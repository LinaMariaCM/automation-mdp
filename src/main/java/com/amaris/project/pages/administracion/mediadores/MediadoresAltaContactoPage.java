package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaContactoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By contactoResponsableInput = By.id("MEDI_PERSCONT");
	private By cargoResponsableInput = By.id("ALTAMEDI_CARGRESP");
	private By telefonoPrincipalInput = By.id("MEDI_TELEFONO1");
	private By faxPrincipalInput = By.id("ALTAMEDI_FAXPRI");
	private By comunicacionIPInput = By.id("ALTAMEDI_COMUNIP");
	private By emailPrincipalInput = By.id("ALTAMEDI_EMAILPRI");

	//------------------Anyadir nueva dirección-----------------------------

	private By anyadirNuevaDireccionBtn = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");
	private By tipoDomicilioCombo = By.id("ALTAMEDI_TIPDOMME");
	private By provinciaTxt = By.id("ALTACLIE_PROVINCIA_ARVATO");
	private By provinciaCombo = By.cssSelector("body > ul:nth-child(4) > li > a");
	private By poblacionTxt = By.id("ALTACLIE_POBLACION_ARVATO");
	private By poblacionCombo = By.cssSelector("body > ul:nth-child(5) > li:nth-child(2) > a");
	private By viaTxt = By.id("ALTACLIE_NOMVIA_ARVATO");
	private By viaCombo = By.cssSelector("body > ul:nth-child(6) > li:nth-child(2) > a");
	private By numeroViaInput = By.id("ALTACLIE_NUMVIA");
	private By codigoPostalInput = By.id("ALTACLIE_CODPOST_ARVATO");

	private By direccionIgualFiscalBtn = By.id("ALTAMEDI_IGUFISC");
	private By direccionIgualComercialBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionDiferenteBtn = By.id("ALTAMEDI_DIFFISC");

	private By aceptarDomicilioBtn = By.id("BOTON_ACEPDOMI");

	private By direcionSuperiorNOComSIBtn	= By.id("ALTAMEDI_IGUCOMER");
	private By direcionSuperiorNOComNOBtn	= By.id("ALTAMEDI_DIFFISC");

	private By direcionSuperiorSIBtn = By.id("ALTAMEDI_IGUPADSI");
	private By direcionSuperiorNOBtn = By.id("ALTAMEDI_IGUPADNO");

	//Controles de datos de domicilio
	private By comprobarDireccionBtn = By.id("BOTON_NORMADOM");
	private By aceptarDireccionBtn = By.id("BOTON_ACEPTAR");
	private By aceptarDireccionPostalBtn = By.id("BOTON_ACEPDOMI");
	private By asignarDomicilioBtn = By.id("BOTON_DOMIMEDI");
	private By cancelarDomicilioBtn = By.id("BOTON_CANCELAR");
	private By borrarCamposDomicilioBtn = By.id("BOTON_BORRADOM");

	//-------------Anyadir nueva red social -------------------------

	private By nuevaRedSocialBtn = By.cssSelector("#capaRedesSociales > div > div.floatright.peq > a");
	private By medTipoRRSSCombo = By.id("ALTAMEDI_TIPOREDS");
	private By medRRSSDescripcionInput = By.id("ALTAMEDI_DESCREDS");

	//-----------Anyadir Medios de contacto-----------------
	private By nuevoMedioContactoBtn = By.cssSelector("#capaMediosContactoPaso2 > div > div.floatright.peq > a");
	private By medNuevoMedioContactoCombo = By.id("MEDI_CONTPROS");
	private By medNuevoMedioContactoInput = By.id("MEDI_CONTACTO");

//-------------Anyadir Nuevo contacto-------------------------
	private By nuevoContactoBtn = By.cssSelector("#capaContactos > div > div.floatright.peq > a");
	private By medAreaContactoCombo = By.id("ALTAMEDI_AREA");
	private By medNombreContactoInput = By.id("ALTAMEDI_NOMCON");
	private By medCargoContactoInput = By.id("ALTAMEDI_CARGO");
	private By medTelefonoContactoInput = By.id("ALTAMEDI_TELFCON");
	private By medFaxContactoInput = By.id("ALTAMEDI_FAXCON");
	private By medEmailContactoInput = By.id("ALTAMEDI_MAILCON");
	private By medPreferenciaComCombo = By.id("ALTAMEDI_PREFCOM");

	//----------Controles de red social- contacto- medios de contacto-------
	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");

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

	public MediadoresAltaContactoPage(UserStory userS) { super(userS); }

	public MediadoresAltaContactoPage clickGuardarYSalir()
	{
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaContactoPage clickCancelarGeneral()
	{
		debugBegin();
		webDriver.clickInFrame(cancelarGeneralBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaContactoPage clickContinuar()
	{
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaContactoPage clickCancelar()
	{
		debugBegin();
		webDriver.switchToFrame(modalFrame);
		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaContactoPage clickGrabar()
	{
		debugBegin();
		webDriver.switchToFrame(modalFrame);
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
}
