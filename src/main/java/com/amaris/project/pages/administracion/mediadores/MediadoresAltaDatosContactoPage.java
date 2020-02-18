package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MediadoresAltaDatosContactoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//--------------Datos generales-------------------------
	private By contactoResponsableInput = By.id("MEDI_PERSCONT");
	private By cargoResponsableInput = By.id("ALTAMEDI_CARGRESP");
	private By telefonoPrincipalInput = By.id("MEDI_TELEFONO1");
	private By faxPrincipalInput = By.id("ALTAMEDI_FAXPRI");
	private By comunicacionIPInput = By.id("ALTAMEDI_COMUNIP");
	private By emailPrincipalInput = By.id("ALTAMEDI_EMAILPRI");

	//------------------Anyadir nueva dirección-----------------------------

	private By alertaDireccionesTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By alertaDireccionesOficinaTxt = By.cssSelector("#capaDomicilio > table.tableForm > tbody > tr > th > strong");
	private By anyadirNuevaDireccionBtn = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");
	private By tipoDomicilioCombo = By.id("ALTAMEDI_TIPDOMME");
	//private By tipoDomicilioCombo = By.cssSelector("#formDatos > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td");
	//private By tipoDomicilioOption = By.cssSelector("#formDatos > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > select > option");
	private By tipoDomicilioOption = By.cssSelector("#ALTAMEDI_TIPDOMME > option");
	private By provinciaInput = By.id("ALTACLIE_PROVINCIA_ARVATO");
	private By provinciaCombo = By.cssSelector("body > ul:nth-child(4) > li"); // quitado " > a" del final
	private By poblacionInput = By.id("ALTACLIE_POBLACION_ARVATO");
	private By poblacionCombo = By.cssSelector("body > ul:nth-child(5) > li"); // quitado ":nth-child(2) > a" del final
	private By viaInput = By.id("ALTACLIE_NOMVIA_ARVATO");
	private By viaCombo = By.cssSelector("body > ul:nth-child(6) > li"); // quitado ":nth-child(2) > a" del final
	private By numeroViaInput = By.id("ALTACLIE_NUMVIA");
	private By codigoPostalInput = By.id("ALTACLIE_CODPOST_ARVATO");

	private By direccionIgualFiscalBtn = By.id("ALTAMEDI_IGUFISC");
	private By direccionIgualComercialBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionDiferenteBtn = By.id("ALTAMEDI_DIFFISC");

	private By direccionSuperiorNOComSIBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionSuperiorNOComNOBtn = By.id("ALTAMEDI_DIFFISC");

	private By direccionSuperiorSIBtn = By.id("ALTAMEDI_IGUPADSI");
	private By direccionSuperiorNOBtn = By.id("ALTAMEDI_IGUPADNO");

	//Controles de datos de domicilio
	private By comprobarDireccionBtn = By.id("BOTON_NORMADOM");
	private By borrarCamposDomicilioBtn = By.id("BOTON_BORRADOM");
	private By aceptarBtn = By.id("BOTON_ACEPTAR");
	private By cancelarDomicilioBtn = By.id("BOTON_CANCELAR");

	private By modificarDomicilioBtn = By.cssSelector("#capaDireccionesPaso2 > div > div:nth-child(4) > table > tbody > tr.odd > td:nth-child(4) > a.js-openModal");

	private By aceptarDireccionBtn = By.id("BOTON_ACEPDOMI");
	private By asignarDomicilioBtn = By.id("BOTON_DOMIMEDI");

	//-------------Anyadir nueva red social -------------------------
	private By nuevaRedSocialBtn = By.cssSelector("#capaRedesSociales > div > div.floatright.peq > a");
	private By medTipoRRSSCombo = By.id("ALTAMEDI_TIPOREDS");
	private By medTipoRRSSOption = By.cssSelector("#ALTAMEDI_TIPOREDS > option");
	private By medRRSSDescripcionInput = By.id("ALTAMEDI_DESCREDS");

	//-----------Anyadir Medios de contacto-----------------
	private By nuevoMedioContactoBtn = By.cssSelector("#capaMediosContactoPaso2 > div > div.floatright.peq > a");
	private By medNuevoTipoContactoCombo = By.id("MEDI_CONTPROS");
	private By medNuevoTipoContactoOption = By.cssSelector("#MEDI_CONTPROS > option");
	private By medNuevoContactoInput = By.id("MEDI_CONTACTO");

	//-------------Anyadir Nuevo contacto-------------------------
	private By nuevoContactoBtn = By.cssSelector("#capaContactos > div > div.floatright.peq > a");
	private By medAreaContactoCombo = By.id("ALTAMEDI_AREA");
	private By medAreaContactoOption = By.cssSelector("#ALTAMEDI_AREA > option");
	private By medNombreContactoInput = By.id("ALTAMEDI_NOMCON");
	private By medCargoContactoInput = By.id("ALTAMEDI_CARGO");
	private By medTelefonoContactoInput = By.id("ALTAMEDI_TELFCON");
	private By medFaxContactoInput = By.id("ALTAMEDI_FAXCON");
	private By medEmailContactoInput = By.id("ALTAMEDI_MAILCON");
	private By medPreferenciaCombo = By.id("ALTAMEDI_PREFCOM");
	private By medPreferenciaOption = By.cssSelector("#ALTAMEDI_PREFCOM > option");

	//----------Controles de red social- contacto- medios de contacto-------
	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");
	private By volverBtn = By.id("botonVolver");

	//-------------Marcas LOPD------------
	private By publicidadMediadorBtn = By.id("ALTAMEDI_ENVIOMED");
	private By publicidadMutuaistaBtn = By.id("ALTAMEDI_ENVIOMUT");
	private By publiImagenMedBtn = By.id("ALTAMEDI_USOIMAGEN");

	//---Controles de la pagina---------------------
	private By cancelarGeneralBtn = By.id("botonCancelar1");
	private By guardarBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	////// ELEMENTOS LISTADOS PERO QUE REALMENTE NO INTERVIENEN EN LOS STEPS DEL TEST todavía
	private By direcionRestoVInput = By.id("ALTACLIE_DATADIC");
	// El desplegable Tipo de Vía no despliega nada. ¿Realmente debería?
	private By direcionTipoVCombo = By.id("ALTACLIE_TIPOVIA_ARVATO");
	private By direcionBloqueInput = By.id("ALTACLIE_BLOQUE_ARVATO");
	private By direcionEscaleraInput = By.id("ALTACLIE_ESCALERA");
	private By direcionPisoInput = By.id("ALTACLIE_PISO");
	private By direcionPuertaInput = By.id("ALTACLIE_PUERTA");

	/* REPASAR DIRECCIÓN FISCAL CON OTRO TIPO DE MEDIADOR.
	CON COLABORADOR HA ASIGNADO EL SUPERIOR DE MANERA AUTOMÁTICA */

	public MediadoresAltaDatosContactoPage(UserStory userS) {
		super(userS);
	}

	//---------------Rellenar datos Generales------------------------
	public MediadoresAltaDatosContactoPage rellenarDatosGeneralesContacto(String contactoResp, String cargoRespo, String telPrincipal, String emailPrincipal) {
		debugBegin();
		webDriver.waitWithDriver(8000);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.setText(contactoResponsableInput, contactoResp);
		webDriver.setText(cargoResponsableInput, cargoRespo);
		webDriver.setText(telefonoPrincipalInput, telPrincipal);
		webDriver.setText(emailPrincipalInput, emailPrincipal);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//--------------Añadir direcciones: los 5 casos basicos--------------------------------- / ANTONIA REFACTORIZADO

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionGeneral() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);

		//	webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		completarCampoProvincia(getTestVar(Constants.DIRECCION_FISC_PROVINCIA));
		completarCampoPoblacion(getTestVar(Constants.DIRECCION_FISC_POBLACION));
		completarCampoNombreVia(getTestVar(Constants.DIRECCION_FISC_NombreVia));
		webDriver.waitWithDriver(2000);
		webDriver.setText(numeroViaInput, "11");

		webDriver.click(comprobarDireccionBtn);
		//webDriver.waitForElementToBePresent(aceptarBtn);
		webDriver.waitWithDriver(3000);
		webDriver.click(aceptarBtn);
		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();

		debugInfo("se acaba de añadir la dirección fiscal del intermediario");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionFiscal() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "FISC");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		if(!getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") || !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")
			|| getTestVar(Constants.DIRECCION_FISC_PROVINCIA) != null || !getTestVar(Constants.DIRECCION_FISC_PROVINCIA).isEmpty()) {
			// si no es oficina o un colaborador gestor + contiene dato en el campo provincia --> completa datos
			completarCampoProvincia(getTestVar(Constants.DIRECCION_FISC_PROVINCIA).toString());
			debugInfo("Introducida la provincia de la dirección fiscal");

			completarCampoPoblacion(getTestVar(Constants.DIRECCION_FISC_POBLACION).toString());
			debugInfo("Introducida la población de la dirección fiscal");

			completarCampoNombreVia(getTestVar(Constants.DIRECCION_FISC_NombreVia).toString());
			debugInfo("Introducida la calle de la dirección fiscal");

			webDriver.waitWithDriver(2000);
			webDriver.setText(numeroViaInput, "11");
			webDriver.click(comprobarDireccionBtn);
			//	webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.waitWithDriver(3000);
			webDriver.click(aceptarBtn);
			debugInfo("Aceptada la dirección para añadirse a la lista");

		}
		webDriver.waitWithDriver(8000);
		if(getTestVar(Constants.NIVEL_ESTRUCTURA).contains("OFIC") || getTestVar(Constants.TIPO_COLABORADOR).contains("GEST")) {
			// si es oficina o gestor, comprueba el copy de la dirección fiscal automáticamente heredada
			String copyDireccionFiscalOficina = webDriver.getText(By.cssSelector("#capaDomicilio > table.tableForm > tbody > tr > th > strong")).trim();
			debugInfo("El copy para la dirección fiscal de una oficina es: " + copyDireccionFiscalOficina);

			boolean checkDireccionFiscalOficina = copyDireccionFiscalOficina
				.equalsIgnoreCase("Tenga en cuenta que para colaboradores gestores o oficinas, el domicilio fiscal se recoge del nivel superior");
			debugInfo("Comprobamos la dirección fiscal, el resultado es: " + checkDireccionFiscalOficina);
			Assert.assertTrue(checkDireccionFiscalOficina, "Comparar campos: el copy de la dirección Fiscal NO coincide");
		} else if(getTestVar(Constants.DIRECCION_FISC_PROVINCIA) == null || getTestVar(Constants.DIRECCION_FISC_PROVINCIA).isEmpty() || getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD")
			|| getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AUXI")) {
			// es colaborador, sin datos --> clic en Fiscal = nivel superior
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn); //último añadido
		}
		debugInfo("se acaba de añadir la dirección fiscal del intermediario"); // muere en este punto

		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoProvincia(String provinciaCampo) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.setText(provinciaInput, provinciaCampo);

		webDriver.waitWithDriver(2000);
		webDriver.clickElementFromDropDownByAttribute(provinciaInput, provinciaCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoPoblacion(String poblacionCampo) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.setText(poblacionInput, poblacionCampo);
		webDriver.waitWithDriver(4000);
		webDriver.clickElementFromDropDownByAttribute(poblacionInput, poblacionCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoNombreVia(String nombreViaCampo) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.setText(viaInput, nombreViaCampo);
		webDriver.waitWithDriver(2000);
		webDriver.clickElementFromDropDownByAttribute(viaInput, viaCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirDireccionComercial() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("se entra al metodo para añadir direccion fiscal");
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "COME");
		debugInfo("se selecciona añadir direccion comercial");

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(getTestVar(Constants.DIRECCION_COME_PROVINCIA) != null && !getTestVar(Constants.DIRECCION_COME_PROVINCIA).isEmpty()) {
			// se comprueba si el campo de provincia para este tipo de dirección contiene datos, a ser así se hace clic en "Diferente", indiferente del nivel
			webDriver.click(direccionDiferenteBtn);
			debugInfo("se selecciona direccion comercial diferente a la fiscal");
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getTestVar(Constants.DIRECCION_COME_PROVINCIA).toString());
			completarCampoPoblacion(getTestVar(Constants.DIRECCION_COME_POBLACION).toString());
			completarCampoNombreVia(getTestVar(Constants.DIRECCION_COME_NombreVia).toString());
			webDriver.waitWithDriver(3000);
			webDriver.setText(numeroViaInput, "11");
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitWithDriver(4000);
			webDriver.click(aceptarBtn);
		}
		// sin datos de provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(getTestVar(Constants.DIRECCION_COME_PROVINCIA) == null || getTestVar(Constants.DIRECCION_COME_PROVINCIA).isEmpty() || !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")
			|| getTestVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_FISCAL_IGUAL_A) == null) {
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.waitForElementToBePresent(aceptarDireccionBtn);
			webDriver.click(aceptarDireccionBtn); //último añadido
		} else { //sin datos de provincia + intermediario --> dirección comercial igual a fiscal
			webDriver.click(direccionIgualFiscalBtn);
			webDriver.waitWithDriver(3000);
			webDriver.click(aceptarDireccionBtn); //último añadido
		}
		webDriver.exitFrame();
		debugInfo("se completó el alta de dirección comercial");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirDireccionProduccion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(8000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "PPRO");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(getTestVar(Constants.DIRECCION_PPRO_PROVINCIA) != null || !getTestVar(Constants.DIRECCION_PPRO_PROVINCIA).isEmpty()) {
			// hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente
			//webDriver.click(direccionSuperiorNOBtn);
			webDriver.waitWithDriver(1500);
			webDriver.click(direccionDiferenteBtn);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getTestVar(Constants.DIRECCION_PPRO_PROVINCIA).toString());
			completarCampoPoblacion(getTestVar(Constants.DIRECCION_PPRO_POBLACION).toString());
			completarCampoNombreVia(getTestVar(Constants.DIRECCION_PPRO_NOMBRE_VIA).toString());
			webDriver.waitWithDriver(2000);
			webDriver.setText(numeroViaInput, "11");
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// sin datos para la provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(getTestVar(Constants.DIRECCION_PPRO_PROVINCIA) == null || getTestVar(Constants.DIRECCION_PPRO_PROVINCIA).isEmpty() || !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")
			||
			getTestVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_FISCAL_IGUAL_A) == null) {
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn); //último añadido
		} else { // sin datos para provincia + INTE + analizar CSV para obtener coberturan desde DIR_FISCAL_IGUAL_A
			webDriver.click(direccionSuperiorNOBtn);
			if(getTestVar(Constants.DIR_FISCAL_IGUAL_A) != null || !getTestVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_FISCAL_IGUAL_A) == "PPRO_FISC") {
				webDriver.click(direccionIgualFiscalBtn);
			}
			if(getTestVar(Constants.DIR_FISCAL_IGUAL_A) != null || !getTestVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_FISCAL_IGUAL_A) == "PPRO_COME") {
				webDriver.click(direccionIgualComercialBtn);
			}
			webDriver.click(aceptarDireccionBtn); //último añadido
		}

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirDireccionRecibos() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "PREC");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(getTestVar(Constants.DIRECCION_PREC_PROVINCIA) != null && !getTestVar(Constants.DIRECCION_PREC_PROVINCIA).isEmpty()) {
			// hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente
			//webDriver.click(direccionSuperiorNOBtn);
			webDriver.waitWithDriver(1500);
			webDriver.click(direccionDiferenteBtn);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getTestVar(Constants.DIRECCION_PREC_PROVINCIA).toString());
			completarCampoPoblacion(getTestVar(Constants.DIRECCION_PREC_POBLACION).toString());
			completarCampoNombreVia(getTestVar(Constants.DIRECCION_PREC_NombreVia).toString());
			webDriver.waitWithDriver(2000);
			webDriver.setText(numeroViaInput, "11");
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// sin datos para la provincia + oficina --> hereda datos del nivel superios
		else if(getTestVar(Constants.DIRECCION_PREC_PROVINCIA) == null && getTestVar(Constants.DIRECCION_PREC_PROVINCIA).isEmpty() && getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn); //último añadido
		}
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirDireccionSiniestros() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "PSIN");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(getTestVar(Constants.DIRECCION_PSIN_PROVINCIA) != null || !getTestVar(Constants.DIRECCION_PSIN_PROVINCIA).isEmpty()) {
			// hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente
			//webDriver.click(direccionSuperiorNOBtn);
			webDriver.waitWithDriver(1500);
			webDriver.click(direccionDiferenteBtn);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getTestVar(Constants.DIRECCION_PSIN_PROVINCIA).toString());
			completarCampoPoblacion(getTestVar(Constants.DIRECCION_PSIN_POBLACION).toString());
			completarCampoNombreVia(getTestVar(Constants.DIRECCION_PSIN_NOMBRE_VIA).toString());
			webDriver.waitWithDriver(2000);
			webDriver.setText(numeroViaInput, "11");
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// sin datos para la provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(getTestVar(Constants.DIRECCION_PSIN_PROVINCIA).equals(null) || getTestVar(Constants.DIRECCION_PSIN_PROVINCIA).isEmpty() && !getTestVar(Constants.NIVEL_ESTRUCTURA)
			.equalsIgnoreCase("INTE")
			|| getTestVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_FISCAL_IGUAL_A).equals(null)) { // ¿¿¿¿¿ FISCAL ????
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn); //último añadido
		} else { // sin datos para provincia + INTE + analizar CSV para obtener coberturan desde DIR_FISCAL_IGUAL_A
			webDriver.click(direccionSuperiorNOBtn);
			if(getTestVar(Constants.DIR_SINIESTROS_IGUAL_A) != null || !getTestVar(Constants.DIR_SINIESTROS_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_SINIESTROS_IGUAL_A)
				.equalsIgnoreCase("PSIN_FISC")) {
				webDriver.click(direccionIgualFiscalBtn);
			} else if(getTestVar(Constants.DIR_SINIESTROS_IGUAL_A) != null || !getTestVar(Constants.DIR_SINIESTROS_IGUAL_A).isEmpty() || getTestVar(Constants.DIR_SINIESTROS_IGUAL_A)
				.equalsIgnoreCase("PSIN_COME")) {
				webDriver.click(direccionIgualComercialBtn);
			}
			webDriver.click(aceptarDireccionBtn); //último añadido
		}

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalIgualFiscal() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionIgualFiscalBtn);
		webDriver.click(aceptarDireccionBtn); // igual a otra dirección
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalIgualComercial() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionIgualComercialBtn);
		webDriver.click(aceptarDireccionBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionPostalDiferente(String provincia, String poblacion, String nombreVia, String numVia) {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.click(direccionDiferenteBtn);
		webDriver.setText(provinciaInput, provincia);
		webDriver.setText(poblacionInput, poblacion);
		webDriver.setText(viaInput, nombreVia);
		webDriver.setText(numeroViaInput, numVia);
		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nueva red social---------------------------------

	public MediadoresAltaDatosContactoPage anyadirNuevaRedSocial(String tipoRedSocial, String descripcionRed) {
		debugBegin();
		if(tipoRedSocial.isEmpty()) tipoRedSocial = "BLOG";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevaRedSocialBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medTipoRRSSCombo, medTipoRRSSOption, "value", tipoRedSocial);
		webDriver.setText(medRRSSDescripcionInput, descripcionRed);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo medio contacto---------------------------------

	public MediadoresAltaDatosContactoPage anyadirDatosNuevoMedioContacto(String tipoContacto, String contacto) {
		debugBegin();
		if(tipoContacto.isEmpty()) tipoContacto = "MAIL";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevoMedioContactoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medNuevoTipoContactoCombo, medNuevoTipoContactoOption, "value", tipoContacto);
		webDriver.setText(medNuevoContactoInput, contacto);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo contacto---------------------------------
	public MediadoresAltaDatosContactoPage anyadirDatosNuevoContacto(String areaContacto, String nombreContacto) {
		debugBegin();
		if(areaContacto.isEmpty()) areaContacto = "ADMF";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(nuevoContactoBtn);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(medAreaContactoCombo, medAreaContactoOption, "value", areaContacto);
		webDriver.setText(medNombreContactoInput, nombreContacto);
		webDriver.click(grabarBtn);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------------Clicks botones---------------------------------

	public MediadoresAltaDatosContactoPage clickCancelarCamposDireccion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarDomicilioBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickAsignarCamposDireccion() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(asignarDomicilioBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickAceptarDireccionPostal() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(aceptarDireccionBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickCancelar() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickGuardarYSalir() {
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickCancelarGeneral() {
		debugBegin();
		webDriver.clickInFrame(cancelarGeneralBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickDireccionSuperiorNO() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(direccionSuperiorNOBtn, modalFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage clickDireccionSuperiorSI() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(direccionSuperiorSIBtn, modalFrame);
		debugEnd();

		return this;
	}

	//-------------------MÉTODOS COMPLEJOS--------------------------------------

	// REVISAR CON IRYNA

	public MediadoresAltaDatosContactoPage altaOficinaDatosContacto() {
		debugBegin();
		rellenarDatosGeneralesContacto("Contacto responsable", "Cargo responsable", "666999999", "email@gmail.com");

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosContactoPage altaColaboradorDatosContacto() {
		debugBegin();
		rellenarDatosGeneralesContacto("Contacto responsable", "Cargo responsable", "699999999", "email@gmail.com");

		// FALTA añadir direcciones

		debugEnd();
		return this;
	}

	//---------------RETENCIONES PARA ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR------------------------

	//ALERTA DE SISTEMA
	public boolean alertaSistemaContacto(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(alertaDireccionesTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public boolean alertaSistemaDireccionesContacto(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String alerta = webDriver.getTextInFrame(alertaDireccionesOficinaTxt, modalFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado:" + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public MediadoresAltaDatosContactoPage altaRetencionesContacto() {
		debugBegin();

		webDriver.waitWithDriver(5000);
		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CONTACTO_RESPONSABLE_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(contactoResponsableInput, cuerpoFrame, "Contacto responsable");

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CARGO_RESPONSABLE_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(cargoResponsableInput, cuerpoFrame, "Cargo responsable");

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(telefonoPrincipalInput, cuerpoFrame, "Telefono");
		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TELEFONO_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(telefonoPrincipalInput, cuerpoFrame, "699999999");

		clickContinuar();
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(emailPrincipalInput, cuerpoFrame, "Esto es un email.");

		clickContinuar();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_EMAIL_PRINCIPAL_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(emailPrincipalInput, cuerpoFrame, "email@gmail.com");
		debugInfo("Se han rellenado los Datos Generales de la Pagina Contacto.");

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_MEDIADORES);
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
			getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_SUPERIOR_MEDIADORES);
		}

		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		//---Elegimos Direccion Comercial-----
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "COME");

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
			getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickInFrame(direccionSuperiorNOBtn, modalFrame);
		}

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickInFrame(comprobarDireccionBtn, modalFrame);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(provinciaInput);
		completarCampoProvincia("ALME");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(poblacionInput);
		completarCampoPoblacion("ALM");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(viaInput);
		completarCampoNombreVia("ALM");

		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);

		webDriver.exitFrame();
		debugInfo("Se ha rellenado la Direccion Comercial.");

		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_MEDIADORES);
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
			getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_SUPERIOR_MEDIADORES);
		}

		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		//---Direccion Fiscal---
		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "FISC");

		//--Solo para oficinas y direccion fiscal
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaDireccionesContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_FISCAL_OFI_COL_MEDIADORES);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickInFrame(aceptarDireccionBtn, modalFrame);

		}

		//---Para Colaboradores----
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") &&
			!getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.click(direccionSuperiorNOBtn);
			webDriver.click(direccionDiferenteBtn);
			webDriver.exitFrame();

		}

		//--Para Colaborador y Tipo colaborador: gestor
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {

			webDriver.waitWithDriver(5000);
			alertaSistemaDireccionesContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_FISCAL_OFI_COL_MEDIADORES);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickInFrame(aceptarDireccionBtn, modalFrame);
			webDriver.exitFrame();

		}

		//---Para Intermediarios---
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")
			|| (getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") &&
			!getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST"))) {

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickInFrame(comprobarDireccionBtn, modalFrame);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia("VALENCIA");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(poblacionInput);
			completarCampoPoblacion("MISLATA");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(viaInput);
			completarCampoNombreVia("GREG");

			webDriver.click(comprobarDireccionBtn);
			webDriver.click(aceptarBtn);

			webDriver.exitFrame();
		}

		debugInfo("Se ha rellenado la Dirección Fiscal.");
		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_MEDIADORES);
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
			getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_SUPERIOR_MEDIADORES);
		}

		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		//--Postal Produccion------
		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(tipoDomicilioCombo, tipoDomicilioOption, "value", "PPRO");

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			|| getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.click(direccionSuperiorNOBtn);
		}

		webDriver.click(direccionDiferenteBtn);

		webDriver.clearText(provinciaInput);
		webDriver.clearText(poblacionInput);
		webDriver.clearText(viaInput);

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(provinciaInput);
		completarCampoProvincia("ALBACETE");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(poblacionInput);
		completarCampoPoblacion("val");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(viaInput);
		completarCampoNombreVia("val");

		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);

		webDriver.exitFrame();

		debugInfo("Se ha rellenado la Dirección Postal Producción.");
		clickContinuar();

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_MEDIADORES);
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
			getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_SUPERIOR_MEDIADORES);
		}

		webDriver.clickInFrame(volverBtn, cuerpoFrame);

		//--Postal Recibos------
		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& !getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.clickElementFromDropDownByAttribute(tipoDomicilioCombo, tipoDomicilioOption, "value", "PREC");

			if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
				&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

				webDriver.click(direccionSuperiorNOBtn);
			}

			webDriver.click(direccionDiferenteBtn);

			webDriver.clearText(provinciaInput);
			webDriver.clearText(poblacionInput);
			webDriver.clearText(viaInput);

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia("ALBACETE");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(poblacionInput);
			completarCampoPoblacion("val");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(viaInput);
			completarCampoNombreVia("val");

			webDriver.click(comprobarDireccionBtn);
			webDriver.click(aceptarBtn);

			webDriver.exitFrame();

			debugInfo("Se ha rellenado la Dirección Postal Recibos.");
			clickContinuar();

			if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
				&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

				alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_MEDIADORES);
			}

			if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
				&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") ||
				getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

				alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_SUPERIOR_MEDIADORES);
			}

			webDriver.clickInFrame(volverBtn, cuerpoFrame);
		}

		//---Postal Siniestros-----
		webDriver.clickInFrame(anyadirNuevaDireccionBtn, cuerpoFrame);

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.clickElementFromDropDownByAttribute(tipoDomicilioCombo, tipoDomicilioOption, "value", "PSIN");

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")
			|| getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")) {

			webDriver.click(direccionSuperiorNOBtn);
		}

		webDriver.click(direccionDiferenteBtn);

		webDriver.clearText(provinciaInput);
		webDriver.clearText(poblacionInput);
		webDriver.clearText(viaInput);

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(provinciaInput);
		completarCampoProvincia("ALBACETE");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
		webDriver.acceptAlert();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(poblacionInput);
		completarCampoPoblacion("val");

		webDriver.click(comprobarDireccionBtn);

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);
		webDriver.waitForElementToBePresent(viaInput);
		completarCampoNombreVia("val");

		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);

		webDriver.exitFrame();

		debugInfo("Se ha rellenado la Dirección Postal Siniestros.");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& !getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AD")) {

			alertaSistemaContacto(Constants.ALERTA_ANYADIR_DIRECCIONES_COLABORADOR_MISMA_DIRECCCION);
			webDriver.clickInFrame(volverBtn, cuerpoFrame);

			webDriver.clickInFrame(modificarDomicilioBtn, cuerpoFrame);

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.clearText(provinciaInput);
			webDriver.clearText(poblacionInput);
			webDriver.clearText(viaInput);

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_PROVINCIA_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia("MADRID");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_POBLACION_MEDIADORES);
			webDriver.acceptAlert();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(poblacionInput);
			completarCampoPoblacion("MAD");

			webDriver.click(comprobarDireccionBtn);

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_ANYADIR_DIRECCIONES_NOMBRE_VIA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(modalFrame);
			webDriver.waitForElementToBePresent(viaInput);
			completarCampoNombreVia("MAD");

			webDriver.click(comprobarDireccionBtn);
			webDriver.click(aceptarBtn);

			webDriver.exitFrame();

			webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		}

		debugEnd();
		return this;
	}

}
