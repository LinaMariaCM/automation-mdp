package com.automation.model.testing;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.utils.FileUtils;
import com.automation.model.utils.objects.DebugLogger;
import com.automation.model.webdriver.DriverHelper;
import com.automation.model.webdriver.configuration.BrowserType;

/**
 * The UserStory class is the base to execute test, having a reference to a TestDataManager, which uses using its String
 * variable "testId" to access the variables specific to a test, and the String variable "scenario" to access the
 * variables specific to a scenario.
 * 
 * It also controls the execution of the test, managing the errors to write them in a result file.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class UserStory {

	private int tries = 0;
	private int maxTries = 0;
	private long startTime;
	private long duration = 0;
	private String result = "";
	private String browser;
	private String timeStamp;
	private String reportPath;
	private SuiteManager suiteM;
	private String testId = "0";
	private String scenario = "";
	private String testCase = "";
	private String lastException = "";
	private DataObject driverConf;
	private DriverHelper webDriver;
	private String[][] resultMatrix;
	private TestDataManager testDataM;
	private boolean retryOnFail = false;
	private DebugLogger logger = null;
	private ArrayList<Callable<Void>> actionList = new ArrayList<>();
	private ArrayList<Callable<Void>> onFailList = new ArrayList<>();
	private ArrayList<Callable<Void>> onSuccessList = new ArrayList<>();
	private ArrayList<Callable<Void>> onEndList = new ArrayList<>();
	private ArrayList<Callable<Void>> afterLastList = new ArrayList<>();

	public UserStory(String scenario) {
		this.scenario = scenario;
		this.testCase = scenario;
		logger = new DebugLogger();
	}

	public UserStory(String id, String scenario) {
		this.scenario = scenario;
		this.testCase = scenario;
		this.testId = id;
		logger = new DebugLogger(id);
	}

	public UserStory addData(DataObject dataObject, String key) {
		testDataM.addData(dataObject, key);

		return this;
	}

	public UserStory addDMData(String fileName, String key) {
		testDataM.addDMData(fileName, key);

		return this;
	}

	public UserStory addMData(String fileName, String key) {
		testDataM.addMData(fileName, key);

		return this;
	}

	public UserStory addTestDataManager(TestDataManager testData) {
		this.testDataM = testData;

		if(!scenario.isEmpty() && testDataM.getTestVar(testId, "scenario") == null) {
			testDataM.setTestVar(testId, "scenario", scenario);
		}

		return this;
	}

	public UserStory initializeTestDataManager() {
		this.testDataM = new TestDataManager();

		return this;
	}

	public String getTestId() {
		return this.testId;
	}

	public String getScenario() {
		return this.scenario;
	}

	public String getTestCase() {
		return testCase;
	}

	public String getResult() {
		return this.result;
	}

	public String getBrowser() {
		return this.browser;
	}

	public String getLastException() {
		return this.lastException;
	}

	public int getTries() {
		return this.tries;
	}

	public int getMaxTries() {
		return this.maxTries;
	}

	public long getDuration() {
		return this.duration;
	}

	public DriverHelper getDriver() {
		return webDriver;
	}

	public TestDataManager getTestDataManager() {
		return testDataM;
	}

	public DataObject getData(String key) {
		return testDataM.getData(key);
	}

	public DataObject getConfigData() {
		return testDataM.getConfigData();
	}

	public String getGlobalVar(String key) {
		return testDataM.getGlobalVar(key);
	}

	public String getScenarioVar(String key) {
		return testDataM.getScenarioVar(scenario, key);
	}

	public String getTestVar(String key) {
		return testDataM.getTestVar(testId, key);
	}

	public String getConfigVar(String key) {
		return testDataM.getConfigVar(key);
	}

	public String getReportPath() {
		return testDataM.getReportPath();
	}

	public void setSuiteManager(SuiteManager suiteM) {
		this.suiteM = suiteM;
	}

	public void setGlobalVar(String key, String value) {
		testDataM.setGlobalVar(key, value);
	}

	public void setScenarioVar(String key, String value) {
		testDataM.setScenarioVar(scenario, key, value);
	}

	public void setTestVar(String key, String value) {
		testDataM.setTestVar(testId, key, value);
	}

	public void setConfigVar(String key, String value) {
		testDataM.setConfigVar(key, value);
	}

	public void setReportPath(String reportPath) {
		testDataM.setReportPath(reportPath);
	}

	public UserStory setDriver(DriverHelper webDriver) {
		this.webDriver = webDriver;

		return this;
	}

	public UserStory setRetryOnFail(boolean retry) {
		retryOnFail = retry;

		return this;
	}

	public UserStory setScenario(String scenario) {
		this.scenario = scenario;

		return this;
	}

	public UserStory setReportConfiguration(String timeStamp, String path, String[][] resultMatrix) {
		this.reportPath = path;
		this.timeStamp = timeStamp;
		this.resultMatrix = resultMatrix;

		return this;
	}

	public UserStory testActions(Callable<Void> actions) {
		actionList.add(actions);

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

	public UserStory afterLastIteration(Callable<Void> actions) {
		afterLastList.add(actions);

		return this;
	}

	private void runFailActions() {
		if(!onFailList.isEmpty()) {
			logger.error(testDataM.caseVariablesToString(testId) + " browser: " + getBrowser() + ", lastException: " + lastException);

			try {
				logger.begin();
				for(int i = 0; i < onFailList.size(); i++) {
					onFailList.get(i).call();
				}
				logger.end();
			} catch(Exception e1) {
				logger.error("ON FAIL ACTIONS");
				e1.printStackTrace();
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
			} catch(Exception e1) {
				logger.error("ON SUCCESS ACTIONS");
				e1.printStackTrace();
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
			} catch(Exception e1) {
				logger.error("ON END ACTIONS");
				e1.printStackTrace();
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
			} catch(Exception e1) {
				logger.error("AFTER LAST ITERATION ACTIONS");
				e1.printStackTrace();
			}
		}
	}

	public Boolean run() throws Exception {
		boolean testResult = false;
		Exception exception = null;
		Error error = null;

		logger.begin();
		startTime = System.currentTimeMillis();

		try {
			try {
				logger.info(testDataM.caseVariablesToString(testId) + ", browser: " + getBrowser());

				for(int i = 0; i < actionList.size(); i++) {
					actionList.get(i).call();
				}

				logger.info("Test execution ended successfully");
				testResult = true;
			} catch(Exception e) {
				logger.error("EXCEPTION ON TEST ACTIONS: " + testDataM.caseVariablesToString(testId));
				e.printStackTrace();
				exception = e;

				takeErrorScreenshot();
			} catch(Error e) {
				logger.error("ERROR ON TEST ACTIONS: " + testDataM.caseVariablesToString(testId));
				e.printStackTrace();
				error = e;

				takeErrorScreenshot();
			}
		} catch(Exception e) {
			logger.error("Initializing driver");
			e.printStackTrace();
			exception = e;
		}

		webDriver.quit();

		if(suiteM.getTestsFinished(testCase) + 1 == suiteM.getTestsToRun(testCase) && afterLastList.size() > 0) {
			runAfterLastIterationActions();
		}

		if(!testResult && checkTries(exception, error)) {
			runFailActions();
			logger.end();

			return run();
		} else {
			duration = (System.currentTimeMillis() - startTime) / 1000;

			if(!testResult) {
				result = AutomationConstants.TEST_FAILURE;

				runFailActions();
				runEndActions();
				logger.end();

				saveExceptionIntoFile(exception != null ? ExceptionUtils.getStackTrace(exception) : error.getStackTrace().toString(), testId);

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

				return testResult;
			}
		}
	}

	private boolean setBooleanOnConfiguration(String key) {
		String stringValue = System.getProperty(key);

		if(stringValue != null && stringValue.isEmpty()) stringValue = "true";

		if(stringValue == null) stringValue = driverConf.getValue(key);
		else driverConf.setValue(key, stringValue);

		return Boolean.parseBoolean(stringValue);
	}

	private String setStringOnConfiguration(String key) {
		String stringValue = System.getProperty(key);
		if((stringValue != null && stringValue.isEmpty()) || stringValue == null) stringValue = driverConf.getValue(key);
		else driverConf.setValue(key, stringValue);

		return stringValue;
	}
	
	private void setDriverWaits() {
		if(driverConf.getValue(AutomationConstants.WAIT_FOR_PAGE) != null
			|| (System.getProperty(AutomationConstants.WAIT_FOR_PAGE) != null
				&& !System.getProperty(AutomationConstants.WAIT_FOR_PAGE).isEmpty())) {
			webDriver.setWaitForPage(setBooleanOnConfiguration(AutomationConstants.WAIT_FOR_PAGE));
		}

		webDriver.setWaitForAngular(setBooleanOnConfiguration(AutomationConstants.WAIT_FOR_ANGULAR));
		webDriver.setWaitForJQuery(setBooleanOnConfiguration(AutomationConstants.WAIT_FOR_JQUERY));
		webDriver.setShowConsoleLog(setBooleanOnConfiguration(AutomationConstants.SHOW_CONSOLE_LOG));

		String timeout = System.getProperty(AutomationConstants.TIMEOUT);
		if(timeout != null && !timeout.isEmpty()) driverConf.setValue(AutomationConstants.TIMEOUT, timeout);
		if(driverConf.getValue(AutomationConstants.TIMEOUT) != null) {
			webDriver.setImplicitWait(Integer.parseInt(driverConf.getValue(AutomationConstants.TIMEOUT)));
			webDriver.setScriptWait(Integer.parseInt(driverConf.getValue(AutomationConstants.TIMEOUT)));
			webDriver.setPageLoadWait(Integer.parseInt(driverConf.getValue(AutomationConstants.TIMEOUT)));
		} else {
			webDriver.setImplicitWait(Integer.parseInt(driverConf.getValue(AutomationConstants.IMPLICIT_WAIT)));
			webDriver.setScriptWait(Integer.parseInt(driverConf.getValue(AutomationConstants.SCRIPT_WAIT)));
			webDriver.setPageLoadWait(Integer.parseInt(driverConf.getValue(AutomationConstants.PAGE_LOAD_WAIT)));
		}
	}
	
	private void setMobileVariables() {
		if(BrowserType.IPHONE.equals(webDriver.getBrowserType())) {
			webDriver.setDeviceName(System.getProperty(AutomationConstants.DEVICE_NAME));
		}

		if(System.getProperty(AutomationConstants.PLATFORM) != null && !System.getProperty(AutomationConstants.PLATFORM).isEmpty()) {
			webDriver.setDevicePlatform(System.getProperty(AutomationConstants.PLATFORM));

			String iosVersion = System.getProperty(AutomationConstants.DEVICE_VERSION);
			if(iosVersion != null && !iosVersion.isEmpty()) driverConf.setValue(webDriver.getDeviceName() + "_version", iosVersion);

			webDriver.setAppVariables(getConfigData());
		}

		webDriver.setEmulationBrowser(setStringOnConfiguration(AutomationConstants.EMULATION_BROWSER));
		webDriver.setAndroidEmulator(setBooleanOnConfiguration(AutomationConstants.ANDROID_EMULATOR));
	}
	
	private void setWindowVariables() {
		if(driverConf.getValue(AutomationConstants.SMALL_WINDOW_LIMIT) != null) {
			webDriver.setSmallWindowLimit(Integer.parseInt(driverConf.getValue(AutomationConstants.SMALL_WINDOW_LIMIT)));
		}

		webDriver.setMaximize(setBooleanOnConfiguration(AutomationConstants.MAXIMIZE_ON_START));

		if(driverConf.getValue(AutomationConstants.WINDOW_HEIGHT) != null && driverConf.getValue(AutomationConstants.WINDOW_WIDTH) != null) {
			webDriver.setWindowSize(Integer.parseInt(driverConf.getValue(AutomationConstants.WINDOW_WIDTH)), Integer.parseInt(driverConf.getValue(AutomationConstants.WINDOW_HEIGHT)));
		} else if(driverConf.getValue(AutomationConstants.WINDOW_HEIGHT) != null) {
			webDriver.setWindowSize(webDriver.getWindowDefaultHeight(), Integer.parseInt(driverConf.getValue(AutomationConstants.WINDOW_HEIGHT)));
		} else if(driverConf.getValue(AutomationConstants.WINDOW_WIDTH) != null) {
			webDriver.setWindowSize(Integer.parseInt(driverConf.getValue(AutomationConstants.WINDOW_WIDTH)), webDriver.getWindowDefaultWidth());
		}
	}
	
	private void setDriverPlugins() {
		String plugins = setStringOnConfiguration(AutomationConstants.DRIVER_PLUGINS);
		
		if(plugins != null && !plugins.isEmpty()) {
			if(!plugins.contains("\\.") && !plugins.contains(",")) {
				webDriver.addPluginFile(plugins);
			} else {
				String div = plugins.contains("\\.") ? "." : ",";
				String[] pluginsArray = plugins.split(div);
				
				for(String plugin : pluginsArray) {
					webDriver.addPluginFile(plugin);
				}
			}
		}
	}

	public void setConfigurationVariables() {
		webDriver.setId(testId);
		webDriver.setReportPath(testDataM.getReportPath());

		webDriver.setUseProxy(setBooleanOnConfiguration(AutomationConstants.USE_PROXY));
		setDriverWaits();
		
		setMobileVariables();

		webDriver.setWebDriverLanguage(setStringOnConfiguration(AutomationConstants.DRIVER_LANGUAGE));

		if(BrowserType.SAFARI.equals(webDriver.getEmulationBrowser()) || BrowserType.SAFARI.equals(browser)) {
			webDriver.setMacOsTechnologyPreview(setBooleanOnConfiguration(AutomationConstants.MACOS_PREVIEW));
			webDriver.setMacOsVersion(setStringOnConfiguration("macos_version"));
		}
		
		setDriverPlugins();

		webDriver.setDownloadDrivers(setBooleanOnConfiguration(AutomationConstants.DRIVER_DOWNLOAD));
		webDriver.setForceCache(setBooleanOnConfiguration(AutomationConstants.FORCE_CACHE));
		
		webDriver.setHub(setStringOnConfiguration(AutomationConstants.IP), setStringOnConfiguration(AutomationConstants.PORT));
		webDriver.setRemoteMode(setBooleanOnConfiguration(AutomationConstants.REMOTE_MODE));

		setWindowVariables();

		logger.info("browser: " + browser + ", ip: " + driverConf.getValue(AutomationConstants.IP)
			+ ", port: " + driverConf.getValue(AutomationConstants.PORT) + ", remote: " + driverConf.getValue(AutomationConstants.REMOTE_MODE));
	}

	public UserStory addDriverConfiguration(String browser, DataObject conf) {
		logger.begin();
		this.driverConf = conf;
		this.browser = browser;
		this.maxTries = Integer.parseInt(driverConf.getValue("max_tries"));
		this.retryOnFail = setBooleanOnConfiguration(AutomationConstants.RETRY_ON_FAIL);

		testDataM.setTestVar(testId, "browser", browser);

		webDriver = new DriverHelper(browser);

		setConfigurationVariables();

		logger.end();

		return this;
	}

	private synchronized boolean checkTries(Exception exception, Error error) {
		boolean result = false;

		String failure = exception != null ? exception.getClass().getCanonicalName() : error.getClass().getCanonicalName();

		logger.info("Checking retryOnFail: " + retryOnFail
			+ (retryOnFail ? ", max tries: " + maxTries + ", current tries: " + (tries + 1) : "")
			+ ((lastException != null && lastException.equals(failure)) ? ", stopping execution because of same error" : ""));

		if((retryOnFail && lastException != null && !lastException.equals(failure)) && tries < maxTries) {
			tries++;
			logger.info("Trying again");

			result = true;
		} else if(retryOnFail) {
			logger.info("Last try, finishing with error");
		}

		lastException = failure;

		return result;
	}

	public synchronized UserStory takeScreenshot() {
		logger.begin();
		try {
			if(timeStamp != null && webDriver != null) {
				new File(reportPath + "/" + AutomationConstants.IMAGES_FOLDER).mkdirs();

				webDriver.takeScreenshot(timeStamp + ".i" + testId, reportPath + "/" + AutomationConstants.IMAGES_FOLDER + "/");
			}
		} catch(Exception e) {
			logger.error("Taking screenshot");
		}
		logger.end();

		return this;
	}

	public synchronized UserStory takeErrorScreenshot() {
		try {
			if(timeStamp != null && webDriver != null) {
				logger.begin();
				String fileName = "[ERROR] - " + timeStamp + ".i" + testId;

				logger.info("Taking screenshot: " + fileName + ".jpg'");
				new File(reportPath + "/" + AutomationConstants.IMAGES_FOLDER).mkdirs();

				suiteM.sendImgToDatabase(timeStamp + ".i" + testId, webDriver.takeScreenshot(fileName, reportPath + "/" + AutomationConstants.IMAGES_FOLDER));

				logger.end();
			}
		} catch(Exception e) {
			logger.end();
		}

		return this;
	}

	public synchronized void saveExceptionIntoFile(String exception, String id) {
		logger.begin();
		try {
			new File(reportPath + "/" + AutomationConstants.EXCEPTIONS_FOLDER).mkdirs();

			FileUtils.writeFile(reportPath + "/" + AutomationConstants.EXCEPTIONS_FOLDER + this.timeStamp + ".e" + Integer.parseInt(id) + ".txt", exception);
		} catch(Exception e) {
			logger.error("Saving Exception into file");
		}
		logger.end();
	}

	private void updateResultMatrix() {
		if(resultMatrix != null) {
			synchronized(resultMatrix) {
				try {
					logger.begin();
					logger.info(testDataM.caseVariablesToString(testId) + ", browser: " + getBrowser() + ", time: " + duration
						+ (lastException.isEmpty() || result.equals(AutomationConstants.TEST_SUCCESS) ? "" : ", report: " + lastException));

					String[] resultArray = new String[testDataM.getCaseVariables().length + 4];

					for(int i = 0; i < testDataM.getCaseVariables().length; i++) {
						resultArray[i] = getTestVar(testDataM.getCaseVariables()[i]);
					}

					resultArray[resultArray.length - 4] = browser;
					resultArray[resultArray.length - 3] = result;
					resultArray[resultArray.length - 2] = Long.toString(duration);
					resultArray[resultArray.length - 1] = result.equals(AutomationConstants.TEST_SUCCESS) ? "" : lastException;

					resultMatrix[Integer.parseInt(testId) + 1] = resultArray;

					logger.info("Saving results as " + testDataM.getTimeStamp() + ".csv");
					new File(testDataM.getReportPath()).mkdirs();
					FileUtils.writeArrayIntoCSVFile(testDataM.getReportPath() + testDataM.getTimeStamp() + ".csv", resultMatrix);

					suiteM.updateTestsFinished(testCase);

					if(suiteM.getTestsFinished(testCase) == suiteM.getTestsToRun(testCase)) {
						logger.info("Last test execution from " + suiteM.getTestsToRun(testCase));
						suiteM.sendCsvToDatabase();
					} else {
						logger.info("Remaining executions "
							+ (suiteM.getTestsToRun(testCase) - suiteM.getTestsFinished(testCase)) + " from " + suiteM.getTestsToRun(testCase));
					}

					logger.end();
				} catch(Exception e) {
					e.printStackTrace();
					logger.end();
					throw e;
				}
			}
		}
	}
}