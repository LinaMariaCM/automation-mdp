package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiniestrosAltaAperturaDeclaracionPage extends PageObject {
	
	public SiniestrosAltaAperturaDeclaracionPage(UserStory userS) {
		super(userS);
	}
	
	// // region webelements
	
	//Consulta póliza
	//
	private By buttonConsultaPoliza = By.id("enlacePoliza");
	//
	private By buttonPersonaContacto = By.id("enlaceDatContacPer");
	//
	private By buttonVolverBuscador = By.id("enlacePoliza");
	
	// #####	FRAMES	#####
	
	//
	 private By leftFrame = By.id("leftFrame");
	//
	 private By topFrame = By.id("topFrame");
	//
	 private By cuerpoFrame = By.id("mainFrame");
	//
	 private By modalFrame = By.id("capaIframe");
	
	 
	 // #####	DATOS OCURRENCIA	#####


	 private By txtFechaOcurrencia = By.id("fechsini");
	
	 
	 //	#####	DATOS DECLARACION	####
	 	 
	 private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
	 //
	 private By comboTipoDeclarante = By.id("tipodecl");	 
	 //
	 private By medioDeclaracionCorreoElec = By.cssSelector("#mododecl > option:nth-child(2)");
	 //
	 private By comboMedioDeclaracion = By.id("mododecl");
	 //
	 private By txtObservaciones = By.id("comentario");
	 //
	 private By txtFechaDenuncia = By.id("FECHDENU");
	 //
	 private By txtNombreDeclarante = By.id("nombpers");
	 //
	 private By txtPrimerApellido = By.id("ape1pers");
	 //
	 private By txtSegundoApellido = By.id("ape2pers");
	 //
	 private By txtTelefono = By.id("telefono1");
	 //
	 private By comboPrefijo = By.id("ESTRUCTU");
	 //
	 private By txtEmail = By.id("email");
	 //
	 private By checkEmailNoDisponible = By.id("emailnodisp");
	 
	 
	 //	#####	OTROS DATOS 	####

	 //
	 private By comboElementoAfectado = By.id("ESTRUCTU");
	 //
	 private By comboInstalacionAfectada = By.id("INSTALAC");
	 //
	 private By txtReferenciaExternaMed = By.id("nombdato_REFEEXTR_1");
	 //
	 private By radioCarpetaFisicaSi = By.id("fisicoSi");
	 //
	 private By radioCarpetaFisicaNo = By.id("fisicoNo");
	 
	 
	
	//	#####	ASISTENCIA	#####
	 
	//
	 private By rdbtnAsistenciaSi = By.id("asistenciaSi");
	//
	 private By rdbtnAsistenciaNo = By.id("asistenciaNo");
	//
	 private By rdbtnUrgenteSi = By.id("resolUrgeSi");
	//
	 private By rdbtnUrgenteNo = By.id("resolUrgeNo");
	//
	 private By comboMotivo = By.id("MOTIASIS");
	//
	 private By txtUbicacionDanos = By.id("nombdato_UBICADAN_1");
	//
	 private By rdbtnReparadoSi = By.id("origDanyoSi");
	//
	 private By rdbtnReparadoNo = By.id("origDanyoNo");
	//
	 private By rdbtnConsecuenciasSi = By.id("consecDanyoSi");
	//
	 private By rdbtnConsecuenciasNo = By.id("consecDanyoNo");
	 //
	 private By txtRefAsistenciaExt = By.id("nombdato_REFEEXAS_1");
	 
	 // botón continuar para produtos 500 y 510 
	 private By btnContinuar = By.id("botonContinuar");
	 
	 
	 // #### BOTONES EXTRA (escenarios fallo) #### 
	 
	 //
	 private By labelErrorEnDeclaracion = By.cssSelector("body > table > tbody > tr > td > p > strong");
	 //
	 private By btnVolver = By.id("botonVolver");
	 //
	 
	// #### AÑADIR DATOS PERSONA CONTACTO #### 
	 private By comboRol = By.id("rol");
	 //
	 private By txtNombre = By.id("nombre");
	 //
	 private By txt1Apellido = By.id("apellido1");
	 //
	 private By txt2Apellido = By.id("apellido2");
	 //
	 private By comboTipoDoc = By.id("tipodocu");
	 //
	 private By txtDocumento = By.id("numedocu");
	 //
	 private By comboPrefijo1 = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(8) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	 //
	 private By comboPrefijo2 = By.cssSelector("#seccionDatosPersonaContacto > div:nth-child(9) > div.box-field.flexibleField > span > div > span.ui-combobox > input");
	 //
	 private By txtTelefono1 = By.id("telefono1");
	 //
	 private By txtTelefono2 = By.id("telefono2");
	 //
	 private By comboSexo = By.id("sexocon");
	 //
	 private By txtEmail2 = By.id("email");
	 //
	 private By checkNoEmail = By.id("emailnodisp");
	 //
	 private By checkRiesgoAsegurado = By.cssSelector("#seccionDatosPersonaContacto > div.sis-col-80 > div > label > input");
	 //
	 private By comboTipoVia = By.id("tipovia");
	 //
	 private By txtVia = By.id("calle");
	 //
	 private By txtNumero = By.id("numero");
	 //
	 private By txtPiso = By.id("label37");
	 //
	 private By txtPuerta = By.id("label380");
	 //
	 private By txtCodPostal = By.id("cp");
	 //
	 private By txtPoblacion = By.id("poblacion");
	 //
	 private By comboProvincia = By.id("provincia");
	 //
	 private By btnGrabar = By.id("buttonRecord");
	 //
	 private By btnCancelar = By.id("buttonCancel");

	 
	// endregion
	
	 
	//############################################################################## 
	 
	 
	// region methods
	
	//Introducir datos Basicos
	 public void altaDatosBasicos(String tipoDeclarante, String medioDeclaracion)
	 {
		this.debugBegin();
				
		this.webDriver.appendText(this.txtFechaOcurrencia, fOcurrencia.format(new Date()));
		System.out.println(tipoDeclarante + "declarando a través de" + medioDeclaracion);
		//this.webDriver.clickElementFromDropDownByAttribute(this.comboTipoDeclarante, "value", tipoDeclarante);//Añadir los tipos de value como comentario
		//this.webDriver.clickElementFromDropDownByAttribute(this.comboMedioDeclaracion, "value", medioDeclaracion);
		this.webDriver.clickElementFromDropDownByIndex(this.comboTipoDeclarante, 4);
		this.webDriver.clickElementFromDropDownByIndex(this.comboMedioDeclaracion, 2);
						
			
	 	this.debugEnd();
	 }
	 
	 //Introducir Datos declaracion
	 public void altaDatosDeclaracion(String fechaOcurrencia, String tipoDeclarante, String medioDeclaracion, String fechaDenuncia, String observaciones) 
	 {
		 this.debugBegin();
			
			this.webDriver.appendText(this.txtFechaOcurrencia, fechaOcurrencia);
			this.webDriver.clickElementFromDropDownByAttribute(this.comboTipoDeclarante, "value", tipoDeclarante);//Añadir los tipos de value como comentario
			this.webDriver.clickElementFromDropDownByAttribute(this.comboMedioDeclaracion, "value", medioDeclaracion);
			this.webDriver.appendText(this.txtFechaDenuncia, fechaDenuncia);
			this.webDriver.appendText(this.txtObservaciones, observaciones);
					
		 this.debugEnd();
	 }
	 
	//Introducir Datos declarante
	 public void altaDatosDeclarante(String nombreDeclarante, String apellidoDeclarante, String segundoApellido, String prefijoTelefono, String numeroTelefono, String emailDeclarante, boolean noDisponible) 
	 {
		 this.debugBegin();

			this.webDriver.appendText(this.txtNombreDeclarante, nombreDeclarante);
			this.webDriver.appendText(this.txtPrimerApellido, apellidoDeclarante);
			this.webDriver.appendText(this.txtSegundoApellido, segundoApellido);
			this.webDriver.clickElementFromDropDownByAttribute(this.comboPrefijo, "value", prefijoTelefono);//Añadir los tipos de value como comentario
			this.webDriver.appendText(this.txtTelefono, numeroTelefono);
			this.webDriver.appendText(this.txtEmail, emailDeclarante);
			if(noDisponible)this.webDriver.click(this.checkEmailNoDisponible);
					
		 this.debugEnd();
	 }
	 
	//Introducir Otros Datos
	 public void altaOtrosDatos(String estructuraAfectada, String instalacionesAfectadas, String referenciaMediador, boolean carpetaFisica) 
	 {
		 this.debugBegin();

			this.webDriver.clickElementFromDropDownByAttribute(this.comboElementoAfectado, "value", estructuraAfectada);//Añadir los tipos de value como comentario
			this.webDriver.clickElementFromDropDownByAttribute(this.comboInstalacionAfectada, "value", instalacionesAfectadas);//Añadir los tipos de value como comentario
			this.webDriver.appendText(this.txtReferenciaExternaMed, referenciaMediador);
			if(carpetaFisica)this.webDriver.click(this.radioCarpetaFisicaSi);
			else this.webDriver.click(this.radioCarpetaFisicaNo);
					
		 this.debugEnd();
	 }
	 
	 //Necesita asistencia
	 public boolean posibilidadAsistencia() 
	 {
		 this.webDriver.waitWithDriver(2500);
		 if(this.webDriver.isClickable(rdbtnAsistenciaSi))return true;
		 else return false;
	 }
	 
	//Introducir datos asistencia NO
	 public void altaSinAsistencia() 
	 {
		 this.debugBegin();

		 this.webDriver.click(this.rdbtnAsistenciaNo);
		 	
		 this.debugEnd();
	 }
	 
	 //Introducir datos asistencia
	 public void altaConAsistencia(boolean requiereAsistencia, boolean resolucionUrgente, String motivo, String ubicacion, boolean origenReparado, boolean consecuencia, String RefAsistenciaExt) 
	 {
		 this.debugBegin();

		 	if(requiereAsistencia)this.webDriver.click(this.rdbtnAsistenciaSi);
			else this.webDriver.click(this.rdbtnAsistenciaNo);
		 	if(resolucionUrgente) {
		 		this.webDriver.click(this.rdbtnUrgenteSi);
		 		//this.webDriver.clickElementFromDropDownByAttribute(comboMotivo, "value", motivo);
				this.webDriver.clickElementFromDropDownByIndex(this.comboMotivo, 2);
				//
		 	}
			else this.webDriver.click(this.rdbtnUrgenteNo);
			this.webDriver.setText(this.txtUbicacionDanos, ubicacion);
		 	if(origenReparado)this.webDriver.click(this.rdbtnReparadoSi);
			else this.webDriver.click(this.rdbtnReparadoNo);
			if(consecuencia)this.webDriver.click(this.rdbtnConsecuenciasSi);
			else this.webDriver.click(this.rdbtnConsecuenciasNo);
			this.webDriver.setText(this.txtRefAsistenciaExt, RefAsistenciaExt);
					
		 this.debugEnd();
	 }
	 
	 //Añadir datos de persona extra
	 public void datosPersonaExtra(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String documento, String prefijoTlf, String telefono1, String prefijoTlf2, String telefono2, String sexo, boolean noEmail, String email, boolean riesgoAsegurado, String tipoVia, String via, String numero, String piso, String puerta, String cp, String poblacion, String provincia )
	 {
		this.debugBegin();
		
		System.out.println("Pulsamos boton -añadir persona de contacto-");
		this.webDriver.click(buttonPersonaContacto);
		
		System.out.println("Pasamos el foco al popup");
		this.webDriver.switchToFrame(modalFrame);
		System.out.println("Comenzamos a rellenar campos de persona extra");
		
		//this.webDriver.clickElementFromDropDownByAttribute(this.comboRol, "value", rol);
		this.webDriver.clickElementFromDropDownByIndex(this.comboRol, 8);
		//
		this.webDriver.setText(this.txtNombre, nombre);
		if(apellido1!="")this.webDriver.setText(this.txt1Apellido, apellido1);
		if(apellido2!="")this.webDriver.setText(this.txt2Apellido, apellido2);
		//this.webDriver.clickElementFromDropDownByAttribute(this.comboTipoDoc, "value", tipoDocumento);
		this.webDriver.clickElementFromDropDownByIndex(this.comboTipoDoc, 1);
		//
		this.webDriver.setText(this.txtDocumento, documento);
		if(prefijoTlf!="")this.webDriver.clickElementFromDropDownByAttribute(this.comboPrefijo1, "value", prefijoTlf);
		else System.out.println("no existe prefijo t1");
		this.webDriver.setText(this.txtTelefono1, telefono1);
		if(prefijoTlf2!="")this.webDriver.clickElementFromDropDownByAttribute(this.comboPrefijo2, "value", prefijoTlf2);
		else System.out.println("no existe prefijo t2");
		this.webDriver.setText(this.txtTelefono2, telefono2);
		//this.webDriver.clickElementFromDropDownByAttribute(this.comboSexo, "value", sexo);
		this.webDriver.clickElementFromDropDownByIndex(this.comboSexo, 1);
		//
		if(noEmail)this.webDriver.click(this.checkNoEmail);
		else this.webDriver.setText(this.txtEmail2, email);
		if(riesgoAsegurado)this.webDriver.click(this.checkRiesgoAsegurado);
		else {
			//this.webDriver.clickElementFromDropDownByAttribute(this.comboTipoVia, "value", tipoVia);
			this.webDriver.clickElementFromDropDownByIndex(this.comboTipoVia, 1);
			//
			this.webDriver.setText(this.txtVia, via);
			this.webDriver.setText(this.txtNumero, numero);
			this.webDriver.setText(this.txtPiso, piso);
			this.webDriver.setText(this.txtPuerta, puerta);
			this.webDriver.setText(this.txtCodPostal, cp);
			this.webDriver.setText(this.txtPoblacion, poblacion);
			//this.webDriver.clickElementFromDropDownByAttribute(this.comboProvincia, "value", provincia);
			this.webDriver.clickElementFromDropDownByIndex(this.comboProvincia, 1);
			//
		}
		
		this.webDriver.click(this.btnGrabar);
		System.out.println("Boton grabar pulsado");
		
		this.webDriver.exitFrame();
		System.out.println("Salir del frame");
		
		this.webDriver.switchToFrame(cuerpoFrame);
		System.out.println("Foco al main frame");
		
	 	this.debugEnd();
	 }	 
	 
	 //Continuar
	 public void clickContinuar()
	 {
		this.debugBegin();
		
		//this.webDriver.waitWithDriver(7000);
		//this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		this.webDriver.click(this.btnContinuar);
		
		//Steps.waitForIt(webDriver);
		System.out.println("pam");
	 	this.debugEnd();
	 }
	
	 DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
	 
	 
	 //Minimos TEST ZERO
	 public void completarMinimos(String numPoliza) // método que completa el mínimo de campos para realizar una prueba
	 {

		 
		this.debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(2500);

		this.webDriver.click(this.tipoDeclaranteTomador);
		
		this.webDriver.appendText(this.txtFechaOcurrencia, fOcurrencia.format(new Date()));
		
		this.webDriver.click(this.medioDeclaracionCorreoElec);
		
		this.webDriver.waitWithDriver(2500);
		System.out.println(numPoliza.substring(0, 3));
		System.out.println(numPoliza.substring(0, 3).equals("510"));
		System.out.println(numPoliza.substring(0, 3).compareTo("510"));
		//if(numPoliza.substring(0, 3).compareTo("510") == 0 || numPoliza.substring(0, 3).compareTo("500") == 0) this.webDriver.click(this.rdbtnAsistenciaNo);
		if(numPoliza.substring(0, 3).compareTo("900") == 0) {rdbtnAsistenciaNo = By.id("fisicoNo");}
		this.webDriver.waitWithDriver(2500);
		System.out.println("pim");
		this.webDriver.waitForElementToBeClickableAndClick(this.rdbtnAsistenciaNo);
	
		this.webDriver.click(this.btnContinuar);
		this.webDriver.waitWithDriver(2500);
		System.out.println("pam");
		this.webDriver.exitFrame();
		
		//this.clickContinuar();
		System.out.println("pum");
		//Steps.waitForIt(webDriver);
		
		this.debugEnd();
	 }
	 
	 
	// endregion
}