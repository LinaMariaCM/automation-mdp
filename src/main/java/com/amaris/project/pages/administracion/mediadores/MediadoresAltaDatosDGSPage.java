package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosDGSPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//-----------General---------------------------------
	private By capitalSocialInput = By.id("ALTAMEDI_CAPSOCI");
	private By fechaInicioRelacionInput = By.id("ALTAMEDI_FEINIREL");
	private By entidadAutorizaCombo = By.id("ALTAMEDI_ENTIDAD");

	private By tipoEntidadCombo = By.id("ALTAMEDI_TIPOENTI");
	private By fechaIniContratoInput = By.id("ALTAMEDI_FEINICON");

	private By anyadirNuevoRamoBtn = By.cssSelector("#capaRamos > div.titulo > div > a");
	private By ramoCombo = By.id("ALTAMEDI_RAMODGS");
	private By productoInput = By.id("ALTAMEDI_PRODUCTO");

	private By grabarRamoBtn = By.id("buttonRecord");
	private By cancelarRamoBtn = By.id("buttonCancel");

	//-----------------------------LPS-DE----------------------
	private By estdoLPSInput = By.id("ALTAMEDI_ESTADOLPS");
	private By codigoRegimenActuacionCombo = By.id("ALTAMEDI_CODREGACT");

	private By identifiRepreseInput = By.id("ALTAMEDI_IDRELP");
	private By razonSocialRepreInput = By.id("ALTAMEDI_RAZSORECLP");
	private By direccionRepreInput = By.id("ALTAMEDI_DIRRELP");
	private By codigoPostalRepreInput = By.id("ALTAMEDI_CPRELP");
	private By poblacionRepreInput = By.id("ALTAMEDI_POBRELP");

	private By razonSocialSucuInput = By.id("ALTAMEDI_RAZSOCSULP");
	private By direccionSucuInput = By.id("ALTAMEDI_DIRSULP");
	private By codigoPostalSucuInput = By.id("ALTAMEDI_CPSULP");
	private By poblacionSucuInput = By.id("ALTAMEDI_POBSULP");

	//-----------Controles de pagina---------------------------
	private By cancelarBtn = By.id("botonCancelar1");
	private By guardarBtn = By.id("botonGrabar1");

	public MediadoresAltaDatosDGSPage(UserStory userS) {
		super(userS);
	}

	public MediadoresAltaDatosDGSPage clickCancelar()
	{
		debugBegin();
		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGuardar()
	{
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickCancelarRamo()
	{
		debugBegin();
		webDriver.switchToFrame(modalFrame);
		webDriver.clickInFrame(cancelarRamoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGrabarrRamo()
	{
		debugBegin();
		webDriver.switchToFrame(modalFrame);
		webDriver.clickInFrame(grabarRamoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoRamo()
	{
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoRamoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}
}
