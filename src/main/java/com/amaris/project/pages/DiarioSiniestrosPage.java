package com.amaris.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.*;
import java.util.List;


public class DiarioSiniestrosPage extends PageObject {


    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");
    private By diarioSiniestro = By.cssSelector("#jt2");
    
    private By anotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) > a > span");
    private By comunicacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) > a > span");
    private By rehuse = By.cssSelector("li.js-action:nth-child(5) > a:nth-child(1) > span");
    
    // Información general
	private By nPolizaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By responsableInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)");
	private By aseguradoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By fOcurrenciaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");	
	private By riesgoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By fAperturaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)");
	private By tipoCausaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(1)");
	private By estadoSiniestroInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)");
	private By mediadorInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(1)");
	private By tareasPendientesInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(6) > td:nth-of-type(1)");
	private By costeActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");    	
	private By importePagosInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");   	
	private By reservaActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By causaSin = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(1)");

	private By avisos = By.cssSelector("body > table.sis-frame-bg.wideBox > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)");
	
    //Pestaña de informacion
    private By pestSituacion = By.cssSelector("#cargaCategorias > li:nth-child(2) > a");
    private By pestComunicacion = By.cssSelector("#cargaCategorias > li:nth-child(3) > a");
    private By pestAnotacion = By.cssSelector("#cargaCategorias > li:nth-child(4) > a");

    //Pop-up anotacion
    private By nuevaAnotacion = By.cssSelector("div.menuNav.menuNavPosAbsolute span");
    private By titulo = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(1) select");
    private By txtComentario = By.cssSelector("#comentario");
    private By Confidencialidad = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(5) select");
    private By grabarAnotacion = By.cssSelector("#botonContinuar2");
    private By desplegarComen = By.cssSelector("table:nth-child(6)  a:nth-child(1)");
    private By ocultarComen = By.cssSelector("table:nth-child(6) > tbody > tr > td > a:nth-child(2)");
    private By cancelar = By.cssSelector("#botonCancelar");

    //Rehuso
    private By motivo = By.cssSelector("#idMotivo");
    private By txtDescripcion = By.cssSelector("#idDescripcion");
    private By inputSi = By.cssSelector("#swCerrSi");
    private By inputNo = By.cssSelector("#swCerrNo");
    private By destino = By.cssSelector("#desti");
    private By grabar = By.cssSelector("#botonGrabar");
    private By nombre = By.cssSelector("#nombre");
    private By email = By.cssSelector("#email");
    
    //Información de comunicación
    
    private By listadoMovimientosSiniestro = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(3) > p:nth-child(8)");
    private By filaListadoMovimientos = By.cssSelector("#tbldiario_wrapper > table > tbody tr");
    
    

    public DiarioSiniestrosPage(UserStory userS) {
        super(userS);
    }

    public DiarioSiniestrosPage rehusar_siniestro(){
        debugBegin();
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(diarioSiniestro, leftFrame);
        debugInfo("estoy en diario");
        ActionSteps.waitForIt(webDriver);
        webDriver.clickInFrame(rehuse, cuerpoFrame);
        ActionSteps.waitForIt(webDriver);
        debugInfo("estoy en rehuso");
        webDriver.switchToFrame(cuerpoFrame);
        webDriver.clickElementChildByAttribute(motivo,"value", "ANEF");
        webDriver.click(inputNo);
        debugInfo("motivo introducido");
        webDriver.clickElementChildByAttribute(destino,"value", "0");
        ActionSteps.waitForIt(webDriver);
        webDriver.setText(nombre, "Prueba Rehuso");
        webDriver.setText(email, "rehuso@rehuso.com");
        webDriver.click(grabar);
        webDriver.exitFrame();
        ActionSteps.waitForIt(webDriver);

        return this;
    }
    
    //TODO completar parte de reconsiderar
    
    public boolean comprobar_siniestro_reconsiderado(){
        debugBegin();

       //comprobar estado de siniestro : "Reconsiderado"        
        
        boolean reconsiderado = webDriver.getTextInFrame(avisos,cuerpoFrame).contains("Reconsiderado");
        if(reconsiderado) { System.out.println("Siniestro reconsiderado");}
        // donde se realice la llamada es necesario colocar una assert para evaluar la comprobación
        
        return reconsiderado;
    }
    
    public DiarioSiniestrosPage comprobarComunicacion(){
    	debugBegin();
    	
    	String mensaje = "Tannhäuser";
    	
    	System.out.println("Comprobando mensaje de comunicación...");
    	
    	if(webDriver.getTextInFrame(listadoMovimientosSiniestro, cuerpoFrame).contains(mensaje)) System.out.println("OK , mensaje de comunicación CORRECTO.");
    	else System.out.println("KO , mensaje de comunicación ERRÓNEO.");
    	
    	debugEnd();
    	return this;
    }
    
    public DiarioSiniestrosPage comprobarAnotacion(){
    	debugBegin();
    	
    	String mensaje = "Ipsum";
    	
    	System.out.println("Comprobando mensaje de anotación...");
    	
    	if(webDriver.getTextInFrame(listadoMovimientosSiniestro, cuerpoFrame).contains(mensaje)) System.out.println("OK , mensaje de anotación CORRECTO.");
    	else System.out.println("KO , mensaje de anotación ERRÓNEO.");
    	
    	debugEnd();
    	return this;
    }
    
    public DiarioSiniestrosPage mostrarInfoGeneral() {
    	debugBegin();
    	debugInfo("Información General desde Diario de Siniestro");
    	System.out.println("=========================================");
    	
        webDriver.switchToFrame(cuerpoFrame);
    	
    	System.out.println("Número de Póliza: " + webDriver.getText(nPolizaInfo));    	
    	System.out.println("Responsable: " + webDriver.getText(responsableInfo));    	
    	System.out.println("Asegurado: " + webDriver.getText(aseguradoInfo));    	
    	System.out.println("Fecha ocurrencia: " + webDriver.getText(fOcurrenciaInfo));    	
    	System.out.println("Riesgo: " + webDriver.getText(riesgoInfo));    	
    	System.out.println("Fecha apertura: " + webDriver.getText(fAperturaInfo));    	
    	System.out.println("Tipo de causa: " + webDriver.getText(tipoCausaInfo));    	
    	System.out.println("Estado Siniestro: " + webDriver.getText(estadoSiniestroInfo));    	
    	System.out.println("Mediador: " + webDriver.getText(mediadorInfo));    	
    	System.out.println("Tareas pendientes: " + webDriver.getText(tareasPendientesInfo));    	
    	System.out.println("Coste actual: " + webDriver.getText(costeActualInfo));    	
    	System.out.println("Importe pagos: " + webDriver.getText(importePagosInfo));    	
    	System.out.println("Reserva actual: " + webDriver.getText(reservaActualInfo));  	
    	
    	webDriver.exitFrame();
    	
    	debugEnd();
    	return this;
    }

    public DiarioSiniestrosPage mostrarListadoMovimientos() {
    	debugBegin();
    	debugInfo("Información Listado de Movimientos desde Diario de Siniestro");
    	System.out.println("=============================================================");
    	webDriver.switchToFrame(cuerpoFrame);
    	List<WebElement> listaMovimientos = webDriver.getElements(filaListadoMovimientos);
    	boolean apertura = false, imas = false; 
    	
    	for(int i=0; i< listaMovimientos.size(); i++){
        	System.out.println(webDriver.getText(listaMovimientos.get(i)));
        	if(webDriver.getText(listaMovimientos.get(i)).contains("(Abierto)") && webDriver.getText(estadoSiniestroInfo).contains("(Abierto)")) apertura = true;
        	if(webDriver.getText(listaMovimientos.get(i)).contains("IMAS")) imas = true ;        	
        	
        	}
    	System.out.println("---------------------------------------------------------");
    	System.out.println("COMPROBACION COMUNICACION APERTURA");
    	if(apertura) {
    		System.out.println("OK : apertura comunicada correctamente");
    	} else {System.out.println("KO : fallo en la apertura");}
    	if(imas) {
    		System.out.println("OK : carpeta IMAS generada");
    	}else {System.out.println("!!! : no se ha creado carpeta IMAS, revisar si existe fallo. ");}
    	System.out.println("=============================================================");
    	
    	webDriver.exitFrame();
    	
    	debugEnd();
    	return this;
    }
    
//END    
}