package com.amaris.automation.model.utils;

import org.testng.ITestContext;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.TestDataManager;
import com.amaris.automation.model.webdriver.configuration.BrowserType;
import com.amaris.automation.model.webdriver.configuration.DeviceType;

public class InitUtils {

	public static boolean getBoolConfigVariable(String key) {
		return getBoolConfigVariable(key, null);
	}

	public static boolean getBoolConfigVariable(String key, DataObject dataObject) {
		String stringValue = System.getProperty(key);

		if(stringValue != null && stringValue.isEmpty()) stringValue = "true";

		if(stringValue == null && dataObject != null) stringValue = dataObject.getValue(key);

		return Boolean.parseBoolean(stringValue);
	}

	public static String getStringConfigVariable(String key) {
		return getStringConfigVariable(key, null);
	}

	public static String getStringConfigVariable(String key, DataObject dataObject) {
		String stringValue = System.getProperty(key);

		if(((stringValue != null && stringValue.isEmpty()) || stringValue == null) && dataObject != null) {
			stringValue = dataObject.getValue(key);
		}

		return stringValue;
	}

	public static boolean setBoolConfigVariable(String key, DataObject dataObject) {
		String stringValue = System.getProperty(key);

		if(stringValue != null && stringValue.isEmpty()) stringValue = "true";

		if(stringValue == null) stringValue = dataObject.getValue(key);
		else dataObject.setValue(key, stringValue);

		return Boolean.parseBoolean(stringValue);
	}

	public static String setStringConfigVariable(String key, DataObject dataObject) {
		String stringValue = System.getProperty(key);

		if((stringValue != null && stringValue.isEmpty()) || stringValue == null) stringValue = dataObject.getValue(key);
		else dataObject.setValue(key, stringValue);

		return stringValue;
	}

