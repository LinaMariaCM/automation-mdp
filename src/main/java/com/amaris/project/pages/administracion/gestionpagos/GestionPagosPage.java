package com.amaris.project.pages.administracion.gestionpagos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class GestionPagosPage extends PageObject {

	// WEB ELEMENTS REGION

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	// Gestion de pagos
	// Operaciones

	private By autorizarPagos = By.cssSelector("a#jt2");
	private By confirmarPagos = By.cssSelector("a#jt3");
	private By emisionManualPagos = By.cssSelector("a#jt4");
	// Pagos
	private By consultarPagos = By.cssSelector("a#jt6");

	private By menuGestionPagos = By.cssSelector("[title = 'Haz clic para volver al menú de Gestión de pagos.']");
	// Autorización
	private By anyadirPagos = By.cssSelector("#listadoRecibos > div.menuNav.menuNavPosAbsolute > div > ul > li > a > span");
	private By fechaDesde = By.cssSelector("#fechadesde");
	private By fechaHasta = By.cssSelector("#fechahasta");
	private By mediosPago = By.cssSelector("#mediopago");
	private By NIFPerceptor = By.cssSelector("#perceptor");
	private By tramitador = By.cssSelector("#tramitador");
	private By nSiniestro = By.cssSelector("#numerosiniestro");
	private By producto = By.cssSelector("#producto");
	private By nPoliza = By.cssSelector("#numeropoliza");
	private By buscarPagos = By.cssSelector("#bloque1 > table > tbody > tr > td.sis-frame-bg > input");
	private By checkSeleccionarPago = By.cssSelector("#check_tr1");
	private By anyadirPagosALista = By.cssSelector("#botonAniadir2");
	private By continuarConPago = By.cssSelector("#botonAgregar3");
	private By autorizarPago = By.cssSelector("#botonAutorizar");

	// Confirmación
	private By anyadirPagosConfirmar = By.cssSelector("#listadoRecibos > div.menuNav.menuNavPosAbsolute > div > ul > li > a > span");

	// Emitir de forma manual

	private By anyadirPagosEmitir = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li.js-action > a > span");
	private By emitirPago = By.cssSelector("[title = 'Emitir']");

	DateFormat fDesde = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat fHasta = new SimpleDateFormat("dd/MM/yyyy");
	// webDriver.appendText(txtFechaOcurrencia, fOcurrencia.format(new Date()));

	// METHODS REGION

	// Constructor
	public GestionPagosPage(UserStory userS) {
		super(userS);
	}

	// Opciones de gestión
	public GestionPagosPage autorizar() {
		debugBegin();
		webDriver.clickInFrame(autorizarPagos, leftFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage confirmar() {
		debugBegin();
		webDriver.clickInFrame(confirmarPagos, leftFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage emisionManual() {
		debugBegin();
		webDriver.clickInFrame(emisionManualPagos, leftFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage consultarPago() {
		debugBegin();
		webDriver.clickInFrame(consultarPagos, leftFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage volverAlMenuGestionPagos() {
		debugBegin();
		webDriver.clickInFrame(menuGestionPagos, leftFrame);
		debugEnd();
		return this;
	}

	// Operaciones : Autorizar

	public GestionPagosPage anyadirPagos() {
		debugBegin();
		webDriver.clickInFrame(anyadirPagos, cuerpoFrame);
		debugEnd();
		return this;
	}

	// 1.Seleccion de pagos

	public GestionPagosPage buscarPagosPorSiniestro() {
		debugBegin();
		webDriver.setTextInFrame(fechaDesde, cuerpoFrame, "01/01/2018"); // TODO : ver como pasar la fecha de una mejor
																			// forma
		webDriver.setTextInFrame(nSiniestro, cuerpoFrame, getTestVar(Constants.NUMERO_SINIESTRO));
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagos, cuerpoFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage buscarPagosPorPoliza() {
		debugBegin();
		webDriver.setTextInFrame(fechaDesde, cuerpoFrame, "01/01/2019"); // TODO : ver como pasar la fecha de una mejor
																			// forma
		webDriver.setTextInFrame(nPoliza, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagos, cuerpoFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage anyadirPagosALista() { // TODO : ver como gestionar bien la lista de pagos
		debugBegin();
		webDriver.clickInFrame(checkSeleccionarPago, cuerpoFrame);
		webDriver.clickInFrame(anyadirPagosALista, cuerpoFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage continuarConPagos() {
		debugBegin();
		webDriver.clickInFrame(continuarConPago, cuerpoFrame);
		debugEnd();
		return this;
	}

	// 2.Agrupaciones

	// TODO : revisar funcionalidad para las agrupaciones

	// 3. Autorizar pagos

	public GestionPagosPage autorizarPagos() {
		debugBegin();
		webDriver.clickInFrame(autorizarPago, cuerpoFrame);
		debugEnd();
		return this;
	}

	// Operaciones : Confirmar

	// 1.Seleccion de pagos

	public GestionPagosPage buscarPagosPorFecha(String desde, String hasta) {

		debugBegin();
		if(desde == null || desde.isEmpty()) {
			desde = fDesde.format(new Date());
		}

		webDriver.setTextInFrame(fechaDesde, cuerpoFrame, desde);

		if(hasta == null || hasta.isEmpty()) {
			hasta = fHasta.format(new Date());
		}

		webDriver.setTextInFrame(fechaHasta, cuerpoFrame, hasta);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagos, cuerpoFrame);
		debugEnd();
		return this;

	}
	// 2.Confirmar pagos

	public GestionPagosPage confirmarPagos() {
		debugBegin();
		webDriver.clickInFrame(autorizarPago, cuerpoFrame);
		debugEnd();
		return this;
	}

	// Emisión manual de pagos

	public GestionPagosPage anyadirPagosAEmitir() {
		debugBegin();
		webDriver.clickInFrame(anyadirPagosEmitir, cuerpoFrame);
		debugEnd();
		return this;
	}

	public GestionPagosPage emitirPago() {
		debugBegin();
		webDriver.clickInFrame(emitirPago, cuerpoFrame);
		debugEnd();
		return this;
	}

}// END
