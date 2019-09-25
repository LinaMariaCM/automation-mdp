package com.amaris.project.pages;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PagosSiniestroPage extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");
    private By selectorFrame = By.id("selectorTipoFigura");
    private By accederPagos = By.xpath(".//*[text()='Pagos'] ");

    //Menu superior
    private By verSaldoFranquicias = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
    private By verDocumentacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
    private By consultaPoliza = By.cssSelector("#enlacePoliza");

    private By irListadoPagos = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar div.level-1 ul.list-level-1 li.rightList span.action-return");

    
    //Continuar,importes,Grabar
    private By botonContinuar1 = By.cssSelector("#botonContinuar");

    //Botones de interaccion
    private By nuevoPago = By.cssSelector("#bloque1tr1 td:nth-child(8) a span");

    //Tipo perceptor
    private By perceptor = By.cssSelector("#tipoPerceptor");
    //Participantes expediente
    private By flecha1  = By.cssSelector("tr.even td:nth-child(2) span");
    //Figuras de la poliza
    private By flecha2 = By.cssSelector("table.grid.narrowBox tr.odd span");
    //Empresas profesionales
    private By empresaColaboradora  = By.cssSelector("#idPerceptor");
    //Compañia contrataria
    private By nombreCia  = By.cssSelector("#nombreCiaCC");
    private By ciaContrataria  = By.cssSelector("#ciaCC");
    //Compañia reparadora
    private By flecha3 = By.cssSelector("tr.odd td:nth-child(4) span");

    //Datos bancarios
    private By medioPago = By.cssSelector("#medioPago");
    private By cuentaValidada = By.cssSelector("#checkboxCuentaValidada");
    private By codigoIban = By.cssSelector("#COMODIN_CADENA");
    private By banco = By.cssSelector("#COMODIN_CADENA_1");
    private By sucursal = By.cssSelector("#COMODIN_CADENA_2");
    private By DC = By.cssSelector("#COMODIN_CADENA_3");
    private By CTA = By.cssSelector("#COMODIN_CADENA_4");
    private By CTA2= By.cssSelector("#COMODIN_CADENA_5");
    private By calcularIban = By.cssSelector("#lnkCalcularIban");

    private By documentoBancario = By.cssSelector("#docBancario");

    //Datos del  pago
    private By tipoDocumento = By.cssSelector("#tipoDocumento");
    private By numeroDocumento = By.cssSelector("#numeroDocumento");
    private By nombre = By.cssSelector("#nombre");
    private By primerApellido = By.cssSelector("#apellido1");
    private By segundoApellido = By.cssSelector("#apellido2");
    private By fechaNacimiento = By.cssSelector("#fechaNacimiento");
    private By sexo = By.cssSelector("#sexo");
    private By prefijo1 = By.cssSelector("input[name='auxiliar404']");
    private By telefono1 = By.cssSelector("#telefono1");
    private By prefijo2 = By.cssSelector("input[name='auxiliar411']");
    private By telefono2 = By.cssSelector("#telefono2");
    private By prefijo3 = By.cssSelector("input[name='auxiliar415']");
    private By fax = By.cssSelector("#numeroFax");
    private By email = By.cssSelector("#eMail");

    //Domicilio
    private By tipoVia = By.cssSelector("#tipovia");
    private By domicilio = By.cssSelector("#nomcalle");
    private By numero = By.cssSelector("#numcalle");
    private By portal = By.cssSelector("#portal");
    private By escalera = By.cssSelector("#escalera");
    private By piso  = By.cssSelector("#piso");
    private By puerta = By.cssSelector("#puerta");
    private By codigoPostal = By.cssSelector("#codpostal");
    private By poblacion = By.cssSelector("#poblacion");

    //Referencia
    private By numeroReferencia = By.cssSelector("#refere");

    //Observaciones
    private By observaciones = By.cssSelector("input[name='observacion']");

    private By botonContinuar = By.cssSelector("#buttonContinue");

    //Conceptos de pago
    private By fechaDePago = By.cssSelector("#fechaPago");
    private By conceptoPago = By.cssSelector("#ctoPago");
    private By botonModificarReserva = By.cssSelector("#botonModificarReserva");
    private By reservaActual = By.cssSelector("#RESEACTU");
    private By grabarReserva = By.cssSelector("#buttonRecord");
    private By cancelarReserva = By.cssSelector("#buttonCancel");
    private By conFactura = By.cssSelector("#radio1");
    private  By sinFactura = By.cssSelector("#radio");

    //Datos factura
    private By fechaFactura = By.cssSelector("#fechaFactura");
    private By numeroFactura = By.cssSelector("#numeroFactura");

    //Coberturas implicadas
    private By rCRotura = By.cssSelector("#checkCob_ST0030");
    private By importe0 = By.cssSelector("#importes0");

    private By rCOmision = By.cssSelector("#checkCob_ST0040");
    private By importe1 = By.cssSelector("#importe1");

    private By dañosPropiosComunitarias = By.cssSelector("#checkCob_ST0043");
    private By importe2 = By.cssSelector("#importe2");

    private By comuntariasSubterraneos = By.cssSelector("#checkCob_ST0204");
    private By importe3 = By.cssSelector("#importe3");

    private By comunitariaLocalizacionAveria = By.cssSelector("#checkCob_ST0045");
    private By importe4 = By.cssSelector("#importe4");

    private By comunitariaReparacionAveria= By.cssSelector("#checkCob_ST0046");
    private By importe5 = By.cssSelector("#importe5");

    private By comunitariaLocalizacionAveriaSubterranea = By.cssSelector("#checkCob_ST0047");
    private By importe6 = By.cssSelector("#importe6");

    private By comunitariaReparacionAveriaSubterranea = By.cssSelector("#checkCob_ST0048");
    private By importe7 = By.cssSelector("#importe7");

    private By comunitariaExcesoAgua = By.cssSelector("#checkCob_ST0050");
    private By importe8 = By.cssSelector("#importe8");

    private By dañosEdificiosColidantes = By.cssSelector("#checkCob_ST0053");
    private By importe9 = By.cssSelector("#importe9");

    private By comunitarioRestauracionEstetica = By.cssSelector("#checkCob_ST0083");
    private By importe10 = By.cssSelector("#importe10");

    private By gastosIntervencionExtinsionSalvamento = By.cssSelector("#checkCob_ST0015");
    private By importe11 = By.cssSelector("#importe11");

    private By gastosDemolicionDescombro = By.cssSelector("#checkCob_ST0016");
    private By importe12 = By.cssSelector("#importe12");

    private By gastosInhabilitadaPerdidaAlquileres = By.cssSelector("#checkCob_ST0017");
    private By importe13 = By.cssSelector("#importe13");

    private By gastosReposicionDocumentos = By.cssSelector("#checkCob_ST0018");
    private By importe14 = By.cssSelector("#importe14");

    private By asistenciaServiciosProfesionales = By.cssSelector("#checkCob_ST0093");
    private By importe15 = By.cssSelector("#importe15");

    //Asignacion de cobertura
    private By actualizarImportePago = By.cssSelector("#datospago div:nth-child(5) input");

    //Importes
    private By pagoCuentaSi = By.cssSelector("#pagoCtaSi");
    private By pagoCuentaNo = By.cssSelector("#pagoCtaNo");

    //Verificacion ultimo pago de carpeta
    private By ultimoPagoSi = By.cssSelector("#ultimoPagoSi");
    private By ultimoPagoNo = By.cssSelector("#ultimoPagoNo");
    private By iva = By.cssSelector("#codigoTipoIvaFactura");
    private By irpf = By.cssSelector("#codigoTipoIrpfFactura");
    private By gastosSuplidos = By.cssSelector("#exentoFacInt");

    // comprobar si tiene pagos
    private By listPagos = By.cssSelector("table.grid:nth-child(1) > tbody:nth-child(1) tr[valign='top'] td:nth-child(9)");


    // endregion

    public PagosSiniestroPage(UserStory userS) {
        super(userS);
    }

    // region methods

    public PagosSiniestroPage nuevoPago (){
        debugBegin();

        webDriver.clickInFrame(accederPagos,leftFrame);
        webDriver.clickInFrame(nuevoPago, cuerpoFrame);

        debugEnd();
        return this;
    }

    public PagosSiniestroPage SeleccionarTipoPerceptor (){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(perceptor,0);
        webDriver.click(flecha1);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage datosPerceptor (){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 4);
        webDriver.click(botonContinuar);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage importes (String fPago, String Importe1){
        debugBegin();

        webDriver.appendTextInFrame(fechaDePago, cuerpoFrame, fPago);
        webDriver.clickElementFromDropDownByIndexInFrame(conceptoPago,cuerpoFrame,1);
        webDriver.clickInFrame(rCRotura, cuerpoFrame);
        webDriver.appendTextInFrame(importe0,cuerpoFrame, Importe1);
        webDriver.clickInFrame(actualizarImportePago, cuerpoFrame);
        webDriver.clickInFrame(botonContinuar1, cuerpoFrame);


        debugEnd();
        return this;
    }

    public PagosSiniestroPage verificacion (){
        debugBegin();

        webDriver.clickInFrame(botonContinuar1, cuerpoFrame);

        debugEnd();
        return this;
    }

    public Boolean comprobar_pagos_pendientes(){
        debugBegin();
        webDriver.clickInFrame(accederPagos,leftFrame);
        ActionSteps.waitForIt(webDriver);
        Boolean check = false;
        if (webDriver.isClickableInFrame(listPagos, cuerpoFrame)){
            debugInfo("antes de la lista");
            webDriver.switchToFrame(cuerpoFrame);
            List<WebElement> listaPagos = webDriver.getElements(listPagos);
            debugInfo("contiene: " +listaPagos.size());
            debugInfo("despues de la lista");
            
            for(int i = 0; i < listaPagos.size(); i++){
                debugInfo("hay Pagos");
                
                debugInfo("Estado: "+listaPagos.get(i).getText());
                if (listaPagos.get(i).getText().compareTo("Pagado") !=0){
                    check = true;
                    debugInfo("Pagos Pendiente: "+check);
                }
            }
            webDriver.exitFrame();
            
        }else{
            debugInfo("no hay pagos");
        }


        debugEnd();
        return check; 
    }
    

}
