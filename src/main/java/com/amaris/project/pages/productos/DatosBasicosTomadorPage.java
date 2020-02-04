
package com.amaris.project.pages.productos;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class DatosBasicosTomadorPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By tipoDocumentoDrpDwn = By.cssSelector("#tipoDocumento");
	private By numeroDocumentoInput = By.id("numeroDocumento");
	private By validarClienteBtn = By.xpath(".//*[text()='Validar cliente']");
	private By nombreTomadorInput = By.xpath(".//*[@name='nombreTomador']");
	private By primerApellidoTomadorInput = By.xpath(".//*[@name='apellido1Tomador']");
	private By segundoApellidoTomadorInput = By.xpath(".//*[@name='apellido2Tomador']");

	private By continuarBtn = By.xpath(".//*[text()='Continuar']");
	private By aceptarBtn = By.xpath(".//*[text()='Aceptar']");
	private By cifEnTramiteBtn = By.xpath(".//*[@ng-model='tomador.cifTramite']");

	private By razonSocialInput = By.name("razonSocial");
	private By clienteExistenteBtn = By.name("duplicadoSelect");
	private By seleccionarClienteBtn = By.xpath(".//*[text()='Seleccionar cliente']");

	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");

	private By volverBtn = By.id("botonVolver");
	private By aceptarVolverBtn = By.cssSelector("#com_aceptar");

	private By anyadirBtn = By.cssSelector("[data-target='#tomadorAseguradoPopUp']");
	private By aceptarAnyadirBtn = By.cssSelector("#tomadorAseguradoPopUp .modal-footer [type='submit']");

	private By cumpleInput = By.name("fechaNacimiento");
	private By mismaDirecBtn = By.cssSelector("[ng-model='mismaDireccionRiesgo']");

	private By procesandoModal = By.cssSelector("#procesando");
	// endregion

	public DatosBasicosTomadorPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public DatosBasicosTomadorPage waitProcesando() {
		debugBegin();

		debugInfo("Se espera al mensaje \"procesando\"");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesandoModal)) {
			debugInfo("Se muestra mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		debugEnd();

		return this;
	}

	public DatosBasicosTomadorPage clickContinuar() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.waitForElementToBeClickableInFrame(loaderModal, cuerpoFrame);
		// webDriver.waitForElementToBeClickableInFrame(procesandoWindow, cuerpoFrame);

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// dentro de la page "7.Tomador y asegurado" añade el mínimo de datos para poder continuar
	public DatosBasicosTomadorPage anyadirDatosMin() {
		debugBegin();

		webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		webDriver.waitWithDriver(4000);

		webDriver.clickInFrame(anyadirBtn, cuerpoFrame);

		webDriver.appendTextInFrame(cumpleInput, cuerpoFrame, "25/05/1989");

		webDriver.clickInFrame(mismaDirecBtn, cuerpoFrame);
		webDriver.clickInFrame(aceptarAnyadirBtn, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		return this;
	}

	public DatosBasicosTomadorPage fillStaticTomadorData() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);

		setTestVar(Constants.DNI_TOMADOR, DocumentGeneratorHelper.generateNif());

		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, getTestVar(Constants.DNI_TOMADOR));

		webDriver.appendTextInFrame(nombreTomadorInput, cuerpoFrame, getScenarioVar(Constants.NOMBRE_TOMADOR));
		webDriver.appendTextInFrame(primerApellidoTomadorInput, cuerpoFrame, getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
		webDriver.appendTextInFrame(segundoApellidoTomadorInput, cuerpoFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));

		webDriver.clickInFrame(validarClienteBtn, cuerpoFrame);
		webDriver.clickInFrame(aceptarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public DatosBasicosTomadorPage fillTomadorData(String tomadorType) {
		debugBegin();

		// TODO Refactorizar junto con fillStaticTomadorData() porque no es nada reusable
		switch(tomadorType) {
			case Constants.NuevoTomadorYAseguradoPrincipal:
				webDriver.waitWithDriver(1500);
				webDriver.waitForElementNotToBeClickable(procesandoWindow);
				webDriver.waitWithDriver(1500);

				if(webDriver.isPresentInFrame(volverBtn, cuerpoFrame)) {
					webDriver.waitForElementToBeClickableInFrame(volverBtn, cuerpoFrame);
					webDriver.clickInFrame(volverBtn, cuerpoFrame);
					webDriver.clickInFrame(aceptarVolverBtn, cuerpoFrame);
				}

				webDriver.waitForElementNotToBeClickableInFrame(loaderModal, cuerpoFrame);

				ActionSteps.waitForIt(webDriver);

				webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);

				setTestVar(Constants.DNI_TOMADOR, DocumentGeneratorHelper.generateNif());

				webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, getTestVar(Constants.DNI_TOMADOR));

				webDriver.appendTextInFrame(nombreTomadorInput, cuerpoFrame, getScenarioVar(Constants.NOMBRE_TOMADOR));
				webDriver.appendTextInFrame(primerApellidoTomadorInput, cuerpoFrame, getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
				webDriver.appendTextInFrame(segundoApellidoTomadorInput, cuerpoFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));

				webDriver.clickInFrame(validarClienteBtn, cuerpoFrame);

				webDriver.waitWithDriver(2000);

				webDriver.waitForElementToBeClickableInFrame(aceptarBtn, cuerpoFrame);

				webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
				webDriver.waitWithDriver(5000);
				webDriver.clickInFrame(continuarBtn, cuerpoFrame);

				break;
			case Constants.ClienteExistente:
				webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);

				setTestVar(Constants.DNI_TOMADOR, DocumentGeneratorHelper.generateNif());

				webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, getTestVar(Constants.DNI_TOMADOR));
				webDriver.clickInFrame(nombreTomadorInput, cuerpoFrame);
				webDriver.clickInFrame(validarClienteBtn, cuerpoFrame);

				webDriver.clickInFrame(clienteExistenteBtn, cuerpoFrame);
				webDriver.clickInFrame(seleccionarClienteBtn, cuerpoFrame);

				Assert.assertEquals(webDriver.getTextInFrame(nombreTomadorInput, cuerpoFrame), getScenarioVar(Constants.NOMBRE_CLIENTE));
				Assert.assertEquals(webDriver.getTextInFrame(primerApellidoTomadorInput, cuerpoFrame), getScenarioVar(Constants.PRIMER_APELLIDO_CLIENTE));
				Assert.assertEquals(webDriver.getTextInFrame(segundoApellidoTomadorInput, cuerpoFrame), getScenarioVar(Constants.SEGUNDO_APELLIDO_CLIENTE));

				break;
			case Constants.TomadorCifEnTramite:
				webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.CIF);
				webDriver.clickInFrame(cifEnTramiteBtn, cuerpoFrame);
				webDriver.appendTextInFrame(razonSocialInput, cuerpoFrame, "Test");

				break;
			default:
				debugError(String.format("El tipo de tomador \"%s\" seleccionado no está implementado", tomadorType));
		}

		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}
}
