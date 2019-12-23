package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.*;
import java.util.List;

public class DiarioSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");
	private By diarioSiniestroBtn = By.cssSelector("#jt2");

	private By anotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) > a > span");
	private By comunicacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) > a > span");
	private By rehuseBtn = By.cssSelector("li.js-action:nth-child(5) > a:nth-child(1) > span");

	// Información general
	private By nPolizaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By responsableInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)");
	private By aseguradoInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By fOcurrenciaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");
	private By riesgoInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By fAperturaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)");
	private By tipoCausaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(1)");
	private By estadoSiniestroInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)");
	private By mediadorInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(1)");
	private By tareasPendientesInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(6) > td:nth-of-type(1)");
	private By costeActualInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By importePagosInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By reservaActualInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By causaSin = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(1)");

	private By avisosTxt = By.cssSelector("body > table.sis-frame-bg.wideBox > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)");

	// Pestaña de informacion
	private By pestSituacion = By.cssSelector("#cargaCategorias > li:nth-child(2) > a");
	private By pestComunicacion = By.cssSelector("#cargaCategorias > li:nth-child(3) > a");
	private By pestAnotacion = By.cssSelector("#cargaCategorias > li:nth-child(4) > a");

	// Pop-up anotacion
	private By nuevaAnotacion = By.cssSelector("div.menuNav.menuNavPosAbsolute span");
	private By titulo = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(1) select");
	private By txtComentario = By.cssSelector("#comentario");
	private By Confidencialidad = By.cssSelector("#capaApunteDialogo0 div.sis-inner-box.sis-clearfix > div:nth-child(5) select");
	private By grabarAnotacion = By.cssSelector("#botonContinuar2");
	private By desplegarComen = By.cssSelector("table:nth-child(6)  a:nth-child(1)");
	private By ocultarComen = By.cssSelector("table:nth-child(6) > tbody > tr > td > a:nth-child(2)");
	private By cancelar = By.cssSelector("#botonCancelar");

	// Rehuso
	private By motivoDrpDwn = By.cssSelector("#idMotivo");
	private By txtDescripcion = By.cssSelector("#idDescripcion");
	private By inputSi = By.cssSelector("#swCerrSi");
	private By inputNoBtn = By.cssSelector("#swCerrNo");
	private By destinoDrpDwn = By.cssSelector("#desti");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By nombreInput = By.cssSelector("#nombre");
	private By emailInput = By.cssSelector("#email");

	// Información de comunicación
	private By listadoMovimientosSiniestroTxt = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(3) > p:nth-child(8)");
	private By listadoMovimientosRows = By.cssSelector("#tbldiario_wrapper > table > tbody tr");

	public DiarioSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public DiarioSiniestrosPage rehusarSiniestro() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(diarioSiniestroBtn, leftFrame);

		debugInfo("Estoy en diario");
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(rehuseBtn, cuerpoFrame);

		debugInfo("Estoy en rehuso");
		ActionSteps.waitForIt(webDriver);
		webDriver.clickElementChildByAttributeInFrame(motivoDrpDwn, cuerpoFrame, "value", "ANEF");
		webDriver.clickInFrame(inputNoBtn, cuerpoFrame);

		debugInfo("Motivo introducido");
		webDriver.clickElementChildByAttributeInFrame(destinoDrpDwn, cuerpoFrame, "value", "0");
		ActionSteps.waitForIt(webDriver);

		webDriver.setTextInFrame(nombreInput, cuerpoFrame, "Prueba Rehuso");
		webDriver.setTextInFrame(emailInput, cuerpoFrame, "rehuso@rehuso.com");
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);

		return this;
	}

	// TODO completar parte de reconsiderar

	public boolean comprobar_siniestro_reconsiderado() {
		debugBegin();

		// Comprobar estado de siniestro : "Reconsiderado"

		boolean reconsiderado = webDriver.getTextInFrame(avisosTxt, cuerpoFrame).contains("Reconsiderado");

		if(reconsiderado) {
			debugInfo("Siniestro reconsiderado");
		}
		// Donde se realice la llamada es necesario colocar una assert para evaluar la comprobación

		return reconsiderado;
	}

	public DiarioSiniestrosPage comprobarComunicacion() {
		debugBegin();

		String mensaje = "Tannhäuser";

		debugInfo("Comprobando mensaje de comunicación...");
		if(webDriver.getTextInFrame(listadoMovimientosSiniestroTxt, cuerpoFrame).contains(mensaje)) {
			debugInfo("OK , mensaje de comunicación CORRECTO.");
		} else {
			debugError("KO , mensaje de comunicación ERRÓNEO.");
		}

		debugEnd();

		return this;
	}

	public DiarioSiniestrosPage comprobarAnotacion() {
		debugBegin();

		String mensaje = "Ipsum";

		debugInfo("Comprobando mensaje de anotación...");

		if(webDriver.getTextInFrame(listadoMovimientosSiniestroTxt, cuerpoFrame).contains(mensaje)) {
			debugInfo("OK , mensaje de anotación CORRECTO.");
		} else {
			debugError("KO , mensaje de anotación ERRÓNEO.");
		}

		debugEnd();
		return this;
	}

	public DiarioSiniestrosPage mostrarInfoGeneral() {
		debugBegin();

		debugInfo("Información General desde Diario de Siniestro");
		debugInfo("=========================================");

		debugInfo("Número de Póliza: " + webDriver.getTextInFrame(nPolizaInfoTxt, cuerpoFrame));
		debugInfo("Responsable: " + webDriver.getTextInFrame(responsableInfoTxt, cuerpoFrame));
		debugInfo("Asegurado: " + webDriver.getTextInFrame(aseguradoInfoTxt, cuerpoFrame));
		debugInfo("Fecha ocurrencia: " + webDriver.getTextInFrame(fOcurrenciaInfoTxt, cuerpoFrame));
		debugInfo("Riesgo: " + webDriver.getTextInFrame(riesgoInfoTxt, cuerpoFrame));
		debugInfo("Fecha apertura: " + webDriver.getTextInFrame(fAperturaInfoTxt, cuerpoFrame));
		debugInfo("Tipo de causa: " + webDriver.getTextInFrame(tipoCausaInfoTxt, cuerpoFrame));
		debugInfo("Estado Siniestro: " + webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame));
		debugInfo("Mediador: " + webDriver.getTextInFrame(mediadorInfoTxt, cuerpoFrame));
		debugInfo("Tareas pendientes: " + webDriver.getTextInFrame(tareasPendientesInfoTxt, cuerpoFrame));
		debugInfo("Coste actual: " + webDriver.getTextInFrame(costeActualInfoTxt, cuerpoFrame));
		debugInfo("Importe pagos: " + webDriver.getTextInFrame(importePagosInfoTxt, cuerpoFrame));
		debugInfo("Reserva actual: " + webDriver.getTextInFrame(reservaActualInfoTxt, cuerpoFrame));

		debugEnd();
		return this;
	}

	public DiarioSiniestrosPage mostrarListadoMovimientos() {
		debugBegin();

		debugInfo("Información Listado de Movimientos desde Diario de Siniestro");
		debugInfo("=============================================================");

		List<WebElement> listaMovimientos = webDriver.getElementsInFrame(listadoMovimientosRows, cuerpoFrame);
		boolean apertura = false, imas = false;

		for(int i = 0; i < listaMovimientos.size(); i++) {
			debugInfo(webDriver.getTextInFrame(listaMovimientos.get(i), cuerpoFrame));
			if(webDriver.getTextInFrame(listaMovimientos.get(i), cuerpoFrame).contains("(Abierto)") && webDriver.getText(estadoSiniestroInfoTxt).contains("(Abierto)")) {
				apertura = true;
			}

			if(webDriver.getTextInFrame(listaMovimientos.get(i), cuerpoFrame).contains("IMAS")) {
				imas = true;
			}
		}

		debugInfo("---------------------------------------------------------");
		debugInfo("COMPROBACION COMUNICACION APERTURA");
		if(apertura) {
			debugInfo("OK : apertura comunicada correctamente");
		} else {
			debugError("KO : fallo en la apertura");
		}

		if(imas) {
			debugInfo("OK : carpeta IMAS generada");
		} else {
			debugError("!!! : no se ha creado carpeta IMAS, revisar si existe fallo. ");
		}

		debugInfo("=============================================================");

		debugEnd();
		return this;
	}
} // END