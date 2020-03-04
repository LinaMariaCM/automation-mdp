package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedAltasRelacionadasAntonia extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	@DataProvider(parallel = false)
	public String[][] altaIntermediario01() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAltaMediadoresC245.csv", "datosTestIntermediarios.csv");
		//	String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAltaMediadoresIntermediarios.csv", null);
		return casesMatrix;
	}

	@Test(dataProvider = "altaIntermediario01")
	public void altaIntermediario01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 80);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login("Innova", "eferrando");
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();
			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed02() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresOficina.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed02")
	public void altaOficina(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		//	suiteM.setRelevantColumn(testCase, 80);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_oficina();
			//	steps.localizar_mediador();
			steps.tramitar_estados_mediador();
			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed03() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresColaboradores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed03")
	public void altaColaborador(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		//	suiteM.setRelevantColumn(testCase, 80);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_colaborador();
			steps.tramitar_estados_mediador();
			return null;
		}).run();
	}

	//---PRUEBAAAA----

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed20() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "med_prueba_enlazadas.csv", "datosTestIntermediarios.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed20")
	public void altaIntermediario20(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login("Innova", "eferrando");
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login("Innova", "eferrando");
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login("Innova", "eferrando");
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//FIN ZONA DE PRUEBAS
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}//END
