package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class AltaAperturaOcurrenciaSiniestrosPage extends PageObject {

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
	private By grupoCausasAccidentesBtn = By.cssSelector("#GRUCAUSA > option:nth-child(2)");
	private By grupoCausasOption = By.cssSelector("#GRUCAUSA > option");
	private By tipoCausasAccidentesBtn = By.cssSelector("#TIPOCAUS > option:nth-child(2)");
	private By tipoCausasOption = By.cssSelector("#TIPOCAUS > option");
	private By grupoCausasDrpDwn = By.cssSelector("#GRUCAUSA");
	private By tiposCausasDrpDwn = By.id("TIPOCAUS");
	private By gremioCausasOption = By.cssSelector("#CODGREMIO > option");
	private By gremioDrpDwn = By.id("CODGREMIO");

	private By reservaInicialInput = By.id("RESEINIC");
	private By modificarReservaBtn = By.cssSelector("#datosCausa > div.sis-frame-bg > table.tableForm > tbody > tr.paraOcultar > td > span:nth-child(4) > input");
	private By grabarModificarReservaBtn = By.id("buttonRecord");
	private By btnCancelarModificarReserva = By.id("buttonCancel");

	// #### DATOS DE LA OCURRENCIA ####
	private By descripcionSiniestroInput = By.cssSelector("#version");
	private By implicadosSiBtn = By.id("implicadosSi");
	private By implicadosNoBtn = By.id("implicadosNo");
	private By encargoSiBtn = By.id("encargoSi");
	private By encargoNoBtn = By.id("encargoNo");
	private By guardarSalirBtn = By.id("botonGuardar");
	private By continuarBtn = By.id("botonContinuar");
	private By descripOcu = By.id("version");
	private By verificarBtn = By.id("botonVerificar");

	// ### DATOS ADICIONALES DE LA OCURRENCIA PARA CAUSAS ESPECIFICAS DE MAC ###

	private By rentaInput = By.cssSelector("#nombdato_RENTA_1"); // Renta
	private By suministro = By.cssSelector("#nombdato_SUMMI_1"); // Suministro
	private By fechaDemandaInput = By.cssSelector("#nombdato_FECHINDEM_1"); // *Fecha interposición demanda desahucio
	private By fechaReclamacion = By.cssSelector("#nombdato_FECHINDRC_1"); // Fecha interposición demanda reclamación
	private By fechaEntregaLlaves = By.cssSelector("#nombdato_FECHENLLA_1"); // Fecha entrega llaves
	private By fechaLanzamiento = By.cssSelector("#nombdato_FECHLANZA_1"); // Fecha lanzamiento
	private By fechaSentencia = By.cssSelector("#nombdato_FECHSENTE_1"); // Fecha sentencia
	private By fechaSolicitudAvanceRentaInput = By.cssSelector("#nombdato_FECHSOAREN_1"); // *Fecha solicitud avance renta
	
	//GUARDAR Y SALIR
	private By mensajeSiniestroProvisionalTxt = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr > td > span > strong");

	private By mensajeAvisoTxt = By.cssSelector(".grid.wideBox tr:nth-child(2) > td:nth-child(2)");
	// endregion

	public AltaAperturaOcurrenciaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public AltaAperturaOcurrenciaSiniestrosPage altaRiesgoAsegurado() {
		debugBegin();

		// TODO rellenar metodo
		// webDriver.clickElementFromDropDownByAttribute(comboLugarOcurrencia, "value", "RIES");
		// webDriver.clickElementFromDropDownByIndex(comboLugarOcurrencia, 2);

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage altaOtroLugarOcurrencia(String tipoVia, String calle, String numero, 
		String portal, String escalera, String piso, String puerta, String cp, String poblacion, String provincia) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(comboLugarOcurrencia, cuerpoFrame, 1);
		webDriver.clickElementFromDropDownByIndexInFrame(comboTipoVia, cuerpoFrame, 2);

		webDriver.setTextInFrame(txtCalleOcurrencia, cuerpoFrame, calle);
		webDriver.setTextInFrame(txtNumeroOcurrencia, cuerpoFrame, numero);
		webDriver.setTextInFrame(txtPortalOcurrencia, cuerpoFrame, portal);
		webDriver.setTextInFrame(txtEscaleraOcurrencia, cuerpoFrame, escalera);
		webDriver.setTextInFrame(txtPisoOcurrencia, cuerpoFrame, piso);
		webDriver.setTextInFrame(txtPuertaOcurrencia, cuerpoFrame, puerta);
		webDriver.setTextInFrame(txtCPOcurrencia, cuerpoFrame, cp);
		webDriver.setTextInFrame(txtPoblacionOcurrencia, cuerpoFrame, poblacion);

		webDriver.clickElementFromDropDownByIndexInFrame(comboProvincia, cuerpoFrame, 2);

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage altaSeleccionarCausas(String grupoCausa, String tipoCausa, String gremioCausa) {
		debugBegin();


		debugInfo("El código del grupo de causa es: " + getTestVar(Constants.GRUPO_CAUSA_COD));
		webDriver.waitWithDriver(10000);
		webDriver.clickElementFromDropDownByAttributeInFrame(grupoCausasDrpDwn, grupoCausasOption, cuerpoFrame, "value", grupoCausa);

		webDriver.waitWithDriver(5000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tiposCausasDrpDwn, tipoCausasOption, cuerpoFrame, "value", tipoCausa);
		webDriver.waitWithDriver(5000);

		if(gremioCausa != null && !gremioCausa.isEmpty() && webDriver.isOnScreenInFrame(gremioDrpDwn, cuerpoFrame)) {
			// TODO Comprobar tiposCausasDrpDwn deberia de ser gremioDrpDwn?
			webDriver.clickElementFromDropDownByAttributeInFrame(tiposCausasDrpDwn, gremioCausasOption, cuerpoFrame, "title", gremioCausa);
		}

		if((getTestVar(Constants.RESERVA_ESPECIFICA) != null && !getTestVar(Constants.RESERVA_ESPECIFICA).isEmpty())
			|| webDriver.getTextInFrame(reservaInicialInput, cuerpoFrame).equals("0,00")) {
			String reserva = "150";

			webDriver.clickInFrame(modificarReservaBtn, cuerpoFrame);

			if(getTestVar(Constants.RESERVA_ESPECIFICA) != null && !getTestVar(Constants.RESERVA_ESPECIFICA).isEmpty()) {
				reserva = getTestVar(Constants.RESERVA_ESPECIFICA);
			}

			debugInfo("Modificamos las reservas a: " + reserva);
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(capaIframe);
			
			webDriver.waitWithDriver(5000);
			webDriver.setText(reservaInicialInput, reserva);
			webDriver.click(grabarModificarReservaBtn);
			
			webDriver.exitFrame();
		}

		debugEnd();

		return this;
	}

	// TODO Unir con altaSeleccionarCausas
	public AltaAperturaOcurrenciaSiniestrosPage modificarCausasEspecificasMAC() {
		debugBegin();
		
		debugInfo("Seleccionamos causas específicas para siniestro MAC");

		webDriver.waitWithDriver(6000);
		webDriver.clickElementFromDropDownByAttributeInFrame(grupoCausasDrpDwn, grupoCausasOption, cuerpoFrame, "value", "GC25");

		webDriver.waitWithDriver(6000);
		debugInfo("El grupo causa específica es: " + getTestVar(Constants.TIPO_CAUSA_MAC) + ", con código: " + getTestVar(Constants.TIPO_CAUSA_MAC_COD));
		webDriver.clickElementFromDropDownByAttributeInFrame(tiposCausasDrpDwn, tipoCausasOption, cuerpoFrame, "value", getTestVar(Constants.TIPO_CAUSA_MAC_COD));

		// if(webDriver.isOnScreen(comboGremio)) {
		// webDriver.clickElementFromDropDownByAttribute(comboGremio, gremioCausasElemento, "title", gremioCausa);
		// }

		// Datos Adicionales
		webDriver.setTextInFrame(rentaInput, cuerpoFrame, "120");

		webDriver.setTextInFrame(fechaDemandaInput, cuerpoFrame, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		webDriver.waitWithDriver(3000);
		
		// TODO rellenar el resto de fechas opcionales

		webDriver.setTextInFrame(fechaSolicitudAvanceRentaInput, cuerpoFrame, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));

		
		debugEnd();
		
		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage altaRellenarDatos(String descripcion, String implicadosExisten, String encargo) {
		debugBegin();

		if(descripcion.isEmpty()) {
			descripcion = "No se ha pasado pasado descripción por csv, se procede a rellenar descripción en modo automático : equipo TaaS";
		}
		
		debugInfo("La descripción del siniestro es: " + descripcion);
		
		webDriver.waitWithDriver(8000);
		webDriver.setTextInFrame(descripcionSiniestroInput, cuerpoFrame, descripcion);
		webDriver.waitWithDriver(6000);
		
		if(implicadosExisten != null && !implicadosExisten.isEmpty()) {
			webDriver.clickInFrame(implicadosSiBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(implicadosNoBtn, cuerpoFrame);
		}

		if(encargo != null && !encargo.isEmpty()) {
			webDriver.clickInFrame(encargoSiBtn, cuerpoFrame);
			debugInfo("Hay encargo y hago clic en el botón Encargos");
		} else {
			webDriver.clickInFrame(encargoNoBtn, cuerpoFrame);
		}

		webDriver.waitWithDriver(2000);
		
		debugEnd();

		return this;
	}
	
	public AltaAperturaOcurrenciaSiniestrosPage clickGuardarSalir() {
		debugBegin();
		
		debugInfo("Procedemos a Guardar y Salir durante el alta de un siniestro.");
		debugInfo("######################################################");
		
		webDriver.clickInFrame(guardarSalirBtn, cuerpoFrame);
		webDriver.waitWithDriver(1500);
		webDriver.acceptAlert();
		
		webDriver.waitWithDriver(6000);
		
		String mensajeSiniProv = webDriver.getTextInFrame(mensajeSiniestroProvisionalTxt, cuerpoFrame);
		String numSinProv = mensajeSiniProv.substring(61, 67);
		String anyoSinProv = mensajeSiniProv.substring(56, 60);
		
		debugInfo("- Número siniestro provisional: " + numSinProv);
		debugInfo("- Año siniestro provisional: "+ anyoSinProv);
		
		setTestVar(Constants.SINIESTRO_PROVISIONAL, numSinProv);
		setTestVar(Constants.ANYO_SINIESTRO, anyoSinProv);
		
		debugInfo("- Número siniestro provisional: " + getTestVar(Constants.SINIESTRO_PROVISIONAL));
		debugInfo("- Año siniestro provisional: "+  getTestVar(Constants.ANYO_SINIESTRO));
		debugInfo(mensajeSiniProv);				
		
		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
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

	public AltaAperturaOcurrenciaSiniestrosPage datosMinOcurrencia(String numPoliza) {
		debugBegin();

		debugInfo("########################################################################");
		debugInfo("# Rellena los datos mínimos de una ocurrencia para que pase la prueba. #");
		debugInfo("########################################################################");

		webDriver.clickInFrame(grupoCausasAccidentesBtn, cuerpoFrame);
		webDriver.clickInFrame(tipoCausasAccidentesBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver, descripcionSiniestroInput);
		
		webDriver.waitWithDriver(3000);
		webDriver.setTextInFrame(descripcionSiniestroInput, cuerpoFrame, pulp);
		webDriver.waitWithDriver(3000);

		webDriver.clickInFrame(implicadosNoBtn, cuerpoFrame);
		webDriver.clickInFrame(encargoNoBtn, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage modificarDescripcion(String descripcion) {
		debugBegin();
		
		debugInfo("Descripcion: " + descripcion);
		setTestVar(Constants.DESCRIPCION_SINIESTRO, descripcion); 
		
		webDriver.setTextInFrame(descripcionSiniestroInput, cuerpoFrame, descripcion);
		webDriver.clickInFrame(verificarBtn, cuerpoFrame);
		
		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage modificarCausa(String grupoCausa, String tipoCausa) {
		debugBegin();
		
		debugInfo("La página ha cargado. Procedemos a moificar los datos de causa.");
		webDriver.waitWithDriver(2000);
		webDriver.clickElementFromDropDownByAttributeInFrame(grupoCausasDrpDwn, grupoCausasOption, cuerpoFrame, "value", grupoCausa);
		webDriver.waitWithDriver(5000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tiposCausasDrpDwn, tipoCausasOption, cuerpoFrame, "value", tipoCausa);
		webDriver.waitWithDriver(3000);
		
		if(webDriver.isOnScreenInFrame(gremioDrpDwn, cuerpoFrame)) {
			webDriver.clickElementFromDropDownByIndexInFrame(gremioDrpDwn, cuerpoFrame, 3);
		}
		
		webDriver.clickInFrame(verificarBtn, cuerpoFrame);
		
		debugEnd();

		return this;
	}

	// -----------------------------------------RETENCIONES---------------------------------------------------------------------

	//---------------------------CAUSA-------------------------------------------------
	public AltaAperturaOcurrenciaSiniestrosPage comprobarAvisos() {
		webDriver.waitWithDriver(5000);
		
		if(webDriver.isPresentInFrame(mensajeAvisoTxt, cuerpoFrame)) {
			String aviso = webDriver.getTextInFrame(mensajeAvisoTxt, cuerpoFrame);

			if(aviso.contains("Existe otro siniestro con") && aviso.contains("para esta póliza con la misma fecha de ocurrencia.")) {
				clickContinuar();
			}
		}

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage grupoCausaFalloVacio() {
		debugBegin();

		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DESCRIPCION_SINIESTRO_CARACTERES);
		webDriver.acceptAlert();
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_GRUPO_CAUSAS);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarGrupoCausa() {
		return seleccionarGrupoCausa("");
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarGrupoCausa(String opcion) {
		debugBegin();
		
		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 0);
				break;
			case "Accidentes":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 1);
				break;
			default:
			case "Agua":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 2);
				break;
			case "Asistencia complementaria":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 3);
				break;
			case "Daños eléctricos":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 4);
				break;
			case "Defensa y reclamación":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 5);
				break;
			case "Fenómenos Atmosféricos":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 6);
				break;
			case "Incendio":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 7);
				break;
			case "Jardines":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 8);
				break;
			case "R.C.General":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 9);
				break;
			case "Riesgos Extensivos":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 10);
				break;
			case "Robo":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 11);
				break;
			case "Rotura Cristales":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 12);
				break;
			case "Varios":
				webDriver.clickElementFromDropDownByIndexInFrame(grupoCausasDrpDwn, cuerpoFrame, 13);
				break;
		}

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage tipoCausaFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DESCRIPCION_SINIESTRO_CARACTERES);
		webDriver.acceptAlert();
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CAUSAS);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarTipoCausa() {
		return seleccionarTipoCausa("2001 BAJANTE GENERAL");
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarTipoCausa(String opcion) {
		debugBegin();
		
		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 0);
				break;
			case "2000 AGUA":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 1);
				break;
			default:
			case "2001 BAJANTE GENERAL":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 2);
				break;
			case "2002 MONTANTES/ACOMETIDAS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 3);
				break;
			case "2003 GRIFOS COMUNITARIOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 4);
				break;
			case "2004 DESAGÜES PRIVADOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 5);
				break;
			case "2005 CONDUCCIONES PRIVADAS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 6);
				break;
			case "2006 GRIFOS PRIVADOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 7);
				break;
			case "2007 CALEFACCION":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 8);
				break;
			case "2009 FILTRACIONES CUBIERTA":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 9);
				break;
			case "2010 CONDUCCIÓN VISTA SIN DAÑOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 10);
				break;
			case "2011 CONDUCCION SUBTERRANEA":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 11);
				break;
			case "2012 CONDENSACIONES":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 12);
				break;
			case "2014 FILTRACIONES ALICATADO":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 13);
				break;
			case "2015 FILTRACIONES FACHADAS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 14);
				break;
			case "2016 PISCINAS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 15);
				break;
			case "2017 DAÑOS POR AGUA (OBRAS)":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 16);
				break;
			case "2018 INUNDACION":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 17);
				break;
			case "2019 ATASCOS CON DAÑOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 18);
				break;
			case "2020 EXCESO DE AGUA":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 19);
				break;
			case "2021 AGUA EDIFICIO COLINDANTE":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 20);
				break;
			case "2022 AGUAS PORTERÍA":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 21);
				break;
			case "2023 BAJANTE PLUVIAL":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 22);
				break;
			case "2029 ATASCO SIN DAÑOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 23);
				break;
			case "2030 ATASCOS CON DAÑOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 24);
				break;
			case "2031 ATASCO SIN DAÑOS":
				webDriver.clickElementFromDropDownByIndexInFrame(tiposCausasDrpDwn, cuerpoFrame, 25);
				break;
		}

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage descripcionSiniestroFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DESCRIPCION_SINIESTRO_CARACTERES);
		webDriver.acceptAlert();
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DESCRIPCION_SINIESTRO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage descripcionSiniestroFalloMinimoCaracteres() {
		debugBegin();

		webDriver.setTextInFrame(descripcionSiniestroInput, cuerpoFrame, "El siniestro");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DESCRIPCION_SINIESTRO_CARACTERES);
		webDriver.acceptAlert();
		
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EXISTEN_IMPLICADOS);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage escribirDescripcionSiniestro() {
		debugBegin();
		webDriver.setTextInFrame(descripcionSiniestroInput, cuerpoFrame, "El siniestro ha ocurrido en el domicilio y esto es una descripcion.");
		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage existenImplicadosFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EXISTEN_IMPLICADOS);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarExistenImplicados() {
		debugBegin();
		webDriver.clickInFrame(implicadosSiBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage necesitaEncargoFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NECESITA_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public AltaAperturaOcurrenciaSiniestrosPage seleccionarNecesitaEncargo() {
		debugBegin();
		webDriver.clickInFrame(encargoSiBtn, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}