package com.project.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasPage {
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(name = "botonContinuar")
	private By btnContinuar = By.name("botonContinuar");
	// endregion

	public ValidacionExcepcionesReglasPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public ValidacionExcepcionesReglasPage clickOnContinuarButton() {
		logger.debug("BEGIN - ClickOnContinuarButton");
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuarButton");

		return this;
	}
	// endregion
}
