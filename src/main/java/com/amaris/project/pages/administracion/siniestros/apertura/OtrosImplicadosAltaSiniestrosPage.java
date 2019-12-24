package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class OtrosImplicadosAltaSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By anotacionesBtn = By.cssSelector("#enlaceDialogo > span");
	private By anyadirNuevoImplicadoBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(4) > a > span");
	private By volverAlBuscadorBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By guardarSalirBtn = By.id("botonGuardar");
	private By continuarBtn = By.id("botonContinuar");
	private By modificarBtn = By.cssSelector("#listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(5) > a > span");
	private By borrarBtn = By.cssSelector("##listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(6) > a > span");
	// endregion

	public OtrosImplicadosAltaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public OtrosImplicadosAltaSiniestrosPage clickNuevoImplicado() {
		debugBegin();
		
		webDriver.waitWithDriver(10000);
		webDriver.clickInFrame(anyadirNuevoImplicadoBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}

	public OtrosImplicadosAltaSiniestrosPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public OtrosImplicadosAltaSiniestrosPage clickGuardarSalir() {
		debugBegin();
		webDriver.clickInFrame(guardarSalirBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
