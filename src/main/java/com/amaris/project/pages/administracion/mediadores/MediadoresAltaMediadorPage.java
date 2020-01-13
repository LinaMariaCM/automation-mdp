package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaMediadorPage extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");

	private By nivelEstructuraDrpDwn = By.cssSelector("#MEDI_NIVEESTR");
	private By actividadPrincipalDrpDwn = By.cssSelector("#MEDI_ACTIPRIN");
	private By contactoResponsableInput = By.cssSelector("#MEDI_PERSCONT");
	private By idiomaDrpDwn = By.cssSelector("#MEDI_IDIOMA");
	private By tlf1Input = By.cssSelector("#MEDI_TELEFONO1");
	private By ejecutivoComercialDrpDwn = By.cssSelector("#MEDI_EJECCOME");

	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By viaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");

	private By comprobarDireccionBtn = By.cssSelector("#BOTON_NORMADOM");
	private By aceptarDireccionBtn = By.cssSelector("#BOTON_ACEPTAR");
	private By aceptarDireccionPostalBtn = By.cssSelector("#BOTON_ACEPDOMI");

	private By tipoMediadorDrpDwn = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By tipoDocumentoDrpDwn = By.cssSelector("#ALTAMEDI_TIPODOCMED");
	private By numeroDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOC");
	private By numRegistroDGSInput = By.cssSelector("#ALTAMEDI_NREGDGS");
	private By cargoResponsableInput = By.cssSelector("#ALTAMEDI_CARGRESP");
	private By nombreFiscalInput = By.cssSelector("#ALTAMEDI_NOMFISCMED");
	private By primerApellidoInput = By.cssSelector("#ALTAMEDI_APE1FISC");
	private By segundoApellidoInput = By.cssSelector("#ALTAMEDI_APE2FISC");
	private By emailPrincipalInput = By.cssSelector("#ALTAMEDI_EMAILPRI");
	private By tipoDomicilioDrpDwn = By.cssSelector("#ALTAMEDI_TIPDOMME");
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
	private By provinciaDrpDwn = By.cssSelector("body > ul:nth-child(4)");
	private By poblacionDrpDwn = By.cssSelector("body > ul:nth-child(5)");
	private By viaDrpDwn = By.cssSelector("body > ul:nth-child(6)");
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
		writeNombreComercialMediador();
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
		webDriver.clickInFrame(grabarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectNivelEstructura() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(nivelEstructuraDrpDwn, mainFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(ejecutivoComercialDrpDwn, mainFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoMediador() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(tipoMediadorDrpDwn, mainFrame, getTestVar(Constants.TIPO_MEDIADOR));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoDocumento() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, mainFrame, getTestVar(Constants.TIPO_DOCUMENTO));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroDocumento() {
		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			setTestVar(Constants.DOCUMENTO_MEDIADOR, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(numeroDocumentoInput, mainFrame, getTestVar(Constants.DOCUMENTO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNombreFiscalYApellidosMediador() {
		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			webDriver.appendTextInFrame(nombreFiscalInput, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		} else {
			webDriver.appendTextInFrame(nombreFiscalInput, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
			webDriver.appendTextInFrame(primerApellidoInput, mainFrame, getTestVar(Constants.PRIMER_APELLIDO_MEDIADOR));
			webDriver.appendTextInFrame(segundoApellidoInput, mainFrame, getTestVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNombreComercialMediador() {
		debugBegin();

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Igual que el fiscal")) {
			webDriver.clickInFrame(nombreComercialIgualFiscalBtn, mainFrame);
		}

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Diferente que el fiscal")) {
			// Cuando nombre comercial es diferente que el fiscal,
			// hay que marcar el radio button y completar el nombre
			// comercial (by default it is
			// the same as the nombre fiscal).
			webDriver.clickInFrame(nombreComercialDiferenteFiscalBtn, mainFrame);
			webDriver.appendTextInFrame(nombreComercialInput, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectActividadPrincipal() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(actividadPrincipalDrpDwn, mainFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectIdioma() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(idiomaDrpDwn, mainFrame, getTestVar(Constants.IDIOMA));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroRegistroDGS() {
		debugBegin();
		// Solo requiere Nº registo DGSFP cuando el tipo mediador es
		// "Agente vinculado", "BS Exclusivo", "BS Vinculado", o "Corredor".
		if(getTestVar(Constants.TIPO_MEDIADOR) != null && getTestVar(Constants.TIPO_MEDIADOR).equals("Agente vinculado")
			|| getTestVar(Constants.TIPO_MEDIADOR).equals("BS Exclusivo") || getTestVar(Constants.TIPO_MEDIADOR).equals("Corredor")) {
			webDriver.appendTextInFrame(numRegistroDGSInput, mainFrame, getTestVar(Constants.DGS));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTieneOficinas() {
		debugBegin();
		webDriver.clickInFrame(tieneOficinasNoBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectColaboradoresExternos() {
		debugBegin();
		webDriver.clickInFrame(colaboradresExternosNoBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectSoftwareGestion() {
		debugBegin();
		webDriver.clickInFrame(softwareGestionNoBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(contactoResponsableInput, mainFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCargoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(cargoResponsableInput, mainFrame, getTestVar(Constants.CARGO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(tlf1Input, mainFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeEmailPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(emailPrincipalInput, mainFrame, getTestVar(Constants.EMAIL_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionComercial() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, mainFrame);

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioDrpDwn, "Comercial");
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(provinciaDrpDwn);
		webDriver.tabulateElement(provinciaInput);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(poblacionDrpDwn);
		webDriver.tabulateElement(poblacionInput);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(viaDrpDwn);
		webDriver.tabulateElement(viaInput);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionFiscal() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, mainFrame);

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioDrpDwn, "Fiscal");
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(provinciaDrpDwn);
		webDriver.tabulateElement(provinciaInput);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(poblacionDrpDwn);
		webDriver.tabulateElement(poblacionInput);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(viaDrpDwn);
		webDriver.tabulateElement(viaInput);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalProduccion() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, mainFrame);

		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioDrpDwn, "Postal producción");
		webDriver.click(direccionIgualFiscalBtn);
		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalRecibos() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioDrpDwn, "Postal recibos");
		webDriver.click(direccionIgualFiscalBtn);
		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalSiniestros() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(tipoDomicilioDrpDwn, "Postal siniestros");
		webDriver.click(direccionIgualFiscalBtn);
		webDriver.click(aceptarDireccionPostalBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addCompaniasPrincipales() {
		debugBegin();
		webDriver.appendTextInFrame(companiasPrincipalesInput, mainFrame, "Texto de las compañías principales");
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCuentaBancaria() {
		debugBegin();

		webDriver.appendTextInFrame(codigoIbanInput, mainFrame, "ES03");
		webDriver.appendTextInFrame(bancoInput, mainFrame, "2100");
		webDriver.appendTextInFrame(sucursalInput, mainFrame, "1234");
		webDriver.appendTextInFrame(dcInput, mainFrame, "5612");
		webDriver.appendTextInFrame(cta1Input, mainFrame, "3456");
		webDriver.appendTextInFrame(cta2Input, mainFrame, "7890");

		debugEnd();

		return this;
	}
	// endregion
}