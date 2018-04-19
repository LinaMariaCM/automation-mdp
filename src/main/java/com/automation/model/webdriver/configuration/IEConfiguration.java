package com.automation.model.webdriver.configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;

import io.github.bonigarcia.wdm.BrowserManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class IEConfiguration implements IBrowserObject {
	
	private DesiredCapabilities desiredCapabilities;
	private DataObject config;
	private String driverPath = "C:\\Program Files (x86)\\Microsoft Web Driver\\";
	final static Logger logger = LoggerFactory.getLogger(IEConfiguration.class);

	public IEConfiguration(DataObject config) throws IOException {
		this.config = config;
		this.desiredCapabilities = createDesiredCapabilities();
	}
	
	public static void downloadDriver(boolean forceCache) {
		logger.debug("[BEGIN] - Starting BrowserManager setup");
		BrowserManager manager = InternetExplorerDriverManager.getInstance();

		if(manager != null) {
			if(forceCache) manager.forceCache();
			manager.setup();
		}
		
		logger.debug("[ END ] - BrowserManager setup finished");
	}

	public Proxy createProxy() {
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.SYSTEM);
		
		return proxy;
	}

	public static DesiredCapabilities createDesiredCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		//if(!Boolean.valueOf(this.config.getValue(ProjectConstants.REMOTE_MODE))) cap.setCapability(InternetExplorerOptions.CAPABILITY, createIEOptions());
		cap.setCapability("disable-popup-blocking", true);
		cap.setCapability("--start-maximized", true);
		cap.setJavascriptEnabled(true);
		
		/*String proxyIp = "110.164.156.194";
		String proxyPort = "8080";
		
		String proxyAddress = proxyIp + ":" + proxyPort;
		
		Proxy proxy = new Proxy();
		
		proxy.setHttpProxy(proxyAddress)
			.setFtpProxy(proxyAddress)
			.setSslProxy(proxyAddress);
		
		cap.setCapability(CapabilityType.PROXY, proxy);*/
		
		return cap;
	}

	public static InternetExplorerOptions createIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.addCommandSwitches("disable-popup-blocking");
		options.addCommandSwitches("--start-maximized");
		
		
		return options;
	}

	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		
		if(Boolean.valueOf(this.config.getValue(AutomationConstants.REMOTE_MODE))) {
			return this.startIEInRemoteDriver();
		} else {
			return new InternetExplorerDriver(this.desiredCapabilities);
		}
	}
	
	public WebDriver startIEInRemoteDriver() throws MalformedURLException {
		WebDriver driver = new ReusableRemoteWebDriver(new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"),
				this.desiredCapabilities);
		return driver;
	}

}
