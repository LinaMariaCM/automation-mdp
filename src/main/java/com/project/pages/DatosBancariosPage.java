package com.project.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DatosBancariosPage
{
	final static Logger logger = LoggerFactory.getLogger(DatosBancariosPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	// @FindBy(name = "cuerpo")
	@FindBy(id = "mainFrame")
	private WebElement cuerpoFrame;

	@FindBy(name = "iban_0")
	private WebElement txtIban0;

	@FindBy(name = "iban_1")
	private WebElement txtIban1;

	@FindBy(name = "iban_2")
	private WebElement txtIban2;

	@FindBy(name = "iban_3")
	private WebElement txtIban3;

	@FindBy(name = "iban_4")
	private WebElement txtIban4;

	@FindBy(name = "iban_5")
	private WebElement txtIban5;

	// @FindBy(xpath = ".//*[text()='MUTUA DE PROPIETARIOS integrará los datos de carácter personal facilitados por el mediador en ficheros de su
	// responsabilidad de acuerdo a las ']/../../label/input")
	// private WebElement chkMutuaPropietariosIntegrara;
	
	@FindBy(id = "lopd")
	private WebElement chkMutuaPropietariosIntegrara;

	@FindBy(xpath = ".//*[contains(text(),'Guardar')]")
	private WebElement btnGuardar;

	@FindBy(css = "#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding")
	private WebElement btnGuardarPeritaje;

	@FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]")
	private WebElement txtProjectNumber;

	@FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]")
	private WebElement txtCodigoProjecto;

	@FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button")
	private WebElement btnAceptarInDialog;

	@FindBy(name = "medioPago")
	private WebElement cmbMedioPago;

	@FindBy(xpath = ".//*[text()='Contratar']")
	// "and @ng-click='db.nextStep(formDatosBancarios)']")
	private WebElement btnContratar;

	// @FindBy(xpath = ".//*[text()='Solicitar peritación']")
	@FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope > div:nth-child(6) > footer > div > button:nth-child(6)")
	private WebElement btnSolicitarPeritacion;

	@FindBy(xpath = ".//*[contains(text(),'La póliza') and contains(text(),'ha sido dada de alta correctamente.')]")
	private WebElement lblPolizaNumber;

	@FindBy(xpath = ".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']")
	private WebElement btnEmitirSuplemento;

	@FindBy(css = "#modalPeritacion > div > div")
	private WebElement frmSolicitudServicioTecnico;

	@FindBy(id = "tipoServicio")
	private WebElement drpdwnTipoServicio;

	@FindBy(id = "persona")
	private WebElement txtPersona;

	@FindBy(id = "rol")
	private WebElement txtRol;

	@FindBy(id = "telefono")
	private WebElement txtTelefono;

	@FindBy(id = "email")
	private WebElement txtEmail;

	@FindBy(id = "direccion")
	private WebElement drpdwnDireccion;

	@FindBy(id = "escalera")
	private WebElement txtEscalera;

	@FindBy(id = "bloque")
	private WebElement txtBloque;

	@FindBy(id = "piso")
	private WebElement txtPiso;

	@FindBy(id = "puerta")
	private WebElement txtPuerta;

	@FindBy(id = "observaciones")
	private WebElement txtObservaciones;
	
	// @FindBy(xpath = "[@id='form1']/table/tbody/tr/td/span/font/strong/text()")
	@FindBy(css = "#form1 > table > tbody > tr > td > span > font > strong")
	private WebElement msgPeritacion;

	// @FindBy(css="#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding")
	// private WebElement btnGuardar;
	// endregion

	public DatosBancariosPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods

	public void introducirFormaPagoYPulsarGuardar()
	{
		this.FillPaymentMethod(this.browserContext.getTestCaseData().getMedioPago());
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
	}
	
	public void introducirFormaPagoYPulsarContratar()
	{
		this.FillPaymentMethod(this.browserContext.getTestCaseData().getMedioPago());
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnContratarAndGetPolizaNumber();
	}
	
	public void introducirFormaPagoYPulsarSolicitarPeritacion()
	{
		this.fillStaticIban();
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnSolicitarPeritacion();
		this.enterDataSolicitudServicioTecnico();
		// this.ClickOnContratarAndGetPolizaNumber();
	}
	
	public void modificarFormaPagoYPulsarGuardar()
	{
		this.FillPaymentMethod(this.browserContext.getTestCaseData().getCambioMedioPago());
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
	}

	public void modificarFormaPagoYPulsarContratar()
	{
		this.FillPaymentMethod(this.browserContext.getTestCaseData().getCambioMedioPago());
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnContratarAndGetPolizaNumber();
	}

	public void ClickOnGuardar()
	{
		logger.debug("BEGIN - ClickOnGuardar");
		this.browserContext.webElementHelper.clickOnWebElementInFrame(this.btnGuardar, this.cuerpoFrame);
		this.wh.waitForPageLoadWithAngular();
		logger.debug("END - ClickOnGuardar");
	}

	public String FillCuentaBancariaWIthValidRandomNumber()
	{
		logger.debug("BEGIN - FillCuentaBancariaWithValidRandomNumber");
		// Iban iban = Iban.random(CountryCode.ES);
		String iban = this.browserContext.getTestCaseData().getIban();
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban.toString());
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		this.wh.sendValueToWebElementInFrame(this.txtIban0, this.cuerpoFrame, ibanList[0]);
		this.wh.sendValueToWebElementInFrame(this.txtIban1, this.cuerpoFrame, ibanList[1]);
		this.wh.sendValueToWebElementInFrame(this.txtIban2, this.cuerpoFrame, ibanList[2]);
		this.wh.sendValueToWebElementInFrame(this.txtIban3, this.cuerpoFrame, ibanList[3]);
		this.wh.sendValueToWebElementInFrame(this.txtIban4, this.cuerpoFrame, ibanList[4]);
		this.wh.sendValueToWebElementInFrame(this.txtIban5, this.cuerpoFrame, ibanList[5]);
		// this.wh.ClickOnWebElementInFrame(this.chkMutuaPropietariosIntegrara, this.cuerpoFrame);

		logger.debug("END - FillCuentaBancariaWithValidRandomNumber");
		return iban;
	}
	
	public String fillStaticIban()
	{
		String iban = "ES0321001234561234567890";
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban.toString());
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		this.wh.sendValueToWebElementInFrame(this.txtIban0, this.cuerpoFrame, ibanList[0]);
		this.wh.sendValueToWebElementInFrame(this.txtIban1, this.cuerpoFrame, ibanList[1]);
		this.wh.sendValueToWebElementInFrame(this.txtIban2, this.cuerpoFrame, ibanList[2]);
		this.wh.sendValueToWebElementInFrame(this.txtIban3, this.cuerpoFrame, ibanList[3]);
		this.wh.sendValueToWebElementInFrame(this.txtIban4, this.cuerpoFrame, ibanList[4]);
		this.wh.sendValueToWebElementInFrame(this.txtIban5, this.cuerpoFrame, ibanList[5]);
		// this.wh.ClickOnWebElementInFrame(this.chkMutuaPropietariosIntegrara, this.cuerpoFrame);

		logger.debug("END - FillCuentaBancariaWithValidRandomNumber");
		return iban;

	}

	public void FillPaymentMethod(
			String paymentMethod)
	{
		logger.debug("BEGIN - FillPaymentMethod");
		// String medioPago = this.wh.getTextFromSelectInFrame(this.cmbMedioPago, this.cuerpoFrame);
		// if (!medioPago.equals(paymentMethod))
		// {
		// medioPago = this.SelectMediadorAsPaymentMethod();
		// }
		// else
		// {
		// medioPago = this.FillCuentaBancariaWIthValidRandomNumber();
		// }
		
		switch (paymentMethod)
		{
			case "el mediador":
				this.SelectMediadorAsPaymentMethod();
				break;
			case "el cobro bancario":
				this.FillCuentaBancariaWIthValidRandomNumber();
				break;
		}
		logger.debug("END - FillPaymentMethod");
		
	}

	String nombreProyecto = "";

	public void GetProjectCodeNumberAndClickOnAceptarButton()
	{
		logger.debug("BEGIN - GetProjectCodeNumberAndClickOnAceptarButton");
		String projectNumberText = this.wh.getTextFromWebElementInFrame(this.txtCodigoProjecto, this.cuerpoFrame);
		String ProjectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();
		this.nombreProyecto = ProjectCode;
		this.wh.clickOnWebElementInFrame(this.btnAceptarInDialog, this.cuerpoFrame);
		this.browserContext.getTestCaseData().setNoCotizacion(ProjectCode);

		// DocumentacionPage documentacionPage = new DocumentacionPage(this.browserContext);
		// documentacionPage.SubirFichero();

		logger.debug("END - GetProjectCodeNumberAndClickOnAceptarButton");
	}

	public String getProjectNumber()
	{
		return this.nombreProyecto;
	}
	
	public String SelectMediadorAsPaymentMethod()
	{
		logger.debug("BEGIN - SelectMediadorAsPaymentMethod");
		this.wh.selectValueInDropDownInFrame(this.cmbMedioPago, this.cuerpoFrame, "Mediador");
		logger.debug("END - SelectMediadorAsPaymentMethod");
		return null;
	}

	public void AceptarCondicionesLegales()
	{
		logger.debug("BEGIN - AceptarCondicionesLegales");
		this.wh.clickOnWebElementInFrame(this.chkMutuaPropietariosIntegrara, this.cuerpoFrame);
		logger.debug("END - AceptarCondicionesLegales");
	}

	public void ClickOnSolicitarPeritacion()
	{
		logger.debug("BEGIN - ClickOnSolicitarPeritacion");
		this.wh.clickOnWebElementInFrame(this.btnSolicitarPeritacion, this.cuerpoFrame);
		logger.debug("END - ClickOnSolicitarPeritacion");
	}

	public void enterDataSolicitudServicioTecnico()
	{
		logger.debug("BEGIN - enterDataSolicitudServicioTecnico");
		// this.wh.switchToFrame(this.cuerpoFrame);
		this.wh.selectValueInDropDownInFrame(this.drpdwnTipoServicio, this.cuerpoFrame, "Verificación de riesgo");
		this.wh.sendValueToWebElementInFrame(this.txtPersona, this.cuerpoFrame, "Nombre Persona Contacto");
		this.wh.selectValueInDropDownInFrame(this.txtRol, this.cuerpoFrame, "Otros");
		this.wh.sendValueToWebElementInFrame(this.txtTelefono, this.cuerpoFrame, "961111111");
		this.wh.sendValueToWebElementInFrame(this.txtEmail, this.cuerpoFrame, "personacontacto@email.com");
		this.wh.selectFirstValueInDropDownInFrame(this.drpdwnDireccion, this.cuerpoFrame);
		this.wh.sendValueToWebElementInFrame(this.txtEscalera, this.cuerpoFrame, "1");
		this.wh.sendValueToWebElementInFrame(this.txtBloque, this.cuerpoFrame, "2");
		this.wh.sendValueToWebElementInFrame(this.txtPiso, this.cuerpoFrame, "3");
		this.wh.sendValueToWebElementInFrame(this.txtPuerta, this.cuerpoFrame, "4");
		this.wh.sendValueToWebElementInFrame(this.txtObservaciones, this.cuerpoFrame, "Unas observaciones para la persona de contacto del peritaje.");
		this.wh.clickOnWebElementInFrame(this.btnGuardarPeritaje, this.cuerpoFrame);
		// this.wh.exitFromFrame();
		String mensajePeritaje = this.wh.getTextFromWebElementInFrame(this.msgPeritacion, this.cuerpoFrame);
		System.out.println("Message peritacion: " + mensajePeritaje + ".\n");
		
		logger.debug("END - enterDataSolicitudServicioTecnico");
	}

	public String getMensajePeritaje()
	{
		String mensajePeritaje = this.wh.getTextFromWebElementInFrame(this.msgPeritacion, this.cuerpoFrame);
		return mensajePeritaje;
	}
	
	public void ClickOnContratarAndGetPolizaNumber()
	{
		logger.debug("BEGIN - ClickOnContratar");
		this.wh.clickOnWebElementInFrameWithJavaScript(this.btnContratar, this.cuerpoFrame);
		this.browserContext.getTestCaseData().setNumPoliza(this.GetPolizaNumber());
		logger.debug("END - ClickOnContratar");
	}

	public String GetPolizaNumber()
	{
		logger.debug("BEGIN - GetPolizaNumber");
		this.wh.switchToFrame(this.cuerpoFrame);
		String polizaNumber = this.wh.getTextFromWebElement(this.lblPolizaNumber);
		Integer firstCharacter = polizaNumber.indexOf("/") + 1;
		Integer lastCharacter = polizaNumber.indexOf("ha") - 1;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPoliza = trimmedPolizaNumber;
		this.GuardarPolizaTxt(numPoliza);

		this.wh.exitFromFrame();
		logger.debug("END - GetPolizaNumber");
		return trimmedPolizaNumber;
	}

	public void ClickOnEmitirSuplemento()
	{
		logger.debug("BEGIN - ClickOnEmitirSuplemento");
		this.wh.switchToFrame(this.cuerpoFrame);
		this.wh.clickOnWebElement(this.btnEmitirSuplemento);
		this.wh.exitFromFrame();
		logger.debug("END - ClickOnEmitirSuplemento");
	}

	public void GuardarPolizaTxt(
			String cadenaTexto)
	{
		try
		{
			// String ruta = fileDownloadTempPath + "\\Polizas.txt";
			String ruta = this.browserContext.getTestCaseData().getFileDownloadTempPath() + "\\Polizas.txt";
			// File archivo = new File("C:\\MutuaPropietarios\\Polizas.txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta, true), StandardCharsets.UTF_8));
			bw.write(cadenaTexto + ";");
			bw.close();
		}
		catch (Exception e)
		{

		}
	}
	// endregion
}
