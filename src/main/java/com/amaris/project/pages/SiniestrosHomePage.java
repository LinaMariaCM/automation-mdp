package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.Steps;

public class SiniestrosHomePage extends PageObject {

	// region WebElements
	private By menuFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By mainFrame = By.id("mainFrame");

	private By btnAperturaAlta = By.id("jt2");
	private By btnAperturaModificar = By.id("jt3");
	private By btnGestionSiniestros = By.id("jt5");
	private By btnGestionPagos = By.id("jt6");
	private By btnAltaEvento = By.id("jt8");
	private By btnGestionEventos = By.id("jt9");
	// endregion

	public SiniestrosHomePage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public SiniestrosHomePage openAperturaAlta() {
		debugBegin();
		webDriver.clickInFrame(btnAperturaAlta, menuFrame);
		Steps.waitForIt(webDriver);
		debugEnd();
		
		return this;
	}

	public SiniestrosHomePage openAperturaModificar() {
		debugBegin();
		webDriver.clickInFrame(btnAperturaModificar, menuFrame);
		debugEnd();
		
		return this;
	}

	public SiniestrosHomePage openGestionSiniestros() {
		debugBegin();
		webDriver.doubleClickInFrame(btnGestionSiniestros, menuFrame);
		debugEnd();
		
		return this;
	}

	public SiniestrosHomePage openAltaEvento() {
		debugBegin();
		webDriver.doubleClickInFrame(btnAltaEvento, menuFrame);
		debugEnd();
		
		return this;
	}

	public SiniestrosHomePage openGestionEventos() {
		debugBegin();
		webDriver.doubleClickInFrame(btnGestionEventos, menuFrame);
		debugEnd();
		
		return this;
	}
	// endregion
}
