package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class DatosBasicosTomadorPage
{
	final static Logger logger = LoggerFactory.getLogger(DatosBasicosTomadorPage.class);
	BrowserContext browserContext;
	protected NgWebDriver ngWebDriver;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	@FindBy(id = "tipoDocumento")
	private WebElement cmbTipoDocumento;

	@FindBy(id = "numeroDocumento")
	private WebElement txtNumeroDocumento;

	@FindBy(xpath = ".//*[text()='Validar cliente']")
	private WebElement btnValidarCliente;

	@FindBy(xpath = ".//*[@name='nombreTomador']")
	private WebElement txtNombreTomador;

	@FindBy(xpath = ".//*[@name='apellido1Tomador']")
	private WebElement txtPrimerApellidoTomador;

	@FindBy(xpath = ".//*[@name='apellido2Tomador']")
	private WebElement txtSegundoApellidoTomador;

	@FindBy(xpath = ".//*[text()='Continuar']")
	private WebElement btnContinuar;

	@FindBy(xpath = ".//*[text()='Aceptar']")
	private WebElement btnAceptar;

	@FindBy(xpath = ".//*[@ng-model='tomador.cifTramite']")
	private WebElement chkCIFEnTramite;

	@FindBy(name = "razonSocial")
	private WebElement txtRazonSocial;

	@FindBy(name = "duplicadoSelect")
	private WebElement rdnClienteExistente;

	@FindBy(xpath = ".//*[text()='Seleccionar cliente']")
	private WebElement btnSeleccionarCliente;

	// endregion

	public DatosBasicosTomadorPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	public void ExecuteActionsInPageTomadorYAseguradoPage(
			String tomadorType) throws Exception
	{
		this.FillTomadorData(tomadorType);
		this.clickOnContinuar();
	}

	// region methods
	public void clickOnContinuar()
	{
		logger.debug("BEGIN - ClickOnContinuar");
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}
	
	public void fillStaticTomadorData()
	{
		this.wh.selectValueInDropDownInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
		this.browserContext.getTestCaseData().setTomadorDNI(DniGeneratorHelper.generaNif(null));
		this.wh.clickOnWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
		this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(this.tData.getTomadorDNI()));
		
		// Select nombre tomador
		this.wh.sendValueToWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame, "Tomnombre");
		// Select primer apellido
		this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, "Tompripellido");
		// Select segundo apellido
		this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame, "Tomsegapellido");
		
		// this.wh.switchToFrame(this.cuerpoFrame);
		// this.wh.changeFocusOfWebElement(this.txtSegundoApellidoTomador);
		// this.wh.exitFromFrame();
		this.wh.clickOnWebElementInFrame(this.btnValidarCliente, this.cuerpoFrame);
		this.wh.clickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
	}
	
	public void FillTomadorData(
			String tomadorType) throws Exception
	{
		logger.debug("BEGIN - FillTomadorData");

		switch (tomadorType)
		{
			case ProjectConstants.NuevoTomadorYAseguradoPrincipal:

				// this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorDNI());
				// this.wh.sendValueToWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorNombre());
				// this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorPrimerApellido());
				// this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorSegundoApellido());
				
				// Select documento tomador
				this.wh.selectValueInDropDownInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
				this.browserContext.getTestCaseData().setTomadorDNI(DniGeneratorHelper.generaNif(null));
				this.wh.clickOnWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
				this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(this.tData.getTomadorDNI()));
				
				// Select nombre tomador
				this.wh.sendValueToWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame, String.valueOf(this.tData.getTomadorNombre()));
				// Select primer apellido
				this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, String.valueOf(this.tData.getTomadorPrimerApellido()));
				// Select segundo apellido
				this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame,
						String.valueOf(this.tData.getTomadorSegundoApellido()));
				
				// this.wh.switchToFrame(this.cuerpoFrame);
				// this.wh.changeFocusOfWebElement(this.txtSegundoApellidoTomador);
				// this.wh.exitFromFrame();
				this.wh.clickOnWebElementInFrame(this.btnValidarCliente, this.cuerpoFrame);
				this.wh.clickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
				break;
			case ProjectConstants.ClienteExistente:
				this.wh.selectValueInDropDownInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
				this.browserContext.getTestCaseData().setTomadorDNI(this.browserContext.getTestCaseData().getTomadorDNI());
				this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorDNI());
				this.wh.clickOnWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame);
				this.wh.clickOnWebElementInFrame(this.btnValidarCliente, this.cuerpoFrame);

				this.wh.clickOnWebElementInFrame(this.rdnClienteExistente, this.cuerpoFrame);
				this.wh.clickOnWebElementInFrame(this.btnSeleccionarCliente, this.cuerpoFrame);

				this.wh.switchToFrame(this.cuerpoFrame);
				Assert.assertEquals(this.wh.getTextFromWebElement(this.txtNombreTomador), this.browserContext.getProperties().ClienteExistenteNombre);
				Assert.assertEquals(this.wh.getTextFromWebElement(this.txtPrimerApellidoTomador),
						this.browserContext.getProperties().ClienteExistentePrimerApellido);
				Assert.assertEquals(this.wh.getTextFromWebElement(this.txtSegundoApellidoTomador),
						this.browserContext.getProperties().ClienteExistenteSegundoApellido);
				this.wh.exitFromFrame();
				break;
			case ProjectConstants.TomadorCifEnTramite:
				this.wh.selectValueInDropDownInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.CIF);
				this.wh.clickOnWebElementInFrame(this.chkCIFEnTramite, this.cuerpoFrame);
				this.wh.sendValueToWebElementInFrame(this.txtRazonSocial, this.cuerpoFrame, "Test");
				break;
			default:
				throw new Exception(String.format("El tipo de tomador \"%s\" seleccionado no está implementado", tomadorType));
		}
		this.browserContext.webElementHelper.waitForAngular();
		logger.debug("END - FillTomadorData");
	}

	// public void NewTomadorWithNewNIF() throws InterruptedException
	// {
	// logger.debug("BEGIN - NewTomadorWithNewNIF");
	// this.wh.SelectValueInDropDownInFrame(this.cmbTipoDocumento, this.cuerpoFrame, MutuaPropietariosConstants.NIF);
	// this.wh.SendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, DniGeneratorHelper.generaNif(null));
	// this.wh.SendValueToWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorNombre());
	// this.wh.SendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame,
	// this.browserContext.getTestCaseData().getTomadorPrimerApellido());
	// this.wh.SendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame,
	// this.browserContext.getTestCaseData().getTomadorSegundoApellido());
	// this.wh.ClickOnWebElementInFrame(this.btnValidarCliente, this.cuerpoFrame);
	// this.wh.ClickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
	// logger.debug("END - NewTomadorWithNewNIF");
	// }
	// endregion
}
