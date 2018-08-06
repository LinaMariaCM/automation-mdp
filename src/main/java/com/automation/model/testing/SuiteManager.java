package com.automation.model.testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataManagerObject;
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
	private String reportPath;
	private DataManagerObject suiteData = new DataManagerObject();
	private String initialTimeStamp;
	private ArrayList<Pair<String, int[]>> testCases = new ArrayList<Pair<String, int[]>>();
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

	public DataObject getSuiteData(String dataKey) {
		return this.suiteData.getData(dataKey);
	}
	
	public void addSuiteData(DataObject dataObject, String dataKey) {
		if(suiteData.containsKey(dataKey)) {
			suiteData.replaceData(dataKey, dataObject);
		} else {
			suiteData.addData(dataKey, dataObject);
		}
	}

	public void addConsoleLog(String testCase, String id, ArrayList<String> logs) {
		consoleLogs.get(testCase).put(id, logs);
	}

	public void setTestOrder(String[] testList) {
		ArrayList<Pair<String, int[]>> testCasesAux = new ArrayList<Pair<String, int[]>>();

		for(String testCase : testList) {
			for(Pair<String, int[]> testCasePair : testCases) {
				if(testCasePair.getKey().equals(testCase)) {
					testCasesAux.add(testCasePair);
					break;
				}
			}
		}

		testCases = testCasesAux;
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

		for(Pair<String, int[]> testCaseInfo : testCases) {
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

	public void sendImgToDatabase(String fileName, byte[] image) {
		String sendImg = System.getProperty("send_img");

		if(sendImg != null && !sendImg.isEmpty() && Boolean.parseBoolean(sendImg)) {
			try {
				String browser = ArrayUtils.arrayToString(InitUtils.getTestBrowsers(), ".");
				RequestHelper request = new RequestHelper(apiUrl + "/" + clientId + "/images/upload/" + clientId + suiteName
					+ (browser.isEmpty() ? "" : "." + browser) + initialTimeStamp + "/" + fileName + ".png");

				request.setContentType("multipart/form-data; boundary=--12345");
				request.addHeader("Encoding", "base64");
				request.setBody("----12345\n"
					+ "Content-Disposition: form-data; name=\"imagefile\"; filename=\"[ERROR] - " + fileName + ".png\"\n"
					+ "Content-Type: image/png\n\n"
					+ Base64.getEncoder().encodeToString(image)
					+ "\n----12345--");
				request.post();

				if(request.getResponseCode() == 201) {
					System.out.println("[INFO] - Image sent correctly: " + fileName);
				} else {
					System.out.println("[INFO] - Error sending image: " + fileName);
				}
			} catch(Exception e) {
				System.out.println("[INFO] - Error sending image: " + fileName);
				e.printStackTrace();
			}
		}
	}

	public void sendCsvToDatabase() {
		for(int i = 0; i < testCases.size(); i++) {
			String sendCsv = System.getProperty("send_csv");

			if(sendCsv == null || sendCsv.isEmpty()) {
				sendCsv = testSuiteObject.get(testCases.get(i).getKey()).getKey().getConfigVar("send_csv");
			}

			if(sendCsv != null && !sendCsv.isEmpty() && Boolean.parseBoolean(sendCsv) && clientId == null) {
				System.out.println("[ERROR] - File not sent: client id not declared");
			} else if(sendCsv != null && !sendCsv.isEmpty() && Boolean.parseBoolean(sendCsv) && apiUrl == null) {
				System.out.println("[ERROR] - File not sent: api_url is null");
			} else if(sendCsv != null && !sendCsv.isEmpty() && Boolean.parseBoolean(sendCsv)) {
				String browser = ArrayUtils.arrayToString(InitUtils.getTestBrowsers(), ".");
				String timeStamp = testSuiteObject.get(testCases.get(i).getKey()).getKey().getTimeStamp();
				String fileName = timeStamp + ".csv";

				RequestHelper request = new RequestHelper(apiUrl + "/" + clientId + "/post/" + suiteName + (browser.isEmpty() ? "" : "." + browser) + "/"
					+ clientId + suiteName + (browser.isEmpty() ? "" : "." + browser) + initialTimeStamp);

				if(testCases.get(i).getValue()[2] >= 0 && testSuiteObject.get(testCases.get(i).getKey()).getValue().length > 1) {
					String key = testSuiteObject.get(testCases.get(i).getKey()).getValue()[0][testCases.get(i).getValue()[2]];
					testSuiteObject.get(testCases.get(i).getKey()).getValue()[0][testCases.get(i).getValue()[2]] = "*" + key;
				}

				request.setContentType("multipart/form-data; boundary=--12345");
				request.setBody("----12345\n"
					+ "Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\n"
					+ "Content-Type: text/csv\n\n"
					+ ArrayUtils.matrixToString(testSuiteObject.get(testCases.get(i).getKey()).getValue(), "\n", ";") + "\n"
					+ "----12345--");
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
			result[i] = testCases.get(0).getValue()[2];
		}

		return result;
	}

	public synchronized String getReportPath() {
		return this.reportPath;
	}

	public synchronized void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public synchronized void setRelevantColumn(String testCase, int relevantColumn) {
		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				synchronized(testCases) {
					testCases.get(i).getValue()[2] = relevantColumn;
				}
			}
		}
	}

	public synchronized void updateTestsFinished(String testCase) {
		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				synchronized(testCases) {
					testCases.get(i).getValue()[1] = testCases.get(i).getValue()[1] + 1;
				}
			}
		}
	}

	public synchronized int getTestsFinished(String testCase) {
		int result = -1;

		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				synchronized(testCases) {
					result = testCases.get(i).getValue()[1];
				}
			}
		}

		return result;
	}

	public synchronized int getTestsToRun(String testCase) {
		int result = -1;

		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				synchronized(testCases) {
					result = testCases.get(i).getValue()[0];
				}
			}
		}

		return result;
	}

	public synchronized String[][] removeDeviceEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = ArrayUtils.removeRowsContaining(casesMatrix, InitUtils.getDeviceEmulationBrowsers(), 2);

		resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getDeviceEmulationBrowsers(), 2);

		if(casesMatrix.length == 0) {
			testCases.remove(testCase);
			testSuiteObject.remove(testCase);
		} else {
			testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
		}

		return result;
	}

	public synchronized String[][] removeMobileEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = ArrayUtils.removeRowsContaining(casesMatrix, InitUtils.getMobileEmulationBrowsers(), 2);

		resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getMobileEmulationBrowsers(), 2);

		if(casesMatrix.length == 0) {
			testCases.remove(testCase);
			testSuiteObject.remove(testCase);
		} else {
			testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
		}

		return result;
	}

	public synchronized String[][] removeTabletEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = ArrayUtils.removeRowsContaining(casesMatrix, InitUtils.getTabletEmulationBrowsers(), 2);

		resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getTabletEmulationBrowsers(), 2);

		if(casesMatrix.length == 0) {
			testCases.remove(testCase);
			testSuiteObject.remove(testCase);
		} else {
			testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
		}

		return result;
	}

	public synchronized void addTestObjects(String testCase, TestDataManager testDataM, String[][] resultMatrix, int testsToRun) {
		testSuiteObject.put(testCase, new Pair<TestDataManager, String[][]>(testDataM, resultMatrix));
		testCases.add(new Pair<String, int[]>(testCase, new int[]{ testsToRun, 0, -1}));
	}

	private ArrayList<Integer> joinIndexes(ArrayList<Integer> indexes1, ArrayList<Integer> indexes2) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for(int index : indexes1) {
			indexes.add(index);
		}

		for(int index : indexes2) {
			if(!indexes.contains(index)) {
				indexes.add(index);
			}
		}

		return indexes;
	}

	private ArrayList<Integer> interceptIndexes(ArrayList<Integer> indexes1, ArrayList<Integer> indexes2) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for(int index : indexes1) {
			if(indexes2.contains(index)) {
				indexes.add(index);
			}
		}

		return indexes;
	}

	private ArrayList<Integer> getFiltersIndexes(String filter, String[][] matrix) {
		String div = filter.contains(",") ? "," : "\\.";
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		String[] unparsedFilters = filter.split("\\]");

		if(unparsedFilters.length > 0) {
			unparsedFilters[0] = unparsedFilters[0].replace("[", "");
			unparsedFilters[unparsedFilters.length - 1] = unparsedFilters[unparsedFilters.length - 1].replace("]", "");

			for(int i = 0; i < unparsedFilters.length; i++) {
				String unparsedFilter = unparsedFilters[i];

				if(unparsedFilter != null && !unparsedFilter.isEmpty()
					&& unparsedFilter.split("=").length > 1 && unparsedFilter.split("=")[1].split(div).length > 0) {
					String unparsedKey = unparsedFilter.split("=")[0];
					String parsedKey = unparsedKey.substring(unparsedKey.indexOf("[") + 1);
					ArrayList<String[]> filters = new ArrayList<String[]>();

					for(int j = 0; j < unparsedFilter.split("=")[1].split(div).length; j++) {
						filters.add(new String[]{ parsedKey, unparsedFilter.split("=")[1].split(div)[j]});
					}

					ArrayList<Integer> auxIndexes = getFilterIndex(filters, matrix);

					if(unparsedKey.replace(parsedKey, "").contains("|")) {
						indexes = interceptIndexes(indexes, auxIndexes);
					} else if(!unparsedKey.replace(parsedKey, "").contains("|")) {
						indexes = joinIndexes(indexes, auxIndexes);
					}
				}
			}
		}

		return indexes;
	}

	private ArrayList<Integer> getFilterIndex(ArrayList<String[]> filters, String[][] matrix) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for(int i = 1; i < matrix.length; i++) {
			boolean remove = true;

			for(int j = 0; j < filters.size(); j++) {
				if((filters.get(j)[1].startsWith("!")
					&& !matrix[i][ArrayUtils.getPositionInArray(matrix[0], filters.get(j)[0])].equals(filters.get(j)[1].substring(1)))
					|| matrix[i][ArrayUtils.getPositionInArray(matrix[0], filters.get(j)[0])].equals(filters.get(j)[1])) {
					remove = false;
				}
			}

			if(remove) indexes.add(i);
		}

		return indexes;
	}

	private String[][] removeRowsFromCasesMatrix(ArrayList<Integer> indexes, String[][] matrix) {
		for(int i = matrix.length - 1; i >= 0; i--) {
			if(indexes.contains(i + 1)) {
				matrix = ArrayUtils.removeRowFromMatrix(matrix, i);
			}
		}

		return matrix;
	}

	private String[][] removeRowsFromResultMatrix(ArrayList<Integer> indexes, String[][] matrix) {
		for(int i = matrix.length - 1; i > 0; i--) {
			if(indexes.contains(i)) {
				matrix = ArrayUtils.removeRowFromMatrix(matrix, i);
			}
		}

		return matrix;
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

			String getCsv = System.getProperty("get_csv");

			if(getCsv == null || getCsv.isEmpty()) {
				getCsv = testData.getConfigVar("get_csv");
			}

			// If "get_csv" is true, try to initialise resultMatrix from a
			// request
			if(getCsv != null && !getCsv.isEmpty() && Boolean.parseBoolean(getCsv) && clientId != null && apiUrl != null) {
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

			// If resultMatrix was not filled by a request, try to fill it with
			// an existent file
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
		// (the request didn't return a file, the file doesn't exist or the case
		// is not continue)
		if(casesMatrix == null || resultMatrix == null) {
			System.out.println("[INFO] - Creating test data");
			casesMatrix = InitUtils.getCasesMatrixFromBrowserArray(testCase, browsers, testData.getTestData().size());
			resultMatrix = InitUtils.getResultMatrixFromTestData(testData.getTestData(), browsers, testData.getCaseVariables());
		}

		// Filters the cases to execute depending on "execution_filter" leaving
		// the resultMatrix without modification
		String executionFilter = System.getProperty("execution_filter");

		if(executionFilter != null && !executionFilter.isEmpty()) {
			ArrayList<Integer> indexes = getFiltersIndexes(executionFilter, resultMatrix);

			casesMatrix = removeRowsFromCasesMatrix(indexes, casesMatrix);
		}

		// Filters the cases to execute depending on "test_filter" modifying the
		// resultMatrix leaving only the cases executed
		String testFilter = System.getProperty("test_filter");

		if(testFilter != null && !testFilter.isEmpty()) {
			ArrayList<Integer> indexes = getFiltersIndexes(testFilter, resultMatrix);

			resultMatrix = removeRowsFromResultMatrix(indexes, resultMatrix);
			casesMatrix = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
		}

		addTestObjects(testCase, testData, resultMatrix, casesMatrix.length);
		consoleLogs.put(testCase, new HashMap<String, ArrayList<String>>());

		System.out.println("[INFO] - Test to run on this execution: " + casesMatrix.length);

		if(!fileFromApi && casesMatrix.length == 0) {
			sendCsvToDatabase();
		}

		return casesMatrix.length == 0 ? null : casesMatrix;
	}
}
