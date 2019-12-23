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
	// private By capaIframe = By.cssSelector("div#dialog-modal > iframe#capaIframe");
	private By capaIframe = By.cssSelector("#capaIframe");
	private By topFrame = By.cssSelector("#topFrame");

	private By logoBtn = By.cssSelector("#logo");

	private By exportaResultado = By.cssSelector("#cabExportar");

	// Información estática de Gestión de Siniestros

	// private By nPoliza = By.cssSelector("form[name='formDatos'] table table td:first-of-type");

	private By nPolizaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By responsableInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)");

	private By aseguradoInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By fOcurrenciaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");

	private By riesgoInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By fAperturaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)");

	private By tipoCausaInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(1)");
	private By estadoSiniestroInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)");

	private By mediadorInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(1)");
	private By fechaCierreSiniestroTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(2)");

	private By tareasPendientesInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(6) > td:nth-of-type(1)");

	private By costeActualInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By importePagosInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By reservaActualInfoTxt = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");

	private By causaSinTxt = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(1)");

	private By carpeta = By.cssSelector("#bloque1tr1");
	// private By listaCarpeta = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque1tr1']");
	private By listaCarpetaBtn = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque1tr1'] > td:nth-child(9) > div.sis-box-actions");

	private By transicionar = By.cssSelector("div.cpdatos a");

	// posiocion global

	// private By diario = By.xpath(".//*[text()='Diario de siniestro '] ");
	private By diarioBtn = By.cssSelector("#jt1son a[title*='Diario de siniestro  ']");
	private By vistaBtn = By.xpath(".//*[text()='Vista siniestro'] ");
	private By agendaBtn = By.id("jt4");
	private By documentacionBtn = By.id("jt5");
	private By comunicacionBtn = By.id("jt6");
	private By bloqueBtn = By.id("jt7");
	private By procesosBtn = By.id("jt8");

	// Datos económicos

	// OJO! revisar conforme se intreractue con los distintos elementos si es necesario pasar de by.id() a by.xpath()
	private By reservasYExpectativasBtn = By.id("jt10");

	private By pagosBtn = By.cssSelector("[title = 'Pagos  ']");

	private By recobrosBtn = By.id("jt12");

	// Otras gestiones
	private By gestionDelFraudeBtn = By.id("jt14");
	// Carpetas

	private By gestionDeCarpetasBtn = By.xpath(".//*[text()='Gestión de carpetas'] ");
	// private By gestionDeCarpetas = By.id("jt15son");

	// Reservas del siniestro
	private By infoCarpeta = By.xpath("//*[@id='bloque1tr1']/td[2]/text()");
	private By infoBloque = By.cssSelector("#bloque1tr1 > td:nth-child(3)");
	private By infoReservaActualTxt = By.cssSelector("#bloque1tr1 > td:nth-child(4)");
	private By infoPagos = By.cssSelector("#bloque1tr1 > td:nth-child(5)");
	private By infoExpectativaActual = By.cssSelector("#bloque1tr2 > td:nth-child(6)");
	private By infoRecobros = By.cssSelector("#bloque1tr1 > td:nth-child(7)");
	private By infoCoste = By.cssSelector("#bloque1tr1 > td:nth-child(8)");

	// private By acciones = By.cssSelector("[id*='capaFlecha'] a");
	private By acciones = By.cssSelector("#bloque1tr1 > td:nth-child(9) > div");

	private By consultarExpectaticvas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By consultarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	// private By modificarExepectativas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(4) > a");
	// a[onclick*='expectativa']
	private By modificarExepectativasBtn = By.linkText("Modificar expectativa");
	// private By modificarReservas = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");
	private By modificarReservasBtn = By.cssSelector("a[onclick*='TITULO=Modificación de reserva actual']");
	// private By modificarReservas = By.linkText("Modificar reservas");

	// Modificacion expectativa actual

	// private By expReservaIndemnizable = By.cssSelector("body.sis-body sis-modalcontainer > #formDatos >
	// div.contentBox.wideBox > div.sis-frame-bg > table:nth-child(2) > tbody > tr.odd > td:nth-child(2) >
	// input#espectativa_CR001");
	private By expReservaIndemnizableInput = By.cssSelector("#espectativa_CR001");
	// private By expReservaIndemnizable = By.cssSelector("#formDatos > div.contentBox.wideBox > div.sis-frame-bg >
	// table:nth-child(2) > tbody > tr.odd > td:nth-child(2) > input");
	private By expReservaReparableInput = By.cssSelector("#espectativa_CR002");
	private By expReservaGastosInput = By.cssSelector("#espectativa_CR003");

	private By grabarExpectativaBtn = By.cssSelector("#botonGrabar");
	private By grabarReservasBtn = By.cssSelector("#buttonRecord");
	private By btnCancelarExpectativa = By.cssSelector("#botonCancelar");

	// Modificacion reserva actual
	private By reservaIndemnizableInput = By.cssSelector("input#CR001");
	private By reservaReparableInput = By.cssSelector("input#CR002");
	private By reservaGastosInput = By.cssSelector("input#CR003");

	// Buscador de siniestros

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
	private By tipoCausaTxt = By.cssSelector("#filtro8");
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

	private By buscarBtn = By.cssSelector("#botonBuscar");

	private By flechaContinuarBtn = By.cssSelector("tr:nth-child(3) td:nth-child(11) span");

	private By verSaldoBtn = By.cssSelector("ul.list-level-1.js-actionsdinamicbar:nth-child(1) span");

	public GestionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public GestionSiniestrosPage clickLogo() {
		debugBegin();
		webDriver.clickInFrame(logoBtn, topFrame);
		debugEnd();

		return this;
	}

	// Acciones menu izquierda
	public GestionSiniestrosPage goToDiario() {
		debugBegin();
		webDriver.clickInFrame(diarioBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToVista() {
		debugBegin();
		webDriver.clickInFrame(vistaBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToAgenda() {
		debugBegin();
		webDriver.clickInFrame(agendaBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToDocumentacion() {
		debugBegin();
		webDriver.clickInFrame(documentacionBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToComunicacion() {
		debugBegin();
		webDriver.clickInFrame(comunicacionBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToBloque() {
		debugBegin();
		webDriver.clickInFrame(bloqueBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToProcesos() {
		debugBegin();
		webDriver.clickInFrame(procesosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage reservasYExpecativas() {
		debugBegin();
		webDriver.clickInFrame(reservasYExpectativasBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToPagos() {
		debugBegin();
		webDriver.clickInFrame(pagosBtn, leftFrame);
		webDriver.waitWithDriver(6000);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToRecobros() {
		debugBegin();
		webDriver.clickInFrame(recobrosBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToGestionDelFraude() {
		debugBegin();
		webDriver.clickInFrame(gestionDelFraudeBtn, leftFrame);
		debugEnd();

		return this;
	}

	public GestionSiniestrosPage goToGestionDeCarpetas() {
		debugBegin();
		webDriver.waitWithDriver(3000);

		debugInfo("Gestion: " + webDriver.getTextInFrame(gestionDeCarpetasBtn, leftFrame));
		webDriver.clickInFrame(gestionDeCarpetasBtn, leftFrame);

		debugEnd();

		return this;
	}
	// end region

	// Reservas y expectativas
	// TODO unir con modificarExpectativasACero
	public GestionSiniestrosPage modificarExpectativa() {
		debugBegin();

		double expIndemnizable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double expReparable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double expGastos = (double) Math.round((Math.random() * 10) * 100d) / 100d;

		setTestVar(EXPECTATIVA_TOTAL, Double.toString(expIndemnizable + expReparable + expGastos));

		debugInfo("El botón para desplegar el menú acciones de carpeta");
		webDriver.clickInFrame(listaCarpetaBtn, cuerpoFrame);
		debugInfo("Desplegar menú acciones de carpeta");
		webDriver.waitForElementToBeClickableInFrame(modificarExepectativasBtn, cuerpoFrame);
		debugInfo("Esperar que abra el menú de acciones");
		webDriver.clickInFrame(modificarExepectativasBtn, cuerpoFrame);
		debugInfo("Click en modificar expectativas");

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);

		debugInfo("Cambiar y esperar al iframe");
		ActionSteps.waitForIt(webDriver); // nuevo
		webDriver.setText(expReservaIndemnizableInput, Double.toString(expIndemnizable));
		webDriver.setText(expReservaReparableInput, Double.toString(expReparable));
		webDriver.setText(expReservaGastosInput, Double.toString(expGastos));

		debugInfo("Todos los campos del modal son modificados");
		webDriver.click(grabarExpectativaBtn);
		webDriver.exitFrame();

		debugInfo("Se graban las expectativas añadidas");

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage modificarExpectativasACero() {
		debugBegin();

		setTestVar(EXPECTATIVA_TOTAL, "0");

		webDriver.clickInFrame(listaCarpetaBtn, cuerpoFrame);
		webDriver.clickInFrame(modificarExepectativasBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);

		webDriver.setText(expReservaIndemnizableInput, "0");
		webDriver.setText(expReservaReparableInput, "0");
		webDriver.setText(expReservaGastosInput, "0");
		webDriver.click(grabarExpectativaBtn);

		webDriver.exitFrame();

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	// TODO unir con modificarReservaACero
	public GestionSiniestrosPage modificarReserva() {
		debugBegin();

		double resIndemnizable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double resReparable = (double) Math.round((Math.random() * 10) * 100d) / 100d;
		double resGastos = (double) Math.round((Math.random() * 10) * 100d) / 100d;

		setTestVar(RESERVA_TOTAL, Double.toString(resIndemnizable + resReparable + resGastos));

		debugInfo("Desplegar menú acciones de carpeta");
		webDriver.clickInFrame(listaCarpetaBtn, cuerpoFrame);

		debugInfo("Click en modificar expectativas");
		webDriver.clickInFrame(modificarReservasBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);

		ActionSteps.waitForIt(webDriver);
		webDriver.setText(reservaIndemnizableInput, Double.toString(resIndemnizable));
		webDriver.setText(reservaReparableInput, Double.toString(resReparable));
		webDriver.setText(reservaGastosInput, Double.toString(resGastos));
		debugInfo("Todos los campos del modal son modificados");

		webDriver.click(grabarReservasBtn);
		debugInfo("Se graban las expectativas añadidas");

		webDriver.exitFrame();
		webDriver.waitWithDriver(3000);

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage modificarReservaACero() {
		debugBegin();

		setTestVar(RESERVA_TOTAL, "0");

		webDriver.clickInFrame(listaCarpetaBtn, cuerpoFrame);
		webDriver.clickInFrame(modificarReservasBtn, cuerpoFrame);
		
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);
		
		webDriver.setText(reservaIndemnizableInput, "0");
		webDriver.setText(reservaReparableInput, "0");
		webDriver.setText(reservaGastosInput, "0");

		webDriver.click(grabarReservasBtn);
		
		webDriver.exitFrame();
		webDriver.waitWithDriver(3000);

		webDriver.acceptAlert();

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage verificarTotales() {
		debugBegin();

		String reservaActual = webDriver.getTextInFrame(infoReservaActualTxt, cuerpoFrame).trim();

		webDriver.takeScreenshot("Comprobacion reservas", userS.getReportPath());

		boolean checkReservas = reservaActual.equals(getTestVar(RESERVA_TOTAL) + "€");
		Assert.assertTrue(checkReservas, "COMPARAR CAMPOS : Verificar Totales info: las reservas coinciden.");

		String expectativaActual = webDriver.getTextInFrame(infoExpectativaActual, cuerpoFrame).trim();

		webDriver.takeScreenshot("Comprobacion expectativas", userS.getReportPath());

		boolean checkExpectativas = expectativaActual.equals(getTestVar(EXPECTATIVA_TOTAL) + "€");
		Assert.assertTrue(checkExpectativas, "COMPARAR CAMPOS : Verificar Totales info: las expectativas coinciden.");

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public GestionSiniestrosPage mostrarInfoGeneral() {
		debugBegin();
		
		debugInfo("Información General desde Gestión de Siniestro");
		debugInfo("=========================================");
		debugInfo("- " + webDriver.getTextInFrame(nPolizaInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(responsableInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(aseguradoInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(fOcurrenciaInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(riesgoInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(fAperturaInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(tipoCausaInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame));
		
		if(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame).contains("Cerrado")) {
			debugInfo("- " + webDriver.getTextInFrame(fechaCierreSiniestroTxt, cuerpoFrame));
		}
		
		debugInfo("- " + webDriver.getTextInFrame(mediadorInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(tareasPendientesInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(costeActualInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(importePagosInfoTxt, cuerpoFrame));
		debugInfo("- " + webDriver.getTextInFrame(reservaActualInfoTxt, cuerpoFrame));
		
		debugEnd();
		
		return this;
	}

	// TODO Comprobar si hacen falta InFrames
	public GestionSiniestrosPage compararInfoGeneralCSV() {
		debugInfo("Cotejando datos de siniestro con csv...");

		debugInfo("Póliza CSV: " + getTestVar(Constants.NUM_POLIZA));

		debugInfo("Póliza de siniestro: " + webDriver.getText(nPolizaInfoTxt));

		if(getTestVar(Constants.NUM_POLIZA).equals(webDriver.getText(nPolizaInfoTxt).substring(20))) {
			debugInfo("Los números de las pólizas coinciden");
		} else {
			debugInfo("Los números de las pólizas NO coinciden");
		}

		debugInfo("Tipo de causa CSV: " + getTestVar(Constants.TIPO_CAUSA));

		debugInfo("Tipo de causa del siniestro: " + webDriver.getText(tipoCausaTxt));

		if(getTestVar(Constants.TIPO_CAUSA).equals(webDriver.getText(tipoCausaInfoTxt))) {
			debugInfo("Los números de las pólizas coinciden");
		} else {
			debugInfo("Los números de las pólizas NO coinciden");
		}

		return this;
	}

	public GestionSiniestrosPage comprobarCausa(String causa) {
		debugBegin();

		debugInfo("Tipo de causa: " + webDriver.getTextInFrame(causaSinTxt, cuerpoFrame));
		Assert.assertTrue(webDriver.getTextInFrame(causaSinTxt, cuerpoFrame).contains(causa), "Modificación de causa siniestro completada con exito");

		debugEnd();
		
		return this;
	}

	// TODO Hacer que las comprobaciones se reflejen en el report
	public GestionSiniestrosPage comprobarSiniestroCerrado() {
		debugBegin();
		
		debugInfo("Comprobamos si el estado del siniestro es: 'Cerrado'");

		debugInfo("- " + webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame));
		if(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame).contains("Cerrado")) {
			debugInfo("OK : el siniestro está cerrado");
			debugInfo("- " + webDriver.getTextInFrame(fechaCierreSiniestroTxt, cuerpoFrame));
			debugInfo("- " + webDriver.getTextInFrame(reservaActualInfoTxt, cuerpoFrame));
			// Tiene que ser 0
		} else {
			// TODO Añadir trigger para que el resultado de la prueba aparezca fallo en el reporte
			debugInfo("KO : el siniestro sigue abierto");
		}

		debugEnd();
		
		return this;
	}

	public GestionSiniestrosPage comprobarSiniestroReaperturadoOk() {
		debugBegin();
		debugInfo("Comprobamos si el siniestro ha reaperturado correctamente");

		if(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame).contains("Abierto")) {
			debugInfo("Estado de siniestro correcto");
			Assert.assertTrue(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame).contains("Abierto"));
		} else {
			debugInfo("Estado de siniestro INCORRECTO");
		}

		Assert.assertFalse(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame).contains("Abierto"));

		Assert.assertFalse(webDriver.getTextInFrame(costeActualInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00") &&
			webDriver.getTextInFrame(importePagosInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00")
			&& webDriver.getTextInFrame(reservaActualInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00"));
		
		debugEnd();
		
		return this;
	}

	public GestionSiniestrosPage comprobarReservasReaperturadasOk() {
		debugBegin();
		
		debugInfo("Comprobamos si el siniestro ha reaperturado correctamente");
		Assert.assertFalse(webDriver.getTextInFrame(costeActualInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00") &&
			webDriver.getTextInFrame(importePagosInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00")
			&& webDriver.getTextInFrame(reservaActualInfoTxt, cuerpoFrame).equalsIgnoreCase("0,00"));

		debugEnd();
		
		return this;
	}

	public GestionSiniestrosPage comprobarCarpetaReaperturadaOk() {
		debugBegin();
		
		debugInfo("Comprobamos si la carpeta ha reaperturado correctamente");
		webDriver.clickInFrame(gestionDeCarpetasBtn, leftFrame);

		debugEnd();
		
		return this;
	}

} // END