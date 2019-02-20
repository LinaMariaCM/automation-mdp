package test;

import com.automation.model.utils.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.TestObject;
import com.project.ProjectConstants;
import com.project.steps.Steps;


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
	public void mec01(String testCase, String id, String browser) throws Exception {
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "1");
		
		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
	
			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
			
			return null;
		}).run();
	}

	public void mec02(String testCase, String id, String browser) throws Exception {
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "2");
		
		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
	
			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	public void mec03(String testCase, String id, String browser) throws Exception {
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "3");
		
		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
	
			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			
			steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
			
			return null;
		}).run();
	}
	
	public void mec04(String testCase, String id, String browser) throws Exception {
		
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.setScenario(testCase + "4");
		
		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
	
			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"),userS.getScenarioVar("usuario"));
			
			steps.aparece_aviso("La dirección del riesgo no está normalizada");
			
			return null;
		}).run();
	}

	
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
