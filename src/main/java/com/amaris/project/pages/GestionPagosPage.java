package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionPagosPage extends PageObject{

	//WEB ELEMENTS REGION
			
	//Gestion de pagos	
		//Operaciones
	
	private By autorizarPagos = By.cssSelector("a#jt2");
	private By confirmarPagos = By.cssSelector("a#jt3");
	private By emisionManualPagos = By.cssSelector("a#jt4");
		//Pagos
	private By consultarPagos = By.cssSelector("a#jt6");
	
		//Autorización
	
	//METHODS REGION
	
	//Constructor
    public GestionPagosPage(UserStory userS) {
        super(userS);
    }
	
    
    
	
}//END
