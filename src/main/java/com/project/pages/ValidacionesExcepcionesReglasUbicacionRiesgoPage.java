package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionesExcepcionesReglasUbicacionRiesgoPage
{
	/*final static Logger logger = LoggerFactory.getLogger(ValidacionesExcepcionesReglasUbicacionRiesgoPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	*/
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	// region webelements
	//@FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");
	
	// @FindBy(xpath = ".//*[text()='Continuar']")
	//@FindBy(id = "botonContinuar")
	private By btnContinuar = By.id("botonContinuar");
	
	// @FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']")
	// private List<WebElement> lblExistenProjectosSuplementoActivo;

	//@FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']")
	private By lblExistenProjectosSuplementoActivo = By.xpath(".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']");

	//@FindBy(xpath = ".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']")
	private By lblUbicacionRiesgoYaAsegurada = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");

	//@FindBy(id = "deshabilitacion")
	private By cmbDeshabilitacion = By.id("deshabilitacion");

	//@FindBy(xpath = ".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']")
	private By btnAnadirInmuebleReferenciaCatastral = By.xpath(".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']");
	
	
	private By procesandoWindow = By.cssSelector(".smallbox");
	// endregion
	/*
	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	*/
	
	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	
	// region methods
	/*
	 * public void ClickOnContinuarButton() throws IOException { logger.debug("BEGIN - ClickOnContinuarButton");
	 * this.webDriver.switchToFrame(this.cuerpoFrame); this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5); WebElement returnedWebElementObject
	 * = this.webDriver.waitForTwoWebElementsAndReturnTheOneFound(this.btnContinuar, this.btnAnadirInmuebleReferenciaCatastral); String webElemntIdentifyText =
	 * this.webDriver.getTextFromWebElement(returnedWebElementObject); System.out.println(webElemntIdentifyText); if
	 * (webElemntIdentifyText.equals(MutuaPropietariosConstants.UbicacionRiesgoConProjectosActivosMsg)) { this.webDriver.clickOnWebElement(this.btnContinuar);
	 * } this.webDriver.exitFromFrame(); this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(); logger.debug("END - ClickOnContinuarButton"); }
	 */

	public void ClickOnContinuarButton() throws IOException
	{
		logger.debug("BEGIN - ClickOnContinuarButton");
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		if (this.webDriver.isPresent(this.lblExistenProjectosSuplementoActivo))
		{
			this.webDriver.click(this.btnContinuar);
		}
		this.webDriver.exitFrame();
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		logger.debug("END - ClickOnContinuarButton");
	}
	
	public void isUbicacionRiesgoUtilizada() throws IOException
	{
		logger.debug("BEGIN - isUbicacionRiesgoUtilizada");
		//this.webDriver.waitWithDriver(2000);
		this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		
		this.webDriver.waitForElementToBePresent(this.lblUbicacionRiesgoYaAsegurada);
		
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		String webElemntIdentifyText = this.webDriver.getText(cmbDeshabilitacion);
		org.junit.Assert.assertNotEquals(ProjectConstants.UbicacionRiesgoYaUtilizadaError, webElemntIdentifyText,
				ProjectConstants.UbicacionRiesgoYaUtilizadaMsg);
		this.webDriver.exitFrame();
		logger.debug("END - isUbicacionRiesgoUtilizada");
		
		
	}
	// endregion
}
