package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
//import com.sun.org.apache.xml.internal.security.utils.Constants;
import com.amaris.project.Constants;
import org.testng.Assert;

import java.util.Calendar;

public class AltaAperturaDeclaracionSiniestrosPage extends PageObject {

	// // region WebElements
	// ##### FRAMES #####
	private By leftFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By cuerpoFrame = By.id("mainFrame");
	private By modalFrame = By.id("capaIframe");

	// Consulta póliza
	private By buttonConsultaPoliza = By.id("enlacePoliza");
	private By personaContactoBtn = By.id("enlaceDatContacPer");
	private By buttonVolverBuscador = By.id("enlacePoliza");

	// ##### DATOS OCURRENCIA #####
	private By fechaOcurrenciaInput = By.cssSelector("#fechsini");

	// ##### DATOS DECLARACION ####
	private By tipoDeclaranteDrpDwn = By.id("tipodecl");
	// private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
	private By tipoDeclaranteTomadorBtn = By.cssSelector("#tipodecl [value='TOMA']");
	private By tipoDeclaranteAsegurado = By.cssSelector("#tipodecl [value='ASEG']");
	private By tipoDeclaranteAdministrador = By.cssSelector("#tipodecl [value='ADMI']");
	private By tipoDeclaranteMediador = By.cssSelector("#tipodecl [value='MEDI']");
	private By tipoDeclaranteProfiesionales = By.cssSelector("#tipodecl [value='PROF']");
	private By tipoDeclaranteNoPerteneciente = By.cssSelector("#tipodecl [value='NORI']");

	private By medioDeclaracionCorreoElecBtn = By.cssSelector("#mododecl > option:nth-child(2)");
	private By medioDeclaracionDrpDwn = By.id("mododecl");
	private By observacionesInput = By.id("comentario");
	private By fechaDenunciaInput = By.id("FECHDENU");
	private By nombreDeclaranteInput = By.id("nombpers");
	private By primerApellidoInput = By.id("ape1pers");
	private By segundoApellidoInput = By.id("ape2pers");
	private By telefonoInput = By.id("telefono1");
	private By comboPrefijo = By.id("#datosDeclarante > div.sis-frame-bg > table > tbody > tr:nth-child(3) > td > span > div > span.ui-combobox");
	private By emailInput = By.id("mail");
	private By emailNoDisponibleBtn = By.id("emailnodisp");
	private By emailNoDisponibleHiddenInput = By.id("emailNoDispHidden");
	private By emailNoDisponiblePCHidden = By.id("obligaMail");

	// ##### OTROS DATOS ####
	private By elementoAfectadoDrpDwn = By.id("ESTRUCTU");
	private By instalacionAfectadaDrpDwn = By.id("INSTALAC");
	private By referenciaExternaMedInput = By.id("nombdato_REFEEXTR_1");
	private By carpetaFisicaSiBtn = By.id("fisicoSi");
	private By carpetaFisicaNoBtn = By.id("fisicoNo");

	// ##### ASISTENCIA #####
	private By asistenciaSiBtn = By.id("asistenciaSi");
	private By asistenciaNoBtn = By.id("asistenciaNo");
	private By urgenteSiBtn = By.id("resolUrgeSi");
	private By urgenteNoBtn = By.id("resolUrgeNo");
	private By motivoDrpDwn = By.id("MOTIASIS");
	private By ubicacionDanyosInput = By.id("nombdato_UBICADAN_1");
	private By reparadoSiBtn = By.id("origDanyoSi");
	private By reparadoNoBtn = By.id("origDanyoNo");
	private By bonsecuenciasSiBtn = By.id("consecDanyoSi");
	private By consecuenciasNoBtn = By.id("consecDanyoNo");
	private By refAsistenciaExtInput = By.id("nombdato_REFEEXAS_1");
	private By continuarBtn = By.id("botonContinuar");

	// #### BOTONES EXTRA (escenarios fallo) ####
	private By labelErrorEnDeclaracion = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By volverBtn = By.id("botonVolver");

