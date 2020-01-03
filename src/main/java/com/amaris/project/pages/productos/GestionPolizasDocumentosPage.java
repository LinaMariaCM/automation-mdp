package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionPolizasDocumentosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");
	private By suplementoCreationConfirmationMessageTxt = By.xpath(".//*[contains(text(),'Suplemento de póliza') and contains(text(),'ha sido emitido correctamente.')]");
	// endregion

	public GestionPolizasDocumentosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public GestionPolizasDocumentosPage checkConfirmationMessage() {
		// isDisplayed
		Assert.assertTrue(webDriver.isPresentInFrame(suplementoCreationConfirmationMessageTxt, cuerpoFrame), 
			"El mensaje de confirmación de que el suplemento se ha emitido correctamente no ha aparecido");

		return this;
	}
	// endregion
}
