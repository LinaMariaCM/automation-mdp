package com.project.pages;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

public class InnovaHomePage extends PageObject {

	// region webelements
	// @FindBy (id = "leftFrame")
	// private WebElement menuFrame;

	private By leftFrame = By.cssSelector("#leftFrame");

	// //@FindBy (id = "topFrame")
	private By topFrame = By.cssSelector("#topFrame");

	// @FindBy (id = "mainFrame")
	// @FindBy (css = "body > div:nth-child(2) > div.centro > div.cuerpo >
	// #mainFrame")
	private By mainFrame = By.cssSelector("#mainFrame");

	// @FindBy (id = "jt2")
	private By btnMutuaEdificioConfort = By.cssSelector("#jt2");

	// @FindBy (id = "jt3")
	private By btnMutuaAlquilerConfort = By.cssSelector("#jt3");

	// @FindBy (id = "jt5")
	private By btnGestionProjectosSimulaciones = By.cssSelector("#jt5");

	// @FindBy (xpath = ".//*[text()='Siniestros']")
	private By btnSiniestros = By.xpath(".//*[text()='Siniestros']");

	// @FindBy (xpath = ".//*[normalize-space(text())='Nuevo proyecto']")
	private By btnNuevoProjecto = By.xpath(".//*[normalize-space(text())='Nuevo proyecto']");

	// @FindBy (xpath = ".//*[normalize-space(text())='Nueva Simulación']")
	private By btnNuevaSimulacion = By.xpath(".//*[normalize-space(text())='Nueva Simulación']");

	// @FindBy (id = "boton1")
	private By btnMenuPrincipal = By.cssSelector("#boton1");

	// @FindBy (xpath = ".//*[text()='Gestión de proyecto/simulación']")
	private By btnGestionProjectoSimulacion = By.xpath(".//*[text()='Gestión de proyecto/simulación']");

	// @FindBy (xpath = ".//*[contains(text(),'Mapa del sitio')]")
	private By btnMapaSitio = By.xpath(".//*[contains(text(),'Mapa del sitio')]");

	// @FindBy (xpath = ".//*[text()='Gestión de cotizaciones']")
	private By btnGestionCotizaciones = By.xpath(".//*[text()='Gestión de cotizaciones']");

	// //@FindBy (xpath = ".//*[@title='Gestión de pólizas']")
	// @FindBy (css = "#mapa > div:nth-child(8) > ul:nth-child(8) > li > a")
	private By btnGestionPolizas = By.xpath(".//*[@title='Gestión de pólizas']");

	// @FindBy (id = "jt13")
	private By btnGestionPolizasMenu = By.cssSelector("#jt13");

	// @FindBy (css = "[title*='Gestión de autorizaciones']")
	private By btnGestionAutorizaciones = By.cssSelector("#jt16");

	// @FindBy (xpath = ".//*[contains(text(),'Mediadores')]")
	private By btnMediadores = By.xpath(".//*[contains(text(),'Mediadores')]");

	// @FindBy (id = "boton2")
	private By btnMenuMEC = By.cssSelector("#boton2");
	// endregion

	/*
	 * public InnovaHomePage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 */

	public InnovaHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void openNewProjectMec() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnNuevoProjecto, this.leftFrame);
		debugEnd();
	}

	public void openNewSimulationMec() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnNuevaSimulacion, this.leftFrame);
		debugEnd();
	}

	public void openMutuaEdificioConfort() {
		debugBegin();
		this.webDriver.moveToElementInFrame(this.btnMutuaEdificioConfort, this.leftFrame);
		this.webDriver.doubleClickInFrame(this.btnMutuaEdificioConfort, this.leftFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		debugEnd();
	}

	public void OpenMutuaAlquilerConfort() {
		debugBegin();
		this.webDriver.moveToElementInFrame(this.btnMutuaAlquilerConfort, this.leftFrame);
		this.webDriver.doubleClickInFrame(this.btnMutuaAlquilerConfort, this.leftFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		debugEnd();
	}

	public void openGestionCotizaciones() {
		debugBegin();
		// La siguiente linea de codigo siempre ha sido comentado.
		// this.webDriver.moveToElementInFrameWithJavaScript(this.btnMapaSitio,
		// this.menuFrame);

		// Añado esto.
		this.webDriver.clickInFrame(this.btnMapaSitio, this.topFrame);
		this.webDriver.clickInFrame(this.btnGestionCotizaciones, this.mainFrame);

		// Codigo original que he comentado.
		// this.webDriver.doubleClickInFrame(this.btnMapaSitio, this.topFrame);
		// this.webDriver.doubleClickInFrame(this.btnGestionCotizaciones,
		// this.mainFrame);
		debugEnd();
	}

	public void OpenGestionPolizas() {
		debugBegin();
		// this.webDriver.doubleClickInFrame(this.btnMapaSitio, this.topFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		this.webDriver.clickInFrame(this.btnMapaSitio, this.topFrame);
		this.webDriver.clickInFrame(this.btnGestionPolizas, this.mainFrame);
		// this.webDriver.clickInFrame(this.btnGestionPolizasMenu,
		// this.menuFrame);
		debugEnd();
	}

	public void OpenGestionAutorizaciones() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnGestionAutorizaciones, this.leftFrame);
		debugEnd();
	}

	public void openMenuMEC() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnMenuMEC, this.leftFrame);
		debugEnd();
	}

	public void openInnovaHome() {
		debugBegin();
		// this.webDriver.doubleClickInFrame(this.btnMenuPrincipal,
		// this.menuFrame);
		// this.webDriver.moveToElementInFrameWithJavaScript(this.btnMenuPrincipal,
		// this.menuFrame);
		this.webDriver.clickInFrame(this.btnMenuPrincipal, this.leftFrame);
		debugEnd();
	}

	public void openSiniestros() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnSiniestros, this.leftFrame);
		debugEnd();
	}

	public void openMediadores() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnMediadores, this.leftFrame);
		debugEnd();
	}
	// endregion
}
