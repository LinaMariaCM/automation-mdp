package com.amaris.project.pages.administracion.gestionautorizaciones;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionAutorizacionesPage extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By procesoBtn = By.name("PROCESO");
	private By estadoBtn = By.cssSelector("#ESTADO");
	private By buscarBtn = By.name("botonBuscar");

	private By numCotizacionBtn = By.cssSelector("#NUMOBJETO");

	private By flechaBtn = By.cssSelector("div[id='capaAjax'] div[id*='capaPuntos'] span");
	private By autorizarBtn = By.linkText("Autorizar");
	private By anularBtn = By.cssSelector("div[class*='cpdatos'] li:nth-child(2)");
	private By autorizar2Btn = By.cssSelector("#botonAutorizar");
	private By anular2Btn = By.cssSelector("div[class*='box-buttons'] input");
	private By resultadoAutTxt = By.cssSelector("tbody tbody span");
	// endregion

	public GestionAutorizacionesPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionAutorizacionesPage buscarAutorizaciones(String seleccionProceso, String seleccionEstado, String noCotizacion) {
		debugBegin();

		webDriver.clickInFrame(procesoBtn, mainFrame);

		webDriver.clickElementFromDropDownByTextInFrame(procesoBtn, mainFrame, seleccionProceso);
		webDriver.clickInFrame(estadoBtn, mainFrame);
		webDriver.clickElementFromDropDownByTextInFrame(estadoBtn, mainFrame, seleccionEstado);
		webDriver.clickInFrame(numCotizacionBtn, mainFrame);
		webDriver.setTextInFrame(numCotizacionBtn, mainFrame, noCotizacion);
		webDriver.clickInFrame(buscarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public GestionAutorizacionesPage autorizar() {
		debugBegin();

		webDriver.clickInFrame(flechaBtn, mainFrame);
		webDriver.clickInFrame(autorizarBtn, mainFrame);
		webDriver.clickInFrame(autorizar2Btn, mainFrame);

		debugEnd();

		return this;
	}

	public GestionAutorizacionesPage denegar() {
		debugBegin();

		webDriver.clickInFrame(flechaBtn, mainFrame);
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(anularBtn, mainFrame);
		webDriver.clickInFrame(anular2Btn, mainFrame);

		debugEnd();

		return this;
	}

	public String recuperarResultadoAutorizacion() {
		debugBegin();

		String result = webDriver.getTextInFrame(resultadoAutTxt, mainFrame);

		debugEnd();

		return result;
	}
	// endregion
}
