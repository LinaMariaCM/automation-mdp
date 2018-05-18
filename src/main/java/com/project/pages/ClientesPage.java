package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ClientesPage
{
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);


	// region webelements
	@FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	@FindBy(id = "leftFrame")
	private By menuFrame = By.cssSelector("leftFrame");

	@FindBy(xpath = ".//*[text()='Clientes']")
	private By clientesLink = By.xpath(".//*[text()='Clientes']");

	@FindBy(id = "filtro1")
	private By rdbNombre = By.cssSelector("filtro1");

	@FindBy(id = "filtro2")
	private By rdbNIF = By.cssSelector("filtro2");

	@FindBy(id = "filtro3")
	private By rdbPoliza = By.cssSelector("filtro3");

	@FindBy(id = "filtro4")
	private By rdbCotizacion = By.cssSelector("filtro4");

	@FindBy(id = "filtro5")
	private By rdbColectivo = By.cssSelector("filtro5");

	@FindBy(id = "filtro6")
	private By rdbRecibo = By.cssSelector("filtro6");

	@FindBy(id = "filtro7")
	private By rdbContacto = By.cssSelector("filtro7");

	@FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");
	
	@FindBy(id = "numedocu")
	private By txtNIF = By.cssSelector("numedocu");
	
	@FindBy(id = "nombpcom")
	private By txtNombre = By.cssSelector("nombpcom");

	@FindBy(id = "datocont")
	private By txtContacto = By.cssSelector("datocont");

	@FindBy(id = "recibsec")
	private By txtRecibo = By.cssSelector("recibsec");

	@FindBy(id = "cotizsec")
	private By txtCotizacion = By.cssSelector("cotizsec");

	@FindBy(id = "polizNum")
	private By txtColectivo = By.cssSelector("polizNum");

	@FindBy(id = "polizsec")
	private By txtPoliza = By.cssSelector("polizsec");

	@FindBy(xpath = "//*[@id='capaAjax']/table[2]/tbody/tr/td")
	private By barraResultadoBusqueda = By.xpath("//*[@id='capaAjax']/table[2]/tbody/tr/td");
	
	@FindBy(xpath = ".//*[text()='Nuevo Tomador']")
	private By btnNuevoTomador = By.xpath(".//*[text()='Nuevo Tomador']");

	@FindBy(xpath = ".//*[text()='Nuevo Interveniente']")
	private By btnNuevoInterveniente = By.xpath(".//*[text()='Nuevo Interveniente']");

	@FindBy(id = "ALTACLIE_TIPODOC")
	private By drpdwnTipoDocumento = By.cssSelector("ALTACLIE_TIPODOC");

	@FindBy(id = "ALTACLIE_NUMDOC")
	private By txtNumeroDocumento = By.cssSelector("ALTACLIE_NUMDOC");

	@FindBy(id = "ALTACLIE_TIPOCLIE")
	private By drpdwnTipoCliente = By.cssSelector("ALTACLIE_TIPOCLIE");
	
	@FindBy(id = "ALTACLIE_NOMBRE")
	private By txtNombreCliente = By.cssSelector("ALTACLIE_NOMBRE");

	@FindBy(id = "ALTACLIE_APELLIDO1")
	private By txtApellido1Cliente = By.cssSelector("ALTACLIE_APELLIDO1");

	@FindBy(id = "ALTACLIE_RAZSOC")
	private By txtRazonSocial = By.cssSelector("ALTACLIE_RAZSOC");

	@FindBy(id = "ALTACLIE_IDIOMA")
	private By drpdwnIdioma = By.cssSelector("ALTACLIE_IDIOMA");
	
	@FindBy(id = "ALTACLIE_GESTPER")
	private By drpdwnGestorPersonalizado = By.cssSelector("ALTACLIE_GESTPER");
	
	@FindBy(id = "ALTACLIE_TELFF_2")
	private By txtTelefonoFijo = By.cssSelector("ALTACLIE_TELFF_2");
	
	@FindBy(id = "BOTON_DOMIMEDI")
	private By btnDomicilioFiscal = By.cssSelector("BOTON_DOMIMEDI");
	
	@FindBy(id = "ALTACLIE_PROVINCIA_ARVATO")
	private By txtProvincia = By.cssSelector("ALTACLIE_PROVINCIA_ARVATO");
	
	@FindBy(id = "ALTACLIE_POBLACION_ARVATO")
	private By txtPoblacion = By.cssSelector("ALTACLIE_POBLACION_ARVATO");
	
	@FindBy(id = "ALTACLIE_NOMVIA_ARVATO")
	private By txtVia = By.cssSelector("ALTACLIE_NOMVIA_ARVATO");
	
	@FindBy(id = "BOTON_NORMADOM")
	private By btnComprobarDireccion = By.cssSelector("BOTON_NORMADOM");

	@FindBy(id = "BOTON_ACEPTAR")
	private By btnAceptar = By.cssSelector("BOTON_ACEPTAR");
	
	@FindBy(id = "botonGrabar")
	private By btnGrabar = By.cssSelector("botonGrabar");
	
	// endregion

	public ClientesPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public void accederAlBuscadorClientes() throws InterruptedException
	{
		// Click en link Clientes
		this.webDriver.moveToElementInFrame(this.clientesLink, this.menuFrame);
		this.webDriver.doubleClickInFrame(this.clientesLink, this.menuFrame);
		//this.webDriver.waitForPageLoadWithAngular();
	}
	
	public void crearNuevoTomador() throws InterruptedException
	{
		// TODO
		// click en nuevo tomador

		// completar datos de nuevo tomador
		// tipo documento
		// numero document
		// nombre y apellidos
		// contacto
		// direccion
		
		// click en grabar
	}

	public void setFiltroBusqueda(
			String filtro)
	{
		//this.tData.setFiltroBuscadorCliente(filtro);
		this.tCData.setTestVar(testId, "FiltroBuscadorCliente", filtro);
	}

	public void buscarConFiltroBusqueda()
	{
		
		logger.debug("BEGIN - FiltroBusqueda");
		
		switch (this.tCData.getTestVar(testId, "FiltroBuscadorCliente"))
		{
			case ProjectConstants.FILTRO_BUSCADOR_NOMBRE:
				this.buscarClientePorNombre();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_NIF:
				this.buscarClientePorNIF();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_POLIZA:
				this.buscarClientePorPoliza();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_COTIZACION:
				this.buscarClientePorCotizacion();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_COLECTIVO:
				this.buscarClientePorColectivo();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_RECIBO:
				this.buscarClientePorRecibo();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_CONTACTO:
				this.buscarClientePorContacto();
				break;
		}
		
		// Click btn buscar
		this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
		logger.debug("END - FiltroBusqueda");
		
	}
	
	public void clickNuevoTomador()
	{
		this.webDriver.clickInFrame(this.btnNuevoTomador, this.cuerpoFrame);
	}

	public void clickNuevoInterveniente()
	{
		this.webDriver.clickInFrame(this.btnNuevoInterveniente, this.cuerpoFrame);
	}
	
	private void buscarClientePorContacto()
	{
		// Click en el rdb Contacto
		this.webDriver.clickInFrame(this.rdbContacto, this.cuerpoFrame);

		// Set Contacto
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtContacto, this.cuerpoFrame, this.tData.getContactoCliente());
		this.webDriver.clearAndAppendTextInFrame(this.txtContacto, this.cuerpoFrame, this.tCData.getTestVar(testId, "ContactoCliente"));
	}

	private void buscarClientePorRecibo()
	{
		// Click en el rdb Recibo
		this.webDriver.clickInFrame(this.rdbRecibo, this.cuerpoFrame);

		// Set Recibo
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtRecibo, this.cuerpoFrame, this.tData.getReciboCliente());
		this.webDriver.clearAndAppendTextInFrame(this.txtRecibo, this.cuerpoFrame, this.tCData.getTestVar(testId, "ReciboCliente"));
	}

	private void buscarClientePorColectivo()
	{
		// Click en el rdb Cotizacion
		this.webDriver.clickInFrame(this.rdbColectivo, this.cuerpoFrame);

		// Set Cotizacion
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtColectivo, this.cuerpoFrame, this.tData.getColectivoCliente());
		this.webDriver.clearAndAppendTextInFrame(this.txtColectivo, this.cuerpoFrame, this.tCData.getTestVar(testId, "ColectivoCliente"));
	}

	private void buscarClientePorCotizacion()
	{
		// Click en el rdb Cotizacion
		this.webDriver.clickInFrame(this.rdbCotizacion, this.cuerpoFrame);

		// Set Cotizacion
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtCotizacion, this.cuerpoFrame, this.tData.getNoCotizacion());
		this.webDriver.clearAndAppendTextInFrame(this.txtCotizacion, this.cuerpoFrame, this.tCData.getTestVar(testId, "CotizacionNum"));
	}

	private void buscarClientePorPoliza()
	{
		// Click en el rdb Poliza
		this.webDriver.clickInFrame(this.rdbPoliza, this.cuerpoFrame);

		// Set Poliza
		
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtPoliza, this.cuerpoFrame, this.tData.getNumPoliza().toString());
		this.webDriver.clearAndAppendTextInFrame(this.txtPoliza, this.cuerpoFrame, this.tCData.getTestVar(testId, "NumPoliza"));
	}

	private void buscarClientePorNombre()
	{
		// Click en el rdb Nombre
		this.webDriver.clickInFrame(this.rdbNombre, this.cuerpoFrame);

		// Set Nombre
		this.webDriver.clearText(txtNombre);
		this.webDriver.appendTextInFrame(this.txtNombre, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorNombre"));
	}

	public void buscarClientePorNIF()
	{
		this.buscarClientePorNIF(this.tCData.getTestVar(testId, "DocumentoInquilino"));
	}

	public void buscarClientePorNIF(
			String numNIF)
	{
		// Click en el rdb NIF
		this.webDriver.clickInFrame(this.rdbNIF, this.cuerpoFrame);
		
		// Set NIF
		//this.webDriver.clearAndSetTextInWebElementInFrame(this.txtNIF, this.cuerpoFrame, numNIF);
		this.webDriver.clearAndAppendTextInFrame(this.txtNIF, this.cuerpoFrame, numNIF);
		
		this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
	}

	public boolean checkResultadoNIF()
	{
		logger.debug("BEGIN - CheckResultadoNIF");
		boolean res = false;
		if (this.webDriver.isPresentInFrame(this.barraResultadoBusqueda, this.cuerpoFrame))
		{
			res = this.webDriver.getTextInFrame(this.barraResultadoBusqueda, this.cuerpoFrame).contains("Resultado de la búsqueda (Nº clientes: 1)");
		}
		
		logger.debug("END - CheckResultadoNIF");
		return res;
	}
	// endregion
}
