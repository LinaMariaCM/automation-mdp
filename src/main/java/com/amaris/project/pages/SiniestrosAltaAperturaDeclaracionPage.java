package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
//import com.sun.org.apache.xml.internal.security.utils.Constants;
import com.amaris.project.Constants;


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
	private By txtFechaOcurrencia = By.cssSelector("#fechsini");

	// ##### DATOS DECLARACION ####
	private By comboTipoDeclarante = By.id("tipodecl");
	//private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
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
	private By comboPrefijo = By.id("ESTRUCTU");
	private By txtEmail = By.id("mail");
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
		webDriver.waitWithDriver(3000);
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
		
		if(fechaOcurrencia.isEmpty() || fechaOcurrencia == null) {	
			webDriver.switchToFrame(cuerpoFrame);
			DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
			webDriver.waitWithDriver(3000);
			//webDriver.switchToFrame(modalFrame);
			webDriver.appendText(txtFechaOcurrencia, fOcurrencia.format(new Date()));
			webDriver.exitFrame();
			}
		else {webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fechaOcurrencia);}

		// Añadir los tipos de value como comentario
		if(tipoDeclarante.isEmpty() || tipoDeclarante == null) { webDriver.clickElementFromDropDownByIndexInFrame(comboTipoDeclarante, cuerpoFrame, 1);}
		else {webDriver.clickElementFromDropDownByAttributeInFrame(comboTipoDeclarante, cuerpoFrame, "value", tipoDeclarante);}
				
		//webDriver.clickElementFromDropDownByAttributeInFrame(comboMedioDeclaracion, cuerpoFrame, "value", medioDeclaracion);
		if(medioDeclaracion.isEmpty() || medioDeclaracion == null) { webDriver.clickElementFromDropDownByIndexInFrame(comboMedioDeclaracion, cuerpoFrame, 1);}
		else {webDriver.clickElementFromDropDownByAttributeInFrame(comboMedioDeclaracion, cuerpoFrame, "value", medioDeclaracion);}
		
		
		//webDriver.appendTextInFrame(txtFechaDenuncia, cuerpoFrame, fechaDenuncia);
		if(fechaDenuncia.isEmpty() || fechaDenuncia == null) {	
			DateFormat fDenuncia = new SimpleDateFormat("dd/MM/yyyy");
			webDriver.appendTextInFrame(txtFechaOcurrencia, cuerpoFrame, fDenuncia.format(new Date()));}
		else {webDriver.appendText(txtFechaOcurrencia, fechaDenuncia);}
		
		if(observaciones.isEmpty() || observaciones == null){ observaciones = "Ipsum sum lorem lorem, esto es una prueba del equipo de TaaS."; } 
		webDriver.appendTextInFrame(txtObservaciones, cuerpoFrame, observaciones);

		
		debugEnd();

		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaDatosDeclarante(String nombreDeclarante, 
					String apellidoDeclarante, String segundoApellido,
					String prefijoTelefono, String numeroTelefono,
					String emailDeclarante,String noDisponible) {
		debugBegin();

		webDriver.appendTextInFrame(txtNombreDeclarante, cuerpoFrame, nombreDeclarante);
		webDriver.appendTextInFrame(txtPrimerApellido, cuerpoFrame, apellidoDeclarante);
		webDriver.appendTextInFrame(txtSegundoApellido, cuerpoFrame, segundoApellido);
		webDriver.clickElementFromDropDownByAttributeInFrame(comboPrefijo, cuerpoFrame, "value", prefijoTelefono);
		webDriver.appendTextInFrame(txtTelefono, cuerpoFrame, numeroTelefono);
		
		//webDriver.appendTextInFrame(txtEmail, cuerpoFrame, emailDeclarante);
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		if(!noDisponible.isEmpty()) {
			webDriver.appendTextInFrame(txtEmail, modalFrame, emailDeclarante);
			// webDriver.clickInFrame(checkNoEmail, modalFrame);
		} else {
			webDriver.appendTextInFrame(txtEmail, modalFrame, "prueba@esto.es");
		}

		//if(noDisponible) webDriver.clickInFrame(checkEmailNoDisponible, cuerpoFrame);

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
//		System.out.println("El tipo de póliza se imprime aquí: " + getTestVar(Constants.NUM_POLIZA).substring(0,3));
//		if(getTestVar(Constants.NUM_POLIZA).substring(0,3).compareTo("920") != 0) {
//			System.out.println("Resultado: " + (Constants.NUM_POLIZA).substring(0,3).compareTo("920"));
//			System.out.println("Entro a 920");
//			if (webDriver.isPresentInFrame(rdbtnAsistenciaNo, cuerpoFrame)) webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame); 
//			}
//		else if(getTestVar(Constants.NUM_POLIZA).substring(0,3).compareTo("900") != 0) {
//			 System.out.println("Entro a 900");
//			 if (webDriver.isPresentInFrame(rdbtnAsistenciaNo, cuerpoFrame)) webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);}
		
		webDriver.isPresentAndClickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		
		debugEnd();

		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage altaConAsistencia(String requiereAsistencia, String resolucionUrgente, 
																	String ubicacion, String origenReparado,
																	String consecuencia, String RefAsistenciaExt) {
		debugBegin();

		if(!Constants.ASISTENCIA.isEmpty()) {
			webDriver.clickInFrame(rdbtnAsistenciaSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnAsistenciaNo, cuerpoFrame);
		}

		if(!Constants.ASISTENCIA_URGENTE.isEmpty()) {
			webDriver.clickInFrame(rdbtnUrgenteSi, cuerpoFrame);
			webDriver.clickElementFromDropDownByIndexInFrame(comboMotivo, cuerpoFrame, 2);
			//
		} else {
			webDriver.clickInFrame(rdbtnUrgenteNo, cuerpoFrame);
		}

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

		webDriver.setTextInFrame(txtRefAsistenciaExt, cuerpoFrame, RefAsistenciaExt);

		debugEnd();

		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage datosPersonaExtra(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String documento, String prefijoTlf,
		String telefono1, String prefijoTlf2,
		String telefono2, String sexo, String noEmail, String email, String riesgoAsegurado, String tipoVia, String via, String numero, String piso, String puerta, String cp, String poblacion,
		String provincia) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(buttonPersonaContacto);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitWithDriver(8000);
		debugInfo("Comenzamos a rellenar campos de persona extra");

		//webDriver.switchToFrame(cuerpoFrame);
		//webDriver.switchToFrame(modalFrame);
		
		webDriver.clickElementFromDropDownByIndex(comboRol, 8);
		//webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);
		
		if(!nombre.isEmpty()) {
		webDriver.setText(txtNombre, nombre);
		}else webDriver.setText(txtNombre, "Nombre" + Integer.toString((int)(Math.random()*100)));
		
		if(!apellido1.isEmpty()) {
			webDriver.setText(txt1Apellido, apellido1);
		}else webDriver.setText(txt1Apellido, "ApellidoUno" + Integer.toString((int)(Math.random()*100)));

		if(!apellido2.isEmpty()) {
			webDriver.setText(txt2Apellido, apellido2);
		}else webDriver.setText(txt2Apellido, "ApellidoDos" + Integer.toString((int)(Math.random()*100)));

		if(!tipoDocumento.isEmpty()){
			//webDriver.clickElementFromDropDownByAttribute(comboTipoDoc, "value", tipoDocumento);
			webDriver.clickElementFromDropDownByIndex(comboTipoDoc, 1);
		}else webDriver.clickElementFromDropDownByIndex(comboTipoDoc, 1);
		webDriver.waitWithDriver(3000);
		if(!documento.isEmpty()){
		webDriver.setText(txtDocumento, documento);}
		else {documento = DniGeneratorHelper.generateNif();
		webDriver.waitWithDriver(3000);
		webDriver.setText(txtDocumento, documento);}
		
		
		if(!prefijoTlf.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(comboPrefijo1, "value", prefijoTlf);
		} else {
			debugInfo("no existe prefijo t1");
		}

		webDriver.setText(txtTelefono1, telefono1);

		if(!prefijoTlf2.isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(comboPrefijo2, "value", prefijoTlf2);
		} else {
			debugInfo("no existe prefijo t2");
		}

		webDriver.setText(txtTelefono2, telefono2);
		//webDriver.clickElementFromDropDownByIndex(comboSexo, 1);
		webDriver.clickElementFromListByAttribute(comboSexo, "value", sexo);

		webDriver.waitWithDriver(3000);
		if(!noEmail.isEmpty()) {
			webDriver.setText(txtEmailPersona, "prueba@esto.es");
			// webDriver.clickInFrame(checkNoEmail, modalFrame);
		} else {
			webDriver.setText(txtEmailPersona, email);
		}
		webDriver.waitWithDriver(3000);
		if(!riesgoAsegurado.isEmpty()) {
			webDriver.click(checkRiesgoAsegurado);
		} else {
			//webDriver.clickElementFromDropDownByIndex(comboTipoVia, 1);
			webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
			webDriver.setText(txtVia, via);
			webDriver.setText(txtNumero, numero);
			webDriver.setText(txtPiso, piso);
			webDriver.setText(txtPuerta, puerta);
			webDriver.setText(txtCodPostal, cp);
			webDriver.setText(txtPoblacion, poblacion);
			//webDriver.clickElementFromDropDownByIndex(comboProvincia, 1);
			webDriver.clickElementFromDropDownByAttribute(comboProvincia, "value", provincia);
			
		}
		//webDriver.setText(txtEmail, "prueba@esto.es");
		webDriver.waitWithDriver(8000);
		webDriver.click(btnGrabar);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public SiniestrosAltaAperturaDeclaracionPage clickContinuar() {
		debugBegin();
		System.out.println(txtEmail);
		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.waitWithDriver(5000);
		//if(webDriver.isPresentInFrame(btnContinuar, cuerpoFrame)){webDriver.clickInFrame(btnContinuar, cuerpoFrame);}
		debugEnd();

		return this;
	}
	
	public SiniestrosAltaAperturaDeclaracionPage clickContinuarSinAsistencia() {
		debugBegin();
		System.out.println(txtEmail);
		webDriver.setTextInFrame(txtEmail, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		webDriver.waitWithDriver(5000);
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

	public SiniestrosAltaAperturaDeclaracionPage modificarDatosSiniestro(String nombre, String primerApellido, String segApellido, String telefono, String email) {
	//public SiniestrosAltaAperturaDeclaracionPage modificarDatosSiniestro() {
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
	
	public SiniestrosAltaAperturaDeclaracionPage continuarSinAcciones() {
		debugBegin();
		webDriver.waitForPageToLoad();
		webDriver.switchToFrame(cuerpoFrame);

		webDriver.waitWithDriver(2500);
		webDriver.click(btnContinuar);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	// endregion
}