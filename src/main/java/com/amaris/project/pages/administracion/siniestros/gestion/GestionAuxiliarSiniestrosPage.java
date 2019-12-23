package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionAuxiliarSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By gestionAux = By.cssSelector("#jt6");

	// Gestion auxiliar
	private By estadoFecha = By.cssSelector("#filtro1");
	private By direccion = By.cssSelector("#filtro2");
	private By cierreFecha = By.cssSelector("#filtro3");
	private By referen = By.cssSelector("filtro4");
	private By buscar = By.cssSelector("#botonBuscar");

	// Estado y fecha
	private By estado = By.cssSelector("#estado");
	private By fechaDesde = By.cssSelector("#fxestDesde");
	private By fechaHasta = By.cssSelector("#fxestHasta");

	// Dirrecion del riesgo
	private By provincia = By.cssSelector("select[id='provincia']");
	private By txtPoblacion = By.cssSelector("#poblacion");
	private By txtcodiPost = By.cssSelector("#postal");
	private By txtCalle = By.cssSelector("#calle");
	private By txtNumero = By.cssSelector("#numero");

	// Fecha cierre
	private By fechaDesdeCierre = By.cssSelector("#fCierreDesde");
	private By fechaHastaCierre = By.cssSelector("##fCierreHasta");
	private By tipoReferen = By.cssSelector("#tipoRefe");
	private By referencia = By.cssSelector("#referencia");

	private By continuar = By.cssSelector("tr.odd:nth-child(3) span");

	public GestionAuxiliarSiniestrosPage(UserStory userS) {
		super(userS);
	}
}