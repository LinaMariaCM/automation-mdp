package com.amaris.project.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DatosBancariosPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.cssSelector("cuerpo");

	private By txtIban0 = By.name("iban_0");
	private By txtIban1 = By.name("iban_1");
	private By txtIban2 = By.name("iban_2");
	private By txtIban3 = By.name("iban_3");
	private By txtIban4 = By.name("iban_4");
	private By txtIban5 = By.name("iban_5");

	// @FindBy(xpath = ".//*[text()='MUTUA DE PROPIETARIOS integrará los datos
	// de carácter personal facilitados por el mediador en ficheros de su
	// responsabilidad de acuerdo a las ']/../../label/input")
	// private WebElement chkMutuaPropietariosIntegrara;

	private By chkMutuaPropietariosIntegrara = By.cssSelector("#lopd");

	private By btnGuardar = By.xpath(".//*[contains(text(),'Guardar')]");
	private By btnGuardarPeritaje = By.cssSelector("#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding");
	private By txtCodigoProjecto = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");
	private By btnAceptarInDialog = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");

	private By cmbMedioPago = By.name("medioPago");

	// @FindBy(xpath = ".//*[text()='Contratar']") and @ng-click='db.nextStep(formDatosBancarios)']")
	private By btnContratar = By.xpath(".//*[text()='Contratar']");

	// @FindBy(xpath = ".//*[text()='Solicitar peritación']")
	private By btnSolicitarPeritacion = By.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > div:nth-child(6) > footer > div > button:nth-child(6)");

	private By lblPolizaNumber = By.xpath(".//*[contains(text(),'La póliza') and contains(text(),'ha sido dada de alta correctamente.')]");
	private By btnEmitirSuplemento = By.xpath(".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']");
	private By frmSolicitudServicioTecnico = By.cssSelector("#modalPeritacion > div > div");

	private By drpdwnTipoServicio = By.cssSelector("#tipoServicio");
	private By txtPersona = By.cssSelector("#persona");
	private By txtRol = By.cssSelector("#rol");
	private By txtTelefono = By.cssSelector("#telefono");
	private By txtEmail = By.cssSelector("#email");
	private By drpdwnDireccion = By.cssSelector("#direccion");
	private By txtEscalera = By.cssSelector("#escalera");
	private By txtBloque = By.cssSelector("#bloque");
	private By txtPiso = By.cssSelector("#piso");
	private By txtPuerta = By.cssSelector("#puerta");
	private By txtObservaciones = By.cssSelector("#observaciones");

	// @FindBy(xpath = "[@id='form1']/table/tbody/tr/td/span/font/strong/text()")
	private By msgPeritacion = By.cssSelector("#form1 > table > tbody > tr > td > span > font > strong");

	// @FindBy(css="#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding")
	// private WebElement btnGuardar;
	// endregion
	String nombreProyecto = "";

	public DatosBancariosPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DatosBancariosPage introducirFormaPagoYPulsarGuardar() {
		FillPaymentMethod(getTestVar(Constants.MEDIO_PAGO));
		ClickOnGuardar();
		GetProjectCodeNumberAndClickOnAceptarButton();

		return this;
	}

	public DatosBancariosPage introducirFormaPagoYPulsarContratar() {
		FillPaymentMethod(getTestVar(Constants.MEDIO_PAGO));
		ClickOnGuardar();
		GetProjectCodeNumberAndClickOnAceptarButton();
		AceptarCondicionesLegales();
		ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage introducirFormaPagoYPulsarSolicitarPeritacion() {
		fillStaticIban();
		ClickOnGuardar();
		GetProjectCodeNumberAndClickOnAceptarButton();
		AceptarCondicionesLegales();
		ClickOnSolicitarPeritacion();
		enterDataSolicitudServicioTecnico();
		// ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage modificarFormaPagoYPulsarGuardar() {
		FillPaymentMethod(getTestVar(Constants.CAMBIO_MEDIO_PAGO));
		ClickOnGuardar();
		GetProjectCodeNumberAndClickOnAceptarButton();

		return this;
	}

	public DatosBancariosPage modificarFormaPagoYPulsarContratar() {
		FillPaymentMethod(getTestVar(Constants.CAMBIO_MEDIO_PAGO));
		ClickOnGuardar();
		GetProjectCodeNumberAndClickOnAceptarButton();
		AceptarCondicionesLegales();
		ClickOnContratarAndGetPolizaNumber();

		return this;
	}

	public DatosBancariosPage ClickOnGuardar() {
		debugBegin();
		
		webDriver.clickInFrame(btnGuardar, cuerpoFrame);
		// webDriver.waitForPageLoadWithAngular();
		debugEnd();

		return this;
	}

	public String FillCuentaBancariaWIthValidRandomNumber() {
		debugBegin();
		// Iban iban = Iban.random(CountryCode.ES);
		String iban = getTestVar(Constants.IBAN);
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban);
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		webDriver.appendTextInFrame(txtIban0, cuerpoFrame, ibanList[0]);
		webDriver.appendTextInFrame(txtIban1, cuerpoFrame, ibanList[1]);
		webDriver.appendTextInFrame(txtIban2, cuerpoFrame, ibanList[2]);
		webDriver.appendTextInFrame(txtIban3, cuerpoFrame, ibanList[3]);
		webDriver.appendTextInFrame(txtIban4, cuerpoFrame, ibanList[4]);
		webDriver.appendTextInFrame(txtIban5, cuerpoFrame, ibanList[5]);
		// wh.ClickOnWebElementInFrame(chkMutuaPropietariosIntegrara,
		// cuerpoFrame);

		debugEnd();

		return iban;
	}

	public String fillStaticIban() {
		debugBegin();
		
		String iban = "ES0321001234561234567890";
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban);
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		webDriver.appendTextInFrame(txtIban0, cuerpoFrame, ibanList[0]);
		webDriver.appendTextInFrame(txtIban1, cuerpoFrame, ibanList[1]);
		webDriver.appendTextInFrame(txtIban2, cuerpoFrame, ibanList[2]);
		webDriver.appendTextInFrame(txtIban3, cuerpoFrame, ibanList[3]);
		webDriver.appendTextInFrame(txtIban4, cuerpoFrame, ibanList[4]);
		webDriver.appendTextInFrame(txtIban5, cuerpoFrame, ibanList[5]);
		// wh.ClickOnWebElementInFrame(chkMutuaPropietariosIntegrara,
		// cuerpoFrame);

		debugEnd();

		return iban;
	}

	public DatosBancariosPage FillPaymentMethod(String paymentMethod) {
		debugBegin();
		// String medioPago =
		// appendTextInFrame.getTextFromSelectInFrame(cmbMedioPago,
		// cuerpoFrame);
		// if (!medioPago.equals(paymentMethod))
		// {
		// medioPago = SelectMediadorAsPaymentMethod();
		// }
		// else
		// {
		// medioPago = FillCuentaBancariaWIthValidRandomNumber();
		// }

		switch(paymentMethod) {
			case "el mediador":
				SelectMediadorAsPaymentMethod();
				break;
			case "el cobro bancario":
				FillCuentaBancariaWIthValidRandomNumber();
				break;
		}

		debugEnd();

		return this;
	}

	public DatosBancariosPage GetProjectCodeNumberAndClickOnAceptarButton() {
		debugBegin();
		
		String projectNumberText = webDriver.getTextInFrame(txtCodigoProjecto, cuerpoFrame);
		String ProjectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();
		nombreProyecto = ProjectCode;
		webDriver.clickInFrame(btnAceptarInDialog, cuerpoFrame);
		// browserContext.getTestCaseData().setNoCotizacion(ProjectCode);
		setTestVar(Constants.NUM_COTIZACION, ProjectCode);

		// DocumentacionPage documentacionPage = new
		// DocumentacionPage(browserContext);
		// documentacionPage.SubirFichero();

		debugEnd();

		return this;
	}

	public String getProjectNumber() {
		return nombreProyecto;
	}

	public DatosBancariosPage SelectMediadorAsPaymentMethod() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(cmbMedioPago, cuerpoFrame, "Mediador");
		debugEnd();

		return this;
	}

	public DatosBancariosPage AceptarCondicionesLegales() {
		debugBegin();
		webDriver.clickInFrame(chkMutuaPropietariosIntegrara, cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage ClickOnSolicitarPeritacion() {
		debugBegin();
		webDriver.clickInFrame(btnSolicitarPeritacion, cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage enterDataSolicitudServicioTecnico() {
		debugBegin();
		// webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnTipoServicio, cuerpoFrame, "Verificación de riesgo");
		webDriver.appendTextInFrame(txtPersona, cuerpoFrame, "Nombre Persona Contacto");
		webDriver.clickElementFromDropDownByTextInFrame(txtRol, cuerpoFrame, "Otros");
		webDriver.appendTextInFrame(txtTelefono, cuerpoFrame, "961111111");
		webDriver.appendTextInFrame(txtEmail, cuerpoFrame, "personacontacto@email.com");
		webDriver.clickElementFromDropDownByIndexInFrame(drpdwnDireccion, cuerpoFrame, 0);
		webDriver.appendTextInFrame(txtEscalera, cuerpoFrame, "1");
		webDriver.appendTextInFrame(txtBloque, cuerpoFrame, "2");
		webDriver.appendTextInFrame(txtPiso, cuerpoFrame, "3");
		webDriver.appendTextInFrame(txtPuerta, cuerpoFrame, "4");
		webDriver.appendTextInFrame(txtObservaciones, cuerpoFrame, "Unas observaciones para la persona de contacto del peritaje.");
		webDriver.clickInFrame(btnGuardarPeritaje, cuerpoFrame);
		// wh.exitFromFrame();
		String mensajePeritaje = webDriver.getTextInFrame(msgPeritacion, cuerpoFrame);
		debugInfo("Message peritacion: " + mensajePeritaje + ".\n");

		debugEnd();

		return this;
	}

	public String getMensajePeritaje() {
		String mensajePeritaje = webDriver.getTextInFrame(msgPeritacion, cuerpoFrame);

		return mensajePeritaje;
	}

	public DatosBancariosPage ClickOnContratarAndGetPolizaNumber() {
		debugBegin();
		
		webDriver.clickInFrame(btnContratar, cuerpoFrame);
		setTestVar(Constants.NUM_POLIZA, GetPolizaNumber());
		
		debugEnd();

		return this;
	}

	public String GetPolizaNumber() {
		debugBegin();
		
		String polizaNumber = webDriver.getTextInFrame(lblPolizaNumber, cuerpoFrame);
		Integer firstCharacter = polizaNumber.indexOf('/') + 1;
		Integer lastCharacter = polizaNumber.indexOf("ha") - 1;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPoliza = trimmedPolizaNumber;
		
		GuardarPolizaTxt(numPoliza);
		
		debugEnd();
		
		return trimmedPolizaNumber;
	}

	public DatosBancariosPage ClickOnEmitirSuplemento() {
		debugBegin();
		
		webDriver.clickInFrame(btnEmitirSuplemento, cuerpoFrame);
		
		debugEnd();

		return this;
	}

	public DatosBancariosPage GuardarPolizaTxt(String cadenaTexto) {
		try {
			// String ruta = fileDownloadTempPath + "\\Polizas.txt";
			// String ruta =
			// browserContext.getTestCaseData().getFileDownloadTempPath() +
			// "\\Polizas.txt";
			//String ruta = getTestVar("fileDownloadTempPath");
			// File archivo = new File("C:\\MutuaPropietarios\\Polizas.txt");
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta, true), StandardCharsets.UTF_8));
			//bw.write(cadenaTexto + ";");
			//bw.close();
			
			writeFile(AutomationConstants.RESOURCES_FOLDER + "Polizas.txt", cadenaTexto + ";");
		} catch(Exception e) {}

		return this;
	}
	// endregion
}
