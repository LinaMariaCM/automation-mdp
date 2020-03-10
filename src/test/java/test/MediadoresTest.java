package test;

//----------------MEDIADORES--------------------------------------//

import com.amaris.automation.model.testing.objects.TestObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class MediadoresTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	//---Intermediario (Acuerdo colaboración) - Oficina - Colaborador (Auxiliar)-------//

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed01() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AD_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed01")
	public void altaRelacionada01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//-----Intermediario (Agente Exclusivo) - Oficina - Colaborador (Auxiliar)---------//

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed02() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AE_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed02")
	public void altaRelacionada02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//----Intermediario (Agente Vinculado)- Oficina - Colaborador (Acuerdo Distribución)----//
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed03() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AV_C_AD.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed03")
	public void altaRelacionada03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//-----BS Exclusivo - Oficina - Colaborador (Auxiliar)----//
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed04() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_BSE_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed04")
	public void altaRelacionada04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//-----BS Vinculado - Oficina - Colaborador (Gestor)----//
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed05() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_BSV_C_GEST.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed05")
	public void altaRelacionada05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//-----Intermediario (Corredor) - Oficina - Colaborador (Auxiliar)----//
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed06() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_CORR_C_AUXI.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed06")
	public void altaRelacionada06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//-----Intermediario (Agente Exclusivo) CIF - Oficina - Colaborador (Acuerdo Distribución)
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed07() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosAlta_I_AE.csv", "datosTestMediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altasRelacionadasMed07")
	public void altaRelacionada07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			steps.set_test_variables_from_scenario_var("INTE");
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();

			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {

				steps.set_test_variables_from_scenario_var("OFIC");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}

			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.set_test_variables_from_scenario_var("COLA");
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}

			return null;
		}).run();
	}

	//---TEST PARA RETENCIONES ALTAS DE INTERMEDIARIO, OFICINA Y COLABORADOR---------------
	@DataProvider(parallel = false)
	public String[][] retencionesAltasMed() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_altas_mediadores_retenciones.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "retencionesAltasMed")
	public void retencionesAltasMediadores(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_retenciones_mediadores();
			return null;
		}).run();
	}

	//--------TEST ALTA PROSPECT--------------//
	@DataProvider(parallel = true)
	public String[][] altaProspectMed() {
		String testCase = Constants.MEDIADORES_CASE + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_prospect.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "altaProspectMed")
	public void altaProspect(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_prospect();
			return null;
		}).run();
	}

	//-------TEST PARA RETENCIONES ALTA PROSPECT-------------//
	@DataProvider(parallel = true)
	public String[][] retencionesAltaProspectMed() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_prospect.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "retencionesAltaProspectMed")
	public void retencionesAltaProsspect(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_prospect_retenciones_mediadores();
			return null;
		}).run();
	}

	//----TEST PARA HACER COMPROBACIONES EN LA FICHA---
	@DataProvider(parallel = false)
	public String[][] dataProviderMed20() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_prueba_comprobaciones_ficha.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed20")
	public void med20(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.comprobaciones_ficha();
			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}

/*
	public void afterSuite() {
		try {
			suiteM.createHtmlReport();
			suiteM.createPdfReport();
		} catch(Exception E) {
			E.printStackTrace();
		}
	}

}

 */


