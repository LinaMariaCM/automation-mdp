package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionCarpetaSiniestrosPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By carpeta = By.cssSelector("#jt16");

    private By nuevaCarpeta = By.cssSelector("li.js-action a");
    private By flechaAcciones = By.cssSelector("div[id*=capaFlecha] a");
    private By tramitar = By.cssSelector("div.cpdatos a");
    private By pesEncargo = By.cssSelector("#pes2");
    private By listEncargo = By.cssSelector("table.grid > tbody:nth-child(1) tr[valign='top'] td:nth-child(8) ");
    private By cerrarCarpeta = By.cssSelector("ul.topnav > li:nth-child(6) > a:nth-child(1) span");
    private By tipoCarpeta = By.cssSelector("table.grid > tbody:nth-child(1) tr[valign='top'] td:nth-child(4) ");
    
    //nueva carpeta
    private By tipoImplica = By.cssSelector("#OTRIMPLI");
    private By rolImplica = By.cssSelector("#implicado_rol");
    private By nombre = By.cssSelector("#nombre");
    private By apellido = By.cssSelector("#apellido1");
    private By telefono = By.cssSelector("#telefono1");
    private By telefono2 = By.cssSelector("#telefono2");
    private By email = By.cssSelector("#email");
    private By codIban = By.cssSelector("div #codIban");
    private By banco = By.cssSelector("div #codBan");
    private By sucursal = By.cssSelector("#codSuc");
    private By dc = By.cssSelector("#codDig");
    private By noCuenta = By.cssSelector("#codCue");
    private By compa = By.cssSelector("#companiaSOA");
    private By grabar = By.cssSelector("#botonGrabar");
    private By estadoCarpeta = By.cssSelector("td:nth-child(7)");

    // cierre carpeta
    private By motivoCierre = By.cssSelector("div.sis-col-50 #motivoCierre");
    private By cierreTareas = By.cssSelector("#cierreTareas");
    private By grabarCierre = By.cssSelector("#buttonRecord");


    
    public GestionCarpetaSiniestrosPage(UserStory userS) {
        super(userS);
    }


    
    
    
    public boolean comprobar_tipo_carpeta(){
    	
    	boolean check = false;
    	
    	List<WebElement> listaTipoCarpeta = webDriver.getElements(tipoCarpeta);
    	
    	for(int i=0; i < listaTipoCarpeta.size() || check; i++) {
    		
    		 if(webDriver.getText(listaTipoCarpeta.get(i)).compareTo("IMAS") == 0) check = true;
    		
    	}
    	
    return check;	
    }
    
    
    
    public boolean comprobar_encargos(){
            debugBegin();
            webDriver.clickInFrame(carpeta,leftFrame);
            ActionSteps.waitForIt(webDriver);
            Boolean check = false;
            webDriver.switchToFrame(cuerpoFrame);
            if (webDriver.isClickable(flechaAcciones)){
                debugInfo("hacer tramite");
                webDriver.click(flechaAcciones);
                webDriver.waitWithDriver(1000);
                webDriver.click(tramitar);
            }
            webDriver.click(pesEncargo);

            if (webDriver.isClickable(listEncargo)){
                debugInfo("antes de la lista");
              //  webDriver.switchToFrame(cuerpoFrame);
                List<WebElement> listaPagos = webDriver.getElements(listEncargo);
                debugInfo("contiene: " +listaPagos.size());
                debugInfo("despues de la lista");
                
                for(int i = 0; i < listaPagos.size(); i++){
                    debugInfo("hay encargos");
                    
                    debugInfo("Estado: "+listaPagos.get(i).getText());
                    if (listaPagos.get(i).getText().compareTo("Cerrado") !=0){
                        check = true;
                        debugInfo("Encargos Pendiente: "+check);
                    }
                }    
            }else{
                debugInfo("no hay encargos");
            }
            webDriver.exitFrame();
    
            debugEnd();
            return check; 
    }

    public GestionCarpetaSiniestrosPage nueva_carpeta(){
        debugBegin();
        webDriver.clickInFrame(carpeta,leftFrame);
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(nuevaCarpeta, cuerpoFrame);
        debugInfo("hecho click nueva carpeta");
        ActionSteps.waitForIt(webDriver);
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementChildByAttribute(tipoImplica,"value", "CAUS");
        webDriver.clickElementChildByAttribute(rolImplica,"value", "TOMA");
        webDriver.waitWithDriver(5000);
        webDriver.setText(telefono, "911250100");
        webDriver.setText(telefono2, "961234567");
        
        webDriver.waitWithDriver(8000);
        webDriver.setText(codIban, "1111");
        webDriver.setText(banco, "1111");
        webDriver.setText(sucursal, "1111");
        webDriver.setText(dc, "11");
        webDriver.setText(noCuenta, "1111111111");
        webDriver.click(grabar);
        webDriver.exitFrame();

        debugEnd();
        return this; 
    }

    
    public GestionCarpetaSiniestrosPage cerrar_carpeta(){
        debugBegin();
        webDriver.clickInFrame(carpeta,leftFrame);
        ActionSteps.waitForIt(webDriver);
        if (webDriver.isClickableInFrame(flechaAcciones, cuerpoFrame)){
            debugInfo("antes de la lista");
            webDriver.switchToFrame(cuerpoFrame);
            List<WebElement> estado = webDriver.getElements(estadoCarpeta);
            debugInfo("contiene: " +estado.size());
            debugInfo("despues de la lista");
            for(int i = 0; i < estado.size(); i++){
                debugInfo("hay tareas");
                
                debugInfo("Estado: "+estado.get(i).getText());
                if (estado.get(i).getText().compareTo("Abierto") ==0){
                    debugInfo("Carpeta abierta: ");
                    debugInfo("hacer tramite");
                    debugInfo("tr[align*=center]:nth-child("+(i+2)+") div[id*=capaFlecha] a");
                    webDriver.click(By.cssSelector("tr[align*=center]:nth-child("+(i+2)+") div[id*=capaFlecha] a"));
                    webDriver.waitWithDriver(1000);
                    webDriver.click(tramitar);
                }
            }
            ActionSteps.waitForIt(webDriver);
            webDriver.click(cerrarCarpeta);
            debugInfo("cierre");
            webDriver.waitWithDriver(5000);
            webDriver.switchToFrame(capaIframe);
            webDriver.clickElementChildByAttribute(motivoCierre,"value", "ERAD");
            debugInfo("motivo");
            webDriver.click(grabarCierre);
            webDriver.exitFrame();
            webDriver.exitFrame();   
        }


        debugEnd();    

        return this;
    }

}