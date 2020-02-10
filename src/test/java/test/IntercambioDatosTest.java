package test;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import com.amaris.project.steps.CheckSteps;


public class IntercambioDatosTest extends TestObject{

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	@DataProvider(parallel = false)
	public String[][] dataProviderIntercambioDatos01() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosVariablesMediadoresIntercambio.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderIntercambioDatos01")
	public void intercambio01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 16);

		userS.testActions(() -> {


			
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.doy_de_alta_prospect();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = false)
	public String[][] dataProviderIntercambioDatos02() {
		String testCase = Constants.MEDIADORES_CASE;
//		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosVariablesMediadoresIntercambio.csv",
//			"datosTestMediadores.csv");
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosVariablesMediadoresIntercambio.csv");
		
		if(suiteM.getSuiteVar("id_prospect_trans") != null) {
			DataObject testData = suiteM.getTestDataManager(testCase).getTestData();
			for(int i = 0; i < testData.size(); i++) {
				testData.setValue(Integer.toString(i), "id_mediador_alta", suiteM.getSuiteVar("id_prospect_trans"));
			}
		}
		
		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderIntercambioDatos02")
	public void intercambio02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

		userS.testActions(() -> {
			
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.obtener_nombres_direcciones_mediador_intercambio_datos();
			
			return null;
		}).run();
	}
	
	//FIN ZONA DE PRUEBAS
	@AfterSuite
	public void afterSuite() {
		try {
			suiteM.createHtmlReport();
			suiteM.createPdfReport();
		} catch(Exception E) {
			E.printStackTrace();
		}
	}

	
	
}//END
