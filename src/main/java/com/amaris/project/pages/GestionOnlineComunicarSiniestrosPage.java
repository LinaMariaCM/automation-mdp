package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineComunicarSiniestrosPage extends PageObject {

	// region webelements
	private By frameAppMainWindow = By.cssSelector("#blockrandom");

	private By topFrame = By.cssSelector("#topFrame");
	private By frameLeftFrame = By.cssSelector("#leftFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By contenidoFrame = By.cssSelector("[name='iframe']");

	private By txtPoliza = By.cssSelector("#numpol");
	private By txtFechaSiniestro = By.cssSelector("#fsin");
	private By drpdwnCausa = By.cssSelector("#selcausa");
	private By txtDescripcionSiniestro = By.cssSelector("#causa");
	private By txtCosteAprox = By.cssSelector("#coste");
	private By drpdwnRol = By.cssSelector("#selrol_1");
	private By txtContactoNombre = By.cssSelector("#contnombre_1");
	private By txtContactoApellido1 = By.cssSelector("#contapellido_1");
	private By txtContactoTelefono1 = By.cssSelector("#conttel_1");
	// endregion

	GestionOnlineComunicarSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineComunicarSiniestrosPage writeNumeroPoliza(String numPoliza) {
		debugBegin();
		webDriver.appendTextInFrame(txtPoliza, contenidoFrame, numPoliza);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectFechaSiniestro(String fechaSiniestro) {
		debugBegin();
		webDriver.appendTextInFrame(txtFechaSiniestro, contenidoFrame, fechaSiniestro);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectCausa(String causa) {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnCausa, contenidoFrame, causa);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeDescripcionSiniestro(String descripcion) {
		debugBegin();
		webDriver.appendTextInFrame(txtDescripcionSiniestro, contenidoFrame, descripcion);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectRolPersonaContacto(String rolPersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnRol, contenidoFrame, rolPersonaContacto);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeNombrePersonaContacto(String nombrePersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(txtContactoNombre, contenidoFrame, nombrePersonaContacto);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writePrimerApellidoPersonaContacto(String apellido1PersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(txtContactoApellido1, contenidoFrame, apellido1PersonaContacto);
		debugEnd();
		
		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeTelefonoPersonaContacto(String tlf1PersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(txtContactoTelefono1, contenidoFrame, tlf1PersonaContacto);
		debugEnd();
		
		return this;
	}
	// endregion
}