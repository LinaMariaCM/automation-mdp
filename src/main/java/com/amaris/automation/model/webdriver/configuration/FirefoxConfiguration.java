package com.amaris.automation.model.webdriver.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class FirefoxConfiguration extends BrowserConfiguration {

	private List<String> pluginFiles = new ArrayList<>();

	public void setPluginFile(List<String> pluginFiles) {
		this.pluginFiles = pluginFiles;
	}

	public static void downloadDriver(boolean forceCache) {
		WebDriverManager manager = WebDriverManager.firefoxdriver();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

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

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);

		for(String fileName : pluginFiles) {
			if(!fileName.contains("\\.")) {
				fileName += ".xpi";
			}

			profile.addExtension(new File(System.getProperty("user.dir") + '/' + fileName));
		}

		options.setProfile(profile);

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
