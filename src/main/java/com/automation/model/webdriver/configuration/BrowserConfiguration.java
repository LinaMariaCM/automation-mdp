package com.automation.model.webdriver.configuration;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.MutableCapabilities;
import com.automation.model.utils.objects.DebugLogger;
import org.openqa.selenium.Proxy;

import java.net.*;

public abstract class BrowserConfiguration {

	protected Proxy seleniumProxy;
	protected String language = null;
	protected boolean headless = false;
	protected boolean useProxy = false;
	protected DebugLogger logger = new DebugLogger().setVerbose(false);
	
	public BrowserConfiguration() {}
	
	public BrowserConfiguration(String id) { logger.setId(id);}
	
	public void setHeadless(boolean value) {
		headless = value;
	}
	
	public void setLanguage(String value) {
		language = value;
	}

	public void setProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public void createProxy(BrowserMobProxy proxy) {
		proxy.setTrustAllServers(true);
		proxy.start();

		seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

		try {
			String hostIp;

			try(final DatagramSocket socket = new DatagramSocket()){
				socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
				hostIp = socket.getLocalAddress().getHostAddress();
			}

			seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
			seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

	public void createProxy(BrowserMobProxy proxy, String proxyIP) {
		proxy.setTrustAllServers(true);
		proxy.start();

		seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		seleniumProxy.setHttpProxy(proxyIP + ":" + proxy.getPort());
		seleniumProxy.setSslProxy(proxyIP + ":" + proxy.getPort());

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
