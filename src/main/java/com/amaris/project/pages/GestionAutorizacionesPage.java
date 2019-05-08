package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionAutorizacionesPage extends PageObject {

	// region webelements

	// @FindBy(id = "PROCESO")

	//private By cmbProceso = By.id("PROCESO");

	private By cmbProceso = By.name("PROCESO");


	// @FindBy(id = "ESTADO")
	private By cmbEstado = By.cssSelector("#ESTADO");

	// @FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");

	// @FindBy(id = "topFrame")
	private By topFrame = By.cssSelector("#topFrame");

	// @FindBy(id = "mainFrame")
	private By mainFrame = By.cssSelector("#mainFrame");

	// @FindBy(id = "NUMOBJETO")
	private By numCotizacion = By.cssSelector("#NUMOBJETO");

	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(xpath = ".//*[@value='COTIZACION']")
	private By ddCotizacion = By.xpath(".//*[@value='COTIZACION']");

	// @FindBy(xpath = ".//*[@value='PENDIENTE']")
	private By ddPendiente = By.xpath(".//*[@value='PENDIENTE']");

	// @FindBy(xpath = "//*[contains(@id, 'capaPuntos')]")
	private By btnFlecha = By.xpath("//*[contains(@id, 'capaPuntos')]");

	// @FindBy(linkText = "Autorizar")
	private By btnAutorizar = By.linkText("Autorizar");

	// @FindBy(linkText = "Anular")
	private By btnAnular = By.linkText("Anular");

	// @FindBy(id = "botonAutorizar")
	private By btnAutorizar2 = By.cssSelector("#botonAutorizar");

	// @FindBy(id = "botonAnular js-href")
	private By btnAnular2 = By.cssSelector("botonAnular");

	// @FindBy(css = "tbody tbody span")
	private By mjsResultadoAut = By.cssSelector("tbody tbody span");

	// endregion

	public GestionAutorizacionesPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public void buscarAutorizaciones(
		String seleccionProceso, String seleccionEstado, String noCotizacion) {
		debugBegin();
		
		this.webDriver.clickInFrame(this.cmbProceso, this.mainFrame);
		
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProceso, this.mainFrame, seleccionProceso);
		this.webDriver.clickInFrame(this.cmbEstado, this.mainFrame);
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbEstado, this.mainFrame, seleccionEstado);
		this.webDriver.clickInFrame(this.numCotizacion, this.mainFrame);
		this.webDriver.setTextInFrame(this.numCotizacion, this.mainFrame, noCotizacion);
		this.webDriver.clickInFrame(this.btnBuscar, this.mainFrame);
		
		debugEnd();
	}

	public void autorizar() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnFlecha, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAutorizar, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAutorizar2, this.mainFrame);
		debugEnd();
	}

	public void denegar() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnFlecha, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnular, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnular2, this.mainFrame);
		debugEnd();
	}

	public String recuperarResultadoAutorizacion() {
		debugBegin();
		String result = this.webDriver.getTextInFrame(this.mjsResultadoAut, this.mainFrame);
		debugEnd();
		return result;
	}

	// endregion
}
