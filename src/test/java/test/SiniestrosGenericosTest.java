package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosGenericosTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.ALTA_SINIESTROS);
	
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosGen01() {
		String testCase = Constants.MEC_SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros33.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	public void siniestrosGen01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			steps.alta_siniestro_simple();
			steps.cierro_navegador();
			
			steps.login("Innova", "Eperez");
			steps.realizo_pago_simple();
			steps.cierro_navegador();
			
			steps.login("Innova", "Eperez");
			steps.cierre_siniestro();
			steps.cierro_navegador();
			
			steps.login("Innova", "Eperez");
			steps.reapertura_siniestro();
			steps.cierro_navegador();
			
			
			return null;
		}).run();
	}
	
	//END
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

	
	
}
