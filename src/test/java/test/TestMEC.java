package test;

import java.io.File;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.configuration.AutomationConstants;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.FileUtils;
import com.automation.model.utils.InitUtils;
import com.automation.model.utils.OSUtils;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.project.ProjectConstants;
import com.project.steps.Steps;
//import com.project.steps.ActionsSteps;


public class TestMEC {

		private TestDataManager testData;
		private String testCase = ProjectConstants.MEC;
		private String[][] casesMatrix = null, resultMatrix = null;
		//private String defaultTestData = "testDataMec01.csv", defaultScenarioData = "scenarioData.csv";
		//private String defaultTestData = "testDataMec01.csv", defaultScenarioData = userS.setScenario(userS.getScenario() + "01");
		private String defaultTestData = "testDataMec01.csv", defaultScenarioData = "datosTestMEC.csv";
		/*public boolean mec01(UserStory userS, Steps steps) throws Exception {
			
		}*/

		@DataProvider(parallel = true)
		public String[][] dataProvider() {
			return this.casesMatrix;
		}

		
		//PRUEBA MEC01
		
		@Test(dataProvider = "dataProvider")
		public void mec01(String id, String browser) throws Exception {
			if(resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3] == null
				|| !resultMatrix[Integer.parseInt(id) + 1][resultMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
				UserStory userS = new UserStory(id, testCase)
					.addTestDataManager(testData)
					.addDriverConfiguration(browser, testData.getConfigData())
					.setReportConfiguration(testData.getTimeStamp(), testData.getReportPath(), resultMatrix);

				Steps steps = new Steps(userS);
				
				userS.setScenario(testCase + "01");
				userS.testActions(() -> {
					//	Escenario: [Mec01] - Alta proyecto: datos catastro+cliente nuevo+complet+cobro mediador			
					
					/*
					 * Dado el mediador "mediador"    
						Y la referencia catastral "ref_catastral"     
						Y la modalidad "modalidad" 
						Y el tomador es "tomador"    
						Y el medio de pago es "medio_pago" 
						Cuando doy de alta una simulacion y convierto esta simulacion a un projecto usando el acceso "acceso" y el usuario "usuario"
						#Y cierro el navegador
						Entonces el resultado es que el projecto se crea correctamente    

					 **/				
					
				
						//steps.el_usuario_se_logea_en_X(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
						steps.doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
						//steps.cierro_navegador();
					
					
					return null;
				}).run();
				//doTest(userS, steps);
			}
		}

		@BeforeSuite
		public synchronized void initializeExecution(ITestContext context) {
			System.out.println("[INFO] - Initializing execution for OS: " + OSUtils.getOsName());
			String[] browsers = InitUtils.getTestBrowsers();

			testData = InitUtils.initializeTestData(InitUtils.getTestDataPath(defaultTestData), defaultScenarioData, AutomationConstants.CONFIGURATION_DATA_SET);
			testData.generateTimeStamp(testCase);
			testData.setCaseVariables(FileUtils.loadDataFileToArray(InitUtils.getTestDataPath(defaultTestData), true)[0]);

			testData.getTestData().duplicateDataByN(browsers.length);

			if(testData.getDailyCase().contains("continue") && new File(testData.getReportPath() + testData.getTimeStamp() + ".csv").exists()) {
				System.out.println("[INFO] - Continue daily");
				resultMatrix = InitUtils.getResultMatrixFromCsvFile(testData.getReportPath() + testData.getTimeStamp() + ".csv");
				casesMatrix = InitUtils.getCasesMatrixFromResultMatrix(resultMatrix);
			} else {
				casesMatrix = InitUtils.getCasesMatrixFromBrowserArray(browsers, testData.getTestData().size());
				resultMatrix = InitUtils.getResultMatrixFromTestData(testData.getTestData(), browsers, testData.getCaseVariables());
			}
			
			InitUtils.setThreads(context);
		}

		@AfterSuite
		public void afterSuite() {
			System.out.println("[INFO] - Generating HTML...");
			CsvToHtml.createReport(testData.getTimeStamp(), testData.getReportPath(), testCase);
		}
	}


