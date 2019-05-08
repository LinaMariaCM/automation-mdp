package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class InmueblePage_MAC extends PageObject {

	public InmueblePage_MAC(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	private By mainFrame = By.cssSelector("#mainFrame");
	//
	// @FindBy(xpath = ".//*[@id='capaShowInmueble']/div/div[2]/div/div/button")
	// private WebElement btnAnadirInmueblePantallaPrincipal;
	private By btnAnadirInmueblePantallaPrincipal = By.cssSelector("#botonAddInmueble");
	//
	// @FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir
	// Inmueble']")
	// private WebElement btnAnadirInmueble;

	//
	// @FindBy(xpath = "//*[@id='AnyadirInmu']")
	// private WebElement btnAnadir;
	private By btnAnadirInmuebleModal = By.cssSelector("#AnyadirInmu");
	//
	// @FindBy(name = "provincia")
	// private WebElement txtProvincia;
	private By txtProvincia = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO");
	//
	// @FindBy(name = "poblacion")
	// private WebElement txtPoblacion;
	private By txtPoblacion = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO");
	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_NOMVIA_ARVATO']")
	// private WebElement txtNombreVia;
	private By txtNombreVia = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO");
	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_NUMVIA']")
	// private WebElement txtNumeroVia;
	private By txtNumeroVia = By.cssSelector("#ALTACLIE_BS_NUMVIA");
	//
	// @FindBy(xpath = ".//*[@id='ui-active-menuitem']")
	// private WebElement itemProvincia;
	private By itemProvincia = By.xpath(".//*[@id='ui-active-menuitem']");
	//
	// @FindBy(xpath = ".//*[@id='ui-active-menuitem']")
	// private WebElement itemPoblacion;
	private By itemPoblacion = By.xpath(".//*[@id='ui-active-menuitem']");
	//
	// @FindBy(xpath = ".//*[@id='ui-active-menuitem']")
	// private WebElement itemNomVia;
	private By itemNomVia = By.xpath(".//*[@id='ui-active-menuitem']");

	//
	// public InmueblePage_MAC(BrowserContext browserContext)
	// {
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	public void executeActionsInInmueblePage() throws InterruptedException {
		this.AddInmuebleByAddress();
	}

	public void AddInmuebleByAddress() throws InterruptedException {
		this.webDriver.clickInFrame(this.btnAnadirInmueblePantallaPrincipal, this.mainFrame);
		Thread.sleep(2000);
		this.webDriver.appendTextInFrame(this.txtProvincia, this.mainFrame, String.valueOf(getScenarioVar("provincia_inm")));
		this.webDriver.clickInFrame(this.itemProvincia, this.mainFrame);
		this.webDriver.appendTextInFrame(this.txtPoblacion, this.mainFrame, String.valueOf(getScenarioVar("poblacion_inm")));
		this.webDriver.clickInFrame(this.itemPoblacion, this.mainFrame);
		this.webDriver.appendTextInFrame(this.txtNombreVia, this.mainFrame, String.valueOf(getScenarioVar("nombre_via_inm")));
		this.webDriver.clickInFrame(this.itemNomVia, this.mainFrame);
		this.webDriver.appendTextInFrame(this.txtNumeroVia, this.mainFrame, String.valueOf(getData("fichero_numero_via").getValue(userS.getScenario(), "numero_via_inm")));
		this.webDriver.clickInFrame(this.txtNombreVia, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnadirInmuebleModal, this.mainFrame);
		debugEnd();
	}
}
