package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

public class SiniestrosAltaAperturaOcurrenciaPage extends PageObject {

	String pulp = "Ezequiel, 25-17: El camino del hombre recto está por todos lados rodeado por la avaricia de los egoístas y la tiranía de los hombres malos.";

	// region webelements
	// ##### FRAMES ####
	private By cuerpoFrame = By.id("mainFrame");
	private By capaIframe = By.id("capaIframe");

	// #### LUGAR DE OCURRENCIA ####
	private By buttonRechazarApertura = By.id("cabRechazar");
	private By buttonVolverAlBuscador = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By comboLugarOcurrencia = By.id("listaLugares");
	private By comboTipoVia = By.id("tdviaocu");
	private By txtCalleOcurrencia = By.id("calleocu");
	private By txtNumeroOcurrencia = By.id("numcaocu");
	private By txtPortalOcurrencia = By.id("portalocu");
	private By txtEscaleraOcurrencia = By.id("escalocu");
	private By txtPisoOcurrencia = By.id("pisoocu");
	private By txtPuertaOcurrencia = By.id("puertaocu");
	private By txtCPOcurrencia = By.id("cpocu");
	private By txtPoblacionOcurrencia = By.id("poblocu");
	private By comboProvincia = By.id("provocu");
	private By buttonGoogleMaps = By.id("dirMaps");

	// #### CAUSAS ####
	private By grupoCausasAccidentes = By.cssSelector("#GRUCAUSA > option:nth-child(2)");
	private By grupoCausasElemento = By.cssSelector("#GRUCAUSA > option");
	private By tipoCausasAccidentes = By.cssSelector("#TIPOCAUS > option:nth-child(2)");
	private By tipoCausasElemento = By.cssSelector("#TIPOCAUS > option");
	private By comboGrupoCausas = By.id("GRUCAUSA");
	private By comboTiposCausas = By.id("TIPOCAUS");
	private By gremioCausasElemento = By.cssSelector("#CODGREMIO > option");
	private By comboGremio = By.id("CODGREMIO");
	
	private By reservaInicial = By.id("RESEINIC");
	private By modificarReserva = By.cssSelector("#datosCausa > div.sis-frame-bg > table.tableForm > tbody > tr.paraOcultar > td > span:nth-child(4) > input");
	private By btnGrabarModificarReserva = By.id("buttonRecord");
	private By btnCancelarModificarReserva = By.id("buttonCancel");
	

	// #### DATOS DE LA OCURRENCIA ####
	private By txtDescripcionSiniestro = By.id("version");
	private By rdbtnImplicadosSi = By.id("implicadosSi");
	private By rdbtnImplicadosNo = By.id("implicadosNo");
	private By rdbtnEncargoSi = By.id("encargoSi");
	private By rdbtnEncargoNo = By.id("encargoNo");
	private By btnGuardarSalir = By.id("botonGuardar");
	private By btnContinuar = By.id("botonContinuar");
	private By descripOcu = By.id("version");
	private By btnVerificar = By.id("botonVerificar");
	
	// ### DATOS ADICIONALES DE LA OCURRENCIA PARA CAUSAS ESPECIFICAS DE MAC ###
	
	private By renta = By.cssSelector("#nombdato_RENTA_1");								//Renta
	private By suministro = By.cssSelector("#nombdato_SUMMI_1"); 						//Suministro
	private By	fechaDemanda = By.cssSelector("#nombdato_FECHINDEM_1");					//*Fecha interposición demanda desahucio
	private By	fechaReclamacion= By.cssSelector("#nombdato_FECHINDRC_1");				//Fecha interposición demanda reclamación
	private By	fechaEntregaLlaves= By.cssSelector("#nombdato_FECHENLLA_1");			//Fecha entrega llaves
	private By	fechaLanzamiento= By.cssSelector("#nombdato_FECHLANZA_1");				//Fecha lanzamiento
	private By	fechaSentencia= By.cssSelector("#nombdato_FECHSENTE_1");				//Fecha sentencia
	private By	fechaSolicitudAvanceRenta= By.cssSelector("#nombdato_FECHSOAREN_1");	//*Fecha solicitud avance renta
	
	// endregion

	public SiniestrosAltaAperturaOcurrenciaPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public SiniestrosAltaAperturaOcurrenciaPage altaRiesgoAsegurado() {
		debugBegin();

		// TODO rellenar metodo
		// webDriver.clickElementFromDropDownByAttribute(comboLugarOcurrencia, "value", "RIES");
		// webDriver.clickElementFromDropDownByIndex(comboLugarOcurrencia, 2);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaOcurrenciaPage altaOtroLugarOcurrencia(String tipoVia, String calle, String numero, String portal, String escalera, String piso, String puerta, String cp, String poblacion, String provincia) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(comboLugarOcurrencia, cuerpoFrame, 1);
		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoVia, cuerpoFrame, 2);

