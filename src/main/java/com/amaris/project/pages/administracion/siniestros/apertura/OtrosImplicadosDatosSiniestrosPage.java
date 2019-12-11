package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class OtrosImplicadosDatosSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By btnGrabar = By.id("botonGrabar");
	private By comboTipologia = By.id("OTRIMPLI");
	private By comboRol = By.id("implicado_rol");

	private By txtNombre = By.id("nombre");
	private By txtApellido1 = By.id("apellido1");
	private By txtApellido2 = By.id("apellido2");
	private By comboTipoDocumento = By.id("tipodocu");
	private By txtNumeroDocumento = By.id("numedocu");
	private By txtTelefono1 = By.id("telefono1");
	private By txtTelefono2 = By.id("telefono2");
	private By comboSexo = By.id("sexocon");
	private By txtEmail = By.id("email");
	private By checkEmailNoDisponble = By.id("emailnodisp");

	private By comboTipoVia = By.id("tipovia");
	private By txtCalle = By.id("calle");
	private By txtNumero = By.id("numero");
	private By txtPiso = By.id("label37");
	private By txtPuerta = By.id("label380");
	private By txtCP = By.id("cp");
	private By txtPoblacion = By.id("poblacion");
	private By comboProvincia = By.id("provincia");

	private By txtIBAN = By.id("codIban");
	private By txtBanco = By.id("codBan");
	private By txtSucursal = By.id("codSuc");
	private By txtDC = By.id("codDig");
	private By txtNumCuenta = By.id("codCue");
	private By checkIbanNoDisponble = By.id("ibannodisp");

	private By comboCompania = By.id("companiaSOA");
	private By txtPoliza = By.id("numpoliza");
	private By txtRefContraria = By.id("referencia");
	private By txtCorreoE = By.id("correoElectronico");
	// endregion

	public OtrosImplicadosDatosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	// public SiniestrosOtrosImplicadosDatos introducirDatosPersonales(String tipologia, String rol, String nombre,
	// String apellido1, String apellido2, String tipoDocumento, String numDocumento, String telefono1,
	public OtrosImplicadosDatosSiniestrosPage introducirDatosPersonales(String rol, String nombre, String apellido1, String apellido2, String tipoDocumento, String numDocumento, String telefono1,
		String telefono2, String sexo, String email) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		// webDriver.clickElementFromDropDownByAttribute(comboTipologia, "value", tipologia);
		webDriver.clickElementFromDropDownByIndex(comboTipologia, 2);
		// webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);
		webDriver.waitWithDriver(8000);
		webDriver.clickElementFromDropDownByIndex(comboRol, 8);

		if(nombre != null && !nombre.isEmpty()) webDriver.setText(txtNombre, nombre);
		else webDriver.setText(txtNombre, "Nombre" + Integer.toString((int) (Math.random() * 100)));

		if(apellido1 != null && !apellido1.isEmpty()) webDriver.setText(txtApellido1, apellido1);
		else webDriver.setText(txtApellido1, "Nombre" + Integer.toString((int) (Math.random() * 100)));

		if(apellido2 != null && !apellido2.isEmpty()) webDriver.setText(txtApellido2, apellido2);
		else webDriver.setText(txtApellido2, "Nombre" + Integer.toString((int) (Math.random() * 100)));

		// webDriver.clickElementFromDropDownByAttribute(comboTipoDocumento, "value", tipoDocumento);
		webDriver.clickElementFromDropDownByIndex(comboTipoDocumento, 1);

		if(numDocumento != null && !numDocumento.isEmpty()) webDriver.setText(txtNumeroDocumento, numDocumento);
		else webDriver.setText(txtNumeroDocumento, DniGeneratorHelper.generateNif());

		if(telefono1 != null && !telefono1.isEmpty()) webDriver.setText(txtTelefono1, telefono1);
		else webDriver.setText(txtTelefono1, "961234567");

		if(telefono2 != null && !telefono2.isEmpty()) webDriver.setText(txtTelefono1, telefono2);
		else webDriver.setText(txtTelefono2, "961234567");

		// webDriver.clickElementFromDropDownByAttribute(comboSexo, "value", sexo);
		if(sexo != null && !sexo.isEmpty()) webDriver.clickElementFromDropDownByIndex(comboSexo, 1);

		if(email != null && email.isEmpty()) {
			webDriver.click(checkEmailNoDisponble);
		} else {
			if(email != null && email.isEmpty()) webDriver.setText(txtEmail, email);
			else webDriver.setText(txtEmail, "prueba@esto.es");
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage introducirDatosDireccion(String tipoVia, String calle, String numero, String piso, String puerta, String cp, String poblacion, String provincia, String IBAN,
		String banco,
		String sucursal, String DC, String nCuenta) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
		webDriver.setText(txtCalle, calle);
		webDriver.setText(txtNumero, numero);
		webDriver.setText(txtPiso, piso);
		webDriver.setText(txtPuerta, puerta);
		webDriver.setText(txtCP, cp);
		webDriver.setText(txtPoblacion, poblacion);
		webDriver.clickElementFromDropDownByAttribute(comboProvincia, "value", provincia);

		if(IBAN.isEmpty() || banco.isEmpty() || sucursal.isEmpty() || DC.isEmpty() || nCuenta.isEmpty()) {
			webDriver.click(checkIbanNoDisponble);
		} else {
			webDriver.setText(txtIBAN, IBAN);
			webDriver.setText(txtBanco, banco);
			webDriver.setText(txtSucursal, sucursal);
			webDriver.setText(txtDC, DC);
			webDriver.setText(txtNumCuenta, nCuenta);
		}

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage introducirDatosCompaniaPrivada(String compania, String poliza, String referenciaContra, String correoE) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttribute(comboCompania, "value", compania);
		webDriver.setText(txtPoliza, poliza);
		webDriver.setText(txtRefContraria, referenciaContra);
		webDriver.setText(txtCorreoE, correoE);

		debugEnd();

		return this;
	}

	public OtrosImplicadosDatosSiniestrosPage clickGrabar() {
		debugBegin();
		webDriver.click(btnGrabar);
		debugEnd();

		return this;
	}

}
