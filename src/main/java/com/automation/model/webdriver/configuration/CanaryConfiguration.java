package com.automation.model.webdriver.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.model.webdriver.configuration.IBrowserObject;
import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class CanaryConfiguration implements IBrowserObject {
	
	private DataObject config;
	private DesiredCapabilities desiredCapabilities;

	public CanaryConfiguration(DataObject config) throws IOException {
		this.config = config;
		this.desiredCapabilities = this.createDesiredCapabilities();

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
			//this.configurationProperties.updateValue("ServiceURL", url);

			WebDriver driver = new ReusableRemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

			String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
			updateValue(AutomationConstants.SESSION_ID, sessionId);

			return driver;
		} else {
			WebDriver driver = new ReusableRemoteWebDriver(this.config.getValue(AutomationConstants.SESSION_ID), 
				new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"), this.desiredCapabilities);

			driver.get("https://groups.google.com/forum/#!topic/webdriver/sFdorYY9IQ4");
			driver.findElement(By.xpath(".//*[text()='Iniciar sesión']")).click();

			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return driver;
		}
	}

	private DesiredCapabilities createDesiredCapabilities() throws IOException {
		DesiredCapabilities desiredCapabilitiesLocal = DesiredCapabilities.chrome();
		desiredCapabilitiesLocal.setCapability(ChromeOptions.CAPABILITY, this.createChromeOptions());
		
		return desiredCapabilitiesLocal;
	}

	/*private DesiredCapabilities createDesiredCapabilities(Proxy proxy) throws IOException {
		DesiredCapabilities desiredCapabilitiesLocal = DesiredCapabilities.chrome();
		desiredCapabilitiesLocal.setCapability(CapabilityType.PROXY, proxy);
		desiredCapabilitiesLocal.setCapability(ChromeOptions.CAPABILITY, this.createChromeOptions());
		
		return desiredCapabilitiesLocal;
	}*/

	private ChromeOptions createChromeOptions() throws IOException {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("disable-popup-blocking");
		options.addArguments("--headless");
		// options.addArguments("--disable-gpu");
		// options.addArguments("--remote-debugging-port=9222");
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

		if(this.config.getValue(AutomationConstants.FILE_DOWNLOAD_TEMP) != null) {
			preferences.put("download.default_directory",this.config.getValue(AutomationConstants.FILE_DOWNLOAD_TEMP));
		}
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
