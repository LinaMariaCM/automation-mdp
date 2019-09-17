package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;

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
    


}