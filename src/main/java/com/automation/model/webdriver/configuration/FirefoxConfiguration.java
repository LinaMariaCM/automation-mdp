package com.automation.model.webdriver.configuration;

import java.util.logging.Level;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FirefoxConfiguration extends BrowserConfiguration {

	public static void downloadDriver(boolean forceCache) {
		BrowserManager manager = FirefoxDriverManager.getInstance();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

	/*
	 * public static DesiredCapabilities createDesiredCapabilities(boolean headless) { 
	 * DesiredCapabilities cap = DesiredCapabilities.firefox();
	 * cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, createOptions(headless));
	 * 
	 * return cap; }
	 */

	public FirefoxOptions createOptions() {
		debugBegin();

		FirefoxOptions options = new FirefoxOptions();

		options.addArguments("--start-maximized");

		options.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.WARNING));

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
