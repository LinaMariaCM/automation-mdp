package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
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
	// private WebElement errorMessage;

	private By checkLopd = By.cssSelector("#chkLopd");
	//
	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messagePoliza;
	//
	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messageRecibo;
	//
	public void ExecuteActionsInContratacionPage() throws InterruptedException {
		debugBegin();
		// Add datos tomador
		new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();

		// Add datos inmueble
		new InmueblePage_MAC(userS).executeActionsInInmueblePage();

		// Add documentacion
		new DocumentacionPage_MAC(userS).addDocumentContratacion();
        Thread.sleep(10000);
		// Tick lopd and click contratar
		this.seleccionarCheckYContratar();

		debugEnd();
	}

	 public void seleccionarCheckYContratar() {
	 	debugBegin();
	    // Marcar el check
	 	this.webDriver.clickInFrame(this.checkLopd, this.mainFrame);
	 	// Contratar
	 	this.webDriver.clickInFrame(this.btnContratar, this.mainFrame);
	 	debugEnd();
	 }

	// public boolean checkPolizaError()
	// {
	// logger.debug("BEGIN - checkPolizaError");
	// boolean res = false;
	// if (this.wh.webElementInFrameIsPresent(this.errorMessage,
	// this.cuerpoFrame)
	// && this.wh.getTextFromWebElementInFrame(this.errorMessage,
	// this.cuerpoFrame)
	// .contains("¡Error! No se puede emitir la póliza, "
	// + "el proyecto deberá ser revisado por compañía, debe adjuntar los
	// documentos obligatorios para el estudio de viabilidad en el paso anterior
	// "
	// + "y esperar la respuesta vía email o bien en Mis proyectos web"))
	// {
	// res = true;
	// }
	//
	// logger.debug("END - checkPolizaError");
	// return res;
	// }
	//
	// public boolean checkPolizaCreada()
	// {
	// logger.debug("BEGIN - checkPolizaCreada");
	// boolean res = false;
	// if (this.wh.webElementInFrameIsPresent(this.messagePoliza,
	// this.cuerpoFrame)
	// && this.wh.webElementInFrameIsPresent(this.messageRecibo,
	// this.cuerpoFrame)
	// && this.wh.getTextFromWebElementInFrame(this.messagePoliza,
	// this.cuerpoFrame).contains("ha sido dada de alta correctamente")
	// && this.wh.getTextFromWebElementInFrame(this.messageRecibo,
	// this.cuerpoFrame).contains("se ha generado correctamente"))
	// {
	// res = true;
	// }
	//
	// logger.debug("END - checkPolizaCreada");
	// return res;
	// }

}
