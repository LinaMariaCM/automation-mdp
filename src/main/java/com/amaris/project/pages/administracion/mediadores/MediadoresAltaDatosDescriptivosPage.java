package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaDeclaracionSiniestrosPage;
import com.amaris.project.utils.ChecksUtils;
import com.sun.tools.jxc.ap.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.amaris.project.pages.administracion.mediadores.MediadoresHomePage;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

public class MediadoresAltaDatosDescriptivosPage extends PageObject {

	//------------ Datos básicos --------------------

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By tituloPaginaTxt = By.cssSelector("h1.titulopagina"); // a borrar cuando exista un "enlace" entre alta y ficha
	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By nivelEstructuraOption = By.cssSelector("#MEDI_NIVEESTR > option");
	private By tipoMediadorCombo = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By tipoMediadorOption = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA > option");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");
	private By ejecutivoComercialOption = By.cssSelector("#MEDI_EJECCOME > option");
	private By mediadorPadreOficinaInput = By.cssSelector("#ALTAMEDI_MEDPADRE");
	private By estrColabOficinaPadreInput = By.cssSelector("#ALTAMEDI_OFIPADRE");
	private By seleccionarOficinaPadreBtn = By.cssSelector("#capaTipoColaborador > table:nth-child(2) > tbody > tr > td:nth-child(3) > div > a");
	private By estrColabTipoCombo = By.cssSelector("#ALTAMEDI_TIPOCOLA");
	private By estrColabTipoOption = By.cssSelector("#ALTAMEDI_TIPOCOLA > option");

	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");
	private By idiomaOption = By.cssSelector("#MEDI_IDIOMA > option");

	private By sexoCombo = By.cssSelector("#ALTAMEDI_SEXOMEDIDGS");
	private By sexoOption = By.cssSelector("#ALTAMEDI_SEXOMEDIDGS > option");

	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPODOCMED");
	private By tipoDocumentoOption = By.cssSelector("#ALTAMEDI_TIPODOCMED > option");
	private By numeroDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOC");
	//	private By nombreFiscalInput = By.id("ALTAMEDI_NOMFISCMED");
	private By nombreFiscalInput = By.cssSelector("#ALTAMEDI_NOMFISCMED");
	private By primerApellidoInput = By.id("ALTAMEDI_APE1FISC");
	private By segundoApellidoInput = By.id("ALTAMEDI_APE2FISC");
	private By nombreComercialIgualFiscalBtn = By.id("ALTAMEDI_NOMCOIGU");
	private By nombreComercialDiferenteFiscalBtn = By.id("ALTAMEDI_NOMCODIF");
	private By nombreComercialInput = By.cssSelector("#ALTAMEDI_OTRONOMB");
	private By referenciaExternaInput = By.id("ALTAMEDI_REFEXT");
	private By numRegistroDGSInput = By.id("ALTAMEDI_NREGDGS");
	private By actividadPrincipalCombo = By.id("MEDI_ACTIPRIN");
	private By actividadPrincipalOption = By.cssSelector("#MEDI_ACTIPRIN > option");
	private By agrupPrincCombo = By.id("ALTAMEDI_AGRUPADR");
	private By agrupPrincOption = By.cssSelector("#ALTAMEDI_AGRUPADR > option");
	private By agrupPrincNumInput = By.id("ALTAMEDI_NCOLAAFF");
	private By otroAgrupSIBtn = By.id("ALTAMEDI_SI");
	private By otroAgrupNOBtn = By.id("ALTAMEDI_NO");

	private By anyadirNuevoAgrupadorBtn = By.cssSelector("#capaAgrupadores > div.titulo > div > a");
	private By agrupadorCombo = By.cssSelector("#ALTAMEDI_AGRUPRIN");
	private By agrupadorOption = By.cssSelector("#ALTAMEDI_AGRUPRIN > option");
	private By agrupadorNumeroInput = By.cssSelector("#ALTAMEDI_NUMERO");
	private By grabarAgrupadorBtn = By.cssSelector("#buttonRecord");
	private By cancelarAgrupadorBtn = By.cssSelector("#buttonCancel");

	//------------ Datos adicionales -----------------------

	private By edadCombo = By.id("ALTAMEDI_ANYONACAPROX");
	private By edadOption = By.cssSelector("#ALTAMEDI_ANYONACAPROX  > option");
	private By estudiosCombo = By.id("ALTAMEDI_NIVEESTU");
	private By estudiosOption = By.cssSelector("#ALTAMEDI_NIVEESTU > option");
	private By afinidadTecnoCombo = By.id("ALTAMEDI_NIVEAFIN");
	private By afinidadTecnoOption = By.cssSelector("#ALTAMEDI_NIVEAFIN > option");
	private By numEmpleadosInput = By.id("ALTAMEDI_NUMEMPSINTIT");

	private By medTieneOficinaSIBtn = By.id("ALTAMEDI_OFISI");
	private By medOficinaNumInput = By.id("ALTAMEDI_CUANTAS");
	private By medTieneOficianNOBtn = By.id("ALTAMEDI_OFINO");

	private By medAuxiliaresSIBtn = By.id("ALTAMEDI_TRABAJASI");
	private By medAuxiliaresNumInput = By.id("ALTAMEDI_CUANTOS");
	private By medAuxiliaresNOBtn = By.id("ALTAMEDI_TRABAJANO");

	private By medSoftwareSIBtn = By.id("ALTAMEDI_SOFTSI");
	private By medSoftwareNOBtn = By.id("ALTAMEDI_SOFTNO");

	private By medPuestoTrabajoCombo = By.id("ALTAMEDI_DONDETRABAJA");
	private By medPuestoTrabajoOption = By.cssSelector("#ALTAMEDI_DONDETRABAJA > option");

	private By nuevoProspectAbrirModalBtn = By.cssSelector("ALTAMEDI_AGRUPRIN");
	private By codigoNuevoProspectModalInput = By.cssSelector("#ALTAMEDI_CODPROSP");
	private By confirmarProspectBtn = By.cssSelector("#capaNombreProspect > div.contentBox.widthstd > div.marcofnd > table > tbody > tr:nth-child(1) > td:nth-child(3) > a");
	private By cerrarNuevoProspectModalBtn = By.cssSelector("#buttonClose");

	//--------- Controles página ---------

	private By cancelarDescripcionBtn = By.id("botonCancelar1");
	private By guardarDescripcionBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");
	private By grabarBtn = By.id("botonGrabar1");

	public MediadoresAltaDatosDescriptivosPage(UserStory userS) {
		super(userS);
	}

	//-------------Añadir datos basicos---------------
	public MediadoresAltaDatosDescriptivosPage anyadirDatosBasicos(String idioma, String nombreFiscal, String primerApell, String segApell, String refExterna, String numRegDGS, String actividPrinci,
		String agrupPrinci, String numeroAgru) {
		debugBegin();
		if(idioma.isEmpty()) idioma = "ESPA";
		if(actividPrinci.isEmpty()) actividPrinci = "ABOG";
		if(agrupPrinci.isEmpty()) agrupPrinci = "1";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", idioma);
		webDriver.setText(nombreFiscalInput, nombreFiscal);
		webDriver.setText(primerApellidoInput, primerApell);
		webDriver.setText(segundoApellidoInput, segApell);
		webDriver.click(nombreComercialIgualFiscalBtn);
		webDriver.setText(referenciaExternaInput, refExterna);
		webDriver.setText(numRegistroDGSInput, numRegDGS);
		webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", actividPrinci);
		webDriver.clickElementFromDropDownByAttribute(agrupPrincCombo, agrupPrincOption, "value", agrupPrinci);
		webDriver.setText(agrupadorNumeroInput, numeroAgru);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-------------Añadir datos adicionales---------------
	public MediadoresAltaDatosDescriptivosPage anyadirDatosAdicionales(String edad, String nivelEstudio, String afinidadTecno, String numEmpleado, String dondeTrabaja) {
		debugBegin();
		if(edad.isEmpty()) edad = "3040";
		if(nivelEstudio.isEmpty()) nivelEstudio = "ALTO";
		if(afinidadTecno.isEmpty()) afinidadTecno = "ALTO";
		if(dondeTrabaja.isEmpty()) dondeTrabaja = "DOPA";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(edadCombo, edadOption, "value", edad);
		webDriver.clickElementFromDropDownByAttribute(estudiosCombo, estudiosOption, "value", nivelEstudio);
		webDriver.clickElementFromDropDownByAttribute(afinidadTecnoCombo, afinidadTecnoOption, "value", afinidadTecno);
		webDriver.setText(numEmpleadosInput, numEmpleado);
		webDriver.click(medTieneOficianNOBtn);
		webDriver.click(medAuxiliaresNOBtn);
		webDriver.click(medSoftwareNOBtn);
		webDriver.clickElementFromDropDownByAttribute(medPuestoTrabajoCombo, medPuestoTrabajoOption, "value", dondeTrabaja);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-------------Añadir nuevo prospect relacionado---------------
	public MediadoresAltaDatosDescriptivosPage anyadirProspectRelacionado(String codigoProspect) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(nuevoProspectAbrirModalBtn);
		webDriver.setText(codigoNuevoProspectModalInput, codigoProspect);
		webDriver.click(confirmarProspectBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage anyadirNuevoAgrupador(String agrupador, String numeroAgrupador) {
		debugBegin();
		if(agrupador.isEmpty()) agrupador = "3040";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevoAgrupadorBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(agrupadorCombo, agrupadorOption, "value", agrupador);
		webDriver.setText(agrupadorNumeroInput, numeroAgrupador);
		webDriver.click(grabarAgrupadorBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-------------Clicks botones---------------
	public MediadoresAltaDatosDescriptivosPage clickCerrarProspectRelacionado() {
		debugBegin();
		webDriver.switchToFrame(modalFrame);
		webDriver.clickInFrame(cerrarNuevoProspectModalBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickCancelarDescripcion() {
		debugBegin();
		webDriver.clickInFrame(cancelarDescripcionBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickGuardarYSalir() {
		debugBegin();
		webDriver.clickInFrame(guardarDescripcionBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickGrabar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickGrabarAgrupador() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarAgrupadorBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickCancelarAgrupador() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarAgrupadorBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickNombreComercialDiferente() {
		debugBegin();
		webDriver.clickInFrame(nombreComercialDiferenteFiscalBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDescriptivosPage clickDisponeSoftwareSi() {
		debugBegin();
		webDriver.clickInFrame(medSoftwareSIBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// ------------------------------------------ Métodos complejos -----------------------------------------

	public MediadoresAltaDatosDescriptivosPage altaIntermediarioDescriptivos() {
		debugBegin();
	//	if(webDriver.isPresentInFrame(nivelEstructuraCombo, cuerpoFrame) &&
			if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			webDriver.waitForElementToBePresentInFrame(nivelEstructuraCombo, cuerpoFrame);
			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", getTestVar(Constants.NIVEL_ESTRUCTURA));
			webDriver.waitWithDriver(3000);
			debugInfo("nivel de estructura seleccionado");
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", getTestVar(Constants.TIPO_MEDIADOR));
			webDriver.waitWithDriver(3000);

			debugInfo("tipo de mediador seleccionado");
			altaDatosBasicosComunes("9876543210");
			debugInfo("datos básicos rellenados");
			//		webDriver.waitWithDriver(3000);
			nombreFiscal();
			debugInfo("nombre fiscal introducido");
			//		webDriver.waitWithDriver(3000);
			tipoDocumentoApellidos();
			debugInfo("apellidos introducido");
			//		webDriver.waitWithDriver(3000);
			nombreComercial();
			debugInfo("nombre comercial introducido");
			//		webDriver.waitWithDriver(3000);

			webDriver.clickElementFromDropDownByAttributeInFrame(sexoCombo, sexoOption, cuerpoFrame, "value", "2");
			webDriver.waitWithDriver(3000);
			clickDisponeSoftwareSi(); // de momento, valor predeterminado, evaluar en futuro si cambiarlo y tirar del CSV. Evaluar si añadir un boolean para gestionar cuando es Si y No.
			debugInfo("cuenta con software de seguros");
		//	nombreFiscalVacio();
			debugInfo("Comprobar uso alertas");
			nombreFiscal();
			webDriver.waitWithDriver(3000);
	/*	}else{
			MediadoresHomePage.openAltaMediador();*/

		}

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreFiscal() {
		debugBegin();
		if(webDriver.isPresentInFrame(nombreFiscalInput, cuerpoFrame) && getTestVar(Constants.NOMBRE_MEDIADOR) != null && !getTestVar(Constants.NOMBRE_MEDIADOR).isEmpty()) {
			webDriver.setTextInFrame(nombreFiscalInput, cuerpoFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
		}
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreFiscalVacio() {
		debugBegin();

		webDriver.clearTextInFrame(nombreFiscalInput, cuerpoFrame);
		clickGuardarYSalir();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_FISCAL_MEDIADORES);
		webDriver.acceptAlert();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage altaDatosBasicosComunes(String numRegDGS) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(ejecutivoComercialCombo, ejecutivoComercialOption, "value", "4000");
		if(getTestVar(Constants.IDIOMA) != null && !getTestVar(Constants.IDIOMA).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", getTestVar(Constants.IDIOMA));
		} else {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", "ESPA");
		}

		if(getTestVar(Constants.ACTIVIDAD_PRINCIPAL) != null && !getTestVar(Constants.ACTIVIDAD_PRINCIPAL).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		} else {
			webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", "ABOG");
		}

		if(webDriver.isPresent(numRegistroDGSInput)) {
			webDriver.setText(numRegistroDGSInput, numRegDGS);
		}

		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreComercial() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		// si en el CSV no hay dato en el campo Nombre comercial, se activa la opción "Igual que fiscal", si hay un nombre en el CSV, se activa la opción "Diferente" y se añade el nombre
		if(getTestVar(Constants.NOMBRE_COMERCIAL) != null && !getTestVar(Constants.NOMBRE_COMERCIAL).isEmpty()) {
			if(webDriver.isPresent(nombreComercialDiferenteFiscalBtn)) {
				clickNombreComercialDiferente();
			}
			webDriver.setText(nombreComercialInput, getTestVar(Constants.NOMBRE_COMERCIAL));
		} else {
			webDriver.click(nombreComercialIgualFiscalBtn);
		}
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage tipoDocumentoApellidos() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
			if(webDriver.isPresent(tipoDocumentoCombo) && getTestVar(Constants.TIPO_DOCUMENTO) != null && !getTestVar(Constants.TIPO_DOCUMENTO).isEmpty()) {
				webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", getTestVar(Constants.TIPO_DOCUMENTO));
				setTestVar(Constants.NUMERO_DOCUMENTO_MEDIADOR, DniGeneratorHelper.generateNif());
				webDriver.setText(numeroDocumentoInput, getTestVar(Constants.NUMERO_DOCUMENTO_MEDIADOR));

				if(getTestVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIF") || getTestVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIE")) {
					webDriver.setText(primerApellidoInput, "primerApell");
				}
				if(getTestVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIF")) {
					webDriver.setText(segundoApellidoInput, "segundoApell");
				}
			}

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	// acaban los métodos complejos
}
