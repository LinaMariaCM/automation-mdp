package com.amaris.project.pages.administracion.siniestros.gestion;

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

	private By polizaInput = By.cssSelector("#numpol");
	private By fechaSiniestroInput = By.cssSelector("#fsin");
	private By causaInput = By.cssSelector("#selcausa");
	private By descripcionSiniestroInput = By.cssSelector("#causa");
	private By costeAproxInput = By.cssSelector("#coste");
	private By rolInput = By.cssSelector("#selrol_1");
	private By contactoNombreInput = By.cssSelector("#contnombre_1");
	private By contactoApellido1Input = By.cssSelector("#contapellido_1");
	private By contactoTelefono1Input = By.cssSelector("#conttel_1");
	// endregion

	GestionOnlineComunicarSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineComunicarSiniestrosPage writeNumeroPoliza(String numPoliza) {
		debugBegin();
		webDriver.appendTextInFrame(polizaInput, contenidoFrame, numPoliza);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectFechaSiniestro(String fechaSiniestro) {
		debugBegin();
		webDriver.appendTextInFrame(fechaSiniestroInput, contenidoFrame, fechaSiniestro);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectCausa(String causa) {
		debugBegin();
		webDriver.appendTextInFrame(causaInput, contenidoFrame, causa);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeDescripcionSiniestro(String descripcion) {
		debugBegin();
		webDriver.appendTextInFrame(descripcionSiniestroInput, contenidoFrame, descripcion);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage selectRolPersonaContacto(String rolPersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(rolInput, contenidoFrame, rolPersonaContacto);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeNombrePersonaContacto(String nombrePersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(contactoNombreInput, contenidoFrame, nombrePersonaContacto);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writePrimerApellidoPersonaContacto(String apellido1PersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(contactoApellido1Input, contenidoFrame, apellido1PersonaContacto);
		debugEnd();

		return this;
	}

	public GestionOnlineComunicarSiniestrosPage writeTelefonoPersonaContacto(String tlf1PersonaContacto) {
		debugBegin();
		webDriver.appendTextInFrame(contactoTelefono1Input, contenidoFrame, tlf1PersonaContacto);
		debugEnd();

		return this;
	}
	// endregion
}