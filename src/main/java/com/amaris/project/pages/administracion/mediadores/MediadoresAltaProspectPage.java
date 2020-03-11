package com.amaris.project.pages.administracion.mediadores;

import java.util.Random;

import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import org.testng.Assert;

public class MediadoresAltaProspectPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");

	//-------------Datos de prospect-------------------------
	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By nivelEstructuraOption = By.cssSelector("#MEDI_NIVEESTR > option");
	private By tipoProspectCombo = By.cssSelector("#MEDI_TIPOPROS");
	private By tipoProspectOption = By.cssSelector("#MEDI_TIPOPROS > option");
	private By numRegistroDgsInput = By.cssSelector("#MEDI_REGISDGS");
	private By actividadPrincipalCombo = By.cssSelector("#MEDI_ACTIPRIN");
	private By actividadPrincipalOption = By.cssSelector("#MEDI_ACTIPRIN > option");
	private By nombreComercialProspectInput = By.cssSelector("#MEDI_NOMBCOME");
	private By contactoResponsableInput = By.cssSelector("#MEDI_PERSCONT");
	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");
	private By idiomaOption = By.cssSelector("#MEDI_IDIOMA > option");
	private By telefonoUnoInput = By.cssSelector("#MEDI_TELEFONO1");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");
	private By ejecutivoComercialOption = By.cssSelector("#MEDI_EJECCOME > option");

	//-----------Datos de prospect asignar domicilio----------------
	private By asignarDomicilioBtn = By.cssSelector("#BOTON_DOMIMEDI");
	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By nombreViaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");
	private By numeroViaInput = By.cssSelector("#ALTACLIE_NUMVIA");
	private By provinciaCombo = By.cssSelector("html > body > ul:nth-of-type(1) > li > a");
	private By poblacionCombo = By.cssSelector("html > body > ul:nth-of-type(2) > li > a");
	private By nombreViaCombo = By.cssSelector("html > body > ul:nth-of-type(3) > li > a");
	private By codigoPostalInput = By.cssSelector("#ALTACLIE_CODPOST_ARVATO");
	private By borrarCamposDireccionBtn = By.cssSelector("#BOTON_BORRADOM");
	private By aceptarDomicilioBtn = By.cssSelector("#BOTON_ACEPTAR");
	private By cancelarDomicilioBtn = By.cssSelector("#BOTON_CANCELAR");
	private By comprobarDireccionDomicilioBtn = By.cssSelector("#BOTON_NORMADOM");

	//-----------Mediadores Relacionados--------------------------
	private By nuevoMediadorBtn = By.cssSelector("#capaMediadores > div.titulo > div > a");
	private By codigoNuevoMediadorInput = By.cssSelector("#MEDI_CODIMEDI");
	private By confirmarNuevoMediadorBtn = By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(3) > a");
	private By cerrarNuevoMediadorBtn = By.cssSelector("#buttonClose");

	//----------Medios de Contacto---------------------------------
	private By anyadirNuevoMedioContactoBtn = By.cssSelector("#capaMediosContacto > div > div.floatright.peq > a");
	private By tipoContactoCombo = By.cssSelector("#MEDI_CONTPROS");
	private By tipoContactoOption = By.cssSelector("#MEDI_CONTPROS > option");
	private By contactoTelefonoInput = By.cssSelector("#MEDI_CONTACTO");
	private By grabarNuevoMedioContactoBtn = By.cssSelector("#buttonRecord");
	private By cancelarNuevoMedioContactoBtn = By.cssSelector("#buttonCancel");

	//--------Controles de Paginas------------------------
	private By cancelarNuevoProspectBtn = By.cssSelector("#botonCancelar1");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By volverBtn = By.cssSelector("#botonVolver");

	private By avisoSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");

	public MediadoresAltaProspectPage(UserStory userS) {
		super(userS);
	}

	//---------------Métodos simples-----------------------------------
	public MediadoresAltaProspectPage selectNivelEstructura() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectTipoProspect() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoProspectCombo, tipoProspectOption, cuerpoFrame, "value", getTestVar(Constants.TIPO_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage escribirNumeroRegistroDGS() {

		debugBegin();
		webDriver.setTextInFrame(numRegistroDgsInput, cuerpoFrame, generadorRandomDgsNumero());
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectActividadPrincipal() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttributeInFrame(actividadPrincipalCombo, actividadPrincipalOption, cuerpoFrame, "value", getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage escribirNombreComercialProspect() {

		debugBegin();
		webDriver.setTextInFrame(nombreComercialProspectInput, cuerpoFrame, getTestVar(Constants.NOMBRE_PROSPECT));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage escribirContactoResponsable() {

		debugBegin();
		webDriver.setTextInFrame(contactoResponsableInput, cuerpoFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage escribirTelefonoUno() {

		debugBegin();
		webDriver.setTextInFrame(telefonoUnoInput, cuerpoFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectIdioma() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttributeInFrame(idiomaCombo, idiomaOption, cuerpoFrame, "value", getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage selectEjecutivoComercial() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttributeInFrame(ejecutivoComercialCombo, ejecutivoComercialOption, cuerpoFrame, "value", getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaProspectPage clickBotonAsignarDomicilio() {

		debugBegin();
		webDriver.clickInFrame(asignarDomicilioBtn, cuerpoFrame);
		webDriver.waitWithDriver(5000);
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

	public MediadoresAltaProspectPage clickAnyadirNuevoMedioContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoMedioContactoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	//---------------------MÉTODOS COMPLEJOS-------------------------------

	public static String generadorRandomDgsNumero() {

		return Integer.toString(new Random().nextInt(99999) + 11111);
	}

	public MediadoresAltaProspectPage completarDatosDireccion() {
		debugBegin();

		clickBotonAsignarDomicilio();
		selectProvincia();
		selectPoblacion();
		selectVia();
		clickBotonComprobarDireccion();
		clickBotonAceptarDireccion();

		debugEnd();
		return this;
	}

	public MediadoresAltaProspectPage altaProspectMediadores() {

		debugBegin();
		selectNivelEstructura();
		selectTipoProspect();

		if(getTestVar(Constants.TIPO_PROSPECT).equalsIgnoreCase("COBS")) {
			escribirNumeroRegistroDGS();
		}

		selectActividadPrincipal();
		escribirNombreComercialProspect();
		escribirContactoResponsable();
		selectIdioma();
		escribirTelefonoUno();
		selectEjecutivoComercial();
		completarDatosDireccion();
		clickBotonGrabar();

		debugEnd();
		return this;
	}

	//---------ALTA PROSPECT RETENCIONES---------------------

	public boolean alertaSistemaProspect(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public MediadoresAltaProspectPage altaProspectRetenciones() {
		debugBegin();

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NIVEL_ESTRUCTURA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", getTestVar(Constants.NIVEL_ESTRUCTURA));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_PROSPECT_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoProspectCombo, tipoProspectOption, cuerpoFrame, "value", getTestVar(Constants.TIPO_PROSPECT));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_REGISTRO_DGS);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(numRegistroDgsInput, cuerpoFrame, "12345");

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ACTIVIDAD_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(actividadPrincipalCombo, actividadPrincipalOption, cuerpoFrame, "value", getTestVar(Constants.ACTIVIDAD_PRINCIPAL));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_COMERCIAL_2_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(nombreComercialProspectInput, cuerpoFrame, getTestVar(Constants.NOMBRE_PROSPECT));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_RESPONSABLE_PROSPECT);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(contactoResponsableInput, cuerpoFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_IDIOMA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(idiomaCombo, idiomaOption, cuerpoFrame, "value", getTestVar(Constants.IDIOMA));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(telefonoUnoInput, cuerpoFrame, "telefono");

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(telefonoUnoInput, cuerpoFrame, "699");

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(telefonoUnoInput, cuerpoFrame, getTestVar(Constants.TLF_PRINCIPAL));

		clickBotonGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EJECUTIVO_COMERCIAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(ejecutivoComercialCombo, ejecutivoComercialOption, cuerpoFrame, "value", getTestVar(Constants.EJECUTIVO_COMERCIAL));

		clickBotonGrabar();

		alertaSistemaProspect(Constants.ALERTA_ANYADIR_DOMICILIO_PROSPECT);
		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		clickBotonAsignarDomicilio();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		webDriver.click(comprobarDireccionDomicilioBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		webDriver.setText(provinciaInput, getTestVar(Constants.PROVINCIA));

		webDriver.waitForElementToBeClickable(provinciaCombo);

		webDriver.tabulateElement(provinciaInput);

		webDriver.click(comprobarDireccionDomicilioBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(poblacionInput, getTestVar(Constants.POBLACION));

		webDriver.waitForElementToBeClickable(poblacionCombo);

		webDriver.tabulateElement(poblacionInput);

		webDriver.click(comprobarDireccionDomicilioBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(nombreViaInput, getTestVar(Constants.NOMBRE_VIA));

		webDriver.waitForElementToBeClickable(nombreViaCombo);

		webDriver.tabulateElement(nombreViaInput);

		webDriver.click(comprobarDireccionDomicilioBtn);
		webDriver.click(aceptarDomicilioBtn);

		webDriver.exitFrame();

		//------No obligatorios-------------
		clickAnyadirNuevoMedioContacto();

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoContactoCombo, tipoContactoOption, modalFrame, "value", "CMIP");

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "Comunica", modalFrame);

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "699999999", modalFrame);

		clickGrabarNuevoMedioContacto();

		clickAnyadirNuevoMedioContacto();

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoContactoCombo, tipoContactoOption, modalFrame, "value", "FAX");

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "Fax", modalFrame);

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "699999999", modalFrame);

		clickGrabarNuevoMedioContacto();

		clickAnyadirNuevoMedioContacto();

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoContactoCombo, tipoContactoOption, modalFrame, "value", "MAIL");

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "Mail", modalFrame);

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "email@email.com", modalFrame);

		clickGrabarNuevoMedioContacto();

		clickAnyadirNuevoMedioContacto();

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoContactoCombo, tipoContactoOption, modalFrame, "value", "TELF");

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "Telefono", modalFrame);

		clickGrabarNuevoMedioContacto();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_PROSPECT);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(contactoTelefonoInput, "699999999", modalFrame);

		clickGrabarNuevoMedioContacto();

		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		debugEnd();
		return this;
	}

}
