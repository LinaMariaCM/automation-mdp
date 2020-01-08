package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;


public class MediadoresTraspasoCarteraPage extends PageObject{

	//region WebElements
	private By cuerpoFrame = By.id("mainFrame");
	private By menuFrame = By.id("leftFrame");

	private By fechaEfectoInput = By.id("TRAS_CAR_FECHA_EFECTO");
	private By mediadorOrigenInput = By.id("TRAS_CAR_MEDIADOR_ORIGEN");
	private By mediadorDestinoInput = By.id("TRAS_CAR_MEDIADOR_DESTINO");

	private By generarComunicacionesTomadoresBtn = By.id("TRAS_CAR_CHECK_MENSAJES");
	private By traspasarBtn = By.name("botonTraspasar");
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
