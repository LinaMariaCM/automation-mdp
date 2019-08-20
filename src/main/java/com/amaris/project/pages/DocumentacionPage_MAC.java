package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import java.awt.AWTException;

import org.openqa.selenium.By;
import com.amaris.project.ProjectConstants;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPage_MAC extends PageObject {

	public DocumentacionPage_MAC(UserStory userS) {
		super(userS);
	}

	// region webelements
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
	private By btnCerrar = By.cssSelector("#modalAddDocu > div > div > div.modal-footer > button");

	// public void ExecuteActionsInDocumentacionPage() throws
	// InterruptedException, IOException
	// {
	// logger.debug("BEGIN - ExecuteActionsInDocumentacionPage");
	//
	// // Click btn add documentacion
	// this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentacionPantallaPrincipal,
	// this.mainFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxContrato,
	// this.mainFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxAceptacion,
	// this.mainFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxTitularidad,
	// this.mainFrame);
	//
	// logger.debug("END - ExecuteActionsInDocumentacionPage");
	// }
	//
	public void addDocumentContratacion() throws AWTException, InterruptedException {
		debugBegin();

		this.webDriver.clickInFrame(this.btnAnadirDocumentacionPantallaPrincipal, this.mainFrame);
		this.webDriver.clickInFrame(btnAnadirDoc, mainFrame);
		debugInfo("boton añadir");
		adjuntarDocumentos();
		// Click chkboxes
		//this.webDriver.clickInFrame(this.chbxContratoContratacion, this.mainFrame);

		if(this.getScenarioVar("acceso").equals(ProjectConstants.LoginAccessInnova)) {
			this.webDriver.clickInFrame(this.chbxAceptacionMediador, this.mainFrame);
		}
		//this.webDriver.clickInFrame(this.chbxTitularidadContratacion, this.mainFrame);
		// this.webDriver.switchToFrame(this.mainFrame);
		// this.webDriver.sendKeysFrame(this.txtFile, this.mainFrame,
		// "C:/Users/amaris2/Desktop/prueba.pdf");

		// this.webDriver.appendTextInFrame(this.txtFile, this.mainFrame,
		// "C:/Users/User/git/codeconventions.pdf");

		//this.webDriver.appendTextInFrame(this.txtFile, this.mainFrame, "C:/Users/User/git/mdp/resources/documentos_anyadidos/codeconventions.pdf");

		// this.webDriver.exitFromFrame();
		//this.webDriver.clickInFrame(this.btnAnadirContratacion, this.mainFrame);
		webDriver.waitWithDriver(30000);
		this.webDriver.clickInFrame(this.btnCerrar, this.mainFrame);

		debugEnd();
	}
	public void adjuntarDocumentos() throws AWTException {
		debugBegin();
		// TODO: mover la ruta de fichero de upload a configuracion
		webDriver.waitWithDriver(5000);
		FileHelper.uploadFIle("C:\\Users\\MALI\\Desktop\\fichero_Mutua.txt");
		debugInfo("fichero subido");
//		this.webDriver.appendTextInFrame(this.elmntFichero, this.mainFrame, System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "prueba_normas_de_protocolo.pdf");
		// this.webDriver.sendKeysFrame(this.elmntFichero, this.mainFrame,
		// "C:/Users/chris/Desktop/New Text Document.txt");
		debugEnd();
	}

}
