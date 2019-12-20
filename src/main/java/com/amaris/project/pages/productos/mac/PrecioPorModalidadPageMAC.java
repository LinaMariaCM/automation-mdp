package com.amaris.project.pages.productos.mac;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class PrecioPorModalidadPageMac extends PageObject {

	// region webelements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By modalidadDrpDwn = By.cssSelector("#nombdato_MODALIDAD_1");
	private By rentaInput = By.cssSelector("#DTRIESALQCONF_RENTA");
	private By convertirProyectoBtn = By.cssSelector("#botonContinuar");
	private By impagoAlquilerDrpDwn = By.cssSelector("#selCobertura");
	private By franquiciaDrpDwn = By.cssSelector("#selFranquicia");
	private By continuarBtn = By.cssSelector("#botonContinuar");
	private By msjErrorTxt = By.cssSelector("div[class *= 'alert alert-danger alert-dismissable'");
	// endregion

	public PrecioPorModalidadPageMac(UserStory userS) {
		super(userS);
	}

	public PrecioPorModalidadPageMac completarRentaMensualAlquiler() {
		debugBegin();

		webDriver.waitWithDriver(4000);

		webDriver.setTextInFrame(rentaInput, mainFrame, getScenarioVar(Constants.RENTA_MENSUAL_ALQUILER));
		webDriver.tabulateElementInFrame(rentaInput, mainFrame);

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMac clickConvertirAProyecto() {
		debugBegin();

		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(convertirProyectoBtn, mainFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMac completarGarantiasBasicas() {
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

	public PrecioPorModalidadPageMac seleccionarImpagoAlquiler() {
		debugBegin();

		debugInfo("SCENARIO: " + userS.getScenario() + ", VALUE: " + getScenarioVar(Constants.IMPAGO_ALQUILER)
			+ ", SCENARIODATA: " + (userS.getTestDataManager().getData(AutomationConstants.SCENARIO_DATA) != null));

		webDriver.clickElementFromDropDownByTextInFrame(impagoAlquilerDrpDwn, mainFrame, getScenarioVar(Constants.IMPAGO_ALQUILER));

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMac seleccionarFranquicia() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(franquiciaDrpDwn, mainFrame, getScenarioVar(Constants.FRANQUICIA_MAC));
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMac clickContinuar() {
		debugBegin();
		webDriver.waitWithDriver(6000);
		webDriver.clickInFrame(continuarBtn, mainFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPageMac selectModalidad() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(modalidadDrpDwn, mainFrame, getTestVar(Constants.MODALIDAD));
		debugEnd();

		return this;
	}

	public String recuperarTextoMensajeError() {
		debugBegin();
		String mensajeError = webDriver.getTextInFrame(msjErrorTxt, mainFrame).substring(2);
		debugError("ERROR RECUPERADO - " + mensajeError);
		debugEnd();

		return mensajeError;
	}

	public boolean checkConvertirAProyectoIsPresent() {
		debugBegin();
		boolean checker = webDriver.isPresentInFrame(convertirProyectoBtn, mainFrame);
		debugEnd();

		return checker;
	}
	// endregion
}
