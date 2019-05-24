package com.amaris.automation.model.webdriver.configuration;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeConfiguration extends BrowserConfiguration {

	public static void downloadDriver(boolean forceCache) {
		BrowserManager manager = EdgeDriverManager.getInstance();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

	public EdgeOptions createOptions() {
		debugBegin();

		EdgeOptions options = new EdgeOptions();

		if(useProxy) {
			DesiredCapabilities proxyCapabilities = new DesiredCapabilities();
			proxyCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

			options.merge(proxyCapabilities);
		}

		debugEnd();

		return options;
	}
}