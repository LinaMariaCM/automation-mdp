package com.project.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InquilinosAvalistasPage_MAC
{
//	final static Logger logger = LoggerFactory.getLogger(InquilinosAvalistasPage_MAC.class);
//	BrowserContext browserContext;
//	private WebElementHelper wh;
//	TestCaseData tData;
//
//	@FindBy(name = "cuerpo")
//	private WebElement cuerpoFrame;
//
//	@FindBy(id = "altaInt")
//	private WebElement btnAnadirDatosInquilinoPantallaPrincipal;
//
//	@FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir']")
//	private WebElement btnAnadirDatosInquilino;
//
//	@FindBy(xpath = "//*[@id='INQUIAVAL_TIPOCONTRATLABAUT_CONF']")
//	private WebElement drpDwnDetalle;
//
//	@FindBy(id = "INQUIAVAL_DOCUMENTOFIS_CONF")
//	private WebElement txtDocumento;
//
//	@FindBy(id = "INQUIAVAL_TIPOINT_CONF")
//	private WebElement tipoInterviniente;
//
//	@FindBy(id = "INQUIAVAL_NOMBREFIS_CONF")
//	private WebElement txtNombre;
//
//	@FindBy(id = "INQUIAVAL_APELL1FIS_CONF")
//	private WebElement txtPrimerApellido;
//
//	@FindBy(id = "INQUIAVAL_INGRENETANU_CONF")
//	private WebElement txtIngresos;
//
//	@FindBy(id = "INQUIAVAL_GRADOPARENT_CONF")
//	private WebElement parentesco;
//
//	@FindBy(id = "INQUIAVAL_TIPOCONTRATOFIS_CONF")
//	private WebElement situacionLaboral;
//
//	@FindBy(id = "INQUIAVAL_TIPOCONTRATOLAB_CONF")
//	private WebElement situacionDetalle;
//
//	@FindBy(name = "nombdato_VALASNEF_1")
//	private WebElement btnValidacionViabilidad;
//	
//	@FindBy(id = "INQUIAVAL_GRABINTERV_CONF")
//	private WebElement btnModificar;
//
//	@FindBy(id = "botonAddDoc")
//	private WebElement btnAnadirDocumentacionPrincipal;
//	
//	@FindBy(id = "addDocumento")
//	private WebElement btnAnadirDocumentoSubido;
//	
//	@FindBy(xpath = ".//*[@id='formDocumentos']/div[3]/div/div[1]/div/label/span/span")
//	private WebElement btnAnadirDocumentacion;
//
//	@FindBy(id = "btnContinuar")
//	private WebElement btnContinuar;
//	
//	@FindBy(name = "doc_0")
//	private WebElement chkbxDosNominas;
//
//	@FindBy(name = "doc_1")
//	private WebElement chkbxDosNominasAval;
//	
//	@FindBy(name = "doc_2")
//	private WebElement chkbxAutorizacionConsulta;
//
//	@FindBy(name = "doc_5")
//	private WebElement chkbxAutorizacionConsultaAval;
//	
//	@FindBy(id = "fichero")
//	private WebElement elmntFichero;
//	
//	@FindBy(id = "btnEnviar")
//	private WebElement btnEnviarACompania;
//	
//	@FindBy(css = "button[id*='modificarInt']")
//	private WebElement btnEditar;
//
//	@FindBy(id = "VERIFIRESULT")
//	private WebElement msjError;
//	
//	@FindBy(id = "numCot")
//	private WebElement numCotizacion;
//	
//	@FindBy(css = "#capaAdjuntarDocumentacion #modalAddDocuInterv button[data-dismiss='modal']")
//	private WebElement btnCerrar;
//	
//	@FindBy(xpath = ".//*[@id='formularioEnvio']/div[3]/button[2]")
//	private WebElement btnEnviarComentarios;
//
//	public InquilinosAvalistasPage_MAC(BrowserContext browserContext)
//	{
//		this.browserContext = browserContext;
//		this.wh = browserContext.webElementHelper;
//		PageFactory.initElements(browserContext.getWebDriver(), this);
//	}
//
//	public void executeActionsInInquilinosAvalistasPage() throws InterruptedException, IOException, AWTException
//	{
//		this.addDatosInquilino();
//		this.anadirDocumentacion();
//		this.browserContext.getTestCaseData().setNoCotizacionMAC(this.recuperarNumeroCotizacion());
//		this.validacionViabilidadInquilino();
//	}
//
//	public void modificarRentasInquilino() throws InterruptedException, IOException, AWTException
//	{
//		this.wh.clickOnWebElementInFrame(this.btnEditar, this.cuerpoFrame);
//		this.wh.sendValueToWebElementInFrame(this.txtIngresos, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getNuevosIngresosNetosInquilino()));
//		this.wh.clickOnWebElementInFrame(this.btnModificar, this.cuerpoFrame);
//		this.browserContext.getTestCaseData().setNoCotizacionMAC(this.recuperarNumeroCotizacion());
//	}
//
//	public void executeActionsInInquilinosAvalistasPageSinDocumentacion() throws InterruptedException, IOException
//	{
//		this.addDatosInquilino();
//	}
//
//	public void addDatosInquilino()
//	{
//		logger.debug("BEGIN - AddDatosInquilino");
//
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosInquilinoPantallaPrincipal, this.cuerpoFrame);
//
//		// Add Nombre
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtNombre, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getNombreInquilino()));
//		// Logger.debug("Nombre inquilino: " + String.valueOf(getNombreInquilino());
//
//		// Add Primer Apellido
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtPrimerApellido, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getPrimerApellidoInquilino()));
//
//		// Add NIF
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtDocumento, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getDocumentoInquilino()));
//
//		// Add Ingresos netos
//		// this.wh.sendValueToWebElementInFrame(this.txtIngresos, this.cuerpoFrame,
//		// String.valueOf(this.browserContext.getTestCaseData().getIngresosNetosInquilino()));
//		
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtIngresos, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getIngresosNetosInquilino()));
//
//		// Situacion laboral
//		this.seleccionarSituacion();
//
//		if (this.wh.webElementInFrameIsPresent(this.drpDwnDetalle, this.cuerpoFrame))
//		{
//			this.wh.selectValueInDropDownInFrameByIndex(this.drpDwnDetalle, this.cuerpoFrame, 1);
//		}
//
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosInquilino, this.cuerpoFrame);
//
//		logger.debug("END - AddDatosInquilino");
//	}
//
//	public void addDatosAval()
//	{
//		logger.debug("BEGIN - AddDatosAval");
//
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosInquilinoPantallaPrincipal, this.cuerpoFrame);
//
//		// Seleccionar que sea aval
//		this.wh.selectValueInDropDownInFrame(this.tipoInterviniente, this.cuerpoFrame, "Avalista");
//
//		// Add Nombre
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtNombre, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getNombreAval()));
//
//		// Add Primer Apellido
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtPrimerApellido, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getPrimerApellidoAval()));
//
//		// Add NIF
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtDocumento, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getDocumentoAval()));
//
//		// Add Ingresos Aval
//		this.wh.sendValueToWebElementInFrame(this.txtIngresos, this.cuerpoFrame, String.valueOf(this.browserContext.getTestCaseData().getIngresosAval()));
//
//		// Seleccionar parentesco
//		this.seleccionarParentesco();
//		
//		// Situacion laboral
//		this.seleccionarSituacion();
//
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosInquilino, this.cuerpoFrame);
//
//		this.browserContext.getTestCaseData().setNoCotizacionMAC(this.recuperarNumeroCotizacion());
//
//		logger.debug("END - AddDatosAval");
//	}
//
//	public void validacionViabilidadInquilino()
//	{
//		logger.debug("BEGIN - ValidacionViabilidadInquilino");
//		this.wh.clickOnWebElementInFrame(this.btnValidacionViabilidad, this.cuerpoFrame);
//		logger.debug("END - ValidacionViabilidadInquilino");
//	}
//
//	public void seleccionarSituacion()
//	{
//		logger.debug("BEGIN - SeleccionarSituacion");
//		String situacion = this.browserContext.getTestCaseData().getSituacionLaboralInquilino();
//		if (situacion.equals(ProjectConstants.SITUACION_LABORAL_ASALARIADO))
//		{
//			this.wh.selectValueInDropDownInFrame(this.situacionLaboral, this.cuerpoFrame, situacion);
//			this.wh.selectValueInDropDownInFrame(this.situacionDetalle, this.cuerpoFrame,
//					ProjectConstants.SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2);
//		}
//		this.wh.selectValueInDropDownInFrame(this.situacionLaboral, this.cuerpoFrame, situacion);
//		logger.debug("END - SeleccionarSituacion");
//	}
//	
//	public void seleccionarParentesco()
//	{
//		logger.debug("BEGIN - SeleccionarParentesco");
//		String parentesco = this.browserContext.getTestCaseData().getParentescoAval();
//		this.wh.selectValueInDropDownInFrame(this.parentesco, this.cuerpoFrame, parentesco);
//		logger.debug("END - SeleccionarParentesco");
//	}
//
//	public void anadirDocumentacion() throws AWTException, InterruptedException
//	{
//		logger.debug("BEGIN - AnadirDocumentacion");
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentacionPrincipal, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.chkbxDosNominas, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.chkbxAutorizacionConsulta, this.cuerpoFrame);
//		this.adjuntarDocumentos();
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentoSubido, this.cuerpoFrame);
//		Thread.sleep(2000);
//		this.wh.clickOnWebElementInFrame(this.btnCerrar, this.cuerpoFrame);
//		logger.debug("END - AnadirDocumentacion");
//	}
//
//	public void anadirDocumentacionAval() throws AWTException, InterruptedException
//	{
//		logger.debug("BEGIN - AnadirDocumentacionAval");
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentacionPrincipal, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.chkbxDosNominasAval, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.chkbxAutorizacionConsultaAval, this.cuerpoFrame);
//		// this.wh.ClickOnWebElementInFrame(this.btnAnadirDocumentacion, this.cuerpoFrame);
//		this.adjuntarDocumentos();
//		this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentoSubido, this.cuerpoFrame);
//		Thread.sleep(2000);
//		this.wh.clickOnWebElementInFrame(this.btnCerrar, this.cuerpoFrame);
//		logger.debug("END - AnadirDocumentacionAval");
//	}
//
//	public void adjuntarDocumentos() throws AWTException
//	{
//		logger.debug("BEGIN - AdjuntarDocumentos");
//		// TODO: mover la ruta de fichero de upload a configuracion
//		this.wh.switchToFrame(this.cuerpoFrame);
//		this.elmntFichero.sendKeys("C:/Users/amaris2/Desktop/prueba.pdf");
//		this.wh.exitFromFrame();
//		logger.debug("END - AdjuntarDocumentos");
//	}
//	
//	public void enviarACompania()
//	{
//		logger.debug("BEGIN - EnviarACompania");
//		// TODO: mover la ruta de fichero de upload a configuracion
//		this.wh.clickOnWebElementInFrame(this.btnEnviarACompania, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.btnEnviarComentarios, this.cuerpoFrame);
//		logger.debug("END - EnviarACompania");
//	}
//
//	public String recuperarTextoMensajeError()
//	{
//		logger.debug("BEGIN - RecuperarTextoMensajeError");
//		this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame);
//		logger.debug("END - RecuperarTextoMensajeError");
//		return this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame);
//	}
//
//	public String recuperarTextoMensajeValidacionOK()
//	{
//		
//		logger.debug("BEGIN - RecuperarTextoMensajeValidacionOK");
//		String result = this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame);
//		System.out.println(result);
//		logger.debug("END - RecuperarTextoMensajeValidacionOK");
//		return result;
//	}
//	
//	public void clickOnContinuar()
//	{
//		logger.debug("BEGIN - Continuar");
//		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
//		logger.debug("END - Continuar");
//	}
//
//	public String recuperarNumeroCotizacion()
//	{
//		logger.debug("BEGIN - RecuperarNumeroCotizacion");
//		this.wh.getTextFromWebElementInFrame(this.numCotizacion, this.cuerpoFrame);
//		logger.debug("END - RecuperarNumeroCotizacion");
//		return this.wh.getTextFromWebElementInFrame(this.numCotizacion, this.cuerpoFrame);
//	}
}
