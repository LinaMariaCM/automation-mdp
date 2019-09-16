package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class BloqueSiniestro extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By bloque = By.cssSelector("#jt7");
    private By acciones = By.cssSelector("#capaFlecha11 a");
    private By transicionar = By.cssSelector("div.cpdatos a");


    // transicionar bloque
    private By bloqueDesti = By.cssSelector("#nuevaCarpeta");
    private By reserva = By.cssSelector("#reservas");
    private By tarea_ori = By.cssSelector("#tareas_ori");
    private By tarea_desti = By.cssSelector("#tareas_des");
    private By datos = By.cssSelector("#datos");
    private By cierre = By.cssSelector("#cierre_ori");
    private By grabar = By.cssSelector("#botonGrabar");
    private By cancelar = By.cssSelector("#botonCancelar");



}