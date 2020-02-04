package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaMediadorPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By actividadPrincipalCombo = By.cssSelector("#MEDI_ACTIPRIN");
	private By contactoResponsableInput = By.cssSelector("#MEDI_PERSCONT");
	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");
	private By telefonoUnoInput = By.cssSelector("#MEDI_TELEFONO1");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");

	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By viaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");

	private By comprobarDireccionBtn = By.cssSelector("#BOTON_NORMADOM");
	private By aceptarDireccionBtn = By.cssSelector("#BOTON_ACEPTAR");
	private By aceptarDireccionPostalBtn = By.cssSelector("#BOTON_ACEPDOMI");

	private By asignarDomicilioBtn = By.cssSelector("#BOTON_DOMIMEDI");

	private By tipoMediadorCombo = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPODOCMED");

	private By numeroDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOC");
	private By numRegistroDGSInput = By.cssSelector("#ALTAMEDI_NREGDGS");
	private By cargoResponsableInput = By.cssSelector("#ALTAMEDI_CARGRESP");
	private By nombreFiscalInput = By.cssSelector("#ALTAMEDI_NOMFISCMED");
	private By primerApellidoInput = By.cssSelector("#ALTAMEDI_APE1FISC");
	private By segundoApellidoInput = By.cssSelector("#ALTAMEDI_APE2FISC");
	private By emailPrincipalInput = By.cssSelector("#ALTAMEDI_EMAILPRI");

	private By tipoDomicilioCombo = By.cssSelector("#ALTAMEDI_TIPDOMME");

	private By nombreComercialIgualFiscalBtn = By.cssSelector("#ALTAMEDI_NOMCOIGU");
	private By nombreComercialDiferenteFiscalBtn = By.cssSelector("#ALTAMEDI_NOMCODIF");
	private By direccionIgualFiscalBtn = By.cssSelector("#ALTAMEDI_IGUFISC");
	private By nombreComercialInput = By.cssSelector("#ALTAMEDI_OTRONOMB");

	private By tieneOficinasNoBtn = By.cssSelector("#ALTAMEDI_OFINO");
	private By colaboradresExternosNoBtn = By.cssSelector("#ALTAMEDI_TRABAJANO");
	private By softwareGestionNoBtn = By.cssSelector("#ALTAMEDI_SOFTNO");
	private By companiasPrincipalesInput = By.cssSelector("#ALTAMEDI_COMPPRIN");

	private By continuarBtn = By.cssSelector("#botonContinuar1");
	private By grabarBtn = By.cssSelector("#botonGrabar1");
	private By provinciaCombo = By.cssSelector("body > ul:nth-child(4)");
	private By poblacionCombo = By.cssSelector("body > ul:nth-child(5)");
	private By viaCombo = By.cssSelector("body > ul:nth-child(6)");
	private By anyadirNuevaDireccionBtn = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");

	// Datos transaccionales page elements.
	private By codigoIbanInput = By.cssSelector("#COMODIN_CADENA");
	private By bancoInput = By.cssSelector("#COMODIN_CADENA_1");
	private By sucursalInput = By.cssSelector("#COMODIN_CADENA_2");
	private By dcInput = By.cssSelector("#COMODIN_CADENA_3");
	private By cta1Input = By.cssSelector("#COMODIN_CADENA_4");
	private By cta2Input = By.cssSelector("#COMODIN_CADENA_5");
	// endregion

	public MediadoresAltaMediadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public MediadoresAltaMediadorPage executeActionsAltaMediadorPage() {
		debugBegin();

		// "Datos descriptivos" page.
		selectNivelEstructura();
		selectTipoMediador();
		selectEjecutivoComercial();
		selectTipoDocumento();
		writeNumeroDocumento();
		writeNombreFiscalYApellidosMediador();
	//	writeNombreComercialMediador();
		selectActividadPrincipal();
		selectIdioma();
		selectTieneOficinas();
		selectColaboradoresExternos();
		selectSoftwareGestion();
		clickContinuar();

		// "Datos de contacto" page.
		writeContactoResponsable();
		writeCargoResponsable();
		writeTelefonoUno();
		writeEmailPrincipal();
		addDireccionComercial();
		addDireccionFiscal();
		addDireccionPostalProduccion();
		addDireccionPostalRecibos();
		addDireccionPostalSiniestros();
		clickContinuar();

		// "Datos relacionales" page.
		addCompaniasPrincipales();
		clickContinuar();

		// Datos transaccionales" page.
		writeCuentaBancaria();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectNivelEstructura() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(nivelEstructuraCombo, cuerpoFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectEjecutivoComercial() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(ejecutivoComercialCombo, cuerpoFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoMediador() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(tipoMediadorCombo, cuerpoFrame, getTestVar(Constants.TIPO_MEDIADOR));

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoDocumento() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoCombo, cuerpoFrame, getTestVar(Constants.TIPO_DOCUMENTO));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroDocumento() {
		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			setTestVar(Constants.DOCUMENTO_MEDIADOR, DocumentGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, getTestVar(Constants.DOCUMENTO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNombreFiscalYApellidosMediador() {
		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			webDriver.appendTextInFrame(nombreFiscalInput, cuerpoFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}
		// When NIF or NIE, also shows surname fields. Second surname only mandatory for NIF.
		else {

			webDriver.appendTextInFrame(nombreFiscalInput, cuerpoFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
			webDriver.appendTextInFrame(primerApellidoInput, cuerpoFrame, getTestVar(Constants.PRIMER_APELLIDO_MEDIADOR));
			webDriver.appendTextInFrame(segundoApellidoInput, cuerpoFrame, getTestVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

/*	public MediadoresAltaMediadorPage writeNombreComercialMediador() {
		debugBegin();

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Igual que el fiscal")) {
			// Cuando nombre comercial es igual al fiscal, solo hay que marcar el radio button.
			webDriver.clickInFrame(nombreComercialIgualFiscalBtn, cuerpoFrame);
		}

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Diferente que el fiscal")) {
			// Cuando nombre comercial es diferente que el fiscal,
			// hay que marcar el radio button y completar el nombre
			// comercial (by default it is
			// the same as the nombre fiscal).
			webDriver.clickInFrame(nombreComercialDiferenteFiscalBtn, cuerpoFrame);
			webDriver.appendTextInFrame(nombreComercialInput, cuerpoFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}

		debugEnd();

		return this;
	}*/

	public MediadoresAltaMediadorPage selectActividadPrincipal() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(actividadPrincipalCombo, cuerpoFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectIdioma() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(idiomaCombo, cuerpoFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroRegistroDGS() {
		debugBegin();
		// Solo requiere Nº registo DGSFP cuando el tipo mediador es
		// "Agente vinculado", "BS Exclusivo", "BS Vinculado", o "Corredor".
		if(getTestVar(Constants.TIPO_MEDIADOR) != null && getTestVar(Constants.TIPO_MEDIADOR).equals("Agente vinculado")
			|| getTestVar(Constants.TIPO_MEDIADOR).equals("BS Exclusivo") || getTestVar(Constants.TIPO_MEDIADOR).equals("Corredor")) {
			webDriver.appendTextInFrame(numRegistroDGSInput, cuerpoFrame, getTestVar(Constants.DGS));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTieneOficinas() {
		debugBegin();
		webDriver.clickInFrame(tieneOficinasNoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectColaboradoresExternos() {
		debugBegin();
		webDriver.clickInFrame(colaboradresExternosNoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectSoftwareGestion() {
		debugBegin();
		webDriver.clickInFrame(softwareGestionNoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(contactoResponsableInput, cuerpoFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCargoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(cargoResponsableInput, cuerpoFrame, getTestVar(Constants.CARGO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(telefonoUnoInput, cuerpoFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeEmailPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(emailPrincipalInput, cuerpoFrame, getTestVar(Constants.EMAIL_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionComercial() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioCombo, "Comercial");
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(provinciaCombo);
		webDriver.tabulateElement(provinciaInput);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(poblacionCombo);
		webDriver.tabulateElement(poblacionInput);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(viaCombo);
		webDriver.tabulateElement(viaInput);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionFiscal() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioCombo, "Fiscal");
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(provinciaCombo);
		webDriver.tabulateElement(provinciaInput);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(poblacionCombo);
		webDriver.tabulateElement(poblacionInput);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(viaCombo);
		webDriver.tabulateElement(viaInput);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalProduccion() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioCombo, "Postal producción");
		webDriver.click(direccionIgualFiscalBtn); // Click radio button "Igual a la fiscal".
		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalRecibos() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioCombo, "Postal recibos");
		webDriver.click(direccionIgualFiscalBtn); // Click radio button "Igual a la fiscal".

		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalSiniestros() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioCombo, "Postal siniestros");
		webDriver.click(direccionIgualFiscalBtn); // Click radio button "Igual a la fiscal".
		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addCompaniasPrincipales() {
		debugBegin();
		webDriver.appendTextInFrame(companiasPrincipalesInput, cuerpoFrame, "Texto de las compañías principales");
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCuentaBancaria() {
		debugBegin();

		webDriver.appendTextInFrame(codigoIbanInput, cuerpoFrame, "ES03");
		webDriver.appendTextInFrame(bancoInput, cuerpoFrame, "2100");
		webDriver.appendTextInFrame(sucursalInput, cuerpoFrame, "1234");
		webDriver.appendTextInFrame(dcInput, cuerpoFrame, "5612");
		webDriver.appendTextInFrame(cta1Input, cuerpoFrame, "3456");
		webDriver.appendTextInFrame(cta2Input, cuerpoFrame, "7890");

		debugEnd();

		return this;
	}
	// endregion
}
