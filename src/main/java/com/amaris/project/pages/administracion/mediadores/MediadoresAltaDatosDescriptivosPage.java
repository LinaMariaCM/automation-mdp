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

	private By nivelEstructuraCombo = By.cssSelector("#MEDI_NIVEESTR");
	private By nivelEstructuraOption = By.cssSelector("#MEDI_NIVEESTR > option");
	private By tipoMediadorCombo = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA");
	private By tipoMediadorOption = By.cssSelector("#ALTAMEDI_TIPOMEDIALTA > option");
	private By ejecutivoComercialCombo = By.cssSelector("#MEDI_EJECCOME");
	private By ejecutivoComercialOption = By.cssSelector("#MEDI_EJECCOME > option");
	private By mediadorPadreOficinaInput = By.cssSelector("#ALTAMEDI_MEDPADRE");
	private By estrColabOficinaPadreInput = By.cssSelector("#ALTAMEDI_OFIPADRE");
	private By estrColabTipoCombo = By.id("ALTAMEDI_TIPOCOLA");
	private By estrColabTipoOption = By.cssSelector("#ALTAMEDI_TIPOCOLA > option");

	private By idiomaCombo = By.cssSelector("#MEDI_IDIOMA");
	private By idiomaOption = By.cssSelector("#MEDI_IDIOMA > option");

	private By sexoCombo = By.cssSelector("#ALTAMEDI_SEXOMEDIDGS");
	private By sexoOption = By.cssSelector("#ALTAMEDI_SEXOMEDIDGS > option");

	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPODOCMED");
	private By tipoDocumentoOption = By.cssSelector("#ALTAMEDI_TIPODOCMED > option");
	private By numeroDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOC");
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

	private By avisoSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By anyadirNuevoAgrupadorBtn = By.cssSelector("#capaAgrupadores > div.titulo > div > a");
	private By agrupadorCombo = By.cssSelector("#ALTAMEDI_AGRUPRIN");
	private By agrupadorOption = By.cssSelector("#ALTAMEDI_AGRUPRIN > option");
	private By agrupadorNumeroInput = By.cssSelector("#ALTAMEDI_NUMERO");
	private By grabarAgrupadorBtn = By.cssSelector("#buttonRecord");

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

	//--------- Controles página ---------

	private By continuarBtn = By.id("botonContinuar1");
	private By grabarBtn = By.id("botonGrabar1");
	private By volverBtn = By.id("botonVolver");

	public MediadoresAltaDatosDescriptivosPage(UserStory userS) {
		super(userS);
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

	public MediadoresAltaDatosDescriptivosPage clickDisponeSoftwareSi() {
		debugBegin();
		webDriver.clickInFrame(medSoftwareSIBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	// ------------------------------------------ Métodos complejos -----------------------------------------

	public MediadoresAltaDatosDescriptivosPage altaIntermediarioDescriptivos() {
		debugBegin();

		if(getScenarioVar(Constants.NIVEL_ESTRUCTURA) != null && !getScenarioVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			webDriver.waitWithDriver(4000);
			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", getScenarioVar(Constants.NIVEL_ESTRUCTURA));
			webDriver.waitWithDriver(3000);
			debugInfo("Nivel de estructura seleccionado.");
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", getScenarioVar(Constants.TIPO_MEDIADOR));
			webDriver.waitWithDriver(3000);

			debugInfo("Tipo de mediador seleccionado.");

			altaDatosBasicosComunes();
			debugInfo("Datos básicos rellenados.");

			nombreFiscal();
			debugInfo("Nombre fiscal introducido.");

			apellidosMediador();
			debugInfo("Apellidos introducidos.");

			nombreComercial();
			debugInfo("Nombre Comercial introducido.");
			webDriver.waitWithDriver(3000);

			if(webDriver.isPresentInFrame(sexoCombo, cuerpoFrame)) {
				webDriver.clickElementFromDropDownByAttributeInFrame(sexoCombo, sexoOption, cuerpoFrame, "value", "2");
			}
			webDriver.waitWithDriver(3000);

			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				disponibilidadSoftware();
			}
			debugInfo("Cuenta con software de seguros.");
			webDriver.waitWithDriver(3000);
		}

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreFiscal() {
		debugBegin();

		if(webDriver.isPresentInFrame(nombreFiscalInput, cuerpoFrame) && getScenarioVar(Constants.NOMBRE_MEDIADOR) != null && !getScenarioVar(Constants.NOMBRE_MEDIADOR).isEmpty()) {
			webDriver.setTextInFrame(nombreFiscalInput, cuerpoFrame, getScenarioVar(Constants.NOMBRE_MEDIADOR));
			debugInfo("Ha rellenado el Nombre Fiscal.");
		} else {
			debugInfo("Ha heredado el Nombre Fiscal del superior.");
		}
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage altaDatosBasicosComunes() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.waitWithDriver(2000);
		webDriver.clickElementFromDropDownByAttribute(ejecutivoComercialCombo, ejecutivoComercialOption, "value", getScenarioVar(Constants.EJECUTIVO_COMERCIAL));
		if(getScenarioVar(Constants.IDIOMA) != null && !getScenarioVar(Constants.IDIOMA).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", getScenarioVar(Constants.IDIOMA));
		} else {
			webDriver.clickElementFromDropDownByAttribute(idiomaCombo, idiomaOption, "value", "ESPA");
		}

		if(webDriver.isPresent(actividadPrincipalCombo) && getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL) != null && !getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(actividadPrincipalCombo, actividadPrincipalOption, "value", getScenarioVar(Constants.ACTIVIDAD_PRINCIPAL));
		}

		if(webDriver.isPresent(numRegistroDGSInput)) {
			webDriver.setText(numRegistroDGSInput, generadorRandomDgsNumero());
		}
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage completarNombreComercial(String nomComercial) {
		debugBegin();
		debugInfo("En posición de completar Nombre Comercial.");
		webDriver.setText(nombreComercialInput, nomComercial);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage completarNombreComercialDiferente(String nomComercial) {
		debugBegin();
		webDriver.click(nombreComercialDiferenteFiscalBtn);
		webDriver.waitWithDriver(3000);
		debugInfo("En posición de completar Nombre Comercial.");
		webDriver.setText(nombreComercialADInput, nomComercial);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage nombreComercial() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.isPresent(nombreComercialInput)) {
			completarNombreComercial(getScenarioVar(Constants.NOMBRE_COMERCIAL));
		} else if(!getScenarioVar(Constants.NOMBRE_COMERCIAL).isEmpty()) {
			completarNombreComercialDiferente(getScenarioVar(Constants.NOMBRE_COMERCIAL));
		} else {
			webDriver.click(nombreComercialIgualFiscalBtn);
		}

		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage tipoDocumento() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.isPresent(tipoDocumentoCombo) && getScenarioVar(Constants.TIPO_DOCUMENTO) != null && !getScenarioVar(Constants.TIPO_DOCUMENTO).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", getScenarioVar(Constants.TIPO_DOCUMENTO));
			if(getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("CIF")) {
				webDriver.setText(numeroDocumentoInput, DocumentGeneratorHelper.generateCIF());
			} else if(getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIF")) {
				webDriver.setText(numeroDocumentoInput, DocumentGeneratorHelper.generateNif());
			} else if(getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIE")) {
				webDriver.setText(numeroDocumentoInput, DocumentGeneratorHelper.generateNIE());
			}

		}
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage apellidosMediador() {
		debugBegin();

		tipoDocumento();

		webDriver.switchToFrame(cuerpoFrame);

		if(getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIF") || getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIE")) {
			webDriver.setText(primerApellidoInput, getScenarioVar(Constants.PRIMER_APELLIDO_MEDIADOR));
		}

		if(getScenarioVar(Constants.TIPO_DOCUMENTO).equalsIgnoreCase("NIF")) {
			webDriver.setText(segundoApellidoInput, getScenarioVar(Constants.SEGUNDO_APELLIDO_MEDIADOR));
		}

		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage altaOficinaDescriptivos() {
		debugBegin();

		altaDatosBasicosComunes();
		nombreComercial();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage altaColaboradorDescriptivos() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		if(webDriver.isPresent(estrColabTipoCombo) && getScenarioVar(Constants.TIPO_COLABORADOR) != null && !getScenarioVar(Constants.TIPO_COLABORADOR).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(estrColabTipoCombo, estrColabTipoOption, "value", getScenarioVar(Constants.TIPO_COLABORADOR));
		}

		webDriver.exitFrame();

		altaDatosBasicosComunes();

		if(getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD") || getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {
			nombreFiscal();
			tipoDocumento();
			apellidosMediador();
			nombreComercial();
		} else {
			webDriver.setTextInFrame(nombreComercialInput, cuerpoFrame, getScenarioVar(Constants.NOMBRE_COMERCIAL));
		}

		webDriver.waitWithDriver(3000);

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDescriptivosPage disponibilidadSoftware() {
		debugBegin();
		if(getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED) != null || !getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED).isEmpty() || getScenarioVar(Constants.DISPONTE_DE_SOFTWARE_ALT_MED)
			.equalsIgnoreCase("TRUE")) {
			clickDisponeSoftwareSi();
		} else {
			webDriver.clickInFrame(medSoftwareNOBtn, cuerpoFrame);
		}

		debugEnd();
		return this;
	}

	//--------------------RETENCIONES PARA ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR------------------------------//

	//--GENERADOR DE NÚMERO DGS--
	public static String generadorRandomDgsNumero() {

		return Integer.toString(new Random().nextInt(99999) + 11111);
	}

	public boolean alertaSistemaDescriptivos(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public MediadoresAltaDatosDescriptivosPage retencionesAltaDescriptivos() {
		debugBegin();

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NIVEL_ESTRUCTURA_MEDIADORES);
		webDriver.acceptAlert();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "INTE");
			debugInfo("Se ha elegido en Nivel de estructura a un Intermediario.");
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "OFIC");
			debugInfo("Se ha elegido en Nivel de estructura a una Oficina.");

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(nivelEstructuraCombo, nivelEstructuraOption, cuerpoFrame, "value", "COLA");
			debugInfo("Se ha elegido en Nivel de estructura a un Colaborador.");
		}

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_MEDIADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AD");
			debugInfo("Se ha elegido en Nivel estructura a un Intermediario y un tipo Mediador a Acuerdo de Colaboración.");
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_MEDIADOR_PADRE_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(mediadorPadreOficinaInput, "1245", cuerpoFrame);

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_OFICINA_PADRE_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(estrColabOficinaPadreInput, "700001", cuerpoFrame);

			webDriver.waitWithDriver(5000);

		}

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_COLABORADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(estrColabTipoCombo, estrColabTipoOption, cuerpoFrame, "value", "AD");
			debugInfo("Se ha elegido en Nivel estructura a un Colaborador de tipo Acuerdo de Distribución.");

			clickContinuar();
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_COLABORADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(estrColabTipoCombo, estrColabTipoOption, cuerpoFrame, "value", "GEST");
			debugInfo("Se ha elegido en Nivel estructura a un Colaborador de tipo Gestor.");

			clickContinuar();

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_COLABORADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(estrColabTipoCombo, estrColabTipoOption, cuerpoFrame, "value", "AUXI");
			debugInfo("Se ha elegido en Nivel estructura a un Colaborador de tipo Auxiliar.");

			clickContinuar();

		}

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EJECUTIVO_COMERCIAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(ejecutivoComercialCombo, ejecutivoComercialOption, cuerpoFrame, "value", "4000");
		debugInfo("Se ha elegido a un ejecutivo Comercial.");

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_IDIOMA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(idiomaCombo, idiomaOption, cuerpoFrame, "value", "ESPA");
		webDriver.waitWithDriver(3000);
		debugInfo("Se ha elegido un idioma.");

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			|| getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			|| getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_COMERCIAL_2_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(nombreComercialInput, cuerpoFrame, "Nombre");

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

			clickContinuar();

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			clickContinuar();

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DOCUMENTO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.waitWithDriver(3000);
			webDriver.clickElementFromDropDownByAttributeInFrame(tipoDocumentoCombo, tipoDocumentoOption, cuerpoFrame, "value", "NIF");
			debugInfo("Se ha elegido Tipo de Documento NIF.");

			clickContinuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_DOCUMENTO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(numeroDocumentoInput, "Numero", cuerpoFrame);
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

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ACTIVIDAD_PRINCIPAL_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(actividadPrincipalCombo, actividadPrincipalOption, cuerpoFrame, "value", "ABOG");
			debugInfo("Se ha elegido una Actividad Principal.");
		}

		//cambio a intermediario: agente vinculado para probar campos
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AV");
			debugInfo("Se ha elegido en Nivel estructura a un Intermediario de tipo Mediador Agente Vinculado.");

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
			debugInfo("Se ha elegido un Mediador Padre Oficina.");

			clickContinuar();
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			alertaSistemaDescriptivos(Constants.ALERTA_NUMERO_DOCUMENTO_1_MEDIADORES);

			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.setTextInFrame(numeroDocumentoInput, DocumentGeneratorHelper.generateNif(), cuerpoFrame);

		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			clickContinuar();

		}

		//cambio a intermediario: agente exclusivo para probar campos
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoMediadorCombo, tipoMediadorOption, cuerpoFrame, "value", "AE");
			debugInfo("Se ha elegido en Nivel estructura a un Intermediario de tipo Mediador: Agente Exclusivo.");

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
