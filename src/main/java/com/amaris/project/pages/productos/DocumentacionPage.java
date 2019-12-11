package com.amaris.project.pages.productos;

import java.awt.AWTException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By anadirDocumentoPendiente = By
		.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(1) > div > div.row.margin-top-10 > div > div > table > tbody > tr:nth-child(2) > td > button");
	private By btnSubirFichero = By
		.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(2) > div > div:nth-child(2) > div > div > table > tbody > tr > td > button");
	private By btnSubirFicheroModal = By.cssSelector("#subirFicheroModal > div > div > form > div.modal-footer > div > button.btn.btn-primary.ng-binding");

	private By btnSeleccionarFichero = By.xpath(".//*[text()='Seleccionar fichero']");
	private By chkAceptacionMediador = By.xpath(".//tr[td[text()='Aceptación del mediador']]/td[1]/input");

	private By btnContinuar = By.xpath(".//*[text()='Continuar']");
	private By btnDocumentacion = By.xpath(".//*[text()='8. Documentación']");
	// endregion

	public DocumentacionPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DocumentacionPage SubirFichero() throws AWTException, URISyntaxException {
		debugBegin();

		if(getTestVar(Constants.USUARIO).equals("calbets")) {
			webDriver.clickInFrame(btnSubirFichero, cuerpoFrame);

			URL url = getClass().getResource("/gatoimagen.jpg");
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			webDriver.clickInFrame(btnSeleccionarFichero, cuerpoFrame);

			FileHelper.uploadFIle(path);

			webDriver.clickInFrame(chkAceptacionMediador, cuerpoFrame);
			webDriver.clickInFrame(btnSubirFicheroModal, cuerpoFrame);
			webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public DocumentacionPage ClickOnContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
