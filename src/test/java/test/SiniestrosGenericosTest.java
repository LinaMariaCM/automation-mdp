package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosGenericosTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.SINIESTROS);
	
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen01() {
		String testCase = Constants.SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosGen01")
	public void siniestrosGen01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.realizo_pago_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.cierre_siniestro();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.reapertura_siniestro();
			steps.cierro_navegador();
			
			
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen02() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen02")
	public void siniestrosGen02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.rehuso_siniestro();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.reconsidero_siniestro_rehusado();
			steps.cierro_navegador();


			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen03() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen03")
	public void siniestrosGen03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.realizo_recobro();
			steps.cierro_navegador();


			return null;
		}).run();
	}


	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen04() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen04")
	public void siniestrosGen04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			// TEST TIPO
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			System.out.println("Login OK. Empezando moficar siniestro Datos");
			steps.modificar_siniestro_datos();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen05() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen05")
	public void siniestrosGen05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			// TEST TIPO
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			System.out.println("Login OK. Empezando moficar siniestro Causa");
			steps.modificar_siniestro_causa();

			return null;
		}).run();
	}



	
	//END
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

	
	
}
