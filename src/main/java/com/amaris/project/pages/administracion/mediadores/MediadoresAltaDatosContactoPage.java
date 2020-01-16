package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosContactoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//--------------Datos generales-------------------------
	private By contactoResponsableInput = By.id("MEDI_PERSCONT");
	private By cargoResponsableInput = By.id("ALTAMEDI_CARGRESP");
	private By telefonoPrincipalInput = By.id("MEDI_TELEFONO1");
	private By faxPrincipalInput = By.id("ALTAMEDI_FAXPRI");
	private By comunicacionIPInput = By.id("ALTAMEDI_COMUNIP");
	private By emailPrincipalInput = By.id("ALTAMEDI_EMAILPRI");

	//------------------Anyadir nueva dirección-----------------------------

	private By anyadirNuevaDireccionBtn = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");
	private By tipoDomicilioCombo = By.id("ALTAMEDI_TIPDOMME");
	private By tipoDomicilioOption = By.cssSelector("#ALTAMEDI_TIPDOMME > option");
	private By provinciaInput = By.id("ALTACLIE_PROVINCIA_ARVATO");
	private By provinciaCombo = By.cssSelector("body > ul:nth-child(4) > li > a");
	private By poblacionInput = By.id("ALTACLIE_POBLACION_ARVATO");
	private By poblacionCombo = By.cssSelector("body > ul:nth-child(5) > li:nth-child(2) > a");
	private By viaInput = By.id("ALTACLIE_NOMVIA_ARVATO");
	private By viaCombo = By.cssSelector("body > ul:nth-child(6) > li:nth-child(2) > a");
	private By numeroViaInput = By.id("ALTACLIE_NUMVIA");
	private By codigoPostalInput = By.id("ALTACLIE_CODPOST_ARVATO");

	private By direccionIgualFiscalBtn = By.id("ALTAMEDI_IGUFISC");
	private By direccionIgualComercialBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionDiferenteBtn = By.id("ALTAMEDI_DIFFISC");

	private By direccionSuperiorNOComSIBtn	= By.id("ALTAMEDI_IGUCOMER");
	private By direccionSuperiorNOComNOBtn	= By.id("ALTAMEDI_DIFFISC");

	private By direccionSuperiorSIBtn = By.id("ALTAMEDI_IGUPADSI");
	private By direccionSuperiorNOBtn = By.id("ALTAMEDI_IGUPADNO");

	//Controles de datos de domicilio
	private By comprobarDireccionBtn = By.id("BOTON_NORMADOM");
	private By borrarCamposDomicilioBtn = By.id("BOTON_BORRADOM");
	private By aceptarBtn = By.id("BOTON_ACEPTAR");
	private By cancelarDomicilioBtn = By.id("BOTON_CANCELAR");

	private By aceptarDireccionBtn = By.id("BOTON_ACEPDOMI");
	private By asignarDomicilioBtn = By.id("BOTON_DOMIMEDI");

	//-------------Anyadir nueva red social -------------------------
	private By nuevaRedSocialBtn = By.cssSelector("#capaRedesSociales > div > div.floatright.peq > a");
	private By medTipoRRSSCombo = By.id("ALTAMEDI_TIPOREDS");
	private By medTipoRRSSOption = By.cssSelector("#ALTAMEDI_TIPOREDS > option");
	private By medRRSSDescripcionInput = By.id("ALTAMEDI_DESCREDS");

	//-----------Anyadir Medios de contacto-----------------
	private By nuevoMedioContactoBtn = By.cssSelector("#capaMediosContactoPaso2 > div > div.floatright.peq > a");
	private By medNuevoTipoContactoCombo = By.id("MEDI_CONTPROS");
	private By medNuevoTipoContactoOption = By.cssSelector("#MEDI_CONTPROS > option");
	private By medNuevoContactoInput = By.id("MEDI_CONTACTO");

