package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import com.project.ProjectConstants;


//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DocumentacionPage_MAC extends PageObject {
	
	public DocumentacionPage_MAC(UserStory userS) {
		super(userS);
	}
	// final static Logger logger =
	// LoggerFactory.getLogger(DocumentacionPage_MAC.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	//
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
	private By btnCerrar = By.cssSelector("#modalAddDocu > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)");

	// public DocumentacionPage_MAC(BrowserContext browserContext)
	// {
	// // this.wh = browserContext.webElementHelper;
	// // PageFactory.initElements(browserContext.getWebDriver(), this);
	//
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	//
	// }
	//
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
	 public void addDocumentContratacion() {
	 	debugBegin();
	 		this.webDriver.clickInFrame(this.btnAnadirDocumentacionPantallaPrincipal, this.mainFrame);

			// Click chkboxes
			this.webDriver.clickInFrame(this.chbxContratoContratacion, this.mainFrame);

			if (this.getScenarioVar("acceso").equals(ProjectConstants.LoginAccessInnova)) {
				this.webDriver.clickInFrame(this.chbxAceptacionMediador, this.mainFrame);
			}
			this.webDriver.clickInFrame(this.chbxTitularidadContratacion, this.mainFrame);
			//this.webDriver.switchToFrame(this.mainFrame);
			//this.webDriver.sendKeysFrame(this.txtFile, this.mainFrame, "C:/Users/amaris2/Desktop/prueba.pdf");

           // this.webDriver.appendTextInFrame(this.txtFile, this.mainFrame, "C:/Users/User/git/codeconventions.pdf");

            this.webDriver.appendTextInFrame(this.txtFile, this.mainFrame, "C:/Users/User/git/mdp/resources/documentos_anyadidos/codeconventions.pdf");

            //this.webDriver.exitFromFrame();
			this.webDriver.clickInFrame(this.btnAnadirContratacion, this.mainFrame);
			this.webDriver.clickInFrame(this.btnCerrar, this.mainFrame);
		 debugEnd();
	 }

}
