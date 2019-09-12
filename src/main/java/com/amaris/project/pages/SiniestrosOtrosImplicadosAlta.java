package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class SiniestrosOtrosImplicadosAlta extends PageObject {

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

	public SiniestrosOtrosImplicadosAlta(UserStory userS) {
		super(userS);
	}

	// region Methods
	public SiniestrosOtrosImplicadosAlta clickNuevoImplicado() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.clickInFrame(btnAnadirNuevoImplicado, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		
		debugEnd();
		
		return this;
	}

	public SiniestrosOtrosImplicadosAlta clickContinuar() {
		debugBegin();
		webDriver.click(btnContinuar);
		debugEnd();
		
		return this;
	}

	public SiniestrosOtrosImplicadosAlta clickGuardarSalir() {
		debugBegin();
		webDriver.click(btnGuardarSalir);
		debugEnd();
		
		return this;
	}
	// endregion
}
