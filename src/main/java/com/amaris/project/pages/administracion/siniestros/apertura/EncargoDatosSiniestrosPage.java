package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import java.util.Date;

import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class EncargoDatosSiniestrosPage extends PageObject {

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By grabarBtn = By.id("botonGrabar");
	private By tipoColaboradorDrpDwn = By.id("tipoEspe");
	private By comboTipoColaboradorElemento = By.cssSelector("#tipoEspe > option");

	private By tipoEncargoDrpDwn = By.id("selectEncargo");
	private By comboTipoEncargoElemento = By.cssSelector("#selectEncargo > option");

	private By subtipoEncargoDrpDwn = By.cssSelector("#selectAgrupacion > option");
	private By fechaEncargoInput = By.id("fechenca");
	private By detallesInput = By.id("comentario");

	private By aperturaSiniestroBtn = By.cssSelector("#formDatos #botonera #botonContinuar");
	private By btnValidarYContinuar = By.id("botonContinuar");

	private By anyadirNuevoEncargoBtn = By.cssSelector("[onclick*='addEncargo()']");
	// end region

	public EncargoDatosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public EncargoDatosSiniestrosPage seleccionarTipoEncargo(String colaborador, String tipoEncargo, String subtipoEncargo) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoColaboradorDrpDwn, comboTipoColaboradorElemento, cuerpoFrame, "value", colaborador);
		// webDriver.clickElementFromDropDownByIndex(comboTipoColaborador, 2);
		webDriver.waitWithDriver(6000);
		// webDriver.clickElementFromDropDownByAttribute(comboTipoColaborador, comboTipoColaboradorElemento, "value", colaborador);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoEncargoDrpDwn, cuerpoFrame, "value", tipoEncargo);
		// webDriver.clickElementFromDropDownByIndex(comboTipoEncargo, 1);
		webDriver.waitWithDriver(6000);
		webDriver.clickElementFromDropDownByAttributeInFrame(subtipoEncargoDrpDwn, cuerpoFrame, "value", subtipoEncargo);
		//webDriver.clickElementFromDropDownByIndex(comboSubtipoEncargo, 2);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage seleccionarDatosEncargo(Date fechaEncargo, String detalles) {
		debugBegin();
		
		webDriver.appendTextInFrame(fechaEncargoInput, cuerpoFrame, DateUtils.dateToString(fechaEncargo));
		webDriver.appendTextInFrame(detallesInput, cuerpoFrame, detalles);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage clickGrabar() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	//--------------------------------------RETENCIONES-------------------------------------------------------
	public EncargoDatosSiniestrosPage anyadirEncargoFalloVacio() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(aperturaSiniestroBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_ENCARGO);
		webDriver.acceptAlert();

		webDriver.clickInFrame(anyadirNuevoEncargoBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage tipoColaboradorFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EXISTE_TIPO_SUBTIPO_CARPETA);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_COLABORADOR);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage seleccionarTipoColaborador() {
		return seleccionarTipoColaborador("");
	}

	public EncargoDatosSiniestrosPage seleccionarTipoColaborador(String opcion) {
		debugBegin();

		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoColaboradorDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Defensa jurídica":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoColaboradorDrpDwn, cuerpoFrame, 1);
				break;
			case "Perito general":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoColaboradorDrpDwn, cuerpoFrame, 2);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage tipoEncargoFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage seleccionarTipoEncargo() {
		return seleccionarTipoEncargo("");
	}

	public EncargoDatosSiniestrosPage seleccionarTipoEncargo(String opcion) {
		debugBegin();

		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoEncargoDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Defensa jurídica":
				webDriver.clickElementFromDropDownByIndexInFrame(tipoEncargoDrpDwn, cuerpoFrame, 1);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage subtipoEncargoFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SUBTIPO_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage seleccionarSubtipoEncargo() {
		return seleccionarSubtipoEncargo("");
	}

	public EncargoDatosSiniestrosPage seleccionarSubtipoEncargo(String opcion) {
		debugBegin();

		// TODO Cambiar a atributo
		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(subtipoEncargoDrpDwn, cuerpoFrame, 0);
				break;
			default:
			case "Defensa y reclamación":
				webDriver.clickElementFromDropDownByIndexInFrame(subtipoEncargoDrpDwn, cuerpoFrame, 1);
				break;
			case "Impago de cuotas comunitarias":
				webDriver.clickElementFromDropDownByIndexInFrame(subtipoEncargoDrpDwn, cuerpoFrame, 2);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage fechaEncargoFalloVacio() {
		debugBegin();
		
		webDriver.clearTextInFrame(fechaEncargoInput, cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage fechaEncargoFormatoIncorrecto() {
		debugBegin();
		
		webDriver.setTextInFrame(fechaEncargoInput, cuerpoFrame, "12/if/201p");
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage escribirfechaEncargo() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(fechaEncargoInput, cuerpoFrame, datoFechaHoy);
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		webDriver.clickInFrame(aperturaSiniestroBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

}
