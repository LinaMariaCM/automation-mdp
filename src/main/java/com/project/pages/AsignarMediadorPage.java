package com.project.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;

//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

import com.automation.model.webdriver.DriverHelper;

public class AsignarMediadorPage {

	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	// @FindBy(id = "nombreRazonSocial")
	private By razonSocial = By.cssSelector("#nombreRazonSocial");

	// @FindBy(id = "codigoMediador")
	//private By txtCodigoMediador = By.name("codigoMediador");
	private By txtCodigoMediador = By.id("codigoMediador");

	// @FindBy(id = "codigo")
	private By txtCodigoMediadorMAC = By.cssSelector("#codigo");

	// @FindBy(id = "numDocumento")
	private By txtDocumento = By.cssSelector("#numDocumento");

	// @FindBy(xpath = ".//*[text()='Buscar']")
	private By btnBuscar = By.xpath(".//*[text()='Buscar']");

	// @FindBy(id = "botonBuscar")
	private By btnBuscarMAC = By.cssSelector("#botonBuscar");

	// @FindBy(xpath = ".//*[@type='radio']")
	private By radioBtnResultadoBusqueda = By.xpath(".//*[@type='radio']");

	// @FindBy(xpath = ".//*[contains(text(),'Continuar')]")
	private By btnContinuar = By.xpath(".//*[contains(text(),'Continuar')]");
	
	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");
	// endregion

	public AsignarMediadorPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public AsignarMediadorPage selectMediadorAndClickOnContinuar(String scenario) throws InterruptedException {
		this.seleccionarMediadorPorCodigo(String.valueOf(tCData.getScenarioVar(scenario, "mediador")));
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage SelectMediadorMACAndClickOnContinuar(String scenario) throws InterruptedException {
		this.SeleccionarMediadorMACPorCodigo(String.valueOf(tCData.getScenarioVar(scenario, "mediador")));
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage clickOnContinuarButton() {
		logger.debug("BEGIN - ClickOnContinuarButton");
		this.webDriver.waitWithDriver(2000);
		//this.webDriver.waitForElementToBeClickableInFrame(this.btnContinuar, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuarButton");

		return this;
	}

	public AsignarMediadorPage seleccionarMediadorPorCodigo(String codigoMediador) throws InterruptedException {
		logger.debug("BEGIN - SeleccionarMediadorPorCodigo");
		//webDriver.waitWithDriver(2000);
		this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.txtCodigoMediador);
		this.webDriver.appendText(this.txtCodigoMediador, codigoMediador);

		this.webDriver.click(this.txtDocumento);
		this.webDriver.click(this.btnBuscar);
		
		this.webDriver.waitForElementNotToBeClickable(loaderModal);
		this.webDriver.click(this.radioBtnResultadoBusqueda);
		// this.webDriver.waitForLoadToComplete();
		this.webDriver.exitFrame();
		this.webDriver.waitForElementNotToBeClickable(loaderModal);

		logger.debug("END - SeleccionarMediadorPorCodigo");

		return this;
	}

	// public AsignarMediadorPage seleccionarMediadorPorCodigo(
	// String codigoMediador) throws InterruptedException
	// {
	// logger.debug("BEGIN - SeleccionarMediadorPorCodigo");
	// //this.webDriver.switchToFrame( this.cuerpoFrame);
	// this.webDriver.clickInFrame(this.txtCodigoMediador, this.cuerpoFrame);
	// this.webDriver.appendTextInFrame(this.txtCodigoMediador,this.cuerpoFrame,
	// codigoMediador);
	//
	// this.webDriver.clickInFrame(this.txtDocumento, this.cuerpoFrame);
	// this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
	// this.webDriver.clickInFrame(this.radioBtnResultadoBusqueda,
	// this.cuerpoFrame);
	// //this.webDriver.exitFrame();
	//
	// logger.debug("END - SeleccionarMediadorPorCodigo");
	//
	// return this;
	// }

	public AsignarMediadorPage SeleccionarMediadorMACPorCodigo(
		String codigoMediador) throws InterruptedException {
		logger.debug("BEGIN - SeleccionarMediadorMACPorCodigo");

		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.appendText(this.txtCodigoMediadorMAC, codigoMediador);

		this.webDriver.click(this.btnBuscarMAC);

		this.webDriver.exitFrame();

		// this.wh.ClickOnWebElementInFrame(this.radioBtnResultadoBusqueda,
		// this.cuerpoFrame);
		logger.debug("END - SeleccionarMediadorMACPorCodigo");

		return this;
	}
	// endregion
}
