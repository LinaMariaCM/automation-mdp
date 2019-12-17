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
	private By btnNoSiniestro = By.cssSelector("#filtro1");
	private By btnNoPoliza = By.cssSelector("#filtro2");
	private By btnNoRecibo = By.cssSelector("#filtro3");
	private By btnAsegurado = By.cssSelector("#filtro4");
	private By btnFechaOcurrencia = By.cssSelector("#filtro6");
	private By btnFechaAlta = By.cssSelector("#filtro7");
	private By btnCausa = By.cssSelector("#filtro8");
	private By btnOtros = By.cssSelector("#filtro9");

	// Opcion Numero Siniestro
	private By tipoProductoSini = By.cssSelector("#prodsini");
	private By txtAno = By.cssSelector("#seriesin");
	private By txtNoSiniestro = By.cssSelector("#numesini");

	// Opcion Numero Poliza
	private By tipoProductoPoliza = By.cssSelector("#producto");
	private By txtNoPoliza = By.cssSelector("#polizsec");

	// Opcion Numero recibo
	private By txtNoRecibo1 = By.cssSelector("#recibann");
	private By txtNoRecibo2 = By.cssSelector("#recibsec");

	// Opcion Asegurado
	private By txtNodocumento = By.cssSelector("#numedocu");
	private By txtNombre = By.cssSelector("#nombpcom");
	private By btnEmpieza = By.cssSelector("#nombpcom");
	private By btnContiene = By.cssSelector("#contiene");

	// Opcion fecha ocurrencia
	private By fechaDesde = By.cssSelector("#desde");
	private By fechaHasta = By.cssSelector("#hasta");

	// Opcion fecha alta
	private By fechaAltaDesde = By.cssSelector("#altadesde");
	private By fechaAltaHasta = By.cssSelector("#altahasta");

	// Opcion tipo causa
	private By fechaCausaDesde = By.cssSelector("#fechDesde");
	private By fechaCausaHasta = By.cssSelector("#fechHasta");
	private By codigoCausa = By.cssSelector("#name4");

	// Opcion Otros
	private By fechaOtrosDesde = By.cssSelector("#fdesde");
	private By fechaOtrosHasta = By.cssSelector("#fhasta");
	private By estadoPoliza = By.cssSelector("#estado");
	private By negocio = By.cssSelector("#productoSini");
	private By mediador = By.cssSelector("#codMediador");

	private By btnBuscar = By.cssSelector("#botonBuscar");

	private By btnContinuar = By.cssSelector("#capaAjax tr.odd span");

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

		webDriver.clickInFrame(btnNoPoliza, cuerpoFrame);
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza, cuerpoFrame, "value", "510");
		}
		webDriver.appendTextInFrame(txtNoPoliza, cuerpoFrame, numPoliza);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorNumeroSiniestro(String siniestro, int index, String anio, String negocio) {
		debugBegin();

		webDriver.clickInFrame(btnNoSiniestro, cuerpoFrame);
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoSini, cuerpoFrame, "value", "510");
		}
		webDriver.appendTextInFrame(txtAno, cuerpoFrame, anio);
		webDriver.appendTextInFrame(txtNoSiniestro, cuerpoFrame, siniestro);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorRecibo(String recibo1, String recibo2) {
		debugBegin();

		webDriver.clickInFrame(btnNoRecibo, cuerpoFrame);
		webDriver.appendTextInFrame(txtNoRecibo1, cuerpoFrame, recibo1);
		webDriver.appendTextInFrame(txtNoRecibo2, cuerpoFrame, recibo2);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorAsegurado(String asegurador, String opNombre, String nombre, String documento) {
		debugBegin();

		webDriver.clickInFrame(btnAsegurado, cuerpoFrame);
		webDriver.appendTextInFrame(txtNodocumento, cuerpoFrame, documento);
		if(opNombre == "contiene") {
			webDriver.clickInFrame(btnContiene, cuerpoFrame);
		} else {
			webDriver.clickInFrame(btnEmpieza, cuerpoFrame);
		}
		webDriver.appendTextInFrame(txtNombre, cuerpoFrame, nombre);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorOcurrencia(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(btnFechaOcurrencia, cuerpoFrame);
		webDriver.appendTextInFrame(fechaDesde, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaHasta, cuerpoFrame, fHasta);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorAlta(String fDesde, String fHasta) {
		debugBegin();

		webDriver.clickInFrame(btnFechaAlta, cuerpoFrame);
		webDriver.appendTextInFrame(fechaAltaDesde, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaAltaHasta, cuerpoFrame, fHasta);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorCausa(String fDesde, String fHasta, String nombre) {
		debugBegin();

		webDriver.clickInFrame(btnCausa, cuerpoFrame);
		webDriver.appendTextInFrame(fechaCausaDesde, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaCausaHasta, cuerpoFrame, fHasta);
		webDriver.appendTextInFrame(codigoCausa, cuerpoFrame, nombre);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ModificarSiniestrosPage buscarPorOtros(String fDesde, String fHasta, String codMediador, String negocio) {
		debugBegin();

		webDriver.clickInFrame(btnOtros, cuerpoFrame);
		webDriver.appendTextInFrame(fechaOtrosDesde, cuerpoFrame, fDesde);
		webDriver.appendTextInFrame(fechaOtrosHasta, cuerpoFrame, fHasta);
		if(negocio.equals(Constants.MEC)) {
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoProductoPoliza, cuerpoFrame, "value", "510");
		}
		webDriver.clickElementFromDropDownByAttributeInFrame(estadoPoliza, cuerpoFrame, "value", "V");
		webDriver.appendTextInFrame(mediador, cuerpoFrame, codMediador);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

}