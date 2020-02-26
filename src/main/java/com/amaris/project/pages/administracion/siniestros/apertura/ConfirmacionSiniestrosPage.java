package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class ConfirmacionSiniestrosPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.id("mainFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By correctoTxt = By.cssSelector("#form1 .marco span.normal strong");

	// private By correcto = By.cssSelector(".normal > strong:nth-child(1)");
	// private By nSiniestro = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody >
	// tr:nth-child(1) > td");
	private By nSiniestroTxt = By.cssSelector("#form1 .marco > table tr > td");

	private By expedienteTxt = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(4) > td > div");
	// private By tramitarSiniestro = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) >
	// a > strong");
	private By tramitarSiniestroBtn = By.cssSelector("#form1 > table.narrowBox.marcofnd > tbody > tr > td:nth-child(2) > a");
	private By mensajeOKTxt = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr > td > span > strong");
	private By volverBtn = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li > a > span");

	private By logoMutuaBtn = By.cssSelector("#logo");
	// endregion

	public ConfirmacionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	// TODO Unir con check
	public ConfirmacionSiniestrosPage confirmarSiniestroOK() {
		debugBegin();

		webDriver.waitWithDriver(5000);
		debugInfo("=====================================");
		debugInfo("Tenga un poco de paciencia por favor.");
		debugInfo("Esto puede tardar unos segundos |||^^ ...");
		debugInfo("=====================================");
		debugInfo("###########################");
		debugInfo("# Mensaje de confirmacion #");
		debugInfo("###########################");
		webDriver.waitWithDriver(10000);
		
		if(webDriver.isPresentInFrame(correctoTxt, cuerpoFrame)) {
			debugInfo("Mensaje: " + webDriver.getTextInFrame(correctoTxt, cuerpoFrame));
			debugInfo(webDriver.getTextInFrame(nSiniestroTxt, cuerpoFrame));

			debugInfo("Expediente generado: " + webDriver.getTextInFrame(expedienteTxt, cuerpoFrame));
			setTestVar(Constants.NUMERO_SINIESTRO, webDriver.getTextInFrame(nSiniestroTxt, cuerpoFrame).substring(26, 34));
			setTestVar(Constants.ANYO_SINIESTRO, webDriver.getTextInFrame(nSiniestroTxt, cuerpoFrame).substring(21, 25));
		} else {
			debugError("Se ha producido un error.");
		}

		debugEnd();

		return this;
	}

	public ConfirmacionSiniestrosPage check() {
		debugBegin();

		debugInfo("###########################");
		debugInfo("# Mensaje de confirmacion #");
		debugInfo("###########################");

		webDriver.waitWithDriver(5000);

		// Need refactor By elements
		if(webDriver.isPresentInFrame(correctoTxt, cuerpoFrame)) {
			debugInfo("Mensaje: " + webDriver.getTextInFrame(correctoTxt, cuerpoFrame));
			debugInfo(webDriver.getTextInFrame(nSiniestroTxt, cuerpoFrame));

			setTestVar(Constants.NUMERO_SINIESTRO, webDriver.getTextInFrame(nSiniestroTxt, cuerpoFrame));

			debugInfo("Expediente generado: " + webDriver.getTextInFrame(expedienteTxt, cuerpoFrame));
		} else {
			debugInfo("Se ha producido un error.");
		}
		debugInfo("###########################");

		debugEnd();

		return this;
	}

	public ConfirmacionSiniestrosPage tramitarSiniestro() {
		debugBegin();
		webDriver.clickInFrame(tramitarSiniestroBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public ConfirmacionSiniestrosPage confirmaModificacion() {
		debugBegin();

		if(webDriver.getTextInFrame(mensajeOKTxt, cuerpoFrame).contains("El siniestro ha sido modificado correctamente")) {
			debugInfo("Modificación de siniestro correcta");
			webDriver.clickInFrame(volverBtn, cuerpoFrame);
		}
		
		debugEnd();

		return this;
	}

	public ConfirmacionSiniestrosPage volverAHomeMutua() {
		debugBegin();

		webDriver.clickInFrame(logoMutuaBtn, topFrame);
		debugInfo("Volvemos a la página principal de Mutua");
		
		debugEnd();
		
		return this;
	}
	// END
}
