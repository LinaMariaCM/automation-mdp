package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosTest2 extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.ALTA_SINIESTROS);
 
	
	/*
	// PRUEBA ALTA SINIESTROS
		@DataProvider(parallel = true)
		public String[][] dataProviderAltaSiniestros01() {
			String testCase = ProjectConstants.ALTA_SINIESTROS + "01";
			String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestAltaSiniestros.csv");

			return casesMatrix;
		}

	
		@Test(dataProvider = "dataProviderAltaSiniestros01")

		public void siniestrosAlta510(String testCase, String id) throws Exception {
			UserStory userS = suiteM.createUserStory(testCase, id);
			Steps steps = new Steps(userS);

			System.out.println("++++++++++++++++++++++++++++++++");

	        System.out.println("Scenario: " + userS.getScenario());

	        System.out.println("++++++++++++++++++++++++++++++++");        
	        
	        userS.addDMData("datosTestAltaSiniestros.csv", "test_id");
			
	        String strAsistencia, strOtrosImplicados, strEncargo;
			boolean boolAsistencia, boolOtrosImplicados, boolEncargo;
			//seteamos el valor de asistencia
			strAsistencia=userS.getScenarioVar("asistencia");
			if(strAsistencia.equals("false")) boolAsistencia=false;
			else boolAsistencia=true;
			
			//*************
			System.out.println("Valor para asistencia=" + userS.getScenarioVar("asistencia"));
			if(boolAsistencia==true)System.out.println("TRUE");
			else System.out.println("FALSE");
			//*************
			
			//seteamos el valor de otros implicados
			strOtrosImplicados=userS.getScenarioVar("otros_implicados");
			if(strOtrosImplicados.equals("false")) boolOtrosImplicados=false;
			else boolOtrosImplicados=true;

			//seteamos el valor de encargo	
			strEncargo=userS.getScenarioVar("encargo");
			if(strEncargo.equals("false")) boolEncargo=false;
			else boolEncargo=true;
			
				
				
				
			userS.testActions(() -> {
				steps.login("Innova", "Eperez");

				steps.alta_siniestroAlt(userS.getScenarioVar("portal_acceso"), userS.getScenarioVar("num_poliza"), boolAsistencia, boolOtrosImplicados, boolEncargo);

				return null;
			}).run();
		}
	
	
	*/
	
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
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000020", false, false, false);

			return null;
		}).run();
	}


	
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta920(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			//steps.alta_siniestroAlt("Innova", "920017879", false, false, false);
		
			steps.alta_siniestroAlt("Innova", "920017000", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta900(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			//steps.alta_siniestroAlt("Innova", "900931784", false, false, false);
		
			steps.alta_siniestroAlt("Innova", "900911779", false, false, false);


			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta500(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "500553299", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta400(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "400009108", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta150(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "150401435", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta200(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "200226110", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta660(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "660000097", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta5000(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "50002522", false, false, false);

			return null;
		}).run();
	}
	


	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta600(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "600601384", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta610(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "610619142", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta620(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "620664851", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta630(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "630674325", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAlta640(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "640701098", false, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestrosAltaAsistencia510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");

			steps.alta_siniestroAlt("Innova", "510000076", true, false, false);

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")

	public void siniestroEncargoImplicadoAdicional510(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login("Innova", "Eperez");


			steps.alta_siniestroAlt("Innova", "510017734", false, true, true);
		
			steps.alta_siniestroAlt("Innova", "510004024", false, true, true);

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
