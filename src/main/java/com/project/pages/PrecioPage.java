package com.project.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class PrecioPage {
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// private String cssFilterSelectedCheckboxes =
	// "input:checked[type=checkbox]";
	// private String xPathFilterClausulaText = "/td[6]";
	// private String xPathFilterClausulaNumber = "/td[4]";

	// @FindBy(xpath = ".//*[contains(text(),'Convertir a proyecto')]")
	// private By btnConvertirAProyecto =
	// By.xpath(".//*[contains(text(),'Convertir a proyecto')]");

	private By btnConvertirAProyecto = By.cssSelector("button[ng-click*='convertToProject']");

	// body > div > div:nth-child(1) > div.container.ng-scope.body-precio > form
	// > div:nth-child(13) > footer > div >
	// button.btn.btn-primary.ng-binding.ng-scope

	// private By btnConvertirAProyecto = By.name("Convertir a proyecto");

	// checkbox of a clausula
	// @FindBy(xpath = ".//tr[td[contains(text(),'Responsabilidad Civil y daños
	// propios causados por
	// aguas comunitarias') and
	// contains(@ng-bind-html,'item.descripcion')]]/td[1]/input")
	// private WebElement chkClausula;

	// @FindBy(css = "input:checked[type=checkbox]")
	// private WebElement chkSelectedCheckboxes;

	// Rows with a checkbox and a clausula
	// @FindBy(xpath = ".//tr[td[input]]")
	private By rowCheckboxWithClausula = By.xpath(".//tr[td[input]]");

	// @FindBy(xpath = ".//*[@class='pagination' and
	// ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	// @FindBy(css = "table.wideBox strong")
	private By msgAvisoSistema = By.cssSelector("table.wideBox strong");

	// @FindBy(id = "logo")
	private By logoMutua = By.cssSelector("#logo");

	// @FindBy(id = "jt2")
	private By productoMec = By.cssSelector("jt2");
	
	private By procesandoWindow = By.cssSelector(".smallbox");
	
	//private By loaderModal = By.cssSelector("#modalLoader");

	// endregion

	public PrecioPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	public void ExecuteActionsInPrecioPage() {

	}

	// region methods
	public void clickOnConvertirAProjecto() {
		logger.debug("BEGIN - ClickOnConvertirAProjecto");
		// this.webDriver.waitWithDriver(5000);
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.clickInFrame(this.btnConvertirAProyecto,
		// this.cuerpoFrame);
		// this.webDriver.waitWithDriver(5000);
		// this.webDriver.exitFrame();
		this.webDriver.waitWithDriver(10000);
		this.webDriver.waitForElementNotToBeClickable(procesandoWindow);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.scrollToBottom();
		this.webDriver.click(this.btnConvertirAProyecto);
		this.webDriver.exitFrame();

		if(this.webDriver.isPresentInFrame(this.msgAvisoSistema, this.cuerpoFrame)) {
			System.out.println("*** Excepción general al convertir a proyecto.");
		}
		logger.debug("END - ClickOnConvertirAProjecto");
	}

}
