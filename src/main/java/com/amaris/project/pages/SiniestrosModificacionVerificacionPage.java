package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
//import com.sun.org.apache.xml.internal.security.utils.Constants;
import com.amaris.project.Constants;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SiniestrosModificacionVerificacionPage extends PageObject {

	//REGION Web Elements
	
	//TODO terminar de mapear webElements
	
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	
	private By causaAnterior = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(2) > td:nth-child(2)");
	private By causaNueva = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(2) > td:nth-child(3)");
	
	private By rentaAnterior = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(3) > td:nth-child(2)");
	private By rentaNueva = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(3) > td:nth-child(3)");
	
	private By fechaDemandaDes = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(4) > td:nth-child(3)");
	private By fechaSolicitudAvanceRenta = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(5) > td:nth-child(3)");
	
	private By btnGrabarCambio = By.cssSelector("#botonGrabar");
	
	
	
	//End Region
	
	
	//REGION Methods
	
	//Constructor
	public SiniestrosModificacionVerificacionPage(UserStory userS) {
		super(userS);
	}
	
	public SiniestrosModificacionVerificacionPage mostrarCambios() {
		debugBegin();
		debugInfo("Se procede a mostrar los cambios producidos en el siniestro...");
		webDriver.switchToFrame(cuerpoFrame);
		System.out.println("========================");
		System.out.println("Causa anterior: " + webDriver.getText(causaAnterior));
		System.out.println("Causa ACTUAL: " + webDriver.getText(causaNueva));
		System.out.println("------------------");
		System.out.println("Renta anterior: " + webDriver.getText(rentaAnterior));
		System.out.println("Renta ACTUAL: " + webDriver.getText(rentaNueva));
		System.out.println("------------------");
		System.out.println("Fecha interposición demanda desahucio: " + webDriver.getText(fechaDemandaDes));
		System.out.println("Fecha solicitud avance renta: " + webDriver.getText(fechaSolicitudAvanceRenta));
		System.out.println("------------------");
		webDriver.exitFrame();
		debugEnd();
		return this;
	}
	
	public SiniestrosModificacionVerificacionPage grabarCambios() {
		debugBegin();
		debugInfo("Grabando cambios...");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(btnGrabarCambio);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}
	
	//End Region	
	
	//END
}
