package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class EncargoDatosSiniestrosPage extends PageObject {

	DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By btnGrabar = By.id("botonGrabar");
	private By comboTipoColaborador = By.id("tipoEspe");
	private By comboTipoColaboradorElemento = By.cssSelector("#tipoEspe > option");

	private By comboTipoEncargo = By.id("selectEncargo");
	private By comboTipoEncargoElemento = By.cssSelector("#selectEncargo > option");

	private By comboSubtipoEncargo = By.id("selectAgrupacion");
	private By txtFechaEncargo = By.id("fechenca");
	private By txtDetalles = By.id("comentario");

	private By btnAperturaSiniestro = By.cssSelector("#formDatos #botonera #botonContinuar");
	private By btnValidarYContinuar = By.id("botonContinuar");

	private By anyadirNuevoEncargoBtn = By.cssSelector("[onclick*='addEncargo()']");
	// end region

	public EncargoDatosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public EncargoDatosSiniestrosPage seleccionarTipoEncargo(String colaborador, String tipoEncargo, String subtipoEncargo) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttribute(comboTipoColaborador, comboTipoColaboradorElemento, "value", colaborador);
		// webDriver.clickElementFromDropDownByIndex(comboTipoColaborador, 2);
		webDriver.waitWithDriver(10000);
		// webDriver.clickElementFromDropDownByAttribute(comboTipoColaborador, comboTipoColaboradorElemento, "value",
		// colaborador);
		// webDriver.clickElementFromDropDownByAttribute(comboTipoEncargo, "value", tipoEncargo);
		// webDriver.clickElementFromDropDownByIndex(comboTipoEncargo, 1);
		webDriver.waitWithDriver(10000);
		// webDriver.clickElementFromDropDownByAttribute(comboSubtipoEncargo, "value", subtipoEncargo);
		webDriver.clickElementFromDropDownByIndex(comboSubtipoEncargo, 2);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage seleccionarDatosEncargo(Date fechaEncargo, String detalles) {
		debugBegin();

		webDriver.setText(txtFechaEncargo, fOcurrencia.format(fechaEncargo));
		webDriver.setText(txtDetalles, detalles);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage clickGrabar() {
		debugBegin();
		webDriver.click(btnGrabar);
		debugEnd();

		return this;
	}

	//--------------------------------------RETENCIONES-------------------------------------------------------

	public EncargoDatosSiniestrosPage anyadirEncargoFalloVacio() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(btnAperturaSiniestro, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_ENCARGO);
		webDriver.acceptAlert();

		webDriver.clickInFrame(anyadirNuevoEncargoBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage tipoColaboradorFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);

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

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoColaborador, cuerpoFrame, 0);
				break;
			default:
			case "Defensa jurídica":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoColaborador, cuerpoFrame, 1);
				break;
			case "Perito general":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoColaborador, cuerpoFrame, 2);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage tipoEncargoFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);

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

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoEncargo, cuerpoFrame, 0);
				break;
			default:
			case "Defensa jurídica":
				webDriver.clickElementFromDropDownByIndexInFrame(comboTipoEncargo, cuerpoFrame, 1);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage subtipoEncargoFalloVacio() {
		debugBegin();
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);

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

		switch(opcion) {
			case "Seleccionar":
				webDriver.clickElementFromDropDownByIndexInFrame(comboSubtipoEncargo, cuerpoFrame, 0);
				break;
			default:
			case "Defensa y reclamación":
				webDriver.clickElementFromDropDownByIndexInFrame(comboSubtipoEncargo, cuerpoFrame, 1);
				break;
			case "Impago de cuotas comunitarias":
				webDriver.clickElementFromDropDownByIndexInFrame(comboSubtipoEncargo, cuerpoFrame, 2);
				break;
		}

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage fechaEncargoFalloVacio() {
		debugBegin();
		webDriver.clearTextInFrame(txtFechaEncargo, cuerpoFrame);
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage fechaEncargoFormatoIncorrecto() {
		debugBegin();
		webDriver.setTextInFrame(txtFechaEncargo, cuerpoFrame, "12/if/201p");
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ENCARGO);
		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public EncargoDatosSiniestrosPage escribirfechaEncargo() {
		debugBegin();

		String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.setTextInFrame(txtFechaEncargo, cuerpoFrame, datoFechaHoy);
		webDriver.clickInFrame(btnGrabar, cuerpoFrame);
		webDriver.clickInFrame(btnAperturaSiniestro, cuerpoFrame);

		debugEnd();

		return this;
	}

}
