package com.amaris.project.pages.administracion.gestionautorizaciones;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionAutorizacionesPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By cmbProceso = By.name("PROCESO");
	private By cmbEstado = By.cssSelector("#ESTADO");
	private By btnBuscar = By.name("botonBuscar");

	private By numCotizacion = By.cssSelector("#NUMOBJETO");

	private By ddCotizacion = By.xpath(".//*[@value='COTIZACION']");
	private By ddPendiente = By.xpath(".//*[@value='PENDIENTE']");

	private By btnFlecha = By.cssSelector("div[id='capaAjax'] div[id*='capaPuntos'] span");
	private By btnAutorizar = By.linkText("Autorizar");
	private By btnAnular = By.cssSelector("div[class*='cpdatos'] li:nth-child(2)");
	private By btnAutorizar2 = By.cssSelector("#botonAutorizar");
	// private By btnAnular2 = By.cssSelector("botonAnular");
	private By btnAnular2 = By.cssSelector("div[class*='box-buttons'] input");
	private By mjsResultadoAut = By.cssSelector("tbody tbody span");
	// endregion

	public GestionAutorizacionesPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionAutorizacionesPage buscarAutorizaciones(String seleccionProceso, String seleccionEstado, String noCotizacion) {
		debugBegin();

		webDriver.clickInFrame(cmbProceso, mainFrame);

		webDriver.clickElementFromDropDownByTextInFrame(cmbProceso, mainFrame, seleccionProceso);
		webDriver.clickInFrame(cmbEstado, mainFrame);
		webDriver.clickElementFromDropDownByTextInFrame(cmbEstado, mainFrame, seleccionEstado);
		webDriver.clickInFrame(numCotizacion, mainFrame);
		webDriver.setTextInFrame(numCotizacion, mainFrame, noCotizacion);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public GestionAutorizacionesPage autorizar() {
		debugBegin();

		webDriver.clickInFrame(btnFlecha, mainFrame);
		webDriver.clickInFrame(btnAutorizar, mainFrame);
		webDriver.clickInFrame(btnAutorizar2, mainFrame);

		debugEnd();

		return this;
	}

	public GestionAutorizacionesPage denegar() {
		debugBegin();

		webDriver.clickInFrame(btnFlecha, mainFrame);
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(btnAnular, mainFrame);
		webDriver.clickInFrame(btnAnular2, mainFrame);

		debugEnd();

		return this;
	}

	public String recuperarResultadoAutorizacion() {
		debugBegin();

		String result = webDriver.getTextInFrame(mjsResultadoAut, mainFrame);

		debugEnd();

		return result;
	}
	// endregion
}
