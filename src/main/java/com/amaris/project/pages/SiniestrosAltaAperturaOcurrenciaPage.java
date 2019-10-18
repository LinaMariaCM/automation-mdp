package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class SiniestrosAltaAperturaOcurrenciaPage extends PageObject {

	String pulp = "Ezequiel, 25-17: El camino del hombre recto está por todos lados rodeado por la avaricia de los egoístas y la tiranía de los hombres malos.";

	// region webelements
	// ##### FRAMES ####
	private By cuerpoFrame = By.id("mainFrame");

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
	private By tipoCausasAccidentes = By.cssSelector("#TIPOCAUS > option:nth-child(2)");
	private By comboGrupoCausas = By.id("GRUCAUSA");
	private By comboTiposCausa = By.id("TIPOCAUS");
	private By comboGremio = By.id("CODGREMIO");

	// #### DATOS DE LA OCURRENCIA ####
	private By txtDescripcionSiniestro = By.id("version");
	private By rdbtnImplicadosSi = By.id("implicadosSi");
	private By rdbtnImplicadosNo = By.id("implicadosNo");
	private By rdbtnEncargoSi = By.id("encargoSi");
	private By rdbtnEncargoNo = By.id("encargoNo");
	private By btnGuardarSalir = By.id("botonGuardar");
	private By btnContinuar = By.id("botonContinuar");
	private By descripOcu = By.id("version");
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

		webDriver.waitWithDriver(2000);
		
		webDriver.clickElementFromDropDownByIndexInFrame(comboGrupoCausas, cuerpoFrame, 2);
		// TODO cambiar por VALUE
		webDriver.waitWithDriver(500);
		// TODO cambiar por VALUE
		webDriver.clickElementFromDropDownByIndexInFrame(comboTiposCausa, cuerpoFrame, 2);
		// TODO cambiar por VALUE
		webDriver.waitWithDriver(500);

		if(webDriver.isOnScreen(comboGremio)) {
			webDriver.clickElementFromDropDownByIndexInFrame(comboGremio, cuerpoFrame, 3);
		}// TODO cambiar por VALUE

		debugEnd();
		
		return this;
	}

	public SiniestrosAltaAperturaOcurrenciaPage altaRellenarDatos(String descripcion, String implicadosExisten, String encargo) {
		debugBegin();

		webDriver.appendTextInFrame(txtDescripcionSiniestro, cuerpoFrame, descripcion);

		if(!implicadosExisten.isEmpty()) {
			webDriver.clickInFrame(rdbtnImplicadosSi, cuerpoFrame);
		} else {
			webDriver.clickInFrame(rdbtnImplicadosNo, cuerpoFrame);
		}

		if(!encargo.isEmpty()) {
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
	// endregion
}