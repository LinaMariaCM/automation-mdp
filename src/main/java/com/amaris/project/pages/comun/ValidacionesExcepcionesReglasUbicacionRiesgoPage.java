package com.amaris.project.pages.comun;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class ValidacionesExcepcionesReglasUbicacionRiesgoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By continuarBtn = By.id("botonContinuar");
	private By existenProjectosSuplementoActivoTxt = By.xpath(".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']");
	private By ubicacionRiesgoYaAseguradaTxt = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");

	private By deshabilitacionTxt = By.id("deshabilitacion");
	private By btnAnadirInmuebleReferenciaCatastral = By.xpath(".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']");

	private By procesandoWindow = By.cssSelector(".smallbox");
	private By aceptarBtn = By.cssSelector("#modalErrores .modal-footer button");
	private By procesandoTxt = By.cssSelector("#procesando");
	// endregion

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage waitProcesando() {
		debugInfo("Espero el mensaje \"procesando\"");
		webDriver.waitWithDriver(5000);

		while(this.webDriver.isPresent(procesandoTxt)) {
			debugInfo("Veo el mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		return this;
	}

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage clickContinuar() {
		debugBegin();

		if(webDriver.isPresentInFrame(existenProjectosSuplementoActivoTxt, cuerpoFrame)) {
			webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage isUbicacionRiesgoUtilizada() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.waitForElementNotToBeClickable(procesandoWindow);
		webDriver.waitWithDriver(4000);

		if(webDriver.isPresentInFrame(ubicacionRiesgoYaAseguradaTxt, cuerpoFrame)) {
			webDriver.waitForElementToBePresentInFrame(ubicacionRiesgoYaAseguradaTxt, cuerpoFrame);
		}

		String identifyText = webDriver.getTextInFrame(deshabilitacionTxt, cuerpoFrame);
		Assert.assertNotEquals(Constants.UbicacionRiesgoYaUtilizadaError, identifyText, Constants.UbicacionRiesgoYaUtilizadaMsg);

		debugEnd();

		return this;
	}
	// endregion
}
