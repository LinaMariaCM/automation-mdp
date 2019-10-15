package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class SiniestrosConfirmacionPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	private By correcto = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > span > strong");
	private By nSiniestro = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(1) > td");
	private By expediente = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(4) > td > div");
	private By tramitarSiniestro = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) > a > strong");
	// endregion

	public SiniestrosConfirmacionPage(UserStory userS) {
		super(userS);
	}
	
	// region Methods
	public SiniestrosConfirmacionPage confirmarSiniestroOK() {
		debugBegin();
		
		System.out.println("###########################\n");
		System.out.println("# Mensaje de confirmacion #\n");
		System.out.println("###########################\n\n");

		if(webDriver.isPresent(correcto)) {
			System.out.println("- mensaje: " + webDriver.getText(correcto) + "\n");
			System.out.println("- " + webDriver.getText(nSiniestro) + "\n");
			System.out.println("- Expediente generado: " + webDriver.getText(expediente));
			setTestVar(Constants.NUMERO_SINIESTRO, webDriver.getText(nSiniestro));
		} else {
			System.out.println("Se ha producido un error.");
		}

		System.out.println();
		
		debugEnd();
		
		return this;
	}

	public SiniestrosConfirmacionPage check() {
		debugBegin();
		
		System.out.println("###########################\n");
		System.out.println("# Mensaje de confirmacion #\n");
		System.out.println("###########################\n\n");

		if(webDriver.isPresentInFrame(correcto, cuerpoFrame)) {
			System.out.println("- mensaje: " + webDriver.getTextInFrame(correcto, cuerpoFrame) + "\n");
			System.out.println("- " + webDriver.getTextInFrame(nSiniestro, cuerpoFrame) + "\n");
			System.out.println("- Expediente generado: " + webDriver.getTextInFrame(expediente, cuerpoFrame));
		} else {
			System.out.println("Se ha producido un error.");
		}

		System.out.println();
		
		
		
		debugEnd();
		
		return this;
	}

	public SiniestrosConfirmacionPage tramitarSiniestro() {
		debugBegin();
		webDriver.clickInFrame(tramitarSiniestro, cuerpoFrame);
		debugEnd();
		
		return this;
	}
}
