package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class InnovaLoginPage extends PageObject {

	// region webelements
	// @FindBy(id = "leftFrame")
	private By menuFrame = By.cssSelector("#leftFrame");

	// @FindBy(id = "usuario")
	private By txtUserId = By.cssSelector("#usuario");

	// @FindBy(id = "clave")
	private By txtPassword = By.cssSelector("#clave");

	// @FindBy(id = "botonEntrar")
	private By btnEnter = By.cssSelector("#botonEntrar");
	// endregion

	/*
	 * public InnovaLoginPage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 */

	public InnovaLoginPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public InnovaLoginPage login(String userId, String password) {
		debugBegin();
		this.webDriver.appendText(this.txtUserId, userId);
		this.webDriver.appendText(this.txtPassword, password);
		this.webDriver.click(this.btnEnter);
		Assert.assertTrue("La aplicación no ha hecho el login correctamente", this.webDriver.isClickable(menuFrame));
		debugEnd();

		return this;
	}
	// endregion
}
