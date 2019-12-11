package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresFichaMediadorPage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By tituloPagina = By.cssSelector("h1.titulopagina");
	// endregion

	public MediadoresFichaMediadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public String getContenidoTituloPagina() {
		debugBegin();
		String contenido = webDriver.getTextInFrame(tituloPagina, mainFrame);
		debugEnd();

		return contenido;
	}
	// endregion
}
