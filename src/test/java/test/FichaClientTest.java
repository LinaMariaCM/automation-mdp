package test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.testing.objects.TestObject;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.InitUtils;
import com.project.ProjectConstants;
import com.project.pages.ClientesPage;
import com.project.*;
import com.project.steps.Steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FichaClientTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.FICHA_CLIENT);


	@DataProvider(parallel = true)
	public String[][] dataProviderFichaCliente() {
		String testCase = ProjectConstants.FICHA_CLIENT + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null);
		System.out.println("TEST 1");
		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderFichaCliente")
	public void fichaCliente(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);
		TestObject object = new TestObject();
		//object.initializeExecution("https://prepro-innova.mutuadepropietarios.es/web/SNetPeticion?idPeticion=GENEMISC0001");
		ClientesPage cliente =new ClientesPage(userS);
		steps.login("mutuaabc","mcena");
		cliente.crearNuevoTomador();
		
		
		
		
		

		userS.testActions(() -> {
			//aqui llamo a los ste
			System.out.println("TEST 2");
			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
