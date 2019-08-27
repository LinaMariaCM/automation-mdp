package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class PrecioValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");
	// endregion

	public PrecioValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public PrecioValidacionExcepcionesReglasPage ClickOnContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();
		
		return this;
	}
	// endregion
}
