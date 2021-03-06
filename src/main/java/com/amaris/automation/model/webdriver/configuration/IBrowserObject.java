package com.amaris.automation.model.webdriver.configuration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public interface IBrowserObject {

	WebDriver createWebDriverAndStartBrowser() throws IOException;
}
