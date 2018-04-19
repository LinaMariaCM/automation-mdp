package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class MediadoresAltaProspectPage
{
	final static Logger logger = LoggerFactory.getLogger(MediadoresAltaProspectPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(id = "leftFrame")
	private WebElement menuFrame;

	@FindBy(id = "topFrame")
	private WebElement topFrame;

	@FindBy(id = "mainFrame")
	private WebElement mainFrame;

	@FindBy(id = "capaIframe")
	private WebElement modalFrame;
	
	@FindBy(id = "MEDI_NIVEESTR")
	private WebElement drpdwnNivelEstructura;

	@FindBy(id = "MEDI_TIPOPROS")
	private WebElement drpdwnTipoProspect;

	@FindBy(id = "MEDI_REGISDGS")
	private WebElement txtNumRegistroDGS;

	@FindBy(id = "MEDI_ACTIPRIN")
	private WebElement drpdwnActividadPrincipal;

	@FindBy(id = "MEDI_NOMBCOME")
	private WebElement txtNombreComercialProspect;

	@FindBy(id = "MEDI_PERSCONT")
	private WebElement txtContactoResponsable;

	@FindBy(id = "MEDI_IDIOMA")
	private WebElement drpdwnIdioma;
	
	@FindBy(id = "MEDI_TELEFONO1")
	private WebElement txtTlf1;
	
	@FindBy(id = "MEDI_EJECCOME")
	private WebElement drpdwnEjecutivoComercial;
	
	@FindBy(id = "botonGrabar")
	private WebElement btnGrabar;
	
	@FindBy(id = "BOTON_DOMIMEDI")
	private WebElement btnAsignarDomicilio;

	@FindBy(id = "ALTACLIE_PROVINCIA_ARVATO")
	private WebElement txtProvincia;

	@FindBy(xpath = "./html/body/ul[1]/li/a")
	private WebElement drpdwnProvincia;

	@FindBy(id = "ALTACLIE_POBLACION_ARVATO")
	private WebElement txtPoblacion;
	
	@FindBy(xpath = "./html/body/ul[2]/li/a")
	private WebElement drpdwnPoblacion;
	
	@FindBy(id = "ALTACLIE_NOMVIA_ARVATO")
	private WebElement txtVia;

	@FindBy(xpath = "./html/body/ul[3]/li/a")
	private WebElement drpdwnVia;
	
	@FindBy(id = "BOTON_NORMADOM")
	private WebElement btnComprobarDireccion;

	@FindBy(id = "BOTON_ACEPTAR")
	private WebElement btnAceptarDireccion;
	// endregion

	public MediadoresAltaProspectPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods
	public void executeActionsAltaProspectPage() throws InterruptedException, IOException
	{
		// String tipoProspect = this.tData.getTipoProspect();
		// String tipoProspect = this.tData.getTipoProspect();
		// System.out.println(tipoProspect);

		this.selectNivelEstructura();
		this.selectTipoProspect();
		this.selectActividadPrincipal();
		// if (tipoProspect.equals("Corredor-BS"))
		// {
		// this.writeNumeroRegistroDGS();
		// }
		if (this.tData.getTipoProspect().equals("Corredor-BS"))
		{
			this.writeNumeroRegistroDGS();
		}
		this.writeNombreComercialProspect();
		this.writeContactoResponsable();
		this.selectIdioma();
		this.writeTelefonoUno();
		this.selectEjecutivoComercial();
		this.completarDatosDireccion();
		this.clickBotonGrabar();
	}
	
	public void completarDatosDireccion() throws InterruptedException, IOException
	{
		this.clickBotonAsignarDomicilio();
		this.selectProvincia();
		this.selectPoblacion();
		this.selectVia();
		this.clickBotonComprobarDireccion();
		this.clickBotonAceptarDireccion();
	}
	
	public void selectNivelEstructura() throws IOException
	{
		logger.debug("BEGIN - selectNivelEstructura");
		// this.wh.sendValueToWebElementInFrame(this.drpdwnNivelEstructura, this.mainFrame,
		// String.valueOf(this.tData.getNivelEstructura()));
		this.wh.sendValueToWebElementInFrame(this.drpdwnNivelEstructura, this.mainFrame, String.valueOf(this.tData.getNivelEstructura()));
		logger.debug("END - selectNivelEstructura");
	}
	
	public void selectTipoProspect() throws IOException
	{
		logger.debug("BEGIN - selectTipoProspect");
		// this.wh.sendValueToWebElementInFrame(this.drpdwnTipoProspect, this.mainFrame,
		// String.valueOf(this.tData.getTipoProspect()));
		this.wh.sendValueToWebElementInFrame(this.drpdwnTipoProspect, this.mainFrame, String.valueOf(this.tData.getTipoProspect()));
		logger.debug("END - selectTipoProspect");
	}

	public void writeNumeroRegistroDGS() throws IOException
	{
		logger.debug("BEGIN - writeNumeroRegistroDGS");
		this.wh.sendValueToWebElementInFrame(this.txtNumRegistroDGS, this.mainFrame, String.valueOf(this.tData.getDgs()));
		logger.debug("END - writeNumeroRegistroDGS");
	}

	public void selectActividadPrincipal() throws IOException
	{
		logger.debug("BEGIN - selectActividadPrincipal");
		// this.wh.sendValueToWebElementInFrame(this.drpdwnActividadPrincipal, this.mainFrame,
		// String.valueOf(this.tData.getActividadPrincipal()));
		this.wh.sendValueToWebElementInFrame(this.drpdwnActividadPrincipal, this.mainFrame, String.valueOf(this.tData.getActividadPrincipal()));
		logger.debug("END - selectActividadPrincipal");
	}
	
	public void writeNombreComercialProspect() throws IOException
	{
		logger.debug("BEGIN - writeNombreComercialProspect");
		this.wh.sendValueToWebElementInFrame(this.txtNombreComercialProspect, this.mainFrame, String.valueOf(this.tData.getNombreComercialProspect()));
		logger.debug("END - writeNombreComercialProspect");
	}
	
	public void writeContactoResponsable() throws IOException
	{
		logger.debug("BEGIN - writeContactoResponsable");
		this.wh.sendValueToWebElementInFrame(this.txtContactoResponsable, this.mainFrame, String.valueOf(this.tData.getContactoResponsable()));
		logger.debug("END - writeContactoResponsable");
	}

	public void writeTelefonoUno() throws IOException
	{
		logger.debug("BEGIN - writeTelefonoUno");
		this.wh.sendValueToWebElementInFrame(this.txtTlf1, this.mainFrame, String.valueOf(this.tData.getTlfPrincipal()));
		logger.debug("END - writeTelefonoUno");
	}

	public void selectIdioma() throws IOException
	{
		logger.debug("BEGIN - selectIdioma");
		this.wh.sendValueToWebElementInFrame(this.drpdwnIdioma, this.mainFrame, String.valueOf(this.tData.getIdioma()));
		logger.debug("END - selectIdioma");
	}

	public void selectEjecutivoComercial() throws IOException
	{
		logger.debug("BEGIN - selectEjecutivoComercial");
		this.wh.sendValueToWebElementInFrame(this.drpdwnEjecutivoComercial, this.mainFrame, String.valueOf(this.tData.getEjecutivoComercial()));
		logger.debug("END - selectEjecutivoComercial");
	}
	
	public void clickBotonAsignarDomicilio() throws IOException
	{
		logger.debug("BEGIN - clickBotonAsignarDomicilio");
		this.wh.clickOnWebElementInFrame(this.btnAsignarDomicilio, this.mainFrame);
		logger.debug("END - clickBotonAsignarDomicilio");
	}
	
	public void selectProvincia() throws IOException
	{
		logger.debug("BEGIN - selectProvincia");
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		// this.wh.sendValueToWebElement(this.txtProvincia, String.valueOf(this.tData.getProvincia()));
		this.wh.sendValueToWebElement(this.txtProvincia, String.valueOf(this.tData.getProvincia()));
		this.wh.waitForWebElement(this.drpdwnProvincia);
		this.wh.changeFocusOfWebElement(this.txtProvincia);
		this.wh.exitFromFrame();
		logger.debug("END - selectProvincia");
	}
	
	public void selectPoblacion() throws IOException
	{
		logger.debug("BEGIN - selectPoblacion");
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		// this.wh.sendValueToWebElement(this.txtPoblacion, String.valueOf(this.tData.getPoblacion()));
		this.wh.sendValueToWebElement(this.txtPoblacion, String.valueOf(this.tData.getPoblacion()));
		this.wh.waitForWebElement(this.drpdwnPoblacion);
		this.wh.changeFocusOfWebElement(this.txtPoblacion);
		this.wh.exitFromFrame();
		logger.debug("END - selectPoblacion");
	}

	public void selectVia() throws IOException
	{
		logger.debug("BEGIN - selectVia");
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.sendValueToWebElement(this.txtVia, String.valueOf(this.tData.getNombreVia()));
		this.wh.waitForWebElement(this.drpdwnVia);
		this.wh.changeFocusOfWebElement(this.txtVia);
		this.wh.exitFromFrame();
		logger.debug("END - selectVia");
	}

	public void clickBotonComprobarDireccion() throws IOException
	{
		logger.debug("BEGIN - clickBotonComprobarDireccion");
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.clickOnWebElement(this.btnComprobarDireccion);
		this.wh.exitFromFrame();
		logger.debug("END - clickBotonComprobarDireccion");
	}

	public void clickBotonAceptarDireccion() throws IOException
	{
		logger.debug("BEGIN - clickBotonAceptarDireccion");
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.clickOnWebElement(this.btnAceptarDireccion);
		this.wh.exitFromFrame();
		logger.debug("END - clickBotonAceptarDireccion");
	}

	public void clickBotonGrabar() throws IOException
	{
		logger.debug("BEGIN - clickBotonGrabar");
		this.wh.clickOnWebElementInFrame(this.btnGrabar, this.mainFrame);
		logger.debug("END - clickBotonGrabar");
	}
	// endregion
}
