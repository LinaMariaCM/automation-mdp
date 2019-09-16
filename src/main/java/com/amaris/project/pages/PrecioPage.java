package com.amaris.project.pages;

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
	// endregion

	public PrecioPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public PrecioPage ClickOnConvertirAProjecto() {
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