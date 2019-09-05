package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class DiarioSiniestroPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");
    
    private By anotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) > a > span");
    private By comunicacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) > a > span");
    private By rehuse = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(5) > a > span");

    //Pestaña de informacion
    private By pestSituacion = By.cssSelector("#cargaCategorias > li:nth-child(2) > a");
    private By pestComunicacion = By.cssSelector("#cargaCategorias > li:nth-child(3) > a");
    private By pestAnotacion = By.cssSelector("#cargaCategorias > li:nth-child(4) > a");

    //Pop-up anotacion
    private By nuevaAnotacion = By.cssSelector("div.menuNav.menuNavPosAbsolute span");
    private By titulo = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(1) select");
    private By txtComentario = By.cssSelector("#comentario");
    private By Confidencialidad = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(5) select");
    private By grabarAnotacion = By.cssSelector("#botonContinuar2");
    private By desplegarComen = By.cssSelector("table:nth-child(6)  a:nth-child(1)");
    private By ocultarComen = By.cssSelector("table:nth-child(6) > tbody > tr > td > a:nth-child(2)");
    private By cancelar = By.cssSelector("#botonCancelar");
    



}