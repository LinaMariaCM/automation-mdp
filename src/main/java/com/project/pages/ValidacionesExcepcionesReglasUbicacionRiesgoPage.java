package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionesExcepcionesReglasUbicacionRiesgoPage
{
	final static Logger logger = LoggerFactory.getLogger(ValidacionesExcepcionesReglasUbicacionRiesgoPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;
	
	// @FindBy(xpath = ".//*[text()='Continuar']")
	@FindBy(id = "botonContinuar")
	private WebElement btnContinuar;
	
	// @FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']")
	// private List<WebElement> lblExistenProjectosSuplementoActivo;

	@FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']")
	private WebElement lblExistenProjectosSuplementoActivo;

	@FindBy(xpath = ".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']")
	private WebElement lblUbicacionRiesgoYaAsegurada;

	@FindBy(id = "deshabilitacion")
	private WebElement cmbDeshabilitacion;

	@FindBy(xpath = ".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']")
	private WebElement btnAnadirInmuebleReferenciaCatastral;
	
	// endregion
	
	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	/*
	 * public void ClickOnContinuarButton() throws IOException { logger.debug("BEGIN - ClickOnContinuarButton");
	 * this.wh.switchToFrame(this.cuerpoFrame); this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5); WebElement returnedWebElementObject
	 * = this.wh.waitForTwoWebElementsAndReturnTheOneFound(this.btnContinuar, this.btnAnadirInmuebleReferenciaCatastral); String webElemntIdentifyText =
	 * this.wh.getTextFromWebElement(returnedWebElementObject); System.out.println(webElemntIdentifyText); if
	 * (webElemntIdentifyText.equals(MutuaPropietariosConstants.UbicacionRiesgoConProjectosActivosMsg)) { this.wh.clickOnWebElement(this.btnContinuar);
	 * } this.wh.exitFromFrame(); this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(); logger.debug("END - ClickOnContinuarButton"); }
	 */

	public void ClickOnContinuarButton() throws IOException
	{
		logger.debug("BEGIN - ClickOnContinuarButton");
		this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		this.wh.switchToFrame(this.cuerpoFrame);
		if (this.wh.webElementIsPresent(this.lblExistenProjectosSuplementoActivo))
		{
			this.wh.clickOnWebElement(this.btnContinuar);
		}
		this.wh.exitFromFrame();
		this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		logger.debug("END - ClickOnContinuarButton");
	}
	
	public void isUbicacionRiesgoUtilizada() throws IOException
	{
		logger.debug("BEGIN - isUbicacionRiesgoUtilizada");
		this.wh.switchToFrame(this.cuerpoFrame);
		this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		WebElement returnedWebElementObject = this.wh.waitForTwoWebElementsAndReturnTheOneFound(this.lblUbicacionRiesgoYaAsegurada,
				this.cmbDeshabilitacion);
		this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		String webElemntIdentifyText = this.wh.getTextFromWebElement(returnedWebElementObject);
		org.junit.Assert.assertNotEquals(ProjectConstants.UbicacionRiesgoYaUtilizadaError, webElemntIdentifyText,
				ProjectConstants.UbicacionRiesgoYaUtilizadaMsg);
		this.wh.exitFromFrame();
		logger.debug("END - isUbicacionRiesgoUtilizada");
	}
	// endregion
}
