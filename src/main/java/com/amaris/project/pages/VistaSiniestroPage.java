package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    
    //Historico
    private By accederHistorico1 = By.cssSelector("#formPestania > table > tbody > tr.odd > td:nth-child(5) > a > span");
    private By historico1 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(3)");
    private By historico2 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(3) > td:nth-child(3)");
    private By historico3 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(4) > td:nth-child(3)");
    private By historico4 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(5) > td:nth-child(3)");
    private By historico5 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(6) > td:nth-child(3)");
    private By historico6 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(7) > td:nth-child(3)");
    private By historico7 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(8) > td:nth-child(3)");
    private By historico8 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(9) > td:nth-child(3)");
    
    private By descripcionNueva = By.cssSelector("#formDatos > table:nth-child(7) > tbody > tr.odd > td:nth-child(3)");
    
    private By listaValoresNuevos[] = {historico1, historico2, historico3, historico4, historico5, historico6, historico7, historico8};
        
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
        
        
     //   System.out.println("El estado del siniestro es: " + webDriver.getTextInFrame(estadoSiniestro, cuerpoFrame));
    //    if(webDriver.getText(estadoSiniestro).compareTo("Cerrado") == 0) {
    //    	System.out.println("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");

       // } else {        	
      
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
		      //  }
        }
        debugEnd();
        return this;

    }

    public VistaSiniestroPage modificarSiniestro(){
        debugBegin();

        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(vistaSiniestro, leftFrame);
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(modifiDatos, cuerpoFrame);
        
        debugEnd();
        return this;
    }
    
    public VistaSiniestroPage mapeoHistoricoModificarDatos(){
        debugBegin();

        ActionSteps.waitForIt(webDriver);
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.switchToFrame(capaIframe);
        
        String nuevosValores="";
        int n=0;
        while (webDriver.isPresent(listaValoresNuevos[n])) {
        	nuevosValores = nuevosValores + " " + webDriver.getText(listaValoresNuevos[n]);
        	n++;
        }
        
        
        
        if(nuevosValores.contains("NOMBREMOD") && nuevosValores.contains("PRIAPELLIDOMOD") && nuevosValores.contains("SEGAPELLIDOMOD") && nuevosValores.contains("660000001") && nuevosValores.contains("modificadoOK@mail.com")) {
        	System.out.println("Los datos modificados se muestran correctamente en el historial");
        }else System.out.println("Algo ha ido regular");
        
        Assert.assertTrue((nuevosValores.contains("NOMBREMOD") && nuevosValores.contains("PRIAPELLIDOMOD") && nuevosValores.contains("SEGAPELLIDOMOD") && nuevosValores.contains("660000001") && nuevosValores.contains("modificadoOK@mail.com")), "Los datos modificados se muestran correctamente en el historial");
        	
        if(webDriver.getText(descripcionNueva).contains("Modificación siniestro completada con exito")){
        	System.out.println("Modificación siniestro completada con exito");
        }
        
        Assert.assertTrue(webDriver.getText(descripcionNueva).contains("Modificación siniestro completada con exito"), "Modificación siniestro completada con exito");

        	
        

        webDriver.exitFrame();
        webDriver.exitFrame();
        debugEnd();
        return this;
    }
        
    

    public VistaSiniestroPage irVistaSiniestroHistorico(){
        debugBegin();

        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(vistaSiniestro, leftFrame);

        ActionSteps.waitForIt(webDriver);
        webDriver.switchToFrame(cuerpoFrame);
        
        webDriver.click(historico);
        ActionSteps.waitForIt(webDriver);
        webDriver.click(historico);
        ActionSteps.waitForIt(webDriver);
        webDriver.click(accederHistorico1);
        
        webDriver.exitFrame();
                
        debugEnd();
        return this;
    }
        
        
}