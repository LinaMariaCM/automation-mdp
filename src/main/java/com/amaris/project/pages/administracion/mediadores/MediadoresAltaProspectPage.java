package com.amaris.project.pages.administracion.mediadores;

import java.util.Random;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaProspectPage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");

	private By drpdwnNivelEstructura = By.cssSelector("#MEDI_NIVEESTR");
	private By drpdwnTipoProspect = By.cssSelector("#MEDI_TIPOPROS");
	private By txtNumRegistroDGS = By.cssSelector("#MEDI_REGISDGS");
	private By drpdwnActividadPrincipal = By.cssSelector("#MEDI_ACTIPRIN");
	private By txtNombreComercialProspect = By.cssSelector("#MEDI_NOMBCOME");
	private By txtContactoResponsable = By.cssSelector("#MEDI_PERSCONT");
	private By drpdwnIdioma = By.cssSelector("#MEDI_IDIOMA");
	private By txtTlf1 = By.cssSelector("#MEDI_TELEFONO1");
	private By drpdwnEjecutivoComercial = By.cssSelector("#MEDI_EJECCOME");

	private By txtProvincia = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By txtPoblacion = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By txtVia = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");

	private By btnGrabar = By.cssSelector("#botonGrabar");
	private By btnAsignarDomicilio = By.cssSelector("#BOTON_DOMIMEDI");
	private By btnComprobarDireccion = By.cssSelector("#BOTON_NORMADOM");
	private By btnAceptarDireccion = By.cssSelector("#BOTON_ACEPTAR");

	private By drpdwnProvincia = By.cssSelector("html > body > ul:nth-of-type(1) > li > a");
	private By drpdwnPoblacion = By.cssSelector("html > body > ul:nth-of-type(2) > li > a");
	private By drpdwnVia = By.cssSelector("html > body > ul:nth-of-type(3) > li > a");
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
		webDriver.appendTextInFrame(drpdwnNivelEstructura, mainFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectTipoProspect() {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnTipoProspect, mainFrame, getTestVar(Constants.TIPO_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNumeroRegistroDGS() {
		debugBegin();
		webDriver.appendTextInFrame(txtNumRegistroDGS, mainFrame, generateRandomDgsNumber());
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectActividadPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnActividadPrincipal, mainFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNombreComercialProspect() {
		debugBegin();
		webDriver.appendTextInFrame(txtNombreComercialProspect, mainFrame, getTestVar(Constants.NOMBRE_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(txtContactoResponsable, mainFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(txtTlf1, mainFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectIdioma() {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnIdioma, mainFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.appendTextInFrame(drpdwnEjecutivoComercial, mainFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAsignarDomicilio() {
		debugBegin();
		webDriver.clickInFrame(btnAsignarDomicilio, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectProvincia() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(txtProvincia, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(drpdwnProvincia);
		webDriver.tabulateElement(txtProvincia);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectPoblacion() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(txtPoblacion, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(drpdwnPoblacion);
		webDriver.tabulateElement(txtPoblacion);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectVia() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(txtVia, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(drpdwnVia);
		webDriver.tabulateElement(txtVia);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonComprobarDireccion() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(btnComprobarDireccion);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAceptarDireccion() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(btnAceptarDireccion);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonGrabar() {
		debugBegin();
		webDriver.clickInFrame(btnGrabar, mainFrame);
		debugEnd();

		return this;
	}
	// endregion
}
