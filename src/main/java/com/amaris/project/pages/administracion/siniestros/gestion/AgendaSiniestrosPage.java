package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class AgendaSiniestrosPage extends PageObject {

	// region WebElement
	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

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
	private By cerrar = By.cssSelector("input[name='botonCerrar']");

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

	// Lista de estado de las tareas
	private By todasLasTareasRow = By.cssSelector("#capaAjax > form > table > tbody > tr:not(:first-child)");

	private By estadoTareaTxt = By.cssSelector("table.grid tbody:nth-child(1) tr[valign='top'] td:nth-child(5)");
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
		webDriver.clickInFrame(agendaBtn, leftFrame);

		ActionSteps.waitForIt(webDriver);
		debugInfo("Agenda");
		webDriver.clickInFrame(nuevaTareaBtn, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugInfo("Nueva tarea");
		debugInfo(getTestVar(Constants.TAREA_TITULO));
		String titulo = "Nueva tareas automatica" + StringUtils.getRandomLetterChain(5);
		if(getTestVar(Constants.TAREA_TITULO) != null && !getTestVar(Constants.TAREA_TITULO).isEmpty()) {
			titulo = getTestVar(Constants.TAREA_TITULO);
		} else {
			setTestVar(Constants.TAREA_TITULO, titulo);
		}

		webDriver.setTextInFrame(tituloInput, cuerpoFrame, titulo);

		webDriver.setTextInFrame(descripcionInput, cuerpoFrame, "Estamos probando una prueba automatizada");

		webDriver.clickElementChildByAttributeInFrame(categoriaBtn, cuerpoFrame, "value", "TSLA");
		webDriver.clickElementChildByAttributeInFrame(pioridadBtn, cuerpoFrame, "value", "1");
		webDriver.setTextInFrame(fechaFinInput, cuerpoFrame, "30/10/2019");
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.waitWithDriver(5000);

		debugEnd();
		return this;
	}

	public boolean comprobarTareasPendientes() {
		debugBegin();

		webDriver.clickInFrame(agendaBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);

		debugInfo("Click en todas las tareas");
		webDriver.clickInFrame(todasTareasBtn, cuerpoFrame);

		Boolean check = false;

		if(webDriver.isClickableInFrame(estadoTareaTxt, cuerpoFrame)) {
			List<WebElement> listaPagos = webDriver.getElementsInFrame(estadoTareaTxt, cuerpoFrame);

			debugInfo("Contiene: " + listaPagos.size());

			for(int i = 0; i < listaPagos.size(); i++) {
				debugInfo("Estado: " + webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame));
				if(webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame).equals("Pendiente")) {
					check = true;
					debugInfo("Tareas pendiente: " + check);
				}
			}
		} else {
			debugInfo("No hay tareas");
		}

		debugEnd();

		return check;
	}

	// IMPORTANTE : si hay que interactuar con la información de la tabla de tareas,
	// llamar a ESTE método para obtener la matriz
	public String[][] listarTareas() {
		debugBegin();

		// TODO Comprobar si hace falta InFrame
		int size = webDriver.getElements(todasLasTareasRow).size();
		String[][] matrix = new String[size][8];

		for(int i = 0; i < size; i++) {
			String[] linea = webDriver.getText(By.cssSelector(tareasRow.replace("[INDEX]", (i + 2) + ""))).trim().split("\n");

			int count = 0;

			for(int j = 0; j < linea.length; j++) {
				if(!linea[j].isEmpty()) {
					matrix[i][count++] = linea[j].trim();
				}
			}
		}

		debugEnd();

		return matrix;
	}

	private int getIndiceTarea(String titulo) {
		debugBegin();

		int indice = -1;
		String[][] matrix = listarTareas();

		for(int i = 0; i < matrix.length; i++) {
			if(titulo.equals(matrix[i][5])) {
				indice = i;
				break;
			}
		}

		debugEnd();

		return indice;
	}

	public AgendaSiniestrosPage detallesTarea(String titulo) {
		debugBegin();

		// TODO Comprobar si hace falta InFrame
		int indice = getIndiceTarea(titulo);

		webDriver.getElements(accionesListaTodasLasTareas).get(indice).click();
		webDriver.click(detalleBtn);

		debugEnd();

		return this;
	}

	public AgendaSiniestrosPage comprobarTareaCerrada() {
		debugBegin();

		webDriver.clickInFrame(infoTareasRealizadas, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(tramitacionSiniestrosLista, cuerpoFrame);
		
		detallesTarea(getTestVar(Constants.TAREA_TITULO));
		
		new TareaDetallesSiniestrosPage(userS)
			.consultarUsuariosDeCierre();
		
		debugEnd();
		
		return this;
	}

}// END