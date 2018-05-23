package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

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
	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(xpath = ".//*[text()='Añadir documentación']")
	// private WebElement btnAnadirDocumentacionPantallaPrincipal;
	//
	// @FindBy(xpath = ".//*[text()='Contrato de alquiler o proforma']")
	// private WebElement chbxContrato;
	//
	// @FindBy(xpath = "//*[@id='DR50']")
	// private WebElement chbxContratoContratacion;
	//
	// @FindBy(xpath = ".//*[text()='Aceptación del mediador']")
	// private WebElement chbxAceptacion;
	//
	// @FindBy(xpath = ".//*[text()='Titularidad de la cuenta']")
	// private WebElement chbxTitularidad;
	//
	// @FindBy(xpath = "//*[@id='DR53']")
	// private WebElement chbxTitularidadContratacion;
	//
	// @FindBy(id = "DR51")
	// private WebElement chbxAceptacionMediador;
	//
	// @FindBy(xpath = ".//*[@id='fichero']")
	// private WebElement txtFile;
	//
	// @FindBy(xpath = ".//*[@id='addDocumento']")
	// private WebElement btnAnadirContratacion;
	//
	// @FindBy(xpath = ".//*[@id='modalAddDocu']/div/div/div[3]/button")
	// private WebElement btnCerrar;
	//
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
	// this.cuerpoFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxContrato,
	// this.cuerpoFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxAceptacion,
	// this.cuerpoFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrameWithJavaScript(this.chbxTitularidad,
	// this.cuerpoFrame);
	//
	// logger.debug("END - ExecuteActionsInDocumentacionPage");
	// }
	//
	// public void addDocumentContratacion()
	// {
	// logger.debug("BEGIN - addDocument");
	// this.wh.clickOnWebElementInFrame(this.btnAnadirDocumentacionPantallaPrincipal,
	// this.cuerpoFrame);
	//
	// // Click chkboxes
	// this.wh.clickOnWebElementInFrame(this.chbxContratoContratacion,
	// this.cuerpoFrame);
	//
	// if (this.tData.getAcceso().equals(ProjectConstants.LoginAccessInnova))
	// {
	// this.wh.clickOnWebElementInFrame(this.chbxAceptacionMediador,
	// this.cuerpoFrame);
	// }
	//
	// this.wh.clickOnWebElementInFrame(this.chbxTitularidadContratacion,
	// this.cuerpoFrame);
	//
	// this.wh.switchToFrame(this.cuerpoFrame);
	// this.txtFile.sendKeys("C:/Users/amaris2/Desktop/prueba.pdf");
	// this.wh.exitFromFrame();
	// this.wh.clickOnWebElementInFrame(this.btnAnadirContratacion,
	// this.cuerpoFrame);
	// this.wh.clickOnWebElementInFrame(this.btnCerrar, this.cuerpoFrame);
	// logger.debug("END - addDocument");
	// }
	//
}
