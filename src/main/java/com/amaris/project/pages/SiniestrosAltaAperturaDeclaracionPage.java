package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiniestrosAltaAperturaDeclaracionPage extends PageObject {

	// // region webelements
	// ##### FRAMES #####
	private By leftFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By cuerpoFrame = By.id("mainFrame");
	private By modalFrame = By.id("capaIframe");

	// Consulta póliza
	private By buttonConsultaPoliza = By.id("enlacePoliza");
	private By buttonPersonaContacto = By.id("enlaceDatContacPer");
	private By buttonVolverBuscador = By.id("enlacePoliza");

	// ##### DATOS OCURRENCIA #####
	private By txtFechaOcurrencia = By.id("fechsini");

	// ##### DATOS DECLARACION ####
	private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
	private By comboTipoDeclarante = By.id("tipodecl");
	private By medioDeclaracionCorreoElec = By.cssSelector("#mododecl > option:nth-child(2)");
	private By comboMedioDeclaracion = By.id("mododecl");
	private By txtObservaciones = By.id("comentario");
	private By txtFechaDenuncia = By.id("FECHDENU");
	private By txtNombreDeclarante = By.id("nombpers");
	private By txtPrimerApellido = By.id("ape1pers");
	private By txtSegundoApellido = By.id("ape2pers");
	private By txtTelefono = By.id("telefono1");
	private By comboPrefijo = By.id("ESTRUCTU");
	private By txtEmail = By.id("email");
	private By checkEmailNoDisponible = By.id("emailnodisp");

	// ##### OTROS DATOS ####
	private By comboElementoAfectado = By.id("ESTRUCTU");
	private By comboInstalacionAfectada = By.id("INSTALAC");
	private By txtReferenciaExternaMed = By.id("nombdato_REFEEXTR_1");
	private By radioCarpetaFisicaSi = By.id("fisicoSi");
	private By radioCarpetaFisicaNo = By.id("fisicoNo");

	// ##### ASISTENCIA #####
	private By rdbtnAsistenciaSi = By.id("asistenciaSi");
	private By rdbtnAsistenciaNo = By.id("asistenciaNo");
	private By rdbtnUrgenteSi = By.id("resolUrgeSi");
	private By rdbtnUrgenteNo = By.id("resolUrgeNo");
	private By comboMotivo = By.id("MOTIASIS");
	private By txtUbicacionDanos = By.id("nombdato_UBICADAN_1");
	private By rdbtnReparadoSi = By.id("origDanyoSi");
	private By rdbtnReparadoNo = By.id("origDanyoNo");
	private By rdbtnConsecuenciasSi = By.id("consecDanyoSi");
	private By rdbtnConsecuenciasNo = By.id("consecDanyoNo");
	private By txtRefAsistenciaExt = By.id("nombdato_REFEEXAS_1");
	private By btnContinuar = By.id("botonContinuar");

	// #### BOTONES EXTRA (escenarios fallo) ####
	private By labelErrorEnDeclaracion = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By btnVolver = By.id("botonVolver");

	// #### DATOS PERSONA CONTACTO ####
	private By comboRol = By.id("rol");
	private By txtNombre = By.id("nombre");
	private By txt1Apellido = By.id("apellido1");
	private By txt2Apellido = By.id("apellido2");
	private By comboTipoDoc = By.id("tipodocu");
	private By txtDocumento = By.id("numedocu");
	private By comboPrefijo1 = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(8) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	private By comboPrefijo2 = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(9) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	private By txtTelefono1 = By.id("telefono1");
	private By txtTelefono2 = By.id("telefono2");
	private By comboSexo = By.id("sexocon");
	private By txtEmail2 = By.id("email");

	private By checkNoEmail = By.id("emailnodisp");
	private By checkRiesgoAsegurado = By.cssSelector("#seccionDatosPersonaContacto > div.sis-col-80 > div > label > input");

	private By comboTipoVia = By.id("tipovia");
	private By txtVia = By.id("calle");
	private By txtNumero = By.id("numero");
	private By txtPiso = By.id("label37");
	private By txtPuerta = By.id("label380");
	private By txtCodPostal = By.id("cp");
	private By txtPoblacion = By.id("poblacion");
	private By comboProvincia = By.id("provincia");
	private By btnGrabar = By.id("buttonRecord");
	private By btnCancelar = By.id("buttonCancel");
	// endregion

	public SiniestrosAltaAperturaDeclaracionPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public SiniestrosAltaAperturaDeclaracionPage altaDatosBasicos(String tipoDeclarante, String medioDeclaracion) {
		debugBegin();

		DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");

		webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fOcurrencia.format(new Date()));
		debugInfo(tipoDeclarante + "declarando a través de" + medioDeclaracion);
		// webDriver.clickElementFromDropDownByAttribute(comboTipoDeclarante, "value",
		// tipoDeclarante);//Añadir los tipos de value como comentario
		// webDriver.clickElementFromDropDownByAttribute(comboMedioDeclaracion, "value", medioDeclaracion);
		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 4);
		webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 2);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaDatosDeclaracion(String fechaOcurrencia, String tipoDeclarante, String medioDeclaracion, String fechaDenuncia, String observaciones) {
		debugBegin();

		webDriver.appendText(txtFechaOcurrencia, fechaOcurrencia);

		// Añadir los tipos de value como comentario
		webDriver.clickElementFromDropDownByAttributeInFrame(comboTipoDeclarante, cuerpoFrame, "value", tipoDeclarante);
		webDriver.clickElementFromDropDownByAttributeInFrame(comboMedioDeclaracion, cuerpoFrame, "value", medioDeclaracion);
		webDriver.appendTextInFrame(txtFechaDenuncia, cuerpoFrame, fechaDenuncia);
		webDriver.appendTextInFrame(txtObservaciones, cuerpoFrame, observaciones);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaDatosDeclarante(String nombreDeclarante, String apellidoDeclarante, String segundoApellido, String prefijoTelefono, String numeroTelefono, String emailDeclarante,
		boolean noDisponible) {
		debugBegin();

		webDriver.appendTextInFrame(txtNombreDeclarante, cuerpoFrame, nombreDeclarante);
		webDriver.appendTextInFrame(txtPrimerApellido, cuerpoFrame, apellidoDeclarante);
		webDriver.appendTextInFrame(txtSegundoApellido, cuerpoFrame, segundoApellido);
		webDriver.clickElementFromDropDownByAttributeInFrame(comboPrefijo, cuerpoFrame, "value", prefijoTelefono);
		webDriver.appendTextInFrame(txtTelefono, cuerpoFrame, numeroTelefono);
		webDriver.appendTextInFrame(txtEmail, cuerpoFrame, emailDeclarante);

		if(noDisponible) webDriver.clickInFrame(checkEmailNoDisponible, cuerpoFrame);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaOtrosDatos(String estructuraAfectada, String instalacionesAfectadas, String referenciaMediador, boolean carpetaFisica) {
		debugBegin();
		// Añadir los tipos de value como comentario
		webDriver.clickElementFromDropDownByAttributeInFrame(comboElementoAfectado, cuerpoFrame, "value", estructuraAfectada);
		// Añadir los tipos de value como comentario
		webDriver.clickElementFromDropDownByAttributeInFrame(comboInstalacionAfectada, cuerpoFrame, "value", instalacionesAfectadas);
		webDriver.appendTextInFrame(txtReferenciaExternaMed, cuerpoFrame, referenciaMediador);

		if(carpetaFisica) {
			webDriver.clickInFrame(radioCarpetaFisicaSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(radioCarpetaFisicaNo, cuerpoFrame);
		}

		debugEnd();
		
		return this;
	}

	public boolean posibilidadAsistencia() {
		debugBegin();
		boolean result = false;

		webDriver.waitWithDriver(2500);
		if(webDriver.isClickableInFrame(rdbtnAsistenciaSi, cuerpoFrame)) {
			result = true;
		}

		debugEnd();

		return result;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaSinAsistencia() {
		debugBegin();
		webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaConAsistencia(boolean requiereAsistencia, boolean resolucionUrgente, String motivo, String ubicacion, boolean origenReparado, boolean consecuencia, String RefAsistenciaExt) {
		debugBegin();

		if(requiereAsistencia) {
			webDriver.clickInFrame(rdbtnAsistenciaSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		}

		if(resolucionUrgente) {
			webDriver.clickInFrame(rdbtnUrgenteSi, cuerpoFrame);
			webDriver.clickElementFromDropDownByIndexInFrame(comboMotivo, cuerpoFrame, 2);
			//
		} else {
			webDriver.clickInFrame(rdbtnUrgenteNo, cuerpoFrame);
		}

		webDriver.setTextInFrame(txtUbicacionDanos, cuerpoFrame, ubicacion);

		if(origenReparado) {
			webDriver.clickInFrame(rdbtnReparadoSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnReparadoNo, cuerpoFrame);
		}

		if(consecuencia) {
			webDriver.clickInFrame(rdbtnConsecuenciasSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnConsecuenciasNo, cuerpoFrame);
		}

		webDriver.setTextInFrame(txtRefAsistenciaExt, cuerpoFrame, RefAsistenciaExt);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage datosPersonaExtra(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String documento, String prefijoTlf, String telefono1, String prefijoTlf2,
		String telefono2, String sexo, boolean noEmail, String email, boolean riesgoAsegurado, String tipoVia, String via, String numero, String piso, String puerta, String cp, String poblacion,
		String provincia) {
		debugBegin();

		webDriver.clickInFrame(buttonPersonaContacto, cuerpoFrame);

		debugInfo("Comenzamos a rellenar campos de persona extra");
		webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 8);
		webDriver.setTextInFrame(txtNombre, modalFrame, nombre);

		if(apellido1 != "") webDriver.setTextInFrame(txt1Apellido, modalFrame, apellido1);
		if(apellido2 != "") webDriver.setTextInFrame(txt2Apellido, modalFrame, apellido2);

		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDoc, modalFrame, 1);
		webDriver.setTextInFrame(txtDocumento, modalFrame, documento);

		if(prefijoTlf != "") {
			webDriver.clickElementFromDropDownByAttributeInFrame(comboPrefijo1, modalFrame, "value", prefijoTlf);
		} else {
			debugInfo("no existe prefijo t1");
		}

		webDriver.setTextInFrame(txtTelefono1, modalFrame, telefono1);

		if(prefijoTlf2 != "") {
			webDriver.clickElementFromDropDownByAttributeInFrame(comboPrefijo2, modalFrame, "value", prefijoTlf2);
		} else {
			debugInfo("no existe prefijo t2");
		}

		webDriver.setTextInFrame(txtTelefono2, modalFrame, telefono2);
		webDriver.clickElementFromDropDownByIndexInFrame(comboSexo, modalFrame, 1);

		if(noEmail) {
			webDriver.clickInFrame(checkNoEmail, modalFrame);
		} else {
			webDriver.setTextInFrame(txtEmail2, modalFrame, email);
		}

		if(riesgoAsegurado) {
			webDriver.clickInFrame(checkRiesgoAsegurado, modalFrame);
		} else {
			webDriver.clickElementFromDropDownByIndexInFrame(comboTipoVia, modalFrame, 1);
			webDriver.setTextInFrame(txtVia, modalFrame, via);
			webDriver.setTextInFrame(txtNumero, modalFrame, numero);
			webDriver.setTextInFrame(txtPiso, modalFrame, piso);
			webDriver.setTextInFrame(txtPuerta, modalFrame, puerta);
			webDriver.setTextInFrame(txtCodPostal, modalFrame, cp);
			webDriver.setTextInFrame(txtPoblacion, modalFrame, poblacion);
			webDriver.clickElementFromDropDownByIndexInFrame(comboProvincia, modalFrame, 1);
		}

		webDriver.clickInFrame(btnGrabar, modalFrame);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage completarMinimos(String numPoliza) {
		debugBegin();
		DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");

		webDriver.waitWithDriver(2500);

		webDriver.clickInFrame(tipoDeclaranteTomador, cuerpoFrame);
		webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fOcurrencia.format(new Date()));
		webDriver.clickInFrame(medioDeclaracionCorreoElec, cuerpoFrame);

		webDriver.waitWithDriver(2500);
		debugInfo("Poliza: " + numPoliza.substring(0, 3));

		if(numPoliza.substring(0, 3).compareTo("900") == 0) {
			rdbtnAsistenciaNo = By.id("fisicoNo");
		}

		webDriver.waitWithDriver(2500);

		webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		webDriver.waitWithDriver(2500);

		debugEnd();
		
		return this;
	}
	// endregion
}