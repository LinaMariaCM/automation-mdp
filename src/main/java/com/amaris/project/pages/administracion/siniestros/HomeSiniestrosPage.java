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
	private By mainFrame = By.id("mainFrame");

	private By aperturaAltaBtn = By.id("jt2");
	private By aperturaModificarBtn = By.id("jt3");
	private By gestionSiniestrosBtn = By.id("jt5");
	private By gestionPagosBtn = By.id("jt6");
	private By altaEventoBtn = By.id("jt8");
	private By gestionEventosBtn = By.id("jt9");

	// private By nPoliza = By.xpath("/html/body/table/tbody/tr/td[1]/table/tbody/tr[1]/td[1]");
	private By nPoliza = By.cssSelector("form[name='formDatos'] table table td:first-of-type");
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
		webDriver.doubleClickInFrame(gestionSiniestrosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionPagos() {
		debugBegin();
		webDriver.doubleClickInFrame(gestionPagosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openAltaEvento() {
		debugBegin();
		webDriver.doubleClickInFrame(altaEventoBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionEventos() {
		debugBegin();
		webDriver.doubleClickInFrame(gestionEventosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage compararCampos() {
		debugBegin();

		// TODO Comprobar si hace falta metodos InFrame
		String numPoliza = webDriver.getText(nPoliza).substring(20);

		Assert.assertTrue(numPoliza.equals(getTestVar(Constants.NUM_POLIZA)), "Comparar campos: el número de póliza coincide.");

		debugInfo("Poliza csv: " + getTestVar(Constants.NUM_POLIZA));
		debugInfo("Poliza numPoliza: " + webDriver.getText(nPoliza));
		debugInfo("Poliza subString: " + numPoliza);

		int testAAA = numPoliza.compareTo(getTestVar(Constants.NUM_POLIZA));
		debugInfo("Result compare to: " + testAAA);

		// TODO añadir campos adicionales

		debugEnd();
		
		return this;
	}

	// endregion
}
