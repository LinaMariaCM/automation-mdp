package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionPolizasDocumentosPage
{
//	final static Logger logger = LoggerFactory.getLogger(DatosBancariosPage.class);
//	BrowserContext browserContext;
//	private WebElementHelper wh;
//	TestCaseData tData;
//
//	// region webelements
//	@FindBy(name = "cuerpo")
//	private WebElement cuerpoFrame;
//
//	@FindBy(xpath = ".//*[contains(text(),'Suplemento de póliza') and contains(text(),'ha sido emitido correctamente.')]")
//	private WebElement lblSuplementoCreationConfirmationMessage;
//
//	// endregion
//
//	public GestionPolizasDocumentosPage(BrowserContext browserContext)
//	{
//		this.browserContext = browserContext;
//		this.wh = browserContext.webElementHelper;
//		this.tData = browserContext.getTestCaseData();
//		PageFactory.initElements(browserContext.getWebDriver(), this);
//	}
//
//	public void CheckConfirmationMessage()
//	{
//		this.wh.switchToFrame(this.cuerpoFrame);
//		Assert.assertTrue("El mensaje de confirmación de que el suplemento se ha emitido correctamente no ha aparecido",
//				this.lblSuplementoCreationConfirmationMessage.isDisplayed());
//	}
}
