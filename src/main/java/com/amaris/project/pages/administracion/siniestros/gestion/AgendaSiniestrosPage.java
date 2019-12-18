package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.ClickInSession;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

public class AgendaSiniestrosPage extends PageObject {

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

	private By agenda = By.cssSelector("#jt4");

	private By nuevaTarea = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
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
	private By titulo = By.cssSelector("#titulo");
	private By descripcion = By.cssSelector("#anotacion");
	private By categoria = By.cssSelector("#categoria");
	private By categoriaTSLA = By.cssSelector("#categoria > option:nth-child(2)"); // son dos opciones dentro de la
																					// categoría
	private By categoriaTSIN = By.cssSelector("#categoria > option:nth-child(3)");// TODO: comprobar si vale la más la
																					// pena seleccionarla por VALUE
																					// desde categoria
	private By pioridad = By.cssSelector("#priority");
	private By fechaFin = By.cssSelector("#fechaler");
	private By email = By.cssSelector("#email");
	private By grabar = By.cssSelector("body > form > table input[name='botonGrabar']");
	private By cerrar = By.cssSelector("input[name='botonCerrar']");

	// cabecera
	private By plantillas = By.cssSelector("#cabPlantillas");
	private By codPlantilla = By.cssSelector("#queryPlantilla");
	private By buscarPlantilla = By.cssSelector("#botonPlantilla");
	private By selecPlantilla = By.cssSelector("#plantilla");

	// cambiar operador
	private By cambiOperador = By.cssSelector("#cabCambiarOperador");
	private By btnCambiarOP = By.cssSelector("#bloqueCambiarOperador td > a");

	// Documentos
	private By documentos = By.cssSelector("#cabDocumentos");
	private By seleccionar = By.cssSelector("#fichero");
	private By anexar = By.cssSelector("#botonAnexar");

	// etiquetas
	private By etiquetas = By.cssSelector("#cabEtiquetas");
	private By txtEtiquetas = By.cssSelector("#textoEtiquetas");
	private By asociarEti = By.cssSelector("#botonAsociar");

	// pestañas
	private By todasTareas = By.cssSelector("#pes0");

	private By tramitacionSiniestrosLista = By.cssSelector("#tablaResultados > table > tbody > tr.even > td:nth-child(1) > a");
	// lista de estado de las tareas

	private By listaTodasLasTareas = By.cssSelector("#capaAjax > form > table > tbody > tr:not(:first-child)");

	private By estadoTarea = By.cssSelector("table.grid tbody:nth-child(1) tr[valign='top'] td:nth-child(5)");
	private String filaTablaTareas = "#capaAjax > form > table > tbody > tr:nth-child([INDEX]):not(:first-child)";

	private By accionesListaTodasLasTareas = By.cssSelector("[id*=capaFlecha] > a");

	private By detalleBtn = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By altaRelacionadaBtn = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	
	
	// METHODS REGION
	public AgendaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public AgendaSiniestrosPage nueva_tarea() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(agenda, leftFrame);

		ActionSteps.waitForIt(webDriver);
		debugInfo("agenda");
		webDriver.clickInFrame(nuevaTarea, cuerpoFrame);
		ActionSteps.waitForIt(webDriver);
		debugInfo("estoy en nueva tarea");

		String titulillo = "Nueva tareas automatica" + StringUtils.getRandomLetterChain(5);
		if(getTestVar(Constants.TAREA_TITULO) != null || getTestVar(Constants.TAREA_TITULO).isEmpty()) {
			titulillo = getTestVar(Constants.TAREA_TITULO);
		} else {
			setTestVar(Constants.TAREA_TITULO, titulillo);
		}

		webDriver.setTextInFrame(titulo, cuerpoFrame, titulillo);

		webDriver.setTextInFrame(descripcion, cuerpoFrame, "Estamos probando una prueba automatizada");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementChildByAttribute(categoria, "value", "TSLA");
		webDriver.clickElementChildByAttribute(pioridad, "value", "1");
		webDriver.setText(fechaFin, "30/10/2019");
		webDriver.click(grabar);
		ActionSteps.waitForIt(webDriver);
		webDriver.waitWithDriver(5000);

		debugEnd();
		return this;
	}

	public boolean comprobar_tareas_pendientes() {
		debugBegin();
		webDriver.clickInFrame(agenda, leftFrame);
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(todasTareas, cuerpoFrame);
		debugInfo("click en todas");
		Boolean check = false;
		if(webDriver.isClickableInFrame(estadoTarea, cuerpoFrame)) {
			debugInfo("antes de la lista");
			webDriver.switchToFrame(cuerpoFrame);
			List<WebElement> listaPagos = webDriver.getElements(estadoTarea);
			debugInfo("contiene: " + listaPagos.size());
			debugInfo("despues de la lista");

			for(int i = 0; i < listaPagos.size(); i++) {
				debugInfo("hay tareas");

				debugInfo("Estado: " + listaPagos.get(i).getText());
				if(listaPagos.get(i).getText().compareTo("Pendiente") == 0) {
					check = true;
					debugInfo("Tareas Pendiente: " + check);
				}
			}
			webDriver.exitFrame();

		} else {
			debugInfo("no hay tareas");
		}

		debugEnd();
		return check;

	}

	public String[][] listarTareas() { // IMPORTANTE : si hay que interactuar con la información de la tabla de tareas,
										// llamar a ESTE método primero para generar matriz
		debugBegin();

		int size = webDriver.getElements(listaTodasLasTareas).size();
		String[][] matrix = new String[size][8];

		for(int i = 0; i < size; i++) {
			String[] linea = webDriver.getText(By.cssSelector(filaTablaTareas.replace("[INDEX]", (i + 2) + ""))).trim().split("\n");

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
		new TareaDetallesSiniestrosPage(userS).consultarUsuariosDeCierre();
		debugEnd();
		return this;
	}

}// END