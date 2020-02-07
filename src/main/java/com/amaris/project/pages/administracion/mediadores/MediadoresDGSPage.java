package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
	//private By buscarBtn = By.cssSelector("#cajabuscador > tbody > tr > td.marcofnd > input[onclick='buscar()']"); por probar
	//private By buscarBtn = By.cssSelector("#cajabuscador > tbody > tr > td.marcofnd > input[value='Buscar']");

	private By enviarDGSBtn = By.cssSelector("#BOTON_ENVIDGS");
	private By actualizarBtn = By.cssSelector("#BOTON_ACTUALIZAR");
	private By descartarDGSBtn = By.cssSelector("#BOTON_DESCDGS");

	private By xmlBtn = By.cssSelector("#BUSCADGS_XML");
	private By excelBtn = By.cssSelector("#BUSCADGS_XLS");
	private By volverBtn = By.cssSelector("#BUSCADGS_BACK");

	private By listaDGSE = By.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > tr[id*='tr']");
	private By envioDGSCorrectoTxt = By.cssSelector("#bloque1 > table:nth-child(2) > tbody > tr > td > strong");

	// endregion

	public MediadoresDGSPage(UserStory userS) {
		super(userS);
	}

	// -------------- Métodos sencillos Envío DGS --------------
	public MediadoresDGSPage clickActualizar() {
		debugBegin();
		webDriver.clickInFrame(actualizarBtn, cuerpoFrame);
		webDriver.waitWithDriver(4000);
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

	// !!!!!! Montar MÉTODO PARA GESTIONAR CÚANDO INICIAR STEP, se incorpora desde la ficha como resultado del cambio de estado

	public MediadoresDGSPage envioMediadorDGS() {
		debugBegin();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("AE")) {
			webDriver.waitWithDriver(4000);
			webDriver.clickInFrame(tipoMediadorAuxiliarBtn, cuerpoFrame);
		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COL") && getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {
			webDriver.waitWithDriver(4000);
			webDriver.clickInFrame(tipoMediadorAgenteExclusivoBtn, cuerpoFrame);
		}
		clickBuscar();
		//	seleccionarMediadorEnvioDGS(getTestVar(Constants.ID_MEDIADOR_ALTA)); // ir a resultados mediante método para localizarlos y seleccionar el mediador que toca. Revisar si hay otra lógica para los auxiliares, prueba con AE
		seleccionarMediadorEnvioDGS(getSuiteVar(Constants.ID_MEDIADOR_ALTA));
		clickEnviarDGS();
		webDriver.waitWithDriver(12000);
		obtenerNumDGS();
		debugEnd();
		return this;
	}

	public MediadoresDGSPage anyadirIdMediador() {
		debugBegin();
		// a la string se le asigna el valor guardado en el CSV y constante
		String idMedAlta = getSuiteVar("id_mediador_alta");
	//	String idMedAlta = getSuiteVar("id_mediador_alta");
		debugInfo("ver si aparece la idMedAlta correctamente: " + idMedAlta);
		debugEnd();
		return this;
	}

	public MediadoresDGSPage recepcionMediadoresDGS() {
		debugBegin();

		// ir a recepción (reformular que esté en el HomePage de Mediadores)

		// métodos para la recepcionDGS del mediador
	/*	webDriver.waitWithDriver(4000);
		webDriver.switchToFrame(cuerpoFrame);*/
		//copiar referencia en "Número" + Acualizar información de envió + Número de envio interno activos  (se queda activo)
		// tras los primeros tests, revisar si se puede probar que los checks sean activos y entonces se haga clic en ellos
	/*	webDriver.click(actualizarInformacionEnvioBtn);
		webDriver.click(numeroEnvioInternoBtn);
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS).toString());
		webDriver.setText(numeroBuscadoInput, "20200205_113051");
		webDriver.exitFrame(); -------------refactorizando*/
		actualizaInfoEnvioEnRecepcionDGS(getScenarioVar(Constants.NUMERO_REF_DGS));// ver si mejor con o sin toString
		clickBuscar();
	/*	webDriver.switchToFrame(cuerpoFrame);
		//copiar referencia en "Nº de referencia:" + "Fecha referencia" poner fecha actual
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS).toString());
		webDriver.setText(numeroReferenciaInput, "20200205_113051");
		//		debugInfo("El número DGS es: " + getTestVar(Constants.NUMERO_REF_DGS));
		String datoFechaReferencia = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.waitWithDriver(3000);
		webDriver.setText(fechaReferenciaInput, datoFechaReferencia);
		webDriver.exitFrame();
		----refactorizando*/
		actualizaInfoEnvioFechaRecepcionDGS(getScenarioVar(Constants.NUMERO_REF_DGS).toString()); // ver si mejor con o sin toString
		clickActualizar();

		//copiar referencia en "Número" + Actualizar mediadores envío + Número de envio interno activos (se queda activo)
		// tras los primeros tests, revisar si se puede probar que los checks sean activos y entonces se haga clic en ellos
	/*	webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(actualizarMediadoresEnvioBtn);
		webDriver.click(numeroEnvioInternoBtn);
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS)); // repasar funcionamiento porque en postpro, complet este campo deja de dar resultados
		webDriver.setText(numeroBuscadoInput, "20200205_113051");
		webDriver.exitFrame();*/
		actualizarMedEnvioEnRecepcionDGS(getScenarioVar(Constants.NUMERO_REF_DGS).toString());
		clickBuscar();

		// Completar el campo "Fecha inscripción" con la fecha actual
		String datoFechaInscripcion = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.waitWithDriver(3000);
		webDriver.setTextInFrame(fechaInscripcionInput, cuerpoFrame, datoFechaInscripcion);
		// método para localizar el mediador que nos interesa y comprobar que el mediador cuenta con la selección "Autorizado" en su desplegable "Respuesta DGS"
		//seleccionarMediadorRecepcionDGS(getTestVar(Constants.ID_MEDIADOR_ALTA).toString());
		seleccionarMediadorRecepcionDGS(getSuiteVar(Constants.ID_MEDIADOR_ALTA));
		clickActualizar();

		debugInfo("finalizado el proceso para autorizar el DGS en 'Recepción DGS'");

		debugEnd();
		return this;
	}

	public MediadoresDGSPage actualizaInfoEnvioFechaRecepcionDGS (String reInternaDGS) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		//copiar referencia en "Nº de referencia:" + "Fecha referencia" poner fecha actual
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS).toString());
		webDriver.setText(numeroReferenciaInput, reInternaDGS);
		//		debugInfo("El número DGS es: " + getTestVar(Constants.NUMERO_REF_DGS));
		String datoFechaReferencia = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.waitWithDriver(3000);
		webDriver.setText(fechaReferenciaInput, datoFechaReferencia);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresDGSPage actualizarMedEnvioEnRecepcionDGS(String reInternaDGS) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(actualizarMediadoresEnvioBtn);
		webDriver.click(numeroEnvioInternoBtn);
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS)); // repasar funcionamiento porque en postpro, complet este campo deja de dar resultados
		webDriver.setText(numeroBuscadoInput, reInternaDGS);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresDGSPage actualizaInfoEnvioEnRecepcionDGS(String reInternaDGS) {
		webDriver.switchToFrame(cuerpoFrame);
		//copiar referencia en "Número" + Acualizar información de envió + Número de envio interno activos  (se queda activo)
		// tras los primeros tests, revisar si se puede probar que los checks sean activos y entonces se haga clic en ellos
		webDriver.click(actualizarInformacionEnvioBtn);
		webDriver.click(numeroEnvioInternoBtn);
		//	webDriver.setText(numeroReferenciaInput, getTestVar(Constants.NUMERO_REF_DGS).toString());
		webDriver.setText(numeroBuscadoInput, reInternaDGS);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresDGSPage seleccionarMediadorRecepcionDGS(String idMediadorAutorizaDGS) {
		debugBegin();

		List<WebElement> obtenerListaEnvioDGS = webDriver.getElementsInFrame(listaDGSE, cuerpoFrame);
		debugInfo("contiene " + obtenerListaEnvioDGS.size() + " mediadores en estado Envio DGS");

		//for(int i = 0; i < obtenerListaEnvioDGS.size(); i++) {
		String obtenerIdMediador = webDriver.getTextInFrame(By
			.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr1 > td:nth-child(5)"), cuerpoFrame).trim().toString();
		debugInfo("El Id del mediador es: " + obtenerIdMediador);

		/*	String obtenerIdMediador = webDriver.getTextInFrame(By
				.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr" + (i + 1) + " > td:nth-child(3)"), cuerpoFrame).trim();
			debugInfo("El Id del mediador es: " + obtenerIdMediador);*/

		/*	if(obtenerIdMediador.equalsIgnoreCase(idMediadorAutorizaDGS)) {
				boolean checkMediadorValue = obtenerIdMediador.equalsIgnoreCase(idMediadorAutorizaDGS);
				debugInfo("Comprobamos la id del mediador es: " + checkMediadorValue);
				Assert.assertTrue(checkMediadorValue, "Comparar campos: la Id del mediador NO coincide");

				// comprobar desplegable "autorizado"
				webDriver.clickElementChildByAttributeInFrame(By
					.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr" + (i + 1) + " > td:nth-child(2) > select > option"), cuerpoFrame, "value", "autorizado");
			debugInfo("Se comprueba y hace clic en Autorizado del mediador. Test completado");
			*/
		if(obtenerIdMediador.equals(idMediadorAutorizaDGS)) {
			debugInfo("Se accede a los métodos de condición cuando se cumple");
			boolean checkMediadorValue = obtenerIdMediador.equalsIgnoreCase(idMediadorAutorizaDGS);
			debugInfo("Comprobamos la id del mediador es: " + checkMediadorValue);
			Assert.assertTrue(checkMediadorValue, "Comparar campos: la Id del mediador NO coincide");

			// comprobar desplegable "autorizado"
			if(checkMediadorValue == true) {
				webDriver.clickElementFromDropDownByAttributeInFrame(By
					.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr1 > td:nth-child(2) > select"), cuerpoFrame, "value", "autorizado");
				debugInfo("Se comprueba y hace clic en Autorizado del mediador. Test completado");
			}

		} else {
			debugInfo("El mediador cuya recepción se autoriza no se encuentra en la lista");
		}

		debugEnd();
		return this;
	}

	public MediadoresDGSPage seleccionarMediadorEnvioDGS(String idMediadorAltaDGS) {
		debugBegin();

		List<WebElement> obtenerListaEnvioDGS = webDriver.getElementsInFrame(listaDGSE, cuerpoFrame);
		debugInfo("contiene " + obtenerListaEnvioDGS.size() + " mediadores en estado Envio DGS");

		for(int i = 1; i < obtenerListaEnvioDGS.size(); i++) {
			String obtenerIdMediador = webDriver.getTextInFrame(By
				.cssSelector("#formDatosEnvio > table.grid.widthstd > tbody > #tr" + (i + 1) + " > td:nth-child(3)"), cuerpoFrame).trim();
			debugInfo("Los Id de los mediadores disponibles son: " + obtenerIdMediador);

			if(obtenerIdMediador.equalsIgnoreCase(idMediadorAltaDGS)) {
				//	boolean checkMediadorValue = obtenerIdMediador.equalsIgnoreCase(idMediadorAltaDGS);
				debugInfo("Comprobamos la id del mediador es: " + obtenerIdMediador);
				//	Assert.assertTrue(checkMediadorValue, "Comparar campos: la Id del mediador NO coincide");
				webDriver.clickElementChildByAttributeInFrame(By
					.cssSelector(
						"#formDatosEnvio > table.grid.widthstd > tbody > #tr" + (i + 1)
							+ " > td:nth-child(2)"), cuerpoFrame, "value", idMediadorAltaDGS); // > input quitado porque es child element
			}
		}

		debugEnd();
		return this;
	}

	public MediadoresDGSPage obtenerNumDGS() {
		debugBegin();
		webDriver.waitWithDriver(10000);
/*		if(webDriver.isPresentInFrame(envioDGSCorrectoTxt, cuerpoFrame)) {
			debugInfo("Mensaje correcto: " + webDriver.getTextInFrame(envioDGSCorrectoTxt, cuerpoFrame));

			setTestVar(Constants.NUMERO_REF_DGS, webDriver.getTextInFrame(envioDGSCorrectoTxt, cuerpoFrame).trim().substring(47, 41).toString());
		} else {
			debugError("Se ha producido un error al obtener el número de referencia DGS");
		}*/
		setSuiteVar(Constants.NUMERO_REF_DGS, webDriver.getTextInFrame(envioDGSCorrectoTxt, cuerpoFrame).trim().substring(46, 61));

	//	webDriver.getTextInFrame(envioDGSCorrectoTxt, cuerpoFrame).trim().substring(46, 61);

		debugInfo("Mensaje correcto: " + webDriver.getTextInFrame(envioDGSCorrectoTxt, cuerpoFrame).trim().substring(46, 61));
		debugEnd();
		return this;
	}

} // END PAGE
