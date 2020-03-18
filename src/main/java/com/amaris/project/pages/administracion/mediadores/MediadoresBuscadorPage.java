package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediadoresBuscadorPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By nombreRazonSocialComercialInput = By.cssSelector("#BUSMED_NOMBCOME");
	private By nombreRazonSocialFiscalInput = By.cssSelector("#BUSMED_NOMBFISC");
	private By nifMediadorInput = By.cssSelector("#BUSMED_NUMEDOCU");
	private By poblacionMediadorCombo = By.cssSelector("#BUSMED_POBLACION");
	private By codigoComercialPostalInput = By.cssSelector("#BUSMED_POSTAL");
	private By telefonoMediadorInput = By.cssSelector("#BUSMED_TELEFONO");
	private By direccionCorreoElectronicoInput = By.cssSelector("#BUSMED_EMAIL");
	private By codigoMediadorMutuaInput = By.cssSelector("#BUSMED_CODIMEDI");
	private By codigoDGSInput = By.cssSelector("#BUSMED_REGISDGS");
	private By referenciaExternaMediadorInput = By.cssSelector("#BUSMED_REFEEXTE");

	private By nivelEstructuraIntermediarioBtn = By.cssSelector("#MEDI_NIESMEDI");
	private By nivelEstructuraOficinaBtn = By.cssSelector("#MEDI_NIESOFIC");
	private By nivelEstructuraColaboradorBtn = By.cssSelector("#MEDI_NIESCOLA");

	private By tipoIntermediarioAgenteExclusivoBtn = By.cssSelector("#MEDI_INTERMAGEX");
	private By tipoIntermediarioAgenteVinculadoBtn = By.cssSelector("#MEDI_INTERMAGVIN");
	private By tipoIntermediarioBSExclusivoBtn = By.cssSelector("#MEDI_INTERMBSEX");
	private By tipoIntermediarioBSVinculadoBtn = By.cssSelector("#MEDI_INTERMBSVIN");
	private By tipoIntermediarioCorredorBtn = By.cssSelector("#MEDI_INTERMCORR");
	private By tipoIntermediarioProspectBtn = By.cssSelector("#MEDI_INTERMPROS");
	private By tipoIntermediarioAffinityBtn = By.cssSelector("#MEDI_INTERMAFFIN");
	private By tipoIntermediarioAcuerdoColaboracionBtn = By.cssSelector("#MEDI_INTERMACDIS");

	private By estadoPendienteEnvioDGSBtn = By.cssSelector("#MEDI_ESTPENVDGS");
	private By estadoPendienteAutorizacionDGSBtn = By.cssSelector("#MEDI_ESTPAUTDGS");
	private By estadoActivoRestringidoBtn = By.cssSelector("#MEDI_ESTACTIRES");
	private By estadoActivoBtn = By.cssSelector("#MEDI_ESTACTIVO");
	private By estadoProspectBtn = By.cssSelector("#MEDI_ESTPROSP");
	private By estadoTramitacionBtn = By.cssSelector("#MEDI_ESTTRAMIT");
	private By estadoFormacionBtn = By.cssSelector("#MEDI_ESTFORM");
	private By estadoBajaBtn = By.cssSelector("#MEDI_ESTBAJA");
	private By estadoBajaTramiteBtn = By.cssSelector("#MEDI_ESTBATR");
	private By estadoMantenimientoBtn = By.cssSelector("#MEDI_ESTMANTE");
	private By estadoRechazadoBtn = By.cssSelector("#MEDI_ESTRECH");

	private By simpleBtn = By.cssSelector("#filtro1");
	private By avanzadoBtn = By.cssSelector("#filtro2");
	private By mediadoresBtn = By.cssSelector("#filtro3");

	private By buscarBtn = By.cssSelector("#cajabuscador > tbody > tr:nth-child(2) > td.marcofnd > input");

	public MediadoresBuscadorPage(UserStory userS) {
		super(userS);
	}

	public MediadoresBuscadorPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// --Buscar mediador por su ID ----
	public MediadoresBuscadorPage buscarMediadorPorId() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_MEDIADOR_ALTA));
		webDriver.clickInFrame(estadoTramitacionBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	//---Búsqueda de intermediario para dar alta oficina---
	public MediadoresBuscadorPage buscarInteRelacionado() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE));
		webDriver.clickInFrame(estadoTramitacionBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	public MediadoresBuscadorPage buscarOficinaPorIdEstadoAlta() {
		debugBegin();

		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_ALTA_OFICINA_AE));
		webDriver.clickInFrame(nivelEstructuraIntermediarioBtn, cuerpoFrame);
		webDriver.clickInFrame(nivelEstructuraColaboradorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(estadoPendienteEnvioDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoRestringidoBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

}
