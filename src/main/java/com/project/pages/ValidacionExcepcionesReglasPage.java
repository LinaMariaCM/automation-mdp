package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasPage
{
	final static Logger logger = LoggerFactory.getLogger(ValidacionExcepcionesReglasPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	@FindBy(name = "botonContinuar")
	private WebElement btnContinuar;
	// endregion

	public ValidacionExcepcionesReglasPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();

		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods
	public void clickOnContinuarButton()
	{
		logger.debug("BEGIN - ClickOnContinuarButton");
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuarButton");
	}
	// endregion
}
