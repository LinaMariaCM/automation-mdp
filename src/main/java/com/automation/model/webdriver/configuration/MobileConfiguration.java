package com.automation.model.webdriver.configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class MobileConfiguration extends BrowserConfiguration {

	private boolean technologyPreview = true;
	private String browserType = BrowserType.GALAXYS5;
	private String emulationBrowser = BrowserType.CHROME;

	private ArrayList<String> pluginFiles = new ArrayList<>();

	public void setPluginFile(ArrayList<String> pluginFiles) {
		this.pluginFiles = pluginFiles;
	}

	public void setTechnologyPreview(boolean technologyPreview) {
		this.technologyPreview = technologyPreview;
	}

	public void setBrowserType(String value) {
		browserType = value;
	}

	public void setEmulationBrowser(String value) {
		emulationBrowser = value;
	}

	public static void downloadDriver(String emulationBrowser, boolean forceCache) {
		BrowserManager manager = null;

		if(emulationBrowser.equals(BrowserType.CHROME)) {
			manager = ChromeDriverManager.getInstance();
		} else if(emulationBrowser.equals(BrowserType.FIREFOX)) {
			manager = FirefoxDriverManager.getInstance();
		}

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
	}

	public MutableCapabilities createOptions() {
		debugBegin();

		MutableCapabilities options = null;

		debugInfo("Browser emulator: " + emulationBrowser + ", Browser type: " + browserType);
		if(emulationBrowser.equals(BrowserType.CHROME)) {
			options = new ChromeOptions();
			((ChromeOptions) options).addArguments("disable-popup-blocking");
			((ChromeOptions) options).addArguments("--start-maximized");

			for(String fileName : pluginFiles) {
				if(!fileName.contains("\\.")) {
					fileName += ".crx";
				}

				((ChromeOptions) options).addExtensions(new File(System.getProperty("user.dir") + "/" + fileName));
			}

			Map<String, Object> preferences = new Hashtable<>();
			((ChromeOptions) options).setExperimentalOption("prefs", preferences);

			preferences.put("plugins.plugins_disabled", new String[]{ "Chrome PDF Viewer"});

			((ChromeOptions) options).setExperimentalOption("mobileEmulation", getMobileEmulationMap(browserType));

			if(language != null) {
				((ChromeOptions) options).addArguments("--lang=" + language);
			}

			if(headless) {
				((ChromeOptions) options).addArguments("-headless");
				((ChromeOptions) options).addArguments("--disable-gpu");
			}
		} else if(emulationBrowser.equals(BrowserType.FIREFOX)) {
			String userAgent = "Mozilla/5.0 (" + browserType + "; U; CPU iPhone OS 3_0 like Mac OS X; en-us)"
				+ "AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";

			options = new FirefoxOptions();
			((FirefoxOptions) options).addArguments("--start-maximized");
			((FirefoxOptions) options).addArguments("--disable-notifications");

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("geo.enabled", true);
			profile.setPreference("geo.provider.use_corelocation", true);
			profile.setPreference("geo.prompt.testing", true);
			profile.setPreference("geo.prompt.testing.allow", true);
			profile.setPreference("general.useragent.override", userAgent);

			((FirefoxOptions) options).setProfile(profile);

			if(language != null) {
				((FirefoxOptions) options).addArguments("--lang=" + language);
			}

			if(headless) {
				((FirefoxOptions) options).addArguments("-headless");
				((FirefoxOptions) options).addArguments("--disable-gpu");
			}
		} else if(emulationBrowser.equals(BrowserType.SAFARI) || emulationBrowser.equals(BrowserType.SAFARI_IPAD)
			|| emulationBrowser.equals(BrowserType.SAFARI_IPHONE)) {
			options = new SafariOptions();

			options.setCapability("os", "OS X");
			options.setCapability("technologyPreview", technologyPreview);
		}

		debugEnd();

		return options;
	}

	private Map<String, String> getMobileEmulationMap(String browserType) {
		debugBegin();
		Map<String, String> mobileEmulation = new HashMap<>();

		switch(browserType) {
			case BrowserType.GALAXYS5:
				debugInfo("MOBILE DEVICE: Galaxy S5");
				mobileEmulation.put("deviceName", "Galaxy S5");
				break;
			case BrowserType.NEXUS5X:
				debugInfo("MOBILE DEVICE: Nexus 5X");
				mobileEmulation.put("deviceName", "Nexus 5X");
				break;
			case BrowserType.NEXUS6P:
				debugInfo("MOBILE DEVICE: Nexus 6P");
				mobileEmulation.put("deviceName", "Nexus 6P");
				break;
			case BrowserType.IPHONE5:
				debugInfo("MOBILE DEVICE: iPhone 5");
				mobileEmulation.put("deviceName", "iPhone 5");
				break;
			case BrowserType.IPHONE6:
				debugInfo("MOBILE DEVICE: iPhone 6");
				mobileEmulation.put("deviceName", "iPhone 6");
				break;
			case BrowserType.IPHONE6PLUS:
				debugInfo("MOBILE DEVICE: iPhone 6 Plus");
				mobileEmulation.put("deviceName", "iPhone 6 Plus");
				break;
			case BrowserType.IPAD:
				debugInfo("MOBILE DEVICE: iPad");
				mobileEmulation.put("deviceName", "iPad");
				break;
			case BrowserType.IPADPRO:
				debugInfo("MOBILE DEVICE: iPad Pro");
				mobileEmulation.put("deviceName", "iPad Pro");
				break;
			default:
				debugInfo("FAILED TO RECOGNIZE PHONE TYPE");
		}

		debugEnd();

		return mobileEmulation;
	}
}
