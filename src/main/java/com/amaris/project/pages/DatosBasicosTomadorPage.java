
package com.amaris.project.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.Steps;

public class DatosBasicosTomadorPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By cmbTipoDocumento = By.cssSelector("#tipoDocumento");
	private By txtNumeroDocumento = By.id("numeroDocumento");
	private By btnValidarCliente = By.xpath(".//*[text()='Validar cliente']");
	private By txtNombreTomador = By.xpath(".//*[@name='nombreTomador']");
	private By txtPrimerApellidoTomador = By.xpath(".//*[@name='apellido1Tomador']");
	private By txtSegundoApellidoTomador = By.xpath(".//*[@name='apellido2Tomador']");
	// private By btnContinuar = By.cssSelector("footer [ng-click*='continuar']");
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");
	private By chkCIFEnTramite = By.xpath(".//*[@ng-model='tomador.cifTramite']");

	private By txtRazonSocial = By.name("razonSocial");
	private By rdnClienteExistente = By.name("duplicadoSelect");
	private By btnSeleccionarCliente = By.xpath(".//*[text()='Seleccionar cliente']");

	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");

	private By btnVolver = By.id("botonVolver");
	private By btnAceptarVolver = By.cssSelector("#com_aceptar");

	private By btnAnyadir = By.cssSelector("[data-target='#tomadorAseguradoPopUp']");
	private By btnAceptarAnyadir = By.cssSelector("#tomadorAseguradoPopUp .modal-footer [type='submit']"); // div.modal-footer
																											// > button

	private By cumple = By.name("fechaNacimiento");
	private By checkMismaDirec = By.cssSelector("[ng-model='mismaDireccionRiesgo']");
	
	private By btnGuardar = By.cssSelector("[ng-bind*='com_guardar']");
	
	
	//private By btnAceptarAnyadir = By.xpath(".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']");
	// endregion

	public DatosBasicosTomadorPage(UserStory userS) {
		super(userS);
	}

	public DatosBasicosTomadorPage ExecuteActionsInPageTomadorYAseguradoPage(String tomadorType) throws Exception {
		fillTomadorData(tomadorType);
		clickOnContinuar();

		return this;
	}

	// region methods
	public DatosBasicosTomadorPage clickOnContinuar() {
		debugBegin();
		webDriver.waitWithDriver(4000);
		webDriver.waitForElementToBeClickableInFrame(loaderModal, cuerpoFrame);
		// webDriver.waitForElementToBeClickableInFrame(procesandoWindow, cuerpoFrame);

		// TODO Comprobar si todos los pasos son necesarios
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.scrollToElement(btnContinuar);

		webDriver.scrollToElement(btnContinuar);
		webDriver.waitWithDriver(4000);
		webDriver.click(btnContinuar);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	// dentro de la page "7.Tomador y asegurado" añade el mínimo de datos para poder continuar
	public DatosBasicosTomadorPage anyadirDatosMin() {
		debugBegin();

		webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		webDriver.waitWithDriver(4000);

		webDriver.clickInFrame(btnAnyadir, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.scrollToElement(cumple);
		webDriver.waitWithDriver(2000);
		webDriver.appendText(cumple, "25/05/1989");
		webDriver.waitWithDriver(2000);
		// webDriver.scrollToBottom();
		// webDriver.waitForElementToBeClickable(checkMismaDirec);
		webDriver.click(checkMismaDirec);
		webDriver.waitWithDriver(4000);
		webDriver.click(btnAceptarAnyadir);
		webDriver.waitWithDriver(2000);
		webDriver.click(btnContinuar);
		webDriver.exitFrame();
		// webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		// webDriver.exitFrame();

		return this;
	}

	public DatosBasicosTomadorPage fillStaticTomadorData() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDocumento, cuerpoFrame, Constants.NIF);

		setTestVar(Constants.DNI_TOMADOR, DniGeneratorHelper.generateNif());

		// TODO Quitar clickInFrame(txtNumeroDocumento... si no es necesario
		webDriver.clickInFrame(txtNumeroDocumento, cuerpoFrame);
		webDriver.appendTextInFrame(txtNumeroDocumento, cuerpoFrame, String.valueOf(getTestVar(Constants.DNI_TOMADOR)));

		webDriver.appendTextInFrame(txtNombreTomador, cuerpoFrame, Constants.NOMBRE_TOMADOR);
		webDriver.appendTextInFrame(txtPrimerApellidoTomador, cuerpoFrame, Constants.PRIMER_APELLIDO_TOMADOR);
		webDriver.appendTextInFrame(txtSegundoApellidoTomador, cuerpoFrame, Constants.SEGUNDO_APELLIDO_TOMADOR);

		// wh.switchToFrame(cuerpoFrame);
		// wh.changeFocusOfWebElement(txtSegundoApellidoTomador);
		// wh.exitFromFrame();
		webDriver.clickInFrame(btnValidarCliente, cuerpoFrame);
		webDriver.clickInFrame(btnAceptar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public DatosBasicosTomadorPage fillTomadorData(String tomadorType) throws Exception {
		debugBegin();

		switch(tomadorType) {
			case Constants.NuevoTomadorYAseguradoPrincipal:
				// Select documento tomador
				webDriver.waitWithDriver(1500);
				webDriver.waitForElementNotToBeClickable(procesandoWindow);
				webDriver.waitWithDriver(1500);

				if(webDriver.isPresentInFrame(btnVolver, cuerpoFrame)) {
					webDriver.waitForElementToBeClickableInFrame(btnVolver, cuerpoFrame);
					webDriver.clickInFrame(btnVolver, cuerpoFrame);
					webDriver.clickInFrame(btnAceptarVolver, cuerpoFrame);
				}

				// webDriver.waitWithDriver(2000);
				webDriver.waitForElementNotToBeClickableInFrame(loaderModal, cuerpoFrame);
				webDriver.waitWithDriver(4000);
				System.out.println("~$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("\n");
				System.out.println("VARIABLE tipoDocumento: " + cmbTipoDocumento);
				System.out.println("VARIABLE cuerpoFrame: " + cuerpoFrame);
				System.out.println("VARIABLE ProjectConstants.NIF: " + Constants.NIF);
				System.out.println("\n");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

				Steps.waitForIt(webDriver);

				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDocumento, cuerpoFrame, Constants.NIF);
				setTestVar(Constants.DNI_TOMADOR, DniGeneratorHelper.generateNif());
				webDriver.clickInFrame(txtNumeroDocumento, cuerpoFrame);
				webDriver.appendTextInFrame(txtNumeroDocumento, cuerpoFrame, getTestVar(Constants.DNI_TOMADOR));

				webDriver.appendTextInFrame(txtNombreTomador, cuerpoFrame, getScenarioVar(Constants.NOMBRE_TOMADOR));
				webDriver.appendTextInFrame(txtPrimerApellidoTomador, cuerpoFrame, getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
				webDriver.appendTextInFrame(txtSegundoApellidoTomador, cuerpoFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));

				webDriver.clickInFrame(btnValidarCliente, cuerpoFrame);

				webDriver.waitWithDriver(2000);
				webDriver.waitForElementNotToBeClickableInFrame(btnAceptar, cuerpoFrame);
				webDriver.clickInFrame(btnAceptar, cuerpoFrame);
				webDriver.waitWithDriver(5000);
				webDriver.clickInFrame(btnContinuar, cuerpoFrame);
				
				break;
			case Constants.ClienteExistente:
				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDocumento, cuerpoFrame, Constants.NIF);
				setTestVar(Constants.DNI_TOMADOR, getScenarioVar(Constants.DNI_TOMADOR));

				webDriver.appendTextInFrame(txtNumeroDocumento, cuerpoFrame, getScenarioVar(Constants.DNI_TOMADOR));
				webDriver.clickInFrame(txtNombreTomador, cuerpoFrame);
				webDriver.clickInFrame(btnValidarCliente, cuerpoFrame);

				webDriver.clickInFrame(rdnClienteExistente, cuerpoFrame);
				webDriver.clickInFrame(btnSeleccionarCliente, cuerpoFrame);

				Assert.assertEquals(webDriver.getTextInFrame(txtNombreTomador, cuerpoFrame), 
					getScenarioVar(Constants.NOMBRE_CLIENTE));
				Assert.assertEquals(webDriver.getTextInFrame(txtPrimerApellidoTomador, cuerpoFrame), 
					getScenarioVar(Constants.PRIMER_APELLIDO_CLIENTE));
				Assert.assertEquals(webDriver.getTextInFrame(txtSegundoApellidoTomador, cuerpoFrame), 
					getScenarioVar(Constants.SEGUNDO_APELLIDO_CLIENTE));

				break;
			case Constants.TomadorCifEnTramite:
				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDocumento, cuerpoFrame, Constants.CIF);
				webDriver.clickInFrame(chkCIFEnTramite, cuerpoFrame);
				webDriver.appendTextInFrame(txtRazonSocial, cuerpoFrame, "Test");

				break;
			default:
				throw new Exception(String.format("El tipo de tomador \"%s\" seleccionado no está implementado", tomadorType));
		}
		// browserContext.webElementHelper.waitForAngular();
		debugEnd();

		return this;
	}

	// public void NewTomadorWithNewNIF() throws InterruptedException
	// {
	// logger.debug("BEGIN - NewTomadorWithNewNIF");
	// wh.SelectValueInDropDownInFrame(cmbTipoDocumento,
	// cuerpoFrame, MutuaPropietariosConstants.NIF);
	// wh.SendValueToWebElementInFrame(txtNumeroDocumento,
	// cuerpoFrame, DniGeneratorHelper.generaNif(null));
	// wh.SendValueToWebElementInFrame(txtNombreTomador,
	// cuerpoFrame,
	// browserContext.getTestCaseData().getTomadorNombre());
	// wh.SendValueToWebElementInFrame(txtSegundoApellidoTomador,
	// cuerpoFrame,
	// browserContext.getTestCaseData().getTomadorPrimerApellido());
	// wh.SendValueToWebElementInFrame(txtSegundoApellidoTomador,
	// cuerpoFrame,
	// browserContext.getTestCaseData().getTomadorSegundoApellido());
	// wh.ClickOnWebElementInFrame(btnValidarCliente,
	// cuerpoFrame);
	// wh.ClickOnWebElementInFrame(btnAceptar, cuerpoFrame);
	// logger.debug("END - NewTomadorWithNewNIF");
	// }
	// endregion
}
