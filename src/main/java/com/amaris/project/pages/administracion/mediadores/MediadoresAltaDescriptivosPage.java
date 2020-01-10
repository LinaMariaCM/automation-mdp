package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDescriptivosPage extends PageObject {

	//------------ Datos básicos -----------

	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By tipoMediadorCombo = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");
	private By mediadorPadreOficinaInput = By.cssSelector("#ALTAMEDI_MEDPADRE");
	private By estrColabOficinaPadreInput = By.cssSelector("#ALTAMEDI_OFIPADRE");
	private By seleccionarOficinaPadreBtn = By.cssSelector("#capaTipoColaborador > table:nth-child(2) > tbody > tr > td:nth-child(3) > div > a");
	private By estrColabTipoCombo = By.cssSelector("#ALTAMEDI_TIPOCOLA");

	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");

	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPODOCMED");
	private By numeroDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOC");
	private By nombreFiscalInput = By.id("ALTAMEDI_NOMFISCMED");
	private By primerApellidoInput = By.id("ALTAMEDI_APE1FISC");
	private By segundoApellidoInput = By.id("ALTAMEDI_APE2FISC");
	private By nombreComercialIgualFiscalBtn = By.id("ALTAMEDI_NOMCOIGU");
	private By nombreComercialDiferenteFiscalBtn = By.id("ALTAMEDI_NOMCODIF");
	private By referenciaExternaInput = By.id("ALTAMEDI_REFEXT");
	private By numRegistroDGSInput = By.id ("ALTAMEDI_NREGDGS");
	private By actividadPrincipalCombo = By.id("MEDI_ACTIPRIN");
	private By agrupPrincCombo = By.id("ALTAMEDI_AGRUPADR");
	private By agrupPrincNumInput = By.id("ALTAMEDI_NCOLAAFF");
	private By otroAgrupSIBtn = By.id("ALTAMEDI_SI");
	private By otroAgrupNOBtn = By.id("ALTAMEDI_NO");

	private By anyadirNuevoAgrupadorBtn = By.cssSelector("#capaAgrupadores > div.titulo > div > a");
	private By agrupadorCombo = By.cssSelector("#ALTAMEDI_AGRUPRIN");
	private By agrupadorNumeroInput = By.cssSelector("#ALTAMEDI_NUMERO");
	private By grabarAgrupadorBtn = By.cssSelector("#buttonRecord");
	private By cancelarAgrupadorBtn = By.cssSelector("#buttonCancel");

	//------------ Datos adicionales -----------

	private By medEdadCombo = By.id("ALTAMEDI_ANYONACAPROX");
	private By medEstudiosCombo = By.id("ALTAMEDI_NIVEESTU");
	private By medAfinidadTecnoCombo = By.id("ALTAMEDI_NIVEAFIN");
	private By medNumEmpleadosInput = By.id("ALTAMEDI_NUMEMPSINTIT");

	private By medTieneOficinaSIBtn = By.id("ALTAMEDI_OFISI");
	private By medOficinaNumInput = By.id("ALTAMEDI_CUANTAS");
	private By medTieneOficianNOBtn = By.id("ALTAMEDI_OFINO");

	private By medAuxiliaresSIBtn = By.id("ALTAMEDI_TRABAJASI");
	private By medAuxiliaresNumInput = By.id("ALTAMEDI_CUANTOS");
	private By medAuxiliaresNOBtn = By.id("ALTAMEDI_TRABAJANO");

	private By medSoftwareSIBtn = By.id("ALTAMEDI_SOFTSI");
	private By medSoftwareNOBtn = By.id("ALTAMEDI_SOFTNO");

	private By medPuestoTrabajoCombo = By.id("ALTAMEDI_DONDETRABAJA");

	private By nuevoProspectAbrirModalBtn = By.cssSelector("ALTAMEDI_AGRUPRIN");
	private By codigoNuevoProspectModalInput = By.cssSelector("#ALTAMEDI_CODPROSP");
	private By confirmarProspectBtn = By.cssSelector("#capaNombreProspect > div.contentBox.widthstd > div.marcofnd > table > tbody > tr:nth-child(1) > td:nth-child(3) > a");
	private By cerrarNuevoProspectModalBtn= By.cssSelector("#buttonClose");

	//--------- Controles página ---------

	private By cancelarDescripcionBtn = By.id("botonCancelar1");
	private By guardarDescripcionBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");
	private By grabarBtn = By.id("botonGrabar1");


	public MediadoresAltaDescriptivosPage(UserStory userS) {
		super(userS);
	}

}
