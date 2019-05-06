package test;

import com.automation.model.utils.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.TestObject;
import com.project.ProjectConstants;
import com.project.steps.Steps;


public class MecTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MEC);

	// PRUEBAS MEC
	@DataProvider(parallel = true)
	public String[][] dataProviderMec01() {
		String testCase = ProjectConstants.MEC;
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMec.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMec")
	public void mec01(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

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

			try 
				{
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
				} catch(Throwable e) 
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			
				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();

			return null;
		}).run();
	}

	
	
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec03(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec04(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@Test(dataProvider = "dataProviderMec")
	public void mec02(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecThu.csv", "fichero_referencias");

		userS.testActions(() -> {
			// Escenario: [Mecxx] - 

			try {
				steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			} catch(Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				steps.el_resultado_es_que_el_proyecto_se_crea_correctamente();
				
			return null;
		}).run();
	}
	
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}
}
