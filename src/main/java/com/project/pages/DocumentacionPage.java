package com.project.pages;

import java.awt.AWTException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.FileUploadHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DocumentacionPage
{
	final static Logger logger = LoggerFactory.getLogger(DetallesRiesgoPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	@FindBy(id = "leftFrame")
	private WebElement leftFrame;

	@FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(1) > div > div.row.margin-top-10 > div > div > table > tbody > tr:nth-child(2) > td > button")
	private WebElement anadirDocumentoPendiente;

	// @FindBy(xpath = ".//*[@data-ng-click='d.initializeModalSubirFichero()']")
	// @FindBy(css = "#subirFicheroModal > div > div > form > div.modal-footer > div > button.btn.btn-primary.ng-binding")
	@FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(2) > div > div:nth-child(2) > div > div > table > tbody > tr > td > button")
	private WebElement btnSubirFichero;
	
	@FindBy(css = "#subirFicheroModal > div > div > form > div.modal-footer > div > button.btn.btn-primary.ng-binding")
	private WebElement btnSubirFicheroModal;

	@FindBy(xpath = ".//*[text()='Seleccionar fichero']")
	private WebElement btnSeleccionarFichero;

	// @FindBy(xpath = ".//tr[td[text()='Aceptación del mediador']]/td[1]/input")
	@FindBy(id = "docContenido_0")
	private WebElement chkAceptacionMediador;

	@FindBy(xpath = ".//*[text()='Continuar']")
	private WebElement btnContinuar;

	@FindBy(xpath = ".//*[text()='8. Documentación']")
	private WebElement btnDocumentacion;
	// endregion

	public DocumentacionPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods
	public void SubirFichero() throws AWTException, URISyntaxException
	{
		logger.debug("BEGIN - SubirFichero");
		if (this.tData.getUsuario().equals("calbets"))
		{
			// this.wh.switchToFrame(this.leftFrame);
			// this.wh.clickOnWebElement(this.btnDocumentacion);
			// this.wh.exitFromFrame();

			this.wh.switchToFrame(this.cuerpoFrame);

			// this.wh.clickOnWebElement(this.anadirDocumentoPendiente);
			this.wh.clickOnWebElement(this.btnSubirFichero);

			URL url = this.getClass().getResource("/gatoimagen.jpg");
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			this.btnSeleccionarFichero.click();
			// this.wh.ClickOnWebElement(this.btnSeleccionarFichero);
			// this.wh.MoveToElementInFrameAndClickWithJavaScript(this.btnSeleccionarFichero, this.cuerpoFrame);

			FileUploadHelper.uploadFIle(path);
			// Alert alert = this.browserContext.GetWebDriver().switchTo().alert();
			// alert.sendKeys(path);

			// this.wh.SendValueToWebElementInFrame(this.btnSeleccionarFichero, this.cuerpoFrame, path);
			this.wh.clickOnWebElement(this.chkAceptacionMediador);
			this.wh.clickOnWebElement(this.btnSubirFicheroModal);
			this.wh.clickOnWebElement(this.btnContinuar);
			this.wh.exitFromFrame();
		}
		
		logger.debug("BEGIN - SubirFichero");
	}

	public void ClickOnContinuar()
	{
		logger.debug("BEGIN - ClickOnContinuar");
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}
	// endregion
}
