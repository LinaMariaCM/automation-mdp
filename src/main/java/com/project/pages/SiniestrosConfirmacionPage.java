package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;

import org.openqa.selenium.By;


public class SiniestrosConfirmacionPage extends PageObject{

	public SiniestrosConfirmacionPage(UserStory userS)
	{
		super(userS);
	}
	
	private By cuerpoFrame = By.id("mainFrame");
	
	private By correcto = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > span > strong");
	

	
	private By nSiniestro = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(1) > td");
	
	private By expediente = By.cssSelector("#form1 > table:nth-child(1) > tbody > tr > td > table > tbody > tr:nth-child(4) > td > div");
	
	public void check()
	{
		this.debugBegin();
		System.out.println("###########################\n");
		System.out.println("# Mensaje de confirmacion #\n");
		System.out.println("###########################\n");
		System.out.println("\n");
		
		if(this.webDriver.isPresentInFrame(this.correcto, this.cuerpoFrame))
		{	
			this.webDriver.switchToFrame(this.cuerpoFrame);
			System.out.println("- mensaje: " + this.webDriver.getText(this.correcto));
			System.out.println("\n");
			System.out.println("- Nº de siniestro: " + this.webDriver.getText(this.nSiniestro));
			System.out.println("\n");
			System.out.println("- Expediente generado: " + this.webDriver.getText(this.expediente));
			this.webDriver.exitFrame();
		}
		
		else System.out.println("Se ha producido un error.");
		
		System.out.println("\n");
		
		this.debugEnd();
	}
	
	
}
