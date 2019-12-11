package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
