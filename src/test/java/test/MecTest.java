package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.ProjectConstants;
import com.amaris.project.steps.Steps;

public class MecTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC);

	// PRUEBAS MEC
	@DataProvider(parallel = true)
	public String[][] dataProviderMec01() {
		String testCase = ProjectConstants.MEC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec01")
	public void mec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);
		
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");
		

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMec02() {
		String testCase = ProjectConstants.MEC + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			try {
				steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				e.printStackTrace();
			}

			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec03() {
		String testCase = ProjectConstants.MEC + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec")
	public void mec03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec04() {
		String testCase = ProjectConstants.MEC + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec")
	public void mec04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.aparece_aviso("La dirección del riesgo no está normalizada");

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec05() {
		String testCase = ProjectConstants.MEC + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.intento_dar_alta_simulacion_hasta_datos_riesgo(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.aparece_aviso("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.");

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMec06() {
		String testCase = ProjectConstants.MEC + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	
	@Test(dataProvider = "dataProviderMec")
	public void mec06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec07() {
		String testCase = ProjectConstants.MEC + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.cerrar_navegador();

			steps.lo_consulto_en_el_buscador_de_cotizaciones(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec08() {
		String testCase = ProjectConstants.MEC + "08";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario")); 
			
			steps.se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			//steps. -> los datos modificados se muestran en GO -> step incluido aunque no implementado, sopesar desarrollo 
		
			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec09a() {
		String testCase = ProjectConstants.MEC + "09a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec09a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec10a() {
		String testCase = ProjectConstants.MEC + "10a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec10a(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.
			
			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();

			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderMec12a() {
		String testCase = ProjectConstants.MEC + "12a";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec12a(String testCase, String id, String browser) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Scenario: " + userS.getScenario());
		System.out.println("++++++++++++++++++++++++++++++++");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.

			steps.doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente();
			
			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
