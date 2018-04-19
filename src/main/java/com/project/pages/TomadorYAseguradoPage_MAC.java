package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class TomadorYAseguradoPage_MAC
{
	final static Logger logger = LoggerFactory.getLogger(TomadorYAseguradoPage_MAC.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;
	
	// DATOS TOMADOR
	@FindBy(xpath = ".//*[text()='Tomador']")
	private WebElement btnTomador;
	
	@FindBy(xpath = "//*[@id='TOMADOR_TIPOTOMASEG_CONF']")
	private WebElement drpDwnAlta;
	
	@FindBy(xpath = "//*[@id='TOMADOR_TIPOPERSONA_CONF']")
	private WebElement drpDwnTipoPersona;
	
	@FindBy(xpath = "//*[@id='TOMADOR_TIPODOCFIS_CONF']")
	private WebElement drpDwnDocumento;
	
	@FindBy(xpath = "//*[@id='TOMADOR_MEDIOPAGO_CONF']")
	private WebElement drpDwnMedioPago;
	
	@FindBy(xpath = ".//*[text()='Asegurado']")
	private WebElement btnAsegurado;
	
	@FindBy(xpath = ".//*[text()='Fisica']")
	private WebElement btnFisica;

	@FindBy(xpath = ".//*[text()='NIF']")
	private WebElement btnNIF;

	@FindBy(xpath = ".//*[text()='Mediador']")
	private WebElement btnMedioPagoMediador;
	
	@FindBy(xpath = ".//*[text()='Documento']")
	private WebElement txtDocumento;

	@FindBy(xpath = "//*[@id='botonGrabar']")
	private WebElement btnAnadirDatosTomador;
	
	// @FindBy(xpath = ".//*[text()='Añadir']")TOMADOR_TIPOTOMASEG_CONF
	@FindBy(css = "button[onclick='aniadirTomadorAsegurado(); return false;']")
	private WebElement btnAnadirDatosTomadorPantallaPrincipal;
	
	@FindBy(xpath = "//*[@id='botonInmuebleVisual']")
	private WebElement btnAnadirDireccion;
	
	@FindBy(xpath = "//*[@id='TOMADOR_DOCUMENTOFIS_CONF']")
	private WebElement txtTomadorDNI;
	
	@FindBy(xpath = "//*[@id='TOMADOR_NOMBREFIS_CONF']")
	private WebElement txtTomadorNombre;
	
	@FindBy(xpath = "//*[@id='TOMADOR_APELL1FIS_CONF']")
	private WebElement txtTomadorPrimerApellido;
	
	@FindBy(xpath = "//*[@id='TOMADOR_APELL2FIS_CONF']")
	private WebElement txtTomadorSegundoApellido;

	@FindBy(xpath = "//*[@id='botoncapaUbicacionIntervinientes']")
	private WebElement btnRellenarDireccion;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_PROVINCIA_ARVATO_TOM']")
	private WebElement txtProvincia;
	
	@FindBy(xpath = "/html/body/ul[2]/li/a")
	private WebElement itemProvincia;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_POBLACION_ARVATO_TOM']")
	private WebElement txtPoblacion;
	
	@FindBy(xpath = "/html/body/ul[3]/li/a")
	private WebElement itemPoblacion;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_NOMVIA_ARVATO_TOM']")
	private WebElement txtNomVia;

	@FindBy(xpath = "/html/body/ul[4]/li/a")
	private WebElement itemNomVia;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_NUMVIA_TOM']")
	private WebElement txtNumVia;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_TIPOVIA_ARVATO_TOM']")
	private WebElement drpDwnTipoVia;
	
	@FindBy(xpath = "//*[@id='ALTACLIE_BS_CODPOST_ARVATO_TOM']")
	private WebElement txtCodigoPostal;
	
	@FindBy(xpath = "//*[@id='fechaNacimiento']")
	private WebElement txtFechaNacimiento;
	
	@FindBy(xpath = "//*[@id='bloque2Tomador']")
	private WebElement txtIBAN;
	
	public TomadorYAseguradoPage_MAC(BrowserContext browserContext)
	{
		this.wh = browserContext.webElementHelper;
		this.browserContext = browserContext;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	public void executeActionsInTomadorYAseguradoPage() throws InterruptedException, IOException
	{
		// Add datos tomador
		this.AddDatosTomador();
	}

	public void AddDatosTomador()
	{
		logger.debug("BEGIN - AddDatosTomador");
		
		if (this.tData.getTomador().equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal))
		{
			
			// this.wh.MoveToElementInFrameWithJavaScript(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
			// this.wh.SwitchToFrame(this.cuerpoFrame);
			// this.wh.ClickOnWebElement(this.btnAnadirDatosTomadorPantallaPrincipal);
			
			// Select Tomador
			this.SeleccionarTomador("Tomador");
			// Select persona fisica
			this.SeleccionarTipoPersona("Física");
			// Select documento tomador DNI
			this.SeleccionarTipoDocumento("NIF");
			
			// Select documento tomador
			this.wh.sendValueToWebElementInFrame(this.txtTomadorDNI, this.cuerpoFrame, String.valueOf(this.tData.getTomadorDNI()));
			// Select nombre tomador
			this.wh.sendValueToWebElementInFrame(this.txtTomadorNombre, this.cuerpoFrame, String.valueOf(this.tData.getTomadorNombre()));
			// Select primer apellido
			this.wh.sendValueToWebElementInFrame(this.txtTomadorPrimerApellido, this.cuerpoFrame, String.valueOf(this.tData.getTomadorPrimerApellido()));
			// Select segundo apellido
			this.wh.sendValueToWebElementInFrame(this.txtTomadorSegundoApellido, this.cuerpoFrame, String.valueOf(this.tData.getTomadorSegundoApellido()));
			
			// Domicilio
			this.wh.clickOnWebElementInFrame(this.btnRellenarDireccion, this.cuerpoFrame);
			
			// Provincia
			this.wh.sendValueToWebElementInFrame(this.txtProvincia, this.cuerpoFrame, String.valueOf(this.tData.getTomadorProvincia()));
			this.wh.clickOnWebElementInFrame(this.itemProvincia, this.cuerpoFrame);
			// Poblacion
			this.wh.sendValueToWebElementInFrame(this.txtPoblacion, this.cuerpoFrame, String.valueOf(this.tData.getTomadorPoblacion()));
			this.wh.clickOnWebElementInFrame(this.itemPoblacion, this.cuerpoFrame);
			// Nombre via
			this.wh.sendValueToWebElementInFrame(this.txtNomVia, this.cuerpoFrame, String.valueOf(this.tData.getTomadorDireccion()));
			this.wh.clickOnWebElementInFrame(this.itemNomVia, this.cuerpoFrame);
			// Num via
			this.wh.sendValueToWebElementInFrame(this.txtNumVia, this.cuerpoFrame, String.valueOf(this.tData.getTomadorNumeroPortal()));
			
			// Click añadir direccion
			this.wh.clickOnWebElementInFrame(this.btnAnadirDireccion, this.cuerpoFrame);
			
			// Fecha nacimiento
			this.wh.sendValueToWebElementInFrame(this.txtFechaNacimiento, this.cuerpoFrame, String.valueOf(this.tData.getTomadorFechaNacimiento()));

			// Medio pago
			this.SeleccionarMedioPago();

			this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
		}
		
		logger.debug("END - AddDatosTomador");
	}

	public void SeleccionarTomador()
	{
		this.SeleccionarTomador(this.browserContext.getTestCaseData().getTomador());
	}

	public void SeleccionarTomador(
			String tomador)
	{
		logger.debug("BEGIN - SeleccionarTomador");
		this.wh.selectValueInDropDownInFrame(this.drpDwnAlta, this.cuerpoFrame, tomador);

		/*
		 * switch (tomador) { case MutuaPropietariosConstants.ALTA_TOMADOR: this.wh.SelectValueInDropDownInFrame(this.btnElegirAlta, this.cuerpoFrame,
		 * tomador); break; case MutuaPropietariosConstants.ALTA_ASEGURADO: this.wh.SelectValueInDropDownInFrame(this.btnElegirAlta, this.cuerpoFrame,
		 * tomador); break; }
		 */

		logger.debug("END - SeleccionarTomador");
	}
	
	public void SeleccionarTipoDocumento(
			String tipo)
	{
		logger.debug("BEGIN - SeleccionarTipoDocumento");
		
		this.wh.selectValueInDropDownInFrame(this.drpDwnDocumento, this.cuerpoFrame, tipo);

		logger.debug("END - SeleccionarTipoDocumento");
	}

	public void SeleccionarTipoPersona(
			String tipo)
	{
		logger.debug("BEGIN - SeleccionarTipoPersona");

		this.wh.selectValueInDropDownInFrame(this.drpDwnTipoPersona, this.cuerpoFrame, tipo);
		/*
		 * this.wh.SwitchToFrame(this.cuerpoFrame); this.wh.MoveToElementWithJavaScript(this.btnFisica);
		 */

		logger.debug("END - SeleccionarTipoPersona");
	}
	
	public void SeleccionarMedioPago()
	{
		logger.debug("BEGIN - SeleccionarMedioPago");
		
		if (this.tData.getMedioPago().equals("mediador"))
		{
			this.wh.selectValueInDropDownInFrame(this.drpDwnMedioPago, this.cuerpoFrame, "Mediador");
		}
		
		if (this.tData.getMedioPago().equals("domiciliacion_bancaria"))
		{
			this.wh.selectValueInDropDownInFrame(this.drpDwnMedioPago, this.cuerpoFrame, "Domiciliación bancaria");
			this.wh.sendValueToWebElementInFrame(this.txtIBAN, this.cuerpoFrame, String.valueOf(this.tData.getNumeroCuenta().substring(2)));
		}
		
		logger.debug("END - SeleccionarMedioPago");
	}
}
