package com.amaris.project.pages.productos;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionPolizasBuscadorPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	private By buscarBtn = By.name("botonBuscar");

	private By mostrarAccionesBtn = By.xpath(".//*[@alt='Acciones']");

	private By suplementoGeneralBtn = By.xpath(".//*[text()='Suplemento general']");
	private By suplementoCambioTomadorBtn = By.xpath(".//*[text()='Suplemento cambio de tomador']");
	private By suplementoMedioPagoBtn = By.xpath(".//*[text()='Suplemento medio de pago']");

	private By numeroPolizaBtn = By.id("filtro1");
	private By consultaBtn = By.xpath(".//*[text()='Consulta']");

	private By nifFiltroBtn = By.cssSelector("#filtro3");
	private By nifCifInput = By.cssSelector("#numedocu");

	private By lineaNegocioDefaultBtn = By.cssSelector("#producto_poliza > option:nth-child(1)");
	private By numeroPolizaInput = By.id("polizsec");
	private By continuarBtn = By.xpath("//*[@id='capaAjax']/table/tbody/tr[2]/td[12]/a");
	// endregion

	public GestionPolizasBuscadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionPolizasBuscadorPage buscarPorNumeroPoliza(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(numeroPolizaBtn, cuerpoFrame);

		webDriver.clickInFrame(lineaNegocioDefaultBtn, cuerpoFrame);

		webDriver.setTextInFrame(numeroPolizaInput, cuerpoFrame, numPoliza);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage buscarPolizaPorNumeroNif(String nifNumber) {
		debugBegin();

		webDriver.clickInFrame(nifFiltroBtn, cuerpoFrame);
		webDriver.appendTextInFrame(nifCifInput, cuerpoFrame, nifNumber);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage seleccionarResultado() {
		debugBegin();

		if(!webDriver.isPresentAndClickInFrame(continuarBtn, cuerpoFrame)) {
			debugInfo("No se han encontrado resultados para la búsqueda realizada");
		}

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage addSuplementoGeneral() {
		debugBegin();
		webDriver.clickInFrame(mostrarAccionesBtn, cuerpoFrame);
		webDriver.clickInFrame(suplementoGeneralBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage addSuplementoCambioMedioPago() {
		debugBegin();
		webDriver.clickInFrame(mostrarAccionesBtn, cuerpoFrame);
		webDriver.clickInFrame(suplementoMedioPagoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage addSuplementoCambioTomador() {
		debugBegin();

		webDriver.clickInFrame(mostrarAccionesBtn, cuerpoFrame);
		webDriver.clickInFrame(suplementoCambioTomadorBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage consultarPoliza() {
		debugBegin();
		webDriver.clickInFrame(mostrarAccionesBtn, cuerpoFrame);
		webDriver.clickInFrame(consultaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endreagion
}
