package com.automation.model.webdriver.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.webdriver.configuration.IBrowserObject;
import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MobileConfiguration implements IBrowserObject {
	
	private DataObject config;
	private DesiredCapabilities desiredCapabilities;
	final static Logger logger = LoggerFactory.getLogger(MobileConfiguration.class);

	public MobileConfiguration(String browserType, DataObject config) throws IOException {
		this.config = config;
		this.desiredCapabilities = MobileConfiguration.createDesiredCapabilities(browserType);

		// This function is available by the use of a maven plugin that
		// downloads the chrome webdriver
		// https://github.com/bonigarcia/webdrivermanager
		BrowserManager manager = ChromeDriverManager.getInstance();
		manager.forceCache();
		manager.setup();
	}

	@Override
	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		if(Boolean.valueOf(this.config.getValue(AutomationConstants.REMOTE_MODE))) {
			return this.startChromeInDebugMode();
		} else {
			return new ChromeDriver(this.desiredCapabilities);
		}
	}

	private WebDriver startChromeInDebugMode() throws IOException {
		if(this.config.getValue(AutomationConstants.SESSION_ID).equals("")) {
			ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
				.usingAnyFreePort().build();
			
			service.start();

			String url = service.getUrl().toString();

			updateValue(AutomationConstants.IP, url.substring(url.indexOf(':')));
			updateValue(AutomationConstants.PORT, url.substring(url.indexOf(':') + 1, url.indexOf('/')));

			WebDriver driver = new ReusableRemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

			String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
			updateValue(AutomationConstants.SESSION_ID, sessionId);

			return driver;
		} else {
			WebDriver driver = new ReusableRemoteWebDriver(this.config.getValue(AutomationConstants.SESSION_ID),
				new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"), this.desiredCapabilities);
			
			return driver;
		}
	}

	public static DesiredCapabilities createDesiredCapabilities(String browserType) {
		DesiredCapabilities desiredCapabilitiesLocal = DesiredCapabilities.chrome();

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", getMobileEmulationMap(browserType));

		desiredCapabilitiesLocal.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		return desiredCapabilitiesLocal;
	}

	public static ChromeOptions createMobileOptions(String browserType) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-popup-blocking");
		options.addArguments("--start-maximized");
		Map<String, Object> preferences = new Hashtable<>();
		options.setExperimentalOption("prefs", preferences);

		preferences.put("plugins.plugins_disabled", new String[]{ "Chrome PDF Viewer"});

		//options.setCapability("mobileEmulation", getMobileEmulationMap(browserType));
		options.setExperimentalOption("mobileEmulation", getMobileEmulationMap(browserType));

		return options;
	}
	
	private static Map<String, String> getMobileEmulationMap(String browserType) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();

		switch(browserType) {
			case BrowserType.GALAXYS5:
				logger.debug("MOBILE DEVICE: Galaxy S5");
				mobileEmulation.put("deviceName", "Galaxy S5");
				break;
			case BrowserType.NEXUS5X:
				logger.debug("MOBILE DEVICE: Nexus 5X");
				mobileEmulation.put("deviceName", "Nexus 5X");
				break;
			case BrowserType.NEXUS6P:
				logger.debug("MOBILE DEVICE: Nexus 6P");
				mobileEmulation.put("deviceName", "Nexus 6P");
				break;
			case BrowserType.IPHONE5:
				logger.debug("MOBILE DEVICE: iPhone 5");
				mobileEmulation.put("deviceName", "iPhone 5");
				break;
			case BrowserType.IPHONE6:
				logger.debug("MOBILE DEVICE: iPhone 6");
				mobileEmulation.put("deviceName", "iPhone 6");
				break;
			case BrowserType.IPHONE6PLUS:
				logger.debug("MOBILE DEVICE: iPhone 6 Plus");
				mobileEmulation.put("deviceName", "iPhone 6 Plus");
				break;
			case BrowserType.IPAD:
				logger.debug("MOBILE DEVICE: iPad");
				mobileEmulation.put("deviceName", "iPad");
				break;
			case BrowserType.IPADPRO:
				logger.debug("MOBILE DEVICE: iPad Pro");
				mobileEmulation.put("deviceName", "iPad Pro");
				break;
			default:
				logger.debug("FAILED TO RECOGNIZE PHONE TYPE");
		}
		
		return mobileEmulation;
	}

	private void updateValue(String propertyName, String propertyValue) throws IOException {
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
			.configure(new Parameters().properties().setFile(new File(AutomationConstants.CONFIGURATION_DATA_SET)));
		
		try {
			builder.getConfiguration().setProperty(propertyName, propertyValue);
			builder.save();
		} catch(ConfigurationException cex) {
			System.out.println("The configuration file: %s has not been accessed correctly");
		}
	}
}