//-------------Anyadir Nuevo contacto-------------------------
	private By nuevoContactoBtn = By.cssSelector("#capaContactos > div > div.floatright.peq > a");
	private By medAreaContactoCombo = By.id("ALTAMEDI_AREA");
	private By medAreaContactoOption = By.cssSelector("#ALTAMEDI_AREA > option");
	private By medNombreContactoInput = By.id("ALTAMEDI_NOMCON");
	private By medCargoContactoInput = By.id("ALTAMEDI_CARGO");
	private By medTelefonoContactoInput = By.id("ALTAMEDI_TELFCON");
	private By medFaxContactoInput = By.id("ALTAMEDI_FAXCON");
	private By medEmailContactoInput = By.id("ALTAMEDI_MAILCON");
	private By medPreferenciaCombo = By.id("ALTAMEDI_PREFCOM");
	private By medPreferenciaOption = By.cssSelector("#ALTAMEDI_PREFCOM > option");

	//----------Controles de red social- contacto- medios de contacto-------
	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");

	//-------------Marcas LOPD------------
	private By publicidadMediadorBtn = By.id("ALTAMEDI_ENVIOMED");
	private By publicidadMutuaistaBtn = By.id("ALTAMEDI_ENVIOMUT");
	private By publiImagenMedBtn = By.id("ALTAMEDI_USOIMAGEN");

	//---Controles de la pagina---------------------
	private By cancelarGeneralBtn = By.id("botonCancelar1");
	private By guardarBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	////// ELEMENTOS LISTADOS PERO QUE REALMENTE NO INTERVIENEN EN LOS STEPS DEL TEST todavía
	private By direcionRestoVInput = By.id("ALTACLIE_DATADIC");
	// El desplegable Tipo de Vía no despliega nada. ¿Realmente debería?
	private By direcionTipoVCombo = By.id("ALTACLIE_TIPOVIA_ARVATO");
	private By direcionBloqueInput = By.id("ALTACLIE_BLOQUE_ARVATO");
	private By direcionEscaleraInput = By.id("ALTACLIE_ESCALERA");
	private By direcionPisoInput = By.id("ALTACLIE_PISO");
	private By direcionPuertaInput = By.id("ALTACLIE_PUERTA");

	/* REPASAR DIRECCIÓN FISCAL CON OTRO TIPO DE MEDIADOR.
	CON COLABORADOR HA ASIGNADO EL SUPERIOR DE MANERA AUTOMÁTICA */

	public MediadoresAltaDatosContactoPage(UserStory userS) { super(userS); }

	//---------------Rellenar datos Generales------------------------
	public MediadoresAltaDatosContactoPage rellenarDatosGenerales(String contactoResp, String cargoRespo, String telPrincipal, String emailPrincipal)
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setText(contactoResponsableInput, contactoResp);
		webDriver.setText(cargoResponsableInput, cargoRespo);
		webDriver.setText(telefonoPrincipalInput, telPrincipal);
		webDriver.setText(emailPrincipalInput, emailPrincipal);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

 	//--------------Añadir direcciones: los 5 casos basicos---------------------------------
	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionComercial(String tipoDomicilio, String provincia, String poblacion, String nombreVia, String numVia)
	{
		debugBegin();
		if(tipoDomicilio.isEmpty()) tipoDomicilio = "COME";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(tipoDomicilioCombo, tipoDomicilioOption, "value", tipoDomicilio);
		webDriver.setText(provinciaInput, provincia);
		webDriver.setText(poblacionInput, poblacion);
		webDriver.setText(viaInput, nombreVia);
		webDriver.setText(numeroViaInput, numVia);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionFiscal(String tipoDomicilio, String provincia, String poblacion, String nombreVia, String numVia)
	{
		debugBegin();
		if(tipoDomicilio.isEmpty()) tipoDomicilio = "FISC";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(tipoDomicilioCombo, tipoDomicilioOption, "value", tipoDomicilio);
		webDriver.setText(provinciaInput, provincia);
		webDriver.setText(poblacionInput, poblacion);
		webDriver.setText(viaInput, nombreVia);
		webDriver.setText(numeroViaInput, numVia);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalIgualFiscal()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionIgualFiscalBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalIgualComercial()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionIgualComercialBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalDiferente(String provincia, String poblacion, String nombreVia, String numVia)
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionDiferenteBtn);
		webDriver.setText(provinciaInput, provincia);
		webDriver.setText(poblacionInput, poblacion);
		webDriver.setText(viaInput, nombreVia);
		webDriver.setText(numeroViaInput, numVia);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nueva red social---------------------------------
	public MediadoresAltaDatosContactoPage anyadirNuevaRedSocial(String tipoRedSocial, String descripcionRed)
	{
		debugBegin();
		if(tipoRedSocial.isEmpty()) tipoRedSocial = "BLOG";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevaRedSocialBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medTipoRRSSCombo, medTipoRRSSOption, "value", tipoRedSocial);
		webDriver.setText(medRRSSDescripcionInput, descripcionRed);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo medio contacto---------------------------------
	public MediadoresAltaDatosContactoPage anyadirDatosNuevoMedioContacto(String tipoContacto, String contacto)
	{
		debugBegin();
		if(tipoContacto.isEmpty()) tipoContacto = "MAIL";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevoMedioContactoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medNuevoTipoContactoCombo, medNuevoTipoContactoOption, "value", tipoContacto);
		webDriver.setText(medNuevoContactoInput, contacto);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo contacto---------------------------------
	public MediadoresAltaDatosContactoPage anyadirDatosNuevoContacto(String areaContacto, String nombreContacto)
	{
		debugBegin();
		if(areaContacto.isEmpty()) areaContacto = "ADMF";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevoContactoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medAreaContactoCombo, medAreaContactoOption, "value", areaContacto);
		webDriver.setText(medNombreContactoInput, nombreContacto);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Clicks botones---------------------------------
	public MediadoresAltaDatosContactoPage clickBorrarCamposDireccion()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(borrarCamposDomicilioBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickCancelarCamposDireccion()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarDomicilioBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickAsignarCamposDireccion()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(asignarDomicilioBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickAceptarDireccionPostal()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(aceptarDireccionBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickCancelar()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, modalFrame);
		debugEnd();

		return this;
	}
	public MediadoresAltaDatosContactoPage clickGuardarYSalir()
	{
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickCancelarGeneral()
	{
		debugBegin();
		webDriver.clickInFrame(cancelarGeneralBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickContinuar()
	{
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickDireccionSuperiorNO()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(direccionSuperiorNOBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickDireccionSuperiorSI()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(direccionSuperiorSIBtn, modalFrame);
		debugEnd();

		return this;
	}

}
