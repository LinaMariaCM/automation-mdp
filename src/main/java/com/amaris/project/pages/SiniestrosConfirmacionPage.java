package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class SiniestrosConfirmacionPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	private By correcto = By.cssSelector("#form1 .marco span.normal strong");
	
	//private By correcto = By.cssSelector(".normal > strong:nth-child(1)");
	//private By nSiniestro = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(1) > td");
	private By nSiniestro = By.cssSelector("#form1 .marco > table tr > td");
		
	private By expediente = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(4) > td > div");
	//private By tramitarSiniestro = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) > a > strong");
	private By tramitarSiniestro = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) > a");
	private By mensajeOK = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr > td > span > strong");
	private By volver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li > a > span");
	
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
		webDriver.waitWithDriver(6000);
		if(webDriver.isPresentInFrame(correcto, cuerpoFrame)) {
			System.out.println("- mensaje: " + webDriver.getTextInFrame(correcto,cuerpoFrame) + "\n");
			System.out.println("- " + webDriver.getTextInFrame(nSiniestro, cuerpoFrame) + "\n");
					
			System.out.println("- Expediente generado: " + webDriver.getTextInFrame(expediente, cuerpoFrame));
			setTestVar(Constants.NUMERO_SINIESTRO, webDriver.getTextInFrame(nSiniestro, cuerpoFrame));
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
		// Need refactor By elements
		if(webDriver.isPresent(correcto)) {
			System.out.println("- mensaje: " + webDriver.getText(correcto) + "\n");
			System.out.println("- " + webDriver.getText(nSiniestro) + "\n");
			
			setTestVar(Constants.NUMERO_SINIESTRO, webDriver.getText(nSiniestro));
			
			System.out.println("- Expediente generado: " + webDriver.getText(expediente));
		} else {
			System.out.println("Se ha producido un error.");
		}

		System.out.println();
		
		
		
		debugEnd();
		
		return this;
	}

	public SiniestrosConfirmacionPage tramitarSiniestro() {
		debugBegin();
		//webDriver.clickInFrame(tramitarSiniestro, cuerpoFrame);
		webDriver.click(tramitarSiniestro);
		debugEnd();
		
		return this;
	}
	
	public SiniestrosConfirmacionPage confirmaModificacion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.getText(mensajeOK).contains("El siniestro ha sido modificado correctamente")) {
			System.out.println("Modificación de siniestro correcta");
			webDriver.click(volver);
		}

		webDriver.exitFrame();
		debugEnd();
		
		return this;
	}
}
