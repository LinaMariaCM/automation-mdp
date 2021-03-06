package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.CheckSteps;
import com.amaris.project.steps.DataSteps;
import com.amaris.project.steps.ActionSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MacTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.MAC);

	// PRUEBAS MAC
	@DataProvider(parallel = true)
	public String[][] dataProviderMac01() {
		String testCase = Constants.MAC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01")
	public void mac01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			dataSteps.el_documento_tomador_es_aleatoreo();
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.enviar_el_proyecto_a_la_compania();
			steps.cierro_navegador();
			steps.autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar(Constants.ACCESO_AUTORIZADO), userS.getScenarioVar(Constants.USUARIO_AUTORIZADO));
			steps.cierro_navegador();
			steps.completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));

			checkSteps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;

		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac01a() {
		String testCase = Constants.MAC + "01a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01a")
	public void mac01a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			dataSteps.el_documento_tomador_es_aleatoreo();
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.enviar_el_proyecto_a_la_compania();
			steps.completo_el_proceso_de_contratacion_MAC_sin_autorizacion();
			steps.se_informa_de_que_la_poliza_no_se_puede_emitir();

			return null;
		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac01b() {
		String testCase = Constants.MAC + "01b";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01b")
	public void mac01b(String testCase, String id) throws Exception {

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			dataSteps.el_documento_tomador_es_aleatoreo();
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.enviar_el_proyecto_a_la_compania();
			steps.cierro_navegador();
			steps.autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar(Constants.ACCESO_AUTORIZADO), userS.getScenarioVar(Constants.USUARIO_AUTORIZADO));
			steps.cierro_navegador();
			steps.completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			checkSteps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac02() {
		String testCase = Constants.MAC + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac02")
	public void mac02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.modificar_ingresos(userS.getScenarioVar(Constants.INGRESOS_INQUILINO_NUEVOS));
			checkSteps.el_proyecto_MAC_se_acepta();
			checkSteps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar(Constants.ACCESO_AUTORIZADO), userS.getScenarioVar(Constants.USUARIO_AUTORIZADO));

			return null;
		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac03() {
		String testCase = Constants.MAC + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac03")
	public void mac03(String testCase, String id) throws Exception {

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			System.out.println("TOKEN 1");
			steps.anyado_avalista();
			System.out.println("TOKEN 2");
			checkSteps.el_proyecto_MAC_se_acepta();
			System.out.println("TOKEN 3");
			checkSteps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar(Constants.ACCESO_AUTORIZADO), userS.getScenarioVar(Constants.USUARIO_AUTORIZADO));
			System.out.println("TOKEN 4");
			
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac04() {
		String testCase = Constants.MAC + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac04")
	public void mac04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", Constants.FICHERO_NUM_VIA);

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.enviar_el_proyecto_a_la_compania();
			steps.deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));
			steps.busco_el_proyecto_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			checkSteps.el_proyecto_esta_en_estado_denegado();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac05() {
		String testCase = Constants.MAC + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac05")
	public void mac05(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino asalariado

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));

			checkSteps.el_proyecto_MAC_se_deniega();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac06() {
		String testCase = Constants.MAC + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac06")
	public void mac06(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino autonomo

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));

			checkSteps.el_proyecto_MAC_se_deniega();

			return null;
		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac07() {
		String testCase = Constants.MAC + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac07")
	public void mac07(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino artista

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			checkSteps.el_proyecto_MAC_se_deniega();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac08() {
		String testCase = Constants.MAC + "08";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac08")
	public void mac08(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino becario

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));

			checkSteps.el_proyecto_MAC_se_deniega();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac09() {
		String testCase = Constants.MAC + "09";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac09")
	public void mac09(String testCase, String id) throws Exception {
		// Reaseguro - Retención por Reaseguro en Alta proyecto/pólizas:
		// Estandar + Renta > 3000€

		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			dataSteps.se_inicia_un_proyecto_con_modalidad();

			steps.la_renta_mensual_es();

			checkSteps.deberia_aparecer_error_rebasada_la_renta_máxima_permitida();
			checkSteps.no_deberia_estar_habilitado_convertir_a_proyecto();

			return null;
		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac10() {
		String testCase = Constants.MAC + "10";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac10")
	public void mac10(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + DateUtils.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			dataSteps.el_documento_aleatoreo_inquilino();
			dataSteps.se_inicia_un_proyecto_con_modalidad();

			steps.la_suma_asegurada_de_impago_alquiler_es();

			checkSteps.deberia_aparecer_error_situacion_reasegurado();
			checkSteps.no_deberia_estar_habilitado_convertir_a_proyecto();

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
