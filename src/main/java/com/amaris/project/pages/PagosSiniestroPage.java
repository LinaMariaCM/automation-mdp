package com.amaris.project.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PagosSiniestroPage extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");
    private By selectorFrame = By.id("selectorTipoFigura");
    private By accederPagos = By.xpath(".//*[text()='Pagos'] ");

    //informcacion general
    
    private By estadoCarpeta = By.cssSelector("table[class='grid wideBox'] > tbody > tr:nth-of-type(2) > td:nth-child(7)");
    
    //Info listado de pagos de carpetas
    
   // private By estadoCarpeta = By.cssSelector("#bloque1tr1 td:nth-child(7) a span");
    
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
    private By rCRotura = By.cssSelector("#checkCob_ST0039");
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

    private By impagoAlquileres = By.cssSelector("#checkCob_ST9004");

    //Asignacion de cobertura
    private By actualizarImportePago = By.cssSelector("#datospago div:nth-child(5) input");

    //Importes
    private By pagoCuentaSi = By.cssSelector("#pagoCtaSi");
    private By pagoCuentaNo = By.cssSelector("#pagoCtaNo");
    private By causasImportes =  By.cssSelector("#coberturaImplicada .radio");
    

    //Verificacion ultimo pago de carpeta
    private By ultimoPagoSi = By.cssSelector("#ultimoPagoSi");
    private By ultimoPagoNo = By.cssSelector("#ultimoPagoNo");
    private By iva = By.cssSelector("#codigoTipoIvaFactura");
    private By irpf = By.cssSelector("#codigoTipoIrpfFactura");
    private By gastosSuplidos = By.cssSelector("#exentoFacInt");

    // comprobar si tiene pagos
    private By listPagos = By.cssSelector("table.grid:nth-child(1) > tbody:nth-child(1) tr[valign='top'] td:nth-child(9)");

    private By tipoPerceptor = By.cssSelector("#tipoPerceptor");
    private By tipoPerceptorElemento = By.cssSelector("#tipoPerceptor > option");

    // Planes de pago de siniestros MAC
    private By radioActivarPlanPago = By.cssSelector("#planPagoSi");

    private By planFPrimerPago = By.cssSelector("input#fPrimerPago");
    private By planFActivacion = By.cssSelector("input#fActivacion");
    private By planImportePrimerPago = By.cssSelector("input#importePrimerPago");
   // private By desplegablePeriodicidad = By.cssSelector("form [id='datosPlan'] > select [id='periodicidad'] > option");
    private By btnGenerarPlan = By.cssSelector("input.secondButton");
    private By tablaPagos = By.id("detallePlan");
    private By marcaPagos = By.cssSelector("table[class='sis-frame-bg.wideBox1] > tbody > tr > td:nth-child(2) > table[class='sis-frame-bg2.wideBox'] > tbody > tr:nth-child(2)");

    //comprobaciones tras finalizar (a parte de las ya grabadas)
    //private By fechaDemandaDeshaucio = By.cssSelector();
    //private By fechaAvanceRenta = By.cssSelector();

    //pago a carpeta
    private By abrirBloques = By.cssSelector("a#jt7");
    private By desplegarCarpetas = By.cssSelector("a#cabeceraBloqueDesplegable1");
    private By menuAccionesCarpetaBloque = By.cssSelector("table[class='grid wideBox'] > tbody >  tr[id*='bloque1tr1b'] > td:nth-child(7) > div.sis-box-actions");

    private By btnPagoACarpeta = By.cssSelector("div.pdata > div > ul > li:nth-child(2) > a");

    private By volverListaPagos = By.cssSelector("div.menuNav.menuNavPosAbsolute.menuNavPosFixed > div > ul > li.rightList > a");

    // endregion

    public PagosSiniestroPage(UserStory userS) {
        super(userS);
    }

    // region methods

    public PagosSiniestroPage nuevoPago (){
        debugBegin();

        
        webDriver.clickInFrame(accederPagos,leftFrame);
        
        setTestVar(Constants.ESTADO_CARPETA, webDriver.getTextInFrame(estadoCarpeta, cuerpoFrame));
        System.out.println("El estado de la carpeta es: " + webDriver.getTextInFrame(estadoCarpeta, cuerpoFrame));
        
        if(getTestVar(Constants.ESTADO_CARPETA).equalsIgnoreCase(getTestVar(Constants.ESTADO_CARPETA_CERRADA))) {
        	System.out.println("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");
        } else {        	
        	webDriver.clickInFrame(nuevoPago, cuerpoFrame);
        }

        debugEnd();
        
        return this;
    }

    public PagosSiniestroPage seleccionarParticipantesExpediente (){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(perceptor,4);
        System.out.println("Elemento flecha1 es: " + flecha1);
        webDriver.waitWithDriver(8000);
  
        webDriver.click(flecha1);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }
    
    public PagosSiniestroPage seleccionarTipoDePerceptor (){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        //webDriver.clickElementFromDropDownByIndex(perceptor,4);
        webDriver.clickElementFromDropDownByAttribute(tipoPerceptor, tipoPerceptorElemento, "value", "PE40");       
        System.out.println("Elemento flecha1 es: " + flecha1);
        webDriver.waitWithDriver(8000);
  
        webDriver.click(flecha1);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage seleccionarFiguraPoliza(){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(perceptor,1);
        webDriver.click(flecha2);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    //VERIFICAR

    public PagosSiniestroPage seleccionarEmpresasProfesionales(){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(perceptor,6);

        webDriver.click(botonContinuar);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage seleccionarCompañiaContrataria(String NombreCia, String CiaContrataria){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(perceptor,2);
        webDriver.appendText(nombreCia, NombreCia);
        webDriver.appendText(ciaContrataria,CiaContrataria);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage seleccionarVariosDatosLibres(){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 3);
        webDriver.click(botonContinuar1);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage seleccionarJuzgado(){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 4);
        webDriver.click(botonContinuar1);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    //Medios pago
    public PagosSiniestroPage medioPagoTransferencia (String CodigoIban, String Banco, String Sucursal, String dc, String cta, String cta2){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 2);
        webDriver.appendText(codigoIban, CodigoIban);
        webDriver.appendText(banco,Banco);
        webDriver.appendText(sucursal,Sucursal);
        webDriver.appendText(DC, dc);
        webDriver.appendText(CTA, cta);
        webDriver.appendText(CTA2, cta2);
        webDriver.click(calcularIban);
        webDriver.click(botonContinuar);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage medioPagoCheque(String docBancario){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 3);
        webDriver.appendText(documentoBancario,docBancario);
        webDriver.click(botonContinuar);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage medioPagoConsignacion (){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(medioPago, 4);
        webDriver.click(botonContinuar);
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

    //Datos del pago

    public PagosSiniestroPage datosPagoNif (String TipoDocumentoNif,  String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(tipoDocumento,1);
        webDriver.appendText(numeroDocumento,TipoDocumentoNif);
        webDriver.appendText(nombre, Nombre);
        webDriver.appendText(primerApellido,PrimerApellido);
        webDriver.appendText(segundoApellido, SegundoApellido);
        webDriver.appendText(fechaNacimiento, FechaNacimiento);
        webDriver.clickElementFromDropDownByIndex(sexo,4);
        webDriver.appendText(telefono1,Tel1);
        webDriver.appendText(telefono2, Tel2);
        webDriver.appendText(email, Email);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage datosPagoNie (String TipoDocumentoNie,  String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(tipoDocumento,2);
        webDriver.appendText(numeroDocumento,TipoDocumentoNie);
        webDriver.appendText(nombre, Nombre);
        webDriver.appendText(primerApellido,PrimerApellido);
        webDriver.appendText(segundoApellido, SegundoApellido);
        webDriver.appendText(fechaNacimiento, FechaNacimiento);
        webDriver.clickElementFromDropDownByIndex(sexo,4);
        webDriver.appendText(telefono1,Tel1);
        webDriver.appendText(telefono2, Tel2);
        webDriver.appendText(email, Email);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage datosPagoPasaporte (String TipoDocumentoPasaporte,  String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(tipoDocumento,1);
        webDriver.appendText(numeroDocumento,TipoDocumentoPasaporte);
        webDriver.appendText(nombre, Nombre);
        webDriver.appendText(primerApellido,PrimerApellido);
        webDriver.appendText(segundoApellido, SegundoApellido);
        webDriver.appendText(fechaNacimiento, FechaNacimiento);
        webDriver.clickElementFromDropDownByIndex(sexo,4);
        webDriver.appendText(telefono1,Tel1);
        webDriver.appendText(telefono2, Tel2);
        webDriver.appendText(email, Email);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    public PagosSiniestroPage datosPagoCif (String TipoDocumentoCif,  String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(tipoDocumento,1);
        webDriver.appendText(numeroDocumento,TipoDocumentoCif);
        webDriver.appendText(telefono1,Tel1);
        webDriver.appendText(telefono2, Tel2);
        webDriver.appendText(email, Email);
        webDriver.exitFrame();

        debugEnd();
        return this;
    }

    //Domicilio

    public PagosSiniestroPage domicilio(String Domicilio, String Numero, String Portal, String Escalera, String Piso, String Puerta, String CodigoPostal, String Poblacion){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementFromDropDownByIndex(tipoVia, 14);
        webDriver.appendText(domicilio, Domicilio);
        webDriver.appendText(numero, Numero);
        webDriver.appendText(portal, Portal);
        webDriver.appendText(escalera, Escalera);
        webDriver.appendText(piso, Piso);
        webDriver.appendText(puerta, Puerta);
        webDriver.appendText(codigoPostal, CodigoPostal);
        webDriver.appendText(poblacion, Poblacion);
        webDriver.exitFrame();
        debugEnd();
        return this;
    }


    //Observaciones

    public PagosSiniestroPage observaciones  (String Observaciones){
        debugBegin();
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.appendText(observaciones, Observaciones);
        webDriver.exitFrame();
        debugEnd();
        return this;
    }

    //Importes
    public PagosSiniestroPage importes (String fPago, String Importe1, boolean activarPlanMAC) {
        debugBegin();
        List<WebElement> listaCausasImportes = webDriver.getElementsInFrame(causasImportes, cuerpoFrame);

        webDriver.appendTextInFrame(fechaDePago, cuerpoFrame, fPago);
        webDriver.waitWithDriver(3000);

        //concepto pago

        webDriver.clickElementChildByIndexInFrame(conceptoPago, cuerpoFrame, 1);
        webDriver.waitWithDriver(12000);
        //Asignacion de cobertura
        System.out.println("Lista de coberturas: " + listaCausasImportes);
        System.out.println("Cobertura seleccionada: " + webDriver.getTextInFrame(listaCausasImportes.get(0), cuerpoFrame));

        webDriver.clickInFrame(listaCausasImportes.get(0), cuerpoFrame);
        //webDriver.clickInFrame(rCRotura, cuerpoFrame);
        webDriver.appendTextInFrame(importe0, cuerpoFrame, Importe1);
        webDriver.waitWithDriver(5000);
        webDriver.clickInFrame(actualizarImportePago, cuerpoFrame);

        if(activarPlanMAC == true) {
            webDriver.clickInFrame(radioActivarPlanPago, cuerpoFrame);
            webDriver.waitWithDriver(8000);
            webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
            webDriver.exitFrame();
        } else {
            webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
        }

        debugEnd();
        return this;
    }

    public PagosSiniestroPage verificacion (){
        debugBegin();
        
        webDriver.waitWithDriver(9000);
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
                if (listaPagos.get(i).getText().compareTo("Pagado") !=0 && listaPagos.get(i).getText().compareTo("Anulado") !=0 ){
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

    public PagosSiniestroPage emitirPlanPagosMAC(String fechaPlanPrimerPago,  String fechaActivacion, String importePrimerPagoPlan){
        debugBegin();
       // webDriver.switchToFrame(cuerpoFrame);

        DateFormat fPlanPrimerPago = new SimpleDateFormat("dd/MM/yyyy");

        DateFormat fActivacionPlan = new SimpleDateFormat("dd/MM/yyyy");



      // if(fechaPlanPrimerPago.isEmpty() || fechaPlanPrimerPago == null) {
           webDriver.switchToFrame(cuerpoFrame);
           webDriver.appendText(planFPrimerPago,fPlanPrimerPago.format(new Date()));
           // DateFormat fPlanPrimerPago = new SimpleDateFormat("dd/MM/yyyy");
          //  webDriver.waitWithDriver(3000);
            //webDriver.appendText(planFPrimerPago, fPlanPrimerPago.format(new Date()));
      /*       webDriver.exitFrame();
       }
        else {webDriver.appendTextInFrame(planFPrimerPago, cuerpoFrame, fechaPlanPrimerPago);}
*/
        webDriver.appendText(planFActivacion,fActivacionPlan.format(new Date()));
      /*  if(fechaActivacion.isEmpty() || fechaActivacion == null) {
            webDriver.switchToFrame(cuerpoFrame);
            DateFormat fActivacionPlan = new SimpleDateFormat("dd/MM/yyyy");
            webDriver.waitWithDriver(3000);
            webDriver.appendText(planFActivacion, fActivacionPlan.format(new Date()));
            webDriver.exitFrame();
        }
        else {webDriver.appendTextInFrame(planFActivacion, cuerpoFrame, fechaActivacion);}
*/
        webDriver.appendText(planImportePrimerPago, importePrimerPagoPlan);
        webDriver.click(btnGenerarPlan);
        webDriver.waitWithDriver(2000);
        //método para probar que se ha generado
        if(webDriver.isPresent(tablaPagos)) {
            if(webDriver.getText(tablaPagos).contains("120")) {
                System.out.println("Si está presente el importe de primer pago");
                webDriver.click(botonContinuar1);
            }
        } else {
            System.out.println("NO está presente el importe del primer pago");
            webDriver.click(botonContinuar1);
        }
        webDriver.exitFrame();
        debugEnd();
        return this;
    }

    public PagosSiniestroPage comprobarPlanPagosMAC (){
        debugBegin();
        webDriver.waitWithDriver(4000);
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.click(volverListaPagos);
        if(webDriver.isPresent(marcaPagos)) {
            webDriver.getText(marcaPagos).contains("2000");
            System.out.println("Si está presente el importe de pagos");
            //webDriver.waitForElementToBeClickable(botonContinuar1);
        } else System.out.println("La marca de pagos NO muestra el importe del plan de pagos");
        webDriver.exitFrame();
        debugEnd();
        return this;
    }

    public PagosSiniestroPage iniciarPagoACarpeta (){
        debugBegin();
        webDriver.waitWithDriver(4000);
        webDriver.clickInFrame(abrirBloques, leftFrame);
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.click(desplegarCarpetas);
        debugInfo("Se despliegan las carpetas del bloque");
        webDriver.isClickableAndClick(menuAccionesCarpetaBloque);
       // webDriver.click(menuAccionesCarpetaBloque);
        debugInfo("se abre el menú de acciones de las carpetas");
        webDriver.isClickableAndClick(btnPagoACarpeta);
        debugInfo("clic en botón pago a carpeta");
        webDriver.exitFrame();
        debugEnd();
        return this;
    }

  //  localizar IMAS - Implicado asegurado	en tabla  <td>IMAS - Implicado asegurado</td> -- #bloque1tr1b > td:nth-child(2)
  //   body > form > table.grid.wideBox > tbody ---  tr#tr1b > td > div > table > tbody   tr#bloque1tr1b > td:nth-child(7) --  div#capaFlecha1910403

 /*   for(int i = 0; i < listaBloques.size(); i++){
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
        }"table.grid.wideBox > tbody > tr[id*='bloque']"
*/
    // endregion
}
