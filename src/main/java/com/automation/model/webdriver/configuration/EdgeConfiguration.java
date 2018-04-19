package com.automation.model.webdriver.configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;

public class EdgeConfiguration implements IBrowserObject {
	
	private DesiredCapabilities desiredCapabilities;
	private DataObject config;
	//private String driverPath = "C:\\Windows\\SystemApps\\Microsoft.MicrosoftEdge_8wekyb3d8bbwe\\";
	private String driverPath = "C:\\Program Files (x86)\\Microsoft Web Driver\\";

	public EdgeConfiguration(DataObject config) throws IOException {
		this.config = config;
		this.desiredCapabilities = createDesiredCapabilities();
		
		/*BrowserManager manager = EdgeDriverManager.getInstance();
		manager.forceCache();
		manager.setup();*/
	}

	public Proxy createProxy() {
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.SYSTEM);
		
		return proxy;
	}

	public static DesiredCapabilities createDesiredCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.edge();
		//if(!Boolean.valueOf(this.config.getValue(ProjectConstants.REMOTE_MODE))) cap.setCapability(EdgeOptions.CAPABILITY, createEdgeOptions());
		//cap.setCapability(EdgeOptions.CAPABILITY, createEdgeOptions());
		
		return cap;
	}

	public static EdgeOptions createEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.setPageLoadStrategy("disable-popup-blocking");
		options.setPageLoadStrategy("--start-maximized");
		
		return options;
	}

	public WebDriver createWebDriverAndStartBrowser() throws IOException {
		System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
		
		if(Boolean.valueOf(this.config.getValue(AutomationConstants.REMOTE_MODE))) {
			return this.startEdgeInRemoteDriver();
		} else {
			return new EdgeDriver(this.desiredCapabilities);
		}
	}
	
	public WebDriver startEdgeInRemoteDriver() throws MalformedURLException {
		WebDriver driver = new ReusableRemoteWebDriver(new URL("http://" + this.config.getValue(AutomationConstants.IP) + ":" + this.config.getValue(AutomationConstants.PORT) + "/wd/hub"),
				this.desiredCapabilities);
		return driver;
	}

}
