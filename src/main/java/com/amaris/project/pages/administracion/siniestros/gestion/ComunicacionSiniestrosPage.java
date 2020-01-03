package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class ComunicacionSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By comunicacionBtn = By.cssSelector("[href*='codmenu=SINI_COMUNICACION']");

	private By nuevaComunicacionBtn = By.cssSelector("#tr0 a.si-arrow-right");

	private By altaAnotacionBtn = By.cssSelector("li.js-action:nth-child(1) > a:nth-child(1");

	private By anyadirNuevaAnotacionBtn = By.cssSelector(".js-toggleblockparam");

	// 1.Medio de envío alta comunicacion
	private By medioEnvioBtn = By.cssSelector("#medio");
	private By privacidadBtn = By.cssSelector("#privi");
	private By destino = By.cssSelector("#desti");

	// Datos medio de envio
	private By nombreInput = By.cssSelector("#nombre");
	private By emailInput = By.id("email");

	private By via = By.cssSelector("#tipovia");
	private By domicilio = By.cssSelector("#domicilio");
	private By numero = By.cssSelector("#numdomi");
	private By cp = By.cssSelector("#cp");

	// Nuevos destinatarios
	private By nombreNuevo = By.id("nombreNew");
	private By emailNuevo = By.id("mailNew");
	private By btnAnyadirNuevo = By.cssSelector(".secondButton");

	private By continuarBtn = By.cssSelector("input.mainButton");

	// Cumplimentacion
	private By asunto = By.cssSelector("#email");
	private By modelo = By.cssSelector("#dcarplan");
	private By modificarSi = By.cssSelector("#modiConteSi");
	private By modificarNo = By.cssSelector("#modiConteNo");
	private By cajaTxt = By.cssSelector("#tinymce");
	private By check = By.cssSelector("#check_Doc_0"); // el numero final del selector indica la final que esta
														// disponible
	private By lupa = By.cssSelector("tr.odd span"); // es la lupa de la primera fila
	private By enviarBtn = By.cssSelector("#botonContinuar");

	// 2.Cumplimentación
	// Medio de envío
	private By AsuntoMail = By.cssSelector("#email");
	private By ModeloMail = By.id("dcarplan");

	private By rdsButtonModificarSi = By.id("modiConteSi");
	private By rdsButtonModificarNo = By.id("modiConteNo");

	// Contenido de la carta
	private By contenidoCartaInput = By.id("tinymce");

	// Añadir nueva anotacion
	private By tituloNuevaAnotacionBtn = By.cssSelector("div.sis-col-100:nth-child(1) > div:nth-child(2) > select:nth-child(1)");
	private By comentarioNuevaAnotacionBtn = By.cssSelector("#comentario");
	private By ConfidencialidadAnotacion = By.cssSelector("div.sis-col-100:nth-child(5) > div:nth-child(2) > select:nth-child(1)");
	private By grabarAnotacionBtn = By.cssSelector("#botonContinuar2");
	private By confidencialAnotacionDropDwn = By.cssSelector("div.sis-col-100:nth-child(5) > div:nth-child(2) > select:nth-child(1)");
	private By cancelarAnotacionBtn = By.cssSelector("#botonCancelar");
	// END REGION

	public ComunicacionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public ComunicacionSiniestrosPage nuevaComunicacion() {
		debugBegin();

		webDriver.clickInFrame(comunicacionBtn, leftFrame);

		webDriver.clickInFrame(nuevaComunicacionBtn, cuerpoFrame);

		// 1.Medio de envío
		// Medio de envío
		webDriver.clickElementFromDropDownByAttributeInFrame(medioEnvioBtn, cuerpoFrame, "value", "EMAIL");
		webDriver.clickElementFromDropDownByAttributeInFrame(privacidadBtn, cuerpoFrame, "value", "");

		// Destinatarios
		// Sí, en esta lista el valor va por números.
		webDriver.clickElementFromDropDownByAttributeInFrame(destino, cuerpoFrame, "value", "3");

		// Datos medio de envío
		webDriver.setTextIfEmpty(nombreInput, "Anónimos Sociedad Anónima ");
		webDriver.setTextIfEmpty(emailInput, "prueba@esto.es");

		// Nuevos destinatarios
		// TODO En principio no son obligatorios, si bien en un futuro se pueden añadir.

		// Figuras para ser destinatarios
		// TODO No obligatorias, se pueden añadir más adelante.

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		// 2.Cumplimentación

		// Medio de envío Autorrellenado

		// Contenido de la carta
		webDriver.setTextInFrame(contenidoCartaInput, cuerpoFrame, "Yo he visto cosas que vosotros no creeríais." +
			"Atacar naves en llamas más allá de Orion." +
			"He visto rayos C brillar en la oscuridad cerca de la puerta de Tannhäuser." +
			"Todos esos momentos... se perderán, como lágrimas en la lluvia.");

		webDriver.clickInFrame(enviarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ComunicacionSiniestrosPage nuevaAnotacion() {
		debugBegin();

		webDriver.clickInFrame(altaAnotacionBtn, cuerpoFrame);
		
		webDriver.waitWithDriver(3000);
		
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);
		
		webDriver.click(anyadirNuevaAnotacionBtn);

		webDriver.clickElementFromDropDownByAttribute(tituloNuevaAnotacionBtn, "value", "Otros");

		setTestVar(Constants.COMENTARIO_ANOTACION, "Ipsum sum, Lorem lorem, Factum factum.");
		debugInfo("Comentario: " + getTestVar(Constants.COMENTARIO_ANOTACION));
		webDriver.setText(comentarioNuevaAnotacionBtn, getTestVar(Constants.COMENTARIO_ANOTACION));

		webDriver.clickElementFromDropDownByAttribute(confidencialAnotacionDropDwn, "value", "VIGLOBAL");

		webDriver.click(grabarAnotacionBtn);
		
		webDriver.exitFrame();

		debugEnd();

		return this;
	}
} // END