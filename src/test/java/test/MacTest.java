package test;

import com.automation.model.testing.SuiteManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.TestObject;
import com.automation.model.utils.CsvToHtml;
import com.automation.model.utils.InitUtils;
import com.project.ProjectConstants;
import com.project.steps.Steps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MacTest extends TestObject {

	protected SuiteManager suiteM = new SuiteManager(ProjectConstants.MAC);

	// PRUEBA MAC01
	@DataProvider(parallel = true)
	public String[][] dataProviderMac01() {
		String testCase = ProjectConstants.MAC + "01";
		String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestMac.csv");

		return casesMatrix;
	}

	@Test(dataProvider = "dataProviderMac01")
	public void mac01(String testCase, String id, String browser) throws Exception {
		UserStory userS = InitUtils.createUserStory(id, testCase, suiteM, browser);
		Steps steps = new Steps(userS);

		userS.addDMData("datosMac" + Steps.getDayOfWeek() + ".csv", "fichero_referencias");

		userS.testActions(() -> {
			/*
			 * Escenario: [Mac01] - Alta de proyecto de alquiler desde GO,
			 * pasando por la autorizacion, con estudio aceptado Dado la renta
			 * de alquiler mensual es "renta_mensual_alquiler" Y el nombre del
			 * inquilino "nombre_inquilino" Y el primer apellido del inquilino
			 * "primer_apell_inqulino" Y el documento aleatoreo Y con ingresos
			 * "ingresos_inquilino" Y situacion laboral "situacion_laboral" Y el
			 * tomador es "tomador" Y el tipo de persona es "tipo_persona" Y el
			 * documento de tomador es aleatoreo Y el nombre de tomador es
			 * "tomador_nombre" Y el primer apellido de tomador es
			 * "tomador_apellido" Y la provincia de tomador es "provincia" Y la
			 * poblacion de tomador es "poblacion" Y la direccion de tomador es
			 * "nombre_via" Y el numero de portal de tomador es "numero_via" Y
			 * la fecha de nacimiento de tomador es "fecha_nacimiento" Y el
			 * numero de cuenta es "numero_cuenta" Y la provincia del inmueble
			 * es "provincia_inm" Y la poblacion del inmueble es "poblacion_inm"
			 * Y la direccion del inmueble es "via_inm" Y el numero de portal
			 * del inmueble es "numerovia_inm" Y la fecha de contrato del
			 * alquiler es "fecha_contr_alq" Cuando doy de alta un proyecto MAC
			 * que llega hasta la pantalla contratación usando el acceso
			 * "acceso" y el usuario "usuario" Y envio el proyecto a la compañia
			 * Y cierro el navegador Y autorizo el proyecto MAC usando el acceso
			 * "accesoAuth" y usuario "usuarioAuth" Y cierro el navegador Y
			 * completo el proceso de contratacion usando el acceso "acceso" y
			 * usuario "usuario" Entonces resultado es que el projecto se crea
			 * correctamente
			 **/

			steps.dar_de_alta_un_proyecto_MAC(userS.getScenarioVar("acceso"), userS.getScenarioVar("usuario"));
			steps.enviar_el_proyecto_a_la_compania();
			steps.cerrar_navegador();
			steps.autorizar_el_proyecto_MAC(userS.getScenarioVar("accesoAuth"), userS.getScenarioVar("usuarioAuth"));
			return null;
		}).run();
	}

	@AfterSuite
	public void afterSuite() {
		CsvToHtml.createJointReport(suiteM);
	}
}
