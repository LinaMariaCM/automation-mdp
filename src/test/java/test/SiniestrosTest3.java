package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class SiniestrosTest3 extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(Constants.ALTA_SINIESTROS);
 

	// PRUEBAS SINIESTROS MEC
	
	
//Circuito completo siniestros : convencional especializado con Asistencia
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec01() {
		String testCase = Constants.MEC_SINIESTROS + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros331.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec01")
	public void siniestrosMec01(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);
		
		suiteM.setRelevantColumn(testCase, 3);

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

	
	//Circuito completo siniestros : convencional especializado con Perito
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec02() {
		String testCase = Constants.MEC_SINIESTROS + "02";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec02")
	public void siniestrosMec02(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			steps.alta_siniestro_simple();
			steps.cierro_navegador();
			
			steps.login("Innova", "Eperez");
			steps.realizo_pago_simple();
			steps.cierre_siniestro();
			
			steps.login("Innova", "Eperez");
			steps.reapertura_siniestro();
			steps.cierro_navegador();

			
			
			return null;
		}).run();
	}

		
	
	//Circuito completo siniestros : convencional especializado con Recobro
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec03() {
		String testCase = Constants.MEC_SINIESTROS + "03";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec03")
	public void siniestrosMec03(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
//			steps.login("Innova", "Eperez");
//			steps.alta_siniestro_simple();
//			steps.cierro_navegador();
			
			steps.login("Innova", "Eperez");
			steps.realizo_recobro();
			steps.cierro_navegador();
			
//			steps.login("Innova", "Eperez");
//			steps.realizo_pago_simple();
//			steps.cierro_navegador();
			//steps.cierre_siniestro();
			//steps.reapertura_siniestro();

			
			
			return null;
		}).run();
	}

	
	
	//Circuito completo siniestros : convencional especializado con Defensa Judicial
	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec04() {
		String testCase = Constants.MEC_SINIESTROS + "04";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec04")
	public void siniestrosMec04(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			
			steps.alta_siniestro_simple();
			
			steps.realizo_pago_simple();
			
			steps.cierre_siniestro();
			
			steps.reapertura_siniestro();

			
			
			return null;
		}).run();
	}

	
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec05() {
		String testCase = Constants.MEC_SINIESTROS + "05";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	//Alta de siniestros con comprobaciones
	@Test(dataProvider = "dataProviderSiniestrosMec05")
	public void siniestrosMec05(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			
			steps.alta_siniestro_simple();
			
			steps.tramito_siniestro_tras_alta();
			
			steps.compruebo_que_datos_han_viajado(); //TODO añadir más campos
					
			steps.compruebo_carpeta_y_encargos();
						
			
			return null;
		}).run();
	}
	
	//comunicaciones en siniestros
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec06() {
		String testCase = Constants.MEC_SINIESTROS + "06";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	
	//Comunicacion siniestro
	@Test(dataProvider = "dataProviderSiniestrosMec06")
	public void siniestrosMec06(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			
			steps.comunico_siniestro();
					
			steps.compruebo_comunicacion_siniestro();
						
			
			return null;
		}).run();
	}
	
	//Alta anotación de un siniestro
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec07() {
		String testCase = Constants.MEC_SINIESTROS + "07";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec07")
	public void siniestrosMec07(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			steps.login("Innova", "Eperez");
			
			steps.anyado_anotacion_siniestro();
					
			steps.compruebo_anotacion_siniestro();
						
			
			return null;
		}).run();
	}
	
	
	//modifico un siniestro
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec08() {
		String testCase = Constants.MEC_SINIESTROS + "08";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec08")
	public void siniestrosMec08(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			//TODO
						
			
			return null;
		}).run();
	}
	
	//compruebo agenda siniestro
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec09() {
		String testCase = Constants.MEC_SINIESTROS + "09";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec09")
	public void siniestrosMec09(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			//TODO
			steps.login("Innova", "Eperez");
			
			steps.nueva_tarea_siniestros();
			
			//steps.compruebo_tarea_siniestro();
			
			//steps.modifico_tarea_siniestro();
			
			//steps.cierro_tarea_siniestro();
			
			//steps.
			
			
			return null;
		}).run();
	}
	
	
	
	//Información General estática de Siniestros
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestrosMec10() {
		String testCase = Constants.MEC_SINIESTROS + "10";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "datosTestAltaSiniestros32.csv");

		return casesMatrix;
	}
	
	@Test(dataProvider = "dataProviderSiniestrosMec10")
	public void siniestrosMec10(String testCase, String id) throws Exception {
		UserStory userS = suiteM.createUserStory(testCase, id);
		ActionSteps steps = new ActionSteps(userS);

		userS.testActions(() -> {
			
			//TEST TIPO
						
			
			return null;
		}).run();
	}

	
	//END
	@AfterSuite
	public void afterSuite() {
		suiteM.createHtmlReport();
	}

}
