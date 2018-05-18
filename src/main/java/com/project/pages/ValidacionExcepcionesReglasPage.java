package com.project.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.webdriver.DriverHelper;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(name = "botonContinuar")
	private By btnContinuar = By.name("botonContinuar");
	// endregion

	public ValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ValidacionExcepcionesReglasPage clickOnContinuarButton() {
		debugBegin();
		
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		
		debugEnd();

		return this;
	}
	// endregion
}
