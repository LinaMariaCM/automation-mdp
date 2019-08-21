package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amaris.project.Constants;

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
		webDriver.clickInFrame(chbxContratoContratacion, mainFrame);

		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			webDriver.clickInFrame(chbxAceptacionMediador, mainFrame);
		}

		webDriver.clickInFrame(chbxTitularidadContratacion, mainFrame);

		webDriver.appendTextInFrame(txtFile, mainFrame, System.getProperty("user.dir") + "/resources/documentos_anyadidos/codeconventions.pdf");

		webDriver.clickInFrame(btnAnadirContratacion, mainFrame);
		webDriver.clickInFrame(btnCerrar, mainFrame);

		debugEnd();

		return this;
	}

}
