package com.automation.model.webdriver.configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ChromeConfiguration extends BrowserConfiguration {

	private ArrayList<String> pluginFiles = new ArrayList<>();

	public void setPluginFile(ArrayList<String> pluginFiles) {
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

			options.addExtensions(new File(System.getProperty("user.dir") + "/" + fileName));
		}

		options.addArguments("disable-popup-blocking");
		options.setCapability(CapabilityType.LOGGING_PREFS, prefs);

		if(language != null) {
			options.addArguments("--lang=" + language);
		}

		if(headless) {
			options.addArguments("-headless");
			options.addArguments("--disable-gpu");
		}

		debugEnd();

		return options;
	}
}
