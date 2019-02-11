package com.project.pages;

import java.lang.String.*;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

import org.openqa.selenium.By;

public class SiniestrosAltaAperturaOcurrenciaPage extends PageObject {
	
	
	String pulp = "Ezequiel, 25-17: El camino del hombre recto está por todos lados rodeado por la avaricia de los egoístas y la tiranía de los hombres malos.";
	
	public SiniestrosAltaAperturaOcurrenciaPage(UserStory userS) {
		super(userS);
	}


	// region webelements
	
	
	//	#####	FRAMES	####
	
	// @FindBy(id = "leftFrame")
	// private By menuFrame;
	//
	// @FindBy(id = "topFrame")
	// private By topFrame;
	//
	// @FindBy(id = "mainFrame")
	private By cuerpoFrame =  By.id("mainFrame");

	
	//	####	LUGAR DE OCURRENCIA	####
	
	// @FindBy(id = "cabRechazar")
	// private By btnRechazarApertura;
	//
	private By buttonRechazarApertura = By.id("cabRechazar");
	//
	private By comboLugarOcurrencia = By.id("listaLugares");
	//
	private By comboTipoVia = By.id("tdviaocu");
	//
	private By txtCalleOcurrencia = By.id("calleocu");
	//
	private By txtNumeroOcurrencia = By.id("numcaocu");
	//
	private By txtPortalOcurrencia = By.id("portalocu");
	//
	private By txtEscaleraOcurrencia = By.id("escalocu");
	//
	private By txtPisoOcurrencia = By.id("pisoocu");
	//
	private By txtPuertaOcurrencia = By.id("puertaocu");
	//
	private By txtCPOcurrencia = By.id("cpocu");
	//
	private By txtPoblacionOcurrencia = By.id("poblocu");
	//
	private By comboProvincia = By.id("provocu");
	//
	private By buttonGoogleMaps = By.id("dirMaps");
	//
	// @FindBy(xpath = "./html/body/div[3]/div/ul/li[1]/a/span")
	// private By btnVolverABuscador;
	//
	// @FindBy(id = "listaLugares")
	// private By drpdwnLugarOcurrencia;
	
		
	//	####	CAUSAS	####
	
	// @FindBy(id = "GRUCAUSA")
	private By grupoCausasAccidentes = By.cssSelector("#GRUCAUSA > option:nth-child(2)");
	//
	// @FindBy(id = "TIPOCAUS")
	private By tipoCausasAccidentes = By.cssSelector("#TIPOCAUS > option:nth-child(2)");
	//
	private By comboGrupoCausas = By.id("GRUCAUSA");
	//
	private By comboTiposCausa = By.id("TIPOCAUS");
	//
	private By comboGremio = By.id("CODGREMIO");
	//
	
	//	####	DATOS DE LA OCURRENCIA	####
	
	// @FindBy(id = "version")
	private By txtDescripcionSiniestro = By.id("version");
	//
	// @FindBy(id = "implicadosSi")
	private By rdbtnImplicadosSi = By.id("implicadosSi");
	//
	// @FindBy(id = "implicadosNo")
	private By rdbtnImplicadosNo = By.id("implicadosNo");
	//
	// @FindBy(id = "encargoSi")
	private By rdbtnEncargoSi = By.id("encargoSi");
	//
	// @FindBy(id = "encargoNo")
	private By rdbtnEncargoNo = By.id("encargoNo");
	//
	// @FindBy(id = "botonGuardar")
	private By btnGuardarSalir = By.id("botonGuardar");
	//
	// @FindBy(id = "botonContinuar")
	private By btnContinuar = By.id("botonContinuar");
	
	
	private By descripOcu = By.id("version");
	
	// endregion
	
		
	// region methods
		
	//Lugar es el riesgo asegurado
	public void altaRiesgoAsegurado()
	{
		this.debugBegin();
		
		this.webDriver.clickElementFromDropDownByAttribute(this.comboLugarOcurrencia, "value", "RIES");
						
		this.debugEnd(); 
	}

	//Otro lugar de ocurrencia
	public void altaOtroLugarOcurrencia(String tipoVia, String calle, String numero, String portal, String escalera, String piso, String puerta, String cp, String poblacion, String provincia)
	{
		this.debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(this.comboLugarOcurrencia, "value", "OTRO");
		this.webDriver.clickElementFromDropDownByAttribute(this.comboTipoVia, "value", tipoVia);
		this.webDriver.appendText(this.txtCalleOcurrencia, calle);
		this.webDriver.appendText(this.txtNumeroOcurrencia, numero);
		this.webDriver.appendText(this.txtPortalOcurrencia, portal);
		this.webDriver.appendText(this.txtEscaleraOcurrencia, escalera);
		this.webDriver.appendText(this.txtPisoOcurrencia, piso);
		this.webDriver.appendText(this.txtPuertaOcurrencia, puerta);
		this.webDriver.appendText(this.txtCPOcurrencia, cp);
		this.webDriver.appendText(this.txtPoblacionOcurrencia, poblacion);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboProvincia, "value", provincia);
							
