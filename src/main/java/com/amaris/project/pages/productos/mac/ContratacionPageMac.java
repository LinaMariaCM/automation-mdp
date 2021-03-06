package com.amaris.project.pages.productos.mac;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import org.openqa.selenium.By;

public class ContratacionPageMac extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By btnContratar = By.cssSelector("#btnContratar");
	private By errorMessageTxt = By.id("VALIDACONTR");

	private By messagePolizaTxt = By.xpath("./html/body/table[1]/tbody/tr/td");
	private By messageReciboTxt = By.xpath("./html/body/table[1]/tbody/tr/td");
	// endregion

	public ContratacionPageMac(UserStory userS) {
		super(userS);
	}

	public ContratacionPageMac seleccionarCheckYContratar() {
		debugBegin();

		// Marcar el check
		// webDriver.waitWithDriver(6000);
		// if (webDriver.isPresentInFrame(checkLopd, mainFrame))
		// {webDriver.clickInFrame(checkLopd, mainFrame);}

		// Contratar
		webDriver.clickInFrame(btnContratar, mainFrame);
		debugEnd();

		return this;
	}

	public boolean checkPolizaError() {
		debugBegin();

		boolean res = false;

		if(webDriver.isPresentInFrame(errorMessageTxt, mainFrame)
			&& webDriver.getTextInFrame(errorMessageTxt, mainFrame).contains("¡Error! No se puede emitir la póliza, "
				+ "el proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios para el estudio de viabilidad en el paso anterior "
				+ "y esperar la respuesta vía email o bien en Mis proyectos web")) {
			res = true;
		}

		debugEnd();

		return res;
	}

	public boolean checkPolizaCreada() {
		debugBegin();

		boolean res = false;

		if(webDriver.isPresentInFrame(messagePolizaTxt, mainFrame)
			&& webDriver.isPresentInFrame(messageReciboTxt, mainFrame)
			&& webDriver.getTextInFrame(messagePolizaTxt, mainFrame).contains("ha sido dada de alta correctamente")
			&& webDriver.getTextInFrame(messageReciboTxt, mainFrame).contains("se ha generado correctamente")) {
			res = true;
		}

		debugEnd();

		return res;
	}

}