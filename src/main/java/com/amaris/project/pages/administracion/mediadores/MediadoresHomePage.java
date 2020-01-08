package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresHomePage extends PageObject {

	// region webelements
	private By menuFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By mainFrame = By.id("mainFrame");

	private By gestionMediadoresBtn = By.id("jt1");
	private By traspasoCarteraBtn = By.id("jt2");
	private By importarMarcasBtn = By.id("jt3");

	private By altaBtn = By.id("jt4");
	private By altaProspectBtn = By.id("jt5");
	private By altaMediadorBtn = By.id("jt6");

	private By comisionesSobrecomisionesBtn = By.id("jt7");
	private By matricesBtn = By.id("jt8");
	private By arbolesBtn = By.id("jt9");

	private By dgsBtn = By.id("jt10");
	private By envioBtn = By.id("jt11");
	private By recepcionBtn = By.id("jt12");

	// region methods
	public MediadoresHomePage openGestionMediadores() {
		debugBegin();
		webDriver.doubleClickInFrame(gestionMediadoresBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openTraspasoCartera() {
		debugBegin();
		webDriver.doubleClickInFrame(traspasoCarteraBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresHomePage openImportarMarca() {
		debugBegin();
		webDriver.doubleClickInFrame(importarMarcasBtn, menuFrame);
		debugEnd();

		return this;
	}

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
