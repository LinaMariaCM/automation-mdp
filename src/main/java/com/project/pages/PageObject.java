package com.project.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestCaseData;
import com.automation.model.webdriver.DriverHelper;

public class PageObject {
	
	private String testId;
	private TestCaseData tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	// region WebElements
	private By webElement = By.cssSelector("");
	
	// endregion

	public PageObject(DriverHelper driver, TestCaseData data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region Methods
	public PageObject someMethod() {
		logger.info("BEGIN - someMethod");

		logger.info("END - someMethod");
		return this;
	}
	// endregion
}
