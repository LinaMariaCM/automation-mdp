package com.amaris.project.pages.administracion.mediadores;

import java.util.Random;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaProspectPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By tipoProspectCombo = By.cssSelector("#MEDI_TIPOPROS");
	private By numRegistroDgsInput = By.cssSelector("#MEDI_REGISDGS");
	private By actividadPrincipalCombo = By.cssSelector("#MEDI_ACTIPRIN");
	private By nombreComercialProspectInput = By.cssSelector("#MEDI_NOMBCOME");
	private By contactoResponsableInput = By.cssSelector("#MEDI_PERSCONT");
	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");
	private By telefonoUnoInput = By.cssSelector("#MEDI_TELEFONO1");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");

	private By asignarDomicilioBtn = By.cssSelector("#BOTON_DOMIMEDI");
	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By nombreViaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");
	private By provinciaCombo = By.cssSelector("html > body > ul:nth-of-type(1) > li > a");
	private By poblacionCombo = By.cssSelector("html > body > ul:nth-of-type(2) > li > a");
	private By nombreViaCombo = By.cssSelector("html > body > ul:nth-of-type(3) > li > a");
	private By codigoPostalInput = By.cssSelector("#ALTACLIE_CODPOST_ARVATO");
	private By borrarCamposDireccionBtn = By.cssSelector("#BOTON_BORRADOM");
	private By aceptarDomicilioBtn = By.cssSelector("#BOTON_ACEPTAR");
	private By cancelarDomicilioBtn = By.cssSelector("#BOTON_CANCELAR");
	private By comprobarDireccionDomicilioBtn = By.cssSelector("#BOTON_NORMADOM");

	private By nuevoMediadorBtn = By.cssSelector("#capaMediadores > div.titulo > div > a");
	private By codigoNuevoMediadorInput = By.cssSelector("#MEDI_CODIMEDI");
	private By confirmarNuevoMediadorBtn = By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(3) > a");
	private By cerrarNuevoMediadorBtn = By.cssSelector("#buttonClose");

	private By anyadirNuevoMedioContactoBtn = By.cssSelector("#capaMediosContacto > div > div.floatright.peq > a");
	private By tipoContactoCombo = By.cssSelector("#MEDI_CONTPROS");
	private By contactoTelefonoInput = By.cssSelector("#MEDI_CONTACTO");
	private By grabarNuevoMedioContactoBtn = By.cssSelector("#buttonRecord");
	private By cancelarNuevoMedioContactoBtn = By.cssSelector("#buttonCancel");

	private By cancelarNuevoProspectBtn = By.cssSelector("#botonCancelar1");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	// endregion

	public MediadoresAltaProspectPage(UserStory userS) {
		super(userS);
	}

	// region methods
	//---------------Métodos simples-----------------------------------
	public static String generadorRandomDgsNumero() {
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
		webDriver.appendTextInFrame(nivelEstructuraCombo, cuerpoFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectTipoProspect() {
		debugBegin();
		webDriver.appendTextInFrame(tipoProspectCombo, cuerpoFrame, getTestVar(Constants.TIPO_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNumeroRegistroDGS() {
		debugBegin();
		webDriver.appendTextInFrame(numRegistroDgsInput, cuerpoFrame, generadorRandomDgsNumero());
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectActividadPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(actividadPrincipalCombo, cuerpoFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNombreComercialProspect() {
		debugBegin();
		webDriver.appendTextInFrame(nombreComercialProspectInput, cuerpoFrame, getTestVar(Constants.NOMBRE_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(contactoResponsableInput, cuerpoFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(telefonoUnoInput, cuerpoFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectIdioma() {
		debugBegin();
		webDriver.appendTextInFrame(idiomaCombo, cuerpoFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.appendTextInFrame(ejecutivoComercialCombo, cuerpoFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAsignarDomicilio() {
		debugBegin();
		webDriver.clickInFrame(asignarDomicilioBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectProvincia() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
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

		webDriver.switchToFrame(cuerpoFrame);
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

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(nombreViaInput, getTestVar(Constants.NOMBRE_VIA));

		webDriver.waitForElementToBeClickable(nombreViaCombo);

		webDriver.tabulateElement(nombreViaInput);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	//-----------Clicks en botones-----------------------------------
	public MediadoresAltaProspectPage clickBotonComprobarDireccion() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(comprobarDireccionDomicilioBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAceptarDireccion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(aceptarDomicilioBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonGrabar() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBorrarCamposDomicilio() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(borrarCamposDireccionBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCancelarDomicilio() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cancelarDomicilioBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickNuevoMediador() {
		debugBegin();
		webDriver.clickInFrame(nuevoMediadorBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickConfirmarNuevoMediador() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(confirmarNuevoMediadorBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickGrabarNuevoMedioContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(grabarNuevoMedioContactoBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCancelarNuevoMedioContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cancelarNuevoMedioContactoBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickAnyadirNuevoMedioContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoMedioContactoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCerrarNuevoMediador() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(cerrarNuevoMediadorBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickCancelarNuevoProspect() {
		debugBegin();
		webDriver.clickInFrame(cancelarNuevoProspectBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	//---------------------Métodos complejos-------------------------------

	public MediadoresAltaProspectPage alta_prospect() {

		debugBegin();
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
		debugEnd();
		return this;
	}
	// endregion
}
