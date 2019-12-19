package com.amaris.project.pages.comun;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasConfirmarPoliza extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By continuarBtn = By.name("botonContinuar");
	private By emitirSuplementoBtn = By.xpath(".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']");
	// endregion

	public ValidacionExcepcionesReglasConfirmarPoliza(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ValidacionExcepcionesReglasConfirmarPoliza clickOnContinuarButton() {
		debugBegin();
		
		boolean arePresent = webDriver.waitForElementToBeClickableInFrame(continuarBtn, cuerpoFrame) != null;
		arePresent = arePresent && webDriver.waitForElementToBeClickableInFrame(emitirSuplementoBtn, cuerpoFrame) != null;

		if(arePresent) {
			webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}
	// endregion
}