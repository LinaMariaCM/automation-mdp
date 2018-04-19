package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class MediadoresFichaMediadorPage
{
	final static Logger logger = LoggerFactory.getLogger(MediadoresFichaMediadorPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(id = "leftFrame")
	private WebElement menuFrame;
	
	@FindBy(id = "topFrame")
	private WebElement topFrame;
	
	@FindBy(id = "mainFrame")
	private WebElement mainFrame;
	
	@FindBy(css = "h1.titulopagina")
	private WebElement tituloPagina;
	// endregion
	
	public MediadoresFichaMediadorPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	public String getContenidoTituloPagina()
	{
		logger.debug("BEGIN - getContenidoTituloPagina");
		String contenido = this.wh.getTextFromWebElementInFrame(this.tituloPagina, this.mainFrame);
		logger.debug("END - getContenidoTituloPagina");
		return contenido;
	}
	// endregion
}
