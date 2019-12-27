package com.amaris.project.pages.administracion.gestionpagos;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;

public class GestionPagosPage extends PageObject {

	// WEB ELEMENTS REGION
	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");

	// Gestion de pagos Operaciones
	private By autorizarPagosBtn = By.cssSelector("a#jt2");
	private By confirmarPagosBtn = By.cssSelector("a#jt3");
	private By emisionManualPagosBtn = By.cssSelector("a#jt4");
	private By consultarPagosBtn = By.cssSelector("a#jt6");

	private By menuGestionPagosBtn = By.cssSelector("[title = 'Haz clic para volver al menú de Gestión de pagos.']");
	// Autorización
	private By anyadirPagosBtn = By.cssSelector("#listadoRecibos > div.menuNav.menuNavPosAbsolute > div > ul > li > a > span");
	private By fechaDesdeInput = By.cssSelector("#fechadesde");
	private By fechaHastaInput = By.cssSelector("#fechahasta");
	private By nSiniestroInput = By.cssSelector("#numerosiniestro");
	private By nPolizaInput = By.cssSelector("#numeropoliza");
	private By buscarPagosBtn = By.cssSelector("#bloque1 > table > tbody > tr > td.sis-frame-bg > input");
	private By seleccionarPagoBtn = By.cssSelector("#check_tr1");
	private By anyadirPagosAListaBtn = By.cssSelector("#botonAniadir2");
	private By continuarConPagoBtn = By.cssSelector("#botonAgregar3");
	private By autorizarPagoBtn = By.cssSelector("#botonAutorizar");

	// Emitir de forma manual
	private By anyadirPagosEmitirBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li.js-action > a > span");
	private By emitirPagoBtn = By.cssSelector("[title = 'Emitir']");

	// Constructor
	public GestionPagosPage(UserStory userS) {
		super(userS);
	}

	// METHODS REGION
	// Opciones de gestión
	public GestionPagosPage autorizar() {
		debugBegin();
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(autorizarPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage confirmar() {
		debugBegin();
		webDriver.clickInFrame(confirmarPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage emisionManual() {
		debugBegin();
		webDriver.clickInFrame(emisionManualPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage consultarPago() {
		debugBegin();
		webDriver.clickInFrame(consultarPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage volverAlMenuGestionPagos() {
		debugBegin();
		webDriver.clickInFrame(menuGestionPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	// Operaciones : Autorizar

	public GestionPagosPage anyadirPagos() {
		debugBegin();
		webDriver.clickInFrame(anyadirPagosBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// 1.Seleccion de pagos

	public GestionPagosPage buscarPagosPorSiniestro() {
		debugBegin();

		// TODO : ver como pasar la fecha de una mejor forma
		webDriver.setTextInFrame(fechaDesdeInput, cuerpoFrame, "01/01/2018");
		webDriver.setTextInFrame(nSiniestroInput, cuerpoFrame, getTestVar(Constants.NUMERO_SINIESTRO));
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagosBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionPagosPage buscarPagosPorPoliza() {
		debugBegin();

		// TODO : ver como pasar la fecha de una mejor forma
		webDriver.setTextInFrame(fechaDesdeInput, cuerpoFrame, "01/01/2019");
		webDriver.setTextInFrame(nPolizaInput, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagosBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public GestionPagosPage anyadirPagosALista() {
		debugBegin();
		// TODO : ver como gestionar bien la lista de pagos
		webDriver.clickInFrame(seleccionarPagoBtn, cuerpoFrame);
		webDriver.clickInFrame(anyadirPagosAListaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage continuarConPagos() {
		debugBegin();
		webDriver.clickInFrame(continuarConPagoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// 2.Agrupaciones

	// TODO : revisar funcionalidad para las agrupaciones

	// 3. Autorizar pagos

	public GestionPagosPage autorizarPagos() {
		debugBegin();
		webDriver.clickInFrame(autorizarPagoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// Operaciones : Confirmar

	// 1.Seleccion de pagos

	public GestionPagosPage buscarPagosPorFecha(String desde, String hasta) {
		debugBegin();

		if(desde == null || desde.isEmpty()) {
			desde = DateUtils.getTodayDate(DateUtils.DATE_FORMAT);
		}

		webDriver.setTextInFrame(fechaDesdeInput, cuerpoFrame, desde);

		if(hasta == null || hasta.isEmpty()) {
			hasta = DateUtils.getTodayDate(DateUtils.DATE_FORMAT);
		}

		webDriver.setTextInFrame(fechaHastaInput, cuerpoFrame, hasta);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(buscarPagosBtn, cuerpoFrame);

		debugEnd();

		return this;

	}

	// 2.Confirmar pagos
	public GestionPagosPage confirmarPagos() {
		debugBegin();
		webDriver.clickInFrame(autorizarPagoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// Emisión manual de pagos
	public GestionPagosPage anyadirPagosAEmitir() {
		debugBegin();
		webDriver.clickInFrame(anyadirPagosEmitirBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public GestionPagosPage emitirPago() {
		debugBegin();
		webDriver.clickInFrame(emitirPagoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

}// END