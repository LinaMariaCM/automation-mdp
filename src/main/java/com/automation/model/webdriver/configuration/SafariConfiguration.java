package com.automation.model.webdriver.configuration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class SafariConfiguration extends BrowserConfiguration {

	private String version = "10";
	private boolean technologyPreview = true;

	public void setVersion(String version) {
		this.version = version;
	}

	public void setTechnologyPreview(boolean technologyPreview) {
		this.technologyPreview = technologyPreview;
	}

	public static void downloadDriver(boolean forceCache) {}

	public DesiredCapabilities createDesiredCapabilities() {
		debugBegin();
		
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		capabilities.setPlatform(Platform.MAC);

		if(technologyPreview) {
			capabilities.setBrowserName("Safari Technology Preview");
		} else {
			capabilities.setBrowserName("Safari");
		}

		capabilities.setVersion(version);

		// BrowserStack
		// capabilities.setCapability("browserstack.local", "false");
		// capabilities.setCapability("browserstack.selenium_version", "3.12");
		// capabilities.setCapability("browserstack.user", "john3937");
		// capabilities.setCapability("browserstack.key",
		// "nKLznfQapSsRkzHq3dyq");

		debugEnd();
		
		return capabilities;
	}

	public SafariOptions createOptions() {
		debugBegin();

		SafariOptions options = new SafariOptions();

		options.setCapability("os", "OS X");
		options.setCapability("technologyPreview", technologyPreview);
		// options.setCapability("os_version", "High Sierra");
		// options.setCapability("browserstack.debug", "true");
		// options.setCapability("browser_version", "11.1.1");

		if(useProxy) {
			DesiredCapabilities proxyCapabilities = new DesiredCapabilities();
			proxyCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

			options.merge(proxyCapabilities);
		}

		debugEnd();

		return options;
	}
}