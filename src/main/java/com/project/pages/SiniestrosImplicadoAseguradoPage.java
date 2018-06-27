package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

import org.openqa.selenium.By;

public class SiniestrosImplicadoAseguradoPage extends PageObject {
	
// THE CONSTRUCTOR	
	public SiniestrosImplicadoAseguradoPage(UserStory userS)
	{
		super(userS);
	}
	
//	REGION WEBELEMENT
	
	//	####	FRAMES	####
	
	private By cuerpoFrame = By.id("mainFrame");
	
	//	####	DATOS DEL ASEGURADO	####
	
	private By btnAperturaSiniestro = By.id("botonContinuar");
	
//end region
	
// REGION METHODS
	
	public void aperturaSinietro()
	{
		this.debugBegin();
		this.webDriver.clickInFrame(this.btnAperturaSiniestro, this.cuerpoFrame);
		Steps.waitForIt(webDriver);
		this.debugEnd();
	}
	
}
