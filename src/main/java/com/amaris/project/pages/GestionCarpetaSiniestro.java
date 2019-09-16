package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionCarpetaSiniestro extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By carpeta = By.cssSelector("#jt16");

    private By nuevaCarpeta = By.cssSelector("li.js-action a");
    private By flechaAcciones = By.cssSelector("#capaFlecha1875285 > a");
    private By tramitar = By.cssSelector("div.cpdatos a");


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
    

}