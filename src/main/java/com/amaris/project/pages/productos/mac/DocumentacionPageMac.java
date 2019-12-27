package com.amaris.project.pages.productos.mac;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import org.openqa.selenium.By;

import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPageMac extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By anyadirDocumentacionPantallaPrincipalBtn = By.cssSelector("#botonAddDoc");
	private By contratoBtn = By.cssSelector("");
	private By aceptacionMediadorBtn = By.cssSelector("#DR51");
	private By titularidadBtn = By.cssSelector("#DR52");
	private By anadirDocBtn = By.cssSelector("#drop-area label");
	private By cerrarBtn = By.cssSelector("#modalAddDocu > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)");
	private By aceptacionBtn = By.xpath(".//*[text()='Aceptación del mediador']");
	// endregion

	public DocumentacionPageMac(UserStory userS) {
		super(userS);
	}

	public DocumentacionPageMac executeActionsInDocumentacionPage() {
		debugBegin();

		webDriver.clickInFrame(anyadirDocumentacionPantallaPrincipalBtn, mainFrame);
		webDriver.clickInFrame(contratoBtn, mainFrame);
		webDriver.clickInFrame(aceptacionBtn, mainFrame);
		webDriver.clickInFrame(titularidadBtn, mainFrame);

		debugEnd();

		return this;
	}

	public DocumentacionPageMac addDocumentContratacion() {
		debugBegin();

		webDriver.clickInFrame(anyadirDocumentacionPantallaPrincipalBtn, mainFrame);
		webDriver.clickInFrame(anadirDocBtn, mainFrame);

		debugInfo("Boton añadir");
		adjuntarDocumentos();

		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			webDriver.clickInFrame(aceptacionMediadorBtn, mainFrame);
		}

		// webDriver.clickInFrame(chbxTitularidadContratacion, mainFrame);

		webDriver.waitWithDriver(30000);
		webDriver.clickInFrame(cerrarBtn, mainFrame);

		debugEnd();

		return this;
	}

	public void adjuntarDocumentos() {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(5000);
		FileHelper.uploadFile(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf");
		debugInfo("Fichero subido");

		debugEnd();
	}
}