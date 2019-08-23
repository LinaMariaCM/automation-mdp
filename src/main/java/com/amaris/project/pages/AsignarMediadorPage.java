package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

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
	private By txtCodigoMediadorMAC = By.id("codigo");

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
	public AsignarMediadorPage selectMediadorAndClickOnContinuar() throws InterruptedException {
		this.seleccionarMediadorPorCodigo(String.valueOf(userS.getScenarioVar("mediador")));
		this.clickOnContinuarButton();

		return this;
	}

	public AsignarMediadorPage SelectMediadorMACAndClickOnContinuar() throws InterruptedException {
		//this.SeleccionarMediadorMACPorCodigo(String.valueOf(userS.getScenarioVar("mediador")));
		this.SeleccionarMediadorMACPorCodigo(userS.getScenarioVar("mediador"));
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
		
		if(userS.getScenario().contains("MAC")) {
			this.webDriver.switchToFrame(this.mainFrame);
			this.webDriver.appendText(this.txtCodigoMediadorMAC, codigoMediador);
	
			this.webDriver.click(this.btnBuscarMAC);
	
			this.webDriver.exitFrame();
		} else {		
			//webDriver.waitWithDriver(2000);
			this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
	
			this.webDriver.switchToFrame(this.mainFrame);
	
			//this.webDriver.click(this.txtCodigoMediador);
			//webDriver.waitWithDriver(2000);
			this.webDriver.appendText(this.txtCodigoMediador, codigoMediador);
	
			this.webDriver.click(this.txtDocumento);
			this.webDriver.click(this.btnBuscar);
			
			this.webDriver.waitForElementNotToBeClickable(loaderModal);
			//this.webDriver.waitForElementToBeClickableAndClick(this.radioBtnResultadoBusqueda);
			//this.webDriver.waitForAngular();
			//webDriver.waitWithDriver(2500);
			this.webDriver.click(this.radioBtnResultadoBusqueda);
			//this.webDriver.waitForLoadToComplete();
			this.webDriver.exitFrame();
			this.webDriver.waitForElementNotToBeClickable(loaderModal);
		}

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

		this.webDriver.waitWithDriver(2000);
		this.webDriver.switchToFrame(this.mainFrame);
		this.webDriver.appendText(this.txtCodigoMediadorMAC, codigoMediador);

		this.webDriver.click(this.btnBuscarMAC);

		this.webDriver.exitFrame();

		// this.wh.ClickOnWebElementInFrame(this.radioBtnResultadoBusqueda,
		// this.cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
