package com.project.pages;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionCotizacionesBuscadorPage extends PageObject {

	// region Bys
	// @FindBy(name = "toc")
	private By menuFrame = By.name("toc");

	// @FindBy(id = "topFrame")
	private By topFrame = By.cssSelector("topFrame");

	// @FindBy(id = "mainFrame")
	private By mainFrame = By.cssSelector("mainFrame");

	// @FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");

	// @FindBy(xpath = ".//*[@value='COTIZACION']")
	private By rdnNoCotizacion = By.xpath(".//*[@value='COTIZACION']");

	// @FindBy(id = "cotizsec")
	private By txtNumeroCotizacion = By.cssSelector("cotizsec");

	// @FindBy(name = "producto_cotizacion")
	private By cmbProductoCotizacion = By.name("producto_cotizacion");

	// @FindBy(xpath = ".//*[@title='Número cotización']")
	private By txtResultadosNumeroCotizacion = By.xpath(".//*[@title='Número cotización']");

	// @FindBy(xpath = ".//*[@title='Mostrar acciones']")
	private By btnMostrarAcciones = By.xpath(".//*[@title='Mostrar acciones']");

	// @FindBy(xpath = ".//*[text()='Modificar']")
	private By btnModificar = By.xpath(".//*[text()='Modificar']");

	// @FindBy(xpath = ".//*[text()='Alta Como']")
	private By btnAltaComo = By.xpath(".//*[text()='Alta Como']");

	// @FindBy(css = "#capaAjax > table > tbody > tr:nth-child(2) >
	// td:nth-child(8)")
	private By estadoCotizacion = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(8)");
	// endregion

	public GestionCotizacionesBuscadorPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void searchCotizacion(String cotizacion) {
		debugBegin();
		
		this.webDriver.clickInFrame(this.rdnNoCotizacion, this.mainFrame);
		if(cotizacion == "Mec")
		// if
		// (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaEdificioConfort))
		{
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaEdificioConfort);
		} else if(cotizacion == "Mac")
		// else if
		// (this.tData.getAcceso().equals(MutuaPropietariosConstants.MutuaAlquierConfort))
		{
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbProductoCotizacion, this.mainFrame, ProjectConstants.MutuaAlquierConfort);
		}

		this.webDriver.appendTextInFrame(this.txtNumeroCotizacion, this.mainFrame, this.testDataM.getTestVar(testId, "CotizacionNum"));
		this.webDriver.clickInFrame(this.btnBuscar, this.mainFrame);
		
		debugEnd();
	}

	public String getCotizacion() {
		debugBegin();
		String cotizacion = this.webDriver.getTextInFrame(this.txtResultadosNumeroCotizacion, this.mainFrame);
		debugEnd();
		return cotizacion;
	}

	public void modificarProjecto() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnMostrarAcciones, this.mainFrame);
		this.webDriver.clickInFrame(this.btnModificar, this.mainFrame);
		debugEnd();
	}

	public String getEstadoCotizacion() {
		debugBegin();
		String result = this.webDriver.getTextInFrame(this.estadoCotizacion, this.mainFrame);
		debugEnd();
		return result;
	}
	// endregion
}
