package com.project.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
/*
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/

public class InnovaHomePage {

	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements

	// @FindBy (id = "leftFrame")
	// private WebElement menuFrame;

	private By menuFrame = By.cssSelector("#leftFrame");

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
	private By btnNuevaSimulaion = By.xpath(".//*[normalize-space(text())='Nueva Simulación']");

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
	private By btnGestionAutorizaciones = By.cssSelector("#Gestión de autorizaciones");

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

	public InnovaHomePage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public void CreateNewProject() {
		logger.debug("BEGIN - CreateNewProject");
		this.webDriver.doubleClickInFrame(this.btnNuevoProjecto, this.menuFrame);
		logger.debug("END - CreateNewProject");
	}

	public void createNewSimulation() {
		logger.debug("BEGIN - CreateNewSimulation");
		this.webDriver.doubleClickInFrame(this.btnNuevaSimulaion, this.menuFrame);
		logger.debug("END - CreateNewSimulation");
	}

	public void openMutuaEdificioConfort() {
		logger.debug("BEGIN - OpenMutuaEdificioConfort");
		this.webDriver.moveToElementInFrame(this.btnMutuaEdificioConfort, this.menuFrame);
		this.webDriver.doubleClickInFrame(this.btnMutuaEdificioConfort, this.menuFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		logger.debug("END - OpenMutuaEdificioConfort");
	}

	public void OpenMutuaAlquilerConfort() {
		logger.debug("BEGIN - OpenMutuaAlquilerConfort");
		this.webDriver.moveToElementInFrame(this.btnMutuaAlquilerConfort, this.menuFrame);
		this.webDriver.doubleClickInFrame(this.btnMutuaAlquilerConfort, this.menuFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		logger.debug("END - OpenMutuaAlquilerConfort");
	}

	public void OpenGestionCotizaciones() {
		logger.debug("BEGIN - OpenGestionCotizaciones");
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
		logger.debug("END - OpenGestionCotizaciones");
	}

	public void OpenGestionPolizas() {
		logger.debug("BEGIN - OpenGestionPolizas");
		// this.webDriver.doubleClickInFrame(this.btnMapaSitio, this.topFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		this.webDriver.clickInFrame(this.btnMapaSitio, this.topFrame);
		this.webDriver.clickInFrame(this.btnGestionPolizas, this.mainFrame);
		// this.webDriver.clickInFrame(this.btnGestionPolizasMenu,
		// this.menuFrame);
		logger.debug("END - OpenGestionPolizas");
	}

	public void OpenGestionAutorizaciones() {
		logger.debug("BEGIN - OpenGestionAutorizaciones");
		this.webDriver.doubleClickInFrame(this.btnGestionAutorizaciones, this.menuFrame);
		logger.debug("END - OpenGestionAutorizaciones");
	}

	public void openMenuMEC() {
		logger.debug("BEGIN - OpenGestionAutorizaciones");
		this.webDriver.doubleClickInFrame(this.btnMenuMEC, this.menuFrame);
		logger.debug("END - OpenGestionAutorizaciones");
	}

	public void openInnovaHome() {
		logger.debug("BEGIN - openInnovaHome");
		// this.webDriver.doubleClickInFrame(this.btnMenuPrincipal,
		// this.menuFrame);
		// this.webDriver.moveToElementInFrameWithJavaScript(this.btnMenuPrincipal,
		// this.menuFrame);
		this.webDriver.clickInFrame(this.btnMenuPrincipal, this.menuFrame);
		logger.debug("END - openInnovaHome");
	}

	public void openSiniestros() {
		logger.debug("BEGIN - openSiniestros");
		this.webDriver.doubleClickInFrame(this.btnSiniestros, this.menuFrame);
		logger.debug("END - openSineistros");
	}

	public void openMediadores() {
		logger.debug("BEGIN - openMediadores");
		this.webDriver.doubleClickInFrame(this.btnMediadores, this.menuFrame);
		logger.debug("END - openMediadores");
	}
	// endregion
}
