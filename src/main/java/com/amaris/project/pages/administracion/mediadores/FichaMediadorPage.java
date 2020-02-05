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

	private By visionGlobalBtn = By.linkText("Vision Global");
	private By infoDescriptivaBtn = By.linkText("Info Descriptiva");
	private By infoContactoBtn = By.linkText("Info Contacto");
	private By infoRelacionalBtn = By.linkText("Info Relacional");
	private By infoTransaccionalBtn = By.linkText("Info Transaccional");
	private By condicionesNegocioBtn = By.linkText("Condiciones de negocio");
	private By infoHistoricaBtn = By.linkText("Info Histórica");
	private By infoCCMBtn = By.cssSelector("#pes7");
	private By infoDGSBtn = By.linkText("Info DGS");
	private By contactosBtn = By.linkText("[onclick*='subSecci=SEC_CONTACTOS']");
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
	private By comentarioResolFinancAltaInput = By.cssSelector("#GESMED_RESFCOME");
	private By rechazarAltaBtn = By.cssSelector("[onclick*='operacion=RECHMEDI]");
	private By solicitarMasInformacionBtn = By.cssSelector("[onclick*='operacion=SOLIINFOINIC]");
	private By confirmarAltaBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By enviaValoraFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVVALFI']");
	private By enviaRevisionFinancieraBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By enviaResolucionFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVRESFI']");
	private By enviaResolucionFinancieraCombo = By.cssSelector("#GESMED_REVFVALO");
	private By enviaResolucionFinancieraOption = By.cssSelector("#GESMED_REVFVALO > option");
	private By enviaResolucionFinancieraAltaCombo = By.cssSelector("#GESMED_RESFVALO");
	private By enviaResolucionFinancieraAltaOption = By.cssSelector("#GESMED_RESFVALO");
	private By enviaResolucionFinancieraInput = By.cssSelector("#GESMED_REVFCOME");
	// alternativa sin probar por si falla el textarea	private By enviaResolucionFinancieraTxt = By.cssSelector("#formDatos > div.contentBox.anchuraCajas > div.marcofnd > table.narrowBox > tbody > tr:nth-child(2) > td > textarea"); o  name=comresfi
	// alternativa para obtener desplegable #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table.anchuraCajas > tbody > tr > td > select > option     deñ select name="valresfi"
	private By avanzarEstadoBtn = By.cssSelector("[onclic='operacion=AVANESTA']");
	private By fFormObligatoria = By.cssSelector("#GESMED_FFOROBLIG");
	private By periodoCreditoTxt = By.cssSelector("body > table.wideBox > tbody > tr > td > p > strong");
	// alternativa private By fFormObligatoria = By.cssSelector("#formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td > input"); o  name="feforobl"
	private By activarMediadorBtn = By.cssSelector("[onclic='operacion=ACTIMEDI']");
	private By fEnvioContratoTxt = By.cssSelector("#GESMED_FENVCONT");
	//alternativas name="feenvcon" y #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td:nth-child(2) > input
	private By fRecepcionContratoTxt = By.cssSelector("#GESMED_FRECCONT");
	// alternativa name="fereccon" y #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td:nth-child(4) > input
	private By solicitarBajaBtn = By.cssSelector("[onclick*='operacion=SOLIBAJA']");
	private By grabarEstadoBtn = By.cssSelector("#buttonRecord");
	private By volverBtn = By.cssSelector("#Submit");
	private By cancelarBtn = By.cssSelector("#buttonCancel");

	private By altaOficinaBtn = By.cssSelector("[onclick*='CODIACCI=ALTAOFIC']");
	// alternativa de alta oficina cuando es en AE activo restringido  #capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(5) > a
	private By altaColaboradorBtn = By.cssSelector("[onclick*='CODIACCI=COLADOFI']");
	// alternativa de alta colaborador  #capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a / + > span texto= Alta colaborador
	private By solicitarMantenimientoBtn = By.cssSelector("[onclick*='operacion=SOLIMANT']");

	//------------- Contenido del encabezado -------------

	private By nivelJerarquicoTxt = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(1)");
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

	//Otros
	private By periodoCreditoCombo = By.cssSelector("#ALTAMEDI_PERCREDI");
	private By periodoCreditoOption = By.cssSelector("#ALTAMEDI_PERCREDI > option");
	private By limiteCreditoCombo = By.cssSelector("#ALTAMEDI_LIMCREDI");
	private By limiteCreditoOption = By.cssSelector("#ALTAMEDI_LIMCREDI > option");
	private By guardarSalirBtn = By.cssSelector("#botonGrabar1");
	// Pestaña Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");

	//--------     Constantes SITUACIONES-----------------------------//
	private static final String RESOLUCION_FINANCIERA = "Situación Resolución financiera";
	private static final String ALTA_MEDIADOR = "Situación Alta mediador";
	private static final String SOLICITUD_ALTA = "Situación Solicitud de alta";
	private static final String INFORMACION_FINANCIERA = "Situación Solicitud información financiera";
	private static final String REVISION_FINANCIERA = "Situación Revisión financiera";

	//--------------- Constantes ESTADOS------------------//

	private static final String EN_TRAMITACION = "Estado En tramitación";
	private static final String FORMACION = "Estado Formación";

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

	public FichaMediadorPage comentarioResolFinancieraAltaConfirmar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(comentarioResolFinancAltaInput, modalFrame, "Comentario para añadir");
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaFormOblig() {
		debugBegin();
		String datoFechaFormOblig = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fFormObligatoria, modalFrame, datoFechaFormOblig);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaEnvioContrato() {
		debugBegin();
		String datoFechaEnvioContrato = DateUtils.getModifiedDate(Calendar.DATE, -3, Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fEnvioContratoTxt, modalFrame, datoFechaEnvioContrato);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirFechaRecepcionContrato() {
		debugBegin();
		String datoFechaRecepcionContrato = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fRecepcionContratoTxt, modalFrame, datoFechaRecepcionContrato);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage grabarComentarioEstado() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarEstadoBtn, modalFrame);
		webDriver.waitWithDriver(3000);
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

		//boolean checkNivelJerarquico = nivelJerarquico.equals("<strong>Nivel Jerárquico </strong>" + getTestVar(Constants.NIVEL_ESTRUCTURA));

		boolean checkNivelJerarquico = nivelJerarquico.equals("Nivel Jerárquico Colaborador");
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

	public FichaMediadorPage anyadirDatosResolucionFinanciera() {
		debugBegin();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_VALORACION_FINANCIERA_MEDIADORES);
		webDriver.acceptAlert();
		webDriver.waitWithDriver(3000);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, enviaResolucionFinancieraOption, modalFrame, "value", "ALAC");

		grabarComentarioEstado();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_FINANCIERA_MEDIADORES);
		webDriver.acceptAlert();

		debugEnd();
		return this;
	}

	//---------------------ESTADOS + SITUACIONES MÉTODOS------------------------------

	//COMPROBAR TEXTO DE ESTADO
	public boolean comprobarEstado(String estado) {
		debugBegin();

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

		String situacionAlta = webDriver.getTextInFrame(situacionMediadorTxt, cuerpoFrame).trim();
		boolean checkSituacion = situacionAlta.equalsIgnoreCase(situacion);

		debugInfo("Mensaje esperado:" + situacion);
		debugInfo("Mensaje real: " + situacionAlta);

		debugEnd();

		return checkSituacion;
	}

	public boolean alertaSistemaFechaFormacion(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String fechaFormacion = webDriver.getTextInFrame(fFormObligatoria, modalFrame).trim();
		boolean checkFecha = fechaFormacion.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + fechaFormacion);

		debugEnd();

		return checkFecha;
	}

	public boolean alertaSistemaPeriodoCredito(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String peridoCredito = webDriver.getTextInFrame(periodoCreditoTxt, modalFrame).trim();
		boolean checkPeriodo = peridoCredito.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + peridoCredito);

		debugEnd();

		return checkPeriodo;
	}

	public FichaMediadorPage solicitarAlta() {
		debugBegin();

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

		debugInfo("Enviar para valoración financiera se hizo con éxito o por lo menos recorrió");

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

		debugInfo("Enviar para revisión financiera se hizo con éxito o por lo menos recorrió");

		debugEnd();
		return this;
	}

	public FichaMediadorPage anyadirPeriodoLimiteCredito() {
		debugBegin();
		clickInfoCCM();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(modificarMedCondiciNegBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttributeInFrame(periodoCreditoCombo, periodoCreditoOption, cuerpoFrame, "value", "45");
		webDriver.clickElementFromDropDownByAttributeInFrame(limiteCreditoCombo, limiteCreditoOption, cuerpoFrame, "value", "ESPE");
		webDriver.clickInFrame(guardarSalirBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage obtenerIdMediador() {
		debugBegin();
		webDriver.waitWithDriver(6000);

		if(webDriver.isPresentInFrame(tituloPaginaTxt, cuerpoFrame)) {
			debugInfo("Mensaje correcto: " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim());
			setScenarioVar((Constants.ID_MEDIADOR_ALTA), webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 5).toString());
			debugInfo("El id del mediador dado de alta es " + webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame).trim().substring(0, 5).toString());
			debugInfo("El mediador del campo  ID_MEDIADOR_ALTA es " + getSuiteVar(Constants.ID_MEDIADOR_ALTA));
		} else {
			debugInfo("Ha habido un error al dat de alta el mediador");
		}
		debugEnd();
		return this;
	}

	public FichaMediadorPage enviarResolucionFinanciera() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");
		Assert.assertTrue(comprobarSituacion(REVISION_FINANCIERA), "La situacion no es correctA.");

		clickMasAcciones();
		clickEnviarResolucionFinanciera();
		webDriver.waitWithDriver(3000);

		grabarComentarioEstado();

		anyadirDatosResolucionFinanciera();
		comentarioResolucionFinanciera();
		grabarComentarioEstado();

		Assert.assertTrue(alertaSistemaPeriodoCredito(Constants.ALERTA_PERIODO_CREDITO_MEDIADORES));
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(volverBtn);
		webDriver.click(cancelarBtn);
		webDriver.exitFrame();

		//--FALTA LA RETENCION DE LIMITE CREDITO----añadir en alta
		anyadirPeriodoLimiteCredito();

		clickMasAcciones();
		clickEnviarResolucionFinanciera();
		webDriver.waitWithDriver(3000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, enviaResolucionFinancieraOption, modalFrame, "value", "ALAC");
		comentarioResolucionFinanciera();
		grabarComentarioEstado();

		debugInfo("Enviar para resolución financiera se hizo con éxito o por lo menos recorrió");

		debugEnd();
		return this;
	}

	// me quedado aqui
	public FichaMediadorPage confirmarAlta() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(EN_TRAMITACION), "El estado no es correcto.");

		if(comprobarSituacion(RESOLUCION_FINANCIERA)) {
			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_VALORACION_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();
			webDriver.waitWithDriver(3000);
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraAltaCombo, enviaResolucionFinancieraAltaOption, modalFrame, "value", "ALAC");

			grabarComentarioEstado();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();
			comentarioResolFinancieraAltaConfirmar();
			grabarComentarioEstado();
			debugInfo("Confirmar alta se hizo con éxito o por lo menos recorrió");
		} else if(comprobarSituacion(SOLICITUD_ALTA)) {
			clickMasAcciones();
			clickConfirmarAlta();
			webDriver.waitWithDriver(3000);
			grabarComentarioEstado();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMENTARIO_FINANCIERA_MEDIADORES);
			webDriver.acceptAlert();
			comentarioResolFinancieraAltaConfirmar();
			grabarComentarioEstado();
			debugInfo("Enviar para resolución financiera se hizo con éxito o por lo menos recorrió");
		}

		debugEnd();
		return this;
	}

	public FichaMediadorPage formacionAvanzarEstado() {
		debugBegin();

		Assert.assertTrue(comprobarEstado(FORMACION), "El estado no es correcto.");

		clickMasAcciones();
		clickAvanzarEstado();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(grabarEstadoBtn);
		webDriver.waitWithDriver(3000);
		Assert.assertTrue(alertaSistemaFechaFormacion(Constants.ALERTA_FECHA_MEDIADORES));
		webDriver.click(volverBtn);
		webDriver.setText(fFormObligatoria, "fecha");
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_MEDIADORES_INCORRECTA);
		webDriver.acceptAlert();
		webDriver.exitFrame();
		anyadirFechaFormOblig();
		grabarComentarioEstado();
		debugInfo("Avanzar estado se hizo con éxito o por lo menos recorrió");

		debugEnd();
		return this;
	}

	/*public FichaMediadorPage anyadirIdMediador() {
		debugBegin();
		// a la string se le asigna el valor guardado en el CSV y constante
		String idMedAlta = getSuiteVar(Constants.ID_MEDIADOR_ALTA);
		debugInfo("ver si aparece la idMedAlta correctamente: " + idMedAlta);
		debugEnd();
		return this;
	}*/

	/// falta realmente hacer uso de esteo dato?? anyadirIdMediador.idMedAlta

	// endregion
}
