package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosTest5 extends TestObject {
	
	
	protected SuiteManager suiteM = new SuiteManager(Constants.SINIESTROS);

	
	// comunicaciones en siniestros
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec06() {
		String testCase = Constants.MEC_SINIESTROS + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros331.csv");

		return casesMatrix;
	}

	// Comunicacion siniestro
	@Test(dataProvider = "dataProviderSiniestrosMec06")
	public void siniestrosMec06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			
			steps.alta_siniestro_simple();
			
			steps.cierro_navegador();
			
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.comunico_siniestro();

			steps.compruebo_comunicacion_siniestro();

			return null;
		}).run();
	}

	// Alta anotación de un siniestro
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec07() {
		String testCase = Constants.MEC_SINIESTROS + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosMec07")
	public void siniestrosMec07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.anyado_anotacion_siniestro();

			steps.compruebo_anotacion_siniestro();

			return null;
		}).run();
	}
	
	
	// compruebo agenda siniestro
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec09() {
		String testCase = Constants.MEC_SINIESTROS + "09";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosMec09")
	public void siniestrosMec09(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

		
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();
			
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.nueva_tarea_siniestros();	
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.modifico_tarea_siniestros();
			steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.cierro_tarea_siniestros();
			steps.cierro_navegador();

			return null;
		}).run();
	}
	
	
	// Alta de Siniestros
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros01() {
		String testCase = Constants.SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros01")
	public void siniestros01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

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

			// steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			// steps.comprobacion_cierre_siniestro();
			// steps.cierro_navegador();

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.reapertura_siniestro();
			steps.cierro_navegador();

			return null;
		}).run();
	}

	// Modificar siniestro datos
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros02() {
		String testCase = Constants.SINIESTROS + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestModificarSiniestro2.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros02")
	public void siniestros02(String testCase, String id) throws Exception {
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

	// Modificar siniestro causa
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros03() {
		String testCase = Constants.SINIESTROS + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestModificarSiniestro2.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros03")
	public void siniestros03(String testCase, String id) throws Exception {
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

	// //Altas de siniestros con causas específicas para MAC
	// @DataProvider(parallel = true)
	// public String[][] dataProviderSiniestros04() {
	// String testCase = Constants.SINIESTROS + "04";
	// String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null,
	// "datosTestAltaSiniestrosMacCausasVarias.csv");
	//
	// return casesMatrix;
	// }

	// @Test(dataProvider = "dataProviderSiniestros04")
	// public void siniestros04(String testCase, String id) throws Exception {
	// UserStory userS = suiteM.createUserStory(testCase, id);
	// ActionSteps steps = new ActionSteps(userS);
	//
	// suiteM.setRelevantColumn(testCase, 15);
	//
	// userS.testActions(() -> {
	//
	// steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
	// steps.alta_siniestro_simple();
	// steps.cierro_navegador();
	//
	// steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
	// steps.realizo_pago_simple();
	// steps.cierro_navegador();
	//
	//
	// steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
	// steps.cierre_siniestro();
	// steps.cierro_navegador();
	//
	// steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
	// steps.reapertura_siniestro();
	// steps.cierro_navegador();
	//
	// return null;
	// }).run();
	// }

	// Alta de Siniestros con Reserva Específica
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros05() {
		String testCase = Constants.SINIESTROS + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestrosReservaEspecifica.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros05")
	public void siniestros05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			
			
			return null;
		}).run();
	}

	// COPROBACION REHUSE Y RECONSIDERACION DE SINIESTRO
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros06() {
		String testCase = Constants.SINIESTROS + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros331.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros06")
	public void siniestros06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

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
	
	
	
	// Guardar siniestro durante el alta y modificar después
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestros07() {
		String testCase = Constants.SINIESTROS + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestrosGuardarYTramitar.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestros07")
	public void siniestros07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 16);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_siniestro_simple();
			steps.cierro_navegador();

			return null;
		}).run();
	}
	
	
	//FIN ZONA DE PRUEBAS
	@AfterSuite
	public void afterSuite() {
		try {
			suiteM.createHtmlReport();
			suiteM.createPdfReport();
		} catch(Exception E) {
			E.printStackTrace();
		}
	}

	

}//END
