package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.utils.InitUtils;
import com.project.ProjectConstants;
import com.project.steps.Steps;

public class SiniestrosTest2 {

	
	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC_SINIESTROS);

	// PRUEBA MEC_SINIESTROS
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec01() {
		String testCase = ProjectConstants.MEC_SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta510(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000020", false);
		
			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta920(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "920017000", false);
		
			return null;
		}).run();
	}

	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta900(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "900918881", false);
		
			return null;
		}).run();
	}
	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta500(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "500553299", false);
		
			return null;
		}).run();
	}
	
	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta400(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "400009108", false);
		
			return null;
		}).run();
	}
	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta150(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "150403130", false);
		
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta200(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "200226110", false);
		
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta660(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "660000097", false);
		
			return null;
		}).run();
	}
	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta5000(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "50002522", false);
		
			return null;
		}).run();
	}

	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta600(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "600600172", false);
		
			return null;
		}).run();
	}
	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta610(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "610619142", false);
		
			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta620(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "620664851", false);
		
			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta630(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "630674325", false);
		
			return null;
		}).run();
	}
	

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAlta640(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "640701098", false);
		
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	
	public void siniestrosAltaAsistencia510(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		
		userS.testActions(() -> {
		
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000076", true);
		
			return null;
		}).run();
	}
	
	
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
	
}
