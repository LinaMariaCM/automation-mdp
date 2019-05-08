package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionPolizasDocumentosPage extends PageObject {

	GestionPolizasDocumentosPage(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(xpath = ".//*[contains(text(),'Suplemento de póliza') and
	// contains(text(),'ha sido emitido correctamente.')]")
	// private WebElement lblSuplementoCreationConfirmationMessage;
	//
	// // endregion
	//
	// public GestionPolizasDocumentosPage(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// public void CheckConfirmationMessage()
	// {
	// this.wh.switchToFrame(this.cuerpoFrame);
	// Assert.assertTrue("El mensaje de confirmación de que el suplemento se ha
	// emitido correctamente no ha aparecido",
	// this.lblSuplementoCreationConfirmationMessage.isDisplayed());
	// }
}
