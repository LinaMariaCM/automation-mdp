package com.amaris.automation.model.webdriver.configuration;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class ChromeConfiguration extends BrowserConfiguration {

	private List<String> pluginFiles = new ArrayList<>();

	public void setPluginFile(List<String> pluginFiles) {
		this.pluginFiles = pluginFiles;
	}

	public static void downloadDriver(boolean forceCache) {
		BrowserManager manager = ChromeDriverManager.getInstance();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

	public ChromeOptions createOptions() {
		debugBegin();

		LoggingPreferences prefs = new LoggingPreferences();
		prefs.enable(LogType.PERFORMANCE, Level.INFO);

		ChromeOptions options = new ChromeOptions();

		for(String fileName : pluginFiles) {
			if(!fileName.contains("\\.")) {
				fileName += ".crx";
			}

			options.addExtensions(new File(System.getProperty("user.dir") + '/' + fileName));
		}

		options.setCapability(CapabilityType.LOGGING_PREFS, prefs);
		options.addArguments("disable-popup-blocking");
		options.addArguments("--enable-strict-powerful-feature-restrictions");
		options.addArguments("--disable-geolocation");

		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.managed_default_content_settings.geolocation", 2);
		options.setExperimentalOption("prefs", chromePrefs);

		if(language != null) {
			options.addArguments("--lang=" + language);
		}

		if(headless) {
			options.addArguments("-headless");
			options.addArguments("--disable-gpu");
		}

		if(useProxy) {
			DesiredCapabilities proxyCapabilities = new DesiredCapabilities();
			proxyCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
			proxyCapabilities.setAcceptInsecureCerts(true);

			options.merge(proxyCapabilities);
		}

		debugEnd();

		return options;
	}
}
