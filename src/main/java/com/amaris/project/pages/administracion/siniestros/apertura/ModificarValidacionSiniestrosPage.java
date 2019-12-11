package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class ModificarValidacionSiniestrosPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.id("mainFrame");

	// #### LUGAR DE OCURRENCIA ####
	private By nombreAnterior = By.cssSelector("#formDatos > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By nombreNuevo = By.cssSelector("#formDatos > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(3)");

	private By botonGrabar = By.id("botonGrabar");

	// endregion

	public ModificarValidacionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public ModificarValidacionSiniestrosPage validar() {

		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		// System.out.println("nombre1 -> " + webDriver.getText(nombreAnterior));
		// System.out.println("nombre2 -> " + webDriver.getText(nombreNuevo));/

		webDriver.click(botonGrabar);

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	// endregion
}