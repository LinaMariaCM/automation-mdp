package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class PrecioPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnConvertirAProyecto = By.cssSelector("button[ng-click*='convertToProject']");
	private By rowCheckboxWithClausula = By.xpath(".//tr[td[input]]");
	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");
	private By msgAvisoSistema = By.cssSelector("table.wideBox strong");
	private By logoMutua = By.cssSelector("#logo");
	private By productoMec = By.cssSelector("#jt2");
	private By procesandoWindow = By.cssSelector(".smallbox");
	private By loaderModal = By.cssSelector("#modalLoader");
	private By procesando = By.cssSelector("div[class*='processing'] div[class*='Processing'] .textProcessing");
	private By procesandoSombra = By.cssSelector("div[id='procesandosombra']");
	// endregion

	public PrecioPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public PrecioPage waitProcesando() {

		System.out.println("Espero a ver procesando...");
		webDriver.waitWithDriver(2000);

		while(this.webDriver.isPresent(procesando)) {
			System.out.println("Lo veo");
			webDriver.waitWithDriver(1500);
		}

		System.out.println("No veo procesando...");
		webDriver.waitWithDriver(2000);

		return this;
	}

	public PrecioPage clickOnConvertirAProjecto() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(btnConvertirAProyecto, cuerpoFrame);

		if(webDriver.isPresentInFrame(msgAvisoSistema, cuerpoFrame)) {
			debugInfo("*** Excepción general al convertir a proyecto.");
		}

		debugEnd();

		return this;
	}
}