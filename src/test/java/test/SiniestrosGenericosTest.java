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
		String testCase = Constants.SINIESTROS;
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

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen06() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	// Alta de siniestros con comprobaciones
	@Test(dataProvider = "dataProviderSiniestrosGen06")
	public void siniestrosGen06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.alta_siniestro_simple();
			steps.tramito_siniestro_tras_alta();

			steps.compruebo_que_datos_han_viajado(); // TODO añadir más campos
			steps.compruebo_carpeta_y_encargos();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen07() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros3anto.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen07")
	public void siniestrosGen07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.realizo_plan_pagos_MAC();
			steps.cierro_navegador();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen08() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen08")
	public void siniestrosGen08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.comprobar_casos_error_declaracion_apertura_siniestro();
			steps.cierro_navegador();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen09() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen09")
	public void siniestrosGen09(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.transicionar_bloques();
			steps.cierro_navegador();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen10() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosGen10")
	public void siniestrosGen10(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.anyado_anotacion_siniestro();

			steps.compruebo_anotacion_siniestro();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen11() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	// Comunicacion siniestro
	@Test(dataProvider = "dataProviderSiniestrosGen11")
	public void siniestrosGen11(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.alta_siniestro_simple();

		//	steps.cierro_navegador();

		//	steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.comunico_siniestro();

			steps.compruebo_comunicacion_siniestro();

			return null;
		}).run();
	}


	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen12() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}


	@Test(dataProvider = "dataProviderSiniestrosGen12")
	public void siniestrosGen12(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.alta_siniestro_simple();

			if(!userS.getTestVar(Constants.TIPO_POLIZA).equalsIgnoreCase("MAC") && !userS.getTestVar(Constants.TIPO_CAUSA_COD).equalsIgnoreCase("TC025001")) {
				steps.tramito_siniestro_tras_alta(); // es un mero click para acceder a tramitación
			}
			steps.nueva_tarea_siniestros();
			steps.modifico_tarea_siniestros();
			steps.cierro_navegador();


			return null;
		}).run();
	}


	//END
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

	
	
}
