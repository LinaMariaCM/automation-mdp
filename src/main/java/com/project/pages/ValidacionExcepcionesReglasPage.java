package com.project.pages;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(name = "botonContinuar")
	//private By btnContinuar = By.name("botonContinuar");

	private By btnContinuar = By.cssSelector("[ng-click='cp.continuar()']");
	
	
	// endregion

	public ValidacionExcepcionesReglasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ValidacionExcepcionesReglasPage clickOnContinuarButton() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		//this.webDriver.scrollToElement(this.btnContinuar);
		//this.webDriver.waitForElementToBeClickable(this.btnContinuar);
		System.out.println("ELEMENTO WEB btnContinuar: " + this.btnContinuar);
		this.webDriver.waitWithDriver(2500);
		this.webDriver.scrollToElement(this.btnContinuar);
		this.webDriver.waitWithDriver(2500);
		this.webDriver.click(this.btnContinuar);

		this.webDriver.exitFrame();
		debugEnd();

		return this;
	}
	// endregion
}
