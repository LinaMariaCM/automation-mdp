package test;


//Circuito completo siniestros (convencional / especializado con perito)
//--------------------------------------------------------------------------




import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.utils.InitUtils;
import com.project.ProjectConstants;
import com.project.pages.ClientePage;
import com.project.steps.Steps;

public class FichaClienteTest {

	
	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.FICHA_CLIENT);

	
	@DataProvider(parallel = false)
	public String[][] dataProviderAltaCliente() {
		String testCase = ProjectConstants.FICHA_CLIENT + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase,null,"datosTestClientes.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderAltaCliente")
	public void altaCliente(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		
		
		Steps steps = new Steps(userS);

		//userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecSin.csv", "fichero_referencias");

		userS.testActions(() -> {
			
			steps.login("Innova","mcena");
		    steps.accederCliente();
		    
			

return null;
}).run();//error aqui
}
	
	@Test(dataProvider = "dataProviderAltaCliente")
	public void emitirMarca(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);


		userS.testActions(() -> {
			
			steps.login("Innova","mcena");
		    steps.marcaCliente();
		    steps.buscaClientePorNif();
		    steps.buscadorCliente();
		    steps.marcaRelacion();
		    steps.marcaNegativa();
		   
		    
			

return null;
}).run();//error aqui
}
	
	
	
	
	
@AfterSuite
public void afterSuite() {
suiteM.createHtmlReport();
}
}




