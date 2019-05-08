package test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.TestObject;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.InitUtils;
import com.project.ProjectConstants;
import com.project.steps.Steps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MacTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MAC);

	// PRUEBAS MAC
	@DataProvider(parallel = true)
	public String[][] dataProviderMac() {
		String testCase = ProjectConstants.MAC;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac")
	public void mac01(String testCase, String id, String browser) throws Exception {
		

		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "01");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			//steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
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
	@Test(dataProvider = "dataProviderMac")
	public void mac01a(String testCase, String id, String browser) throws Exception {
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "01a");
		
		System.out.println("Scenario: " + userS.getScenario());
		
		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.enviar_el_proyecto_a_la_compania();
			
			steps.completo_el_proceso_de_contratacion_MAC_sin_autorizacion();
			
			//steps.cerrar_navegador();
			
			steps.se_informa_de_que_la_poliza_no_se_puede_emitir();
						
			return null;
			
		}).run();
		
		
	}

	@Test(dataProvider = "dataProviderMac")
	public void mac01b(String testCase, String id, String browser) throws Exception {
		
		/*
		 * 
		 * @Mac01b
			Escenario: [Mac01b] - Alta de proyecto de alquiler desde GO, pasando por la autorizacion, con estudio aceptado y variacion en franquicia y suma asegurada
			Dado la renta de alquiler mensual es "renta_mensual_alquiler"
			Y el nombre del inquilino "nombre_inquilino"
			Y el primer apellido del inquilino "primer_apell_inqulino"
			Y el documento aleatoreo
			Y con ingresos "ingresos_inquilino"
			Y suma asegurada es "impago_alquiler"
			Y franquicia es "franquiciaMac"
			Y situacion laboral "situacion_laboral" 
			Y el tomador es "tomador"
			Y el tipo de persona es "tipo_persona"
			Y el documento de tomador es aleatoreo
			Y el nombre de tomador es "tomador_nombre"
			Y el primer apellido de tomador es "tomador_apellido"
			Y la provincia de tomador es "provincia"
			Y la poblacion de tomador es "poblacion"
			Y la direccion de tomador es "nombre_via"
			Y el numero de portal de tomador es "numero_via"
			Y la fecha de nacimiento de tomador es "fecha_nacimiento"
			Y el numero de cuenta es "numero_cuenta"
			Y la provincia del inmueble es "provincia_inm"
			Y la poblacion del inmueble es "poblacion_inm"
			Y la direccion del inmueble es "via_inm"
			Y el numero de portal del inmueble es "numerovia_inm"
			Y la fecha de contrato del alquiler es "fecha_contr_alq"
			##############################################################################################################################
			
			Cuando doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso "acceso" y el usuario "usuario"
			
			Y envio el proyecto a la compañia
			Y cierro el navegador
			Y autorizo el proyecto MAC usando el acceso "accesoAuth" y usuario "usuarioAuth" 
			Y cierro el navegador
			Y completo el proceso de contratacion usando el acceso "acceso" y usuario "usuario" 
			Entonces resultado es que el projecto se crea correctamente
		 * 
		 * */
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "01b");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			//steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
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
	
	@Test(dataProvider = "dataProviderMac")
	public void mac02(String testCase, String id, String browser) throws Exception {
		
		/*
		 * 
		 * @Mac02
			Escenario: [Mac02] - Alta de proyecto de alquiler desde GO, pasando por la autorizacion, con estudio denegado por rentas y revertido por cambio ingresos
			Dado la renta de alquiler mensual es "renta_mensual_alquiler"
			Y el nombre del inquilino "nombre_inquilino"
			Y el primer apellido del inquilino "primer_apell_inqulino"
			Y el documento aleatoreo
			Y con ingresos "ingresos_inquilino"
			Y situacion laboral "situacion_laboral" 
			######################################################################################################################################################
			Cuando doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso "acceso" y el usuario "usuario"
			Y modifico los ingresos a "ingresos_inquilino_nuevos"
			Entonces el proyecto MAC se acepta
			Y se puede autorizar usando el acceso "accesoAuth" y usuario "usuarioAuth"
		 * 
		 * */
		

		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "02");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.crear_un_proyecto_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			//steps.enviar_el_proyecto_a_la_compania();
			
			steps.modificar_ingresos("ingresos_inquilino_nuevos");
			
			//steps.cerrar_navegador();
			
			//steps.login_y_autorizar_el_proyecto_MAC(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));
			
			//steps.cerrar_navegador();
			
			//steps.completo_el_proceso_de_contratacion_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_proyecto_MAC_se_acepta();
			
			steps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario("accessoAuth", "usuario");

			return null;
			
		}).run();
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac03(String testCase, String id, String browser) throws Exception {
			

		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "03");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.anyado_avalista();
			
			steps.el_proyecto_MAC_se_acepta();
			
			steps.se_puede_autorizar_usando_el_acceso_Innova_y_usuario("accesoAuth", "usuarioAuth");
			
			return null;
			
		}).run();
		
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac04(String testCase, String id, String browser) throws Exception {
		
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "04");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {
			
			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.enviar_el_proyecto_a_la_compania();
			
			steps.deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario("accesoAuth", "usuarioAuth");
			
			steps.busco_el_proyecto_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.el_proyecto_esta_en_estado_denegado();
			
			return null;
			
		}).run();
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac05(String testCase, String id, String browser) throws Exception {
		
		//Estudio denegado por rentas de inquilino asalariado
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "05");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.el_proyecto_MAC_se_deniega();

			return null;
			
		}).run();	
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac06(String testCase, String id, String browser) throws Exception {
		
		//Estudio denegado por rentas de inquilino autonomo
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "06");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.el_proyecto_MAC_se_deniega();

			return null;
			
		}).run();
		
		
	}		
	
	@Test(dataProvider = "dataProviderMac")
	public void mac07(String testCase, String id, String browser) throws Exception {

		//  Estudio denegado por rentas de inquilino artista
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		
		userS.setScenario(testCase + "07");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.el_proyecto_MAC_se_deniega();

			return null;
			
		}).run();
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac08(String testCase, String id, String browser) throws Exception {
		
		// Estudio denegado por rentas de inquilino becario
		
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
				
		userS.setScenario(testCase + "08");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario("acceso", "usuario");
			
			steps.el_proyecto_MAC_se_deniega();
			
			return null;
			
		}).run();
		
		
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac09(String testCase, String id, String browser) throws Exception {
		
		// Reaseguro - Retención por Reaseguro en Alta proyecto/pólizas: Estandar + Renta > 3000€
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
				
		userS.setScenario(testCase + "09");

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_numero_via");

		userS.testActions(() -> {

			steps.se_inicia_un_proyecto_con_modalidad("modalidad");
			
			steps.la_renta_mensual_es("renta_mensual_alquiler");
			
			steps.deberia_aparecer_error_rebasada_la_renta_máxima_permitida();
			
			steps.no_deberia_estar_habilitado_convertir_a_proyecto();
			
			return null;
			
		}).run();
		
		
	}
	
	@Test(dataProvider = "dataProviderMac")
	public void mac10(String testCase, String id, String browser) throws Exception {
		

		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
				
		userS.setScenario(testCase + "10");

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
