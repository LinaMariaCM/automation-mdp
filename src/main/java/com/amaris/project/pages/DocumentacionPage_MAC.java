package com.amaris.project.pages;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import java.awt.AWTException;

import org.openqa.selenium.By;

import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPage_MAC extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By btnAnadirDocumentacionPantallaPrincipal = By.cssSelector("#botonAddDoc");
	private By chbxContrato = By.cssSelector("");
	private By chbxContratoContratacion = By.cssSelector("#DR50");
	private By chbxAceptacionMediador = By.cssSelector("#DR51");
	private By chbxTitularidad = By.cssSelector("#DR52");
	private By chbxTitularidadContratacion = By.cssSelector("#DR53");
	private By txtFile = By.cssSelector("#fichero");
	private By btnAnadirContratacion = By.cssSelector("#addDocumento");
	private By btnAnadirDoc = By.cssSelector("#drop-area label");
	private By btnCerrar = By.cssSelector("#modalAddDocu > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)");
	private By chbxAceptacion = By.xpath(".//*[text()='Aceptación del mediador']");
	// endregion

	public DocumentacionPage_MAC(UserStory userS) {
		super(userS);
	}

	public DocumentacionPage_MAC ExecuteActionsInDocumentacionPage() {
		debugBegin();

		webDriver.clickInFrame(btnAnadirDocumentacionPantallaPrincipal, mainFrame);
		webDriver.clickInFrame(chbxContrato, mainFrame);
		webDriver.clickInFrame(chbxAceptacion, mainFrame);
		webDriver.clickInFrame(chbxTitularidad, mainFrame);

		debugEnd();

		return this;
	}

	public DocumentacionPage_MAC addDocumentContratacion() {
		debugBegin();
		
		webDriver.clickInFrame(btnAnadirDocumentacionPantallaPrincipal, mainFrame);
		webDriver.clickInFrame(btnAnadirDoc, mainFrame);
		
		debugInfo("Boton añadir");
		adjuntarDocumentos();

		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			webDriver.clickInFrame(chbxAceptacionMediador, mainFrame);
		}

		webDriver.clickInFrame(chbxTitularidadContratacion, mainFrame);

		webDriver.waitWithDriver(30000);
		webDriver.clickInFrame(btnCerrar, mainFrame);

		debugEnd();

		return this;
	}
	
	public void adjuntarDocumentos() {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(5000);
		FileHelper.uploadFIle(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf");
		debugInfo("Fichero subido");

		debugEnd();
	}
}