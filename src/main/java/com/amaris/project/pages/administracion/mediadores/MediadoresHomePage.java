package com.amaris.project.pages.administracion.mediadores;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresHomePage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");


	private By gestionMediadoresBtn = By.cssSelector("a[id='jt1']");
	private By traspasoCarteraBtn = By.cssSelector("a[id='jt2']");
	private By importarMarcasBtn = By.cssSelector("a[id='jt3']");

	private By altaBtn = By.cssSelector("a[id='jt4']");
	private By altaProspectBtn = By.cssSelector("a[id='jt5']");
	private By altaMediadorBtn = By.cssSelector("a[id='jt6']");

	private By comisionesSobrecomisionesBtn = By.cssSelector("a[id='jt7']");
	private By matricesBtn = By.cssSelector("a[id='jt8']");
	private By arbolesBtn = By.cssSelector("a[id='jt9']");

	private By DgsBtn = By.cssSelector("a[id='jt10']");
	private By envioBtn = By.cssSelector("a[id='jt11']");
	private By recepcionBtn = By.cssSelector("a[id='jt12']");


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
