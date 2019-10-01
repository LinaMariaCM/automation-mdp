package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosTest3 extends TestObject {

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
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	public void siniestrosAlta(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			steps.alta_siniestro_simple();

			return null;
		}).run();
	}

	

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
