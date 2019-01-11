package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;
import com.project.steps.Steps;

public class DatosBasicosTomadorPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(id = "tipoDocumento")
	private By cmbTipoDocumento = By.cssSelector("#tipoDocumento");

	// @FindBy(id = "numeroDocumento")
	private By txtNumeroDocumento = By.id("numeroDocumento");

	// @FindBy(xpath = ".//*[text()='Validar cliente']")
	private By btnValidarCliente = By.xpath(".//*[text()='Validar cliente']");
	//private By btnValidarCliente = By.name("Validar cliente");

	// @FindBy(xpath = ".//*[@name='nombreTomador']")
	private By txtNombreTomador = By.xpath(".//*[@name='nombreTomador']");

	// @FindBy(xpath = ".//*[@name='apellido1Tomador']")
	private By txtPrimerApellidoTomador = By.xpath(".//*[@name='apellido1Tomador']");

	// @FindBy(xpath = ".//*[@name='apellido2Tomador']")
	private By txtSegundoApellidoTomador = By.xpath(".//*[@name='apellido2Tomador']");

	
	///html/body/div/div[1]/div/div[3]/footer/div/button[2]
	
	// @FindBy(xpath = ".//*[text()='Continuar']")
	//private By btnContinuar = By.cssSelector("footer [ng-click*='continuar']");
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");


	// @FindBy(xpath = ".//*[text()='Aceptar']")
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");

	// @FindBy(xpath = ".//*[@ng-model='tomador.cifTramite']")
	private By chkCIFEnTramite = By.xpath(".//*[@ng-model='tomador.cifTramite']");

	// @FindBy(name = "razonSocial")
	private By txtRazonSocial = By.name("razonSocial");

	// @FindBy(name = "duplicadoSelect")
	private By rdnClienteExistente = By.name("duplicadoSelect");

	// @FindBy(xpath = ".//*[text()='Seleccionar cliente']")
	private By btnSeleccionarCliente = By.xpath(".//*[text()='Seleccionar cliente']");

	private By procesandoWindow = By.cssSelector(".smallbox");

	private By btnVolver = By.id("botonVolver");

	//private By btnAceptarVolver = By.cssSelector("button[ng-click*='com_aceptar']");
	
	private By loaderModal = By.cssSelector("#modalLoader");
	
	private By btnAceptarVolver = By.cssSelector("#com_aceptar");
	// private By btnAceptarVolver = By.id("Aceptar");
	// private By btnAceptarVolver = By.xpath(".//*[text()='Aceptar']");
	// endregion
	
	private By btnAnyadir = By.cssSelector("[data-target='#tomadorAseguradoPopUp']");
	
	private By cumple = By.name("fechaNacimiento");
	
	
	private By checkMismaDirec = By.cssSelector("[ng-model='mismaDireccionRiesgo']");
	
	
	private By btnAceptarAnyadir = By.cssSelector("#tomadorAseguradoPopUp .modal-footer [type='submit']"); //div.modal-footer > button
	
	
	//private By btnAceptarAnyadir = By.xpath(".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']");

	public DatosBasicosTomadorPage(UserStory userS) {
		super(userS);
	}

	public DatosBasicosTomadorPage ExecuteActionsInPageTomadorYAseguradoPage(String tomadorType) throws Exception {
		this.fillTomadorData(tomadorType);
		this.clickOnContinuar();

		return this;
	}

	// region methods
	public DatosBasicosTomadorPage clickOnContinuar() {
		debugBegin();
		this.webDriver.waitWithDriver(4000);

		this.webDriver.waitForElementToBeClickableInFrame(this.loaderModal, this.cuerpoFrame);

		//this.webDriver.waitForElementToBeClickableInFrame(this.procesandoWindow, this.cuerpoFrame);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.scrollToElement(this.btnContinuar);
		
		this.webDriver.scrollToElement(this.btnContinuar);
		this.webDriver.waitWithDriver(4000);
		this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//dentro de la page "7.Tomador y asegurado" añade el mínimo de datos para poder continuar
	public DatosBasicosTomadorPage anyadirDatosMin(){
		debugBegin();
		
		this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
		this.webDriver.waitWithDriver(4000);

		this.webDriver.clickInFrame(this.btnAnyadir, this.cuerpoFrame);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.scrollToElement(this.cumple);
		this.webDriver.waitWithDriver(2000);
		this.webDriver.appendText(this.cumple, "25/05/1989");
		this.webDriver.waitWithDriver(2000);
		//this.webDriver.scrollToBottom();
		//this.webDriver.waitForElementToBeClickable(this.checkMismaDirec);
		this.webDriver.click(this.checkMismaDirec);
		this.webDriver.waitWithDriver(4000);
		this.webDriver.click(this.btnAceptarAnyadir);
		this.webDriver.waitWithDriver(2000);
		this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();
		//this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);

		//this.webDriver.exitFrame();
		
	return this;
	}
	
	
	public DatosBasicosTomadorPage fillStaticTomadorData() {
		debugBegin();

		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
		// this.browserContext.getTestCaseData().setTomadorDNI(DniGeneratorHelper.generaNif(null));
		setTestVar("tomadorDNI", DniGeneratorHelper.generaNif(null));
		this.webDriver.clickInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
		// this.webDriver.sendValueToWebElementInFrame(this.txtNumeroDocumento,
		// this.cuerpoFrame, String.valueOf(getTomadorDNI()));
		this.webDriver.appendTextInFrame(this.txtNumeroDocumento, this.cuerpoFrame, String.valueOf(getScenarioVar("TomadorDNI")));

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

		debugEnd();

		return this;
	}

	public DatosBasicosTomadorPage fillTomadorData(String tomadorType) {
		debugBegin();

		switch(tomadorType) {
			case ProjectConstants.NuevoTomadorYAseguradoPrincipal:
				// this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento,
				// this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorDNI());
				// this.wh.sendValueToWebElementInFrame(this.txtNombreTomador,
				// this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorNombre());
				// this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador,
				// this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorPrimerApellido());
				// this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador,
				// this.cuerpoFrame,
				// this.browserContext.getTestCaseData().getTomadorSegundoApellido());

				// Select documento tomador
				this.webDriver.waitWithDriver(1500);
				this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
				this.webDriver.waitWithDriver(1500);

				if(this.webDriver.isPresentInFrame(this.btnVolver, this.cuerpoFrame)) {
					this.webDriver.waitForElementToBeClickableInFrame(this.btnVolver, this.cuerpoFrame);
					this.webDriver.clickInFrame(this.btnVolver, this.cuerpoFrame);
					this.webDriver.clickInFrame(this.btnAceptarVolver, this.cuerpoFrame);
				}
				//this.webDriver.waitWithDriver(2000);
				this.webDriver.waitForElementNotToBeClickableInFrame(this.loaderModal, this.cuerpoFrame);
				this.webDriver.waitWithDriver(4000);
				System.out.println("~$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("\n");
				System.out.println("VARIABLE tipoDocumento: " + this.cmbTipoDocumento);
				System.out.println("VARIABLE this.cuerpoFrame: " + this.cuerpoFrame);
				System.out.println("VARIABLE ProjectConstants.NIF: "+ ProjectConstants.NIF);
				System.out.println("\n");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				
				
				//this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
				//this.webDriver.waitWithDriver(3500);
				//this.webDriver.waitForAngular();
				
				Steps.waitForIt(webDriver);
				//Steps.waitForIt(webDriver, this.cmbTipoDocumento);
				//Steps.waitForIt(webDriver, 1000);

				this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
				setTestVar("tomador_dni", DniGeneratorHelper.generaNif(null));
				this.webDriver.clickInFrame(this.txtNumeroDocumento, this.cuerpoFrame);
				this.webDriver.appendTextInFrame(this.txtNumeroDocumento, this.cuerpoFrame, getTestVar("tomador_dni"));

				// Select nombre tomador
				// this.wh.sendValueToWebElementInFrame(this.txtNombreTomador,
				// this.cuerpoFrame,
				// String.valueOf(this.tData.getTomadorNombre()));
				this.webDriver.appendTextInFrame(this.txtNombreTomador, this.cuerpoFrame, getScenarioVar("nombre_tomador"));

				// Select primer apellido
				// this.wh.sendValueToWebElementInFrame(this.txtPrimerApellidoTomador,
				// this.cuerpoFrame,
				// String.valueOf(this.tData.getTomadorPrimerApellido()));
				this.webDriver.appendTextInFrame(this.txtPrimerApellidoTomador, this.cuerpoFrame, getScenarioVar("primer_apellido_tomador"));

				// Select segundo apellido
				// this.wh.sendValueToWebElementInFrame(this.txtSegundoApellidoTomador,
				// this.cuerpoFrame,
				// String.valueOf(this.tData.getTomadorSegundoApellido()));
				this.webDriver.appendTextInFrame(this.txtSegundoApellidoTomador, this.cuerpoFrame, getScenarioVar("segundo_apellido_tomador"));

				// this.wh.switchToFrame(this.cuerpoFrame);
				// this.wh.changeFocusOfWebElement(this.txtSegundoApellidoTomador);
				// this.wh.exitFromFrame();

				
				this.webDriver.clickInFrame(this.btnValidarCliente, this.cuerpoFrame);
				
				this.webDriver.waitWithDriver(2000);
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.waitForElementNotToBeClickable(this.btnAceptar);
				this.webDriver.click(this.btnAceptar);
				this.webDriver.exitFrame();
				this.webDriver.waitWithDriver(5000);
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(this.btnContinuar);
				this.webDriver.exitFrame();
				break;


			case ProjectConstants.ClienteExistente:
				this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
				// this.browserContext.getTestCaseData().setTomadorDNI(this.browserContext.getTestCaseData().getTomadorDNI());
				setTestVar("TomadorDNI", getScenarioVar("TomadorDNI"));

				this.webDriver.appendTextInFrame(this.txtNumeroDocumento, this.cuerpoFrame, getScenarioVar("TomadorDNI"));
				this.webDriver.clickInFrame(this.txtNombreTomador, this.cuerpoFrame);
				this.webDriver.clickInFrame(this.btnValidarCliente, this.cuerpoFrame);

				this.webDriver.clickInFrame(this.rdnClienteExistente, this.cuerpoFrame);
				this.webDriver.clickInFrame(this.btnSeleccionarCliente, this.cuerpoFrame);

				this.webDriver.switchToFrame(this.cuerpoFrame);
				Assert.assertEquals(this.webDriver.getText(this.txtNombreTomador), getScenarioVar("NombreCliente"));
				Assert.assertEquals(this.webDriver.getText(this.txtPrimerApellidoTomador), getScenarioVar("tomadorPrimerApellido"));
				Assert.assertEquals(this.webDriver.getText(this.txtSegundoApellidoTomador), getScenarioVar("TomadorSegundoApellido"));
				this.webDriver.exitFrame();

				break;


			case ProjectConstants.TomadorCifEnTramite:
				this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDocumento, this.cuerpoFrame, ProjectConstants.CIF);
				this.webDriver.clickInFrame(this.chkCIFEnTramite, this.cuerpoFrame);
				this.webDriver.appendTextInFrame(this.txtRazonSocial, this.cuerpoFrame, "Test");

				break;
			default:
				// throw new Exception(String.format("El tipo de tomador \"%s\"
				// seleccionado no está implementado", tomadorType));
		}
		// this.browserContext.webElementHelper.waitForAngular();
		debugEnd();

		return this;
	}

	// public void NewTomadorWithNewNIF() throws InterruptedException
	// {
	// logger.debug("BEGIN - NewTomadorWithNewNIF");
	// this.wh.SelectValueInDropDownInFrame(this.cmbTipoDocumento,
	// this.cuerpoFrame, MutuaPropietariosConstants.NIF);
	// this.wh.SendValueToWebElementInFrame(this.txtNumeroDocumento,
	// this.cuerpoFrame, DniGeneratorHelper.generaNif(null));
	// this.wh.SendValueToWebElementInFrame(this.txtNombreTomador,
	// this.cuerpoFrame,
	// this.browserContext.getTestCaseData().getTomadorNombre());
	// this.wh.SendValueToWebElementInFrame(this.txtSegundoApellidoTomador,
	// this.cuerpoFrame,
	// this.browserContext.getTestCaseData().getTomadorPrimerApellido());
	// this.wh.SendValueToWebElementInFrame(this.txtSegundoApellidoTomador,
	// this.cuerpoFrame,
	// this.browserContext.getTestCaseData().getTomadorSegundoApellido());
	// this.wh.ClickOnWebElementInFrame(this.btnValidarCliente,
	// this.cuerpoFrame);
	// this.wh.ClickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
	// logger.debug("END - NewTomadorWithNewNIF");
	// }
	// endregion
}
