package com.amaris.project.pages.administracion.siniestros.gestion;

import com.amaris.project.Constants;
import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionBuscadorSiniestrosPage extends PageObject {

	// Elementos
	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	// private By gestionSiniestros = By.xpath(".//*[text()='Gestión de siniestros']");
	private By gestionSiniestrosBtn = By.cssSelector("#jt5");

	private By numeroSiniestroBtn = By.cssSelector("#filtro1");
	private By numeroPolizaBtn = By.cssSelector("#filtro2");
	private By numeroReciboBtn = By.cssSelector("#filtro3");
	private By aseguradoBtn = By.cssSelector("#filtro4");
	private By fechaOcurrenciaBtn = By.cssSelector("#filtro6");
	private By fechaAltaBtn = By.cssSelector("#filtro7");
	private By causaBtn = By.cssSelector("#filtro8");
	private By otrosBtn = By.cssSelector("#filtro9");
	private By opProduct = By.cssSelector("#capaPOLIZA td.flexibleField");
	private By opProductoSiniestroDrpDwn = By.cssSelector("#capaSINIESTRO td.flexibleField");

	// Opcion Numero Siniestro
	private By tipoProductoSini = By.cssSelector("#prodsini");
	private By anyoInput = By.cssSelector("#seriesin");
	private By numeroSiniestroInput = By.cssSelector("#numesini");

	// Opcion Numero Poliza
	private By tipoProductoPolizaDrpDwn = By.cssSelector("#producto");
	private By numeroPolizaInput = By.cssSelector("#polizsec");

	// Opcion Numero recibo
	private By numeroRecibo1Input = By.cssSelector("#recibann");
	private By numeroRecibo2Input = By.cssSelector("#recibsec");

	// Opcion Asegurado
	private By numeroDocumentoInput = By.cssSelector("#numedocu");
	private By nombreInput = By.cssSelector("#nombpcom");
	private By empiezaBtn = By.cssSelector("#nombpcom");
	private By contieneBtn = By.cssSelector("#contiene");

	// Opcion fecha ocurrencia
	private By fechaDesdeInput = By.cssSelector("#desde");
	private By fechaHastaInput = By.cssSelector("#hasta");

	// Opcion fecha alta
	private By fechaAltaDesdeInput = By.cssSelector("#altadesde");
	private By fechaAltaHastaInput = By.cssSelector("#altahasta");

	// Opcion tipo causa
	private By fechaCausaDesdeInput = By.cssSelector("#fechDesde");
	private By fechaCausaHastaInput = By.cssSelector("#fechHasta");
	private By codigoCausaInput = By.cssSelector("#name4");

	// Opcion Otros
	private By fechaOtrosDesdeInput = By.cssSelector("#fdesde");
	private By fechaOtrosHastaInput = By.cssSelector("#fhasta");
	private By estadoPolizaDrpDwn = By.cssSelector("#estado");
	private By negocio = By.cssSelector("#productoSini");
	private By mediadorInput = By.cssSelector("#codMediador");

	private By buscarBtn = By.cssSelector("#botonBuscar");

	// private By btnContinuar = By.cssSelector("#capaAjax tr.odd span");
	private By continuarBtn = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(11) > a > span");
	private By btnContinuarElemento = By.cssSelector("#formListado tr:last-of-type [onclick*='enlaceContinuar']");

	public GestionBuscadorSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public GestionBuscadorSiniestrosPage abrirGestionSiniestro() {
		debugBegin();

		webDriver.clickInFrame(gestionSiniestrosBtn, leftFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorNumeroPoliza(String numPoliza) {
		debugBegin();
		webDriver.clickInFrame(gestionSiniestrosBtn, leftFrame);
		debugInfo("ha dado click");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(numeroPolizaBtn);
		/*
		 * System.out.println("Ramo de póliza - " + numPoliza.substring(0,3)); if (numPoliza.substring(0,3) == "510"){
		 * webDriver.clickElementChildByAttribute(opProduct,"value", "510"); System.out.println("poliza de 510"); } //
		 * webDriver.switchToFrame(cuerpoFrame); //
		 * webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza, cuerpoFrame, "value", "510");
		 * //webDriver.clickElementFromDropDownByAttribute(opProduct, tipoProductoPoliza, "value", '510');
		 * 
		 * else if (numPoliza.substring(0,3) == "920"){ webDriver.clickElementChildByAttribute(opProduct,"value",
		 * "920");}
		 * 
		 * else if (numPoliza.substring(0,3) == "640"){ webDriver.clickElementChildByAttribute(opProduct,"value",
		 * "640");}
		 */

		webDriver.clickElementFromDropDownByIndex(tipoProductoPolizaDrpDwn, 0);

		webDriver.setText(numeroPolizaInput, numPoliza);
		webDriver.waitForPageToLoad();
		webDriver.waitForElementToBeClickable(buscarBtn);
		webDriver.click(buscarBtn);

		ActionSteps.waitForIt(webDriver);
		webDriver.click(continuarBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorNumeroSiniestro(String siniestro, String anio, String negocio) {
		debugBegin();

		webDriver.clickInFrame(gestionSiniestrosBtn, leftFrame);
		webDriver.clickInFrame(numeroSiniestroBtn, cuerpoFrame);

		if(negocio != null && negocio.equals(Constants.MEC)) {
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickElementChildByAttribute(opProductoSiniestroDrpDwn, "value", "510");
			webDriver.exitFrame();
		}

		webDriver.setTextInFrame(anyoInput, cuerpoFrame, anio);

		webDriver.setTextInFrame(numeroSiniestroInput, cuerpoFrame, siniestro);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorNumeroSiniestro(String siniestro, String anio) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(gestionSiniestrosBtn, leftFrame);
		debugInfo("ha dado click");

		webDriver.clickInFrame(numeroSiniestroBtn, cuerpoFrame);
		/*
		 * if (negocio.equals(Constants.MEC)){ webDriver.switchToFrame(cuerpoFrame);
		 * webDriver.clickElementChildByAttribute(opProductSIni,"value", "510"); webDriver.exitFrame(); }
		 */
		webDriver.switchToFrame(cuerpoFrame);

		// ActionSteps.waitForIt(webDriver);
		// webDriver.clickElementFromDropDownByIndex(tipoProductoSini, 0);

		// ActionSteps.waitForIt(webDriver);
		webDriver.setText(anyoInput, anio);

		webDriver.setText(numeroSiniestroInput, siniestro);
		webDriver.click(buscarBtn);
		webDriver.waitWithDriver(6000);
		// ActionSteps.waitForIt(webDriver);
		webDriver.click(continuarBtn);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorRecibo(String recibo1, String recibo2) {
		debugBegin();

		webDriver.clickInFrame(numeroReciboBtn, cuerpoFrame);
		webDriver.appendTextInFrame(numeroRecibo1Input, cuerpoFrame, recibo1);
		webDriver.appendTextInFrame(numeroRecibo2Input, cuerpoFrame, recibo2);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorAsegurado(String asegurador, String opNombre, String nombre, String documento) {
		debugBegin();

		webDriver.clickInFrame(aseguradoBtn, cuerpoFrame);

		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, documento);
		if(opNombre == "contiene") {
			webDriver.clickInFrame(contieneBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(empiezaBtn, cuerpoFrame);
		}

		webDriver.setTextInFrame(nombreInput, cuerpoFrame, nombre);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorOcurrencia(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(fechaOcurrenciaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaHastaInput, cuerpoFrame, fHasta);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorAlta(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(fechaAltaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaAltaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaAltaHastaInput, cuerpoFrame, fHasta);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// Alternativo_MIRKO
	/*
	 * public GestionSiniestroBuscadorPage buscarPorNumeroPoliza(String numPoliza) { debugBegin();
	 * webDriver.clickInFrame(gestionSiniestros, leftFrame); debugInfo("ha dado click");
	 * webDriver.switchToFrame(cuerpoFrame); webDriver.click(btnNoPoliza); if(numPoliza.substring(0, 3) == "510") {
	 * webDriver.clickElementFromDropDownByAttribute(opProduct, opProductElemento, "value", "510"); } //
	 * webDriver.switchToFrame(cuerpoFrame); // webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza,
	 * cuerpoFrame, "value", "510"); // webDriver.clickElementFromDropDownByAttribute(opProduct, tipoProductoPoliza,
	 * "value", '510');
	 * 
	 * else if(numPoliza.substring(0, 3) == "920") { webDriver.clickElementFromDropDownByAttribute(opProduct,
	 * opProductElemento, "value", "920"); }
	 * 
	 * else if(numPoliza.substring(0, 3) == "640") { webDriver.clickElementFromDropDownByAttribute(opProduct,
	 * opProductElemento, "value", "640"); }
	 * 
	 * webDriver.setText(txtNoPoliza, numPoliza); webDriver.click(btnBuscar);
	 */

	/*
	 * List<WebElement> listaBtnContinuar = webDriver.getElements(btnContinuar);
	 * 
	 * if(listaBtnContinuar.size() == 1) { webDriver.click(btnContinuarElemento);
	 * System.out.println("Solo 1 siniestro para la póliza " + getTestVar(Constants.NUM_POLIZA)); } else {
	 * webDriver.click(listaBtnContinuar.get(listaBtnContinuar.size())); System.out.println("Hay " +
	 * listaBtnContinuar.size() + " siniestros para la póliza " + getTestVar(Constants.NUM_POLIZA)); }
	 */
	/*
	 * webDriver.waitWithDriver(3000); webDriver.click(btnContinuarElemento);
	 * 
	 * webDriver.exitFrame();
	 * 
	 * debugEnd();
	 * 
	 * return this; }
	 */

	public GestionBuscadorSiniestrosPage buscarPorCausa(String fDesde, String fHasta, String nombre) {
		debugBegin();

		webDriver.clickInFrame(causaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaCausaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaCausaHastaInput, cuerpoFrame, fHasta);
		webDriver.appendTextInFrame(codigoCausaInput, cuerpoFrame, nombre);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionBuscadorSiniestrosPage buscarPorOtros(String fDesde, String fHasta, String codMediador, String negocio) {
		debugBegin();

		webDriver.clickInFrame(otrosBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaOtrosDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaOtrosHastaInput, cuerpoFrame, fHasta);

		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPolizaDrpDwn, cuerpoFrame, "value", "510");
		}

		webDriver.clickElementFromDropDownByAttributeInFrame(estadoPolizaDrpDwn, cuerpoFrame, "value", "V");

		webDriver.setTextInFrame(mediadorInput, cuerpoFrame, codMediador);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// TODO Revisar para hacer reusable
	public GestionBuscadorSiniestrosPage metodoParche(String siniestroParche, String anyoParche) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(gestionSiniestrosBtn, leftFrame);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(numeroSiniestroBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.setTextInFrame(anyoInput, cuerpoFrame, anyoParche);

		webDriver.setTextInFrame(numeroSiniestroInput, cuerpoFrame, siniestroParche);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		webDriver.waitWithDriver(5000);

		debugInfo("Clic en Abrir siniestro");

		debugEnd();

		return this;
	}

}