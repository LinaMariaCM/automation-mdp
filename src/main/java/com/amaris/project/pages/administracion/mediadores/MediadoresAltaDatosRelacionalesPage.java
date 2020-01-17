package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosRelacionalesPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By especialistaRamoSIBtn = By.id("ALTAMEDI_ESPRAMOSI");
	private By especialistaRamoNOBtn = By.id("ALTAMEDI_ESPRAMONO");
	private By especialistaRamoCombo = By.id("ALTAMEDI_RAMO");

	private By adminFincasSIBtn = By.id("ALTAMEDI_FINCASSI");
	private By adminFincasNOBtn = By.id("ALTAMEDI_FINCASNO");
	private By adminFincasCuantasInput = By.id("ALTAMEDI_FINCAS");

	private By medNuevoProductoBtn = By.linkText("Añadir nuevo producto");
	private By nuevoProductoCombo = By.id("ALTAMEDI_PRODUCT");
	private By nuevoProductoOption = By.cssSelector("#ALTAMEDI_PRODUCT > option");
	private By nuevoProdCompPrincipalCombo = By.id("ALTAMEDI_COMPRIN");
	private By nuevoProdCompPrincipalOption = By.cssSelector("#ALTAMEDI_COMPRIN > option");
	private By nuevoProdCompSecundariaCombo = By.id("ALTAMEDI_COMSECU ");
	private By nuevoProdCompSecundariaOption = By.cssSelector("#ALTAMEDI_COMSECU > option");

	private By potencialNPCombo = By.id("ALTAMEDI_POTNP");
	private By potencialNPOption = By.cssSelector("#ALTAMEDI_POTNP > option");
	private By autonomoProyectosSIBtn = By.id("ALTAMEDI_AUTOSI");
	private By autonomoProyectosNOBtn = By.id("ALTAMEDI_AUTONO");
	private By compPrincipInput = By.id("ALTAMEDI_COMPPRIN");

	private By medNuevoBancoBtn = By.linkText("Añadir nuevo banco");
	private By nombreBancoInput = By.id("ALTAMEDI_NOMBANCO");
	private By observacionesBancoInput = By.id("ALTAMEDI_OBSBANCO");

	private By valorarDelegadoCombo = By.id("ALTAMEDI_VALDEL");
	private By valorarDelegadoOption = By.cssSelector("#ALTAMEDI_VALDEL > option");

	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");

	//-----------Controles de pagina---------------------------

	private By cancelarRelacionalesBtn = By.id("botonCancelar1");
	private By guardarRelacionalesBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	public MediadoresAltaDatosRelacionalesPage(UserStory userS) {
		super(userS);
	}

 	//---------------Añadir datos PRODUCTO segun casos:----------------------------------
	// ramo --> Si  y finca --Si
	// ramo --> No y finca --> Si
	// ramo --> No y Finca --> No
	// ramo --> si y finca --> No

	public MediadoresAltaDatosRelacionalesPage anyadirDatosProductoSinRamoSinFinca() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(especialistaRamoNOBtn);
		webDriver.click(adminFincasNOBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage anyadirDatosProductoRamoSinFinca() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(especialistaRamoSIBtn);
		webDriver.click(adminFincasNOBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	public MediadoresAltaDatosRelacionalesPage anyadirDatosProductoSinRamoConFinca() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(especialistaRamoNOBtn);
		webDriver.click(adminFincasSIBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage anyadirDatosProductoConRamoConFinca() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(especialistaRamoSIBtn);
		webDriver.click(adminFincasSIBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//----------------------Añadir nuevo producto ----------------------------
	public MediadoresAltaDatosRelacionalesPage anyadirNuevoProducto(String producto, String companyiaPrincipal, String companyiaSecundaria) {
		debugBegin();
		if(producto.isEmpty()) producto = "COMU";
		if(companyiaPrincipal.isEmpty()) companyiaPrincipal = "L0546";
		if(companyiaSecundaria.isEmpty()) companyiaSecundaria = "C0089";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(medNuevoProductoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(nuevoProductoCombo, nuevoProductoOption , "value", producto);
		webDriver.clickElementFromDropDownByAttribute(nuevoProdCompPrincipalCombo, nuevoProdCompPrincipalOption , "value", companyiaPrincipal);
		webDriver.clickElementFromDropDownByAttribute(nuevoProdCompSecundariaCombo, nuevoProdCompSecundariaOption , "value", companyiaSecundaria);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-----------------------Añadir datos del mediador----------------
	public MediadoresAltaDatosRelacionalesPage anyadirDatosMediador(String potencial, String companyiasPrincipales) {
		debugBegin();
		if(potencial.isEmpty()) potencial = "ALTO";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(potencialNPCombo, potencialNPOption , "value", potencial);
		webDriver.click(autonomoProyectosNOBtn);
		webDriver.setText(compPrincipInput, companyiasPrincipales);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo banco---------------------------
	public MediadoresAltaDatosRelacionalesPage anyadirNuevoBanco(String nombreBanco, String observacionesBanco) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(medNuevoBancoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(nombreBancoInput, nombreBanco);
		webDriver.setText(observacionesBancoInput, observacionesBanco);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos comentarios---------------------------
	public MediadoresAltaDatosRelacionalesPage anyadirDatosComentarios(String valoracionDeleg) {
		debugBegin();
		if(valoracionDeleg.isEmpty()) valoracionDeleg = "1";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(valorarDelegadoCombo, valorarDelegadoOption , "value", valoracionDeleg);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-------------------Clicks en botones------------------------
	public MediadoresAltaDatosRelacionalesPage clickCancelar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, modalFrame);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage clickCancelarDatosrelacionales() {
		debugBegin();
		webDriver.clickInFrame(cancelarRelacionalesBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage clickGuardarDatosRelacionales() {
		debugBegin();
		webDriver.clickInFrame(guardarRelacionalesBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage clickContinuarDatosRelacionales() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

}
