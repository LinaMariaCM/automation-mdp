package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
//import com.sun.org.apache.xml.internal.security.utils.Constants;
import com.amaris.project.Constants;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AltaAperturaDeclaracionSiniestrosPage extends PageObject {

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
	private By txtFechaOcurrencia = By.cssSelector("#fechsini");

	// ##### DATOS DECLARACION ####
	private By comboTipoDeclarante = By.id("tipodecl");
	// private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
	private By tipoDeclaranteTomador = By.cssSelector("#tipodecl [value='TOMA']");
	private By tipoDeclaranteAsegurado = By.cssSelector("#tipodecl [value='ASEG']");
	private By tipoDeclaranteAdministrador = By.cssSelector("#tipodecl [value='ADMI']");
	private By tipoDeclaranteMediador = By.cssSelector("#tipodecl [value='MEDI']");
	private By tipoDeclaranteProfiesionales = By.cssSelector("#tipodecl [value='PROF']");
	private By tipoDeclaranteNoPerteneciente = By.cssSelector("#tipodecl [value='NORI']");

	private By medioDeclaracionCorreoElec = By.cssSelector("#mododecl > option:nth-child(2)");
	private By comboMedioDeclaracion = By.id("mododecl");
	private By txtObservaciones = By.id("comentario");
	private By txtFechaDenuncia = By.id("FECHDENU");
	private By txtNombreDeclarante = By.id("nombpers");
	private By txtPrimerApellido = By.id("ape1pers");
	private By txtSegundoApellido = By.id("ape2pers");
	private By txtTelefono = By.id("telefono1");
	private By comboPrefijo = By.id("#datosDeclarante > div.sis-frame-bg > table > tbody > tr:nth-child(3) > td > span > div > span.ui-combobox");
	private By txtEmail = By.id("mail");
	private By checkEmailNoDisponible = By.id("emailnodisp");
	private By emailNoDisponibleHidden = By.id("emailNoDispHidden");
	private By emailNoDisponiblePCHidden = By.id("obligaMail");

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
	private By comboRol = By.cssSelector("#rol");
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
	private By txtEmailPersona = By.id("email");

	//private By checkNoEmail = By.id("emailnodisp");
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
	private By haceTresMesesTxt = By.cssSelector(".grid.wideBox tr:nth-child(2) > td:nth-child(2) ");

	// endregion

	public AltaAperturaDeclaracionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AltaAperturaDeclaracionSiniestrosPage altaDatosBasicos(String tipoDeclarante, String medioDeclaracion) {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, DateUtils.getTodayDate("dd/MM/yyyy"));
		debugInfo(tipoDeclarante + "declarando a través de" + medioDeclaracion);
		// webDriver.clickElementFromDropDownByAttribute(comboTipoDeclarante, "value",
		// tipoDeclarante);//Añadir los tipos de value como comentario
		// webDriver.clickElementFromDropDownByAttribute(comboMedioDeclaracion, "value", medioDeclaracion);
		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 4);
		webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 2);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaDatosDeclaracion(String fechaOcurrencia, String tipoDeclarante, String medioDeclaracion, String fechaDenuncia, String observaciones) {
		debugBegin();

		if(fechaOcurrencia == null || fechaOcurrencia.isEmpty()) {
			webDriver.switchToFrame(cuerpoFrame);
			DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
			webDriver.waitWithDriver(3000);
			// webDriver.switchToFrame(modalFrame);
			webDriver.appendText(txtFechaOcurrencia, fOcurrencia.format(new Date()));
			webDriver.exitFrame();
		} else {
			webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fechaOcurrencia);
		}

		// Añadir los tipos de value como comentario
		if(tipoDeclarante == null || tipoDeclarante.isEmpty()) {
			webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 1);
		} else {
			webDriver.clickElementFromDropDownByAttributeInFrame(comboTipoDeclarante, cuerpoFrame, "value", tipoDeclarante);
		}

		// webDriver.clickElementFromDropDownByAttributeInFrame(comboMedioDeclaracion, cuerpoFrame, "value",
		// medioDeclaracion);
		if(medioDeclaracion == null || medioDeclaracion.isEmpty()) {
			webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);
		} else {
			webDriver.clickElementFromDropDownByAttributeInFrame(comboMedioDeclaracion, cuerpoFrame, "value", medioDeclaracion);
		}

		// webDriver.appendTextInFrame(txtFechaDenuncia, cuerpoFrame, fechaDenuncia);
		if(fechaDenuncia == null || fechaDenuncia.isEmpty()) {
			DateFormat fDenuncia = new SimpleDateFormat("dd/MM/yyyy");
			webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fDenuncia.format(new Date()));
		} else {
			webDriver.appendText(txtFechaOcurrencia, fechaDenuncia);
		}

		if(observaciones == null || observaciones.isEmpty()) {
			observaciones = "Ipsum sum lorem lorem, esto es una prueba del equipo de TaaS.";
		}
		webDriver.appendTextInFrame(txtObservaciones, cuerpoFrame, observaciones);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaDatosDeclarante(String nombreDeclarante,
		String apellidoDeclarante, String segundoApellido,
		String prefijoTelefono, String numeroTelefono,
		String emailDeclarante, String noDisponible) {
		debugBegin();

		if(nombreDeclarante != null) {
			webDriver.appendTextInFrame(txtNombreDeclarante, cuerpoFrame, nombreDeclarante);
		}

		if(apellidoDeclarante != null) {
			webDriver.appendTextInFrame(txtPrimerApellido, cuerpoFrame, apellidoDeclarante);
		}

		if(segundoApellido != null) {
			webDriver.appendTextInFrame(txtSegundoApellido, cuerpoFrame, segundoApellido);
		}
		// webDriver.clickElementFromDropDownByAttributeInFrame(comboPrefijo, cuerpoFrame, "value", prefijoTelefono); en
		// principio sólo contemplado para España

		// if(webDriver.getTextInFrame(txtTelefono, cuerpoFrame).isEmpty()) System.out.println("El número de teléfono
		// del declarante ya está puesto: " + webDriver.getTextInFrame(txtTelefono, cuerpoFrame));
		//
		// else {
		// System.out.println("El número del declarante es: " + numeroTelefono);
		// webDriver.appendTextInFrame(txtTelefono, cuerpoFrame, numeroTelefono);
		// }

		// if(emailDeclarante.isEmpty()) webDriver.appendTextInFrame(txtEmail, cuerpoFrame, "prueba_sin_mail@esto.es");
		// else webDriver.appendTextInFrame(txtEmail, cuerpoFrame, emailDeclarante);

		System.out.println("El número del declarante es: " + numeroTelefono);
		if(numeroTelefono != null) {
			webDriver.setTextInFrame(txtTelefono, cuerpoFrame, numeroTelefono);
		}

		webDriver.waitWithDriver(3000);
		// webDriver.switchToFrame(cuerpoFrame);
		if(noDisponible != null && !noDisponible.isEmpty() && emailDeclarante != null) {
			// webDriver.appendTextInFrame(txtEmail, modalFrame, emailDeclarante);
			webDriver.appendTextInFrame(txtEmail, cuerpoFrame, emailDeclarante);
			// webDriver.clickInFrame(checkNoEmail, modalFrame);
		} else {
			// webDriver.appendTextInFrame(txtEmail, modalFrame, "prueba@esto.es");
			webDriver.appendTextInFrame(txtEmail, cuerpoFrame, "prueba_sin_mail@esto.es");
		}

		// if(noDisponible) webDriver.clickInFrame(checkEmailNoDisponible, cuerpoFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaOtrosDatos(String estructuraAfectada, String instalacionesAfectadas, String referenciaMediador, boolean carpetaFisica) {
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

	public AltaAperturaDeclaracionSiniestrosPage altaSinAsistencia() {
		debugBegin();
		// System.out.println("El tipo de póliza se imprime aquí: " + getTestVar(Constants.NUM_POLIZA).substring(0,3));
		// if(getTestVar(Constants.NUM_POLIZA).substring(0,3).compareTo("920") != 0) {
		// System.out.println("Resultado: " + (Constants.NUM_POLIZA).substring(0,3).compareTo("920"));
		// System.out.println("Entro a 920");
		// if (webDriver.isPresentInFrame(rdbtnAsistenciaNo, cuerpoFrame)) webDriver.clickInFrame(rdbtnAsistenciaNo,
		// cuerpoFrame);
		// }
		// else if(getTestVar(Constants.NUM_POLIZA).substring(0,3).compareTo("900") != 0) {
		// System.out.println("Entro a 900");
		// if (webDriver.isPresentInFrame(rdbtnAsistenciaNo, cuerpoFrame)) webDriver.clickInFrame(rdbtnAsistenciaNo,
		// cuerpoFrame);}
		// if(webDriver.isPresentInFrame(rdbtnAsistenciaNo, cuerpoFrame)){webDriver.clickInFrame(rdbtnAsistenciaNo,
		// cuerpoFrame);}

		if(getTestVar(Constants.NUM_POLIZA).startsWith("150")) {
			System.out.println("Póliza carece de opción: 'alta sin asistencia'.");
		} else {
			webDriver.isPresentAndClickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		}

		debugInfo("Seleccionada: Asistencia NO");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaConAsistencia(String requiereAsistencia, String resolucionUrgente,
		String ubicacion, String origenReparado,
		String consecuencia, String RefAsistenciaExt) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		if(!Constants.ASISTENCIA.isEmpty()) {
			webDriver.clickInFrame(rdbtnAsistenciaSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		}

		if(!Constants.ASISTENCIA_URGENTE.isEmpty()) {
			webDriver.clickInFrame(rdbtnUrgenteSi, cuerpoFrame);
			webDriver.waitWithDriver(2000);
			webDriver.clickElementFromDropDownByIndexInFrame(comboMotivo, cuerpoFrame, 2);
			//
		} else {
			webDriver.clickInFrame(rdbtnUrgenteNo, cuerpoFrame);
		}

		if(ubicacion != null && !ubicacion.isEmpty())
			webDriver.setTextInFrame(txtUbicacionDanos, cuerpoFrame, ubicacion);

		if(!Constants.ASISTENCIA_ORIGEN_DANYOS_REPARADOS.isEmpty()) {
			webDriver.clickInFrame(rdbtnReparadoSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnReparadoNo, cuerpoFrame);
		}

		if(!Constants.ASISTENCIA_DANYOS_A_CONSECUENCIA.isEmpty()) {
			webDriver.clickInFrame(rdbtnConsecuenciasSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnConsecuenciasNo, cuerpoFrame);
		}

		if(RefAsistenciaExt != null && !RefAsistenciaExt.isEmpty())
			webDriver.setTextInFrame(txtRefAsistenciaExt, cuerpoFrame, RefAsistenciaExt);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage datosPersonaExtra(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String documento, String prefijoTlf,
		String telefono1, String prefijoTlf2,
		String telefono2, String sexo, String noEmail, String email, String riesgoAsegurado, String tipoVia, String via, String numero, String piso, String puerta, String cp, String poblacion,
		String provincia) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(buttonPersonaContacto);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitWithDriver(9000);
		debugInfo("Comenzamos a rellenar campos de persona extra");

		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.switchToFrame(modalFrame);

		webDriver.clickElementFromDropDownByIndex(comboRol, 8);
		// webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);

		if(nombre != null && !nombre.isEmpty()) {
			webDriver.setText(txtNombre, nombre);
		} else webDriver.setText(txtNombre, "Nombre" + Integer.toString((int) (Math.random() * 100)));

		if(apellido1 != null && !apellido1.isEmpty()) {
			webDriver.setText(txt1Apellido, apellido1);
		} else webDriver.setText(txt1Apellido, "ApellidoUno" + Integer.toString((int) (Math.random() * 100)));

		if(apellido2 != null && !apellido2.isEmpty()) {
			webDriver.setText(txt2Apellido, apellido2);
		} else webDriver.setText(txt2Apellido, "ApellidoDos" + Integer.toString((int) (Math.random() * 100)));

		if(tipoDocumento != null && !tipoDocumento.isEmpty()) {
			// webDriver.clickElementFromDropDownByAttribute(comboTipoDoc, "value", tipoDocumento);
			webDriver.clickElementFromDropDownByIndex(comboTipoDoc, 1);
		} else webDriver.clickElementFromDropDownByIndex(comboTipoDoc, 1);
		webDriver.waitWithDriver(3000);

		if(documento != null && !documento.isEmpty()) {
			webDriver.setText(txtDocumento, documento);
		} else {
			documento = DniGeneratorHelper.generateNif();
			webDriver.waitWithDriver(3000);
			webDriver.setText(txtDocumento, documento);
		}

		if(prefijoTlf != null && !prefijoTlf.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(comboPrefijo1, "value", prefijoTlf);
		} else {
			debugInfo("no existe prefijo t1");
		}

		webDriver.setText(txtTelefono1, telefono1);

		if(prefijoTlf2 != null && !prefijoTlf2.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(comboPrefijo2, "value", prefijoTlf2);
		} else {
			debugInfo("no existe prefijo t2");
		}

		if(telefono2 != null && !telefono2.isEmpty()) {
			webDriver.setText(txtTelefono2, telefono2);
		}
		// webDriver.clickElementFromDropDownByIndex(comboSexo, 1);
		if(sexo != null && !sexo.isEmpty()) {
			webDriver.clickElementFromListByAttribute(comboSexo, "value", sexo);
		}

		webDriver.waitWithDriver(3000);
		if(noEmail != null && !noEmail.isEmpty()) {
			webDriver.setText(txtEmailPersona, "prueba@esto.es");
			// webDriver.clickInFrame(checkNoEmail, modalFrame);
		} else {
			webDriver.setText(txtEmailPersona, email);
		}
		webDriver.waitWithDriver(3000);
		if(riesgoAsegurado != null && !riesgoAsegurado.isEmpty()) {
			webDriver.click(checkRiesgoAsegurado);
		} else {
			// webDriver.clickElementFromDropDownByIndex(comboTipoVia, 1);
			if(tipoVia != null && !tipoVia.isEmpty())
				webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
			if(via != null && !via.isEmpty()) webDriver.setText(txtVia, via);
			if(numero != null && !numero.isEmpty()) webDriver.setText(txtNumero, numero);
			if(piso != null && !piso.isEmpty()) webDriver.setText(txtPiso, piso);
			if(puerta != null && !puerta.isEmpty()) webDriver.setText(txtPuerta, puerta);
			if(cp != null && !cp.isEmpty()) webDriver.setText(txtCodPostal, cp);
			if(poblacion != null && !poblacion.isEmpty()) webDriver.setText(txtPoblacion, poblacion);
			// webDriver.clickElementFromDropDownByIndex(comboProvincia, 1);
			if(provincia != null && !provincia.isEmpty())
				webDriver.clickElementFromDropDownByAttribute(comboProvincia, "value", provincia);
		}
		// webDriver.setText(txtEmail, "prueba@esto.es");
		webDriver.waitWithDriver(8000);
		webDriver.click(btnGrabar);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickContinuar() {
		debugBegin();
		System.out.println(txtEmail);
		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.waitWithDriver(5000);
		// if(webDriver.isPresentInFrame(btnContinuar, cuerpoFrame)){webDriver.clickInFrame(btnContinuar, cuerpoFrame);}
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickContinuarSinAsistencia() {
		debugBegin();
		System.out.println(txtEmail);
		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage completarMinimos(String numPoliza) {
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

	public AltaAperturaDeclaracionSiniestrosPage modificarDatosSiniestro(String nombre, String primerApellido, String segApellido, String telefono, String email) {
		// public SiniestrosAltaAperturaDeclaracionPage modificarDatosSiniestro() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		webDriver.clickElementFromDropDownByIndex(comboTipoDeclarante, 1);
		webDriver.setText(txtNombreDeclarante, nombre);
		webDriver.setText(txtPrimerApellido, primerApellido);
		webDriver.setText(txtSegundoApellido, segApellido);
		webDriver.setText(txtTelefono, telefono);
		webDriver.setText(txtEmail, email);
		webDriver.waitWithDriver(3000);
		webDriver.click(btnContinuar);

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage continuarSinAcciones() {
		debugBegin();
		webDriver.waitForPageToLoad();
		webDriver.switchToFrame(cuerpoFrame);

		webDriver.waitWithDriver(2500);
		webDriver.click(btnContinuar);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickVolver() {
		debugBegin();
		webDriver.clickInFrame(btnVolver, cuerpoFrame);
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickGrabarPersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);
		debugEnd();

		return this;
	}

	// -----------------------------------------------RETENCIONES-----------------------------------------------------------------------

	// localizar alerta, comparar texto y clic en aceptar para quitarla

	/*
	 * public SiniestrosAltaAperturaDeclaracionPage accionesSobreAlerta() { if(webDriver.alertIsPresent(true)) {
	 * debugBegin(); comprobarContenidoAlerta(); webDriver.acceptAlert(); } else {
	 * debugInfo("Ha fallado la localización de la retención"); } debugEnd(); return this; }
	 */

	public AltaAperturaDeclaracionSiniestrosPage comprobarAlertaAvisoSistema(String textoAviso) {
		debugBegin();

		String alertaResultado = webDriver.getTextInFrame(labelErrorEnDeclaracion, cuerpoFrame).trim();

		boolean checkAvisoSistema = alertaResultado.equalsIgnoreCase(textoAviso);

		debugInfo("Mensaje esperado: " + textoAviso);
		debugInfo("Mensaje real: " + alertaResultado);

		Assert.assertTrue(checkAvisoSistema, "COMPARAR CAMPOS : alerta NO se muestra");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage rellenarDatosMinimos() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, datoFechaHoy);
		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 2);
		webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);
		webDriver.waitWithDriver(5000);
		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@email.es");
		webDriver.waitWithDriver(5000);

		debugEnd();

		return this;
	}

	/*
	 * public SiniestrosAltaAperturaDeclaracionPage comprobarAvisoFechaOcurrencia() { debugBegin();
	 *
	 * A UTLIZAR LA SIGUIENTE LÍNEA PARA INVOCAR DIRECTAMENTE A LA CONSTANTE ESTIPULADA
	 * new ChecksUtils(userS).comprobarAlerta(Constants.FECHA_OCURRENCIA_AVISOS);
	 *
	 * debugEnd();
	 *
	 * return this; }
	 */

	// -------------------------------------------------------FECHAS OCURRENCIA------------------------------------------------------------
	// Dejar el campo fecha de ocrrencia vacío
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(txtFechaOcurrencia, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_OCURRENCIA);
		webDriver.acceptAlert();
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, "09/of/2019");
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_OCURRENCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloPosteriorHoy() {
		debugBegin();

		String datoFechaManyana = DateUtils.getModifiedDate(Calendar.DATE, 3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, datoFechaManyana);
		//webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 2);
		//webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);

		/*webDriver.waitWithDriver(8000);
		webDriver.setTextInFrame(txtEmail,cuerpoFrame, "prueba@email.es");
		webDriver.waitWithDriver(8000);
		*/
		//webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_OCURRENCIA_POSTERIOR_HOY);
		clickVolver();

		debugEnd();

		return this;
	}

	//Revisar codigo
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloHaceTresMeses() {
		debugBegin();

		String fechaHaceTresMeses = DateUtils.getModifiedDate(Calendar.MONTH, -3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, fechaHaceTresMeses);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		String textoHaceTresMeses = webDriver.getTextInFrame(haceTresMesesTxt, cuerpoFrame).trim();

		boolean checkAvisoHaceTresMeses = textoHaceTresMeses.equalsIgnoreCase(Constants.ALERTA_OCURRENCIA_HACE_TRES_MESES);

		debugInfo("Mensaje esperado: " + Constants.ALERTA_OCURRENCIA_HACE_TRES_MESES);
		debugInfo("Mensaje real: " + textoHaceTresMeses);

		Assert.assertTrue(checkAvisoHaceTresMeses, "COMPARAR CAMPOS : alerta NO se muestra");

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloAnteriorFechaVigenciaPoliza() {
		debugBegin();

		String fechaAnteriorVigenciaPoliza = "01/12/2017";

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, fechaAnteriorVigenciaPoliza);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_POLIZA_FUERA_VIGOR);
		clickVolver();

		debugEnd();

		return this;
	}

	// Poner fecha de ocurrencia correcta
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaHoy() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaOcurrencia, cuerpoFrame, datoFechaHoy);

		debugEnd();

		return this;
	}

	/*
	 * public SiniestrosAltaAperturaDeclaracionPage fechaOcurrenciaAnteriorFechaVigenciaPoliza() { debugBegin();
	 * DateFormat fechaHoy = new SimpleDateFormat("dd/MM/yyyy"); String datoFechaHoy = fechaHoy.toString();
	 *
	 * webDriver.switchToFrame(cuerpoFrame); webDriver.appendText(txtFechaOcurrencia,datoFechaHoy);
	 * webDriver.click(btnContinuar); new ChecksUtils(userS).comprobarAlerta(Constants.FECHA_OCURRENCIA_AVISOS); webDriver.acceptAlert();
	 * webDriver.exitFrame();
	 *
	 * debugEnd(); return this; }
	 */
	//-------------------------------------DECLARACIÓN------------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage tipoDeclaranteFalloVacio() {
		debugBegin();
		seleccionarTipoDeclarante("Seleccionar");
		//webDriver.clearTextInFrame(comboTipoDeclarante, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DECLARANTE);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage medioDeclaracionFalloVacio() {
		debugBegin();
		seleccionarMedioDeclaracion("Seleccionar");
		//webDriver.clearTextInFrame(comboMedioDeclaracion, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_MEDIO_DECLARACION);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarTipoDeclarante() {
		return seleccionarTipoDeclarante("");
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarTipoDeclarante(String opcion) {
		debugBegin();

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 0);
				break;
			default:
			case "Tomador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 1);
				break;
			case "Asegurado":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 2);
				break;
			case "Administrador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 3);
				break;
			case "Mediador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 4);
				break;
			case "Beneficiario":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 5);
				break;
			case "Portero":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 6);
				break;
			case "Copropietario":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 7);
				break;
			case "Inquilino":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 8);
				break;
			case "Empleado comunidad de propietarios":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 9);
				break;
			case "Presidente":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 10);
				break;
			case "Profesionales":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 11);
				break;
			case "No perteneciente al riesgo":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 12);
				break;
		}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarMedioDeclaracion() {
		return seleccionarMedioDeclaracion("");
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarMedioDeclaracion(String opcion) {
		debugBegin();

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 0);
				break;
			case "Correo electrónico":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);
				break;
			default:
			case "Correo ordinario":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 2);
				break;
			case "Fax":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 3);
				break;
			case "Teléfono":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 4);
				break;
			case "Visitas":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 5);
				break;
			case "Web Portal Cliente":
				webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 6);
				break;
		}

		debugEnd();

		return this;
	}

	// --------------------------------AÑADIR DATOS---------------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloVacio() {

		debugBegin();

		webDriver.clearTextInFrame(txtEmail, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@prueba");
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloNoDisponible() {
		debugBegin();

		webDriver.clearTextInFrame(txtEmail, cuerpoFrame);

		webDriver.clickInFrame(checkEmailNoDisponible, cuerpoFrame);

		if(!webDriver.getAttributeInFrame(emailNoDisponibleHidden, cuerpoFrame, "value").equalsIgnoreCase("S")) {
			webDriver.clickInFrame(checkEmailNoDisponible, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	//--------------------------------------ASISTENCIA----------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage asistenciaFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ASISTENCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarAsistencia() {
		debugBegin();

		webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);

		debugEnd();

		return this;
	}
	// --------------------------------------PERSONA DE CONTACTO-------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage personaContactoFalloAñadir() {
		debugBegin();

		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_ANYADIR_PERSONAS_CONTACTO);
		clickVolver();

		debugEnd();

		return this;
	}

	//
	public AltaAperturaDeclaracionSiniestrosPage rolPersonaContactoFalloVacio() {

		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(buttonPersonaContacto);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitWithDriver(5000);
		webDriver.click(btnGrabar);
		webDriver.exitFrame();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ROL);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarRolPersonaContacto() {
		return seleccionarRolPersonaContacto("Administrador");
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarRolPersonaContacto(String opcion) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 0);
				break;
			default:
			case "Copropietario":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 1);
				break;
			case "Inquilino":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 2);
				break;
			case "Portero":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 3);
				break;
			case "Presidente":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 4);
				break;
			case "Mediador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 5);
				break;
			case "Tomador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 6);
				break;
			case "Administrador":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 7);
				break;
			case "Asegurado":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 8);
				break;
			case "Beneficiario":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 9);
				break;
			case "No perteneciente al riesgo":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 10);
				break;
			case "Profesionales":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 11);
				break;
			case "Migración eMutua":
				webDriver.clickElementFromDropDownByIndexInFrame(comboRol, modalFrame, 12);
				break;
		}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage nombrePersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_IMPLICADO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage escribirNombrePersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(txtNombre, modalFrame, "Nombre");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage telefonoPersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_1);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage telefonoPersonaContactoFalloAlfanumerico() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(txtTelefono1, modalFrame, "frjgh7899");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_1);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage escribirTelefonoPersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(txtTelefono1, modalFrame, "678987654");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(txtEmailPersona, modalFrame, "prueba@prueba");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloNoDisponible() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clearTextInFrame(txtEmailPersona, modalFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(checkEmailNoDisponible, modalFrame);

		webDriver.switchToFrame(cuerpoFrame);
		if(!webDriver.getAttributeInFrame(emailNoDisponiblePCHidden, modalFrame, "style").equalsIgnoreCase("display : inline;")) {
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickInFrame(checkEmailNoDisponible, modalFrame);
		}

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO, false);

		debugEnd();

		return this;
	}
	// ------------------------------------FECHAS DENUNCIA---------------------------------

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloAnteriorOcurrencia() {
		debugBegin();

		String datoFechaDenunciaAnterior = DateUtils.getModifiedDate(Calendar.DATE, -4, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaDenuncia, cuerpoFrame, datoFechaDenunciaAnterior);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_DENUNCIA_ANTERIOR_OCURRENCIA);
		clickVolver();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloVacio() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		webDriver.clearTextInFrame(txtFechaDenuncia, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_DENUNCIA);
		webDriver.acceptAlert();
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(txtFechaDenuncia, cuerpoFrame, "09/of/2019");
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_DENUNCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloPosteriorHoy() {
		debugBegin();

		String datoFechaPosteriorHoy = DateUtils.getModifiedDate(Calendar.DATE, 3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaDenuncia, cuerpoFrame, datoFechaPosteriorHoy);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		////
		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_DENUNCIA_ANTERIOR_OCURRENCIA);
		clickVolver();

		debugEnd();

		return this;
	}

	// Completar campo denuncia con la fecha de hoy
	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaHoy() {
		debugBegin();

		String datoFechaDenunciaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaDenuncia, cuerpoFrame, datoFechaDenunciaHoy);

		debugEnd();

		return this;
	}
	// endregion
}