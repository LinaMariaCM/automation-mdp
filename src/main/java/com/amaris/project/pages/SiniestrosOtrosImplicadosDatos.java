package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class SiniestrosOtrosImplicadosDatos extends PageObject {

	// THE CONSTRUCTOR
	public SiniestrosOtrosImplicadosDatos(UserStory userS) {
		super(userS);
	}

	// REGION WEBELEMENT

	// #### FRAMES ####

	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	//
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	//
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	//
	private By btnGrabar = By.id("botonGrabar");
	//
	private By comboTipologia = By.id("OTRIMPLI");
	//
	private By comboRol = By.id("implicado_rol");
	//
	private By txtNombre = By.id("nombre");
	//
	private By txtApellido1 = By.id("apellido1");
	//
	private By txtApellido2 = By.id("apellido2");
	//
	private By comboTipoDocumento = By.id("tipodocu");
	//
	private By txtNumeroDocumento = By.id("numedocu");
	//
	private By txtTelefono1 = By.id("telefono1");
	//
	private By txtTelefono2 = By.id("telefono2");
	//
	private By comboSexo = By.id("sexocon");
	//
	private By txtEmail = By.id("email");
	//
	private By checkEmailNoDisponble = By.id("emailnodisp");
	//
	private By comboTipoVia = By.id("tipovia");
	//
	private By txtCalle = By.id("calle");
	//
	private By txtNumero = By.id("numero");
	//
	private By txtPiso = By.id("label37");
	//
	private By txtPuerta = By.id("label380");
	//
	private By txtCP = By.id("cp");
	//
	private By txtPoblacion = By.id("poblacion");
	//
	private By comboProvincia = By.id("provincia");
	//
	private By txtIBAN = By.id("codIban");
	//
	private By txtBanco = By.id("codBan");
	//
	private By txtSucursal = By.id("codSuc");
	//
	private By txtDC = By.id("codDig");
	//
	private By txtNumCuenta = By.id("codCue");
	//
	private By checkIbanNoDisponble = By.id("ibannodisp");
	//
	private By comboCompania = By.id("companiaSOA");
	//
	private By txtPoliza = By.id("numpoliza");
	//
	private By txtRefContraria = By.id("referencia");
	//
	private By txtCorreoE = By.id("correoElectronico");

	// end region

	// REGION METHODS

	public void introducirDatosPersonales(String tipologia, String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String numDocumento, String telefono1,
		String telefono2, String sexo, String email) {
		this.debugBegin();

		//this.webDriver.clickElementFromDropDownByAttribute(comboTipologia, "value", tipologia);
		this.webDriver.clickElementFromDropDownByIndex(comboTipologia, 2);
		//this.webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);
		this.webDriver.clickElementFromDropDownByIndex(comboRol, 8);
		this.webDriver.setText(txtNombre, nombre);
		this.webDriver.setText(txtApellido1, apellido1);
		this.webDriver.setText(txtApellido2, apellido2);
		//this.webDriver.clickElementFromDropDownByAttribute(comboTipoDocumento, "value", tipoDocumento);
		this.webDriver.clickElementFromDropDownByIndex(comboTipoDocumento, 1);
		this.webDriver.setText(txtNumeroDocumento, numDocumento);
		this.webDriver.setText(txtTelefono1, telefono1);
		this.webDriver.setText(txtTelefono2, telefono2);
		//this.webDriver.clickElementFromDropDownByAttribute(comboSexo, "value", sexo);
		this.webDriver.clickElementFromDropDownByIndex(comboSexo, 1);
		if(email == "") this.webDriver.click(checkEmailNoDisponble);
		else this.webDriver.setText(txtEmail, email);

		this.debugEnd();
	}

	public void introducirDatosDireccion(String tipoVia, String calle, String numero, String piso, String puerta, String cp, String poblacion, String provincia, String IBAN, String banco,
		String sucursal, String DC, String nCuenta) {
		this.debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
		this.webDriver.setText(txtCalle, calle);
		this.webDriver.setText(txtNumero, numero);
		this.webDriver.setText(txtPiso, piso);
		this.webDriver.setText(txtPuerta, puerta);
		this.webDriver.setText(txtCP, cp);
		this.webDriver.setText(txtPoblacion, poblacion);
		this.webDriver.clickElementFromDropDownByAttribute(comboProvincia, "value", provincia);
		if(IBAN == "" || banco == "" || sucursal == "" || DC == "" || nCuenta == "") this.webDriver.click(checkIbanNoDisponble);
		else {
			this.webDriver.setText(txtIBAN, IBAN);
			this.webDriver.setText(txtBanco, banco);
			this.webDriver.setText(txtSucursal, sucursal);
			this.webDriver.setText(txtDC, DC);
			this.webDriver.setText(txtNumCuenta, nCuenta);
		}

		this.debugEnd();
	}

	public void introducirDatosCompaniaPrivada(String compania, String poliza, String referenciaContra, String correoE) {
		this.debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(comboCompania, "value", compania);
		this.webDriver.setText(txtPoliza, poliza);
		this.webDriver.setText(txtRefContraria, referenciaContra);
		this.webDriver.setText(txtCorreoE, correoE);

		this.debugEnd();
	}

	public void clickGrabar() {
		this.debugBegin();
		this.webDriver.click(this.btnGrabar);
		this.debugEnd();
	}

}
