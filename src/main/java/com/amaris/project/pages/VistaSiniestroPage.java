package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;

public class VistaSiniestroPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");


    private By vistaSiniestro = By.cssSelector("#jt3");

    private By cerrarSiniestro = By.cssSelector("li:nth-child(1) span");
    private By modifiDatos = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) span");
    private By altaAnotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(5) span");

    // Pestañas
    private By datoEco = By.cssSelector("#pes1");
    private By poliRecibo = By.cssSelector("#pes2");
    private By otrosSinies = By.cssSelector("#pes3");
    private By historico = By.cssSelector("#pes4");
    private By carpeta = By.cssSelector("#pes5");
    private By consultaSinies = By.cssSelector("#pes6");
    private By clasulas = By.cssSelector("#pes7");

    private By modiReferencia = By.cssSelector("#capaAjax .secondButton");
    private By def = By.cssSelector("#DEF");
    private By sac = By.cssSelector("#SAC");
    private By dgs = By.cssSelector("#DGS");
    private By reclamacion = By.cssSelector("#RECLAMACION");

    //cierre

    private By motivo = By.cssSelector("#motivoCierre");
    private By motivoElemento = By.cssSelector("#motivoCierre > option");
    
    private By grabar = By.cssSelector("#botonGrabar");
    
    private By estadoSiniestro = By.cssSelector(("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)"));
    
    public VistaSiniestroPage(UserStory userS) {
        super(userS);
    }

    public VistaSiniestroPage cierre_siniestro(Boolean pagos, Boolean encargos, Boolean tareas ){
        debugBegin();
        
        
        System.out.println("El estado del siniestro es: " + webDriver.getText(estadoSiniestro));
        if(webDriver.getText(estadoSiniestro).compareTo("Cerrado") == 0) {
        	System.out.println("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");

        } else {        	
      
		        if (pagos == false && encargos == false && tareas == false){
		        webDriver.clickInFrame(vistaSiniestro, leftFrame);
		        ActionSteps.waitForIt(webDriver);
		        debugInfo("estoy en vista");
		        //webDriver.exitFrame();
		       // 
		        webDriver.clickInFrame(cerrarSiniestro, cuerpoFrame);
		        
		        
		        debugInfo("ha hecho click");
		       webDriver.switchToFrame(cuerpoFrame);
		       webDriver.waitWithDriver(3000);
		       webDriver.switchToFrame(capaIframe);
		        //ActionSteps.waitForIt(webDriver);
		        webDriver.waitWithDriver(5000);
		        webDriver.clickElementFromDropDownByAttribute(motivo, motivoElemento, "value", "PRSC");
		        //webDriver.clickElementChildByAttribute(motivo, "value", "PRSC");
		        debugInfo("ha hecho click motivo");
		        webDriver.click(grabar);
		        //webDriver.exitFrame();
		        webDriver.exitFrame();
		        }else {
		            debugInfo("Hay tareas pendientes.");
		        }
        }
        debugEnd();
        return this;

    }

}