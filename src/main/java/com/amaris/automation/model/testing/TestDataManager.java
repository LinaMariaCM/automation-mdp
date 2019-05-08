package com.amaris.automation.model.testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.data.DataManagerObject;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.utils.ArrayUtils;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.objects.DebugLogger;

/**
 * The TestDataManager class is used to manage the test data, having test data, scenario data and global data.
 * 
 * It is also possible to add more data specific to a test.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class TestDataManager {

	private String testCase;
	private String dailyCase = "";
	private String timeStamp;
	private String reportPath;
	private String[] caseVariables;
	private DataManagerObject data;
	private DebugLogger logger = new DebugLogger();

	public TestDataManager() {
		data = new DataManagerObject();
	}

	public TestDataManager(DataManagerObject data) {
		this.data = data;
	}

	public TestDataManager(DataObject mainData) {
		data = new DataManagerObject();

		data.addData(AutomationConstants.TEST_DATA, mainData);
	}

	public void generateTimeStamp(String testCase, String timeStampDriver) {
		this.testCase = testCase;
		// Time Stamp
		dailyCase = System.getProperty(AutomationConstants.SPECIAL_CASE) == null ? "" : System.getProperty(AutomationConstants.SPECIAL_CASE);

		// If not special case, add time to timeStamp
		timeStamp = new SimpleDateFormat("yyyy.MM.dd" + (dailyCase.isEmpty() ? ".HH.mm.ss" : "")).format(new java.util.Date());

		logger.info("Execution ID: " + timeStamp);

		// Report Folder
		reportPath = System.getProperty("user.dir") + '/' + AutomationConstants.REPORTS_FOLDER + "T" + timeStamp.replace(".", "") + '/';

		// If special case is not empty, add case and browser to file name
		String buildGroup = System.getProperty(AutomationConstants.BUILD_GROUP);
		buildGroup = buildGroup == null || buildGroup.isEmpty() ? "" : "." + buildGroup;

		timeStamp += "." + testCase + "." + timeStampDriver + buildGroup;
	}

	// region Getters
	public String getTestCase() {
		return this.testCase;
	}

	public String getDailyCase() {
		return this.dailyCase;
	}

	public synchronized String getReportPath() {
		return this.reportPath;
	}

	public synchronized String getTimeStamp() {
		return this.timeStamp;
	}

	public synchronized String[] getCaseVariables() {
		return caseVariables;
	}

	public String caseVariablesToString(String testId) {
		StringBuilder textInfo = new StringBuilder();

		for(int i = 0; i < caseVariables.length; i++) {
			textInfo.append(" " + caseVariables[i] + ": " + getTestVar(testId, caseVariables[i]));
			if(i != caseVariables.length - 1) {
				textInfo.append(",");
			}
		}
		return textInfo.toString();
	}

	public DataManagerObject getDataManager() {
		return this.data;
	}

	public DataObject getData(String dataKey) {
		return this.data.getData(dataKey);
	}

	public DataObject getTestData() {
		return this.data.getData(AutomationConstants.TEST_DATA);
	}

	public DataObject getConfigData() {
		return data.getData(AutomationConstants.CONFIGURATION_DATA);
	}

	public String getGlobalVar(String key) {
		return data.getData(AutomationConstants.GLOBAL_DATA).getValue(key);
	}

	public String getScenarioVar(String scenario, String key) {
		return data.getData(AutomationConstants.SCENARIO_DATA).getValue(scenario, key);
	}

	public String getTestVar(String testId, String key) {
		return data.getData(AutomationConstants.TEST_DATA).getValue(testId, key);
	}

	public String getConfigVar(String key) {
		return data.getData(AutomationConstants.CONFIGURATION_DATA).getValue(key);
	}
	// endregion

	// region Setters
	public void setTestData(DataObject testData) {
		this.data.replaceData(AutomationConstants.TEST_DATA, testData);
	}

	public synchronized void setReportPath(String path) {
		this.reportPath = path;
	}

	public synchronized void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public synchronized void setCaseVariables(String[] caseVariables) {
		this.caseVariables = ArrayUtils.removeElementFromArray(caseVariables, AutomationConstants.BROWSER);
	}

	public void setGlobalVar(String key, String value) {
		data.getData(AutomationConstants.GLOBAL_DATA).setValue(key, value);
	}

	public void setScenarioVar(String scenario, String key, String value) {
		data.getData(AutomationConstants.SCENARIO_DATA).setValue(scenario, key, value);
	}

	public void setTestVar(String testId, String key, String value) {
		data.getData(AutomationConstants.TEST_DATA).setValue(testId, key, value);
	}

	public void setConfigVar(String key, String value) {
		data.getData(AutomationConstants.CONFIGURATION_DATA).setValue(key, value);
	}
	// endregion

	// region Data Access
	public String getVar(String key) {
		String result = null;

		if(data.getData(AutomationConstants.GLOBAL_DATA).getValue(key) != null) {
			result = data.getData(AutomationConstants.GLOBAL_DATA).getValue(key);
		} else if(data.getData(AutomationConstants.SCENARIO_DATA).getRow() != null
			&& data.getData(AutomationConstants.SCENARIO_DATA).getValue(key) != null) {
			result = data.getData(AutomationConstants.SCENARIO_DATA).getValue(key);
		} else if(data.getData(AutomationConstants.TEST_DATA).getRow() != null
			&& data.getData(AutomationConstants.TEST_DATA).getValue(key) != null) {
			result = data.getData(AutomationConstants.TEST_DATA).getValue(key);
		} else {
			String[] dataKeys = data.getKeySet();

			for(String dataKey : dataKeys) {
				if(!ArrayUtils.contains(new String[]{ AutomationConstants.GLOBAL_DATA, AutomationConstants.SCENARIO_DATA,
						AutomationConstants.TEST_DATA, AutomationConstants.CONFIGURATION_DATA}, dataKey)
					&& data.getData(dataKey).getRow() != null && data.getData(dataKey).getValue(key) != null) {
					result = data.getData(dataKey).getValue(key);
					break;
				}
			}
		}

		return result;
	}

	public String getVar(String rowKey, String key) {
		String result = null;

		if(data.getData(AutomationConstants.GLOBAL_DATA).getValue(key) != null) {
			result = data.getData(AutomationConstants.GLOBAL_DATA).getValue(key);
		} else if(data.getData(AutomationConstants.SCENARIO_DATA).getRow(rowKey) != null
			&& data.getData(AutomationConstants.SCENARIO_DATA).getValue(rowKey, key) != null) {
			result = data.getData(AutomationConstants.SCENARIO_DATA).getValue(rowKey, key);
		} else if(data.getData(AutomationConstants.TEST_DATA).getRow(rowKey) != null
			&& data.getData(AutomationConstants.TEST_DATA).getValue(rowKey, key) != null) {
			result = data.getData(AutomationConstants.TEST_DATA).getValue(rowKey, key);
		} else {
			String[] dataKeys = data.getKeySet();

			for(String dataKey : dataKeys) {
				if(!ArrayUtils.contains(new String[]{ AutomationConstants.GLOBAL_DATA, AutomationConstants.SCENARIO_DATA,
						AutomationConstants.TEST_DATA, AutomationConstants.CONFIGURATION_DATA}, dataKey)
					&& data.getData(dataKey).getRow(rowKey) != null && data.getData(dataKey).getValue(rowKey, key) != null) {
					result = data.getData(dataKey).getValue(rowKey, key);
					break;
				}
			}
		}

		return result;
	}

	public void generateTestRow(String rowKey) {
		if(data.containsKey(AutomationConstants.TEST_DATA)) {
			data.getData(AutomationConstants.TEST_DATA).addRow(rowKey);
		} else {
			data.addData(AutomationConstants.TEST_DATA, new DataObject().addRow(rowKey));
		}
	}
	// endregion

	// region Data Setters
	private void printDataAccessError(String dataType, String filePath, Exception e) {
		if(!new File(FileUtils.getFilePathFromRelative(filePath)).exists()) {
			logger.error("No " + dataType + " data file found");
		} else {
			logger.error("Error reading the " + dataType + " data"
				+ (e.getMessage() != null && !e.getMessage().isEmpty() ? ": " + e.getMessage() : ""));
		}
	}

	public void addGlobalData(DataObject testData) {
		if(data.containsKey(AutomationConstants.GLOBAL_DATA)) {
			data.replaceData(AutomationConstants.GLOBAL_DATA, testData);
		} else {
			data.addData(AutomationConstants.GLOBAL_DATA, testData);
		}
	}

	public void addGlobalData(String filePath) {
		DataObject globalData = null;

		if(filePath != null) {
			try {
				globalData = new DataObject(FileUtils.fileToMData(filePath));
				data.setKey(AutomationConstants.GLOBAL_DATA);
			} catch(Exception e) {
				printDataAccessError("global", filePath, e);
			}
		}

		if(globalData != null && data.containsKey(AutomationConstants.GLOBAL_DATA)) {
			data.replaceData(AutomationConstants.GLOBAL_DATA, globalData);
		} else if(globalData != null) {
			data.addData(AutomationConstants.GLOBAL_DATA, globalData);
		} else {
			data.addData(AutomationConstants.GLOBAL_DATA, new DataObject().addRow("row"));
		}
	}

	public void addScenarioData(DataObject testData) {
		if(data.containsKey(AutomationConstants.SCENARIO_DATA)) {
			data.replaceData(AutomationConstants.SCENARIO_DATA, testData);
		} else {
			data.addData(AutomationConstants.SCENARIO_DATA, testData);
		}
	}

	public void addScenarioData(String filePath) {
		DataObject scenarioData = null;

		if(filePath != null) {
			try {
				scenarioData = new DataObject(FileUtils.fileToDMData(filePath));
				data.setKey(AutomationConstants.SCENARIO_DATA);
			} catch(Exception e) {
				printDataAccessError("scenario", filePath, e);
			}
		}

		if(scenarioData != null && data.containsKey(AutomationConstants.SCENARIO_DATA)) {
			data.replaceData(AutomationConstants.SCENARIO_DATA, scenarioData);
		} else if(scenarioData != null) {
			data.addData(AutomationConstants.SCENARIO_DATA, scenarioData);
		}
	}

	public void addConfigurationData(String filePath) {
		DataObject conf = null;

		try {
			conf = new DataObject(FileUtils.fileToMData(filePath));
		} catch(Exception e) {
			printDataAccessError("configuration", filePath, e);
		}

		if(conf != null && data.containsKey(AutomationConstants.CONFIGURATION_DATA)) {
			data.replaceData(AutomationConstants.CONFIGURATION_DATA, conf);
		} else if(conf != null) {
			data.addData(AutomationConstants.CONFIGURATION_DATA, conf);
		} else {
			data.addData(AutomationConstants.CONFIGURATION_DATA, new DataObject().addRow("row"));
		}
	}

	public void addTestData(String filePath) {
		DataObject testData = null;

		if(filePath != null) {
			try {
				// Apply test filter to test data
				String testFilter = System.getProperty(AutomationConstants.TEST_FILTER);
				String[][] csvMatrix = FileUtils.csvFileToMatrix(filePath, true);

				if(testFilter != null && !testFilter.isEmpty()) {
					List<Integer> removeIndexes = ArrayUtils.getFiltersIndexes(testFilter, csvMatrix);

					csvMatrix = ArrayUtils.removeRowsFromMatrix(removeIndexes, csvMatrix, true);
				}

				testData = new DataObject(FileUtils.csvStringToMData(ArrayUtils.matrixToString(csvMatrix, "\n", ";")));
				data.setKey(AutomationConstants.TEST_DATA);
			} catch(Exception e) {
				logger.printStackTrace(e);
				printDataAccessError("test", filePath, e);
			}
		} else {
			testData = new DataObject().addRow("0");
			testData.setValue("id", "0");
		}

		if(testData != null && data.containsKey(AutomationConstants.TEST_DATA)) {
			data.replaceData(AutomationConstants.TEST_DATA, testData);
		} else if(testData != null) {
			data.addData(AutomationConstants.TEST_DATA, testData);
		}
	}

	public void addTestData(DataObject testData) {
		if(data.containsKey(AutomationConstants.TEST_DATA)) {
			data.replaceData(AutomationConstants.TEST_DATA, testData);
		} else {
			data.addData(AutomationConstants.TEST_DATA, testData);
		}
	}

	public void addData(DataObject dataObject, String dataKey) {
		if(data.containsKey(dataKey)) {
			data.replaceData(dataKey, dataObject);
		} else {
			data.addData(dataKey, dataObject);
		}
	}

	public void addDMData(String filePath, String dataKey) {
		if(!new File(filePath).isAbsolute()) filePath = AutomationConstants.RESOURCES_FOLDER + filePath;
		DataObject dataObject = new DataObject(FileUtils.fileToDMData(filePath));

		if(data.containsKey(dataKey)) {
			data.replaceData(dataKey, dataObject);
		} else {
			data.addData(dataKey, dataObject);
		}
	}

	public void addMData(String fileName, String dataKey) {
		if(!new File(fileName).isAbsolute()) fileName = AutomationConstants.RESOURCES_FOLDER + fileName;
		DataObject dataObject = new DataObject(FileUtils.fileToMData(fileName));

		if(data.containsKey(dataKey)) {
			data.replaceData(dataKey, dataObject);
		} else {
			data.addData(dataKey, dataObject);
		}
	}
	// endregion
}
