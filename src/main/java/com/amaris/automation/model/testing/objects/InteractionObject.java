package com.amaris.automation.model.testing.objects;

import java.io.File;
import java.util.Map;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.objects.DebugLogger;

public class InteractionObject {

	protected String testId;
	protected UserStory userS;
	protected DebugLogger logger;

	public InteractionObject() {
		logger = new DebugLogger();
	}

	public InteractionObject(UserStory userStory) {
		this.userS = userStory;
		this.testId = userStory.getTestId();

		logger = new DebugLogger(testId);
	}

	// Get data methods
	protected DataObject getData(String key) {
		return userS.getData(key);
	}

	protected String getConfigVar(String key) {
		return userS.getConfigVar(key);
	}

	protected String getSuiteVar(String key) {
		return userS.getSuiteVar(key);
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

	protected String getVar(String key) {
		return userS.getVar(key);
	}

	protected String getVar(String rowKey, String key) {
		return userS.getVar(rowKey, key);
	}

	// Set data methods
	protected void setData(DataObject data, String key) {
		userS.addData(data, key);
	}

	protected void setConfigVar(String key, String value) {
		userS.setConfigVar(key, value);
	}

	protected void setSuiteVar(String key, String value) {
		userS.setSuiteVar(key, value);
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

	// FileUtils methods
	public static String getPathWithResources(String filePath) {
		if(!new File(filePath).exists() && !new File(System.getProperty("user.dir") + '/' + filePath).exists()
			&& new File(System.getProperty("user.dir") + '/' + AutomationConstants.RESOURCES_FOLDER + filePath).exists()) {
			filePath = System.getProperty("user.dir") + '/' + AutomationConstants.RESOURCES_FOLDER + filePath;
		}

		return filePath;
	}

	protected static Map<String, Map<String, String>> csvFileToMData(String filePath) {
		return FileUtils.csvFileToMData(getPathWithResources(filePath));
	}

	protected static Map<String, Map<String, String>> csvFileToDMData(String filePath) {
		return FileUtils.csvFileToDMData(getPathWithResources(filePath));
	}

	protected static Map<String, Map<String, String>> jsonFileToMData(String filePath) {
		return FileUtils.jsonFileToMData(getPathWithResources(filePath));
	}

	protected static Map<String, Map<String, String>> jsonFileToDMData(String filePath) {
		return FileUtils.jsonFileToDMData(getPathWithResources(filePath));
	}

	protected static Map<String, Map<String, String>> variablesFileToArray(String filePath) {
		return FileUtils.variablesFileToArray(getPathWithResources(filePath));
	}

	protected static void appendMatrixToCsvFile(String filePath, String[][] matrix) {
		FileUtils.appendMatrixToCsvFile(getPathWithResources(filePath), matrix);
	}

	protected static void writeMatrixToCsvFile(String filePath, String[][] matrix) {
		FileUtils.writeMatrixToCsvFile(getPathWithResources(filePath), matrix);
	}

	protected static String[][] csvFileToMatrix(String filePath) {
		return FileUtils.csvFileToMatrix(getPathWithResources(filePath));
	}

	protected static String readFile(String filePath) {
		return FileUtils.readFile(getPathWithResources(filePath));
	}

	protected static void writeFile(String filePath, String text) {
		FileUtils.writeFile(getPathWithResources(filePath), text);
	}

	protected static void appendToFile(String filePath, String text) {
		FileUtils.appendToFile(getPathWithResources(filePath), text);
	}

	protected void deleteFileFromReportFolder(String filePath) {
		if(!new File(filePath).exists() && new File(userS.getReportPath() + filePath).exists()) {
			filePath = userS.getReportPath() + filePath;
		}

		FileUtils.deleteFile(filePath);
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

	protected void printStackTrace(Exception exception) {
		logger.printStackTrace(exception);
	}

	protected void setDebugVerbose(boolean verbose) {
		logger.setVerbose(verbose);
	}
}
