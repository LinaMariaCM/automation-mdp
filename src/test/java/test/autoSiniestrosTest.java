package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;


public class autoSiniestrosTest extends TestObject{

//TODO Alta Siniestro	

//TODO Nueva Comunicación
	
//TODO Alta anotación
	
//TODO Modificar Siniestro : Datos y Descripciones
	
//TODO Modificar Siniestro : Causa
	
//TODO Alta tarea Agenda
	
//TODO Modificar una tarea de la Agenda
	
//TODO Cerrar una tarea de la Agenda
	
//TODO Transicionar bloque
	
//TODO Modificar Reservas
	
//TODO Modificar Reservas a cero - CIERRE
	
//TODO Modificar Expectativas
	
//TODO Realizar pago - cuenta no validada
	
//TODO Cierre Siniestro - Encargos
	
//TODO Cierre Siniestros - Tareas
	
//TODO Rehuse de Siniestro
	
//TODO Cierre de Siniestro
	
//TODO Reapertura de Siniestro
	
//TODO Guardar alta sin completar
	
//TODO Alta comprobación de campos
	
	@AfterSuite
	public void afterSuite() { try
		{suiteM.createHtmlReport();
		suiteM.createPdfReport();} catch(Exception E) {E.printStackTrace();}
	}

}//END
