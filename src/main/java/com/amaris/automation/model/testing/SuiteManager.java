package com.amaris.automation.model.testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.data.DataManagerObject;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.httprequest.RequestHelper;
import com.amaris.automation.model.utils.ArrayUtils;
import com.amaris.automation.model.utils.CsvToHtml;
import com.amaris.automation.model.utils.CsvToPdf;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.InitUtils;
import com.amaris.automation.model.utils.JiraMessager;
import com.amaris.automation.model.utils.JiraTicket;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.automation.model.utils.objects.DebugLogger;
import com.amaris.automation.model.utils.objects.Pair;

/**
 * The SuiteManager class is used to manage test objects like the
 * TestDataManager and the result matrix.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class SuiteManager {

	private int maxTries = 0;
	private String apiUrl;
	private String suiteName;
	private String projectId;
	private String mainDriver;
	private String reportPath;
	private String specialCase;
	private String testDataPath;
	private String scenarioDataPath;
	private String globalDataPath;
	private String initialTimeStamp;
	private boolean retryOnFail = false;
	private boolean testDataPathSet = false;
	private boolean globalDataPathSet = false;
	private boolean scenarioDataPathSet = false;
	private DebugLogger logger = new DebugLogger();
	private DataManagerObject suiteData = new DataManagerObject();
	private static final String FILE_SENT_SUCCESS_MESSAGE = "File sent correctly: ";
	private static final String FILE_SENT_FAILURE_MESSAGE = "Error sending file: ";
	private Map<String, Map<String, List<String>>> consoleLogs = new HashMap<>();
	// Pair<testCase name, int[]{tests to finish, tests finished, relevant
	// columns}>
	private ArrayList<Pair<String, int[]>> testCases = new ArrayList<>();
	// Pair<TestDataManager, resultMatrix>
	private Map<String, Pair<TestDataManager, String[][]>> testSuiteObject = new HashMap<>();

	public SuiteManager(String suiteName) {
		this.suiteName = suiteName;
		initialTimeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new java.util.Date());
	}

	public void setTestDataPath(String path) {
		testDataPathSet = true;
		testDataPath = path;
	}

	public void setScenarioDataPath(String path) {
		scenarioDataPathSet = true;
		scenarioDataPath = path;
	}

	public void setGlobalDataPath(String path) {
		globalDataPathSet = true;
		globalDataPath = path;
	}

	public String getName() {
		return suiteName;
	}

	public String getDailyCase() {
		return specialCase;
	}

	public String getMainDriver() {
		return mainDriver;
	}

	public int getMaxTries() {
		return maxTries;
	}

	public boolean getRetryOnFail() {
		return retryOnFail;
	}

	public String[] getSuiteDataKeys() {
		return this.suiteData.getKeySet();
	}

	public String getSuiteVar(String key) {
		String resultVar = null;

		for(String dataKey : suiteData.getKeySet()) {
			resultVar = getSuiteVar(dataKey, suiteData.getData(dataKey).getKey(), key);

			if(resultVar != null) {
				break;
			}
		}

		return resultVar;
	}

	public String getSuiteVar(String rowKey, String key) {
		String resultVar = null;

		for(String dataKey : suiteData.getKeySet()) {
			resultVar = getSuiteVar(dataKey, rowKey, key);

			if(resultVar != null) {
				break;
			}
		}

		return resultVar;
	}

	public String getSuiteVar(String suiteKey, String rowKey, String key) {
		String resultVar = null;

		if(suiteData.getData(suiteKey).getRow(rowKey) != null && suiteData.getData(suiteKey).getRow(rowKey).containsKey(key)) {
			resultVar = suiteData.getData(suiteKey).getValue(key);
		}

		return resultVar;
	}

	public void setSuiteVar(String key, String value) {
		if(getSuiteData(AutomationConstants.SUITE_DATA) == null) {
			addSuiteData(new DataObject().addRow("row"), AutomationConstants.SUITE_DATA);
		}

		getSuiteData(AutomationConstants.SUITE_DATA).setValue(key, value);
	}

	public void setSuiteVar(String rowKey, String key, String value) {
		boolean valueSet = false;

		for(String dataKey : suiteData.getKeySet()) {
			if(suiteData.getData(dataKey).getRow(rowKey) != null) {
				setSuiteVar(dataKey, rowKey, key, value);
				valueSet = true;
				break;
			}
		}

		if(!valueSet) {
			if(getSuiteData(AutomationConstants.SUITE_DATA) == null) {
				addSuiteData(new DataObject().addRow("row").addRow(rowKey).setKey(rowKey), AutomationConstants.SUITE_DATA);
			}

			getSuiteData(AutomationConstants.SUITE_DATA).setValue(rowKey, key, value);
		}
	}

	public void setSuiteVar(String suiteKey, String rowKey, String key, String value) {
		suiteData.getData(suiteKey).setValue(rowKey, key, value);
	}

	public DataObject getSuiteData(String dataKey) {
		return this.suiteData.getData(dataKey);
	}

	public void addSuiteData(DataObject dataObject, String dataKey) {
		suiteData.addData(dataKey, dataObject);
	}

	public void addSuiteData(String filePath, String dataKey) {
		if(filePath != null && !new File(filePath).isAbsolute()) filePath = AutomationConstants.RESOURCES_FOLDER + filePath;
		DataObject dataObject = new DataObject(FileUtils.fileToDMData(filePath));

		addSuiteData(dataObject, dataKey);
	}

	public void addConsoleLog(String testCase, String id, List<String> logs) {
		consoleLogs.get(testCase).put(id, logs);
	}

	public void setTestOrder(String[] testList) {
		ArrayList<Pair<String, int[]>> testCasesAux = new ArrayList<>();

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

	public void createModifiedHtmlReport(CsvToHtml reportClass) {
		createModifiedHtmlReport(reportClass, null);
	}

	public void createModifiedHtmlReport(CsvToHtml reportClass, String translationFile) {
		reportClass.createJointReport(this, translationFile);
	}

	public void createHtmlReport() {
		createHtmlReport(null);
	}

	public void createHtmlReport(String translationFile) {
		new CsvToHtml().createJointReport(this, translationFile);
	}

	public void createModifiedPdfReport(CsvToPdf reportClass) {
		createModifiedPdfReport(reportClass, null);
	}

	public void createModifiedPdfReport(CsvToPdf reportClass, String translationFile) {
		reportClass.createJointReport(this, translationFile);
	}

	public void createPdfReport() {
		createPdfReport(null);
	}

	public void createPdfReport(String translationFile) {
		new CsvToPdf().createJointReport(this, translationFile);
	}

	private String getLogsFromAllThreads(Pair<String, int[]> testCaseInfo) {
		StringBuilder result = new StringBuilder();
		int totalThreads = getResultMatrix(testCaseInfo.getKey()).length - 1;

		for(int i = 0; i < totalThreads; i++) {
			if(i == 0) {
				result.append("[" + testCaseInfo.getKey() + "]\n");
			}

			if(consoleLogs.get(testCaseInfo.getKey()).get(Integer.toString(i)) != null) {
				for(String log : consoleLogs.get(testCaseInfo.getKey()).get(Integer.toString(i))) {
					result.append("Thread(" + i + ") - " + log + "\n");
				}

				result.append("\n");
			}
		}

		return result.toString();
	}

	public void createLogReport() {
		StringBuilder result = new StringBuilder();
		String path = reportPath + '/' + suiteName + "ConsoleLogReport.txt";

		if(new File(reportPath + '/' + suiteName + "ConsoleLogReport.txt").exists()) {
			String fileText = FileUtils.readFile(path);

			result.append(fileText == null ? "" : fileText);
		}

		for(Pair<String, int[]> testCaseInfo : testCases) {
			result.append(getLogsFromAllThreads(testCaseInfo));
		}

		if(!result.toString().isEmpty()) {
			FileUtils.writeFile(path, result.toString());
		}
	}

	public String getInitialStamp() {
		return initialTimeStamp;
	}

	public String getTimeStamp() {
		String timeStampAux = testSuiteObject.get(testCases.get(0).getKey()).getKey().getTimeStamp();

		timeStampAux = timeStampAux.replace(testCases.get(0).getKey(), getName());

		return timeStampAux;
	}

	public String getTimeStamp(String testCase) {
		return testSuiteObject.get(testCase).getKey().getTimeStamp();
	}

	public synchronized TestDataManager getTestDataManager(String testCase) {
		TestDataManager testDataM = null;

		if(testSuiteObject.get(testCase) != null) {
			testDataM = testSuiteObject.get(testCase).getKey();
		}

		return testDataM;
	}

	public synchronized DataObject getConfigData(String testCase) {
		DataObject configData = null;

		if(testSuiteObject.get(testCase) != null) {
			configData = testSuiteObject.get(testCase).getKey().getConfigData();
		}

		return configData;
	}

	public synchronized String getConfigVar(String key) {
		String configVar = null;

		if(testCases.size() > 0 && testCases.get(0) != null && testCases.get(0).getKey() != null) {
			configVar = getConfigVar(testCases.get(0).getKey(), key);
		}

		return configVar;
	}

	public synchronized String getConfigVar(String testCase, String key) {
		String configVar = null;

		if(testSuiteObject.get(testCase) != null) {
			configVar = testSuiteObject.get(testCase).getKey().getConfigVar(key);
		}

		return configVar;
	}

	public String[][] getResultMatrix(String testCase) {
		String[][] testDataM = null;

		if(testSuiteObject.get(testCase) != null) {
			testDataM = testSuiteObject.get(testCase).getValue();
		}

		return testDataM;
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

		if(getTestsFinished(testCase) == getTestsToRun(testCase)) {
			logger.info("Last test execution from " + getTestsToRun(testCase));

			if(InitUtils.getBoolConfigVariable(AutomationConstants.SEND_CSV, getTestDataManager(testCase).getConfigData())) {
				sendAllCsvReport();
			}
		} else {
			logger.info("Remaining executions "
				+ (getTestsToRun(testCase) - getTestsFinished(testCase)) + " from " + getTestsToRun(testCase));
		}
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

	public synchronized int getRelevantColumns(String testCase) {
		int result = -1;

		for(int i = 0; i < testCases.size(); i++) {
			if(testCases.get(i).getKey().equals(testCase)) {
				synchronized(testCases) {
					result = testCases.get(i).getValue()[2];
				}
			}
		}

		return result;
	}

	public String getProjectId() {
		return projectId;
	}

	private void setProjectId(DataObject config) {
		if(projectId == null) {
			projectId = InitUtils.getStringConfigVariable(AutomationConstants.PROJECT_ID, config);
		}
	}

	public void sendImgToDatabase(String mainDriver, String fileName, byte[] image) {
		String sendImg = System.getProperty(AutomationConstants.SEND_IMG);

		if(image != null && sendImg != null && !sendImg.isEmpty() && Boolean.parseBoolean(sendImg)) {
			try {
				RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/images")
					.addHeader("Encoding", "base64")
					.setSendFile("imagefile", fileName + ".png", "image/png", Base64.getEncoder().encodeToString(image));

				if(request.post().getStatusCode() == 201) {
					logger.info("Image sent correctly: " + fileName);
				} else {
					logger.info("Error sending image: " + fileName);
				}
			} catch(Exception e) {
				logger.error("Error sending image: " + fileName);
				logger.printStackTrace(e);
			}
		}
	}

	public void sendHtmlToDatabase(String fileName, String text) {
		sendHtmlToDatabase(fileName, text, false);
	}

	public void sendHtmlToDatabase(String fileName, String text, boolean force) {
		if(InitUtils.getBoolConfigVariable(AutomationConstants.SEND_CSV) || force) {
			try {
				RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/html/" + fileName)
					.setSendFile(fileName, "text/html; charset=utf-8", text);
	
				if(request.post().getStatusCode() == 201) {
					logger.info(FILE_SENT_SUCCESS_MESSAGE + fileName);
				} else {
					logger.info(FILE_SENT_FAILURE_MESSAGE + fileName +
						(request.getResponseMessage() != null ? " (" + request.getStatusCode() + " - " + request.getResponseMessage() + ")" : ""));
					if(request.getResponseAsString() != null) logger.info(request.getResponseAsString());
				}
			} catch(Exception e) {
				logger.error("Error sending html: " + fileName);
				logger.printStackTrace(e);
			}
		}
	}

	public String[][] getCsvFile(String fileName) {
		return getCsvFile(fileName, false);
	}

	public String[][] getCsvFile(String fileName, boolean force) {
		String[][] result = null;

		if(InitUtils.getBoolConfigVariable(AutomationConstants.GET_CSV) || force) {
			try {
				fileName = fileName.endsWith(".csv") ? fileName : fileName + ".csv";
				RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/csvfile/" + fileName);
	
				if(request.get().getStatusCode() == 200) {
					logger.info("File was received correctly: " + fileName);
					result = InitUtils.getResultMatrixFromCsvString(request.getResponseAsString().replaceAll("\r\n", "\n"));
				} else {
					logger.error("File wasn't received: " + fileName);
				}
			} catch(Exception e) {
				logger.error("Error getting CSV file: " + fileName);
				logger.printStackTrace(e);
			}
		}

		return result;
	}

	public void sendCsvFile(String fileName, String text) {
		sendCsvFile(fileName, text, false);
	}

	public void sendCsvFile(String fileName, String text, boolean force) {
		if(InitUtils.getBoolConfigVariable(AutomationConstants.SEND_CSV) || force) {
			try {
				fileName = fileName.endsWith(".csv") ? fileName : fileName + ".csv";
				RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/csvfile/" + fileName)
					.setSendFile(fileName, "text/csv", text);

				if(request.post().getStatusCode() == 201) {
					logger.info(FILE_SENT_SUCCESS_MESSAGE + fileName);
				} else {
					logger.info(FILE_SENT_FAILURE_MESSAGE + fileName +
						(request.getResponseMessage() != null ? " (" + request.getStatusCode() + " - " + request.getResponseMessage() + ")" : ""));
					if(request.getResponseAsString() != null) logger.info(request.getResponseAsString());
				}
			} catch(Exception e) {
				logger.error("Error sending the CSV file: " + fileName);
				logger.printStackTrace(e);
			}
		}
	}

	public String[][] getCsvReport(String timeStamp) {
		String[][] result = null;
		
		try {
			RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/csv/" + timeStamp + ".csv");
	
			if(request.get().getStatusCode() == 200) {
				logger.info("File was received correctly: " + timeStamp + ".csv");
				result = InitUtils.getResultMatrixFromCsvString(request.getResponseAsString().replaceAll("\r\n", "\n"));
			} else {
				logger.error("File wasn't received: " + timeStamp + ".csv");
			}
		} catch(Exception e) {
			logger.error("Error geting the CSV report: " + timeStamp);
			logger.printStackTrace(e);
		}

		return result;
	}

	public void sendCsvReport(String fileName, String text, String driver) {
		try {
			fileName = fileName.endsWith(".csv") ? fileName : fileName + ".csv";
			String buildId = projectId + suiteName + (driver.isEmpty() ? "" : "." + driver) + initialTimeStamp;
	
			RequestHelper request = new RequestHelper(apiUrl + "/" + projectId + "/post/" + suiteName + "/" + buildId);
	
			request.setSendFile(fileName, "text/csv", text)
				.post();
	
			if(request.getStatusCode() == 201) {
				logger.info(FILE_SENT_SUCCESS_MESSAGE + fileName);
			} else {
				logger.info(FILE_SENT_FAILURE_MESSAGE + fileName +
					(request.getResponseMessage() != null ? " (" + request.getStatusCode() + " - " + request.getResponseMessage() + ")" : ""));
				if(request.getResponseAsString() != null) logger.info(request.getResponseAsString());
			}
		} catch(Exception e) {
			logger.error("Error sending the CSV report: " + fileName);
			logger.printStackTrace(e);
		}
	}

	private static String getResultStringWithRelevantColumn(String[][] resultMatrix, int relevantColumns) {
		String[][] result = new String[resultMatrix.length][resultMatrix[0].length];

		for(int i = 0; i < resultMatrix.length; i++) {
			for(int j = 0; j < resultMatrix[i].length; j++) {
				result[i][j] = resultMatrix[i][j];

				if(i == 0 && j == relevantColumns) {
					result[i][j] = "*" + result[i][j];
				}
			}
		}

		return ArrayUtils.matrixToString(result, "\n", ";");
	}

	protected void sendAllCsvReport() {
		if(projectId == null) {
			logger.error("File not sent: client id not declared");
		} else if(apiUrl == null) {
			logger.error("File not sent: api_url is null");
		} else {
			for(int i = 0; i < testCases.size(); i++) {
				String testCase = testCases.get(i).getKey();
				String driver = getTimeStampDriver(getTestDataManager(testCase));
				String fileName = getTestDataManager(testCase).getTimeStamp() + ".csv";

				sendCsvReport(fileName, getResultStringWithRelevantColumn(getResultMatrix(testCase), getRelevantColumns(testCase)), driver);
			}
		}
	}

	protected void updateZephyrTicket(String jiraTicketId, String result) {
		DataObject configData = getTestDataManager(testCases.get(0).getKey()).getConfigData();

		String url = InitUtils.getStringConfigVariable("jira_url", configData);
		String user = InitUtils.getStringConfigVariable("jira_user", configData);
		String pass = InitUtils.getStringConfigVariable("jira_pass", configData);
		String project = InitUtils.getStringConfigVariable("jira_project", configData);

		if(url != null && !url.isEmpty() && user != null && !user.isEmpty()
			&& pass != null && !pass.isEmpty() && project != null && !project.isEmpty()) {
			new JiraMessager(url, user, pass).updateZephyrTicket(jiraTicketId, result);
		}
	}

	protected void createJiraTicket(UserStory userS, Throwable throwable) {
		DataObject configData = getTestDataManager(testCases.get(0).getKey()).getConfigData();

		String url = InitUtils.getStringConfigVariable("jira_url", configData);
		String user = InitUtils.getStringConfigVariable("jira_user", configData);
		String pass = InitUtils.getStringConfigVariable("jira_pass", configData);
		String project = InitUtils.getStringConfigVariable("jira_project", configData);

		if(url != null && !url.isEmpty() && user != null && !user.isEmpty()
			&& pass != null && !pass.isEmpty() && project != null && !project.isEmpty()) {
			JiraTicket ticket = new JiraTicket();

			String stackTrace = "";
			String failingLine = "";

			for(int i = 0; i < throwable.getStackTrace().length; i++) {
				if(i != 0) stackTrace += "\n";
				stackTrace += throwable.getStackTrace()[i].toString();

				if(failingLine.isEmpty() && throwable.getStackTrace()[i].toString().contains("com.amaris.project")) {
					failingLine = throwable.getStackTrace()[i].toString();
				}
			}

			if(failingLine.isEmpty()) {
				failingLine = "Bug";
			}

			ticket.setProject(project);
			ticket.setSummary("Bug - " + StringUtils.snakeCaseToNatural(suiteName + ": " + userS.getTestCase())
				+ " (" + failingLine.substring(failingLine.indexOf('(') + 1, failingLine.indexOf(')')) + ")");
			ticket.setIssueType("10008");
			ticket.setPriority("3");
			ticket.setDescription(throwable.toString() + "\n" + stackTrace);

			if(userS.getTestVar(AutomationConstants.JIRA_TEST_ID) != null) {
				ticket.setLink("relates to", userS.getTestVar(AutomationConstants.JIRA_TEST_ID));
			}

			new JiraMessager(url, user, pass).sendTicket(ticket);
		}
	}

	public synchronized String[][] removeDeviceEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] result = null;
		String[][] resultMatrix = getResultMatrix(testCase);

		if(casesMatrix != null) {
			resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getDeviceEmulationBrowsers(), 2);
			result = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
			result = applyExecutionFilter(resultMatrix, result);

			if(casesMatrix.length == 0) {
				for(int i = 0; i < testCases.size(); i++) {
					if(testCases.get(i).getKey().equals(testCase)) {
						testCases.remove(i);
						break;
					}
				}

				testSuiteObject.remove(testCase);
			} else {
				testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
			}
		}

		return result;
	}

	public synchronized String[][] removeMobileEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = null;

		if(casesMatrix != null) {
			resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getMobileEmulationBrowsers(), 2);
			result = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
			result = applyExecutionFilter(resultMatrix, result);

			if(casesMatrix.length == 0) {
				for(int i = 0; i < testCases.size(); i++) {
					if(testCases.get(i).getKey().equals(testCase)) {
						testCases.remove(i);
						break;
					}
				}
				testSuiteObject.remove(testCase);
			} else {
				testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
			}
		}

		return result;
	}

	public synchronized String[][] removeTabletEmulationCases(String testCase, String[][] casesMatrix) {
		String[][] resultMatrix = getResultMatrix(testCase);
		String[][] result = null;

		if(casesMatrix != null) {
			resultMatrix = ArrayUtils.removeRowsContaining(resultMatrix, InitUtils.getTabletEmulationBrowsers(), 2);
			result = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
			result = applyExecutionFilter(resultMatrix, result);

			if(casesMatrix.length == 0) {
				for(int i = 0; i < testCases.size(); i++) {
					if(testCases.get(i).getKey().equals(testCase)) {
						testCases.remove(i);
						break;
					}
				}

				testSuiteObject.remove(testCase);
			} else {
				testSuiteObject.replace(testCase, new Pair<TestDataManager, String[][]>(testSuiteObject.get(testCase).getKey(), resultMatrix));
			}
		}

		return result;
	}

	public synchronized void addTestObjects(String testCase, TestDataManager testDataM, String[][] resultMatrix, int testsToRun) {
		testSuiteObject.put(testCase, new Pair<TestDataManager, String[][]>(testDataM, resultMatrix));
		testCases.add(new Pair<String, int[]>(testCase, new int[]{ testsToRun, 0, -1}));
	}

	private String getBrowserArgument(TestDataManager testDataM) {
		String browserArgument = System.getProperty(AutomationConstants.BROWSER);

		if((browserArgument == null || browserArgument.isEmpty())
			&& mainDriver != null && (mainDriver.equals(AutomationConstants.WEB) || mainDriver.equals(AutomationConstants.MOBILE_WEB))) {
			browserArgument = testDataM.getConfigVar(AutomationConstants.BROWSER);
		}

		return browserArgument;
	}

	private String getDeviceArgument(TestDataManager testDataM) {
		String decviceArgument = System.getProperty(AutomationConstants.DEVICE);

		if((decviceArgument == null || decviceArgument.isEmpty()) && mainDriver != null && (mainDriver.equals(AutomationConstants.MOBILE_APP) || mainDriver.equals(AutomationConstants.MOBILE_WEB))) {
			decviceArgument = testDataM.getConfigVar(AutomationConstants.DEVICE);
		}

		return decviceArgument;
	}

	private String getPlatformArgument(TestDataManager testDataM) {
		String platformArgument = System.getProperty(AutomationConstants.PLATFORM);

		if((platformArgument == null || platformArgument.isEmpty()) && mainDriver != null && (mainDriver.equals(AutomationConstants.MOBILE_APP) || mainDriver.equals(AutomationConstants.MOBILE_WEB))) {
			platformArgument = testDataM.getConfigVar(AutomationConstants.PLATFORM);
		}

		return platformArgument;
	}

	private void addBrowserToTestData(TestDataManager testDataM) {
		String browserArgument = getBrowserArgument(testDataM);
		String deviceArgument = getDeviceArgument(testDataM);

		if((mainDriver.equals(AutomationConstants.WEB) || mainDriver.equals(AutomationConstants.MOBILE_WEB))
			&& testDataM.getTestData() != null && testDataM.getTestData().getRow() != null
			&& !testDataM.getTestData().getRow().containsKey(AutomationConstants.BROWSER) && browserArgument != null && !browserArgument.isEmpty()) {
			for(int i = 0; i < testDataM.getTestData().size(); i++) {
				testDataM.getTestData().getRow(Integer.toString(i)).put(AutomationConstants.BROWSER, browserArgument);
			}
		}

		if((mainDriver.equals(AutomationConstants.MOBILE_APP) || mainDriver.equals(AutomationConstants.MOBILE_WEB))
			&& testDataM.getTestData() != null && testDataM.getTestData().getRow() != null
			&& !testDataM.getTestData().getRow().containsKey(AutomationConstants.PLATFORM) && deviceArgument != null && !deviceArgument.isEmpty()) {
			for(int i = 0; i < testDataM.getTestData().size(); i++) {
				testDataM.getTestData().getRow(Integer.toString(i)).put(AutomationConstants.PLATFORM, deviceArgument);
				testDataM.getTestData().getRow(Integer.toString(i)).put(AutomationConstants.DEVICE, deviceArgument);
			}
		}
	}

	private void setMainDriver(DataObject configData) {
		if(mainDriver == null) {
			mainDriver = InitUtils.getMainDriverFromProperties();

			if((mainDriver == null || mainDriver.isEmpty()) && configData != null
				&& configData.getValue(AutomationConstants.MAIN_DRIVER) != null && !configData.getValue(AutomationConstants.MAIN_DRIVER).isEmpty()) {
				mainDriver = configData.getValue(AutomationConstants.MAIN_DRIVER);
			}

			if(mainDriver == null || mainDriver.isEmpty()) {
				mainDriver = "api";
			}
		}
	}

	private void setCaseVariables(String testDataPath, TestDataManager testDataM) {
		if(testDataPath != null) {
			testDataM.setCaseVariables(FileUtils.csvFileToMatrix(testDataPath)[0]);
		} else {
			testDataM.setCaseVariables(new String[]{ "id"});
		}
	}

	private void setMaxTries(DataObject configData) {
		if(StringUtils.isNumber(InitUtils.setStringConfigVariable(AutomationConstants.MAX_TRIES, configData))) {
			this.maxTries = Integer.parseInt(configData.getValue(AutomationConstants.MAX_TRIES));
		} else {
			configData.setValue(AutomationConstants.MAX_TRIES, Integer.toString(maxTries));
		}
	}

	private void setApiUrl(DataObject configData) {
		if(apiUrl == null) {
			String serverUrl = System.getProperty(AutomationConstants.API_URL);

			if(serverUrl != null && !serverUrl.isEmpty()) {
				apiUrl = serverUrl;
				configData.setValue(AutomationConstants.API_URL, apiUrl);
			} else {
				apiUrl = configData.getValue(AutomationConstants.API_URL);
			}
		} else {
			configData.setValue(AutomationConstants.API_URL, apiUrl);
		}
	}

	private String[][] getResultMatrixFromApi(TestDataManager testDataM) {
		String[][] resultMatrix = null;
		boolean getCsv = InitUtils.getBoolConfigVariable(AutomationConstants.GET_CSV, testDataM.getConfigData());

		// If "get_csv" is true, try to initialise resultMatrix from a request
		if(getCsv && projectId != null && apiUrl != null) {
			resultMatrix = getCsvReport(testDataM.getTimeStamp());
		}

		if(getCsv && projectId == null) logger.info("Project ID not declared");
		if(getCsv && apiUrl == null) logger.info("API URL not declared");

		return resultMatrix;
	}

	private String[][] applyExecutionFilter(String[][] resultMatrix, String[][] casesMatrix) {
		// Filters the cases to execute depending on "execution_filter" leaving
		// the resultMatrix without modification
		String executionFilter = System.getProperty(AutomationConstants.EXECUTION_FILTER);

		if(executionFilter != null && !executionFilter.isEmpty()) {
			logger.info("Applying execution filter (" + executionFilter + ")");
			List<Integer> removeIndexes = ArrayUtils.getFiltersIndexes(executionFilter, resultMatrix);

			for(int i = 0; i < removeIndexes.size(); i++) {
				removeIndexes.set(i, removeIndexes.get(i) - 1);
			}

			casesMatrix = ArrayUtils.removeRowsContaining(casesMatrix, ArrayUtils.integerArrayToStringArray(removeIndexes.toArray(new Integer[0])), 1);
		}

		return casesMatrix;
	}

	private void handleNoCasesToRunWithApi(boolean fileFromApi, TestDataManager testDataM, String[][] resultMatrix, String[][] casesMatrix) {
		if(!fileFromApi && casesMatrix.length == 0 && InitUtils.getBoolConfigVariable(AutomationConstants.SEND_CSV, testDataM.getConfigData())) {
			sendAllCsvReport();
		} else if(fileFromApi && casesMatrix.length == 0) {
			new File(testDataM.getReportPath()).mkdirs();

			FileUtils.writeMatrixToCsvFile(testDataM.getReportPath() + testDataM.getTimeStamp() + ".csv", resultMatrix);
		}
	}

	protected String getTimeStampDriver(TestDataManager testDataM) {
		String timeStampDriver = "";

		if(mainDriver.equals(AutomationConstants.WEB) || mainDriver.equals(AutomationConstants.MOBILE_WEB)) {
			timeStampDriver = getBrowserArgument(testDataM);
		}

		if(mainDriver.equals(AutomationConstants.MOBILE_APP) || mainDriver.equals(AutomationConstants.MOBILE_WEB)) {
			String device = InitUtils.getStringConfigVariable(AutomationConstants.DEVICE, testDataM.getConfigData());

			timeStampDriver = timeStampDriver != null && timeStampDriver.isEmpty() ? device : device + "." + timeStampDriver;
		}

		if(timeStampDriver == null || timeStampDriver.isEmpty()) timeStampDriver = "api";

		return timeStampDriver;
	}

	public String[][] initializeTestObjects(String testCase) {
		return initializeTestObjects(testCase, scenarioDataPathSet ? scenarioDataPath : null);
	}

	public String[][] initializeTestObjects(String testCase, String scenarioDataPath) {
		return initializeTestObjects(testCase, scenarioDataPath, testDataPathSet ? testDataPath : null);
	}

	public String[][] initializeTestObjects(String testCase, String scenarioDataPath, String testDataPath) {
		return initializeTestObjects(testCase, scenarioDataPath, testDataPath, globalDataPathSet ? globalDataPath : null);
	}

	public String[][] initializeTestObjects(String testCase, String scenarioDataPath, String testDataPath, String globalDataPath) {
		logger.info("Case: " + testCase);
		String[][] casesMatrix = null;
		String[][] resultMatrix = null;

		testDataPath = InitUtils.getTestDataPath(testDataPath);

		TestDataManager testDataM = InitUtils.initializeTestData(testDataPath, scenarioDataPath, globalDataPath, AutomationConstants.CONFIGURATION_DATA);

		setMainDriver(testDataM.getConfigData());
		addBrowserToTestData(testDataM);

		testDataM.generateTimeStamp(testCase, getTimeStampDriver(testDataM));

		reportPath = testDataM.getReportPath();
		testDataM.setConfigVar(AutomationConstants.REPORT_PATH, reportPath);

		setCaseVariables(testDataPath, testDataM);
		setProjectId(testDataM.getConfigData());
		setMaxTries(testDataM.getConfigData());
		setApiUrl(testDataM.getConfigData());
		this.retryOnFail = InitUtils.setBoolConfigVariable(AutomationConstants.RETRY_ON_FAIL, testDataM.getConfigData());

		boolean fileFromApi = false;

		specialCase = testDataM.getDailyCase();

		if(testDataM.getDailyCase().contains("continue")) {
			logger.info("Continue daily");

			resultMatrix = getResultMatrixFromApi(testDataM);

			if(resultMatrix != null) fileFromApi = true;

			// If resultMatrix was not filled by a request, try to fill it with
			// an existent file
			if(resultMatrix == null && new File(testDataM.getReportPath() + testDataM.getTimeStamp() + ".csv").exists()) {
				logger.info("Getting test data from report file '" + testDataM.getTimeStamp() + ".csv'");
				resultMatrix = InitUtils.getResultMatrixFromCsvFile(testDataM.getReportPath() + testDataM.getTimeStamp() + ".csv");
			}

			// If resultMatrix was filled, fill casesMatrix
			if(resultMatrix != null) {
				casesMatrix = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix, testCase);
			}
		}

		// If neither casesMatrix nor resultMatrix are filled at this point
		// (the request didn't return a file, the file doesn't exist or the case
		// is not continue)
		if(casesMatrix == null) {
			logger.info("Creating " + (testDataPath == null ? "base test data" : "test data from file '" + testDataPath + "'"));
			casesMatrix = InitUtils.getCasesMatrixFromTestData(testCase, testDataM.getTestData().size());
			resultMatrix = InitUtils.getResultMatrixFromTestData(testDataM.getTestData(), testDataM.getCaseVariables());
		}

		casesMatrix = applyExecutionFilter(resultMatrix, casesMatrix);

		addTestObjects(testCase, testDataM, resultMatrix, casesMatrix.length);
		consoleLogs.put(testCase, new HashMap<String, List<String>>());

		logger.info("Cases to run on this execution: " + casesMatrix.length
			+ (casesMatrix.length != resultMatrix.length - 1 ? " from " + (resultMatrix.length - 1) : ""));

		handleNoCasesToRunWithApi(fileFromApi, testDataM, resultMatrix, casesMatrix);

		return casesMatrix.length == 0 ? null : casesMatrix;
	}

	public UserStory createUserStory(String testCase, String id) {
		return new UserStory(id, testCase, this);
	}
}