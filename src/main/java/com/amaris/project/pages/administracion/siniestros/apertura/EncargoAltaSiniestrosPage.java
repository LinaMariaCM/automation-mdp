package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class EncargoAltaSiniestrosPage extends PageObject {

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By anotacionesBtn = By.cssSelector("#enlaceDialogo > span");
	private By anadirNuevoEncargoBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(4) > a > span");
	private By volverAlBuscadorBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By guardarSalirBtn = By.id("botonGuardar");
	private By continuarBtn = By.id("botonContinuar");
	private By modificarBtn = By.cssSelector("#listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(5) > a > span");
	private By borrarBtn = By.cssSelector("##listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(6) > a > span");
	// end region

	public EncargoAltaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public boolean checkEncargoAdded() {
		debugBegin();

		boolean result = false;

		if(webDriver.isClickable(modificarBtn) && (webDriver.isClickable(borrarBtn))) {
			result = true;
		}

		debugEnd();

		return result;
	}

	public EncargoAltaSiniestrosPage clickNuevoEncargo() {
		debugBegin();
		webDriver.waitWithDriver(8000);
		webDriver.click(anadirNuevoEncargoBtn);
		ActionSteps.waitForIt(webDriver);
		debugEnd();

		return this;
	}

	public EncargoAltaSiniestrosPage clickContinuar() {
		debugBegin();
		webDriver.click(continuarBtn);
		// ActionSteps.waitForIt(webDriver);
		webDriver.exitFrame();
		webDriver.waitWithDriver(7000);
		debugEnd();

		return this;
	}

	public EncargoAltaSiniestrosPage clickGuardarSalir() {
		debugBegin();
		webDriver.click(guardarSalirBtn);
		debugEnd();

		return this;
	}
	// endregion
}
