package com.amaris.automation.model.testing.objects;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.webdriver.DriverHelper;

public class PageObject extends InteractionObject {

	protected DriverHelper webDriver;

	public PageObject() {
		super();
	}

	public PageObject(UserStory userStory) {
		super(userStory);

		this.webDriver = userS.getWebDriver();

		if(webDriver.getDriver() == null && !webDriver.getDriverType().equals(AutomationConstants.WEB)) {
			webDriver.initializeDriver();
		}
	}
}
