package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.ProjectConstants;
import com.amaris.project.steps.Steps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MacTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MAC);

	// PRUEBAS MAC
	@DataProvider(parallel = true)
	public String[][] dataProviderMac01() {
		String testCase = ProjectConstants.MAC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01")
	public void mac01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			// steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"),
			// userS.getScenarioVar("usuario"));

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.enviar_el_proyecto_a_la_compania();

			steps.cerrar_navegador();

			steps.login_y_autorizar_el_proyecto_MAC(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));

			steps.cerrar_navegador();

			steps.completo_el_proceso_de_contratacion_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;

		}).run();
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMac01a() {
		String testCase = ProjectConstants.MAC + "01a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01a")
	public void mac01a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.enviar_el_proyecto_a_la_compania();

			steps.completo_el_proceso_de_contratacion_MAC_sin_autorizacion();

			// steps.cerrar_navegador();

			steps.se_informa_de_que_la_poliza_no_se_puede_emitir();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac01b() {
		String testCase = ProjectConstants.MAC + "01b";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac01b")
	public void mac01b(String testCase, String id) throws Exception {


		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			// steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"),
			// userS.getScenarioVar("usuario"));

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.enviar_el_proyecto_a_la_compania();

			steps.cerrar_navegador();

			steps.login_y_autorizar_el_proyecto_MAC(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));

			steps.cerrar_navegador();

			steps.completo_el_proceso_de_contratacion_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac02() {
		String testCase = ProjectConstants.MAC + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac02")
	public void mac02(String testCase, String id) throws Exception {

		/*
		 * 
		 * @Mac02 Escenario: [Mac02] - Alta de proyecto de alquiler desde GO,
		 * pasando por la autorizacion, con estudio denegado por rentas y
		 * revertido por cambio ingresos Dado la renta de alquiler mensual es
		 * "renta_mensual_alquiler" Y el nombre del inquilino "nombre_inquilino"
		 * Y el primer apellido del inquilino "primer_apell_inqulino" Y el
		 * documento aleatoreo Y con ingresos "ingresos_inquilino" Y situacion
		 * laboral "situacion_laboral"
		 * #####################################################################
		 * #####################################################################
		 * ############ Cuando doy de alta un proyecto MAC que llega hasta la
		 * pantalla contratación usando el acceso "acceso" y el usuario
		 * "usuario" Y modifico los ingresos a "ingresos_inquilino_nuevos"
		 * Entonces el proyecto MAC se acepta Y se puede autorizar usando el
		 * acceso "accesoAuth" y usuario "usuarioAuth"
		 * 
		 */

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			// steps.enviar_el_proyecto_a_la_compania();

			steps.modificar_ingresos("ingresos_inquilino_nuevos");

			// steps.cerrar_navegador();

			// steps.login_y_autorizar_el_proyecto_MAC(userS.getScenarioVar("accesoAuth"),
			// userS.getScenarioVar("usuarioAuth"));

			// steps.cerrar_navegador();

			// steps.completo_el_proceso_de_contratacion_MAC(userS.getScenarioVar("acceso"),
			// userS.getScenarioVar("usuario"));

			steps.el_proyecto_MAC_se_acepta();

			steps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac03() {
		String testCase = ProjectConstants.MAC + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac03")
	public void mac03(String testCase, String id) throws Exception {

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

	
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.anyado_avalista();

			steps.el_proyecto_MAC_se_acepta();

			steps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));

			return null;

		}).run();

	}
	
	@DataProvider(parallel = true)
	public String[][] dataProviderMac04() {
		String testCase = ProjectConstants.MAC + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac04")
	public void mac04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.enviar_el_proyecto_a_la_compania();

			steps.deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));

			steps.busco_el_proyecto_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_proyecto_esta_en_estado_denegado();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac05() {
		String testCase = ProjectConstants.MAC + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac05")
	public void mac05(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino asalariado

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_proyecto_MAC_se_deniega();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac06() {
		String testCase = ProjectConstants.MAC + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac06")
	public void mac06(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino autonomo

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_proyecto_MAC_se_deniega();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac07() {
		String testCase = ProjectConstants.MAC + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac07")
	public void mac07(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino artista

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_proyecto_MAC_se_deniega();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac08() {
		String testCase = ProjectConstants.MAC + "08";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac08")
	public void mac08(String testCase, String id) throws Exception {
		// Estudio denegado por rentas de inquilino becario

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_proyecto_MAC_se_deniega();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac09() {
		String testCase = ProjectConstants.MAC + "09";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac09")
	public void mac09(String testCase, String id) throws Exception {

		// Reaseguro - Retención por Reaseguro en Alta proyecto/pólizas:
		// Estandar + Renta > 3000€
		

		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);


		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.se_inicia_un_proyecto_con_modalidad("modalidad");

			steps.la_renta_mensual_es("renta_mensual_alquiler");

			steps.deberia_aparecer_error_rebasada_la_renta_máxima_permitida();

			steps.no_deberia_estar_habilitado_convertir_a_proyecto();

			return null;

		}).run();

	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMac10() {
		String testCase = ProjectConstants.MAC + "10";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMac10")
	public void mac10(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

	
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");


		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.se_inicia_un_proyecto_con_modalidad("modalidad");

			steps.la_suma_asegurada_de_impago_alquiler_es("impago_alquiler");

			steps.deberia_aparecer_error_situacion_reasegurado();

			steps.no_deberia_estar_habilitado_convertir_a_proyecto();

			return null;

		}).run();

	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
