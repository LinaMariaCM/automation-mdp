package com.amaris.project.pages.productos;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.FileHelper;

public class DocumentacionPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");
	private By subirFicheroBtn = By
		.cssSelector("body > div > div:nth-child(1) > div.container.ng-scope > form > div > div:nth-child(2) > div > div:nth-child(2) > div > div > table > tbody > tr > td > button");
	private By subirFicheroModalBtn = By.cssSelector("#subirFicheroModal > div > div > form > div.modal-footer > div > button.btn.btn-primary.ng-binding");

	private By seleccionarFicheroBtn = By.xpath(".//*[text()='Seleccionar fichero']");
	private By aceptacionMediadorBtn = By.xpath(".//tr[td[text()='Aceptación del mediador']]/td[1]/input");

	private By continuarBtn = By.xpath(".//*[text()='Continuar']");
	// endregion

	public DocumentacionPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DocumentacionPage subirFichero() throws URISyntaxException {
		debugBegin();

		if(getTestVar(Constants.USUARIO).equals("calbets")) {
			webDriver.clickInFrame(subirFicheroBtn, cuerpoFrame);

			URL url = getClass().getResource("/gatoimagen.jpg");
			File file = new File(url.toURI());
			String path = file.getAbsolutePath();

			webDriver.clickInFrame(seleccionarFicheroBtn, cuerpoFrame);

			FileHelper.uploadFile(path);

			webDriver.clickInFrame(aceptacionMediadorBtn, cuerpoFrame);
			webDriver.clickInFrame(subirFicheroModalBtn, cuerpoFrame);
			webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public DocumentacionPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	// endregion
}
