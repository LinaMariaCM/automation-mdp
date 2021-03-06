package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Calendar;
import java.util.List;

public class FichaMediadorPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");

	private By tituloPaginaTxt = By.cssSelector("body.sis-body > h1.titulopagina");
	private By buscadorMediadoresBtn = By.linkText(("Buscador mediadores").trim());
	private By fichaMediadorBtn = By.cssSelector("#jt1son > a[title='Ficha mediador  ']");
	private By agendaMediadorBtn = By.cssSelector("#jt4");

	//------------- Botones Pestañas -------------

	private By visionGlobalBtn = By.linkText(("Vision Global").trim());
	private By infoDescriptivaBtn = By.linkText(("Info Descriptiva").trim());
	private By infoContactoBtn = By.linkText(("Info Contacto").trim());
	private By infoRelacionalBtn = By.linkText(("Info Relacional").trim());
	private By infoTransaccionalBtn = By.linkText(("Info Transaccional").trim());
	private By condicionesNegocioBtn = By.linkText(("Condiciones de negocio").trim());
	private By infoHistoricaBtn = By.linkText(("Info Histórica").trim());
	private By infoCCMBtn = By.linkText(("Info CCM").trim());
	private By infoDGSBtn = By.linkText(("Info DGS").trim());
	private By contactosBtn = By.cssSelector("[onclick*='subSecci=SEC_CONTACTOS']");
	private By situacionesBtn = By.cssSelector("[onclick*='subSecci=SEC_SITUACIONES']");
	private By cambiosBtn = By.cssSelector("[onclick*='subSecci=SEC_CAMBIOS']");
	private By anotacionesBtn = By.cssSelector("[onclick*='subSecci=SEC_ANOTACIONES']");

	//------------- Botones en "Más acciones" -------------

	private By masAccionesBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > a > span");
	private By convertirAffinityBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By iniciarAltamediadorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(2) > a");
	private By solicitarAltaBtn = By.cssSelector("[onclick*='operacion=SOLIALTA']");
	private By comentarioSituacionInput = By.cssSelector("body.modalContenido > #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td > textarea");
	private By observacionComercialInput = By.cssSelector("#GESMED_OBSECOME");
	private By comentarioResolFinancInput = By.cssSelector("body.modalContenido > #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table.narrowBox > tbody > tr:nth-child(2) > td > textarea");
	private By rechazarAltaBtn = By.cssSelector("[onclick*='operacion=RECHMEDI']");
	private By solicitarMasInformacionBtn = By.cssSelector("[onclick*='operacion=SOLIINFOINIC']");
	//private By confirmarAltaBtn = By.cssSelector("[onclick*='operacion=CONFALTAINIC']");
	private By confirmarAltaBtn = By.linkText(("Confirmar alta").trim());
	private By enviaValoraFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVVALFI']");
	//private By enviaRevisionFinancieraBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	//#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(2) > a
	//lanzarAccion('ACCSMEDFICH', '121820', 'TDSERV0004I&servicio=GESTMEDI&operacion=ENVREVFI&codicombo=ACCSMEDFICH&swinidat=S~SWIFRAME=S~SWVENTANA=N~ALTODFRAME=400~ANCHODFRAME=750~SWPREGUNTA=N~PREGUNTA=~TITULO=Enviar para revision financiera~CODIACCI=MEREVFIN~SWTXUDT=N'); return false;
	private By enviaRevisionFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVREVFI']");
	private By enviaResolucionFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVRESFI']");
	private By enviaResolucionFinancieraCombo = By.cssSelector("#GESMED_REVFVALO");
	private By enviaResolucionFinancieraOption = By.cssSelector("#GESMED_REVFVALO > option");
	private By enviaResolucionFinancieraAltaCombo = By.cssSelector("#GESMED_RESFVALO");
	private By enviaResolucionFinancieraAltaOption = By.cssSelector("#GESMED_RESFVALO > option");
	private By enviaResolucionFinancieraInput = By.cssSelector("#GESMED_REVFCOME");
	private By avanzarEstadoBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(2) > a");
	private By fFormObligatoriaTxt = By.cssSelector("body > table.wideBox > tbody > tr > td > p > strong");
	private By fFormObligatoriaInput = By.cssSelector("#GESMED_FFOROBLIG");
	private By periodoCreditoTxt = By.cssSelector("body > table.wideBox > tbody > tr > td > p > strong");
	private By activarMediadorBtn = By.cssSelector("[onclick*='CODIACCI=ACTIMEDI']");
	private By fEnvioContratoInput = By.cssSelector("#GESMED_FENVCONT");
	private By fRecepcionContratoInput = By.cssSelector("#GESMED_FRECCONT");
	private By solicitarBajaBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(3) > a");
	private By grabarEstadoBtn = By.cssSelector("#buttonRecord");
	private By volverBtn = By.cssSelector("#Submit");
	private By cancelarBtn = By.cssSelector("#buttonCancel");

	private By altaOficinaBtn = By.cssSelector("[onclick*='CODIACCI=ALTAOFIC']");
	private By altaColaboradorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By solicitarMantenimientoBtn = By.cssSelector("[onclick*='operacion=SOLIMANT']");

	//------------- Contenido del encabezado y texto-------------

	private By nivelJerarquicoTxt = By.cssSelector("#capaCab .marcofnd.wideBox .wideBox td");
	private By tipoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By tipoProspectTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By tipoColaboradorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td");
	private By ejecutivoComercialTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By oficinaPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By mediadorPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");
	private By estadoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td");
	private By situacionMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td");

	//-----------------Texto de alta prospect encabezado------------
	private By actividadPrincipalProspectTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(4) > td");
	private By direccionProspectTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(10) > td:nth-child(1)");
	private By poblacionProspectTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(11) > td:nth-child(1)");
	private By provinciaProspectTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(11) > td:nth-child(2)");

	//------------- Contenido Pestañas -------------

	// Pestaña Visión Global
	private By nombreFiscalTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By idiomaMediadorTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(6) > td:nth-child(2)");
	private By nombreContactoRespTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(1)");
	private By cargoContactoRespTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(2)");

	// Pestaña Info descriptiva
	private By actividadPrincipalTxt = By
		.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(5) > td:nth-child(2)");
	private By nombreComercialTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td");
	private By sexoTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(6) > td");
	private By disponeSoftwareTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-der > table > tbody > tr > td > table > tbody > tr:nth-child(8) > td");

	// Pestaña Info contacto
	private By telefonoPrincipalTxt = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(5) > td:nth-child(1)");
	private By emailPrincipalTxt = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(6) > td");

	// Pestaña Info relacional
	private By ramoMediadorTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By cuantasFincasTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By companyiasPrincipTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td");
	private By nombreBancoTxt = By
		.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)");

	// Pestaña Condiciones de negocio
	private By ibanPagoComisionesTxt = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(3)");
	private By ibanRecibosAutoliqTxt = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(4)");
	private By modificarMedCondiciNegBtn = By.cssSelector("#capaAjax > table > tbody > tr > td > a");
	private By cuadroComisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div.titulo > a");
	private By buscarArbolComiInput = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(2) > th:nth-child(2)");
	private By cancelarArbolComiBtn = By.cssSelector("#buttonCancel");

	private By cuadroSubcomisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(3) > div.titulo > a");
	private By fechaIniAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHINI");
	private By fechaVenciAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHFIN");

	private By arbolInput = By.cssSelector("#criterio");
	private By buscarArbolSubcomiBtn = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(9) > td:nth-child(3) > input");

	// Pestaña Info CCM
	private By periodoCreditoFichaTxt = By.cssSelector("#capaAjax > div.marco.fondo > table.wideBox > tbody > tr:nth-child(4) > td:nth-child(2)");
	private By limiteCreditoFichaTxt = By.cssSelector("#capaAjax > div.marco.fondo > table.wideBox > tbody > tr:nth-child(5) > td:nth-child(4)");
	private By periodoCreditoCombo = By.cssSelector("#ALTAMEDI_PERCREDI");
	private By periodoCreditoOption = By.cssSelector("#ALTAMEDI_PERCREDI > option");
	private By limiteCreditoCombo = By.cssSelector("#ALTAMEDI_LIMCREDI");
	private By limiteCreditoOption = By.cssSelector("#ALTAMEDI_LIMCREDI > option");

	// Pestaña Info DGS
	private By fechaInicioContratoTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(8) > td > table > tbody > tr > td");
	private By nombreRepresentaLegalTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");
	private By apellidoRepresentaLegalTxt = By
		.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(1)");
	private By altoCargoRazonSocialTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By altoCargoProfesionTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(6)");
	private By altoCargoEstadoCombo = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(8)");
	private By altoCargoEstadoOption = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(8) > option");

	// Pestaña Contactos
	private By listaDirecciones = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr");

	// Control de pagina
	private By guardarSalirBtn = By.cssSelector("#botonGrabar1");

	// Pestaña Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");
	private By situacionCambiosOption = By.cssSelector("#situacion > option");
	private By cambioSituacionTxt = By.cssSelector("#formDatos > div.contentBox.anchuraCajas > div.marcofnd > p");

	//----------------Constantes SITUACIONES-----------------------------//
	private static final String RESOLUCION_FINANCIERA = "Situación Resolución financiera";
	private static final String ALTA_MEDIADOR = "Situación Alta mediador";
	private static final String SOLICITUD_ALTA = "Situación Solicitud de alta";
	private static final String INFORMACION_FINANCIERA = "Situación Solicitud información financiera";
	private static final String REVISION_FINANCIERA = "Situación Revisión financiera";

	//--------------- Constantes ESTADOS------------------//
	private static final String EN_TRAMITACION = "Estado En tramitación";
	private static final String FORMACION = "Estado Formación";
	private static final String ACTIVO_RESTRINGIDO = "Estado Activo restringido";
	private static final String ACTIVO = "Estado Activo";
	private static final String PENDIENTE_ENVIO_DGS = "Estado Pendiente envio DGS";

	public FichaMediadorPage(UserStory userS) {
		super(userS);
	}

	// ---- Acceder a las pestañas de la ficha-------------

	public FichaMediadorPage clickBuscadorMediadores() {
		debugBegin();
		webDriver.clickInFrame(buscadorMediadoresBtn, menuFrame);
		debugInfo("Se hizo clic en el buscador de mediadores desde la ficha");
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickVisionGlobal() {
		debugBegin();
		webDriver.clickInFrame(visionGlobalBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoDescriptiva() {
		debugBegin();
		webDriver.clickInFrame(infoDescriptivaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoContacto() {
		debugBegin();
		webDriver.clickInFrame(infoContactoBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoRelacional() {
		debugBegin();
		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(infoRelacionalBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoTransaccional() {
		debugBegin();
		webDriver.clickInFrame(infoTransaccionalBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickCondicionesNegocio() {
		debugBegin();
		webDriver.clickInFrame(condicionesNegocioBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoCCM() {
		debugBegin();
		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(infoCCMBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoDGS() {
		debugBegin();
		webDriver.clickInFrame(infoDGSBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickAgendaMediadorProspect() {
		debugBegin();

		webDriver.clickInFrame(agendaMediadorBtn, menuFrame);

		debugEnd();
		return this;
	}

	// ---- Más acciones + Estados + Situaciones
	public FichaMediadorPage clickMasAcciones() {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(masAccionesBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickSolicitarBaja() {
		debugBegin();
		webDriver.clickInFrame(solicitarBajaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickSolicitarAlta() {
		debugBegin();
		webDriver.clickInFrame(solicitarAltaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickSolicitarAltaOficina() {
		debugBegin();
		webDriver.clickInFrame(altaOficinaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickSolicitarAltaColaborador() {
		debugBegin();
		webDriver.clickInFrame(altaColaboradorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickConfirmarAlta() {
		debugBegin();
		webDriver.clickInFrame(confirmarAltaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarValFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaValoraFinancieraBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarRevisionFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaRevisionFinancieraBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarResolucionFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaResolucionFinancieraBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickAvanzarEstado() {
		debugBegin();
		webDriver.clickInFrame(avanzarEstadoBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickActivarMediador() {
		debugBegin();
		webDriver.clickInFrame(activarMediadorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirComentarioSituacion() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(comentarioSituacionInput, modalFrame, "Comentario para añadir en el Pop up cuando se solicita cambio de estado o situación del mediador");
		webDriver.waitWithDriver(3000);

		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirObservacionComercial() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(observacionComercialInput, modalFrame, "Comentario para añadir");
		webDriver.waitWithDriver(3000);

		debugEnd();
		return this;
	}

	public FichaMediadorPage comentarioResolucionFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(enviaResolucionFinancieraInput, modalFrame, "Comentario para añadir en el Pop up cuando se envía el resultado de la Resolución financiera");
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage comentarioResolFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(comentarioResolFinancInput, modalFrame, "Comentario para añadir.");
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaFormOblig() {
		debugBegin();
		String datoFechaFormOblig = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fFormObligatoriaInput, modalFrame, datoFechaFormOblig);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaEnvioContrato() {
		debugBegin();
		String datoFechaEnvioContrato = DateUtils.getModifiedDate(Calendar.DATE, -3, Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fEnvioContratoInput, modalFrame, datoFechaEnvioContrato);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaRecepcionContratoAntesEnvio() {
		debugBegin();
		String datoFechaRecepContrato = DateUtils.getModifiedDate(Calendar.DATE, -7, Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fRecepcionContratoInput, modalFrame, datoFechaRecepContrato);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaRecepcionContrato() {
		debugBegin();
		String datoFechaRecepcionContrato = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fRecepcionContratoInput, modalFrame, datoFechaRecepcionContrato);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage grabarComentarioEstado() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarEstadoBtn, modalFrame);
		webDriver.waitWithDriver(5000);
		debugEnd();
		return this;
	}

	// ----------------------------------------------- MÉTODOS COMPLEJOS -----------------------------------------------
	public String getContenidoTituloPagina() {
		debugBegin();
		String contenido = webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame);
		debugEnd();

		return contenido;
	}

	//---------------------ESTADOS + SITUACIONES MÉTODOS------------------------------

	//COMPROBAR TEXTO DE ESTADO
	public boolean comprobarEstado(String estado) {
		debugBegin();
		webDriver.waitWithDriver(6000);

		String estadoAlta = webDriver.getTextInFrame(estadoMediadorTxt, cuerpoFrame).trim();
		boolean checkEstado = estadoAlta.equalsIgnoreCase(estado);

		debugInfo("Mensaje esperado: " + estado);
		debugInfo("Mensaje real: " + estadoAlta);

		debugEnd();

		return checkEstado;
	}

	//COMPROBAR TEXTO DE SITUACIÓN
	public boolean comprobarSituacion(String situacion) {
		debugBegin();
		webDriver.waitWithDriver(3000);
		String situacionAlta = webDriver.getTextInFrame(situacionMediadorTxt, cuerpoFrame).trim();
		boolean checkSituacion = situacionAlta.equalsIgnoreCase(situacion);

		debugInfo("Mensaje esperado: " + situacion);
		debugInfo("Mensaje real: " + situacionAlta);

		debugEnd();

		return checkSituacion;
	}

	//ALERTA SOBRE LA FECHA DE FORMACION
	public boolean alertaSistemaFechaFormacion(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.waitWithDriver(3000);
		String fechaFormacion = webDriver.getTextInFrame(fFormObligatoriaTxt, modalFrame).trim();
		boolean checkFecha = fechaFormacion.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + fechaFormacion);

		debugEnd();

		return checkFecha;
	}

	//ALERTA SOBRE PERIODO DE CREDITO
	public boolean alertaSistemaPeriodoLimiteCredito(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String peridoCredito = webDriver.getTextInFrame(periodoCreditoTxt, modalFrame).trim();
		boolean checkPeriodo = peridoCredito.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + peridoCredito);

		debugEnd();

		return checkPeriodo;
	}

	//ALERTA SOBRE CAMBIO DE SITUACION PARA DAR DE BAJA
	public boolean alertaCambioSituacion(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String cambioSituacion = webDriver.getTextInFrame(cambioSituacionTxt, modalFrame).trim();
		boolean checkCambio = cambioSituacion.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + cambioSituacion);

		debugEnd();

		return checkCambio;
	}

	//RELLENAR LA PARTE DE PERIODO DE CREDITO
	public FichaMediadorPage anyadirPeriodoCredito() {
		debugBegin();
		clickMasAcciones();
		clickInfoCCM();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(modificarMedCondiciNegBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttributeInFrame(periodoCreditoCombo, periodoCreditoOption, cuerpoFrame, "value", "45");
		webDriver.clickInFrame(guardarSalirBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	//RELLENAR LA PARTE DE LIMITE DE CREDITO
	public FichaMediadorPage anyadirLimiteCredito() {
		debugBegin();
		clickMasAcciones();
		clickInfoCCM();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(modificarMedCondiciNegBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttributeInFrame(limiteCreditoCombo, limiteCreditoOption, cuerpoFrame, "value", "ESPE");
		webDriver.clickInFrame(guardarSalirBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirDatosResolucionFinanciera() {
		debugBegin();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_VALORACION_REVISION_FINANCIERA_MEDIADORES);
		webDriver.acceptAlert();
		webDriver.waitWithDriver(3000);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, enviaResolucionFinancieraOption, modalFrame, "value", "ALAC");

		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_REVISION_FINANCIERA_MEDIADORES);
		webDriver.acceptAlert();

		debugEnd();
		return this;
	}

	//------------------EMPIEZAN ESTADOS--------------------------

	public FichaMediadorPage solicitarAlta() {
		debugBegin();
		debugInfo("Se entra para solicitar Alta de Oficina.");

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");
		Assert.assertTrue(comprobarSituacion(ALTA_MEDIADOR), "La situacion no es correcta.");

		webDriver.waitWithDriver(3000);
		clickMasAcciones();
		clickSolicitarAlta();
		webDriver.waitWithDriver(3000);

		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_ADICIONAL_MEDIADORES);
		webDriver.acceptAlert();

		anyadirComentarioSituacion();
		grabarComentarioEstado();

		debugInfo("Solicitar Alta se hizo con éxito o por lo menos recorrió.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarValoracionFinanciera() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");
		Assert.assertTrue(comprobarSituacion(SOLICITUD_ALTA), "La situacion no es correcta.");

		clickMasAcciones();
		clickEnviarValFinanciera();
		webDriver.waitWithDriver(3000);

		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_OBSERVACION_COMERCIAL_MEDIADORES);
		webDriver.acceptAlert();

		anyadirObservacionComercial();
		grabarComentarioEstado();

		debugInfo("Enviar para Valoración Financiera se hizo con éxito o por lo menos recorrió.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarRevisionFinanciera() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");
		Assert.assertTrue(comprobarSituacion(INFORMACION_FINANCIERA), "La situacion no es correcta.");

		clickMasAcciones();
		clickEnviarRevisionFinanciera();
		webDriver.waitWithDriver(3000);

		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_ADICIONAL_MEDIADORES);
		webDriver.acceptAlert();

		anyadirComentarioSituacion();
		grabarComentarioEstado();

		debugInfo("Enviar para Revisión Financiera se hizo con éxito o por lo menos recorrió.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage obtenerIdMediador() {
		debugBegin();
		webDriver.waitWithDriver(6000);

		if(webDriver.isPresentInFrame(tituloPaginaTxt, cuerpoFrame)) {
			debugInfo("Mensaje correcto: " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim());

			setTestVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());

			debugInfo("El id del mediador dado de alta es " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());

			if(getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE).contains("TRUE")) {
				setTestVar((Constants.ID_ALTA_INTERMEDIARIO_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Intermediario obtenido " + getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE));
			} else if(getTestVar(Constants.ID_ALTA_OFICINA_AE).contains("TRUE")) {
				setTestVar((Constants.ID_ALTA_OFICINA_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Oficina obtenido");
			} else if(getTestVar(Constants.ID_ALTA_COLABORADOR_AE).contains("TRUE")) {
				setTestVar((Constants.ID_ALTA_COLABORADOR_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Colaborador obtenido");
			} else {
				setTestVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de mediador obtenido");
			}

		} else {
			debugInfo("Ha habido un error al dar de Alta el Mediador.");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarResolucionFinanciera() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");
		Assert.assertTrue(comprobarSituacion(REVISION_FINANCIERA), "La situacion no es correcta.");

		clickMasAcciones();
		clickEnviarResolucionFinanciera();
		webDriver.waitWithDriver(3000);

		grabarComentarioEstado();

		anyadirDatosResolucionFinanciera();
		comentarioResolucionFinanciera();
		grabarComentarioEstado();

		Assert.assertTrue(alertaSistemaPeriodoLimiteCredito(Constants.ALERTA_PERIODO_CREDITO_MEDIADORES));
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(volverBtn);
		webDriver.click(cancelarBtn);
		webDriver.exitFrame();

		anyadirPeriodoCredito();

		clickMasAcciones();
		clickEnviarResolucionFinanciera();
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, enviaResolucionFinancieraOption, modalFrame, "value", "ALAC");
		comentarioResolucionFinanciera();
		grabarComentarioEstado();

		Assert.assertTrue(alertaSistemaPeriodoLimiteCredito(Constants.ALERTA_LIMITE_CREDITO_MEDIADORES));
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(volverBtn);
		webDriver.click(cancelarBtn);
		webDriver.exitFrame();

		anyadirLimiteCredito();

		clickMasAcciones();
		clickEnviarResolucionFinanciera();
		webDriver.waitWithDriver(3000);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, enviaResolucionFinancieraOption, modalFrame, "value", "ALAC");

		comentarioResolucionFinanciera();
		grabarComentarioEstado();

		debugInfo("Enviar para Resolución Financiera se hizo con éxito o por lo menos recorrió.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage confirmarAlta() {
		debugBegin();

		if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE")
			|| getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV")
			|| getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE")
			|| getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV")
			|| getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR")) {

			Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");

			comprobarSituacion(RESOLUCION_FINANCIERA);

			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_VALORACION_RESOLUCION_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();
			webDriver.waitWithDriver(5000);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraAltaCombo, enviaResolucionFinancieraAltaOption, modalFrame, "value", "ALAC");

			grabarComentarioEstado();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_RESOLUCION_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();
			webDriver.waitWithDriver(3000);

			anyadirComentarioSituacion();
			grabarComentarioEstado();

			debugInfo("Confirmar Alta se hizo con éxito o por lo menos recorrió.");

		} else if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			|| getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")
			|| getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			|| getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD")) {

			Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");

			comprobarSituacion(SOLICITUD_ALTA);

			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_OBSERVACION_REVISION_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();

			anyadirComentarioSituacion();
			grabarComentarioEstado();
			debugInfo("Confirmar Alta se hizo con éxito o por lo menos recorrió.");

		} else if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") && getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD")) {

			Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");

			comprobarSituacion(ALTA_MEDIADOR);

			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_ADICIONAL_MEDIADORES);
			webDriver.acceptAlert();

			anyadirComentarioSituacion();
			grabarComentarioEstado();
			debugInfo("Confirmar Alta se hizo con éxito o por lo menos recorrió.");

		}

		debugEnd();

		return this;
	}

	public FichaMediadorPage formacionAvanzarEstado() {
		debugBegin();

		if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") ||
			getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			Assert.assertTrue(comprobarEstado(FORMACION), "El estado no es correcto.");

			clickMasAcciones();
			clickAvanzarEstado();
			grabarComentarioEstado();

			Assert.assertTrue(alertaSistemaFechaFormacion(Constants.ALERTA_FECHA_MEDIADORES));
			webDriver.waitWithDriver(3000);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.click(volverBtn);
			webDriver.waitWithDriver(3000);
			webDriver.setText(fFormObligatoriaInput, "fecha");
			webDriver.click(grabarEstadoBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_MEDIADORES_INCORRECTA);
			webDriver.acceptAlert();
			webDriver.waitWithDriver(5000);

			webDriver.exitFrame();

			anyadirFechaFormOblig();
			grabarComentarioEstado();

			Assert.assertTrue(comprobarEstado(PENDIENTE_ENVIO_DGS), "El estado no es correcto.");

			debugInfo("Avanzar Estado se hizo con éxito o por lo menos recorrió.");
		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage activarMediadorEstado() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(ACTIVO_RESTRINGIDO), "El estado no es correcto.");

		clickMasAcciones();
		clickActivarMediador();
		webDriver.waitWithDriver(3000);
		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ACTIVAR_MEDIADORES);
		webDriver.acceptAlert();
		webDriver.waitWithDriver(3000);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(fEnvioContratoInput, "fecha");
		webDriver.click(grabarEstadoBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ACTIVAR_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();

		anyadirFechaEnvioContrato();
		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ACTIVAR_MEDIADORES);
		webDriver.acceptAlert();
		webDriver.waitWithDriver(3000);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(fRecepcionContratoInput, "fecha");
		webDriver.click(grabarEstadoBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ACTIVAR_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.exitFrame();

		anyadirFechaRecepcionContratoAntesEnvio();
		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_ENVIO_CONTRATO_SUPERIOR_MEDIADORES);
		webDriver.acceptAlert();

		anyadirFechaRecepcionContrato();
		grabarComentarioEstado();

		debugInfo("Activar Mediador se hizo con éxito o por lo menos recorrió.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage solicitarBaja() {
		debugBegin();

		if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") ||
			getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") ||
			getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") ||
			getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

			Assert.assertTrue(comprobarEstado(ACTIVO), "El estado no es correcto.");

			clickMasAcciones();
			clickSolicitarBaja();
			webDriver.waitWithDriver(3000);

			Assert.assertTrue(alertaCambioSituacion(Constants.ALERTA_CAMBIO_SITUACION_BAJA_MEDIADORES));
			grabarComentarioEstado();

			debugInfo("Solicitar Baja se hizo con éxito o por lo menos recorrió.");
		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage comprobarEstadoActivo() {
		debugBegin();
		webDriver.waitWithDriver(4000);
		Assert.assertTrue(comprobarEstado(ACTIVO), "El estado no es correcto.");
		debugEnd();
		return this;
	}

	//---------------METODOS PARA HACER VERIFICACIONES EN FICHA------------------------------------

	public FichaMediadorPage verificarNivelEstructura(String constanteFicha, String nivelJerarquico) {

		debugBegin();

		String nivelJerarquicoInte = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

		boolean intermediarioInte = getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase(constanteFicha) &&
			nivelJerarquicoInte.equalsIgnoreCase(nivelJerarquico);

		Assert.assertTrue(intermediarioInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Nivel de Estructura.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarNivelEstructuraProspect(String nivelJerarquico) {

		debugBegin();

		String nivelJerarquicoInte = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

		boolean intermediarioInte = nivelJerarquicoInte.equalsIgnoreCase(nivelJerarquico);

		Assert.assertTrue(intermediarioInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Nivel de Estructura Prospect.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTipoMediador(String constanteFicha, String tipoMed) {

		debugBegin();

		String tipoMediador = webDriver.getTextInFrame(tipoMediadorTxt, cuerpoFrame).substring(16).trim();

		boolean tipoMediadorInte = getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase(constanteFicha) &&
			tipoMediador.equalsIgnoreCase(tipoMed);

		Assert.assertTrue(tipoMediadorInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Tipo de Mediador.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTipoProspect(String tipoProspect) {

		debugBegin();

		String tipoProspectMed = webDriver.getTextInFrame(tipoProspectTxt, cuerpoFrame).substring(16).trim();

		boolean tipoProspecInte = tipoProspectMed.equalsIgnoreCase(tipoProspect);

		Assert.assertTrue(tipoProspecInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Tipo de Prospect.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTipoColaborador(String constanteFicha, String tipoCol) {

		debugBegin();

		String tipoColaborador = webDriver.getTextInFrame(tipoColaboradorTxt, cuerpoFrame).substring(19).trim();

		boolean tipoColaboradorMediador = getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase(constanteFicha) &&
			tipoColaborador.equalsIgnoreCase(tipoCol);

		Assert.assertTrue(tipoColaboradorMediador, "Es incorrecto.");
		debugInfo("Se ha verificado el Tipo de Colaborador.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarEjecutivoComercial(String ejecutivoCome) {

		debugBegin();

		String ejecutivoComercial = webDriver.getTextInFrame(ejecutivoComercialTxt, cuerpoFrame).substring(19, 24).trim();

		boolean ejecutivoComercialMed = ejecutivoComercial.equalsIgnoreCase(ejecutivoCome);

		Assert.assertTrue(ejecutivoComercialMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Ejecutivo Comercial.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarIdioma(String constanteFicha, String idioma) {

		debugBegin();

		String idiomaMed = webDriver.getTextInFrame(idiomaMediadorTxt, cuerpoFrame).substring(7).trim();

		boolean idiomaMediador = getScenarioVar(Constants.IDIOMA).equalsIgnoreCase(constanteFicha) &&
			idiomaMed.equalsIgnoreCase(idioma);

		Assert.assertTrue(idiomaMediador, "Es incorrecto.");
		debugInfo("Se ha verificado el Idioma.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarIdiomaProspect(String idioma) {

		debugBegin();

		String idiomaMed = webDriver.getTextInFrame(idiomaMediadorTxt, cuerpoFrame).substring(7).trim();

		boolean idiomaMediador = idiomaMed.equalsIgnoreCase(idioma);

		Assert.assertTrue(idiomaMediador, "Es incorrecto.");
		debugInfo("Se ha verificado el Idioma Prospect.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarActividadPrincipal(String constanteFicha, String actividadPri) {

		debugBegin();

		String actividadPrinc = webDriver.getTextInFrame(actividadPrincipalTxt, cuerpoFrame).trim();
		boolean actividadPMed = getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase(constanteFicha) &&
			actividadPrinc.equalsIgnoreCase(actividadPri);

		Assert.assertTrue(actividadPMed, "Es incorrecto.");
		debugInfo("Se ha verificado la Actividad Principal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarActividadPrincipalProspect(String constanteFicha, String actividadPri) {

		debugBegin();

		String actividadPrinc = webDriver.getTextInFrame(actividadPrincipalProspectTxt, cuerpoFrame).substring(20).trim();

		boolean actividadPMed = getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase(constanteFicha) &&
			actividadPrinc.equalsIgnoreCase(actividadPri);

		Assert.assertTrue(actividadPMed, "Es incorrecto.");
		debugInfo("Se ha verificado la Actividad Principal Prospect.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarNombreComercial(String nombreComer) {

		debugBegin();

		String nombreComercial = webDriver.getTextInFrame(nombreComercialTxt, cuerpoFrame).trim();

		boolean nombreComMed = nombreComercial.equalsIgnoreCase(nombreComer);

		Assert.assertTrue(nombreComMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre Comercial.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarDisponeSoftware(String constanteFicha, String disponeSoftw) {

		debugBegin();

		String disponeSoftware = webDriver.getTextInFrame(disponeSoftwareTxt, cuerpoFrame).trim();

		boolean disponeSoftwareMed = getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase(constanteFicha) &&
			disponeSoftware.equalsIgnoreCase(disponeSoftw);

		Assert.assertTrue(disponeSoftwareMed, "Es incorrecto.");
		debugInfo("Se ha verificado la Disponibilidad de Software.");

		debugEnd();
		return this;
	}
	
	public FichaMediadorPage verificarNombres(String nombreFisc, String primeApell, String segApell) {

		debugBegin();

		String nombreCompleto = webDriver.getTextInFrame(nombreFiscalTxt, cuerpoFrame).substring(14).trim();

		debugInfo("El nombre completo tal como aparece en la ficha: " + nombreFisc + " " + primeApell + " " + segApell);
		debugInfo("El nombre completo tal como aparece en el CSV: " + getScenarioVar(Constants.NOMBRE_MEDIADOR) + " " + getScenarioVar(Constants.PRIMER_APELLIDO_MEDIADOR) + " "
			+ getScenarioVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));

		boolean checkNombresFiscales = nombreCompleto.equalsIgnoreCase(nombreFisc + " " + primeApell + " " + segApell);

		Assert.assertTrue(checkNombresFiscales, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre Completo Fiscal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarSoloNombreFiscal(String nombreFisc) {

		debugBegin();

		String nombreCompleto = webDriver.getTextInFrame(nombreFiscalTxt, cuerpoFrame).substring(14).trim();

		debugInfo("El nombre completo tal como aparece en la ficha: " + nombreFisc);
		debugInfo("El nombre completo tal como aparece en el CSV: " + getScenarioVar(Constants.NOMBRE_MEDIADOR));

		boolean checkNombresFiscales = nombreCompleto.equalsIgnoreCase(nombreFisc);

		Assert.assertTrue(checkNombresFiscales, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre Fiscal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarNombrePrimerApe(String nombreFisc, String primeApell) {

		debugBegin();

		String nombreCompleto = webDriver.getTextInFrame(nombreFiscalTxt, cuerpoFrame).substring(14).trim();

		debugInfo("El nombre completo tal como aparece en la ficha: " + nombreFisc + " " + primeApell);
		debugInfo("El nombre completo tal como aparece en el CSV: " + getScenarioVar(Constants.NOMBRE_MEDIADOR) + " " + getScenarioVar(Constants.PRIMER_APELLIDO_MEDIADOR));

		boolean checkNombresFiscales = nombreCompleto.equalsIgnoreCase(nombreFisc + " " + primeApell);

		Assert.assertTrue(checkNombresFiscales, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre y Primer apellido.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTelefonoPrincipal(String telefono) {

		debugBegin();

		String telefonPri = webDriver.getTextInFrame(telefonoPrincipalTxt, cuerpoFrame).substring(23).trim();

		boolean telefonPriMed = telefonPri.equalsIgnoreCase(telefono);

		Assert.assertTrue(telefonPriMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Telefono Principal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarEmailPrincipal(String email) {

		debugBegin();

		String emailPri = webDriver.getTextInFrame(emailPrincipalTxt, cuerpoFrame).substring(16).trim();

		boolean telefonPriMed = emailPri.equalsIgnoreCase(email);

		Assert.assertTrue(telefonPriMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Email Principal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarRamo(String constanteFicha, String ramoMediador) {
		debugBegin();

		String ramo = webDriver.getTextInFrame(ramoMediadorTxt, cuerpoFrame).substring(21).trim();

		boolean ramoMed = getScenarioVar(Constants.RAMO).equalsIgnoreCase(constanteFicha) &&
			ramo.equals(ramoMediador);

		Assert.assertTrue(ramoMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Ramo.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarAdministraFincasCuantas(String cuantas) {

		debugBegin();

		String cuantasFincas = webDriver.getTextInFrame(cuantasFincasTxt, cuerpoFrame).substring(10).trim();

		boolean cuantasFincasMed = cuantasFincas.equalsIgnoreCase(cuantas);

		Assert.assertTrue(cuantasFincasMed, "Es incorrecto.");
		debugInfo("Se ha verificado que Administra Fincas(cuántas admnistra).");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarNombreDelBanco(String banco) {

		debugBegin();

		String nomBanco = webDriver.getTextInFrame(nombreBancoTxt, cuerpoFrame).trim();

		boolean nomBancoMed = nomBanco.equalsIgnoreCase(banco);

		Assert.assertTrue(nomBancoMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre del Banco.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarCompanyiasPrincipales(String companyia) {
		debugBegin();

		String companyiasPrincip = webDriver.getTextInFrame(companyiasPrincipTxt, cuerpoFrame).substring(31).trim();

		boolean companyiasPrincipMed = companyiasPrincip.equals(companyia);

		Assert.assertTrue(companyiasPrincipMed, "Es incorrecto.");
		debugInfo("Se han verificado las Compañias Principales.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarOficinaPadre(String oficinaPadre) {
		debugBegin();

		int indexPadreInicial = webDriver.getTextInFrame(oficinaPadreTxt, cuerpoFrame).indexOf("-");
		String oficinaPadreMed = webDriver.getTextInFrame(oficinaPadreTxt, cuerpoFrame).substring(14, indexPadreInicial).trim();

		boolean oficinaMedResMed = oficinaPadreMed.equalsIgnoreCase(oficinaPadre);

		Assert.assertTrue(oficinaMedResMed, "Es incorrecto.");
		debugInfo("Se ha verificado Oficina Padre.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarMediadorPadre(String mediadorPadre) {
		debugBegin();

		int indexPadreInicial = webDriver.getTextInFrame(mediadorPadreTxt, cuerpoFrame).indexOf("-");
		String padreMed = webDriver.getTextInFrame(mediadorPadreTxt, cuerpoFrame).substring(15, indexPadreInicial).trim();

		boolean padreMedResMed = padreMed.equalsIgnoreCase(mediadorPadre);

		Assert.assertTrue(padreMedResMed, "Es incorrecto.");
		debugInfo("Se ha verificado Mediador Padre.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarContactoResponsable(String contacto) {
		debugBegin();

		String contactoRes = webDriver.getTextInFrame(nombreContactoRespTxt, cuerpoFrame).substring(7).trim();

		boolean contactoResMed = contactoRes.equalsIgnoreCase(contacto);

		Assert.assertTrue(contactoResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Contacto Responsable.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarCargoResponsable(String cargo) {
		debugBegin();

		String cargoRes = webDriver.getTextInFrame(cargoContactoRespTxt, cuerpoFrame).substring(6).trim();

		boolean cargoResMed = cargoRes.equalsIgnoreCase(cargo);

		Assert.assertTrue(cargoResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Cargo responsable.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarBancoComisiones(String banco) {
		debugBegin();

		String bancoCom = webDriver.getTextInFrame(ibanPagoComisionesTxt, cuerpoFrame).substring(20).trim();

		boolean bancoComMed = bancoCom.equalsIgnoreCase(banco);

		Assert.assertTrue(bancoComMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Banco de Comisiones.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarPagoAutoliquidaciones(String banco) {
		debugBegin();

		String bancoCom = webDriver.getTextInFrame(ibanRecibosAutoliqTxt, cuerpoFrame).substring(37).trim();

		boolean bancoComMed = bancoCom.equalsIgnoreCase(banco);

		Assert.assertTrue(bancoComMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Banco Pago de Autoliquidaciones.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarPeriodoCredito(String periodo) {
		debugBegin();

		String periodoMed = webDriver.getTextInFrame(periodoCreditoFichaTxt, cuerpoFrame).trim();

		debugInfo("El periodo que se pasa es " + periodo);
		debugInfo("El periodo que se coge de la ficha es " + periodoMed);
		boolean periodoCreditoMed = periodoMed.equalsIgnoreCase(periodo);

		Assert.assertTrue(periodoCreditoMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Periodo Credito.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarLimiteCredito(String limite) {
		debugBegin();

		String limiteMed = webDriver.getTextInFrame(limiteCreditoFichaTxt, cuerpoFrame).trim();

		boolean limiteCreditoMed = limiteMed.equalsIgnoreCase(limite);

		Assert.assertTrue(limiteCreditoMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Límite Credito.");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarDireccionesFicha() {
		debugBegin();

		List<WebElement> obtenerListaDirecciones = webDriver.getElementsInFrame(listaDirecciones, cuerpoFrame);
		debugInfo("contiene " + obtenerListaDirecciones.size() + " direcciones");

		for(int i = 1; i < obtenerListaDirecciones.size(); i++) {

			String obtenerTipoDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table "
					+ "> tbody > tr:nth-child(" + (i + 1) + ") > td:nth-child(2)"), cuerpoFrame).trim();
			debugInfo("El tipo de dirección es: " + obtenerTipoDireccion);

			String obtenerDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table "
					+ "> tbody > tr:nth-child(" + (i + 1) + ") > td:nth-child(3)"), cuerpoFrame).trim();

			if(obtenerTipoDireccion.equalsIgnoreCase("Fiscal")) {

				debugInfo("La direccion que recojo es " + obtenerDireccion);
				debugInfo("La direccion de nombre via es " + getScenarioVar(Constants.DIRECCION_FISC_NombreVia));
				boolean nombreViaMed = obtenerDireccion.contains(getScenarioVar(Constants.DIRECCION_FISC_NombreVia).toUpperCase());

				Assert.assertTrue(nombreViaMed, "Es incorrecto.");
				debugInfo("Se ha verificado la Direccion Fiscal.");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Comercial")) {
				boolean nombreViaMed = obtenerDireccion.contains(getScenarioVar(Constants.DIRECCION_COME_NombreVia).toUpperCase());

				debugInfo("La direccion que recojo es " + obtenerDireccion);
				debugInfo("La direccion de nombre via es " + getScenarioVar(Constants.DIRECCION_COME_NombreVia));
				Assert.assertTrue(nombreViaMed, "Es incorrecto.");
				debugInfo("Se ha verificado la Direccion Comercial.");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal producción")) {
				boolean nombreViaMed = obtenerDireccion.contains(getScenarioVar(Constants.DIRECCION_PPRO_NOMBRE_VIA).toUpperCase());

				debugInfo("La direccion que recojo es " + obtenerDireccion);
				debugInfo("La direccion de nombre via es " + getScenarioVar(Constants.DIRECCION_PPRO_NOMBRE_VIA));
				Assert.assertTrue(nombreViaMed, "Es incorrecto.");
				debugInfo("Se ha verificado la Direccion Postal Produccion.");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal recibos")) {
				boolean nombreViaMed = obtenerDireccion.contains(getScenarioVar(Constants.DIRECCION_PREC_NombreVia).toUpperCase());

				debugInfo("La direccion que recojo es " + obtenerDireccion);
				debugInfo("La direccion de nombre via es " + getScenarioVar(Constants.DIRECCION_PREC_NombreVia));
				Assert.assertTrue(nombreViaMed, "Es incorrecto.");
				debugInfo("Se ha verificado la Direccion Postal recibos.");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal siniestros")) {

				boolean nombreViaMed = obtenerDireccion.contains(getScenarioVar(Constants.DIRECCION_PSIN_NOMBRE_VIA).toUpperCase());

				debugInfo("La direccion que recojo es " + obtenerDireccion);
				debugInfo("La direccion de nombre via es " + getScenarioVar(Constants.DIRECCION_PSIN_NOMBRE_VIA));
				Assert.assertTrue(nombreViaMed, "Es incorrecto.");
				debugInfo("Se ha verificado la Direccion Postal siniestros.");
			}

		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage comprobacionFicha() {
		debugBegin();
		if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") || getScenarioVar(Constants.NIVEL_ESTRUCTURA) != null
			|| !getScenarioVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {

			//NIVEL ESTRUCTURA
			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				verificarNivelEstructura(MediadoresConstantesFicha.INTE, "Intermediario");
			} else if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {
				verificarNivelEstructura(MediadoresConstantesFicha.OFIC, "Oficina");
			} else if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {
				verificarNivelEstructura(MediadoresConstantesFicha.COLA, "Colaborador");
			}

			//TIPO DE MEDIADOR
			if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.AE, "Agente exclusivo");
			} else if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.AD, "Acuerdo colaboración");
			} else if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.AV, "Agente vinculado");
			} else if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.BSE, "BS exclusivo");
			} else if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.BSV, "BS vinculado");
			} else if(getScenarioVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") && getScenarioVar(Constants.TIPO_MEDIADOR) != null
				&& !getScenarioVar(Constants.TIPO_MEDIADOR).isEmpty()) {
				verificarTipoMediador(MediadoresConstantesFicha.CORR, "Corredor");
			}

			//OFICINA PADRE
			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && getScenarioVar(Constants.NIVEL_ESTRUCTURA) != null
				&& !getScenarioVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {
				verificarOficinaPadre(getTestVar(Constants.ID_ALTA_OFICINA_AE));
			}

			//MEDIADOR PADRE
			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") && getScenarioVar(Constants.NIVEL_ESTRUCTURA) != null
				&& !getScenarioVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {
				verificarMediadorPadre(getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE));
			}

			//TIPO DE COLABORADOR
			if(getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD") && getScenarioVar(Constants.TIPO_COLABORADOR) != null
				&& !getScenarioVar(Constants.TIPO_COLABORADOR).isEmpty()) {
				verificarTipoColaborador(MediadoresConstantesFicha.AD_COLABORADOR, "Acuerdo Distribución");
			} else if(getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") && getScenarioVar(Constants.TIPO_COLABORADOR) != null
				&& !getScenarioVar(Constants.TIPO_COLABORADOR).isEmpty()) {
				verificarTipoColaborador(MediadoresConstantesFicha.AUXI, "Auxiliar");
			} else if(getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST") && getScenarioVar(Constants.TIPO_COLABORADOR) != null
				&& !getScenarioVar(Constants.TIPO_COLABORADOR).isEmpty()) {
				verificarTipoColaborador(MediadoresConstantesFicha.GEST, "Gestor");
			}

			//EJECUTIVO COMERCIAL
			if(getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4000")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4001")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4003")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4005")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4007")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4010")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4011")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4015")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4016")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4019")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4023")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4024")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4027")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4056")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4067")
				|| getScenarioVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4069")) {

				verificarEjecutivoComercial(getScenarioVar(Constants.EJECUTIVO_COMERCIAL));
			}

			//IDIOMA
			if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("ESPA")) {
				verificarIdioma(MediadoresConstantesFicha.ESPA, "Castellano");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("CATA")) {
				verificarIdioma(MediadoresConstantesFicha.CATA, "Català");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("EUSK")) {
				verificarIdioma(MediadoresConstantesFicha.EUSK, "Euskara");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("ENGL")) {
				verificarIdioma(MediadoresConstantesFicha.ENGL, "English");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("FRAN")) {
				verificarIdioma(MediadoresConstantesFicha.FRAN, "Français");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("PRTG")) {
				verificarIdioma(MediadoresConstantesFicha.PRTG, "Português");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("DEUT")) {
				verificarIdioma(MediadoresConstantesFicha.DEUT, "Deutsch");
			} else if(getScenarioVar(Constants.IDIOMA).equalsIgnoreCase("GALE")) {
				verificarIdioma(MediadoresConstantesFicha.GALE, "Galego");
			}

			//NOMBRE, PRIMER APELLIDO Y SEGUNDO APELLIDO FISCALES COMPLETOS
			if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Sleepwalking")) {
				verificarNombres("Sleepwalking", "Bringme", "Thehorizon");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Orion")) {
				verificarNombres("Orion", "Cliff", "Burton");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Mario")) {
				verificarNombrePrimerApe("Mario", "Local");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("A7X")) {
				verificarNombrePrimerApe("A7X", "Exist");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Carol")) {
				verificarNombres("Carol", "Lopez", "Castillo");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Ghost Macabre")) {
				verificarSoloNombreFiscal("Ghost Macabre");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Looper")) {
				verificarNombres("Looper", "Bringme", "Thehorizon");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Pantera")) {
				verificarNombres("Pantera", "Shedding", "Skin");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Mariete")) {
				verificarSoloNombreFiscal("Mariete");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Loren")) {
				verificarSoloNombreFiscal("Loren");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Ozzy Osborne")) {
				verificarSoloNombreFiscal("Ozzy Osborne");
			} else if(getScenarioVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("In this moment")) {
				verificarNombrePrimerApe("In this moment", "Fighters");
			}

			//CONTACTO RESPONSABLE
			verificarContactoResponsable("Contacto Responsable");

			//CARGO RESPONSABLE
			verificarCargoResponsable("Cargo Responsable");

			clickInfoDescriptiva();

			//ACTIVIDAD PRINCIPAL
			if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("MESE")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.MESE, "Mediador de Seguros");
			} else if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("ADFI")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.ADFI, "Administrador de Fincas");
			} else if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("ABOG")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.ABOG, "Abogados");
			} else if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("OTRO")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.OTRO, "Otros");
			} else if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("API")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.API, "API");
			} else if(getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("GEPA")) {
				verificarActividadPrincipal(MediadoresConstantesFicha.GEPA, "Gestor Patrimonios");
			}

			//NOMBRE COMERCIAL
			if(getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med01")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med02")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med03")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med04")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med05")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med06")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med07")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med09")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med10")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med11")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med12")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med13")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med14")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med15")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med16")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med17")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med18")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med19")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med20")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med21")
				|| getScenarioVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med22")) {

				verificarNombreComercial(getScenarioVar(Constants.NOMBRE_COMERCIAL));
			}

			//DISPONE SOFTWARE
			if(getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase("TRUE")) {
				verificarDisponeSoftware(MediadoresConstantesFicha.DISPONE_SOFTWARE_SI, "Sí");
			} else if(getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase("FALSE")) {
				verificarDisponeSoftware(MediadoresConstantesFicha.DISPONE_SOFTWARE_NO, "No");
			}

			clickInfoContacto();

			verificarTelefonoPrincipal("666302010");
			verificarEmailPrincipal("mediador@email.com");

			//DIRECCIONES
			verificarDireccionesFicha();

			clickInfoRelacional();

			//RAMO
			if(getScenarioVar(Constants.RAMO).equalsIgnoreCase("10")) {
				verificarRamo(MediadoresConstantesFicha.ASISTENCIA, "Asistencia");
			}

			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {
				verificarAdministraFincasCuantas("30");
			}

			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {
				verificarNombreDelBanco("Nombre del banco");
			}
			//COMPAÑIAS PRINCIPALES
			if(getScenarioVar(Constants.COMPANYIAS_PRINCIPALES).equalsIgnoreCase("Compania principal abogado")) {
				verificarCompanyiasPrincipales(getScenarioVar(Constants.COMPANYIAS_PRINCIPALES).toUpperCase());
			}

			//BANCO COMISIONES
			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

				clickCondicionesNegocio();
				verificarBancoComisiones("ES0321001234561234567890");

			}
			//BANCO PAGO AUTOLIQUIDACIONES
			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

				verificarPagoAutoliquidaciones("ES0321001234561234567890");

			}
		}

		debugEnd();
		return this;
	}

	//COMPROBACION DE DIRECCIONES PROSPECT EN FICHA----------
	public FichaMediadorPage verificarDireccionesProspect(String direccion, String poblacion, String provincia) {

		debugBegin();

		//DIRECCION
		String direccionP = webDriver.getTextInFrame(direccionProspectTxt, cuerpoFrame).substring(10).trim();

		boolean direccionProsMed = direccionP.equalsIgnoreCase(direccion);

		Assert.assertTrue(direccionProsMed, "Es incorrecto.");
		debugInfo("Se ha verificado La Direccion Prospect.");

		//POBLACION
		String poblacionP = webDriver.getTextInFrame(poblacionProspectTxt, cuerpoFrame).substring(10).trim();

		boolean poblacionMed = poblacionP.equalsIgnoreCase(poblacion);

		Assert.assertTrue(poblacionMed, "Es incorrecto.");
		debugInfo("Se ha verificado La Población Prospect.");

		//PROVINCIA
		String provinciaP = webDriver.getTextInFrame(provinciaProspectTxt, cuerpoFrame).substring(10).trim();

		boolean provinciaMed = provinciaP.equalsIgnoreCase(provincia);

		Assert.assertTrue(provinciaMed, "Es incorrecto.");
		debugInfo("Se ha verificado La Provincia Prospect.");

		debugEnd();
		return this;
	}

	//COMPROBACINES EN FICHA DE ALTA PROSPECT
	public FichaMediadorPage comprobacionesFichaAltaProspect() {

		debugBegin();

		webDriver.waitWithDriver(5000);
		//NIVEL ESTRUCTURA PROSPECT
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			verificarNivelEstructuraProspect("Intermediario");
		}

		//TIPO PROSPECT
		if(getTestVar(Constants.TIPO_PROSPECT).equalsIgnoreCase("COBS") && getTestVar(Constants.TIPO_PROSPECT) != null
			&& !getTestVar(Constants.TIPO_PROSPECT).isEmpty()) {
			verificarTipoProspect("Corredor-BS");
		}

		//DIRECCIONES
		verificarDireccionesProspect(getTestVar(Constants.NOMBRE_VIA), getTestVar(Constants.POBLACION), getTestVar(Constants.PROVINCIA));

		//IDIOMA PROSPECT
		if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("ESPA")) {
			verificarIdiomaProspect("Castellano");
		}

		//CONTACTO RESPONSABLE PROSPECT
		verificarContactoResponsable("Contacto");

		//EJECUTIVO COMERCIAL PROSPECT
		if(getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4000")) {

			verificarEjecutivoComercial(getTestVar(Constants.EJECUTIVO_COMERCIAL));
		}

		//ACTIVIDAD PRINCIPAL PROSPECT
		if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("ABOG")) {
			verificarActividadPrincipalProspect(MediadoresConstantesFicha.ABOG, "Abogados");
		}

		clickInfoDescriptiva();

		//NOMBRE COMERCIAL PROSPECT
		if(getTestVar(Constants.NOMBRE_PROSPECT).equalsIgnoreCase("Nombre")) {

			verificarNombreComercial(getTestVar(Constants.NOMBRE_PROSPECT));
		}

		clickInfoContacto();

		//TELEFONO PRINCIPAL PROSPECT
		verificarTelefonoPrincipal("699999999");

		debugEnd();
		return this;
	}

}


