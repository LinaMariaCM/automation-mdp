package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresHomePage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By altaProspectBtn = By.xpath(".//*[contains(@title,'Prospect')]");
	private By altaMediadorBtn = By.xpath(".//*[contains(@title,'Mediador  ')]");
	private By matricesBtn = By.xpath(".//*[contains(@title,'Matrices')]");
	private By arbolesBtn = By.xpath(".//*[contains(@title,'Árboles')]");
	private By envioBtn = By.xpath(".//*[contains(@title,'Envío')]");
	private By recepcionBtn = By.xpath(".//*[contains(@title,'Recepción')");
	// endregion

	public MediadoresHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public MediadoresHomePage openAltaProspect() {
		debugBegin();
		webDriver.doubleClickInFrame(altaProspectBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openAltaMediador() {
		debugBegin();
		webDriver.doubleClickInFrame(altaMediadorBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openMatrices() {
		debugBegin();
		webDriver.doubleClickInFrame(matricesBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openArboles() {
		debugBegin();
		webDriver.doubleClickInFrame(arbolesBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openEnvio() {
		debugBegin();
		webDriver.doubleClickInFrame(envioBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openRecepcion() {
		debugBegin();
		webDriver.doubleClickInFrame(recepcionBtn, menuFrame);
		debugEnd();

		return this;
	}
	// endregion
}
