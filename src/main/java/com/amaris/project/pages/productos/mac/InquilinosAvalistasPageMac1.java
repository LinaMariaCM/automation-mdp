package com.amaris.project.pages.productos.mac;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

import org.openqa.selenium.By;

public class InquilinosAvalistasPageMac1 extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By modalRaro = By.cssSelector("#docu div[class='row block'] #botonAddDoc");
	private By modalRaro2 = By.cssSelector(".modal-backdrop.fade.in");

	private By anyadirDatosInquilinoPantallaPrincipalBtn = By.cssSelector("#altaInt");

	private By anyadirDatosInquilinoBtn = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");
	private By detalleDrpDwn = By.cssSelector("#INQUIAVAL_TIPOCONTRATLABAUT_CONF");
	private By documentoInput = By.cssSelector("#INQUIAVAL_DOCUMENTOFIS_CONF");
	private By tipoIntervinienteDrpDwn = By.id("#INQUIAVAL_TIPOINT_CONF");
	private By nombreInput = By.cssSelector("#INQUIAVAL_NOMBREFIS_CONF");
	private By primerApellidoInput = By.cssSelector("#INQUIAVAL_APELL1FIS_CONF");
	private By ingresosInput = By.cssSelector("#INQUIAVAL_INGRENETANU_CONF");
	private By parentescoDrpDwn = By.cssSelector("#INQUIAVAL_GRADOPARENT_CONF");
	private By situacionLaboralDrpDwn = By.cssSelector("#INQUIAVAL_TIPOCONTRATOFIS_CONF");
	private By situacionDetalleDrpDwn = By.cssSelector("#INQUIAVAL_TIPOCONTRATOLAB_CONF");
	private By validacionViabilidadBtn = By.id("INQUIAVAL_VALASNEF_CONF");
	private By modificarBtn = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");

	private By anyadirDocumentacionPrincipalBtn = By.cssSelector("#botonAddDoc");
	private By anadirDocumentoSubidoBtn = By.cssSelector("#addDocumento");
	private By anadirDocumentacionBtn = By.cssSelector("#formDocumentos");

	private By continuarBtn = By.cssSelector("#btnContinuar");

	private By dosNominasAvalBtn = By.name("doc_1");
	private By autorizacionConsultaAvalBtn = By.name("doc_5");

	private By enviarACompaniaBtn = By.cssSelector("#btnEnviar");
	private By editarBtn = By.cssSelector("#modificarInt");

	private By msjErrorTxt = By.cssSelector("#VERIFIRESULT");
	private By numCotizacionTxt = By.cssSelector("#numCot");
	private By anyadirDocBtn = By.cssSelector("#drop-area label");
	private By eliminarDocBtn = By.cssSelector("#orderTableDocu button:nth-child(2)");
	private By cerrarBtn = By.cssSelector("#capaAdjuntarDocumentacion #modalAddDocuInterv > div > div > div.modal-footer > button");

	private By comentarioInput = By.id("ENVIO_COM_COMENTARIOS");
	private By enviarComentariosBtn = By.cssSelector("#formularioEnvio > div.modal-footer > button:nth-child(2)");
	private By unAnyoBtn = By.cssSelector("option[value='AI1']");
	// endregion

	public InquilinosAvalistasPageMac1(UserStory userS) {
		super(userS);
	}

	public InquilinosAvalistasPageMac1 executeActionsInInquilinosAvalistasPage() {
		debugBegin();

		addDatosInquilino();

		anyadirDocumentacion();

		setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());
		debugInfo("Numero Cotizacion: " + getTestVar(Constants.NUM_COTIZACION));

		validacionViabilidadInquilino();

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 modificarRentasInquilino() {
		webDriver.clickInFrame(editarBtn, mainFrame);
		webDriver.appendTextInFrame(ingresosInput, mainFrame, getTestVar(Constants.INGRESOS_INQUILINO_NUEVOS));
		webDriver.clickInFrame(modificarBtn, mainFrame);
		setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());

		return this;
	}

	public InquilinosAvalistasPageMac1 addDatosInquilino() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.click(anyadirDatosInquilinoPantallaPrincipalBtn);

		// webDriver.clickInFrame(btnAnadirDatosInquilinoPantallaPrincipal, mainFrame);
		webDriver.waitWithDriver(3000);

		debugInfo("Nombre inquilino: " + getScenarioVar(Constants.NOMBRE_INQUILINO));
		webDriver.setText(nombreInput, getScenarioVar(Constants.NOMBRE_INQUILINO));

		debugInfo("Aprellido inquilino: " + getScenarioVar(Constants.PRIMER_APELLIDO_INQUILINO));
		webDriver.setText(primerApellidoInput, getScenarioVar(Constants.PRIMER_APELLIDO_INQUILINO));

		debugInfo("Documento inquilino: " + getScenarioVar(Constants.DOCUMENTO_INQUILINO));
		webDriver.setText(documentoInput, getScenarioVar(Constants.DOCUMENTO_INQUILINO));

		// Situacion laboral
		seleccionarSituacion();

		webDriver.waitWithDriver(4000);

		if(webDriver.isClickable(detalleDrpDwn)) {
			webDriver.click(detalleDrpDwn);
			// webDriver.waitWithDriver(3000);
			webDriver.click(unAnyoBtn);
			// webDriver.clickElementFromDropDownByIndex(drpDwnDetalle, mainFrame, 1);
			// webDriver.clickElementFromDropDownByAttribute(drpDwnDetalle, "value", "AI1");
			// webDriver.clickElementFromDropDownByAttributeInFrame(drpDwnDetalle, mainFrame, "value", "AS1");

			// Detalle

			// Ingresos anuales

		}

		debugInfo("Ingresos inquilino: " + getScenarioVar(Constants.INGRESOS_INQUILINO));
		webDriver.setText(ingresosInput, getScenarioVar(Constants.INGRESOS_INQUILINO));

		webDriver.click(anyadirDatosInquilinoBtn);

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 addDatosAval() {
		debugBegin();

		if(webDriver.isPresentInFrame(modalRaro, mainFrame)) {
			webDriver.setAttributeInFrame(modalRaro, mainFrame, "style", "display: none;");
			// webDriver.setAttributeInFrame(modalRaro2, mainFrame, "hidden", "");
		}

		if(webDriver.isPresentInFrame(modalRaro2, mainFrame)) {
			webDriver.setAttributeInFrame(modalRaro2, mainFrame, "hidden", "");
		}

		// if(webDriver.isPresentInFrame(btnCerrarSpesiaru, mainFrame)) {
		// webDriver.isPresentAndClickInFrame(btnCerrarSpesiaru, mainFrame);
		// }

		webDriver.clickInFrame(anyadirDatosInquilinoPantallaPrincipalBtn, mainFrame);

		// webDriver.waitWithDriver(10000);

		// Seleccionar que sea aval
		webDriver.clickElementFromDropDownByText(tipoIntervinienteDrpDwn, "Avalista");

		debugInfo("Nombre inquilino: " + getScenarioVar(Constants.NOMBRE_AVALISTA));
		webDriver.setTextInFrame(nombreInput, mainFrame, userS.getTestVar(Constants.NOMBRE_AVALISTA));

		debugInfo("Aprellido inquilino: " + getScenarioVar(Constants.PRIMER_APELLIDO_AVALISTA));
		webDriver.setTextInFrame(primerApellidoInput, mainFrame, userS.getTestVar(Constants.PRIMER_APELLIDO_AVALISTA));

		// Seleccionar parentesco
		seleccionarParentesco();

		// Situacion laboral
		seleccionarSituacion();

		debugInfo("Documento inquilino: " + getScenarioVar(Constants.DOCUMENTO_AVALISTA));
		webDriver.setTextInFrame(documentoInput, mainFrame, userS.getTestVar(Constants.DOCUMENTO_AVALISTA));

		debugInfo("Ingresos inquilino: " + getScenarioVar(Constants.INGRESOS_AVALISTA));
		webDriver.setTextInFrame(ingresosInput, mainFrame, userS.getTestVar(Constants.INGRESOS_AVALISTA));

		webDriver.clickInFrame(anyadirDatosInquilinoBtn, mainFrame);

		userS.setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 validacionViabilidadInquilino() {
		debugBegin();
		webDriver.clickInFrame(validacionViabilidadBtn, mainFrame);
		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 seleccionarSituacion() {
		debugBegin();
		String situacion = getScenarioVar(Constants.SITUACION_LABORAL);
		debugInfo("Situacion: " + situacion);

		if(situacion.equals(Constants.SITUACION_LABORAL_ASALARIADO)) {
			webDriver.clickElementFromDropDownByText(situacionLaboralDrpDwn, situacion);

			webDriver.clickElementFromDropDownByText(situacionDetalleDrpDwn, Constants.SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2);
		} else {
			webDriver.clickElementFromDropDownByText(situacionLaboralDrpDwn, situacion);
		}

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 seleccionarParentesco() {
		debugBegin();

		String parentescoText = getScenarioVar(Constants.PARENTESCO_AVALISTA);
		webDriver.clickElementFromDropDownByTextInFrame(parentescoDrpDwn, mainFrame, parentescoText);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 anyadirDocumentacion() {
		debugBegin();

		webDriver.clickInFrame(anyadirDocumentacionPrincipalBtn, mainFrame);
		webDriver.clickInFrame(anyadirDocBtn, mainFrame);

		// webDriver.clickInFrame(chkbxDosNominas, mainFrame);
		// webDriver.clickInFrame(chkbxAutorizacionConsulta, mainFrame);

		adjuntarDocumentos();

		// webDriver.clickInFrame(btnAnadirDocumentoSubido, mainFrame);

		webDriver.scrollToElementInFrame(eliminarDocBtn, mainFrame);
		debugInfo("Documento añadido");

		webDriver.clickInFrame(cerrarBtn, mainFrame);

		adjuntarDocumentos();

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 anyadirDocumentacionAval() {
		debugBegin();

		webDriver.clickInFrame(anyadirDocumentacionPrincipalBtn, mainFrame);
		webDriver.clickInFrame(dosNominasAvalBtn, mainFrame);
		webDriver.clickInFrame(autorizacionConsultaAvalBtn, mainFrame);
		webDriver.clickInFrame(anadirDocumentacionBtn, mainFrame);

		adjuntarDocumentos();

		webDriver.clickInFrame(anadirDocumentoSubidoBtn, mainFrame);
		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(cerrarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 adjuntarDocumentos() {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(5000);
		FileHelper.uploadFile((System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf").replaceAll("/", "\\\\"));
		debugInfo("Fichero subido");

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPageMac1 enviarACompania() {
		debugBegin();

		webDriver.clickInFrame(enviarACompaniaBtn, mainFrame);

		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(comentarioInput, mainFrame, "IPSUM SUM LOREM LOREM, ESTO ES UNA PRUEBA DEL EQUIPO TaaS");
		webDriver.clickInFrame(enviarComentariosBtn, mainFrame);

		debugEnd();

		return this;
	}

	public String recuperarTextoMensajeError() {
		debugBegin();
		String result = webDriver.getTextInFrame(msjErrorTxt, mainFrame);
		debugInfo("Texto mensaje de error: " + result);
		debugEnd();

		return result;
	}

	public String recuperarTextoMensajeValidacionOK() {
		debugBegin();
		String result = webDriver.getTextInFrame(msjErrorTxt, mainFrame);
		debugInfo("Texto validacion: " + result);
		debugEnd();

		return result;
	}

	public InquilinosAvalistasPageMac1 clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, mainFrame);
		debugEnd();

		return this;
	}

	public String recuperarNumeroCotizacion() {
		debugBegin();
		String result = webDriver.getTextInFrame(numCotizacionTxt, mainFrame);
		debugInfo("Numero cotizacion: " + result);
		debugEnd();

		return result;
	}

	public InquilinosAvalistasPageMac1 anyadirIngresosNetosAnuales() {
		debugBegin();
		webDriver.setTextInFrame(ingresosInput, mainFrame, "30000");
		debugEnd();

		return this;
	}

}
