package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.*;

public class DiarioSiniestrosPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");
    private By diarioSiniestro = By.cssSelector("#jt2");
    
    private By anotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) > a > span");
    private By comunicacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) > a > span");
    private By rehuse = By.cssSelector("li.js-action:nth-child(5) > a:nth-child(1) > span");

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

    //Rehuso
    private By motivo = By.cssSelector("#idMotivo");
    private By txtDescripcion = By.cssSelector("#idDescripcion");
    private By inputSi = By.cssSelector("#swCerrSi");
    private By inputNo = By.cssSelector("#swCerrNo");
    private By destino = By.cssSelector("#desti");
    private By grabar = By.cssSelector("#botonGrabar");
    private By nombre = By.cssSelector("#nombre");
    private By email = By.cssSelector("#email");
    
    //Información de comunicación
    private By textoPrimeraComunicacion = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(3) > p:nth-child(8)");
    

    public DiarioSiniestrosPage(UserStory userS) {
        super(userS);
    }

    public DiarioSiniestrosPage rehusar_siniestro(){
        debugBegin();
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(diarioSiniestro, leftFrame);
        debugInfo("estoy en diario");
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(rehuse, cuerpoFrame);
        ActionSteps.waitForIt(webDriver);
        debugInfo("estoy en rehuso");
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementChildByAttribute(motivo,"value", "ANEF");
        webDriver.click(inputNo);
        debugInfo("motivo introducido");
        webDriver.clickElementChildByAttribute(destino,"value", "0");
        ActionSteps.waitForIt(webDriver);
        webDriver.setText(nombre, "Prueba Rehuso");
        webDriver.setText(email, "rehuso@rehuso.com");
        webDriver.click(grabar);
        webDriver.exitFrame();
        ActionSteps.waitForIt(webDriver);

        return this;
    }
    
    public DiarioSiniestrosPage comprobarComunicacion(){
    	debugBegin();
    	
    	String mensaje = "Tannhäuser";
    	
    	System.out.println("Comprobando mensaje de comunicación...");
    	
    	if(webDriver.getTextInFrame(textoPrimeraComunicacion, cuerpoFrame).contains(mensaje)) System.out.println("OK , mensaje de comunicación CORRECTO.");
    	else System.out.println("KO , mensaje de comunicación ERRÓNEO.");
    	
    	debugEnd();
    	return this;
    }
    

}