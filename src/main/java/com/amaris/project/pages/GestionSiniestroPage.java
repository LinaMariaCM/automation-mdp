package com.amaris.project.pages;

import org.openqa.selenium.By;

public class GestionSiniestroPage {
    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By exportaResultado = By.cssSelector("#cabExportar");

    //Buscador de siniestros

    //Numero Siniestro
    private By numeroSiniestro = By.cssSelector("#filtro1");
    private By añoSiniestro = By.cssSelector("#seriesin");
    private By numSiniestro = By.cssSelector("#numesini");

    //Numero Poliza
    private By numeroPoliza = By.cssSelector("#filtro2");
    private By tipoProducto = By.cssSelector("#producto");
    private By numPoliza = By.cssSelector("#polizsec");

    //Numero recibo
    private By numeroRecibo = By.cssSelector("#filtro3");
    private By numRecibo1 = By.cssSelector("input[name='recibann']");
    private By numRecibo2 = By.cssSelector("#recibsec");

    //Asegurado
    private By asegurado = By.cssSelector("#filtro4");
    private By documento = By.cssSelector("#numedocu");
    private By empiezaPor = By.cssSelector("#empiezapor");
    private By contiene = By.cssSelector("#contiene");
    private By nombreApellidos = By.cssSelector("input[name='nombpcom']");

    //Fecha ocurrencia
    private By fechaOcurrencia = By.cssSelector("#filtro6");
    private By fDesde = By.cssSelector("#desde");
    private By fHasta = By.cssSelector("#hasta");

    //Fecha alta
    private By fechaAlta = By.cssSelector("#filtro7");
    private By fAltaDesde = By.cssSelector("#altadesde");
    private By fAltaHasta = By.cssSelector("#altahasta");

    //Tipo causa
    private By tipoCausa = By.cssSelector("#filtro8");
    private By fCausaDesde = By.cssSelector("#fechDesde");
    private By fCausaHasta = By.cssSelector("#fechHasta");
    private By codigo = By.cssSelector("#name4");

    //Otros
    private By otros = By.cssSelector("#filtro9");
    private By fOtrosDesde = By.className("#fdesde");
    private By fOtrosHasta = By.cssSelector("#fhasta");
    private By estadoPoliza = By.cssSelector("#estado");
    private By lineaNegocio = By.cssSelector("#productoSini");
    private By mediador = By.cssSelector("#codMediador");

    private By botonBuscar = By.cssSelector("#botonBuscar");

    private By flechaContinuar = By.cssSelector("tr:nth-child(3) td:nth-child(11) span");

    private By pagos = By.cssSelector("jt11");

    private By verSaldo = By.cssSelector("ul.list-level-1.js-actionsdinamicbar:nth-child(1) span")







}
