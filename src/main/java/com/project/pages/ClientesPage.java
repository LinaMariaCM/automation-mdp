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

public class ClientesPage
{
	final static Logger logger = LoggerFactory.getLogger(FichaEdificioPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	@FindBy(id = "leftFrame")
	private WebElement menuFrame;

	@FindBy(xpath = ".//*[text()='Clientes']")
	private WebElement clientesLink;

	@FindBy(id = "filtro1")
	private WebElement rdbNombre;

	@FindBy(id = "filtro2")
	private WebElement rdbNIF;

	@FindBy(id = "filtro3")
	private WebElement rdbPoliza;

	@FindBy(id = "filtro4")
	private WebElement rdbCotizacion;

	@FindBy(id = "filtro5")
	private WebElement rdbColectivo;

	@FindBy(id = "filtro6")
	private WebElement rdbRecibo;

	@FindBy(id = "filtro7")
	private WebElement rdbContacto;

	@FindBy(name = "botonBuscar")
	private WebElement btnBuscar;
	
	@FindBy(id = "numedocu")
	private WebElement txtNIF;
	
	@FindBy(id = "nombpcom")
	private WebElement txtNombre;

	@FindBy(id = "datocont")
	private WebElement txtContacto;

	@FindBy(id = "recibsec")
	private WebElement txtRecibo;

	@FindBy(id = "cotizsec")
	private WebElement txtCotizacion;

	@FindBy(id = "polizNum")
	private WebElement txtColectivo;

	@FindBy(id = "polizsec")
	private WebElement txtPoliza;

	@FindBy(xpath = "//*[@id='capaAjax']/table[2]/tbody/tr/td")
	private WebElement barraResultadoBusqueda;
	
	@FindBy(xpath = ".//*[text()='Nuevo Tomador']")
	private WebElement btnNuevoTomador;

	@FindBy(xpath = ".//*[text()='Nuevo Interveniente']")
	private WebElement btnNuevoInterveniente;

	@FindBy(id = "ALTACLIE_TIPODOC")
	private WebElement drpdwnTipoDocumento;

	@FindBy(id = "ALTACLIE_NUMDOC")
	private WebElement txtNumeroDocumento;

	@FindBy(id = "ALTACLIE_TIPOCLIE")
	private WebElement drpdwnTipoCliente;
	
	@FindBy(id = "ALTACLIE_NOMBRE")
	private WebElement txtNombreCliente;

	@FindBy(id = "ALTACLIE_APELLIDO1")
	private WebElement txtApellido1Cliente;

	@FindBy(id = "ALTACLIE_RAZSOC")
	private WebElement txtRazonSocial;

	@FindBy(id = "ALTACLIE_IDIOMA")
	private WebElement drpdwnIdioma;
	
	@FindBy(id = "ALTACLIE_GESTPER")
	private WebElement drpdwnGestorPersonalizado;
	
	@FindBy(id = "ALTACLIE_TELFF_2")
	private WebElement txtTelefonoFijo;
	
	@FindBy(id = "BOTON_DOMIMEDI")
	private WebElement btnDomicilioFiscal;
	
	@FindBy(id = "ALTACLIE_PROVINCIA_ARVATO")
	private WebElement txtProvincia;
	
	@FindBy(id = "ALTACLIE_POBLACION_ARVATO")
	private WebElement txtPoblacion;
	
	@FindBy(id = "ALTACLIE_NOMVIA_ARVATO")
	private WebElement txtVia;
	
	@FindBy(id = "BOTON_NORMADOM")
	private WebElement btnComprobarDireccion;

	@FindBy(id = "BOTON_ACEPTAR")
	private WebElement btnAceptar;
	
	@FindBy(id = "botonGrabar")
	private WebElement btnGrabar;
	
	// endregion

	public ClientesPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods
	public void accederAlBuscadorClientes() throws InterruptedException
	{
		// Click en link Clientes
		this.wh.moveToElementInFrameWithJavaScript(this.clientesLink, this.menuFrame);
		this.wh.doubleClickOnWebElementInFrame(this.clientesLink, this.menuFrame);
		this.wh.waitForPageLoadWithAngular();
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
		this.tData.setFiltroBuscadorCliente(filtro);
	}

	public void buscarConFiltroBusqueda()
	{
		
		logger.debug("BEGIN - FiltroBusqueda");
		
		switch (this.tData.getFiltroBuscadorCliente())
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
		this.wh.clickOnWebElementInFrame(this.btnBuscar, this.cuerpoFrame);
		logger.debug("END - FiltroBusqueda");
		
	}
	
	public void clickNuevoTomador()
	{
		this.wh.clickOnWebElementInFrame(this.btnNuevoTomador, this.cuerpoFrame);
	}

	public void clickNuevoInterveniente()
	{
		this.wh.clickOnWebElementInFrame(this.btnNuevoInterveniente, this.cuerpoFrame);
	}
	
	private void buscarClientePorContacto()
	{
		// Click en el rdb Contacto
		this.wh.clickOnWebElementInFrame(this.rdbContacto, this.cuerpoFrame);

		// Set Contacto
		this.wh.clearAndSetTextInWebElementInFrame(this.txtContacto, this.cuerpoFrame, this.tData.getContactoCliente());
	}

	private void buscarClientePorRecibo()
	{
		// Click en el rdb Recibo
		this.wh.clickOnWebElementInFrame(this.rdbRecibo, this.cuerpoFrame);

		// Set Recibo
		this.wh.clearAndSetTextInWebElementInFrame(this.txtRecibo, this.cuerpoFrame, this.tData.getReciboCliente());
	}

	private void buscarClientePorColectivo()
	{
		// Click en el rdb Cotizacion
		this.wh.clickOnWebElementInFrame(this.rdbColectivo, this.cuerpoFrame);

		// Set Cotizacion
		this.wh.clearAndSetTextInWebElementInFrame(this.txtColectivo, this.cuerpoFrame, this.tData.getColectivoCliente());
	}

	private void buscarClientePorCotizacion()
	{
		// Click en el rdb Cotizacion
		this.wh.clickOnWebElementInFrame(this.rdbCotizacion, this.cuerpoFrame);

		// Set Cotizacion
		this.wh.clearAndSetTextInWebElementInFrame(this.txtCotizacion, this.cuerpoFrame, this.tData.getNoCotizacion());
	}

	private void buscarClientePorPoliza()
	{
		// Click en el rdb Poliza
		this.wh.clickOnWebElementInFrame(this.rdbPoliza, this.cuerpoFrame);

		// Set Poliza
		this.wh.clearAndSetTextInWebElementInFrame(this.txtPoliza, this.cuerpoFrame, this.tData.getNumPoliza().toString());
	}

	private void buscarClientePorNombre()
	{
		// Click en el rdb Nombre
		this.wh.clickOnWebElementInFrame(this.rdbNombre, this.cuerpoFrame);

		// Set Nombre
		this.wh.clearAndSetTextInWebElementInFrame(this.txtNombre, this.cuerpoFrame, this.tData.getTomadorNombre());
	}

	public void buscarClientePorNIF()
	{
		this.buscarClientePorNIF(this.tData.getDocumentoInquilino());
	}

	public void buscarClientePorNIF(
			String numNIF)
	{
		// Click en el rdb NIF
		this.wh.clickOnWebElementInFrame(this.rdbNIF, this.cuerpoFrame);
		
		// Set NIF
		this.wh.clearAndSetTextInWebElementInFrame(this.txtNIF, this.cuerpoFrame, numNIF);
		
		this.wh.clickOnWebElementInFrame(this.btnBuscar, this.cuerpoFrame);
	}

	public boolean checkResultadoNIF()
	{
		logger.debug("BEGIN - CheckResultadoNIF");
		boolean res = false;
		if (this.wh.webElementInFrameIsPresent(this.barraResultadoBusqueda, this.cuerpoFrame))
		{
			res = this.wh.getTextFromWebElementInFrame(this.barraResultadoBusqueda, this.cuerpoFrame).contains("Resultado de la búsqueda (Nº clientes: 1)");
		}
		
		logger.debug("END - CheckResultadoNIF");
		return res;
	}
	// endregion
}
