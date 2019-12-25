package com.amaris.project.pages.administracion.siniestros;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class HomeSiniestrosPage extends PageObject {

	// region WebElements
	private By menuFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By cuerpoFrame = By.id("mainFrame");

	private By aperturaAltaBtn = By.id("jt2");
	private By aperturaModificarBtn = By.id("jt3");
//	private By gestionSiniestrosBtn = By.id("jt5");
	private By gestionSiniestrosBtn = By.cssSelector("[href*='codmenu=GESTIONDSINIESTRO']");
	private By gestionPagosBtn = By.id("jt6");
	private By altaEventoBtn = By.id("jt8");
	private By gestionEventosBtn = By.id("jt9");

	// private By nPoliza = By.xpath("/html/body/table/tbody/tr/td[1]/table/tbody/tr[1]/td[1]");
	private By numPolizaTxt = By.cssSelector("form[name='formDatos'] table table td:first-of-type");
	private By causa = By.xpath("/html/body/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]");

	// endregion

	public HomeSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public HomeSiniestrosPage openAperturaAlta() {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(aperturaAltaBtn, menuFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openAperturaModificar() {
		debugBegin();
		webDriver.clickInFrame(aperturaModificarBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionSiniestros() {
		debugBegin();
		webDriver.clickInFrame(gestionSiniestrosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionPagos() {
		debugBegin();
		webDriver.clickInFrame(gestionPagosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openAltaEvento() {
		debugBegin();
		webDriver.clickInFrame(altaEventoBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionEventos() {
		debugBegin();
		webDriver.clickInFrame(gestionEventosBtn, menuFrame);
		debugEnd();

		return this;
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

	// endregion
}
