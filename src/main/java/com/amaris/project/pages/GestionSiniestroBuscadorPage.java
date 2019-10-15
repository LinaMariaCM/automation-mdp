package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionSiniestroBuscadorPage extends PageObject {

//Elementos
private By cuerpoFrame = By.id("mainFrame");
private By leftFrame = By.cssSelector("#leftFrame");
private By gestionSiniestros = By.xpath(".//*[text()='Gestión de siniestros']");

private By btnNoSiniestro = By.cssSelector("#filtro1");
private By btnNoPoliza = By.cssSelector("#filtro2");
private By btnNoRecibo = By.cssSelector("#filtro3");
private By btnAsegurado = By.cssSelector("#filtro4");
private By btnFechaOcurrencia = By.cssSelector("#filtro6");
private By btnFechaAlta = By.cssSelector("#filtro7");
private By btnCausa = By.cssSelector("#filtro8");
private By btnOtros = By.cssSelector("#filtro9");
private By opProduct = By.cssSelector("#capaPOLIZA td.flexibleField");
private By opProductSIni = By.cssSelector("#capaSINIESTRO td.flexibleField");

// Opcion Numero Siniestro
private By tipoProductoSini = By.cssSelector("#prodsini");
private By txtAno = By.cssSelector("#seriesin");
private By txtNoSiniestro = By.cssSelector("#numesini");

// Opcion Numero Poliza
private By tipoProductoPoliza = By.cssSelector("#producto");
private By txtNoPoliza = By.cssSelector("#polizsec");

// Opcion Numero recibo
private By txtNoRecibo1 = By.cssSelector("#recibann");
private By txtNoRecibo2 = By.cssSelector("#recibsec");

//Opcion Asegurado
private By txtNodocumento = By.cssSelector("#numedocu");
private By txtNombre = By.cssSelector("#nombpcom");
private By btnEmpieza = By.cssSelector("#nombpcom");
private By btnContiene = By.cssSelector("#contiene");

//Opcion fecha ocurrencia
private By fechaDesde = By.cssSelector("#desde");
private By fechaHasta = By.cssSelector("#hasta");

//Opcion fecha alta
private By fechaAltaDesde = By.cssSelector("#altadesde");
private By fechaAltaHasta = By.cssSelector("#altahasta");

//Opcion tipo causa
private By fechaCausaDesde = By.cssSelector("#fechDesde");
private By fechaCausaHasta = By.cssSelector("#fechHasta");
private By codigoCausa = By.cssSelector("#name4");

//Opcion Otros
private By fechaOtrosDesde = By.cssSelector("#fdesde");
private By fechaOtrosHasta = By.cssSelector("#fhasta");
private By estadoPoliza = By.cssSelector("#estado");
private By negocio = By.cssSelector("#productoSini");
private By mediador = By.cssSelector("#codMediador");


private By btnBuscar = By.cssSelector("#botonBuscar");

private By btnContinuar = By.cssSelector("#capaAjax tr.odd span");

public GestionSiniestroBuscadorPage(UserStory userS) {
    super(userS);
}

public GestionSiniestroBuscadorPage abrirGestionSiniestro(){
    debugBegin();
    
    webDriver.clickInFrame(gestionSiniestros,leftFrame);

    debugEnd();

    return this;
}


public GestionSiniestroBuscadorPage buscarPorNumeroPoliza(String numPoliza, String negocio) {
    debugBegin();
    webDriver.clickInFrame(gestionSiniestros,leftFrame);
    debugInfo("ha dado click");
    webDriver.switchToFrame(cuerpoFrame);
    webDriver.click(btnNoPoliza);
    if (negocio == "MEC"){
      //  webDriver.switchToFrame(cuerpoFrame);
     //   webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza, cuerpoFrame, "value", "510");
        //webDriver.clickElementFromDropDownByAttribute(opProduct, tipoProductoPoliza, "value", '510');
        webDriver.clickElementChildByAttribute(opProduct,"value", "510");
       // webDriver.exitFrame();
        
    }
    webDriver.setText(txtNoPoliza,numPoliza);
    webDriver.click(btnBuscar);

    ActionSteps.waitForIt(webDriver);
    webDriver.click(btnContinuar);
    webDriver.exitFrame();
    
    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorNumeroSiniestro(String siniestro,String anio, String negocio) {
    debugBegin();
    webDriver.clickInFrame(gestionSiniestros,leftFrame);
    debugInfo("ha dado click");
    webDriver.clickInFrame(btnNoSiniestro, cuerpoFrame);
    if (negocio == "MEC"){
        webDriver.switchToFrame(cuerpoFrame);
         webDriver.clickElementChildByAttribute(opProductSIni,"value", "510");
         webDriver.exitFrame();
    }
    webDriver.setTextInFrame(txtAno, cuerpoFrame, anio);
    
    webDriver.setTextInFrame(txtNoSiniestro, cuerpoFrame, siniestro);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorRecibo(String recibo1, String recibo2) {
    debugBegin();
    
    webDriver.clickInFrame(btnNoRecibo, cuerpoFrame);
    webDriver.appendTextInFrame(txtNoRecibo1, cuerpoFrame, recibo1);
    webDriver.appendTextInFrame(txtNoRecibo2, cuerpoFrame, recibo2);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorAsegurado(String asegurador, String opNombre, String nombre, String documento) {
    debugBegin();
    
    webDriver.clickInFrame(btnAsegurado, cuerpoFrame);
    webDriver.appendTextInFrame(txtNodocumento, cuerpoFrame, documento);
    if (opNombre=="contiene"){
        webDriver.clickInFrame(btnContiene, cuerpoFrame);
    }else {
        webDriver.clickInFrame(btnEmpieza, cuerpoFrame);
    }
    webDriver.setTextInFrame(txtNombre, cuerpoFrame, nombre);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);
    
    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorOcurrencia(String fDesde, String fHasta) {
    debugBegin();
    
    webDriver.clickInFrame(btnFechaOcurrencia, cuerpoFrame);
    webDriver.appendTextInFrame(fechaDesde, cuerpoFrame, fDesde);
    webDriver.appendTextInFrame(fechaHasta, cuerpoFrame, fHasta);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}


public GestionSiniestroBuscadorPage buscarPorAlta(String fDesde, String fHasta) {
    debugBegin();
    
    webDriver.clickInFrame(btnFechaAlta, cuerpoFrame);
    webDriver.appendTextInFrame(fechaAltaDesde, cuerpoFrame, fDesde);
    webDriver.appendTextInFrame(fechaAltaHasta, cuerpoFrame, fHasta);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorCausa(String fDesde, String fHasta, String nombre) {
    debugBegin();
    
    webDriver.clickInFrame(btnCausa, cuerpoFrame);
    webDriver.appendTextInFrame(fechaCausaDesde, cuerpoFrame, fDesde);
    webDriver.appendTextInFrame(fechaCausaHasta, cuerpoFrame, fHasta);
    webDriver.appendTextInFrame(codigoCausa, cuerpoFrame, nombre);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}

public GestionSiniestroBuscadorPage buscarPorOtros(String fDesde, String fHasta, String codMediador, String negocio) {
    debugBegin();
    
    webDriver.clickInFrame(btnOtros, cuerpoFrame);
    webDriver.appendTextInFrame(fechaOtrosDesde, cuerpoFrame, fDesde);
    webDriver.appendTextInFrame(fechaOtrosHasta, cuerpoFrame, fHasta);
    if (negocio == "MEC"){
        webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza, cuerpoFrame, "value", "510");
    }

    webDriver.clickElementFromDropDownByAttributeInFrame(estadoPoliza, cuerpoFrame, "value", "V");

    webDriver.setTextInFrame(mediador, cuerpoFrame, codMediador);
    webDriver.clickInFrame(btnBuscar, cuerpoFrame);

    ActionSteps.waitForIt(webDriver);
    webDriver.clickInFrame(btnContinuar, cuerpoFrame);

    debugEnd();

    return this;
}





}