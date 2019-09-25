package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionCarpetaSiniestro extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By carpeta = By.cssSelector("#jt16");

    private By nuevaCarpeta = By.cssSelector("li.js-action a");
    private By flechaAcciones = By.cssSelector("div[id*=capaFlecha] a");
    private By tramitar = By.cssSelector("div.cpdatos a");
    private By pesEncargo = By.cssSelector("#pes2");
    private By listEncargo = By.cssSelector("table.grid > tbody:nth-child(1) tr[valign='top'] td:nth-child(8) ");


    //nueva carpeta
    private By tipoImplica = By.cssSelector("#OTRIMPLI");
    private By rolImplica = By.cssSelector("#implicado_rol");
    private By nombre = By.cssSelector("#nombre");
    private By apellido = By.cssSelector("#apellido1");
    private By telefono = By.cssSelector("#telefono1");
    private By email = By.cssSelector("#email");
    private By codIban = By.cssSelector("div #codIban");
    private By banco = By.cssSelector("div #codBan");
    private By sucursal = By.cssSelector("#codSuc");
    private By dc = By.cssSelector("#codDig");
    private By noCuenta = By.cssSelector("#codCue");
    private By compa = By.cssSelector("#companiaSOA");
    private By grabar = By.cssSelector("#botonGrabar");

    
    public GestionCarpetaSiniestro(UserStory userS) {
        super(userS);
    }


    public Boolean comprobar_encargos(){
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

}