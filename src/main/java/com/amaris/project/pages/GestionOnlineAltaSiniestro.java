package com.amaris.project.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

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
	
	private By txtRefMediador = By.id("sref");
	
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

	private By comboTipoDocumento = By.id("seldoc_1");

	private By buttonSeleccionArchivo = By.id("adjdocu1");

	private By txtDescripcionDocu = By.id("descadjdocu_1");

	private By buttonBorrarAdjunto = By.id("deldocsel1");

	private By buttonEnviarSin = By.id("enviar");

	private By buttonImprimirSin = By.id("imprimir");

	private By buttonBorrarSin = By.id("borrar");
	
	private By modalOK = By.id("modalWindow");
	
	private By textoModalOK = By.cssSelector("#modalWindow > div.modal-body");
	
	private By modalSiniestroExiste = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-body > div");	
	
	private By buttonExisteNo = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.null");	
	
	private By buttonExisteSi = By.cssSelector("body > div.bootbox.modal.fade.in > div.modal-footer > a.btn.btn-primary");
	
	
	
	DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");

	// endregion



	// region methods
	
	
	public void altaInfoPoliza(String numpoliza, String fecha){
		debugBegin();

		this.webDriver.switchToFrame(this.contentFrame);
		
		this.webDriver.setText(this.txtNumPoliza, numpoliza);  
		this.webDriver.removeAttribute(this.txtFechaSiniestro, "readonly");
		this.webDriver.click(this.txtFechaSiniestro);
		System.out.println("Click en fecha");
		this.webDriver.waitWithDriver(1500);
		if(fecha!="") this.webDriver.setText(this.txtFechaSiniestro, fecha); 
		else this.webDriver.setText(this.txtFechaSiniestro, fOcurrencia.format(new Date()));
		
		this.webDriver.waitWithDriver(1500);
		System.out.println("Si todo bien, exit frame time");
		this.webDriver.waitWithDriver(1500);

		this.webDriver.waitWithDriver(3000);
		this.webDriver.click(this.txtRefMediador);
		
        this.webDriver.exitFrame();
		
		debugEnd();
		
	}

	public void altaCausaDescripcion(String causa, String descripcion, String costeAprox){
		debugBegin();

		this.webDriver.switchToFrame(this.contentFrame);
		String causaTxt="";
		
		if (causa.equals("1"))causaTxt="AGUA";
		else if (causa.equals("2"))causaTxt="IMPAGO ALQUILERES";
		else if (causa.equals("3"))causaTxt="EXPLOSION";
		else causaTxt="AGUA";
		
		
        this.webDriver.clickElementFromDropDownByText(this.comboCausa, causaTxt);
        this.webDriver.setText(this.txtDescripcion, descripcion);
        this.webDriver.setText(this.txtCosteAprox, costeAprox);

        this.webDriver.exitFrame();
        
		
		debugEnd();
		
	}
	

	public void altaCuentaSiniestro(){
		debugBegin();

		this.webDriver.switchToFrame(this.contentFrame);

		this.webDriver.waitWithDriver(3000);
		if(this.webDriver.isClickable(checkCuentaIndemnizacion))this.webDriver.click(checkCuentaIndemnizacion);
		else if(this.webDriver.isClickable(checkCuentaRecibos))this.webDriver.click(checkCuentaRecibos);
		else {
			this.webDriver.click(checkNuevaCuenta);      
			this.webDriver.clickElementFromDropDownByAttribute(this.comboPaisIban, "value", "ES");
	        this.webDriver.setText(this.txtIban1, "ES21");
	        this.webDriver.setText(this.txtIban2, "2100");
	        this.webDriver.setText(this.txtIban3, "0001");
	        this.webDriver.setText(this.txtIban4, "0500");
	        this.webDriver.setText(this.txtIban5, "0000");
	        this.webDriver.setText(this.txtIban6, "0001");	        
		}

        this.webDriver.exitFrame();
		
		debugEnd();
	}

	public void altaPersonaContacto(String rol, String nombre, String apellido1, String apellido2, String telefono, String email){
		
		debugBegin();
		
		this.webDriver.switchToFrame(this.contentFrame);

		this.webDriver.waitWithDriver(3000);
		this.webDriver.clickElementFromDropDownByIndex(this.comboRol, 1);
        this.webDriver.setText(this.txtNombre, nombre);
        this.webDriver.setText(this.txtApellido1, apellido1);
        this.webDriver.setText(this.txtApellido2, apellido2);
        this.webDriver.setText(this.txtTelefono, telefono);
        this.webDriver.setText(this.txtEmail, email);
		
        this.webDriver.exitFrame();
        
		debugEnd();
	}

	public void altaDireccionContacto(Boolean asegurado, String tipoVia, String nombreVia, String numVia, String piso, String puerta, String localidad, String provincia, String cp){
		
		debugBegin();
		
		this.webDriver.switchToFrame(this.contentFrame);

		this.webDriver.waitWithDriver(3000);
		if(asegurado)this.webDriver.click(this.checkViveEnRiesgoSi); 
		else  //para este caso falta definir los valores correspondientes a la provincia y localidad. En proceso de estudiar como debe funcionar exactamente!
		{
			this.webDriver.click(this.checkViveEnRiesgoNo);
			this.webDriver.clickElementFromDropDownByIndex(this.comboTipoVia, 1);
			this.webDriver.setText(this.comboNombreVia, nombreVia);
			this.webDriver.setText(this.txtNumeroVia, numVia);
			this.webDriver.setText(this.txtPiso, piso);
			this.webDriver.setText(this.txtPuerta, puerta);
		}

        this.webDriver.exitFrame();
		
		debugEnd();
	}
	

	public void altaObservaciones(String observaciones){
		debugBegin();

		this.webDriver.switchToFrame(this.contentFrame);

        this.webDriver.setText(txtObservaciones, observaciones);     

        this.webDriver.exitFrame();
		
		debugEnd();
		
	}
	

	public void altaDocumentoAdj(){
		debugBegin();
     
		//A especificar como hacerlo - PENDIENTE DE REVISIÓN
		
		debugEnd();
		
	}
	

	public void clickEnviar(){
		debugBegin();

		this.webDriver.waitWithDriver(3000);
		this.webDriver.switchToFrame(this.contentFrame);
		
		//if(this.webDriver.isClickable(buttonEnviarSin))this.webDriver.click(buttonEnviarSin);

		this.webDriver.waitWithDriver(3000);
		this.webDriver.click(buttonEnviarSin);
		
        this.webDriver.exitFrame();
		
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
	
	

	public void checkYaExisteSiniestro() {
		
		debugBegin();
		
		this.webDriver.waitWithDriver(15000);

		if(this.webDriver.isClickable(buttonExisteSi))this.webDriver.click(buttonExisteSi);
		
		debugEnd();
	}
	
	public void comprobarOK() {
		
		debugBegin();
		
		this.webDriver.waitWithDriver(25000);
		this.webDriver.waitForElementToBePresent(modalOK);
		this.webDriver.waitForElementToBeClickable(modalOK);
		this.webDriver.click(modalOK);
		System.out.println(this.webDriver.getText(this.textoModalOK));
		this.webDriver.takeScreenshotWithCondition();
		
		debugEnd();
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
