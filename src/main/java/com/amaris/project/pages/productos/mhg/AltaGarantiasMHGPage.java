package com.amaris.project.pages.productos.mhg;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaDeclaracionSiniestrosPage;
import org.openqa.selenium.By;

import java.util.Calendar;

public class AltaGarantiasMHGPage extends PageObject {

	//---FRAMES----
	private By topFrame = By.cssSelector("#topFrame");
	private By modalFrame = By.cssSelector("#leftFrame");
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By fechaEfectoSuplemInput = By.cssSelector("#suplefec");

	//---DESCRIPCION DE LA VIVIENDA----
	private By descripcionViviendaBtn = By.cssSelector("#formDatosDir > div:nth-child(3) > div > div > button");
	private By situacionViviendaCombo = By.cssSelector("#SITUACIONMODALIDAD");
	private By situacionViviendaOption = By.cssSelector("#SITUACIONMODALIDAD > option");
	private By regimenViviendaCombo = By.cssSelector("#REGOCUPAMODALIDAD");
	private By regimenViviendaOption = By.cssSelector("#REGOCUPAMODALIDAD > option");
	private By usoViviendaCombo = By.cssSelector("#usodvive");
	private By usoViviendaOption = By.cssSelector("#usodvive > option");
	private By tipoViviendaCombo = By.cssSelector("#TIPVIVIMODALIDAD");
	private By tipoViviendaOption = By.cssSelector("#TIPVIVIMODALIDAD > option");
	private By materialConstruccionCombo = By.cssSelector("#MATCONSTMOD");
	private By materialConstruccionOption = By.cssSelector("#MATCONSTMOD > option");

	//---SUPERFICIE----
	private By superficieBtn = By.cssSelector("#formDatosDir > div:nth-child(4) > div > div > button");
	private By m2ViviendaInput = By.cssSelector("#m2vivi");

	//---CONSTRUCCIONES ANEXAS----
	private By construccionesAnexasBtn = By.cssSelector("#formDatosDir > div:nth-child(5) > div > div > button");
	private By garajesAisladosCerradosBtn = By.cssSelector("#CA04");
	private By constrDeporteJuegoBtn = By.cssSelector("#CA05");
	private By plazasParquingBtn = By.cssSelector("#CA03");
	private By trasterosCobertizosBtn = By.cssSelector("#CA01");
	private By piscinasBtn = By.cssSelector("#CA02");

	//---ANYO CONSTRUCCION Y REHABILITACIONES---
	private By anyoConstrRehabBtn = By.cssSelector("#formDatosDir > div:nth-child(6) > div > div > button");
	private By anyoConstruccionInput = By.cssSelector("#INMU_FECHCONS");

	private By anyoRehabiIntInput = By.cssSelector("#fechreha");
	private By rehabMenosQuinceAnyosBtn = By.cssSelector("#SWREHA15");

	//---MEDIDAS DE PROTECCION--------
	private By medidasProteccionBtn = By.cssSelector("#formDatosDir > div:nth-child(7) > div > div > button");
	private By puertaBlindadaBtn = By.cssSelector("#SWPBLI");
	private By alarmaConectadaBtn = By.cssSelector("#SWALAR");

	private By proteccionVentanaBtn = By.cssSelector("#SWPVEN");
	private By cajaFuerteaBtn = By.cssSelector("#swcajase");
	private By otrasMedidProteccionBtn = By.cssSelector("#SWOTRASMP");

	//---AGRAVACIONES DEL RIESGO------
	private By agravacionRiesgoBtn = By.cssSelector("#formDatosDir > div:nth-child(8) > div > div > button");
	private By viviendaDepositoGasoilBtn = By.cssSelector("#swagraga");
	private By viviendaProximaTallerBtn = By.cssSelector("#swagravi");

	//---OTRAS POLIZAS DE MUTUA------
	private By otraPolizaMutuaBtn = By.cssSelector("#formDatosDir > div:nth-child(9) > div > div > button");
	private By comunidadAsegBtn = By.cssSelector("#POLCOMU");
	private By otraViviendaImpagoBtn = By.cssSelector("#OTRAPOL");

	//---BOTONES DE CONTROL---
	private By cancelarBtn = By.cssSelector("#formDatosDir > div:nth-child(10) > div > div > a");
	private By guardarBtn = By.cssSelector("#formDatosDir > div:nth-child(10) > div > div > button.btn.btn-default");
	private By continuarBtn = By.cssSelector("#formDatosDir > div:nth-child(10) > div > div > button.btn.btn-primary");
	private By volverBtn = By.cssSelector("#botonVolver");

	//---ALERTAS SISTEMA---
	private By alertaSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By avisoSistemaTxt = By.cssSelector("#modalErrValHogar > div > div > div.modal-body > div > div > h5");

	public AltaGarantiasMHGPage(UserStory userS) {
		super(userS);
	}

	//---FUNCIONES PARA ALERTAS Y AVISOS DE SISTEMA---

	public boolean alertaSistema(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(alertaSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public boolean avisoSistema(String mensaje) {
		debugBegin();

		String aviso = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAviso = aviso.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + aviso);

		debugEnd();

		return checkAviso;
	}

	//------CLICKS EN BOTONES--------
	public AltaGarantiasMHGPage clickVolver() {
		debugBegin();

		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public AltaGarantiasMHGPage clickContinuarPagina() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public AltaGarantiasMHGPage clickCancelarPagina() {
		debugBegin();

		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public AltaGarantiasMHGPage clickGuardarPagina() {
		debugBegin();

		webDriver.clickInFrame(guardarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}
}
