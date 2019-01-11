package com.automation.model.webdriver.configuration;

import org.openqa.selenium.MutableCapabilities;

import com.automation.model.utils.objects.DebugLogger;

public abstract class BrowserConfiguration {

	protected boolean headless = false;
	protected String language = null;
	protected DebugLogger logger = new DebugLogger().setVerbose(false);
	
	public BrowserConfiguration() {}
	
	public BrowserConfiguration(String id) { logger.setId(id);}
	
	public void setHeadless(boolean value) {
		headless = value;
	}
	
	public void setLanguage(String value) {
		language = value;
	}

	public static void downloadDriver(boolean forceCache) {}

	public abstract MutableCapabilities createOptions();
	
	public void debugBegin() {
		logger.begin();
	}
	
	public void debugEnd() {
		logger.end();
	}
	
	public void debugInfo(String message) {
		logger.info(message);
	}
}
