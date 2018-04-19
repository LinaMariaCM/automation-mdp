package com.project.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
/*
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/
public class GestionOnlineHomePage
{
	/*final static Logger logger = LoggerFactory.getLogger(GestionOnlineHomePage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	*/
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	// region webelements
	@FindBy(id = "blockrandom") 
	private By frameAppMainWindow;
	
	@FindBy(id = "topFrame")
	private By topFrame;
	
	@FindBy(id = "leftFrame")
	private By frameLeftFrame;
	
	@FindBy(id = "mainFrame")
	private By mainFrame;
	
	@FindBy(name = "iframe")
	private By buscadorFrame;
	
	
	private By btnNovedadesDialogClose = By.xpath(".//*[contains(@class,'modal-header')]/button");
	
	private By btnContratacionSelector = By.xpath("#t3-mainnav > div > div > div > div > ul > li:nth-child(6) > a"); 
	
	@FindBy(linkText = "Siniestros")
	private By btnSiniestrosSelector;
	

	private By btnContratarOnlineOption = By.xpath(".//*[@class='navbar-inner']//*[text()='Contratar online ']");
	
	// @FindBy(xpath = ".//*[contains(text(),'Contratar Online Proyectos')]")
	
	private By btnContratarOnlineProyectosOption = By.xpath("#t3-mainnav > div > div > div > div > ul > li:nth-child(6) > div > div > div > div > div > ul > li:nth-child(1) > a");
	
	// @FindBy(xpath = ".//*[contains(text(),'Mis proyectos web')]")

	private By btnMisProyectosWebOption = By.xpath("#t3-mainnav > div > div > div > div > ul > li:nth-child(6) > div > div > div > div > div > ul > li:nth-child(2) > a");
	
	// @FindBy(xpath = ".//*[contains(text(),'Mutua Edificio Confort')]/../..//*[contains(text(),'Contratar')]")

	private By btnContratarmutuaEdificioSeleccionPlus = By.xpath("#dropdown-comunidad > div > a.span2.contratar_btn.popup.prod-mdp > p > span");
	
	// @FindBy(xpath = ".//*[contains(text(),'Mutua Alquiler Confort')]/../..//*[contains(text(),'Contratar')]")
	
	private By btnContratarmutuaAlquiler = By.xpath("#dropdown-alquiler > div > a.span2.contratar_btn.popup.prod-mdp > p > span");

	private By btnMutuaEdificioConfort = By.xpath(".//*[contains(@title,'MUTUA EDIFICIO CONFORT.')]");
	

	private By btnNuevoProjecto = By.xpath(".//*[normalize-space(text())='Nuevo proyecto']");
	

	private By btnNuevaSimulaion = By.xpath(".//*[normalize-space(text())='Nueva Simulación']");
	
	// @FindBy(xpath = ".//*[text()='Acepto']")
	//@FindBy(css = ".accept")
	private By btnAcepto = By.xpath(".//*[text()='Acepto']");
	
	@FindBy(linkText = "Aceptar")
	private By btnAceptar;
	
	// @FindBy(xpath = ".//*[text()=' Mapa del sitio']")
	//@FindBy(css = "#Mod222 > div > div > div > p > a")
	private By btnMapaWeb = By.xpath("#Mod222 > div > div > div > p > a");
	
	//@FindBy(xpath = ".//*[text()='Gestión de cotizaciones']")
	private By btnGestionCotizaciones = By.xpath(".//*[text()='Gestión de cotizaciones']");
	
	//@FindBy(xpath = ".//*[@title='Gestión de pólizas']")
	private By btnGestionPolizas = By.xpath(".//*[@title='Gestión de pólizas']");
	
	//@FindBy(xpath = ".//*[@id='pr_id']")
	private By codigoProyecto = By.xpath(".//*[@id='pr_id']");
	
	@FindBy(id = "tprpoyecto")
	private By tipoProyectoDropdown;
	
	@FindBy(id = "producto")
	private By productoDropdown;
	
	@FindBy(id = "search")
	private By btnBuscar;
	
	//@FindBy(css = "table[id*='DataTables_Table'] a[onclick*='javascript: editarProyecto']")
	private By modificarProyecto = By.xpath("table[id*='DataTables_Table'] a[onclick*='javascript: editarProyecto']");

	//@FindBy(css = "[id^='eliminar_'] > div > ul > li:nth-child(3) > a")
	private By modificarProyectoUatPj = By.xpath("[id^='eliminar_'] > div > ul > li:nth-child(3) > a");
	
	//@FindBy(css = "table[id*='DataTables_Table'] a[onclick*='javascript: verEjemplar']")
	private By consultarProyecto = By.xpath("table[id*='DataTables_Table'] a[onclick*='javascript: verEjemplar']");

	//@FindBy(css = "[id^='eliminar_'] > div > a")
	private By drpdwnAcciones = By.xpath("[id^='eliminar_'] > div > a");
	
	// @FindBy(css = "tr.odd:nth-child(1) > td:nth-child(13)")
	//@FindBy(css = "#DataTables_Table_0 > tbody > tr > td:nth-child(13)") // By from UatPj
	private By estadoPoliza = By.xpath("#DataTables_Table_0 > tbody > tr > td:nth-child(13)");
	
	// @FindBy(css = ".mis-proyectos-web div[id *= modalWindow")
	//@FindBy(css = "#modalWindow")
	private By errorBuscar = By.xpath(".mis-proyectos-web div[id *= modalWindow");
	
	// @FindBy(css = "#modalWindow .modal-footer .btn-primary")
	//@FindBy(css = "#modalWindow > div.modal-footer > button") // This is the By from UatPj
	private By cerrarErrorBuscar = By.xpath("#modalWindow > div.modal-footer > button");
	
	// endregion
	
	/*
	public GestionOnlineHomePage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}*/
	
	public GestionOnlineHomePage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
	}
	
	// public void deleteCookies()
	// {
	// logger.debug("BEGIN - deleteCookies");
	// this.browserContext.getWebDriver().manage().deleteAllCookies();
	// logger.debug("END - deleteCookies");
	// }
	
	// region methods
	public GestionOnlineHomePage acceptCookies()
	{
		logger.debug("BEGIN - acceptCookies");
		this.webDriver.click(this.btnAcepto);
		logger.debug("END - acceptCookies");
		
		return this;
	}
	
	public GestionOnlineHomePage closeNovedadesDialog()
	{
		logger.debug("BEGIN - CloseNovedadesDialog");
		if (!this.tCData.getConfigVar("environmnent").equals("UatPj"))
		{
			this.webDriver.click(this.btnAceptar);
		}
		logger.debug("END - CloseNovedadesDialog");
		
		return this;
	}
	
	public GestionOnlineHomePage createNewProject()
	{
		logger.debug("BEGIN - CreateNewProject");
		
		logger.debug("END - CreateNewProject");
		
		return this;
	}
	
	public GestionOnlineHomePage createNewSimulation()
	{
		logger.debug("BEGIN - CreateNewSimulation");
		//this.webDriver.doubleClick(this.btnMutuaEdificioConfort, this.frameLeftFrame);
		//this.webDriver.doubleclickInFrame(this.btnNuevaSimulaion, this.frameLeftFrame);
		this.webDriver.doubleClick(this.btnMutuaEdificioConfort);
		this.webDriver.doubleClick(this.btnNuevaSimulaion);
		
		logger.debug("END - CreateNewSimulation");
		
		return this;
	}
	
	public GestionOnlineHomePage openMutuaEdificioConfort() throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - OpenMutuaEdificioConfort");
		// In GO UatPj environment, only need to hover over option.
		if (this.tCData.getConfigVar("environment").equals("UatPj"))
		{
			this.webDriver.moveToElement(this.btnContratacionSelector);
		}
		else
		{
			this.webDriver.click(this.btnContratacionSelector);
		}
		this.webDriver.click(this.btnContratarOnlineProyectosOption);
		//this.webDriver.waitForPageLoadToFinish();
		this.webDriver.clickInFrame(this.btnContratarmutuaEdificioSeleccionPlus, this.frameAppMainWindow);
		this.webDriver.switchToWindow(1);
		//this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		logger.debug("END - OpenMutuaEdificioConfort");
		
		return this;
	}
	
	public GestionOnlineHomePage openMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - OpenMutuaAlquilerConfort");
		
		// In GO UatPj environment, only need to hover over option.
		if (this.tCData.getConfigVar("environmnent").equals("UatPj"))
		{
			this.webDriver.moveToElement(this.btnContratacionSelector);
		}
		else
		{
			this.webDriver.click(this.btnContratacionSelector);
		}

		this.webDriver.click(this.btnContratarOnlineProyectosOption);
		this.webDriver.clickInFrame(this.btnContratarmutuaAlquiler, this.frameAppMainWindow);
		this.webDriver.switchToWindow(1);
		//this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		logger.debug("END - OpenMutuaAlquilerConfort");
		
		return this;
	}
	
	public GestionOnlineHomePage openMisProyectosWeb() throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - OpenMisProyectosWeb");
		if (this.tCData.getConfigVar("environmnent").equals("UatPj"))
		{
			this.webDriver.moveToElement(this.btnContratacionSelector);
		}
		else
		{
			this.webDriver.click(this.btnContratacionSelector);
		}
		this.webDriver.click(this.btnMisProyectosWebOption);
		
		logger.debug("END - OpenMisProyectosWeb");
		
		return this;
	}
	
	public GestionOnlineHomePage openSiniestros() throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - OpenMisProyectosWeb");
		this.webDriver.click(this.btnAceptar);
		this.webDriver.click(this.btnContratacionSelector);
		this.webDriver.click(this.btnMisProyectosWebOption);
		
		logger.debug("END - OpenMisProyectosWeb");
		
		return this;
	}
	
	public GestionOnlineHomePage buscarProyectoWeb(
			String noCotizacion) throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - BuscarProyectosWeb");
		this.webDriver.clickInFrame(this.codigoProyecto, this.buscadorFrame);
		this.webDriver.appendTextInFrame(this.codigoProyecto, this.buscadorFrame, noCotizacion);
		this.webDriver.clickInFrame(this.btnBuscar, this.buscadorFrame);

		if (this.tCData.getConfigVar("environmnent").equals("UatPj"))
		{
			while (!this.webDriver.isPresentInFrame(this.drpdwnAcciones, this.buscadorFrame))
			{
				// Si aparece el error de busqueda, cierralo y buscar de nuevo.
				if (this.webDriver.isPresent(this.errorBuscar))
				{
					this.webDriver.click(this.cerrarErrorBuscar);
					this.webDriver.clickInFrame(this.btnBuscar, this.buscadorFrame);
				}
			}
		}
		else
		{
			while (!this.webDriver.isPresentInFrame(this.consultarProyecto, this.buscadorFrame))
			{
				// Si aparece el error de busqueda, cierralo y buscar de nuevo.
				if (this.webDriver.isPresent(this.errorBuscar))
				{
					this.webDriver.click(this.cerrarErrorBuscar);
					this.webDriver.clickInFrame(this.btnBuscar, this.buscadorFrame);
				}
			}
		}
		logger.debug("END - BuscarProyectosWeb");
		
		return this;
	}
	
	public GestionOnlineHomePage modificarProyecto() throws AWTException, InterruptedException, IOException
	{
		logger.debug("BEGIN - ModificarProyecto");
		this.webDriver.switchToFrame(this.buscadorFrame);
		
		if (this.tCData.getConfigVar("environmnent").equals("UatPj"))
		{
			System.out.println("In modificarProyecto UatPJ if");
			// this.webDriver.clickInFrame(this.drpdwnAcciones, this.buscadorFrame);
			// this.webDriver.clickInFrame(this.modificarProyectoUatPj, this.buscadorFrame);
			this.webDriver.click(this.drpdwnAcciones);
			this.webDriver.click(this.modificarProyectoUatPj);
		}
		else
		{
			System.out.println("In modificarProyecto UatPJ if else");
			try
			{
				this.webDriver.click(this.modificarProyecto);
			}
			catch (Exception e)
			{
				this.webDriver.click(this.modificarProyecto);
			}
		}
		
		this.webDriver.switchToWindow(1);
		//this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		//this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		logger.debug("END - ModificarProyecto");
		
		return this;
	}
	
	public String recuperarEstadoPoliza()
	{
		logger.debug("BEGIN - RecuperarEstadoPoliza");
		this.webDriver.getTextInFrame(this.estadoPoliza, this.buscadorFrame);
		logger.debug("END - RecuperarEstadoPoliza");
		return this.webDriver.getTextInFrame(this.estadoPoliza, this.buscadorFrame);
	}
	
	// public void openGestionCotizaciones()
	// {
	// logger.debug("BEGIN - OpenGestionCotizaciones");
	// this.webDriver.click(this.btnMapaWeb);
	// this.webDriver.doubleclickInFrame(this.btnGestionCotizaciones, this.mainFrame);
	// logger.debug("END - OpenGestionCotizaciones");
	// }
	
	public GestionOnlineHomePage openGestionPolizas()
	{
		logger.debug("BEGIN - OpenGestionPolizas");
		this.webDriver.doubleClickInFrame(this.btnMapaWeb, this.topFrame);
		this.webDriver.doubleClickInFrame(this.btnGestionPolizas, this.mainFrame);
		logger.debug("END - OpenGestionPolizas");
		
		return this;
	}
	// endregion
}
