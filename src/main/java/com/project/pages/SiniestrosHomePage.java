package com.project.pages;

import org.openqa.selenium.By;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

public class SiniestrosHomePage extends PageObject {
	

	// final static Logger logger =
	// LoggerFactory.getLogger(SiniestrosHomePage.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	
	
	
	// region webelements
	
	// @FindBy(id = "leftFrame")
	 private By menuFrame = By.id("leftFrame");
	//
	// @FindBy(id = "topFrame")
	// private WebElement topFrame;
	//
	// @FindBy(id = "mainFrame")
	// private WebElement mainFrame;
	
	 
	// @FindBy(id = "jt2")
	 
	 private By btnAperturaAlta = By.id("jt2");	
	 
	// @FindBy(id = "jt3")
	// private WebElement btnAperturaModificar;
	
	 private By btnAperturaModificar = By.id("jt3");
	 
	// @FindBy(id = "jt5")
	// private WebElement btnGestionSiniestros;
	//
	// @FindBy(id = "jt6")
	// private WebElement btnGestionPagos;
	//
	// @FindBy(id = "jt8")
	// private WebElement btnAltaEvento;
	//
	// @FindBy(id = "jt9")
	// private WebElement btnGestionEventos;
	// // endregion
	//

	//Constructor 
	 
	public SiniestrosHomePage(UserStory userS) {
			super(userS);
		}
	 
	 
	// region methods
	
	 public void openAperturaAlta()
	 {
		this.debugBegin(); 
		this.webDriver.clickInFrame(this.btnAperturaAlta,
		this.menuFrame);
		Steps.waitForIt(webDriver);
		this.debugEnd();
	 }
	
	 public void openAperturaModificar()
	 {
	 this.debugBegin();
	 this.webDriver.clickInFrame(this.btnAperturaModificar, this.menuFrame);
	 this.debugEnd();
	 }
	
	// public void openGestionSiniestros()
	// {
	// logger.debug("BEGIN - openGestionSiniestros");
	// this.wh.doubleClickOnWebElementInFrame(this.btnGestionSiniestros,
	// this.menuFrame);
	// logger.debug("END - openGestionSiniestros");
	// }
	//
	// public void openAltaEvento()
	// {
	// logger.debug("BEGIN - openAltaEvento");
	// this.wh.doubleClickOnWebElementInFrame(this.btnAltaEvento,
	// this.menuFrame);
	// logger.debug("END - openAltaEvento");
	// }
	//
	// public void openGestionEventos()
	// {
	// logger.debug("BEGIN - openGestionEventos");
	// this.wh.doubleClickOnWebElementInFrame(this.btnGestionEventos,
	// this.menuFrame);
	// logger.debug("END - openGestionEventos");
	// }
	// endregion
}
