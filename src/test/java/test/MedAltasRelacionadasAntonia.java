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

	//---med_prueba_enlazada.csv----

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed20() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AD_C_AUXI.csv", "datosTestMediadores.csv");
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

	//-----datosAlta_I_AE_C_AUXI.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed21() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AE_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed21")
	public void altaIntermediario21(String testCase, String id) throws Exception {
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

	//-----datosAlta_I_AV_C_AD.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed22() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AV_C_AD.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed22")
	public void altaIntermediario22(String testCase, String id) throws Exception {
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

	//-----datosAlta_I_BSE_C_AUXI.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed23() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_BSE_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed23")
	public void altaIntermediario23(String testCase, String id) throws Exception {
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

	//-----med_prueba_enlazadas_5.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed24() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_BSV_C_GEST.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed24")
	public void altaIntermediario24(String testCase, String id) throws Exception {
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

	//-----datosAlta_I_CORR_C_AUXI.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed25() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_CORR_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed25")
	public void altaIntermediario25(String testCase, String id) throws Exception {
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

	//-----datosAlta_I_AE.csv---
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed26() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AE.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed26")
	public void altaIntermediario26(String testCase, String id) throws Exception {
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
