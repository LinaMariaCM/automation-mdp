package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class ProcesosSinientroPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By procesos  = By.cssSelector("#jt8");

    private By crearProc = By.cssSelector("li.js-action > a");

    // crear procesos
    private By tipoReferencia = By.cssSelector("#CPGE_TIPOREFE");
    private By proceso = By.cssSelector("#aux629");
    private By pesDocumentacion = By.cssSelector("#pesDocumentacion span");
    private By nuevoDocu = By.cssSelector("#capaDocumentacion a");
    private By pesContactos = By.cssSelector("#pesContactos span");
    private By nuevoContac = By.cssSelector("#capaContactos a");

    private By grabar = By.cssSelector("#buttonRecord");
    private By cancel = By.cssSelector("#buttonCancel");
    

}


