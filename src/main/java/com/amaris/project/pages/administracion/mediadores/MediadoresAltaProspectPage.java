package com.amaris.project.pages.administracion.mediadores;

import java.util.Random;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaProspectPage extends PageObject {

	// region WebElements
	private By mainFrame = By.id("mainFrame");
	private By modalFrame = By.id("capaIframe");

	private By nivelEstructuraCombo = By.id("MEDI_NIVEESTR");
	private By tipoProspectCombo = By.id("MEDI_TIPOPROS");
	private By numRegistroDgsInput = By.id("MEDI_REGISDGS");
	private By actividadPrincipalCombo = By.id("MEDI_ACTIPRIN");
	private By nombreComercialProspectInput = By.id("MEDI_NOMBCOME");
	private By contactoResponsableInput = By.id("MEDI_PERSCONT");
	private By idiomaCombo = By.id("MEDI_IDIOMA");
	private By telefonoUnoInput = By.id("MEDI_TELEFONO1");
	private By ejecutivoComercialCombo = By.id("MEDI_EJECCOME");

	private By asignarDomicilioBtn = By.id("BOTON_DOMIMEDI");
	private By provinciaInput = By.id("ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.id("ALTACLIE_POBLACION_ARVATO");
	private By nombreViaInput = By.id("ALTACLIE_NOMVIA_ARVATO");
	private By provinciaCombo = By.cssSelector("html > body > ul:nth-of-type(1) > li > a");
	private By poblacionCombo = By.cssSelector("html > body > ul:nth-of-type(2) > li > a");
	private By nombreViaCombo = By.cssSelector("html > body > ul:nth-of-type(3) > li > a");
	private By codigoPostalInput = By.id("ALTACLIE_CODPOST_ARVATO");
	private By borrarCamposDireccionBtn = By.id("BOTON_BORRADOM");
	private By aceptarDomicilioBtn = By.id("BOTON_ACEPTAR");
	private By cancelarDomicilioBtn = By.id("BOTON_CANCELAR");
	private By comprobarDireccionDomicilioBtn = By.id("BOTON_NORMADOM");

	private By nuevoMediadorBtn = By.cssSelector("#capaMediadores > div.titulo > div > a");
	private By codigoNuevoMediadorInput = By.id("MEDI_CODIMEDI");
	private By confirmarNuevoMediadorBtn = By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(3) > a");
	private By cerrarNuevoMediadorBtn = By.id("buttonClose");

	private By anyadirNuevoMedioContactoBtn = By.cssSelector("#capaMediosContacto > div > div.floatright.peq > a");
	private By tipoContactoCombo = By.id("MEDI_CONTPROS");
	private By contactoTelefonoInput = By.id("MEDI_CONTACTO");
	private By grabarNuevoMedioContactoBtn = By.id("buttonRecord");
	private By cancelarNuevoMedioContactoBtn = By.id("buttonCancel");

	private By cancelarNuevoProspectBtn = By.id("botonCancelar1");
	private By grabarBtn = By.id("botonGrabar");
	// endregion

	public MediadoresAltaProspectPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public MediadoresAltaProspectPage executeActionsAltaProspectPage() {
		selectNivelEstructura();
		selectTipoProspect();
		selectActividadPrincipal();

		if(getTestVar(Constants.TIPO_PROSPECT).equals("Corredor-BS")) {
			writeNumeroRegistroDGS();
		}

		writeNombreComercialProspect();
		writeContactoResponsable();
		selectIdioma();
		writeTelefonoUno();
		selectEjecutivoComercial();
		completarDatosDireccion();
		clickBotonGrabar();

		return this;
	}

	public static String generateRandomDgsNumber() {
		return Integer.toString(new Random().nextInt(99999) + 11111);
	}

	public MediadoresAltaProspectPage completarDatosDireccion() {
		clickBotonAsignarDomicilio();
		selectProvincia();
		selectPoblacion();
		selectVia();
		clickBotonComprobarDireccion();
		clickBotonAceptarDireccion();

		return this;
	}

	public MediadoresAltaProspectPage selectNivelEstructura() {
		debugBegin();
		webDriver.appendTextInFrame(nivelEstructuraCombo, mainFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectTipoProspect() {
		debugBegin();
		webDriver.appendTextInFrame(tipoProspectCombo, mainFrame, getTestVar(Constants.TIPO_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNumeroRegistroDGS() {
		debugBegin();
		webDriver.appendTextInFrame(numRegistroDgsInput, mainFrame, generateRandomDgsNumber());
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectActividadPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(actividadPrincipalCombo, mainFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNombreComercialProspect() {
		debugBegin();
		webDriver.appendTextInFrame(nombreComercialProspectInput, mainFrame, getTestVar(Constants.NOMBRE_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(contactoResponsableInput, mainFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(telefonoUnoInput, mainFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectIdioma() {
		debugBegin();
		webDriver.appendTextInFrame(idiomaCombo, mainFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.appendTextInFrame(ejecutivoComercialCombo, mainFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAsignarDomicilio() {
		debugBegin();
		webDriver.clickInFrame(asignarDomicilioBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectProvincia() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));

		webDriver.waitForElementToBeClickable(provinciaCombo);

		webDriver.tabulateElement(provinciaInput);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectPoblacion() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));

		webDriver.waitForElementToBeClickable(poblacionCombo);

		webDriver.tabulateElement(poblacionInput);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectVia() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(nombreViaInput, getTestVar(Constants.NOMBRE_VIA));

		webDriver.waitForElementToBeClickable(nombreViaCombo);

		webDriver.tabulateElement(nombreViaInput);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonComprobarDireccion() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(comprobarDireccionDomicilioBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAceptarDireccion() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(aceptarDomicilioBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonGrabar() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBorrarCamposDomicilio() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(borrarCamposDireccionBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCancelarDomicilio() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cancelarDomicilioBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickNuevoMediador() {
		debugBegin();
		webDriver.clickInFrame(nuevoMediadorBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickConfirmarNuevoMediador() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(confirmarNuevoMediadorBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	public MediadoresAltaProspectPage clickGrabarNuevoMedioContacto() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(grabarNuevoMedioContactoBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	public MediadoresAltaProspectPage clickCancelarNuevoMedioContacto() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cancelarNuevoMedioContactoBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	public MediadoresAltaProspectPage clickAnyadirNuevoMedioContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoMedioContactoBtn, mainFrame);
		debugEnd();

		return this;
	}
	public MediadoresAltaProspectPage clickCerrarNuevoMediador() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cerrarNuevoMediadorBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCancelarNuevoProspect() {
		debugBegin();
		webDriver.clickInFrame(cancelarNuevoProspectBtn, mainFrame);
		debugEnd();

		return this;
	}
	// endregion
}
