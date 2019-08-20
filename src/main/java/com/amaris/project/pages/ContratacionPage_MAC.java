package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import java.awt.AWTException;

import org.openqa.selenium.By;

public class ContratacionPage_MAC extends PageObject {

	public ContratacionPage_MAC(UserStory userS) {
		super(userS);
	}

	// region webelements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By btnContratar = By.cssSelector("#btnContratar");
	//
	// @FindBy(xpath = "//*[@id='VALIDACONTR']")
	private By errorMessage = By.id("VALIDACONTR");

	private By checkLopd = By.cssSelector("#chkLopd");
	//
	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messagePoliza;

	private By messagePoliza = By.xpath("./html/body/table[1]/tbody/tr/td");

	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messageRecibo;

	private By messageRecibo = By.xpath("./html/body/table[1]/tbody/tr/td");

	public void ExecuteActionsInContratacionPage() throws InterruptedException, AWTException {
		debugBegin();
		// Add datos tomador
		new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();

		// Add datos inmueble
		new InmueblePage_MAC(userS).executeActionsInInmueblePage();

		// Add documentacion
		new DocumentacionPage_MAC(userS).addDocumentContratacion();

		// Tick lopd and click contratar
		this.seleccionarCheckYContratar();

		debugEnd();
	}

	public void seleccionarCheckYContratar() {
		debugBegin();

		// Marcar el check
		// this.webDriver.waitWithDriver(6000);
		// if (this.webDriver.isPresentInFrame(this.checkLopd, this.mainFrame))
		// {this.webDriver.clickInFrame(this.checkLopd, this.mainFrame);}

		// Contratar
		this.webDriver.clickInFrame(this.btnContratar, this.mainFrame);
		debugEnd();
	}

	public boolean checkPolizaError() {
		debugBegin();
		boolean res = false;
		if(this.webDriver.isPresentInFrame(this.errorMessage, this.mainFrame) && this.webDriver.getTextInFrame(this.errorMessage, this.mainFrame).contains("¡Error! No se puede emitir la póliza, "
			+ "el proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios para el estudio de viabilidad en el paso anterior "
			+ "y esperar la respuesta vía email o bien en Mis proyectos web")) {
			res = true;
		}

		debugEnd();
		return res;
	}

	public boolean checkPolizaCreada() {
		debugBegin();
		boolean res = false;
		if(this.webDriver.isPresentInFrame(this.messagePoliza, this.mainFrame)
			&& this.webDriver.isPresentInFrame(this.messageRecibo, this.mainFrame)
			&& this.webDriver.getTextInFrame(this.messagePoliza, this.mainFrame).contains("ha sido dada de alta correctamente")
			&& this.webDriver.getTextInFrame(this.messageRecibo, this.mainFrame).contains("se ha generado correctamente")) {
			res = true;
		}

		debugEnd();
		return res;
	}

}
