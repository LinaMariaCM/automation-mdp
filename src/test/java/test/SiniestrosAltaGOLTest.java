package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;
import com.amaris.project.steps.Steps;

public class SiniestrosAltaGOLTest {

	protected SuiteManager suiteM = new SuiteManager(Constants.MEC_SINIESTROS);

	// PRUEBA MEC_SINIESTROS
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec01() {
		String testCase = Constants.MEC_SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.testActions(() -> {
			steps.login("GOL", "640");

			steps.alta_siniestroAlt("GOL", "510006850", false, false, false);

			return null;
		}).run();
	}

	//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec02() {
			String testCase = Constants.MEC_SINIESTROS + "02";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec02")

		public void siniestrosAlta500(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "500504786", false, false, false);

				return null;
			}).run();
		}
		
		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec03() {
			String testCase = Constants.MEC_SINIESTROS + "03";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec03")

		public void siniestrosAlta400(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "325", false, false, false);

				return null;
			}).run();
		}
		
		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec04() {
			String testCase = Constants.MEC_SINIESTROS + "04";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec04")

		public void siniestrosAlta200(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "200223717", false, false, false);

				return null;
			}).run();
		}


		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec05() {
			String testCase = Constants.MEC_SINIESTROS + "05";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec05")

		public void siniestrosAlta920(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "920021985", false, false, false);

				return null;
			}).run();
		}

		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec06() {
			String testCase = Constants.MEC_SINIESTROS + "06";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec06")

		public void siniestrosAlta900(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "900920199", false, false, false);

				return null;
			}).run();
		}

		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec07() {
			String testCase = Constants.MEC_SINIESTROS + "07";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec07")

		public void siniestrosAlta660(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "660008068", false, false, false);

				return null;
			}).run();
		}

		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec08() {
			String testCase = Constants.MEC_SINIESTROS + "08";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec08")

		public void siniestrosAlta600(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "600601509", false, false, false);

				return null;
			}).run();
		}
		
		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec09() {
			String testCase = Constants.MEC_SINIESTROS + "09";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec09")

		public void siniestrosAlta610(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "610636150", false, false, false);

				return null;
			}).run();
		}

		
		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec10() {
			String testCase = Constants.MEC_SINIESTROS + "10";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec10")

		public void siniestrosAlta630(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "630670830", false, false, false);

				return null;
			}).run();
		}

		
		//
		@DataProvider(parallel = true)
		public String[][] dataProviderSiniestrosMec11() {
			String testCase = Constants.MEC_SINIESTROS + "11";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

			return casesMatrix;
		}

		@Test(dataProvider = "dataProviderSiniestrosMec11")

		public void siniestrosAlta640(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			userS.testActions(() -> {
				steps.login("GOL", "640");

				steps.alta_siniestroAlt("GOL", "640721662", false, false, false);

				return null;
			}).run();
		}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
