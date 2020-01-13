package com.amaris.project.pages.administracion.siniestros.apertura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import java.util.List;

public class AltaAperturaSiniestrosPage extends PageObject {

	// region webelements
	private By menuFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By mainFrame = By.id("mainFrame");

	private By numPolizaBtn = By.id("filtro1");
	private By nombreTomadorBtn = By.id("filtro2");
	private By nifBtn = By.id("filtro3");
	private By rdbtnDireccion = By.id("filtro4");
	private By polizaProcedenciaBtn = By.id("filtro5");
	private By otrosBtn = By.id("filtro6");

	private By continuarBtn = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(12) > a > span");
	private By buscarBtn = By.name("botonBuscar");
	private By productoDrpDwn = By.id("producto_poliza");

	private By numPolizaInput = By.id("polizsec");
	private By empiezaPorBtn = By.id("empiezapor");
	private By contieneBtn = By.id("contiene");
	private By nombreInput = By.id("nombpcom");
	private By nifDocumentoInput = By.id("numedocu");
	private By txtProvincia = By.id("BUSC_EDIF_PROVINCIA");
	private By txtPoblacion = By.id("BUSC_EDIF_POBLACION");
	private By txtVia = By.id("BUSC_EDIF_VIA");
	private By txtNumVia = By.id("BUSC_EDIF_NUMVIA");
	private By txtRestoVia = By.id("BUSC_EDIF_RESTVIA");
	private By txtCodigoPostal = By.id("BUSC_EDIF_POSTCOD");
	private By polizaProcedenciaInput = By.id("poliproce");
	private By fechaDesdeInput = By.id("desde");
	private By fechaHastaInput = By.id("hasta");

	private By estadoDrpDwn = By.id("estado");
	private By lineaNegocioDrpDwn = By.id("producto");
	private By codigoMediadorInput = By.id("codMediador");
	private By comboIntervalo = By.id("intervalo");
	private By comboPaginas = By.id("paginas");

	private By polizas50Btn = By.cssSelector(".lnkViewAllResults");

	private By selectPolizaBtn = By.cssSelector(".si-button2.si-arrow-right");
	// private By selectPoliza = By.cssSelector("#capaAjax > table > tbody > tr:nth-child("+
	// Integer.toString((int)((Math.random()*51))) +") > td:nth-child(12) > a > span");

	// endregion

	public AltaAperturaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public AltaAperturaSiniestrosPage buscar50Polizas() {
		debugBegin();

		webDriver.clickInFrame(polizas50Btn, mainFrame);
		ActionSteps.waitForIt(userS.getWebDriver());

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNumPoliza(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(numPolizaBtn, mainFrame);
		webDriver.setTextInFrame(numPolizaInput, mainFrame, numPoliza);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNumPoliza(String codigoProducto, String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(numPolizaBtn, mainFrame);
		// webDriver.clickElementFromDropDownByAttribute(comboProducto, "value", codigoProducto);
		webDriver.clickElementFromDropDownByIndexInFrame(productoDrpDwn, mainFrame, 0);
		webDriver.setTextInFrame(numPolizaInput, mainFrame, numPoliza);
		webDriver.clickInFrame(buscarBtn, mainFrame);
		
		ActionSteps.waitForIt(userS.getWebDriver());

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNombreTomador(String nombreTomador) {
		debugBegin();

		webDriver.clickInFrame(nombreTomadorBtn, mainFrame);
		webDriver.clickInFrame(empiezaPorBtn, mainFrame);
		webDriver.setTextInFrame(nombreInput, mainFrame, nombreTomador);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarContieneNombreTomador(String nombreTomador) {
		debugBegin();

		webDriver.clickInFrame(nombreTomadorBtn, mainFrame);
		webDriver.clickInFrame(contieneBtn, mainFrame);
		webDriver.setTextInFrame(nombreInput, mainFrame, nombreTomador);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNIF(String nif) {
		debugBegin();

		webDriver.clickInFrame(nifBtn, mainFrame);
		webDriver.setTextInFrame(nifDocumentoInput, mainFrame, nif);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPolizaProcedencia(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(polizaProcedenciaBtn, mainFrame);
		webDriver.setTextInFrame(polizaProcedenciaInput, mainFrame, numPoliza);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarOtros(String desde, String hasta, String estado, String lineaNegocio, String mediador) {
		debugBegin();

		webDriver.clickInFrame(otrosBtn, mainFrame);

		webDriver.setTextInFrame(fechaDesdeInput, mainFrame, desde);
		webDriver.setTextInFrame(fechaHastaInput, mainFrame, hasta);

		// Estados: V = vigor, A =Anulada, F = Vencida
		webDriver.clickElementFromDropDownByAttributeInFrame(estadoDrpDwn, mainFrame, "value", estado);
		// Lineas Negocio 920, 510, 660, 640, 500
		webDriver.clickElementFromDropDownByAttributeInFrame(lineaNegocioDrpDwn, mainFrame, "value", lineaNegocio);
		webDriver.setTextInFrame(codigoMediadorInput, mainFrame, mediador);

		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	// Busqueda por Otros (solo fecha y ramo)
	public AltaAperturaSiniestrosPage buscarOtros(String desde, String hasta, String lineaNegocio) {
		debugBegin();

		webDriver.clickInFrame(otrosBtn, mainFrame);
		webDriver.setTextInFrame(fechaDesdeInput, mainFrame, desde);
		webDriver.setTextInFrame(fechaHastaInput, mainFrame, hasta);
		// Ramos 920, 510, 660, 640, 500
		webDriver.clickElementFromDropDownByAttributeInFrame(lineaNegocioDrpDwn, mainFrame, "value", lineaNegocio);

		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	// Continuar
	public AltaAperturaSiniestrosPage continuarPrimeraPoliza() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage continuarRandomPoliza() {
		debugBegin();

		List<WebElement> listaPolizas = webDriver.getElementsInFrame(selectPolizaBtn, mainFrame);

		webDriver.waitWithDriver(3000);

		webDriver.clickInFrame(listaPolizas.get((int) (Math.random() * listaPolizas.size())), mainFrame);

		debugEnd();

		return this;
	}

	// Busqueda por Direccion con la información obligatoriav TBD
	/*
	 * public SiniestrosAltaAperturaPage buscarDireccion(String provincia, String poblacion, String via, String numVia)
	 * { debugBegin();
	 * 
	 * webDriver.clickInFrame(rdbtnDireccion, mainFrame); webDriver.appendTextInFrame(txtProvincia, mainFrame,
	 * provincia); webDriver.appendTextInFrame(txtPoblacion, mainFrame, poblacion); webDriver.appendTextInFrame(txtVia,
	 * mainFrame, via); webDriver.appendTextInFrame(txtNumVia, mainFrame, numVia); webDriver.clickInFrame(btnBuscar,
	 * mainFrame);
	 * 
	 * debugEnd();
	 * 
	 * return this;}
	 */

	// endregion
}