package com.amaris.project.pages.administracion.siniestros.gestion;

import com.amaris.automation.model.utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
import org.testng.Assert;

public class AgendaSiniestrosPage extends PageObject {

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By modalIframe = By.cssSelector("#capaIframe");

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

	private By agendaBtn = By.cssSelector("#jt4");

	private By nuevaTareaBtn = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
	private By altaAnotacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(3) span");
	private By comunicacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(5) span");
	private By rehuse = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(7) span");

	// opciones de las pestañas de información
	private By pestanyaTodasLasTareas = By.cssSelector("#pes0 > span");
	private By pestanyaSiniestro = By.cssSelector("#pes1 > span");
	private By pestanyaImplicadoAsegurado = By.cssSelector("#pes2 > span");

	private By infoFiltrar = By.cssSelector("#cabFiltrar > strong");
	private By infoLeyenda = By.cssSelector("#cabLeyenda > strong");
	private By infoMisEtiquetas = By.cssSelector("#cabEtiquetas > strong");
	private By infoTareasFuturas = By.cssSelector("#cabCalendario > strong");
	private By infoVerEnCalendario = By.cssSelector("#cabTareasCalendario > strong");
	private By infoTareasRealizadas = By.cssSelector("#cabCalendarioRealizadas > strong");
	private By infoExportarTareas = By.cssSelector("#cabExportarTareas > strong");

	// nueva tarea
	private By tituloInput = By.cssSelector("#titulo");
	private By descripcionInput = By.cssSelector("#anotacion");
	private By categoriaBtn = By.cssSelector("#categoria");
	// Son dos opciones dentro de la categoría
	private By categoriaTSLA = By.cssSelector("#categoria > option:nth-child(2)");
	// TODO: comprobar si vale la más la pena seleccionarla por VALUE desde categoria
	private By categoriaTSIN = By.cssSelector("#categoria > option:nth-child(3)");
	private By pioridadBtn = By.cssSelector("#priority");
	private By fechaFinInput = By.cssSelector("#fechaler");
	private By email = By.cssSelector("#email");
	private By grabarBtn = By.cssSelector("body > form > table input[name='botonGrabar']");
	private By cerrarTareaBtn = By.cssSelector("input[name='botonCerrar']");
	private By detalleTarea = By.linkText("Detalle");

	// Cabecera
	private By plantillas = By.cssSelector("#cabPlantillas");
	private By codPlantilla = By.cssSelector("#queryPlantilla");
	private By buscarPlantilla = By.cssSelector("#botonPlantilla");
	private By selecPlantilla = By.cssSelector("#plantilla");

	// Cambiar operador
	private By cambiOperador = By.cssSelector("#cabCambiarOperador");
	private By btnCambiarOP = By.cssSelector("#bloqueCambiarOperador td > a");

	// Documentos
	private By documentos = By.cssSelector("#cabDocumentos");
	private By seleccionar = By.cssSelector("#fichero");
	private By anexar = By.cssSelector("#botonAnexar");

	// Etiquetas
	private By etiquetas = By.cssSelector("#cabEtiquetas");
	private By txtEtiquetas = By.cssSelector("#textoEtiquetas");
	private By asociarEti = By.cssSelector("#botonAsociar");

	// Pestañas
	private By todasTareasBtn = By.cssSelector("#pes0");

	private By tramitacionSiniestrosLista = By.cssSelector("#tablaResultados > table > tbody > tr.even > td:nth-child(1) > a");
	private By listaTareasRealizadas = By.cssSelector("#tablaResultados > table > tbody > tr");

	// Lista de estado de las tareas
	private By todasLasTareasRow = By.cssSelector("#capaAjax > form > table > tbody > tr:not(:first-child)");

	private By estadoTareaTxt = By.cssSelector("table.grid tbody:nth-child(1) tr[valign='top'] td:nth-child(5)");
	private By tituloTareaTxt = By.cssSelector("table.grid tbody:nth-child(1) tr[valign='top'] td:nth-child(7)");
	private By listaTareasTabla = By.cssSelector("table.grid tbody:nth-child(1) tr");

	private String tareasRow = "#capaAjax > form > table > tbody > tr:nth-child([INDEX]):not(:first-child)";

	private By accionesListaTodasLasTareas = By.cssSelector("[id*=capaFlecha] > a");

	private By detalleBtn = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By altaRelacionadaBtn = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");

	public AgendaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public AgendaSiniestrosPage nuevaTarea() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		ActionSteps.waitForIt(webDriver);
		debugInfo("Se accede a Agenda");
		webDriver.clickInFrame(nuevaTareaBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);

