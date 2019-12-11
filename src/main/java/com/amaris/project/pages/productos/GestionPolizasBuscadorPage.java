package com.amaris.project.pages.productos;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionPolizasBuscadorPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.id("mainFrame");

	private By btnBuscar = By.name("botonBuscar");

	private By btnMostrarAcciones = By.xpath(".//*[@alt='Acciones']");

	private By btnSuplementoGeneral = By.xpath(".//*[text()='Suplemento general']");
	private By btnSuplementoCambioTomador = By.xpath(".//*[text()='Suplemento cambio de tomador']");
	private By btnSuplementoMedioPago = By.xpath(".//*[text()='Suplemento medio de pago']");

	private By rdnNoPoliza = By.id("filtro1");
	private By btnConsulta = By.xpath(".//*[text()='Consulta']");

	private By rdnNIFfiltro = By.cssSelector("#filtro3");
	private By txtNifCif = By.cssSelector("#numedocu");

	private By lineaNegocioDefault = By.cssSelector("#producto_poliza > option:nth-child(1)");
	private By lineaNegocioMec = By.cssSelector("#producto_poliza > option:nth-child(3)");
	private By inputNumeroPoliza = By.id("polizsec");
	private By continuar = By.xpath("//*[@id='capaAjax']/table/tbody/tr[2]/td[12]/a");
	// endregion

	public GestionPolizasBuscadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionPolizasBuscadorPage buscarPorNumeroPoliza(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(rdnNoPoliza, cuerpoFrame);

		webDriver.clickInFrame(lineaNegocioDefault, cuerpoFrame);

		webDriver.setTextInFrame(inputNumeroPoliza, cuerpoFrame, numPoliza);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage buscarPolizaPorNumeroNif(String NifNumber) {
		debugBegin();

		webDriver.clickInFrame(rdnNIFfiltro, cuerpoFrame);
		webDriver.appendTextInFrame(txtNifCif, cuerpoFrame, NifNumber);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage SeleccionarResultado() {
		debugBegin();

		if(!webDriver.isPresentAndClickInFrame(continuar, cuerpoFrame)) {
			debugInfo("No se han encontrado resultados para la búsqueda realizada");
		}

		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage AddSuplementoGeneral() {
		debugBegin();

		webDriver.clickInFrame(btnMostrarAcciones, cuerpoFrame);
		webDriver.clickInFrame(btnSuplementoGeneral, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage AddSuplementoCambioMedioPago() {
		debugBegin();

		webDriver.clickInFrame(btnMostrarAcciones, cuerpoFrame);
		webDriver.clickInFrame(btnSuplementoMedioPago, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage AddSuplementoCambioTomador() {
		debugBegin();

		webDriver.clickInFrame(btnMostrarAcciones, cuerpoFrame);
		webDriver.clickInFrame(btnSuplementoCambioTomador, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPolizasBuscadorPage ConsultarPoliza() {
		debugBegin();
		webDriver.clickInFrame(btnMostrarAcciones, cuerpoFrame);
		webDriver.clickInFrame(btnConsulta, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endreagion
}
