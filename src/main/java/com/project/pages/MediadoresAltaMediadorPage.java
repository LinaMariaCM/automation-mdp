package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class MediadoresAltaMediadorPage
{
	final static Logger logger = LoggerFactory.getLogger(MediadoresAltaMediadorPage.class);
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
	
	@FindBy(id = "ALTAMEDI_TIPOMEDIALTA")
	private WebElement drpdwnTipoMediador;

	@FindBy(id = "ALTAMEDI_TIPODOCMED")
	private WebElement drpdwnTipoDocumento;

	@FindBy(id = "ALTAMEDI_NUMDOC")
	private WebElement txtNumeroDocumento;

	@FindBy(id = "ALTAMEDI_NREGDGS")
	private WebElement txtNumRegistroDGS;
	
	@FindBy(id = "MEDI_ACTIPRIN")
	private WebElement drpdwnActividadPrincipal;
	
	@FindBy(id = "MEDI_PERSCONT")
	private WebElement txtContactoResponsable;

	@FindBy(id = "ALTAMEDI_CARGRESP")
	private WebElement txtCargoResponsable;

	@FindBy(id = "MEDI_IDIOMA")
	private WebElement drpdwnIdioma;

	@FindBy(id = "MEDI_TELEFONO1")
	private WebElement txtTlf1;
	
	@FindBy(id = "MEDI_EJECCOME")
	private WebElement drpdwnEjecutivoComercial;

	@FindBy(id = "botonGrabar1")
	private WebElement btnGrabar;

	@FindBy(id = "BOTON_DOMIMEDI")
	private WebElement btnAsignarDomicilio;
	
	@FindBy(id = "ALTACLIE_PROVINCIA_ARVATO")
	private WebElement txtProvincia;
	
	// @FindBy(xpath = "./html/body/ul[1]/li/a")
	@FindBy(css = "body > ul:nth-child(4)")
	private WebElement drpdwnProvincia;
	
	@FindBy(id = "ALTACLIE_POBLACION_ARVATO")
	private WebElement txtPoblacion;

	// @FindBy(xpath = "./html/body/ul[2]/li/a")
	@FindBy(css = "body > ul:nth-child(5)")
	private WebElement drpdwnPoblacion;

	@FindBy(id = "ALTACLIE_NOMVIA_ARVATO")
	private WebElement txtVia;
	
	// @FindBy(xpath = "./html/body/ul[3]/li/a")
	@FindBy(css = "body > ul:nth-child(6)")
	private WebElement drpdwnVia;

	@FindBy(id = "BOTON_NORMADOM")
	private WebElement btnComprobarDireccion;
	
	@FindBy(id = "BOTON_ACEPTAR")
	private WebElement btnAceptarDireccion;

	@FindBy(id = "BOTON_ACEPDOMI")
	private WebElement btnAceptarDireccionPostal;
	
	@FindBy(id = "ALTAMEDI_NOMFISCMED")
	private WebElement txtNombreFiscal;

	@FindBy(id = "ALTAMEDI_APE1FISC")
	private WebElement txtPrimerApellido;

	@FindBy(id = "ALTAMEDI_APE2FISC")
	private WebElement txtSegundoApellido;

	@FindBy(id = "botonContinuar1")
	private WebElement btnContinuar;

	@FindBy(id = "ALTAMEDI_EMAILPRI")
	private WebElement txtEmailPrincipal;
	
	@FindBy(css = "#capaDireccionesPaso2 > div > div.floatright.peq > a")
	private WebElement anyadirNuevaDireccion;
	
	@FindBy(id = "ALTAMEDI_TIPDOMME")
	private WebElement drpdwnTipoDomicilio;

	@FindBy(id = "ALTAMEDI_NOMCOIGU")
	private WebElement radioNombreComercialIgualFiscal;

	@FindBy(id = "ALTAMEDI_NOMCODIF")
	private WebElement radioNombreComercialDiferenteFiscal;
	
	@FindBy(id = "ALTAMEDI_IGUFISC")
	private WebElement radioDireccionIgualFiscal;

	@FindBy(id = "ALTAMEDI_OTRONOMB")
	private WebElement txtNombreComercial;
	
	// Datos transaccionales page elements.
	@FindBy(id = "COMODIN_CADENA")
	private WebElement txtCodigoIban;
	
	@FindBy(id = "COMODIN_CADENA_1")
	private WebElement txtBanco;
	
	@FindBy(id = "COMODIN_CADENA_2")
	private WebElement txtSucursal;
	
	@FindBy(id = "COMODIN_CADENA_3")
	private WebElement txtDc;
	
	@FindBy(id = "COMODIN_CADENA_4")
	private WebElement txtCta1;
	
	@FindBy(id = "COMODIN_CADENA_5")
	private WebElement txtCta2;

	@FindBy(id = "ALTAMEDI_OFINO")
	private WebElement tieneOficinasNo;

	@FindBy(id = "ALTAMEDI_TRABAJANO")
	private WebElement colaboradresExternosNo;

	@FindBy(id = "ALTAMEDI_SOFTNO")
	private WebElement softwareGestionNo;

	@FindBy(id = "ALTAMEDI_COMPPRIN")
	private WebElement companiasPrincipales;
	// endregion
	
	public MediadoresAltaMediadorPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	public void executeActionsAltaMediadorPage() throws InterruptedException, IOException
	{
		
		// "Datos descriptivos" page.
		this.selectNivelEstructura();
		this.selectTipoMediador();
		this.selectEjecutivoComercial();
		this.selectTipoDocumento();
		this.writeNumeroDocumento();
		this.writeNombreFiscalYApellidosMediador();
		this.writeNombreComercialMediador();
		this.selectActividadPrincipal();
		this.selectIdioma();
		this.selectTieneOficinas();
		this.selectColaboradoresExternos();
		this.selectSoftwareGestion();
		this.clickContinuar();
		
		// "Datos de contacto" page.
		this.writeContactoResponsable();
		this.writeCargoResponsable();
		this.writeTelefonoUno();
		this.writeEmailPrincipal();
		this.addDireccionComercial();
		this.addDireccionFiscal();
		this.addDireccionPostalProduccion();
		this.addDireccionPostalRecibos();
		this.addDireccionPostalSiniestros();
		this.clickContinuar();
		
		// "Datos relacionales" page.
		this.addCompaniasPrincipales();
		this.clickContinuar();

		// Datos transaccionales" page.
		this.writeCuentaBancaria();
		this.wh.clickOnWebElementInFrame(this.btnGrabar, this.mainFrame);
	}

	public void selectNivelEstructura() throws IOException
	{
		logger.debug("BEGIN - selectNivelEstructura");
		this.wh.selectValueInDropDownInFrame(this.drpdwnNivelEstructura, this.mainFrame, String.valueOf(this.tData.getNivelEstructura()));
		logger.debug("END - selectNivelEstructura");
	}

	public void selectEjecutivoComercial() throws IOException
	{
		logger.debug("BEGIN - selectEjecutivoComercial");
		this.wh.selectValueInDropDownInFrame(this.drpdwnEjecutivoComercial, this.mainFrame, String.valueOf(this.tData.getEjecutivoComercial()));
		logger.debug("END - selectEjecutivoComercial");
	}
	
	public void selectTipoMediador() throws IOException
	{
		logger.debug("BEGIN - selectTipoProspect");
		this.wh.selectValueInDropDownInFrame(this.drpdwnTipoMediador, this.mainFrame, String.valueOf(this.tData.getTipoMediador()));
		logger.debug("END - selectTipoProspect");
	}

	public void selectTipoDocumento() throws IOException
	{
		logger.debug("BEGIN - selectTipoDocumento");
		this.wh.selectValueInDropDownInFrame(this.drpdwnTipoDocumento, this.mainFrame, String.valueOf(this.tData.getTipoDocumento()));
		logger.debug("END - selectTipoDocumento");
	}

	public void writeNumeroDocumento() throws IOException
	{
		logger.debug("BEGIN - writeNumeroDocumento");
		if (this.tData.getTipoDocumento() != null && this.tData.getTipoDocumento().equals("NIF"))
		{
			this.tData.setNumeroDocumentoMediador(DniGeneratorHelper.generaNif(null));
			this.wh.sendValueToWebElementInFrame(this.txtNumeroDocumento, this.mainFrame, String.valueOf(this.tData.getNumeroDocumentoMediador()));
		}
		logger.debug("END - writeNumeroDocumento");
	}
	
	public void writeNombreFiscalYApellidosMediador() throws IOException
	{
		logger.debug("BEGIN - writeNombreFiscalYApellidosMediador");
		// When CIF, only the Nombre Fiscal field appears.
		if (this.tData.getTipoDocumento() != null && this.tData.getTipoDocumento().equals("CIF"))
		{
			this.wh.sendValueToWebElementInFrame(this.txtNombreFiscal, this.mainFrame, String.valueOf(this.tData.getNombreFiscalMediador()));
		}
		// When NIF or NIE, also shows surname fields. Second surname only mandatory for NIF.
		else
		{
			this.wh.sendValueToWebElementInFrame(this.txtNombreFiscal, this.mainFrame, String.valueOf(this.tData.getNombreFiscalMediador()));
			this.wh.sendValueToWebElementInFrame(this.txtPrimerApellido, this.mainFrame, String.valueOf(this.tData.getPrimerApellidoMediador()));
			this.wh.sendValueToWebElementInFrame(this.txtSegundoApellido, this.mainFrame, String.valueOf(this.tData.getSegundoApellidoMediador()));
		}
		logger.debug("END - writeNombreFiscalYApellidosMediador");
	}
	
	public void writeNombreComercialMediador() throws IOException
	{
		logger.debug("BEGIN - writeNombreComercialMediador");
		
		if (this.tData.getTipoNombreComercialMediador().equals("Igual que el fiscal"))
		{
			// Cuando nombre comercial es igual al fiscal, solo hay que marcar el radio button.
			this.wh.clickOnWebElementInFrame(this.radioNombreComercialIgualFiscal, this.mainFrame);
		}
		
		if (this.tData.getTipoNombreComercialMediador().equals("Diferente que el fiscal"))
		{
			// Cuando nombre comercial es diferente que el fiscal, hay que marcar el radio button y completar el nombre comercial (by default it is
			// the same as the nombre fiscal).
			this.wh.clickOnWebElementInFrame(this.radioNombreComercialDiferenteFiscal, this.mainFrame);
			this.wh.sendValueToWebElementInFrame(this.txtNombreComercial, this.mainFrame, String.valueOf(this.tData.getNombreComercialMediador()));
		}
		logger.debug("END - writeNombreComercialMediador");
	}

	public void selectActividadPrincipal() throws IOException
	{
		logger.debug("BEGIN - selectActividadPrincipal");
		this.wh.selectValueInDropDownInFrame(this.drpdwnActividadPrincipal, this.mainFrame, String.valueOf(this.tData.getActividadPrincipal()));
		logger.debug("END - selectActividadPrincipal");
	}

	public void selectIdioma() throws IOException
	{
		logger.debug("BEGIN - selectIdioma");
		this.wh.selectValueInDropDownInFrame(this.drpdwnIdioma, this.mainFrame, String.valueOf(this.tData.getIdioma()));
		logger.debug("END - selectIdioma");
	}

	public void writeNumeroRegistroDGS() throws IOException
	{
		logger.debug("BEGIN - writeNumeroRegistroDGS");
		// Solo requiere Nº registo DGSFP cuando el tipo mediador es "Agente vinculado", "BS Exclusivo", "BS Vinculado", o "Corredor".
		if (this.tData.getTipoMediador() != null && this.tData.getTipoMediador().equals("Agente vinculado")
				| this.tData.getTipoMediador().equals("BS Exclusivo") | this.tData.getTipoMediador().equals("Corredor"))
		{
			this.wh.sendValueToWebElementInFrame(this.txtNumRegistroDGS, this.mainFrame, String.valueOf(this.tData.getDgs()));
		}
		logger.debug("END - writeNumeroRegistroDGS");
	}
	
	public void selectTieneOficinas() throws IOException
	{
		logger.debug("BEGIN - selectTieneOficinas");
		this.wh.clickOnWebElementInFrame(this.tieneOficinasNo, this.mainFrame);
		logger.debug("END - selectTieneOficinas");
	}

	public void selectColaboradoresExternos() throws IOException
	{
		logger.debug("BEGIN - selectColaboradoresExternos");
		this.wh.clickOnWebElementInFrame(this.colaboradresExternosNo, this.mainFrame);
		logger.debug("END - selectColaboradoresExternos");
	}

	public void selectSoftwareGestion() throws IOException
	{
		logger.debug("BEGIN - selectSoftwareGestion");
		this.wh.clickOnWebElementInFrame(this.softwareGestionNo, this.mainFrame);
		logger.debug("END - selectSoftwareGestion");
	}

	public void clickContinuar() throws IOException
	{
		logger.debug("BEGIN - clickContinuar");
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.mainFrame);
		logger.debug("END - clickContinuar");
	}

	public void writeContactoResponsable() throws IOException
	{
		logger.debug("BEGIN - writeContactoResponsable");
		this.wh.sendValueToWebElementInFrame(this.txtContactoResponsable, this.mainFrame, String.valueOf(this.tData.getContactoResponsable()));
		logger.debug("END - writeContactoResponsable");
	}

	public void writeCargoResponsable() throws IOException
	{
		logger.debug("BEGIN - writeCargoResponsable");
		this.wh.sendValueToWebElementInFrame(this.txtCargoResponsable, this.mainFrame, String.valueOf(this.tData.getCargoResponsable()));
		logger.debug("END - writeCargoResponsable");
	}

	public void writeTelefonoUno() throws IOException
	{
		logger.debug("BEGIN - writeTelefonoUno");
		this.wh.sendValueToWebElementInFrame(this.txtTlf1, this.mainFrame, String.valueOf(this.tData.getTlfPrincipal()));
		logger.debug("END - writeTelefonoUno");
	}

	public void writeEmailPrincipal() throws IOException
	{
		logger.debug("BEGIN - writeEmailPrincipal");
		this.wh.sendValueToWebElementInFrame(this.txtEmailPrincipal, this.mainFrame, String.valueOf(this.tData.getEmailPrincipal()));
		logger.debug("END - writeEmailPrincipal");
	}
	
	public void addDireccionComercial() throws IOException
	{
		logger.debug("BEGIN - addDireccionComercial");
		this.wh.clickOnWebElementInFrame(this.anyadirNuevaDireccion, this.mainFrame);
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.selectValueInDropDown(this.drpdwnTipoDomicilio, "Comercial");
		this.wh.sendValueToWebElement(this.txtProvincia, this.tData.getProvincia());
		this.wh.waitForWebElement(this.drpdwnProvincia);
		this.wh.changeFocusOfWebElement(this.txtProvincia);
		this.wh.sendValueToWebElement(this.txtPoblacion, this.tData.getPoblacion());
		this.wh.waitForWebElement(this.drpdwnPoblacion);
		this.wh.changeFocusOfWebElement(this.txtPoblacion);
		this.wh.sendValueToWebElement(this.txtVia, this.tData.getNombreVia());
		this.wh.waitForWebElement(this.drpdwnVia);
		this.wh.changeFocusOfWebElement(this.txtVia);
		this.wh.clickOnWebElement(this.btnComprobarDireccion);
		this.wh.clickOnWebElement(this.btnAceptarDireccion);
		this.wh.exitFromFrame();
		logger.debug("END - addDireccionComercial");
	}

	public void addDireccionFiscal() throws IOException
	{
		logger.debug("BEGIN - addDireccionFiscal");
		this.wh.clickOnWebElementInFrame(this.anyadirNuevaDireccion, this.mainFrame);
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.selectValueInDropDown(this.drpdwnTipoDomicilio, "Fiscal");
		this.wh.sendValueToWebElement(this.txtProvincia, this.tData.getProvincia());
		this.wh.waitForWebElement(this.drpdwnProvincia);
		this.wh.changeFocusOfWebElement(this.txtProvincia);
		this.wh.sendValueToWebElement(this.txtPoblacion, this.tData.getPoblacion());
		this.wh.waitForWebElement(this.drpdwnPoblacion);
		this.wh.changeFocusOfWebElement(this.txtPoblacion);
		this.wh.sendValueToWebElement(this.txtVia, this.tData.getNombreVia());
		this.wh.waitForWebElement(this.drpdwnVia);
		this.wh.changeFocusOfWebElement(this.txtVia);
		this.wh.clickOnWebElement(this.btnComprobarDireccion);
		this.wh.clickOnWebElement(this.btnAceptarDireccion);
		this.wh.exitFromFrame();
		logger.debug("END - addDireccionFiscal");
	}

	public void addDireccionPostalProduccion() throws IOException
	{
		logger.debug("BEGIN - addDireccionPostalProduccion");
		this.wh.clickOnWebElementInFrame(this.anyadirNuevaDireccion, this.mainFrame);
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.selectValueInDropDown(this.drpdwnTipoDomicilio, "Postal producción");
		this.wh.clickOnWebElement(this.radioDireccionIgualFiscal);  // Click radio button "Igual a la fiscal".
		this.wh.clickOnWebElement(this.btnAceptarDireccionPostal);
		this.wh.exitFromFrame();
		logger.debug("END - addDireccionPostalProduccion");
	}

	public void addDireccionPostalRecibos() throws IOException
	{
		logger.debug("BEGIN - addDireccionPostalRecibos");
		this.wh.clickOnWebElementInFrame(this.anyadirNuevaDireccion, this.mainFrame);
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.selectValueInDropDown(this.drpdwnTipoDomicilio, "Postal recibos");
		this.wh.clickOnWebElement(this.radioDireccionIgualFiscal);  // Click radio button "Igual a la fiscal".
		this.wh.clickOnWebElement(this.btnAceptarDireccionPostal);
		this.wh.exitFromFrame();
		logger.debug("END - addDireccionPostalRecibos");
	}

	public void addDireccionPostalSiniestros() throws IOException
	{
		logger.debug("BEGIN - addDireccionPostalSiniestros");
		this.wh.clickOnWebElementInFrame(this.anyadirNuevaDireccion, this.mainFrame);
		this.wh.switchToFrame(this.mainFrame);
		this.wh.switchToFrame(this.modalFrame);
		this.wh.selectValueInDropDown(this.drpdwnTipoDomicilio, "Postal siniestros");
		this.wh.clickOnWebElement(this.radioDireccionIgualFiscal);  // Click radio button "Igual a la fiscal".
		this.wh.clickOnWebElement(this.btnAceptarDireccionPostal);
		this.wh.exitFromFrame();
		logger.debug("END - addDireccionPostalSiniestros");
	}

	public void addCompaniasPrincipales() throws IOException
	{
		logger.debug("BEGIN - addCompaniasPrincipales");
		this.wh.sendValueToWebElementInFrame(this.companiasPrincipales, this.mainFrame, "Texto de las compañías principales");
		logger.debug("END - addCompaniasPrincipales");
	}

	public void writeCuentaBancaria() throws IOException
	{
		logger.debug("BEGIN - writeCuentaBancaria");
		this.wh.sendValueToWebElementInFrame(this.txtCodigoIban, this.mainFrame, "ES03");
		this.wh.sendValueToWebElementInFrame(this.txtBanco, this.mainFrame, "2100");
		this.wh.sendValueToWebElementInFrame(this.txtSucursal, this.mainFrame, "1234");
		this.wh.sendValueToWebElementInFrame(this.txtDc, this.mainFrame, "5612");
		this.wh.sendValueToWebElementInFrame(this.txtCta1, this.mainFrame, "3456");
		this.wh.sendValueToWebElementInFrame(this.txtCta2, this.mainFrame, "7890");
		logger.debug("BEGIN - writeCuentaBancaria");
	}

	// endregion
}
