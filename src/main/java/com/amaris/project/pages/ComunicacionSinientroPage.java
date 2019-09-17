package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;

public class ComunicacionSinientroPage extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By comunicacion = By.cssSelector("#jt6");

    private By nuevaComuni = By.cssSelector("#tr0 a.si-arrow-right");

    //alta comunicacion
    private By medioEnvio = By.cssSelector("#medio");
    private By privacidad = By.cssSelector("#privi");
    private By destino = By.cssSelector("#desti");

    //datos medio de envio
    private By nombre = By.cssSelector("#nombre");
    private By via = By.cssSelector("#tipovia");
    private By domicilio = By.cssSelector("#domicilio");
    private By numero = By.cssSelector("#numdomi");
    private By  cp = By.cssSelector("#cp");

    private By continuar = By.cssSelector("input.mainButton");

    //cumplimentacion

    private By asunto = By.cssSelector("#email");
    private By modelo = By.cssSelector("#dcarplan");
    private By modificarSi = By.cssSelector("#modiConteSi");
    private By modificarNo = By.cssSelector("#modiConteNo");
    private By cajaTxt = By.cssSelector("#tinymce");
    private By check = By.cssSelector("#check_Doc_0");   // el numero final del selector indica la final que esta disponible
    private By lupa = By.cssSelector("tr.odd span");   // es la lupa de la primera fila
    private By enviar = By.cssSelector("#botonContinuar");




} 