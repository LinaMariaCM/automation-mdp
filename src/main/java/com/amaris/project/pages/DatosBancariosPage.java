package com.amaris.project.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DatosBancariosPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	// @FindBy(id = "mainFrame")
	private By cuerpoFrame = By.cssSelector("cuerpo");

	// @FindBy(name = "iban_0")
	private By txtIban0 = By.name("iban_0");

	// @FindBy(name = "iban_1")
	private By txtIban1 = By.name("iban_1");

	// @FindBy(name = "iban_2")
	private By txtIban2 = By.name("iban_2");

	// @FindBy(name = "iban_3")
	private By txtIban3 = By.name("iban_3");

	// @FindBy(name = "iban_4")
	private By txtIban4 = By.name("iban_4");

	// @FindBy(name = "iban_5")
	private By txtIban5 = By.name("iban_5");

	// @FindBy(xpath = ".//*[text()='MUTUA DE PROPIETARIOS integrará los datos
	// de carácter personal facilitados por el mediador en ficheros de su
	// responsabilidad de acuerdo a las ']/../../label/input")
	// private WebElement chkMutuaPropietariosIntegrara;

	// @FindBy(id = "lopd")
	private By chkMutuaPropietariosIntegrara = By.cssSelector("lopd");

	// @FindBy(xpath = ".//*[contains(text(),'Guardar')]")
	private By btnGuardar = By.xpath(".//*[contains(text(),'Guardar')]");

	// @FindBy(css = "#modalPeritacion > div > div > div.modal-footer > div >
	// button.btn.btn-primary.ng-binding")
	private By btnGuardarPeritaje = By.cssSelector("#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding");

	// @FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and
	// contains(text(),'se ha guardado.')]")
	private By txtProjectNumber = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");

	// @FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and
	// contains(text(),'se ha guardado.')]")
	private By txtCodigoProjecto = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");

	// @FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and
	// contains(text(),'se ha
	// guardado.')]/../../../../div[@class='modal-footer']/button")
	private By btnAceptarInDialog = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");

	// @FindBy(name = "medioPago")
	private By cmbMedioPago = By.name("medioPago");

	// @FindBy(xpath = ".//*[text()='Contratar']")
	// "and @ng-click='db.nextStep(formDatosBancarios)']")
	private By btnContratar = By.xpath(".//*[text()='Contratar']");

	// @FindBy(xpath = ".//*[text()='Solicitar peritación']")
	// @FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope >
	// div:nth-child(6) > footer > div > button:nth-child(6)")
	private By btnSolicitarPeritacion = By.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > div:nth-child(6) > footer > div > button:nth-child(6)");

	// @FindBy(xpath = ".//*[contains(text(),'La póliza') and
	// contains(text(),'ha sido dada de alta correctamente.')]")
	private By lblPolizaNumber = By.xpath(".//*[contains(text(),'La póliza') and contains(text(),'ha sido dada de alta correctamente.')]");

	// @FindBy(xpath = ".//*[text()='Emitir suplemento' and
	// @ng-click='db.contratar(formDatosBancarios)']")
	private By btnEmitirSuplemento = By.xpath(".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']");

	// @FindBy(css = "#modalPeritacion > div > div")
	private By frmSolicitudServicioTecnico = By.cssSelector("#modalPeritacion > div > div");

	// @FindBy(id = "tipoServicio")
	private By drpdwnTipoServicio = By.cssSelector("tipoServicio");

	// @FindBy(id = "persona")
	private By txtPersona = By.cssSelector("persona");

	// @FindBy(id = "rol")
	private By txtRol = By.cssSelector("rol");

	// @FindBy(id = "telefono")
	private By txtTelefono = By.cssSelector("telefono");

	// @FindBy(id = "email")
	private By txtEmail = By.cssSelector("email");

	// @FindBy(id = "direccion")
	private By drpdwnDireccion = By.cssSelector("direccion");

	// @FindBy(id = "escalera")
	private By txtEscalera = By.cssSelector("escalera");

	// @FindBy(id = "bloque")
	private By txtBloque = By.cssSelector("bloque");

	// @FindBy(id = "piso")
	private By txtPiso = By.cssSelector("piso");

	// @FindBy(id = "puerta")
	private By txtPuerta = By.cssSelector("puerta");

	// @FindBy(id = "observaciones")
	private By txtObservaciones = By.cssSelector("observaciones");

	// @FindBy(xpath =
	// "[@id='form1']/table/tbody/tr/td/span/font/strong/text()")
	// @FindBy(css = "#form1 > table > tbody > tr > td > span > font > strong")
	private By msgPeritacion = By.cssSelector("#form1 > table > tbody > tr > td > span > font > strong");

	// @FindBy(css="#modalPeritacion > div > div > div.modal-footer > div >
	// button.btn.btn-primary.ng-binding")
	// private WebElement btnGuardar;
	// endregion
	String nombreProyecto = "";

	public DatosBancariosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DatosBancariosPage introducirFormaPagoYPulsarGuardar() {
		this.FillPaymentMethod(getTestVar("MedioPago"));
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();

		return this;
	}

	public DatosBancariosPage introducirFormaPagoYPulsarContratar() {
		this.FillPaymentMethod(getTestVar("MedioPago"));
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage introducirFormaPagoYPulsarSolicitarPeritacion() {
		this.fillStaticIban();
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnSolicitarPeritacion();
		this.enterDataSolicitudServicioTecnico();
		// this.ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage modificarFormaPagoYPulsarGuardar() {
		this.FillPaymentMethod(getTestVar("CambioMedioPago"));
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();

		return this;
	}

	public DatosBancariosPage modificarFormaPagoYPulsarContratar() {
		this.FillPaymentMethod(getTestVar("CambioMedioPago"));
		this.ClickOnGuardar();
		this.GetProjectCodeNumberAndClickOnAceptarButton();
		this.AceptarCondicionesLegales();
		this.ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage ClickOnGuardar() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnGuardar, this.cuerpoFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		debugEnd();

		return this;
	}

	public String FillCuentaBancariaWIthValidRandomNumber() {
		debugBegin();
		// Iban iban = Iban.random(CountryCode.ES);
		String iban = getTestVar("IBAN");
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban.toString());
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		this.webDriver.appendTextInFrame(this.txtIban0, this.cuerpoFrame, ibanList[0]);
		this.webDriver.appendTextInFrame(this.txtIban1, this.cuerpoFrame, ibanList[1]);
		this.webDriver.appendTextInFrame(this.txtIban2, this.cuerpoFrame, ibanList[2]);
		this.webDriver.appendTextInFrame(this.txtIban3, this.cuerpoFrame, ibanList[3]);
		this.webDriver.appendTextInFrame(this.txtIban4, this.cuerpoFrame, ibanList[4]);
		this.webDriver.appendTextInFrame(this.txtIban5, this.cuerpoFrame, ibanList[5]);
		// this.wh.ClickOnWebElementInFrame(this.chkMutuaPropietariosIntegrara,
		// this.cuerpoFrame);

		debugEnd();

		return iban;
	}

	public String fillStaticIban() {
		debugBegin();
		String iban = "ES0321001234561234567890";
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban.toString());
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		this.webDriver.appendTextInFrame(this.txtIban0, this.cuerpoFrame, ibanList[0]);
		this.webDriver.appendTextInFrame(this.txtIban1, this.cuerpoFrame, ibanList[1]);
		this.webDriver.appendTextInFrame(this.txtIban2, this.cuerpoFrame, ibanList[2]);
		this.webDriver.appendTextInFrame(this.txtIban3, this.cuerpoFrame, ibanList[3]);
		this.webDriver.appendTextInFrame(this.txtIban4, this.cuerpoFrame, ibanList[4]);
		this.webDriver.appendTextInFrame(this.txtIban5, this.cuerpoFrame, ibanList[5]);
		// this.wh.ClickOnWebElementInFrame(this.chkMutuaPropietariosIntegrara,
		// this.cuerpoFrame);

		debugEnd();

		return iban;
	}

	public DatosBancariosPage FillPaymentMethod(String paymentMethod) {
		debugBegin();
		// String medioPago =
		// this.appendTextInFrame.getTextFromSelectInFrame(this.cmbMedioPago,
		// this.cuerpoFrame);
		// if (!medioPago.equals(paymentMethod))
		// {
		// medioPago = this.SelectMediadorAsPaymentMethod();
		// }
		// else
		// {
		// medioPago = this.FillCuentaBancariaWIthValidRandomNumber();
		// }

		switch(paymentMethod) {
			case "el mediador":
				this.SelectMediadorAsPaymentMethod();
				break;
			case "el cobro bancario":
				this.FillCuentaBancariaWIthValidRandomNumber();
				break;
		}

		debugEnd();

		return this;
	}

	public DatosBancariosPage GetProjectCodeNumberAndClickOnAceptarButton() {
		debugBegin();
		String projectNumberText = this.webDriver.getTextInFrame(this.txtCodigoProjecto, this.cuerpoFrame);
		String ProjectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();
		this.nombreProyecto = ProjectCode;
		this.webDriver.clickInFrame(this.btnAceptarInDialog, this.cuerpoFrame);
		// this.browserContext.getTestCaseData().setNoCotizacion(ProjectCode);
		setTestVar("CotizacionNum", ProjectCode);

		// DocumentacionPage documentacionPage = new
		// DocumentacionPage(this.browserContext);
		// documentacionPage.SubirFichero();

		debugEnd();

		return this;
	}

	public String getProjectNumber() {
		return this.nombreProyecto;
	}

	public DatosBancariosPage SelectMediadorAsPaymentMethod() {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbMedioPago, this.cuerpoFrame, "Mediador");
		debugEnd();

		return this;
	}

	public DatosBancariosPage AceptarCondicionesLegales() {
		debugBegin();
		this.webDriver.clickInFrame(this.chkMutuaPropietariosIntegrara, this.cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage ClickOnSolicitarPeritacion() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnSolicitarPeritacion, this.cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage enterDataSolicitudServicioTecnico() {
		debugBegin();
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdwnTipoServicio, this.cuerpoFrame, "Verificación de riesgo");
		this.webDriver.appendTextInFrame(this.txtPersona, this.cuerpoFrame, "Nombre Persona Contacto");
		this.webDriver.clickElementFromDropDownByTextInFrame(this.txtRol, this.cuerpoFrame, "Otros");
		this.webDriver.appendTextInFrame(this.txtTelefono, this.cuerpoFrame, "961111111");
		this.webDriver.appendTextInFrame(this.txtEmail, this.cuerpoFrame, "personacontacto@email.com");
		this.webDriver.clickElementFromDropDownByIndexInFrame(this.drpdwnDireccion, this.cuerpoFrame, 0);
		this.webDriver.appendTextInFrame(this.txtEscalera, this.cuerpoFrame, "1");
		this.webDriver.appendTextInFrame(this.txtBloque, this.cuerpoFrame, "2");
		this.webDriver.appendTextInFrame(this.txtPiso, this.cuerpoFrame, "3");
		this.webDriver.appendTextInFrame(this.txtPuerta, this.cuerpoFrame, "4");
		this.webDriver.appendTextInFrame(this.txtObservaciones, this.cuerpoFrame, "Unas observaciones para la persona de contacto del peritaje.");
		this.webDriver.clickInFrame(this.btnGuardarPeritaje, this.cuerpoFrame);
		// this.wh.exitFromFrame();
		String mensajePeritaje = this.webDriver.getTextInFrame(this.msgPeritacion, this.cuerpoFrame);
		debugInfo("Message peritacion: " + mensajePeritaje + ".\n");

		debugEnd();

		return this;
	}

	public String getMensajePeritaje() {
		String mensajePeritaje = this.webDriver.getTextInFrame(this.msgPeritacion, this.cuerpoFrame);

		return mensajePeritaje;
	}

	public DatosBancariosPage ClickOnContratarAndGetPolizaNumber() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnContratar, this.cuerpoFrame);
		// this.browserContext.getTestCaseData().setNumPoliza(this.GetPolizaNumber());
		setTestVar("PolizaNumber", this.GetPolizaNumber());
		debugEnd();

		return this;
	}

	public String GetPolizaNumber() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		String polizaNumber = this.webDriver.getText(this.lblPolizaNumber);
		Integer firstCharacter = polizaNumber.indexOf("/") + 1;
		Integer lastCharacter = polizaNumber.indexOf("ha") - 1;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPoliza = trimmedPolizaNumber;
		this.GuardarPolizaTxt(numPoliza);

		this.webDriver.exitFrame();
		debugEnd();
		return trimmedPolizaNumber;
	}

	public DatosBancariosPage ClickOnEmitirSuplemento() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.btnEmitirSuplemento);
		this.webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public DatosBancariosPage GuardarPolizaTxt(String cadenaTexto) {
		try {
			// String ruta = fileDownloadTempPath + "\\Polizas.txt";
			// String ruta =
			// this.browserContext.getTestCaseData().getFileDownloadTempPath() +
			// "\\Polizas.txt";
			//String ruta = getTestVar("fileDownloadTempPath");
			// File archivo = new File("C:\\MutuaPropietarios\\Polizas.txt");
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta, true), StandardCharsets.UTF_8));
			//bw.write(cadenaTexto + ";");
			//bw.close();
			
			writeFile(getTestVar("fileDownloadTempPath"), cadenaTexto + ";");
		} catch(Exception e) {}

		return this;
	}
	// endregion
}
