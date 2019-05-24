package com.amaris.automation.model.testing;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.httprequest.RequestHelper;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.objects.DebugLogger;
import com.amaris.automation.model.webdriver.DriverHelper;
import com.amaris.automation.model.webdriver.configuration.BrowserType;

/**
 * The UserStory class is the base to execute test, having a reference to a getTestDataManager()anager, which uses using
 * its String variable "testId" to access the variables specific to a test, and the String variable "scenario" to access
 * the variables specific to a scenario.
 * 
 * It also controls the execution of the test, managing the errors to write them in a result file.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class UserStory {

	private int tries = 0;
	private long duration = 0;
	private String result = "";
	private String browser;
	private SuiteManager suiteM;
	private String testId = "0";
	private String scenario = "";
	private String testCase = "";
	private String lastException = "";
	private DriverHelper webDriver;
	private RequestHelper request;
	private DebugLogger logger = null;
	private ArrayList<Callable<Void>> actionList = new ArrayList<>();
	private ArrayList<Callable<Void>> onFailList = new ArrayList<>();
	private ArrayList<Callable<Void>> onSuccessList = new ArrayList<>();
	private ArrayList<Callable<Void>> onEndList = new ArrayList<>();
	private ArrayList<Callable<Void>> afterLastList = new ArrayList<>();

	public UserStory(String testCase, SuiteManager suiteM) {
		this.scenario = testCase;
		this.testCase = testCase;
		this.suiteM = suiteM;

		logger = new DebugLogger();
	}

	public UserStory(String id, String testCase, SuiteManager suiteM) {
		this.testId = id;
		this.scenario = testCase;
		this.testCase = testCase;
		this.suiteM = suiteM;

		logger = new DebugLogger(id);
	}

	public UserStory addData(DataObject dataObject, String key) {
		getTestDataManager().addData(dataObject, key);

		return this;
	}

	public UserStory addDMData(String fileName, String key) {
		getTestDataManager().addDMData(fileName, key);

		return this;
	}

	public UserStory addMData(String fileName, String key) {
		getTestDataManager().addMData(fileName, key);

		return this;
	}

	public String getTestId() {
		return testId;
	}

	public String getScenario() {
		return scenario;
	}

	public String getTestCase() {
		return testCase;
	}

	public String getResult() {
		return result;
	}

	public void assignBrowser() {
		if(suiteM.getMainDriver().equals(AutomationConstants.WEB)) {
			browser = assignIfNull(browser, getTestVar(AutomationConstants.BROWSER));
			browser = assignIfNull(browser, getConfigVar(AutomationConstants.BROWSER));
			browser = assignIfNull(browser, BrowserType.CHROME);
		} else if(suiteM.getMainDriver().equals(AutomationConstants.MOBILE_APP) || suiteM.getMainDriver().equals(AutomationConstants.MOBILE_WEB)) {
			browser = assignIfNull(browser, System.getProperty(AutomationConstants.DEVICE));
			browser = assignIfNull(browser, getTestVar(AutomationConstants.DEVICE));
			browser = assignIfNull(browser, getConfigVar(AutomationConstants.DEVICE));
		}
	}

	public String getBrowser() {
		if(browser == null) {
			assignBrowser();
		}

		return browser;
	}

	public String getLastException() {
		return lastException;
	}

	public int getTries() {
		return tries;
	}

	public int getMaxTries() {
		return suiteM.getMaxTries();
	}

	public long getDuration() {
		return duration;
	}

	private String[][] getResultMatrix() {
		return suiteM.getResultMatrix(testCase);
	}

	private String assignIfNull(String variable, String assign) {
		return variable == null ? assign : variable;
	}

	public DriverHelper getWebDriver() {
		if(webDriver == null) {
			assignBrowser();

			addDriverConfiguration();
		}

		return webDriver;
	}

	public RequestHelper getRequest() {
		if(request == null) {
			request = new RequestHelper();
		}

		return request;
	}

	public TestDataManager getTestDataManager() {
		return suiteM.getTestDataManager(testCase);
	}

	public DataObject getData(String key) {
		DataObject resultData = suiteM.getSuiteData(key);

		if(resultData == null) {
			resultData = getTestDataManager().getData(key);
		}

		return resultData;
	}

	public DataObject getConfigData() {
		return getTestDataManager().getConfigData();
	}

	public String getSuiteVar(String key) {
		return suiteM.getSuiteVar(key);
	}

	public String getGlobalVar(String key) {
		return getTestDataManager().getGlobalVar(key);
	}

	public String getScenarioVar(String key) {
		return getTestDataManager().getScenarioVar(scenario, key);
	}

	public String getTestVar(String key) {
		return getTestDataManager().getTestVar(testId, key);
	}

	public String getConfigVar(String key) {
		return getTestDataManager().getConfigVar(key);
	}

	public String getVar(String key) {
		String resultVar = getTestDataManager().getVar(key);

		if(resultVar == null) {
			resultVar = suiteM.getSuiteVar(key);
		}

		return resultVar;
	}

	public String getVar(String rowKey, String key) {
		String resultVar = getTestDataManager().getVar(rowKey, key);

		if(resultVar == null) {
			resultVar = suiteM.getSuiteVar(rowKey, key);
		}

		return resultVar;
	}

	public String getReportPath() {
		return getTestDataManager().getReportPath();
	}

	public String getTimeStamp() {
		return getTestDataManager().getTimeStamp();
	}

	public void setSuiteVar(String key, String value) {
		suiteM.setSuiteVar(key, value);
	}

	public void setGlobalVar(String key, String value) {
		getTestDataManager().setGlobalVar(key, value);
	}

	public void setScenarioVar(String key, String value) {
		getTestDataManager().setScenarioVar(scenario, key, value);
	}

	public void setTestVar(String key, String value) {
		getTestDataManager().setTestVar(testId, key, value);
	}

	public void setConfigVar(String key, String value) {
		getTestDataManager().setConfigVar(key, value);
	}

	public void setReportPath(String reportPath) {
		getTestDataManager().setReportPath(reportPath);
	}

	public UserStory setScenario(String scenario) {
		this.scenario = scenario;

		return this;
	}

	public UserStory testActions(Callable<Void> actions) {
		actionList.add(actions);

		return this;
	}

	public UserStory onSuccess(Callable<Void> actions) {
		onSuccessList.add(actions);

		return this;
	}

	public UserStory onFail(Callable<Void> actions) {
		onFailList.add(actions);

		return this;
	}

	public UserStory onEnd(Callable<Void> actions) {
		onEndList.add(actions);

		return this;
	}

	public UserStory onLastIteration(Callable<Void> actions) {
		afterLastList.add(actions);

		return this;
	}

	private void runFailActions() {
		if(!onFailList.isEmpty()) {
			String errorString = getTestDataManager().caseVariablesToString(testId);
			if(!errorString.isEmpty()) errorString += ", ";

			errorString += browser == null ? "" : AutomationConstants.BROWSER + ": " + browser + ", ";

			logger.error(errorString + "lastException: " + lastException);

			try {
				logger.begin();
				for(int i = 0; i < onFailList.size(); i++) {
					onFailList.get(i).call();
				}
				logger.end();
			} catch(Exception e) {
				logger.error("ON FAIL ACTIONS");
				logger.printStackTrace(e);
			}
		}
	}

	private void runSuccessActions() {
		if(!onSuccessList.isEmpty()) {
			try {
				logger.begin();
				for(int i = 0; i < onSuccessList.size(); i++) {
					onSuccessList.get(i).call();
				}
				logger.end();
			} catch(Exception e) {
				logger.error("ON SUCCESS ACTIONS");
				logger.printStackTrace(e);
			}
		}
	}

	private void runEndActions() {
		if(!onEndList.isEmpty()) {
			try {
				logger.begin();
				for(int i = 0; i < onEndList.size(); i++) {
					onEndList.get(i).call();
				}
				logger.end();
			} catch(Exception e) {
				logger.error("ON END ACTIONS");
				logger.printStackTrace(e);
			}
		}
	}

	private void runAfterLastIterationActions() {
		if(!afterLastList.isEmpty()) {
			try {
				logger.begin();
				for(int i = 0; i < afterLastList.size(); i++) {
					afterLastList.get(i).call();
				}
				logger.end();
			} catch(Exception e) {
				logger.error("AFTER LAST ITERATION ACTIONS");
				logger.printStackTrace(e);
			}
		}
	}

	private void handleTestEnd(boolean testResult, Exception exception, Error error) throws Exception {
		if(webDriver != null) suiteM.addConsoleLog(testCase, testId, webDriver.getConsoleLogs());

		if(!testResult) {
			result = AutomationConstants.TEST_FAILURE;

			runFailActions();
			runEndActions();
			logger.end();

			saveExceptionIntoFile(exception != null ? ExceptionUtils.getStackTrace(exception) : Arrays.toString(error.getStackTrace()), testId);

			String failure = "";

			if(exception != null && exception.getMessage() != null) {
				failure = exception.getMessage();
			} else if(error != null && error.getMessage() != null) {
				failure = error.getMessage();
			}

			logger.info("Test execution ended with failure" + (!failure.isEmpty() ? ": " + failure : ""));

			updateResultMatrix();

			if(exception != null) {
				throw exception;
			} else {
				throw error;
			}
		} else {
			result = AutomationConstants.TEST_SUCCESS;

			runSuccessActions();
			runEndActions();
			logger.end();

			updateResultMatrix();
		}
	}

	public Boolean run() throws Exception {
		boolean testResult = false;
		Exception exception = null;
		Error error = null;

		logger.begin();
		long startTime = System.currentTimeMillis();

		try {
			String infoString = getTestDataManager().caseVariablesToString(testId);
			if(!infoString.isEmpty() && browser != null) infoString += ", ";

			infoString += browser == null ? "" : AutomationConstants.BROWSER + ": " + browser;

			if(!infoString.isEmpty()) {
				logger.info(infoString);
			}

			for(int i = 0; i < actionList.size(); i++) {
				actionList.get(i).call();
			}

			logger.info("Test execution ended successfully");
			testResult = true;
		} catch(Exception e) {
			logger.error("EXCEPTION ON TEST ACTIONS: " + getTestDataManager().caseVariablesToString(testId));
			logger.printStackTrace(e);
			exception = e;

			takeErrorScreenshot();
		} catch(Error e) {
			logger.error("ERROR ON TEST ACTIONS: " + getTestDataManager().caseVariablesToString(testId));
			logger.printStackTrace(e);
			error = e;

			takeErrorScreenshot();
		}

		if(webDriver != null) webDriver.quit();

		if(suiteM.getTestsFinished(testCase) + 1 == suiteM.getTestsToRun(testCase) && !afterLastList.isEmpty()) {
			runAfterLastIterationActions();
		}

		if(!testResult && checkTries(exception, error)) {
			runFailActions();
			logger.end();

			return run();
		} else {
			duration = (System.currentTimeMillis() - startTime) / 1000;

			handleTestEnd(testResult, exception, error);

			return testResult;
		}
	}

	private UserStory addDriverConfiguration() {
		logger.begin();

		webDriver = new DriverHelper(browser, getConfigData());
		webDriver.setId(testId);

		String mainDriverValue = "";

		if(suiteM.getMainDriver().equals(AutomationConstants.WEB)
			|| suiteM.getMainDriver().equals(AutomationConstants.MOBILE_WEB)) {
			mainDriverValue = AutomationConstants.BROWSER;
		} else if(suiteM.getMainDriver().equals(AutomationConstants.MOBILE_APP)) {
			mainDriverValue = AutomationConstants.DEVICE;
		}

		getTestDataManager().setTestVar(testId, mainDriverValue, browser);
		logger.info(mainDriverValue + ": " + browser + ", ip: " + getConfigData().getValue(AutomationConstants.IP)
			+ ", port: " + getConfigData().getValue(AutomationConstants.PORT) + ", remote: " + getConfigData().getValue(AutomationConstants.REMOTE_MODE));

		logger.end();

		return this;
	}

	private synchronized UserStory takeErrorScreenshot() {
		try {
			if(getTimeStamp() != null && webDriver != null) {
				logger.begin();
				String fileName = "[ERROR] - " + getTimeStamp() + ".i" + testId;

				logger.info("Taking screenshot: " + fileName + ".jpg'");
				new File(getReportPath() + '/' + AutomationConstants.IMAGES_FOLDER).mkdirs();

				suiteM.sendImgToDatabase(suiteM.getTimeStampDriver(getTestDataManager()), getTimeStamp() + ".i" + testId, webDriver
					.takeScreenshot(fileName, getReportPath() + '/' + AutomationConstants.IMAGES_FOLDER));

				logger.end();
			}
		} catch(Exception e) {
			logger.end();
		}

		return this;
	}

	private synchronized boolean checkTries(Exception exception, Error error) {
		boolean resultAux = false;

		String failure = exception != null ? exception.getClass().getCanonicalName() : error.getClass().getCanonicalName();

		logger.info("Checking retry on fail: " + suiteM.getRetryOnFail()
			+ (suiteM.getRetryOnFail() ? ", max tries: " + suiteM.getMaxTries() + ", current tries: " + (tries + 1) : "")
			+ ((lastException != null && lastException.equals(failure)) ? ", stopping execution because of same error" : ""));

		if((suiteM.getRetryOnFail() && lastException != null && !lastException.equals(failure)) && tries < suiteM.getMaxTries()) {
			tries++;
			logger.info("Trying again");

			resultAux = true;
		} else if(suiteM.getRetryOnFail()) {
			logger.info("Last try, finishing with error");
		}

		lastException = failure;

		return resultAux;
	}

	public synchronized void saveExceptionIntoFile(String exception, String id) {
		logger.begin();

		try {
			new File(getReportPath() + '/' + AutomationConstants.EXCEPTIONS_FOLDER).mkdirs();

			FileUtils.writeFile(getReportPath() + '/' + AutomationConstants.EXCEPTIONS_FOLDER + getTimeStamp() + ".e" + Integer.parseInt(id) + ".txt", exception);
		} catch(Exception e) {
			logger.error("Saving Exception into file");
		}

		logger.end();
	}

	private String[] getExecutionResultArray(boolean addBrowserToMatrix) {
		String[] resultArray = new String[getTestDataManager().getCaseVariables().length + 3 + (addBrowserToMatrix ? 1 : 0)];

		for(int i = 0; i < getTestDataManager().getCaseVariables().length; i++) {
			resultArray[i] = getTestVar(getTestDataManager().getCaseVariables()[i]);
		}

		if(addBrowserToMatrix) resultArray[resultArray.length - 4] = getBrowser();
		resultArray[resultArray.length - 3] = result;
		resultArray[resultArray.length - 2] = Long.toString(duration);
		resultArray[resultArray.length - 1] = result.equals(AutomationConstants.TEST_SUCCESS) ? "" : lastException;

		return resultArray;
	}

	private void updateResultMatrix() {
		if(getResultMatrix() != null) {
			synchronized(getResultMatrix()) {
				try {
					logger.begin();

					String infoString = getTestDataManager().caseVariablesToString(testId);
					if(!infoString.isEmpty()) infoString += ", ";
					//TODO
					boolean addBrowserToMatrix = ArrayUtils.contains(getResultMatrix()[0], AutomationConstants.BROWSER);

					logger.info(infoString + (browser != null && addBrowserToMatrix ? "browser: " + browser + ", " : "") + "time: " + duration
						+ (lastException.isEmpty() || result.equals(AutomationConstants.TEST_SUCCESS) ? "" : ", report: " + lastException));

					getResultMatrix()[Integer.parseInt(testId) + 1] = getExecutionResultArray(addBrowserToMatrix);

					logger.info("Saving results as " + getTestDataManager().getTimeStamp() + ".csv");
					new File(getReportPath()).mkdirs();
					FileUtils.writeMatrixToCsvFile(getReportPath() + getTestDataManager().getTimeStamp() + ".csv", getResultMatrix());

					suiteM.updateTestsFinished(testCase);

					logger.end();
				} catch(Exception e) {
					logger.printStackTrace(e);
					logger.end();
					throw e;
				}
			}
		}
	}
}