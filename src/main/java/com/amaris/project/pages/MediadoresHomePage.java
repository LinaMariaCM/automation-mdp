package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresHomePage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By btnAltaProspect = By.xpath(".//*[contains(@title,'Prospect')]");
	private By btnAltaMediador = By.xpath(".//*[contains(@title,'Mediador  ')]");
	private By btnMatrices = By.xpath(".//*[contains(@title,'Matrices')]");
	private By btnArboles = By.xpath(".//*[contains(@title,'Árboles')]");
	private By btnEnvio = By.xpath(".//*[contains(@title,'Envío')]");
	private By btnRecepcion = By.xpath(".//*[contains(@title,'Recepción')");
	// endregion

	public MediadoresHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public MediadoresHomePage openAltaProspect() {
		debugBegin();
		webDriver.doubleClickInFrame(btnAltaProspect, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openAltaMediador() {
		debugBegin();
		webDriver.doubleClickInFrame(btnAltaMediador, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openMatrices() {
		debugBegin();
		webDriver.doubleClickInFrame(btnMatrices, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openArboles() {
		debugBegin();
		webDriver.doubleClickInFrame(btnArboles, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openEnvio() {
		debugBegin();
		webDriver.doubleClickInFrame(btnEnvio, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openRecepcion() {
		debugBegin();
		webDriver.doubleClickInFrame(btnRecepcion, menuFrame);
		debugEnd();

		return this;
	}
	// endregion
}
