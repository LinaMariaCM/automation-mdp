package com.project.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

/*
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/
public class GestionOnlineAltaSiniestro extends PageObject {
	
	

	public GestionOnlineAltaSiniestro(UserStory userS) {
		super(userS);
	}


	// region webelements
	
	private By topFrame = By.cssSelector("#topFrame");

	private By leftFrame = By.cssSelector("#leftFrame");

    private By mainFrame = By.cssSelector("#mainFrame");

	private By contentFrame = By.cssSelector("#blockrandom");

	private By txtNumPoliza = By.id("numpol");
	
	private By txtFechaSiniestro = By.id("fsin");
	
	private By comboCausa = By.id("selcausa");
	
	private By checkAsistencia = By.id("Requiereasistencia");

	private By txtDescripcion = By.id("causa");
	
	private By txtCosteAprox = By.id("coste");

	private By checkCuentaIndemnizacion = By.id("indem_sin");
	
	private By checkCuentaRecibos = By.id("cobro_rec");

	private By checkNuevaCuenta = By.id("nueva_cuenta");
	
	private By comboPaisIban = By.id("pais_iban");

	private By txtSwiftBic = By.id("swift_iban");
	
	private By txtIban1 = By.id("iban1");
	
	private By txtIban2 = By.id("iban2");
	
	private By txtIban3 = By.id("iban3");
	
	private By txtIban4 = By.id("iban4");
	
	private By txtIban5 = By.id("iban5");
	
	private By txtIban6 = By.id("iban6");
		
	private By buttonConvertirCC = By.id("convert_from_cc");

	private By txtCC1 = By.id("cuenta1");
	
	private By txtCC2 = By.id("cuenta2");
	
	private By txtCC3 = By.id("cuenta3");
	
	private By txtCC4 = By.id("cuenta4");
	
	private By buttonAccionConvertir = By.id("convert_from_cc");

	private By comboRol = By.id("selrol_1");

	private By txtNombre = By.id("contnombre_1");

	private By txtApellido1 = By.id("contapellido1_1");

	private By txtApellido2 = By.id("contapellido2_1");

	private By txtTelefono = By.id("conttel_1");

	private By txtEmail = By.id("contmail_1");

	private By checkViveEnRiesgoSi = By.id("PersonasContactoSi");

	private By checkViveEnRiesgoNo = By.id("PersonasContactoNo");
	
	private By checkViveEnRiesgoNsNc = By.id("PersonasContactoNS");
	
	private By comboProvincia = By.cssSelector("#contprovi_1_normalizada_chosen > a > span");
	
	private By comboLocalidad = By.cssSelector("#contloca_1_normalizada_chosen > a > span");

	private By comboTipoVia = By.cssSelector("#conttipvia_1_normalizada_chosen > a > span");

	private By comboNombreVia = By.cssSelector("#contnomvia_1_normalizada_chosen > a > span");

	private By txtCodigoPostal = By.id("contcp_1_normalizada");

	private By txtNumeroVia = By.id("contnum_1_normalizada");

	private By txtPiso = By.id("contpis_1_normalizada");

	private By txtPuerta = By.id("contpta_1_normalizada");

	private By buttonMasContactos = By.id("contplus");

	private By buttonMenosContactos = By.id("contminus");

	private By txtObservaciones = By.id("observaciones");

	private By comboTipoDocumento = By.cssSelector("#seldoc_1");

	private By buttonSeleccionArchivo = By.cssSelector("adjdocu1");

	private By txtDescripcionDocu = By.cssSelector("descadjdocu_1");

	private By buttonBorrarAdjunto = By.cssSelector("deldocsel1");

	private By buttonEnviarSin = By.cssSelector("enviar");

	private By buttonImprimirSin = By.cssSelector("imprimir");

	private By buttonBorrarSin = By.cssSelector("borrar");
	
	private By modalOK = By.id("modalWindow");
	
	private By textoModalOK = By.cssSelector("#modalWindow > div.modal-body");
	
	

	// endregion



	// region methods
	
	
	public void altaInfoPoliza(String numpoliza, String Fecha){
		debugBegin();

        this.webDriver.setText(txtNumPoliza, numpoliza);  
        this.webDriver.setText(txtFechaSiniestro, Fecha);      
		
		debugEnd();
		
	}

	public void altaCausaDescripcion(String causa, String descripcion, String costeAprox){
		debugBegin();

        this.webDriver.clickElementFromDropDownByAttribute(comboCausa, "value", causa);
        this.webDriver.setText(txtDescripcion, descripcion);
        this.webDriver.setText(txtCosteAprox, costeAprox);
        
		
		debugEnd();
		
	}
	

	public void altaCuentaSiniestro(){
		debugBegin();

		if(this.webDriver.isClickable(checkCuentaIndemnizacion))this.webDriver.click(checkCuentaIndemnizacion);
		else if(this.webDriver.isClickable(checkCuentaRecibos))this.webDriver.click(checkCuentaRecibos);
		else {
			this.webDriver.click(checkNuevaCuenta);      
			this.webDriver.clickElementFromDropDownByAttribute(comboPaisIban, "value", "ES");
	        this.webDriver.setText(txtIban1, "ES21");
	        this.webDriver.setText(txtIban2, "2100");
	        this.webDriver.setText(txtIban3, "0001");
	        this.webDriver.setText(txtIban4, "0500");
	        this.webDriver.setText(txtIban5, "0000");
	        this.webDriver.setText(txtIban6, "0001");
		}
		
		debugEnd();
	}

	public void altaPersonaContacto(String rol, String nombre, String apellido1, String apellido2, String telefono, String email){
		
		debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(comboRol, "value", rol);
        this.webDriver.setText(txtNombre, nombre);
        this.webDriver.setText(txtApellido1, apellido1);
        this.webDriver.setText(txtApellido2, apellido2);
        this.webDriver.setText(txtTelefono, telefono);
        this.webDriver.setText(txtEmail, email);
		
		debugEnd();
	}

	public void altaDireccionContacto(Boolean asegurado, String tipoVia, String nombreVia, String numVia, String piso, String puerta, String localidad, String provincia, String cp){
		
		debugBegin();

		if(asegurado)this.webDriver.click(checkViveEnRiesgoSi); 
		else  //para este caso falta definir los valores correspondientes a la provincia y localidad. En proceso de estudiar como debe funcionar exactamente!
		{
			this.webDriver.click(checkViveEnRiesgoNo);
			this.webDriver.clickElementFromDropDownByAttribute(comboTipoVia, "value", tipoVia);
			this.webDriver.setText(comboNombreVia, nombreVia);
			this.webDriver.setText(txtNumeroVia, numVia);
			this.webDriver.setText(txtPiso, piso);
			this.webDriver.setText(txtPuerta, puerta);
		}
		
		debugEnd();
	}
	

	public void altaObservaciones(String observaciones){
		debugBegin();

        this.webDriver.setText(txtObservaciones, observaciones);        
		
		debugEnd();
		
	}
	

	public void altaDocumentoAdj(){
		debugBegin();
     
		//A especificar como hacerlo - PENDIENTE DE REVISIÓN
		
		debugEnd();
		
	}
	

	public void clickEnviar(){
		debugBegin();

		if(this.webDriver.isClickable(buttonEnviarSin))this.webDriver.click(buttonEnviarSin);
		
		debugEnd();
		
	}
	

	public void clickImprimir(){
		debugBegin();

		if(this.webDriver.isClickable(buttonImprimirSin))this.webDriver.click(buttonImprimirSin);
		
		debugEnd();
		
	}

	

	public void clickBorrar(){
		debugBegin();

		if(this.webDriver.isClickable(buttonBorrarSin))this.webDriver.click(buttonBorrarSin);
		
		debugEnd();
		
	}
	
	public void comprobarOK() {
		this.webDriver.waitForElementToBePresent(modalOK);
		System.out.println(textoModalOK.toString());
	}
	/*
	public GestionOnlineAltaSiniestro acceptCookies() {
		debugBegin();
		this.webDriver.waitWithDriver(2500);
		//this.webDriver.click(this.btnAceptarCookies);
		this.webDriver.click(this.btnAceptarCookies);
			;
		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestro createNewSimulation() {
		debugBegin();
		
		this.webDriver.doubleClick(this.btnMutuaEdificioConfort);
		this.webDriver.doubleClick(this.btnNuevaSimulaion);

		debugEnd();

		return this;
	}

	public GestionOnlineAltaSiniestro openContratarMutuaEdificioConfort() throws AWTException, InterruptedException, IOException {
		debugBegin();
		
        this.webDriver.click(this.btnContratacion);
        this.webDriver.clickInFrame(this.drpdownComunidades, this.contentFrame);
		this.webDriver.clickInFrame(this.btnContratarMutuaEdificioConfort, this.contentFrame);
		this.webDriver.switchToWindow(1);
		this.webDriver.maximizeWindow();
		
		debugEnd();
		
		return this;
	}
	
	public void openGestionCotizaciones()
	 {
		 debugBegin();
		 this.webDriver.click(this.btnMapaWeb);
		 this.webDriver.doubleClickInFrame(this.btnGestionCotizaciones,
		 this.mainFrame);
		 debugEnd();
	 }

	public GestionOnlineAltaSiniestro openGestionPolizas() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnMapaWeb, this.topFrame);
		this.webDriver.doubleClickInFrame(this.btnGestionPolizas, this.mainFrame);
		debugEnd();

		return this;
	}*/
	// endregion
}
