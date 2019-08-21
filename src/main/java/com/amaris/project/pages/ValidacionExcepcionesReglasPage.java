package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.cssSelector("#botonContinuar");
	private By labelTitulo = By.cssSelector("#formDatos > div.sis-font-l");
	// endregion

	public ValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ValidacionExcepcionesReglasPage clickOnContinuarButton() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public String comprobarNombrePagina() {
		debugBegin();
		
		String titulo = "";

		debugInfo("El 1er valor del título de la página es:" + titulo);
		if(webDriver.isPresent(labelTitulo)) titulo = webDriver.getText(labelTitulo);
		debugInfo("El valor final del título de la página es:" + titulo);
		
		debugEnd();

		return titulo;
	}

	public ValidacionExcepcionesReglasPage ContinuarAltaSiniestro() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}

	// endregion
}
