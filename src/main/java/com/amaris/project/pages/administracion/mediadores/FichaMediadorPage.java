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

	// region webelements

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By tituloPaginaTxt = By.cssSelector("body.sis-body > h1.titulopagina");
	private By buscadorMediadoresBtn = By.linkText(("Buscador mediadores").trim());

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
	private By rechazarAltaBtn = By.cssSelector("[onclick*='operacion=RECHMEDI]");
	private By solicitarMasInformacionBtn = By.cssSelector("[onclick*='operacion=SOLIINFOINIC]");
	private By confirmarAltaBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
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
	private By activarMediadorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(3) > a");
	private By fEnvioContratoInput = By.cssSelector("#GESMED_FENVCONT");
	private By fRecepcionContratoInput = By.cssSelector("#GESMED_FRECCONT");
	private By solicitarBajaBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(3) > a");
	private By grabarEstadoBtn = By.cssSelector("#buttonRecord");
	private By volverBtn = By.cssSelector("#Submit");
	private By cancelarBtn = By.cssSelector("#buttonCancel");

	private By altaOficinaBtn = By.cssSelector("[onclick*='CODIACCI=ALTAOFIC']");
	private By altaColaboradorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By solicitarMantenimientoBtn = By.cssSelector("[onclick*='operacion=SOLIMANT']");

	//------------- Contenido del encabezado -------------

	private By nivelJerarquicoTxt = By.cssSelector("#capaCab .marcofnd.wideBox .wideBox td");
	private By tipoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By tipoColaboradorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td");
	private By ejecutivoComercialTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By oficinaPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By mediadorPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");
	private By estadoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td");
	private By situacionMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td");

	//------------- Contenido Pestañas -------------

	// Pestaña Visión Global
	private By nombreFiscalVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By actividadPrincipalVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(4) > td:nth-child(2)");
	private By idiomaVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(6) > td:nth-child(2)");
	private By contactoResponsableVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(1)");
	private By cargoResponsableVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(2)");
	private By especialistaRamoVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(1) > td:nth-child(1)");
	private By administraFincasVGlobal = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(2) > td");

	// Pestaña Info descriptiva
	private By consultarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By importarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By subirLogoMedBtn = By.cssSelector("#cabNuevoDoc");
	private By nombreComercialDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td");
	private By nombreFiscalDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td");
	private By actividadPrincipalDescr = By
		.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(5) > td:nth-child(2)");
	private By idiomaDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(5) > td:nth-child(4)");
	private By nDGSDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(3) > td:nth-child(2)");
	private By sexoDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(6) > td");
	private By softwareDescr = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-der > table > tbody > tr > td > table > tbody > tr:nth-child(8) > td");

	// Pestaña Info contacto
	private By modificarMedContactoBtn = By.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(1) > td > a");
	private By contactoResponsableContacto = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By cargoResponsableContacto = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By telefonoPrincipal = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(5) > td:nth-child(1)");
	private By emailPrincipal = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(6) > td");

	// Pestaña Info relacional
	private By modificarMedRelacioBtn = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(1) > td > a");
	private By especialistaRamoRelacional = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By administraFincasRelacional = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");
	private By companiasTrabajado = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td");
	private By nombreBanco = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2");
	private By comentarioSituaciones = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");

	// Pestaña Condiciones de negocio
	private By ibanComisiones = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(3)");
	private By ibanAutoliquidaciones = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(4)");

	private By modificarMedCondiciNegBtn = By.cssSelector("#capaAjax > table > tbody > tr > td > a");
	private By cuadroComisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div.titulo > a");
	private By buscarArbolComiInput = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(2) > th:nth-child(2)");
	//private By grabarArbolComiBtn = By.cssSelector("#buttonRecord");
	private By cancelarArbolComiBtn = By.cssSelector("#buttonCancel");

	private By cuadroSubcomisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(3) > div.titulo > a");
	private By fechaIniAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHINI");
	private By fechaVenciAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHFIN");

	private By arbolInput = By.cssSelector("#criterio");
	private By buscarArbolSubcomiBtn = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(9) > td:nth-child(3) > input");

	// Pestaña Info CCM
	private By periodoCredito = By.cssSelector("#capaAjax > div.marco.fondo > table.wideBox > tbody > tr:nth-child(4) > td:nth-child(2)");
	private By limiteCredito = By.cssSelector("#capaAjax > div.marco.fondo > table.wideBox > tbody > tr:nth-child(5) > td:nth-child(4)");
	private By periodoCreditoCombo = By.cssSelector("#ALTAMEDI_PERCREDI");
	private By periodoCreditoOption = By.cssSelector("#ALTAMEDI_PERCREDI > option");
	private By limiteCreditoCombo = By.cssSelector("#ALTAMEDI_LIMCREDI");
	private By limiteCreditoOption = By.cssSelector("#ALTAMEDI_LIMCREDI > option");

	// Pestaña Info DGS
	private By fechaInicioContrato = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(8) > td > table > tbody > tr > td");
	private By nombreRepresentaLegal = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");
	private By apellidoRepresentaLegal = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(1)");
	private By altoCargoRazonSocial = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By altoCargoProfesion = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(6)");
	private By altoCargoEstadoCombo = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(8)");

	// Pestaña Contactos
	private By anyadirNuevoContacBtn = By.cssSelector("#cabMedioContacto");
	private By fechaDescendenteBtn = By.cssSelector("#descendenteContactos");
	private By fechaAscendenteBtn = By.cssSelector("#ascendenteContactos");
	private By listaDirecciones = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr");

	// Control de pagina
	private By guardarSalirBtn = By.cssSelector("#botonGrabar1");

	// Pestaña Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");
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

	// endregion

	public FichaMediadorPage(UserStory userS) {
		super(userS);
	}

	// region methods

	// ---- Acceder a las pestañas de la ficha

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

	public FichaMediadorPage clickModifMedInfoRelacional() {
		debugBegin();
		webDriver.clickInFrame(modificarMedRelacioBtn, cuerpoFrame);
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

	// ---- Más acciones + Estados + Situaciones

	public FichaMediadorPage clickMasAcciones() {
		debugBegin();
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

	public FichaMediadorPage verificarCampoJerarquia() {
		debugBegin();

		String nivelJerarquico = (webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).trim());
		System.out.println(nivelJerarquico);

		boolean checkNivelJerarquico = nivelJerarquico.equals("<strong>Nivel Jerárquico </strong>" + getTestVar(Constants.NIVEL_ESTRUCTURA));

		//	boolean checkNivelJerarquico = nivelJerarquico.equals("Nivel Jerárquico Colaborador");
		Assert.assertTrue(checkNivelJerarquico, "Comparar campos: el nivel de estructura coincide");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarCampoNombreComercial() {
		debugBegin();

		clickInfoDescriptiva();

		String nombreComercial = (webDriver.getTextInFrame(nombreComercialDescr, cuerpoFrame).trim());
		System.out.println(nombreComercial);

		boolean checkNombreComercial = nombreComercial.equals("ANTIVIST");
		Assert.assertTrue(checkNombreComercial, "Comparar campos: el nombre comercial coincide");

		debugEnd();
		return this;
	}

	// ---- ACCIONES SOBRE FICHA

	public FichaMediadorPage clickAnyadirNuevoContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoContacBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public FichaMediadorPage verificarDireccion() {
		debugBegin();

		clickInfoContacto();

		List<WebElement> obtenerListaDirecciones = webDriver.getElementsInFrame(listaDirecciones, cuerpoFrame);
		debugInfo("contiene " + obtenerListaDirecciones.size() + " direcciones");

		for(int i = 1; i < obtenerListaDirecciones.size(); i++) {

			String obtenerTipoDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(" + (i + 1)
					+ ") > td:nth-child(2)"), cuerpoFrame).trim();
			debugInfo("El tipo de dirección es: " + obtenerTipoDireccion);

			String obtenerDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(" + (i
					+ 1)
					+ ") > td:nth-child(3)"), cuerpoFrame).trim();
			debugInfo("El contenido de la dirección es: " + obtenerDireccion);

			if(obtenerTipoDireccion.equalsIgnoreCase("Fiscal")) {
				boolean checkDireccionFiscal = obtenerDireccion.equalsIgnoreCase("BELLREGUARD 32 (46710) DAIMUS - Valencia");
				debugInfo("Comprobamos la dirección fiscal, el resultado es: " + checkDireccionFiscal);
				Assert.assertTrue(checkDireccionFiscal, "Comparar campos: la dirección Fiscal NO coincide");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Comercial")) {
				boolean checkDireccionComercial = obtenerDireccion.equalsIgnoreCase("(mismo domicilio que fiscal) BELLREGUARD 32 (46710) DAIMUS - Valencia");
				debugInfo("Comprobamos la dirección comercial, el resultado es: " + checkDireccionComercial);
				Assert.assertTrue(checkDireccionComercial, "Comparar campos: la dirección Comercial NO coincide");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal producción")) {
				boolean checkDireccionProduccion = obtenerDireccion.equalsIgnoreCase("(mismo domicilio que fiscal) BELLREGUARD 32 (46710) DAIMUS - Valencia");
				debugInfo("Comprobamos la dirección de producción, el resultado es: " + checkDireccionProduccion);
				Assert.assertTrue(checkDireccionProduccion, "Comparar campos: la dirección Postal producción NO coincide");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal siniestros")) {
				boolean checkDireccionSiniestros = obtenerDireccion.equalsIgnoreCase("(mismo domicilio que fiscal) BELLREGUARD 32 (46710) DAIMUS - Valencia");
				debugInfo("Comprobamos la dirección de siniestros, el resultado es: " + checkDireccionSiniestros);
				Assert.assertTrue(checkDireccionSiniestros, "Comparar campos: la dirección Postal siniestros NO coincide");
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal recibos")) {
				boolean checkDireccionRecibos = obtenerDireccion.equalsIgnoreCase("(mismo domicilio que fiscal) BELLREGUARD 32 (46710) DAIMUS - Valencia");
				debugInfo("Comprobamos la dirección de recibos, el resultado es: " + checkDireccionRecibos);
				Assert.assertTrue(checkDireccionRecibos, "Comparar campos: la dirección Postal recibos NO coincide");
			}

		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage obtenerDatoAltaIntermediario() {
		debugBegin();
		webDriver.waitWithDriver(4000);
		webDriver.waitForElementToBePresentInFrame(tituloPaginaTxt, cuerpoFrame);
		String datoAlta = webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame);
		debugInfo("El mediador dado de alta es " + datoAlta);
		debugEnd();
		return this;
	}

	//---------------------ESTADOS + SITUACIONES MÉTODOS------------------------------

	//COMPROBAR TEXTO DE ESTADO
	public boolean comprobarEstado(String estado) {
		debugBegin();
		webDriver.waitWithDriver(3000);
	//	String estadoAlta = webDriver.getTextInFrame(By.cssSelector("<strong>Estado </strong>") + estadoMediadorTxt, cuerpoFrame).trim();
		String estadoAlta = webDriver.getTextInFrame(estadoMediadorTxt, cuerpoFrame).trim();
		boolean checkEstado = estadoAlta.equalsIgnoreCase(estado);

		debugInfo("Mensaje esperado:" + estado);
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

		debugInfo("Mensaje esperado:" + situacion);
		debugInfo("Mensaje real: " + situacionAlta);

		debugEnd();

		return checkSituacion;
	}

	//ALERTA SOBRE LA FECHA DE FORMACION
	public boolean alertaSistemaFechaFormacion(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String fechaFormacion = webDriver.getTextInFrame(fFormObligatoriaTxt, modalFrame).trim();
		boolean checkFecha = fechaFormacion.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + fechaFormacion);

		debugEnd();

		return checkFecha;
	}

	//ALERTA SOBRE PERDIODO DE CREDITO
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

		debugInfo("Mensaje esperado:" + mensaje);
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

		if(!getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") || getTestVar(Constants.TIPO_MEDIADOR) != null
			|| !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

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

			debugInfo("Solicitar alta se hizo con éxito o por lo menos recorrió");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarValoracionFinanciera() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

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

			debugInfo("Enviar para valoración financiera se hizo con éxito o por lo menos recorrió");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarRevisionFinanciera() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

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

			debugInfo("Enviar para revisión financiera se hizo con éxito o por lo menos recorrió");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage obtenerIdMediador() {
		debugBegin();
		webDriver.waitWithDriver(6000);

		if(webDriver.isPresentInFrame(tituloPaginaTxt, cuerpoFrame)) {
			debugInfo("Mensaje correcto: " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim());
			//		setScenarioVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString()); pentdiente por borrar esta línea

			setTestVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
			//con esta lina se obtiene el id para guardarlo en esta misma prueba

			debugInfo("El id del mediador dado de alta es " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
			
			if(getTestVar(Constants.NIVEL_ESTRUCTURA).contains("INTE")){
				setTestVar((Constants.ID_INTERMEDIARIO_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Intermediario obtenido");
			}
			else if(getTestVar(Constants.NIVEL_ESTRUCTURA).contains("OFI")){
				setTestVar((Constants.ID_OFICINA_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Oficina obtenido");
			}
			else if(getTestVar(Constants.NIVEL_ESTRUCTURA).contains("COLAB")){
				setTestVar((Constants.ID_COLABORADOR_AE), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de Colaborador obtenido");
			}
			else{
				setTestVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
				debugInfo("Código de mediador obtenido");
			}
			
			setSuiteVar(("cod_mediador_trans"), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
			// en esta línea se guarda para reutilizararlo en otra

			debugInfo("El mediador del campo  ID_MEDIADOR_ALTA es " + getSuiteVar(Constants.ID_MEDIADOR_ALTA));
		} else {
			debugInfo("Ha habido un error al dat de alta el mediador");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarResolucionFinanciera() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

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

			debugInfo("Enviar para resolución financiera se hizo con éxito o por lo menos recorrió");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage confirmarAlta() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

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

			debugInfo("Confirmar alta se hizo con éxito o por lo menos recorrió");

		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AUXI") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("GEST") || getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD") ||
			getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {

			comprobarSituacion(SOLICITUD_ALTA);

			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_REVISION_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();

			anyadirComentarioSituacion();
			grabarComentarioEstado();
			debugInfo("Confirmar alta se hizo con éxito o por lo menos recorrió");

		}

		debugEnd();

		return this;
	}

	public FichaMediadorPage formacionAvanzarEstado() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") ||
			getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty() || getTestVar(Constants.TIPO_COLABORADOR) != null || !getTestVar(Constants.TIPO_COLABORADOR)
			.isEmpty()) {

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

			debugInfo("Avanzar estado se hizo con éxito o por lo menos recorrió");
		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage activarMediadorEstado() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") ||
			getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty() ||
			getTestVar(Constants.TIPO_COLABORADOR) != null || !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {

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

			debugInfo("Activar Mediador se hizo con éxito o por lo menos recorrió");
		}
		debugEnd();
		return this;
	}

	// falta ver para ver mediadores
	public FichaMediadorPage solicitarBaja() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST") ||
			getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty() ||
			getTestVar(Constants.TIPO_COLABORADOR) != null || !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {

			Assert.assertTrue(comprobarEstado(ACTIVO), "El estado no es correcto.");

			clickMasAcciones();
			clickSolicitarBaja();
			webDriver.waitWithDriver(3000);

			Assert.assertTrue(alertaCambioSituacion(Constants.ALERTA_CAMBIO_SITUACION_BAJA_MEDIADORES));
			grabarComentarioEstado();

			debugInfo("Solicitar Baja se hizo con éxito o por lo menos recorrió");
		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage comprobarEstadoActivo(){
		debugBegin();
		webDriver.waitWithDriver(4000);
		Assert.assertTrue(comprobarEstado(ACTIVO), "El estado no es correcto.");
		debugEnd();
		return this;
	}

	// METODO PARA HACER COMPROBACIONES EN FICHA
	public FichaMediadorPage comprobacionFicha() {
		debugBegin();
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") || getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			|| !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {

			webDriver.waitWithDriver(8000);
			String nivelJerarquicoInte = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

			boolean intermediarioInte = getTestVar(Constants.NIVEL_ESTRUCTURA).equals(MediadoresConstantesFicha.INTE) &&
				nivelJerarquicoInte.equals("Intermediario");

			Assert.assertTrue(intermediarioInte, "Es incorrecto.");

		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") || getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			|| !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {

			webDriver.waitWithDriver(9000);
			String nivelJerarquicoOfic = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

			boolean intermediarioOfic = getTestVar(Constants.NIVEL_ESTRUCTURA).equals(MediadoresConstantesFicha.OFIC) &&
				nivelJerarquicoOfic.equals("Oficina");

			Assert.assertTrue(intermediarioOfic, "Es incorrecto.");

		} else if (getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") || getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			|| !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {

			webDriver.waitWithDriver(8000);
			String nivelJerarquicoCola = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

			boolean intermediarioCola = getTestVar(Constants.NIVEL_ESTRUCTURA).equals(MediadoresConstantesFicha.COLA) &&
				nivelJerarquicoCola.equals("Colaborador");

			Assert.assertTrue(intermediarioCola, "Es incorrecto.");
		}

		debugEnd();
		return this;
	}

	// endregion
}
