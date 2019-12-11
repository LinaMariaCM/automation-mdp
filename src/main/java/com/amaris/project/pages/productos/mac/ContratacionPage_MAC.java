package com.amaris.project.pages.productos.mac;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import org.openqa.selenium.By;

public class ContratacionPage_MAC extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");
	private By btnContratar = By.cssSelector("#btnContratar");
	private By errorMessage = By.id("VALIDACONTR");

	private By checkLopd = By.cssSelector("#chkLopd");

	private By messagePoliza = By.xpath("./html/body/table[1]/tbody/tr/td");
	private By messageRecibo = By.xpath("./html/body/table[1]/tbody/tr/td");
	// endregion

	public ContratacionPage_MAC(UserStory userS) {
		super(userS);
	}

	public ContratacionPage_MAC ExecuteActionsInContratacionPage() {
		debugBegin();
		// Add datos tomador
		new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();

		// Add datos inmueble
		new InmueblePage_MAC(userS).executeActionsInInmueblePage();

		// Add documentacion
		new DocumentacionPage_MAC(userS).addDocumentContratacion();

		// Tick lopd and click contratar
		seleccionarCheckYContratar();

		debugEnd();

		return this;
	}

	public ContratacionPage_MAC seleccionarCheckYContratar() {
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

		if(webDriver.isPresentInFrame(errorMessage, mainFrame)
			&& webDriver.getTextInFrame(errorMessage, mainFrame).contains("¡Error! No se puede emitir la póliza, "
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

		if(webDriver.isPresentInFrame(messagePoliza, mainFrame)
			&& webDriver.isPresentInFrame(messageRecibo, mainFrame)
			&& webDriver.getTextInFrame(messagePoliza, mainFrame).contains("ha sido dada de alta correctamente")
			&& webDriver.getTextInFrame(messageRecibo, mainFrame).contains("se ha generado correctamente")) {
			res = true;
		}

		debugEnd();

		return res;
	}

}