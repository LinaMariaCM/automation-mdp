package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ComunicacionSiniestrosPage extends PageObject {

    private By cuerpoFrame = By.id("mainFrame");
    private By leftFrame = By.cssSelector("#leftFrame");
    private By capaIframe = By.cssSelector("#capaIframe");

    private By comunicacion = By.cssSelector("#jt6");

    private By nuevaComuni = By.cssSelector("#tr0 a.si-arrow-right");
    
    private By altaAnotacion = By.cssSelector("li.js-action:nth-child(1) > a:nth-child(1");
    
    private By anyadirNuevaAnotacion = By.cssSelector(".js-toggleblockparam");

    //1.Medio de envío
    //alta comunicacion
    private By medioEnvio = By.cssSelector("#medio");
    private By privacidad = By.cssSelector("#privi");
    private By destino = By.cssSelector("#desti");

    //datos medio de envio
    private By nombre = By.cssSelector("#nombre");
    private By email = By.id("email");
    
    private By via = By.cssSelector("#tipovia");
    private By domicilio = By.cssSelector("#domicilio");
    private By numero = By.cssSelector("#numdomi");
    private By  cp = By.cssSelector("#cp");

    //nuevos destinatarios
    private By nombreNuevo = By.id("nombreNew");
    private By emailNuevo =By.id("mailNew");
    private By btnAnyadirNuevo =By.cssSelector(".secondButton");
    
    private By continuar = By.cssSelector("input.mainButton");

    //cumplimentacion

    private By asunto = By.cssSelector("#email");
    private By modelo = By.cssSelector("#dcarplan");
    private By modificarSi = By.cssSelector("#modiConteSi");
    private By modificarNo = By.cssSelector("#modiConteNo");
    private By cajaTxt = By.cssSelector("#tinymce");
    private By check = By.cssSelector("#check_Doc_0");   // el numero final del selector indica la final que esta disponible
    private By lupa = By.cssSelector("tr.odd span");   // es la lupa de la primera fila
    private By enviar = By.cssSelector("#botonContinuar");

    //2.Cumplimentación
    //Medio de envío
    
    private By AsuntoMail = By.cssSelector("#email");
    private By ModeloMail = By.id("dcarplan");
    
    private By rdsButtonModificarSi = By.id("modiConteSi");
    private By rdsButtonModificarNo  = By.id("modiConteNo");
    
    //Contenido de la carta
    
    private By contenidoCarta = By.id("tinymce");
    
    
    //Añadir nueva anotacion
    private By tituloNuevaAnotacion = By.cssSelector("div.sis-col-100:nth-child(1) > div:nth-child(2) > select:nth-child(1)");
    private By comentarioNuevaAnotacion = By.cssSelector("#comentario");
    private By ConfidencialidadAnotacion = By.cssSelector("div.sis-col-100:nth-child(5) > div:nth-child(2) > select:nth-child(1)");
    private By grabarAnotacion = By.cssSelector("#botonContinuar2");
    private By confidencialAnotacion = By.cssSelector("div.sis-col-100:nth-child(5) > div:nth-child(2) > select:nth-child(1)");
    private By btnCancelarAnotacion = By.cssSelector("#botonCancelar");
    
    //END REGION
    
    //Constructor
    public ComunicacionSiniestrosPage(UserStory userS) {
		super(userS);
	} 

    
    public ComunicacionSiniestrosPage nuevaComunicacion(){
    	debugBegin();
    	
    	webDriver.clickInFrame(comunicacion, cuerpoFrame);   	
    	
    	webDriver.clickInFrame(nuevaComuni, cuerpoFrame); 
    	
    	//1.Medio de envío
    	//Medio de envío   	
    	webDriver.clickElementFromDropDownByAttributeInFrame(medioEnvio, cuerpoFrame, "value", "EMAIL");
       	webDriver.clickElementFromDropDownByAttributeInFrame(privacidad, cuerpoFrame, "value", "");
    	
    	//Destinatarios
    	webDriver.clickElementFromDropDownByAttributeInFrame(destino, cuerpoFrame, "value", "3"); // Sí, en esta lista el valor va por números.
    	
    	//Datos medio de envío
    	webDriver.setTextIfEmpty(nombre, "Anónimos Sociedad Anónima ");
    	webDriver.setTextIfEmpty(email, "prueba@esto.es");
    	
    	//Nuevos destinatarios
    	//TODO En principio no son obligatorios, si bien en un futuro se pueden añadir.
    	
    	
    	//Figuras para ser destinatarios
    	//TODO No obligatorias, se pueden añadir más adelante.
    	
    	webDriver.clickInFrame(continuar, cuerpoFrame);
    	
    	//2.Cumplimentación
    	
    	//Medio de envío
    	//Autorrellenado
    	
    	//Contenido de la carta
    	webDriver.setTextInFrame(contenidoCarta, cuerpoFrame, "Yo he visto cosas que vosotros no creeríais." + 
    														"Atacar naves en llamas más allá de Orion." + 
    														"He visto rayos C brillar en la oscuridad cerca de la puerta de Tannhäuser." +
    														"Todos esos momentos... se perderán, como lágrimas en la lluvia.");
    	
    	webDriver.clickInFrame(enviar, cuerpoFrame);
    	debugEnd();    	
    	return this;
    	   }
        
    public ComunicacionSiniestrosPage nuevaAnotacion(){
    	debugBegin();
    	
    	webDriver.clickInFrame(altaAnotacion, cuerpoFrame);
    	
    	webDriver.clickInFrame(anyadirNuevaAnotacion, capaIframe);
    	
    	webDriver.clickElementFromDropDownByAttributeInFrame(tituloNuevaAnotacion, capaIframe, "value", "Otros");
    	
    	webDriver.setTextInFrame(comentarioNuevaAnotacion, capaIframe, "Ipsum sum, Lorem lorem, Factum factum.");
    	
    	webDriver.clickElementFromDropDownByAttributeInFrame(confidencialAnotacion, capaIframe, "value", "VIGLOBAL");
    	
    	webDriver.clickInFrame(btnCancelarAnotacion, capaIframe);
    	    	   	
    	
    	debugEnd();
    	return this;
    }

    
    //END
} 