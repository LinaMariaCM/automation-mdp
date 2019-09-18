package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class VistaSiniestroPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");


    private By vistaSiniestro = By.cssSelector("#jt3");

    private By cerrarSiniestro = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) span");
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
    private By grabar = By.cssSelector("#botonGrabar");

    
    public VistaSiniestroPage(UserStory userS) {
        super(userS);
    }

    public VistaSiniestroPage cierre_siniestro(){
        debugBegin();
        webDriver.clickInFrame(vistaSiniestro, leftFrame);
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(cerrarSiniestro, cuerpoFrame);
       // ActionSteps.waitForIt(webDriver);
        webDriver.waitWithDriver(5000);
        //webDriver.click(motivo);
        webDriver.dispatchEvent(motivo, "click");
        debugInfo("ha hecho click");
        //webDriver.clickElementFromDropDownByAttributeInFrame(motivo, cuerpoFrame, "value", "PRSC");
        webDriver.clickInFrame(grabar, capaIframe);

        debugEnd();
        return this;

    }

}