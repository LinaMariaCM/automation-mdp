package com.amaris.project.pages.productos;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class PrecioValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By continuarBtn = By.xpath(".//*[text()='Continuar']");
	// endregion

	public PrecioValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public PrecioValidacionExcepcionesReglasPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
