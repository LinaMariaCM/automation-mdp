package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class MediadoresFichaMediadorPage extends PageObject {

	MediadoresFichaMediadorPage(UserStory userS) {
		super(userS);
	}

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
	// @FindBy(css = "h1.titulopagina")
	// private WebElement tituloPagina;
	// // endregion
	//
	// public MediadoresFichaMediadorPage(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public String getContenidoTituloPagina()
	// {
	// logger.debug("BEGIN - getContenidoTituloPagina");
	// String contenido =
	// this.wh.getTextFromWebElementInFrame(this.tituloPagina, this.mainFrame);
	// logger.debug("END - getContenidoTituloPagina");
	// return contenido;
	// }
	// endregion
}
