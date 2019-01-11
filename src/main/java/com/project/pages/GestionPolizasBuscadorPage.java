package com.project.pages;

import org.openqa.selenium.By;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionPolizasBuscadorPage extends PageObject {
	
 public	GestionPolizasBuscadorPage(UserStory userS) {
		super(userS);
	}
	// final static Logger logger =
	// LoggerFactory.getLogger(GestionOnlineHomePage.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	//
 
	// region webelements
 
	// @FindBy(xpath = ".//*[@value='POLIZA']")
	// @FindBy(id = "filtro1")
	private By rdnNoPoliza = By.id("filtro1");
	//
	// @FindBy(name = "toc")
	// private WebElement menuFrame;
	//
	// @FindBy(id = "topFrame")
	// private WebElement topFrame;
	//
	// @FindBy(id = "mainFrame")
	private By cuerpoFrame = By.id("mainFrame");
	
	
	// @FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");
	
	
	// @FindBy(name = "producto_poliza")
	// private WebElement cmbProductoCotizacion;
	//
	// @FindBy(name = "polizsec")
	// private WebElement txtNumeroPoliza;
	//
	// @FindBy(xpath = ".//*[@alt='Acciones']")
	// private WebElement btnMostrarAcciones;
	//
	// @FindBy(xpath = ".//*[text()='Suplemento general']")
	// private WebElement btnSuplementoGeneral;
	//
	// @FindBy(xpath = ".//*[text()='Suplemento cambio de tomador']")
	// private WebElement btnSuplementoCambioTomador;
	//
	// @FindBy(xpath = ".//*[text()='Suplemento medio de pago']")
	// private WebElement btnSuplementoMedioPago;
	//
	// @FindBy(xpath = ".//*[text()='Consulta']")
	// private WebElement btnConsulta;
	//
	// @FindBy(id = "filtro3")
	// private WebElement rdnNIFfiltro;
	//
	// @FindBy(id = "numedocu")
	// private WebElement txtNifCif;
	//
	
	//private By lineaNegocioDefault = By.id("producto_poliza");
	
	private By lineaNegocioDefault = By.cssSelector("#producto_poliza > option:nth-child(1)");
	
	private By lineaNegocioMec = By.cssSelector("#producto_poliza > option:nth-child(3)");
	
	private By inputNumeroPoliza = By.id("polizsec");
	
	private By continuar = By.xpath("//*[@id='capaAjax']/table/tbody/tr[2]/td[12]/a");
	
	// // endregion
	//
	// public GestionPolizasBuscadorPage(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	//
	// public void SearchPolizaByPolizaNumber(String poliza)
	// {
	// logger.debug("BEGIN - SearchPoliza");
	// this.wh.switchToFrame(this.mainFrame);
	// this.wh.clickOnWebElement(this.rdnNoPoliza);
	// this.wh.selectValueInDropDown(this.cmbProductoCotizacion,
	// ProjectConstants.MutuaEdificioConfort);
	// this.wh.sendValueToWebElement(this.txtNumeroPoliza, poliza);
	// this.wh.clickOnWebElement(this.btnBuscar);
	// this.wh.exitFromFrame();
	// logger.debug("END - SearchPoliza");
	// }
	
	public void BuscarPorNumeroPoliza(String numPoliza)
	{
		this.debugBegin();
		
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.rdnNoPoliza);
		
		
		this.webDriver.click(this.lineaNegocioDefault);
		
		this.webDriver.setText(inputNumeroPoliza, numPoliza);
		this.webDriver.click(this.btnBuscar);
		Steps.waitForIt(webDriver);
		this.webDriver.exitFrame();
		
		this.debugEnd();
	}
	
	public void SeleccionarResultado()
	{
		this.debugBegin();
		
		this.webDriver.switchToFrame(this.cuerpoFrame);
		
		if(webDriver.isPresent(this.continuar)) this.webDriver.click(this.continuar);
		else System.out.println("No se han encontrado resultados para la búsqueda realizada");
		
		this.webDriver.exitFrame();
		this.debugEnd();
	}
	
	// public void SearchPolizaByNifNumber(String NifNumber)
	// {
	// logger.debug("BEGIN - SearchPoliza");
	// this.wh.switchToFrame(this.mainFrame);
	// // this.wh.SelectValueInDropDown(this.cmbProductoCotizacion,
	// MutuaPropietariosConstants.MutuaEdificioConfort);
	// this.wh.clickOnWebElement(this.rdnNIFfiltro);
	// this.wh.sendValueToWebElement(this.txtNifCif, NifNumber);
	// this.wh.clickOnWebElement(this.btnBuscar);
	// this.wh.exitFromFrame();
	// logger.debug("END - SearchPoliza");
	// }
	//
	// public void AddSuplementoGeneral()
	// {
	// logger.debug("BEGIN - AddSuplementoGeneral");
	// this.wh.switchToFrame(this.mainFrame);
	// this.wh.moveToElementWithJavaScript(this.btnMostrarAcciones);
	// this.wh.clickOnWebElement(this.btnMostrarAcciones);
	// this.wh.moveToElementAndClickWithJavaScript(this.btnSuplementoGeneral);
	// this.wh.exitFromFrame();
	// logger.debug("END - AddSuplementoGeneral");
	// }
	//
	// public void AddSuplementoCambioMedioPago()
	// {
	// logger.debug("BEGIN - AddSuplementoCambioMedioPago");
	// this.wh.switchToFrame(this.mainFrame);
	// this.wh.moveToElementWithJavaScript(this.btnMostrarAcciones);
	// this.wh.clickOnWebElement(this.btnMostrarAcciones);
	// this.wh.moveToElementAndClickWithJavaScript(this.btnSuplementoMedioPago);
	// this.wh.exitFromFrame();
	// logger.debug("END - AddSuplementoCambioMedioPago");
	// }
	//
	// public void AddSuplementoCambioTomador()
	// {
	// logger.debug("BEGIN - AddSuplementoCambioTomador");
	// this.wh.switchToFrame(this.mainFrame);
	// this.wh.moveToElementWithJavaScript(this.btnMostrarAcciones);
	// this.wh.clickOnWebElement(this.btnMostrarAcciones);
	// this.wh.moveToElementAndClickWithJavaScript(this.btnSuplementoCambioTomador);
	// this.wh.exitFromFrame();
	// logger.debug("END - AddSuplementoCambioTomador");
	// }
	//
	// public void ConsultarPoliza()
	// {
	// logger.debug("BEGIN - ConsultarPoliza");
	// this.wh.switchToFrame(this.mainFrame);
	// this.wh.clickOnWebElement(this.btnMostrarAcciones);
	// this.wh.clickOnWebElement(this.btnConsulta);
	// this.wh.exitFromFrame();
	// logger.debug("END - ConsultarPoliza");
	// }

	// endreagion
}