		webDriver.appendTextInFrame(txtCalleOcurrencia, cuerpoFrame, calle);
		webDriver.appendTextInFrame(txtNumeroOcurrencia, cuerpoFrame, numero);
		webDriver.appendTextInFrame(txtPortalOcurrencia, cuerpoFrame, portal);
		webDriver.appendTextInFrame(txtEscaleraOcurrencia, cuerpoFrame, escalera);
		webDriver.appendTextInFrame(txtPisoOcurrencia, cuerpoFrame, piso);
		webDriver.appendTextInFrame(txtPuertaOcurrencia, cuerpoFrame, puerta);
		webDriver.appendTextInFrame(txtCPOcurrencia, cuerpoFrame, cp);
		webDriver.appendTextInFrame(txtPoblacionOcurrencia, cuerpoFrame, poblacion);

		webDriver.clickElementFromDropDownByIndexInFrame(comboProvincia, cuerpoFrame, 2);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaOcurrenciaPage altaSeleccionarCausas(String grupoCausa, String tipoCausa, String gremioCausa) {
		debugBegin();

		webDriver.waitWithDriver(8000);
		webDriver.switchToFrame(cuerpoFrame);
		//webDriver.clickElementFromDropDownByIndexInFrame(comboGrupoCausas, cuerpoFrame, 2);
		//webDriver.clickElementFromDropDownByAttributeInFrame(comboGrupoCausas, cuerpoFrame, "value", "GC02");
	
		webDriver.clickElementFromDropDownByAttribute(comboGrupoCausas, grupoCausasElemento, "value", grupoCausa); 
		
	
		webDriver.waitWithDriver(5000);
		
		//webDriver.clickElementFromDropDownByIndex(comboTiposCausa, 2);
		webDriver.clickElementFromDropDownByAttribute(comboTiposCausas, tipoCausasElemento, "value", tipoCausa); 
		// TODO cambiar por VALUE
		webDriver.waitWithDriver(5000);

		if(webDriver.isOnScreen(comboGremio)) {
			//webDriver.clickElementFromDropDownByIndex(comboGremio, 3);
			webDriver.clickElementFromDropDownByAttribute(comboTiposCausas, gremioCausasElemento, "title", gremioCausa); 			
		}
		
		//si es necesario modificar la reserva a un valor específico, se lee desde csv
		if((getTestVar(Constants.RESERVA_ESPECIFICA) != null && !getTestVar(Constants.RESERVA_ESPECIFICA).isEmpty()) 
			|| webDriver.getText(reservaInicial).equals("0,00")){
			String reserva = "150";
			
			webDriver.click(modificarReserva);
			
			if(getTestVar(Constants.RESERVA_ESPECIFICA) != null && !getTestVar(Constants.RESERVA_ESPECIFICA).isEmpty()) {
				reserva = getTestVar(Constants.RESERVA_ESPECIFICA);
			}
			
			debugInfo("MODIFICAMOS LAS RESERVAS A: " + reserva);
			webDriver.switchToFrame(capaIframe);
			webDriver.waitWithDriver(5000);
			webDriver.setText(reservaInicial, reserva);
			webDriver.click(btnGrabarModificarReserva);
			webDriver.exitFrame();
			webDriver.switchToFrame(cuerpoFrame);
		}
		
		webDriver.exitFrame();
		debugEnd();
		
		return this;
	}
	public SiniestrosAltaAperturaOcurrenciaPage modificarCausasEspecificasMAC() {
		debugBegin();
		debugInfo("Seleccionamos causas específicas para siniestro MAC");
		webDriver.switchToFrame(cuerpoFrame);		
		
		webDriver.waitWithDriver(6000);
		webDriver.clickElementFromDropDownByAttribute(comboGrupoCausas, grupoCausasElemento, "value", "GC25");
		
		webDriver.waitWithDriver(6000);
		System.out.println("El grupo causa específica es: " + getTestVar(Constants.TIPO_CAUSA_MAC) + " , con código: " + getTestVar(Constants.TIPO_CAUSA_MAC_COD));
		webDriver.clickElementFromDropDownByAttribute(comboTiposCausas, tipoCausasElemento, "value", getTestVar(Constants.TIPO_CAUSA_MAC_COD));
		
//		if(webDriver.isOnScreen(comboGremio)) {
//			webDriver.clickElementFromDropDownByAttribute(comboGremio, gremioCausasElemento, "title", gremioCausa);	
//		}
		
		//Datos Adicionales
		
		webDriver.setText(renta, "120");
	
		DateFormat fechaDeHoy = new SimpleDateFormat("dd/MM/yyyy");
		
		webDriver.appendText(fechaDemanda, fechaDeHoy.format(new Date()));
		webDriver.waitWithDriver(3000);
		//TODO rellenar el resto de fechas opcionales
		
		webDriver.appendText(fechaSolicitudAvanceRenta, fechaDeHoy.format(new Date()));
		
		webDriver.exitFrame();	
		debugEnd();
		return this;
		}

