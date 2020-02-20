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
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv",
			"datosTestMediadores.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed01")
	public void med01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		userS.setScenario(testCase + userS.getVar("test_id"));

		ActionSteps steps = new ActionSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			steps.doy_de_alta_prospect_usando_acceso_y_usuario(userS.getScenarioVar(Constants.ACCESO),
				userS.getScenarioVar(Constants.USUARIO));
			// checkSteps.datos_prospect_grabados_coinciden();

			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] dataProviderMed02() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv",
			"datosTestMediadores.csv");

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

			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] dataProviderMed03() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_csv_1.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed03")
	public void med03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		// CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "eferrando");


			return null;
		}).run();
	}

	// TEST DE IRYNA PARA DAR ALTA OFICINA A UN INTERMEDIARIO
	@DataProvider(parallel = true)
	public String[][] dataProviderMed04() {
		String testCase = Constants.MEDIADORES_CASE + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_colabordor_csv_2.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed04")
	public void med04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_oficina();
			steps.tramitar_estados_mediador();
			return null;
		}).run();
	}

	// TEST PARA DAR ALTA COLABORADOR
	@DataProvider(parallel = true)
	public String[][] dataProviderMed05() {
		String testCase = Constants.MEDIADORES_CASE + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_colabordor_csv_2.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed05")
	public void med05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_colaborador();
			return null;
		}).run();
	}

	// TEST alta propesct
	@DataProvider(parallel = true)
	public String[][] dataProviderMed06() {
		String testCase = Constants.MEDIADORES_CASE + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_prospect_csv.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed06")
	public void med06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_prospect();
			return null;
		}).run();
	}

	// TEST de ANTONIA PARA ENVIO Y RECEPCIÓN de DGS

	@DataProvider(parallel = false)
	public String[][] dataProviderMed07() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_csv_1.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed07")
	public void med07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();
			return null;
		}).run();
	}

	// TEST de ANTONIA ALTA de TRES

	@DataProvider(parallel = false)
	public String[][] dataProviderMed08() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresIntermediarios.csv");

	/*	if(suiteM.getSuiteVar("id_mediador_alta") != null) {
			DataObject testData = suiteM.getTestDataManager(testCase).getTestData();
			for(int i = 0; i < testData.size(); i++) {
				testData.setValue(Integer.toString(i), "id_mediador_alta", suiteM.getSuiteVar("id_prospect_trans"));
			}
		}*/

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed08")
	public void med08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_intermediario();
			steps.tramitar_estados_mediador();
	/*		steps.alta_oficina();
			steps.tramitar_estados_mediador();
			steps.alta_colaborador();
			steps.tramitar_estados_mediador();*/
			return null;
		}).run();
	}

	@DataProvider(parallel = true)
	public String[][] dataProviderMed11() {
		String testCase = Constants.MEDIADORES_CASE + "11";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_csv_1.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed11")
	public void med11(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		// CheckSteps checkSteps = new CheckSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");

			return null;
		}).run();
	}

	// TEST PARA HACER COMPROBACIONES EN LA FICHA
	@DataProvider(parallel = true)
	public String[][] dataProviderMed20() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "prueba_comprobaciones_mediadores.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed20")
	public void med20(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.comprobacion_ficha();
			return null;
		}).run();
	}

	// TEST PARA RETENCIONES ALTAS PARA INTERMEDIARIO, OFICINA Y COLABORADOR
	@DataProvider(parallel = false)
	public String[][] dataProviderMed21() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_altas_retenciones.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed21")
	public void med21(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login("Innova", "eferrando");
			steps.alta_retenciones_mediadores();
			return null;
		}).run();
	}

	// TEST PARA RETENCIONES ALTA PROSPECT
	@DataProvider(parallel = false)
	public String[][] dataProviderMed22() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "med_alta_prospect_csv.csv");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMed22")
	public void med22(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_prospect_retenciones_mediadores();
			return null;
		}).run();
	}

	@AfterSuite
	/*	public void afterSuite() {suiteM.createHtmlReport();} - queda comentado porque se dejará el método final utilizado
	 por Mirko para el testCase de las pruebas entrelazadas*/

	public void afterSuite() {
		try {
			suiteM.createHtmlReport();
			suiteM.createPdfReport();
		} catch(Exception E) {
			E.printStackTrace();
		}
	}

}


