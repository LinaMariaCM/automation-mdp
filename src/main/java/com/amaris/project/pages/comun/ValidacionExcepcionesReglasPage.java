package com.amaris.project.pages.comun;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class ValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.id("mainFrame");

	private By continuarBtn = By.cssSelector("#botonContinuar");
	private By tituloTxt = By.xpath("//*[@id='formDatos']/div[3]");
	// endregion

	public ValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ValidacionExcepcionesReglasPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public String comprobarNombrePagina() {
		debugBegin();

		String titulo = "No encontrado";
		ActionSteps.waitForIt(webDriver);
		
		if(webDriver.isPresentInFrame(tituloTxt, cuerpoFrame)) {
			titulo = webDriver.getTextInFrame(tituloTxt, cuerpoFrame);
		}

		debugInfo("El valor del título de la página es: " + titulo);

		debugEnd();

		return titulo;
	}

	public ValidacionExcepcionesReglasPage comprobarPaginaModificacion() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		
		webDriver.switchToFrame(cuerpoFrame);
		
		if(webDriver.isPresent(tituloTxt)) {
			debugInfo("Esta presente el titulo");
			webDriver.waitForElementToBeClickable(continuarBtn);
			
			if(webDriver.getText(tituloTxt).contains("excepciones")) {
				webDriver.click(continuarBtn);
			}
		} else {
			debugInfo("NO está presente el título");
		}
		
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	// endregion
}
