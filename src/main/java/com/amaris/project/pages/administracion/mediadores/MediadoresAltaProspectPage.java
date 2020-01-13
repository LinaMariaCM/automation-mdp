package com.amaris.project.pages.administracion.mediadores;

import java.util.Random;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaProspectPage extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");

	private By nivelEstructuraDrpDwn = By.cssSelector("#MEDI_NIVEESTR");
	private By tipoProspectDrpDwn = By.cssSelector("#MEDI_TIPOPROS");
	private By numRegistroDGSInput = By.cssSelector("#MEDI_REGISDGS");
	private By actividadPrincipalInput = By.cssSelector("#MEDI_ACTIPRIN");
	private By nombreComercialProspectInput = By.cssSelector("#MEDI_NOMBCOME");
	private By contactoResponsableInput = By.cssSelector("#MEDI_PERSCONT");
	private By idiomaInput = By.cssSelector("#MEDI_IDIOMA");
	private By tlf1Input = By.cssSelector("#MEDI_TELEFONO1");
	private By ejecutivoComercialInput = By.cssSelector("#MEDI_EJECCOME");

	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By viaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");

	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By asignarDomicilioBtn = By.cssSelector("#BOTON_DOMIMEDI");
	private By comprobarDireccionBtn = By.cssSelector("#BOTON_NORMADOM");
	private By aceptarDireccionBtn = By.cssSelector("#BOTON_ACEPTAR");

	private By provinciaDrpDw = By.cssSelector("html > body > ul:nth-of-type(1) > li > a");
	private By poblacionDrpDwn = By.cssSelector("html > body > ul:nth-of-type(2) > li > a");
	private By viaDrpDwn = By.cssSelector("html > body > ul:nth-of-type(3) > li > a");
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
		webDriver.appendTextInFrame(nivelEstructuraDrpDwn, mainFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectTipoProspect() {
		debugBegin();
		webDriver.appendTextInFrame(tipoProspectDrpDwn, mainFrame, getTestVar(Constants.TIPO_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage writeNumeroRegistroDGS() {
		debugBegin();
		webDriver.appendTextInFrame(numRegistroDGSInput, mainFrame, generateRandomDgsNumber());
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectActividadPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(actividadPrincipalInput, mainFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
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
		webDriver.appendTextInFrame(tlf1Input, mainFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectIdioma() {
		debugBegin();
		webDriver.appendTextInFrame(idiomaInput, mainFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.appendTextInFrame(ejecutivoComercialInput, mainFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
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
		webDriver.waitForElementToBeClickable(provinciaDrpDw);
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
		webDriver.waitForElementToBeClickable(poblacionDrpDwn);
		webDriver.tabulateElement(poblacionInput);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectVia() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(viaDrpDwn);
		webDriver.tabulateElement(viaInput);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonComprobarDireccion() {
		debugBegin();

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(comprobarDireccionBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAceptarDireccion() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(aceptarDireccionBtn);
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
	// endregion
}
