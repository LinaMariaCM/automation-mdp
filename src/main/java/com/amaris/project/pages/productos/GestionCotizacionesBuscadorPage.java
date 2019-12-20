package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class GestionCotizacionesBuscadorPage extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By buscarBtn = By.name("botonBuscar");

	private By numeroCotizacionBtn = By.cssSelector("#filtro1");
	private By numeroCotizacionInput = By.cssSelector("#cotizsec");
	private By productoCotizacionDrpDwn = By.name("producto_cotizacion");
	private By wesultadosNumeroCotizacionTxt = By.xpath(".//*[@title='Número cotización']");

	private By mostrarAccionesBtn = By.xpath(".//*[@title='Mostrar acciones']");
	private By modificarBtn = By.xpath(".//*[text()='Modificar']");
	private By estadoCotizacionTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)");
	// endregion

	public GestionCotizacionesBuscadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionCotizacionesBuscadorPage searchCotizacion(String cotizacion) {
		debugBegin();

		webDriver.clickInFrame(numeroCotizacionBtn, mainFrame);
		
		if(userS.getTestCase().contains("Mec")) {
			webDriver.clickElementFromDropDownByTextInFrame(productoCotizacionDrpDwn, mainFrame, Constants.MutuaEdificioConfort);
		} else if(userS.getTestCase().contains("Mac")) {
			webDriver.clickElementFromDropDownByTextInFrame(productoCotizacionDrpDwn, mainFrame, Constants.MutuaAlquierConfort);
		}

		webDriver.setTextInFrame(numeroCotizacionInput, mainFrame, cotizacion);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public String getCotizacion() {
		debugBegin();
		String cotizacion = webDriver.getTextInFrame(wesultadosNumeroCotizacionTxt, mainFrame);
		debugEnd();

		return cotizacion;
	}

	public GestionCotizacionesBuscadorPage modificarProjecto() {
		debugBegin();

		webDriver.clickInFrame(mostrarAccionesBtn, mainFrame);
		webDriver.clickInFrame(modificarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public String getEstadoCotizacion() {
		debugBegin();
		String result = webDriver.getTextInFrame(estadoCotizacionTxt, mainFrame);
		debugEnd();

		return result;
	}
	// endregion
}