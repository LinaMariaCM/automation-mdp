package com.amaris.project.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

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

	public InnovaLoginPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public InnovaLoginPage login(String userId, String password) {
		debugBegin();
		this.webDriver.appendText(this.txtUserId, userId);
		this.webDriver.appendText(this.txtPassword, password);
		this.webDriver.click(this.btnEnter);
		Assert.assertTrue(webDriver.isClickable(menuFrame), "La aplicación no ha hecho el login correctamente");
		debugEnd();

		return this;
	}
	// endregion
}
