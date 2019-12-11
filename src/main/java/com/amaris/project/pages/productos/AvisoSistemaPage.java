package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class AvisoSistemaPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By btnContinuar = By.xpath(".//*[text()='Volver']");
	private By msgAvisoPlantasAlto = By.xpath("./html/body/table");
	// endregion

	public AvisoSistemaPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AvisoSistemaPage checkmsgAvisoPlantasAlto() {
		debugBegin();

		this.webDriver.switchToFrame(this.cuerpoFrame);
		String mensaje = this.webDriver.getText(this.msgAvisoPlantasAlto);
		Assert.assertTrue(mensaje.contains("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía."));
		this.webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public AvisoSistemaPage clikOnVolver() {
		debugBegin();

		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();

		debugEnd();

		return this;
	}
	// endregion
}
