package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MediadoresDGSPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By notificarDGSBtn = By.cssSelector("#BUSENVIO");
	private By descartarNotificarDGSBtn = By.cssSelector("#BUSENVIO2");
	private By tipoMediadorAgenteExclusivoBtn = By.cssSelector("#TIPOMEDI");
	private By tipoMediadorAuxiliarBtn = By.cssSelector("#TIPOMEDI2");

	private By actualizarInformacionEnvioBtn = By.cssSelector("#BUSRECEP");
	private By actualizarMediadoresEnvioBtn = By.cssSelector("#BUSRECEP2");
	private By numeroEnvioInternoBtn = By.cssSelector("#BUSC");
	private By numeroExpedienteBtn = By.cssSelector("#BUSC2");
	private By numeroRegistroBtn = By.cssSelector("#BUSC3");
	private By numeroTasasBtn = By.cssSelector("#BUSC4");

	private By numeroBuscadoInput = By.cssSelector("#NUMERO");
	private By numeroReferenciaInput = By.cssSelector("#ALTAMEDI_NUMEXPED");
	private By fechaReferenciaInput = By.cssSelector("#ALTAMEDI_FCREGSTR");
	private By numeroRegistroInput = By.cssSelector("#ALTAMEDI_NUMRGSTR");
	private By numeroPagoTasasInput = By.cssSelector("#ALTAMEDI_NUMTASA");
	private By fechaInscripcionInput = By.cssSelector("#ALTAMEDI_FEINSDGS");
	private By respuestaDGSCombo = By.cssSelector("#tr1 > td:nth-child(2) > select");
	private By codigoEntidadInput = By.cssSelector("#entidad1");

	private By buscarBtn = By.cssSelector("#cajabuscador > tbody > tr > td.marcofnd > input");
	private By enviarDGSBtn = By.cssSelector("#BOTON_ENVIDGS");
	private By actualizarBtn = By.cssSelector("#BOTON_ACTUALIZAR");
	private By descartarDGSBtn = By.cssSelector("#BOTON_DESCDGS");

	private By xmlBtn = By.cssSelector("#BUSCADGS_XML");
	private By excelBtn = By.cssSelector("#BUSCADGS_XLS");
	private By volverBtn = By.cssSelector("#BUSCADGS_BACK");

	private By elemtosListaDGS = By.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > tr[id*='tr']");
	// endregion

	public MediadoresDGSPage(UserStory userS) {
		super(userS);
	}

	// -------------- Métodos sencillos Envío DGS --------------
	public MediadoresDGSPage clickActualizar() {
		debugBegin();
		webDriver.clickInFrame(actualizarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		webDriver.waitWithDriver(5000);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickEnviarDGS() {
		debugBegin();
		webDriver.clickInFrame(enviarDGSBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickXML() {
		debugBegin();
		webDriver.clickInFrame(xmlBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickExcel() {
		debugBegin();
		webDriver.clickInFrame(excelBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickVolver() {
		debugBegin();
		webDriver.clickInFrame(volverBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickDescartarDGS() {
		debugBegin();
		webDriver.clickInFrame(descartarDGSBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// -------------- Métodos sencillos Recepción DGS --------------

	public MediadoresDGSPage clickActualizarInfoEnvio() {
		debugBegin();
		webDriver.clickInFrame(actualizarInformacionEnvioBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickActualizarMediadorEnvio() {
		debugBegin();
		webDriver.clickInFrame(actualizarMediadoresEnvioBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// !!!!!! Montar MÉTODO PARA GESTIONAR CÚANDO INICIAR STEP

	public MediadoresDGSPage envioMediadorDGS() {
		debugBegin();
		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE")) {
			webDriver.clickInFrame(tipoMediadorAuxiliarBtn, cuerpoFrame);
		}
		if(getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {
			webDriver.clickInFrame(tipoMediadorAgenteExclusivoBtn, cuerpoFrame);
		}
		clickBuscar();
		seleccionarMediadorEnvioDGS("121800"); // ir a resultados mediante método para localizarlos y seleccionar el mediador que toca. Revisar si hay otra lógica para los auxiliares, prueba con AE
		clickEnviarDGS();
		obtenerNumDGS();
		debugEnd();
		return this;
	}

	public MediadoresDGSPage recepcionMediadoresDGS() {
		debugBegin();

		// ir a recepción (reformular que esté en el HomePage de Mediadores)
		// método para la recepcionDGS del mediador

		//copiar referencia en "Número" + Acualizar información de envió + Número de envio interno activos  (se queda activo)
		// clic en Buscar
		// espera
		//copiar referencia en "Nº de referencia:" + "Fecha referencia" poner fecha actual + clic en actualizarBtn
		// espera
		// en teoría mensaje: "Para ver la lista completa de envíos diríjase a: Menú principal> Control de gestión> Consultas SQL(V2.0)"
		// hasta aquí - C255 - paso 7

		//copiar referencia en "Número" + Actualizar mediadores envío + Número de envio interno activos (se queda activo)
		// clic en Buscar
		// espera
		// Completar el campo "Fecha inscripción" con la fecha actual
		// método para localizar el mediador que nos interesa
		// método para comprobar que el mediador cuenta con la selección "Autorizado" en su desplegable "Respuesta DGS"
		// clic en Actualizar para completar el proceso

		// método para comrpobar la ficha del mediador --> esta tiene el cambio a Estado: Activo restringido

		debugEnd();
		return this;
	}

	public MediadoresDGSPage seleccionarMediadorEnvioDGS(String idMediadorAltaDGS) {
		debugBegin();

		List<WebElement> obtenerListaEnvioDGS = webDriver.getElementsInFrame(elemtosListaDGS, cuerpoFrame);
		debugInfo("contiene " + obtenerListaEnvioDGS.size() + " mediadores en estado Envio DGS");

		for(int i = 1; i < obtenerListaEnvioDGS.size(); i++) {
			String obtenerIdMediador = webDriver.getTextInFrame(By
				.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr" + (i + 1) + " > td:nth-child(2)"), cuerpoFrame); // > input quitado porque es el child element a clickar
			debugInfo("El Id del mediador es: " + obtenerIdMediador);

			if(obtenerIdMediador.equalsIgnoreCase(idMediadorAltaDGS)) {
				boolean checkMediadorValue = obtenerIdMediador.equalsIgnoreCase(idMediadorAltaDGS);
				debugInfo("Comprobamos la id del mediador es: " + checkMediadorValue);
				Assert.assertTrue(checkMediadorValue, "Comparar campos: la dirección Postal producción NO coincide");
				webDriver.getElementChildByAttributeInFrame(obtenerIdMediador, cuerpoFrame, "value", idMediadorAltaDGS);
			}


		/*	webDriver.getElementChildByAttributeInFrame("obtenerIdMediador", cuerpoFrame, "value", idMediadorAltaDGS);
			webDriver.clickElementChildByAttributeInFrame("obtenerIdMediador", cuerpoFrame, "value", idMediadorAltaDGS);*/
		}
	//	webDriver.clickElementChildByAttributeInFrame();

	//	String checkMediador = webDriver.getTextInFrame(By.cssSelector(""));
	//		webDriver.isPresentAndClick("value", idMediadorAltaDGS);
			// recoger Id del mediador que interesa

			// generar lista con los chebox disponibles

			// analizar el contenido de value de los checkbox

			// hacer click en el que haya coincidencia con el mediador que nos interesa

			debugEnd();
		return this;
	}

	public MediadoresDGSPage obtenerNumDGS() {
		debugBegin();
/* método para solucionar copy "Enviado correctamente. Código de envio número 20200129_121249 . Puede descargar los ficheros asociados"
			 #bloque1 > table:nth-child(2) > tbody > tr > td > strong  ver de este obtenerDatoAltaIntermediario() en la FichaPage */
		debugEnd();
		return this;
	}

} // END PAGE
