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

	public String[][] dataProviderMec() {

		String testCase = ProjectConstants.MEC;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "1");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "2");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				e.printStackTrace();
			}

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "3");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "4");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.aparece_aviso("La dirección del riesgo no está normalizada");

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "5");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.intento_dar_alta_simulacion_hasta_datos_riesgo(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.aparece_aviso("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.");

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "6");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "7");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.cerrar_navegador();

			steps.lo_consulto_en_el_buscador_de_cotizaciones(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			steps.el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion();

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "8");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec09(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec10(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.

			return null;
		}).run();
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec11(String testCase, String id, String browser) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "");

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {

			// steps.

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
