package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(name = "botonContinuar")
	// private By btnContinuar = By.name("botonContinuar");

	private By btnContinuar = By.cssSelector("#botonContinuar");

	private By labelTitulo = By.cssSelector("#formDatos > div.sis-font-l");

	// private By btnContinuarAltaSiniestro = By.cssSelector("#botonContinuar");

	// endregion

	// CONSTRUCTOR

	public ValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// REGION METHODS

	public ValidacionExcepcionesReglasPage clickOnContinuarButton() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.scrollToElement(this.btnContinuar);
		// this.webDriver.waitForElementToBeClickable(this.btnContinuar);

		System.out.println("ELEMENTO WEB btnContinuar: " + this.btnContinuar);
		// this.webDriver.waitWithDriver(2500);
		// this.webDriver.scrollToElement(this.btnContinuar);
		// this.webDriver.waitWithDriver(2500);
		this.webDriver.click(this.btnContinuar);

		this.webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public String comprobarNombrePagina() {
		String titulo;
		titulo = "";
		System.out.println("El 1er valor del título de la página es:" + titulo);
		this.debugBegin();
		if(this.webDriver.isPresent(labelTitulo)) titulo = this.webDriver.getText(labelTitulo);
		this.debugEnd();
		System.out.println("El valor final del título de la página es:" + titulo);
		return titulo;
	}

	public void ContinuarAltaSiniestro() {
		this.debugBegin();
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		this.debugEnd();
	}

	public void clickContinuar() {
		this.debugBegin();
		this.webDriver.click(btnContinuar);
		this.debugEnd();
	}

	// endregion
}