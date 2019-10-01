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
import com.amaris.project.steps.DataSteps;

public class CerrarSiniestro {

	protected SuiteManager suiteM = new SuiteManager(Constants.CIERRE_SINIESTRO);

	@DataProvider(parallel = false)
	public String[][] cierreSiniestro() {
		String testCase = Constants.CIERRE_SINIESTRO;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestClientes.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "cierreSiniestro")
	public void altaCliente(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);


		// userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv",
		// "fichero_referencias");
		// userS.addDMData("datosMecSin.csv", "fichero_referencias");

		userS.testActions(() -> {
            steps.login("Innova", "Eperez");
            steps.cierre_siniestro();
			//dataSteps.el_documento_tomador_es_aleatoreo();
			//steps.accederCliente();

			return null;
		}).run();// error aqui
    }
}