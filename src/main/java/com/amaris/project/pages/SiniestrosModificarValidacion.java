package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class SiniestrosModificarValidacion extends PageObject {

	
	// region webelements
	private By cuerpoFrame = By.id("mainFrame");

	// #### LUGAR DE OCURRENCIA ####
	private By nombreAnterior = By.cssSelector("#formDatos > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By nombreNuevo = By.cssSelector("#formDatos > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(3)");
			
	private By botonGrabar = By.id("botonGrabar");

	// endregion

	public SiniestrosModificarValidacion(UserStory userS) {
		super(userS);
	}

	// region methods
	
	public SiniestrosModificarValidacion validar(){
		
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		//System.out.println("nombre1 -> " + webDriver.getText(nombreAnterior));
		//System.out.println("nombre2 -> " + webDriver.getText(nombreNuevo));/

		webDriver.click(botonGrabar);
		
		webDriver.exitFrame();
		
		debugEnd();
		
		return this;
	}
	
	// endregion
}