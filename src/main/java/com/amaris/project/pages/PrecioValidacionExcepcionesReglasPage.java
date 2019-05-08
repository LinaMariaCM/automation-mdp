package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class PrecioValidacionExcepcionesReglasPage extends PageObject {

	PrecioValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(xpath = ".//*[text()='Continuar']")
	// private WebElement btnContinuar;
	// // endregion
	//
	// public PrecioValidacionExcepcionesReglasPage(
	// BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void ClickOnContinuar()
	// {
	// logger.debug("BEGIN - ClickOnContinuar");
	// this.browserContext.webElementHelper.switchToFrame(this.cuerpoFrame);
	// // this.browserContext.webElementHelper.ScrollToEndOfPage();
	//
	// this.btnContinuar.click();
	//
	// this.browserContext.webElementHelper.exitFromFrame();
	// logger.debug("END - ClickOnContinuar");
	// }
	// // endregion
}
