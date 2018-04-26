package test;

import java.io.File;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.configuration.AutomationConstants;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.FileUtils;
import com.automation.model.utils.InitUtils;
import com.automation.model.utils.OSUtils;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.project.ProjectConstants;
import com.project.steps.Steps;

public class TestSuite {

	private TestDataManager testData;
	private String testCase = ProjectConstants.MAC;
	private String[][] casesMatrix = null, resultMatrix = null;
	private String defaultTestData = "testDataTest.csv", defaultScenarioData = "scenarioData.csv";

	public boolean doTest(UserStory userS, Steps steps) throws Exception {
		userS.setScenario(testCase + "01");
		return userS.testActions(() -> {
			
			
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProvider() {
		return this.casesMatrix;
	}

	@Test(dataProvider = "dataProvider")
	public void Test(String id, String browser) throws Exception {
		if(resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3] == null
			|| !resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
			UserStory userS = new UserStory(id, testCase)
				.addTestDataManager(testData)
				.addDriverConfiguration(browser, testData.getConfigData())
				.setReportConfiguration(testData.getTimeStamp(), testData.getReportPath(), resultMatrix);

			Steps steps = new Steps(userS);

			doTest(userS, steps);
		}
	}

	@BeforeSuite
	public synchronized void initializeExecution(ITestContext context) {
		System.out.println("[INFO] - Initializing execution for OS: " + OSUtils.getOsName());
		String[] browsers = InitUtils.getTestBrowsers();

		testData = InitUtils.initializeTestData(InitUtils.getTestDataPath(defaultTestData), defaultScenarioData, AutomationConstants.CONFIGURATION_DATA_SET);
		testData.generateTimeStamp(testCase);
		testData.setCaseVariables(FileUtils.loadDataFileToArray(InitUtils.getTestDataPath(defaultTestData), true)[0]);

		testData.getTestData().duplicateDataByN(browsers.length);

		if(testData.getDailyCase().contains("continue") && new File(testData.getReportPath() + testData.getTimeStamp() + ".csv").exists()) {
			System.out.println("[INFO] - Continue daily");
			resultMatrix = InitUtils.getResultMatrixFromCsvFile(testData.getReportPath() + testData.getTimeStamp() + ".csv");
			casesMatrix = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix);
		} else {
			casesMatrix = InitUtils.getCasesMatrixFromBrowserArray(browsers, testData.getTestData().size());
			resultMatrix = InitUtils.getResultMatrixFromTestData(testData.getTestData(), browsers, testData.getCaseVariables());
		}
		
		InitUtils.setThreads(context);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("[INFO] - Generating HTML...");
		CsvToHtml.createReport(testData.getTimeStamp(), testData.getReportPath(), testCase);
	}
}
