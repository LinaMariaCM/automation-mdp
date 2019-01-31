package com.automation.model.webdriver;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.utils.*;
import com.automation.model.utils.objects.DebugLogger;
import com.automation.model.webdriver.configuration.*;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * The DriverHelper class implements methods which use Selenium libraries to manage the creation of a webdriver and to
 * interact with different kinds of browser drivers, providing a wide set of configurations.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class DriverHelper {

	private WebDriver driver;
	private BrowserMobProxy proxy = new BrowserMobProxyServer();
	private DebugLogger logger;
	private boolean verbose = false;
	private boolean maximize = true;
	private boolean waitForPage = true;
	private boolean waitForAngular = true;
	private boolean waitForJQuery = false;
	private boolean showConsoleLog = false;
	private boolean useProxy = false;
	private int shortWait = 3;
	private int smallWindowLimit = 1025;
	private int defaultWindowHeight = 768;
	private int defaultWindowWidth = 1366;
	private String id = "0";
	private String ip = "localhost";
	private String port = "4444";
	private String proxyPort = "";
	private String deviceName;
	private String devicePlatform;
	private boolean androidEmulator = false;
	private String language = null;
	private String appPackage;
	private String launchActivity;
	private String platformVersion;
	private String udid;
	private String macOsVersion = "10";
	private String macOsBrowserStackUser;
	private String macOsBrowserStackKey;
	private String emulationBrowser = BrowserType.CHROME;
	private boolean desktop = true;
	private boolean headless = false;
	private boolean forceCache = true;
	private boolean remoteMode = false;
	private boolean downloadDrivers = false;
	private boolean smallWindowMode = false;
	private boolean deviceEmulation = false;
	private boolean macOsTechnologyPreview = false;
	private String reportPath = "";
	private String browserType;
	private String driverType;
	private String reportingLevel = "normal";
	private int implicitTimeout = 50;
	private int scriptTimeout = 50;
	private int pageLoadTimeout = 50;
	private DesiredCapabilities capabilities;
	private ArrayList<String> pluginFiles = new ArrayList<>(); 
	private ArrayList<String> consoleLogs = new ArrayList<>();

	public DriverHelper(DesiredCapabilities cap) {
		capabilities = cap;
		browserType = cap.getBrowserName();

		if(capabilities.getCapability("platformName") != null &&
			(capabilities.getCapability("platformName").toString().equalsIgnoreCase("ANDROID") 
				|| capabilities.getCapability("platformName").toString().equalsIgnoreCase("iOS"))) {
			desktop = false;
		}

		if(!desktop && (browserType == null || browserType.isEmpty())) {
			driverType = AutomationConstants.MOBILE_APP;
		} else {
			driverType = AutomationConstants.WEB;
		}

		logger = new DebugLogger().setVerbose(false);
	}

	public DriverHelper(String browser) {
		headless = browser.contains("_headless");

		if(ArrayUtils.contains(InitUtils.getDeviceEmulationBrowsers(), browser.replace("_headless", ""))
		|| ArrayUtils.contains(InitUtils.getDesktopBrowsers(), browser.replace("_headless", ""))) {
			browserType = browser.replace("_headless", "");
			driverType = AutomationConstants.WEB;

			if(browserType.equals(BrowserType.SAFARI_IPHONE) || browserType.equals((BrowserType.SAFARI_IPAD))) {
				emulationBrowser = "safari";
			}
		} else if(BrowserType.IPHONE.equals(browser)) {
			browserType = browser;
			driverType = AutomationConstants.MOBILE_APP;
			desktop = false;
		} else {
			deviceName = browser;
			driverType = AutomationConstants.MOBILE_APP;
			desktop = false;
		}

		logger = new DebugLogger().setVerbose(false);
	}

	public BrowserMobProxy getProxy() {
		return proxy;
	}
	
	public void addPluginFile(String pluginFile) {
		pluginFiles.add(pluginFile);
	}

	public void setDebugVerbose(boolean verbose) {
		logger.setVerbose(verbose);
	}

	public void setHub(String ip, String port) {
		if(ip != null) {
			this.ip = ip;
		}

		if(port != null) {
			this.port = port;
		}
	}

	public boolean isRemoteMode() {
		return remoteMode;
	}

	public void setMaximize(boolean value) {
		maximize = value;
	}

	public void setWaitForPage(boolean value) {
		waitForPage = value;
	}

	public void setWaitForAngular(boolean value) {
		waitForAngular = value;
	}

	public void setWaitForJQuery(boolean value) {
		waitForJQuery = value;
	}

	public void setShowConsoleLog(boolean value) {
		showConsoleLog = value;
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
			logger.error("Exception setting implicit timeout" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
		}

		try {
			if(driver != null) driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {}

		try {
			if(driver != null) driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		} catch(WebDriverException e) {}
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

	public void setVerbose(boolean value) {
		verbose = value;
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

	public void setAndroidEmulator(boolean androidEmulator) {
		this.androidEmulator = androidEmulator;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setMacOsVersion(String version) {
		this.macOsVersion = version;
	}

	public void setMacOsTechnologyPreview(boolean macOsTechnologyPreview) {
		this.macOsTechnologyPreview = macOsTechnologyPreview;
	}

	public void setWebDriverLanguage(String language) {
		this.language = language;
	}

	public boolean isUseProxy() {
		return useProxy;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public boolean isAndroidEmulator() {
		return androidEmulator;
	}

	public String getBrowserType() {
		return browserType;
	}

	public String getEmulationBrowser() {
		return emulationBrowser;
	}

	public String getDevicePlatform() {
		return devicePlatform;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public int getWindowDefaultWidth() {
		return defaultWindowWidth;
	}

	public int getWindowDefaultHeight() {
		return defaultWindowHeight;
	}

	public void setMacOsBrowserStack(String browserStackUser, String browserStackKey) {
		this.macOsBrowserStackUser = browserStackUser;
		this.macOsBrowserStackKey = browserStackKey;
	}

	public void setAndroidAppVariables(String appPackage, String appActivity) {
		this.appPackage = appPackage;
		this.launchActivity = appActivity;
	}

	public void setAppVariables(DataObject configData) {
		if(devicePlatform != null && devicePlatform.equalsIgnoreCase(Platform.ANDROID.toString())) {
			this.appPackage = configData.getValue("app_package");
			this.launchActivity = configData.getValue("launch_activity");
		} else {
			this.platformVersion = configData.getValue(deviceName + "_version");
			this.appPackage = configData.getValue("ios_package");
			this.udid = configData.getValue(deviceName + "_udid");
		}
	}

	public void downloadDriver() {
		boolean auxVerbose = this.verbose;
		this.verbose = true;

		logger.begin();

		switch(browserType) {
			case BrowserType.FIREFOX:
				logger.info("Checking firefox driver");
				FirefoxConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.CHROME:
				logger.info("Checking chrome driver");
				ChromeConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.INTERNET_EXPLORER:
				logger.info("Checking Internet Explorer driver");
				IEConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.EDGE:
				logger.info("Checking edge driver");
				EdgeConfiguration.downloadDriver(forceCache);
				break;
			case BrowserType.SAFARI:
				logger.info("Checking safari driver");
				break;
			default:
				if(emulationBrowser.equals(BrowserType.FIREFOX)) {
					logger.info("Checking firefox driver for " + browserType);
					FirefoxConfiguration.downloadDriver(forceCache);
				} else if(emulationBrowser.equals(BrowserType.SAFARI)) {
					logger.info("Checking safari driver");
				} else {
					logger.info("Checking chrome driver for " + browserType);
					ChromeConfiguration.downloadDriver(forceCache);
				}

				break;
		}

		logger.end();

		this.verbose = auxVerbose;
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
				default:
					driverFolders = new File(mavenWindowsPath + "chromedriver/win32").list();
					System.setProperty("webdriver.chrome.driver", mavenWindowsPath + "chromedriver/win32/" + driverFolders[driverFolders.length - 1] + "/chromedriver.exe");
					break;
			}
		} else {
			String[] driverFolders;
			String mavenLinuxPath;
			String mavenLinuxPathJenkins = "/var/lib/jenkins/.m2/repository/webdriver/";
			String mavenLinuxPathHome = System.getProperty("user.home") + "/.m2/repository/webdriver/";

			if(new File(mavenLinuxPathJenkins).list() != null){
				mavenLinuxPath = mavenLinuxPathJenkins;
			} else {
				mavenLinuxPath = mavenLinuxPathHome;
			}

			switch(browserType) {
				case BrowserType.FIREFOX:
					driverFolders = new File(mavenLinuxPath + "geckodriver/linux64").list();
					System.setProperty("webdriver.gecko.driver", mavenLinuxPath + "geckodriver/linux64/" + driverFolders[driverFolders.length - 1] + "/geckodriver");
					break;
				case BrowserType.CHROME:
				default:
					driverFolders = new File(mavenLinuxPath + "chromedriver/linux64").list();
					System.setProperty("webdriver.chrome.driver", mavenLinuxPath + "chromedriver/linux64/" + driverFolders[driverFolders.length - 1] + "/chromedriver");
					break;
			}
		}
	}

	private BrowserConfiguration setSafariConfiguration(BrowserConfiguration options) {
		((SafariConfiguration) options).setTechnologyPreview(macOsTechnologyPreview);
		((SafariConfiguration) options).setVersion(macOsVersion);

		return options;
	}

	private BrowserConfiguration setMobileConfiguration(BrowserConfiguration options) {
		((MobileConfiguration) options).setBrowserType(browserType);
		((MobileConfiguration) options).setEmulationBrowser(emulationBrowser);

		if(emulationBrowser.equals(BrowserType.SAFARI)) {
			((MobileConfiguration) options).setTechnologyPreview(macOsTechnologyPreview);
		}

		return options;
	}

	private BrowserConfiguration createBrowserConfiguration() {
		BrowserConfiguration options = null;

		switch(browserType) {
			case BrowserType.FIREFOX:
				options = new FirefoxConfiguration();
				((FirefoxConfiguration) options).setPluginFile(pluginFiles);
				break;
			case BrowserType.CHROME:
				options = new ChromeConfiguration();
				((ChromeConfiguration) options).setPluginFile(pluginFiles);
				break;
			case BrowserType.INTERNET_EXPLORER:
				options = new IEConfiguration();
				break;
			case BrowserType.EDGE:
				options = new EdgeConfiguration();
				break;
			case BrowserType.SAFARI:
				options = new SafariConfiguration();
				setSafariConfiguration(options);
				break;
			default:
				options = new MobileConfiguration();
				setMobileConfiguration(options);
				((MobileConfiguration) options).setPluginFile(pluginFiles);
				break;
		}

		options.setHeadless(headless);
		options.setLanguage(language);
		options.setProxy(useProxy);

		if(useProxy) {
			proxyPort = options.createProxy(proxy);
			logger.info("Proxy location: localhost:" + proxyPort);
		}

		return options;
	}

	private WebDriver createRemoteWebDriver(URL hubUrl, BrowserConfiguration options) {
		WebDriver driver = null;

		switch(browserType) {
			case BrowserType.FIREFOX:
				logger.info("Initializing remote firefox driver");
				driver = new RemoteWebDriver(hubUrl, (FirefoxOptions) options.createOptions());
				break;
			case BrowserType.CHROME:
				logger.info("Initializing remote chrome driver");				
				driver = new RemoteWebDriver(hubUrl, (ChromeOptions) options.createOptions());
				break;
			case BrowserType.INTERNET_EXPLORER:
				logger.info("Initializing remote internet explorer driver");
				driver = new RemoteWebDriver(hubUrl, (InternetExplorerOptions) options.createOptions());
				break;
			case BrowserType.EDGE:
				logger.info("Initializing remote edge driver");
				driver = new RemoteWebDriver(hubUrl, (EdgeOptions) options.createOptions());
				break;
			case BrowserType.SAFARI:
				logger.info("Initializing remote safari driver");
				driver = new RemoteWebDriver(hubUrl, (SafariOptions) options.createOptions());
				break;
			default:
				logger.info("EmulationBrowser: " + emulationBrowser);
				
				if(!emulationBrowser.equals(BrowserType.SAFARI)) {
					if(emulationBrowser.equals(BrowserType.FIREFOX)) {
						driver = new RemoteWebDriver(hubUrl, (FirefoxOptions) options.createOptions());
					} else {
						driver = new RemoteWebDriver(hubUrl, (ChromeOptions) options.createOptions());
					}
				} else {
					driver = new RemoteWebDriver(hubUrl, (SafariOptions) options.createOptions());
				}

				deviceEmulation = true;

				break;
		}

		return driver;
	}

	private WebDriver createLocalWebDriver(BrowserConfiguration options) {
		WebDriver driver = null;

		switch(browserType) {
			case BrowserType.FIREFOX:
				logger.info("Initializing firefox driver");
				driver = new FirefoxDriver((FirefoxOptions) options.createOptions());
				break;
			case BrowserType.CHROME:
				logger.info("Initializing chrome driver");
				driver = new ChromeDriver((ChromeOptions) options.createOptions());
				break;
			case BrowserType.INTERNET_EXPLORER:
				logger.info("Initializing Internet Explorer driver");
				driver = new InternetExplorerDriver((InternetExplorerOptions) options.createOptions());
				break;
			case BrowserType.EDGE:
				logger.info("Initializing edge driver");
				driver = new EdgeDriver((EdgeOptions) options.createOptions());
				break;
			case BrowserType.SAFARI:
				logger.info("Initializing safari driver");				
				driver = new SafariDriver((SafariOptions) options.createOptions());
				break;
			default:
				logger.info("EmulationBrowser: " + emulationBrowser);

				if(!emulationBrowser.equals(BrowserType.SAFARI)) {
					if(emulationBrowser.equals(BrowserType.FIREFOX)) {
						logger.info("Initializing firefox driver for " + browserType);
						driver = new FirefoxDriver((FirefoxOptions) options.createOptions());
					} else {
						logger.info("Initializing chrome driver for " + browserType);
						driver = new ChromeDriver((ChromeOptions) options.createOptions());
					}
				} else {
					logger.info("Initializing safari driver for " + browserType);
					driver = new SafariDriver((SafariOptions) options.createOptions());
				}

				deviceEmulation = true;
				break;
		}


		return driver;
	}

	private WebDriver createAppDriver(URL hubUrl) {
		WebDriver appDriver = null;

		capabilities = new DesiredCapabilities();

		if(devicePlatform.equalsIgnoreCase(Platform.ANDROID.toString())) {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", launchActivity);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

			if(androidEmulator) {
				logger.info("Android Emulator detected.");
				capabilities.setCapability("app", "/app/" + appPackage + ".apk");
				capabilities.setCapability("appWaitPackage", appPackage);
				capabilities.setCapability("appWaitDuration", 40000);
				capabilities.setCapability("deviceReadyTimeout", 10);
				capabilities.setCapability("androidInstallTimeout", 130000);
			}

			logger.info("Initializing Android driver on hub: " + hubUrl);
			appDriver = new AndroidDriver<WebElement>(hubUrl, capabilities);
		} else {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.APP, appPackage);

			logger.info("Initializing iOs driver on hub: " + hubUrl);
			logger.info("Capabilities: " + capabilities.toString());
			appDriver = new IOSDriver<WebElement>(hubUrl, capabilities);
		}

		return appDriver;
	}

	private void setWindowSizeConfiguration() {
		if(desktop && !deviceEmulation) {
			if(browserType != null && browserType.equals(BrowserType.SAFARI)) {
				resizeWindow(1024, 675);
				setWindowPosition(2, 2);
				waitWithDriver(2000);
			} else {
				resizeWindow(defaultWindowWidth, defaultWindowHeight);
			}
		} else if(desktop && browserType.equals(BrowserType.SAFARI_IPHONE)) {
			resizeWindow(375, 667);
			setWindowPosition(2, 2); // TODO: Selenium bug transforms 0 and 1 to boolean, change to 0, 0 when fixed
			waitWithDriver(3000);
		} else if(desktop && browserType.equals(BrowserType.SAFARI_IPAD)) {
			resizeWindow(860, 670);
			setWindowPosition(2, 2); // TODO: Selenium bug transforms 0 and 1 to boolean, change to 0, 0 when fixed
			waitWithDriver(3000);
		} else if(desktop && deviceEmulation && emulationBrowser.equals(BrowserType.FIREFOX)) {
			if(ArrayUtils.contains(InitUtils.getMobileEmulationBrowsers(), browserType)) {
				resizeWindow(360, 640);
			} else {
				resizeWindow(1024, 768);
			}
		}

		if(maximize) maximizeWindow();

		if(desktop && Integer.parseInt(((JavascriptExecutor) driver).executeAsyncScript("arguments[0](window.outerWidth);").toString()) < smallWindowLimit) {
			smallWindowMode = true;
		}
	}

	public void initializeDriver() {
		boolean verbose = this.verbose;
		this.verbose = true;

		logger.begin();
		URL hubUrl = null;

		try {
			if(browserType != null && browserType.contains(BrowserType.SAFARI) && macOsBrowserStackUser != null && macOsBrowserStackKey != null) {
				hubUrl = new URL("http://" + macOsBrowserStackUser + ":" + macOsBrowserStackKey + "@hub-cloud.browserstack.com/wd/hub");
			} else {
				hubUrl = new URL("http://" + ip + ":" + port + "/wd/hub");
			}
		} catch(MalformedURLException e) {
			logger.error("Error with url");
			e.printStackTrace();
		}

		if(desktop) {
			logger.info("Desktop device");

			if(downloadDrivers) {
				downloadDriver();
			}			

			BrowserConfiguration options = createBrowserConfiguration();

			if(remoteMode) {
				logger.info("Initializing remote driver");

				driver = createRemoteWebDriver(hubUrl, options);
			} else {
				setPropertyDriverPath(OSUtils.getOsName(), browserType);

				driver = createLocalWebDriver(options);

			}
		} else if(devicePlatform != null) {
			logger.info("Mobile device");
			driver = createAppDriver(hubUrl);
		}

		setTimeouts();

		setWindowSizeConfiguration();

		logger.end();

		this.verbose = verbose;
	}

	@SuppressWarnings("unchecked")
	public SessionId getSessionId() {
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
					case BrowserType.INTERNET_EXPLORER:
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
						} else if(emulationBrowser.equals(BrowserType.SAFARI)) {
							sessionId = ((SafariDriver) driver).getSessionId();
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

		return sessionId;
	}

	// region WebDriver
	public String getId() {
		return id;
	}

	public void setId(String value) {
		id = value;
		logger.setId(id);
	}

	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
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

	public boolean isDeviceEmulation() {
		return deviceEmulation;
	}

	public boolean isMobileEmulation() {
		return ArrayUtils.contains(InitUtils.getMobileEmulationBrowsers(), browserType);
	}

	public boolean isTabletEmulation() {
		return ArrayUtils.contains(InitUtils.getTabletEmulationBrowsers(), browserType);
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

	public void setWindowPosition(int x, int y) {
		Point position = new Point(x, y);

		if(driver != null) {
			driver.manage().window().setPosition(position);
		}
	}

	public void setWindowSize(int width, int height) {
		defaultWindowHeight = height;
		defaultWindowWidth = width;
	}

	public void setEmulationBrowser(String browser) {
		if(browser != null) emulationBrowser = browser;
	}

	public void quit() {
		try {
			if(driver != null) {
				if(useProxy) proxy.stop();
				driver.quit();
			}
		} catch(Exception e) {}
	}

	public void maximizeWindow() {
		try {
			if(desktop && driver != null) {
				driver.manage().window().maximize();
			} else if(capabilities.getCapability("platformName") != null && capabilities.getCapability("platformName").equals("iOS")
				&& driver != null) {
				java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

				Point position = new Point(2, 2); // TODO: Selenium bug
													// transforms 0 and 1 to
													// boolean, change to 0, 0
													// when fixed
				driver.manage().window().setPosition(position);

				Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
				driver.manage().window().setSize(maximizedScreenSize);
			}
		} catch(Exception e) {}
	}

	public void resizeWindow(int width, int heigth) {
		try {
			if(desktop && driver != null) {
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
			String[] activityArray = ((AndroidDriver<WebElement>) driver).currentActivity().split(".");

			return activityArray[activityArray.length - 1];
		} else return driver.getCurrentUrl();
	}

	public List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	public List<WebElement> getElementChildren(By element) {
		logger.begin();
		waitForElementToBePresent(element);

		List<WebElement> elements = driver.findElement(element).findElements(By.xpath("*"));

		logger.end();

		return elements;
	}

	public List<WebElement> getElementsMobile(String by) {
		@SuppressWarnings("unchecked")
		AndroidDriver<WebElement> appDriver = ((AndroidDriver<WebElement>) driver);

		return appDriver.findElementsByClassName("android.widget.FrameLayout");
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

	@SuppressWarnings("rawtypes")
	public WebElement getElement(By by) {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = ((AppiumDriver<WebElement>) driver);
			WebElement el = null;

			setTimeouts(shortWait);

			try {
				el = appDriver.findElement(by);
			} catch(Exception e) {}

			if(el == null || !el.isDisplayed()) {
				scrollToTop();

				try {
					el = appDriver.findElement(by);
				} catch(Exception e) {}

				for(int i = 0; i < 10 && (el == null || !el.isDisplayed()); i++) {
					Dimension windowSize = appDriver.manage().window().getSize();

					new TouchAction(appDriver).press(PointOption.point((int) (windowSize.width / 2), (int) (windowSize.height * 0.7)))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
						.moveTo(PointOption.point((int) (windowSize.width / 2), (int) (windowSize.height * 0.3)))
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
			logger.error("Error removing element");
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
			for(int i = auxStyle.indexOf(':') + 1; i < auxStyle.length(); i++) {
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

	public String executeJavaScript(String script) {
		return ((JavascriptExecutor) driver).executeScript(script) + "";
	}

	public String getSource() {
		return driver.getPageSource();
	}

	public void printAllElements() {
		List<WebElement> list = getAllElements();

		for(int i = 0; i < list.size(); i++) {
			String className = list.get(i).getAttribute("class").equals("") ? "" : "class='" + list.get(i).getAttribute("class") + "'";
			String elementId = list.get(i).getAttribute("id").equals("") ? "" : "id='" + list.get(i).getAttribute("id") + "'";
			
			logger.info(list.get(i).getTagName() + " " + className + " " + elementId);
		}
	}

	public void go(String url) {
		if(driver == null || getSessionId() == null) {
			initializeDriver();
		}

		driver.get(url);
		waitForLoadToComplete();
	}

	public void refresh() {
		logger.begin();
		driver.navigate().refresh();
		waitForLoadToComplete();
		logger.end();
	}

	public void forward() {
		logger.begin();
		driver.navigate().forward();
		waitForLoadToComplete();
		logger.end();
	}

	public void back() {
		logger.begin();
		driver.navigate().back();
		waitForLoadToComplete();
		logger.end();
	}
	// endregion

	public WebElement selectClickableElement(By by) {
		logger.begin();

		WebElement el = null;

		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
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
		} else {
			el = getElement(by);
		}

		logger.end();

		return el;
	}

	// region Clicks
	public void click(By by) {
		click(waitForElementToBeClickable(by));
	}

	public void click(WebElement element) {
		logger.begin();

		if(browserType != null && (browserType.equals(BrowserType.INTERNET_EXPLORER) || browserType.equals(BrowserType.SAFARI))) {
			try {
				new Actions(driver).moveToElement(element).click().perform();
			} catch(Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			}
		} else {
			waitForElementToBeClickable(element).click();
		}

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
	}

	public void dispatchEvent(By by, String event) {
		dispatchEvent(waitForElementToBePresent(by), event);
	}

	public void dispatchEvent(WebElement element, String event) {
		logger.begin();

		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('" + event + "', {bubbles:true}));", element);

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
	}

	public void triggerAngularEvent(By by, String event) {
		triggerAngularEvent(waitForElementToBeClickable(by), event);
	}

	public void triggerAngularEvent(WebElement element, String event) {
		logger.begin();

		((JavascriptExecutor) driver).executeScript("angular.element(arguments[0]).triggerHandler('" + event + "');", element);

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
	}

	public void clickInFrame(By by, By frame) {
		switchToFrame(frame);
		click(by);
		exitFrame();
	}

	@SuppressWarnings("rawtypes")
	public void clickOnCoordinates(int xCor, int yCor) {
		logger.begin();

		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;

			new TouchAction(appDriver).press(PointOption.point(xCor, yCor)).release().perform();
		} else if(driverType != null && !driverType.equals(AutomationConstants.MOBILE_APP)) {
			new Actions(driver).moveByOffset(xCor, yCor).click().perform();
		}

		logger.end();
	}

	public void clickRelativePosition(By by, double xPer, double yPer) {
		clickRelativePosition(driver.findElement(by), xPer, yPer);
	}

	@SuppressWarnings("rawtypes")
	public void clickRelativePosition(WebElement el, double xPer, double yPer) {
		logger.begin();
		waitForElementToBeClickable(el);

		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Rectangle rect = el.getRect();

			new TouchAction(appDriver).press(PointOption.point((int) (rect.width * xPer) + rect.x, (int) (rect.height * yPer) + rect.y)).release().perform();
		} else if(browserType != null && browserType.equals(BrowserType.INTERNET_EXPLORER)) {
			Dimension size = el.getSize();

			new Actions(driver).moveToElement(el).moveByOffset((int) (((double) -size.width / 2) + size.width * yPer), 
				(int) (((double) -size.height / 2) + size.height * yPer)).click().perform();
		} else {
			try {
				((JavascriptExecutor) driver).executeScript("document.elementFromPoint("
					+ "arguments[0].getBoundingClientRect().x + (arguments[0].getBoundingClientRect().width * " + xPer + "), "
					+ "arguments[0].getBoundingClientRect().y + (arguments[0].getBoundingClientRect().height * " + yPer + ")).click();", el);
			} catch(WebDriverException e) {
				try {
					new Actions(driver).moveToElement(el).click().perform();
				} catch(Exception e1) {
					logger.error("Element not found");
					e.printStackTrace();

					throw e;
				}

			}
		}

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
	}

	public void clickOver(By by) {
		clickOver(waitForElementToBeClickable(by));
	}

	public void clickOver(WebElement el) {
		logger.begin();

		waitForElementToBeClickable(el);

		if(browserType != null && browserType.equals(BrowserType.INTERNET_EXPLORER)) {
			new Actions(driver).moveToElement(el).click().perform();
		} else {
			try {
				((JavascriptExecutor) driver).executeScript("document.elementFromPoint("
					+ "arguments[0].getBoundingClientRect().x, "
					+ "arguments[0].getBoundingClientRect().y).click();", el);
			} catch(WebDriverException e) {
				try {
					new Actions(driver).moveToElement(el).click().perform();
				} catch(Exception e1) {
					logger.info("Element not found");
					e.printStackTrace();

					throw e;
				}
			}
		}

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
	}

	public void doubleClick(By by) {
		doubleClick(driver.findElement(by));
	}

	public void doubleClick(WebElement element) {
		logger.begin();

		waitForElementToBeClickable(element);
		new Actions(driver).moveToElement(element).doubleClick().perform();

		waitForLoadToComplete();
		takeScreenshotWithCondition();
		logger.end();
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

		waitForLoadToComplete();
	}

	public void swipeLeft(By by) {
		WebElement element = waitForElementToBeClickable(by);
		Dimension size = element.getSize();

		new Actions(driver).moveToElement(element).moveByOffset((int) (size.width * 0.4), 0).clickAndHold().pause(2500)
			.moveByOffset((int) (-size.width * 0.8), 0).pause(1000).release().perform();

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeDown(double percentage) {
		if(percentage < 0.3) {
			percentage = 0.4;
		} else if(percentage > 1) {
			percentage = 1;
		}

		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Dimension size = driver.manage().window().getSize();

			logger.info("Scrolling from point " + (size.getHeight() * 0.3) + " to " + (size.getHeight() * percentage));
			new TouchAction(appDriver).press(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.3)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * percentage)))
				.release().perform();
		} else {
			Dimension size = driver.manage().window().getSize();

			new Actions(driver).moveByOffset(0, (int) (-size.height * 0.3)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (size.height * percentage)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeDown(By by) {
		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			WebElement element = driver.findElement(by);
			Rectangle rect = element.getRect();

			new TouchAction(appDriver).press(PointOption.point((rect.getX() + rect.getWidth() / 2), (int) (rect.getY() + (rect.getHeight() * 0.3))))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((rect.getX() + rect.getWidth() / 2), (int) (rect.getY() + (rect.getHeight() * 0.8))))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.release().perform();

		} else {
			WebElement element = waitForElementToBeClickable(by);
			Dimension size = element.getSize();

			new Actions(driver).moveToElement(element).moveByOffset(0, (int) (-size.height * 0.4)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (size.height * 0.1)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeDown() {
		if(driverType != null || driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Dimension size = driver.manage().window().getSize();

			logger.info("Scrolling from point " + (size.getHeight() * 0.3) + " to " + (size.getHeight() * 0.8));
			new TouchAction(appDriver).press(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.3)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.8)))
				.release().perform();

		} else {
			Dimension size = driver.manage().window().getSize();

			new Actions(driver).moveByOffset(0, (int) (-size.height * 0.4)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (size.height * 0.5)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeUp(double percentage) {
		if(percentage < 0.3) {
			percentage = 0.4;
		} else if(percentage > 1) {
			percentage = 1;
		}

		if(driverType != null && driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Dimension size = driver.manage().window().getSize();

			logger.info("Scrolling from point " + (size.getHeight() * percentage) + " to " + (size.getHeight() * 0.3));
			new TouchAction(appDriver).press(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * percentage)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.3)))
				.release().perform();
		} else {
			Dimension size = driver.manage().window().getSize();

			new Actions(driver).moveByOffset(0, (int) (-size.height * 0.3)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (size.height * percentage)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeUp(By by) {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			WebElement element = driver.findElement(by);

			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Rectangle rect = element.getRect();

			new TouchAction(appDriver).press(PointOption.point((rect.getX() + rect.getWidth() / 2), (int) (rect.getY() + rect.getHeight() * 0.8)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((rect.getX() + rect.getWidth() / 2), (int) (rect.getY() + rect.getHeight() * 0.3)))
				.release().perform();

		} else {
			WebElement element = waitForElementToBeClickable(by);

			Dimension size = element.getSize();

			new Actions(driver).moveToElement(element).moveByOffset(0, (int) (size.height * 0.4)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (-size.height * 0.5)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}

	@SuppressWarnings("rawtypes")
	public void swipeUp() {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;
			Dimension size = this.getDriver().manage().window().getSize();

			new TouchAction(appDriver).press(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.8)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point((size.getWidth() / 2), (int) (size.getHeight() * 0.3)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.release().perform();

		} else {

			Dimension size = this.getDriver().manage().window().getSize();

			new Actions(driver).moveByOffset(0, (int) (size.height * 0.4)).clickAndHold().pause(2500)
				.moveByOffset(0, (int) (-size.height * 0.5)).pause(1000).release().perform();
		}

		waitForLoadToComplete();
	}
	// endregion

	// region Text
	public String getText(By by) {
		waitForLoadToComplete();

		return getText(driver.findElement(by));
	}

	public String getTextInFrame(By by, By frame) {
		String result = "";

		switchToFrame(frame);
		result = getText(by);
		exitFrame();

		return result;
	}

	public String getText(WebElement webElement) {
		logger.begin();
		waitForLoadToComplete();

		String text = webElement.getText();

		if(text.isEmpty()) {
			Object javascriptRepsonse = ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", webElement);

			if(javascriptRepsonse != null) {
				text = javascriptRepsonse.toString();
			}
		}

		logger.end();

		return text;
	}

	public void clickElementFromDropDownByText(By dropDown, String value) {
		logger.begin();
		waitForElementToBeClickable(dropDown);

		Select select = new Select(driver.findElement(dropDown));
		select.selectByVisibleText(value);

		waitForLoadToComplete();
		logger.end();
	}

	public void clickElementFromDropDownByTextInFrame(By dropDown, By frame, String value) {
		switchToFrame(frame);
		clickElementFromDropDownByText(dropDown, value);
		exitFrame();
	}

	public void clickElementFromDropDownByAttribute(By elementToClick, By elementList, String attribute, String value) {
		logger.begin();
		waitForElementToBeClickable(elementToClick).click();

		clickElementFromListByAttribute(elementList, attribute, value);

		waitForLoadToComplete();
		logger.end();
	}

	public void clickElementFromDropDownByAttribute(By containingElement, String attribute, String value) {
		clickElementFromDropDownByAttribute(containingElement, containingElement, attribute, value);
	}

	public void clickElementFromListByAttribute(By elementList, String attribute, String value) {
		logger.begin();
		WebElement el = getElementFromListByAttribute(elementList, attribute, value);

		if(el != null) el.click();
		else {
			logger.info("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.end();
	}

	public WebElement getElementFromListByAttribute(By elementList, String attribute, String value) {
		logger.begin();
		waitForElementToBeClickable(elementList);

		WebElement webElement = driver.findElement(elementList).findElement(By.cssSelector("[" + attribute + "='" + value + "']"));

		logger.end();

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
		logger.begin();
		WebElement el = getElementChildByIndex(elementList, index);

		if(el != null) el.click();
		else {
			logger.info("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.end();
	}

	public WebElement getElementChildByIndex(By elementList, int index) {
		logger.begin();
		waitForElementToBeClickable(elementList);

		WebElement webElement = null;
		List<WebElement> elements = driver.findElement(elementList).findElements(By.xpath("*"));
		
		if(!elements.isEmpty() && index >= 0) {
			webElement = elements.get(index);
		} else if(!elements.isEmpty() && index < 0) {
			webElement = elements.get(elements.size() + index);
		}

		logger.end();

		return webElement;
	}

	public void clickElementChildByText(By elementList, String text) {
		logger.begin();

		WebElement el = getElementChildByText(elementList, text);

		if(el != null) el.click();
		else {
			logger.info("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.end();
	}

	public WebElement getElementChildByText(By elementList, String text) {
		logger.begin();
		waitForElementToBeClickable(elementList);

		List<WebElement> elements = driver.findElement(elementList).findElements(By.xpath("*[contains(text(), '" + text + "')]"));
		WebElement webElement = !elements.isEmpty() ? elements.get(0) : null;

		logger.end();

		return webElement;
	}

	public void clickElementChildByAttribute(By elementList, String attribute, String value) {
		logger.begin();

		WebElement el = getElementChildByAttribute(elementList, attribute, value);

		if(el != null) el.click();
		else {
			logger.info("No child elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.end();
	}

	public WebElement getElementChildByAttribute(By elementList, String attribute, String value) {
		logger.begin();
		waitForElementToBeClickable(elementList);

		List<WebElement> elements = driver.findElement(elementList).findElements(By.cssSelector("[" + attribute + "='" + value + "']"));
		WebElement webElement = !elements.isEmpty() ? elements.get(0) : null;

		logger.end();

		return webElement;
	}

	public void clickElementFromCollectionByIndex(By elementList, int index) {
		logger.begin();

		WebElement el = getElementFromCollectionByIndex(elementList, index);

		if(el != null) el.click();
		else {
			logger.info("No elements found on " + elementList);
		}

		waitForLoadToComplete();
		logger.end();
	}

	public WebElement getElementFromCollectionByIndex(By elementList, int index) {
		logger.begin();
		waitForElementToBeClickable(elementList);

		WebElement webElement = null;
		List<WebElement> elements = driver.findElements(elementList);
		
		if(!elements.isEmpty() && index >= 0) {
			webElement = elements.get(index);
		} else if(!elements.isEmpty() && index < 0) {
			webElement = elements.get(elements.size() + index);
		}

		logger.end();

		return webElement;
	}

	public void clearText(By by) {
		logger.begin();
		WebElement el = waitForElementToBeClickable(by);

		el.clear();

		waitForLoadToComplete();
		logger.end();
	}

	public void clearTextInFrame(By by, By frame) {
		switchToFrame(frame);
		clearText(by);
		exitFrame();
	}

	public void pressMultipleKeys(String[] keysArray) {
		if(keysArray != null && keysArray.length == 0) {
			try {
				Robot robot = new Robot();

				for(String key : keysArray) {
					if(key != null) robot.keyPress((int) key.charAt(0));
				}
			} catch(AWTException e) {
				e.printStackTrace();
			}
		}
	}

	public void releaseMultipleKeys(String[] keysArray) {
		if(keysArray != null && keysArray.length == 0) {
			try {
				Robot robot = new Robot();

				for(String key : keysArray) {
					if(key != null) robot.keyRelease((int) key.charAt(0));
				}
			} catch(AWTException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMultipleKeys(String[] keysArray) {
		pressMultipleKeys(keysArray);

		releaseMultipleKeys(keysArray);
	}

	public void setText(By by, String text) {
		waitForLoadToComplete();

		clearText(by);
		appendText(by, text);
	}

	public void appendText(By by, String text) {
		logger.begin();

		WebElement el = waitForElementToBeClickable(by);
		el.sendKeys(text);

		waitForLoadToComplete();
		logger.end();
	}

	public void appendTextInFrame(By by, By frame, String text) {
		switchToFrame(frame);
		appendText(by, text);
		exitFrame();
	}

	public void clearAndAppendText(By by, String text) {
		logger.begin();

		clearText(by);
		appendText(by, text);

		logger.end();
	}

	public void clearAndAppendTextInFrame(By by, By frame, String text) {
		switchToFrame(frame);
		clearAndAppendText(by, text);
		exitFrame();
	}

	public void setTextIfEmpty(By by, String text) {
		logger.info("Checking if element text is empty");
		if(getText(by).isEmpty()) {
			setText(by, text);
		} else {
			logger.info("Element text is not empty");
		}
	}

	public void setTextIfDifferent(By by, String text) {
		logger.info("Checking if element contains the same text");
		if(!getAttribute(by, "value").equals(text)) {
			clearText(by);
			appendText(by, text);
		} else logger.info("Text is the same");
	}

	public void setTextInFrame(By by, By frame, String value) {
		switchToFrame(frame);

		setText(by, value);

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
		logger.begin();

		if(!driverType.equals(AutomationConstants.MOBILE_APP) && browserType != null && browserType.equals(BrowserType.FIREFOX)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseover', {bubbles:true}));", element);
		} else if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			new Actions(driver).moveToElement(element).perform();
		}

		waitForLoadToComplete();
		logger.end();
	}

	public void moveOverElement(By by) {
		logger.begin();

		if(!driverType.equals(AutomationConstants.MOBILE_APP) && browserType != null && browserType.equals(BrowserType.INTERNET_EXPLORER)) {
			new Actions(driver).moveToElement(driver.findElement(by)).perform();
		} else if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseover', {bubbles:true}));", driver.findElement(by));
		}

		waitForLoadToComplete();
		logger.end();
	}
	// endregion

	// region Frames
	public void switchToFrame(By by) {
		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = ((AppiumDriver<WebElement>) driver);
			appDriver.switchTo().frame(driver.findElement(by));
		} else {
			driver.switchTo().frame(driver.findElement(by));
		}
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void exitFrame() {
		driver.switchTo().defaultContent();
	}
	// endregion

	// region Focus
	public void tabulateElement(By by) {
		logger.begin();
		waitForElementToBeClickable(by);

		driver.findElement(by).sendKeys(Keys.TAB);

		logger.end();
	}

	public void tabulateElementInFrame(By by, By frame) {
		switchToFrame(frame);
		tabulateElement(by);
		exitFrame();
	}
	// endregion

	// region Scrolls
	public void scrollPageDown() {
		logger.begin();
		waitForLoadToComplete();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, window.pageYOffset + (window.innerHeight * 0.8));");

		logger.end();
	}

	public void scrollNthPageDown(int numberOfPages) {
		for(int i = 0; i < numberOfPages; i++) {
			scrollPageDown();
		}
	}

	@SuppressWarnings("rawtypes")
	public void scrollToTop() {
		logger.begin();
		waitForLoadToComplete();

		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;

			for(int i = 0; i < 5; i++) {
				Dimension windowSize = appDriver.manage().window().getSize();

				new TouchAction(appDriver).press(PointOption.point((int) (windowSize.width / 2), (int) (windowSize.height * 0.1)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
					.moveTo(PointOption.point((int) (windowSize.width / 2), (int) (windowSize.height * 0.8))).release().perform();
			}
		} else {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, 0);");
		}

		logger.end();
	}

	@SuppressWarnings("rawtypes")
	public void scrollToBottom() {
		logger.begin();
		waitForLoadToComplete();

		if(driverType.equals(AutomationConstants.MOBILE_APP)) {
			@SuppressWarnings("unchecked")
			AppiumDriver<WebElement> appDriver = (AppiumDriver<WebElement>) driver;

			for(int i = 0; i < 5; i++) {
				Dimension windowSize = appDriver.manage().window().getSize();

				new TouchAction(appDriver).press(PointOption.point((int) (windowSize.width / 2), (int) (windowSize.height * 0.8)))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
					.moveTo(PointOption.point((int) (windowSize.width / 2), 1)).release()
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(150))).perform();
			}
		} else {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(window.pageXOffset, document.body.scrollHeight);");
		}

		logger.end();
	}

	public void scrollToRightLimit() {
		logger.begin();
		waitForLoadToComplete();

		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollWidth, window.pageYOffset);");
		}

		logger.end();
	}

	public void scrollToLeftLimit() {
		logger.begin();
		waitForLoadToComplete();

		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, window.pageYOffset);");
		}

		logger.end();
	}

	/**
	 * Scrolls inside an element enough pixels to make sure that a child element is visible.
	 *
	 * @param scroll
	 *            the element that will be scrolled
	 * @param el
	 *            the element that we want to be visible
	 * @param extraScroll
	 *            extra pixels that will be scrolled
	 */
	public void scrollToElementInsideParent(By scroll, By el, int extraScroll) {
		WebElement parentWE = driver.findElement(scroll);
		WebElement elementWE = driver.findElement(el);

		int parentHeight = parentWE.getSize().height;
		int parentTop = parentWE.getLocation().y;
		int elementHeight = elementWE.getSize().height;
		int elementTop = elementWE.getLocation().y;

		int scrolledPixels = (((elementTop + elementHeight) - parentTop) - parentHeight) + extraScroll;

		if(scrolledPixels > 0) {
			logger.info("Scrolling to element (" + scrolledPixels + " pixels)");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop=" + scrolledPixels + ";", parentWE);
		} else {
			logger.info("No need to scroll the element. It's already visible.");
		}
	}

	public void scrollToElement(By by) {
		if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
			scrollToElement(driver.findElement(by));
		} else {
			getElement(by);
		}
	}

	public void scrollToElement(WebElement el) {
		scrollToElement(el, false);
	}

	public void scrollToElement(By by, boolean complete) {
		scrollToElement(driver.findElement(by), complete);
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
			logger.error("Exception found: " + e.getMessage());
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
		logger.begin();
		waitForElementToBeClickable(by);

		click(by);

		waitForLoadToComplete();
		logger.end();
	}

	public void waitForLoadToComplete() {
		logger.begin();

		if(desktop && !driverType.equals(AutomationConstants.MOBILE_APP)) {
			if(waitForPage) {
				waitForPageToLoad();
			}

			if(waitForAngular) {
				waitForAngular();
			}

			if(waitForJQuery) {
				waitForJQuery();
			}

			if(showConsoleLog) {
				addToLog();
			}
		}

		logger.end();
	}

	public void waitForPageToLoad() {
		logger.begin();

		try {
			new WebDriverWait(driver, implicitTimeout)
				.pollingEvery(Duration.ofMillis(500))
				.until((ExpectedCondition<Boolean>) wd -> "complete".equals(((JavascriptExecutor) wd).executeScript("return !document ? false : !document.readyState ? false : document.readyState;")));
		} catch(JavascriptException e) {}

		logger.end();
	}

	public void waitForJQuery() {
		logger.begin();

		try {
			if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
				new WebDriverWait(driver, implicitTimeout)
					.pollingEvery(Duration.ofMillis(500))
					.until((ExpectedCondition<Boolean>) wd -> (((JavascriptExecutor) wd)
						.executeScript("return jQuery.active == 0  && jQuery.isReady;") + "").toString().equals("true"));
			}
		} catch(WebDriverException e) {
			if(e.getMessage() == null || (e.getMessage() != null && !e.getMessage().contains("jQuery is not defined"))) {
				logger.error("Exception in wait for jQuery" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
			}
		}

		logger.end();
	}

	public void waitForAngular() {
		logger.begin();

		try {
			if(!driverType.equals(AutomationConstants.MOBILE_APP)) {
				new WebDriverWait(driver, implicitTimeout)
					.pollingEvery(Duration.ofMillis(500))
					.until((ExpectedCondition<Boolean>) wd -> (((JavascriptExecutor) wd).executeScript("return !window.angular"
						+ " || (!!window.angular && !!angular.element(document).injector()"
						+ " && angular.element(document).injector().get('$http').pendingRequests.length === 0);") + "").toString().equals("true"));
			}
		} catch(WebDriverException e) {
			logger.error("Exception in wait for angular" + (e.getMessage() == null ? "" : ": " + e.getMessage()));
		}

		logger.end();
	}

	public void listenToAJAXRequest(String url) {
		logger.begin();

		((JavascriptExecutor) driver).executeScript("var origOpen = XMLHttpRequest.prototype.open;" +
			"XMLHttpRequestComplete = false;" +
			"XMLHttpRequest.prototype.open = function() {" +
			"    if (this.resource.url.includes(\"" + url + "\")) {" +
			"        XMLHttpRequestComplete = false;" +
			"        this.addEventListener('load', function() {" +
			"            XMLHttpRequestComplete = true;" +
			"        });" +
			"    }" +
			"    origOpen.apply(this, arguments);" +
			"};");

		logger.end();
	}

	public boolean waitForAJAXRequest() {
		logger.begin();
		boolean ajaxComplete = false;

		try {
			new WebDriverWait(driver, implicitTimeout)
				.pollingEvery(Duration.ofMillis(100))
				.until((ExpectedCondition<Boolean>) wd -> (((JavascriptExecutor) wd).executeScript("return typeof(XMLHttpRequestComplete) != 'undefined' && XMLHttpRequestComplete").toString()
					.equals("true")));

			ajaxComplete = true;
		} catch(Exception e) {
			logger.error(e.getMessage());
		}

		logger.end();

		return ajaxComplete;
	}

	@SuppressWarnings("unchecked")
	public WebElement waitForElementToBePresent(By waitElement) {
		logger.begin();
		waitForLoadToComplete();
		WebElement el = null;

		if((browserType != null && browserType.equals(BrowserType.SAFARI))
				|| (deviceEmulation && emulationBrowser.equals(BrowserType.SAFARI))) {
			boolean isPresent = false;

			long checkDuration = shortWait * 1000;

			for(int i = 0; !isPresent && i < implicitTimeout * 1000; i += checkDuration) {
				long initialTime = System.currentTimeMillis();
				isPresent = isPresent(waitElement);
				checkDuration = System.currentTimeMillis() - initialTime;
			}
			
			if(isPresent) {
				el = driver.findElement(waitElement);
			}
		} else {
			el = new WebDriverWait(!driverType.equals(AutomationConstants.WEB) ? ((AndroidDriver<WebElement>) driver) : driver, implicitTimeout)
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(WebDriverException.class)
				.until(ExpectedConditions.presenceOfElementLocated(waitElement));
		}

		logger.end();

		return el;
	}

	public WebElement waitForElementToBePresentInFrame(By waitElement, By frame) {
		this.switchToFrame(frame);

		WebElement el = waitForElementToBePresent(waitElement);

		this.exitFrame();

		return el;
	}

	public WebElement waitForElementToBeClickable(By waitElement) {
		logger.begin();

		if(desktop && driverType.equals(AutomationConstants.WEB)) {
			WebElement webElement = waitForElementToBePresent(waitElement);

			if(!isClickable(webElement) || !isOnScreen(webElement)) {
				scrollToElement(webElement);
			}

			boolean isClickable = false;

			long checkDuration = shortWait * 1000;

			for(int i = 0; !isClickable && i < implicitTimeout * 1000; i += checkDuration) {
				long initialTime = System.currentTimeMillis();
				isClickable = isClickable(waitElement);
				checkDuration = System.currentTimeMillis() - initialTime;
			}
		} else {
			scrollToElement(waitElement);
		}

		logger.end();

		return driver.findElement(waitElement);
	}

	public WebElement waitForElementToBeClickable(WebElement waitElement) {
		logger.begin();
		waitForLoadToComplete();

		boolean isClickable = false;

		long checkDuration = shortWait * 1000;

		for(int i = 0; !isClickable && i < implicitTimeout; i += checkDuration) {
			long initialTime = System.currentTimeMillis();
			isClickable = isClickable(waitElement);
			checkDuration = System.currentTimeMillis() - initialTime;
		}

		logger.end();

		return waitElement;
	}

	public boolean waitForElementNotToBeClickable(By waitElement) {
		logger.begin();
		waitForLoadToComplete();

		boolean isClickable = isClickable(waitElement);

		long checkDuration = shortWait * 1000;

		for(int i = 0; isClickable && i < implicitTimeout * 1000; i += checkDuration) {
			long initialTime = System.currentTimeMillis();
			isClickable = isClickable(waitElement);
			checkDuration = System.currentTimeMillis() - initialTime;
		}

		logger.end();

		return isClickable;
	}

	public boolean waitForElementNotToBeClickableInFrame(By waitElement, By frame) {
		switchToFrame(frame);
		boolean result = waitForElementNotToBeClickable(waitElement);
		exitFrame();

		return result;
	}

	public void waitForElementToBeClickableInFrame(By waitElement, By frame) {
		switchToFrame(frame);
		waitForElementToBeClickable(waitElement);
		exitFrame();
	}

	public boolean waitForAPIResponse(long milliseconds) {
		boolean modHeader = System.getProperty("use_modheader") != null && System.getProperty("use_modheader").equals("true") ? true : false;
		if(!modHeader && !useProxy) {
			waitWithDriver(milliseconds);
			return true;
		}

		return false;
	}

	//endregion

	public boolean isEnabled(By by) {
		return driver.findElement(by).isEnabled();
	}

	public Dimension getWindowSize() {
		Dimension size;

		if(desktop) {
			int width = Integer.parseInt(((JavascriptExecutor) driver).executeScript("return window.innerWidth;") + "");
			int height = Integer.parseInt(((JavascriptExecutor) driver).executeScript("return window.innerHeight;") + "");

			size = new Dimension(width, height);
		} else {
			size = new Dimension(driver.manage().window().getSize().width, driver.manage().window().getSize().height);
		}

		return size;
	}

	public Dimension getWindowOffset() {
		Dimension size = new Dimension(0, 0);

		if(desktop) {
			double xOffset = Double.parseDouble(((JavascriptExecutor) driver).executeScript("return window.pageXOffset;") + "");
			double yOffset = Double.parseDouble(((JavascriptExecutor) driver).executeScript("return window.pageYOffset;") + "");
			size = new Dimension((int) xOffset, (int) yOffset);
		}

		return size;
	}

	public ArrayList<String> getConsoleLogs() {
		return consoleLogs;
	}

	public ArrayList<String> getCurrentLogs() {
		ArrayList<String> list = new ArrayList<>();

		if(browserType.equals(BrowserType.CHROME)) {
			driver.manage().logs().get("browser").forEach(p -> 
				list.add(p.getLevel().getName() + ": " + p.getMessage()));
		}

		return list;
	}

	public void addToLog() {
		ArrayList<String> list = getCurrentLogs();

		if(browserType.equals(BrowserType.CHROME)) {
			if(consoleLogs.isEmpty() && list.isEmpty()) {
				int pos = 0;
				boolean isEqual = false;
				int maxSize = consoleLogs.size() < list.size() ? consoleLogs.size() : list.size();

				for(int i = 0; i < maxSize; i++) {
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

				for(int i = pos; i < list.size(); i++) {
					consoleLogs.add(list.get(i));
					logger.info(list.get(i));
				}
			} else {
				for(String log : list) {
					consoleLogs.add(log);
					logger.info(log);
				}
			}
		}
	}

	public boolean isSelected(By webElement) {
		return driver.findElement(webElement).isSelected();
	}

	public boolean isOnScreen(By by) {
		return isOnScreen(by, -1);
	}

	public boolean isOnScreen(By by, int percentage) {
		boolean result = false;

		waitForLoadToComplete();

		try {
			setTimeouts(shortWait);

			WebElement el = driver.findElement(by);

			setTimeouts();

			result = isOnScreen(el, percentage);
		} catch(NoSuchElementException | TimeoutException e) {
			logger.info("Error trying to find element of screen"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));
		}

		return result;
	}

	public boolean isOnScreen(WebElement webElement) {
		return isOnScreen(webElement, -1);
	}

	public boolean isOnScreen(WebElement webElement, int percentage) {
		boolean result = false;

		waitForLoadToComplete();

		try {
			Rectangle rect = new Rectangle(webElement.getLocation(), webElement.getSize());
			Dimension windowSize = getWindowSize();
			Dimension windowOffset = getWindowOffset();

			Rectangle visibleRect = new Rectangle(0, 0, 0, 0);

			if(rect.x - windowOffset.width > windowSize.width || (rect.x - windowOffset.width) + rect.width < 0) {
				visibleRect.setWidth(0);
			} else {
				visibleRect.setWidth(Math.min((rect.x - windowOffset.width) + rect.width, windowSize.width) - Math.max(rect.x - windowOffset.width, 0));
			}

			if(rect.y - windowOffset.height > windowSize.height || (rect.y - windowOffset.height) + rect.height < 0) {
				visibleRect.setHeight(0);
			} else {
				visibleRect.setHeight(Math.min((rect.y - windowOffset.height) + rect.height, windowSize.height) - Math.max(rect.y - windowOffset.height, 0));
			}

			if(percentage < 0 && visibleRect.height > 0 && visibleRect.width > 0) {
				result = true;
			} else {
				Double elementArea = (double) rect.width * (double) rect.height;
				Double visibleArea = (double) visibleRect.width * (double) visibleRect.height;

				if((int) (visibleArea / elementArea * 100) >= percentage) {
					result = true;
				}
			}
		} catch(TimeoutException | NullPointerException | NoSuchElementException | StaleElementReferenceException e) {
			logger.info("Error trying to find element of screen"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));
		}

		return result;
	}

	public boolean isClickable(By by) {
		boolean result = false;

		waitForLoadToComplete();

		try {
			setTimeouts(shortWait);

			WebElement el = driver.findElement(by);

			setTimeouts();

			result = isClickable(el);
		} catch(WebDriverException e) {
			logger.info("Error trying to find if element is clickable"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));
		}

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
		} catch(TimeoutException | NullPointerException | NoSuchElementException | StaleElementReferenceException e) {
			logger.info("Error trying to find if element is clickable"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));
		}

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
		} catch( NullPointerException | WebDriverException e) {
			logger.info("Error trying to find if element is present"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));}

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

		logger.begin();
		value = isPresent(by);
		if(value) click(by);
		logger.end();

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

		logger.begin();
		value = isClickable(by);
		if(value) click(by);
		logger.end();

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
		logger.begin();
		Set<String> result = driver.getWindowHandles();
		logger.end();

		return result;
	}

	public String getMainWindowHandle() {
		logger.begin();
		String result = driver.getWindowHandle();
		logger.end();

		return result;
	}

	public void moveToSecondWindow(String mainFrameWindowHandle) {
		logger.begin();
		Set<String> handles = driver.getWindowHandles();

		handles.forEach(p -> {
			if(!p.equals(mainFrameWindowHandle)) {
				driver.switchTo().window(p);
				driver.manage().window().maximize();
			}
		});

		logger.end();
	}

	public void closeSecondWindow(String mainFrameWindowHandle) {
		logger.begin();
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

		logger.end();
	}

	public void moveToWindow(String windowHandle) {
		logger.begin();
		driver.switchTo().window(windowHandle);
		logger.end();
	}
	// endregion

	// region Screenshots
	public byte[] getFullScreenshot() {
		logger.begin();
		byte[] screenshot = null;

		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			if(BrowserType.SAFARI.equals(browserType) ||
				BrowserType.SAFARI_IPHONE.equals(browserType) ||
				BrowserType.SAFARI_IPAD.equals(browserType)) {
				logger.info("Cropping screenshot");

				int screenshotWidth = ImageUtils.byteToBuffImage(screenshot).getWidth();
				int screenshotHeight = ImageUtils.byteToBuffImage(screenshot).getHeight();

				logger.info("Offset: " + getWindowOffset().getWidth() + " " + getWindowOffset().getHeight());
				logger.info("Dimmensions: " + getWindowSize().getWidth() + " " + getWindowSize().getHeight());
				screenshot = ImageUtils.cropImage(screenshot, getWindowOffset().getWidth(), getWindowOffset().getHeight(), Math.min(getWindowSize().getWidth(), screenshotWidth), Math
					.min(getWindowSize().getHeight(), screenshotHeight));
			}
		} catch(Exception e) {
			logger.error("Ha habido un problema obteniendo la imagen");
		}

		logger.end();
		return screenshot;
	}

	public byte[] takeScreenshot(String fileName, String directory) {
		logger.begin();
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
			logger.error("Ha habido un problema obteniendo la imagen");
		}

		logger.end();
		return screenshot;
	}

	public byte[] takeScreenshot(int x, int y, int w, int h) {
		return takeScreenshot("", x, y, w, h);
	}

	public byte[] takeScreenshot(String screenshotName, int x, int y, int w, int h) {
		logger.begin();
		byte[] screenshot = null;
		String fileName = screenshotName;

		if(!screenshotName.isEmpty()) {
			if(!screenshotName.contains("/") && !screenshotName.contains("\\")) {
				screenshotName = "./" + screenshotName;
			} else {
				File folder = new File(screenshotName.substring(0, screenshotName.lastIndexOf('/')));
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
			
			if(w + x > windowSize.width) {
				w = windowSize.width - x;
			} else if(w + x < 0) {
				w = 0;
			}
			
			if(h + y > windowSize.height) {
				h = windowSize.height - y;
			} else if(w + x < 0) {
				h = 0;
			}

			screenshot = ImageUtils.cropImage(screenshot, x, y, w, h);

			if(!screenshotName.isEmpty()) {
				ImageUtils.writeByteImageToFile(screenshot, fileName);
			}
		} catch(Exception e) {
			logger.error("There has been an error obtaining the image");
		}

		logger.begin();
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
				String[] bounds = StringUtils.stringToArray(el, "bounds=\"[", "]\" ")[0].replaceAll("\\]\\[", ",").split(",");

				String locator = el.contains("resource-id") ? StringUtils.stringToArray(el, "resource-id=\"", "\" ")[0] + "[" + StringUtils.stringToArray(el, "instance=\"", "\"")[0] + "]"
					: StringUtils.stringToArray(el, "class=\"", "\" ")[0] + "[" + StringUtils.stringToArray(el, "instance=\"", "\"")[0] + "]";

				locator = locator.replace("android:id/", "");

				takeScreenshot(path + activity + " - " + locator, Integer.parseInt(bounds[0]), Integer.parseInt(bounds[1]), Integer.parseInt(bounds[2])
					- Integer.parseInt(bounds[0]), Integer.parseInt(bounds[3]) - Integer.parseInt(bounds[1]));
			}
		}
	}
	// endregion

	// region Android
	@SuppressWarnings("rawtypes")
	public void sendAndroidKey(AndroidKey androidKey) {
		((AndroidDriver) driver).pressKey(new KeyEvent(androidKey));
	}

	@SuppressWarnings("rawtypes")
	public boolean isAndroidKeyboardShown() {
		return ((AndroidDriver) driver).isKeyboardShown();
	}

	@SuppressWarnings("rawtypes")
	public void hideAndroidKeyboard() {
		((AndroidDriver) driver).hideKeyboard();
	}

	@SuppressWarnings("rawtypes")
	public void scrollDropdownAndroid(By by, String selection) {
		MobileElement me = (MobileElement) waitForElementToBeClickable(by);
		int x = me.getCenter().x;
		int y = me.getCenter().y;

		TouchAction touchAction = new TouchAction((MobileDriver) driver);
		touchAction.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(0, 50)).release();
		((PerformsTouchActions) driver).performTouchAction(touchAction);
	}

	@SuppressWarnings("rawtypes")
	public void clickAndHold(By by, long duration) {
		MobileElement me = (MobileElement) waitForElementToBeClickable(by);
		Point center = me.getCenter();

		TouchAction touchAction = new TouchAction((MobileDriver) driver);
		touchAction.press(PointOption.point(center.x, center.y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).release();
		((PerformsTouchActions) driver).performTouchAction(touchAction);
	}
	// endregion

	// region Alerts
	public boolean alertIsPresent() {
		boolean result = false;

		try {
			driver.switchTo().alert().getText();

			exitFrame();

			result = true;
		} catch(Exception e) {
			logger.info("Error trying to get alert present state");
		}

		return result;
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();

		String text = alert.getText();

		exitFrame();

		return text;
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();

		alert.accept();

		exitFrame();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();

		alert.dismiss();

		exitFrame();
	}
	// endregion

	// region Cookies
	public Cookie getCookie(String cookieName) {
		return driver.manage().getCookieNamed(cookieName);
	}

	public Set<Cookie> getCookies() {
		return driver.manage().getCookies();
	}

	public void addCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	public void cleanCookies() {
		driver.manage().deleteAllCookies();
	}

	public void deleteCookie(Cookie cookie) {
		driver.manage().deleteCookie(cookie);
	}

	public void deleteCookieByName(String cookieName) {
		driver.manage().deleteCookieNamed(cookieName);
	}
	// endregion
}