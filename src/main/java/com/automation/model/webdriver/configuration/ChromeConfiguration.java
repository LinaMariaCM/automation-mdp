package com.automation.model.webdriver.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.JavascriptExecutor;
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

public class ChromeConfiguration implements IBrowserObject {
	
	private DataObject config;
	private DesiredCapabilities desiredCapabilities;
	final static Logger logger = LoggerFactory.getLogger(ChromeConfiguration.class);

	@Override
	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		if(Boolean.valueOf(this.config.getValue(AutomationConstants.REMOTE_MODE))) {
			return this.startChromeInRemoteMode();
		} else {
			return new ChromeDriver(this.desiredCapabilities);
		}
	}
	
	public static void downloadDriver(boolean forceCache) {
		logger.debug("[BEGIN] - Starting BrowserManager setup");
		BrowserManager manager = ChromeDriverManager.getInstance();
		
		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
		
		logger.debug("[ END ] - BrowserManager setup finished");
	}

	private WebDriver startChromeInRemoteMode() throws IOException {
		if(this.config.getValue(AutomationConstants.SESSION_ID).equals("")) {
			ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
				.usingAnyFreePort().build();
			service.start();

			String url = service.getUrl().toString();

			updateValue(AutomationConstants.IP, url.substring(url.indexOf(':')));
			updateValue(AutomationConstants.PORT, url.substring(url.indexOf(':') + 1, url.indexOf('/')));
			//new ConfigurationProperties().updateValue("ServiceURL", url);

			WebDriver driver = new ReusableRemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

			String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
			updateValue(AutomationConstants.SESSION_ID, sessionId);

			return driver;
		} else {
			/*WebDriver driver = new ReusableRemoteWebDriver(this.configurationProperties.sessionID, new URL(this.configurationProperties.serviceURL),
				this.desiredCapabilities);*/
			WebDriver driver = new ReusableRemoteWebDriver(this.config.getValue(AutomationConstants.SESSION_ID), 
				new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"), this.desiredCapabilities);
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
			} catch(Exception e) {
				e.printStackTrace();
			}
			return driver;
		}
	}

	public static DesiredCapabilities createDesiredCapabilities(boolean headless) {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, createChromeOptions(headless));
		
		//CREACION DEL PROXY
		
		
		//cap.setCapability(CapabilityType.PROXY, value);
		
		/*String proxyIp = "110.164.156.194";
		String proxyPort = "8080";
		
		String proxyAddress = proxyIp + ":" + proxyPort;
		
		Proxy proxy = new Proxy();
		
		proxy.setHttpProxy(proxyAddress)
			.setFtpProxy(proxyAddress)
			.setSslProxy(proxyAddress);
		
		cap.setCapability(CapabilityType.PROXY, proxy);*/
		
		
		return cap;
	}

	/*private DesiredCapabilities createDesiredCapabilities(Proxy proxy) throws IOException, ConfigurationException {
		DesiredCapabilities desiredCapabilitiesLocal = DesiredCapabilities.chrome();
		desiredCapabilitiesLocal.setCapability(CapabilityType.PROXY, proxy);
		desiredCapabilitiesLocal.setCapability(ChromeOptions.CAPABILITY, this.createChromeOptions());
		
		return desiredCapabilitiesLocal;
	}*/

	public static ChromeOptions createChromeOptions(boolean headless) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-popup-blocking");
		
		if(headless) {
			options.addArguments("-headless");
			options.addArguments("--disable-gpu");
		}
		//options.addArguments("--no-sandbox");
		//options.addArguments("--window-size=1280,1696");
		options.addArguments("--start-maximized");
		Map<String, Object> preferences = new Hashtable<>();
		options.setExperimentalOption("prefs", preferences);

		// disable flash and the PDF viewer
		preferences.put("plugins.plugins_disabled", new String[]{ "Chrome PDF Viewer"});

		// set default download folder
		// File tempFolder = new
		// File(FileUtils.getTempDirectory().getAbsolutePath() +
		// "\\MutuaPropietarios\\");
		// this.configurationProperties.UpdateValue("fileDownloadPath",
		// tempFolder.getAbsolutePath());
		// FileUtils.forceMkdir(tempFolder);

		/*if(this.config.getValue(ProjectConstants.FILE_DOWNLOAD_TEMP) != null) {
			preferences.put("download.default_directory",this.config.getValue(ProjectConstants.FILE_DOWNLOAD_TEMP));
		}*/
		// options.setExperimentalOption("debuggerAddress", "127.0.0.1:11111");
		// options.addArguments("--test-type");
		// options.addArguments("--allow-running-insecure-content");
		// System.setProperty("webdriver.chrome.args", "--disable-logging");
		// System.setProperty("webdriver.chrome.silentOutput", "true");
		return options;
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
