package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

public class SiniestrosEncargoDatos extends PageObject {

	DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");

	// #### DATOS DEL ASEGURADO ####
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	private By btnGrabar = By.id("botonGrabar");
	private By comboTipoColaborador = By.id("tipoEspe");
	private By comboTipoEncargo = By.id("selectEncargo");
	private By comboSubtipoEncargo = By.id("selectAgrupacion");
	private By txtFechaEncargo = By.id("fechenca");
	private By txtDetalles = By.id("comentario");
	// end region

	public SiniestrosEncargoDatos(UserStory userS) {
		super(userS);
	}

	// region Methods
	public SiniestrosEncargoDatos seleccionarTipoEncargo(String colaborador, String tipoEncargo, String subtipoEncargo) {
		debugBegin();

		webDriver.clickElementFromDropDownByAttribute(comboTipoColaborador, "value", colaborador);
		webDriver.waitWithDriver(3000);
		//webDriver.clickElementFromDropDownByIndex(comboTipoColaborador, 2);
		webDriver.waitWithDriver(500);
		//webDriver.clickElementFromDropDownByAttribute(comboTipoEncargo, "value", tipoEncargo);
		webDriver.clickElementFromDropDownByIndex(comboTipoEncargo, 1);
		webDriver.waitWithDriver(500);
		//webDriver.clickElementFromDropDownByAttribute(comboSubtipoEncargo, "value", subtipoEncargo);
		webDriver.clickElementFromDropDownByIndex(comboSubtipoEncargo, 2);

		debugEnd();
		
		return this;
	}

	public SiniestrosEncargoDatos seleccionarDatosEncargo(Date fechaEncargo, String detalles) {
		debugBegin();

		webDriver.setText(txtFechaEncargo, fOcurrencia.format(fechaEncargo));
		webDriver.setText(txtDetalles, detalles);

		debugEnd();
		
		return this;
	}

	public SiniestrosEncargoDatos clickGrabar() {
		debugBegin();
		webDriver.click(btnGrabar);
		debugEnd();
		
		return this;
	}
}
