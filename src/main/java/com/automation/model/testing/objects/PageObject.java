package com.automation.model.testing.objects;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.utils.objects.DebugLogger;
import com.automation.model.webdriver.DriverHelper;

public class PageObject {

	protected String testId;
	protected UserStory userS;
	protected DebugLogger logger;
	protected DriverHelper webDriver;
	protected TestDataManager testDataM;

	public PageObject(UserStory userStory) {
		this.userS = userStory;
		this.testDataM = userStory.getTestDataManager();
		this.webDriver = userS.getDriver();

		if(webDriver.getDriver() == null && !webDriver.getDriverType().equals(AutomationConstants.WEB)) {
			webDriver.initializeDriver();
		}
		
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
		logger = new DebugLogger(testId);
	}
	
	public PageObject(DriverHelper webDriver) {
		this.webDriver = webDriver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
		logger = new DebugLogger(testId);
	}
	
	public PageObject(DriverHelper webDriver, TestDataManager testDataManager) {
		this.testDataM = testDataManager;
		this.webDriver = webDriver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
		logger = new DebugLogger(testId);
	}
	
	// Get data methods
	protected DataObject getData(String key) {
		return testDataM.getData(key);
	}
	
	protected String getConfigVar(String key) {
		return testDataM.getConfigVar(key);
	}
	
	protected String getGlobalVar(String key) {
		return testDataM.getGlobalVar(key);
	}
	
	protected String getScenarioVar(String key) {
		String result = null;
		
		if(userS != null && userS.getScenario() != null) {
			result = testDataM.getScenarioVar(userS.getScenario(), key);
		}
		
		return result;
	}
	
	protected String getTestVar(String key) {
		return testDataM.getTestVar(webDriver.getId(), key);
	}
	
	protected String getVar(String rowKey, String key) {
		return testDataM.getVar(rowKey, key);
	}

	// Set data methods
	protected void setData(DataObject data, String key) {
		testDataM.addData(data, key);
	}
	
	protected void setConfigVar(String key, String value) {
		testDataM.setConfigVar(key, value);
	}
	
	protected void setGlobalVar(String key, String value) {
		testDataM.setGlobalVar(key, value);
	}
	
	protected void setScenarioVar(String key, String value) {
		testDataM.setScenarioVar(userS.getScenario(), key, value);
	}
	
	protected void setTestVar(String key, String value) {
		testDataM.setTestVar(webDriver.getId(), key, value);
	}

	// Print to console methods
	protected void debugBegin() {
		logger.begin();
	}
	
	protected void debugEnd() {
		logger.end();
	}
	
	protected void debugInfo(String message) {
		logger.info(message);
	}
	
	protected void debugError(String message) {
		logger.error(message);
	}
	
	protected void setDebugVerbose(boolean verbose) {
		logger.setVerbose(verbose);
	}
}