	// #### DATOS PERSONA CONTACTO ####
	private By rolDrpDwn = By.cssSelector("#rol");
	private By elementoRol = By.cssSelector("#rol > option");
	private By nombreInput = By.id("nombre");
	private By apellido1Input = By.id("apellido1");
	private By apellido2Input = By.id("apellido2");
	private By tipoDocDrpDwn = By.id("tipodocu");
	private By documentoInput = By.id("numedocu");
	private By prefijo1DrpDwn = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(8) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	private By prefijo2DrpDwn = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(9) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	private By telefono1Input = By.id("telefono1");
	private By telefono2Input = By.id("telefono2");
	private By sexOption = By.id("sexocon");
	private By emailPersonaInput = By.id("email");

	// private By checkNoEmail = By.id("emailnodisp");
	private By riesgoAseguradoBtn = By.cssSelector("#seccionDatosPersonaContacto > div.sis-col-80 > div > label > input");

	private By tipoViaDrpDwn = By.cssSelector("#tipovia");
	private By viaInput = By.cssSelector("#calle");
	private By numeroInput = By.cssSelector("#numero");
	private By pisoInput = By.cssSelector("#label37");
	private By puertaInput = By.cssSelector("#label380");
	private By codPostalInput = By.cssSelector("#cp");
	private By poblacionInput = By.cssSelector("#poblacion");
	private By provinciaDrpDwn = By.cssSelector("#provincia");
	private By grabarBtn = By.cssSelector("#buttonRecord");
	private By cancelarBtn = By.cssSelector("#buttonCancel");
	private By haceTresMesesTxt = By.cssSelector(".grid.wideBox tr:nth-child(2) > td:nth-child(2) ");
	// endregion

	public AltaAperturaDeclaracionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AltaAperturaDeclaracionSiniestrosPage altaDatosBasicos(String tipoDeclarante, String medioDeclaracion) {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(fechaOcurrenciaInput, cuerpoFrame, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		debugInfo(tipoDeclarante + " declarando a través de " + medioDeclaracion);

		webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 4);
		webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 2);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaDatosDeclaracion(String fechaOcurrencia, String tipoDeclarante,
		String medioDeclaracion, String fechaDenuncia, String observaciones) {
		debugBegin();

		webDriver.waitWithDriver(3000);

		if(fechaOcurrencia == null || fechaOcurrencia.isEmpty()) {
			fechaOcurrencia = DateUtils.getTodayDate(DateUtils.DATE_FORMAT);
		}

		webDriver.appendTextInFrame(fechaOcurrenciaInput, cuerpoFrame, fechaOcurrencia);

		// Añadir los tipos de value como comentario
		if(tipoDeclarante == null || tipoDeclarante.isEmpty()) {
			webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 1);
		} else {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, "value", tipoDeclarante);
		}

		if(medioDeclaracion == null || medioDeclaracion.isEmpty()) {
			webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 1);
		} else {
			webDriver.clickElementFromDropDownByAttributeInFrame(medioDeclaracionDrpDwn, cuerpoFrame, "value", medioDeclaracion);
		}

		if(fechaDenuncia == null || fechaDenuncia.isEmpty()) {
			fechaDenuncia = DateUtils.getTodayDate(DateUtils.DATE_FORMAT);
		}

		webDriver.appendTextInFrame(fechaDenunciaInput, cuerpoFrame, fechaDenuncia);

		if(observaciones == null || observaciones.isEmpty()) {
			observaciones = "Ipsum sum lorem lorem, esto es una prueba del equipo de TaaS.";
		}
		webDriver.appendTextInFrame(observacionesInput, cuerpoFrame, observaciones);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaDatosDeclarante(String nombreDeclarante, String apellidoDeclarante,
		String segundoApellido, String prefijoTelefono, String numeroTelefono, String emailDeclarante, String noDisponible) {
		debugBegin();

		if(nombreDeclarante != null) {
			webDriver.appendTextInFrame(nombreDeclaranteInput, cuerpoFrame, nombreDeclarante);
		}

		if(apellidoDeclarante != null) {
			webDriver.appendTextInFrame(primerApellidoInput, cuerpoFrame, apellidoDeclarante);
		}

		if(segundoApellido != null) {
			webDriver.appendTextInFrame(segundoApellidoInput, cuerpoFrame, segundoApellido);
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

		if(numeroTelefono != null && !numeroTelefono.isEmpty()) {
			debugInfo("El número del declarante es: " + numeroTelefono);
			webDriver.setTextInFrame(telefonoInput, cuerpoFrame, numeroTelefono);
		}

		webDriver.waitWithDriver(3000);

		if(noDisponible != null && !noDisponible.isEmpty() && emailDeclarante != null) {
			webDriver.appendTextInFrame(emailInput, cuerpoFrame, emailDeclarante);
		} else if(noDisponible != null && !noDisponible.isEmpty() && emailDeclarante == null) {
			webDriver.appendTextInFrame(emailInput, cuerpoFrame, "prueba_sin_mail@esto.es");
		} else {
			// TODO Crear un metodo para hacer click o no dependiendo si el checkbox esta activado
			webDriver.clickInFrame(emailNoDisponibleBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaOtrosDatos(String estructuraAfectada, String instalacionesAfectadas, String referenciaMediador, boolean carpetaFisica) {
		debugBegin();

		// Añadir los tipos de value como comentario
		webDriver.clickElementFromDropDownByAttributeInFrame(elementoAfectadoDrpDwn, cuerpoFrame, "value", estructuraAfectada);
		// Añadir los tipos de value como comentario
		webDriver.clickElementFromDropDownByAttributeInFrame(instalacionAfectadaDrpDwn, cuerpoFrame, "value", instalacionesAfectadas);
		webDriver.appendTextInFrame(referenciaExternaMedInput, cuerpoFrame, referenciaMediador);

		if(carpetaFisica) {
			webDriver.clickInFrame(carpetaFisicaSiBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(carpetaFisicaNoBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public boolean posibilidadAsistencia() {
		debugBegin();

		boolean result = false;

		webDriver.waitWithDriver(2500);
		if(webDriver.isClickableInFrame(asistenciaSiBtn, cuerpoFrame)) {
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

		// if(getTestVar(Constants.NUM_POLIZA).startsWith("150")) {
		// System.out.println("Póliza carece de opción: 'alta sin asistencia'.");
		// } else {
		webDriver.waitWithDriver(4000);
		webDriver.isPresentAndClickInFrame(asistenciaNoBtn, cuerpoFrame);
		// }

		debugInfo("Seleccionada: Asistencia NO");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage altaConAsistencia(String requiereAsistencia, String resolucionUrgente,
		String ubicacion, String origenReparado, String consecuencia, String refAsistenciaExt) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		if(getTestVar(Constants.ASISTENCIA) != null && !getTestVar(Constants.ASISTENCIA).isEmpty()) {
			webDriver.clickInFrame(asistenciaSiBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(asistenciaNoBtn, cuerpoFrame);
		}

		if(getTestVar(Constants.ASISTENCIA_URGENTE) != null && !getTestVar(Constants.ASISTENCIA_URGENTE).isEmpty()) {
			webDriver.clickInFrame(urgenteSiBtn, cuerpoFrame);
			webDriver.waitWithDriver(2000);
			webDriver.clickElementFromDropDownByIndexInFrame(motivoDrpDwn, cuerpoFrame, 2);
		} else {
			webDriver.clickInFrame(urgenteNoBtn, cuerpoFrame);
		}

		if(ubicacion != null && !ubicacion.isEmpty()) {
			webDriver.setTextInFrame(ubicacionDanyosInput, cuerpoFrame, ubicacion);
		}

		if(getTestVar(Constants.ASISTENCIA_ORIGEN_DANYOS_REPARADOS) != null
			&& !getTestVar(Constants.ASISTENCIA_ORIGEN_DANYOS_REPARADOS).isEmpty()) {
			webDriver.clickInFrame(reparadoSiBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(reparadoNoBtn, cuerpoFrame);
		}

		if(getTestVar(Constants.ASISTENCIA_DANYOS_A_CONSECUENCIA) != null
			&& !getTestVar(Constants.ASISTENCIA_DANYOS_A_CONSECUENCIA).isEmpty()) {
			webDriver.clickInFrame(bonsecuenciasSiBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(consecuenciasNoBtn, cuerpoFrame);
		}

		if(refAsistenciaExt != null && !refAsistenciaExt.isEmpty()) {
			webDriver.setTextInFrame(refAsistenciaExtInput, cuerpoFrame, refAsistenciaExt);
		}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage datosPersonaExtra(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento,
		String documento, String prefijoTlf, String telefono1, String prefijoTlf2, String telefono2, String sexo, String noEmail, String email,
		String riesgoAsegurado, String tipoVia, String via, String numero, String piso, String puerta, String cp, String poblacion, String provincia) {
		debugBegin();

		webDriver.clickInFrame(personaContactoBtn, cuerpoFrame);

		webDriver.waitWithDriver(9000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.switchToFrame(modalFrame);

		webDriver.clickElementFromDropDownByAttribute(rolDrpDwn, elementoRol, "value", "NORIE");

		if(nombre != null && !nombre.isEmpty()) {
			webDriver.setText(nombreInput, nombre);
		} else {
			webDriver.setText(nombreInput, "Nombre" + Integer.toString((int) (Math.random() * 100)));
		}

		if(apellido1 != null && !apellido1.isEmpty()) {
			webDriver.setText(apellido1Input, apellido1);
		} else {
			webDriver.setText(apellido1Input, "ApellidoUno" + Integer.toString((int) (Math.random() * 100)));
		}

		if(apellido2 != null && !apellido2.isEmpty()) {
			webDriver.setText(apellido2Input, apellido2);
		} else {
			webDriver.setText(apellido2Input, "ApellidoDos" + Integer.toString((int) (Math.random() * 100)));
		}

		// TODO Comproba, las dos condiciones hacen lo mismo
		if(tipoDocumento != null && !tipoDocumento.isEmpty()) {
			// TODO Cambiar a atributo y comprobar si funciona
			// webDriver.clickElementFromDropDownByAttribute(comboTipoDoc, "value", tipoDocumento);
			webDriver.clickElementFromDropDownByIndex(tipoDocDrpDwn, 1);
		} else {
			webDriver.clickElementFromDropDownByIndex(tipoDocDrpDwn, 1);
		}

		webDriver.waitWithDriver(3000);

		if(documento == null || documento.isEmpty()) {
			documento = DocumentGeneratorHelper.generateNif();
		}

		webDriver.setText(documentoInput, documento);

		if(prefijoTlf != null && !prefijoTlf.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(prefijo1DrpDwn, "value", prefijoTlf);
		} else {
			debugInfo("No existe prefijo t1");
		}

		if(telefono1 != null && !telefono1.isEmpty()) {
			webDriver.setText(telefono1Input, telefono1);
		} else {
			webDriver.setText(telefono1Input, "961234567");
			debugInfo("no existe teléfono 1");
		}
		
		

		if(prefijoTlf2 != null && !prefijoTlf2.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(prefijo2DrpDwn, "value", prefijoTlf2);
		} else {
			debugInfo("No existe prefijo t2");
		}

		if(telefono2 != null && !telefono2.isEmpty()) {
			webDriver.setText(telefono2Input, telefono2);
		} else {
			debugInfo("No se dispone de telefono 2");
			}
		
		
		// webDriver.clickElementFromDropDownByIndex(sexOption, 1);
		if(sexo != null && !sexo.isEmpty()) {
			webDriver.clickElementFromListByAttribute(sexOption, "value", sexo);
		} else { debugInfo("no se especifica sexo");
			
		}

		webDriver.waitWithDriver(2000);
		if(noEmail != null && !noEmail.isEmpty()) {
			webDriver.setText(emailPersonaInput, "prueba@esto.es");
			// webDriver.clickInFrame(checkNoEmail, modalFrame);
			
		} else {
			
			if( email!= null && !email.isEmpty()) {
				webDriver.setText(emailPersonaInput, email);
			} else {
				webDriver.setText(emailPersonaInput, "prueba@esto.es");
			}			
			
		}
		debugInfo("completamos email");
		
		
		webDriver.waitWithDriver(2000);
		
//		if(riesgoAsegurado != null && !riesgoAsegurado.isEmpty()) {
			webDriver.click(riesgoAseguradoBtn);
//		} else {
//			// webDriver.clickElementFromDropDownByIndex(comboTipoVia, 1);
//			if(tipoVia != null && !tipoVia.isEmpty()) webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
//			if(via != null && !via.isEmpty()) webDriver.setText(txtVia, via);
//			if(numero != null && !numero.isEmpty()) webDriver.setText(txtNumero, numero);
//			if(piso != null && !piso.isEmpty()) webDriver.setText(txtPiso, piso);
//			if(puerta != null && !puerta.isEmpty()) webDriver.setText(txtPuerta, puerta);
//			if(cp != null && !cp.isEmpty()) webDriver.setText(txtCodPostal, cp);
//			if(poblacion != null && !poblacion.isEmpty()) webDriver.setText(txtPoblacion, poblacion);
//			// webDriver.clickElementFromDropDownByIndex(comboProvincia, 1);
//			if(provincia != null && !provincia.isEmpty()) webDriver.clickElementFromDropDownByAttribute(comboProvincia, "value", provincia);
//		}
		debugInfo("Completamos dirección de la persona extra (si vive en riesgo asegurado o no.)");
		// webDriver.setText(txtEmail, "prueba@esto.es");
		webDriver.waitWithDriver(2000);
		webDriver.click(grabarBtn);
		webDriver.waitWithDriver(2000);
		debugInfo("Grabamos y salimos de la ventana");
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	// TODO Comprobar, hace lo mismo que clickContinuarSinAsistencia
	public AltaAperturaDeclaracionSiniestrosPage clickContinuar() {
		debugBegin();

		webDriver.setTextInFrame(emailInput, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		webDriver.waitWithDriver(5000);
		// if(webDriver.isPresentInFrame(btnContinuar, cuerpoFrame)){webDriver.clickInFrame(btnContinuar, cuerpoFrame);}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickContinuarSinAsistencia() {
		debugBegin();

		webDriver.setTextInFrame(emailInput, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage completarMinimos(String numPoliza) {
		debugBegin();

		webDriver.waitWithDriver(2500);

		webDriver.clickInFrame(tipoDeclaranteTomadorBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaOcurrenciaInput, cuerpoFrame, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		webDriver.clickInFrame(medioDeclaracionCorreoElecBtn, cuerpoFrame);

		webDriver.waitWithDriver(2500);
		debugInfo("Poliza: " + numPoliza.substring(0, 3));

		if(numPoliza.substring(0, 3).equals("900")) {
			asistenciaNoBtn = By.id("fisicoNo");
		}

		webDriver.waitWithDriver(2500);

		webDriver.clickInFrame(asistenciaNoBtn, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		webDriver.waitWithDriver(2500);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage modificarDatosSiniestro(String nombre, String primerApellido, String segApellido, String telefono, String email) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 1);

		webDriver.setTextInFrame(nombreDeclaranteInput, cuerpoFrame, nombre);
		webDriver.setTextInFrame(primerApellidoInput, cuerpoFrame, primerApellido);
		webDriver.setTextInFrame(segundoApellidoInput, cuerpoFrame, segApellido);
		webDriver.setTextInFrame(telefonoInput, cuerpoFrame, telefono);
		webDriver.setTextInFrame(emailInput, cuerpoFrame, email);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage continuarSinAcciones() {
		debugBegin();
		webDriver.waitWithDriver(2500);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickVolver() {
		debugBegin();
		webDriver.clickInFrame(volverBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage clickGrabarPersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);
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

		Assert.assertTrue(checkAvisoSistema, "Comparar campos: alerta NO se muestra");

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage rellenarDatosMinimos() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, datoFechaHoy);

		webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 2);
		webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 1);
		webDriver.waitWithDriver(5000);

		webDriver.setTextInFrame(emailInput, cuerpoFrame, "prueba@email.es");
		webDriver.waitWithDriver(5000);

		debugEnd();

		return this;
	}

	// ---------------------FECHAS OCURRENCIA---------------------------------
	// Dejar el campo fecha de ocrrencia vacío
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(fechaOcurrenciaInput, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_OCURRENCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, "09/of/2019");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_OCURRENCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloPosteriorHoy() {
		debugBegin();

		String datoFechaManyana = DateUtils.getModifiedDate(Calendar.DATE, 3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, datoFechaManyana);
		// webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 2);
		// webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);

		/*
		 * webDriver.waitWithDriver(8000); webDriver.setTextInFrame(txtEmail,cuerpoFrame, "prueba@email.es");
		 * webDriver.waitWithDriver(8000);
		 */
		// webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_OCURRENCIA_POSTERIOR_HOY);
		clickVolver();

		debugEnd();

		return this;
	}

	// Revisar codigo
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaFalloHaceTresMeses() {
		debugBegin();

		String fechaHaceTresMeses = DateUtils.getModifiedDate(Calendar.MONTH, -3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, fechaHaceTresMeses);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

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

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, fechaAnteriorVigenciaPoliza);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_POLIZA_FUERA_VIGOR);
		clickVolver();

		debugEnd();

		return this;
	}

	// Poner fecha de ocurrencia correcta
	public AltaAperturaDeclaracionSiniestrosPage fechaOcurrenciaHoy() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaOcurrenciaInput, cuerpoFrame, datoFechaHoy);

		debugEnd();

		return this;
	}

	/*
	 * public SiniestrosAltaAperturaDeclaracionPage fechaOcurrenciaAnteriorFechaVigenciaPoliza() { debugBegin();
	 * DateFormat fechaHoy = new SimpleDateFormat("dd/MM/yyyy"); String datoFechaHoy = fechaHoy.toString();
	 *
	 * webDriver.switchToFrame(cuerpoFrame); webDriver.appendText(txtFechaOcurrencia,datoFechaHoy);
	 * webDriver.click(btnContinuar); new ChecksUtils(userS).comprobarAlerta(Constants.FECHA_OCURRENCIA_AVISOS);
	 * webDriver.acceptAlert(); webDriver.exitFrame();
	 *
	 * debugEnd(); return this; }
	 */
	// -------------------------------------DECLARACIÓN------------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage tipoDeclaranteFalloVacio() {
		debugBegin();

		seleccionarTipoDeclarante("Seleccionar");

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DECLARANTE);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage medioDeclaracionFalloVacio() {
		debugBegin();

		seleccionarMedioDeclaracion("Seleccionar");

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

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

		// TODO Cambiar por atributo, comprobar si es MAC o MEC para seleccionar diferentes opciones
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Tomador":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 1);
				break;
			case "Asegurado":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 2);
				break;
			case "Administrador":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 3);
				break;
			case "Mediador":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 4);
				break;
			case "Beneficiario":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 5);
				break;
			case "Portero":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 6);
				break;
			case "Copropietario":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 7);
				break;
			case "Inquilino":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 8);
				break;
			case "Empleado comunidad de propietarios":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 9);
				break;
			case "Presidente":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 10);
				break;
			case "Profesionales":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 11);
				break;
			case "No perteneciente al riesgo":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoDeclaranteDrpDwn, cuerpoFrame, 12);
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

		// TODO Cambiar por atributo, comprobar si es MAC o MEC para seleccionar diferentes opciones
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 0);
				break;
			case "Correo electrónico":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 1);
				break;
			default:
			case "Correo ordinario":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 2);
				break;
			case "Fax":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 3);
				break;
			case "Teléfono":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 4);
				break;
			case "Visitas":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 5);
				break;
			case "Web Portal Cliente":
				webDriver.clickElementFromDropDownByIndexInFrame(medioDeclaracionDrpDwn, cuerpoFrame, 6);
				break;
		}

		debugEnd();

		return this;
	}

	// --------------------------------AÑADIR DATOS---------------------------------------------------
	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloVacio() {
		debugBegin();

		webDriver.clearTextInFrame(emailInput, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(emailInput, cuerpoFrame, "prueba@prueba");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailDeclaranteFalloNoDisponible() {
		debugBegin();

		webDriver.clearTextInFrame(emailInput, cuerpoFrame);

		webDriver.clickInFrame(emailNoDisponibleBtn, cuerpoFrame);

		if(!webDriver.getAttributeInFrame(emailNoDisponibleHiddenInput, cuerpoFrame, "value").equalsIgnoreCase("S")) {
			webDriver.clickInFrame(emailNoDisponibleBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	// --------------------------------------ASISTENCIA----------------------------------------------

	public AltaAperturaDeclaracionSiniestrosPage asistenciaFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ASISTENCIA);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage seleccionarAsistencia() {
		debugBegin();
		webDriver.clickInFrame(asistenciaNoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// --------------------------------------PERSONA DE CONTACTO-------------------------------------------
	public AltaAperturaDeclaracionSiniestrosPage personaContactoFalloAnyadir() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_ANYADIR_PERSONAS_CONTACTO);
		clickVolver();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage rolPersonaContactoFalloVacio() {

		debugBegin();

		webDriver.clickInFrame(personaContactoBtn, cuerpoFrame);

		webDriver.waitWithDriver(5000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitWithDriver(5000);

		webDriver.click(grabarBtn);

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

		// TODO Cambiar por atributo, comprobar si es MAC o MEC para seleccionar diferentes opciones
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 0);
				break;
			default:
			case "Copropietario":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 1);
				break;
			case "Inquilino":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 2);
				break;
			case "Portero":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 3);
				break;
			case "Presidente":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 4);
				break;
			case "Mediador":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 5);
				break;
			case "Tomador":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 6);
				break;
			case "Administrador":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 7);
				break;
			case "Asegurado":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 8);
				break;
			case "Beneficiario":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 9);
				break;
			case "No perteneciente al riesgo":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 10);
				break;
			case "Profesionales":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 11);
				break;
			case "Migración eMutua":
				webDriver.clickElementFromDropDownByIndexInFrame(rolDrpDwn, modalFrame, 12);
				break;
		}

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage nombrePersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_IMPLICADO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage escribirNombrePersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(nombreInput, modalFrame, "Nombre");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage telefonoPersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_1);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage telefonoPersonaContactoFalloAlfanumerico() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(telefono1Input, modalFrame, "frjgh7899");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_1);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage escribirTelefonoPersonaContacto() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(telefono1Input, modalFrame, "678987654");
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloVacio() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		webDriver.setText(emailPersonaInput, "prueba@prueba");
		webDriver.click(grabarBtn);

		webDriver.exitFrame();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage emailPersonaContactoFalloNoDisponible() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		webDriver.clearText(emailPersonaInput);
		webDriver.click(emailNoDisponibleBtn);

		webDriver.exitFrame();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(!webDriver.getAttribute(emailNoDisponiblePCHidden, "style").equals("display : inline;")) {
			webDriver.click(emailNoDisponibleBtn);
		}

		webDriver.click(grabarBtn);

		webDriver.exitFrame();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PERSONA_CONTACTO, false);

		debugEnd();

		return this;
	}
	
	// ------------------------------------FECHAS DENUNCIA---------------------------------
	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloAnteriorOcurrencia() {
		debugBegin();

		String datoFechaDenunciaAnterior = DateUtils.getModifiedDate(Calendar.DATE, -4, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaDenunciaInput, cuerpoFrame, datoFechaDenunciaAnterior);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		
		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_DENUNCIA_ANTERIOR_OCURRENCIA);
		clickVolver();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloVacio() {
		debugBegin();
		
		webDriver.waitWithDriver(5000);
		webDriver.clearTextInFrame(fechaDenunciaInput, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_DENUNCIA);
		webDriver.acceptAlert();
		
		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloFormatoIncorrecto() {
		debugBegin();

		webDriver.setTextInFrame(fechaDenunciaInput, cuerpoFrame, "09/of/2019");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_DENUNCIA);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaFalloPosteriorHoy() {
		debugBegin();

		String datoFechaPosteriorHoy = DateUtils.getModifiedDate(Calendar.DATE, 3, Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaDenunciaInput, cuerpoFrame, datoFechaPosteriorHoy);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		comprobarAlertaAvisoSistema(Constants.ALERTA_FECHA_DENUNCIA_ANTERIOR_OCURRENCIA);
		clickVolver();

		debugEnd();

		return this;
	}

	// Completar campo denuncia con la fecha de hoy
	public AltaAperturaDeclaracionSiniestrosPage fechaDenunciaHoy() {
		debugBegin();

		String datoFechaDenunciaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaDenunciaInput, cuerpoFrame, datoFechaDenunciaHoy);

		debugEnd();

		return this;
	}
	// endregion
}