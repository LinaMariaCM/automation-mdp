package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaOcurrenciaSiniestrosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediadoresBuscadorPage extends PageObject {

	// region WebElements
	private By menuFrame = By.id("mainFrame");
	private By modalFrame = By.id("leftFrame");

	private By nombreRazonSocialComercialInput = By.id("BUSMED_NOMBCOME");
	private By nombreRazonSocialFiscalInput = By.id("BUSMED_NOMBFISC");
	private By nifMediadorInput = By.id("BUSMED_NUMEDOCU");
	private By poblacionMediadorCombo = By.id("BUSMED_POBLACION");
	private By codigoComercialPostalInput = By.id("BUSMED_POSTAL");
	private By telefonoMediadorInput = By.id("BUSMED_TELEFONO");
	private By direccionCorreoElectronicoInput = By.id("BUSMED_EMAIL");
	private By codigoMediadorMutuaInput = By.id("BUSMED_CODIMEDI");
	private By codigoDGSInput = By.id("BUSMED_REGISDGS");
	private By referenciaExternaMediadorInput = By.id("BUSMED_REFEEXTE");
	private By ejecutivoComercialCombo = By.id("BUSMED_EJECOMER");
	private By delegacionMediadorCombo = By.id("BUSMED_DELEGACION");
	private By panelMediadorCombo = By.id("BUSMED_PANEL");

	private By figurasNivelInferiorNoBtn = By.id("BUSMED_FIGUINFE_NO");
	private By figurasNivelInferiorSiSoloColaboradoresBtn = By.id("BUSMED_FIGUINFE_COLA");
	private By figurasNivelInferiorSiTodosNivelesBtn = By.id("BUSMED_FIGUINFE_TODO");
	private By figurasNivelInferiorSiSoloOficinasBtn = By.id("BUSMED_FIGUINFE_OFIC");

	private By nivelEstructuraIntermediarioBtn = By.id("MEDI_NIESMEDI");
	private By nivelEstructuraOficinaBtn = By.id("MEDI_NIESOFIC");
	private By nivelEstructuraColaboradorBtn = By.id("MEDI_NIESCOLA");

	private By tipoIntermediarioAgenteExclusivoBtn = By.id("MEDI_INTERMAGEX");
	private By tipoIntermediarioAgenteVinculadoBtn = By.id("MEDI_INTERMAGVIN");
	private By tipoIntermediarioBSExclusivoBtn = By.id("MEDI_INTERMBSEX");
	private By tipoIntermediarioBSVinculadoBtn = By.id("MEDI_INTERMBSVIN");
	private By tipoIntermediarioCorredorBtn = By.id("MEDI_INTERMCORR");
	private By tipoIntermediarioProspectBtn = By.id("MEDI_INTERMPROS");
	private By tipoIntermediarioAffinityBtn = By.id("MEDI_INTERMAFFIN");
	private By tipoIntermediarioAcuerdoColaboracionBtn = By.id("MEDI_INTERMACDIS");

	private By estadoPendienteEnvioDGSBtn = By.id("MEDI_ESTPENVDGS");
	private By estadoPendienteAutorizacionDGSBtn = By.id("MEDI_ESTPAUTDGS");
	private By estadoActivoRestringidoBtn = By.id("MEDI_ESTACTIRES");
	private By estadoActivoBtn = By.id("MEDI_ESTACTIVO");
	private By estadoProspectBtn = By.id("MEDI_ESTPROSP");
	private By estadoTramitacionBtn = By.id("MEDI_ESTTRAMIT");
	private By estadoFormacionBtn = By.id("MEDI_ESTFORM");
	private By estadoBajaBtn = By.id("MEDI_ESTBAJA");
	private By estadoBajaTramiteBtn = By.id("MEDI_ESTBATR");
	private By estadoMantenimientoBtn = By.id("MEDI_ESTMANTE");
	private By estadoRechazadoBtn = By.id("MEDI_ESTRECH");

	private By simpleBtn = By.id("filtro1");
	private By avanzadoBtn = By.id("filtro2");
	private By mediadoresBtn = By.id("filtro3");

	//Buscador avanzado
	private By direccionComercialInput = By.id("BUSMED_NOMCALLE");
	private By contactoResponsableIntermediarioInput = By.id("BUSMED_PERSCONT");
	private By gestorPersonalizadoCombo = By.id("BUSMED_GESTPERS");
	private By clavePasarelaInput = By.id("BUSMED_CODIPROS");
	private By agrupadorCombo = By.id("BUSMED_AGRUPADR");
	private By clasificacionContableCombo = By.id("BUSMED_CLASCONT");
	private By actividadPrincipalCombo= By.id("BUSMED_ACTPRINC");
	private By tramitadorConvencionalCombo= By.id("BUSMED_TRAMSINI");
	private By tramitadorAsistenciaCombo= By.id("BUSMED_TRAMASIS");

	private By exportarResultadosBtn = By.cssSelector("ul[class='topnav'] a[href^='#']");
	private By buscarBtn = By.name("botonBuscar");
	// endregion

	private By listaBuscador = By.cssSelector("tr[id*='bloque']");

	public MediadoresBuscadorPage(UserStory userS) {
		super(userS);
	}

	public MediadoresBuscadorPage clickExportarResultados() {
		debugBegin();
		webDriver.clickInFrame(exportarResultadosBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresBuscadorPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, menuFrame);
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

	List<WebElement> tabla = webDriver.getElementsInFrame(listaBuscador, menuFrame);
	debugInfo("La lista es:" + tabla);
	//String codigoMediador = tabla.get(3);

		return this;
	}
}
