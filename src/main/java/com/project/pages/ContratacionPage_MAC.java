package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

public class ContratacionPage_MAC extends PageObject {

	public ContratacionPage_MAC(UserStory userS) {
		super(userS);
	}
	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(xpath = ".//*[text()='Contratar']")
	// // @FindBy(id = "btnContratar")
	// private WebElement btnContratar;
	//
	// @FindBy(xpath = "//*[@id='VALIDACONTR']")
	// private WebElement errorMessage;
	//
	// @FindBy(id = "chkLopd")
	// private WebElement checkLopd;
	//
	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messagePoliza;
	//
	// @FindBy(xpath = "./html/body/table[1]/tbody/tr/td")
	// private WebElement messageRecibo;
	//
	// public void ExecuteActionsInContratacionPage() throws
	// InterruptedException, IOException
	// {
	// // Add datos tomador
	// TomadorYAseguradoPage_MAC tomadorYAseguradoPage_MAC = new
	// TomadorYAseguradoPage_MAC(this.browserContext);
	// tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
	//
	// // Add datos inmueble
	// InmueblePage_MAC inmueblePage_MAC = new
	// InmueblePage_MAC(this.browserContext);
	// inmueblePage_MAC.executeActionsInInmueblePage();
	//
	// // Add documentacion
	//
	// // Click btn contratar
	// // this.wh.clickOnWebElementInFrame(this.btnContratar, this.cuerpoFrame);
	// this.wh.clickOnWebElement(this.btnContratar);
	//
	// }
	//
	// public void seleccionarCheckYContratar() throws InterruptedException,
	// IOException
	// {
	// logger.debug("BEGIN - seleccionarCheckYContratar");
	// // Marcar el check
	// this.wh.clickOnWebElementInFrame(this.checkLopd, this.cuerpoFrame);
	// // Contratar
	// this.wh.clickOnWebElementInFrame(this.btnContratar, this.cuerpoFrame);
	// logger.debug("END - seleccionarCheckYContratar");
	// }
	//
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
