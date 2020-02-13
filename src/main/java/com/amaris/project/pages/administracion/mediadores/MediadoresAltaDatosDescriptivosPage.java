package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

import java.util.Random;

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
	//private By estrColabTipoCombo = By.cssSelector("#ALTAMEDI_TIPOCOLA");
	private By estrColabTipoCombo = By.id("ALTAMEDI_TIPOCOLA");
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
	private By nombreComercialInput = By.cssSelector("#ALTAMEDI_NOMBRECOM");
	private By nombreComercialADInput = By.cssSelector("#capaOtroNombre > table > tbody > tr > td:nth-child(2) > input#ALTAMEDI_OTRONOMB");
	private By referenciaExternaInput = By.id("ALTAMEDI_REFEXT");
	private By numRegistroDGSInput = By.id("ALTAMEDI_NREGDGS");
	private By actividadPrincipalCombo = By.id("MEDI_ACTIPRIN");
	private By actividadPrincipalOption = By.cssSelector("#MEDI_ACTIPRIN > option");
	private By agrupPrincCombo = By.id("ALTAMEDI_AGRUPADR");
	private By agrupPrincOption = By.cssSelector("#ALTAMEDI_AGRUPADR > option");
	private By agrupPrincNumInput = By.id("ALTAMEDI_NCOLAAFF");
	private By otroAgrupSIBtn = By.id("ALTAMEDI_SI");
	private By otroAgrupNOBtn = By.id("ALTAMEDI_NO");

	private By avisoSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By anyadirNuevoAgrupadorBtn = By.cssSelector("#capaAgrupadores > div.titulo > div > a");
	private By agrupadorCombo = By.cssSelector("#ALTAMEDI_AGRUPRIN");
	private By agrupadorOption = By.cssSelector("#ALTAMEDI_AGRUPRIN > option");
	private By agrupadorNumeroInput = By.cssSelector("#ALTAMEDI_NUMERO");
	private By grabarAgrupadorBtn = By.cssSelector("#buttonRecord");
	private By cancelarAgrupadorBtn = By.cssSelector("#buttonCancel");
	private By modificarAgrupadorBtn = By.cssSelector("#capaAgrupadores > table > tbody > tr.odd > td:nth-child(4) > a.js-openModal");

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
	private By volverBtn = By.id("botonVolver");

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
		webDriver.click(nombreComercialDiferenteFiscalBtn);
		webDriver.waitWithDriver(2000);
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
			//	webDriver.waitForElementToBePresentInFrame(nivelEstructuraCombo, cuerpoFrame);
			webDriver.waitWithDriver(4000);
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
			webDriver.waitWithDriver(3000);
			if((Constants.TIPO_MEDIADOR).equals("AE") || (Constants.TIPO_MEDIADOR).equals("BSE")) {
				webDriver.clickElementFromDropDownByAttributeInFrame(sexoCombo, sexoOption, cuerpoFrame, "value", "2");
			}
			webDriver.waitWithDriver(3000);
			if(webDriver.isPresentInFrame(medSoftwareNOBtn, cuerpoFrame) || webDriver.isPresentInFrame(medSoftwareSIBtn, cuerpoFrame)) {
				disponibilidadSoftware();
			}
			debugInfo("cuenta con software de seguros");
			webDriver.waitWithDriver(3000);
		}

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreFiscal() {
		debugBegin();
		webDriver.waitWithDriver(3200);
		if(webDriver.isPresentInFrame(nombreFiscalInput, cuerpoFrame) && getTestVar(Constants.NOMBRE_MEDIADOR) != null && !getTestVar(Constants.NOMBRE_MEDIADOR).isEmpty()) {
			webDriver.setTextInFrame(nombreFiscalInput, cuerpoFrame, getTestVar(Constants.NOMBRE_MEDIADOR));
			debugInfo("Ha rellenado nombre fiscal.");
		} else {
			debugInfo("Ha habido un problema al añadir el nombre fiscal");
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
		webDriver.clickElementFromDropDownByAttribute(ejecutivoComercialCombo, ejecutivoComercialOption, "value", getTestVar(Constants.EJECUTIVO_COMERCIAL));
		if(getTestVar(Constants.IDIOMA) != null && !getTestVar(Constants.IDIOMA).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", getTestVar(Constants.IDIOMA));
		} else {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", "ESPA");
		}

		if(webDriver.isPresent(actividadPrincipalCombo) && getTestVar(Constants.ACTIVIDAD_PRINCIPAL) != null && !getTestVar(Constants.ACTIVIDAD_PRINCIPAL).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", getTestVar(Constants.ACTIVIDAD_PRINCIPAL));
		} /*else {
			webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", "ABOG");
		} utilizar método cuando CSV se encuentra chachi*/

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
		if(getTestVar(Constants.NOMBRE_COMERCIAL) != null || !getTestVar(Constants.NOMBRE_COMERCIAL).isEmpty()) {
			if(webDriver.isPresent(nombreComercialDiferenteFiscalBtn)) {
				clickNombreComercialDiferente();
				webDriver.waitWithDriver(2000);
			}

			webDriver.waitWithDriver(3000);
			//	webDriver.setText(nombreComercialADInput, "Mediador"); descomentar si la siguiente línea  y método relacionado si el alta no funciona por su culpa
			completarNombreComercial(getTestVar(Constants.NOMBRE_COMERCIAL).toString());

		} else {
			webDriver.click(nombreComercialIgualFiscalBtn);
		}

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage completarNombreComercial(String nomComercial) {
		debugBegin();
		webDriver.setText(nombreComercialADInput, nomComercial);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage tipoDocumentoApellidos() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.isPresent(tipoDocumentoCombo) && getTestVar(Constants.TIPO_DOCUMENTO) != null && !getTestVar(Constants.TIPO_DOCUMENTO).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", getTestVar(Constants.TIPO_DOCUMENTO));
			setTestVar(Constants.NUMERO_DOCUMENTO_MEDIADOR, DocumentGeneratorHelper.generateNif());
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

	// metodo para alta oficina asociado a un intermediario
	public MediadoresAltaDatosDescriptivosPage altaOficinaDescriptivos() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		altaDatosBasicosComunes("9876543210");

		if(getTestVar(Constants.NOMBRE_COMERCIAL) != null && !getTestVar(Constants.NOMBRE_COMERCIAL).isEmpty()) {

			webDriver.setTextInFrame(nombreComercialInput, getTestVar(Constants.NOMBRE_COMERCIAL), cuerpoFrame);
		} else {
			webDriver.setTextInFrame(nombreComercialInput, "Med01", cuerpoFrame);
		}

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage altaColaboradorDescriptivos() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.isPresent(estrColabTipoCombo) && getTestVar(Constants.TIPO_COLABORADOR) != null && !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(estrColabTipoCombo, estrColabTipoOption, "value", getTestVar(Constants.TIPO_COLABORADOR));
		} else {
			webDriver.clickElementFromDropDownByAttribute(estrColabTipoCombo, estrColabTipoOption, "value", "AD");
		}

		webDriver.exitFrame();

		altaDatosBasicosComunes("9876543210");

		if(getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD")) {
			nombreFiscal();
			tipoDocumentoApellidos();
			nombreComercial();
		} else {
			webDriver.setTextInFrame(nombreComercialInput, cuerpoFrame, getTestVar(Constants.NOMBRE_COMERCIAL));
		}

		webDriver.waitWithDriver(3000);

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage disponibilidadSoftware() {
		debugBegin();
		if(getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED) != null || !getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).isEmpty() || getTestVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED)
			.equalsIgnoreCase("TRUE")) {
			clickDisponeSoftwareSi();
		} else {
			webDriver.clickInFrame(medSoftwareNOBtn, cuerpoFrame);
		}

		debugEnd();
		return this;
	}

	// acaban los métodos complejos

	//------------------------RETENCIONES---------------------------------

	//Generador de Dgs numero
	public static String generadorRandomDgsNumero() {

		return Integer.toString(new Random().nextInt(99999) + 11111);
	}

	public boolean alertaSistemaDescriptivos(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	//-------------------------------RETENCIONES PARA ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR----------------------------------

	public MediadoresAltaDatosDescriptivosPage retencionesAltaDescriptivos() {
		debugBegin();

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NIVEL_ESTRUCTURA_MEDIADORES);
		webDriver.acceptAlert();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "INTE");
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "OFIC");
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "COLA");
		}

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_MEDIADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AD");
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_MEDIADOR_PADRE_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(mediadorPadreOficinaInput, "1245" , cuerpoFrame);

		}
