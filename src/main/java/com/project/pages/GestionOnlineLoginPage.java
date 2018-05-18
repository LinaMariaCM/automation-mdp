package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.webdriver.DriverHelper;

/*
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/
public class GestionOnlineLoginPage extends PageObject {

	// region webelements
	@FindBy(id = "username")
	private By txtUserId;

	@FindBy(id = "password")
	private By txtPassword;

	@FindBy(css = "button.btn.btn-primary")
	private By btnEntrar;

	@FindBy(linkText = "Aceptar")
	private By btnAceptar;
	// endregion

	/*
	 * public GestionOnlineLoginPage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 */

	public GestionOnlineLoginPage(UserStory userS) {
		super(userS);
	}
	// region methods

	public void login(String userId, String password) {
		debugBegin();
		this.webDriver.appendText(this.txtUserId, userId);
		this.webDriver.appendText(this.txtPassword, password);
		this.webDriver.click(this.btnEntrar);
		debugEnd();
	}
	// endregion
}
