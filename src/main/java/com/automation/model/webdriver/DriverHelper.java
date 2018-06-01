package com.automation.model.webdriver;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.utils.StringUtils;
import com.automation.model.utils.objects.HtmlElement;
import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.utils.ArrayUtils;
import com.automation.model.utils.ImageUtils;
import com.automation.model.utils.InitUtils;
import com.automation.model.utils.OSUtils;
import com.automation.model.webdriver.configuration.ChromeConfiguration;
import com.automation.model.webdriver.configuration.EdgeConfiguration;
import com.automation.model.webdriver.configuration.FirefoxConfiguration;
import com.automation.model.webdriver.configuration.IEConfiguration;
import com.automation.model.webdriver.configuration.MobileConfiguration;
import com.automation.model.webdriver.configuration.SafariConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * The DriverHelper class implements methods which use Selenium libraries to
 * manage the creation of a webdriver and to interact with different kinds of
 * browser drivers, providing a wide set of configurations.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class DriverHelper {

	private WebDriver driver;
	private boolean waitForAngular = true;
	private boolean waitForJQuery = false;
	private boolean showConsoleLog = false;
	private int smallWindowLimit = 1025;
	private int defaultWindowHeigth = 1366;
	private int defaultWindowWidth= 768;
	private int shortWait = 3;
	private String id = "0";
	private String ip = "localhost";
	private String port = "4444";
	private String deviceName;
	private String devicePlatform;
	private String appPackage;
	private String launchActivity;
	private String iOsUdid;
	private String emulationBrowser = BrowserType.CHROME;
	private boolean desktop = true;
	private boolean headless = false;
	private boolean forceCache = true;
	private boolean remoteMode = false;
	private boolean downloadDrivers = false;
	private boolean smallWindowMode = false;
	private boolean mobileEmulation = false;
	private String reportPath = "";
	private String browserType;
	private String driverType;
	private String reportingLevel = "normal";
	private int implicitTimeout = 50;
	private int scriptTimeout = 50;
	private int pageLoadTimeout = 50;
	private DesiredCapabilities capabilities;
	private ArrayList<String> consoleLogs = new ArrayList<String>();
	final static Logger logger = LoggerFactory.getLogger(DriverHelper.class);

	public DriverHelper(DesiredCapabilities cap) {
		capabilities = cap;
		browserType = cap.getBrowserName();

		if(capabilities.getCapability("platformName") != null &&
			(capabilities.getCapability("platformName").toString().equals("ANDROID") || capabilities.getCapability("platformName").toString().equals("iOS"))) {
			desktop = false;
		}

		if(!desktop && (browserType == null || browserType.isEmpty())) {
			driverType = AutomationConstants.MOBILE_APP;
		} else {
			driverType = AutomationConstants.WEB;
		}
	}

	public DriverHelper(String browser) {
		headless = browser.contains("_headless");
		
		if(ArrayUtils.contains(InitUtils.getMobileBrowsers(), browser.replace("_headless", "")) 
			|| ArrayUtils.contains(InitUtils.getDesktopBrowsers(), browser.replace("_headless", ""))) {
			browserType = browser.replace("_headless", "");
			driverType = AutomationConstants.WEB;
		} else {
			deviceName = browser;
			driverType = AutomationConstants.MOBILE_APP;
			desktop = false;
		}
	}
	
	private String getDebugLine() {
		int line = Thread.currentThread().getStackTrace()[3].getLineNumber();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());
		String className = Thread.currentThread().getStackTrace()[3].getClassName();
		className = className.contains(".") ? className.substring(className.lastIndexOf(".") + 1) : className;
		
		return timeStamp + " - " + className + ":" + line;
	}
	
	private void debugBegin() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		System.out.println(getDebugLine() + " - [BEGIN] (" + id + ") - " + methodName);
	}
	
	private void debugEnd() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		System.out.println(getDebugLine() + " - [END] (" + id + ") - " + methodName);
	}
	
	private void debugInfo(String message) {
		System.out.println(getDebugLine() + " - [INFO] (" + id + ") - " + message);
	}
	
	private void debugError(String message) {
		System.out.println(getDebugLine() + " - [ERROR] (" + id + ") - " + message);
	}

	public void setHub(String ip, String port) {
		if(ip != null) {
			this.ip = ip;
		}
		
		if(port != null) {
			this.port = port;
		}
	}

	public void setRemoteMode(boolean value) {
		remoteMode = value;
	}

	public void setPlatform(boolean value) {
		desktop = value;
	}

	public void setForceCache(boolean value) {
		forceCache = value;
	}

	public void setDownloadDrivers(boolean value) {
		downloadDrivers = value;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	
	public void setDevicePlatform(String platform) {
		this.devicePlatform = platform;
	}
	
	public void setAppVariables(DataObject configData) {
		if(devicePlatform.toLowerCase().equals(Platform.ANDROID.toString().toLowerCase())) {
			this.appPackage = configData.getValue("app_package");
			this.launchActivity = configData.getValue("launch_activity");
		} else {
			this.appPackage = configData.getValue("ios_package");
			this.iOsUdid = configData.getValue(deviceName + "_udid");
		}
	}

	public void downloadDriver(String browserType) {
		debugBegin();
		
		switch(browserType) {
			case BrowserType.FIREFOX:
				debugInfo("Checking firefox driver");
				FirefoxConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.CHROME:
				debugInfo("Checking chrome driver");
				ChromeConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.IE:
				debugInfo("Checking Internet Explorer driver");
				IEConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.EDGE:
				debugInfo("Checking edge driver");
				break;
			case BrowserType.SAFARI:
				debugInfo("Checking safari driver");
				break;
			default:
				if(emulationBrowser.equals(BrowserType.FIREFOX)) {
					debugInfo("Checking firefox driver for " + browserType);
					FirefoxConfiguration.downloadDriver(forceCache);
				} else {
					debugInfo("Checking chrome driver for " + browserType);
					ChromeConfiguration.downloadDriver(forceCache);
				}
				
				break;
		}
		
		debugEnd();
	}

	private void setPropertyDriverPath(String operativeS, String browserType) {
		if(operativeS.startsWith("Windows")) {
			String[] driverFolders;
			String mavenWindowsPath = System.getenv("USERPROFILE") + "/.m2/repository/webdriver/";
			
			switch(browserType) {
				case BrowserType.FIREFOX:
					driverFolders = new File(mavenWindowsPath + "geckodriver/win64").list();
					System.setProperty("webdriver.gecko.driver", mavenWindowsPath + "geckodriver/win64/" + driverFolders[driverFolders.length - 1] + "/geckodriver.exe");
					break;
				case BrowserType.CHROME:
					driverFolders = new File(mavenWindowsPath + "chromedriver/win32").list();
					System.setProperty("webdriver.chrome.driver", mavenWindowsPath + "chromedriver/win32/" + driverFolders[driverFolders.length - 1] + "/chromedriver.exe");
					break;
			}
		} else {
			String[] driverFolders;
			String mavenLinuxPath = "/var/lib/jenkins/.m2/repository/webdriver/";
			
			switch(browserType) {
				case BrowserType.FIREFOX:
					driverFolders = new File(mavenLinuxPath + "geckodriver/linux64").list();
					System.setProperty("webdriver.gecko.driver", mavenLinuxPath + "geckodriver/linux64/" + driverFolders[driverFolders.length - 1] + "/geckodriver");
					break;
				case BrowserType.CHROME:
					driverFolders = new File(mavenLinuxPath + "chromedriver/linux64").list();
					System.setProperty("webdriver.chrome.driver", mavenLinuxPath + "chromedriver/linux64/" + driverFolders[driverFolders.length - 1] + "/chromedriver");
					break;
			}
		}
	}

	public void initializeDriver() {
		URL hubUrl = null;

		try {
			hubUrl = new URL("http://" + ip + ":" + port + "/wd/hub");
		} catch(MalformedURLException e) {
			debugError("Error with url");
			e.printStackTrace();
		}

		if(desktop) {
			if(downloadDrivers) {
				downloadDriver(browserType);
			}
			
			if(remoteMode) {
				debugInfo("Initializing remote driver");				
				switch(browserType) {
					case BrowserType.FIREFOX:
						driver = new RemoteWebDriver(hubUrl, FirefoxConfiguration.createFirefoxOptions(headless));
						break;
					case BrowserType.CHROME:
						driver = new RemoteWebDriver(hubUrl, ChromeConfiguration.createChromeOptions(headless));
						break;
					case BrowserType.IE:
						driver = new RemoteWebDriver(hubUrl, IEConfiguration.createIEOptions());
						break;
					case BrowserType.EDGE:
						driver = new RemoteWebDriver(hubUrl, EdgeConfiguration.createEdgeOptions());
						break;
					case BrowserType.SAFARI:
						driver = new RemoteWebDriver(hubUrl, SafariConfiguration.createSafariOptions());
						break;
					default:
						if(emulationBrowser.equals(BrowserType.FIREFOX)) {
							driver = new RemoteWebDriver(hubUrl, MobileConfiguration.createFirefoxMobileOptions(browserType));
							Dimension dimension = new Dimension(320, 568);
							driver.manage().window().setSize(dimension);
						} else {
							driver = new RemoteWebDriver(hubUrl, MobileConfiguration.createChromeMobileOptions(browserType));
						}
						
						mobileEmulation = true;
						break;
				}
			} else {
				setPropertyDriverPath(OSUtils.getOsName(), browserType);
				
				switch(browserType) {
					case BrowserType.FIREFOX:
						debugInfo("Initializing firefox driver");
						driver = new FirefoxDriver(FirefoxConfiguration.createFirefoxOptions(headless));
						break;
					case BrowserType.CHROME:
						debugInfo("Initializing chrome driver");
						driver = new ChromeDriver(ChromeConfiguration.createChromeOptions(headless));
						break;
					case BrowserType.IE:
						debugInfo("Initializing Internet Explorer driver");
						driver = new InternetExplorerDriver(IEConfiguration.createIEOptions());
						break;
					case BrowserType.EDGE:
						debugInfo("Initializing edge driver");
						driver = new EdgeDriver(EdgeConfiguration.createEdgeOptions());
						break;
					case BrowserType.SAFARI:
						debugInfo("Initializing safari driver");
						driver = new SafariDriver(SafariConfiguration.createSafariOptions());
						break;
					default:
						if(emulationBrowser.equals(BrowserType.FIREFOX)) {
							debugInfo("Initializing chrome driver for " + browserType);
							driver = new FirefoxDriver(MobileConfiguration.createFirefoxMobileOptions(browserType));
						} else {
							debugInfo("Initializing firefox driver for " + browserType);
							driver = new ChromeDriver(MobileConfiguration.createChromeMobileOptions(browserType));
						}
						mobileEmulation = true;
						break;
				}
			}
		} else {
			capabilities = new DesiredCapabilities();
			
			if(devicePlatform.toUpperCase().equals(Platform.ANDROID.toString())) {
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability("appPackage", appPackage);
				capabilities.setCapability("appActivity", launchActivity);
				
				driver = new AndroidDriver<WebElement>(hubUrl, capabilities);
			} else {
				capabilities.setCapability("automationName", "XCUITest"); // XCUITest
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("udid", iOsUdid);
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("app", appPackage);
				
				debugInfo("Initializing iOs driver");
				driver = new IOSDriver<WebElement>(hubUrl, capabilities);
			}
		}

		setTimeouts();
		
		if(desktop && !mobileEmulation) resizeWindow(defaultWindowHeigth, defaultWindowWidth);

		if(desktop && Integer.parseInt(((JavascriptExecutor) driver).executeAsyncScript("arguments[0](window.outerWidth);").toString()) < smallWindowLimit) {
			smallWindowMode = true;
		}

		debugInfo("Driver initialized");
	}

	public String getSessionId() {
		SessionId sessionId = null;

		if(desktop) {
			if(remoteMode) {
				sessionId = ((RemoteWebDriver) driver).getSessionId();
			} else {
				switch(browserType) {
					case BrowserType.FIREFOX:
						sessionId = ((FirefoxDriver) driver).getSessionId();
						break;
					case BrowserType.CHROME:
						sessionId = ((ChromeDriver) driver).getSessionId();
						break;
					case BrowserType.IE:
						sessionId = ((InternetExplorerDriver) driver).getSessionId();
						break;
					case BrowserType.EDGE:
						sessionId = ((EdgeDriver) driver).getSessionId();
						break;
					case BrowserType.SAFARI:
						sessionId = ((SafariDriver) driver).getSessionId();
						break;
					default:
						if(emulationBrowser.equals(BrowserType.FIREFOX)) {
							sessionId = ((FirefoxDriver) driver).getSessionId();
						} else {
							sessionId = ((ChromeDriver) driver).getSessionId();
						}
						
						break;
				}
			}
		} else {
			if(capabilities.getCapability("platformName").toString().toLowerCase().contains("android")) {
				sessionId = ((AndroidDriver<WebElement>) driver).getSessionId();
			} else {
				sessionId = ((IOSDriver<WebElement>) driver).getSessionId();
			}
		}

		return sessionId == null ? null : sessionId.toString();
	}

	// region WebDriver
	public String getId() {
		return id;
	}

	public void setId(String value) {
		id = value;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getDriverType() {
		return driverType;
	}

	public boolean isReducedViewMode() {
		return smallWindowMode;
	}

	public boolean isNormalViewMode() {
		return !smallWindowMode;
	}

	public void setReportingLevel(String value) {
		reportingLevel = value;
	}

	public void setSmallWindowMode(boolean value) {
		smallWindowMode = value;
	}

	public void setSmallWindowLimit(int value) {
		smallWindowLimit = value;
	}

	public void setWindowSize(int heigth, int width) {
		defaultWindowHeigth = heigth;
		defaultWindowWidth = width;
	}
	
	public void setEmulationBrowser(String browser) {
		if(browser != null) emulationBrowser = browser;
	}

	public void quit() {
		try {
			if(driver != null) {
				driver.quit();
			}
		} catch(Exception e) {}
	}

	public void maximizeWindow() {
		try {
			if(desktop && driver != null) {
				driver.manage().window().maximize();
			} else if (capabilities.getCapability("platformName") != null && capabilities.getCapability("platformName").equals("iOS")
				   && driver != null) {
				java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Point position = new Point(0, 0);
				driver.manage().window().setPosition(position);
				Dimension maximizedScreenSize =
						new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
				driver.manage().window().setSize(maximizedScreenSize);
			}
		} catch(Exception e) {}
	}

	public void resizeWindow(int width, int heigth) {
		try {
			if(desktop && driver != null) {				
				driver.manage().window().setPosition(new Point(0, 0));
				driver.manage().window().setSize(new Dimension(width, heigth));
			}
		} catch(Exception e) {}
	}
	// endregion

	// region Timeouts
	public void setImplicitWait(int timeOut) {
		implicitTimeout = timeOut;

		if(driver != null) {
			try {
				driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			} catch(WebDriverException e) {}
		}
	}

	public void setScriptWait(int timeOut) {
		scriptTimeout = timeOut;

		try {
			if(driver != null) driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {} ;
	}

	public void setPageLoadWait(int timeOut) {
		pageLoadTimeout = timeOut;

		try {
			if(driver != null) driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {} ;
	}

	public String getCurrentPage() {
		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			String[] activityArray = StringUtils.stringToArray(((AndroidDriver<WebElement>) driver).currentActivity(), ".");

			return activityArray[activityArray.length - 1];
		} else return driver.getCurrentUrl();
	}

	public List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	public List<Integer> getClickableElementsPosition(List<WebElement> elements) {
		List<Integer> positionList = new ArrayList<Integer>();

		for(int i = 0; i < elements.size(); i++) {
			if(!(elements.get(i).getSize().height == 0 && elements.get(i).getSize().width == 0) && isClickable(elements.get(i))) {
				positionList.add(i);
			}
		}

		return positionList;
	}

	public WebElement getElement(By by) {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = ((AppiumDriver<WebElement>) driver);
			WebElement el = null;

			setTimeouts(shortWait);

			try {
				el = appDriver.findElement(by);
			} catch(Exception e) {}

			if(el == null) {
				scrollToTop();

				try {
					el = appDriver.findElement(by);
				} catch(Exception e) {}

				for(int i = 0; i < 10 && el == null; i++) {
					Dimension windowSize = appDriver.manage().window().getSize();
					
					new TouchAction(appDriver).press((int) (windowSize.width / 2), (int) (windowSize.height * 0.5))
						.waitAction(Duration.ofMillis(800))
						.moveTo((int) (windowSize.width / 2), (int) (windowSize.height * 0.25))
						.release().perform();

					try {
						el = appDriver.findElement(by);
					} catch(Exception e) {}
				}
			}

			if(el == null) appDriver.findElement(by);

			setTimeouts();

			return el;
		} else {
			waitForElementToBeClickable(by);

			return driver.findElement(by);
		}
	}

	private List<WebElement> getAllElements() {
		if(driverType.equals("MOBILEAPP")) return driver.findElements(By.xpath("//*"));
		else return driver.findElements(By.cssSelector("*"));
	}

	public void removeElement(By by) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].remove()", driver.findElement(by));
		} catch(Exception e) {
			debugError("Error removing element");
			throw e;
		}
	}

	public String getAttribute(By by, String attribute) {
		return driver.findElement(by).getAttribute(attribute);
	}

	public String getCssValue(By by, String cssValue) {
		return driver.findElement(by).getCssValue(cssValue);
	}

	public void setAttribute(By by, String attribute, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", driver.findElement(by), attribute, value);
	}
	
	public void addStyleAttribute(By by, String key, String value) {
		String attribute = getAttribute(by, "style");
		
		if(attribute != null && !attribute.isEmpty() && attribute.contains(key)) {
			String auxStyle = attribute.substring(attribute.indexOf(key));
			
			boolean inValue = false;
			for(int i = auxStyle.indexOf(":") + 1; i < auxStyle.length(); i++) {
				if(!inValue && auxStyle.charAt(i) != ' ') {
					inValue = true;
				} else if(inValue && (i + 1 == auxStyle.length() || auxStyle.charAt(i) == ';' || auxStyle.charAt(i) == ' ')) {
					setAttribute(by, "style", attribute.replace(auxStyle.substring(0, i), key + ": " + value));
					break;
				}
			}
		} else if(attribute != null && !attribute.isEmpty() && !attribute.contains(key)) {
			setAttribute(by, "style", getAttribute(by, key) + " " + key + ": " + value);
		} else {
			setAttribute(by, "style", key + ": " + value + ";");
		}
	}

	public void removeAttribute(By by, String attribute) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute(arguments[1]);", driver.findElement(by), attribute);
	}

	public String getSource() {
		return driver.getPageSource();
	}

	public void printAllElements() {
		List<WebElement> list = getAllElements();

		for(int i = 0; i < list.size(); i++) {
			String className = list.get(i).getAttribute("class").equals("") ? "" : "class='" + list.get(i).getAttribute("class") + "'";
			String id = list.get(i).getAttribute("id").equals("") ? "" : "id='" + list.get(i).getAttribute("id") + "'";
			System.out.println(list.get(i).getTagName() + " " + className + " " + id);
		}
	}
	
	public void setWaitForAngular(boolean value) {
		this.waitForAngular = value;
	}
	
	public void setWaitForJQuery(boolean value) {
		this.waitForJQuery = value;
	}
	
	public void setShowConsoleLog(boolean value) {
		this.showConsoleLog = value;
	}

	private void setTimeouts() {
		setImplicitWait(implicitTimeout);
		setScriptWait(scriptTimeout);
		setPageLoadWait(pageLoadTimeout);
	}

	private void setTimeouts(int timeOut) {
		try {
			if(driver != null) driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {
			debugError("Exception  set implicit timeout" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
		}

		try {
			if(driver != null) driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {}

		try {
			if(driver != null) driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {}
	}

	public void go(String url) {
		if(driver == null || getSessionId() == null) {
			initializeDriver();
		}

		driver.get(url);
		waitForLoadToComplete();
	}
	// endregion

	public WebElement selectClickableElement(By by) {
		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			WebElement el = null;
			List<WebElement> els = driver.findElements(by);

			if(els.size() == 0) {
				el = driver.findElement(by);
			} else if(els.size() == 1) {
				el = els.get(0);
			} else {
				for(int i = 0; i < els.size(); i++) {
					el = els.get(i);
					if(isClickable(els.get(i))) {
						break;
					}
				}
			}

			return el;
		} else {
			return getElement(by);
		}
	}

	// region Clicks
	public void click(By by) {
		click(waitForElementToBeClickable(by));
	}

	public void click(WebElement element) {
		logger.trace("[BEGIN] - click");
		waitForElementToBeClickable(element).click();

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.trace("[END] - click");
	}
	
	public void dispatchEvent(By by, String event) {
		dispatchEvent(waitForElementToBeClickable(by), event);
	}

	public void dispatchEvent(WebElement element, String event) {
		logger.trace("[BEGIN] - dispatchEvent: " + event);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('" + event + "', {bubbles:true}));", element);

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.trace("[END] - dispatchEvent");
	}
	
	public void triggerAngularEvent(By by, String event) {
		triggerAngularEvent(waitForElementToBeClickable(by), event);
	}

	public void triggerAngularEvent(WebElement element, String event) {
		logger.trace("[BEGIN] - dispatchEvent: " + event);
		
		((JavascriptExecutor) driver).executeScript("angular.element(arguments[0]).triggerHandler('" + event + "');", element);

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.trace("[END] - dispatchEvent");
	}

	public void clickInFrame(By by, By frame) {
		switchToFrame(frame);
		click(by);
		exitFrame();
	}
	
	public void clickRelativePosition(By by, double xPer, double yPer) {
		clickRelativePosition(driver.findElement(by), xPer, yPer);
	}

	public void clickRelativePosition(WebElement el, double xPer, double yPer) {
		logger.trace("[BEGIN] - clickRelativePosition");
		waitForElementToBeClickable(el);

		try {
			((JavascriptExecutor) driver).executeScript("document.elementFromPoint("
				+ "arguments[0].getBoundingClientRect().x + (arguments[0].getBoundingClientRect().width * " + xPer + "), "
				+ "arguments[0].getBoundingClientRect().y + (arguments[0].getBoundingClientRect().height * " + yPer + ")).click();", el);
		} catch(WebDriverException e) {
			try {
				new Actions(driver).moveToElement(el).click().perform();
			} catch(Exception e1) {
				System.out.println("Element not found");
				e.printStackTrace();

				throw e;
			}

		}

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.trace("[END] - clickRelativePosition");
	}

	public void clickOver(By by) {
		clickOver(waitForElementToBeClickable(by));
	}

	public void clickOver(WebElement el) {
		logger.trace("[BEGIN] - clickOver");
		waitForElementToBeClickable(el);

		try {
			((JavascriptExecutor) driver).executeScript("document.elementFromPoint("
				+ "arguments[0].getBoundingClientRect().x, "
				+ "arguments[0].getBoundingClientRect().y).click();", el);
		} catch(WebDriverException e) {
			try {
				new Actions(driver).moveToElement(el).click().perform();
			} catch(Exception e1) {
				debugInfo("Element not found");
				e.printStackTrace();

				throw e;
			}
		}

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.trace("[END] - clickOver");
	}

	public void doubleClick(By by) {
		doubleClick(driver.findElement(by));
	}

	public void doubleClick(WebElement element) {
		logger.trace("[BEGIN] - doubleClick");

		waitForElementToBeClickable(element);
		new Actions(driver).moveToElement(element).doubleClick().perform();

		takeScreenshotWithCondition();
		logger.trace("[END] - doubleClick");
	}

	public void doubleClickInFrame(By by, By frame) {
		switchToFrame(frame);
		doubleClick(by);
		exitFrame();
	}
	
	public void swipeRight(By by) {
		WebElement element = waitForElementToBeClickable(by);
		Dimension size = element.getSize();
		
		new Actions(driver).moveToElement(element).moveByOffset((int) (-size.width * 0.4), 0).clickAndHold().pause(2500)
			.moveByOffset((int) (size.width * 0.8), 0).pause(1000).release().perform();
		
		waitForPageToLoad();
	}
	
	public void swipeLeft(By by) {
		WebElement element = waitForElementToBeClickable(by);
		Dimension size = element.getSize();
		
		new Actions(driver).moveToElement(element).moveByOffset((int) (size.width * 0.4), 0).clickAndHold().pause(2500)
			.moveByOffset((int) (-size.width * 0.8), 0).pause(1000).release().perform();
		
		waitForPageToLoad();
	}
	
	public void swipeDown(By by) {
		WebElement element = waitForElementToBeClickable(by);
		Dimension size = element.getSize();

		new Actions(driver).moveToElement(element).moveByOffset(0, (int) (-size.height * 0.4)).clickAndHold().pause(2500)
			.moveByOffset(0, (int) (size.height * 0.8)).pause(1000).release().perform();
		
		waitForPageToLoad();
	}
	
	public void swipeUp(By by) {
		WebElement element = waitForElementToBeClickable(by);
		Dimension size = element.getSize();

		new Actions(driver).moveToElement(element).moveByOffset(0, (int) (size.height * 0.4)).clickAndHold().pause(2500)
			.moveByOffset(0, (int) (-size.height * 0.8)).pause(1000).release().perform();
		
		waitForPageToLoad();
	}
	// endregion

	// region Text
	public String getText(By by) {
		waitForLoadToComplete();

		String text = getText(driver.findElement(by));

		return text;
	}
	
	public String getTextInFrame(By by, By frame) {
		String result = "";
		
		switchToFrame(frame);
		result = getText(by);
		exitFrame();
		
		return result;
	}

	public String getText(WebElement webElement) {
		logger.trace("[BEGIN] - getText");
		waitForLoadToComplete();

		String text = webElement.getText();
		
		if(text.isEmpty()) {
			Object javascriptRepsonse = ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", webElement);
			
			if(javascriptRepsonse != null) {
				text = javascriptRepsonse.toString();
			}
		}

		logger.trace("[END] - getText");
		return text;
	}

	public void clickElementFromDropDownByText(By dropDown, String value) {
		logger.trace("[BEGIN] - clickElementFromDropDownByText");
		waitForElementToBeClickable(dropDown);
		Select select = new Select(driver.findElement(dropDown));
		select.selectByVisibleText(value);
		waitForLoadToComplete();
		logger.trace("[END] - clickElementFromDropDownByText");
	}
	
	public void clickElementFromDropDownByTextInFrame(By dropDown, By frame, String value) {
		switchToFrame(frame);
		clickElementFromDropDownByText(dropDown, value);
		exitFrame();
	}

	public void clickElementFromDropDownByAttribute(By elementToClick, By elementList, String attribute, String value) {
		logger.trace("[BEGIN] - clickElementFromDropDownByAttribute");
		waitForElementToBeClickable(elementToClick).click();
		
		clickElementFromListByAttribute(elementList, attribute, value);
		
		waitForLoadToComplete();
		logger.trace("[END] - clickElementFromDropDownByAttribute");
	}

	public void clickElementFromDropDownByAttribute(By containingElement, String attribute, String value) {
		clickElementFromDropDownByAttribute(containingElement, containingElement, attribute, value);
	}

	public void clickElementFromListByAttribute(By elementList, String attribute, String value) {
		logger.trace("[BEGIN] - clickElementFromListByAttribute");
		WebElement el = getElementFromListByAttribute(elementList, attribute, value);
		
		if(el != null) el.click();
		else {
			logger.debug("[INFO] No child elements found on " + elementList);
		}
		
		waitForLoadToComplete();
		logger.trace("[END] - clickElementFromListByAttribute");
	}

	public WebElement getElementFromListByAttribute(By elementList, String attribute, String value) {
		logger.trace("[BEGIN] - getElementFromListByAttribute");
		waitForElementToBeClickable(elementList);
		WebElement webElement = driver.findElement(elementList).findElement(By.cssSelector("[" + attribute + "='" + value + "']"));
		logger.trace("[END] - getElementFromListByAttribute");
		
		return webElement;
	}
	
	public void clickFirstElementFromDropDownInFrame(By elementList, By frame) {
		switchToFrame(frame);
			
		clickElementChildByIndex(elementList, 1);
		
		waitForLoadToComplete();
		exitFrame();
	}

	public void clickElementFromDropDownByIndex(By elementToClick, By elementList, int index) {
		waitForElementToBeClickable(elementToClick).click();
		
		clickElementChildByIndex(elementList, index);
		
		waitForLoadToComplete();
	}

	public void clickElementFromDropDownByIndex(By elementContainer, int index) {
		clickElementFromDropDownByIndex(elementContainer, elementContainer, index);
	}

	public void clickElementChildByIndex(By elementList, int index) {
		logger.trace("[BEGIN] - clickElementChildByIndex");
		WebElement el = getElementChildByIndex(elementList, index);
		
		if(el != null) el.click();
		else {
			debugInfo("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.trace("[END] - clickElementChildByIndex");
	}

	public WebElement getElementChildByIndex(By elementList, int index) {
		logger.trace("[BEGIN] - getElementChildByIndex");
		waitForElementToBeClickable(elementList);
		List<WebElement> elements = driver.findElement(elementList).findElements(By.xpath("*"));
		WebElement webElement = elements.size() > 0 ? index >= 0 ? elements.get(index) : elements.get(elements.size() + index) : null;
		logger.trace("[END] - getElementChildByIndex");
		
		return webElement;
	}

	public void clickElementChildByText(By elementList, String text) {
		logger.trace("[BEGIN] - clickElementChildByText");
		WebElement el = getElementChildByText(elementList, text);
		
		if(el != null) el.click();
		else {
			debugInfo("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.trace("[END] - clickElementChildByText");
	}

	public WebElement getElementChildByText(By elementList, String text) {
		logger.trace("[BEGIN] - getElementChildByText");
		waitForElementToBeClickable(elementList);
		List<WebElement> elements = driver.findElement(elementList).findElements(By.xpath("*[contains(text(), '" + text + "')]"));
		WebElement webElement = elements.size() > 0 ? elements.get(0) : null;
		logger.trace("[END] - getElementChildByText");
		
		return webElement;
	}

	public void clickElementChildByAttribute(By elementList, String attribute, String value) {
		logger.trace("[BEGIN] - clickElementChildByAttribute");
		WebElement el = getElementChildByAttribute(elementList, attribute, value);
		
		if(el != null) el.click();
		else {
			debugInfo("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.trace("[END] - clickElementChildByAttribute");
	}

	public WebElement getElementChildByAttribute(By elementList, String attribute, String value) {
		logger.trace("[BEGIN] - getElementChildByAttribute");
		waitForElementToBeClickable(elementList);
		List<WebElement> elements = driver.findElement(elementList).findElements(By.cssSelector("[" + attribute + "='" + value + "']"));
		WebElement webElement = elements.size() > 0 ? elements.get(0) : null;
		logger.trace("[END] - getElementChildByAttribute");
		
		return webElement;
	}

	public void clickElementFromCollectionByIndex(By elementList, int index) {
		logger.trace("[BEGIN] - clickElementFromCollectionByIndex");
		WebElement el = getElementFromCollectionByIndex(elementList, index);
		
		if(el != null) el.click();
		else {
			debugInfo("No elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.trace("[END] - clickElementFromCollectionByIndex");
	}

	public WebElement getElementFromCollectionByIndex(By elementList, int index) {
		logger.trace("[BEGIN] - getElementFromCollectionByIndex");
		waitForElementToBeClickable(elementList);
		
		List<WebElement> elements = driver.findElements(elementList);
		WebElement webElement = elements.size() > 0 ? index >= 0 ? elements.get(index) : elements.get(elements.size() + index) : null;
		logger.trace("[END] - getElementFromCollectionByIndex");
		
		return webElement;
	}
	
	public void clearText(By by) {
		logger.trace("[BEGIN] - clearText");
		WebElement el = waitForElementToBeClickable(by);

		el.clear();

		waitForLoadToComplete();
		logger.trace("[END] - clearText");
	}

	public void clearTextInFrame(By by, By frame) {
		switchToFrame(frame);
		clearText(by);
		exitFrame();
	}

	public void setText(By by, String text) {
		waitForLoadToComplete();
		clearText(by);
		appendText(by, text);
	}

	public void appendText(By by, String text) {
		logger.trace("[BEGIN] - appendText");
		WebElement el = waitForElementToBeClickable(by);

		if(!driverType.equals(AutomationConstants.MOBILE_APP) && browserType.equals(BrowserType.IE)) {
			String initialText = getAttribute(by, "value");

			setAttribute(by, "value", initialText + text);
			el.sendKeys(Keys.BACK_SPACE + "" + text.charAt(text.length() - 1));
		} else el.sendKeys(text);

		waitForLoadToComplete();

		logger.trace("[END] - appendText");
	}

	public void appendTextInFrame(By by, By frame, String text) {
		switchToFrame(frame);
		appendText(by, text);
		exitFrame();
	}
	
	public void clearAndAppendTextInFrame(By by, By frame, String text) {
		switchToFrame(frame);
		clearText(by);
		appendText(by, text);
		exitFrame();
		logger.trace("[END] - appendText");
	}

	public void setTextIfEmpty(By by, String text) {
		logger.trace("[INFO] - Checking if element text is empty");
		if(getText(by).isEmpty()) {
			setText(by, text);
		}
	}

	public void setTextIfDifferent(By by, String text) {
		logger.trace("[INFO] - Checking if element contains the same text");
		if(!getAttribute(by, "value").equals(text)) {
			clearText(by);
			appendText(by, text);
		} else logger.trace("[END] - Text is the same");
	}

	public void sendKeysFrame(By by, By frame, String value) {
		switchToFrame(frame);

		appendText(by, value);

		exitFrame();
	}
	// endregion

	// region Move
	public void moveToElement(By by) {
		moveToElement(driver.findElement(by));
	}
	
	public void moveToElementInFrame(By by, By frame) {
		switchToFrame(frame);
		moveToElement(driver.findElement(by));
		exitFrame();
	}

	public void moveToElement(WebElement element) {
		logger.trace("[BEGIN] - moveToElement");
		
		if(!driverType.equals(AutomationConstants.MOBILE_APP) && browserType.equals(BrowserType.FIREFOX)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseover', {bubbles:true}));", element);
		}
		else if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			new Actions(driver).moveToElement(element).perform();
		}

		waitForLoadToComplete();
		logger.trace("[END] - moveToElement");
	}

	public void moveOverElement(By by) {
		logger.trace("[BEGIN] - moveOverElement");

		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseover', {bubbles:true}));", driver.findElement(by));

		waitForLoadToComplete();
		logger.trace("[END] - moveOverElement");
	}
	// endregion

	// region Frames
	public void switchToFrame(By by) {
		logger.trace("[INFO] - switchToFrame");
		driver.switchTo().frame(driver.findElement(by));
	}

	public void exitFrame() {
		logger.trace("[INFO] - exitFrame");
		driver.switchTo().defaultContent();
	}
	// endregion

	// region Focus
	public void tabulateElement(By by) {
		logger.trace("[BEGIN] - tabulateElement");
		waitForElementToBeClickable(by);
		driver.findElement(by).sendKeys(Keys.TAB);
		logger.trace("[END] - tabulateElement");
	}

	public void tabulateElementInFrame(By by, By frame) {
		switchToFrame(frame);
		tabulateElement(by);
		exitFrame();
	}
	// endregion

	// region Scrolls
	public void scrollPageDown() {
		logger.trace("[BEGIN] - scrollPageDown");
		waitForLoadToComplete();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, window.pageYOffset + (window.innerHeight * 0.8));");
		logger.trace("[END] - scrollPageDown");
	}

	public void scrollToTop() {
		logger.trace("[BEGIN] - scrollToTop");
		waitForLoadToComplete();

		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;

			for(int i = 0; i < 5; i++) {
				Dimension windowSize = appDriver.manage().window().getSize();
				
				new TouchAction(appDriver).press((int) (windowSize.width / 2), (int) (windowSize.height * 0.1))
					.waitAction(Duration.ofMillis(100))
					.moveTo((int) (windowSize.width / 2), (int) (windowSize.height * 0.8)).release().perform();
			}
		} else {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, 0);");
		}
		
		logger.trace("[END] - scrollToTop");
	
	}

	public void scrollToBottom() {
		logger.trace("[BEGIN] - scrollToBottom");
		waitForLoadToComplete();

		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;

			for(int i = 0; i < 5; i++) {
				Dimension windowSize = appDriver.manage().window().getSize();
				
				new TouchAction(appDriver).press((int) (windowSize.width / 2), (int) (windowSize.height * 0.8))
					.waitAction(Duration.ofMillis(100))
					.moveTo((int) (windowSize.width / 2), (int) (windowSize.height * 1)).release().perform();
			}
		} else {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, document.body.scrollHeight);");
		}

		logger.trace("[END] - scrollToBottom");
	}

	public void scrollNthPageDown(int numberOfPages) {
		for(int i = 0; i < numberOfPages; i++) {
			scrollPageDown();
		}
	}

	public void scrollToElement(WebElement el) {
		scrollToElement(el, false);
	}

	public void scrollToElement(WebElement el, boolean complete) {
		try {
			if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + complete + ");", el);
			} else {
				new Actions(driver).moveToElement(el).perform();
			}
		} catch(StaleElementReferenceException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			logger.trace("Exception in function scrollToWebElement WebElement", e);
		}
	}

	public void scrollToElement(By by) {
		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			scrollToElement(driver.findElement(by));
		}
		else {
			getElement(by);
		}
	}
	// endregion

	// region Waits
	public final void waitWithDriver(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeClickableAndClick(By by) {
		logger.trace("[BEGIN] - waitForElementToBeClickableAndClick");
		waitForElementToBeClickable(by);

		click(by);

		waitForLoadToComplete();

		logger.trace("[END] - waitForElementToBeClickableAndClick");
	}

	public void waitForLoadToComplete() {
		if(desktop && !driverType.equals(AutomationConstants.MOBILE_APP)) {
			logger.trace("[BEGIN] - waitForLoadToComplete");
			waitForPageToLoad();
			
			if(waitForAngular) {
				waitForAngular();
			}
			
			if(waitForJQuery) {
				waitForJQuery();
			}

			
			if(showConsoleLog) {
				addToLog();
			}
			
			logger.trace("[END] - waitForLoadToComplete");
		}
	}

	public void waitForPageToLoad() {
		logger.trace("[BEGIN] - waitForPageToLoad");
		
		new WebDriverWait(driver, implicitTimeout)
			.pollingEvery(Duration.ofMillis(500))
			.until((ExpectedCondition<Boolean>) wd -> "complete".equals(((JavascriptExecutor) wd).executeScript(
				"return !document ? false : !document.readyState ? false : document.readyState;")));
		
		logger.trace("[END] - waitForPageToLoad");
	}

	public void waitForJQuery() {
		logger.trace("[BEGIN] - waitForJQuery");
		try {
			if(!driverType.equals(AutomationConstants.MOBILE_APP)) {				
				new WebDriverWait(driver, implicitTimeout)
					.pollingEvery(Duration.ofMillis(500))
					.until((ExpectedCondition<Boolean>) wd -> (((JavascriptExecutor) wd)
						.executeScript("return jQuery.active == 0  && jQuery.isReady;") + "").toString().equals("true"));
			}
		} catch(WebDriverException e) {
			if(e.getMessage() == null || (e.getMessage() != null && !e.getMessage().contains("jQuery is not defined"))) {
				System.out.println("[ERROR] (" + id + ") - Exception in wait for jQuery" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
			}
		}
		
		logger.trace("[END] - waitForJQuery");
	}

	public void waitForAngular() {
		logger.trace("[BEGIN] - waitForAngular");
		try {
			if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
				new WebDriverWait(driver, implicitTimeout)
					.pollingEvery(Duration.ofMillis(500))
					.until((ExpectedCondition<Boolean>) wd -> (((JavascriptExecutor) wd).executeScript(
						"return !window.angular || (!!window.angular && !!angular.element(document).injector()"
						+ " && angular.element(document).injector().get('$http').pendingRequests.length === 0);") + "").toString().equals("true"));
			}
		} catch(WebDriverException e) {
			debugError("Exception in wait for angular" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
		}
		
		logger.trace("[END] - waitForAngular");
	}

	public WebElement waitForElementToBeClickable(By waitElement) {
		logger.trace("[BEGIN] - waitForElementToBeClickable");
		
		if(desktop && driverType.equals(AutomationConstants.WEB)) {
			WebElement webElement = waitForElementToBePresent(waitElement);
			
			Dimension windowSize = getWindowSize();
			Dimension windowOffset = getWindowOffset();
			Dimension elementSize = webElement.getSize();
			Point elementLocation = webElement.getLocation();
			
			if(!isClickable(waitElement) || ((elementLocation.x + elementSize.width < windowOffset.width
				|| elementLocation.x > windowSize.width + windowOffset.width)
				&& elementLocation.y + elementSize.height < windowOffset.height
				|| elementLocation.y > windowSize.height + windowOffset.height)) {
				scrollToElement(waitElement);
			}

			boolean isClickable = false;
	
			long checkDuration = shortWait;
	
			for(int i = 0; !isClickable && i < implicitTimeout; i += checkDuration) {
				long initialTime = System.currentTimeMillis();
				isClickable = isClickable(waitElement);
				checkDuration = System.currentTimeMillis() - initialTime;
			}
		} else {
			scrollToElement(waitElement);
		}

		logger.trace("[END] - waitForElementToBeClickable");
		
		return driver.findElement(waitElement);
	}

	public WebElement waitForElementToBeClickable(WebElement waitElement) {
		logger.trace("[BEGIN] - waitForElementToBeClickable");
		waitForLoadToComplete();

		boolean isClickable = false;

		long checkDuration = shortWait;

		for(int i = 0; !isClickable && i < implicitTimeout; i += checkDuration) {
			long initialTime = System.currentTimeMillis();
			isClickable = isClickable(waitElement);
			checkDuration = System.currentTimeMillis() - initialTime;
		}
		logger.trace("[END] - waitForElementToBeClickable");
		
		return waitElement;
	}

	public WebElement waitForElementToBePresent(By waitElement) {
		logger.trace("[BEGIN] - waitForElementToBePresent");
		waitForLoadToComplete();

		@SuppressWarnings("unchecked")
		WebElement el = new WebDriverWait(!driverType.equals(AutomationConstants.WEB) ? ((AndroidDriver<WebElement>) driver) : driver, implicitTimeout)
			.pollingEvery(Duration.ofMillis(500))
			.until(ExpectedConditions.presenceOfElementLocated(waitElement));
		
		logger.trace("[END] - waitForElementToBePresent");
		
		return el;
	}
	
	public WebElement waitForElementToBePresentInFrame(By waitElement, By frame) {
		logger.trace("[BEGIN] - waitForElementToBePresent");
		this.switchToFrame(frame);
		waitForLoadToComplete();
		
		WebElement el = new WebDriverWait(driver, implicitTimeout)
			.pollingEvery(Duration.ofMillis(500))
			.until(ExpectedConditions.presenceOfElementLocated(waitElement));
		this.exitFrame();
		
		logger.trace("[END] - waitForElementToBePresent");
		
		return el;
	}

	public boolean waitForElementNotToBeClickable(By waitElement) {
		logger.trace("[BEGIN] - waitForElementNotToBeClickable");
		waitForLoadToComplete();

		boolean isClickable = isClickable(waitElement);

		for(int i = 0; isClickable && i < implicitTimeout; i += shortWait) {
			isClickable = isClickable(waitElement);
		}
		
		logger.trace("[END] - waitForElementNotToBeClickable");
		
		return isClickable;
	}

	public void waitForElementToBeClickableInFrame(By waitElement, By frame) {
		switchToFrame(frame);
		waitForElementToBeClickable(waitElement);
		exitFrame();
	}

	public boolean isEnabled(By by) {
		return driver.findElement(by).isEnabled();
	}

	public Dimension getWindowSize() {
		Dimension size = new Dimension(0, 0);

		if(desktop) {
			int width = Integer.parseInt(((JavascriptExecutor) driver).executeScript("return window.innerWidth;").toString());
			int height = Integer.parseInt(((JavascriptExecutor) driver).executeScript("return window.innerHeight;").toString());

			size = new Dimension(width, height);
		} else {
			size = new Dimension(driver.manage().window().getSize().width, driver.manage().window().getSize().height);
		}

		return size;
	}

	public Dimension getWindowOffset() {
		Dimension size = new Dimension(0, 0);

		if(desktop) {
			double xOffset = Double.parseDouble(((JavascriptExecutor) driver).executeScript("return window.pageXOffset;").toString());
			double yOffset = Double.parseDouble(((JavascriptExecutor) driver).executeScript("return window.pageYOffset;").toString());
			size = new Dimension((int) xOffset, (int) yOffset);
		}

		return size;
	}

	public ArrayList<String> getConsoleLogs() {
		return consoleLogs;
	}

	public ArrayList<String> getCurrentLogs() {
		ArrayList<String> list = new ArrayList<String>();
		
		driver.manage().logs().get("browser").forEach(p -> {			
			list.add(p.getLevel().getName() + ": " + p.getMessage());
		});
		
		return list;
	}

	public void addToLog() {
		ArrayList<String> list = getCurrentLogs();
		
		if(consoleLogs.size() > 0 && list.size() > 0) {
			int pos = 0;
			boolean isEqual = false;
			int maxSize = consoleLogs.size() < list.size() ? consoleLogs.size() : list.size();
			
			for(int i = 0; i < list.size() && i < consoleLogs.size(); i++) {
				int currentMaxSize = maxSize - i;
				
				for(int j = 0; j < currentMaxSize; j++) {
					if(!list.get(j).equals(consoleLogs.get(consoleLogs.size() - currentMaxSize + j))) {
						break;
					}
					
					if(j + 1 == currentMaxSize) {
						isEqual = true;
						pos = j;
					}
				}
				
				if(isEqual) {
					break;
				}
			}
			
			for(int i = pos; i < maxSize; i++) {
				consoleLogs.add(list.get(i));
				System.out.println(list.get(i));
			}
		} else {
			for(String log : list) {
				consoleLogs.add(log);
				System.out.println(log);
			}
		}
		
	}
	
	public boolean isSelected(By webElement) {
		return driver.findElement(webElement).isSelected();
	}

	public boolean isClickable(By by) {
		boolean result = false;
		
		waitForLoadToComplete();

		try {
			setTimeouts(shortWait);

			WebElement el = driver.findElement(by);

			setTimeouts();

			result = isClickable(el);
		} catch(NoSuchElementException e) {} catch(TimeoutException e) {}

		setTimeouts();
		return result;
	}

	public boolean isClickable(WebElement webElement) {
		boolean result = false;
		
		waitForLoadToComplete();

		try {
			setTimeouts(shortWait);
			new WebDriverWait(driver, shortWait)
				.pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.elementToBeClickable(webElement));

			result = true;
		} catch(TimeoutException e) {} catch(NullPointerException e) {} catch(NoSuchElementException e) {} 
		catch(StaleElementReferenceException e) {}

		setTimeouts();
		return result;
	}

	public boolean isPresent(By by) {
		boolean result = false;
		
		waitForLoadToComplete();

		try {
			setTimeouts(shortWait);
			new WebDriverWait(driver, shortWait)
				.pollingEvery(Duration.ofMillis(500))
				.until(ExpectedConditions.presenceOfElementLocated(by));

			result = true;
		} catch(TimeoutException e) {} catch(NullPointerException e) {} catch(NoSuchElementException e) {}
		catch(StaleElementReferenceException e) {} catch(ElementNotVisibleException e) {}

		setTimeouts();
		return result;
	}

	public boolean isPresentInFrame(By by, By frame) {
		boolean check = false;

		switchToFrame(frame);
		check = isPresent(by);
		exitFrame();

		return check;
	}

	public boolean isPresentAndClick(By by) {
		boolean value = false;

		logger.trace("[BEGIN] - webElementisPresentAndClick");
		value = isPresent(by);
		if(value) click(by);
		logger.trace("[END] - webElementisPresentAndClick");

		return value;
	}

	public boolean isPresentAndClickInFrame(By by, By frame) {
		boolean value = false;

		switchToFrame(frame);
		value = isPresentAndClick(by);
		exitFrame();

		return value;
	}

	public boolean isClickableAndClick(By by) {
		boolean value = false;

		logger.trace("[BEGIN] - webElementisPresentAndClick");
		value = isClickable(by);
		if(value) click(by);
		logger.trace("[END] - webElementisPresentAndClick");

		return value;
	}
	// endregion

	// region Window Handles
	public void switchToWindow(int nTab) {
		int currentTab = 0;

		for(String winHandle : driver.getWindowHandles()) {
			if(currentTab++ == nTab) {
				driver.switchTo().window(winHandle);
				break;
			}
		}
	}

	public void switchToNextWindow() {
		boolean next = false;
		String nextWindow = null;
		String mainWindow = getMainWindowHandle();

		for(String winHandle : driver.getWindowHandles()) {
			if(nextWindow == null) {
				nextWindow = winHandle;
			}

			if(mainWindow.contentEquals(winHandle)) {
				next = true;
			} else if(next) {
				nextWindow = winHandle;
				break;
			}
		}

		driver.switchTo().window(nextWindow);
	}

	public Set<String> getListOfWindowHandles() {
		logger.trace("[BEGIN] - getListOfWindowHandles");
		Set<String> result = driver.getWindowHandles();
		logger.trace("[END] - getListOfWindowHandles");

		return result;
	}

	public String getMainWindowHandle() {
		logger.trace("[BEGIN] - getMainWindowHandle");
		String result = driver.getWindowHandle();
		logger.trace("[END] - getMainWindowHandle");

		return result;
	}

	public void moveToSecondWindow(String mainFrameWindowHandle) {
		logger.trace("[BEGIN] - moveToSecondWindow");
		Set<String> handles = driver.getWindowHandles();

		handles.forEach(p -> {
			if(!p.equals(mainFrameWindowHandle)) {
				driver.switchTo().window(p);
				driver.manage().window().maximize();
			}
		});
		
		logger.trace("[END] - moveToSecondWindow");
	}

	public void closeSecondWindow(String mainFrameWindowHandle) {
		logger.trace("[BEGIN] - closeSecondWindow");
		Set<String> handles = driver.getWindowHandles();

		if(handles.size() > 1) {
			handles.forEach(p -> {
				if(!p.equals(mainFrameWindowHandle) && !mainFrameWindowHandle.equals("")) {
					driver.switchTo().window(p);
					driver.close();
					driver.switchTo().window(mainFrameWindowHandle);
				}
			});
		}
		logger.trace("[END] - closeSecondWindow");
	}

	public void moveToWindow(String windowHandle) {
		logger.trace("[BEGIN] - moveToWindow");
		driver.switchTo().window(windowHandle);
		logger.trace("[END] - moveToWindow");
	}
	// endregion

	// region Screenshots
	public byte[] getFullScreenshot() {
		logger.trace("[BEGIN] - getFullScreenshot");
		byte[] screenshot = null;

		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		} catch(Exception e) {
			logger.trace("Ha habido un problema obteniendo la imagen");
		}

		logger.trace("[END] - getFullScreenshot");
		return screenshot;
	}

	public byte[] takeScreenshot(String fileName, String directory) {
		logger.trace("[BEGIN] - takeScreenshot");
		byte[] screenshot = null;
		
		if(!fileName.isEmpty()) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			fileName = (fileName.isEmpty() ? timeStamp : fileName.replaceAll("\\[TIMESTAMP\\]", timeStamp));
		}
		
		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			File file = new File(directory + "/" + fileName + ".jpg");
			new File(directory).mkdirs();
			try(OutputStream stream = new FileOutputStream(file)) {
				stream.write(screenshot);
			}
		} catch(Exception e) {
			logger.trace("Ha habido un problema obteniendo la imagen");
		}

		logger.trace("[END] - takeScreenshot");
		return screenshot;
	}

	public byte[] takeScreenshot(int x, int y, int w, int h) {
		return takeScreenshot("", x, y, w, h);
	}

	public byte[] takeScreenshot(String screenshotName, int x, int y, int w, int h) {
		logger.trace("[BEGIN] - takeScreenshot");
		byte[] screenshot = null;
		String fileName = screenshotName;

		if(!screenshotName.isEmpty()) {
			if(!screenshotName.contains("/") && !screenshotName.contains("\\")) {
				screenshotName = "./" + screenshotName;
			} else {
				File folder = new File(screenshotName.substring(0, screenshotName.lastIndexOf("/")));
				if(!folder.exists()) folder.mkdirs();
			}

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			fileName = (screenshotName.isEmpty() ? timeStamp : screenshotName.replaceAll("\\[TIMESTAMP\\]", timeStamp));
		}

		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			Dimension windowOffset = getWindowOffset();
			Dimension windowSize = getWindowSize();
			x = x - windowOffset.width < 0 ? 0 : x - windowOffset.width;
			y = y - windowOffset.height < 0 ? 0 : y - windowOffset.height;
			w = w + x > windowSize.width ? windowSize.width - x : w + x < 0 ? 0 : w;
			h = h + y > windowSize.height ? windowSize.height - y : h + y < 0 ? 0 : h;

			screenshot = ImageUtils.cropImage(screenshot, x, y, w, h);

			if(!screenshotName.isEmpty()) {
				ImageUtils.writeByteImageToFile(screenshot, fileName);
			}
		} catch(Exception e) {
			logger.trace("There has been an error obtaining the image");
		}

		logger.trace("[END] - takeScreenshot");
		return screenshot;
	}

	public void takeScreenshotWithCondition() {
		if(reportingLevel.equals(AutomationConstants.REPORTING_LVL_VERBOSE)) {
			takeScreenshot("checkScreenshot - [TIMESTAMP]", reportPath + AutomationConstants.DEBUG_IMAGES_FOLDER);
		}
	}

	public byte[] screenshotElement(By webElement) {
		return screenshotElement(driver.findElement(webElement));
	}

	public byte[] screenshotElement(WebElement webElement) {
		return takeScreenshot("", webElement.getLocation().x, webElement
			.getLocation().y, webElement.getSize().width, webElement.getSize().height);
	}

	public byte[] screenshotElement(WebElement webElement, String path) {
		return screenshotElement("[ELEMENT]", webElement, path);
	}

	public byte[] screenshotElement(String name, WebElement webElement, String path) {
		return takeScreenshot(path + "/" + name.replace("[ELEMENT]", webElement.getTagName() + "." + webElement.getAttribute("class")), webElement.getLocation().x, webElement
			.getLocation().y, webElement.getSize().width, webElement.getSize().height);
	}

	public void screenshotElements(String[] elements, String activity, String path) {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			path = path.endsWith("/") ? path : path + "/";

			for(String el : elements) {
				String[] bounds = StringUtils.stringToArray(StringUtils.stringToArray(el, "bounds=\"[", "]\" ")[0].replaceAll("\\]\\[", ","), ",");

				String locator = el.contains("resource-id") ? StringUtils.stringToArray(el, "resource-id=\"", "\" ")[0] + "[" + StringUtils.stringToArray(el, "instance=\"", "\"")[0] + "]"
					: StringUtils.stringToArray(el, "class=\"", "\" ")[0] + "[" + StringUtils.stringToArray(el, "instance=\"", "\"")[0] + "]";

				locator = locator.replace("android:id/", "");

				takeScreenshot(path + activity + " - " + locator, Integer.parseInt(bounds[0]), Integer.parseInt(bounds[1]), Integer.parseInt(bounds[2])
					- Integer.parseInt(bounds[0]), Integer.parseInt(bounds[3]) - Integer.parseInt(bounds[1]));
				System.out.println("Loc: " + locator);
			}
		}
	}
	// endregion

	// region Alert
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();

		String text = alert.getText();

		exitFrame();

		return text;
	}


	public void scrollKeys(String selection) {
	      System.out.println("Starting the process");
	      By meX = By.xpath("//*[contains(@resource-id, 'month')][@index='0']");
	      waitForElementToBeClickable(meX);
	      MobileElement me = (MobileElement) driver.findElement(meX);

	      TouchAction touchAction = new TouchAction((MobileDriver) driver);
	      touchAction.press(me).waitAction(Duration.ofMillis(1000)).moveTo(0, 50).release();
	      ((PerformsTouchActions) driver).performTouchAction(touchAction);

	    // ((RemoteWebDriver) driver).getMouse()(selection);
	      System.out.println("Ending Process");
	  }
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();

		alert.accept();

		exitFrame();
	}
	// endregion
}