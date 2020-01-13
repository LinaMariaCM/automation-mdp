package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class OtrosImplicadosDatosSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By anotacionesBtn = By.cssSelector("#enlaceDialogo > span");
	private By volverBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By anyadirNuevoImplicadoBtn = By.cssSelector("[onclick*='addImplicado()']");
	private By continuarBtn = By.id("botonContinuar");
	private By grabarBtn = By.id("botonGrabar");
	private By tipologiaDrpDwn = By.id("OTRIMPLI");
	private By rolDrpDwn = By.id("implicado_rol");

	private By nombreInput = By.id("nombre");
	private By apellido1Input = By.id("apellido1");
	private By apellido2Input = By.id("apellido2");
	private By tipoDocumentoDrpDwn = By.id("tipodocu");
	private By numeroDocumentoInput = By.id("numedocu");
	private By telefono1Input = By.id("telefono1");
	private By telefono2Input = By.id("telefono2");
	private By sexoDrpDwn = By.id("sexocon");
	private By emailInput = By.id("email");
	private By emailNoDisponbleBtn = By.id("emailnodisp");

	private By tipoViaDrpDwn = By.id("tipovia");
	private By calleInput = By.id("calle");
	private By numeroInput = By.id("numero");
	private By pisoInput = By.id("label37");
	private By puertaInput = By.id("label380");
	private By cpInput = By.id("cp");
	private By poblacionInput = By.id("poblacion");
	private By provinciaDrpDwn = By.id("provincia");

	private By ibanInput = By.id("codIban");
	private By bancoInput = By.id("codBan");
	private By sucursalInput = By.id("codSuc");
	private By dcInput = By.id("codDig");
	private By numCuentaInput = By.id("codCue");
	private By ibanNoDisponbleBtn = By.id("ibannodisp");

	private By companiaDrpDwn = By.id("companiaSOA");
	private By polizaInput = By.id("numpoliza");
	private By refContrariaInput = By.id("referencia");
	private By correoEInput = By.id("correoElectronico");

	private By ibanObligatorioTxt = By.id("obligaCodIban");
	private By emailObligatorioTxt = By.id("obligaMail");

	// endregion

	public OtrosImplicadosDatosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	// public SiniestrosOtrosImplicadosDatos introducirDatosPersonales(String tipologia, String rol, String nombre,
	// String apellido1, String apellido2, String tipoDocumento, String numDocumento, String telefono1,

	public OtrosImplicadosDatosSiniestrosPage introducirDatosPersonales(String rol, String nombre, String apellido1, String apellido2,
		String tipoDocumento, String numDocumento, String telefono1, String telefono2, String sexo, String email) {
		debugBegin();

		// webDriver.clickElementFromDropDownByAttribute(comboTipologia, "value", tipologia);
		webDriver.clickElementFromDropDownByIndexInFrame(tipologiaDrpDwn, cuerpoFrame, 2);
		// webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);
		webDriver.waitWithDriver(8000);
		webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 8);

		if(nombre != null && !nombre.isEmpty()) {
			webDriver.setTextInFrame(nombreInput, cuerpoFrame, nombre);
		} else {
			webDriver.setTextInFrame(nombreInput, cuerpoFrame, "Nombre" + Integer.toString((int) (Math.random() * 100)));
		}

		if(apellido1 != null && !apellido1.isEmpty()) {
			webDriver.setTextInFrame(apellido1Input, cuerpoFrame, apellido1);
		} else {
			webDriver.setTextInFrame(apellido1Input, cuerpoFrame, "Nombre" + Integer.toString((int) (Math.random() * 100)));
		}

		if(apellido2 != null && !apellido2.isEmpty()) {
			webDriver.setTextInFrame(apellido2Input, cuerpoFrame, apellido2);
		} else {
			webDriver.setTextInFrame(apellido2Input, cuerpoFrame, "Nombre" + Integer.toString((int) (Math.random() * 100)));
		}

		// webDriver.clickElementFromDropDownByAttribute(comboTipoDocumento, "value", tipoDocumento);
		webDriver.clickElementFromDropDownByIndexInFrame(tipoDocumentoDrpDwn, cuerpoFrame, 1);

		if(numDocumento != null && !numDocumento.isEmpty()) {
			webDriver.setTextInFrame(numeroDocumentoInput, cuerpoFrame, numDocumento);
		} else {
			webDriver.setTextInFrame(numeroDocumentoInput, cuerpoFrame, DniGeneratorHelper.generateNif());
		}

		if(telefono1 != null && !telefono1.isEmpty()) {
			webDriver.setTextInFrame(telefono1Input, cuerpoFrame, telefono1);
		} else {
			webDriver.setTextInFrame(telefono1Input, cuerpoFrame, "961234567");
		}

		if(telefono2 != null && !telefono2.isEmpty()) {
			webDriver.setTextInFrame(telefono2Input, cuerpoFrame, telefono2);
		} else {
			webDriver.setTextInFrame(telefono2Input, cuerpoFrame, "961234567");
		}

		// webDriver.clickElementFromDropDownByAttribute(comboSexo, "value", sexo);
		if(sexo != null && !sexo.isEmpty()) {
			webDriver.clickElementFromDropDownByIndexInFrame(sexoDrpDwn, cuerpoFrame, 1);
		}

		/*
		 * if(email != null && email.isEmpty()) { setDisponibilidadEmail(false); } else { if(email != null &&
		 * email.isEmpty()) { webDriver.setText(txtEmail, email); } else { webDriver.setText(txtEmail,
		 * "prueba@esto.es"); } }
		 */
		/*
		 * método bueno, estudiar por qué falla para incorporarlo cuando sepa por qué if(email == null &&
		 * email.isEmpty()){ webDriver.click(checkEmailNoDisponble); }else{ webDriver.appendText(txtEmail, email); }
		 */

		webDriver.clickInFrame(emailNoDisponbleBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage introducirDatosDireccion(String tipoVia, String calle, String numero, String piso, String puerta, 
		String cp, String poblacion, String provincia, String iban, String banco, String sucursal, String dc, String nCuenta) {
		debugBegin();

		// if añadido por Antonia el 19/12/ falta incorporar datos en csv, para pasar alguna dirección del riesgo
		if(tipoVia != null && !tipoVia.isEmpty() && calle != null && !calle.isEmpty() && numero != null && !numero.isEmpty() 
			&& piso != null && !piso.isEmpty() && puerta != null && !puerta.isEmpty() && cp != null && !cp.isEmpty() 
			&& poblacion != null && !poblacion.isEmpty() && provincia != null && !provincia.isEmpty()) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoViaDrpDwn, cuerpoFrame, "value", tipoVia);
			
			webDriver.setTextInFrame(calleInput, cuerpoFrame, calle);
			webDriver.setTextInFrame(numeroInput, cuerpoFrame, numero);
			webDriver.setTextInFrame(pisoInput, cuerpoFrame, piso);
			webDriver.setTextInFrame(puertaInput, cuerpoFrame, puerta);
			webDriver.setTextInFrame(cpInput, cuerpoFrame, cp);
			webDriver.setTextInFrame(poblacionInput, cuerpoFrame, poblacion);
			
			webDriver.clickElementFromDropDownByAttributeInFrame(provinciaDrpDwn, cuerpoFrame, "value", provincia);
		}

		if(iban != null && !iban.isEmpty() && banco != null && !banco.isEmpty() && sucursal != null && !sucursal.isEmpty() 
			&& dc != null && !dc.isEmpty() && nCuenta != null && !nCuenta.isEmpty()) {
			webDriver.appendTextInFrame(ibanInput, cuerpoFrame, iban);
			webDriver.appendTextInFrame(bancoInput, cuerpoFrame, banco);
			webDriver.appendTextInFrame(sucursalInput, cuerpoFrame, sucursal);
			webDriver.appendTextInFrame(dcInput, cuerpoFrame, dc);
			webDriver.appendTextInFrame(numCuentaInput, cuerpoFrame, nCuenta);
		} else {
			webDriver.clickInFrame(ibanNoDisponbleBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage introducirDatosCompaniaPrivada(String compania, String poliza, String referenciaContra, String correoE) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttribute(companiaDrpDwn, "value", compania);
		webDriver.setText(polizaInput, poliza);
		webDriver.setText(refContrariaInput, referenciaContra);
		webDriver.setText(correoEInput, correoE);

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage clickGrabar() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// ---------------------RETENCIONES-----------------------------------------------
	public OtrosImplicadosDatosSiniestrosPage otrosImplicadosFalloVacio() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_IMPLICADO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage tipologiaImplicadoFalloVacio() {
		debugBegin();
		
		webDriver.clickInFrame(anyadirNuevoImplicadoBtn, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPOLOGIA_IMPLICADO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage seleccionarTipologiaImplicado() {
		return seleccionarTipologiaImplicado("Causante");
	}

	public OtrosImplicadosDatosSiniestrosPage seleccionarTipologiaImplicado(String opcion) {
		debugBegin();

		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(tipologiaDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Causante":
				webDriver.clickElementFromDropDownByIndexInFrame(tipologiaDrpDwn, cuerpoFrame, 1);
				break;
			case "Lesionado":
				webDriver.clickElementFromDropDownByIndexInFrame(tipologiaDrpDwn, cuerpoFrame, 2);
				break;
			case "Perjudicado":
				webDriver.clickElementFromDropDownByIndexInFrame(tipologiaDrpDwn, cuerpoFrame, 3);
				break;
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage rolImplicadoFalloVacio() {
		debugBegin();

		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ROL);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage seleccionarRolImplicado() {
		return seleccionarRolImplicado("Tomador");
	}

	public OtrosImplicadosDatosSiniestrosPage seleccionarRolImplicado(String opcion) {
		debugBegin();

		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Tomador":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 1);
				break;
			case "Empleado Comunidad de Propietarios":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 2);
				break;
			case "Portero":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 3);
				break;
			case "Asegurado":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 4);
				break;
			case "Copropietario":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 5);
				break;
			case "Inquilino":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 6);
				break;
			case "Presidente":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 7);
				break;
			case "No perteneciente al riesgo":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, cuerpoFrame, 8);
				break;
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage nombreImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(nombreInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_IMPLICADO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirNombreImplicado() {
		debugBegin();
		webDriver.setTextInFrame(nombreInput, cuerpoFrame, "Nombre");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage telefonoPrimeroImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(telefono1Input, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_1);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirTelefonoPrimeroImplicado() {
		debugBegin();
		webDriver.setTextInFrame(telefono1Input, cuerpoFrame, "698745896");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage telefonoSegundoImplicadoFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(telefono2Input, cuerpoFrame, "14587fhtp");
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_2);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirTelefonoSegundoImplicado() {
		debugBegin();
		webDriver.setTextInFrame(telefono2Input, cuerpoFrame, "698745896");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage emailImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(emailInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage emailImplicadoFalloFormatoIncorrecto() {
		debugBegin();

		escribirEmailImplicado("prueba@prueba");
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirEmailImplicado(String email) {
		debugBegin();
		webDriver.setTextInFrame(emailInput, cuerpoFrame, email);
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage setDisponibilidadEmail(boolean value) {
		debugBegin();

		webDriver.clickInFrame(emailNoDisponbleBtn, cuerpoFrame);

		if(value != webDriver.getAttributeInFrame(emailObligatorioTxt, cuerpoFrame, "style").contains("display : inline;")) {
			webDriver.clickInFrame(emailNoDisponbleBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage ibanImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(ibanInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CODIGO_IBAN);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirIbanImplicado(String iban) {
		debugBegin();
		webDriver.setTextInFrame(ibanInput, cuerpoFrame, iban);
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage bancoImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(bancoInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_BANCO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirBancoImplicado() {
		debugBegin();
		webDriver.setTextInFrame(bancoInput, cuerpoFrame, "1542");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage sucursalImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(sucursalInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SUCURSAL);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirSucursalImplicado() {
		debugBegin();
		webDriver.setTextInFrame(sucursalInput, cuerpoFrame, "1478");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage dcImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(dcInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DC);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirDcImplicado() {
		debugBegin();
		webDriver.setTextInFrame(dcInput, cuerpoFrame, "1479");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage numeroCuentaImplicadoFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(numCuentaInput, cuerpoFrame);
		clickGrabar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_DE_CUENTA);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage escribirNumeroCuentaImplicado() {
		debugBegin();
		webDriver.setTextInFrame(numCuentaInput, cuerpoFrame, "2278");
		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage setDisponibilidadIban(boolean value) {
		webDriver.clickInFrame(ibanNoDisponbleBtn, cuerpoFrame);

		if(value != webDriver.getAttributeInFrame(ibanObligatorioTxt, cuerpoFrame, "style").equals("display : inline;")) {
			webDriver.clickInFrame(ibanNoDisponbleBtn, cuerpoFrame);
		}

		return this;
	}

}
