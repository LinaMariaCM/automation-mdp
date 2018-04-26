package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionCotizacionesBuscadorPage

{
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	//This varible is created to assign a type of of insurance policy 'MEC' or 'MAC' since ir was originaly taken from the tData ID,
	//as a quick workaround we pass on this class which ever is needed
	private String escenario;

	
	// region Bys
	//@FindBy(name = "toc")
	private By menuFrame = By.name("toc");
	
	//@FindBy(id = "topFrame")
	private By topFrame = By.cssSelector("topFrame");
	
	//@FindBy(id = "mainFrame")
	private By mainFrame = By.cssSelector("mainFrame");
	
	//@FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");
	
	//@FindBy(xpath = ".//*[@value='COTIZACION']")
	private By rdnNoCotizacion = By.xpath(".//*[@value='COTIZACION']");
	
	//@FindBy(id = "cotizsec")
	private By txtNumeroCotizacion = By.cssSelector("cotizsec");
	
	//@FindBy(name = "producto_cotizacion")
	private By cmbProductoCotizacion = By.name("producto_cotizacion");
	
	//@FindBy(xpath = ".//*[@title='Número cotización']")
	private By txtResultadosNumeroCotizacion = By.xpath(".//*[@title='Número cotización']");
	
	//@FindBy(xpath = ".//*[@title='Mostrar acciones']")
	private By btnMostrarAcciones = By.xpath(".//*[@title='Mostrar acciones']");
	
	//@FindBy(xpath = ".//*[text()='Modificar']")
	private By btnModificar = By.xpath(".//*[text()='Modificar']");
	
	//@FindBy(xpath = ".//*[text()='Alta Como']")
	private By btnAltaComo = By.xpath(".//*[text()='Alta Como']");
	
	//@FindBy(css = "#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)")
	private By estadoCotizacion = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)");
	// endregion
	
	public GestionCotizacionesBuscadorPage(DriverHelper driver, TestDataManager data, String escenario) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
		this.escenario = escenario;
	}
	
	// region methods
	public void searchCotizacion(
			String cotizacion)
	{
		logger.debug("BEGIN - SearchCotizacion");
		this.webDriver.clickInFrame(this.rdnNoCotizacion, this.mainFrame);
		if (escenario == "Mec")
		// if (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaEdificioConfort))
		{
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaEdificioConfort);
		}
		else if (escenario == "Mac")
		// else if (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaAlquierConfort))
		{
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaAlquierConfort);
		}
		
		this.webDriver.appendTextInFrame(this.txtNumeroCotizacion, this.mainFrame, this.tCData.getTestVar(testId, "CotizacionNum"));
		this.webDriver.clickInFrame(this.btnBuscar, this.mainFrame);
		logger.debug("END - SearchCotizacion");
	}
	
	public String getCotizacion()
	{
		logger.debug("BEGIN - GetCotizacion");
		String cotizacion = this.webDriver.getTextInFrame(this.txtResultadosNumeroCotizacion, this.mainFrame);
		logger.debug("END - GetCotizacion");
		return cotizacion;
	}
	
	public void modificarProjecto()
	{
		logger.debug("BEGIN - ModificarProjecto");
		this.webDriver.clickInFrame(this.btnMostrarAcciones, this.mainFrame);
		this.webDriver.clickInFrame(this.btnModificar, this.mainFrame);
		logger.debug("END - ModificarProjecto");
	}
	
	public String getEstadoCotizacion()
	{
		logger.debug("BEGIN - recuperar resultado autorizacion");
		String result = this.webDriver.getTextInFrame(this.estadoCotizacion, this.mainFrame);
		logger.debug("END - recuperar resultado autorizacion");
		return result;
	}
	// endregion
}
