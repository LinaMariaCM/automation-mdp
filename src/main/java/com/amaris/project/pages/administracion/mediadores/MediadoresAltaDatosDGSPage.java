package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosDGSPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//-----------General---------------------------------
	private By tipoDocRepresentCombo = By.cssSelector("#ALTAMEDI_DOCREPR");
	private By numDocRepresentInput = By.cssSelector("#ALTAMEDI_NUMDOCREPR");
	private By nombreRepresentInput = By.cssSelector("#ALTAMEDI_NOMBREPR");
	private By primApellidoRepresentInput = By.cssSelector("#ALTAMEDI_APE1REPR");
	private By segApellidoRepresentInput = By.cssSelector("#ALTAMEDI_APE2REPR");

	private By fechaIniContratoInput = By.cssSelector("#ALTAMEDI_FEINICON");

	//------------------Altos cargos---------------------
	private By anyadirAltoNuevoCargoBtn = By.cssSelector("#capaAltosCargos > div > div.floatright.peq > aN");
	private By tipoDocumentoCombo = By.cssSelector("#ALTAMEDI_TIPDOCALTC");
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

	private By razonSocialInput = By.cssSelector("#ALTAMEDI_RAZSOCALTC");
	private By tipoDocRepresentanCifCombo = By.cssSelector("#ALTAMEDI_TIPDOCREPRE");
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

	private By tipoEntidadCombo = By.id("ALTAMEDI_TIPOENTI");

	private By anyadirNuevoRamoBtn = By.cssSelector("#capaRamos > div.titulo > div > a");
	private By ramoCombo = By.id("ALTAMEDI_RAMODGS");
	private By productoInput = By.id("ALTAMEDI_PRODUCTO");

	private By grabarRamoBtn = By.id("buttonRecord");
	private By cancelarRamoBtn = By.id("buttonCancel");

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
	public MediadoresAltaDatosDGSPage anyadirDatosGenerales(String nombreRepre, String numRepre, String fechaIniContrato)
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setText(nombreRepresentanCifInput, nombreRepre);
		webDriver.setText(numDocRepresentanCifInput, numRepre);
		webDriver.setText(fechaIniContratoInput, fechaIniContrato);
		webDriver.exitFrame();
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage anyadirNuevoAltoCargo(String nombre, String primApell, String segApell, String sexo, String fechaNombramiento, String fechaCese, String estado, String tipoCargo, String profesion, String tel, String movil, String fax, String web)
	{
		debugBegin();
		if(sexo.isEmpty()) sexo = "1";
		if(estado.isEmpty()) estado = "1";
		if(tipoCargo.isEmpty()) tipoCargo = "40";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirAltoNuevoCargoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(nombreInput, nombre);
		webDriver.setText(primerApellidoInput, primApell);
		webDriver.setText(segundoApellidoInput, segApell);
		webDriver.clickElementFromDropDownByAttribute(sexoCombo, sexoOption, "value", sexo);
		webDriver.setText(fechaNombramInput, fechaNombramiento);
		webDriver.setText(fechaCeseInput, fechaCese);
		webDriver.clickElementFromDropDownByAttribute(estadoCombo, estadoOption , "value", estado);
		webDriver.clickElementFromDropDownByAttribute(tipoCargoCombo, tipoCargoOption , "value", tipoCargo);
		webDriver.setText(profesionInput, profesion);
		webDriver.setText(telefonoInput, tel);
		webDriver.setText(faxInput, fax);
		webDriver.setText(movilInput, movil);
		webDriver.setText(paginaWebInput, web);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosDGSPage anyadirNuevoSocio(String numDoc, String fechaNombramiento, String fechaCese, String estado, String participacion)
	{
		debugBegin();
		if(estado.isEmpty()) estado = "1";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevoSocioBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.setText(numDocuNuevSocioInput, numDoc);
		webDriver.setText(fechaNombNuevSocioInput, fechaNombramiento);
		webDriver.setText(fechaCeseNuevSocioInput, fechaCese);
		webDriver.clickElementFromDropDownByAttribute(estadoNuevSocioCombo, estadoNuevSocioOption , "value", estado);
		webDriver.setText(partCapitalNuevSocInput, participacion);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

 	//------------Clicks botones -----------------------
	public MediadoresAltaDatosDGSPage clickCancelar()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGrabar()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGuardarYSalir()
	{
		debugBegin();
		webDriver.clickInFrame(guardarYSalirBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickCancelarRamo()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarRamoBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickGrabarRamo()
	{
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(grabarRamoBtn, modalFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoRamo()
	{
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoRamoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickCancelarDGS()
	{
		debugBegin();
		webDriver.clickInFrame(cancelarGeneralBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoSocio()
	{
		debugBegin();
		webDriver.clickInFrame(anyadirNuevoSocioBtn, cuerpoFrame);
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosDGSPage clickAnyadirNuevoAltoCargo()
	{
		debugBegin();
		webDriver.clickInFrame(anyadirAltoNuevoCargoBtn, cuerpoFrame);
		debugEnd();
		return this;
	}
}
