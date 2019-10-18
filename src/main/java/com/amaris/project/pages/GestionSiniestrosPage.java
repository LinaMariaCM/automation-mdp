package com.amaris.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;



public class GestionSiniestrosPage extends PageObject{
	
    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By exportaResultado = By.cssSelector("#cabExportar");

    //posiocion global
    
    private By diario = By.id("jt3");
    private By vista = By.id("jt");
    private By agenda = By.id("jt4");
    private By documentacion = By.id("jt5");	
    private By comunicacion = By.id("jt6");
    private By bloque = By.id("jt7");
    private By procesos = By.id("jt8");
    
    //Datos económicos 
    
    //OJO! revisar conforme se intreractue con los distintos elementos si es necesario pasar de by.id() a by.xpath()
    private By reservasYExpectativas = By.xpath(".//*[text()='Reservas y expectativas'] "); 
    
    private By pagos = By.cssSelector("jt11");
    
    private By recobros = By.id("jt12");
    
    //Otras gestiones
    private By gestionDelFraude = By.id("jt14");
    //Carpetas
  
    private By gestionDeCarpetas = By.xpath(".//*[title()='Gestión de carpetas'] "); 
  
    
    //Reservas del siniestro
    
    private By infoCarpeta = By.xpath("//*[@id='bloque1tr1']/td[2]/text()");
    private By infoBloque = By.cssSelector("#bloque1tr1 > td:nth-child(3)");
    private By infoReservaActual = By.cssSelector("#bloque1tr1 > td:nth-child(4)");
    private By infoPagos = By.cssSelector("#bloque1tr1 > td:nth-child(5)");
    private By infoExpectativaActual = By.cssSelector("#bloque1tr1 > td:nth-child(6)");
    private By infoRecobros = By.cssSelector("#bloque1tr1 > td:nth-child(7)");
    private By infoCoste = By.cssSelector("#bloque1tr1 > td:nth-child(8)");
    
    private By acciones = By.cssSelector("[id*='capaFlecha'] a");
    
    
    
    private By consultarExpectaticvas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
    private By consultarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
    private By modificarExepectativas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");;
    private By modificarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(4) > a");;
    
    //modificacion expectativa actual
    
    private By expReservaIndemnizable = By.cssSelector("#espectativa_CR001");
    private By expReservaReparable = By.cssSelector("#espectativa_CR002");
    private By expReservaGastos = By.cssSelector("#espectativa_CR003");   
    
    
    private By btnGrabarExpectativa = By.cssSelector("#botonGrabar");
    private By btnCancelarExpectativa = By.cssSelector("#botonCancelar");
    
    //modificacion reserva actuial
    
    private By reservaIndemnizable = By.cssSelector("#CR001");
    private By reservaReparable = By.cssSelector("#CR002");
    private By reservaGastos = By.cssSelector("#CR003");  
    
    ////Buscador de siniestros

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

    

    private By verSaldo = By.cssSelector("ul.list-level-1.js-actionsdinamicbar:nth-child(1) span");

    
	public GestionSiniestrosPage(UserStory userS) {
		super(userS);
	} 
    
    
    //Acciones menu izquierda    
    

