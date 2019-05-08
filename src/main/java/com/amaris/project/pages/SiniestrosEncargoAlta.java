package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.Steps;

import org.openqa.selenium.By;

public class SiniestrosEncargoAlta extends PageObject {

	// THE CONSTRUCTOR
	public SiniestrosEncargoAlta(UserStory userS) {
		super(userS);
	}

	// REGION WEBELEMENT

	// #### FRAMES ####

	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	//
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	//
	private By btnAnadirNuevoEncargo = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(4) > a > span");
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

	public boolean checkEncargoAdded() {
		if(this.webDriver.isClickable(btnModificar) && (this.webDriver.isClickable(btnBorrar))) return true;
		else return false;
	}

	public void clickNuevoEncargo() {
		this.debugBegin();
		this.webDriver.click(this.btnAnadirNuevoEncargo);
		Steps.waitForIt(webDriver);
		this.debugEnd();
	}

	public void clickContinuar() {
		this.debugBegin();
		this.webDriver.click(this.btnContinuar);
		Steps.waitForIt(webDriver);
		this.debugEnd();
	}

	public void clickGuardarSalir() {
		this.debugBegin();
		this.webDriver.click(btnGuardarSalir);
		this.debugEnd();
	}

}
