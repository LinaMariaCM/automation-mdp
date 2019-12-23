package com.amaris.project.pages.administracion.siniestros.gestion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;

public class GestionOnlineAltaSiniestrosPage extends PageObject {

	// region WebElements
	private By topFrame = By.cssSelector("#topFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By contentFrame = By.cssSelector("#blockrandom");

	private By numPolizaInput = By.cssSelector("#numpol");
	private By fechaSiniestroInput = By.id("fsin");
	private By txtRefMediador = By.id("sref");

	private By causaDrpDwn = By.id("selcausa");
	private By asistenciaBtn = By.id("Requiereasistencia");

	private By descripcionInput = By.id("causa");
	private By costeAproxInput = By.id("coste");

	private By cuentaIndemnizacionBtn = By.id("indem_sin");
	private By cuentaRecibosBtn = By.id("cobro_rec");
	private By nuevaCuentaBtn = By.id("nueva_cuenta");

	private By paisIbanDrpDwn = By.id("pais_iban");
	private By swiftBicInput = By.id("swift_iban");
	private By iban1Input = By.id("iban1");
	private By iban2Input = By.id("iban2");
	private By iban3Input = By.id("iban3");
	private By iban4Input = By.id("iban4");
	private By iban5Input = By.id("iban5");
	private By iban6Input = By.id("iban6");

	private By convertirCCBtn = By.id("convert_from_cc");
	private By cc1Input = By.id("cuenta1");
	private By cc2Input = By.id("cuenta2");
	private By cc3Input = By.id("cuenta3");
	private By cc4Input = By.id("cuenta4");

	private By rolDrpDwn = By.id("selrol_1");

	private By nombreInput = By.id("contnombre_1");
	private By apellido1Input = By.id("contapellido1_1");
	private By apellido2Input = By.id("contapellido2_1");
	private By telefonoInput = By.id("conttel_1");
	private By emailInput = By.id("contmail_1");

	private By viveEnRiesgoSiBtn = By.cssSelector("#PersonasContactoSi");
	private By viveEnRiesgoNoBtn = By.id("PersonasContactoNo");
	private By viveEnRiesgoNsNcBtn = By.id("PersonasContactoNS");

	private By provinciaDrpDwn = By.cssSelector("#contprovi_1_normalizada_chosen > a > span");
	private By localidadDrpDwn = By.cssSelector("#contloca_1_normalizada_chosen > a > span");
	private By tipoViaDrpDwn = By.cssSelector("#conttipvia_1_normalizada_chosen > a > span");
	private By nombreViaInput = By.cssSelector("#contnomvia_1_normalizada_chosen > a > span");

	private By codigoPostalInput = By.id("contcp_1_normalizada");
	private By numeroViaInput = By.id("contnum_1_normalizada");
	private By pisoInput = By.id("contpis_1_normalizada");
	private By puertaInput = By.id("contpta_1_normalizada");

	private By masContactosBtn = By.id("contplus");
	private By menosContactosBtn = By.id("contminus");

	private By observacionesInput = By.id("observaciones");

	private By tipoDocumentoDrpDwn = By.id("seldoc_1");
	private By seleccionArchivoBtn = By.id("adjdocu1");
	private By descripcionDocuInput = By.id("descadjdocu_1");

	private By borrarAdjuntoBtn = By.id("deldocsel1");
	private By enviarSinBtn = By.id("enviar");
	private By imprimirSinBtn = By.id("imprimir");
	private By borrarSinBtn = By.id("borrar");

	private By okModal = By.id("modalWindow");
	private By okModalTxt = By.cssSelector("#modalWindow > div.modal-body");

	private By siniestroExisteModal = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-body > div");
	private By existeNoBtn = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.null");
	private By existeSiBtn = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.btn-primary");
	// endregion

	public GestionOnlineAltaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineAltaSiniestrosPage altaInfoPoliza(String numpoliza, String fecha) {
		debugBegin();

		webDriver.setTextInFrame(numPolizaInput, contentFrame, numpoliza);

		debugInfo("Click en fecha");
		webDriver.removeAttributeInFrame(fechaSiniestroInput, contentFrame, "readonly");
		webDriver.clickInFrame(fechaSiniestroInput, contentFrame);
		webDriver.waitWithDriver(1500);

		if(fecha.isEmpty()) {
			fecha = DateUtils.getTodayDate(DateUtils.DATE_FORMAT);
		}

		webDriver.setTextInFrame(fechaSiniestroInput, contentFrame, fecha);

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

		if(causa.equals("1")) {
			causaTxt = "AGUA";
		} else if(causa.equals("2")) {
			causaTxt = "IMPAGO ALQUILERES";
		} else if(causa.equals("3")) {
			causaTxt = "EXPLOSION";
		} else {
			causaTxt = "AGUA";
		}

		webDriver.clickElementFromDropDownByTextInFrame(causaDrpDwn, contentFrame, causaTxt);
		webDriver.setTextInFrame(descripcionInput, contentFrame, descripcion);
		webDriver.setTextInFrame(costeAproxInput, contentFrame, costeAprox);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaCuentaSiniestro() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		if(!webDriver.isClickableAndClickInFrame(cuentaIndemnizacionBtn, contentFrame)
			&& !webDriver.isClickableAndClickInFrame(cuentaRecibosBtn, contentFrame)) {
			webDriver.clickInFrame(nuevaCuentaBtn, contentFrame);
			webDriver.clickElementFromDropDownByAttribute(paisIbanDrpDwn, contentFrame, "value", "ES");
			webDriver.setTextInFrame(iban1Input, contentFrame, "ES21");
			webDriver.setTextInFrame(iban2Input, contentFrame, "2100");
			webDriver.setTextInFrame(iban3Input, contentFrame, "0001");
			webDriver.setTextInFrame(iban4Input, contentFrame, "0500");
			webDriver.setTextInFrame(iban5Input, contentFrame, "0000");
			webDriver.setTextInFrame(iban6Input, contentFrame, "0001");
		}

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaPersonaContacto(String rol, String nombre, String apellido1, String apellido2, String telefono, String email) {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, contentFrame, 1);
		webDriver.setTextInFrame(nombreInput, contentFrame, nombre);
		webDriver.setTextInFrame(apellido1Input, contentFrame, apellido1);
		webDriver.setTextInFrame(apellido2Input, contentFrame, apellido2);
		webDriver.setTextInFrame(telefonoInput, contentFrame, telefono);
		webDriver.setTextInFrame(emailInput, contentFrame, email);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaDireccionContacto(Boolean asegurado, String tipoVia, String nombreVia, String numVia,
		String piso, String puerta, String localidad, String provincia, String cp) {
		debugBegin();
		
		webDriver.waitWithDriver(3000);
		if(asegurado) {
			webDriver.clickInFrame(viveEnRiesgoSiBtn, contentFrame);
		} else {
			// Para este caso falta definir los valores correspondientes a la provincia y localidad. En proceso de
			// estudiar como debe funcionar exactamente!
			webDriver.clickInFrame(viveEnRiesgoNoBtn, contentFrame);
			webDriver.clickElementFromDropDownByIndexInFrame(tipoViaDrpDwn, contentFrame, 1);
			webDriver.setTextInFrame(nombreViaInput, contentFrame, nombreVia);
			webDriver.setTextInFrame(numeroViaInput, contentFrame, numVia);
			webDriver.setTextInFrame(pisoInput, contentFrame, piso);
			webDriver.setTextInFrame(puertaInput, contentFrame, puerta);
		}

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaObservaciones(String observaciones) {
		debugBegin();

		webDriver.setTextInFrame(observacionesInput, contentFrame, observaciones);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage altaDocumentoAdj() {
		debugBegin();

		// TODO A especificar como hacerlo - PENDIENTE DE REVISIÓN

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickEnviar() {
		debugBegin();

		// if(webDriver.isClickable(buttonEnviarSin))webDriver.click(buttonEnviarSin);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(enviarSinBtn, contentFrame);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickImprimir() {
		debugBegin();

		webDriver.isClickableAndClick(imprimirSinBtn);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage clickBorrar() {
		debugBegin();

		webDriver.isClickableAndClick(borrarSinBtn);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage checkYaExisteSiniestro() {
		debugBegin();

		webDriver.waitWithDriver(15000);

		webDriver.isClickableAndClick(existeSiBtn);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestrosPage comprobarOk() {
		debugBegin();

		webDriver.waitWithDriver(25000);
		
		webDriver.click(okModal);
		
		debugInfo("Texto en modal ok: " + webDriver.getText(okModalTxt));
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
