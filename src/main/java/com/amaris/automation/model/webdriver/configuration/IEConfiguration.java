package com.amaris.automation.model.webdriver.configuration;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEConfiguration extends BrowserConfiguration {

	public static void downloadDriver(boolean forceCache) {
		BrowserManager manager = InternetExplorerDriverManager.getInstance();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

	public InternetExplorerOptions createOptions() {
		debugBegin();

		InternetExplorerOptions options = new InternetExplorerOptions();

		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		options.setCapability("unexpectedAlertBehaviour", "accept");
		options.setCapability("disable-popup-blocking", true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.destructivelyEnsureCleanSession();
		options.enablePersistentHovering();
		options.ignoreZoomSettings();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.requireWindowFocus();
		options.addCommandSwitches("disable-popup-blocking");
		options.addCommandSwitches("--start-fullscreen");

		if(useProxy) {
			DesiredCapabilities proxyCapabilities = new DesiredCapabilities();
			proxyCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

			options.merge(proxyCapabilities);
		}

		debugEnd();

		return options;
	}
}
