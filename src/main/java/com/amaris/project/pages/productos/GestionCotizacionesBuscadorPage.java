package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class GestionCotizacionesBuscadorPage extends PageObject {

	// region Bys
	private By menuFrame = By.name("toc");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By btnBuscar = By.name("botonBuscar");

	private By rdnNoCotizacion = By.cssSelector("#filtro1");
	private By txtNumeroCotizacion = By.cssSelector("#cotizsec");
	private By cmbProductoCotizacion = By.name("producto_cotizacion");
	private By txtResultadosNumeroCotizacion = By.xpath(".//*[@title='Número cotización']");

	private By btnMostrarAcciones = By.xpath(".//*[@title='Mostrar acciones']");
	private By btnModificar = By.xpath(".//*[text()='Modificar']");
	private By btnAltaComo = By.xpath(".//*[text()='Alta Como']");
	private By estadoCotizacion = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)");
	// endregion

	public GestionCotizacionesBuscadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionCotizacionesBuscadorPage searchCotizacion(String cotizacion) {
		debugBegin();

		webDriver.clickInFrame(rdnNoCotizacion, mainFrame);
		if(userS.getTestCase().contains("Mec")) {
			webDriver.clickElementFromDropDownByTextInFrame(cmbProductoCotizacion, mainFrame, Constants.MutuaEdificioConfort);
		} else if(userS.getTestCase().contains("Mac")) {
			webDriver.clickElementFromDropDownByTextInFrame(cmbProductoCotizacion, mainFrame, Constants.MutuaAlquierConfort);
		}

		webDriver.setTextInFrame(txtNumeroCotizacion, mainFrame, cotizacion);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public String getCotizacion() {
		debugBegin();
		String cotizacion = webDriver.getTextInFrame(txtResultadosNumeroCotizacion, mainFrame);
		debugEnd();

		return cotizacion;
	}

	public GestionCotizacionesBuscadorPage modificarProjecto() {
		debugBegin();

		webDriver.clickInFrame(btnMostrarAcciones, mainFrame);
		webDriver.clickInFrame(btnModificar, mainFrame);

		debugEnd();

		return this;
	}

	public String getEstadoCotizacion() {
		debugBegin();
		String result = webDriver.getTextInFrame(estadoCotizacion, mainFrame);
		debugEnd();

		return result;
	}
	// endregion
}