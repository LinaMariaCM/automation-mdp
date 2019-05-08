package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.ProjectConstants;
import com.amaris.project.steps.Steps;


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
	public void mec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {
			

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
