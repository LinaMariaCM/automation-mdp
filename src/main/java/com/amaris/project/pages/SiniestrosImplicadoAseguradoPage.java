package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class SiniestrosImplicadoAseguradoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By comboSeleccionAsegurado = By.id("seleccionAsegurado");
	private By txtNombreAsegurado = By.id("nombre");
	private By txtApellido1Asegurado = By.id("apellido1");
	private By txtApellido2Asegurado = By.id("apellido2");
	private By comboTipoDocumento = By.id("tipodocu");
	private By txtNumeroDocumento = By.id("numedocu");

	private By txtTelefono1 = By.id("telefono1");
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
	private By txtBanco = By.id("#datosAsegurado > div.sis-frame-bg > div:nth-child(27) > div.box-field.flexibleField > input");
	private By txtSucursal = By.id("#datosAsegurado > div.sis-frame-bg > div:nth-child(28) > div.box-field.flexibleField > input");
	private By txtDC = By.id("#datosAsegurado > div.sis-frame-bg > div:nth-child(29) > div.box-field.flexibleField > input");
	private By txtNumeroCuenta = By.id("#datosAsegurado > div.sis-frame-bg > div:nth-child(30) > div.box-field.flexibleField > input");
	private By btnGuardarSalir = By.id("botonGuardar");
	private By btnAperturaSiniestro = By.id("botonContinuar");
	// endregion

	public SiniestrosImplicadoAseguradoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public SiniestrosImplicadoAseguradoPage aperturaSinietro() {
		debugBegin();
		webDriver.clickInFrame(btnAperturaSiniestro, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();
		
		return this;
	}

	public SiniestrosImplicadoAseguradoPage clickApertura() {
		debugBegin();

		webDriver.clickInFrame(btnAperturaSiniestro, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();
		
		return this;
	}
	// endregion
}
