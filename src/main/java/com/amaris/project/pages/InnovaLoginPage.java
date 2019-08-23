package com.amaris.project.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class InnovaLoginPage extends PageObject {

	// region webelements
	private By menuFrame = By.cssSelector("#leftFrame");

	private By txtUserId = By.cssSelector("#usuario");
	private By txtPassword = By.cssSelector("#clave");
	private By btnEnter = By.cssSelector("#botonEntrar");
	// endregion

	public InnovaLoginPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public InnovaLoginPage login(String userId, String password) {
		debugBegin();
		
		webDriver.appendText(txtUserId, userId);
		webDriver.appendText(txtPassword, password);
		webDriver.click(btnEnter);
		
		Assert.assertTrue(webDriver.isClickable(menuFrame), 
			"La aplicación no ha hecho el login correctamente");
		
		debugEnd();

		return this;
	}
	// endregion
}
