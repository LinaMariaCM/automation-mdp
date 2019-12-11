package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class MediadoresAltaMediadorPage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");

	private By drpdwnNivelEstructura = By.cssSelector("#MEDI_NIVEESTR");
	private By drpdwnActividadPrincipal = By.cssSelector("#MEDI_ACTIPRIN");
	private By txtContactoResponsable = By.cssSelector("#MEDI_PERSCONT");
	private By drpdwnIdioma = By.cssSelector("#MEDI_IDIOMA");
	private By txtTlf1 = By.cssSelector("#MEDI_TELEFONO1");
	private By drpdwnEjecutivoComercial = By.cssSelector("#MEDI_EJECCOME");

	private By txtProvincia = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By txtPoblacion = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By txtVia = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");

	private By btnComprobarDireccion = By.cssSelector("#BOTON_NORMADOM");
	private By btnAceptarDireccion = By.cssSelector("#BOTON_ACEPTAR");
	private By btnAceptarDireccionPostal = By.cssSelector("#BOTON_ACEPDOMI");
	private By btnAsignarDomicilio = By.cssSelector("#BOTON_DOMIMEDI");

	private By drpdwnTipoMediador = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By drpdwnTipoDocumento = By.cssSelector("#ALTAMEDI_TIPODOCMED");
	private By txtNumeroDocumento = By.cssSelector("#ALTAMEDI_NUMDOC");
	private By txtNumRegistroDGS = By.cssSelector("#ALTAMEDI_NREGDGS");
	private By txtCargoResponsable = By.cssSelector("#ALTAMEDI_CARGRESP");
	private By txtNombreFiscal = By.cssSelector("#ALTAMEDI_NOMFISCMED");
	private By txtPrimerApellido = By.cssSelector("#ALTAMEDI_APE1FISC");
	private By txtSegundoApellido = By.cssSelector("#ALTAMEDI_APE2FISC");
	private By txtEmailPrincipal = By.cssSelector("#ALTAMEDI_EMAILPRI");
	private By drpdwnTipoDomicilio = By.cssSelector("#ALTAMEDI_TIPDOMME");
	private By radioNombreComercialIgualFiscal = By.cssSelector("#ALTAMEDI_NOMCOIGU");
	private By radioNombreComercialDiferenteFiscal = By.cssSelector("#ALTAMEDI_NOMCODIF");
	private By radioDireccionIgualFiscal = By.cssSelector("#ALTAMEDI_IGUFISC");
	private By txtNombreComercial = By.cssSelector("#ALTAMEDI_OTRONOMB");
	private By tieneOficinasNo = By.cssSelector("#ALTAMEDI_OFINO");
	private By colaboradresExternosNo = By.cssSelector("#ALTAMEDI_TRABAJANO");
	private By softwareGestionNo = By.cssSelector("#ALTAMEDI_SOFTNO");
	private By companiasPrincipales = By.cssSelector("#ALTAMEDI_COMPPRIN");

	private By btnContinuar = By.cssSelector("#botonContinuar1");
	private By btnGrabar = By.cssSelector("#botonGrabar1");
	private By drpdwnProvincia = By.cssSelector("body > ul:nth-child(4)");
	private By drpdwnPoblacion = By.cssSelector("body > ul:nth-child(5)");
	private By drpdwnVia = By.cssSelector("body > ul:nth-child(6)");
	private By anyadirNuevaDireccion = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");

	// Datos transaccionales page elements.
	private By txtCodigoIban = By.cssSelector("#COMODIN_CADENA");
	private By txtBanco = By.cssSelector("#COMODIN_CADENA_1");
	private By txtSucursal = By.cssSelector("#COMODIN_CADENA_2");
	private By txtDc = By.cssSelector("#COMODIN_CADENA_3");
	private By txtCta1 = By.cssSelector("#COMODIN_CADENA_4");
	private By txtCta2 = By.cssSelector("#COMODIN_CADENA_5");
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
		webDriver.clickInFrame(btnGrabar, mainFrame);

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectNivelEstructura() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnNivelEstructura, mainFrame, getTestVar(Constants.NIVEL_ESTRUCTURA));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectEjecutivoComercial() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnEjecutivoComercial, mainFrame, getTestVar(Constants.EJECUTIVO_COMERCIAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoMediador() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnTipoMediador, mainFrame, getTestVar(Constants.TIPO_MEDIADOR));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTipoDocumento() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnTipoDocumento, mainFrame, getTestVar(Constants.TIPO_DOCUMENTO));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroDocumento() {
		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			setTestVar(Constants.DOCUMENTO_MEDIADOR, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(txtNumeroDocumento, mainFrame, getTestVar(Constants.DOCUMENTO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNombreFiscalYApellidosMediador() {
		debugBegin();
		// When CIF, only the Nombre Fiscal field appears.
		if(getTestVar(Constants.TIPO_DOCUMENTO) != null
			&& getTestVar(Constants.TIPO_DOCUMENTO).equals(Constants.NIF)) {
			webDriver.appendTextInFrame(txtNombreFiscal, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}
		// When NIF or NIE, also shows surname fields. Second surname only mandatory for NIF.
		else {
			webDriver.appendTextInFrame(txtNombreFiscal, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
			webDriver.appendTextInFrame(txtPrimerApellido, mainFrame, getTestVar(Constants.PRIMER_APELLIDO_MEDIADOR));
			webDriver.appendTextInFrame(txtSegundoApellido, mainFrame, getTestVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNombreComercialMediador() {
		debugBegin();

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Igual que el fiscal")) {
			// Cuando nombre comercial es igual al fiscal, solo hay que marcar el radio button.
			webDriver.clickInFrame(radioNombreComercialIgualFiscal, mainFrame);
		}

		if(getTestVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Diferente que el fiscal")) {
			// Cuando nombre comercial es diferente que el fiscal, hay que marcar el radio button y completar el nombre
			// comercial (by default it is
			// the same as the nombre fiscal).
			webDriver.clickInFrame(radioNombreComercialDiferenteFiscal, mainFrame);
			webDriver.appendTextInFrame(txtNombreComercial, mainFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectActividadPrincipal() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnActividadPrincipal, mainFrame, getTestVar(Constants.ACTIVIDAD_PRINCIPAL));

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectIdioma() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnIdioma, mainFrame, getTestVar(Constants.IDIOMA));

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeNumeroRegistroDGS() {
		debugBegin();
		// Solo requiere Nº registo DGSFP cuando el tipo mediador es "Agente vinculado", "BS Exclusivo", "BS Vinculado",
		// o "Corredor".
		if(getTestVar(Constants.TIPO_MEDIADOR) != null && getTestVar(Constants.TIPO_MEDIADOR).equals("Agente vinculado")
			|| getTestVar(Constants.TIPO_MEDIADOR).equals("BS Exclusivo") || getTestVar(Constants.TIPO_MEDIADOR).equals("Corredor")) {
			webDriver.appendTextInFrame(txtNumRegistroDGS, mainFrame, getTestVar(Constants.DGS));
		}

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectTieneOficinas() {
		debugBegin();
		webDriver.clickInFrame(tieneOficinasNo, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectColaboradoresExternos() {
		debugBegin();
		webDriver.clickInFrame(colaboradresExternosNo, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage selectSoftwareGestion() {
		debugBegin();
		webDriver.clickInFrame(softwareGestionNo, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, mainFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeContactoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(txtContactoResponsable, mainFrame, getTestVar(Constants.CONTACTO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCargoResponsable() {
		debugBegin();
		webDriver.appendTextInFrame(txtCargoResponsable, mainFrame, getTestVar(Constants.CARGO_RESPONSABLE));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeTelefonoUno() {
		debugBegin();
		webDriver.appendTextInFrame(txtTlf1, mainFrame, getTestVar(Constants.TLF_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeEmailPrincipal() {
		debugBegin();
		webDriver.appendTextInFrame(txtEmailPrincipal, mainFrame, getTestVar(Constants.EMAIL_PRINCIPAL));
		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionComercial() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccion, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(drpdwnTipoDomicilio, "Comercial");
		webDriver.appendText(txtProvincia, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(drpdwnProvincia);
		webDriver.tabulateElement(txtProvincia);
		webDriver.appendText(txtPoblacion, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(drpdwnPoblacion);
		webDriver.tabulateElement(txtPoblacion);
		webDriver.appendText(txtVia, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(drpdwnVia);
		webDriver.tabulateElement(txtVia);
		webDriver.click(btnComprobarDireccion);
		webDriver.click(btnAceptarDireccion);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionFiscal() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccion, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(drpdwnTipoDomicilio, "Fiscal");
		webDriver.appendText(txtProvincia, getTestVar(Constants.PROVINCIA));
		webDriver.waitForElementToBeClickable(drpdwnProvincia);
		webDriver.tabulateElement(txtProvincia);
		webDriver.appendText(txtPoblacion, getTestVar(Constants.POBLACION));
		webDriver.waitForElementToBeClickable(drpdwnPoblacion);
		webDriver.tabulateElement(txtPoblacion);
		webDriver.appendText(txtVia, getTestVar(Constants.NOMBRE_VIA));
		webDriver.waitForElementToBeClickable(drpdwnVia);
		webDriver.tabulateElement(txtVia);
		webDriver.click(btnComprobarDireccion);
		webDriver.click(btnAceptarDireccion);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalProduccion() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccion, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(drpdwnTipoDomicilio, "Postal producción");
		webDriver.click(radioDireccionIgualFiscal); // Click radio button "Igual a la fiscal".
		webDriver.click(btnAceptarDireccionPostal);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalRecibos() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccion, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(drpdwnTipoDomicilio, "Postal recibos");
		webDriver.click(radioDireccionIgualFiscal); // Click radio button "Igual a la fiscal".
		webDriver.click(btnAceptarDireccionPostal);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addDireccionPostalSiniestros() {
		debugBegin();

		webDriver.clickInFrame(anyadirNuevaDireccion, mainFrame);
		webDriver.switchToFrame(mainFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByText(drpdwnTipoDomicilio, "Postal siniestros");
		webDriver.click(radioDireccionIgualFiscal); // Click radio button "Igual a la fiscal".
		webDriver.click(btnAceptarDireccionPostal);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage addCompaniasPrincipales() {
		debugBegin();
		webDriver.appendTextInFrame(companiasPrincipales, mainFrame, "Texto de las compañías principales");

		debugEnd();

		return this;
	}

	public MediadoresAltaMediadorPage writeCuentaBancaria() {
		debugBegin();

		webDriver.appendTextInFrame(txtCodigoIban, mainFrame, "ES03");
		webDriver.appendTextInFrame(txtBanco, mainFrame, "2100");
		webDriver.appendTextInFrame(txtSucursal, mainFrame, "1234");
		webDriver.appendTextInFrame(txtDc, mainFrame, "5612");
		webDriver.appendTextInFrame(txtCta1, mainFrame, "3456");
		webDriver.appendTextInFrame(txtCta2, mainFrame, "7890");

		debugEnd();

		return this;
	}
	// endregion
}
