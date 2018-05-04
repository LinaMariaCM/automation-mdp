package com.automation.model.utils;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.testing.TestDataManager;

public class InitUtils {
	
	public static void setThreads(ITestContext context) {
		if(System.getProperty("threads") != null && !System.getProperty("threads").isEmpty()) {
	        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(System.getProperty("threads")));
		}
	}
	
	public static String[] getTestBrowsers() {
		String[] browsers = new String[]{ BrowserType.CHROME};

		if(System.getProperty("browser") != null && !System.getProperty("browser").isEmpty()) {
			String browser = System.getProperty("browser");
			
			browsers = browser.split(browser.contains(",") ? ",": "\\.");
		}
		
		return browsers;
	}
	
	public static String getTestDataPath(String defaultTestData) {
		String testDataFile = System.getProperty("test_data");
		
		if(testDataFile != null && !testDataFile.isEmpty()) {
			testDataFile = AutomationConstants.RESOURCES_FOLDER + "/" + testDataFile;
		} else {
			testDataFile = AutomationConstants.RESOURCES_FOLDER + "/" + defaultTestData;
		}
		
		return testDataFile;
	}
	
	public static TestDataManager initializeTestData(String testDataPath, String configDataPath) {
		return initializeTestData(testDataPath, AutomationConstants.SCENARIO_DATA_SET, configDataPath);
	}
	
	public static TestDataManager initializeTestData(String testDataPath, String scenarioData, String configDataPath) {
		// Get Configuration Data
		TestDataManager testData = new TestDataManager(new DataObject(FileUtils.csvFileToMData(System.getProperty("user.dir") + "/" + testDataPath)));
		
		testData.addConfigurationData(configDataPath);
		testData.addScenarioData(scenarioData == null ?  AutomationConstants.SCENARIO_DATA_SET : AutomationConstants.RESOURCES_FOLDER + scenarioData);
		testData.addGlobalData(AutomationConstants.GLOBAL_DATA_SET);
		
		return testData;
	}
	
	public static String[][] getResultMatrixFromCsvFile(String filePath) {
		filePath = filePath.endsWith(".csv") ? filePath : filePath + ".csv";
		
		return FileUtils.loadDataFileToArray(filePath, true);
	}
	
	public static String[][] getCasesMatrixFromResultMatrix(String[][] resultMatrix) {
		String[][] testMatrix = ArrayUtils.removeColumnFromMatrix(resultMatrix, resultMatrix[0].length - 3, resultMatrix[0].length - 1);
		testMatrix = ArrayUtils.removeColumnFromMatrix(testMatrix, 0, resultMatrix[0].length - 5);
		testMatrix = ArrayUtils.removeRowFromMatrix(testMatrix, 0, 0);
		
		return ArrayUtils.addIndexToMatrix(testMatrix);
	}
	
	public static String[][] getCasesMatrixFromBrowserArray(String[] browsers, int size) {
		String[][] testMatrix = new String[size][1];

		for(int i = 0; i < browsers.length; i++) {
			for(int j = 0; j < size / browsers.length; j++) {
				testMatrix[(size / browsers.length * i) + j][0] = browsers[i];
			}
		}

		return ArrayUtils.addIndexToMatrix(testMatrix);
	}
	
	public static String[][] getResultMatrixFromTestData(DataObject dataObject, String[] browsers, String[] testVariables) {
		String[][] resultMatrix = new String[dataObject.size() + 1][dataObject.getRow().size() + 3];
		
		for(int j = 0; j < testVariables.length; j++) {
			resultMatrix[0][j] = testVariables[j];
		}
		
		resultMatrix[0][resultMatrix[0].length - 4] = "browser";
		resultMatrix[0][resultMatrix[0].length - 3] = "result";
		resultMatrix[0][resultMatrix[0].length - 2] = "time";
		resultMatrix[0][resultMatrix[0].length - 1] = "exception";
		
		for(int i = 1; i < resultMatrix.length; i++) {
			String[] arrayAux = new String[dataObject.getRow().size() + 3];

			for(int j = 0; j < testVariables.length; j++) {
				arrayAux[j] = dataObject.getValue(Integer.toString(i - 1), testVariables[j]);
			}
			
			arrayAux[arrayAux.length - 4] = browsers[(int) ((i - 1) / (dataObject.size() / browsers.length))];
			arrayAux[arrayAux.length - 3] = AutomationConstants.TEST_UNDONE;
			arrayAux[arrayAux.length - 2] = "0.0";
			arrayAux[arrayAux.length - 1] = "None";
			
			resultMatrix[i] = arrayAux;
		}

		return resultMatrix;
	}
}