		debugInfo("Click en Nueva tarea");
		debugInfo("El título de la tarea a dar de alta en el CSV es " + getTestVar(Constants.TAREA_TITULO));
		String titulo = "Nueva tareas automatica " + StringUtils.getRandomLetterChain(5);

		if(getTestVar(Constants.TAREA_TITULO) != null && !getTestVar(Constants.TAREA_TITULO).isEmpty()) {
			webDriver.setTextInFrame(tituloInput, cuerpoFrame, getTestVar(Constants.TAREA_TITULO));
		} else {
			webDriver.setTextInFrame(tituloInput, cuerpoFrame, titulo);
			setTestVar((Constants.TAREA_TITULO), titulo);
		}

		webDriver.setTextInFrame(descripcionInput, cuerpoFrame, "Esta tarea se ha creado en una prueba automatizada");
		webDriver.clickElementChildByAttributeInFrame(categoriaBtn, cuerpoFrame, "value", "TSLA");
		webDriver.clickElementChildByAttributeInFrame(pioridadBtn, cuerpoFrame, "value", "1");
		webDriver.setTextInFrame(fechaFinInput, cuerpoFrame, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.waitWithDriver(5000);

		debugEnd();
		return this;
	}


	public AgendaSiniestrosPage gestionTarea() {
		debugBegin();

		webDriver.waitWithDriver(2600);
		webDriver.clickInFrame(todasTareasBtn, cuerpoFrame);
		webDriver.waitWithDriver(2000);

		List<WebElement> listaTareas = webDriver.getElementsInFrame(listaTareasTabla, cuerpoFrame);
		debugInfo("Contiene: " + listaTareas.size() + " tareas");

		String obtenerTittuloUltimaTarea = webDriver.getTextInFrame(By.cssSelector("#capaAjax > form > table > tbody > tr:nth-child(2) > td:nth-child(7)"), cuerpoFrame).trim();
		debugInfo("Título de la tarea es: " + obtenerTittuloUltimaTarea);
		debugInfo("Mensaje real: " + getTestVar(Constants.TAREA_TITULO));

		String obtenerReferenciaUltimaTarea = webDriver.getTextInFrame(By.cssSelector("#capaAjax > form > table > tbody > tr:nth-child(2) > td:nth-child(2)"), cuerpoFrame).trim();
		debugInfo("La referencia de la tarea es: " + obtenerReferenciaUltimaTarea);
		boolean checkTarea = obtenerTittuloUltimaTarea.equalsIgnoreCase(getTestVar(Constants.TAREA_TITULO));
		Assert.assertTrue(checkTarea, "El título de la tarea no es correcto.");

		if(webDriver.isPresentInFrame(estadoTareaTxt, cuerpoFrame) && checkTarea == true) {

			webDriver.clickInFrame(By.cssSelector("#capaFlecha" + obtenerReferenciaUltimaTarea + "> a"), cuerpoFrame);
			webDriver.clickInFrame(detalleTarea, cuerpoFrame);
			webDriver.clickInFrame(cerrarTareaBtn, cuerpoFrame);

		} else {
			debugInfo("Ha habido un error en la comparación de tareas");
		}
		webDriver.clickInFrame(infoTareasRealizadas, cuerpoFrame);
		webDriver.clickInFrame(By.cssSelector("#tablaResultados > table > tbody > tr.even > td.pijama2 > a"), cuerpoFrame);
		webDriver.waitWithDriver(2000);

		List<WebElement> listaTareasResueltas = webDriver.getElementsInFrame(listaTareasTabla, cuerpoFrame);

		debugInfo("Contiene: " + listaTareasResueltas.size() + " tareas");

		//for(int j = 1; j < listaTareasResueltas.size(); j++) {
			String obtenerReferenciasTareasResueltas = webDriver.getTextInFrame(By.cssSelector("#tablaResultados > form > table > tbody > tr.odd > td:nth-child(2)"), cuerpoFrame).trim();

			debugInfo("Las tareas cerradas son: " + obtenerReferenciasTareasResueltas);

			boolean checkTareaRealizada = obtenerReferenciaUltimaTarea.equalsIgnoreCase(obtenerReferenciasTareasResueltas);
			Assert.assertTrue(checkTareaRealizada, "El título de la tarea cerrada no es correcto.");
	//	}

		//}
		debugInfo("------- TE HAS FLIPADO MUCHO, ACABAS DE HACER EL CIERRE Y COMPROBACIONES DE TAREAS DE UNA VEZ- --------");
		debugEnd();
		return this;
	}

}// END