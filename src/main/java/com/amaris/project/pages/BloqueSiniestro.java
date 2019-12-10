package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class BloqueSiniestro extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By bloque = By.cssSelector("#jt7");
    private By acciones = By.cssSelector("#capaFlecha12 a");
    private By transicionar = By.cssSelector("div.cpdatos a");
    private By codBloque = By.cssSelector("#bloque1tr1 > td:nth-child(2)");
    private By listaBloque = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque']");

    // transicionar bloque
    private By bloqueDesti = By.cssSelector("#nuevaCarpeta");
    private By reserva = By.cssSelector("#reservas");
    private By tarea_ori = By.cssSelector("#tareas_ori");
    private By tarea_desti = By.cssSelector("#tareas_des");
    private By datos = By.cssSelector("#datos");
    private By cierre = By.cssSelector("#cierre_ori");
    private By grabar = By.cssSelector("#botonGrabar");
    private By cancelar = By.cssSelector("#botonCancelar");
    private By error = By.cssSelector("td.sis-font-l");
    // Opciones
    private By opReservas = By.cssSelector("#reservas");
    private By opOriginal = By.cssSelector("#tareas_ori");
    private By opTareas = By.cssSelector("#tareas_des");
    private By opDatos = By.cssSelector("#datos");
    private By opCierre = By.cssSelector("#cierre_ori");


    public BloqueSiniestro(UserStory userS) {
        super(userS);
    }
    


    public BloqueSiniestro transicionar_bloques(){
        debugBegin();
        webDriver.waitWithDriver(2000);
        webDriver.clickInFrame(bloque,leftFrame);
        ActionSteps.waitForIt(webDriver);
        debugInfo("Estoy en bloque");
        webDriver.waitWithDriver(3000);
        webDriver.switchToFrame(cuerpoFrame);
        List<WebElement> listaBloques = webDriver.getElements(listaBloque);
        debugInfo("contiene: " +listaBloques.size());
        debugInfo("despues de la lista");
            for(int i = 0; i < listaBloques.size(); i++){
                String codigo = webDriver.getText(By.cssSelector("#bloque1tr"+(i+1)+ "> td:nth-child(2")); // depende en que fila este es un numero u otro. Ej:segunda fila tendra el numero 2
                debugInfo("el codigo es: "+codigo);
                webDriver.click(By.cssSelector("#capaFlecha"+codigo+" a")); // el selector va dependiendo de que codigo de bloque sea.
                debugInfo("click acciones");
                if (webDriver.isClickable(transicionar)){
                    debugInfo("contiene transiciona");
                    webDriver.click(transicionar);
                    webDriver.waitWithDriver(3000); 
                }
                else {
                    debugInfo("no contiene transiciona");
                    webDriver.click(By.cssSelector("#cabeceraBloqueDesplegable"+(i+1)));  // se hace este click porque cuan le doy al boton de acciones el desplejable tapa al siguiente selector
                }
        }
        webDriver.switchToFrame(capaIframe);
        webDriver.clickElementChildByAttribute(bloqueDesti,"value", "11");  
        debugInfo("destino bloque");
        if(webDriver.isClickable(error)){
            String mensjError = webDriver.getText(By.cssSelector("td.sis-font-l p strong"));
            debugInfo(mensjError);
        }else{
            webDriver.click(opDatos);
            debugInfo("Opcion Datos");
            webDriver.click(grabar);
        }
        
        webDriver.exitFrame();
        debugEnd();
        return this;
    }

}