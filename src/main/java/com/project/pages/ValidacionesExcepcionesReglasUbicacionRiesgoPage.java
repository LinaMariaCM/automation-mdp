package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionesExcepcionesReglasUbicacionRiesgoPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	// @FindBy(id = "botonContinuar")
	private By btnContinuar = By.id("botonContinuar");

	// @FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de
	// suplemento activo para la misma póliza.']")
	// private List<WebElement> lblExistenProjectosSuplementoActivo;

	// @FindBy(xpath = ".//*[text()='AVISO: Existen otros proyectos de
	// suplemento activo para la misma póliza.']")
	private By lblExistenProjectosSuplementoActivo = By.xpath(".//*[text()='AVISO: Existen otros proyectos de suplemento activo para la misma póliza.']");

	// @FindBy(xpath = ".//*[text()='AVISO: El mismo riesgo ya se encuentra
	// asegurado en Mutua de propietarios.']")
	private By lblUbicacionRiesgoYaAsegurada = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");

	// @FindBy(id = "deshabilitacion")
	private By cmbDeshabilitacion = By.id("deshabilitacion");

	// @FindBy(xpath = ".//*[@ng-click='ur.modalBuscador.updateInmueble()' and
	// text()='Añadir inmueble']")
	private By btnAnadirInmuebleReferenciaCatastral = By.xpath(".//*[@ng-click='ur.modalBuscador.updateInmueble()' and text()='Añadir inmueble']");

	private By procesandoWindow = By.cssSelector(".smallbox");
	// *[@id="modalErrores"]/div/div/div[2]/div/div/p

	private By aceptarBtn = By.cssSelector("#modalErrores .modal-footer button");
	// private By aceptar = By.id("modalErrores");
	// endregion
	/*
	 * public ValidacionesExcepcionesReglasUbicacionRiesgoPage(BrowserContext
	 * browserContext) { this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * 
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 */

	public ValidacionesExcepcionesReglasUbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	/*
	 * public void ClickOnContinuarButton() throws IOException {
	 * logger.debug("BEGIN - ClickOnContinuarButton");
	 * this.webDriver.switchToFrame(this.cuerpoFrame);
	 * this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
	 * WebElement returnedWebElementObject =
	 * this.webDriver.waitForTwoWebElementsAndReturnTheOneFound(this.
	 * btnContinuar, this.btnAnadirInmuebleReferenciaCatastral); String
	 * webElemntIdentifyText =
	 * this.webDriver.getTextFromWebElement(returnedWebElementObject);
	 * System.out.println(webElemntIdentifyText); if
	 * (webElemntIdentifyText.equals(MutuaPropietariosConstants.
	 * UbicacionRiesgoConProjectosActivosMsg)) {
	 * this.webDriver.clickOnWebElement(this.btnContinuar); }
	 * this.webDriver.exitFromFrame();
	 * this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
	 * logger.debug("END - ClickOnContinuarButton"); }
	 */

	public void ClickOnContinuarButton() throws IOException {
		debugBegin();
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		if(this.webDriver.isPresent(this.lblExistenProjectosSuplementoActivo)) {
			this.webDriver.click(this.btnContinuar);
		}
		this.webDriver.exitFrame();
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		debugEnd();
	}

	public void isUbicacionRiesgoUtilizada() throws IOException {
		debugBegin();
		// this.webDriver.waitWithDriver(2000);
		this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
		this.webDriver.waitWithDriver(2000);
		// this.webDriver.click(aceptarBtn);

		if(this.webDriver.isPresent(this.lblUbicacionRiesgoYaAsegurada)) {
			this.webDriver.waitForElementToBePresent(this.lblUbicacionRiesgoYaAsegurada);
		}

		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		String webElemntIdentifyText = this.webDriver.getText(cmbDeshabilitacion);
		org.junit.Assert.assertNotEquals(ProjectConstants.UbicacionRiesgoYaUtilizadaError, webElemntIdentifyText, ProjectConstants.UbicacionRiesgoYaUtilizadaMsg);

		// this.webDriver.switchToFrame(this.cuerpoFrame);

		// this.webDriver.exitFrame();
		this.webDriver.exitFrame();
		debugEnd();
	}
	// endregion
}
