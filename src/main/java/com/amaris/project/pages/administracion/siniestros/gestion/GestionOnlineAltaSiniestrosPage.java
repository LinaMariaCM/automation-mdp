package com.amaris.project.pages.administracion.siniestros.gestion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineAltaSiniestrosPage extends PageObject {

	// region webelements
	private By topFrame = By.cssSelector("#topFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By contentFrame = By.cssSelector("#blockrandom");

	private By txtNumPoliza = By.cssSelector("#numpol");
	private By txtFechaSiniestro = By.id("fsin");
	private By txtRefMediador = By.id("sref");

	private By comboCausa = By.id("selcausa");
	private By checkAsistencia = By.id("Requiereasistencia");

	private By txtDescripcion = By.id("causa");
	private By txtCosteAprox = By.id("coste");

	private By checkCuentaIndemnizacion = By.id("indem_sin");
	private By checkCuentaRecibos = By.id("cobro_rec");
	private By checkNuevaCuenta = By.id("nueva_cuenta");

	private By comboPaisIban = By.id("pais_iban");
	private By txtSwiftBic = By.id("swift_iban");
	private By txtIban1 = By.id("iban1");
	private By txtIban2 = By.id("iban2");
	private By txtIban3 = By.id("iban3");
	private By txtIban4 = By.id("iban4");
	private By txtIban5 = By.id("iban5");
	private By txtIban6 = By.id("iban6");

	private By buttonConvertirCC = By.id("convert_from_cc");
	private By txtCC1 = By.id("cuenta1");
	private By txtCC2 = By.id("cuenta2");
	private By txtCC3 = By.id("cuenta3");
	private By txtCC4 = By.id("cuenta4");

	private By comboRol = By.id("selrol_1");

	private By txtNombre = By.id("contnombre_1");
	private By txtApellido1 = By.id("contapellido1_1");
	private By txtApellido2 = By.id("contapellido2_1");
	private By txtTelefono = By.id("conttel_1");
	private By txtEmail = By.id("contmail_1");

	private By checkViveEnRiesgoSi = By.cssSelector("#PersonasContactoSi");
	private By checkViveEnRiesgoNo = By.id("PersonasContactoNo");
	private By checkViveEnRiesgoNsNc = By.id("PersonasContactoNS");

	private By comboProvincia = By.cssSelector("#contprovi_1_normalizada_chosen > a > span");
	private By comboLocalidad = By.cssSelector("#contloca_1_normalizada_chosen > a > span");
	private By comboTipoVia = By.cssSelector("#conttipvia_1_normalizada_chosen > a > span");
	private By comboNombreVia = By.cssSelector("#contnomvia_1_normalizada_chosen > a > span");

	private By txtCodigoPostal = By.id("contcp_1_normalizada");
	private By txtNumeroVia = By.id("contnum_1_normalizada");
	private By txtPiso = By.id("contpis_1_normalizada");
	private By txtPuerta = By.id("contpta_1_normalizada");

	private By buttonMasContactos = By.id("contplus");
	private By buttonMenosContactos = By.id("contminus");

	private By txtObservaciones = By.id("observaciones");

	private By comboTipoDocumento = By.id("seldoc_1");
	private By buttonSeleccionArchivo = By.id("adjdocu1");
	private By txtDescripcionDocu = By.id("descadjdocu_1");

	private By buttonBorrarAdjunto = By.id("deldocsel1");
	private By buttonEnviarSin = By.id("enviar");
	private By buttonImprimirSin = By.id("imprimir");
	private By buttonBorrarSin = By.id("borrar");

	private By modalOK = By.id("modalWindow");
	private By textoModalOK = By.cssSelector("#modalWindow > div.modal-body");

	private By modalSiniestroExiste = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-body > div");
	private By buttonExisteNo = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.null");
	private By buttonExisteSi = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.btn-primary");

	private DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
	// endregion

	public GestionOnlineAltaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineAltaSiniestrosPage altaInfoPoliza(String numpoliza, String fecha) {
		debugBegin();

		// webDriver.switchToFrame(contentFrame);

		webDriver.setTextInFrame(txtNumPoliza, contentFrame, numpoliza);

		debugInfo("Click en fecha");
		webDriver.removeAttributeInFrame(txtFechaSiniestro, contentFrame, "readonly");
		webDriver.clickInFrame(txtFechaSiniestro, contentFrame);
		webDriver.waitWithDriver(1500);

		if(fecha != "") {
			webDriver.setTextInFrame(txtFechaSiniestro, contentFrame, fecha);
		} else {
			webDriver.setTextInFrame(txtFechaSiniestro, contentFrame, fOcurrencia.format(new Date()));
		}

		webDriver.waitWithDriver(1500);
		debugInfo("Si todo bien, exit frame time");
		webDriver.waitWithDriver(1500);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(txtRefMediador, contentFrame);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaCausaDescripcion(String causa, String descripcion, String costeAprox) {
		debugBegin();

		String causaTxt = "";

		if(causa.equals("1")) causaTxt = "AGUA";
		else if(causa.equals("2")) causaTxt = "IMPAGO ALQUILERES";
		else if(causa.equals("3")) causaTxt = "EXPLOSION";
		else causaTxt = "AGUA";

		webDriver.clickElementFromDropDownByTextInFrame(comboCausa, contentFrame, causaTxt);
		webDriver.setTextInFrame(txtDescripcion, contentFrame, descripcion);
		webDriver.setTextInFrame(txtCosteAprox, contentFrame, costeAprox);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaCuentaSiniestro() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		if(!webDriver.isClickableAndClickInFrame(checkCuentaIndemnizacion, contentFrame)
			&& !webDriver.isClickableAndClickInFrame(checkCuentaRecibos, contentFrame)) {
			webDriver.clickInFrame(checkNuevaCuenta, contentFrame);
			webDriver.clickElementFromDropDownByAttribute(comboPaisIban, contentFrame, "value", "ES");
			webDriver.setTextInFrame(txtIban1, contentFrame, "ES21");
			webDriver.setTextInFrame(txtIban2, contentFrame, "2100");
			webDriver.setTextInFrame(txtIban3, contentFrame, "0001");
			webDriver.setTextInFrame(txtIban4, contentFrame, "0500");
			webDriver.setTextInFrame(txtIban5, contentFrame, "0000");
			webDriver.setTextInFrame(txtIban6, contentFrame, "0001");
		}

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaPersonaContacto(String rol, String nombre, String apellido1, String apellido2, String telefono, String email) {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByIndexInFrame(comboRol, contentFrame, 1);
		webDriver.setTextInFrame(txtNombre, contentFrame, nombre);
		webDriver.setTextInFrame(txtApellido1, contentFrame, apellido1);
		webDriver.setTextInFrame(txtApellido2, contentFrame, apellido2);
		webDriver.setTextInFrame(txtTelefono, contentFrame, telefono);
		webDriver.setTextInFrame(txtEmail, contentFrame, email);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaDireccionContacto(Boolean asegurado, String tipoVia, String nombreVia, String numVia, String piso, String puerta, String localidad, String provincia,
		String cp) {
		debugBegin();
		webDriver.waitWithDriver(3000);
		if(asegurado) {
			webDriver.clickInFrame(checkViveEnRiesgoSi, contentFrame);
		} else {
			// para este caso falta definir los valores correspondientes a la provincia y localidad. En proceso de
			// estudiar como debe funcionar exactamente!
			webDriver.clickInFrame(checkViveEnRiesgoNo, contentFrame);
			webDriver.clickElementFromDropDownByIndexInFrame(comboTipoVia, contentFrame, 1);
			webDriver.setTextInFrame(comboNombreVia, contentFrame, nombreVia);
			webDriver.setTextInFrame(txtNumeroVia, contentFrame, numVia);
			webDriver.setTextInFrame(txtPiso, contentFrame, piso);
			webDriver.setTextInFrame(txtPuerta, contentFrame, puerta);
		}

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaObservaciones(String observaciones) {
		debugBegin();

		webDriver.setTextInFrame(txtObservaciones, contentFrame, observaciones);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaDocumentoAdj() {
		debugBegin();

		// A especificar como hacerlo - PENDIENTE DE REVISIÓN

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickEnviar() {
		debugBegin();

		// if(webDriver.isClickable(buttonEnviarSin))webDriver.click(buttonEnviarSin);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buttonEnviarSin, contentFrame);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickImprimir() {
		debugBegin();

		webDriver.isClickableAndClick(buttonImprimirSin);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickBorrar() {
		debugBegin();

		webDriver.isClickableAndClick(buttonBorrarSin);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage checkYaExisteSiniestro() {
		debugBegin();

		webDriver.waitWithDriver(15000);

		webDriver.isClickableAndClick(buttonExisteSi);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage comprobarOK() {
		debugBegin();

		webDriver.waitWithDriver(25000);
		webDriver.waitForElementToBePresent(modalOK);
		webDriver.waitForElementToBeClickable(modalOK);
		webDriver.click(modalOK);
		debugInfo("Texto en modal ok: " + webDriver.getText(textoModalOK));
		webDriver.takeScreenshotWithCondition();

		debugEnd();

		return this;
	}

	/*
	 * public GestionOnlineAltaSiniestro acceptCookies() { debugBegin(); webDriver.waitWithDriver(2500);
	 * //webDriver.click(btnAceptarCookies); webDriver.click(btnAceptarCookies); ; debugEnd();
	 * 
	 * return this; }
	 * 
	 * public GestionOnlineAltaSiniestro createNewSimulation() { debugBegin();
	 * 
	 * webDriver.doubleClick(btnMutuaEdificioConfort); webDriver.doubleClick(btnNuevaSimulaion);
	 * 
	 * debugEnd();
	 * 
	 * return this; }
	 * 
	 * public GestionOnlineAltaSiniestro openContratarMutuaEdificioConfort() throws AWTException, InterruptedException,
	 * IOException { debugBegin();
	 * 
	 * webDriver.click(btnContratacion); webDriver.clickInFrame(drpdownComunidades, contentFrame);
	 * webDriver.clickInFrame(btnContratarMutuaEdificioConfort, contentFrame); webDriver.switchToWindow(1);
	 * webDriver.maximizeWindow();
	 * 
	 * debugEnd();
	 * 
	 * return this; }
	 * 
	 * public void openGestionCotizaciones() { debugBegin(); webDriver.click(btnMapaWeb);
	 * webDriver.doubleClickInFrame(btnGestionCotizaciones, mainFrame); debugEnd(); }
	 * 
	 * public GestionOnlineAltaSiniestro openGestionPolizas() { debugBegin(); webDriver.doubleClickInFrame(btnMapaWeb,
	 * topFrame); webDriver.doubleClickInFrame(btnGestionPolizas, mainFrame); debugEnd();
	 * 
	 * return this; }
	 */
	// endregion
}
