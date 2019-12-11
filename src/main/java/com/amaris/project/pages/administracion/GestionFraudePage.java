package com.amaris.project.pages.administracion;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;

public class GestionFraudePage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By nuevoFraude = By.cssSelector("li.js-action a");
	private By tipoFraude = By.cssSelector("#FRAU_TIPOLOGIA");
	private By fechaFraude = By.cssSelector("#FRAU_FECHALTA");
	private By activoFraude = By.cssSelector("#FRAU_ACTIVACION");
	private By detecFraude = By.cssSelector("#FRAU_DETECTOR");
	private By intencionFraude = By.cssSelector("#FRAU_SWINTENCION");
	private By continuar = By.cssSelector("#botonContinuar");

	// Fraude
	private By checkLista = By.cssSelector("#iddefraudador_1"); // el numero indica la fila de la tabla
	private By acciones = By.cssSelector("#capaPuntos1 a");
	private By nuevoDefra = By.cssSelector("li.js-action a");
	private By consultar = By.cssSelector("div.cpdatos li:nth-child(1) > a");
	private By modificar = By.cssSelector("div.cpdatos li:nth-child(2) > a");
	private By eliminar = By.cssSelector("div.cpdatos li:nth-child(3) > a");
	private By guardar = By.cssSelector("div #botonGuardar");

	// gestion
	private By estado = By.cssSelector("#FRAU_ESTADO");
	private By fechaUltima = By.cssSelector("#FRAU_FECHULTIMA");
	private By reclamado = By.cssSelector("div #FRAU_RECLAMADO");
	private By importNeto = By.cssSelector("#FRAU_NETO");
	private By observa = By.cssSelector("#FRAU_OBSERVACIONES");
	private By bloqueo = By.cssSelector("#FRAU_SWBLOQUEO");

	// resolucion
	private By tipoResolu = By.cssSelector("#FRAU_TIPORESO");
	private By fraudeTipo = By.cssSelector("#FRAU_TIPOFRAU");
	private By fechaResolu = By.cssSelector("#FRAU_FECHRESO");

	// verificacion
	private By grabar = By.cssSelector("#botonGrabar");

}