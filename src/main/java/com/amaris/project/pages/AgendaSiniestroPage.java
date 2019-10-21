package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class AgendaSiniestroPage extends PageObject {


    
    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By agenda = By.cssSelector("#jt4");

    private By nuevaTarea = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
    private By altaAnotacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(3) span");
    private By comunicacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(5) span");
    private By rehuse = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(7) span");

    //nueva tarea
    private By titulo = By.cssSelector("#titulo");
    private By descripcion = By.cssSelector("#anotacion");
    private By categoria = By.cssSelector("#categoria");
    private By pioridad = By.cssSelector("#priority");
    private By fechaFin = By.cssSelector("#fechaler");
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

    // pestañas
    private By todasTareas = By.cssSelector("#pes0");


    // lista de estado de las tareas
    private By estadoTarea = By.cssSelector("table.grid tbody:nth-child(1) tr[valign='top'] td:nth-child(5)");

    public AgendaSiniestroPage(UserStory userS) {
        super(userS);
    }
    
    public AgendaSiniestroPage nueva_tarea(){
        debugBegin();
        webDriver.waitWithDriver(5000);
        webDriver.clickInFrame(agenda,leftFrame);
        
        ActionSteps.waitForIt(webDriver);
        debugInfo("agenda");
        webDriver.clickInFrame(nuevaTarea, cuerpoFrame);
        ActionSteps.waitForIt(webDriver);
        debugInfo("estoy en nueva tarea");
        webDriver.setTextInFrame(titulo, cuerpoFrame, "Nueva tareas automatica");
        webDriver.setTextInFrame(descripcion, cuerpoFrame, "Estamos probando una prueba automatizada");
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementChildByAttribute(categoria, "value", "TSLA");
        webDriver.clickElementChildByAttribute(pioridad, "value", "1");
        webDriver.setText(fechaFin, "30/10/2019");
        webDriver.click(grabar);
        ActionSteps.waitForIt(webDriver);
        webDriver.waitWithDriver(5000);

        debugEnd();
        return this;
    }


    public boolean comprobar_tareas_pendientes(){
        debugBegin();
        webDriver.clickInFrame(agenda,leftFrame);
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(todasTareas, cuerpoFrame);
        debugInfo("click en todas");
        Boolean check = false;
        if (webDriver.isClickableInFrame(estadoTarea, cuerpoFrame)){
            debugInfo("antes de la lista");
            webDriver.switchToFrame(cuerpoFrame);
            List<WebElement> listaPagos = webDriver.getElements(estadoTarea);
            debugInfo("contiene: " +listaPagos.size());
            debugInfo("despues de la lista");
            
            for(int i = 0; i < listaPagos.size(); i++){
                debugInfo("hay tareas");
                
                debugInfo("Estado: "+listaPagos.get(i).getText());
                if (listaPagos.get(i).getText().compareTo("Pendiente") ==0){
                    check = true;
                    debugInfo("Tareas Pendiente: "+check);
                }
            }
            webDriver.exitFrame();
            
        }else{
            debugInfo("no hay tareas");
        }


        debugEnd();
        return check; 

    }

}