package test;

import com.amaris.automation.model.testing.objects.TestObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.SINIESTROS);

	@DataProvider(parallel = false)
	public String[][] dataProviderSiniestrosTest() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosTest")
	public void siniestrosTest01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {

			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));

			steps.alta_siniestro_simple();

			steps.nueva_tarea_siniestros();
			steps.modifico_tarea_siniestros();
			steps.cierro_tarea_siniestros();

			if(userS.getTestVar(Constants.TIPO_POLIZA).equalsIgnoreCase("MAC") && userS.getTestVar(Constants.TIPO_CAUSA_COD).equalsIgnoreCase("TC025001")) {
				steps.realizo_plan_pagos_MAC();
			} else {
				steps.realizo_pago_simple();
			}

			steps.cierre_siniestro();
			steps.reapertura_siniestro();

			steps.rehuso_siniestro();
			steps.reconsidero_siniestro_rehusado();

			steps.realizo_recobro();

			steps.modificar_siniestro_datos();

			steps.modificar_siniestro_causa();

			steps.tramito_siniestro_tras_alta();

			steps.compruebo_que_datos_han_viajado(); // TODO añadir más campos
			steps.compruebo_carpeta_y_encargos();

			steps.transicionar_bloques();

			steps.anyado_anotacion_siniestro();
			steps.compruebo_anotacion_siniestro();

			steps.comunico_siniestro();
			steps.compruebo_comunicacion_siniestro();

			steps.nueva_tarea_siniestros();
			steps.modifico_tarea_siniestros();
			steps.cierro_tarea_siniestros();

			steps.cierro_navegador();

			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] dataProviderSiniestrosTestRetneciones() {
		String testCase = Constants.SINIESTROS;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosTestRetenciones")
	public void siniestrosTest02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.comprobar_casos_error_declaracion_apertura_siniestro();
			steps.cierro_navegador();

			return null;
		}).run();
	}


	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
