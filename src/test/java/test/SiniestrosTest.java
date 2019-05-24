package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.ProjectConstants;
import com.amaris.project.steps.Steps;

public class SiniestrosTest {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC_SINIESTROS);

	// PRUEBA MEC_SINIESTROS
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec01() {
		String testCase = ProjectConstants.MEC_SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestrosMec01")
	public void siniestrosMec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		Steps steps = new Steps(userS);

		// userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv",
		// "fichero_referencias");
		// userS.addDMData("datosMecSin.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [SiniestrosMec01] - Alta siniestro a partir de una
			// póliza tipo MEC:

			/*
			 * SINIESTROS MEC
			 * 
			 * entorno: X
			 * 
			 * acceso: INNOVA
			 * 
			 * HOJA DE RUTA:
			 * 
			 *	 1. Login: Eperez
			 * 
			 *	 2. Siniestros
			 * 
			 *		 2.1 Alta
			 * 
			 *		 2.1.1 Buscador de pólizas: número de póliza: (ie: 510001249)
			 * 
			 *		 2.1.2 Alta apertura (Paso 1)
			 * 
			 *		 2.1.2.1 Alta apertura aviso
			 * 
			 *		 2.1.3 Alta apertura (Paso 2)
			 *	 
			 *		 2.1.3.1 Alta apertura aviso
			 *	 
			 *		 2.1.4 Alta apertura (Paso 3)
			 * 
			 *		 2.1.5 Alta apertura: Mensaje de Confirmación
			 * 
			 */

			// steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(
			// userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			// 1. me logeo

			steps.login("Innova", "Eperez");

			// 2. doy de alta un siniestro tipo

			// steps.alta_siniestro("510000148");
			steps.alta_siniestro("Innova", "900902646");
			// steps.alta_siniestro("GOL","000016");
			return null;
		}).run();
	}

	/*
	 * public void siniestrosMec02(String testCase, String id, String browser)
	 * throws Exception { UserStory userS = InitUtils.createUserStory(id,
	 * testCase, suiteM, browser); Steps steps = new Steps(userS);
	 * 
	 * 
	 * userS.testActions(() -> {
	 * 
	 * steps.login("Innova", "Eperez");
	 * 
	 * steps.alta_siniestroAlt("Innova", "510000020");
	 * 
	 * return null; }).run(); }
	 */

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
