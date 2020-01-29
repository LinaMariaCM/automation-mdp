package test;

//Circuito completo siniestros (convencional / especializado con perito)
//--------------------------------------------------------------------------

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import com.amaris.project.steps.CheckSteps;

public class MediadoresTest {

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	@DataProvider(parallel = false)
	public String[][] dataProviderMed01() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv", "datosTestMediadores.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed01")
	public void med01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		
		userS.setScenario(testCase + userS.getVar("test_id"));

		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			steps.doy_de_alta_prospect_usando_acceso_y_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			//checkSteps.datos_prospect_grabados_coinciden();

			return null;
		}).run();
	}


	@DataProvider(parallel = false)
	public String[][] dataProviderMed02() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv", "datosTestMediadores.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed01")
	public void med02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		userS.setScenario(testCase + userS.getVar("test_id"));

		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.obtener_nombres_direcciones_mediador();

			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMed03() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_csv_1.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed03")
	public void med03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		//CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "eferrando");

			steps.alta_datos_basicos_mediador();
			steps.alta_datos_contacto_mediador();

			return null;
		}).run();
	}









	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
