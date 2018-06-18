package com.automation.model.testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.httprequest.RequestHelper;
import com.automation.model.utils.ArrayUtils;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.FileUtils;
import com.automation.model.utils.InitUtils;
import com.automation.model.utils.StringUtils;

import javafx.util.Pair;

/**
 * The SuiteManager class is used to manage test objects like the
 * TestDataManager and the result matrix.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class SuiteManager {

	private String apiUrl;
	private String clientId;
	private String suiteName;
	private String initialTimeStamp;
	private String reportPath;
	private ArrayList<Pair<String, Integer>> testCases = new ArrayList<Pair<String, Integer>>();
	private HashMap<String, HashMap<String, ArrayList<String>>> consoleLogs = new HashMap<String, HashMap<String, ArrayList<String>>>();
	private HashMap<String, Pair<TestDataManager, String[][]>> testSuiteObject = new HashMap<String, Pair<TestDataManager, String[][]>>();
	
	public SuiteManager(String suiteName) {
		this.suiteName = suiteName;
		initialTimeStamp = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
	}
	
	public SuiteManager(String clientId, String suiteName) {
		this.clientId = clientId;
		this.suiteName = suiteName;
		initialTimeStamp = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
	}

	public String getName() {
		return suiteName;
	}

	public void addConsoleLog(String testCase, String id, ArrayList<String> logs) {
		consoleLogs.get(testCase).put(id, logs);
	}

	public void createHtmlReport() {
		createHtmlReport(null);
	}

	public void createHtmlReport(String translationFile) {
		CsvToHtml.createJointReport(this, translationFile);
	}

	public void createLogReport() {
		String result = "";
		String path = reportPath + "/" + suiteName + "ConsoleLogReport.txt";

		if(new File(reportPath + "/" + suiteName + "ConsoleLogReport.txt").exists()) {
			result = FileUtils.getTextFromFile(path);

			if(result == null) result = "";
		}

		for(Pair<String, Integer> testCaseInfo : testCases) {
			int totalThreads = getResultMatrix(testCaseInfo.getKey()).length - 1;

			for(int i = 0; i < totalThreads; i++) {
				if(i == 0) {
					result += "[" + testCaseInfo.getKey() + "]\n";
				}

				if(consoleLogs.get(testCaseInfo.getKey()).get(Integer.toString(i)) != null) {
					for(String log : consoleLogs.get(testCaseInfo.getKey()).get(Integer.toString(i))) {
						result += "Thread(" + i + ") - " + log + "\n";
					}

					result += "\n";
				}
			}
		}

		if(!result.isEmpty()) {
			FileUtils.writeFile(path, result);
		}
	}

	public synchronized TestDataManager getTestData(String testCase) {
		TestDataManager testDataM = null;

		if(testSuiteObject.get(testCase) != null) {
			testDataM = testSuiteObject.get(testCase).getKey();
		}

		return testDataM;
	}

	public String[][] getResultMatrix(String testCase) {
		String[][] testDataM = null;

		if(testSuiteObject.get(testCase) != null) {
			testDataM = testSuiteObject.get(testCase).getValue();
		}

		return testDataM;
	}

	public void sendCsvToDatabase() {
		for(int i = 0; i < testCases.size(); i++) {
			String sendCsv = System.getProperty("send_csv");

			if(sendCsv == null || sendCsv.isEmpty()) {
				sendCsv = testSuiteObject.get(testCases.get(i).getKey()).getKey().getConfigVar("send_csv");
			}

			if(sendCsv != null && !sendCsv.isEmpty() && Boolean.parseBoolean(sendCsv) && apiUrl != null) {
				String fileName = testSuiteObject.get(testCases.get(i).getKey()).getKey().getTimeStamp() + ".csv";

				RequestHelper request = new RequestHelper(apiUrl + "/" + clientId + "/post/" + suiteName + "/" + clientId + suiteName + initialTimeStamp);

				request.setContentType("multipart/form-data; boundary=--12345");
				request.setBody("----12345\n"
					+ "Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\n"
					+ "Content-Type: text/csv\n\n"
					+ FileUtils.getTextFromFile(reportPath + fileName)
					+ "\n----12345--");
				request.post();

				if(request.getResponseCode() == 201) {
					System.out.println("[INFO] - File sent correctly: " + fileName);
				} else {
					System.out.println("[INFO] - Error sending file: " + fileName);
				}
			}
		}
	}

	public synchronized String[] getTestCases() {
		String[] result = new String[testCases.size()];

		for(int i = 0; i < result.length; i++) {
			result[i] = testCases.get(i).getKey();
		}

		return result;
	}

	public synchronized int[] getRelevantColumns() {
		int[] result = new int[testCases.size()];

		for(int i = 0; i < result.length; i++) {
			result[i] = testCases.get(0).getValue();
		}

		return result;
	}

	public synchronized void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public synchronized void setRelevantColumn(String testCase, int relevantColumn) {
		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				testCases.set(i, new Pair<String, Integer>(testCase, relevantColumn));
			}
		}
	}

	public synchronized String[][] removeMobileCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = ArrayUtils.removeRowsContaining(casesMatrix, InitUtils.getMobileBrowsers(), 2);

		resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getMobileBrowsers(), 2);

		if(casesMatrix.length == 0) {
			testCases.remove(testCase);
			testSuiteObject.remove(testCase);
		} else {
			testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
		}

		return result;
	}

	public synchronized void addTestObjects(String testCase, TestDataManager testDataM, String[][] resultMatrix) {
		testSuiteObject.put(testCase, new Pair<TestDataManager, String[][]>(testDataM, resultMatrix));
		testCases.add(new Pair<String, Integer>(testCase, -1));
	}

	public String[][] initializeTestObjects(String testCase) {
		return initializeTestObjects(testCase, null, null);
	}

	public String[][] initializeTestObjects(String testCase, String scenarioDataPath) {
		return initializeTestObjects(testCase, scenarioDataPath, null);
	}

	public String[][] initializeTestObjects(String testCase, String scenarioDataPath, String testDataPath) {
		System.out.println("[INFO] - Case: " + testCase);
		String[][] casesMatrix = null;
		String defaultTestData = InitUtils.getTestDataPath(testDataPath), defaultScenarioData = scenarioDataPath;
		String[] browsers = InitUtils.getTestBrowsers();

		String[][] resultMatrix = null;
		TestDataManager testData = InitUtils.initializeTestData(defaultTestData, defaultScenarioData, AutomationConstants.CONFIGURATION_DATA_SET);

		testData.generateTimeStamp(testCase);

		reportPath = testData.getReportPath();
		
		if(apiUrl == null) {
			String serverUrl = System.getProperty("api_url");
			
			if(serverUrl != null && !serverUrl.isEmpty()) {
				apiUrl = serverUrl;
				testData.setConfigVar("api_url", apiUrl);
			} else {
				apiUrl = testData.getConfigVar("api_url");
			}
		} else {
			testData.setConfigVar("api_url", apiUrl);
		}

		if(defaultTestData != null) {
			testData.addTestData(defaultTestData);
			testData.setCaseVariables(FileUtils.loadCsvFileToArray(defaultTestData, true)[0]);
		} else {
			HashMap<String, HashMap<String, String>> hashMapAux = new HashMap<String, HashMap<String, String>>();

			String[] keyArray = new String[]{ "row", "id"};
			hashMapAux.put("0", StringUtils.stringToDMRow(keyArray, new String[]{ "0", "0"}));

			testData.addTestData(new DataObject(hashMapAux));
			testData.setCaseVariables(new String[]{ "id"});
		}

		testData.getTestData().duplicateDataByN(browsers.length);
		
		boolean fileFromApi = false;
		
		if(testData.getDailyCase().contains("continue")) {
			System.out.println("[INFO] - Continue daily");
			
			String requestCsv = System.getProperty("get_csv");
			
			if(requestCsv == null || requestCsv.isEmpty()) {
				requestCsv = testData.getConfigVar("get_csv");
			}

			// If "request_csv" is true, try to initialise resultMatrix from a request
			if(requestCsv != null && !requestCsv.isEmpty() && Boolean.parseBoolean(requestCsv) && clientId != null && apiUrl != null) {				
				RequestHelper request = new RequestHelper(apiUrl + "/" + clientId + "/csv/" + testData.getTimeStamp() + ".csv");
				request.get();
				
				if(request.getResponseCode() == 200) {
					System.out.println("[INFO] - File was received correctly: " + testData.getTimeStamp() + ".csv");
					resultMatrix = InitUtils.getResultMatrixFromCsvString(request.getResponseBody(), testData.getTimeStamp() + ".csv");
					
					fileFromApi = true;
				} else {					
					System.out.println("[ERROR] - File wasn't received: " + testData.getTimeStamp() + ".csv");
				}
			}
			
			// If resultMatrix was not filled by a request, try to fill it with an existent file
			if(resultMatrix == null && new File(testData.getReportPath() + testData.getTimeStamp() + ".csv").exists()) {
				System.out.println("[INFO] - Getting test data from file");
				resultMatrix = InitUtils.getResultMatrixFromCsvFile(testData.getReportPath() + testData.getTimeStamp() + ".csv");
			}
			
			// If resultMatrix was filled, fill casesMatrix
			if(resultMatrix != null) {
				casesMatrix = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
			}
		} 
		
		// If neither casesMatrix nor resultMatrix are filled at this point 
		// (the request didn't return a file, the file doesn't exist or the case is not continue)
		if(casesMatrix == null || resultMatrix == null) {
			System.out.println("[INFO] - Creating test data");
			casesMatrix = InitUtils.getCasesMatrixFromBrowserArray(testCase, browsers, testData.getTestData().size());
			resultMatrix = InitUtils.getResultMatrixFromTestData(testData.getTestData(), browsers, testData.getCaseVariables());
		}

		addTestObjects(testCase, testData, resultMatrix);
		consoleLogs.put(testCase, new HashMap<String, ArrayList<String>>());

		System.out.println("[INFO] - Test to run on this execution: " + casesMatrix.length);
		
		if(!fileFromApi && casesMatrix.length == 0) {
			sendCsvToDatabase();
		}

		return casesMatrix.length == 0 ? null : casesMatrix;
	}
}
