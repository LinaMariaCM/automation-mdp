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


public class DependenciaInterOfiColabTest extends TestObject{

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	@DataProvider(parallel = false)
	public String[][] dataProviderIntercambioDatos01() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosVariablesMediadoresIntercambio2.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderIntercambioDatos01")
	public void intercambio01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 20);

		userS.testActions(() -> {

			// alta intermediario agente exclusivo
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_interm_AE_completo();
			
			// alta oficina
			if(userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina_a_un_intermediario();
			}
			
			// alta de colaborador
			if(userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();			
			}
			
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
