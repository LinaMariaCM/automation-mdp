package com.amaris.project.pages.administracion.MEC;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class AltaDireccionMEC extends PageObject {

	private By proyectoNuevo = By.cssSelector("a[onclick*='codmenu=510_NUEVA_COTIZACION']");
//	private By gestionSiniestrosBtn = By.cssSelector("[href*='codmenu=GESTIONDSINIESTRO']");

	private By menuFrame = By.cssSelector("#leftFrame");
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By codigoMediadorInput = By.cssSelector("#codigoMediador");
	private By buscarMediadorBtn = By.cssSelector("button[type='submit']");
	private By seleccionarMediadorRadio = By.cssSelector("input[name='mediatorSelect']");
	private By continuarMediadorBtn = By.linkText("Continuar");

	private By anyadirInuebleBtn = By.cssSelector("button[data-target='#inmuebleModal']");
	private By refCatastralRadio = By.cssSelector("#critCatastro");
	private By refCatastralInput = By.cssSelector("#crefCatastral");
	private By buscarRefCatastralBtn = By.cssSelector("#formFoot > div > div > a");
	private By resultadoBuscarCopyTxt = By.cssSelector("#inmuebleModal > div > div > div.modal-body > div > div.row.margin-top-10.ng-scope > p");
	//	Selecciona las áreas a asegurar
	private By anyadirInmuebleModalBtn = By.cssSelector("#inmuebleModal > div > div > div.modal-footer > button.btn.btn-primary.ng-binding");

	public AltaDireccionMEC(UserStory userS) {
		super(userS);
	}

	public AltaDireccionMEC openAltaMEC() {
		debugBegin();
		webDriver.clickInFrame(proyectoNuevo, menuFrame);
		debugEnd();
		return this;
	}

	public AltaDireccionMEC buscarMediadorPorId() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.appendText(codigoMediadorInput, "640"); // revisar si es el mediador
		webDriver.click(buscarMediadorBtn);
		webDriver.click(seleccionarMediadorRadio);
		webDriver.click(continuarMediadorBtn);
		webDriver.exitFrame();
		debugEnd();
		return this;

	}

	public AltaDireccionMEC anyadirRefCatastral() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirInuebleBtn);
		webDriver.waitWithDriver(2400);
		webDriver.click(refCatastralRadio);
		webDriver.appendText(refCatastralInput, "002 006 10 002"); // revisar 5332101WG0753S
		webDriver.click(buscarRefCatastralBtn);
		webDriver.waitForElementToBePresent(resultadoBuscarCopyTxt);
		//webDriver.isPresent(resultadoBuscarCopyTxt);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

} //page ends
