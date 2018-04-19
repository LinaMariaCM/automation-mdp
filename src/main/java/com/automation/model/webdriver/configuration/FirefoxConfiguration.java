package com.automation.model.webdriver.configuration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FirefoxConfiguration implements IBrowserObject {
	
	private DataObject config;
	private FirefoxProfile firefoxProfile;
	private DesiredCapabilities desiredCapabilities;
	final static Logger logger = LoggerFactory.getLogger(FirefoxConfiguration.class);

	public FirefoxConfiguration(DataObject config) throws IOException {		
		this.config = config;
		this.firefoxProfile = this.createFirefoxProfile();
		
		this.desiredCapabilities = FirefoxConfiguration.createDesiredCapabilities(false);
	}
	
	public static void downloadDriver(boolean forceCache) {
		logger.debug("[BEGIN] - Starting BrowserManager setup");
		BrowserManager manager = FirefoxDriverManager.getInstance();
		
		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
		
		logger.debug("[ END ] - BrowserManager setup finished");
	}

	@Override
	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		if(Boolean.valueOf(this.config.getValue(AutomationConstants.REMOTE_MODE))) {
			return startFirefoxInRemoteMode();

		} else {
			return new FirefoxDriver(new FirefoxOptions().setBinary(new FirefoxBinary()).setProfile(this.firefoxProfile));//.addCapabilities(this.desiredCapabilities));
		}
	}

	private WebDriver startFirefoxInRemoteMode() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		
		//desiredCapabilities.setBrowserName("firefox");
		//NUEVO
		//if(new GetOS().isWindows()) System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + ProjectConstants.RESOURCES_FOLDER + "\\gecko\\geckodriver.exe");
		//else System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/" + ProjectConstants.RESOURCES_FOLDER + "/gecko/geckodriver");
		/*
		if(new GetOS().isWindows()) {
			if(System.getenv("ProgramFiles(x86)") != null) System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\" + ProjectConstants.RESOURCES_FOLDER + "\\gecko\\0.18.0\\windows64\\geckodriver.exe");
			else System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\" + ProjectConstants.RESOURCES_FOLDER + "\\gecko\\0.18.0\\windows32\\geckodriver.exe");
		} else {
			if(System.getProperty("os.arch").indexOf("64") != -1) System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/" + ProjectConstants.RESOURCES_FOLDER + "/gecko/0.18.0/linux64/geckodriver");
			else System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/" + ProjectConstants.RESOURCES_FOLDER + "/gecko/0.18.0/linux32/geckodriver");
		}*/

		// System.setProperty("webdriver.gecko.driver","/Users/amaris/Downloads");

		// desiredCapabilities.setCapability("marionette", true);
		// desiredCapabilities.setCapability("binary",
		// this.configurationProperties.firefoxMacPath);
		// desiredCapabilities.setPlatform(Platform.MAC);
		// WebDriver driver = new ReusableRemoteWebDriver(new
		// URL(this.configurationProperties.serviceURL),
		// DesiredCapabilities.firefox());

		
		//WebDriver driver = new ReusableRemoteWebDriver(new URL(this.configurationProperties.serviceURL), desiredCapabilities);
		WebDriver driver = new ReusableRemoteWebDriver(
			new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"), desiredCapabilities);

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		} catch(Exception e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static DesiredCapabilities createDesiredCapabilities(boolean headless) {
		//System.setProperty("webdriver.gecko.driver","~/Gecko/geckodriver");
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, createFirefoxOptions(headless));
		
		/*FirefoxProfile firefoxProfile = new FirefoxProfile();
        //Then add the proxy setting to the Firefox profile we created
        firefoxProfile.setPreference("network.proxy.http", "110.164.156.194");
        firefoxProfile.setPreference("network.proxy.http_port", "8080");
        
        cap.setCapability("requiredCapabilities", firefoxProfile);*/
		
		return cap;
	}

	public static FirefoxOptions createFirefoxOptions(boolean headless) {
		FirefoxOptions options = new FirefoxOptions();
		
		options.addArguments("--start-maximized");
		if(headless) options.addArguments("-headless");
		
		return options;
	}

	public DesiredCapabilities createDesiredCapabilities(Proxy proxy) {
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.PROXY, proxy);
		
		return cap;
	}

	public FirefoxProfile createFirefoxProfile() {
		URL location = this.getClass().getResource("/firebug-2.0.17-fx.xpi");
		String FullPath = location.getPath();

		File file = new File(FullPath);
		// InputStream inputStreamFromFile =
		// this.getClass().getResourceAsStream(this.properties.firebugAddingFileNameAndPath);

		// MarionetteDriverManager.getInstance().setup();
		BrowserManager manager = FirefoxDriverManager.getInstance();
		manager.forceCache();
		manager.setup();
		
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		if(Boolean.valueOf(this.config.getValue(AutomationConstants.FIREFOX_ENABLE_FIREBUG))) {
			firefoxProfile.addExtension(file);

			firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.17-fx");
			firefoxProfile.setPreference("extensions.firebug.showStackTrace", true);
			firefoxProfile.setPreference("extensions.firebug.delayLoad", false);
			firefoxProfile.setPreference("extensions.firebug.showFirstRunPage", false);
			firefoxProfile.setPreference("extensions.firebug.allPagesActivation", "off");
			firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
			firefoxProfile.setPreference("extensions.firebug.defaultPanelName", "console");
			firefoxProfile.setPreference("pdfjs.disabled", true);

			firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
			firefoxProfile.setPreference("plugin.scan.plid.all", false);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile", "text/csv, application/pdf,application/octet-stream");
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
			firefoxProfile.setPreference("browser.download.manager.useWindow", false);
			firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
			firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);

			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			
			if(this.config.getValue(AutomationConstants.FILE_DOWNLOAD_TEMP) != null) {
				firefoxProfile.setPreference("browser.download.dir", Paths.get(this.config.getValue(AutomationConstants.FILE_DOWNLOAD_TEMP)).toString());
			}

			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip, text/csv, application/pdf,application/octet-stream");

			// firefoxProfile.setEnableNativeEvents(true);
		}
		
		return firefoxProfile;
	}
}
