package com.amaris.project.pages;

import java.awt.AWTException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(id = "leftFrame")
	private By leftFrame = By.cssSelector("#leftFrame");

	// @FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope >
	// form > div > div:nth-child(1) > div > div.row.margin-top-10 > div > div >
	// table > tbody > tr:nth-child(2) > td > button")
	private By anadirDocumentoPendiente = By
		.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(1) > div > div.row.margin-top-10 > div > div > table > tbody > tr:nth-child(2) > td > button");

	// @FindBy(xpath = ".//*[@data-ng-click='d.initializeModalSubirFichero()']")
	// @FindBy(css = "#subirFicheroModal > div > div > form > div.modal-footer >
	// div > button.btn.btn-primary.ng-binding")
	// @FindBy(css = "body > div > div:nth-child(1) > div.container.ng-scope >
	// form > div > div:nth-child(2) > div > div:nth-child(2) > div > div >
	// table > tbody > tr > td > button")
	private By btnSubirFichero = By
		.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(2) > div > div:nth-child(2) > div > div > table > tbody > tr > td > button");

	// @FindBy(css = "#subirFicheroModal > div > div > form > div.modal-footer >
	// div > button.btn.btn-primary.ng-binding")
	private By btnSubirFicheroModal = By.cssSelector("#subirFicheroModal > div > div > form > div.modal-footer > div > button.btn.btn-primary.ng-binding");

	// @FindBy(xpath = ".//*[text()='Seleccionar fichero']")
	private By btnSeleccionarFichero = By.xpath(".//*[text()='Seleccionar fichero']");

	// @FindBy(xpath = ".//tr[td[text()='Aceptación del
	// mediador']]/td[1]/input")
	// @FindBy(id = "docContenido_0")
	private By chkAceptacionMediador = By.xpath(".//tr[td[text()='Aceptación del mediador']]/td[1]/input");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	// @FindBy(xpath = ".//*[text()='8. Documentación']")
	private By btnDocumentacion = By.xpath(".//*[text()='8. Documentación']");
	// endregion

	public DocumentacionPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DocumentacionPage SubirFichero() throws AWTException, URISyntaxException {
		debugBegin();

		if(this.getTestVar("Usuario").equals("calbets")) {
			// this.wh.switchToFrame(this.leftFrame);
			// this.wh.clickOnWebElement(this.btnDocumentacion);
			// this.wh.exitFromFrame();

			this.webDriver.switchToFrame(this.cuerpoFrame);

			// this.wh.clickOnWebElement(this.anadirDocumentoPendiente);
			this.webDriver.click(this.btnSubirFichero);

			URL url = this.getClass().getResource("/gatoimagen.jpg");
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			// this.btnSeleccionarFichero.click();
			this.webDriver.click(this.btnSeleccionarFichero);
			// this.wh.ClickOnWebElement(this.btnSeleccionarFichero);
			// this.wh.MoveToElementInFrameAndClickWithJavaScript(this.btnSeleccionarFichero,
			// this.cuerpoFrame);

			FileHelper.uploadFIle(path);
			// Alert alert =
			// this.browserContext.GetWebDriver().switchTo().alert();
			// alert.sendKeys(path);

			// this.wh.SendValueToWebElementInFrame(this.btnSeleccionarFichero,
			// this.cuerpoFrame, path);
			this.webDriver.click(this.chkAceptacionMediador);
			this.webDriver.click(this.btnSubirFicheroModal);
			this.webDriver.click(this.btnContinuar);
			this.webDriver.exitFrame();
		}

		debugEnd();

		return this;
	}

	public DocumentacionPage ClickOnContinuar() {
		debugBegin();
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
