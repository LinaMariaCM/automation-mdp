package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

/*
import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/
public class GestionOnlineLoginPage extends PageObject {

	// region webelements
	private By txtUserId = By.cssSelector("#username");
	private By txtPassword = By.cssSelector("#password");
    private By btnEntrar = By.cssSelector("button.btn.btn-primary");
    private By btnAceptar = By.cssSelector("#ca_banner > div.accept");


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

	public GestionOnlineLoginPage login(String userId, String password) {
		debugBegin();

		// Enter username and password
		this.webDriver.appendText(this.txtUserId, userId);
		this.webDriver.appendText(this.txtPassword, password);
		this.webDriver.click(this.btnEntrar);

		// Accept cookies popup
		this.webDriver.click(this.btnAceptar);
		debugEnd();

		return this;
	}
	// endregion
}
