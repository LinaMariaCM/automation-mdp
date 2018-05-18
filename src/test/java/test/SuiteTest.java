package test;

import com.automation.model.utils.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.TestObject;
import com.project.ProjectConstants;
import com.project.steps.Steps;


public class SuiteTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC);

	// PRUEBA MEC01
	@DataProvider(parallel = true)
	public String[][] dataProviderMec01() {
		String testCase = ProjectConstants.MEC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec01")
	public void mec01(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {
			

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		CsvToHtml.createJointReport(suiteM);
	}
}
