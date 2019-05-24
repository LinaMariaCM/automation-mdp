package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasConfirmarPoliza extends PageObject {

	ValidacionExcepcionesReglasConfirmarPoliza(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(name = "botonContinuar")
	// private WebElement btnContinuar;
	//
	// @FindBy(xpath = ".//*[text()='Emitir suplemento' and
	// @ng-click='db.contratar(formDatosBancarios)']")
	// private WebElement btnEmitirSuplemento;
	// // endregion
	//
	// public ValidacionExcepcionesReglasConfirmarPoliza(BrowserContext
	// browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	//
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void ClickOnContinuarButton() throws IOException
	// {
	// logger.debug("BEGIN - ClickOnContinuarButton");
	// // if
	// (this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoInclusionExclusionDescuento)
	// // ||
	// this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoinclusionMaquinaria)
	// // ||
	// this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoInclusionEnergiaSolar))
	// // {
	// this.wh.switchToFrame(this.cuerpoFrame);
	// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
	// this.wh.waitForTwoWebElementsAndCLickOnlyIntheFirstOne(this.btnContinuar,
	// this.btnEmitirSuplemento);
	// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
	// // try
	// // {
	// // // this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);
	// //
	// // this.wh.SwitchToFrame(this.cuerpoFrame);
	// // if (this.btnContinuar.isDisplayed())
	// // {
	// // this.wh.ClickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
	// // }
	// // }
	// // catch (Exception e)
	// // {
	// // logger.trace("el botón continuar no ha aparecido en la pantalla de
	// validadcion de excepciones de reglas confirmar poliza", e);
	// // }
	// // }
	// // this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
	// this.wh.exitFromFrame();
	// logger.debug("END - ClickOnContinuarButton");
	// }
	// // endregion

}
