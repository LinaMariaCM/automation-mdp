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
	private By accederPagosBtn = By.xpath(".//*[text()='Pagos'] ");

	// Informacion general
	private By avisosInfoTxt = By.cssSelector("body > form > table.sis-frame-bg.wideBox > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2)");

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

	private By estadoCarpetaTxt = By.cssSelector("table[class='grid wideBox'] > tbody > tr:nth-of-type(2) > td:nth-child(7)");

	// Info listado de pagos de carpetas

	// private By estadoCarpeta = By.cssSelector("#bloque1tr1 td:nth-child(7) a span");

	// Menu superior
	private By verSaldoFranquicias = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
	private By verDocumentacion = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar li:nth-child(1) span");
	private By consultaPoliza = By.cssSelector("#enlacePoliza");

	private By irListadoPagos = By.cssSelector("div.actionsbar.js-fixedbar.js-assignedfixedbar div.level-1 ul.list-level-1 li.rightList span.action-return");

	// Continuar,importes,Grabar
	private By continuar1Btn = By.cssSelector("#botonContinuar");

	// Botones de interaccion
	private By nuevoPagoBtn = By.cssSelector("#bloque1tr1 td:nth-child(8) a span");

	// Tipo perceptor
	private By perceptorDrpDwn = By.cssSelector("#tipoPerceptor");
	// Participantes expediente
	private By flecha1Btn = By.cssSelector("tr.even td:nth-child(2) span");
	// Figuras de la poliza
	private By flecha2Btn = By.cssSelector("table.grid.narrowBox tr.odd span");
	// Empresas profesionales
	private By empresaColaboradora = By.cssSelector("#idPerceptor");
	// Compañia contrataria
	private By nombreCiaInput = By.cssSelector("#nombreCiaCC");
	private By ciaContratariaInput = By.cssSelector("#ciaCC");
	// Compañia reparadora
	private By flecha3 = By.cssSelector("tr.odd td:nth-child(4) span");

	// Datos bancarios
	private By medioPagoDrpDwn = By.cssSelector("#medioPago");
	private By cuentaValidada = By.cssSelector("#checkboxCuentaValidada");
	private By codigoIbanInput = By.cssSelector("#COMODIN_CADENA");
	private By bancoInput = By.cssSelector("#COMODIN_CADENA_1");
	private By sucursalInput = By.cssSelector("#COMODIN_CADENA_2");
	private By dcInput = By.cssSelector("#COMODIN_CADENA_3");
	private By ctaInput = By.cssSelector("#COMODIN_CADENA_4");
	private By cta2Input = By.cssSelector("#COMODIN_CADENA_5");
	private By calcularIbanBtn = By.cssSelector("#lnkCalcularIban");

	private By documentoBancario = By.cssSelector("#docBancario");

	// Datos del pago
	private By tipoDocumentoDrpDwn = By.cssSelector("#tipoDocumento");
	private By numeroDocumentoInput = By.cssSelector("#numeroDocumento");
	private By nombreInput = By.cssSelector("#nombre");
	private By primerApellidoInput = By.cssSelector("#apellido1");
	private By segundoApellidoInput = By.cssSelector("#apellido2");
	private By fechaNacimientoInput = By.cssSelector("#fechaNacimiento");
	private By sexoDrpDwn = By.cssSelector("#sexo");
	private By prefijo1 = By.cssSelector("input[name='auxiliar404']");
	private By telefono1Input = By.cssSelector("#telefono1");
	private By prefijo2 = By.cssSelector("input[name='auxiliar411']");
	private By telefono2Input = By.cssSelector("#telefono2");
	private By prefijo3 = By.cssSelector("input[name='auxiliar415']");
	private By fax = By.cssSelector("#numeroFax");
	private By emailInput = By.cssSelector("#eMail");

	// Domicilio
	private By tipoViaDrpDwn = By.cssSelector("#tipovia");
	private By domicilioInput = By.cssSelector("#nomcalle");
	private By numeroInput = By.cssSelector("#numcalle");
	private By portalInput = By.cssSelector("#portal");
	private By escaleraInput = By.cssSelector("#escalera");
	private By pisoInput = By.cssSelector("#piso");
	private By puertaInput = By.cssSelector("#puerta");
	private By codigoPostalInput = By.cssSelector("#codpostal");
	private By poblacionInput = By.cssSelector("#poblacion");

	// Referencia
	private By numeroReferencia = By.cssSelector("#refere");

	// Observaciones
	private By observacionesInput = By.cssSelector("input[name='observacion']");

	private By continuarBtn = By.cssSelector("#buttonContinue");

	// Conceptos de pago
	private By fechaDePagoInput = By.cssSelector("#fechaPago");
	private By conceptoPagoList = By.cssSelector("#ctoPago");
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
	private By importe0Input = By.cssSelector("#importes0");

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
	private By actualizarImportePagoBtn = By.cssSelector("#datospago div:nth-child(5) input");

	// Importes
	private By pagoCuentaSi = By.cssSelector("#pagoCtaSi");
	private By pagoCuentaNo = By.cssSelector("#pagoCtaNo");
	private By causasImportesBtn = By.cssSelector("#coberturaImplicada .radio");
	private By causasImportesTxt = By.cssSelector("#coberturaImplicada tr:not(:first-child) > td:nth-child(2)");

	// Verificacion ultimo pago de carpeta
	private By ultimoPagoSi = By.cssSelector("#ultimoPagoSi");
	private By ultimoPagoNo = By.cssSelector("#ultimoPagoNo");
	private By iva = By.cssSelector("#codigoTipoIvaFactura");
	private By irpf = By.cssSelector("#codigoTipoIrpfFactura");
	private By gastosSuplidos = By.cssSelector("#exentoFacInt");

	// comprobar si tiene pagos
	private By listaPagosTxt = By.cssSelector("table.grid:nth-child(1) > tbody:nth-child(1) tr[valign='top'] td:nth-child(9)");

	private By tipoPerceptorDrpDwn = By.cssSelector("#tipoPerceptor");
	private By tipoPerceptorOption = By.cssSelector("#tipoPerceptor > option");

	// información de pago en lista

	private By infoIdPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(1) > strong");
	private By infoFechaListaPago = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(2)");
	private By infoReferenciaPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(3)");
	private By infoPerceptorPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(4)");
	private By infoCostePagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(5)");
	private By infoIRPFPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(6)");
	private By infoIVAPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(7)");
	private By infoTotalPagadoPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(8)");
	private By infoEstadoPagoListaTxt = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(9)");
	private By infoSituacionPagoListaTxt = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(10)");
	private By infoAgrupacionPagoLista = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(11)");
	private By infoAccionesPagoListaBtn = By.cssSelector("#capaBloque1Desplegable2 > table > tbody > tr.odd > td:nth-child(12)");

	// acciones disponibles dentro de la info de lista de pagos
	private By infoAccionesConsultar = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	private By infoAccionesModificar = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	private By infoAccionesAnular = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");
	private By infoAccionesDesbloquearBtn = By.cssSelector("body > div.pdata > div > ul > li:nth-child(4) > a");
	// validar una cuenta dentro de la opcion de desbloquear
	private By desbloquearCuentaValidadaBtn = By.cssSelector("#checkNoValid");
	private By desbloquearGrabarBtn = By.cssSelector("#buttonRecord");

	private By activarPlanPagoBtn = By.cssSelector("#planPagoSi");

	private By planFPrimerPagoInput = By.cssSelector("input#fPrimerPago");
	private By planFActivacionInput = By.cssSelector("input#fActivacion");
	private By planImportePrimerPagoInput = By.cssSelector("input#importePrimerPago");
	private By generarPlanBtn = By.cssSelector("input.secondButton");
	private By tablaPagosTxt = By.id("detallePlan");
	private By marcaPagos = By.cssSelector("table[class='sis-frame-bg.wideBox1] > tbody > tr > td:nth-child(2) > table[class='sis-frame-bg2.wideBox'] > tbody > tr:nth-child(2)");
	private By primerPagoTablaTxt = By.cssSelector("#capaBloque1Desplegable2 > table.grid.wideBox > tbody > tr:nth-child(2) > td:nth-child(10)");
	private By msjConfirmarPrimerPagoTxt = By.cssSelector("table.narrowBox");

	// pago a carpeta

	// private By volverListaPagos = By.cssSelector("div.menuNav.menuNavPosAbsolute.menuNavPosFixed > div > ul >
	// li.rightList > a");
	private By volverListaPagosBtn = By.cssSelector("div.menuNav.menuNavPosAbsolute > div > ul > li > a > span.retorno");
	private By desplegarCarpetasBtn = By.cssSelector("a#cabeceraBloqueDesplegable1");
	// endregion

	public PagosSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// region methods

	public PagosSiniestrosPage nuevoPago() {
		debugBegin();

		webDriver.clickInFrame(accederPagosBtn, leftFrame);

		setTestVar(Constants.ESTADO_CARPETA, webDriver.getTextInFrame(estadoCarpetaTxt, cuerpoFrame));
		debugInfo("El estado de la carpeta es: " + webDriver.getTextInFrame(estadoCarpetaTxt, cuerpoFrame));

		if(getTestVar(Constants.ESTADO_CARPETA).equalsIgnoreCase(getTestVar(Constants.ESTADO_CARPETA_CERRADA))) {
			debugInfo("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");
		} else {
			webDriver.clickInFrame(nuevoPagoBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarParticipantesExpediente() {
		debugBegin();

		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByIndexInFrame(perceptorDrpDwn, cuerpoFrame, 4);
		webDriver.waitWithDriver(8000);

		webDriver.clickInFrame(flecha1Btn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarTipoDePerceptor() {
		debugBegin();

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoPerceptorDrpDwn, tipoPerceptorOption, cuerpoFrame, "value", "PE40");
		webDriver.waitWithDriver(8000);

		webDriver.clickInFrame(flecha1Btn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarFiguraPoliza() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(perceptorDrpDwn, cuerpoFrame, 1);
		webDriver.clickInFrame(flecha2Btn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// VERIFICAR
	public PagosSiniestrosPage seleccionarEmpresasProfesionales() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndex(perceptorDrpDwn, cuerpoFrame, 6);

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarCompanyiaContrataria(String nombreCia, String ciaContrataria) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(perceptorDrpDwn, cuerpoFrame, 2);

		webDriver.appendTextInFrame(nombreCiaInput, cuerpoFrame, nombreCia);
		webDriver.appendTextInFrame(ciaContratariaInput, cuerpoFrame, ciaContrataria);

		debugEnd();

		return this;
	}

	// TODO Unir con seleccionarJuzgado
	public PagosSiniestrosPage seleccionarVariosDatosLibres() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 3);
		webDriver.clickInFrame(continuar1Btn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage seleccionarJuzgado() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 4);
		webDriver.clickInFrame(continuar1Btn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// Medios pago
	public PagosSiniestrosPage medioPagoTransferencia(String codigoIban, String banco, String sucursal, String dc, String cta, String cta2) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 2);

		webDriver.appendTextInFrame(codigoIbanInput, cuerpoFrame, codigoIban);
		webDriver.appendTextInFrame(bancoInput, cuerpoFrame, banco);
		webDriver.appendTextInFrame(sucursalInput, cuerpoFrame, sucursal);
		webDriver.appendTextInFrame(dcInput, cuerpoFrame, dc);
		webDriver.appendTextInFrame(ctaInput, cuerpoFrame, cta);
		webDriver.appendTextInFrame(cta2Input, cuerpoFrame, cta2);

		webDriver.clickInFrame(calcularIbanBtn, cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();
		return this;
	}

	// TODO unir con medioPagoConsignacion
	public PagosSiniestrosPage medioPagoCheque(String docBancario) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 3);
		webDriver.appendTextInFrame(documentoBancario, cuerpoFrame, docBancario);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage medioPagoConsignacion() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 4);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// TODO Comprobar metodos, es igual a medioPagoConsignacion
	public PagosSiniestrosPage datosPerceptor() {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(medioPagoDrpDwn, cuerpoFrame, 4);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	// Datos del pago
	// TODO unir con datosPagoNie, datosPagoPasaporte y datosPagoCif
	public PagosSiniestrosPage datosPagoNif(String tipoDocumentoNif, String nombre, String primerApellido, String segundoApellido, 
		String fechaNacimiento, String telefono1, String telefono2, String email) {
		debugBegin();

		webDriver.clickElementFromDropDownByIndexInFrame(tipoDocumentoDrpDwn, cuerpoFrame, 1);

		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, tipoDocumentoNif);
		webDriver.appendTextInFrame(nombreInput, cuerpoFrame, nombre);
		webDriver.appendTextInFrame(primerApellidoInput, cuerpoFrame, primerApellido);
		webDriver.appendTextInFrame(segundoApellidoInput, cuerpoFrame, segundoApellido);
		webDriver.appendTextInFrame(fechaNacimientoInput, cuerpoFrame, fechaNacimiento);

		webDriver.clickElementFromDropDownByIndexInFrame(sexoDrpDwn, cuerpoFrame, 4);

		webDriver.appendTextInFrame(telefono1Input, cuerpoFrame, telefono1);
		webDriver.appendTextInFrame(telefono2Input, cuerpoFrame, telefono2);
		webDriver.appendTextInFrame(emailInput, cuerpoFrame, email);

		debugEnd();

		return this;
	}

	public PagosSiniestrosPage datosPagoNie(String tipoDocumentoNie, String nombre, String primerApellido, String segundoApellido, 
		String fechaNacimiento, String telefono1, String telefono2, String email) {
		debugBegin();
		
		webDriver.clickElementFromDropDownByIndexInFrame(tipoDocumentoDrpDwn, cuerpoFrame, 2);
		
		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, tipoDocumentoNie);
		webDriver.appendTextInFrame(nombreInput, cuerpoFrame, nombre);
		webDriver.appendTextInFrame(primerApellidoInput, cuerpoFrame, primerApellido);
		webDriver.appendTextInFrame(segundoApellidoInput, cuerpoFrame, segundoApellido);
		webDriver.appendTextInFrame(fechaNacimientoInput, cuerpoFrame, fechaNacimiento);
		
		webDriver.clickElementFromDropDownByIndexInFrame(sexoDrpDwn, cuerpoFrame, 4);
		
		webDriver.appendTextInFrame(telefono1Input, cuerpoFrame, telefono1);
		webDriver.appendTextInFrame(telefono2Input, cuerpoFrame, telefono2);
		webDriver.appendTextInFrame(emailInput, cuerpoFrame, email);

		debugEnd();
		
		return this;
	}

	public PagosSiniestrosPage datosPagoPasaporte(String tipoDocumentoPasaporte, String nombre, String primerApellido, String segundoApellido, 
		String fechaNacimiento, String telefono1, String telefono2, String email) {
		debugBegin();
		
		webDriver.clickElementFromDropDownByIndexInFrame(tipoDocumentoDrpDwn, cuerpoFrame, 1);
		
		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, tipoDocumentoPasaporte);
		webDriver.appendTextInFrame(nombreInput, cuerpoFrame, nombre);
		webDriver.appendTextInFrame(primerApellidoInput, cuerpoFrame, primerApellido);
		webDriver.appendTextInFrame(segundoApellidoInput, cuerpoFrame, segundoApellido);
		webDriver.appendTextInFrame(fechaNacimientoInput, cuerpoFrame, fechaNacimiento);
		
		webDriver.clickElementFromDropDownByIndexInFrame(sexoDrpDwn, cuerpoFrame, 4);
		
		webDriver.appendTextInFrame(telefono1Input, cuerpoFrame, telefono1);
		webDriver.appendTextInFrame(telefono2Input, cuerpoFrame, telefono2);
		webDriver.appendTextInFrame(emailInput, cuerpoFrame, email);

		debugEnd();
		
		return this;
	}

	public PagosSiniestrosPage datosPagoCif(String tipoDocumentoCif, String nombre, String primerApellido, String segundoApellido, 
		String fechaNacimiento, String telefono1, String telefono2, String email) {
		debugBegin();
		
		webDriver.clickElementFromDropDownByIndexInFrame(tipoDocumentoDrpDwn, cuerpoFrame, 1);
		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, tipoDocumentoCif);
		webDriver.appendTextInFrame(telefono1Input, cuerpoFrame, telefono1);
		webDriver.appendTextInFrame(telefono2Input, cuerpoFrame, telefono2);
		webDriver.appendTextInFrame(emailInput, cuerpoFrame, email);

		debugEnd();
		return this;
	}

	// Domicilio
	public PagosSiniestrosPage domicilio(String domicilio, String numero, String portal, String escalera, 
		String piso, String puerta, String codigoPostal, String poblacion) {
		debugBegin();
		
		webDriver.clickElementFromDropDownByIndexInFrame(tipoViaDrpDwn, cuerpoFrame, 14);
		
		webDriver.appendTextInFrame(domicilioInput, cuerpoFrame, domicilio);
		webDriver.appendTextInFrame(numeroInput, cuerpoFrame, numero);
		webDriver.appendTextInFrame(portalInput, cuerpoFrame, portal);
		webDriver.appendTextInFrame(escaleraInput, cuerpoFrame, escalera);
		webDriver.appendTextInFrame(pisoInput, cuerpoFrame, piso);
		webDriver.appendTextInFrame(puertaInput, cuerpoFrame, puerta);
		webDriver.appendTextInFrame(codigoPostalInput, cuerpoFrame, codigoPostal);
		webDriver.appendTextInFrame(poblacionInput, cuerpoFrame, poblacion);
		
		debugEnd();
		
		return this;
	}

	// Observaciones
	public PagosSiniestrosPage observaciones(String observaciones) {
		debugBegin();
		webDriver.appendTextInFrame(observacionesInput, cuerpoFrame, observaciones);
		debugEnd();
		
		return this;
	}

	// Importes
	public PagosSiniestrosPage importes(String fPago, String importe, boolean activarPlanMAC) {
		debugBegin();

		// TODO Cambiar, si se asigna directamente el valor, no hace falta ponerlo de parametro
		fPago = DateUtils.getTodayDate(Constants.DATE_FORMAT);


		webDriver.appendTextInFrame(fechaDePagoInput, cuerpoFrame, fPago);
		webDriver.waitWithDriver(3000);

		// Concepto pago
		webDriver.clickElementChildByIndexInFrame(conceptoPagoList, cuerpoFrame, 1);
		webDriver.waitWithDriver(12000);
		
		// Asignacion de cobertura
		debugInfo("Cobertura seleccionada: " + webDriver.getTextInFrame(causasImportesTxt, cuerpoFrame));

		webDriver.clickInFrame(causasImportesBtn, cuerpoFrame);

		if(importe == null || importe.isEmpty()) {
			importe = "123";
		}

		debugInfo("Importe: " + importe);
		webDriver.clickInFrame(importe0Input, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.setTextInFrame(importe0Input, cuerpoFrame, importe);
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(actualizarImportePagoBtn, cuerpoFrame);

		if(activarPlanMAC) {
			webDriver.clickInFrame(activarPlanPagoBtn, cuerpoFrame);
			webDriver.waitWithDriver(8000);
		}
		
		webDriver.clickInFrame(continuar1Btn, cuerpoFrame);

		debugEnd();
		
		return this;
	}

	public PagosSiniestrosPage verificacion() {
		debugBegin();
		webDriver.waitWithDriver(9000);
		webDriver.clickInFrame(continuar1Btn, cuerpoFrame);
		debugEnd();
		
		return this;
	}

	public Boolean comprobarPagosPendientes() {
		debugBegin();
		
		webDriver.clickInFrame(accederPagosBtn, leftFrame);
		
		ActionSteps.waitForIt(webDriver);
		
		boolean check = false;
		
		if(webDriver.isClickableInFrame(listaPagosTxt, cuerpoFrame)) {
			List<WebElement> listaPagos = webDriver.getElementsInFrame(listaPagosTxt, cuerpoFrame);
			debugInfo("Contiene: " + listaPagos.size());

			for(int i = 0; i < listaPagos.size(); i++) {
				debugInfo("Estado: " + webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame));
				
				if(!webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame).equals("Pagado") 
					&& !webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame).equals("Anulado")) {
					check = true;
					debugInfo("Pagos Pendiente: " + check);
					break;
				}
			}
		} else {
			debugInfo("No hay pagos");
		}

		debugEnd();
		
		return check;
	}

	public PagosSiniestrosPage desbloquearPago() {
		debugBegin();
		
		debugInfo("Comprobamos el estado del pago... ");

		if(webDriver.getTextInFrame(avisosInfoTxt, cuerpoFrame).contains("Reconsiderado")) {
			debugInfo("Siniestro ya reconsiderado");
			new GestionSiniestrosPage(userS)
				.clickLogo();
			
			return this;
		}
		
		debugInfo("El esado actual del pago es: " + webDriver.getTextInFrame(infoSituacionPagoListaTxt, cuerpoFrame));
		if(webDriver.getTextInFrame(infoEstadoPagoListaTxt, cuerpoFrame).contains("Pendiente de Autorización")) {
			debugError("Error: Pago ya desbloqueado");
			new GestionSiniestrosPage(userS)
				.clickLogo();
			
			return this;
		}

		debugInfo("Procedemos a desbloquear pago");
		webDriver.clickInFrame(infoAccionesPagoListaBtn, cuerpoFrame);
		webDriver.clickInFrame(infoAccionesDesbloquearBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(desbloquearCuentaValidadaBtn, capaIframe);
		webDriver.clickInFrame(desbloquearGrabarBtn, capaIframe);
		webDriver.waitWithDriver(3000);

		if(webDriver.getText(infoEstadoPagoListaTxt).contains("Pendiente de Autorización")) {
			debugInfo("Pago desbloqueado");
		} else {
			debugError("Error: el pago no se ha podido despbloquear.");
		}

		debugEnd();
		
		return this;
	}

	public PagosSiniestrosPage emitirPlanPagosMAC(String fechaPlanPrimerPago, String fechaActivacion, String importePrimerPagoPlan) {
		debugBegin();

		webDriver.waitWithDriver(2000);
		// TODO Comprobar, si siempre se le asigna un valor, no hace falta pedir un parametro
		fechaPlanPrimerPago = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		fechaActivacion = DateUtils.getTodayDate(Constants.DATE_FORMAT);

		webDriver.appendTextInFrame(planFPrimerPagoInput, cuerpoFrame, fechaPlanPrimerPago);
		webDriver.appendTextInFrame(planFActivacionInput, cuerpoFrame, fechaActivacion);
		webDriver.appendTextInFrame(planImportePrimerPagoInput, cuerpoFrame, importePrimerPagoPlan);

		webDriver.clickInFrame(generarPlanBtn, cuerpoFrame);

		webDriver.waitWithDriver(2000);

		// Método para probar que se ha generado
		if(webDriver.isPresentInFrame(tablaPagosTxt, cuerpoFrame) 
			&& webDriver.getTextInFrame(tablaPagosTxt, cuerpoFrame).contains("120")) {
			debugInfo("Si está presente el importe de primer pago");
		} else {
			debugInfo("NO está presente el importe del primer pago");
		}
		
		webDriver.clickInFrame(continuar1Btn, cuerpoFrame);

		debugEnd();
		
		return this;
	}

	public PagosSiniestrosPage comprobarPlanPagosMac() {
		debugBegin();
		
		webDriver.waitWithDriver(4000);

		if(!webDriver.getTextInFrame(msjConfirmarPrimerPagoTxt, cuerpoFrame).contains("120,00")) {
			debugInfo("El importe del primer pago no coincide con el establecido de 120€");
		}

		webDriver.clickInFrame(volverListaPagosBtn, cuerpoFrame);

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(desplegarCarpetasBtn, cuerpoFrame);

		String ppagoTabla = webDriver.getTextInFrame(primerPagoTablaTxt, cuerpoFrame).trim();

		boolean checkPlanPagoTabla = ppagoTabla.contains("120,00€");
		Assert.assertTrue(checkPlanPagoTabla, "COMPARAR CAMPOS : El primer pago se lista en la tabla de pagos");

		debugEnd();
		
		return this;
	}

	// endregion
}