/*
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_OFICINA_PADRE_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(estrColabOficinaPadreInput, "700001", cuerpoFrame);

			webDriver.waitWithDriver(5000);

		}
*/
		clickContinuar();
/*
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_COLABORADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(estrColabTipoCombo, estrColabTipoOption, cuerpoFrame, "value", "AD");

			clickContinuar();
		}
*/
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EJECUTIVO_COMERCIAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(ejecutivoComercialCombo, ejecutivoComercialOption, cuerpoFrame, "value", "4000");

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_IDIOMA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(idiomaCombo, idiomaOption, cuerpoFrame, "value", "ESPA");
		webDriver.waitWithDriver(3000);

		clickContinuar();


		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_COMERCIAL_2_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(nombreComercialInput, cuerpoFrame, "Nombre");

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DOCUMENTO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.waitWithDriver(3000);
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoDocumentoCombo, tipoDocumentoOption, cuerpoFrame, "value", "NIF");

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_DOCUMENTO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(numeroDocumentoInput, "Numero documento", cuerpoFrame);
			webDriver.waitWithDriver(3000);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_FISCAL_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(nombreFiscalInput, "Nombre", cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PRIMER_APELLIDO_MEDIADORES);

			webDriver.acceptAlert();

			webDriver.setTextInFrame(primerApellidoInput, "Primer Apellido", cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEGUNDO_APELLIDO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(segundoApellidoInput, "Segundo Apellido", cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_COMERCIAL_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.clickInFrame(nombreComercialDiferenteFiscalBtn, cuerpoFrame);

			webDriver.clearTextInFrame(nombreComercialADInput, cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_COMERCIAL_2_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(nombreComercialADInput, "Nombre comercial", cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ACTIVIDAD_PRINCIPAL_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(actividadPrincipalCombo, actividadPrincipalOption, cuerpoFrame, "value", "ABOG");

		}

		//cambio a agente vinculado para probar campos
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AV");

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_REGISTRO_DGS_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(numRegistroDGSInput, generadorRandomDgsNumero(), cuerpoFrame);

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DISPONE_SOFTWARE_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.waitWithDriver(3000);

			clickDisponeSoftwareSi();
		}

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaDescriptivos(Constants.ALERTA_MEDIADOR_PADRE_MEDIADORES_INCORRECTO);
			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.setTextInFrame(mediadorPadreOficinaInput, "1242", cuerpoFrame);

			clickContinuar();
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaDescriptivos(Constants.ALERTA_NUMERO_DOCUMENTO_1_MEDIADORES);

			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.setTextInFrame(numeroDocumentoInput, DocumentGeneratorHelper.generateNif(), cuerpoFrame);

		}
/*
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(estrColabTipoCombo, estrColabTipoOption, cuerpoFrame, "value", "AUXI");
		}
*/
		//cambio a agente exclusivo para probar campos
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AE");

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEXO_MEDIADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(sexoCombo, sexoOption, cuerpoFrame, "value", "1");

			clickContinuar();
		}



		debugEnd();
		return this;
	}

}
