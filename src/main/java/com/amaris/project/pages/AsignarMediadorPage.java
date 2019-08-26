package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class AsignarMediadorPage extends PageObject {

	// region webelements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By razonSocial = By.cssSelector("#nombreRazonSocial");
	private By txtCodigoMediador = By.id("codigoMediador");
	private By txtCodigoMediadorMAC = By.id("codigo");
	private By txtDocumento = By.cssSelector("#numDocumento");

	private By btnBuscar = By.xpath(".//*[text()='Buscar']");
	private By btnBuscarMAC = By.cssSelector("#botonBuscar");
	private By radioBtnResultadoBusqueda = By.xpath(".//*[@type='radio']");
	private By btnContinuar = By.xpath(".//*[contains(text(),'Continuar')]");
	
	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");
	
	private By procesando = By.cssSelector(".procesando");
	// endregion

	public  AsignarMediadorPage(UserStory userS) {
		super(userS);
	}
	
	public AsignarMediadorPage TerminaProcesando() {
		this.webDriver.waitForElementNotToBePresent(procesando);
		
		return this;
	}

	// region methods
	public AsignarMediadorPage selectMediadorAndClickOnContinuar() {
		selectMediadorAndClickOnContinuar(getScenarioVar(Constants.MEDIADOR));

		return this;
	}
	
	public AsignarMediadorPage selectMediadorAndClickOnContinuar(String codigoMed) {
		this.seleccionarMediadorPorCodigo(codigoMed);
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage SelectMediadorMACAndClickOnContinuar() {
		SeleccionarMediadorMACPorCodigo(getScenarioVar(Constants.MEDIADOR));
		clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage clickOnContinuarButton() {
		debugBegin();
		
		webDriver.waitWithDriver(3000);
		//webDriver.waitForElementToBeClickableInFrame(btnContinuar, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, mainFrame);
		
		debugEnd();

		return this;
	}

	public AsignarMediadorPage seleccionarMediadorPorCodigo(String codigoMediador) {
		debugBegin();
		
		if(userS.getScenario().contains(Constants.MAC)) {
			webDriver.appendTextInFrame(txtCodigoMediadorMAC, mainFrame, codigoMediador);
			webDriver.click(btnBuscarMAC);
		} else {		
			webDriver.waitForElementNotToBeClickable(procesandoWindow);
	
			webDriver.appendTextInFrame(txtCodigoMediador, mainFrame, codigoMediador);
	
			webDriver.clickInFrame(txtDocumento, mainFrame);
			webDriver.clickInFrame(btnBuscar, mainFrame);
			
			webDriver.waitForElementNotToBeClickableInFrame(loaderModal, mainFrame);
			
			webDriver.clickInFrame(radioBtnResultadoBusqueda, mainFrame);
			
			webDriver.waitForElementNotToBeClickable(loaderModal);
		}

		debugEnd();

		return this;
	}

	public AsignarMediadorPage SeleccionarMediadorMACPorCodigo(String codigoMediador) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		webDriver.appendTextInFrame(txtCodigoMediadorMAC, mainFrame, codigoMediador);

		webDriver.clickInFrame(btnBuscarMAC, mainFrame);

		// wh.clickInFrame(radioBtnResultadoBusqueda, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
