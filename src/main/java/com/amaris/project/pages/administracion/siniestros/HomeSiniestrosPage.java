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

	private By btnAperturaAlta = By.id("jt2");
	private By btnAperturaModificar = By.id("jt3");
	private By btnGestionSiniestros = By.id("jt5");
	private By btnGestionPagos = By.id("jt6");
	private By btnAltaEvento = By.id("jt8");
	private By btnGestionEventos = By.id("jt9");

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
		webDriver.clickInFrame(btnAperturaAlta, menuFrame);
		ActionSteps.waitForIt(webDriver);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openAperturaModificar() {
		debugBegin();
		webDriver.clickInFrame(btnAperturaModificar, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionSiniestros() {
		debugBegin();
		webDriver.doubleClickInFrame(btnGestionSiniestros, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionPagos() {
		debugBegin();
		webDriver.doubleClickInFrame(btnGestionPagos, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openAltaEvento() {
		debugBegin();
		webDriver.doubleClickInFrame(btnAltaEvento, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage openGestionEventos() {
		debugBegin();
		webDriver.doubleClickInFrame(btnGestionEventos, menuFrame);
		debugEnd();

		return this;
	}

	public HomeSiniestrosPage compararCampos() {
		debugBegin();

		String numPoliza = webDriver.getText(nPoliza).substring(20);
		if(numPoliza.compareTo(getTestVar(Constants.NUM_POLIZA)) == 0) {
			Assert.assertTrue(true, "COMPARAR CAMPOS : el número de póliza coincide.");
			System.out.println("COMPARAR CAMPOS : el número de póliza coincide.");
		} else {
			Assert.assertTrue(false, "COMPARAR CAMPOS : póliza : El número NO coincide.");
			System.out.println("COMPARAR CAMPOS : póliza : El número NO coincide.");
		}

		System.out.println("poliza csv = " + getTestVar(Constants.NUM_POLIZA));
		System.out.println("poliza numPoliza = " + webDriver.getText(nPoliza));
		System.out.println("poliza subString = " + numPoliza);
		int testAAA = numPoliza.compareTo(getTestVar(Constants.NUM_POLIZA));
		System.out.println("result compare to: " + testAAA);

		// TODO añadir campos adicionales

		debugEnd();
		return this;
	}

	// endregion
}
