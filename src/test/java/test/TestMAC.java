package test;

import com.automation.configuration.AutomationConstants;
import com.automation.data.DataObject;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.FileUtils;
import com.automation.model.utils.InitUtils;
import com.automation.model.utils.OSUtils;
import com.project.ProjectConstants;
import com.project.steps.Steps;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
//import com.project.steps.ActionsSteps;


public class TestMAC {

		private TestDataManager testData;
		private String testCase = ProjectConstants.MAC;
		private String[][] casesMatrix = null, resultMatrix = null;
		//private String defaultTestData = "testDataMec01.csv", defaultScenarioData = "scenarioData.csv";
		//private String defaultTestData = "testDataMec01.csv", defaultScenarioData = userS.setScenario(userS.getScenario() + "01");
		private String defaultTestData = "testDataMac01.csv", defaultScenarioData = "datosTestMac.csv";
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

				LocalDate date = LocalDate.now();
				DayOfWeek dow = date.getDayOfWeek();
				String dia = dow.getDisplayName(TextStyle.SHORT, Locale.US);

				DataObject ficheroReferencias = new DataObject(FileUtils.csvFileToDMData(
						System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "datosMac" + dia + ".csv"));

				testData.addData(ficheroReferencias, "fichero_referencias");
				
				userS.testActions(() -> {

					/*
					 * Escenario: [Mac01] - Alta de proyecto de alquiler desde GO, pasando por la autorizacion, con estudio aceptado
						Dado la renta de alquiler mensual es "renta_mensual_alquiler"
						Y el nombre del inquilino "nombre_inquilino"
						Y el primer apellido del inquilino "primer_apell_inqulino"
						Y el documento aleatoreo
						Y con ingresos "ingresos_inquilino"
						Y situacion laboral "situacion_laboral"
						Y el tomador es "tomador"
						Y el tipo de persona es "tipo_persona"
						Y el documento de tomador es aleatoreo
						Y el nombre de tomador es "tomador_nombre"
						Y el primer apellido de tomador es "tomador_apellido"
						Y la provincia de tomador es "provincia"
						Y la poblacion de tomador es "poblacion"
						Y la direccion de tomador es "nombre_via"
						Y el numero de portal de tomador es "numero_via"
						Y la fecha de nacimiento de tomador es "fecha_nacimiento"
						Y el numero de cuenta es "numero_cuenta"
						Y la provincia del inmueble es "provincia_inm"
						Y la poblacion del inmueble es "poblacion_inm"
						Y la direccion del inmueble es "via_inm"
						Y el numero de portal del inmueble es "numerovia_inm"
						Y la fecha de contrato del alquiler es "fecha_contr_alq"
						Cuando doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso "acceso" y el usuario "usuario"
						Y envio el proyecto a la compañia
						Y cierro el navegador
						Y autorizo el proyecto MAC usando el acceso "accesoAuth" y usuario "usuarioAuth"
						Y cierro el navegador
						Y completo el proceso de contratacion usando el acceso "acceso" y usuario "usuario"
						Entonces resultado es que el projecto se crea correctamente
					 **/
					
				
						//steps.el_usuario_se_logea_en_X(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
						steps.doy_de_alta_un_proyecto_MAC_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
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


