package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;

public class DatosBasicosTomadorPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(id = "tipoDocumento")
	private By cmbTipoDocumento = By.id("tipoDocumento");

	// @FindBy(id = "numeroDocumento")
	private By txtNumeroDocumento = By.id("numeroDocumento");

	// @FindBy(xpath = ".//*[text()='Validar cliente']")
	// private By btnValidarCliente = By.xpath(".//*[text()='Validar
	// cliente']");
	private By btnValidarCliente = By.name("Validar cliente");

	// @FindBy(xpath = ".//*[@name='nombreTomador']")
	private By txtNombreTomador = By.xpath(".//*[@name='nombreTomador']");

	// @FindBy(xpath = ".//*[@name='apellido1Tomador']")
	private By txtPrimerApellidoTomador = By.xpath(".//*[@name='apellido1Tomador']");

	// @FindBy(xpath = ".//*[@name='apellido2Tomador']")
	private By txtSegundoApellidoTomador = By.xpath(".//*[@name='apellido2Tomador']");

	// @FindBy(xpath = ".//*[text()='Continuar']")
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

	private By btnAceptarVolver = By.cssSelector("button[ng-click*='com_aceptar']");
	// private By btnAceptarVolver = By.cssSelector("com_aceptar");
	// private By btnAceptarVolver = By.id("Aceptar");
	// private By btnAceptarVolver = By.xpath(".//*[text()='Aceptar']");
	// endregion

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
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		debugEnd();

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
		// debugBegin();

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
				this.webDriver.waitWithDriver(1000);
				this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
				this.webDriver.waitWithDriver(1000);
				if(this.webDriver.isPresentInFrame(this.btnVolver, this.cuerpoFrame)) {
					this.webDriver.clickInFrame(this.btnVolver, this.cuerpoFrame);
					this.webDriver.clickInFrame(this.btnAceptarVolver, this.cuerpoFrame);
				}
				this.webDriver.waitWithDriver(4000);
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
				this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);

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
