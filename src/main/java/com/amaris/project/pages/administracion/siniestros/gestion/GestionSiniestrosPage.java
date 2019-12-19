package com.amaris.project.pages.administracion.siniestros.gestion;

import com.amaris.project.steps.ActionSteps;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class GestionSiniestrosPage extends PageObject {

	private static String RESERVA_TOTAL = "reserva_total";
	private static String EXPECTATIVA_TOTAL = "expectativa_total";

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	//private By capaIframe = By.cssSelector("div#dialog-modal > iframe#capaIframe");
	private By capaIframe = By.cssSelector("#capaIframe");
	private By topFrame = By.cssSelector("#topFrame");
	
	private By logo = By.cssSelector("#logo");
	
	private By exportaResultado = By.cssSelector("#cabExportar");

	// Información estática de Gestión de Siniestros

	// private By nPoliza = By.cssSelector("form[name='formDatos'] table table td:first-of-type");

	private By nPolizaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By responsableInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)");

	private By aseguradoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By fOcurrenciaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");

	private By riesgoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By fAperturaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)");

	private By tipoCausaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(1)");
	private By estadoSiniestroInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)");

	private By mediadorInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(1)");
	private By fechaCierreSiniestro = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(2)");

	private By tareasPendientesInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(6) > td:nth-of-type(1)");

	private By costeActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By importePagosInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By reservaActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");

	private By causaSin = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(1)");

	private By carpeta = By.cssSelector("#bloque1tr1");
	//private By listaCarpeta = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque1tr1']");
	private By listaCarpeta = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque1tr1'] > td:nth-child(9) > div.sis-box-actions");

	private By transicionar = By.cssSelector("div.cpdatos a");

	// posiocion global

	// private By diario = By.xpath(".//*[text()='Diario de siniestro '] ");
	private By diario = By.cssSelector("#jt1son a[title*='Diario de siniestro  ']");
	private By vista = By.xpath(".//*[text()='Vista siniestro'] ");
	private By agenda = By.id("jt4");
	private By documentacion = By.id("jt5");
	private By comunicacion = By.id("jt6");
	private By bloque = By.id("jt7");
	private By procesos = By.id("jt8");

	// Datos económicos

	// OJO! revisar conforme se intreractue con los distintos elementos si es necesario pasar de by.id() a by.xpath()
	private By reservasYExpectativas = By.id("jt10");

	private By pagos = By.cssSelector("[title = 'Pagos  ']");

	private By recobros = By.id("jt12");

	// Otras gestiones
	private By gestionDelFraude = By.id("jt14");
	// Carpetas

	private By gestionDeCarpetas = By.xpath(".//*[text()='Gestión de carpetas'] ");
	// private By gestionDeCarpetas = By.id("jt15son");

	// Reservas del siniestro

	private By infoCarpeta = By.xpath("//*[@id='bloque1tr1']/td[2]/text()");
	private By infoBloque = By.cssSelector("#bloque1tr1 > td:nth-child(3)");
	private By infoReservaActual = By.cssSelector("#bloque1tr1 > td:nth-child(4)");
	private By infoPagos = By.cssSelector("#bloque1tr1 > td:nth-child(5)");
	private By infoExpectativaActual = By.cssSelector("#bloque1tr2 > td:nth-child(6)");
	private By infoRecobros = By.cssSelector("#bloque1tr1 > td:nth-child(7)");
	private By infoCoste = By.cssSelector("#bloque1tr1 > td:nth-child(8)");

	//private By acciones = By.cssSelector("[id*='capaFlecha'] a");
	private By acciones = By.cssSelector("#bloque1tr1 > td:nth-child(9) > div");

	private By consultarExpectaticvas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By consultarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	//	private By modificarExepectativas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(4) > a");
	// a[onclick*='expectativa']
	private By modificarExepectativas = By.linkText("Modificar expectativa");
	//	private By modificarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");
	private By modificarReservas = By.cssSelector("a[onclick*='TITULO=Modificación de reserva actual']");
	//	private By modificarReservas = By.linkText("Modificar reservas");

	// modificacion expectativa actual

	//private By expReservaIndemnizable = By.cssSelector("body.sis-body sis-modalcontainer > #formDatos > div.contentBox.wideBox > div.sis-frame-bg > table:nth-child(2) > tbody > tr.odd > td:nth-child(2) > input#espectativa_CR001");
	private By expReservaIndemnizable = By.cssSelector("#espectativa_CR001");
	//private By expReservaIndemnizable = By.cssSelector("#formDatos > div.contentBox.wideBox > div.sis-frame-bg > table:nth-child(2) > tbody > tr.odd > td:nth-child(2) > input");
	private By expReservaReparable = By.cssSelector("#espectativa_CR002");
	private By expReservaGastos = By.cssSelector("#espectativa_CR003");

	private By btnGrabarExpectativa = By.cssSelector("#botonGrabar");
	private By btnGrabarReservas = By.cssSelector("#buttonRecord");
	private By btnCancelarExpectativa = By.cssSelector("#botonCancelar");

	// modificacion reserva actuial

	private By reservaIndemnizable = By.cssSelector("input#CR001");
	private By reservaReparable = By.cssSelector("input#CR002");
	private By reservaGastos = By.cssSelector("input#CR003");

	//// Buscador de siniestros

	// Numero Siniestro
	private By numeroSiniestro = By.cssSelector("#filtro1");
	private By añoSiniestro = By.cssSelector("#seriesin");
	private By numSiniestro = By.cssSelector("#numesini");

	// Numero Poliza
	private By numeroPoliza = By.cssSelector("#filtro2");
	private By tipoProducto = By.cssSelector("#producto");
	private By numPoliza = By.cssSelector("#polizsec");

	// Numero recibo
	private By numeroRecibo = By.cssSelector("#filtro3");
	private By numRecibo1 = By.cssSelector("input[name='recibann']");
	private By numRecibo2 = By.cssSelector("#recibsec");

	// Asegurado
	private By asegurado = By.cssSelector("#filtro4");
	private By documento = By.cssSelector("#numedocu");
	private By empiezaPor = By.cssSelector("#empiezapor");
	private By contiene = By.cssSelector("#contiene");
	private By nombreApellidos = By.cssSelector("input[name='nombpcom']");

	// Fecha ocurrencia
	private By fechaOcurrencia = By.cssSelector("#filtro6");
	private By fDesde = By.cssSelector("#desde");
	private By fHasta = By.cssSelector("#hasta");

	// Fecha alta
	private By fechaAlta = By.cssSelector("#filtro7");
	private By fAltaDesde = By.cssSelector("#altadesde");
	private By fAltaHasta = By.cssSelector("#altahasta");

	// Tipo causa
	private By tipoCausa = By.cssSelector("#filtro8");
	private By fCausaDesde = By.cssSelector("#fechDesde");
	private By fCausaHasta = By.cssSelector("#fechHasta");
	private By codigo = By.cssSelector("#name4");

	// Otros
	private By otros = By.cssSelector("#filtro9");
	private By fOtrosDesde = By.className("#fdesde");
	private By fOtrosHasta = By.cssSelector("#fhasta");
	private By estadoPoliza = By.cssSelector("#estado");
	private By lineaNegocio = By.cssSelector("#productoSini");
	private By mediador = By.cssSelector("#codMediador");

	private By botonBuscar = By.cssSelector("#botonBuscar");

	private By flechaContinuar = By.cssSelector("tr:nth-child(3) td:nth-child(11) span");

	private By verSaldo = By.cssSelector("ul.list-level-1.js-actionsdinamicbar:nth-child(1) span");

	public GestionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public GestionSiniestrosPage logo() {
		debugBegin();
		webDriver.clickInFrame(logo, topFrame);
		debugEnd();
		return this;
	}
	
	// Acciones menu izquierda

	public GestionSiniestrosPage diario() {
		debugBegin();
		webDriver.clickInFrame(diario, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage vista() {
		debugBegin();
		webDriver.clickInFrame(vista, leftFrame);

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage agenda() {
		debugBegin();
		webDriver.clickInFrame(agenda, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage documentacion() {
		debugBegin();
		webDriver.clickInFrame(documentacion, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage comunicacion() {
		debugBegin();
		webDriver.clickInFrame(comunicacion, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage bloque() {
		debugBegin();
		webDriver.clickInFrame(bloque, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage procesos() {
		debugBegin();
		webDriver.clickInFrame(procesos, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage reservasYExpecativas() {
		debugBegin();
		webDriver.clickInFrame(reservasYExpectativas, leftFrame);

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage pagos() {
		debugBegin();
		webDriver.clickInFrame(pagos, leftFrame);
		webDriver.waitWithDriver(6000);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage recobros() {
		debugBegin();
		webDriver.clickInFrame(recobros, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage gestionDelFraude() {
		debugBegin();
		webDriver.clickInFrame(gestionDelFraude, leftFrame);
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage gestionDeCarpetas() {
		debugBegin();
		webDriver.waitWithDriver(3000);
		// webDriver.scrollToElementInFrame(gestionDeCarpetas, leftFrame);
		// webDriver.waitWithDriver(3000);
		// webDriver.scrollToElement(gestionDeCarpetas);
		// webDriver.waitWithDriver(30000);

		webDriver.exitFrame();
		// System.out.println(webDriver.getText(leftFrame));
		System.out.println(webDriver.getTextInFrame(gestionDeCarpetas, leftFrame));
		webDriver.clickInFrame(gestionDeCarpetas, leftFrame);
		// webDriver.click(gestionDeCarpetas);
		debugEnd();
		return this;
	}
	// end region

	// Reservas y expectativas

	public GestionSiniestrosPage modificarExpectativa() {

		debugBegin();
		double expIndemnizable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double expReparable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double expGastos = (double) Math.round((Math.random() * 10) * 100d) / 100d;

		setTestVar(EXPECTATIVA_TOTAL, Double.toString(expIndemnizable + expReparable + expGastos));

		webDriver.waitForElementToBeClickableInFrame(listaCarpeta, cuerpoFrame);
		debugInfo("el botón para desplegar el menú acciones de carpeta");
		webDriver.clickInFrame(listaCarpeta, cuerpoFrame);
		debugInfo("desplegar menú acciones de carpeta");
		webDriver.waitForElementToBeClickableInFrame(modificarExepectativas, cuerpoFrame);
		debugInfo("esperar que abra el menú de acciones");
		webDriver.clickInFrame(modificarExepectativas, cuerpoFrame);
		debugInfo("click en modificar expectativas");
		webDriver.switchToFrame(cuerpoFrame);

		debugInfo("cambiar y esperar al iframe");
		ActionSteps.waitForIt(webDriver); // nuevo
		webDriver.setTextInFrame(expReservaIndemnizable, capaIframe, Double.toString(expIndemnizable));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("se modifica la expectativa indemnizable");
		//ActionSteps.waitForIt(webDriver); // nuevo
		webDriver.setTextInFrame(expReservaReparable, capaIframe, Double.toString(expReparable));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("se modifica la expectativa gastos");
		//	ActionSteps.waitForIt(webDriver); // nuevo
		webDriver.setTextInFrame(expReservaGastos, capaIframe, Double.toString(expGastos));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("todos los campos del modal son modificados");
		webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
		debugInfo("se grabam las expectativas añadidas");
		webDriver.exitFrame();

		debugEnd();
		return this;

	}

	public GestionSiniestrosPage modificarExpectativasACero() {

		debugBegin();

		setTestVar(EXPECTATIVA_TOTAL, "0");

		webDriver.waitForElementToBeClickableInFrame(listaCarpeta, cuerpoFrame);
		webDriver.clickInFrame(listaCarpeta, cuerpoFrame);
		webDriver.waitForElementToBeClickableInFrame(modificarExepectativas, cuerpoFrame);
		webDriver.clickInFrame(modificarExepectativas, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);

		webDriver.setTextInFrame(expReservaIndemnizable, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(expReservaReparable, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(expReservaGastos, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabarExpectativa, capaIframe);
		webDriver.exitFrame();

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage modificarReserva() {

		debugBegin();

		double resIndemnizable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double resReparable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double resGastos = (double) Math.round((Math.random() * 10) * 100d) / 100d;

		setTestVar(RESERVA_TOTAL, Double.toString(resIndemnizable + resReparable + resGastos));

		//webDriver.waitForElementToBeClickableInFrame(listaCarpeta, cuerpoFrame);
		debugInfo("el botón para desplegar el menú acciones de carpeta");
		webDriver.clickInFrame(listaCarpeta, cuerpoFrame);
		debugInfo("desplegar menú acciones de carpeta");
		//webDriver.waitForElementToBeClickableInFrame(modificarReservas, cuerpoFrame);
		debugInfo("esperar que abra el menú de acciones");
		webDriver.clickInFrame(modificarReservas, cuerpoFrame);
		debugInfo("click en modificar expectativas");
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("cambiar y esperar al iframe");

		ActionSteps.waitForIt(webDriver);
		webDriver.setTextInFrame(reservaIndemnizable, capaIframe, Double.toString(resIndemnizable));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("se modifica la expectativa indemnizable");
		webDriver.setTextInFrame(reservaReparable, capaIframe, Double.toString(resReparable));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("se modifica la expectativa gastos");
		webDriver.setTextInFrame(reservaGastos, capaIframe, Double.toString(resGastos));
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("todos los campos del modal son modificados");
		webDriver.clickInFrame(btnGrabarReservas, capaIframe);
		debugInfo("se grabam las expectativas añadidas");
		webDriver.exitFrame();
		webDriver.waitWithDriver(3000);

		debugEnd();

		return this;

	}

	public GestionSiniestrosPage modificarReservaACero() {

		debugBegin();

		setTestVar(RESERVA_TOTAL, "0");

		webDriver.waitForElementToBeClickableInFrame(listaCarpeta, cuerpoFrame);
		webDriver.clickInFrame(listaCarpeta, cuerpoFrame);
		webDriver.waitForElementToBeClickableInFrame(modificarReservas, cuerpoFrame);
		webDriver.clickInFrame(modificarReservas, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(reservaIndemnizable, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(reservaReparable, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(reservaGastos, capaIframe, "0");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(btnGrabarReservas, capaIframe);
		webDriver.exitFrame();
		webDriver.waitWithDriver(3000);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage verificarTotales() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String reservaActual = webDriver.getText(infoReservaActual).trim();

		webDriver.takeScreenshot("comprobacion reservas", userS.getReportPath());

		boolean checkReservas = reservaActual.equals(getTestVar(RESERVA_TOTAL + "€"));
		Assert.assertTrue(checkReservas, "COMPARAR CAMPOS : Verificar Totales info: las reservas coinciden.");

		String expectativaActual = webDriver.getText(infoExpectativaActual).trim();

		webDriver.takeScreenshot("comprobacion expectativas", userS.getReportPath());

		boolean checkExpectativas = expectativaActual.equals(getTestVar(EXPECTATIVA_TOTAL + "€"));
		Assert.assertTrue(checkExpectativas, "COMPARAR CAMPOS : Verificar Totales info: las expectativas coinciden.");

		webDriver.exitFrame();

		debugEnd();

		return this;

	}

	public GestionSiniestrosPage mostrarInfoGeneral() {
		debugBegin();
		debugInfo("Información General desde Gestión de Siniestro");
		System.out.println("=========================================");
		webDriver.switchToFrame(cuerpoFrame);
		System.out.println("- " + webDriver.getText(nPolizaInfo));
		System.out.println("- " + webDriver.getText(responsableInfo));
		System.out.println("- " + webDriver.getText(aseguradoInfo));
		System.out.println("- " + webDriver.getText(fOcurrenciaInfo));
		System.out.println("- " + webDriver.getText(riesgoInfo));
		System.out.println("- " + webDriver.getText(fAperturaInfo));
		System.out.println("- " + webDriver.getText(tipoCausaInfo));
		System.out.println("- " + webDriver.getText(estadoSiniestroInfo));
		if(webDriver.getText(estadoSiniestroInfo).contains("Cerrado")) System.out.println("- " + webDriver.getText(fechaCierreSiniestro));
		System.out.println("- " + webDriver.getText(mediadorInfo));
		System.out.println("- " + webDriver.getText(tareasPendientesInfo));
		System.out.println("- " + webDriver.getText(costeActualInfo));
		System.out.println("- " + webDriver.getText(importePagosInfo));
		System.out.println("- " + webDriver.getText(reservaActualInfo));
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public GestionSiniestrosPage compararInfoGeneralCSV() {

		boolean check = false;

		System.out.println("Cotejando datos con de siniestro con csv...");

		System.out.println("Póliza CSV: " + getTestVar(Constants.NUM_POLIZA));

		System.out.println("Póliza de siniestro: " + webDriver.getText(nPolizaInfo));

		if(getTestVar(Constants.NUM_POLIZA).compareTo(webDriver.getText(nPolizaInfo).substring(20)) == 0) {
			System.out.println("Los números de las pólizas coinciden");
		} else System.out.println("Los números de las pólizas NO coinciden");

		System.out.println("Tipo de causa CSV: " + getTestVar(Constants.TIPO_CAUSA));

		System.out.println("Tipo de causa del siniestro: " + webDriver.getText(tipoCausa));

		if(getTestVar(Constants.TIPO_CAUSA).compareTo(webDriver.getText(tipoCausaInfo)) == 0) {
			System.out.println("Los números de las pólizas coinciden");
		} else System.out.println("Los números de las pólizas NO coinciden");

		return this;
	}

	public GestionSiniestrosPage comprobarCausa(String causa) {
		debugBegin();

		webDriver.waitForPageToLoad();
		webDriver.switchToFrame(cuerpoFrame);

		System.out.println("Tipo de causa: " + webDriver.getText(causaSin));
		Assert.assertTrue(webDriver.getText(causaSin).contains(causa), "Modificación de causa siniestro completada con exito");

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage comprobarSiniestroCerrado() { // TODO hacer que las comprobocaiones se reflejen en el
		// report
		debugBegin();
		debugInfo("Comprobamos si el estado del siniestro es: 'Cerrado'");

		webDriver.switchToFrame(cuerpoFrame);
		System.out.println("- " + webDriver.getText(estadoSiniestroInfo));
		if(webDriver.getText(estadoSiniestroInfo).contains("Cerrado")) {
			System.out.println("OK : el siniestro está cerrado");
			System.out.println("- " + webDriver.getText(fechaCierreSiniestro)); // tiene que ser
			System.out.println("- " + webDriver.getText(reservaActualInfo));
		} // tiene que ser 0

		else System.out.println("KO : el siniestro sigue abierto"); // TODO añadir trigger para que el resultado de la
		// prueba aparezca fallo en el reporte

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage comprobarSiniestroReaperturadoOk() {
		debugBegin();
		debugInfo("Comprobamos si el siniestro ha reaperturado correctamente");

		if(webDriver.getTextInFrame(estadoSiniestroInfo, cuerpoFrame).contains("Abierto")) {
			System.out.println("Estado de siniestro correcto");
			Assert.assertTrue(webDriver.getTextInFrame(estadoSiniestroInfo, cuerpoFrame).contains("Abierto"));
		} else {
			System.out.println("Estado de siniestro INCORRECTO");
		}

		Assert.assertFalse(webDriver.getTextInFrame(estadoSiniestroInfo, cuerpoFrame).contains("Abierto"));

		if(webDriver.getTextInFrame(costeActualInfo, cuerpoFrame).equalsIgnoreCase("0,00") &&
			webDriver.getTextInFrame(importePagosInfo, cuerpoFrame).equalsIgnoreCase("0,00")
			&& webDriver.getTextInFrame(reservaActualInfo, cuerpoFrame).equalsIgnoreCase("0,00"))

			Assert.assertFalse(webDriver.getTextInFrame(costeActualInfo, cuerpoFrame).equalsIgnoreCase("0,00") &&
				webDriver.getTextInFrame(importePagosInfo, cuerpoFrame).equalsIgnoreCase("0,00")
				&& webDriver.getTextInFrame(reservaActualInfo, cuerpoFrame).equalsIgnoreCase("0,00"));

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage comprobarReservasReaperturadasOk() {
		debugBegin();
		debugInfo("Comprobamos si el siniestro ha reaperturado correctamente");

		if(webDriver.getTextInFrame(costeActualInfo, cuerpoFrame).equalsIgnoreCase("0,00") &&
			webDriver.getTextInFrame(importePagosInfo, cuerpoFrame).equalsIgnoreCase("0,00")
			&& webDriver.getTextInFrame(reservaActualInfo, cuerpoFrame).equalsIgnoreCase("0,00"))

			Assert.assertFalse(webDriver.getTextInFrame(costeActualInfo, cuerpoFrame).equalsIgnoreCase("0,00") &&
				webDriver.getTextInFrame(importePagosInfo, cuerpoFrame).equalsIgnoreCase("0,00")
				&& webDriver.getTextInFrame(reservaActualInfo, cuerpoFrame).equalsIgnoreCase("0,00"));

		debugEnd();
		return this;
	}

	public GestionSiniestrosPage comprobarCarpetaReaperturadaOk() {
		debugBegin();
		debugInfo("Comprobamos si la carpeta ha reaperturado correctamente");

		webDriver.clickInFrame(gestionDeCarpetas, leftFrame);

		debugEnd();
		return this;
	}

} // END