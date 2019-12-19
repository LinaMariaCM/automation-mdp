package com.amaris.project.pages.administracion.siniestros.gestion;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PagosSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");
	private By selectorFrame = By.id("selectorTipoFigura");
	private By accederPagos = By.xpath(".//*[text()='Pagos'] ");

	// informacion general
	private By avisosInfo = By.cssSelector("body > form > table.sis-frame-bg.wideBox > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)");
	
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
	
	private By estadoCarpeta = By.cssSelector("table[class='grid wideBox'] > tbody > tr:nth-of-type(2) > td:nth-child(7)");

	// Info listado de pagos de carpetas

	// private By estadoCarpeta = By.cssSelector("#bloque1tr1 td:nth-child(7) a span");

	// Menu superior
	private By verSaldoFranquicias = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
	private By verDocumentacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
	private By consultaPoliza = By.cssSelector("#enlacePoliza");

	private By irListadoPagos = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar div.level-1 ul.list-level-1 li.rightList span.action-return");

	// Continuar,importes,Grabar
	private By botonContinuar1 = By.cssSelector("#botonContinuar");

	// Botones de interaccion
	private By nuevoPago = By.cssSelector("#bloque1tr1 td:nth-child(8) a span");

	// Tipo perceptor
	private By perceptor = By.cssSelector("#tipoPerceptor");
	// Participantes expediente
	private By flecha1 = By.cssSelector("tr.even td:nth-child(2) span");
	// Figuras de la poliza
	private By flecha2 = By.cssSelector("table.grid.narrowBox tr.odd span");
	// Empresas profesionales
	private By empresaColaboradora = By.cssSelector("#idPerceptor");
	// Compañia contrataria
	private By nombreCiaInput = By.cssSelector("#nombreCiaCC");
	private By ciaContratariaInput = By.cssSelector("#ciaCC");
	// Compañia reparadora
	private By flecha3 = By.cssSelector("tr.odd td:nth-child(4) span");

	// Datos bancarios
	private By medioPago = By.cssSelector("#medioPago");
	private By cuentaValidada = By.cssSelector("#checkboxCuentaValidada");
	private By codigoIban = By.cssSelector("#COMODIN_CADENA");
	private By banco = By.cssSelector("#COMODIN_CADENA_1");
	private By sucursal = By.cssSelector("#COMODIN_CADENA_2");
	private By DC = By.cssSelector("#COMODIN_CADENA_3");
	private By CTA = By.cssSelector("#COMODIN_CADENA_4");
	private By CTA2 = By.cssSelector("#COMODIN_CADENA_5");
	private By calcularIban = By.cssSelector("#lnkCalcularIban");

	private By documentoBancario = By.cssSelector("#docBancario");

	// Datos del pago
	private By tipoDocumento = By.cssSelector("#tipoDocumento");
	private By numeroDocumento = By.cssSelector("#numeroDocumento");
	private By nombre = By.cssSelector("#nombre");
	private By primerApellido = By.cssSelector("#apellido1");
	private By segundoApellido = By.cssSelector("#apellido2");
	private By fechaNacimiento = By.cssSelector("#fechaNacimiento");
	private By sexo = By.cssSelector("#sexo");
	private By prefijo1 = By.cssSelector("input[name='auxiliar404']");
	private By telefono1 = By.cssSelector("#telefono1");
	private By prefijo2 = By.cssSelector("input[name='auxiliar411']");
	private By telefono2 = By.cssSelector("#telefono2");
	private By prefijo3 = By.cssSelector("input[name='auxiliar415']");
	private By fax = By.cssSelector("#numeroFax");
	private By email = By.cssSelector("#eMail");

	// Domicilio
	private By tipoVia = By.cssSelector("#tipovia");
	private By domicilio = By.cssSelector("#nomcalle");
	private By numero = By.cssSelector("#numcalle");
	private By portal = By.cssSelector("#portal");
	private By escalera = By.cssSelector("#escalera");
	private By piso = By.cssSelector("#piso");
	private By puerta = By.cssSelector("#puerta");
	private By codigoPostal = By.cssSelector("#codpostal");
	private By poblacion = By.cssSelector("#poblacion");

	// Referencia
	private By numeroReferencia = By.cssSelector("#refere");

	// Observaciones
	private By observaciones = By.cssSelector("input[name='observacion']");

	private By botonContinuar = By.cssSelector("#buttonContinue");

	// Conceptos de pago
	private By fechaDePago = By.cssSelector("#fechaPago");
	private By conceptoPago = By.cssSelector("#ctoPago");
	private By botonModificarReserva = By.cssSelector("#botonModificarReserva");
	private By reservaActual = By.cssSelector("#RESEACTU");
	private By grabarReserva = By.cssSelector("#buttonRecord");
	private By cancelarReserva = By.cssSelector("#buttonCancel");
	private By conFactura = By.cssSelector("#radio1");
	private By sinFactura = By.cssSelector("#radio");

	// Datos factura
	private By fechaFactura = By.cssSelector("#fechaFactura");
	private By numeroFactura = By.cssSelector("#numeroFactura");

	// Coberturas implicadas
	private By rCRotura = By.cssSelector("#checkCob_ST0039");
	private By importe0 = By.cssSelector("#importes0");

	private By rCOmision = By.cssSelector("#checkCob_ST0040");
	private By importe1 = By.cssSelector("#importe1");

	private By dañosPropiosComunitarias = By.cssSelector("#checkCob_ST0043");
	private By importe2 = By.cssSelector("#importe2");

	private By comuntariasSubterraneos = By.cssSelector("#checkCob_ST0204");
	private By importe3 = By.cssSelector("#importe3");

	private By comunitariaLocalizacionAveria = By.cssSelector("#checkCob_ST0045");
	private By importe4 = By.cssSelector("#importe4");

	private By comunitariaReparacionAveria = By.cssSelector("#checkCob_ST0046");
	private By importe5 = By.cssSelector("#importe5");

	private By comunitariaLocalizacionAveriaSubterranea = By.cssSelector("#checkCob_ST0047");
	private By importe6 = By.cssSelector("#importe6");

	private By comunitariaReparacionAveriaSubterranea = By.cssSelector("#checkCob_ST0048");
	private By importe7 = By.cssSelector("#importe7");

	private By comunitariaExcesoAgua = By.cssSelector("#checkCob_ST0050");
	private By importe8 = By.cssSelector("#importe8");

	private By dañosEdificiosColidantes = By.cssSelector("#checkCob_ST0053");
	private By importe9 = By.cssSelector("#importe9");

	private By comunitarioRestauracionEstetica = By.cssSelector("#checkCob_ST0083");
	private By importe10 = By.cssSelector("#importe10");

	private By gastosIntervencionExtinsionSalvamento = By.cssSelector("#checkCob_ST0015");
	private By importe11 = By.cssSelector("#importe11");

	private By gastosDemolicionDescombro = By.cssSelector("#checkCob_ST0016");
	private By importe12 = By.cssSelector("#importe12");

	private By gastosInhabilitadaPerdidaAlquileres = By.cssSelector("#checkCob_ST0017");
	private By importe13 = By.cssSelector("#importe13");

	private By gastosReposicionDocumentos = By.cssSelector("#checkCob_ST0018");
	private By importe14 = By.cssSelector("#importe14");

	private By asistenciaServiciosProfesionales = By.cssSelector("#checkCob_ST0093");
	private By importe15 = By.cssSelector("#importe15");

	// Asignacion de cobertura
	private By actualizarImportePago = By.cssSelector("#datospago div:nth-child(5) input");

	// Importes
	private By pagoCuentaSi = By.cssSelector("#pagoCtaSi");
	private By pagoCuentaNo = By.cssSelector("#pagoCtaNo");
	private By causasImportes = By.cssSelector("#coberturaImplicada .radio");

	// Verificacion ultimo pago de carpeta
	private By ultimoPagoSi = By.cssSelector("#ultimoPagoSi");
	private By ultimoPagoNo = By.cssSelector("#ultimoPagoNo");
	private By iva = By.cssSelector("#codigoTipoIvaFactura");
	private By irpf = By.cssSelector("#codigoTipoIrpfFactura");
	private By gastosSuplidos = By.cssSelector("#exentoFacInt");

	// comprobar si tiene pagos
	private By listPagos = By.cssSelector("table.grid:nth-child(1) > tbody:nth-child(1) tr[valign='top'] td:nth-child(9)");

	private By tipoPerceptor = By.cssSelector("#tipoPerceptor");
	private By tipoPerceptorElemento = By.cssSelector("#tipoPerceptor > option");

	// información de pago en lista

	private By infoIdPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(1) > strong");
	private By infoFechaListaPago = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(2)");
	private By infoReferenciaPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(3)");
	private By infoPerceptorPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(4)");
	private By infoCostePagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(5)");
	private By infoIRPFPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(6)");
	private By infoIVAPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(7)");
	private By infoTotalPagadoPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(8)");
	private By infoEstadoPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(9)");
	private By infoSituacionPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(10)");
	private By infoAgrupacionPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(11)");
	private By infoAccionesPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(12)");

	// acciones disponibles dentro de la info de lista de pagos
	private By infoAccionesConsultar = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By infoAccionesModificar = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	private By infoAccionesAnular = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");
	private By infoAccionesDesblooquear = By.cssSelector("body > div.pdata > div > ul > li:nth-child(4) > a");
	// validar una cuenta dentro de la opcion de desbloquear
	private By DesbloquearCuentaValidada = By.cssSelector("#checkNoValid");
	private By DesbloquearGrabar = By.cssSelector("#buttonRecord");

	private By radioActivarPlanPago = By.cssSelector("#planPagoSi");

	private By planFPrimerPago = By.cssSelector("input#fPrimerPago");
	private By planFActivacion = By.cssSelector("input#fActivacion");
	private By planImportePrimerPago = By.cssSelector("input#importePrimerPago");
	private By btnGenerarPlan = By.cssSelector("input.secondButton");
	private By tablaPagos = By.id("detallePlan");
	private By marcaPagos = By.cssSelector("table[class='sis-frame-bg.wideBox1] > tbody > tr > td:nth-child(2) > table[class='sis-frame-bg2.wideBox'] > tbody > tr:nth-child(2)");
	private By primerPagoTabla = By.cssSelector("#capaBloque1Desplegable2 > table.grid.wideBox > tbody > tr:nth-child(2) > td:nth-child(10)");
	private By msjConfirmarPrimerPago = By.cssSelector("table.narrowBox");

	// pago a carpeta

	//	private By volverListaPagos = By.cssSelector("div.menuNav.menuNavPosAbsolute.menuNavPosFixed > div > ul > li.rightList > a");
	private By volverListaPagos = By.cssSelector("div.menuNav.menuNavPosAbsolute > div > ul > li > a > span.retorno");
	private By desplegarCarpetas = By.cssSelector("a#cabeceraBloqueDesplegable1");
	// endregion

	public PagosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public PagosSiniestrosPage nuevoPago() {
		debugBegin();

		webDriver.clickInFrame(accederPagos, leftFrame);

		setTestVar(Constants.ESTADO_CARPETA, webDriver.getTextInFrame(estadoCarpeta, cuerpoFrame));
		System.out.println("El estado de la carpeta es: " + webDriver.getTextInFrame(estadoCarpeta, cuerpoFrame));

		if(getTestVar(Constants.ESTADO_CARPETA).equalsIgnoreCase(getTestVar(Constants.ESTADO_CARPETA_CERRADA))) {
			System.out.println("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");
		} else {
			webDriver.clickInFrame(nuevoPago, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarParticipantesExpediente() {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(perceptor, 4);
		System.out.println("Elemento flecha1 es: " + flecha1);
		webDriver.waitWithDriver(8000);

		webDriver.click(flecha1);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage seleccionarTipoDePerceptor() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		// webDriver.clickElementFromDropDownByIndex(perceptor,4);
		webDriver.clickElementFromDropDownByAttribute(tipoPerceptor, tipoPerceptorElemento, "value", "PE40");
		System.out.println("Elemento flecha1 es: " + flecha1);
		webDriver.waitWithDriver(8000);

		webDriver.click(flecha1);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage seleccionarFiguraPoliza() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(perceptor, 1);
		webDriver.click(flecha2);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	// VERIFICAR

	public PagosSiniestrosPage seleccionarEmpresasProfesionales() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(perceptor, 6);

		webDriver.click(botonContinuar);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage seleccionarCompanyiaContrataria(String nombreCia, String ciaContrataria) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(perceptor, 2);
		webDriver.appendText(nombreCiaInput, nombreCia);
		webDriver.appendText(ciaContratariaInput, ciaContrataria);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage seleccionarVariosDatosLibres() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 3);
		webDriver.click(botonContinuar1);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage seleccionarJuzgado() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 4);
		webDriver.click(botonContinuar1);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	// Medios pago
	public PagosSiniestrosPage medioPagoTransferencia(String CodigoIban, String Banco, String Sucursal, String dc, String cta, String cta2) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 2);
		webDriver.appendText(codigoIban, CodigoIban);
		webDriver.appendText(banco, Banco);
		webDriver.appendText(sucursal, Sucursal);
		webDriver.appendText(DC, dc);
		webDriver.appendText(CTA, cta);
		webDriver.appendText(CTA2, cta2);
		webDriver.click(calcularIban);
		webDriver.click(botonContinuar);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage medioPagoCheque(String docBancario) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 3);
		webDriver.appendText(documentoBancario, docBancario);
		webDriver.click(botonContinuar);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage medioPagoConsignacion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 4);
		webDriver.click(botonContinuar);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage datosPerceptor() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(medioPago, 4);
		webDriver.click(botonContinuar);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	// Datos del pago

	public PagosSiniestrosPage datosPagoNif(String TipoDocumentoNif, String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(tipoDocumento, 1);
		webDriver.appendText(numeroDocumento, TipoDocumentoNif);
		webDriver.appendText(nombre, Nombre);
		webDriver.appendText(primerApellido, PrimerApellido);
		webDriver.appendText(segundoApellido, SegundoApellido);
		webDriver.appendText(fechaNacimiento, FechaNacimiento);
		webDriver.clickElementFromDropDownByIndex(sexo, 4);
		webDriver.appendText(telefono1, Tel1);
		webDriver.appendText(telefono2, Tel2);
		webDriver.appendText(email, Email);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage datosPagoNie(String TipoDocumentoNie, String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(tipoDocumento, 2);
		webDriver.appendText(numeroDocumento, TipoDocumentoNie);
		webDriver.appendText(nombre, Nombre);
		webDriver.appendText(primerApellido, PrimerApellido);
		webDriver.appendText(segundoApellido, SegundoApellido);
		webDriver.appendText(fechaNacimiento, FechaNacimiento);
		webDriver.clickElementFromDropDownByIndex(sexo, 4);
		webDriver.appendText(telefono1, Tel1);
		webDriver.appendText(telefono2, Tel2);
		webDriver.appendText(email, Email);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage datosPagoPasaporte(String TipoDocumentoPasaporte, String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2,
		String Email) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(tipoDocumento, 1);
		webDriver.appendText(numeroDocumento, TipoDocumentoPasaporte);
		webDriver.appendText(nombre, Nombre);
		webDriver.appendText(primerApellido, PrimerApellido);
		webDriver.appendText(segundoApellido, SegundoApellido);
		webDriver.appendText(fechaNacimiento, FechaNacimiento);
		webDriver.clickElementFromDropDownByIndex(sexo, 4);
		webDriver.appendText(telefono1, Tel1);
		webDriver.appendText(telefono2, Tel2);
		webDriver.appendText(email, Email);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage datosPagoCif(String TipoDocumentoCif, String Nombre, String PrimerApellido, String SegundoApellido, String FechaNacimiento, String Tel1, String Tel2, String Email) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(tipoDocumento, 1);
		webDriver.appendText(numeroDocumento, TipoDocumentoCif);
		webDriver.appendText(telefono1, Tel1);
		webDriver.appendText(telefono2, Tel2);
		webDriver.appendText(email, Email);
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	// Domicilio

	public PagosSiniestrosPage domicilio(String Domicilio, String Numero, String Portal, String Escalera, String Piso, String Puerta, String CodigoPostal, String Poblacion) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByIndex(tipoVia, 14);
		webDriver.appendText(domicilio, Domicilio);
		webDriver.appendText(numero, Numero);
		webDriver.appendText(portal, Portal);
		webDriver.appendText(escalera, Escalera);
		webDriver.appendText(piso, Piso);
		webDriver.appendText(puerta, Puerta);
		webDriver.appendText(codigoPostal, CodigoPostal);
		webDriver.appendText(poblacion, Poblacion);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	// Observaciones

	public PagosSiniestrosPage observaciones(String Observaciones) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.appendText(observaciones, Observaciones);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	// Importes
	public PagosSiniestrosPage importes(String fPago, String Importe1, boolean activarPlanMAC) {
		debugBegin();

		fPago = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		List<WebElement> listaCausasImportes = webDriver.getElementsInFrame(causasImportes, cuerpoFrame);

		webDriver.appendTextInFrame(fechaDePago, cuerpoFrame, fPago);
		webDriver.waitWithDriver(3000);

		// concepto pago

		webDriver.clickElementChildByIndexInFrame(conceptoPago, cuerpoFrame, 1);
		webDriver.waitWithDriver(12000);
		// Asignacion de cobertura
		System.out.println("Lista de coberturas: " + listaCausasImportes);
		System.out.println("Cobertura seleccionada: " + webDriver.getTextInFrame(listaCausasImportes.get(0), cuerpoFrame));

		webDriver.clickInFrame(listaCausasImportes.get(0), cuerpoFrame);
		// webDriver.clickInFrame(rCRotura, cuerpoFrame);
		if(Importe1 == null || Importe1.isEmpty()) Importe1 = "123";
		webDriver.appendTextInFrame(importe0, cuerpoFrame, Importe1);
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(actualizarImportePago, cuerpoFrame);

		if(activarPlanMAC) {
			webDriver.clickInFrame(radioActivarPlanPago, cuerpoFrame);
			webDriver.waitWithDriver(8000);
			webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
		} else {
			webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
		}

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage verificacion() {
		debugBegin();

		webDriver.waitWithDriver(9000);
		webDriver.clickInFrame(botonContinuar1, cuerpoFrame);

		debugEnd();
		return this;
	}

	public Boolean comprobarPagosPendientes() {
		debugBegin();
		webDriver.clickInFrame(accederPagos, leftFrame);
		ActionSteps.waitForIt(webDriver);
		Boolean check = false;
		if(webDriver.isClickableInFrame(listPagos, cuerpoFrame)) {
			debugInfo("antes de la lista");
			webDriver.switchToFrame(cuerpoFrame);
			List<WebElement> listaPagos = webDriver.getElements(listPagos);
			debugInfo("Contiene: " + listaPagos.size());

			for(int i = 0; i < listaPagos.size(); i++) {
				debugInfo("hay Pagos");

				debugInfo("Estado: " + listaPagos.get(i).getText());
				if(listaPagos.get(i).getText().compareTo("Pagado") != 0 && listaPagos.get(i).getText().compareTo("Anulado") != 0) {
					check = true;
					debugInfo("Pagos Pendiente: " + check);
				}
			}
			webDriver.exitFrame();

		} else {
			debugInfo("No hay pagos");
		}

		debugEnd();
		return check;
	}

	public PagosSiniestrosPage desbloquearPago() {
		debugBegin();
		debugInfo("Comprobamos el estado del pago... ");
		
		if(webDriver.getTextInFrame(avisosInfo,cuerpoFrame).contains("Reconsiderado")) {
			System.out.println("Siniestro ya reconsiderado");
			new GestionSiniestrosPage(userS).logo();
			return this;
		}
		System.out.println("El esado actual del pago es: " + webDriver.getTextInFrame(infoSituacionPagoLista,cuerpoFrame));
		if(webDriver.getTextInFrame(infoEstadoPagoLista,cuerpoFrame).contains("Pendiente de Autorización")) {
			System.out.println("Error: Pago ya desbloqueado");
			new GestionSiniestrosPage(userS).logo();
			return this;
		}

		debugInfo("Procedemos a desbloquear pago");
		webDriver.clickInFrame(infoAccionesPagoLista, cuerpoFrame);
		webDriver.clickInFrame(infoAccionesDesblooquear, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(DesbloquearCuentaValidada, capaIframe);
		webDriver.clickInFrame(DesbloquearGrabar, capaIframe);
		webDriver.waitWithDriver(3000);

		if(webDriver.getText(infoEstadoPagoLista).contains("Pendiente de Autorización")) {
			System.out.println("Pago desbloqueado");
		} else System.out.println("Error: el pago no se ha podido despbloquear.");

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage emitirPlanPagosMAC(String fechaPlanPrimerPago, String fechaActivacion, String importePrimerPagoPlan) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		fechaPlanPrimerPago = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		fechaActivacion = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.appendTextInFrame(planFPrimerPago, cuerpoFrame, fechaPlanPrimerPago);
		webDriver.appendTextInFrame(planFActivacion, cuerpoFrame, fechaActivacion);
		webDriver.appendTextInFrame(planImportePrimerPago, cuerpoFrame, importePrimerPagoPlan);

		webDriver.clickInFrame(btnGenerarPlan, cuerpoFrame);

		webDriver.waitWithDriver(2000);

		// método para probar que se ha generado
		if(webDriver.isPresentInFrame(tablaPagos, cuerpoFrame)) {
			if(webDriver.getTextInFrame(tablaPagos, cuerpoFrame).contains("120")) {
				System.out.println("Si está presente el importe de primer pago");
				webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
			}
		} else {
			System.out.println("NO está presente el importe del primer pago");
			webDriver.clickInFrame(botonContinuar1, cuerpoFrame);
		}

		debugEnd();
		return this;
	}

	public PagosSiniestrosPage comprobarPlanPagosMAC() {
		debugBegin();
		webDriver.waitWithDriver(4000);

		if(!webDriver.getTextInFrame(msjConfirmarPrimerPago, cuerpoFrame).contains("120,00")) {
			debugInfo("El importe del primer pago no coincide con el establecido de 120€");
		}

		webDriver.clickInFrame(volverListaPagos, cuerpoFrame);

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(desplegarCarpetas, cuerpoFrame);

		String ppagoTabla = webDriver.getTextInFrame(primerPagoTabla, cuerpoFrame).trim();

		boolean checkPPagoTabla = ppagoTabla.contains("120,00€");
		Assert.assertTrue(checkPPagoTabla, "COMPARAR CAMPOS : El primer pago se lista en la tabla de pagos");

		debugEnd();
		return this;
	}

	// endregion
}
