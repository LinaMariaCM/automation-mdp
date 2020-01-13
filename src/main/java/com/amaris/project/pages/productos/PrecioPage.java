package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class PrecioPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By convertirAProyectoBtn = By.cssSelector("button[ng-click*='convertToProject']");
	private By msgAvisoSistemaTxt = By.cssSelector("table.wideBox strong");
	private By procesandoModal = By.cssSelector("div[class*='processing'] div[class*='Processing'] .textProcessing");
	// endregion

	public PrecioPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public PrecioPage waitProcesando() {
		debugBegin();

		debugInfo("Se espera al mensaje \"procesando\"");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesandoModal)) {
			debugInfo("Se muestra mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		debugEnd();

		return this;
	}

	public PrecioPage clickConvertirAProjecto() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(convertirAProyectoBtn, cuerpoFrame);

		if(webDriver.isPresentInFrame(msgAvisoSistemaTxt, cuerpoFrame)) {
			debugInfo("Excepción general al convertir a proyecto.");
		}

		debugEnd();

		return this;
	}
}