package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionAutorizacionesPage

{
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	
	// region webelements
	
	//@FindBy(id = "PROCESO")
	private By cmbProceso = By.cssSelector("PROCESO");
	
	//@FindBy(id = "ESTADO")
	private By cmbEstado = By.cssSelector("ESTADO");
	
	//@FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");
	
	//@FindBy(id = "topFrame")
	private By topFrame = By.cssSelector("topFrame");
	
	//@FindBy(id = "mainFrame")
	private By mainFrame = By.cssSelector("mainFrame");

	//@FindBy(id = "NUMOBJETO")
	private By numCotizacion = By.cssSelector("NUMOBJETO");

	//@FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");
	
	//@FindBy(xpath = ".//*[@value='COTIZACION']")
	private By ddCotizacion = By.xpath(".//*[@value='COTIZACION']");
	
	//@FindBy(xpath = ".//*[@value='PENDIENTE']")
	private By ddPendiente = By.xpath(".//*[@value='PENDIENTE']");
	
	//@FindBy(xpath = "//*[contains(@id, 'capaPuntos')]")
	private By btnFlecha = By.xpath("//*[contains(@id, 'capaPuntos')]");
	
	//@FindBy(linkText = "Autorizar")
	private By btnAutorizar = By.linkText("Autorizar");
	
	//@FindBy(linkText = "Anular")
	private By btnAnular = By.linkText("Anular");
	
	//@FindBy(id = "botonAutorizar")
	private By btnAutorizar2 = By.cssSelector("botonAutorizar");
	
	//@FindBy(id = "botonAnular js-href")
	private By btnAnular2 = By.cssSelector("botonAnular");

	//@FindBy(css = "tbody tbody span")
	private By mjsResultadoAut = By.cssSelector("tbody tbody span");
	
	// endregion
	
	public GestionAutorizacionesPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}
	
	// region methods
	
	public void buscarAutorizaciones(
			String seleccionProceso, String seleccionEstado, String noCotizacion)
	{
		logger.debug("BEGIN - buscarAutorizaciones");
		this.webDriver.clickInFrame(this.cmbProceso, this.mainFrame);
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProceso, this.mainFrame, seleccionProceso);
		this.webDriver.clickInFrame(this.cmbEstado, this.mainFrame);
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbEstado, this.mainFrame, seleccionEstado);
		this.webDriver.clickInFrame(this.numCotizacion, this.mainFrame);
		this.webDriver.appendTextInFrame(this.numCotizacion, this.mainFrame, noCotizacion);
		this.webDriver.clickInFrame(this.btnBuscar, this.mainFrame);
		logger.debug("END - buscarAutorizaciones");
	}
	
	public void autorizar()
	{
		logger.debug("BEGIN - autorizar");
		this.webDriver.clickInFrame(this.btnFlecha, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAutorizar, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAutorizar2, this.mainFrame);
		logger.debug("END - autorizar");
	}

	public void denegar()
	{
		logger.debug("BEGIN - denegar");
		this.webDriver.clickInFrame(this.btnFlecha, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnular, this.mainFrame);
		this.webDriver.clickInFrame(this.btnAnular2, this.mainFrame);
		logger.debug("END - denegar");
	}

	public String recuperarResultadoAutorizacion()
	{
		logger.debug("BEGIN - recuperar resultado autorizacion");
		String result = this.webDriver.getTextInFrame(this.mjsResultadoAut, this.mainFrame);
		logger.debug("END - recuperar resultado autorizacion");
		return result;
	}

	// endregion
}
