package com.amaris.project.pages.administracion.siniestros.apertura;

import com.amaris.project.Constants;
import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class ModificarSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By modificar = By.cssSelector("#jt3");

	// Buscador
	private By numeroSiniestroBtn = By.cssSelector("#filtro1");
	private By numeroPolizaBtn = By.cssSelector("#filtro2");
	private By numeroReciboBtn = By.cssSelector("#filtro3");
	private By aseguradoBtn = By.cssSelector("#filtro4");
	private By fechaOcurrenciaBtn = By.cssSelector("#filtro6");
	private By fechaAltaBtn = By.cssSelector("#filtro7");
	private By causaBtn = By.cssSelector("#filtro8");
	private By otrosBtn = By.cssSelector("#filtro9");

	// Opcion Numero Siniestro
	private By tipoProductoSiniDrpDwn = By.cssSelector("#prodsini");
	private By anyoInput = By.cssSelector("#seriesin");
	private By numeroSiniestroInput = By.cssSelector("#numesini");

	// Opcion Numero Poliza
	private By tipoProductoPolizaDrpDwn = By.cssSelector("#producto");
	private By numeroPolizaInput = By.cssSelector("#polizsec");

	// Opcion Numero recibo
	private By numeroRecibo1Input = By.cssSelector("#recibann");
	private By numeroRecibo2Input = By.cssSelector("#recibsec");

	// Opcion Asegurado
	private By numeroDocumentoInput = By.cssSelector("#numedocu");
	private By nombreInput = By.cssSelector("#nombpcom");
	private By empiezaBtn = By.cssSelector("#nombpcom");
	private By contieneBtn = By.cssSelector("#contiene");

	// Opcion fecha ocurrencia
	private By fechaDesdeInput = By.cssSelector("#desde");
	private By fechaHastaInput = By.cssSelector("#hasta");

	// Opcion fecha alta
	private By fechaAltaDesdeInput = By.cssSelector("#altadesde");
	private By fechaAltaHastaInput = By.cssSelector("#altahasta");

	// Opcion tipo causa
	private By fechaCausaDesdeInput = By.cssSelector("#fechDesde");
	private By fechaCausaHastaInput = By.cssSelector("#fechHasta");
	private By codigoCausaInput = By.cssSelector("#name4");

	// Opcion Otros
	private By fechaOtrosDesdeInput = By.cssSelector("#fdesde");
	private By fechaOtrosHastaInput = By.cssSelector("#fhasta");
	private By estadoPolizaDrpDwn = By.cssSelector("#estado");
	private By negocio = By.cssSelector("#productoSini");
	private By mediadorInput = By.cssSelector("#codMediador");

	private By buscarBtn = By.cssSelector("#botonBuscar");

	private By continuarBtn = By.cssSelector("#capaAjax tr.odd span");

	// Declaracion
	private By consultPoliza = By.cssSelector("#enlacePoliza");
	private By anotacion = By.cssSelector("#enlaceDialogo");
	private By nuevaPerson = By.cssSelector("#enlaceDatContacPer");

	private By fechaOcurre = By.cssSelector("#fechsini");
	private By tipoDecla = By.cssSelector("#tipodecl");
	private By medioDecla = By.cssSelector("#mododecl");
	private By fechaRegis = By.cssSelector("#FECHREGI");
	private By fechaDenun = By.cssSelector("#FECHDENU");
	private By nombre = By.cssSelector("#nombpers");
	private By apellido = By.cssSelector("#ape1pers");
	private By telefono = By.cssSelector("#telefono1");
	private By email = By.cssSelector("#mail");
	private By noEmail = By.cssSelector("#emailnodisp");
	private By mediadorExter = By.cssSelector("#nombdato_REFEEXTR_1");
	private By carpetaSi = By.cssSelector("#fisicoSi");
	private By carpetaNo = By.cssSelector("#fisicoNo");
	private By modifiPerso = By.cssSelector("span.si-edit-02");
	private By eliminar = By.cssSelector("span.si-close-03");
	private By continuar = By.cssSelector("#botonContinuar");
	private By rol = By.cssSelector("#rol");
	private By nombreModi = By.cssSelector("#nombre");
	private By apelliModi = By.cssSelector("#apellido1");
	private By documento = By.cssSelector("#numedocu");
	private By telefonoModi = By.cssSelector("#telefono1");
	private By persAsegurado = By.cssSelector("div.sis-col-80 input");
	private By grabar = By.cssSelector("#buttonRecord");
	private By cancelar = By.cssSelector("#buttonCancel");

	// consulta poliza
	private By recibos = By.cssSelector("#pesRecibos");
	private By coberturas = By.cssSelector("#pesCoberturas");
	private By siniestro = By.cssSelector("#pesSiniestros");
	private By situaciones = By.cssSelector("#pesSituaciones");
	private By aseguradores = By.cssSelector("#pesAsegurados");
	private By clasula = By.cssSelector("#pesClausulas");

	// anotacion
	private By nuevaAnota = By.cssSelector("#cabApunteDialogo0");
	private By titulo = By.cssSelector("#titulo");
	private By comentario = By.cssSelector("#comentario");
	private By confidencial = By.cssSelector("div.sis-col-100 select");
	private By grabarAnota = By.cssSelector("#botonContinuar2");

	// nueva persona contacto
	private By nuevaPers = By.cssSelector("#enlaceDatContacPer");

	// ocurrencia
	private By lugarOcurren = By.cssSelector("#listaLugares");
	private By grupoCausa = By.cssSelector("#GRUCAUSA");
	private By tipoCausa = By.cssSelector("#TIPOCAUS");
	private By reserva = By.cssSelector("#RESEINIC");
	private By descrip = By.cssSelector("#version");
	private By implicadoSi = By.cssSelector("#implicadosSi");
	private By implicadoNo = By.cssSelector("#implicadosNo");
	private By encargoSi = By.cssSelector("#encargoSi");
	private By encargoNo = By.cssSelector("#encargoNo");
	private By renta = By.cssSelector("#nombdato_RENTA_1");
	private By suministro = By.cssSelector("#nombdato_SUMMI_1");
	private By guardar = By.cssSelector("#botonGuardar");

	// implicado asegurado
	private By asegurado = By.cssSelector("#seleccionAsegurado");
	private By nombreAsegura = By.cssSelector("#seleccionAsegurado");
	private By tipoDocu = By.cssSelector("#tipodocu");
	private By noDocu = By.cssSelector("#numedocu");

	// PF manual
	private By pf = By.cssSelector("#botonOPF > span");

	public ModificarSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public ModificarSiniestrosPage buscarPorNumeroPoliza(String numPoliza, String negocio) {
		debugBegin();

		webDriver.clickInFrame(numeroPolizaBtn, cuerpoFrame);
		
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPolizaDrpDwn, cuerpoFrame, "value", "510");
		}
		
		webDriver.appendTextInFrame(numeroPolizaInput, cuerpoFrame, numPoliza);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorNumeroSiniestro(String siniestro, int index, String anio, String negocio) {
		debugBegin();

		webDriver.clickInFrame(numeroSiniestroBtn, cuerpoFrame);
		
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoSiniDrpDwn, cuerpoFrame, "value", "510");
		}
		
		webDriver.appendTextInFrame(anyoInput, cuerpoFrame, anio);
		webDriver.appendTextInFrame(numeroSiniestroInput, cuerpoFrame, siniestro);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorRecibo(String recibo1, String recibo2) {
		debugBegin();

		webDriver.clickInFrame(numeroReciboBtn, cuerpoFrame);
		webDriver.appendTextInFrame(numeroRecibo1Input, cuerpoFrame, recibo1);
		webDriver.appendTextInFrame(numeroRecibo2Input, cuerpoFrame, recibo2);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorAsegurado(String asegurador, String opNombre, String nombre, String documento) {
		debugBegin();

		webDriver.clickInFrame(aseguradoBtn, cuerpoFrame);
		webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, documento);
		
		if(opNombre == "contiene") {
			webDriver.clickInFrame(contieneBtn, cuerpoFrame);
		} else {
			webDriver.clickInFrame(empiezaBtn, cuerpoFrame);
		}
		
		webDriver.appendTextInFrame(nombreInput, cuerpoFrame, nombre);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorOcurrencia(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(fechaOcurrenciaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaHastaInput, cuerpoFrame, fHasta);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorAlta(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(fechaAltaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaAltaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaAltaHastaInput, cuerpoFrame, fHasta);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorCausa(String fDesde, String fHasta, String nombre) {
		debugBegin();

		webDriver.clickInFrame(causaBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaCausaDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaCausaHastaInput, cuerpoFrame, fHasta);
		webDriver.appendTextInFrame(codigoCausaInput, cuerpoFrame, nombre);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorOtros(String fDesde, String fHasta, String codMediador, String negocio) {
		debugBegin();

		webDriver.clickInFrame(otrosBtn, cuerpoFrame);
		webDriver.appendTextInFrame(fechaOtrosDesdeInput, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaOtrosHastaInput, cuerpoFrame, fHasta);
		
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPolizaDrpDwn, cuerpoFrame, "value", "510");
		}
		
		webDriver.clickElementFromDropDownByAttributeInFrame(estadoPolizaDrpDwn, cuerpoFrame, "value", "V");
		webDriver.appendTextInFrame(mediadorInput, cuerpoFrame, codMediador);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

}