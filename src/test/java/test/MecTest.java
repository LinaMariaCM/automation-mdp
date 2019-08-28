package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.CheckSteps;
import com.amaris.project.steps.DataSteps;
import com.amaris.project.steps.ActionSteps;

public class MecTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.MEC);

	// PRUEBAS MEC
	@DataProvider(parallel = true)
	public String[][] dataProviderMec01() {
		String testCase = Constants.MEC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec01")
	public void mec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");
		

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMec02() {
		String testCase = Constants.MEC + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec02")
	public void mec02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec03() {
		String testCase = Constants.MEC + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec03")
	public void mec03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec04() {
		String testCase = Constants.MEC + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec04")
	public void mec04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			checkSteps.aparece_aviso("La dirección del riesgo no está normalizada");

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec05() {
		String testCase = Constants.MEC + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec05")
	public void mec05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.intento_dar_alta_simulacion_hasta_datos_riesgo(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			checkSteps.aparece_aviso("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.");

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMec06() {
		String testCase = Constants.MEC + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec06")
	public void mec06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec07() {
		String testCase = Constants.MEC + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec07")
	public void mec07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.lo_consulto_en_el_buscador_de_cotizaciones(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec08() {
		String testCase = Constants.MEC + "08";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec08")
	public void mec08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			dataSteps.el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO)); 
			steps.se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			//steps. -> los datos modificados se muestran en GO -> step incluido aunque no implementado, sopesar desarrollo 
		
			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec09a() {
		String testCase = Constants.MEC + "09a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec09a")
	public void mec09a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec10a() {
		String testCase = Constants.MEC + "10a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec10a")
	public void mec10a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec12a() {
		String testCase = Constants.MEC + "12a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec12a")
	public void mec12a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			steps.cierro_navegador();
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec13a() {
		String testCase = Constants.MEC + "13a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec13a")
	public void mec13a(String testCase, String id) throws Exception {
		
		// POR TERMINAR
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			checkSteps.aparece_aviso("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.");
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec14a() {
		String testCase = Constants.MEC + "14a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec14a")
	public void mec14a(String testCase, String id) throws Exception {
		
		// FALLA EN EL PRIMER PASO
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			steps.cierro_navegador();
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec15() {
		String testCase = Constants.MEC + "15";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec15")
	public void mec15(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.lo_consulto_en_el_buscador_de_cotizaciones(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion();
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec16() {
		String testCase = Constants.MEC + "16";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec16")
	public void mec16(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_y_la_convierto_a_un_proyecto_y_la_guardo_sin_contratar_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			// TODO: cambio el medio de pago a "cambio_medio_pago"
			steps.modifico_la_cotización(userS.getScenarioVar(Constants.CAMBIO_ACCESO), userS.getScenarioVar(Constants.CAMBIO_USUARIO));
			checkSteps.la_cotizacion_se_actualiza_correctamente();
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec19() {
		String testCase = Constants.MEC + "19";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec19")
	public void mec19(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de edificios a "cambio_num_edificios"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNEdificios);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNEdificios);
			checkSteps.la_cotizacion_se_actualiza_correctamente();
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec20() {
		String testCase = Constants.MEC + "20";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec20")
	public void mec20(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de viviendas a "cambio_num_viviendas"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNViviendas);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNViviendas);
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec21() {
		String testCase = Constants.MEC + "21";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec21")
	public void mec21(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de viviendas a "cambio_num_locales"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNLocales);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNLocales);
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec23() {
		String testCase = Constants.MEC + "23";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec23")
	public void mec23(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de edificios a "cambio_num_edificios"
			// TODO: cambio el número de viviendas a "cambio_num_viviendas"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNEdificios);
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNViviendas);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNEdificios);
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec24() {
		String testCase = Constants.MEC + "24";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec24")
	public void mec24(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de edificios a "cambio_num_edificios"
			// TODO: cambio el número de locales a "cambio_num_locales"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNEdificios);
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNLocales);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNEdificios);
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec25() {
		String testCase = Constants.MEC + "25";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec25")
	public void mec25(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.agrego_un_suplemento();
			// TODO: cambio el número de edificios a "cambio_num_edificios"
			// TODO: cambio el número de viviendas a "cambio_num_locales"
			// TODO: cambio el número de viviendas a "cambio_num_viviendas"
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNEdificios);
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNLocales);
			steps.agrego_el_motivo_suplemento(Constants.MotivoSuplementoModificacionNViviendas);
			steps.emito_un_suplemento_general_con_motivo(Constants.MotivoSuplementoModificacionNEdificios);
			checkSteps.la_copia_tomador_deberia_tener_los_nuevos_datos();
			
			return null;
		}).run();
	}
	
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec35() {
		String testCase = Constants.MEC + "35";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec35")
	public void mec35(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec36() {
		String testCase = Constants.MEC + "36";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec36")
	public void mec36(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec38() {
		String testCase = Constants.MEC + "38";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec38")
	public void mec38(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecConPer01() {
		String testCase = Constants.MEC_CON_PER + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecConPer01")
	public void mecconper01(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.continuo_en_detalles_riesgo();
			checkSteps.aparece_aviso(Constants.AvisoPeritajePlantasSotano);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecConPer02() {
		String testCase = Constants.MEC_CON_PER + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecConPer02")
	public void mecconper02(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		
		userS.testActions(() -> {
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: cambio el año construcción a "construccion_edificio"
			steps.continuo_en_detalles_riesgo();
			checkSteps.aparece_aviso(Constants.AvisoPeritajeAntiguead);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecConPer04() {
		String testCase = Constants.MEC_CON_PER + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecConPer04")
	public void mecconper04(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		
		userS.testActions(() -> {
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.modifico_el_capital_continente_a(Constants.CAPITAL_16M);
			steps.continuo_en_detalles_riesgo();
			checkSteps.aparece_aviso(Constants.AvisoPeritajeCapitalContinente);
			
			return null;
		}).run();
	}
	
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecMotSupGen20() {
		String testCase = Constants.MEC_MOT_SUP_GEN + "20";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecMotSupGen20")
	public void mecmotsupgen20(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		
		userS.testActions(() -> {
			
			steps.emito_un_suplemento_general_con_motivo(Constants.AvisoModificacionAnyoRehabilitacion);
			checkSteps.la_poliza_muestra_en_la_pestanya(Constants.PolizaDetailYearAndRehabilitationLevel, Constants.DATOS_RIESGO);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecParRetSim23() {
		String testCase = Constants.MEC_PAR_RET_SIM + "23";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecParRetSim23")
	public void mecparretsim23(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		
		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: Y selecciono como número de plantas de sotano "num_plantas_sotano"
			steps.continuo_en_detalles_riesgo();
			checkSteps.aparece_aviso(Constants.AvisoPlantasSotanoGreaterThan10);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMecParRetPro23() {
		String testCase = Constants.MEC_PAR_RET_PRO + "23";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMecParRetPro23")
	public void mecparretpro23(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		
		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: Y selecciono como número de plantas de sotano "num_plantas_sotano"
			steps.continuo_en_detalles_riesgo();
			checkSteps.aparece_aviso(Constants.AvisoPlantasSotanoGreaterThan10);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec94() {
		String testCase = Constants.MEC + "94";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec94")
	public void mec94(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO)); // TODO: version MEC
			// TODO: selecciono como tomador "tomador"
			// TODO: continuo en datos básicos del tomador
			checkSteps.aparece_aviso(Constants.AvisoComunidadesEnTramite);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec95() {
		String testCase = Constants.MEC + "95";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec95")
	public void mec95(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO)); // TODO: version MEC
			// TODO: selecciono como tomador "tomador"
			// TODO: continuo en datos básicos del tomador
			checkSteps.aparece_aviso(Constants.AvisoComunidadesEnTramite);
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec101() {
		String testCase = Constants.MEC + "101";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec101")
	public void mec101(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec102() {
		String testCase = Constants.MEC + "102";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec102")
	public void mec102(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: aparece un mensaje de error y los campos deshabilitación y edificio madera aparecen resaltados en rojo
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec103() {
		String testCase = Constants.MEC + "103";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec103")
	public void mec103(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: aparece un mensaje indicando que se va a crear un infraseguro
			// TODO: aparece una clausula adicional
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec104() {
		String testCase = Constants.MEC + "104";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec104")
	public void mec104(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			// TODO: aparece un mensaje indicando que se va a crear un supraseguro
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec105() {
		String testCase = Constants.MEC + "105";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec105")
	public void mec105(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			// TODO: añade una franquicia obligatoria
			checkSteps.el_valor_de_los_capitales_varia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec106a() {
		String testCase = Constants.MEC + "106a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec106a")
	public void mec106a(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO)); // TODO: version MEC
			checkSteps.sale_un_aviso_si_el_precio_no_cambia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec106b() {
		String testCase = Constants.MEC + "106b";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec106b")
	public void mec106b(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO)); // TODO: version MEC
			checkSteps.sale_un_aviso_si_el_precio_no_cambia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec107() {
		String testCase = Constants.MEC + "107";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec107")
	public void mec107(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec108() {
		String testCase = Constants.MEC + "108";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec108")
	public void mec108(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec110() {
		String testCase = Constants.MEC + "110";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec110")
	public void mec110(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec111() {
		String testCase = Constants.MEC + "111";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec111")
	public void mec111(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec112() {
		String testCase = Constants.MEC + "112";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec112")
	public void mec112(String testCase, String id) throws Exception {
		
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + ActionSteps.getDayOfWeek() + ".csv", "fichero_referencias");
		

		userS.testActions(() -> {
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			steps.cierro_navegador();
			checkSteps.el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
			
			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
	
}
