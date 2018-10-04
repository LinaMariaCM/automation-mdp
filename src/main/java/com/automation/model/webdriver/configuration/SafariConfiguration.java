package com.automation.model.webdriver.configuration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class SafariConfiguration {

	public static DesiredCapabilities createDesiredCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		capabilities.setPlatform(Platform.MAC);
		capabilities.setBrowserName("safari");
		capabilities.setVersion("10");

		// BrowserStack
		capabilities.setCapability("browserstack.local", "false");
		capabilities.setCapability("browserstack.selenium_version", "3.12");
		capabilities.setCapability("browserstack.user", "john3937");
		capabilities.setCapability("browserstack.key", "nKLznfQapSsRkzHq3dyq");
		return capabilities;
	}

	public static SafariOptions createSafariOptions() {
		SafariOptions options = new SafariOptions();

		options.setCapability("os", "OS X");
		// options.setCapability("os_version", "High Sierra");
		options.setCapability("browserstack.debug", "true");
		// options.setCapability("browser_version", "11.1.1");

		return options;
	}
}