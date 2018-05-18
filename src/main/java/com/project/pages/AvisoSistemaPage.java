package com.project.pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

import com.automation.model.webdriver.DriverHelper;
import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

public class AvisoSistemaPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.xpath(".//*[text()='Volver']");

	private By msgAvisoPlantasAlto = By.xpath("./html/body/table");
	// endregion

	/*
	 * public AvisoSistemaPage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 * 
	 */

	public AvisoSistemaPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void CheckmsgAvisoPlantasAlto() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		String mensaje = this.webDriver.getText(this.msgAvisoPlantasAlto);
		Assert.assertTrue(mensaje.contains("Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía."));
		this.webDriver.exitFrame();
		debugEnd();
	}

	public void ClikOnVolver() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();
		debugEnd();
	}
	// endregion
}
