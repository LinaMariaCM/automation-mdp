package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class MediadoresAltaDatosContactoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//--------------Datos generales-------------------------
	private By contactoResponsableInput = By.id("MEDI_PERSCONT");
	private By cargoResponsableInput = By.id("ALTAMEDI_CARGRESP");
	private By telefonoPrincipalInput = By.id("MEDI_TELEFONO1");
	private By emailPrincipalInput = By.id("ALTAMEDI_EMAILPRI");

	//------------------Anyadir nueva dirección-----------------------------

	private By alertaDireccionesTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");
	private By alertaDireccionesOficinaTxt = By.cssSelector("#capaDomicilio > table.tableForm > tbody > tr > th > strong");
	private By anyadirNuevaDireccionBtn = By.cssSelector("#capaDireccionesPaso2 > div > div.floatright.peq > a");
	private By tipoDomicilioCombo = By.id("ALTAMEDI_TIPDOMME");
	private By tipoDomicilioOption = By.cssSelector("#ALTAMEDI_TIPDOMME > option");
	private By provinciaInput = By.id("ALTACLIE_PROVINCIA_ARVATO");
	private By provinciaCombo = By.cssSelector("body > ul:nth-child(4) > li"); // quitado " > a" del final
	private By poblacionInput = By.id("ALTACLIE_POBLACION_ARVATO");
	private By poblacionCombo = By.cssSelector("body > ul:nth-child(5) > li"); // quitado ":nth-child(2) > a" del final
	private By viaInput = By.id("ALTACLIE_NOMVIA_ARVATO");
	private By viaCombo = By.cssSelector("body > ul:nth-child(6) > li"); // quitado ":nth-child(2) > a" del final
	private By numeroViaInput = By.id("ALTACLIE_NUMVIA");

	private By direccionIgualFiscalBtn = By.id("ALTAMEDI_IGUFISC");
	private By direccionIgualComercialBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionDiferenteBtn = By.cssSelector("#ALTAMEDI_DIFFISC");

	private By direccionSuperiorNOComSIBtn = By.id("ALTAMEDI_IGUCOMER");
	private By direccionSuperiorNOComNOBtn = By.id("ALTAMEDI_DIFFISC");

	private By direccionSuperiorSIBtn = By.id("ALTAMEDI_IGUPADSI");
	private By direccionSuperiorNOBtn = By.id("ALTAMEDI_IGUPADNO");

	//-------Controles de datos de domicilio-----
	private By comprobarDireccionBtn = By.id("BOTON_NORMADOM");
	private By aceptarBtn = By.id("BOTON_ACEPTAR");

	private By listaDirecciones = By.cssSelector("#formDatos > #capaDireccionesPaso2 > div.contentBox > div:nth-child(4) > table > tbody > tr");

	private By aceptarDireccionBtn = By.id("BOTON_ACEPDOMI");

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

	//----------Controles de red social- contacto- medios de contacto-------
	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");
	private By volverBtn = By.id("botonVolver");

	//------Controles de la pagina---------------------
	private By cancelarGeneralBtn = By.id("botonCancelar1");
	private By guardarBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

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

	//--------------Añadir direcciones: los 5 casos basicos--------------------------------- //

	public MediadoresAltaDatosContactoPage anyadirNuevaDireccionFiscal() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(4000);

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "FISC");
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") || getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {
			// Si es oficina o gestor, comprueba el copy de la dirección fiscal automáticamente heredada
			heredaDireccionFiscal();

		} else if(!getScenarioVar(Constants.DIRECCION_FISC_PROVINCIA).isEmpty() && !getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC")) {

			if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA") && !getScenarioVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("GEST")) {
				webDriver.click(direccionSuperiorNOBtn);
				webDriver.waitWithDriver(2000);
			}

			// Si no es oficina o un colaborador gestor + contiene dato en el campo provincia --> completa datos - getVar(Constants.DIRECCION_FISC_PROVINCIA) != null
			completarCampoProvincia(getScenarioVar(Constants.DIRECCION_FISC_PROVINCIA).toString());
			debugInfo("Introducida la provincia de la Dirección Fiscal.");

			completarCampoPoblacion(getScenarioVar(Constants.DIRECCION_FISC_POBLACION).toString());
			debugInfo("Introducida la población de la Dirección Fiscal.");

			completarCampoNombreVia(getScenarioVar(Constants.DIRECCION_FISC_NombreVia).toString());
			debugInfo("Introducida la calle de la Dirección Fiscal.");

			webDriver.waitWithDriver(3000);
			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitWithDriver(3000);
			webDriver.click(aceptarBtn);
			webDriver.waitWithDriver(5000);
			debugInfo("Aceptada la dirección para añadirse a la lista.");
			webDriver.waitWithDriver(4600);
		} else if(getScenarioVar(Constants.DIRECCION_FISC_PROVINCIA).equals(null) || getScenarioVar(Constants.DIRECCION_FISC_PROVINCIA).isEmpty()) {
			// Es colaborador, sin datos --> Click en Fiscal = Nivel superior
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn);
		}

		debugInfo("Se acaba de añadir la Dirección Fiscal.");

		webDriver.waitWithDriver(3000);
		webDriver.exitFrame();

		obtenerDirecciones();

		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage heredaDireccionFiscal() {
		debugBegin();

		// Si es oficina o gestor, comprueba el copy de la dirección fiscal automáticamente heredada
		String copyDireccionFiscalOficina = webDriver.getText(By.cssSelector("#capaDomicilio > table.tableForm > tbody > tr > th > strong")).trim();
		debugInfo("El copy para la Dirección Fiscal de una oficina es: " + copyDireccionFiscalOficina);

		boolean checkDireccionFiscalOficina = copyDireccionFiscalOficina
			.equalsIgnoreCase("Tenga en cuenta que para colaboradores gestores o oficinas, el domicilio fiscal se recoge del nivel superior");
		debugInfo("Comprobamos la Dirección Fiscal, el resultado es: " + checkDireccionFiscalOficina);
		Assert.assertTrue(checkDireccionFiscalOficina, "Comparar campos: el copy de la Dirección Fiscal NO coincide.");

		if(checkDireccionFiscalOficina == true) {
			debugInfo("Hace clic en aceptar dirección fiscal heredada.");
			webDriver.click(aceptarDireccionBtn);
		} else {
			debugInfo("Ha habido un error y no se ha hecho click en aceptar en el mensaje de coincidencia de direcciones fiscales.");
		}
		webDriver.exitFrame();

		debugEnd();
		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoProvincia(String provinciaCampo) {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.setText(provinciaInput, provinciaCampo);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttribute(provinciaInput, provinciaCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoPoblacion(String poblacionCampo) {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.setText(poblacionInput, poblacionCampo);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttribute(poblacionInput, poblacionCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage completarCampoNombreVia(String nombreViaCampo) {
		debugBegin();
		webDriver.waitWithDriver(3000);
		webDriver.setText(viaInput, nombreViaCampo);
		webDriver.waitWithDriver(3000);
		webDriver.clickElementFromDropDownByAttribute(viaInput, viaCombo, "role", "menuitem");
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosContactoPage obtenerDirecciones() {
		debugBegin();
		webDriver.waitWithDriver(3000);

		List<WebElement> obtenerListaDirecciones = webDriver.getElementsInFrame(listaDirecciones, cuerpoFrame);
		debugInfo("Contiene " + obtenerListaDirecciones.size() + " direcciones.");

		for(int i = 1; i < obtenerListaDirecciones.size(); i++) {

			String obtenerTipoDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#formDatos > #capaDireccionesPaso2 > div > div:nth-child(4) > table > tbody > tr:nth-child(" + (i
					+ 1)
					+ ") > td:nth-child(2)"), cuerpoFrame).trim();
			debugInfo("El tipo de dirección es: " + obtenerTipoDireccion);

			String obtenerDireccion = webDriver.getTextInFrame(By.cssSelector(
				"#formDatos > #capaDireccionesPaso2 > div > div:nth-child(4) > table > tbody > tr:nth-child(" + (i
					+ 1)
					+ ") > td:nth-child(3)"), cuerpoFrame).trim();

			if(obtenerTipoDireccion.equalsIgnoreCase("Fiscal")) {
				setTestVar((Constants.DIRECCION_FISC_COMPLETA), obtenerDireccion);
				debugInfo("La dirección Fiscal es " + getTestVar(Constants.DIRECCION_FISC_COMPLETA));
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Comercial")) {
				setTestVar(Constants.DIRECCION_COME_COMPLETA, obtenerDireccion);
				debugInfo("La dirección Comercial es " + getTestVar(Constants.DIRECCION_COME_COMPLETA));
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal producción")) {
				setTestVar((Constants.DIRECCION_PPRO_COMPLETA), obtenerDireccion);
				debugInfo("La dirección Postal Producción es " + getTestVar(Constants.DIRECCION_PPRO_COMPLETA));
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal recibos")) {
				setTestVar((Constants.DIRECCION_PREC_COMPLETA), obtenerDireccion);
				debugInfo("La dirección Postal Recibos es " + getTestVar(Constants.DIRECCION_PREC_COMPLETA));
			}
			if(obtenerTipoDireccion.equalsIgnoreCase("Postal siniestros")) {
				setTestVar((Constants.DIRECCION_PSIN_COMPLETA), obtenerDireccion);
				debugInfo("La dirección Postal Siniestros es " + getTestVar(Constants.DIRECCION_PSIN_COMPLETA));
			}

		}
		debugEnd();
		return this;
	}

	public MediadoresAltaDatosContactoPage anyadirDireccionComercial() {
		debugBegin();
		webDriver.switchToFrame(cuerpoFrame);
		debugInfo("Se entra al método para añadir Direccion Comercial.");
		webDriver.click(anyadirNuevaDireccionBtn);
		webDriver.waitWithDriver(3200);
		webDriver.clickElementFromDropDownByAttributeInFrame(tipoDomicilioCombo, tipoDomicilioOption, modalFrame, "value", "COME");
		debugInfo("Se selecciona añadir Direccion Comercial.");

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(modalFrame);

		if(!getScenarioVar(Constants.DIRECCION_COME_PROVINCIA).isEmpty()) {
			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				webDriver.click(direccionSuperiorNOBtn);
			}
			webDriver.waitForElementToBePresent(direccionDiferenteBtn);
			webDriver.click(direccionDiferenteBtn);
			debugInfo("Se selecciona Direccion Comercial diferente a la Fiscal.");
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getScenarioVar(Constants.DIRECCION_COME_PROVINCIA));
			completarCampoPoblacion(getScenarioVar(Constants.DIRECCION_COME_POBLACION));
			completarCampoNombreVia(getScenarioVar(Constants.DIRECCION_COME_NombreVia));
			webDriver.waitWithDriver(3000);
			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitWithDriver(4000);
			webDriver.click(aceptarBtn);
		}
		// Sin datos de provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(getScenarioVar(Constants.DIRECCION_COME_PROVINCIA).isEmpty() && !getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.waitForElementToBePresent(aceptarDireccionBtn);
			webDriver.click(aceptarDireccionBtn);
		} else if(getScenarioVar(Constants.DIRECCION_COME_PROVINCIA).isEmpty() && getScenarioVar(Constants.NIVEL_ESTRUCTURA)
			.equalsIgnoreCase("INTE")) { // Sin datos de provincia + intermediario --> dirección comercial igual a fiscal

			webDriver.waitWithDriver(2800);
			webDriver.click(direccionIgualFiscalBtn);
			webDriver.waitWithDriver(3000);
			webDriver.click(aceptarDireccionBtn);
		}

		webDriver.exitFrame();
		obtenerDirecciones();
		debugInfo("Se completó el alta de Dirección Comercial.");
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

		if(!getScenarioVar(Constants.DIRECCION_PPRO_PROVINCIA).isEmpty()) {
			// Hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente  getScenarioVar(Constants.DIRECCION_PPRO_PROVINCIA) != null
			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				webDriver.click(direccionSuperiorNOBtn);
				webDriver.waitWithDriver(3000);
			}

			webDriver.click(direccionDiferenteBtn);

			webDriver.waitWithDriver(3000);
			completarCampoProvincia(getScenarioVar(Constants.DIRECCION_PPRO_PROVINCIA));
			completarCampoPoblacion(getScenarioVar(Constants.DIRECCION_PPRO_POBLACION));
			completarCampoNombreVia(getScenarioVar(Constants.DIRECCION_PPRO_NOMBRE_VIA));
			webDriver.waitWithDriver(2000);

			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// Sin datos para la provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE") && (getScenarioVar(Constants.DIRECCION_PPRO_PROVINCIA).isEmpty()
			|| getScenarioVar(Constants.DIR_FISCAL_IGUAL_A).isEmpty())) {

			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn);

		} else if(getScenarioVar(Constants.DIRECCION_PPRO_PROVINCIA).isEmpty()) { // sin datos para provincia + INTE + analizar CSV para obtener coberturan desde DIR_FISCAL_IGUAL_A

			if(getScenarioVar(Constants.DIR_PRODUCCION_IGUAL_A).equalsIgnoreCase("PPRO_FISC") && !getScenarioVar(Constants.DIR_PRODUCCION_IGUAL_A)
				.isEmpty()) {
				webDriver.waitWithDriver(2000);
				webDriver.click(direccionIgualFiscalBtn);

			} else if(getScenarioVar(Constants.DIR_PRODUCCION_IGUAL_A).equalsIgnoreCase("PPRO_COME") && !getScenarioVar(Constants.DIR_PRODUCCION_IGUAL_A).isEmpty()) {

				webDriver.click(direccionIgualComercialBtn);
			}

			webDriver.click(aceptarDireccionBtn);
		}

		webDriver.exitFrame();
		obtenerDirecciones();

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

		if(!getScenarioVar(Constants.DIRECCION_PREC_PROVINCIA).isEmpty()) {
			// Hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente / getScenarioVar(Constants.DIRECCION_PREC_PROVINCIA) != null
			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				webDriver.click(direccionSuperiorNOBtn);
				webDriver.waitWithDriver(2400);
			}
			webDriver.click(direccionDiferenteBtn);
			webDriver.waitWithDriver(1800);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getScenarioVar(Constants.DIRECCION_PREC_PROVINCIA));
			completarCampoPoblacion(getScenarioVar(Constants.DIRECCION_PREC_POBLACION));
			completarCampoNombreVia(getScenarioVar(Constants.DIRECCION_PREC_NombreVia));
			webDriver.waitWithDriver(2000);
			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// Sin datos para la provincia + oficina --> hereda datos del nivel superios
		else if(getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("OFIC") && getScenarioVar(Constants.DIRECCION_PREC_PROVINCIA).isEmpty()) {
			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn);
		} else if(getScenarioVar(Constants.DIRECCION_PREC_PROVINCIA).isEmpty()) { // sin datos para provincia + INTE + analizar CSV para obtener coberturan desde DIR_FISCAL_IGUAL_A

			if(getScenarioVar(Constants.DIR_RECIBOS_IGUAL_A).equalsIgnoreCase("PREC_FISC") && !getScenarioVar(Constants.DIR_RECIBOS_IGUAL_A).isEmpty()) {
				webDriver.waitWithDriver(2000);
				webDriver.click(direccionIgualFiscalBtn);
			} else if(getScenarioVar(Constants.DIR_RECIBOS_IGUAL_A).equalsIgnoreCase("PREC_COME") && !getScenarioVar(Constants.DIR_RECIBOS_IGUAL_A).isEmpty()) {

				webDriver.click(direccionIgualComercialBtn);
			}

			webDriver.click(aceptarDireccionBtn);
		}

		webDriver.exitFrame();
		obtenerDirecciones();
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

		if(!getScenarioVar(Constants.DIRECCION_PSIN_PROVINCIA).isEmpty()) {
			// Hay datos para provincia + clic en "Direccion seleccionada != superior" y se selecciona diferente / getScenarioVar(Constants.DIRECCION_PSIN_PROVINCIA) != null
			if(!getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
				webDriver.click(direccionSuperiorNOBtn);
				webDriver.waitWithDriver(2000);
			}

			webDriver.click(direccionDiferenteBtn);
			webDriver.waitWithDriver(2000);
			webDriver.waitForElementToBePresent(provinciaInput);
			completarCampoProvincia(getScenarioVar(Constants.DIRECCION_PSIN_PROVINCIA));
			completarCampoPoblacion(getScenarioVar(Constants.DIRECCION_PSIN_POBLACION));
			completarCampoNombreVia(getScenarioVar(Constants.DIRECCION_PSIN_NOMBRE_VIA));
			webDriver.waitWithDriver(2000);

			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));
			webDriver.click(comprobarDireccionBtn);
			webDriver.waitForElementToBePresent(aceptarBtn);
			webDriver.click(aceptarBtn);
		}
		// Sin datos para la provincia + oficina / colaborador --> hereda datos del nivel superios
		else if(getScenarioVar(Constants.DIRECCION_PSIN_PROVINCIA).isEmpty()
			&& !getScenarioVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			webDriver.click(direccionSuperiorSIBtn);
			webDriver.click(aceptarDireccionBtn);

		} else if(getScenarioVar(Constants.DIRECCION_PSIN_PROVINCIA).isEmpty()) { // sin datos para provincia + INTE + analizar CSV para obtener coberturas desde DIR_FISCAL_IGUAL_A

			if(getScenarioVar(Constants.DIR_SINIESTROS_IGUAL_A).equalsIgnoreCase("PSIN_FISC") && !getScenarioVar(Constants.DIR_SINIESTROS_IGUAL_A).isEmpty()) {
				webDriver.click(direccionIgualFiscalBtn);
			} else if(getScenarioVar(Constants.DIR_SINIESTROS_IGUAL_A).equalsIgnoreCase("PSIN_COME") && !getScenarioVar(Constants.DIR_SINIESTROS_IGUAL_A).isEmpty()) {
				webDriver.click(direccionIgualComercialBtn);
			}

			webDriver.click(aceptarDireccionBtn);
		}

		webDriver.exitFrame();
		obtenerDirecciones();
		debugEnd();

		return this;
	}

	//------------------Clicks botones---------------------------------

	public MediadoresAltaDatosContactoPage clickContinuar() {
		debugBegin();

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		webDriver.waitWithDriver(3000);

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

	//---------------RETENCIONES PARA ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR------------------------

	//----ALERTA DE SISTEMA-------
	public boolean alertaSistemaContacto(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(alertaDireccionesTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();
		return checkAlerta;
	}

	public boolean alertaSistemaDireccionesContacto(String mensaje) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		String alerta = webDriver.getTextInFrame(alertaDireccionesOficinaTxt, modalFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
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
		webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));

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
			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));

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
		webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));

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
			webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));

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
		webDriver.setText(numeroViaInput, StringUtils.getRandomNumberInRange(1, 201));

		webDriver.click(comprobarDireccionBtn);
		webDriver.click(aceptarBtn);

		webDriver.exitFrame();

		debugInfo("Se ha rellenado la Dirección Postal Siniestros.");
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();
		return this;
	}

}
