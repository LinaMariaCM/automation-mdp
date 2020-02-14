package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class MediadoresAltaDatosDGSPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//-----------General---------------------------------
	private By tipoDocRepresentCombo = By.cssSelector("#ALTAMEDI_DOCREPR");
	private By tipoDocRepresentOption = By.cssSelector("#ALTAMEDI_DOCREPR > option");
	private By numDocRepresentInput = By.cssSelector("#ALTAMEDI_NUMDOCREPR");
	private By nombreRepresentInput = By.cssSelector("#ALTAMEDI_NOMBREPR");
	private By primApellidoRepresentInput = By.cssSelector("#ALTAMEDI_APE1REPR");
	private By segApellidoRepresentInput = By.cssSelector("#ALTAMEDI_APE2REPR");

	private By fechaIniContratoInput = By.cssSelector("#ALTAMEDI_FEINICON");

	//------------------Altos cargos---------------------
	private By anyadirAltoNuevoCargoBtn = By.cssSelector("#capaAltosCargos > div > div.floatright.peq > a");
	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPDOCALTC");
	private By tipoDocumentoOption = By.cssSelector("#ALTAMEDI_TIPDOCALTC > option");
	private By numDocumentoInput = By.cssSelector("#ALTAMEDI_NUMDOCALTC");
	private By nombreInput = By.cssSelector("#ALTAMEDI_NOMBALTC");
	private By primerApellidoInput = By.cssSelector("#ALTAMEDI_APE1ALTC");
	private By segundoApellidoInput = By.cssSelector("#ALTAMEDI_APE2ALTC");
	private By fechaNombramInput = By.cssSelector("#ALTAMEDI_FNOMBALTC");
	private By sexoCombo = By.cssSelector("#ALTAMEDI_SEXOALTOCARGODGS");
	private By sexoOption = By.cssSelector("#ALTAMEDI_SEXOALTOCARGODGS > option");
	private By fechaCeseInput = By.cssSelector("#ALTAMEDI_FCESEALTCI");
	private By estadoCombo = By.cssSelector("#ALTAMEDI_ESTALTC");
	private By estadoOption = By.cssSelector("#ALTAMEDI_ESTALTC > option");
	private By tipoCargoCombo = By.cssSelector("#ALTAMEDI_TIPCARGO");
	private By tipoCargoOption = By.cssSelector("#ALTAMEDI_TIPCARGO > option");
	private By profesionInput = By.cssSelector("#ALTAMEDI_PROFESION");
	private By telefonoInput = By.cssSelector("#ALTAMEDI_TELFREPRE");
	private By faxInput = By.cssSelector("#ALTAMEDI_FAXREPRE");
	private By emailInput = By.cssSelector("#ALTAMEDI_EMAILREPRE");
	private By movilInput = By.cssSelector("#ALTAMEDI_MOVILREPRE");
	private By paginaWebInput = By.cssSelector("#ALTAMEDI_PAGWEBREPRE");

	//para cuando eliges tipo documento cif en alto cargo
	private By razonSocialInput = By.cssSelector("#ALTAMEDI_RAZSOCALTC");
	private By tipoDocRepresentanCifCombo = By.cssSelector("#ALTAMEDI_TIPDOCREPRE");
	private By tipoDocRepresentanCifOption = By.cssSelector("#ALTAMEDI_TIPDOCREPRE > option");
	private By numDocRepresentanCifInput = By.cssSelector("#ALTAMEDI_NUMDOREPRE");
	private By nombreRepresentanCifInput = By.cssSelector("#ALTAMEDI_NOMBREPRE");
	private By priApellRepresentanCifInput = By.cssSelector("#ALTAMEDI_APE1REPRE");
	private By segApellRepresentanCifInput = By.cssSelector("#ALTAMEDI_APE2REPRE");

	//---------------Añadir nuevo socio ------------
	private By anyadirNuevoSocioBtn = By.cssSelector("#capaSocios > div > div.floatright.peq > a");
	private By socioIgualAltoCargoNOBtn = By.cssSelector("#ALTAMEDI_IGALTOCNO");
	private By socioIgualAltoCargoSIBtn = By.cssSelector("#ALTAMEDI_IGALTOCSI");

	private By altoCargoCombo = By.cssSelector("#ALTAMEDI_CODALTOCATGO");
	private By tipoDocuNuevSocioCombo = By.cssSelector("#ALTAMEDI_TIPDOCSOCIO");
	private By numDocuNuevSocioInput = By.cssSelector("#ALTAMEDI_NUMDOCSOCIO");
	private By fechaNombNuevSocioInput = By.cssSelector("#ALTAMEDI_FECHNOMB");
	private By fechaCeseNuevSocioInput = By.cssSelector("#ALTAMEDI_FECHCESE");
	private By estadoNuevSocioCombo = By.cssSelector("#ALTAMEDI_ESTSOCI");
	private By estadoNuevSocioOption = By.cssSelector("#ALTAMEDI_ESTSOCI > option");
	private By partCapitalNuevSocInput = By.cssSelector("#ALTAMEDI_PARTCAPI");
	private By nombreNuevSocInput = By.cssSelector("#ALTAMEDI_NOMBSOCI");
	private By priAppellNuevSocInput = By.cssSelector("#ALTAMEDI_APE1SOCI");
	private By segApellNuevSocInput = By.cssSelector("#ALTAMEDI_APE2SOCI");
	private By sexoNuevSocCombo = By.cssSelector("#ALTAMEDI_SEXOSOCIODGS");
	private By razonSocialNuevSocioInput = By.cssSelector("#ALTAMEDI_RAZSOCSOCIO");

	private By grabarBtn = By.cssSelector("buttonRecord");
	private By cancelarBtn = By.cssSelector("#buttonRecord");

	//MAPEO DE CASO ESPECIAL AGENTE EXCLUSIVO CON NIE O NIF
	//-----------General---------------------------------
	private By capitalSocialInput = By.id("ALTAMEDI_CAPSOCI");
	private By fechaInicioRelacionInput = By.id("ALTAMEDI_FEINIREL");
	private By entidadAutorizaCombo = By.id("ALTAMEDI_ENTIDAD");
	private By entidadAutorizaOption = By.cssSelector("#ALTAMEDI_ENTIDAD > option");

	private By tipoEntidadCombo = By.id("ALTAMEDI_TIPOENTI");
	private By tipoEntidadOption = By.cssSelector("#ALTAMEDI_TIPOENTI > option");

	private By anyadirNuevoRamoBtn = By.cssSelector("#capaRamos > div.titulo > div > a");
	private By ramoCombo = By.id("ALTAMEDI_RAMODGS");
	private By ramoOption = By.cssSelector("#ALTAMEDI_RAMODGS > option");
	private By productoInput = By.id("ALTAMEDI_PRODUCTO");

	private By grabarRamoBtn = By.id("buttonRecord");
	private By cancelarRamoBtn = By.id("buttonCancel");
	private By volverBtn = By.id("botonVolver");

	private By avisoSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By modificarAltoCargoBtn = By.cssSelector("#capaAltosCargos > div > div:nth-child(4) > table > tbody > tr.odd > td:nth-child(6) > a:nth-child(2)");

	//-----------------------------LPS-DE----------------------
	private By estdoLPSInput = By.id("ALTAMEDI_ESTADOLPS");
	private By codigoRegimenActuacionCombo = By.id("ALTAMEDI_CODREGACT");

	private By identifiRepreseInput = By.id("ALTAMEDI_IDRELP");
	private By razonSocialRepreInput = By.id("ALTAMEDI_RAZSORECLP");
	private By direccionRepreInput = By.id("ALTAMEDI_DIRRELP");
	private By codigoPostalRepreInput = By.id("ALTAMEDI_CPRELP");
	private By poblacionRepreInput = By.id("ALTAMEDI_POBRELP");

	private By razonSocialSucuInput = By.id("ALTAMEDI_RAZSOCSULP");
	private By direccionSucuInput = By.id("ALTAMEDI_DIRSULP");
	private By codigoPostalSucuInput = By.id("ALTAMEDI_CPSULP");
	private By poblacionSucuInput = By.id("ALTAMEDI_POBSULP");

	//-----------Controles de pagina---------------------------
	private By cancelarGeneralBtn = By.id("botonCancelar1");
	private By guardarYSalirBtn = By.id("botonGrabar1");

	public MediadoresAltaDatosDGSPage(UserStory userS) {
		super(userS);
	}

	//---------Añadir datos generales--------------------

	public MediadoresAltaDatosDGSPage escribirNombreRepresentante(String nombre) {

		debugBegin();
		webDriver.setText(nombreRepresentInput, nombre);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage tipoDocumentoRepresentante() {

		debugBegin();
		webDriver.clickElementFromDropDownByAttribute(tipoDocRepresentCombo, tipoDocRepresentOption, "value", getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE));
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage escribirNumeroDocumentoRepresentante() {

		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE) != null && getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE).equalsIgnoreCase("CIF")) {

			webDriver.setText(numDocRepresentInput, "R6991265G");

		} else if(getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE) != null && getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE).equalsIgnoreCase("NIF")) {
			webDriver.setText(numDocRepresentInput, DocumentGeneratorHelper.generateNif());
		} else {

			webDriver.setText(numDocRepresentInput, "96195668P");
		}

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage escribirNumeroDocumentoAltoCargo() {

		debugBegin();

		if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO) != null && getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("CIF")) {

			webDriver.setText(numDocumentoInput, "R6991265G");

		} else if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO) != null && getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("NIF")) {
			webDriver.setText(numDocumentoInput, DocumentGeneratorHelper.generateNif());
		} else {

			webDriver.setText(numDocumentoInput, "96195668P");
		}

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage escribirFechaIniRelacion() {
		debugBegin();
		webDriver.setText(fechaIniContratoInput, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		debugEnd();
		return this;
	}

	//------------Clicks botones -----------------------
	public MediadoresAltaDatosDGSPage clickCancelar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGrabar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGuardarYSalir() {
		debugBegin();
		webDriver.clickInFrame(guardarYSalirBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoSocio() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoSocioBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoAltoCargo() {
		debugBegin();
		webDriver.click(anyadirAltoNuevoCargoBtn);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickCancelarRamo() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarRamoBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGrabarRamo() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarRamoBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoRamo() {
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoRamoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickCancelarDGS() {
		debugBegin();
		webDriver.clickInFrame(cancelarGeneralBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	//-----------METODOS COMPLEJOS-------------------------------

	public MediadoresAltaDatosDGSPage anyadirNuevoSocio(String numDoc, String fechaNombramiento, String fechaCese, String estado, String participacion) {
		debugBegin();

		if(estado.isEmpty()) estado = "1";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevoSocioBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(numDocuNuevSocioInput, numDoc);
		webDriver.setText(fechaNombNuevSocioInput, fechaNombramiento);
		webDriver.setText(fechaCeseNuevSocioInput, fechaCese);
		webDriver.clickElementFromDropDownByAttribute(estadoNuevSocioCombo, estadoNuevSocioOption, "value", estado);
		webDriver.setText(partCapitalNuevSocInput, participacion);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDGSPage anyadirDatosGenerales() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		tipoDocumentoRepresentante();
		escribirNumeroDocumentoRepresentante();
		escribirNombreRepresentante("Nombre");

		if(getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE).equalsIgnoreCase("NIF") || getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE).equalsIgnoreCase("NIE")) {
			webDriver.setText(primApellidoRepresentInput, "primerApell");
		}

		if(getTestVar(Constants.TIPO_DOCUMENTO_REPRESENTANTE).equalsIgnoreCase("NIF")) {
			webDriver.setText(segApellidoRepresentInput, "segundoApell");
		}

		escribirFechaIniRelacion();
		clickAnyadirNuevoAltoCargo();
		anyadirNuevoAltoCargo();

		clickGuardarYSalir();

		debugEnd();
		return this;

	}

	public MediadoresAltaDatosDGSPage anyadirNuevoAltoCargo() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO));
		escribirNumeroDocumentoAltoCargo();

		if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("NIF") || getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("NIE")) {
			webDriver.setText(nombreInput, "Nombre");
			webDriver.setText(primerApellidoInput, "Primer Apellido");
			webDriver.clickElementFromDropDownByAttribute(sexoCombo, sexoOption, "value", getTestVar(Constants.SEXO));

		}

		if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("NIF")) {
			webDriver.setText(segundoApellidoInput, "Segundo Apellido");
		}

		if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO).equalsIgnoreCase("CIF")) {

			webDriver.setText(razonSocialInput, "Razon");
			webDriver.clickElementFromDropDownByAttribute(tipoDocRepresentanCifCombo, tipoDocRepresentanCifOption, "value", getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF));
			webDriver.setText(nombreRepresentanCifInput, "Nombre");

			if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF).equalsIgnoreCase("NIF")) {
				webDriver.setText(segApellRepresentanCifInput, "Segundo Apellido");
			}

			if(getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF) != null && getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF).equalsIgnoreCase("NIE")
				|| getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF).equalsIgnoreCase("PAS")
				|| getTestVar(Constants.TIPO_DOCUMENTO_ALTO_CARGO_CIF).equalsIgnoreCase("NIF")) {
				webDriver.setText(priApellRepresentanCifInput, "Primer Apellido");
			}
		}

		webDriver.setText(fechaNombramInput, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		webDriver.clickElementFromDropDownByAttribute(estadoCombo, estadoOption, "value", "1");
		webDriver.clickElementFromDropDownByAttribute(tipoCargoCombo, tipoCargoOption, "value", "40");
		webDriver.setText(profesionInput, "Profesion");

		webDriver.click(grabarBtn);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	// definir en el método común de la page qué cuando aparece

	public MediadoresAltaDatosDGSPage anyadirFechaInicioRelacion() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.waitWithDriver(4000);
		webDriver.setText(fechaInicioRelacionInput, DateUtils.getTodayDate(DateUtils.DATE_FORMAT));
		webDriver.click(guardarYSalirBtn);

		webDriver.exitFrame();
		webDriver.waitWithDriver(6000);
		debugEnd();

		return this;
	}

	//-------------RETENCIONES--------------------------

	public boolean alertaSistemaDGS(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public MediadoresAltaDatosDGSPage retencionesAltaIntermediarioDGS() {
		debugBegin();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			if(getTestVar(Constants.TIPO_MEDIADOR) != null && !getTestVar(Constants.TIPO_MEDIADOR).isEmpty()
				&& getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AE")) {

				String datoFechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

				clickGuardarYSalir();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_INICIO_RELACION);
				webDriver.acceptAlert();

				webDriver.setTextInFrame(fechaInicioRelacionInput, "fecha", cuerpoFrame);

				clickGuardarYSalir();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_INICIO_RELACION);
				webDriver.acceptAlert();

				webDriver.setTextInFrame(fechaInicioRelacionInput, datoFechaHoy, cuerpoFrame);

				webDriver.clickElementFromDropDownByAttributeInFrame(entidadAutorizaCombo, entidadAutorizaOption, cuerpoFrame, "value", "M0328");

				clickGuardarYSalir();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_ENTIDAD_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.clickElementFromDropDownByAttributeInFrame(tipoEntidadCombo, tipoEntidadOption, cuerpoFrame, "value", "AUTO");

				clickGuardarYSalir();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_INICIO_CONTRATO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.setTextInFrame(fechaIniContratoInput, "fecha", cuerpoFrame);

				clickGuardarYSalir();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_INICIO_CONTRATO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.setTextInFrame(fechaIniContratoInput, datoFechaHoy, cuerpoFrame);

				clickGuardarYSalir();

				alertaSistemaDGS(Constants.ALERTA_ENTIDAD_ALMENOS_RAMO_MEDIADORES);
				webDriver.clickInFrame(volverBtn, cuerpoFrame);

				clickAnyadirNuevoRamo();

				clickGrabarRamo();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_RAMO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.switchToFrame(cuerpoFrame);
				webDriver.clickElementFromDropDownByAttributeInFrame(ramoCombo, ramoOption, modalFrame, "value", "1");

				clickGrabarRamo();

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PRODUCTO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.switchToFrame(cuerpoFrame);
				webDriver.setTextInFrame(productoInput, "Producto", modalFrame);

				clickGrabarRamo();

				clickGuardarYSalir();
			}
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& getTestVar(Constants.TIPO_COLABORADOR) != null && !getTestVar(Constants.TIPO_COLABORADOR).isEmpty()
			&& getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			String fechaHoy = DateUtils.getTodayDate(Constants.DATE_FORMAT);

			webDriver.waitWithDriver(3000);
			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DOCUMENTO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttributeInFrame(tipoDocRepresentCombo, tipoDocRepresentOption, cuerpoFrame, "value", "NIF");

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_DOCUMENTO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(numDocRepresentInput, "Documento", cuerpoFrame);

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(nombreRepresentInput, "Nombre", cuerpoFrame);

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PRIMER_APELLIDO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(primApellidoRepresentInput, "Primer Apellido", cuerpoFrame);

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEGUNDO_APELLIDO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(segApellidoRepresentInput, "Segundo Apellido", cuerpoFrame);

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_INICIO_CONTRATO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(fechaIniContratoInput, "fecha", cuerpoFrame);

			clickGuardarYSalir();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_INICIO_CONTRATO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(fechaIniContratoInput, fechaHoy, cuerpoFrame);

			clickGuardarYSalir();

			//AQUI
			alertaSistemaDGS(Constants.ALERTA_NUMERO_DOCUMENTO_1_MEDIADORES);
			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.setTextInFrame(numDocumentoInput, DocumentGeneratorHelper.generateNif(), cuerpoFrame);

			clickGuardarYSalir();

			alertaSistemaDGS(Constants.ALERTA_ALTO_CARGO_MEDIADORES);

			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.waitWithDriver(2000);
			webDriver.clickInFrame(anyadirAltoNuevoCargoBtn, cuerpoFrame);

			//--Empiezan repetenciones de alto cargo---

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_DOCUMENTO_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", "NIF");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NUMERO_DOCUMENTO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setText(numDocumentoInput, "Documento");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(nombreInput, "Nombre");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PRIMER_APELLIDO_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(primerApellidoInput, "Primer Apellido");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEGUNDO_APELLIDO_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(primerApellidoInput, "Segundo Apellido");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEXO_MEDIADOR);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttribute(sexoCombo, sexoOption, "value", "1");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_FECHA_NOMBRAMIENTO_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(fechaNombramInput, fechaHoy);
			webDriver.clickElementFromDropDownByAttribute(estadoCombo, estadoOption, "title", "Elegir");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ESTADO_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttribute(estadoCombo, estadoOption, "value", "1");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_CARGOS_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.clickElementFromDropDownByAttribute(tipoCargoCombo, tipoCargoOption, "value", "40");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PROFESION_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(profesionInput, "Profesion");
			webDriver.clickElementFromDropDownByAttribute(tipoDocumentoCombo, tipoDocumentoOption, "value", "CIF");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_RAZON_SOCIAL_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(razonSocialInput, "Razon social");
			webDriver.setText(fechaNombramInput, fechaHoy);
			webDriver.clickElementFromDropDownByAttribute(tipoDocRepresentanCifCombo, tipoDocRepresentanCifOption, "value", "NIF");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setText(nombreRepresentanCifInput, "Nombre");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_PRIMER_APELLIDO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setText(primApellidoRepresentInput, "Primer Apellido");
			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SEGUNDO_APELLIDO_REPRESENTANTE);
			webDriver.acceptAlert();

			webDriver.setText(segundoApellidoInput, "Segundo Apellido");
			webDriver.clickElementFromDropDownByAttribute(tipoCargoCombo, tipoCargoOption, "value", "40");
			webDriver.setText(profesionInput, "Profesion");

			//--No obligatorios--
			webDriver.setText(telefonoInput, "Telefono");

			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setText(telefonoInput, "699999989");

			webDriver.setText(movilInput, "movil");

			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_MOVIL_ALTO_CARGO);
			webDriver.acceptAlert();

			webDriver.setText(movilInput, "699999999");

			webDriver.setText(emailInput, "Esto es un email");

			webDriver.click(grabarBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL);
			webDriver.acceptAlert();

			webDriver.setText(emailInput, "mutua@gmail.com");

			webDriver.click(grabarBtn);

			webDriver.exitFrame();

			clickGuardarYSalir();

			alertaSistemaDGS(Constants.ALERTA_NUMERO_DOCUMENTO_CARGO_INCORRECTO);
			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.clickInFrame(modificarAltoCargoBtn, cuerpoFrame);
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);

			webDriver.setText(numDocumentoInput, DocumentGeneratorHelper.generateCIF());
			webDriver.click(grabarBtn);
			webDriver.exitFrame();

			//clickGuardarYSalir();

		}

		debugEnd();

		return this;
	}
}

