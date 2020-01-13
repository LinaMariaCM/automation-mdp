package com.amaris.project.pages.comun.gestiononline;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineLoginPage extends PageObject {

	// region WebElements
	private By userIdInput = By.id("username");
	private By passwordInput = By.id("password");
	private By entrarBtn = By.cssSelector("button.btn.btn-primary");
	private By aceptarBtn = By.cssSelector("#ca_banner > div.accept");
	// endregion

	public GestionOnlineLoginPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public GestionOnlineLoginPage login(String userId, String password) {
		debugBegin();

		webDriver.appendText(userIdInput, userId);
		webDriver.appendText(passwordInput, password);
		
		webDriver.click(entrarBtn);

		webDriver.click(aceptarBtn);
		
		debugEnd();

		return this;
	}
	// endregion
}
