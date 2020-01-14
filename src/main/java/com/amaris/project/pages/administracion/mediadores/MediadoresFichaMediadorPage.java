package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.siniestros.HomeSiniestrosPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MediadoresFichaMediadorPage extends PageObject {

	// region webelements

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By tituloPaginaTxt = By.cssSelector("h1.titulopagina");


	//------------- Botones Pestañas -------------

	private By visionGlobalBtn = By.cssSelector("#pes0");
	private By infoDescriptivaBtn = By.cssSelector("#pes1");
	private By infoContactoBtn = By.cssSelector("#pes2");
	private By infoRelacionalBtn = By.cssSelector("#pes3");
	private By condicionesNegocioBtn = By.cssSelector("#pes5");
	private By infoHistoricaBtn = By.cssSelector("#pes6");
	private By infoCCMBtn = By.cssSelector("#pes7");
	private By contactosBtn = By.cssSelector("#pes8");
	private By situacionesBtn = By.cssSelector("#pes9");
	private By cambiosBtn = By.cssSelector("#pes10");
	private By anotacionesBtn = By.cssSelector("#pes11");


	//------------- Botones en "Más acciones" -------------

	private By masAccionesBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > a > span");
	private By convertirAffinityBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By iniciarAltamediadorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(2) > a");



	//------------- Contenido del encabezado -------------

	private By nivelJerarquicoTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(1)");
	private By tipoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By tipoColaboradorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td");
	private By ejecutivoComercialTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By oficinaPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By mediadorPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");
	private By estadoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td");
	private By situacionMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td");

	//------------- Contenido Pestañas -------------

	// Pestaña Info descriptiva
	private By consultarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By importarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By subirLogoMedBtn = By.cssSelector("#cabNuevoDoc");


	// Pestaña Info contactos
	private By modificarMedContactoBtn = By.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(1) > td > a");


	// Pestaña Info relacional
	private By modificarMedRelacioBtn = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(1) > td > a");


	// Pestaña Condiciones de negocio
	private By modificarMedCondiciNegBtn = By.cssSelector("#capaAjax > table > tbody > tr > td > a");

	private By cuadroComisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div.titulo > a");
	private By buscarArbolComiInput = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(2) > th:nth-child(2)");
	private By grabarArbolComiBtn = By.cssSelector("#buttonRecord");
	private By cancelarArbolComiBtn = By.cssSelector("#buttonCancel");

	private By cuadroSubcomisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(3) > div.titulo > a");
	private By fechaIniAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHINI");
	private By fechaVenciAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHFIN");

	private By arbolInput = By.cssSelector("#criterio");
	private By buscarArbolSubcomiBtn = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(9) > td:nth-child(3) > input");

	// Pestaña Contactos
	private By anyadirNuevoContacBtn = By.cssSelector("#cabMedioContacto");
	private By fechaDescendenteBtn = By.cssSelector("#descendenteContactos");
	private By fechaAscendenteBtn = By.cssSelector("#ascendenteContactos");

	// Pestaña Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");

	// endregion

	public MediadoresFichaMediadorPage(UserStory userS) {
		super(userS);
	}


	// region methods

	public String getContenidoTituloPagina() {
		debugBegin();
		String contenido = webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame);
		debugEnd();

		return contenido;
	}

	public HomeSiniestrosPage compararCampos() {
		debugBegin();

		String numPoliza = webDriver.getTextInFrame(numPolizaTxt, cuerpoFrame);
		numPoliza = numPoliza.substring(numPoliza.indexOf('/') + 1);

		debugInfo("Poliza esperada: " + getTestVar(Constants.NUM_POLIZA));
		debugInfo("Poliza real: " + numPoliza);

		Assert.assertTrue(numPoliza.equals(getTestVar(Constants.NUM_POLIZA)), "Comparar campos: el número de póliza coincide.");
		// TODO añadir campos adicionales

		debugEnd();

		return this;
	}
/*
	public MediadoresFichaMediadorPage


	nivelJerarquicoTxt

	tipoMediadorTxt

	tipoColaboradorTxt

	ejecutivoComercialTxt

	oficinaPadreTxt

	mediadorPadreTxt

	estadoMediadorTxt

	situacionMediadorTxt

*/













	//
	public MediadoresFichaMediadorPage clickAnyadirNuevoContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoContacBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// endregion
}
