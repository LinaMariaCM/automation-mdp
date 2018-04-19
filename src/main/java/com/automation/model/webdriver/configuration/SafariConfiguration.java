package com.automation.model.webdriver.configuration;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;

public class SafariConfiguration implements IBrowserObject {

	private DataObject config;
	private DesiredCapabilities desiredCapabilities;

	public SafariConfiguration(DataObject config) throws IOException {
		this.config = config;
		this.desiredCapabilities = SafariConfiguration.createDesiredCapabilities();
	}

	@Override
	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		return new ReusableRemoteWebDriver(
			new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"), this.desiredCapabilities);
	}

	public static DesiredCapabilities createDesiredCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		capabilities.setPlatform(Platform.MAC);
		capabilities.setBrowserName("safari");
		capabilities.setVersion("10");
		
		return capabilities;
	}

	public static SafariOptions createSafariOptions() {
		SafariOptions options = new SafariOptions();
		
		return options;
	}

}