		this.debugEnd(); 
	}

	//Seleccionar Causas
	public void altaSeleccionarCausas(String grupoCausa, String tipoCausa, String gremioCausa)
	{
		this.debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(this.comboGrupoCausas, "value", grupoCausa);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboTiposCausa, "value", tipoCausa);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboGremio, "value", tipoCausa);
						
		this.debugEnd(); 
	}
	

	//Rellenar Datos
	public void altaRellenarDatos(String descripcion, boolean implicadosExisten, boolean encargo)
	{
		this.debugBegin();

		this.webDriver.appendText(this.txtDescripcionSiniestro, descripcion);
		if(implicadosExisten)this.webDriver.click(this.rdbtnImplicadosSi);
		else this.webDriver.click(this.rdbtnImplicadosNo);
		if(encargo)this.webDriver.click(this.rdbtnEncargoSi);
		else this.webDriver.click(this.rdbtnEncargoNo);
						
		this.debugEnd(); 
	}
		
	
	//Click en continuar
	public void clickContinuar()
	{
		this.debugBegin();

		this.webDriver.click(this.btnContinuar);
						
		this.debugEnd(); 
	}
		
	// public void clickRechazarApertura()
	// {
	// logger.debug("BEGIN - clickRechazarApertura");
	// this.wh.clickOnWebElementInFrame(this.btnRechazarApertura,
	// this.mainFrame);
	// logger.debug("END - clickRechazarApertura");
	// }
	//
	// public void clickVolverABuscador()
	// {
	// logger.debug("BEGIN - clickVolverABuscador");
	// this.wh.clickOnWebElementInFrame(this.btnVolverABuscador,
	// this.mainFrame);
	// logger.debug("END - clickVolverABuscador");
	// }
	//
	// public void selectLugarOcurrencia(
	// String lugar)
	// {
	// logger.debug("BEGIN - selectLugarOcurrencia");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnLugarOcurrencia,
	// this.mainFrame, lugar);
	// logger.debug("END - selectLugarOcurrencia");
	// }
	//
	// public void selectGrupoCausas(
	// String causa)
	// {
	// logger.debug("BEGIN - selectGrupoCausas");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnGrupoCausas,
	// this.mainFrame, causa);
	// logger.debug("END - selectGrupoCausas");
	// }
	//
	// public void selectTipoCausas(
	// String tipoCausa)
	// {
	// logger.debug("BEGIN - selectTipoCausas");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnTipoCausas,
	// this.mainFrame, tipoCausa);
	// logger.debug("END - selectTipoCausas");
	// }
	//
	// public void writeDescripcionSiniestro(
	// String descripcion)
	// {
	// logger.debug("BEGIN - writeDescripcionSiniestro");
	// this.wh.sendValueToWebElementInFrame(this.txtDescripcionSiniestro,
	// this.mainFrame, descripcion);
	// logger.debug("END - writeDescripcionSiniestro");
	// }
	//
	// public void clickImplicadosSi()
	// {
	// logger.debug("BEGIN - clickImplicadosSi");
	// this.wh.clickOnWebElementInFrame(this.rdbtnImplicadosSi, this.mainFrame);
	// logger.debug("END - clickImplicadosSi");
	// }
	//
	// public void clickImplicadosNo()
	// {
	// logger.debug("BEGIN - clickImplicadosNo");
	// this.wh.clickOnWebElementInFrame(this.rdbtnImplicadosNo, this.mainFrame);
	// logger.debug("END - clickImplicadosNo");
	// }
	//
	// public void clickEncargoSi()
	// {
	// logger.debug("BEGIN - clickEncargoSi");
	// this.wh.clickOnWebElementInFrame(this.rdbtnEncargoSi, this.mainFrame);
	// logger.debug("END - clickEncargoSi");
	// }
	//
	// public void clickEncargoNo()
	// {
	// logger.debug("BEGIN - clickEncargoNo");
	// this.wh.clickOnWebElementInFrame(this.rdbtnEncargoNo, this.mainFrame);
	// logger.debug("END - clickEncargoNo");
	// }
	//
	// public void clickGuardarYSalir()
	// {
	// logger.debug("BEGIN - clickGuardarYSalir");
	// this.wh.clickOnWebElementInFrame(this.btnGuardarSalir, this.mainFrame);
	// logger.debug("END - clickGuardarYSalir");
	// }
	//
	// public void clickContinuar()
	// {
	// logger.debug("BEGIN - clickContinuar");
	// this.wh.clickOnWebElementInFrame(this.btnContinuar, this.mainFrame);
	// logger.debug("END - clickContinuar");
	// }

		
	public void datosMinOcurrencia(String numPoliza)	//rellena los datos mínimos de una ocurrencia para que pase la prueba
	{	
		this.debugBegin();
		
		System.out.println("########################################################################");
		System.out.println("# Rellena los datos mínimos de una ocurrencia para que pase la prueba. #");
		System.out.println("########################################################################");	
		
		//String descripcion = "Un héroe es todo aquel que hace lo que puede";
		
		this.webDriver.switchToFrame(this.cuerpoFrame);
		
		this.webDriver.click(this.grupoCausasAccidentes);
		this.webDriver.click(this.tipoCausasAccidentes);
		
		Steps.waitForIt(webDriver, txtDescripcionSiniestro);
		this.webDriver.waitWithDriver(3000);
		this.webDriver.appendText(this.txtDescripcionSiniestro, pulp);
		this.webDriver.waitWithDriver(3000);

		System.out.println("####################");
		System.out.println("# escribo algo 2 . #");
		System.out.println("####################");	
		
		this.webDriver.click(this.rdbtnImplicadosNo);
		this.webDriver.click(this.rdbtnEncargoNo);
		
		//if(numPoliza.substring(0, 2).equals("510") || numPoliza.substring(0, 2).equals("500")) this.webDriver.app;
		
		this.webDriver.click(this.btnContinuar);
		Steps.waitForIt(webDriver);
		
		this.webDriver.exitFrame();
		
		this.debugEnd();
	}
	// endregion		
}