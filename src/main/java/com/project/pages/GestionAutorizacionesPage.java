package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionAutorizacionesPage

{
	final static Logger logger = LoggerFactory.getLogger(GestionAutorizacionesPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	
	@FindBy(id = "PROCESO")
	private WebElement cmbProceso;
	
	@FindBy(id = "ESTADO")
	private WebElement cmbEstado;
	
	@FindBy(name = "botonBuscar")
	private WebElement btnBuscar;
	
	@FindBy(id = "topFrame")
	private WebElement topFrame;
	
	@FindBy(id = "mainFrame")
	private WebElement mainFrame;

	@FindBy(id = "NUMOBJETO")
	private WebElement numCotizacion;

	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;
	
	@FindBy(xpath = ".//*[@value='COTIZACION']")
	private WebElement ddCotizacion;
	
	@FindBy(xpath = ".//*[@value='PENDIENTE']")
	private WebElement ddPendiente;
	
	@FindBy(xpath = "//*[contains(@id, 'capaPuntos')]")
	private WebElement btnFlecha;
	
	@FindBy(linkText = "Autorizar")
	private WebElement btnAutorizar;
	
	@FindBy(linkText = "Anular")
	private WebElement btnAnular;
	
	@FindBy(id = "botonAutorizar")
	private WebElement btnAutorizar2;
	
	@FindBy(id = "botonAnular js-href")
	private WebElement btnAnular2;

	@FindBy(css = "tbody tbody span")
	private WebElement mjsResultadoAut;
	
	// endregion
	
	public GestionAutorizacionesPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	
	public void buscarAutorizaciones(
			String seleccionProceso, String seleccionEstado, String noCotizacion)
	{
		logger.debug("BEGIN - buscarAutorizaciones");
		this.wh.clickOnWebElementInFrame(this.cmbProceso, this.mainFrame);
		this.wh.selectValueInDropDownInFrame(this.cmbProceso, this.mainFrame, seleccionProceso);
		this.wh.clickOnWebElementInFrame(this.cmbEstado, this.mainFrame);
		this.wh.selectValueInDropDownInFrame(this.cmbEstado, this.mainFrame, seleccionEstado);
		this.wh.clickOnWebElementInFrame(this.numCotizacion, this.mainFrame);
		this.wh.sendValueToWebElementInFrame(this.numCotizacion, this.mainFrame, noCotizacion);
		this.wh.clickOnWebElementInFrame(this.btnBuscar, this.mainFrame);
		logger.debug("END - buscarAutorizaciones");
	}
	
	public void autorizar()
	{
		logger.debug("BEGIN - autorizar");
		this.wh.clickOnWebElementInFrame(this.btnFlecha, this.mainFrame);
		this.wh.clickOnWebElementInFrame(this.btnAutorizar, this.mainFrame);
		this.wh.clickOnWebElementInFrame(this.btnAutorizar2, this.mainFrame);
		logger.debug("END - autorizar");
	}

	public void denegar()
	{
		logger.debug("BEGIN - denegar");
		this.wh.clickOnWebElementInFrame(this.btnFlecha, this.mainFrame);
		this.wh.clickOnWebElementInFrame(this.btnAnular, this.mainFrame);
		this.wh.clickOnWebElementInFrame(this.btnAnular2, this.mainFrame);
		logger.debug("END - denegar");
	}

	public String recuperarResultadoAutorizacion()
	{
		logger.debug("BEGIN - recuperar resultado autorizacion");
		String result = this.wh.getTextFromWebElementInFrame(this.mjsResultadoAut, this.mainFrame);
		logger.debug("END - recuperar resultado autorizacion");
		return result;
	}

	// endregion
}
