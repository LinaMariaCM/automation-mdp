package com.amaris.project.pages.productos.mac;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class PrecioPorModalidadPageMAC extends PageObject {

	// region webelements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By drpdwnModalidad = By.cssSelector("#nombdato_MODALIDAD_1");
	private By txtRenta = By.cssSelector("#DTRIESALQCONF_RENTA");
	private By btnConvertirProyecto = By.cssSelector("#botonContinuar");
	private By drpdnImpagoAlquiler = By.cssSelector("#selCobertura");
	private By drpdnFranquicia = By.cssSelector("#selFranquicia");
	private By btnContinuar = By.cssSelector("#botonContinuar");
	private By msjError = By.cssSelector("div[class *= 'alert alert-danger alert-dismissable'");

	private By msjErrorRebasada = By.cssSelector("#RAUTCAPMAXCONF");
	private By msjErrorReaseguro = By.cssSelector("#REASRENTAALQ");
	// endregion

	public PrecioPorModalidadPageMAC(UserStory userS) {
		super(userS);
	}

	public PrecioPorModalidadPageMAC executeActionsInPrecioPorModalidadPage() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		completarRentaMensualAlquiler();
		completarGarantiasBasicas();
		clickOnConvertirAProyecto();

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC completarRentaMensualAlquiler() {
		debugBegin();

		webDriver.waitWithDriver(4000);

		webDriver.setTextInFrame(txtRenta, mainFrame, getScenarioVar(Constants.RENTA_MENSUAL_ALQUILER));
		webDriver.tabulateElementInFrame(txtRenta, mainFrame);

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC clickOnConvertirAProyecto() {
		debugBegin();

		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(btnConvertirProyecto, mainFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC completarGarantiasBasicas() {
		debugBegin();

		String impagoAlquiler = getScenarioVar(Constants.IMPAGO_ALQUILER);
		String franquicia = getScenarioVar(Constants.FRANQUICIA_MAC);

		if(impagoAlquiler != null && !impagoAlquiler.isEmpty()) {
			seleccionarImpagoAlquiler();
		}

		if(franquicia != null && !franquicia.isEmpty()) {
			seleccionarFranquicia();
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC seleccionarImpagoAlquiler() {
		debugBegin();

		debugInfo("SCENARIO: " + userS.getScenario() + ", VALUE: " + getScenarioVar(Constants.IMPAGO_ALQUILER)
			+ ", SCENARIODATA: " + (userS.getTestDataManager().getData(AutomationConstants.SCENARIO_DATA) != null));

		webDriver.clickElementFromDropDownByTextInFrame(drpdnImpagoAlquiler, mainFrame, getScenarioVar(Constants.IMPAGO_ALQUILER));

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC seleccionarFranquicia() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdnFranquicia, mainFrame, getScenarioVar(Constants.FRANQUICIA_MAC));
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC clickContinuar() {
		debugBegin();
		webDriver.waitWithDriver(6000);
		webDriver.clickInFrame(btnContinuar, mainFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMAC selectModalidad() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnModalidad, mainFrame, getTestVar(Constants.MODALIDAD));
		debugEnd();

		return this;
	}

	public String recuperarTextoMensajeError() {
		debugBegin();
		String mensajeError = webDriver.getTextInFrame(msjError, mainFrame).substring(2);
		debugError("ERROR RECUPERADO - " + mensajeError);
		debugEnd();

		return mensajeError;
	}

	public boolean checkConvertirAProyectoIsPresent() {
		debugBegin();
		boolean checker = webDriver.isPresentInFrame(btnConvertirProyecto, mainFrame);
		debugEnd();
		return checker;
	}
	// endregion
}
