package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import com.amaris.project.steps.CheckSteps;
import com.amaris.project.steps.DataSteps;

public class SoloGarajesTest {

	protected SuiteManager suiteM = new SuiteManager(Constants.GARAJES_CASE);

	@DataProvider(parallel = false)
	public String[][] dataProviderGarajes01() {
		String testCase = Constants.GARAJES_CASE + "101a"; // TODO create a file for this test
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderGarajes01")
	public void garajes01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			dataSteps.marcado_el_check_Asegurar_unicamente_los_garajes();
			
			steps.doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			checkSteps.aparece_aviso("Los datos de superficies (m2) son orientativos, por favor reviselos");
			checkSteps.esta_habilitado_el_campo("M2 Trasteros");
			checkSteps.esta_habilitado_el_campo("No plantas bajo rasante");
			checkSteps.esta_habilitado_el_campo("No plantas en alto");
			checkSteps.esta_habilitado_el_campo("M2 Garajes");
			checkSteps.esta_habilitado_el_campo("No Plazas de garaje");

			return null;
		}).run();
	}

	@DataProvider(parallel = false)
	public String[][] dataProviderGarajes02() {
		String testCase = Constants.GARAJES_CASE + "101b"; // TODO create a file for this test
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadores.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderGarajes02")
	public void garajes02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);
		CheckSteps checkSteps = new CheckSteps(userS);

		userS.testActions(() -> {
			dataSteps.marcado_el_check_Asegurar_unicamente_los_garajes();
			
			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar(Constants.ACCESO), userS.getScenarioVar(Constants.USUARIO));
			
			checkSteps.el_resultado_es_que_el_projecto_se_crea_correctamente();

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
