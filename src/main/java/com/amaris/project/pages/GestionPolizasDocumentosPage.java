package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionPolizasDocumentosPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By lblSuplementoCreationConfirmationMessage = By.xpath(".//*[contains(text(),'Suplemento de póliza') and contains(text(),'ha sido emitido correctamente.')]");
	// endregion

	GestionPolizasDocumentosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public GestionPolizasDocumentosPage CheckConfirmationMessage() {
		// isDisplayed
		Assert.assertTrue(webDriver.isPresent(lblSuplementoCreationConfirmationMessage),
			"El mensaje de confirmación de que el suplemento se ha emitido correctamente no ha aparecido");

		return this;
	}
	// endregion
}
