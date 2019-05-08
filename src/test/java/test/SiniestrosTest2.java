package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.ProjectConstants;
import com.amaris.project.steps.Steps;

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

	public void siniestrosAlta510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000020", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta920(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "920017000", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta900(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "900911779", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta500(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "500553299", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta400(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "400009108", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta150(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "150401435", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta200(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "200226110", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta660(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "660000097", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta5000(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "50002522", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta600(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "600601384", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta610(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "610619142", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta620(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "620664851", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta630(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "630674325", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta640(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "640701098", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAltaAsistencia510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000076", true, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestroEncargoImplicadoAdicional510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510004024", false, true, true);

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
