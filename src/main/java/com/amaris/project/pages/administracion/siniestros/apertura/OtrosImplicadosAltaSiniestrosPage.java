package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class OtrosImplicadosAltaSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	private By btnAnadirNuevoImplicado = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(4) > a > span");
	private By btnVolverAlBuscador = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By btnGuardarSalir = By.id("botonGuardar");
	private By btnContinuar = By.id("botonContinuar");
	private By btnModificar = By.cssSelector("#listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(5) > a > span");
	private By btnBorrar = By.cssSelector("##listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(6) > a > span");
	// endregion

	public OtrosImplicadosAltaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public OtrosImplicadosAltaSiniestrosPage clickNuevoImplicado() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		// webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.waitWithDriver(9000);
		webDriver.clickInFrame(btnAnadirNuevoImplicado, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}

	public OtrosImplicadosAltaSiniestrosPage clickContinuar() {
		debugBegin();
		webDriver.click(btnContinuar);
		debugEnd();

		return this;
	}

	public OtrosImplicadosAltaSiniestrosPage clickGuardarSalir() {
		debugBegin();
		webDriver.click(btnGuardarSalir);
		debugEnd();

		return this;
	}
	// endregion
}
