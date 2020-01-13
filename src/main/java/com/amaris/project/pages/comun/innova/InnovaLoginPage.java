package com.amaris.project.pages.comun.innova;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class InnovaLoginPage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");

	private By userIdInput = By.cssSelector("#usuario");
	private By passwordInput = By.cssSelector("#clave");
	private By enterBtn = By.cssSelector("#botonEntrar");
	// endregion

	public InnovaLoginPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public InnovaLoginPage login(String userId, String password) {
		debugBegin();

		webDriver.appendText(userIdInput, userId);
		webDriver.appendText(passwordInput, password);
		webDriver.click(enterBtn);

		Assert.assertTrue(webDriver.isClickable(menuFrame), "La aplicación no ha hecho el login correctamente");

		debugEnd();

		return this;
	}
	// endregion
}
