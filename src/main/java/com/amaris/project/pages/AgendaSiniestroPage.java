package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;

public class AgendaSiniestroPage extends PageObject {


    
    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By agenda = By.cssSelector("#jt4");

    private By nuevaTarea = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
    private By altaAnotacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(3) span");
    private By comunicacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(5) span");
    private By rehuse = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(7) span");


    private By titulo = By.cssSelector("#titulo");
    private By descripcion = By.cssSelector("#anotacion");
    private By categoria = By.cssSelector("#categoria");
    private By pioridad = By.cssSelector("#priority");
    private By email = By.cssSelector("#email");
    private By grabar = By.cssSelector("body > form > table input[name='botonGrabar']");
    private By cerrar = By.cssSelector("input[name='botonCerrar']");

    //cabecera
    private By plantillas = By.cssSelector("#cabPlantillas");
    private By codPlantilla = By.cssSelector("#queryPlantilla");
    private By buscarPlantilla = By.cssSelector("#botonPlantilla");
    private By selecPlantilla = By.cssSelector("#plantilla");

    //cambiar operador
    private By cambiOperador = By.cssSelector("#cabCambiarOperador");
    private By btnCambiarOP = By.cssSelector("#bloqueCambiarOperador td > a");

    //Documentos
    private By documentos = By.cssSelector("#cabDocumentos");
    private By seleccionar = By.cssSelector("#fichero");
    private By anexar = By.cssSelector("#botonAnexar");

    //etiquetas
    private By etiquetas = By.cssSelector("#cabEtiquetas");
    private By txtEtiquetas = By.cssSelector("#textoEtiquetas");
    private By asociarEti = By.cssSelector("#botonAsociar");


    

}