    public GestionSiniestrosPage agenda(){	
    	debugBegin();
    	webDriver.clickInFrame(agenda, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage documentacion(){
    	debugBegin();
    	webDriver.clickInFrame(documentacion, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage comunicacion(){
    	debugBegin();
    	webDriver.clickInFrame(comunicacion, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage bloque(){	
    	debugBegin();
    	webDriver.clickInFrame(bloque, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage procesos(){
    	debugBegin();
    	webDriver.clickInFrame(procesos, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage reservasYExpecativas(){
    	debugBegin();
    	webDriver.clickInFrame(reservasYExpectativas, leftFrame);
    	
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage pagos(){
    	debugBegin();
    	webDriver.clickInFrame(pagos, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage recobros(){
    	debugBegin();
    	webDriver.clickInFrame(recobros,  leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage gestionDelFraude(){
    	debugBegin();
    	webDriver.clickInFrame(gestionDelFraude, leftFrame);
    	debugEnd();
    	return this;}
    
    public GestionSiniestrosPage gestionDeCarpetas(){
    	debugBegin();
    	webDriver.clickInFrame(gestionDeCarpetas, leftFrame);
    	//webDriver.click(gestionDeCarpetas);
    	debugEnd();
    	return this;}
    // end region
    
    //Reservas y expectativas
    //Acciones
    
    String expectativaTotal = "";
    public GestionSiniestrosPage modificarExpectativa(){	
    	
    	debugBegin();
    	double resIndemnizable = (double) Math.round((Math.random()*10) * 100d) / 100d;    	 
       	double resReparable = (double) Math.round((Math.random()*10) * 100d) / 100d;    	
    	double resGastos = (double) Math.round((Math.random()*10) * 100d) / 100d;
    	   	
    	expectativaTotal = Double.toString(resIndemnizable + resReparable + resGastos);
    	
    	List<WebElement> listaAcciones = webDriver.getElements(acciones);
    	   	
    	webDriver.clickInFrame(listaAcciones.get(1), cuerpoFrame);
    	
    	webDriver.clickInFrame(modificarExepectativas, capaIframe);
    	
    	webDriver.setTextInFrame(expReservaIndemnizable, capaIframe, Double.toString(resIndemnizable));
    	
    	webDriver.setTextInFrame(expReservaReparable, capaIframe, Double.toString(resReparable));
    	
    	webDriver.setTextInFrame(expReservaGastos, capaIframe, Double.toString(resGastos));
    	
    	webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
    	
    	debugEnd();
    	return this;
    	
    }
    
    public GestionSiniestrosPage modificarExpectativasACero(){
    
    debugBegin();	
    	
    expectativaTotal = "0";	
    
	webDriver.clickInFrame(acciones, cuerpoFrame);
	
	webDriver.clickInFrame(modificarExepectativas, capaIframe);
	
	webDriver.setTextInFrame(expReservaIndemnizable, capaIframe, "0");
	
	webDriver.setTextInFrame(expReservaReparable, capaIframe, "0");
	
	webDriver.setTextInFrame(expReservaGastos, capaIframe, "0");
	
	webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
	
	webDriver.acceptAlert();

	debugEnd();
	
	return this;
    }
    
    String reservaTotal = "";
    public GestionSiniestrosPage modificarReserva(){	
    	
    	debugBegin();
    	
    	double resIndemnizable = (double) Math.round((Math.random()*10) * 100d) / 100d;    	 
       	double resReparable = (double) Math.round((Math.random()*10) * 100d) / 100d;    	
    	double resGastos = (double) Math.round((Math.random()*10) * 100d) / 100d;
    	   	
    	reservaTotal = Double.toString(resIndemnizable + resReparable + resGastos);
    	 	
    	webDriver.clickInFrame(acciones, cuerpoFrame);
    	
    	webDriver.clickInFrame(modificarExepectativas, capaIframe);
    	
    	webDriver.setTextInFrame(reservaIndemnizable, capaIframe, Double.toString(resIndemnizable));
    	
    	webDriver.setTextInFrame(reservaReparable, capaIframe, Double.toString(resReparable));
    	
    	webDriver.setTextInFrame(reservaGastos, capaIframe, Double.toString(resGastos));
    	
    	webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
    	
    	debugEnd();
    	
    	return this;
    	
    }
    
    public GestionSiniestrosPage modificarReservaACero(){
    
    debugBegin();	
    	
	reservaTotal = "0";
    	
    webDriver.clickInFrame(acciones, cuerpoFrame);
	
	webDriver.clickInFrame(modificarExepectativas, capaIframe);
	
	webDriver.setTextInFrame(reservaIndemnizable, capaIframe, "0");
	
	webDriver.setTextInFrame(reservaReparable, capaIframe, "0");
	
	webDriver.setTextInFrame(reservaGastos, capaIframe, "0");
	
	webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
	
	webDriver.acceptAlert();
	
	debugEnd();

	return this;
    }
        
    public GestionSiniestrosPage verificarTotales(){
    debugBegin();
    	
    if(infoReservaActual.equals(reservaTotal)) System.out.println("verificarTotales info: las reservas coinciden.");
	 else System.out.println("verificarTotales info : las reservas NO coincicen.");
    
	System.out.println("reserva Actual: " + infoReservaActual);
	System.out.println("reserva Total: " + reservaTotal);
    
    if(infoExpectativaActual.equals(expectativaTotal)) System.out.println("verificarTotales info : las expectativas coincicen.");
    	else System.out.println("verificarTotales info : las expectativas NO coincicen.");

	System.out.println("expectativa Actual: " + infoExpectativaActual);
	System.out.println("expectativa Total: " + expectativaTotal);
    debugEnd();
    return this;
    }
    
}