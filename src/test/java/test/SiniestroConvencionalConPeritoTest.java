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
import com.project.steps.Steps;

public class SiniestroConvencionalConPeritoTest {

	
	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.SINIESTRO_CONVENCIONAL_CON_PERITO);

	// PRUEBA MEC_SINIESTROS
	@DataProvider(parallel = true)
	public String[][] dataProviderSiniestroConvencionalConPerito() {
		String testCase = ProjectConstants.SINIESTRO_CONVENCIONAL_CON_PERITO + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestroConvencionalConPerito.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderSiniestroConvencionalConPerito")
	public void siniestroConvencionalConPerito01(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		//userS.addDMData("datosMec" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");
		//userS.addDMData("datosMecSin.csv", "fichero_referencias");

		userS.testActions(() -> {

////	1.  Alta siniestro desde GOL 
//
//			steps.login("GOL", "640");
//			System.out.println("He pasado al siguiente step");			
//			steps.alta_siniestro("900902646","GOL");
//			
			
//	1. Alta siniestro desde  INNOVA
			
			steps.login("Innova", "Eperez");
			System.out.println("################################");
			System.out.println("# He pasado al siguiente step. #");
			System.out.println("################################");
			steps.alta_siniestro("Innova","900902646");			
			
			
	
//	2.  Se apertura siniestro en Sisnet (ver que han viajado correctamente todos los datos de la póliza, datos mediador y referencia mediador)
			
			

//	3.  La causa viaja con la provisión correcta de apertura

//	4.  Asignación de tramitador correcta

//	5.  Se tiene que visualizar la referencia Sisnet y referencia eMutua

//	6.  solicitamos encargo pericial

//	7.  solicitamos encargo pericial durante la tramitación

//	8.  Por cada implicado generamos una carpeta, la reserva de la carpeta es de 0,01 €

//	9.  Subimos documentación desde el content manager y se generan tareas

//	10. Se han creado agendas de control de recepción de encargo pericial

//	11. se reciben los avances previos (ver si la reserva se reajusta cuando se recibe previo con modificación de reserva)

//	12. Se recibe la minuta pericial. Tiene que registrarse en Sisnet todo el pago de la minuta

//	13. Se recibe informe pericial

//	14. Los hitos del siniestro definidos se transcriben en el diario del siniestro

//	15. "Podemos realizar comunicaciones desde el diario del siniestro y las mismas quedan registradas en el diario
//	     y en el gestor documental"
	 
//	16. Realizamos pago de indemnización o una denegación del siniestro

//	17. El circuito de pago se realiza correctamente / la carta de rehuse se genera correctamente

//	18. Cerramos carpeta
	
//	19. Cerramos siniestro 

//	20. Reaperturar siniestro cerrado
	return null;
}).run();
}

@AfterSuite
public void afterSuite() {
suiteM.createHtmlReport();
}


}
