package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
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

	private By tituloPaginaTxt = By.cssSelector("h1.titulopagina");

	//------------- Botones Pestañas -------------


	private By visionGlobalBtn = By.linkText("Vision Global");
	private By infoDescriptivaBtn = By.linkText("Info Descriptiva");
	private By infoContactoBtn = By.linkText("Info Contacto");
	private By infoRelacionalBtn = By.linkText("Info Relacional");
	private By infoTransaccionalBtn = By.linkText("Info Transaccional");
	private By condicionesNegocioBtn = By.linkText("Condiciones de negocio");
	private By infoHistoricaBtn = By.linkText("Info Histórica");
	private By infoCCMBtn = By.linkText("Info CCM");
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
	private By comentarioSituacionTxt = By.cssSelector("body.modalContenido > #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td > textarea");
	private By rechazarAltaBtn = By.cssSelector("[onclick*='operacion=RECHMEDI]");
	private By solicitarMasInformacionBtn = By.cssSelector("[onclick*='operacion=SOLIINFOINIC]");
	private By confirmarAltaBtn = By.cssSelector("[onclick*='operacion=CONFALTAFIN']");
	private By enviaValoraFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVVALFI']");
	private By enviaRevisionFinancieraBtn = By.cssSelector("[onclick*='ooperacion=ENVREVFI']");
	private By enviaResolucionFinancieraBtn = By.cssSelector("[onclick*='operacion=ENVRESFI']");
	private By enviaResolucionFinancieraCombo = By.cssSelector("#GESMED_REVFVALO");
	private By enviaResolucionFinancieraTxt = By.cssSelector("#GESMED_REVFCOME");
	// alternativa sin probar por si falla el textarea	private By enviaResolucionFinancieraTxt = By.cssSelector("#formDatos > div.contentBox.anchuraCajas > div.marcofnd > table.narrowBox > tbody > tr:nth-child(2) > td > textarea"); o  name=comresfi
	// alternativa para obtener desplegable #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table.anchuraCajas > tbody > tr > td > select > option     deñ select name="valresfi"
	private By avanzarEstadoBtn = By.cssSelector("[onclic='operacion=AVANESTA']");
	private By fFormObligatoria = By.cssSelector("#GESMED_FFOROBLIG");
	// alternativa private By fFormObligatoria = By.cssSelector("#formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td > input"); o  name="feforobl"
	private By activarMediadorBtn = By.cssSelector("[onclic='operacion=ACTIMEDI']");
	private By fEnvioContratoTxt = By.cssSelector("#GESMED_FENVCONT");
	//alternativas name="feenvcon" y #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td:nth-child(2) > input
	private By fRecepcionContratoTxt = By.cssSelector("#GESMED_FRECCONT");
	// alternativa name="fereccon" y #formDatos > div.contentBox.anchuraCajas > div.marcofnd > table > tbody > tr:nth-child(2) > td:nth-child(4) > input
	private By solicitarBajaBtn = By.cssSelector("[onclick*='operacion=SOLIBAJA']");
	private By grabarEstadoBtn = By.cssSelector("#buttonRecord");
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

	// Pestaña Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");

	// endregion

	public FichaMediadorPage(UserStory userS) {
		super(userS);
	}

	// region methods

	// ---- Acceder a las pestañas de la ficha

	public FichaMediadorPage clickVisionGlobal() {
		debugBegin();
		webDriver.clickInFrame(visionGlobalBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickinfoDescriptiva() {
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

	public FichaMediadorPage clickCondicionesNegocio(){
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
		webDriver.clickInFrame(solicitarBajaBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickSolicitarAlta() {
		debugBegin();
		webDriver.clickInFrame(solicitarAltaBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickConfirmarAlta() {
		debugBegin();
		webDriver.clickInFrame(confirmarAltaBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarValFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaValoraFinancieraBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarRevisionFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaRevisionFinancieraBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickEnviarResolucionFinanciera() {
		debugBegin();
		webDriver.clickInFrame(enviaResolucionFinancieraBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickAvanzarEstado() {
		debugBegin();
		webDriver.clickInFrame(avanzarEstadoBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage clickActivarMediador() {
		debugBegin();
		webDriver.clickInFrame(activarMediadorBtn,cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirComentarioSituacion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(comentarioSituacionTxt, modalFrame, "Comentario para añadir en el Pop up cuando se solicita cambio de estado o situación del mediador");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage seleccionarResolucionFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, modalFrame, "value", "ALAC");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage comentarioResolucionFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(enviaResolucionFinancieraTxt, modalFrame, "Comentario para añadir en el Pop up cuando se envía el resultado de la Resolución financiera");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaFormOblig() {
		debugBegin();
		String datoFechaFormOblig = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fFormObligatoria, modalFrame, datoFechaFormOblig);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaEnvioContrato() {
		debugBegin();
		String datoFechaEnvioContrato = DateUtils.getModifiedDate(Calendar.DATE, -3, Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fEnvioContratoTxt, modalFrame, datoFechaEnvioContrato);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaRecepcionContrato() {
		debugBegin();
		String datoFechaRecepcionContrato = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fRecepcionContratoTxt, modalFrame, datoFechaRecepcionContrato);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage grabarComentarioEstado() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarEstadoBtn,modalFrame);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}


	// ----------------------------------------------- MÉTODOS COMPLEJOS -----------------------------------------------
	public String getContenidoTituloPagina() {
		debugBegin();
		webDriver.clickInFrame(visionGlobalBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickinfoDescriptiva() {
		debugBegin();
		webDriver.clickInFrame(infoDescriptivaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoContacto() {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(infoContactoBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		debugEnd();

		return this;
	}

	public FichaMediadorPage clickInfoRelacional() {
		debugBegin();
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

	public FichaMediadorPage añadirComentarioSituacion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(comentarioSituacionTxt, modalFrame, "Comentario para añadir en el Pop up cuando se solicita cambio de estado o situación del mediador");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage seleccionarResolucionFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(enviaResolucionFinancieraCombo, modalFrame, "value", "ALAC");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage comentarioResolucionFinanciera() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(enviaResolucionFinancieraTxt, modalFrame, "Comentario para añadir en el Pop up cuando se envía el resultado de la Resolución financiera");
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaFormOblig() {
		debugBegin();
		String datoFechaFormOblig = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fFormObligatoria, modalFrame, datoFechaFormOblig);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaEnvioContrato() {
		debugBegin();
		String datoFechaEnvioContrato = DateUtils.getModifiedDate(Calendar.DATE, -3, Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fEnvioContratoTxt, modalFrame, datoFechaEnvioContrato);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage añadirFechaRecepcionContrato() {
		debugBegin();
		String datoFechaRecepcionContrato = DateUtils.getTodayDate(Constants.DATE_FORMAT);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setTextInFrame(fRecepcionContratoTxt, modalFrame, datoFechaRecepcionContrato);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public FichaMediadorPage grabarComentarioEstado() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarEstadoBtn, modalFrame);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();
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

		clickinfoDescriptiva();

		String nombreComercial = (webDriver.getTextInFrame(nombreComercialDescr, cuerpoFrame).trim());
		System.out.println(nombreComercial);

		boolean checkNombreComercial = nombreComercial.equals("ANTIVIST");
		Assert.assertTrue(checkNombreComercial, "Comparar campos: el nombre comercial coincide");

		debugEnd();
		return this;
	}

	// ---- ACCIONES SOBRE FICHA

	public FichaMediadorPage solicitarAlta() {
		debugBegin();
		clickMasAcciones();
		webDriver.clickInFrame(solicitarAltaBtn, cuerpoFrame);
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("ya en cuerpo frame");
		webDriver.waitWithDriver(5000);
		webDriver.setTextInFrame(comentarioSituacionTxt, modalFrame, "Comentario en el modal para solicitar alta");
		grabarComentarioEstado();
		debugInfo("Solicitar alta se hizo con éxito o por lo menos recorrió");

	/*	String direccionComercial = (webDriver.getTextInFrame(direccionComercialTxt, cuerpoFrame).trim());
		System.out.println(direccionComercial);

		boolean checkDireccionComercial = direccionComercial.equals(("SAN GREGORIO 7 (02637) FUENSANTA - Albacete").trim());
		Assert.assertTrue(checkDireccionComercial, "Comparar campos: la dirección comercial coincide");

		debugInfo("");*/
		debugEnd();
		return this;
	}

	//
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

	// endregion
}
