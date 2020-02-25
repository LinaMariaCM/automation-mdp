package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediadoresBuscadorPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By nombreRazonSocialComercialInput = By.cssSelector("#BUSMED_NOMBCOME");
	private By nombreRazonSocialFiscalInput = By.cssSelector("#BUSMED_NOMBFISC");
	private By nifMediadorInput = By.cssSelector("#BUSMED_NUMEDOCU");
	private By poblacionMediadorCombo = By.cssSelector("#BUSMED_POBLACION");
	private By codigoComercialPostalInput = By.cssSelector("#BUSMED_POSTAL");
	private By telefonoMediadorInput = By.cssSelector("#BUSMED_TELEFONO");
	private By direccionCorreoElectronicoInput = By.cssSelector("#BUSMED_EMAIL");
	private By codigoMediadorMutuaInput = By.cssSelector("#BUSMED_CODIMEDI");
	private By codigoDGSInput = By.cssSelector("#BUSMED_REGISDGS");
	private By referenciaExternaMediadorInput = By.cssSelector("#BUSMED_REFEEXTE");
	private By ejecutivoComercialCombo = By.cssSelector("#BUSMED_EJECOMER");
	private By delegacionMediadorCombo = By.cssSelector("#BUSMED_DELEGACION");
	private By panelMediadorCombo = By.cssSelector("#BUSMED_PANEL");

	private By figurasNivelInferiorNoBtn = By.cssSelector("#BUSMED_FIGUINFE_NO");
	private By figurasNivelInferiorSiSoloColaboradoresBtn = By.cssSelector("#BUSMED_FIGUINFE_COLA");
	private By figurasNivelInferiorSiTodosNivelesBtn = By.cssSelector("#BUSMED_FIGUINFE_TODO");
	private By figurasNivelInferiorSiSoloOficinasBtn = By.cssSelector("#BUSMED_FIGUINFE_OFIC");

	private By nivelEstructuraIntermediarioBtn = By.cssSelector("#MEDI_NIESMEDI");
	private By nivelEstructuraOficinaBtn = By.cssSelector("#MEDI_NIESOFIC");
	private By nivelEstructuraColaboradorBtn = By.cssSelector("#MEDI_NIESCOLA");

	private By tipoIntermediarioAgenteExclusivoBtn = By.cssSelector("#MEDI_INTERMAGEX");
	private By tipoIntermediarioAgenteVinculadoBtn = By.cssSelector("#MEDI_INTERMAGVIN");
	private By tipoIntermediarioBSExclusivoBtn = By.cssSelector("#MEDI_INTERMBSEX");
	private By tipoIntermediarioBSVinculadoBtn = By.cssSelector("#MEDI_INTERMBSVIN");
	private By tipoIntermediarioCorredorBtn = By.cssSelector("#MEDI_INTERMCORR");
	private By tipoIntermediarioProspectBtn = By.cssSelector("#MEDI_INTERMPROS");
	private By tipoIntermediarioAffinityBtn = By.cssSelector("#MEDI_INTERMAFFIN");
	private By tipoIntermediarioAcuerdoColaboracionBtn = By.cssSelector("#MEDI_INTERMACDIS");

	private By estadoPendienteEnvioDGSBtn = By.cssSelector("#MEDI_ESTPENVDGS");
	private By estadoPendienteAutorizacionDGSBtn = By.cssSelector("#MEDI_ESTPAUTDGS");
	private By estadoActivoRestringidoBtn = By.cssSelector("#MEDI_ESTACTIRES");
	private By estadoActivoBtn = By.cssSelector("#MEDI_ESTACTIVO");
	private By estadoProspectBtn = By.cssSelector("#MEDI_ESTPROSP");
	private By estadoTramitacionBtn = By.cssSelector("#MEDI_ESTTRAMIT");
	private By estadoFormacionBtn = By.cssSelector("#MEDI_ESTFORM");
	private By estadoBajaBtn = By.cssSelector("#MEDI_ESTBAJA");
	private By estadoBajaTramiteBtn = By.cssSelector("#MEDI_ESTBATR");
	private By estadoMantenimientoBtn = By.cssSelector("#MEDI_ESTMANTE");
	private By estadoRechazadoBtn = By.cssSelector("#MEDI_ESTRECH");

	private By simpleBtn = By.cssSelector("#filtro1");
	private By avanzadoBtn = By.cssSelector("#filtro2");
	private By mediadoresBtn = By.cssSelector("#filtro3");

	//Buscador avanzado
	private By direccionComercialInput = By.cssSelector("#BUSMED_NOMCALLE");
	private By contactoResponsableIntermediarioInput = By.cssSelector("#BUSMED_PERSCONT");
	private By gestorPersonalizadoCombo = By.cssSelector("#BUSMED_GESTPERS");
	private By clavePasarelaInput = By.cssSelector("#BUSMED_CODIPROS");
	private By agrupadorCombo = By.cssSelector("#BUSMED_AGRUPADR");
	private By clasificacionContableCombo = By.cssSelector("#BUSMED_CLASCONT");
	private By actividadPrincipalCombo = By.cssSelector("#BUSMED_ACTPRINC");
	private By tramitadorConvencionalCombo = By.cssSelector("#BUSMED_TRAMSINI");
	private By tramitadorAsistenciaCombo = By.cssSelector("#BUSMED_TRAMASIS");

	private By exportarResultadosBtn = By.cssSelector("#formBarraAcciones > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(1) > a");
	private By buscarBtn = By.cssSelector("#cajabuscador > tbody > tr:nth-child(2) > td.marcofnd > input");

	private By listaBuscador = By.cssSelector("tr[id*='bloque']");
	// endregion

	public MediadoresBuscadorPage(UserStory userS) {
		super(userS);
	}

	public MediadoresBuscadorPage clickExportarResultados() {
		debugBegin();
		webDriver.clickInFrame(exportarResultadosBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresBuscadorPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// Seleccionar casilla en la tabla
	// Leer texto en la tabla
	// Acceder a mas acciones

	/*
		public MediadoresBuscadorPage buscarMediadorEstadoPendienteEnvioDGS() {
			debugBegin();
			webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, menuFrame);
			webDriver.clickInFrame(estadoActivoRestringidoBtn,menuFrame);
			webDriver.clickInFrame(estadoActivoBtn,menuFrame);
			webDriver.waitWithDriver(3000);
			webDriver.clickInFrame(buscarBtn,menuFrame);
			debugEnd();

			return this;
		}
	*/
	public MediadoresBuscadorPage accederElementosTabla() {

		List<WebElement> tabla = webDriver.getElementsInFrame(listaBuscador, cuerpoFrame);
		debugInfo("La lista es:" + tabla);
		//String codigoMediador = tabla.get(3);

		return this;
	}

	// método a revisar para buscar mediador por su ID - Antonia
	public MediadoresBuscadorPage buscarMediadorPorId() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_MEDIADOR_ALTA));
		webDriver.clickInFrame(estadoTramitacionBtn,cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	//Búsqueda para comprobar el intercambio de datos
	public MediadoresBuscadorPage buscarInteRelacionado() {
		debugBegin();
		//webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_ALTA_INTERMEDIARIO_AE));
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_INTE_PADRE));
		webDriver.clickInFrame(estadoTramitacionBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	//METODO PROVISIONAL DE IRYNA PARA BUSCAR MEDIADOR INTERMEDIARIO  POR ID EN ESTADO DE ALTA

	public MediadoresBuscadorPage buscarMediadorPorIdEstadoAlta() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, "2632");
		webDriver.clickInFrame(nivelEstructuraColaboradorBtn, cuerpoFrame);
		webDriver.clickInFrame(nivelEstructuraOficinaBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(estadoPendienteEnvioDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoRestringidoBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	public MediadoresBuscadorPage buscarOficinaPorIdEstadoAlta() {
		debugBegin();
	//	webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_ALTA_OFICINA_AE));
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, getTestVar(Constants.ID_OFICINA_PADRE));
		webDriver.clickInFrame(nivelEstructuraIntermediarioBtn, cuerpoFrame);
		webDriver.clickInFrame(nivelEstructuraColaboradorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(estadoPendienteEnvioDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoRestringidoBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	//buscar por id mediador para probar estados y situaciones para AE
	public MediadoresBuscadorPage buscarMediadorEstadoSituacionAE() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, "121819");
		webDriver.clickInFrame(nivelEstructuraOficinaBtn, cuerpoFrame);
		webDriver.clickInFrame(nivelEstructuraColaboradorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(estadoPendienteEnvioDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoRestringidoBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoTramitacionBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

	public MediadoresBuscadorPage buscarMediadorFichaComprobacion() {
		debugBegin();
		webDriver.setTextInFrame(codigoMediadorMutuaInput, cuerpoFrame, "122006");
		webDriver.clickInFrame(nivelEstructuraOficinaBtn, cuerpoFrame);
		webDriver.clickInFrame(nivelEstructuraColaboradorBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(estadoPendienteEnvioDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoPendienteAutorizacionDGSBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoRestringidoBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoActivoBtn, cuerpoFrame);
		webDriver.clickInFrame(estadoTramitacionBtn, cuerpoFrame);
		clickBuscar();
		webDriver.waitWithDriver(8000);
		debugEnd();
		return this;
	}

}
