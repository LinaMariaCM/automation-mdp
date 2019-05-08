package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class SiniestrosConfirmacionPage extends PageObject {

	// REGION CONSTRUCTOR

	public SiniestrosConfirmacionPage(UserStory userS) {
		super(userS);
	}

	// REGION WEBELEMENTS

	private By cuerpoFrame = By.id("mainFrame");

	private By correcto = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > span > strong");

	private By nSiniestro = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(1) > td");

	private By expediente = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(4) > td > div");

	// FOR: TRAMITACION SINIESTRO

	private By tramitarSiniestro = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) > a > strong");

	// REGION METHODS

	public void confirmarSiniestroOK() {
		this.debugBegin();
		System.out.println("###########################\n");
		System.out.println("# Mensaje de confirmacion #\n");
		System.out.println("###########################\n");
		System.out.println("\n");

		if(this.webDriver.isPresent(correcto)) {

			System.out.println("- mensaje: " + this.webDriver.getText(this.correcto));
			System.out.println("\n");
			System.out.println("- " + this.webDriver.getText(this.nSiniestro));
			System.out.println("\n");
			System.out.println("- Expediente generado: " + this.webDriver.getText(this.expediente));

		}

		else System.out.println("Se ha producido un error.");

		System.out.println("\n");
		this.debugEnd();
	}

	public void check() {
		this.debugBegin();
		System.out.println("###########################\n");
		System.out.println("# Mensaje de confirmacion #\n");
		System.out.println("###########################\n");
		System.out.println("\n");

		if(this.webDriver.isPresentInFrame(this.correcto, this.cuerpoFrame)) {
			this.webDriver.switchToFrame(this.cuerpoFrame);

			System.out.println("- mensaje: " + this.webDriver.getText(this.correcto));
			System.out.println("\n");
			System.out.println("- " + this.webDriver.getText(this.nSiniestro));
			System.out.println("\n");
			System.out.println("- Expediente generado: " + this.webDriver.getText(this.expediente));

			this.webDriver.exitFrame();
		}

		else System.out.println("Se ha producido un error.");

		System.out.println("\n");
		this.debugEnd();
	}

	public void tramitarSiniestro() {
		this.debugBegin();
		this.webDriver.clickInFrame(this.tramitarSiniestro, this.cuerpoFrame);
		this.debugEnd();
	}

}
