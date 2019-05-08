package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineComunicarSiniestrosPage extends PageObject {

	GestionOnlineComunicarSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(id = "blockrandom")
	// private WebElement frameAppMainWindow;
	//
	// @FindBy(id = "topFrame")
	// private WebElement topFrame;
	//
	// @FindBy(id = "leftFrame")
	// private WebElement frameLeftFrame;
	//
	// @FindBy(id = "mainFrame")
	// private WebElement mainFrame;
	//
	// @FindBy(name = "iframe")
	// private WebElement contenidoFrame;
	//
	// @FindBy(id = "numpol")
	// private WebElement txtPoliza;
	//
	// @FindBy(id = "fsin")
	// private WebElement txtFechaSiniestro;
	//
	// @FindBy(id = "selcausa")
	// private WebElement drpdwnCausa;
	//
	// @FindBy(id = "causa")
	// private WebElement txtDescripcionSiniestro;
	//
	// @FindBy(id = "coste")
	// private WebElement txtCosteAprox;
	//
	// @FindBy(id = "selrol_1")
	// private WebElement drpdwnRol;
	//
	// @FindBy(id = "contnombre_1")
	// private WebElement txtContactoNombre;
	//
	// @FindBy(id = "contapellido_1")
	// private WebElement txtContactoApellido1;
	//
	// @FindBy(id = "conttel_1")
	// private WebElement txtContactoTelefono1;
	//
	// // endregion
	//
	// public GestionOnlineComunicarSiniestrosPage(BrowserContext
	// browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void writeNumeroPoliza(
	// String numPoliza)
	// {
	// logger.debug("BEGIN - writeNumeroPoliza");
	// this.wh.sendValueToWebElementInFrame(this.txtPoliza, this.contenidoFrame,
	// numPoliza);
	// logger.debug("END - writeNumeroPoliza");
	// }
	//
	// public void selectFechaSiniestro(
	// String fechaSiniestro)
	// {
	// logger.debug("BEGIN - selectFechaSiniestro");
	// this.wh.sendValueToWebElementInFrame(this.txtFechaSiniestro,
	// this.contenidoFrame, fechaSiniestro);
	// logger.debug("END - selectFechaSiniestro");
	// }
	//
	// public void selectCausa(
	// String causa)
	// {
	// logger.debug("BEGIN - selectCausa");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnCausa,
	// this.contenidoFrame, causa);
	// logger.debug("END - selectCausa");
	// }
	//
	// public void writeDescripcionSiniestro(
	// String descripcion)
	// {
	// logger.debug("BEGIN - writeDescripcionSiniestro");
	// this.wh.sendValueToWebElementInFrame(this.txtDescripcionSiniestro,
	// this.contenidoFrame, descripcion);
	// logger.debug("END - writeDescripcionSiniestro");
	// }
	//
	// public void selectRolPersonaContacto(
	// String rolPersonaContacto)
	// {
	// logger.debug("BEGIN - selectRolPersonaContacto");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnRol, this.contenidoFrame,
	// rolPersonaContacto);
	// logger.debug("END - selectRolPersonaContacto");
	// }
	//
	// public void writeNombrePersonaContacto(
	// String nombrePersonaContacto)
	// {
	// logger.debug("BEGIN - writeNombrePersonaContacto");
	// this.wh.sendValueToWebElementInFrame(this.txtContactoNombre,
	// this.contenidoFrame, nombrePersonaContacto);
	// logger.debug("END - writeNombrePersonaContacto");
	// }
	//
	// public void writePrimerApellidoPersonaContacto(
	// String apellido1PersonaContacto)
	// {
	// logger.debug("BEGIN - writePrimerApellidoPersonaContacto");
	// this.wh.sendValueToWebElementInFrame(this.txtContactoApellido1,
	// this.contenidoFrame, apellido1PersonaContacto);
	// logger.debug("END - writePrimerApellidoPersonaContacto");
	// }
	//
	// public void writeTelefonoPersonaContacto(
	// String tlf1PersonaContacto)
	// {
	// logger.debug("BEGIN - writeTelefonoPersonaContacto");
	// this.wh.sendValueToWebElementInFrame(this.txtContactoTelefono1,
	// this.contenidoFrame, tlf1PersonaContacto);
	// logger.debug("END - writeTelefonoPersonaContacto");
	// }
	// endregion
}
