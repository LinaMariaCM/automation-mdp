package com.amaris.project.pages;

import java.awt.AWTException;
import java.io.IOException;

import com.amaris.project.ProjectConstants;
import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class InquilinosAvalistasPage_MAC extends PageObject {

	// @FindBy(name = "main")
	// private WebElement mainFrame;
	private By mainFrame = By.cssSelector("#mainFrame");
	//
	// @FindBy(id = "altaInt")
	// private WebElement btnAnadirDatosInquilinoPantallaPrincipal;
	private By btnAnadirDatosInquilinoPantallaPrincipal = By.cssSelector("#altaInt");
	//
	// @FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir']")
	// private WebElement btnAnadirDatosInquilino;
	private By btnAnadirDatosInquilino = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");
	//
	// @FindBy(xpath = "//*[@id='INQUIAVAL_TIPOCONTRATLABAUT_CONF']")
	// private WebElement drpDwnDetalle;
	private By drpDwnDetalle = By.cssSelector("#INQUIAVAL_TIPOCONTRATLABAUT_CONF");
	//
	// @FindBy(id = "INQUIAVAL_DOCUMENTOFIS_CONF")
	// private WebElement txtDocumento;
	private By txtDocumento = By.cssSelector("#INQUIAVAL_DOCUMENTOFIS_CONF");
	//
	// @FindBy(id = "INQUIAVAL_TIPOINT_CONF")
	// private WebElement tipoInterviniente;
	private By tipoInterviniente = By.cssSelector("#INQUIAVAL_TIPOINT_CONF");

	// @FindBy(id = "INQUIAVAL_NOMBREFIS_CONF")
	// private WebElement txtNombre;
	private By txtNombre = By.cssSelector("#INQUIAVAL_NOMBREFIS_CONF");

	//
	// @FindBy(id = "INQUIAVAL_APELL1FIS_CONF")
	// private WebElement txtPrimerApellido;
	private By txtPrimerApellido = By.cssSelector("#INQUIAVAL_APELL1FIS_CONF");

	//
	// @FindBy(id = "INQUIAVAL_INGRENETANU_CONF")
	// private WebElement txtIngresos;
	private By txtIngresos = By.cssSelector("#INQUIAVAL_INGRENETANU_CONF");

	//
	// @FindBy(id = "INQUIAVAL_GRADOPARENT_CONF")
	// private WebElement parentesco;
	private By parentesco = By.cssSelector("#INQUIAVAL_GRADOPARENT_CONF");

	//
	// @FindBy(id = "INQUIAVAL_TIPOCONTRATOFIS_CONF")
	// private WebElement situacionLaboral;
	private By situacionLaboral = By.cssSelector("#INQUIAVAL_TIPOCONTRATOFIS_CONF");

	//
	// @FindBy(id = "INQUIAVAL_TIPOCONTRATOLAB_CONF")
	// private WebElement situacionDetalle;
	private By situacionDetalle = By.cssSelector("#INQUIAVAL_TIPOCONTRATOLAB_CONF");

	//
	// @FindBy(name = "nombdato_VALASNEF_1")
	// private WebElement btnValidacionViabilidad;
	private By btnValidacionViabilidad = By.id("INQUIAVAL_VALASNEF_CONF");

	//
	// @FindBy(id = "INQUIAVAL_GRABINTERV_CONF")
	// private WebElement btnModificar;
	private By btnModificar = By.cssSelector("#INQUIAVAL_GRABINTERV_CONF");

	// @FindBy(id = "botonAddDoc")
	// private WebElement btnAnadirDocumentacionPrincipal;
	private By btnAnadirDocumentacionPrincipal = By.cssSelector("#botonAddDoc");

	//
	// @FindBy(id = "addDocumento")
	// private WebElement btnAnadirDocumentoSubido;
	private By btnAnadirDocumentoSubido = By.cssSelector("#addDocumento");

	// @FindBy(xpath =
	// ".//*[@id='formDocumentos']/div[3]/div/div[1]/div/label/span/span")
	// private WebElement btnAnadirDocumentacion;
	private By btnAnadirDocumentacion = By.cssSelector("#formDocumentos");

	// @FindBy(id = "btnContinuar")
	// private WebElement btnContinuar;
	private By btnContinuar = By.cssSelector("#btnContinuar");

	// @FindBy(name = "doc_0")
	// private WebElement chkbxDosNominas;
	private By chkbxDosNominas = By.name("doc_0");

	// @FindBy(name = "doc_1")
	// private WebElement chkbxDosNominasAval;
	private By chkbxDosNominasAval = By.name("doc_1");

	// @FindBy(name = "doc_2")
	// private WebElement chkbxAutorizacionConsulta;
	private By chkbxAutorizacionConsulta = By.name("doc_2");

	// @FindBy(name = "doc_5")
	// private WebElement chkbxAutorizacionConsultaAval;
	private By chkbxAutorizacionConsultaAval = By.name("doc_5");

	// @FindBy(id = "fichero")
	// private WebElement elmntFichero;
	private By elmntFichero = By.cssSelector("#fichero");

	// @FindBy(id = "btnEnviar")
	// private WebElement btnEnviarACompania;
	private By btnEnviarACompania = By.id("btnEnviar");

	// @FindBy(css = "button[id*='modificarInt']")
	// private WebElement btnEditar;
	//
	// @FindBy(id = "VERIFIRESULT")
	// private WebElement msjError;

	private By msjError = By.id("VERIFIRESULT");

	// @FindBy(id = "numCot")
	// private WebElement numCotizacion;
	private By numCotizacion = By.cssSelector("#numCot");
	//

	// @FindBy(css = "#capaAdjuntarDocumentacion #modalAddDocuInterv
	// button[data-dismiss='modal']")
	// private WebElement btnCerrar;
	// private By btnCerrar = By.cssSelector("#capaAdjuntarDocumentacion
	// #modalAddDocuInterv button[data-dismiss='modal']");

	// private By btnCerrar = By.cssSelector("#modalAddDocuInterv > div > div >
	// div.modal-footer > button");

	private By btnCerrar = By.cssSelector("#capaAdjuntarDocumentacion #modalAddDocuInterv > div > div > div.modal-footer > button");

	//
	// @FindBy(xpath = ".//*[@id='formularioEnvio']/div[3]/button[2]")
	// private WebElement btnEnviarComentarios;
	// private By btnEnviarComentarios = By.cssSelector("#formularioEnvio >
	// div:nth-child(3) > button:nth-child(2)");

	private By btnEnviarComentarios = By.cssSelector("#formularioEnvio > div.modal-footer > button:nth-child(2)");

	// public InquilinosAvalistasPage_MAC(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	public InquilinosAvalistasPage_MAC(UserStory userS) {
		super(userS);
	}

	public void executeActionsInInquilinosAvalistasPage() throws InterruptedException, IOException, AWTException {
		debugBegin();

		this.addDatosInquilino();
		this.anadirDocumentacion();
		this.setTestVar("NumCotizacion", recuperarNumeroCotizacion());
		System.out.println("***NumCotizacion in executeActionsInInquilinosAvalistasPage: " + getTestVar("NumCotizacion"));
		// this.setTestVar(this.recuperarNumeroCotizacion());
		this.validacionViabilidadInquilino();

		debugEnd();
	}
	// public void executeActionsInInquilinosAvalistasPage() throws
	// InterruptedException, IOException, AWTException
	// {
	// this.addDatosInquilino();
	// this.anadirDocumentacion();
	// this.browserContext.getTestCaseData().setNoCotizacionMAC(this.recuperarNumeroCotizacion());
	// this.validacionViabilidadInquilino();
	// }
	//
	// public void modificarRentasInquilino() throws InterruptedException,
	// IOException, AWTException
	// {
	// this.webDriver.clickElementInFrame(this.btnEditar, this.mainFrame);
	// this.webDriver.sendValueToWebElementInFrame(this.txtIngresos,
	// this.mainFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getNuevosIngresosNetosInquilino()));
	// this.webDriver.clickElementInFrame(this.btnModificar, this.mainFrame);
	// this.browserContext.getTestCaseData().setNoCotizacionMAC(this.recuperarNumeroCotizacion());
	// }
	//
	// public void executeActionsInInquilinosAvalistasPageSinDocumentacion()
	// throws InterruptedException, IOException
	// {
	// this.addDatosInquilino();
	// }
	//

	public void addDatosInquilino() {
		debugBegin();

		this.webDriver.clickInFrame(this.btnAnadirDatosInquilinoPantallaPrincipal, this.mainFrame);

		// Add Nombre
		this.webDriver.setTextInFrame(this.txtNombre, this.mainFrame, String.valueOf(getScenarioVar("nombre_inquilino")));
		// Logger.debug("Nombre inquilino: " +
		// String.valueOf(getNombreInquilino());

		// Add Primer Apellido
		this.webDriver.setTextInFrame(this.txtPrimerApellido, this.mainFrame, String.valueOf(getScenarioVar("primer_apell_inquilino")));

		// Add NIF
		this.webDriver.setTextInFrame(this.txtDocumento, this.mainFrame, String.valueOf(getScenarioVar("documento_inquilino")));

		// Add Ingresos netos
		this.webDriver.setTextInFrame(this.txtIngresos, this.mainFrame, String.valueOf(getScenarioVar("ingresos_inquilino")));

		// Situacion laboral
		this.seleccionarSituacion();

		// This has been commented so that if the test fails, we know that the
		// Detalle field has been enabled for a Situación Laboral that
		// previously didn't have it.
		// if(this.webDriver.isPresentInFrame(this.drpDwnDetalle,
		// this.mainFrame)) {
		// this.webDriver.clickElementFromDropDownByIndex(this.drpDwnDetalle,
		// this.mainFrame, 1);
		// }
		this.webDriver.clickInFrame(this.btnAnadirDatosInquilino, this.mainFrame);

		debugEnd();
	}

	// public void addDatosInquilino()
	// {
	// logger.debug("BEGIN - AddDatosInquilino");
	//
	// this.webDriver.clickElementInFrame(this.btnAnadirDatosInquilinoPantallaPrincipal,
	// this.mainFrame);
	//
	// // Add Nombre
	// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtNombre,
	// this.mainFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getNombreInquilino()));
	// // Logger.debug("Nombre inquilino: " +
	// String.valueOf(getNombreInquilino());
	//
	// // Add Primer Apellido
	// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtPrimerApellido,
	// this.mainFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getPrimerApellidoInquilino()));
	//
	// // Add NIF
	// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtDocumento,
	// this.mainFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getDocumentoInquilino()));
	//
	// // Add Ingresos netos
	// // this.webDriver.sendValueToWebElementInFrame(this.txtIngresos,
	// this.mainFrame,
	// //
	// String.valueOf(this.browserContext.getTestCaseData().getIngresosNetosInquilino()));
	//
	// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtIngresos,
	// this.mainFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getIngresosNetosInquilino()));
	//
	// // Situacion laboral
	// this.seleccionarSituacion();
	//
	// if (this.webDriver.webElementInFrameIsPresent(this.drpDwnDetalle,
	// this.mainFrame))
	// {
	// this.webDriver.selectValueInDropDownInFrameByIndex(this.drpDwnDetalle,
	// this.mainFrame, 1);
	// }
	//
	// this.webDriver.clickElementInFrame(this.btnAnadirDatosInquilino,
	// this.mainFrame);
	//
	// logger.debug("END - AddDatosInquilino");
	// }
	//

	public void addDatosAval() {
		this.debugBegin();

		this.webDriver.clickInFrame(this.btnAnadirDatosInquilinoPantallaPrincipal, this.mainFrame);

		// Seleccionar que sea aval
		this.webDriver.clickElementFromDropDownByText(this.tipoInterviniente, "Avalista");

		// Add Nombre
		this.webDriver.setTextInFrame(this.txtNombre, this.mainFrame, String.valueOf(this.userS.getTestVar("nombre_aval")));

		// Add Primer Apellido
		this.webDriver.setTextInFrame(this.txtPrimerApellido, this.mainFrame, String.valueOf(this.userS.getTestVar("primer_apell_inqulino")));

		// Add NIF
		this.webDriver.setTextInFrame(this.txtDocumento, this.mainFrame, String.valueOf(this.userS.getTestVar("documento_aval")));

		// Add Ingresos Aval
		this.webDriver.setTextInFrame(this.txtIngresos, this.mainFrame, String.valueOf(this.userS.getTestVar("ingresos_aval")));

		// Seleccionar parentesco
		this.seleccionarParentesco();

		// Situacion laboral
		this.seleccionarSituacion();

		this.webDriver.clickInFrame(this.btnAnadirDatosInquilino, this.mainFrame);

		this.userS.setTestVar("num_cotizacion", this.recuperarNumeroCotizacion());

		this.debugEnd();
	}

	public void validacionViabilidadInquilino() throws AWTException, InterruptedException {
		debugBegin();

		this.webDriver.waitWithDriver(4000);
		// this.webDriver.waitForElementToBeClickableInFrame(btnValidacionViabilidad,
		// this.mainFrame);
		// this.webDriver.clickInFrame(this.btnValidacionViabilidad,
		// this.mainFrame);
		this.webDriver.clickInFrame(this.btnValidacionViabilidad, this.mainFrame);
		// this.webDriver.waitWithDriver(4000);

		debugEnd();
	}

	// public void validacionViabilidadInquilino()
	// {
	// logger.debug("BEGIN - ValidacionViabilidadInquilino");
	// this.webDriver.clickElementInFrame(this.btnValidacionViabilidad,
	// this.mainFrame);
	// logger.debug("END - ValidacionViabilidadInquilino");
	// }

	public void seleccionarSituacion() {
		debugBegin();

		String situacion = getScenarioVar("situacion_laboral");
		if(situacion.equals(ProjectConstants.SITUACION_LABORAL_ASALARIADO)) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.situacionLaboral, this.mainFrame, situacion);
			this.webDriver.clickElementFromDropDownByTextInFrame(this.situacionDetalle, this.mainFrame, ProjectConstants.SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2);
		} else {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.situacionLaboral, this.mainFrame, situacion);
		}

		debugEnd();
	}

	// public void seleccionarSituacion()
	// {
	// logger.debug("BEGIN - SeleccionarSituacion");
	// String situacion =
	// this.browserContext.getTestCaseData().getSituacionLaboralInquilino();
	// if (situacion.equals(ProjectConstants.SITUACION_LABORAL_ASALARIADO))
	// {
	// this.webDriver.selectValueInDropDownInFrame(this.situacionLaboral,
	// this.mainFrame, situacion);
	// this.webDriver.selectValueInDropDownInFrame(this.situacionDetalle,
	// this.mainFrame,
	// ProjectConstants.SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2);
	// }
	// this.webDriver.selectValueInDropDownInFrame(this.situacionLaboral,
	// this.mainFrame, situacion);
	// logger.debug("END - SeleccionarSituacion");
	// }
	//
	public void seleccionarParentesco() {
		debugBegin();

		String parentesco = getScenarioVar("parentesco_aval");
		this.webDriver.clickElementFromDropDownByTextInFrame(this.parentesco, this.mainFrame, parentesco);

		debugEnd();
	}
	// public void seleccionarParentesco()
	// {
	// logger.debug("BEGIN - SeleccionarParentesco");
	// String parentesco =
	// this.browserContext.getTestCaseData().getParentescoAval();
	// this.webDriver.selectValueInDropDownInFrame(this.parentesco,
	// this.mainFrame,
	// parentesco);
	// logger.debug("END - SeleccionarParentesco");
	// }

	public void anadirDocumentacion() throws AWTException, InterruptedException {
		debugBegin();
		this.webDriver.clickInFrame(this.btnAnadirDocumentacionPrincipal, this.mainFrame);
		this.webDriver.clickInFrame(this.chkbxDosNominas, this.mainFrame);
		this.webDriver.clickInFrame(this.chkbxAutorizacionConsulta, this.mainFrame);
		this.adjuntarDocumentos();
		this.webDriver.waitWithDriver(6000);
		this.webDriver.clickInFrame(this.btnAnadirDocumentoSubido, this.mainFrame);

		this.webDriver.waitWithDriver(6000);
		this.webDriver.moveToElementInFrame(this.btnCerrar, this.mainFrame);

		// this.webDriver.waitWithDriver(3000);

		this.webDriver.clickInFrame(this.btnCerrar, this.mainFrame);
		this.webDriver.waitWithDriver(10000);
		if(webDriver.isPresentInFrame(this.btnCerrar, this.mainFrame)) this.webDriver.clickInFrame(this.btnCerrar, this.mainFrame);
		debugEnd();
	}

	// public void anadirDocumentacion() throws AWTException,
	// InterruptedException
	// {
	// logger.debug("BEGIN - AnadirDocumentacion");
	// this.webDriver.clickElementInFrame(this.btnAnadirDocumentacionPrincipal,
	// this.mainFrame);
	// this.webDriver.clickElementInFrame(this.chkbxDosNominas, this.mainFrame);
	// this.webDriver.clickElementInFrame(this.chkbxAutorizacionConsulta,
	// this.mainFrame);
	// this.adjuntarDocumentos();
	// this.webDriver.clickElementInFrame(this.btnAnadirDocumentoSubido,
	// this.mainFrame);
	// Thread.sleep(2000);
	// this.webDriver.clickElementInFrame(this.btnCerrar, this.mainFrame);
	// logger.debug("END - AnadirDocumentacion");
	// }

	public void anadirDocumentacionAval() throws AWTException, InterruptedException {
		this.debugBegin();
		this.webDriver.clickInFrame(this.btnAnadirDocumentacionPrincipal, this.mainFrame);
		this.webDriver.clickInFrame(this.chkbxDosNominasAval, this.mainFrame);
		this.webDriver.clickInFrame(this.chkbxAutorizacionConsultaAval, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnadirDocumentacion, this.mainFrame);
		this.adjuntarDocumentos();
		this.webDriver.clickInFrame(this.btnAnadirDocumentoSubido, this.mainFrame);
		Thread.sleep(2000);
		this.webDriver.clickInFrame(this.btnCerrar, this.mainFrame);
		this.debugEnd();
	}

	public void adjuntarDocumentos() throws AWTException {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(10000);
		this.webDriver.appendTextInFrame(this.elmntFichero, this.mainFrame, System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf");
		// this.webDriver.sendKeysFrame(this.elmntFichero, this.mainFrame,
		// "C:/Users/chris/Desktop/New Text Document.txt");
		debugEnd();
	}

	// public void adjuntarDocumentos() throws AWTException
	// {
	// logger.debug("BEGIN - AdjuntarDocumentos");
	// // TODO: mover la ruta de fichero de upload a configuracion
	// this.webDriver.switchToFrame(this.mainFrame);
	// this.elmntFichero.sendKeys("C:/Users/amaris2/Desktop/prueba.pdf");
	// this.webDriver.exitFromFrame();
	// logger.debug("END - AdjuntarDocumentos");
	// }
	//

	public void enviarACompania() {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion

		// this.webDriver.waitWithDriver(6000);
		// if(this.webDriver.isPresentInFrame(this.btnCerrar, this.mainFrame))

		webDriver.waitWithDriver(2000);

		this.webDriver.clickInFrame(this.btnEnviarACompania, this.mainFrame);
		this.webDriver.waitWithDriver(6000);
		this.webDriver.clickInFrame(this.btnEnviarComentarios, this.mainFrame);
		this.webDriver.waitWithDriver(3000);
		debugEnd();
	}

	// public void enviarACompania()
	// {
	// logger.debug("BEGIN - EnviarACompania");
	// // TODO: mover la ruta de fichero de upload a configuracion
	// this.webDriver.clickElementInFrame(this.btnEnviarACompania,
	// this.mainFrame);
	// this.webDriver.clickElementInFrame(this.btnEnviarComentarios,
	// this.mainFrame);
	// logger.debug("END - EnviarACompania");
	// }
	//
	public String recuperarTextoMensajeError() {
		debugBegin();
		this.webDriver.getTextInFrame(this.msjError, this.mainFrame);
		debugEnd();
		return this.webDriver.getTextInFrame(this.msjError, this.mainFrame);
	}

	public String recuperarTextoMensajeValidacionOK() {

		debugBegin();
		String result = this.webDriver.getTextInFrame(this.msjError, this.mainFrame);
		System.out.println(result);
		debugEnd();
		return result;
	}

	public void clickContinuar() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnContinuar, this.mainFrame);
		debugEnd();
	}

	public String recuperarNumeroCotizacion() {
		debugBegin();
		this.webDriver.getTextInFrame(this.numCotizacion, this.mainFrame);
		debugEnd();
		return this.webDriver.getTextInFrame(this.numCotizacion, this.mainFrame);
	}

}
