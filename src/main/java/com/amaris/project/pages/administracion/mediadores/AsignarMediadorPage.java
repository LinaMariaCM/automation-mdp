package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class AsignarMediadorPage extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By codigoMediadorTxt = By.id("codigoMediador");
	private By codigoMediadorMacTxt = By.id("codigo");
	private By documentoTxt = By.cssSelector("#numDocumento");

	private By buscarBtn = By.xpath(".//*[text()='Buscar']");
	private By buscarMacBtn = By.cssSelector("#botonBuscar");
	private By resultadoBusquedaBtn = By.xpath(".//*[@type='radio']");
	private By continuarBtn = By.xpath(".//*[contains(text(),'Continuar')]");

	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");

	private By procesando = By.cssSelector(".procesando");
	// endregion

	public AsignarMediadorPage(UserStory userS) {
		super(userS);
	}

	public AsignarMediadorPage terminaProcesando() {
		webDriver.waitForElementNotToBePresent(procesando);

		return this;
	}

	// region methods
	public AsignarMediadorPage selectMediadorAndClickOnContinuar() {
		selectMediadorAndClickOnContinuar(getScenarioVar(Constants.MEDIADOR));

		return this;
	}

	public AsignarMediadorPage selectMediadorAndClickOnContinuar(String codigoMed) {
		seleccionarMediadorPorCodigo(codigoMed);
		clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage selectMediadorMACAndClickOnContinuar() {
		seleccionarMediadorMACPorCodigo(getScenarioVar(Constants.MEDIADOR));
		clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage clickOnContinuarButton() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(continuarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AsignarMediadorPage seleccionarMediadorPorCodigo(String codigoMediador) {
		debugBegin();

		if(userS.getScenario().contains(Constants.MAC)) {
			webDriver.appendTextInFrame(codigoMediadorMacTxt, mainFrame, codigoMediador);
			webDriver.click(buscarMacBtn);
		} else {
			webDriver.waitForElementNotToBeClickable(procesandoWindow);

			webDriver.appendTextInFrame(codigoMediadorTxt, mainFrame, codigoMediador);

			webDriver.clickInFrame(documentoTxt, mainFrame);
			webDriver.clickInFrame(buscarBtn, mainFrame);

			webDriver.waitForElementNotToBeClickableInFrame(loaderModal, mainFrame);

			webDriver.clickInFrame(resultadoBusquedaBtn, mainFrame);

			webDriver.waitForElementNotToBeClickable(loaderModal);
		}

		debugEnd();

		return this;
	}

	public AsignarMediadorPage seleccionarMediadorMACPorCodigo(String codigoMediador) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		webDriver.appendTextInFrame(codigoMediadorMacTxt, mainFrame, codigoMediador);

		webDriver.clickInFrame(buscarMacBtn, mainFrame);

		debugEnd();

		return this;
	}
	// endregion
}
