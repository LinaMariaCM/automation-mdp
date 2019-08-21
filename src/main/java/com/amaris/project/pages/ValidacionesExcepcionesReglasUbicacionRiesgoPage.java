package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class ValidacionesExcepcionesReglasUbicacionRiesgoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.id("botonContinuar");
	private By lblExistenProjectosSuplementoActivo = By.xpath(".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']");
	private By lblUbicacionRiesgoYaAsegurada = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");

	private By cmbDeshabilitacion = By.id("deshabilitacion");
	private By btnAnadirInmuebleReferenciaCatastral = By.xpath(".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']");

	private By procesandoWindow = By.cssSelector(".smallbox");
	private By aceptarBtn = By.cssSelector("#modalErrores .modal-footer button");
	// endregion

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void ClickOnContinuarButton() {
		debugBegin();

		if(webDriver.isPresentInFrame(lblExistenProjectosSuplementoActivo, cuerpoFrame)) {
			webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		}

		debugEnd();
	}

	public void isUbicacionRiesgoUtilizada() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.waitForElementNotToBeClickable(procesandoWindow);
		webDriver.waitWithDriver(4000);

		if(webDriver.isPresentInFrame(lblUbicacionRiesgoYaAsegurada, cuerpoFrame)) {
			webDriver.waitForElementToBePresentInFrame(lblUbicacionRiesgoYaAsegurada, cuerpoFrame);
		}

		String identifyText = webDriver.getTextInFrame(cmbDeshabilitacion, cuerpoFrame);
		Assert.assertNotEquals(Constants.UbicacionRiesgoYaUtilizadaError, identifyText, Constants.UbicacionRiesgoYaUtilizadaMsg);

		debugEnd();
	}
	// endregion
}
