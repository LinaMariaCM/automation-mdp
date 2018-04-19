package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class InnovaLoginPage
{
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	// region webelements
	@FindBy(id = "leftFrame")
	private By menuFrame;

	@FindBy(id = "usuario")
	private By user;

	@FindBy(id = "clave")
	private By password;

	@FindBy(id = "botonEntrar")
	private By enter;
	// endregion

	/*
	public InnovaLoginPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}*/
	
	
	public InnovaLoginPage(DriverHelper driver, TestDataManager data)
	{
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
		PageFactory.initElements(webDriver, this);
	}
	
	// region methods
	public InnovaLoginPage login(String userId, String Password)
	{
		logger.debug("BEGIN - login");
		//this.webDriver.sendValueToWebElement(this.user, userId);
		this.webDriver.
		this.webDriver.sendValueToWebElement(this.password, Password);
		this.webDriver.clickOnWebElement(this.enter);
		this.webDriver.waitForPageLoadToFinish();
		Assert.assertTrue("La aplicación no ha hecho el login correctamente", this.menuFrame.isDisplayed());
		logger.debug("END - login");
		
		return this;
	}
	// endregion
}
