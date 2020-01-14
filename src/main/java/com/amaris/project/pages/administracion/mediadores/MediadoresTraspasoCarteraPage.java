package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;


public class MediadoresTraspasoCarteraPage extends PageObject{

	//region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By fechaEfectoInput = By.cssSelector("#TRAS_CAR_FECHA_EFECTO");
	private By mediadorOrigenInput = By.cssSelector("#TRAS_CAR_MEDIADOR_ORIGEN");
	private By mediadorDestinoInput = By.cssSelector("#TRAS_CAR_MEDIADOR_DESTINO");

	private By generarComunicacionesTomadoresBtn = By.cssSelector("#TRAS_CAR_CHECK_MENSAJES");
	private By traspasarBtn = By.cssSelector("#formTraspasoCartera > div > div > div.sis-frame-bg > table > tbody > tr:nth-child(4) > td:nth-child(1) > input");
	// endregion

	public MediadoresTraspasoCarteraPage(UserStory userS) {
		super(userS);
	}

	public MediadoresTraspasoCarteraPage clickTraspasar() {

		debugBegin();
		webDriver.clickInFrame(traspasarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
}
