package com.project.pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

import com.automation.model.webdriver.DriverHelper;
import com.automation.model.testing.TestDataManager;

public class AvisoSistemaPage {

	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.xpath(".//*[text()='Volver']");

	private By msgAvisoPlantasAlto = By.xpath("./html/body/table");
	// endregion

	/*
	 * public AvisoSistemaPage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 * 
	 */

	public AvisoSistemaPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public void CheckmsgAvisoPlantasAlto() {
		logger.debug("BEGIN - CheckmsgAvisoPlantasAlto");
		this.webDriver.switchToFrame(this.cuerpoFrame);
		String mensaje = this.webDriver.getText(this.msgAvisoPlantasAlto);
		Assert.assertTrue(mensaje.contains("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía."));
		this.webDriver.exitFrame();

		logger.debug("END - CheckmsgAvisoPlantasAlto");
	}

	public void ClikOnVolver() {
		logger.debug("BEGIN - ClikOnVolver");
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();
		logger.debug("END - ClikOnVolver");
	}
	// endregion
}
