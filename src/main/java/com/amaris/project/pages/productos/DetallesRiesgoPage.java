package com.amaris.project.pages.productos;

import org.testng.Assert;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;

public class DetallesRiesgoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By edificioMaderaDrpDwn = By.id("edifConstruccionMadera");
	private By noMaderaBtn = By.cssSelector("#edifConstruccionMadera > option[label ~= 'No']");
	private By deshabitacionBtn = By.id("deshabilitacion");
	private By deshabitacion75Btn = By.cssSelector("#deshabilitacion > option:nth-of-type(2)");
	private By firstOptionEdifMadOption = By.cssSelector("#edifConstruccionMadera > option:first-child");

	private By deshabilitacionDrpDwn = By.cssSelector("#deshabilitacion > option");

	private By continuarBtn = By.xpath(".//*[contains(text(),'Continuar')]");

	private By m2ViviendasInput = By.cssSelector("#m2Viviendas");
	private By m2OficinasInput = By.cssSelector("#m2Oficinas");
	private By m2GarajesInput = By.cssSelector("#m2Garajes");
	private By m2ZonasAjardinadasInput = By.cssSelector("#m2ZonasAjardinadas");

	private By numeroViviendasInput = By.name("numViviendas");
	private By numeroPlantasAltoInput = By.name("numPlantasAlto");
	private By numeroPlantasSotanoInput = By.name("numPlantasSotano");
	private By numeroEdificiosInput = By.cssSelector("#numEdificios");
	private By numeroLocalesInput = By.name("numLocales");
	private By anyoConstruccionInput = By.cssSelector("#anyoConstruccion");

	private By capitalContinenteTotalAseguradoTxt = By.cssSelector("#capitalContinenteTotalAsegurado");
	private By capitalContenidoTxt = By.cssSelector("#capitalContenido");
	private By capitalContinenteInput = By.cssSelector("#capitalContinente");

	private By gasolineraMenos50MBtn = By.cssSelector("#edifGasolineraMenos50m");
	private By calefaccionCentralAguaCalienteCentralizadaBtn = By.cssSelector("#edifCalefaccionCentral");
	private By depositoCombustibleBtn = By.cssSelector("#edifDepositoCombustible");
	private By anyoRehabAguasInput = By.cssSelector("#anyoRehabAguasCom");
	private By nivelRehabAguasDrpDwn = By.cssSelector("#nivelRehabAguasCom");
	private By anyoRehabIntegralInput = By.cssSelector("#anyoRehabIntegral");
	private By m2ContruidosTotalesInput = By.cssSelector("#m2ConstruidosTotales");

	private By avisoGarajesTxt = By.xpath(".//*[text()='Los datos de superficies (m']");

	private By aceptarBtn = By.xpath(".//*[@id='modalErrores']//*[text()='Aceptar']");
	private By txtM2Trasteros = By.cssSelector("#m2Trasteros");
	private By txtNumPlazasGaraje = By.cssSelector("#numPlazasGarajes");
	private By avisoNoTieneRefCatastralTxt = By
		.xpath(".//*[text()='El edificio no tiene referencia catastral, intente ubicar el riesgo de nuevo o introduzca los datos de superficies y año de construcción.']/../../../..//button[text()='Aceptar']");

	private By convertirBtn = By.cssSelector("[ng-bind-html*='com_convertirProyecto']");
	private By convertirAProyectoBtn = By.cssSelector("button[ng-click*='convertToProject']");
	private By msgAvisoSistemaTxt = By.cssSelector("table.wideBox strong");
	private By procesandoModal = By.cssSelector("#procesando");
	// endregion

	public DetallesRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public DetallesRiesgoPage waitProcesando() {
		debugBegin();

		debugInfo("Se espera al mensaje \"procesando\"");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesandoModal)) {
			debugInfo("Se muestra mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage clickConvertirProyectoDos() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(convertirAProyectoBtn, cuerpoFrame);

		if(webDriver.isPresentInFrame(msgAvisoSistemaTxt, cuerpoFrame)) {
			debugInfo("Excepción general al convertir a proyecto.");
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage clickConvertirProyecto() {
		debugBegin();

		this.webDriver.scrollToBottomInFrame(cuerpoFrame);
		this.webDriver.waitWithDriver(8000);

		this.webDriver.clickInFrame(convertirBtn, cuerpoFrame);

		this.webDriver.waitWithDriver(8000);

		debugEnd();

		return this;
	}

	// This function modifies the values of the fields located in the page.
	// All the values are modified if they are different than the ones pressent in the object TestCasse Data.
	public String completarDatosRiesgoMinimos() {
		debugBegin();

		String value = "";

		// String edificioMadera =
		// webDriver.getText(firstOptionEdifMad);
		// if
		// (!edificioMadera.equals(testDataM.getTestVar(testId,"edificioMadera"))
		// &&
		// !testDataM.getTestVar(testId,"edificioMadera").equals(""))

		// webDriver.waitWithDriver(5000);

		// if(!edificioMadera.equals(testDataM.getTestVar(testId,
		// "edificioMadera")) && !testDataM.getTestVar(testId,
		// "edificioMadera").equals("")) {
		// webDriver.selectValueInDropDown(cmbEdificioMadera,
		// getTestVar("edificioMadera"));
		// webDriver.clickElementFromDropDownByText(cmbEdificioMadera,
		// getTestVar("edificioMadera"));
		// } else if(getTestVar("edificioMadera").equals("")
		// && !edificioMadera.equals("")) { throw new Exception("El valor del
		// campo porcentaje edificio madera no es blanco al entrar en la
		// página"); }

		// webDriver.clickElementFromDropDownByText(cmbEdificioMadera,
		// getTestVar("edificioMadera"));

		webDriver.clickInFrame(edificioMaderaDrpDwn, cuerpoFrame);
		webDriver.clickInFrame(noMaderaBtn, cuerpoFrame);
		webDriver.waitWithDriver(4000);

		// String deshabilitacion =
		// webDriver.getText(edifConstruccionMadera);
		// if(!deshabilitacion.equals(testDataM.getTestVar(testId,
		// "deshabilitacion")) && !testDataM.getTestVar(testId,
		// "deshabilitacion").equals("")) {
		// webDriver.clickElementFromDropDownByText(cmbDeshabilitacion,
		// getTestVar("deshabilitacion"));
		// } else if(testDataM.getTestVar(testId,
		// "deshabilitacion").equals("")
		// && !deshabilitacion.equals("")) { throw new Exception("El valor del
		// campo deshabilitación no es blanco al entrar en la página"); }

		webDriver.clickInFrame(deshabitacionBtn, cuerpoFrame);
		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(deshabitacion75Btn, cuerpoFrame);
		webDriver.waitWithDriver(4000);
		// value = webDriver.getText(txtAnyoConstruccion);

		/* AÑO DE CONSTRUCCION Y REHABILITACIONES */
		webDriver.setTextInFrame(anyoConstruccionInput, cuerpoFrame, "2000");

		/* SUPERFICIES */
		value = webDriver.getTextInFrame(anyoConstruccionInput, cuerpoFrame);

		webDriver.waitWithDriver(3000);

		debugEnd();

		return value;
	}

	public String getCapitalContinente() {
		return webDriver.getTextInFrame(capitalContinenteInput, cuerpoFrame);
	}

	public String getCapitalContenido() {
		return webDriver.getTextInFrame(capitalContenidoTxt, cuerpoFrame);
	}

	public String getCapitalContinenteTotalAsegurado() {
		return webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame);
	}

	public DetallesRiesgoPage completarDatosRiesgo() throws Exception {
		debugBegin();

		// webDriver.clickElementFromDropDownByIndexInFrame(edifConstruccionMadera, cuerpoFrame, 1);
		webDriver.clickInFrame(firstOptionEdifMadOption, cuerpoFrame);

		// webDriver.clickElementFromDropDownByIndexInFrame(edifConstruccionMadera, cuerpoFrame, 1);

		webDriver.clickInFrame(deshabilitacionDrpDwn, cuerpoFrame);

		// webDriver.switchToFrame(cuerpoFrame);

		// if (testDataM.getCapitalContinente() != null)
		if(getTestVar(Constants.CAPITAL_CONTINENTE) != null && !getTestVar(Constants.CAPITAL_CONTINENTE).isEmpty()) {
			// if(Boolean.parseBoolean(getTestVar("capitalContinenteVariacion"))) {
			// Double capitalContinenteModified =
			// nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame)).doubleValue()
			// + testDataM.getCapitalContinente().doubleValue();

			// Double capitalContinenteModified = nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame))
			// .doubleValue() + Double.parseDouble(getTestVar(Constants.CAPITAL_CONTINENTE));

			// webDriver.appendTextInFrame(txtCapitalContinente,
			// cuerpoFrame, String.valueOf(capitalContinenteModified));
			// webDriver.appendTextInFrame(txtCapitalContinente, cuerpoFrame,
			// String.valueOf(capitalContinenteModified));
			// webDriver.tabulateElementInFrame(txtCapitalContinente, cuerpoFrame);
			// testDataM.setCapitalContinente(capitalContinenteModified);
			// setConfigVar("CapitalContinente", "capitalContinenteModified");

			// } else {
			// webDriver.appendTextInFrame(txtCapitalContinente, cuerpoFrame,
			// String.valueOf(getConfigVar("CapitalContinente")));
			webDriver.appendTextInFrame(capitalContinenteInput, cuerpoFrame, getTestVar(Constants.CAPITAL_CONTINENTE));
			// webDriver.tabulateElementInFrame(txtCapitalContinente, cuerpoFrame);
			// testDataM.setCapitalContinente(nf.parse(webDriver.getTextInFrame(txtCapitalContinente,
			// cuerpoFrame)));
			// setConfigVar("CapitalContinente", webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame));
			// }
		}

		// if(getTestVar("capital_contenido") != null) {
		// Double capitalContenidoModified =
		// nf.parse(webDriver.getTextInFrame(txtCapitalContenido,
		// cuerpoFrame)).doubleValue()
		// + testDataM.getCapitalContenido().doubleValue();

		// Double capitalContenidoModified = Double.parseDouble(webDriver.getTextInFrame(txtCapitalContenido,
		// cuerpoFrame))
		// + Double.parseDouble(getTestVar("CapitalContenido"));
		// webDriver.appendTextInFrame(txtCapitalContenido, cuerpoFrame, nf.format(capitalContenidoModified));
		// webDriver.tabulateElementInFrame(txtCapitalContenido, cuerpoFrame);
		// testDataM.setCapitalContenido(capitalContenidoModified);
		// setTestVar("CapitalContenido", "capitalContenidoModified");
		// }

		String edificioMadera = webDriver.getTextInFrame(edificioMaderaDrpDwn, cuerpoFrame);

		if(getTestVar(Constants.CONSTRUIDO_MADERA) != null && !getTestVar(Constants.CONSTRUIDO_MADERA).isEmpty()
			&& !edificioMadera.equals(getTestVar(Constants.CONSTRUIDO_MADERA))) {
			webDriver.clickElementFromDropDownByTextInFrame(edificioMaderaDrpDwn, cuerpoFrame, getTestVar(Constants.CONSTRUIDO_MADERA));
		} else if((getTestVar(Constants.CONSTRUIDO_MADERA) == null || getTestVar(Constants.CONSTRUIDO_MADERA).isEmpty())
			&& !edificioMadera.isEmpty()) { throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página"); }

		webDriver.waitWithDriver(2000);

		String deshabitacionDatos = getTestVar(Constants.DESHABITACION);
		String deshabilitacionWeb = webDriver.getTextInFrame(deshabilitacionDrpDwn, cuerpoFrame);

		if(deshabitacionDatos != null && !deshabitacionDatos.isEmpty() && !deshabilitacionWeb.equals(deshabitacionDatos)) {
			webDriver.clickElementFromDropDownByTextInFrame(deshabilitacionDrpDwn, cuerpoFrame, getTestVar(Constants.DESHABITACION));
		} else if((deshabitacionDatos == null || deshabitacionDatos.isEmpty())
			&& !deshabilitacionWeb.isEmpty()) { throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página"); }

		String m2ContruidosTotales = webDriver.getTextInFrame(m2ContruidosTotalesInput, cuerpoFrame);
		if(m2ContruidosTotales.isEmpty() && getTestVar(Constants.M2_CONSTRUIDOS) != null && !getTestVar(Constants.M2_CONSTRUIDOS).isEmpty()) {
			webDriver.appendTextInFrame(m2ContruidosTotalesInput, cuerpoFrame, getTestVar(Constants.M2_CONSTRUIDOS));
		}

		String anyoConstruccion = webDriver.getTextInFrame(anyoConstruccionInput, cuerpoFrame);

		if(getTestVar(Constants.ANYO_CONSTRUIDO) != null && getTestVar(Constants.ANYO_CONSTRUIDO).equals(Constants.MayorDe50)) {
			int year = Integer.parseInt(DateUtils.getTodayDate("yyyy"));

			webDriver.appendTextInFrame(anyoConstruccionInput, cuerpoFrame, String.valueOf(year - 51));
		} else if(getTestVar(Constants.ANYO_CONSTRUIDO) != null && !anyoConstruccion.equals(getTestVar(Constants.ANYO_CONSTRUIDO))) {
			int year = Integer.parseInt(DateUtils.getTodayDate("yyyy"));

			webDriver.appendTextInFrame(anyoConstruccionInput, cuerpoFrame, String.valueOf(year - 49));
		}

		String anyoRehabAguas = getTestVar(Constants.ANYO_REHAB_AGUAS) == null ? "" : getTestVar(Constants.ANYO_REHAB_AGUAS);

		if(anyoRehabAguas.equals(webDriver.getTextInFrame(anyoConstruccionInput, cuerpoFrame))
			&& getTestVar(Constants.NIVEL_REHAB_AGUAS) != null) {
			int year = Integer.parseInt(webDriver.getTextInFrame(anyoConstruccionInput, cuerpoFrame));

			webDriver.appendTextInFrame(anyoRehabAguasInput, cuerpoFrame, String.valueOf(year + 1));
			webDriver.clickElementFromDropDownByTextInFrame(nivelRehabAguasDrpDwn, cuerpoFrame, anyoRehabAguas);
		}

		if(getTestVar(Constants.ANYO_REHAB_INTEGRAL) != null) {
			webDriver.appendTextInFrame(anyoRehabIntegralInput, cuerpoFrame, getTestVar(Constants.ANYO_REHAB_INTEGRAL));
		}

		String m2Viviendas = webDriver.getTextInFrame(m2ViviendasInput, cuerpoFrame);

		if(getTestVar(Constants.M2_VIVIENDAS) != null && !m2Viviendas.equals(getTestVar(Constants.M2_VIVIENDAS))) {
			getCapitales();

			getValuesBefore();

			webDriver.appendTextInFrame(m2ViviendasInput, cuerpoFrame, getTestVar(Constants.M2_VIVIENDAS));
			webDriver.tabulateElementInFrame(m2ViviendasInput, cuerpoFrame);

			getValuesAfter();
			compareValues(Constants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Garajes = webDriver.getTextInFrame(m2GarajesInput, cuerpoFrame);

		if(getTestVar(Constants.M2_GARAJES) != null && !m2Garajes.equals(getTestVar(Constants.M2_GARAJES))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2GarajesInput, cuerpoFrame, getTestVar(Constants.M2_GARAJES));
			webDriver.tabulateElementInFrame(m2GarajesInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 garajes");
		}

		String m2Oficinas = webDriver.getTextInFrame(m2OficinasInput, cuerpoFrame);

		if(getTestVar(Constants.M2_OFICINAS) != null && !m2Oficinas.equals(getTestVar(Constants.M2_OFICINAS))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2OficinasInput, cuerpoFrame, getTestVar(Constants.M2_OFICINAS));
			webDriver.tabulateElementInFrame(m2OficinasInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = webDriver.getTextInFrame(m2ZonasAjardinadasInput, cuerpoFrame);

		if(getTestVar(Constants.M2_ZONAS_AJARDINADAS) != null && !m2ZonasAjardinadas.equals(getTestVar(Constants.M2_ZONAS_AJARDINADAS))) {
			webDriver.appendTextInFrame(m2ZonasAjardinadasInput, cuerpoFrame, getTestVar(Constants.M2_ZONAS_AJARDINADAS));
			webDriver.tabulateElementInFrame(m2ZonasAjardinadasInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		String numeroViviendas = webDriver.getTextInFrame(numeroViviendasInput, cuerpoFrame);

		if(getTestVar(Constants.NUM_VIVIENDAS) != null && !numeroViviendas.equals(getTestVar(Constants.NUM_VIVIENDAS))) {
			webDriver.appendTextInFrame(numeroViviendasInput, cuerpoFrame, getTestVar(Constants.NUM_VIVIENDAS));
		}

		String numeroPlantasAlto = webDriver.getTextInFrame(numeroPlantasAltoInput, cuerpoFrame);

		if(getTestVar(Constants.NUM_PLANTAS_ALTO) != null && !numeroPlantasAlto.equals(getTestVar(Constants.NUM_PLANTAS_ALTO))) {
			webDriver.appendTextInFrame(numeroPlantasAltoInput, cuerpoFrame, getTestVar(Constants.NUM_PLANTAS_ALTO));
		}

		String numeroPlantasSotano = webDriver.getTextInFrame(numeroPlantasSotanoInput, cuerpoFrame);

		if(getTestVar(Constants.NUM_PLANTAS_SOTANO) != null && !numeroPlantasSotano.equals(getTestVar(Constants.NUM_PLANTAS_SOTANO))) {
			webDriver.appendTextInFrame(numeroPlantasSotanoInput, cuerpoFrame, getTestVar(Constants.NUM_PLANTAS_SOTANO));
		}

		String numeroEdificios = webDriver.getTextInFrame(numeroEdificiosInput, cuerpoFrame);

		if(getTestVar(Constants.NUM_EDIFICIOS) != null && !numeroEdificios.equals(getTestVar(Constants.NUM_EDIFICIOS))) {
			webDriver.appendTextInFrame(numeroEdificiosInput, cuerpoFrame, getTestVar(Constants.NUM_EDIFICIOS));
		}

		if(Boolean.parseBoolean(getTestVar(Constants.GASOLINERA_MENOS_50M))) {
			webDriver.clickInFrame(gasolineraMenos50MBtn, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.CALEFACCION_CENTRAL))
			&& !webDriver.isSelectedInFrame(calefaccionCentralAguaCalienteCentralizadaBtn, cuerpoFrame)) {
			webDriver.clickInFrame(calefaccionCentralAguaCalienteCentralizadaBtn, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.DEPOSITO_COMBUSTIBLE))) {
			webDriver.clickInFrame(depositoCombustibleBtn, cuerpoFrame);
		}

		webDriver.clickInFrame(capitalContinenteInput, cuerpoFrame);

		debugEnd();

		return this;
	}

	// This function modifies the values of the fields located in the page. All the values are
	// modified if they are different than the ones present
	// in the object TestCasse Data inside the values whose variables start with Modified.
	public DetallesRiesgoPage modificarDatosRiesgo() {
		debugBegin();

		// Modify Año rehabilitación de aguas comunitarias
		String anyoRehabAguas = webDriver.getTextInFrame(anyoRehabAguasInput, cuerpoFrame);
		String anyoConstruccion = webDriver.getTextInFrame(anyoConstruccionInput, cuerpoFrame);

		if(getTestVar(Constants.NIVEL_REHAB_AGUAS) != null) {
			if(anyoRehabAguas.isEmpty()) {
				webDriver.appendTextInFrame(anyoRehabAguasInput, cuerpoFrame, String.valueOf(Integer.parseInt(anyoConstruccion) + 1));
				webDriver.clickElementFromDropDownByTextInFrame(nivelRehabAguasDrpDwn, cuerpoFrame, getTestVar(Constants.NIVEL_REHAB_AGUAS));

				setTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES, webDriver.getTextInFrame(anyoRehabAguasInput, cuerpoFrame));
			} else {
				// If Año rehabilitación de aguas comunitarias is already present,
				// then input Año rehabilitación de aguas comunitarias + 1.
				// Required if we want to execute this test in the same week, before database reset.
				webDriver.appendText(anyoRehabAguasInput, String.valueOf(Integer.parseInt(anyoRehabAguas) + 1));
				webDriver.clickElementFromDropDownByTextInFrame(nivelRehabAguasDrpDwn, cuerpoFrame, getTestVar(Constants.NIVEL_REHAB_AGUAS));

				setTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES, webDriver.getTextInFrame(anyoRehabAguasInput, cuerpoFrame));
			}
		}

		String numeroEdificios = webDriver.getTextInFrame(numeroEdificiosInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_NUM_EDIFICIOS) != null && !numeroEdificios.equals(getTestVar(Constants.CAMBIO_NUM_EDIFICIOS))) {
			webDriver.appendTextInFrame(numeroEdificiosInput, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_EDIFICIOS));
		}

		String numeroViviendas = webDriver.getTextInFrame(numeroViviendasInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_NUM_VIVIENDAS) != null && !numeroViviendas.equals(getTestVar(Constants.CAMBIO_NUM_VIVIENDAS))) {
			webDriver.appendTextInFrame(numeroViviendasInput, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_VIVIENDAS));
		}

		String numeroLocales = webDriver.getTextInFrame(numeroLocalesInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_NUM_LOCALES) != null && !numeroLocales.equals(getTestVar(Constants.CAMBIO_NUM_LOCALES))) {
			webDriver.appendTextInFrame(numeroLocalesInput, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_LOCALES));
		}

		// TODO Comprobar el .equals('-1') puede que no sea correcto
		String m2ContruidosTotales = webDriver.getTextInFrame(m2ContruidosTotalesInput, cuerpoFrame);
		if(getTestVar(Constants.M2_CONSTRUIDOS) != null && m2ContruidosTotales.equals("-1")) {
			webDriver.appendTextInFrame(m2ContruidosTotalesInput, cuerpoFrame, getTestVar(Constants.M2_CONSTRUIDOS));
		}

		String m2Viviendas = webDriver.getTextInFrame(m2ViviendasInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_M2_VIVIENDAS) != null && !m2Viviendas.equals(getTestVar(Constants.CAMBIO_M2_VIVIENDAS))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2ViviendasInput, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_VIVIENDAS));
			webDriver.tabulateElementInFrame(m2ViviendasInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 viviendas");

			setTestVar(Constants.M2_CONSTRUIDOS, webDriver.getTextInFrame(m2ContruidosTotalesInput, cuerpoFrame));
		}

		String m2Garajes = webDriver.getTextInFrame(m2ViviendasInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_M2_GARAJES) != null && !m2Garajes.equals(getTestVar(Constants.CAMBIO_M2_GARAJES))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2GarajesInput, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_GARAJES));
			webDriver.tabulateElementInFrame(m2GarajesInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Oficinas = webDriver.getTextInFrame(m2OficinasInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_M2_OFICINAS) != null && !m2Oficinas.equals(getTestVar(Constants.CAMBIO_M2_OFICINAS))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2OficinasInput, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_OFICINAS));
			webDriver.tabulateElementInFrame(m2OficinasInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = webDriver.getTextInFrame(m2ZonasAjardinadasInput, cuerpoFrame);
		if(getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS) != null && !m2ZonasAjardinadas.equals(getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS))) {
			getValuesBefore();

			webDriver.appendTextInFrame(m2ZonasAjardinadasInput, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS));
			webDriver.tabulateElementInFrame(m2ZonasAjardinadasInput, cuerpoFrame);

			getValuesAfter();

			compareValues(Constants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage getCapitales() {
		debugBegin();

		webDriver.waitWithDriver(2000);

		if(!webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame).isEmpty()) {
			webDriver.scrollToBottomInFrame(cuerpoFrame);
			setTestVar(Constants.CAPITAL_TOTAL, webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame));
			setTestVar(Constants.CAPITAL_CONTENIDO, webDriver.getTextInFrame(capitalContenidoTxt, cuerpoFrame));
			setTestVar(Constants.CAPITAL_CONTINENTE, webDriver.getTextInFrame(capitalContinenteInput, cuerpoFrame));
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage checkForInfraseguroOrSupraSeguro() {
		debugBegin();

		// Double CapitalTotalAsegurado = nf
		// .parse(webDriver.getText(txtCapitalContinenteTotalAsegurado))
		// .doubleValue();
		// Double CapitalContenido =
		// nf.parse(webDriver.getText(txtCapitalContenido))
		// .doubleValue();
		Double capitalContiente = Double.parseDouble(webDriver.getTextInFrame(capitalContinenteInput, cuerpoFrame));

		if(capitalContiente > Double.parseDouble(getTestVar(Constants.CAPITAL_CONTINENTE))) {
			setTestVar(Constants.INFRA_SEGURO, "true");
		} else if(capitalContiente < Double.parseDouble(getTestVar(Constants.CAPITAL_CONTINENTE))) {
			setTestVar(Constants.SUPRA_SEGURO, "true");
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage clickContinuar() {
		debugBegin();
		// CheckForInfraseguroOrSupraSeguro();
		// cuerpoFrame.click();

		webDriver.scrollToBottom();

		webDriver.waitWithDriver(8000);

		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		webDriver.waitWithDriver(8000);

		// TODO - This is supposed to check that the madera and deshabitacion
		// fields are mandatory, but currently gives a NULL pointer exception.
		// Perhaps is should be moved out of ClikOnContinuar.

		// if(getTestVar("edificio_madera").equals("") &&
		// getTestVar("deshabitacion").equals("")) {
		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.click(btnCamposObligatiosModalWindowAceptar);

		// webDriver.waitWithDriver(5000);

		// webDriver.clickElementFromDropDownByIndex(edifConstruccionMadera, 0);

		// webDriver.clickElementFromDropDownByIndex(deshabilitacion, 0);

		// String color1 =
		// webDriver.getElement(cmbDeshabilitacion).getCssValue(
		// "border-color"); String color2 =
		// webDriver.getElement(cmbEdificioMadera).getCssValue(
		// "border-color");
		//
		// Assert.assertTrue(color1.equals("rgb(169, 68, 66)"), "El campo deshabilitación no tiene un borde rojo");
		// Assert.assertTrue(color2.equals("rgb(169, 68, 66)"), "El campo edificio madera no tiene un borde rojo");

		// webDriver.exitFrame(); //}

		// webDriver.scrollToBottom();
		debugEnd();

		return this;
	}

	public DetallesRiesgoPage getValuesBefore() {
		if(!webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame).isEmpty()) {
			setTestVar(Constants.CAPITAL_CONTENIDO_ANTES, webDriver.getTextInFrame(capitalContenidoTxt, cuerpoFrame));
			setTestVar(Constants.CAPITAL_CONTINENTE_ANTES, webDriver.getTextInFrame(capitalContinenteInput, cuerpoFrame));
			setTestVar(Constants.CAPITAL_TOTAL_ANTES, webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame));
		}

		return this;
	}

	public DetallesRiesgoPage getValuesAfter() {
		setTestVar(Constants.CAPITAL_CONTENIDO_DESPUES, webDriver.getTextInFrame(capitalContenidoTxt, cuerpoFrame));
		setTestVar(Constants.CAPITAL_CONTINENTE_DESPUES, webDriver.getTextInFrame(capitalContinenteInput, cuerpoFrame));
		setTestVar(Constants.CAPITAL_TOTAL_DESPUES, webDriver.getTextInFrame(capitalContinenteTotalAseguradoTxt, cuerpoFrame));

		return this;
	}

	public DetallesRiesgoPage compareValues(String comparisonType, String modification) {
		Double capitalContenidoBefore = Double.parseDouble(getTestVar(Constants.CAPITAL_CONTENIDO_ANTES));
		Double capitalContenidoAfter = Double.parseDouble(getTestVar(Constants.CAPITAL_CONTENIDO_DESPUES));
		Double capitalContinenteBefore = Double.parseDouble(getTestVar(Constants.CAPITAL_CONTINENTE_ANTES));
		Double capitalContinenteAfter = Double.parseDouble(getTestVar(Constants.CAPITAL_CONTINENTE_DESPUES));
		Double capitalTotalBefore = Double.parseDouble(getTestVar(Constants.CAPITAL_TOTAL_ANTES));
		Double capitalTotalAfter = Double.parseDouble(getTestVar(Constants.CAPITAL_TOTAL_DESPUES));

		switch(comparisonType) {
			case Constants.NotEqual:
				if(capitalContenidoBefore == capitalContenidoAfter
					|| capitalContinenteBefore == capitalContinenteAfter
					|| capitalTotalBefore == capitalTotalAfter) {
					setTestVar(Constants.ERROR_CAMBIO_CANTIDADES, "true");
					setTestVar(Constants.MENSAJE_ERROR_CAMBIO_CANTIDADES, "El valor de las cantiadaes no ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);
				}

				break;
			case Constants.Equal:
				if(capitalContenidoBefore != capitalContenidoAfter
					|| capitalContinenteBefore != capitalContinenteAfter
					|| capitalTotalBefore != capitalTotalAfter) {
					setTestVar(Constants.ERROR_CAMBIO_CANTIDADES, "true");
					setTestVar(Constants.MENSAJE_ERROR_CAMBIO_CANTIDADES, "El valor de las cantiadaes ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);
				}

				break;
			default:
		}

		return this;
	}

	public DetallesRiesgoPage checkAvisoGarajes() {
		debugBegin();

		if(Boolean.parseBoolean(getTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES))) {
			if(webDriver.getElementsInFrame(avisoGarajesTxt, cuerpoFrame).size() != 1) {
				setTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES, "true");
			}

			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage checkAvisoNoTieneRefCatastral() {
		debugBegin();

		if(webDriver.isPresentInFrame(avisoNoTieneRefCatastralTxt, cuerpoFrame)) {
			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public DetallesRiesgoPage checkAvisoGarajesWithException() {
		debugBegin();

		if(Boolean.parseBoolean(getTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES))
			&& Boolean.parseBoolean(getTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES))) {
			Assert.assertTrue(!Boolean.parseBoolean(getTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES)), Constants.AvisoGarajesErrorMessage);
		}

		debugEnd();

		return this;
	}

	public boolean isFieldEnabled(String fieldName) {
		boolean result = false;

		switch(fieldName) {
			case "M2 Trasteros":
				if(webDriver.isEnabledInFrame(txtM2Trasteros, cuerpoFrame)) {
					result = true;
				}

				break;
			case "No plantas bajo rasante":
				if(webDriver.isEnabledInFrame(numeroPlantasSotanoInput, cuerpoFrame)) {
					result = true;
				}

				break;
			case "No plantas en alto":
				if(webDriver.isEnabledInFrame(numeroPlantasAltoInput, cuerpoFrame)) {
					result = true;
				}

				break;
			case "M2 Garajes":
				// isDisplayed
				if(webDriver.isEnabledInFrame(m2GarajesInput, cuerpoFrame)) {
					result = true;
				}

				break;
			case "No Plazas de garaje":
				// isDisplayed
				if(webDriver.isEnabledInFrame(txtNumPlazasGaraje, cuerpoFrame)) {
					result = true;
				}

				break;
			default:
		}

		return result;
	}

	public DetallesRiesgoPage enterAnyoConstruccionMoreThan50() {
		int year = Integer.parseInt(DateUtils.getTodayDate("yyyy"));

		webDriver.appendTextInFrame(anyoConstruccionInput, cuerpoFrame, String.valueOf(year - 51));

		return this;
	}
	// endregion
}
