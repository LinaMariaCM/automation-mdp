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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FichaMediadorPage extends PageObject {

	// region webelements

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By tituloPaginaTxt = By.cssSelector("body.sis-body > h1.titulopagina");
	private By buscadorMediadoresBtn = By.linkText(("Buscador mediadores").trim());

	private By fichaMediadorBtn = By.id("jt2");

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
	//	private By confirmarAltaBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
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

	//------------- Contenido del encabezado y texto-------------

	private By nivelJerarquicoTxt = By.cssSelector("#capaCab .marcofnd.wideBox .wideBox td");
	private By tipoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By tipoColaboradorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td");
	private By ejecutivoComercialTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	private By oficinaPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td");
	private By mediadorPadreTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td");
	private By estadoMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td");
	private By situacionMediadorTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td");
	private By actividadPrincipalTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(4) > td:nth-child(2)");
	private By idiomaMediadorTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(6) > td:nth-child(2)");
	private By nombreContactoRespTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(1)");
	private By cargoContactoRespTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(2)");
	private By nombreComercialTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-izq > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(2) > td");
	private By disponeSoftwareTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td.tabla-der > table > tbody > tr > td > table > tbody > tr:nth-child(8) > td");
	private By nombreFiscalTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(1) > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(1)");
	private By telefonoPrincipalTxt = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(5) > td:nth-child(1)");
	private By emailPrincipalTxt = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > table > tbody > tr:nth-child(6) > td");
	private By ramoMediadorTxt = By.cssSelector("#capaAjax > table > tbody > tr > td:nth-child(2) > table:nth-child(3) > tbody > tr:nth-child(1) > td:nth-child(1)");
	private By companyiasPrincipTxt = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(3) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td");
	private By ibanPagoComisionesTxt = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(3)");
	private By ibanRecibosAutoliqTxt = By.cssSelector("#capaAjax > div:nth-child(7) > table > tbody > tr > td:nth-child(2) > p:nth-child(4)");

	private By direcionCPTxt = By
		.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(3)");

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

	public FichaMediadorPage clickFichaMediador() {
		debugBegin();
		webDriver.waitWithDriver(8000);
		if(!webDriver.isPresentInFrame(masAccionesBtn, cuerpoFrame)) {
			webDriver.clickInFrame(fichaMediadorBtn, menuFrame);
			webDriver.waitWithDriver(8000);
		}
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

	// -----------------ACCIONES SOBRE FICHA---------------------

	public FichaMediadorPage clickAnyadirNuevoContacto() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoContacBtn, cuerpoFrame);
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
		webDriver.waitWithDriver(6000);

		//	String estadoAlta = webDriver.getTextInFrame(By.cssSelector("<strong>Estado </strong>") + estadoMediadorTxt, cuerpoFrame).trim();

		clickFichaMediador();

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
		debugInfo("Se entra para solicitar alta de Oficina");

		//	if(getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
		// dentro del IF, comentado temporalmente por Antonia: !getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD")

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
		//	}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarValoracionFinanciera() {
		debugBegin();

	/*	if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {*/

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
		//	}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarRevisionFinanciera() {
		debugBegin();

	/*	if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {*/

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
		//	}

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
				debugInfo("Código de Intermediario obtenido" + getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE));
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

			//	setSuiteVar(("cod_mediador_trans"), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 6).toString());
			// en esta línea se guarda para reutilizararlo en otra

		} else {
			debugInfo("Ha habido un error al dat de alta el mediador");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarResolucionFinanciera() {
		debugBegin();

	/*	if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") || getTestVar(Constants.TIPO_MEDIADOR) != null || !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {*/

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
		//	}

		debugEnd();
		return this;
	}

	public FichaMediadorPage confirmarAlta() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE")
			|| getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV")
			|| getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE")
			|| getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV")
			|| getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR")) {

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

		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			|| getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")
			|| getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			|| getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD")) {

			Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");

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

		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") && getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD")) {

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
			debugInfo("Confirmar alta se hizo con éxito o por lo menos recorrió");

		} // último else if añadido por Antonia.

		debugEnd();

		return this;
	}

	public FichaMediadorPage formacionAvanzarEstado() {
		debugBegin();

		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

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

	/*	if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") ||
			getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") ||
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {*/

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
		//	}
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
			getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

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

	public FichaMediadorPage comprobarEstadoActivo() {
		debugBegin();
		webDriver.waitWithDriver(4000);
		Assert.assertTrue(comprobarEstado(ACTIVO), "El estado no es correcto.");
		debugEnd();
		return this;
	}

	//---------------METODOS PARA HACER COMPROBACIONES EN FICHA------------------------------------

	public FichaMediadorPage obtenerCodgioPostal() {

		debugBegin();

		int indexCPInicial = webDriver.getTextInFrame(direcionCPTxt, cuerpoFrame).indexOf("(");
		int indexCPFinal = webDriver.getTextInFrame(direcionCPTxt, cuerpoFrame).indexOf(")");
		String sacoCP = webDriver.getTextInFrame(direcionCPTxt, cuerpoFrame).substring(indexCPInicial, indexCPFinal).trim();

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarNivelEstructura(String constanteFicha, String nivelJerarquico) {

		debugBegin();

		String nivelJerarquicoInte = webDriver.getTextInFrame(nivelJerarquicoTxt, cuerpoFrame).substring(16).trim();

		boolean intermediarioInte = getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase(constanteFicha) &&
			nivelJerarquicoInte.equalsIgnoreCase(nivelJerarquico);

		Assert.assertTrue(intermediarioInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Nivel de Estructura.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTipoMediador(String constanteFicha, String tipoMed) {

		debugBegin();

		String tipoMediador = webDriver.getTextInFrame(tipoMediadorTxt, cuerpoFrame).substring(16).trim();

		boolean tipoMediadorInte = getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase(constanteFicha) &&
			tipoMediador.equalsIgnoreCase(tipoMed);

		Assert.assertTrue(tipoMediadorInte, "Es incorrecto.");
		debugInfo("Se ha verificado el Tipo de Mediador");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTipoColaborador(String constanteFicha, String tipoCol) {

		debugBegin();

		String tipoColaborador = webDriver.getTextInFrame(tipoColaboradorTxt, cuerpoFrame).substring(16).trim();

		boolean tipoColaboradorMediador = getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase(constanteFicha) &&
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
		debugInfo("Se ha verificado el Ejecutivo Comercial");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarIdioma(String constanteFicha, String idioma) {

		debugBegin();

		String idiomaMed = webDriver.getTextInFrame(idiomaMediadorTxt, cuerpoFrame).substring(7).trim();

		boolean idiomaMediador = getTestVar(Constants.IDIOMA).equalsIgnoreCase(constanteFicha) &&
			idiomaMed.equalsIgnoreCase(idioma);

		Assert.assertTrue(idiomaMediador, "Es incorrecto.");
		debugInfo("Se ha verificado el Idioma.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarActividadPrincipal(String constanteFicha, String actividadPri) {

		debugBegin();

		String actividadPrinc = webDriver.getTextInFrame(actividadPrincipalTxt, cuerpoFrame).substring(20).trim();

		boolean actividadPMed = getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase(constanteFicha) &&
			actividadPrinc.equalsIgnoreCase(actividadPri);

		Assert.assertTrue(actividadPMed, "Es incorrecto.");
		debugInfo("Se ha verificado la Actividad principal.");

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

		boolean disponeSoftwareMed = getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase(constanteFicha) &&
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
		debugInfo("El nombre completo tal como aparece en el CSV: " + getTestVar(Constants.NOMBRE_MEDIADOR) + " " + getTestVar(Constants.PRIMER_APELLIDO_MEDIADOR) + " "
			+ getTestVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));

		boolean checkNombresFiscales = nombreCompleto.equalsIgnoreCase(nombreFisc + " " + primeApell + " " + segApell);

		Assert.assertTrue(checkNombresFiscales, "Es incorrecto.");
		debugInfo("Se ha verificado el Nombre Completo Fiscal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarTelefonoPrincipal(String telefono) {

		debugBegin();

		String telefonPri = webDriver.getTextInFrame(telefonoPrincipalTxt, cuerpoFrame).substring(23).trim();

		boolean telefonPriMed = telefonPri.equalsIgnoreCase(telefono);

		Assert.assertTrue(telefonPriMed, "Es incorrecto.");
		debugInfo("Se ha verificado que el Telefono principal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarEmailPrincipal(String email) {

		debugBegin();

		String emailPri = webDriver.getTextInFrame(emailPrincipalTxt, cuerpoFrame).substring(16).trim();

		boolean telefonPriMed = emailPri.equalsIgnoreCase(email);

		Assert.assertTrue(telefonPriMed, "Es incorrecto.");
		debugInfo("Se ha verificado que el Email Principal.");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarDireccion() {
		debugBegin();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")){

			List<WebElement> obtenerListaDirecciones = webDriver.getElementsInFrame(listaDirecciones, cuerpoFrame);
			debugInfo("contiene " + obtenerListaDirecciones.size() + " direcciones");

			for(int i = 1; i < obtenerListaDirecciones.size(); i++) {

				String obtenerTipoDireccion = webDriver.getTextInFrame(By.cssSelector(
					"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(" + (i
						+ 1)
						+ ") > td:nth-child(2)"), cuerpoFrame).trim();
				debugInfo("El tipo de dirección es: " + obtenerTipoDireccion);

				String obtenerDireccion = webDriver.getTextInFrame(By.cssSelector(
					"#capaAjax > table:nth-child(1) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(" + (i
						+ 1)
						+ ") > td:nth-child(3)"), cuerpoFrame).trim();
				debugInfo("--------------------- El contenido de la dirección en FICHA es: " + obtenerDireccion);
				debugInfo("--------------------- El contenido de la dirección en el CSV es: " + getTestVar(Constants.DIRECCION_FISC_NombreVia).trim() + " 11 " + "(08029) " + getTestVar(Constants.DIRECCION_FISC_PROVINCIA).trim() + " - " + getTestVar(Constants.DIRECCION_FISC_POBLACION).trim());


				if(obtenerTipoDireccion.equalsIgnoreCase("Fiscal")) {

					/*boolean checkDireccionFiscal = obtenerDireccion.equalsIgnoreCase(
						getTestVar(Constants.DIRECCION_FISC_NombreVia).trim() + " 11 " + "(08029) " + getTestVar(Constants.DIRECCION_FISC_PROVINCIA).trim() + " - "
							+ getTestVar(Constants.DIRECCION_FISC_POBLACION).trim());*/

					boolean checkDireccionFiscal = obtenerDireccion.equalsIgnoreCase(getTestVar(Constants.DIRECCION_FISC_COMPLETA));

					debugInfo("Comprobamos la dirección fiscal, el resultado es: " + checkDireccionFiscal);
					Assert.assertTrue(checkDireccionFiscal, "Comparar campos: la dirección Fiscal NO coincide");

				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Comercial")) {
					/*boolean checkDireccionComercial = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_COME_NombreVia).trim() + " 11 " + "(08013) " + getTestVar(Constants.DIRECCION_COME_PROVINCIA).trim() + " - "
							+ getTestVar(Constants.DIRECCION_COME_POBLACION).trim());*/
					boolean checkDireccionComercial = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_COME_COMPLETA));

					debugInfo("Comprobamos la dirección comercial, el resultado es: " + checkDireccionComercial);
					Assert.assertTrue(checkDireccionComercial, "Comparar campos: la dirección Comercial NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Postal producción")) {

					/*boolean checkDireccionProduccion = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PPRO_NOMBRE_VIA).trim() + " 11 " + "(08020) " + getTestVar(Constants.DIRECCION_PPRO_PROVINCIA).trim() + " - "
							+ getTestVar(Constants.DIRECCION_PPRO_POBLACION).trim());*/
					boolean checkDireccionProduccion = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PPRO_COMPLETA));

					debugInfo("Comprobamos la dirección de producción, el resultado es: " + checkDireccionProduccion);
					Assert.assertTrue(checkDireccionProduccion, "Comparar campos: la dirección Postal producción NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Postal recibos")) {

					/*boolean checkDireccionRecibos = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PREC_NombreVia).trim() + " 11 " + "(08005) " + getTestVar(Constants.DIRECCION_PREC_PROVINCIA).trim() + " - "
							+ getTestVar(Constants.DIRECCION_PREC_POBLACION).trim());*/

					boolean checkDireccionRecibos = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PREC_COMPLETA));

					debugInfo("Comprobamos la dirección de recibos, el resultado es: " + checkDireccionRecibos);
					Assert.assertTrue(checkDireccionRecibos, "Comparar campos: la dirección Postal recibos NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Postal siniestros")) {

					/*boolean checkDireccionSiniestros = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PSIN_NOMBRE_VIA).trim() + " 11 " + "(08017) " + getTestVar(Constants.DIRECCION_PSIN_PROVINCIA).trim() + " - "
							+ getTestVar(Constants.DIRECCION_PSIN_POBLACION).trim());*/
					boolean checkDireccionSiniestros = obtenerDireccion
						.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PSIN_COMPLETA));

					debugInfo("Comprobamos la dirección de siniestros, el resultado es: " + checkDireccionSiniestros);
					Assert.assertTrue(checkDireccionSiniestros, "Comparar campos: la dirección Postal siniestros NO coincide");
				}

			}

			if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {
				if(obtenerTipoDireccion.equalsIgnoreCase("Fiscal")) {
					boolean checkDireccionFiscal = obtenerDireccion.equalsIgnoreCase(getTestVar(Constants.DIRECCION_FISC_COMPLETA));
					debugInfo("Comprobamos la dirección fiscal, el resultado es: " + checkDireccionFiscal);
					Assert.assertTrue(checkDireccionFiscal, "Comparar campos: la dirección Fiscal NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Comercial")) {
					boolean checkDireccionComercial = obtenerDireccion.equalsIgnoreCase(getTestVar(Constants.DIRECCION_COME_COMPLETA));
					debugInfo("Comprobamos la dirección comercial, el resultado es: " + checkDireccionComercial);
					Assert.assertTrue(checkDireccionComercial, "Comparar campos: la dirección Comercial NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Postal producción")) {
					boolean checkDireccionProduccion = obtenerDireccion.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PPRO_COMPLETA));
					debugInfo("Comprobamos la dirección de producción, el resultado es: " + checkDireccionProduccion);
					Assert.assertTrue(checkDireccionProduccion, "Comparar campos: la dirección Postal producción NO coincide");
				}
				if(obtenerTipoDireccion.equalsIgnoreCase("Postal siniestros")) {
					boolean checkDireccionSiniestros = obtenerDireccion.equalsIgnoreCase(getTestVar(Constants.DIRECCION_PSIN_COMPLETA));
					debugInfo("Comprobamos la dirección de siniestros, el resultado es: " + checkDireccionSiniestros);
					Assert.assertTrue(checkDireccionSiniestros, "Comparar campos: la dirección Postal siniestros NO coincide");
				}

			}

		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarRamo(String constanteFicha, String ramoMediador) {
		debugBegin();

		String ramo = webDriver.getTextInFrame(ramoMediadorTxt, cuerpoFrame).substring(21).trim();

		boolean ramoMed = getTestVar(Constants.RAMO_ALT_MED).equalsIgnoreCase(constanteFicha) &&
			ramo.equals(ramoMediador);

		Assert.assertTrue(ramoMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Ramo es Asistencia");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarCompanyiasPrincipales(String constanteFicha, String companyia) {
		debugBegin();

		String companyiasPrincip = webDriver.getTextInFrame(companyiasPrincipTxt, cuerpoFrame).substring(31).trim();

		boolean companyiasPrincipMed = getTestVar(Constants.COMPANYIAS_PRINCIPALES).equalsIgnoreCase(constanteFicha) &&
			companyiasPrincip.equals(companyia);

		Assert.assertTrue(companyiasPrincipMed, "Es incorrecto.");
		debugInfo("Se ha verificado las Compañias principales");

		debugEnd();
		return this;
	}

	//colaboradores: todos los 3
	public FichaMediadorPage verificarOficinaPadre(String oficinaPadre) {
		debugBegin();

		int indexPadreInicial = webDriver.getTextInFrame(oficinaPadreTxt, cuerpoFrame).indexOf("-");
		String oficinaPadreMed = webDriver.getTextInFrame(oficinaPadreTxt, cuerpoFrame).substring(14, indexPadreInicial).trim();

		boolean oficinaMedResMed = oficinaPadreMed.equalsIgnoreCase(oficinaPadre);

		Assert.assertTrue(oficinaMedResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Oficina Padre");
		debugEnd();
		return this;
	}

	//solo oficina
	public FichaMediadorPage verificarMediadorPadre(String mediadorPadre) {
		debugBegin();

		int indexPadreInicial = webDriver.getTextInFrame(mediadorPadreTxt, cuerpoFrame).indexOf("-");
		String padreMed = webDriver.getTextInFrame(mediadorPadreTxt, cuerpoFrame).substring(15, indexPadreInicial).trim();

		boolean padreMedResMed = padreMed.equalsIgnoreCase(mediadorPadre);

		Assert.assertTrue(padreMedResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Mediador Padre");

		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarContactoResponsable(String contacto) {
		debugBegin();

		String contactoRes = webDriver.getTextInFrame(nombreContactoRespTxt, cuerpoFrame).substring(7).trim();
		debugInfo("Lo que saca en la ficha es " + contactoRes);

		boolean contactoResMed = contactoRes.equalsIgnoreCase(contacto);

		debugInfo("lo que pongo yo " + contacto);
		Assert.assertTrue(contactoResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Contacto Responsable");
		debugEnd();
		return this;
	}

	public FichaMediadorPage verificarCargoResponsable(String cargo) {
		debugBegin();

		String cargoRes = webDriver.getTextInFrame(cargoContactoRespTxt, cuerpoFrame).substring(6).trim();

		boolean cargoResMed = cargoRes.equalsIgnoreCase(cargo);

		Assert.assertTrue(cargoResMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Cargo responsable");
		debugEnd();
		return this;
	}

	//solo para cualquier tipo de intermediarios
	public FichaMediadorPage verificarBancoComisiones(String banco) {
		debugBegin();

		String bancoCom = webDriver.getTextInFrame(ibanPagoComisionesTxt, cuerpoFrame).substring(20).trim();

		boolean bancoComMed = bancoCom.equalsIgnoreCase(banco);

		Assert.assertTrue(bancoComMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Banco de Comisiones");
		debugEnd();
		return this;
	}

	//solo para cualquier tipo de intermediarios
	public FichaMediadorPage verificarPagoAutoliquidaciones(String banco) {
		debugBegin();

		String bancoCom = webDriver.getTextInFrame(ibanRecibosAutoliqTxt, cuerpoFrame).substring(37).trim();

		boolean bancoComMed = bancoCom.equalsIgnoreCase(banco);

		Assert.assertTrue(bancoComMed, "Es incorrecto.");
		debugInfo("Se ha verificado el Banco PAGO de Autoliquidaciones");
		debugEnd();
		return this;
	}

	public FichaMediadorPage comprobacionFicha() {
		debugBegin();

		clickFichaMediador();

		//NIVEL ESTRUCTURA
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") && getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {
			verificarNivelEstructura(MediadoresConstantesFicha.INTE, "Intermediario");
		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") && getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {
			verificarNivelEstructura(MediadoresConstantesFicha.OFIC, "Oficina");
		} else if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && getTestVar(Constants.NIVEL_ESTRUCTURA) != null
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()) {
			verificarNivelEstructura(MediadoresConstantesFicha.COLA, "Colaborador");
		}

		//TIPO DE MEDIADOR
		if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.AE, "Agente exclusivo");
		} else if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.AD, "Acuerdo colaboración");
		} else if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AV") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.AV, "Agente vinculado");
		} else if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSE") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.BSE, "BS exclusivo");
		} else if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("BSV") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.BSV, "BS vinculado");
		} else if(getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("CORR") && getTestVar(Constants.TIPO_MEDIADOR) != null
			&& !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()) {
			verificarTipoMediador(MediadoresConstantesFicha.CORR, "Corredor");
		}

		//TIPO DE COLABORADOR
		if(getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD") && getTestVar(Constants.TIPO_COLABORADOR) != null
			&& !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {
			verificarTipoColaborador(MediadoresConstantesFicha.AD_COLABORADOR, "Acuerdo Distribución");
		} else if(getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI") && getTestVar(Constants.TIPO_COLABORADOR) != null
			&& !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {
			verificarTipoColaborador(MediadoresConstantesFicha.AUXI, "Auxiliar");
		} else if(getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST") && getTestVar(Constants.TIPO_COLABORADOR) != null
			&& !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {
			verificarTipoColaborador(MediadoresConstantesFicha.GEST, "Gestor");
		}

		//EJECUTIVO COMERCIAL
		if(getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4000")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4001")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4003")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4005")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4007")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4010")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4011")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4015")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4016")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4019")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4023")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4024")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4027")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4056")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4067")
			|| getTestVar(Constants.EJECUTIVO_COMERCIAL).equalsIgnoreCase("4069")) {

			verificarEjecutivoComercial(getTestVar(Constants.EJECUTIVO_COMERCIAL));
		}

		//IDIOMA
		if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("ESPA")) {
			verificarIdioma(MediadoresConstantesFicha.ESPA, "Castellano");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("CATA")) {
			verificarIdioma(MediadoresConstantesFicha.CATA, "Català");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("EUSK")) {
			verificarIdioma(MediadoresConstantesFicha.EUSK, "Euskara");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("ENGL")) {
			verificarIdioma(MediadoresConstantesFicha.ENGL, "English");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("FRAN")) {
			verificarIdioma(MediadoresConstantesFicha.FRAN, "Français");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("PRTG")) {
			verificarIdioma(MediadoresConstantesFicha.PRTG, "Português");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("DEUT")) {
			verificarIdioma(MediadoresConstantesFicha.DEUT, "Deutsch");
		} else if(getTestVar(Constants.IDIOMA).equalsIgnoreCase("GALE")) {
			verificarIdioma(MediadoresConstantesFicha.GALE, "Galego");
		}
		//ACTIVIDAD PRINCIPAL
		if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("MESE")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.MESE, "Mediador de Seguros");
		} else if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("ADFI")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.ADFI, "Administrador de Fincas");
		} else if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("ABOG")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.ABOG, "Abogados");
		} else if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("OTRO")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.OTRO, "Otros");
		} else if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("API")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.API, "API");
		} else if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL).equalsIgnoreCase("GEPA")) {
			verificarActividadPrincipal(MediadoresConstantesFicha.GEPA, "Gestor Patrimonios");
		}

		//NOMBRE, PRIMER APELLIDO Y SEGUNDO APELLIDO FISCALES COMPLETOS
		if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Sleepwalking")) {
			verificarNombres("Sleepwalking", "Bringme", "Thehorizon");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Orion")) {
			verificarNombres("Orion", "Cliff", "Burton");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("A7X")) {
			verificarNombres("Foo", "Fighters", "Neighbourhood");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Foo")) {
			verificarNombres("A7X", "Exist", "");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Ghost Macabre")) {
			verificarNombres("Ghost Macabre", "", "");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Pantera")) {
			verificarNombres("Pantera", "Shedding", "Skin");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("Ozzy Osborne")) {
			verificarNombres("Ozzy Osborne", "", "");
		} else if(getTestVar(Constants.NOMBRE_MEDIADOR).equalsIgnoreCase("In this moment")) {
			verificarNombres("In this moment", "", "");
		}

		//CONTACTO RESPONSABLE
		verificarContactoResponsable("Contacto Responsable");

		//CARGO RESPONSABLE
		verificarCargoResponsable("Cargo Responsable");

		clickInfoDescriptiva();

		//NOMBRE COMERCIAL
		if(getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med01")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med02")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med03")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med04")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med05")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med06")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med07")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med09")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med10")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med11")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med12")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med13")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med14")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med15")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med16")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med18")
			|| getTestVar(Constants.NOMBRE_COMERCIAL).equalsIgnoreCase("Med19")) {

			verificarNombreComercial(getTestVar(Constants.NOMBRE_COMERCIAL));
		}

		//DISPONE SOFTWARE
		if(getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase("TRUE")) {
			verificarDisponeSoftware(MediadoresConstantesFicha.DISPONE_SOFTWARE_SI, "Sí");
		} else if(getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).equalsIgnoreCase("FALSE")) {
			verificarDisponeSoftware(MediadoresConstantesFicha.DISPONE_SOFTWARE_NO, "No");
		}

		clickInfoContacto();

		verificarTelefonoPrincipal("666302010");
		verificarEmailPrincipal("mediador@email.com");

		//DIRECCIONES
		verificarDireccion();

		clickInfoRelacional();

		//RAMO
		if(getTestVar(Constants.RAMO_ALT_MED).equalsIgnoreCase("10")) {
			verificarRamo(MediadoresConstantesFicha.ASISTENCIA, "Asistencia");
		}

		//COMPAÑIAS PRINCIPALES
		if(getTestVar(Constants.COMPANYIAS_PRINCIPALES).equalsIgnoreCase("Compañía principal abogado")) {
			verificarCompanyiasPrincipales(MediadoresConstantesFicha.COMPANYIA_PRINCIPAL_MED, getTestVar(Constants.COMPANYIAS_PRINCIPALES));
		}

		clickCondicionesNegocio();

		//BANCO COMISIONES
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			verificarBancoComisiones("ES0321001234561234567890");

		}
		//BANCO PAGO AUTOLIQUIDACIONES
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			verificarPagoAutoliquidaciones("ES0321001234561234567890");

		}

		debugEnd();
		return this;
	}

}

