package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

public class SiniestrosAltaAperturaDeclaracionPage extends PageObject {
	
	SiniestrosAltaAperturaDeclaracionPage(UserStory userS) {
		super(userS);
	}
	// final static Logger logger =
	// LoggerFactory.getLogger(SiniestrosAltaAperturaDeclaracionPage.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	//
	// // region webelements
	// @FindBy(id = "leftFrame")
	// private WebElement menuFrame;
	//
	// @FindBy(id = "topFrame")
	// private WebElement topFrame;
	//
	// @FindBy(id = "mainFrame")
	// private WebElement mainFrame;
	//
	// @FindBy(id = "fechsini")
	// private WebElement txtFechaOcurrencia;
	//
	// @FindBy(id = "tipodecl")
	// private WebElement drpdwnTipoDeclarante;
	//
	// @FindBy(id = "mododecl")
	// private WebElement drpdwnMedioDeclaracion;
	//
	// @FindBy(id = "FECHDENU")
	// private WebElement txtFechaDenuncia;
	//
	// @FindBy(id = "asistenciaSi")
	// private WebElement rdbtnAsistenciaSi;
	//
	// @FindBy(id = "asistenciaNo")
	// private WebElement rdbtnAsistenciaNo;
	//
	// @FindBy(id = "botonContinuar")
	// private WebElement btnContinuar;
	// // endregion
	//
	// public SiniestrosAltaAperturaDeclaracionPage(BrowserContext
	// browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void writeFechaOcurrencia(
	// String fechaOcurrencia)
	// {
	// logger.debug("BEGIN - writeFechaOcurrencia");
	// this.wh.sendValueToWebElementInFrame(this.txtFechaOcurrencia,
	// this.mainFrame, fechaOcurrencia);
	// logger.debug("END - writeFechaOcurrencia");
	// }
	//
	// public void selectTipoDeclarante(
	// String tipoDeclarante)
	// {
	// logger.debug("BEGIN - selectTipoDeclarante");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnTipoDeclarante,
	// this.mainFrame, tipoDeclarante);
	// logger.debug("END - selectTipoDeclarante");
	// }
	//
	// public void selectMedioDeclaracion(
	// String medioDeclaracion)
	// {
	// logger.debug("BEGIN - selectMedioDeclaracion");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnMedioDeclaracion,
	// this.mainFrame, medioDeclaracion);
	// logger.debug("END - selectMedioDeclaracion");
	// }
	//
	// public void writeFechaDenuncia(
	// String fechaDenuncia)
	// {
	// logger.debug("BEGIN - writeFechaDenuncia");
	// this.wh.sendValueToWebElementInFrame(this.txtFechaDenuncia,
	// this.mainFrame, fechaDenuncia);
	// logger.debug("END - writeFechaDenuncia");
	// }
	//
	// public void selectAsistenciaSi()
	// {
	// logger.debug("BEGIN - selectAsistenciaSi");
	// this.wh.clickOnWebElementInFrame(this.rdbtnAsistenciaSi, this.mainFrame);
	// logger.debug("END - selectAsistenciaSi");
	// }
	//
	// public void selectAsistenciaNo()
	// {
	// logger.debug("BEGIN - selectAsistenciaNo");
	// this.wh.clickOnWebElementInFrame(this.rdbtnAsistenciaNo, this.mainFrame);
	// logger.debug("END - selectAsistenciaNo");
	// }
	//
	// public void clickContinuar()
	// {
	// logger.debug("BEGIN - clickContinuar");
	// this.wh.clickOnWebElementInFrame(this.btnContinuar, this.mainFrame);
	// logger.debug("END - clickContinuar");
	// }
	// endregion
}