package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionPagoSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By pago = By.cssSelector("#jt7");

	private By refenPago = By.cssSelector("#filtro1");
	private By tipoPago = By.cssSelector("filtro2");
	private By noSiniestro = By.cssSelector("filtro3");
	private By nif = By.cssSelector("filtro4");
	private By percept = By.cssSelector("filtro5");
	private By concepto = By.cssSelector("filtro6");
	private By importe = By.cssSelector("filtro7");
	private By fecha = By.cssSelector("filtro8");
	private By otros = By.cssSelector("filtro9");
	private By combinada = By.cssSelector("filtro10");

	// referencia de pago
	private By txtReferen = By.cssSelector("#capaREFPAGO #refPago");

	// TIPOLOGIA DE PAGO
	private By tipo = By.cssSelector("#CTIPO");
	private By fechDesdeTipo = By.cssSelector("#fxestDesde");
	private By fechHastaTipo = By.cssSelector("#fxestHasta");

	// Numero siniestro
	private By product = By.cssSelector("#prodsini");
	private By anio = By.cssSelector("#seriesin");
	private By noSinies = By.cssSelector("#numesini");

	// NIF
	private By txtDocu = By.cssSelector("#numedocu");

	// perceptor
	private By txtNombre = By.cssSelector("#nombpcom");

	// Concepto pago
	private By txtConcep = By.cssSelector("#conptoPago");

	// Importe
	private By importeMin = By.cssSelector("#importeMin");
	private By importeMax = By.cssSelector("#importeMax");

	// Fecha
	private By desde = By.cssSelector("#desde");
	private By hasta = By.cssSelector("#hasta");

	// Otros
	private By estadoOtros = By.cssSelector("#estado_otros");
	private By desdeOtros = By.cssSelector("#desde_otros");
	private By hastaOtros = By.cssSelector("#hasta_otros");

	// Combinada
	private By producCombi = By.cssSelector("#producto");
	private By anioCombi = By.cssSelector("#serieSin");
	private By noSiniesCombi = By.cssSelector("#numeSini");
	private By refCombi = By.cssSelector("#criterioNombre #refPago");
	private By docuCombi = By.cssSelector("#numeDoc");
	private By nombCombi = By.cssSelector("#nombCom");
	private By impMinCombi = By.cssSelector("#impoMin");
	private By impMaxCombi = By.cssSelector("#impoMax");
	private By fechaDsdCombi = By.cssSelector("#fechAltaDesde");
	private By fechaHastaCombi = By.cssSelector("#fechAltaHasta");
	private By concepCombi = By.cssSelector("#conceptoPago");
	private By estadoRecibo = By.cssSelector("#estadoPago");

	public GestionPagoSiniestrosPage(UserStory userS) {
		super(userS);
	}

}