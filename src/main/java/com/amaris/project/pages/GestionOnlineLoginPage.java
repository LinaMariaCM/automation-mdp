package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineLoginPage extends PageObject {

	// region webelements
	private By txtUserId = By.id("username");
	private By txtPassword = By.id("password");
	private By btnEntrar = By.cssSelector("button.btn.btn-primary");
	private By btnAceptar = By.cssSelector("#ca_banner > div.accept");
	// endregion

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
