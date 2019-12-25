package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ImplicadoAseguradoSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");
	private By modalFrame = By.id("capaIframe");
	private By anotacionesBtn = By.cssSelector("#enlaceDialogo > span");
	private By anotacionesNuevoBtn = By.cssSelector("[data-target='capaApunteDialogo0'] > span");

	// #### DATOS DEL ASEGURADO ####
	private By seleccionAseguradoDrpDwn = By.id("seleccionAsegurado");
	private By comboSeleccionAseguradoElemento = By.cssSelector("#seleccionAsegurado > option");
	private By txtNombreAsegurado = By.id("nombre");
	private By txtApellido1Asegurado = By.id("apellido1");
	private By txtApellido2Asegurado = By.id("apellido2");
	private By comboTipoDocumento = By.id("tipodocu");
	private By txtNumeroDocumento = By.id("numedocu");

	private By telefono1Input = By.id("telefono1");
	private By txtTelefono2 = By.id("telefono2");
	private By comboSexo = By.id("sexocon");
	private By txtEmail = By.id("email");

	private By comboTipoVia = By.id("implicado_tipodvia");
	private By txtCalle = By.id("implicado_nomcalle");
	private By txtNumero = By.id("numero");
	private By txtPiso = By.id("label37");
	private By txtPuerta = By.id("label380");
	private By txtCP = By.id("cp");
	private By txtPoblacion = By.id("poblacion");
	private By comboProvincia = By.id("provincia");

	private By txtIBAN = By.cssSelector("#datosAsegurado > div.sis-frame-bg > div:nth-child(26) > div.box-field.flexibleField > input");
	private By txtBanco = By.cssSelector("#datosAsegurado > div.sis-frame-bg > div:nth-child(27) > div.box-field.flexibleField > input");
	private By txtSucursal = By.cssSelector("#datosAsegurado > div.sis-frame-bg > div:nth-child(28) > div.box-field.flexibleField > input");
	private By txtDC = By.cssSelector("#datosAsegurado > div.sis-frame-bg > div:nth-child(29) > div.box-field.flexibleField > input");
	private By txtNumeroCuenta = By.cssSelector("#datosAsegurado > div.sis-frame-bg > div:nth-child(30) > div.box-field.flexibleField > input");
	private By guardarSalirBtn = By.id("botonGuardar");
	private By aperturaSiniestroBtn = By.cssSelector("#formDatos #botonera #botonContinuar");
	private By validarYContinuarBtn = By.id("botonContinuar");
	private By continuarBtn = By.id("botonContinuar");
	private By grabarAnotacionBtn = By.id("botonContinuar2");
	private By cerrarAnotacionesBtn = By.id("botonCancelar");

	private By tituloAnotacionInput = By.id("titulo");
	private By clausulaEspecialInput = By.cssSelector(".grid.wideBox tr:nth-child(2) > td:nth-child(2)");
	// endregion

	public ImplicadoAseguradoSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ImplicadoAseguradoSiniestrosPage aperturaSinietro() {
		debugBegin();
		webDriver.clickInFrame(aperturaSiniestroBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();

		return this;
	}

	public ImplicadoAseguradoSiniestrosPage clickApertura() {
		debugBegin();

		// webDriver.waitWithDriver(6000);
		// if(webDriver.isPresentInFrame(btnValidarYContinuar, cuerpoFrame)) {
		// webDriver.clickInFrame(btnValidarYContinuar, cuerpoFrame);
		// System.out.println("Validamos cosas");
		// }

		debugInfo("Texto boton: " + webDriver.getTextInFrame(aperturaSiniestroBtn, cuerpoFrame));
		webDriver.waitWithDriver(3000);

		webDriver.clickInFrame(aperturaSiniestroBtn, cuerpoFrame);

		webDriver.waitWithDriver(5000);

		debugEnd();

		return this;
	}

	public ImplicadoAseguradoSiniestrosPage seleccionarImplicado() {
		debugBegin();
		
		//debugInfo("Seleccionamos implicado: " + webDriver.getElementChildByIndexInFrame(seleccionAseguradoDrpDwn, cuerpoFrame, 1).getText());
		webDriver.clickElementChildByIndexInFrame(seleccionAseguradoDrpDwn, cuerpoFrame, 1);

		if((!webDriver.getTextInFrame(telefono1Input, cuerpoFrame).startsWith("(") || !webDriver.getTextInFrame(telefono1Input, cuerpoFrame).startsWith("+") 
			|| webDriver.getTextInFrame(telefono1Input, cuerpoFrame).length() < 9)) {
			debugInfo("Número de teléfono 1 mal puesto: " + webDriver.getTextInFrame(telefono1Input, cuerpoFrame));
			webDriver.setTextInFrame(telefono1Input, cuerpoFrame, "961234567");
			debugInfo("Se sustituye por: 961234567");
		}

		debugEnd();

		return this;
	}

	public ImplicadoAseguradoSiniestrosPage continuar() {
		debugBegin();

		String numeroBien = "";
		
		if(webDriver.getText(telefono1Input).startsWith("+")) {
			numeroBien = webDriver.getText(telefono1Input).substring(3);

			webDriver.setText(telefono1Input, numeroBien);
		}

		webDriver.clickInFrame(validarYContinuarBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();

		return this;
	}

	//------------------------RETENCIONES-------------------------------------------
	public ImplicadoAseguradoSiniestrosPage capturaDatosSiniestro() {
		debugBegin();

		String textoClausulaEspecial = webDriver.getTextInFrame(By.xpath("//*[contains(text(), '" + Constants.ALERTA_POLIZA_CLAUSULAS_ESPECIALES + "')]"), cuerpoFrame).trim();

		boolean checkAvisoHaceTresMeses = textoClausulaEspecial.equalsIgnoreCase(Constants.ALERTA_POLIZA_CLAUSULAS_ESPECIALES);

		debugInfo("Mensaje esperado: " + Constants.ALERTA_POLIZA_CLAUSULAS_ESPECIALES);
		debugInfo("Mensaje real: " + textoClausulaEspecial);

		Assert.assertTrue(checkAvisoHaceTresMeses, "COMPARAR CAMPOS : alerta NO se muestra");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ImplicadoAseguradoSiniestrosPage anotacionesImplicadoTituloFalloVacio() {
		debugBegin();

		webDriver.clickInFrame(anotacionesBtn, cuerpoFrame);
		
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitWithDriver(5000);
		
		webDriver.click(anotacionesNuevoBtn);
		webDriver.click(grabarAnotacionBtn);
		
		webDriver.exitFrame();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TITULO_ANOTACION);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public ImplicadoAseguradoSiniestrosPage escribirAnotacionesImplicado() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(tituloAnotacionInput, "Esto es una anotación.");
		webDriver.click(grabarAnotacionBtn);
		webDriver.waitWithDriver(3000);
		webDriver.click(cerrarAnotacionesBtn);
		webDriver.exitFrame();
		
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// endregion
}
