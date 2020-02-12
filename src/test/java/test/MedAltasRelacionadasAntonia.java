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
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresIntermediarios.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "altasRelacionadasMed01")
	public void arm01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 20);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_interm_AE_completo();
			
			return null;
		}).run();
	}
	
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed02() {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresOficina.csv");
		
		if(suiteM.getSuiteVar("cod_mediador_trans") != null) {
			DataObject testData = suiteM.getTestDataManager(testCase).getTestData();
			for(int i = 0; i < testData.size(); i++) {
				testData.setValue(Integer.toString(i), "id_inter_ae", suiteM.getSuiteVar("cod_mediador_trans"));
			}
		}
		
		return casesMatrix;
	}
	
	@Test(dataProvider = "altasRelacionadasMed02")
	public void arm02 (String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_oficina_a_un_intermediario();
			return null;
		}).run();
	}
	
	
	@DataProvider(parallel = false)
	public String[][] altasRelacionadasMed03 () {
		String testCase = Constants.MEDIADORES_CASE;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosAltaMediadoresColaboradores.csv");
		
		if(suiteM.getSuiteVar("id_prospect_trans") != null) {
			DataObject testData = suiteM.getTestDataManager(testCase).getTestData();
			for(int i = 0; i < testData.size(); i++) {
				testData.setValue(Integer.toString(i), "id_ofi_ae", suiteM.getSuiteVar("id_prospect_trans"));
			}
		}
		
		return casesMatrix;
	}
	
	@Test(dataProvider = "altasRelacionadasMed03")
	public void arm03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		suiteM.setRelevantColumn(testCase, 15);

		userS.testActions(() -> {
			steps.login(userS.getTestVar(Constants.ACCESO), userS.getTestVar(Constants.USUARIO));
			steps.alta_colaborador();			
			
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
