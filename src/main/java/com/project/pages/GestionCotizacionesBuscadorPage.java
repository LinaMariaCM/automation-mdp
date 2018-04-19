package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionCotizacionesBuscadorPage

{
	final static Logger logger = LoggerFactory.getLogger(GestionCotizacionesBuscadorPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(name = "toc")
	private WebElement menuFrame;
	
	@FindBy(id = "topFrame")
	private WebElement topFrame;
	
	@FindBy(id = "mainFrame")
	private WebElement mainFrame;
	
	@FindBy(name = "botonBuscar")
	private WebElement btnBuscar;
	
	@FindBy(xpath = ".//*[@value='COTIZACION']")
	private WebElement rdnNoCotizacion;
	
	@FindBy(id = "cotizsec")
	private WebElement txtNumeroCotizacion;
	
	@FindBy(name = "producto_cotizacion")
	private WebElement cmbProductoCotizacion;
	
	@FindBy(xpath = ".//*[@title='Número cotización']")
	private WebElement txtResultadosNumeroCotizacion;
	
	@FindBy(xpath = ".//*[@title='Mostrar acciones']")
	private WebElement btnMostrarAcciones;
	
	@FindBy(xpath = ".//*[text()='Modificar']")
	private WebElement btnModificar;
	
	@FindBy(xpath = ".//*[text()='Alta Como']")
	private WebElement btnAltaComo;
	
	@FindBy(css = "#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)")
	private WebElement estadoCotizacion;
	// endregion
	
	public GestionCotizacionesBuscadorPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	public void searchCotizacion(
			String cotizacion)
	{
		logger.debug("BEGIN - SearchCotizacion");
		this.wh.clickOnWebElementInFrame(this.rdnNoCotizacion, this.mainFrame);
		if (this.tData.getTestID().contains("Mec"))
		// if (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaEdificioConfort))
		{
			this.wh.selectValueInDropDownInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaEdificioConfort);
			this.wh.sendValueToWebElementInFrame(this.txtNumeroCotizacion, this.mainFrame, this.tData.getNoCotizacion());
		}
		else if (this.tData.getTestID().contains("Mac"))
		// else if (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaAlquierConfort))
		{
			this.wh.selectValueInDropDownInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaAlquierConfort);
			this.wh.sendValueToWebElementInFrame(this.txtNumeroCotizacion, this.mainFrame, this.tData.getNoCotizacionMAC());
		}
		
		this.wh.clickOnWebElementInFrame(this.btnBuscar, this.mainFrame);
		logger.debug("END - SearchCotizacion");
	}
	
	public String getCotizacion()
	{
		logger.debug("BEGIN - GetCotizacion");
		String cotizacion = this.wh.getTextFromWebElementInFrame(this.txtResultadosNumeroCotizacion, this.mainFrame);
		logger.debug("END - GetCotizacion");
		return cotizacion;
	}
	
	public void modificarProjecto()
	{
		logger.debug("BEGIN - ModificarProjecto");
		this.wh.clickOnWebElementInFrame(this.btnMostrarAcciones, this.mainFrame);
		this.wh.clickOnWebElementInFrame(this.btnModificar, this.mainFrame);
		logger.debug("END - ModificarProjecto");
	}
	
	public String getEstadoCotizacion()
	{
		logger.debug("BEGIN - recuperar resultado autorizacion");
		String result = this.wh.getTextFromWebElementInFrame(this.estadoCotizacion, this.mainFrame);
		logger.debug("END - recuperar resultado autorizacion");
		return result;
	}
	// endregion
}
