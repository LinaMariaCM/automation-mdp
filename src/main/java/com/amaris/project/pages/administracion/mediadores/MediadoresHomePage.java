package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresHomePage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By gestionMediadoresBtn = By.cssSelector("#jt1");
	private By traspasoCarteraBtn = By.cssSelector("#jt2");
	private By importarMarcasBtn = By.cssSelector("#jt3");

	private By altaBtn = By.cssSelector("#jt4");
	private By altaProspectBtn = By.cssSelector("#jt5");
	private By altaMediadorBtn = By.cssSelector("#jt6");

	private By comisionesSobrecomisionesBtn = By.cssSelector("#jt7");
	private By matricesBtn = By.cssSelector("#jt8");
	private By arbolesBtn = By.cssSelector("#jt9");

	private By dgsBtn = By.cssSelector("#jt10");
	private By envioBtn = By.cssSelector("#jt11");
	private By recepcionBtn = By.cssSelector("#jt12");

	private By codigoMediadorBuscadorInput = By.cssSelector("#BUSMED_CODIMEDI");


	public MediadoresHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public MediadoresHomePage openGestionMediadores() {
		debugBegin();
		webDriver.clickInFrame(gestionMediadoresBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openTraspasoCartera() {
		debugBegin();
		webDriver.clickInFrame(traspasoCarteraBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openImportarMarca() {
		debugBegin();
		webDriver.clickInFrame(importarMarcasBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openAltaProspect() {
		debugBegin();
		webDriver.clickInFrame(altaProspectBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openAltaMediador() {
		debugBegin();
		webDriver.waitForElementToBePresentInFrame(codigoMediadorBuscadorInput, cuerpoFrame);
		webDriver.doubleClickInFrame(altaMediadorBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openMatrices() {
		debugBegin();
		webDriver.clickInFrame(matricesBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openArboles() {
		debugBegin();
		webDriver.clickInFrame(arbolesBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openEnvio() {
		debugBegin();
		webDriver.clickInFrame(envioBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openRecepcion() {
		debugBegin();
		webDriver.clickInFrame(recepcionBtn, menuFrame);
		debugEnd();

		return this;
	}
	// endregion
}
