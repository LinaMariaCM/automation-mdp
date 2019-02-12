package com.automation.model.testing.objects;

import com.automation.data.DataObject;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.utils.objects.DebugLogger;
import com.automation.model.webdriver.DriverHelper;

public class StepObject {

	protected String testId;
	protected UserStory userS;
	protected DebugLogger logger;
	
	public StepObject(UserStory userStory) {
		this.userS = userStory;
		
		testId = userS.getDriver().getId() == null ? "0" : userS.getDriver().getId();
		logger = new DebugLogger(testId);
	}
	
	// Get data methods
	protected DataObject getData(String key) {
		return userS.getData(key);
	}
	
	protected String getConfigVar(String key) {
		return userS.getConfigVar(key);
	}
	
	protected String getGlobalVar(String key) {
		return userS.getGlobalVar(key);
	}
	
	protected String getScenarioVar(String key) {
		String result = null;
		
		if(userS != null && userS.getScenario() != null) {
			result = userS.getScenarioVar(key);
		}
		
		return result;
	}
	
	protected String getTestVar(String key) {
		return userS.getTestVar(key);
	}

	// Set data methods
	protected void setData(DataObject data, String key) {
		userS.addData(data, key);
	}
	
	protected void setConfigVar(String key, String value) {
		userS.setConfigVar(key, value);
	}
	
	protected void setGlobalVar(String key, String value) {
		userS.setGlobalVar(key, value);
	}
	
	protected void setScenarioVar(String key, String value) {
		userS.setScenarioVar(key, value);
	}
	
	protected void setTestVar(String key, String value) {
		userS.setTestVar(key, value);
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
