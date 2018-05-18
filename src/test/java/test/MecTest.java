package test;

import com.automation.model.utils.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.TestClass;
import com.automation.model.testing.UserStory;
import com.project.ProjectConstants;
import com.project.steps.Steps;


public class MecTest extends TestClass {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC);

	// PRUEBA MEC01
	@DataProvider(parallel = true)
	public String[][] dataProviderMec01() {
		String testCase = ProjectConstants.MEC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec01")
	public void mec01(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mec01] - Alta proyecto: datos catastro+cliente nuevo+complet+cobro mediador

			/*
			 * Dado el mediador "mediador" 
			 * Y la referencia catastral "ref_catastral" 
			 * Y la modalidad "modalidad" Y el tomador es "tomador"
			 * Y el medio de pago es "medio_pago"
			 * Cuando doy de alta una simulacion y convierto esta simulacion a un projecto usando el acceso "acceso" y el usuario "usuario"
			 * Y cierro el navegador
			 * Entonces el resultado es que el projecto se crea correctamente
			 **/

			steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(
				userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));

			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		CsvToHtml.createJointReport(suiteM);
	}
}
