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

public class FichaClienteTest {

	protected SuiteManager suiteM = new SuiteManager(Constants.FICHA_CLIENT);

	@DataProvider(parallel = false)
	public String[][] dataProviderAltaCliente() {
		String testCase = Constants.FICHA_CLIENT + "09";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestClientes.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderAltaCliente")
	public void altaCliente(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);

		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);


		// userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv",
		// "fichero_referencias");
		// userS.addDMData("datosMecSin.csv", "fichero_referencias");

		userS.testActions(() -> {
			steps.login("Innova", "mcena");
			dataSteps.el_documento_tomador_es_aleatoreo();
			steps.accederCliente();

			return null;
		}).run();// error aqui
	}


/*	@DataProvider(parallel = false)
	public String[][] dataBuscaNombre() {
		String testCase = Constants.FICHA_CLIENT + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestClientes.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataBuscaNombre")
	public void buscaNombre(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "mcena");
			steps.marcaCliente();
			steps.buscanom
			steps.buscadorCliente();
			steps.marcaRelacion();
			steps.marcaNegativa();

			return null;
		}).run();// error aqui
	}*/



	@DataProvider(parallel = false)
	public String[][] dataBuscaNif() {
		String testCase = Constants.FICHA_CLIENT + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestClientes.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataBuscaNif")
	public void buscaNif(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		DataSteps dataSteps = new DataSteps(userS);

		userS.testActions(() -> {
			steps.login("Innova", "mcena");
			steps.marcaCliente();
			steps.buscaClientePorNif();
			steps.buscadorCliente();
			steps.marcaRelacion();
			steps.marcaNegativa();

			return null;
		}).run();// error aqui
	}



	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
