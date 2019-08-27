package com.amaris.project.pages;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

import org.openqa.selenium.By;

public class InquilinosAvalistasPage_MAC extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By modalRaro = By.cssSelector("#modalAddDocuInterv");
	private By modalRaro2 = By.cssSelector(".modal-backdrop.fade.in");

	private By btnAnadirDatosInquilinoPantallaPrincipal = By.id("altaInt");

	private By btnAnadirDatosInquilino = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");
	private By drpDwnDetalle = By.cssSelector("#INQUIAVAL_TIPOCONTRATLABAUT_CONF");
	private By txtDocumento = By.cssSelector("#INQUIAVAL_DOCUMENTOFIS_CONF");
	private By tipoInterviniente = By.id("#INQUIAVAL_TIPOINT_CONF");
	private By txtNombre = By.cssSelector("#INQUIAVAL_NOMBREFIS_CONF");
	private By txtPrimerApellido = By.cssSelector("#INQUIAVAL_APELL1FIS_CONF");
	private By txtIngresos = By.cssSelector("#INQUIAVAL_INGRENETANU_CONF");
	private By parentesco = By.cssSelector("#INQUIAVAL_GRADOPARENT_CONF");
	private By situacionLaboral = By.cssSelector("#INQUIAVAL_TIPOCONTRATOFIS_CONF");
	private By situacionDetalle = By.cssSelector("#INQUIAVAL_TIPOCONTRATOLAB_CONF");
	private By btnValidacionViabilidad = By.id("INQUIAVAL_VALASNEF_CONF");
	private By btnModificar = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");

	private By btnAnadirDocumentacionPrincipal = By.cssSelector("#botonAddDoc");
	private By btnAnadirDocumentoSubido = By.cssSelector("#addDocumento");
	private By btnAnadirDocumentacion = By.cssSelector("#formDocumentos");

	private By btnContinuar = By.cssSelector("#btnContinuar");

	private By chkbxDosNominas = By.name("doc_0");
	private By chkbxDosNominasAval = By.name("doc_1");
	private By chkbxAutorizacionConsulta = By.name("doc_2");
	private By chkbxAutorizacionConsultaAval = By.name("doc_5");

	private By elmntFichero = By.cssSelector("#fichero");
	private By btnEnviarACompania = By.cssSelector("#btnEnviar");
	private By btnEditar = By.cssSelector("#modificarInt");

	private By msjError = By.cssSelector("#VERIFIRESULT");
	private By numCotizacion = By.cssSelector("#numCot");
	private By btnAnadirDoc = By.cssSelector("#drop-area label");
	private By btnEliminarDoc = By.cssSelector("#orderTableDocu button:nth-child(2)");
	private By btnCerrar = By.cssSelector("#capaAdjuntarDocumentacion #modalAddDocuInterv > div > div > div.modal-footer > button");
	private By btnCerrarSpesiaru = By.cssSelector("#modalAddDocuInterv .modal-footer button");

	private By textoComentario = By.id("ENVIO_COM_COMENTARIOS");
	private By btnEnviarComentarios = By.cssSelector("#formularioEnvio > div.modal-footer > button:nth-child(2)");
	// endregion

	public InquilinosAvalistasPage_MAC(UserStory userS) {
		super(userS);
	}

	public InquilinosAvalistasPage_MAC executeActionsInInquilinosAvalistasPage() {
		debugBegin();

		addDatosInquilino();
		anadirDocumentacion();
		setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());
		debugInfo("NumCotizacion: " + getTestVar(Constants.NUM_COTIZACION));

		validacionViabilidadInquilino();

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC modificarRentasInquilino() {
		webDriver.clickInFrame(btnEditar, mainFrame);
		webDriver.appendTextInFrame(txtIngresos, mainFrame, getTestVar(Constants.INGRESOS_INQUILINO_NUEVOS));
		webDriver.clickInFrame(btnModificar, mainFrame);
		setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());

		return this;
	}

	public InquilinosAvalistasPage_MAC executeActionsInInquilinosAvalistasPageSinDocumentacion() {
		// TODO Eliminar metodo inutil
		return addDatosInquilino();
	}

	public InquilinosAvalistasPage_MAC addDatosInquilino() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.click(btnAnadirDatosInquilinoPantallaPrincipal);

		debugInfo("Nombre inquilino: " + getScenarioVar(Constants.NOMBRE_INQUILINO));
		webDriver.setText(txtNombre, getScenarioVar(Constants.NOMBRE_INQUILINO));

		debugInfo("Aprellido inquilino: " + getScenarioVar(Constants.PRIMER_APELLIDO_INQUILINO));
		webDriver.setText(txtPrimerApellido, getScenarioVar(Constants.PRIMER_APELLIDO_INQUILINO));


		debugInfo("Documento inquilino: " + getScenarioVar(Constants.DOCUMENTO_INQUILINO));
		webDriver.setText(txtDocumento, getScenarioVar(Constants.DOCUMENTO_INQUILINO));

		debugInfo("Ingresos inquilino: " + getScenarioVar(Constants.INGRESOS_INQUILINO));
		webDriver.setText(txtIngresos, getScenarioVar(Constants.INGRESOS_INQUILINO));

		// Situacion laboral
		seleccionarSituacion();

		if(webDriver.isClickable(drpDwnDetalle)) {
			debugInfo("entra condicion");
			webDriver.clickElementFromDropDownByIndex(drpDwnDetalle, mainFrame, 1);
		}

		webDriver.click(btnAnadirDatosInquilino);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC addDatosAval() {
		debugBegin();

		// TODO Eliminar prints y esperas milenarias
		System.out.println("PRUEBA 1");
		if(webDriver.isPresentInFrame(modalRaro, mainFrame)) {
			webDriver.setAttributeInFrame(modalRaro, mainFrame, "style", "display: none;");
			webDriver.setAttributeInFrame(modalRaro2, mainFrame, "hidden", "");
		}

		webDriver.isPresentAndClickInFrame(btnCerrarSpesiaru, mainFrame);

		System.out.println("PRUEBA 2");

		webDriver.waitWithDriver(99999);

		webDriver.clickInFrame(btnAnadirDatosInquilinoPantallaPrincipal, mainFrame);

		webDriver.waitWithDriver(10000);

		System.out.println("PRUEBA 3");
		// Seleccionar que sea aval

		webDriver.clickElementFromDropDownByText(tipoInterviniente, "Avalista");

		System.out.println("PRUEBA 4");

		debugInfo("Nombre inquilino: " + getScenarioVar(Constants.NOMBRE_AVALISTA));
		webDriver.setTextInFrame(txtNombre, mainFrame, userS.getTestVar(Constants.NOMBRE_AVALISTA));

		debugInfo("Aprellido inquilino: " + getScenarioVar(Constants.PRIMER_APELLIDO_AVALISTA));
		webDriver.setTextInFrame(txtPrimerApellido, mainFrame, userS.getTestVar(Constants.PRIMER_APELLIDO_AVALISTA));

		debugInfo("Documento inquilino: " + getScenarioVar(Constants.DOCUMENTO_AVALISTA));
		webDriver.setTextInFrame(txtDocumento, mainFrame, userS.getTestVar(Constants.DOCUMENTO_AVALISTA));

		debugInfo("Ingresos inquilino: " + getScenarioVar(Constants.INGRESOS_AVALISTA));
		webDriver.setTextInFrame(txtIngresos, mainFrame, userS.getTestVar(Constants.INGRESOS_AVALISTA));

		// Seleccionar parentesco
		seleccionarParentesco();

		// Situacion laboral
		seleccionarSituacion();

		webDriver.clickInFrame(btnAnadirDatosInquilino, mainFrame);

		userS.setTestVar(Constants.NUM_COTIZACION, recuperarNumeroCotizacion());

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC validacionViabilidadInquilino() {
		debugBegin();

		webDriver.waitForElementToBeClickable(btnValidacionViabilidad);
		webDriver.click(btnValidacionViabilidad);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC seleccionarSituacion() {
		debugBegin();
		//webDriver.switchToFrame(mainFrame);
		String situacion = getScenarioVar(Constants.SITUACION_LABORAL);

		if(situacion.equals(Constants.SITUACION_LABORAL_ASALARIADO)) {
			webDriver.clickElementFromDropDownByText(situacionLaboral, situacion);
			webDriver.clickElementFromDropDownByText(situacionDetalle, Constants.SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2);
		} else {
			webDriver.clickElementFromDropDownByText(situacionLaboral, situacion);
		}

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC seleccionarParentesco() {
		debugBegin();

		String parentescoText = getScenarioVar(Constants.PARENTESCO_AVALISTA);
		webDriver.clickElementFromDropDownByTextInFrame(parentesco, mainFrame, parentescoText);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC anadirDocumentacion() {
		debugBegin();

		webDriver.click(btnAnadirDocumentacionPrincipal);
		webDriver.click(btnAnadirDoc);

		// webDriver.clickInFrame(chkbxDosNominas, mainFrame);
		// webDriver.clickInFrame(chkbxAutorizacionConsulta, mainFrame);

		adjuntarDocumentos();

		// webDriver.clickInFrame(btnAnadirDocumentoSubido, mainFrame);

		webDriver.scrollToElement(btnEliminarDoc);
		debugInfo("Documento añadido");
		webDriver.moveToElement(btnCerrar);

		webDriver.click(btnCerrar);

		adjuntarDocumentos();

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC anadirDocumentacionAval() {
		debugBegin();

		webDriver.clickInFrame(btnAnadirDocumentacionPrincipal, mainFrame);
		webDriver.clickInFrame(chkbxDosNominasAval, mainFrame);
		webDriver.clickInFrame(chkbxAutorizacionConsultaAval, mainFrame);
		webDriver.clickInFrame(btnAnadirDocumentacion, mainFrame);

		adjuntarDocumentos();

		webDriver.clickInFrame(btnAnadirDocumentoSubido, mainFrame);
		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(btnCerrar, mainFrame);

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC adjuntarDocumentos() {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(5000);
		FileHelper.uploadFIle(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf");
		debugInfo("Fichero subido");

		debugEnd();

		return this;
	}

	public InquilinosAvalistasPage_MAC enviarACompania() {
		debugBegin();

		webDriver.click(btnEnviarACompania);
		//webDriver.clickInFrame(btnEnviarComentarios, mainFrame);
		
		// TODO: mover la ruta de fichero de upload a configuracion
		// webDriver.waitWithDriver(3000);
		// if(webDriver.isPresentInFrame(btnCerrar, mainFrame)) webDriver.clickInFrame(btnCerrar, mainFrame);
		//
		// webDriver.waitWithDriver(3000);
		// webDriver.clickInFrame(btnEnviarACompania, mainFrame);
		// webDriver.waitWithDriver(2000);
		// webDriver.appendTextInFrame(textoComentario, mainFrame, "IPSUM SUM LOREM LOREM, ESTO ES UNA PRUEBA DEL EQUIPO
		// TaaS");
		// webDriver.clickInFrame(btnEnviarComentarios, mainFrame);
		// webDriver.waitWithDriver(3000);
		// if(webDriver.isPresentInFrame(btnCerrar, mainFrame))
		// webDriver.clickInFrame(btnCerrar, mainFrame);

		webDriver.waitWithDriver(3000);
		//webDriver.isPresentInFrame(btnEnviarACompania, mainFrame);
		//webDriver.clickInFrame(btnEnviarACompania, mainFrame);
		//webDriver.waitWithDriver(2000);
		webDriver.isPresent(textoComentario);
		webDriver.appendText(textoComentario, "IPSUM SUM LOREM LOREM, ESTO ES UNA PRUEBA DEL EQUIPO TaaS");
		webDriver.click(btnEnviarComentarios);

		debugEnd();

		return this;
	}

	public String recuperarTextoMensajeError() {
		debugBegin();
		webDriver.getTextInFrame(msjError, mainFrame);
		debugEnd();

		return webDriver.getTextInFrame(msjError, mainFrame);
	}

	public String recuperarTextoMensajeValidacionOK() {
		debugBegin();
		String result = webDriver.getTextInFrame(msjError, mainFrame);
		debugInfo("Result: " + result);
		debugEnd();

		return result;
	}

	public InquilinosAvalistasPage_MAC clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, mainFrame);
		debugEnd();

		return this;
	}

	public String recuperarNumeroCotizacion() {
		debugBegin();
		webDriver.getText(numCotizacion);
		debugEnd();

		return webDriver.getText(numCotizacion);
	}

}