	public SiniestrosAltaAperturaOcurrenciaPage altaRellenarDatos(String descripcion, String implicadosExisten, String encargo) {
		debugBegin();
		
		if(descripcion != null && descripcion.isEmpty()) {
			descripcion = "No se ha pasado pasado descripción por csv, se procede a rellenar descripción en modo automático : equipo TaaS";
		}
		debugInfo("La descripción del siniestro es: "+ descripcion);
		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(txtDescripcionSiniestro, cuerpoFrame, descripcion);
		webDriver.waitWithDriver(3000);
		if(implicadosExisten != null && !implicadosExisten.isEmpty()) {
			
			webDriver.clickInFrame(rdbtnImplicadosSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnImplicadosNo, cuerpoFrame);
		}

		if(encargo != null && !encargo.isEmpty()) {
			webDriver.clickInFrame(rdbtnEncargoSi, cuerpoFrame);
			System.out.println("Hay encargo y clicko de verdad en el botón Encargos");
		} else {
			webDriver.clickInFrame(rdbtnEncargoNo, cuerpoFrame);
		}

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaOcurrenciaPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();
		
		return this;
	}

	// public SiniestrosAltaAperturaOcurrenciaPage clickRechazarApertura()
	// {
	// logger.debug("BEGIN - clickRechazarApertura");
	// wh.clickOnWebElementInFrame(btnRechazarApertura,
	// mainFrame);
	// logger.debug("END - clickRechazarApertura");
	// }
	//
	// public SiniestrosAltaAperturaOcurrenciaPage clickVolverABuscador()
	// {
	// logger.debug("BEGIN - clickVolverABuscador");
	// wh.clickOnWebElementInFrame(btnVolverABuscador,
	// mainFrame);
	// logger.debug("END - clickVolverABuscador");
	// }
	//
	// public SiniestrosAltaAperturaOcurrenciaPage clickGuardarYSalir()
	// {
	// logger.debug("BEGIN - clickGuardarYSalir");
	// wh.clickOnWebElementInFrame(btnGuardarSalir, mainFrame);
	// logger.debug("END - clickGuardarYSalir");
	// }

	public SiniestrosAltaAperturaOcurrenciaPage datosMinOcurrencia(String numPoliza) {
		debugBegin();

		debugInfo("########################################################################");
		debugInfo("# Rellena los datos mínimos de una ocurrencia para que pase la prueba. #");
		debugInfo("########################################################################");

		webDriver.clickInFrame(grupoCausasAccidentes, cuerpoFrame);
		webDriver.clickInFrame(tipoCausasAccidentes, cuerpoFrame);

		ActionSteps.waitForIt(webDriver, txtDescripcionSiniestro);
		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(txtDescripcionSiniestro, cuerpoFrame, pulp);
		webDriver.waitWithDriver(3000);

		webDriver.clickInFrame(rdbtnImplicadosNo, cuerpoFrame);
		webDriver.clickInFrame(rdbtnEncargoNo, cuerpoFrame);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaOcurrenciaPage modificarDescripcion(String descripcion){
	//public SiniestrosAltaAperturaOcurrenciaPage modificarDescripcion(){
		
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		
		webDriver.waitForPageToLoad();
		webDriver.setText(txtDescripcionSiniestro, descripcion);
		webDriver.click(btnVerificar);
		debugEnd();
		
		webDriver.exitFrame();
		
		return this;
	}
	
	public SiniestrosAltaAperturaOcurrenciaPage modificarCausa(String grupoCausa, String tipoCausa){
		//public SiniestrosAltaAperturaOcurrenciaPage modificarDescripcion(){
			
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		
		webDriver.waitForPageToLoad();
		System.out.println("La página ha cargado. Procedemos a moificar los datos de causa.");
		webDriver.waitWithDriver(2000);
		webDriver.clickElementFromDropDownByAttribute(comboGrupoCausas, grupoCausasElemento, "value", grupoCausa); 
		webDriver.waitWithDriver(5000);
		webDriver.clickElementFromDropDownByAttribute(comboTiposCausas, tipoCausasElemento, "value", tipoCausa); 
		webDriver.waitWithDriver(3000);
		if(webDriver.isOnScreen(comboGremio)) {
			webDriver.clickElementFromDropDownByIndex(comboGremio, 3);		
		}
		webDriver.click(btnVerificar);

		webDriver.exitFrame();
		debugEnd();
			
		return this;
	}
	
	// endregion
}