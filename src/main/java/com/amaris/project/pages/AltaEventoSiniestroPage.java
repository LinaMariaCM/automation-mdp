package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class AltaEventoSiniestroPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By alta = By.cssSelector("#jt8");

    //declaracion
    private By fechaApertu = By.cssSelector("#EVENTO_FECHAPER_1");
    private By fechaInicio = By.cssSelector("#EVENTO_FECHAINICIO_1");
    private By natura = By.cssSelector("#EVENTO_NATURALEZA_1");
    private By estado = By.cssSelector("#EVENTO_ESTADO_1");
    private By titulo = By.cssSelector("#EVENTO_TITULO_1");
    private By descrip = By.cssSelector("#EVENTO_DESCRIPCION_1");
    private By anadir = By.cssSelector("#botonAdd0");
    private By continuar = By.cssSelector("input.mainButton");

    private By causa = By.cssSelector("#nombdato_nombdato_TIPOCAUSA_1_0"); //el ultimo numero indica el orden que esta. el ultimos es 458.

    //delimitacion 
    private By newPoblacion = By.cssSelector("li.js-action span");
    private By proivincia = By.cssSelector("#provincia");
    private By checkPobla = By.cssSelector("#check_tr1"); //el ultimo numero indica el orden que esta.
    private By anadirPobla = By.cssSelector("#botonAniadir2");
    private By buscarPobla = By.cssSelector("td.sis-frame-bg > input");
    private By contiPobla = By.cssSelector("#botonContinuar");
    private By guardar = By.cssSelector("#botonGuardar");
    private By eliminarPobla = By.cssSelector("span.si-button2");


    // relacion evento
    private By newEvent = By.cssSelector("li.js-action span");

    //assignacion de siniestro
    private By newSiniestro = By.cssSelector("li.js-action span"); 
    private By fecha = By.cssSelector("#filtro2");
    private By otros = By.cssSelector("#filtro3");
    
    //fecha
    private By fechaDesde = By.cssSelector("#fechadesde");
    private By fechaHasta = By.cssSelector("#fechahasta");
    private By produc = By.cssSelector("#EVENTO_LISTA_PROD_FECH");
    private By buscarSinies = By.cssSelector("input.mainButton");

    //otros
    private By productOtros = By.cssSelector("#EVENTO_LISTA_PRODUCTO");
    private By poliza = By.cssSelector("#numeroPoliza");


    // Resolucion
    private By fechaFinal = By.cssSelector("#EVENTO_FECHAFINAL_1");
    private By fechaTramita = By.cssSelector("#EVENTO_FFECHATRAM_1");
    private By observa = By.cssSelector("#EVENTO_OBSERVACION_1");
    private By contiResol = By.cssSelector("#buttonContinue");

    



    public AltaEventoSiniestroPage(UserStory userS) {
        super(userS);
    }


}