package com.project.pages;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;


public class AsignarMediadorPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By mainFrame = By.cssSelector("#mainFrame");

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

	public  AsignarMediadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AsignarMediadorPage selectMediadorAndClickOnContinuar(String scenario) throws InterruptedException {
		this.seleccionarMediadorPorCodigo(String.valueOf(getScenarioVar("mediador")));
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage SelectMediadorMACAndClickOnContinuar(String scenario) throws InterruptedException {
		this.SeleccionarMediadorMACPorCodigo(String.valueOf(getScenarioVar("mediador")));
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage clickOnContinuarButton() {
		debugBegin();
		
		this.webDriver.waitWithDriver(3000);
		//this.webDriver.waitForElementToBeClickableInFrame(this.btnContinuar, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnContinuar, this.mainFrame);
		
		debugEnd();

		return this;
	}

	public AsignarMediadorPage seleccionarMediadorPorCodigo(String codigoMediador) throws InterruptedException {
		debugBegin();
		//webDriver.waitWithDriver(2000);
		this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
		this.webDriver.switchToFrame(this.mainFrame);
		this.webDriver.click(this.txtCodigoMediador);
		this.webDriver.appendText(this.txtCodigoMediador, codigoMediador);

		this.webDriver.click(this.txtDocumento);
		this.webDriver.click(this.btnBuscar);
		
		this.webDriver.waitForElementNotToBeClickable(loaderModal);
		this.webDriver.click(this.radioBtnResultadoBusqueda);
		// this.webDriver.waitForLoadToComplete();
		this.webDriver.exitFrame();
		this.webDriver.waitForElementNotToBeClickable(loaderModal);

		debugEnd();

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

	public AsignarMediadorPage SeleccionarMediadorMACPorCodigo(String codigoMediador) throws InterruptedException {
		debugBegin();

		this.webDriver.clearAndAppendTextInFrame(this.txtCodigoMediadorMAC, this.mainFrame, codigoMediador);
		this.webDriver.clickInFrame(this.btnBuscarMAC, this.mainFrame);


		// this.wh.ClickOnWebElementInFrame(this.radioBtnResultadoBusqueda,
		// this.cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
