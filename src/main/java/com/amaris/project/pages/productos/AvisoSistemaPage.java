package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class AvisoSistemaPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By continuarBtn = By.xpath(".//*[text()='Volver']");
	private By msgAvisoPlantasAltoTxt = By.xpath("./html/body/table");
	// endregion

	public AvisoSistemaPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AvisoSistemaPage checkmsgAvisoPlantasAlto() {
		debugBegin();

		String mensaje = this.webDriver.getTextInFrame(msgAvisoPlantasAltoTxt, cuerpoFrame);
		Assert.assertTrue(mensaje.contains("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía."));

		debugEnd();

		return this;
	}

	public AvisoSistemaPage clikVolver() {
		debugBegin();
		this.webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