	public static boolean checkTestRun(String[][] resultMatrix, String id) {
		return resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3] == null
			|| !resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS);
	}

	public static void setThreads(ITestContext context) {
		String threads = System.getProperty("threads");

		if(threads != null && !threads.isEmpty()) {
			context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(threads));
		}
	}

	public static String getMainDriverFromProperties() {
		String result = null;
		String browser = System.getProperty(AutomationConstants.BROWSER);
		String platform = System.getProperty(AutomationConstants.PLATFORM);

		if((browser != null && !browser.isEmpty()) && ArrayUtils.contains(InitUtils.getDesktopBrowsers(), browser)
			&& platform != null && !platform.isEmpty()) {
			result = AutomationConstants.MOBILE_WEB;
		} else if(((browser == null || browser.isEmpty()) || !ArrayUtils.contains(InitUtils.getDesktopBrowsers(), browser))
			&& platform != null && !platform.isEmpty()) {
			result = AutomationConstants.MOBILE_APP;
		} else if(browser != null && !browser.isEmpty() && (platform == null || platform.isEmpty())) {
			result = AutomationConstants.WEB;
		}

		return result;
	}

	public static String[] getTestBrowsers() {
		String[] browsers = new String[]{};

		if(System.getProperty(AutomationConstants.BROWSER) != null && !System.getProperty(AutomationConstants.BROWSER).isEmpty()
			&& (System.getProperty(AutomationConstants.DEVICE) == null || System.getProperty(AutomationConstants.DEVICE).isEmpty())) {
			String browser = System.getProperty(AutomationConstants.BROWSER);

			browsers = browser.split(browser.contains(",") ? "," : "\\.");
		} else if(System.getProperty(AutomationConstants.DEVICE) != null && !System.getProperty(AutomationConstants.DEVICE).isEmpty()
			&& (System.getProperty(AutomationConstants.BROWSER) == null || System.getProperty(AutomationConstants.BROWSER).isEmpty())) {
			browsers = new String[]{ System.getProperty(AutomationConstants.DEVICE)};
		}

		return browsers;
	}

	public static String[] getTestDevices() {
		String[] devices = new String[]{};

		if(System.getProperty(AutomationConstants.BROWSER) != null && !System.getProperty(AutomationConstants.BROWSER).isEmpty()
			&& (System.getProperty(AutomationConstants.DEVICE) == null || System.getProperty(AutomationConstants.DEVICE).isEmpty())) {
			String browser = System.getProperty(AutomationConstants.BROWSER);

			devices = browser.split(browser.contains(",") ? "," : "\\.");
		} else if(System.getProperty(AutomationConstants.DEVICE) != null && !System.getProperty(AutomationConstants.DEVICE).isEmpty()
			&& (System.getProperty(AutomationConstants.BROWSER) == null || System.getProperty(AutomationConstants.BROWSER).isEmpty())) {
			devices = new String[]{ System.getProperty(AutomationConstants.DEVICE)};
		}

		return devices;
	}

	public static String getTestDataPath(String defaultTestData) {
		String testDataFile = System.getProperty(AutomationConstants.TEST_DATA);

		if(testDataFile != null && !testDataFile.isEmpty()) {
			testDataFile = AutomationConstants.RESOURCES_FOLDER + testDataFile;
		} else if(defaultTestData != null && !defaultTestData.isEmpty()) {
			testDataFile = AutomationConstants.RESOURCES_FOLDER + defaultTestData;
		} else {
			testDataFile = null;
		}

		return testDataFile;
	}

	public static TestDataManager initializeTestData(String testDataPath, String scenarioData, String globalData, String configDataPath) {
		// Get Configuration Data
		TestDataManager testData = new TestDataManager();

		testData.addTestData(testDataPath);
		testData.addConfigurationData(AutomationConstants.RESOURCES_FOLDER + configDataPath);
		testData.addScenarioData(AutomationConstants.RESOURCES_FOLDER + (scenarioData == null ? AutomationConstants.SCENARIO_DATA_SET : scenarioData));
		testData.addGlobalData(AutomationConstants.RESOURCES_FOLDER + (globalData == null ? AutomationConstants.GLOBAL_DATA_SET : globalData));

		return testData;
	}

	public static String[][] getResultMatrixFromCsvFile(String filePath) {
		filePath = filePath.endsWith(".csv") ? filePath : filePath + ".csv";

		return FileUtils.csvFileToMatrix(filePath, true);
	}

	public static String[][] getResultMatrixFromCsvString(String csvString) {
		return FileUtils.csvStringToMatrix(csvString, true);
	}

	public static String[][] getCasesMatrixFromResultMatrix(String[][] resultMatrix, String testCase) {
		String[][] testMatrix = ArrayUtils.addIndexToMatrix(new String[resultMatrix.length - 1][0]);

		int casesToRun = 0;

		for(int i = 1; i < resultMatrix.length; i++) {
			if(!resultMatrix[i][resultMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
				casesToRun++;
			}
		}

		int currentCase = 0;
		String[][] testMatrixAux = new String[0][0];

		if(testMatrix.length > 0) {
			testMatrixAux = new String[casesToRun][testMatrix[0].length - 1];

			if(testMatrixAux.length > 0) testMatrixAux[0] = testMatrix[0];

			for(int i = 0; i < testMatrix.length; i++) {
				if(!resultMatrix[i + 1][resultMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
					testMatrixAux[currentCase++] = testMatrix[i];
				}
			}
		}

		return testMatrixAux.length == 0 ? testMatrixAux : ArrayUtils.addColumnToMatrix(testMatrixAux, testCase, 0);
	}

	public static String[][] getCasesMatrixFromTestData(String testCase, int size) {
		String[][] testMatrix = new String[size][0];

		testMatrix = ArrayUtils.addIndexToMatrix(testMatrix);

		return ArrayUtils.addColumnToMatrix(testMatrix, testCase, 0);
	}

	public static String[][] getResultMatrixFromTestData(DataObject testData, String[] testVariables) {
		boolean containsBrowser = testData.getRow().containsKey(AutomationConstants.BROWSER);
		boolean containsDevice = testData.getRow().containsKey(AutomationConstants.DEVICE);
		testVariables = ArrayUtils.removeElementFromArray(testVariables, AutomationConstants.BROWSER);
		testVariables = ArrayUtils.removeElementFromArray(testVariables, AutomationConstants.DEVICE);
		String[][] resultMatrix = new String[testData.size() + 1][testVariables.length + 3 + (containsBrowser ? 1 : 0)];

		for(int j = 0; j < testVariables.length; j++) {
			resultMatrix[0][j] = testVariables[j];
		}

		if(containsBrowser || containsDevice) resultMatrix[0][resultMatrix[0].length - 4] = AutomationConstants.BROWSER;
		resultMatrix[0][resultMatrix[0].length - 3] = "result";
		resultMatrix[0][resultMatrix[0].length - 2] = "time";
		resultMatrix[0][resultMatrix[0].length - 1] = "exception";

		for(int i = 1; i < resultMatrix.length; i++) {
			String[] arrayAux = new String[testVariables.length + 3 + (containsBrowser ? 1 : 0)];

			for(int j = 0; j < testVariables.length; j++) {
				arrayAux[j] = testData.getValue(Integer.toString(i - 1), testVariables[j]);
			}

			if(containsBrowser || containsDevice) {
				String browser = testData.getValue(Integer.toString(i - 1), AutomationConstants.BROWSER);
				browser = !containsBrowser ? testData.getValue(Integer.toString(i - 1), AutomationConstants.DEVICE) : browser;

				arrayAux[arrayAux.length - 4] = browser;
			}

			arrayAux[arrayAux.length - 3] = AutomationConstants.TEST_UNDONE;
			arrayAux[arrayAux.length - 2] = "0.0";
			arrayAux[arrayAux.length - 1] = "None";

			resultMatrix[i] = arrayAux;
		}

		return resultMatrix;
	}

	public static boolean browserIsContained(String browser) {
		return browserIsContained(new String[]{ browser});
	}

	public static boolean browserIsContained(String[] browsersToCheck) {
		boolean result = true;
		String[] browsers = InitUtils.getTestBrowsers();

		for(String browser : browsers) {
			if(!ArrayUtils.contains(browsersToCheck, browser)) {
				result = false;
				break;
			}
		}

		return result;
	}

	public static String[] getDeviceEmulationBrowsers() {
		return new String[]{ BrowserType.NEXUS5X, BrowserType.NEXUS6P, BrowserType.GALAXYS5, BrowserType.IPAD, BrowserType.IPADPRO,
				BrowserType.IPHONE5, BrowserType.IPHONE6, BrowserType.IPHONE6PLUS, BrowserType.SAFARI_IPHONE, BrowserType.SAFARI_IPAD};
	}

	public static String[] getMobileEmulationBrowsers() {
		return new String[]{ BrowserType.NEXUS5X, BrowserType.NEXUS6P, BrowserType.GALAXYS5,
				BrowserType.IPHONE5, BrowserType.IPHONE6, BrowserType.IPHONE6PLUS, BrowserType.SAFARI_IPHONE};
	}

	public static String[] getTabletEmulationBrowsers() {
		return new String[]{ BrowserType.IPAD, BrowserType.IPADPRO, BrowserType.SAFARI_IPAD};
	}

	public static String[] getDesktopBrowsers() {
		return new String[]{ BrowserType.CHROME, BrowserType.FIREFOX, BrowserType.EDGE, BrowserType.INTERNET_EXPLORER, BrowserType.SAFARI};
	}

	public static String[] getMobileDevices() {
		return new String[]{ DeviceType.ANDROID, DeviceType.IPHONE};
	}

	public static boolean deviceIsContained(String[] devicesToCheck) {
		boolean result = true;
		String[] devices = InitUtils.getTestDevices();

		for(String device : devices) {
			if(!ArrayUtils.contains(devicesToCheck, device)) {
				result = false;
				break;
			}
		}

		return result;
	}

	private InitUtils() {}
}
