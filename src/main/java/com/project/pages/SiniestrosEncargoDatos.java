package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

public class SiniestrosEncargoDatos extends PageObject {
	
// THE CONSTRUCTOR
	public SiniestrosEncargoDatos(UserStory userS)
	{
		super(userS);
	}
	
//	REGION WEBELEMENT
	
	//	####	FRAMES	####
	
	private By cuerpoFrame = By.id("mainFrame");
	
	//	####	DATOS DEL ASEGURADO	####
	
	DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
	//
	private By btnAnotaciones = By.cssSelector("#enlaceDialogo > span");
	//
	private By btnVolver = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li.rightList > a > span");
	//
	private By btnGrabar = By.id("botonGrabar");
	//
	private By comboTipoColaborador = By.id("tipoEspe");
	//
	private By comboTipoEncargo = By.id("selectEncargo");
	//
	private By comboSubtipoEncargo = By.id("selectAgrupacion");
	//
	private By txtFechaEncargo = By.id("fechenca");
	//
	private By txtDetalles = By.id("comentario");
	
//end region
	
// REGION METHODS
	
	
	public void seleccionarTipoEncargo(String colaborador, String tipoEncargo, String subtipoEncargo)
	{
		this.debugBegin();

		this.webDriver.clickElementFromDropDownByAttribute(comboTipoColaborador, "value", colaborador);
		this.webDriver.waitWithDriver(500);
		this.webDriver.clickElementFromDropDownByAttribute(comboTipoEncargo, "value", tipoEncargo);
		this.webDriver.waitWithDriver(500);
		this.webDriver.clickElementFromDropDownByAttribute(comboSubtipoEncargo, "value", subtipoEncargo);
		
		this.debugEnd();
	}
	

	public void seleccionarDatosEncargo(Date fechaEncargo, String detalles)
	{
		this.debugBegin();

		this.webDriver.setText(txtFechaEncargo, fOcurrencia.format(fechaEncargo));
		this.webDriver.setText(txtDetalles, detalles);
		
		this.debugEnd();
	}
	
	

	public void clickGrabar()
	{
		this.debugBegin();
		this.webDriver.click(btnGrabar);
		this.debugEnd();
	}
	
}
