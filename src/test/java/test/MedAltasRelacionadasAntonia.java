package test;

import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedAltasRelacionadasAntonia extends TestObject{

	protected SuiteManager suiteM = new SuiteManager(Constants.MEDIADORES_CASE);

	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed01() {
		String testCase = Constants.MEDIADORES_CASE;
	//	String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresIntermediarios.csv"); antes comentado junto al resto de la prueba
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "alta_interm_18_02_2020.csv");
		return casesMatrix;
	}
	
	@Test(dataProvider = "altasRelacionadasMed01")
	public void arm01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

	//	suiteM.setRelevantColumn(testCase, 80);

		userS.testActions(() -> {
			// alta intermediario agente exclusivo
			if(userS.getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
					steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
					steps.alta_intermediario();
					steps.tramitar_estados_mediador();
				}
			// alta oficina
			/*if(userS.getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") && userS.getTestVar(Constants.ID_ALTA_OFICINA_AE).equalsIgnoreCase("TRUE")) {
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_oficina();
				steps.tramitar_estados_mediador();
			}*/

			// alta de colaborador
	/*		if(userS.getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && userS.getTestVar(Constants.ID_ALTA_COLABORADOR_AE).equalsIgnoreCase("TRUE")) {
				steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
				steps.alta_colaborador();
				steps.tramitar_estados_mediador();
			}*/
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
