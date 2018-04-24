package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.project.ProjectConstants;

public class DatosBasicosTomadorPage
{
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);


	// region webelements
	//@FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	//@FindBy(id = "tipoDocumento")
	private By cmbTipoDocumento = By.cssSelector("tipoDocumento");

	//@FindBy(id = "numeroDocumento")
	private By txtNumeroDocumento = By.cssSelector("numeroDocumento");

	//@FindBy(xpath = ".//*[text()='Validar cliente']")
	private By btnValidarCliente = By.xpath(".//*[text()='Validar cliente']");

	//@FindBy(xpath = ".//*[@name='nombreTomador']")
	private By txtNombreTomador = By.xpath(".//*[@name='nombreTomador']");

	//@FindBy(xpath = ".//*[@name='apellido1Tomador']")
	private By txtPrimerApellidoTomador = By.xpath(".//*[@name='apellido1Tomador']");

	//@FindBy(xpath = ".//*[@name='apellido2Tomador']")
	private By txtSegundoApellidoTomador = By.xpath(".//*[@name='apellido2Tomador']");

	//@FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	//@FindBy(xpath = ".//*[text()='Aceptar']")
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");

	//@FindBy(xpath = ".//*[@ng-model='tomador.cifTramite']")
	private By chkCIFEnTramite = By.xpath(".//*[@ng-model='tomador.cifTramite']");

	//@FindBy(name = "razonSocial")
	private By txtRazonSocial = By.name("razonSocial");

	//@FindBy(name = "duplicadoSelect")
	private By rdnClienteExistente = By.name("duplicadoSelect");

	//@FindBy(xpath = ".//*[text()='Seleccionar cliente']")
	private By btnSeleccionarCliente = By.xpath(".//*[text()='Seleccionar cliente']");

	// endregion

	public DatosBasicosTomadorPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
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
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}
	
	public void fillStaticTomadorData()
	{
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
		//this.browserContext.getTestCaseData().setTomadorDNI(DniGeneratorHelper.generaNif(null));
		this.tCData.setTestVar(testId, "tomadorDNI", DniGeneratorHelper.generaNif(null));
		this.webDriver.clickInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
		//this.webDriver.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(this.tCData.getTomadorDNI()));
		this.webDriver.appendTextInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "tomadorDNI")));
		
		// Select nombre tomador
		this.webDriver.appendTextInFrame(this.txtNombreTomador, this.cuerpoFrame, "Tomnombre");
		// Select primer apellido
		this.webDriver.appendTextInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, "Tompripellido");
		// Select segundo apellido
		this.webDriver.appendTextInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame, "Tomsegapellido");
		
		// this.wh.switchToFrame(this.cuerpoFrame);
		// this.wh.changeFocusOfWebElement(this.txtSegundoApellidoTomador);
		// this.wh.exitFromFrame();
		this.webDriver.clickInFrame(this.btnValidarCliente, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
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
				this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
				this.tCData.setTestVar(testId, "tomadorDNI", DniGeneratorHelper.generaNif(null));
				this.webDriver.clickInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
				this.webDriver.appendTextInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "tomadorDNI")));
				
				// Select nombre tomador
				//this.wh.sendValueToWebElementInFrame(this.txtNombreTomador, this.cuerpoFrame, String.valueOf(this.tData.getTomadorNombre()));
				this.webDriver.appendTextInFrame(this.txtNombreTomador, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "nombre_tomador")));
				
				// Select primer apellido
				//this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, String.valueOf(this.tData.getTomadorPrimerApellido()));
				this.webDriver.appendTextInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "primer_apellido_tomador")));
				
				// Select segundo apellido
				//this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame, String.valueOf(this.tData.getTomadorSegundoApellido()));
				this.webDriver.appendTextInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "segundo_apellido_tomador")));
				
				// this.wh.switchToFrame(this.cuerpoFrame);
				// this.wh.changeFocusOfWebElement(this.txtSegundoApellidoTomador);
				// this.wh.exitFromFrame();
				this.webDriver.clickInFrame(this.btnValidarCliente, this.cuerpoFrame);
				this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
				break;
			case ProjectConstants.ClienteExistente:
				this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
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
