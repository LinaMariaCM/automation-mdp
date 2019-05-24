package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.Steps;

import org.openqa.selenium.By;

public class SiniestrosOtrosImplicadosAlta extends PageObject {

	// THE CONSTRUCTOR
	public SiniestrosOtrosImplicadosAlta(UserStory userS) {
		super(userS);
	}

	// REGION WEBELEMENT

	// #### FRAMES ####

	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	//
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	//
	private By btnAnadirNuevoImplicado = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(4) > a > span");
	//
	private By btnVolverAlBuscador = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	//
	private By btnGuardarSalir = By.id("botonGuardar");
	//
	private By btnContinuar = By.id("botonContinuar");
	//
	private By btnModificar = By.cssSelector("#listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(5) > a > span");
	//
	private By btnBorrar = By.cssSelector("##listaImplicados > table.grid.narrowBox > tbody > tr.odd > td:nth-child(6) > a > span");

	// end region

	// REGION METHODS

	/*
	 * public boolean checkImplicadoAdded() {
	 * if(this.webDriver.isClickable(btnModificar) &&
	 * (this.webDriver.isClickable(btnBorrar))) return true; else return false;
	 * }
	 */

	public void clickNuevoImplicado() {
		this.debugBegin();
		this.webDriver.click(this.btnAnadirNuevoImplicado);
		Steps.waitForIt(webDriver);
		this.debugEnd();
	}

	public void clickContinuar() {
		this.debugBegin();
		this.webDriver.click(this.btnContinuar);
		this.debugEnd();
	}

	public void clickGuardarSalir() {
		this.debugBegin();
		this.webDriver.click(btnGuardarSalir);
		this.debugEnd();
	}

}
