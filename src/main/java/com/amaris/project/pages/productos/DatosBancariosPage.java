package com.amaris.project.pages.productos;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class DatosBancariosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("cuerpo");

	private By iban0Input = By.name("iban_0");
	private By iban1Input = By.name("iban_1");
	private By iban2Input = By.name("iban_2");
	private By iban3Input = By.name("iban_3");
	private By iban4Input = By.name("iban_4");
	private By iban5Input = By.name("iban_5");

	private By mutuaPropietariosIntegraraBtn = By.cssSelector("#lopd");

	private By guardarBtn = By.xpath(".//*[contains(text(),'Guardar')]");
	private By guardarPeritajeBtn = By.cssSelector("#modalPeritacion > div > div > div.modal-footer > div > button.btn.btn-primary.ng-binding");
	private By codigoProjectoTxt = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");
	private By aceptarInDialogBtn = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");

	private By medioPagoDrpDwn = By.name("medioPago");

	private By contratarBtn = By.xpath(".//*[text()='Contratar']");

	private By solicitarPeritacionBtn = By.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > div:nth-child(6) > footer > div > button:nth-child(6)");

	private By polizaNumberInput = By.xpath(".//*[contains(text(),'La póliza') and contains(text(),'ha sido dada de alta correctamente.')]");
	private By emitirSuplementoBtn = By.xpath(".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']");

	private By tipoServicioDrpDwn = By.cssSelector("#tipoServicio");
	private By personaInput = By.cssSelector("#persona");
	private By rolInput = By.cssSelector("#rol");
	private By telefonoInput = By.cssSelector("#telefono");
	private By emailInput = By.cssSelector("#email");
	private By direccionDrpDwn = By.cssSelector("#direccion");
	private By escaleraInput = By.cssSelector("#escalera");
	private By bloqueInput = By.cssSelector("#bloque");
	private By pisoInput = By.cssSelector("#piso");
	private By puertaInput = By.cssSelector("#puerta");
	private By observacionesInput = By.cssSelector("#observaciones");

	private By msgPeritacionTxt = By.cssSelector("#form1 > table > tbody > tr > td > span > font > strong");
	// endregion

	public DatosBancariosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public DatosBancariosPage clickGuardar() {
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public String fillCuentaBancariaWithValidRandomNumber() {
		debugBegin();

		String iban = getTestVar(Constants.IBAN);
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban);
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		webDriver.appendTextInFrame(iban0Input, cuerpoFrame, ibanList[0]);
		webDriver.appendTextInFrame(iban1Input, cuerpoFrame, ibanList[1]);
		webDriver.appendTextInFrame(iban2Input, cuerpoFrame, ibanList[2]);
		webDriver.appendTextInFrame(iban3Input, cuerpoFrame, ibanList[3]);
		webDriver.appendTextInFrame(iban4Input, cuerpoFrame, ibanList[4]);
		webDriver.appendTextInFrame(iban5Input, cuerpoFrame, ibanList[5]);

		debugEnd();

		return iban;
	}

	public String fillStaticIban() {
		debugBegin();

		String iban = "ES0321001234561234567890";
		Iterable<String> ibanIterator = Splitter.fixedLength(4).split(iban);
		String[] ibanList = Iterables.toArray(ibanIterator, String.class);

		webDriver.appendTextInFrame(iban0Input, cuerpoFrame, ibanList[0]);
		webDriver.appendTextInFrame(iban1Input, cuerpoFrame, ibanList[1]);
		webDriver.appendTextInFrame(iban2Input, cuerpoFrame, ibanList[2]);
		webDriver.appendTextInFrame(iban3Input, cuerpoFrame, ibanList[3]);
		webDriver.appendTextInFrame(iban4Input, cuerpoFrame, ibanList[4]);
		webDriver.appendTextInFrame(iban5Input, cuerpoFrame, ibanList[5]);

		debugEnd();

		return iban;
	}

	public DatosBancariosPage fillPaymentMethod(String paymentMethod) {
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
				selectMediadorAsPaymentMethod();
				break;
			case "el cobro bancario":
				fillCuentaBancariaWithValidRandomNumber();
				break;
		}

		debugEnd();

		return this;
	}

	public DatosBancariosPage getProjectCodeNumberAndClickOnAceptarButton() {
		debugBegin();

		String projectNumberText = webDriver.getTextInFrame(codigoProjectoTxt, cuerpoFrame);
		String projectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();

		setTestVar(Constants.NUMERO_PROYECTO, projectCode);

		webDriver.clickInFrame(aceptarInDialogBtn, cuerpoFrame);

		setTestVar(Constants.NUM_COTIZACION, projectCode);

		// DocumentacionPage documentacionPage = new
		// DocumentacionPage(browserContext);
		// documentacionPage.subirFichero();

		debugEnd();

		return this;
	}

	public DatosBancariosPage selectMediadorAsPaymentMethod() {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(medioPagoDrpDwn, cuerpoFrame, "Mediador");
		debugEnd();

		return this;
	}

	public DatosBancariosPage aceptarCondicionesLegales() {
		debugBegin();
		webDriver.clickInFrame(mutuaPropietariosIntegraraBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage clickSolicitarPeritacion() {
		debugBegin();
		webDriver.clickInFrame(solicitarPeritacionBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public DatosBancariosPage enterDataSolicitudServicioTecnico() {
		debugBegin();

		webDriver.clickElementFromDropDownByTextInFrame(tipoServicioDrpDwn, cuerpoFrame, "Verificación de riesgo");

		webDriver.appendTextInFrame(personaInput, cuerpoFrame, "Nombre Persona Contacto");

		webDriver.clickElementFromDropDownByTextInFrame(rolInput, cuerpoFrame, "Otros");

		webDriver.appendTextInFrame(telefonoInput, cuerpoFrame, "961111111");
		webDriver.appendTextInFrame(emailInput, cuerpoFrame, "personacontacto@email.com");

		webDriver.clickElementFromDropDownByIndexInFrame(direccionDrpDwn, cuerpoFrame, 0);

		webDriver.appendTextInFrame(escaleraInput, cuerpoFrame, "1");
		webDriver.appendTextInFrame(bloqueInput, cuerpoFrame, "2");
		webDriver.appendTextInFrame(pisoInput, cuerpoFrame, "3");
		webDriver.appendTextInFrame(puertaInput, cuerpoFrame, "4");
		webDriver.appendTextInFrame(observacionesInput, cuerpoFrame, "Unas observaciones para la persona de contacto del peritaje.");

		webDriver.clickInFrame(guardarPeritajeBtn, cuerpoFrame);

		debugInfo("Message peritacion: " + getMensajePeritaje() + ".\n");

		debugEnd();

		return this;
	}

	public String getMensajePeritaje() {
		debugBegin();
		String mensajePeritaje = webDriver.getTextInFrame(msgPeritacionTxt, cuerpoFrame);
		debugEnd();

		return mensajePeritaje;
	}

	public DatosBancariosPage clickContratarAndGetPolizaNumber() {
		debugBegin();

		webDriver.clickInFrame(contratarBtn, cuerpoFrame);
		setTestVar(Constants.NUM_POLIZA, getPolizaNumber());

		debugEnd();

		return this;
	}

	public String getPolizaNumber() {
		debugBegin();

		String polizaNumber = webDriver.getTextInFrame(polizaNumberInput, cuerpoFrame);
		int firstCharacter = polizaNumber.indexOf('/') + 1;
		int lastCharacter = polizaNumber.indexOf("ha") - 1;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPoliza = trimmedPolizaNumber;

		guardarPolizaTxt(numPoliza);

		debugEnd();

		return trimmedPolizaNumber;
	}

	public DatosBancariosPage clickEmitirSuplemento() {
		debugBegin();

		webDriver.clickInFrame(emitirSuplementoBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public DatosBancariosPage guardarPolizaTxt(String cadenaTexto) {
		try {
			appendToFile(AutomationConstants.RESOURCES_FOLDER + "Polizas.txt", cadenaTexto + ";");
		} catch(Exception e) {
			debugError("Error creando el fichero Polizas.txt");
		}

		return this;
	}
	// endregion
}
