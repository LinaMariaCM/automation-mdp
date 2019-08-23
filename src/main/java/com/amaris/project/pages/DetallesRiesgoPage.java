package com.amaris.project.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class DetallesRiesgoPage extends PageObject {

	private Locale locale = new Locale("es", "ES");
	private NumberFormat nf = NumberFormat.getInstance(locale);
	private Double CapitalTotalAsegurado = null;
	private Double CapitalContenido = null;
	private Double CapitalContinente = null;

	private Double CapitalContenidoBefore = null;
	private Double CapitalContenidoAfter = null;
	private Double CapitalTotalAseguradoBefore = null;
	private Double CapitalTotalAseguradoAfter = null;
	private Double CapitalContinenteBefore = null;
	private Double CapitalContienteAfter = null;

	// region webelements
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By edificioMaderaCmb = By.id("edifConstruccionMadera");
	private By noMadera = By.cssSelector("#edifConstruccionMadera > option[label ~= 'No']");
	private By deshabitacion = By.id("deshabilitacion");
	private By deshabitacion75 = By.cssSelector("#deshabilitacion > option:nth-of-type(2)");
	private By firstOptionEdifMad = By.cssSelector("#edifConstruccionMadera > option:first-child");

	private By cmbDeshabilitacion = By.cssSelector("#deshabilitacion > option");
	private By deshabilitacion = By.cssSelector("#deshabilitacion");

	private By btnContinuar = By.xpath(".//*[contains(text(),'Continuar')]");

	private By txtM2Viviendas = By.cssSelector("#m2Viviendas");
	private By txtM2Oficinas = By.cssSelector("#m2Oficinas");
	private By txtM2Garajes = By.cssSelector("#m2Garajes");
	private By txtM2ZonasAjardinadas = By.cssSelector("#m2ZonasAjardinadas");

	private By txtNoViviendas = By.name("numViviendas");
	private By txtNumeroPlantasAlto = By.name("numPlantasAlto");
	private By txtNumeroPlantasSotano = By.name("numPlantasSotano");
	private By txtNumeroEdificios = By.cssSelector("#numEdificios");
	private By txtNumeroLocales = By.name("numLocales");
	private By txtAnyoConstruccion = By.cssSelector("#anyoConstruccion");

	private By btnAnadirActividadComercial = By.xpath(".//*[text()='Añadir actividad comercial']");
	private By btnAnadir = By.xpath(".//*[text()='Añadir']");
	private By txtActividadDescripcion = By.xpath(".//*[@ng-model='actividad.descripcion']");
	private By txtActividadM2 = By.xpath(".//*[@ng-model='actividad.m2']");
	private By txtActividadPorcentaje = By.xpath(".//*[@ng-model='actividad.porcentaje']");
	private By txtM2Locales = By.xpath(".//*[@ng-model='dr.moduloDetallesRiesgo.m2locales']");

	private By btnGuardarActividadesComerciales = By.xpath(".//*[text()='Guardar' and @ng-disabled='formActividadesComerciales.$invalid']");

	private By txtCapitalContinenteTotalAsegurado = By.cssSelector("#capitalContinenteTotalAsegurado");
	private By txtCapitalContenido = By.cssSelector("#capitalContenido");
	private By txtCapitalContinente = By.cssSelector("#capitalContinente");

	private By btnCamposObligatiosModalWindowAceptar = By.xpath(".//*[text()='No se han rellenado los campos obligatorios.']/../../../..//button[text()='Aceptar']");

	private By chkGasolineraMenos50M = By.cssSelector("#edifGasolineraMenos50m");
	private By chkCalefaccionCentralAguaCalienteCentralizada = By.cssSelector("#edifCalefaccionCentral");
	private By chkDepositoCombustible = By.cssSelector("#edifDepositoCombustible");
	private By txtAnyoRehabAguas = By.cssSelector("#anyoRehabAguasCom");
	private By cmbNivelRehabAguas = By.cssSelector("#nivelRehabAguasCom");
	private By txtAnyoRehabIntegral = By.cssSelector("#anyoRehabIntegral");
	private By txtM2ContruidosTotales = By.cssSelector("#m2ConstruidosTotales");

	private By lblAvisoGarajes = By.xpath(".//*[text()='Los datos de superficies (m']");
	private List<By> lblAvisoGarajesList;

	private By btnAceptar = By.xpath(".//*[@id='modalErrores']//*[text()='Aceptar']");
	private By txtM2Trasteros = By.cssSelector("#m2Trasteros");
	private By txtNumPlantasBajoRasante = By.cssSelector("#numPlantasSotano");
	private By txtNumPlazasGaraje = By.cssSelector("#numPlazasGarajes");
	private By avisoNoTieneRefCatastral = By.xpath(".//*[text()='El edificio no tiene referencia catastral, intente ubicar el riesgo de nuevo o introduzca los datos de superficies y año de construcción.']/../../../..//button[text()='Aceptar']");

	private By btnConvertir = By.cssSelector("[ng-bind-html*='com_convertirProyecto']");	
	// endregion

	public DetallesRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public DetallesRiesgoPage executeActionsInPageDetallesRiesgoPage() throws Exception {
		debugBegin();

		CheckAvisoGarajes();
		GetCapitales();
		completarDatosRiesgo();
		ModificarDatosRiesgo();
		clickOnContinuar();

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage completarDatosEnDetallesRiesgo() throws Exception {
		debugBegin();

		// CheckAvisoGarajes();
		// GetCapitales();
		completarDatosRiesgo();
		clickOnContinuar();

		debugEnd();
		
		return this;
	}
	
	public void clickOnConvertirProyecto() throws Exception {
		debugBegin();
		System.out.println("TOKEN A");
		this.webDriver.scrollToBottom();
		System.out.println("TOKEN B");
		this.webDriver.waitWithDriver(16000);
		System.out.println("TOKEN C");
		this.webDriver.clickInFrame(this.btnConvertir, this.cuerpoFrame);
		//this.webDriver.waitForElementToBeClickableAndClick(this.btnConvertir);
		System.out.println("TOKEN D");
		this.webDriver.waitWithDriver(8000);
		System.out.println("TOKEN E");
		debugEnd();
	}
		

	public DetallesRiesgoPage completarDatosEnDetallesRiesgoMinimos() {
		debugBegin();

		// CheckAvisoGarajes();
		// GetCapitales();
		completarDatosRiesgoMinimos();
		clickOnContinuar();

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage modificarDatosEnDetallesRiesgo() throws ParseException {
		debugBegin();

		CheckAvisoGarajes();
		GetCapitales();
		ModificarDatosRiesgo();
		clickOnContinuar();

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue() throws Exception {
		debugBegin();

		CheckAvisoGarajes();
		GetCapitales();
		completarDatosRiesgo();
		ModificarDatosRiesgo();

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage completarDatosEnDetallesRiesgoSinContinuar() throws Exception {
		debugBegin();

		CheckAvisoGarajes();
		GetCapitales();
		completarDatosRiesgo();

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage modificarDatosEnDetallesRiesgoSinContinuar() throws ParseException {
		debugBegin();

		CheckAvisoGarajes();
		GetCapitales();
		ModificarDatosRiesgo();

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

		webDriver.clickInFrame(edificioMaderaCmb, cuerpoFrame);
		webDriver.clickInFrame(noMadera, cuerpoFrame);
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

		webDriver.clickInFrame(deshabitacion, cuerpoFrame);
		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(deshabitacion75, cuerpoFrame);
		webDriver.waitWithDriver(4000);
		// value = webDriver.getText(txtAnyoConstruccion);

		/* AÑO DE CONSTRUCCION Y REHABILITACIONES */
		webDriver.scrollToElementInFrame(txtAnyoConstruccion, cuerpoFrame);
		webDriver.waitWithDriver(1000);
		webDriver.clearTextInFrame(txtAnyoConstruccion, cuerpoFrame);
		webDriver.appendTextInFrame(txtAnyoConstruccion, cuerpoFrame, "2000");
		webDriver.waitWithDriver(1000);

		/* SUPERFICIES */
		value = webDriver.getTextInFrame(this.txtAnyoConstruccion, cuerpoFrame);

		webDriver.waitWithDriver(3000);
		clickOnContinuar();

		debugEnd();
		
		return value;
	}

	public String getCapitalContinente() {
		return webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame);
	}

	public String getCapitalContenido() {		
		return webDriver.getTextInFrame(txtCapitalContenido, cuerpoFrame);
	}

	public String getCapitalContinenteTotalAsegurado() {
		return webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame);
	}

	public DetallesRiesgoPage completarDatosRiesgo() throws Exception {
		debugBegin();

		// webDriver.clickElementFromDropDownByIndexInFrame(edifConstruccionMadera, cuerpoFrame, 1);
		webDriver.clickInFrame(firstOptionEdifMad, cuerpoFrame);

		// webDriver.clickElementFromDropDownByIndexInFrame(edifConstruccionMadera, cuerpoFrame, 1);

		webDriver.clickInFrame(cmbDeshabilitacion, cuerpoFrame);

		// webDriver.switchToFrame(cuerpoFrame);

		// if (testDataM.getCapitalContinente() != null)
		if(getTestVar(Constants.CAPITAL_CONTINENTE) != null) {

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
			webDriver.appendTextInFrame(txtCapitalContinente, cuerpoFrame, getTestVar(Constants.CAPITAL_CONTINENTE));
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

		String edificioMadera = webDriver.getTextInFrame(edificioMaderaCmb, cuerpoFrame);

		if(!edificioMadera.equals(getTestVar(Constants.CONSTRUIDO_MADERA))
			&& !getTestVar(Constants.CONSTRUIDO_MADERA).isEmpty()) {
			webDriver.clickElementFromDropDownByTextInFrame(edificioMaderaCmb, cuerpoFrame, getTestVar(Constants.CONSTRUIDO_MADERA));
		} else if(getTestVar(Constants.CONSTRUIDO_MADERA).isEmpty() && !edificioMadera.isEmpty()) {
			throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página");
		}
		webDriver.waitWithDriver(2000);

		String deshabitacionDatos = getTestVar(Constants.DESHABITACION) == null ? "" : getTestVar(Constants.DESHABITACION);
		String deshabilitacionWeb = webDriver.getTextInFrame(cmbDeshabilitacion, cuerpoFrame);

		if(!deshabilitacionWeb.equals(deshabitacionDatos) && !deshabitacionDatos.equals("")) {
			webDriver.clickElementFromDropDownByTextInFrame(cmbDeshabilitacion, cuerpoFrame, getTestVar(Constants.DESHABITACION));
		} else if(deshabitacionDatos.isEmpty() && !deshabilitacionWeb.isEmpty()) {
			throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página");
		}

		String m2ContruidosTotales = webDriver.getTextInFrame(txtM2ContruidosTotales, cuerpoFrame);
		if(m2ContruidosTotales.equals("") && getTestVar(Constants.M2_CONSTRUIDOS) != null) {
			webDriver.appendTextInFrame(txtM2ContruidosTotales, cuerpoFrame, getTestVar(Constants.M2_CONSTRUIDOS));
		}

		String anyoConstruccion = webDriver.getTextInFrame(txtAnyoConstruccion, cuerpoFrame);

		if(getTestVar(Constants.ANYO_CONSTRUIDO) != null && getTestVar(Constants.ANYO_CONSTRUIDO).equals(Constants.MayorDe50)) {
			int year = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(LocalDate.now()));

			webDriver.appendTextInFrame(txtAnyoConstruccion, cuerpoFrame, String.valueOf(year - 51));
		} else if(getTestVar(Constants.ANYO_CONSTRUIDO) != null && !anyoConstruccion.equals(getTestVar(Constants.ANYO_CONSTRUIDO))) {
			int year = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(LocalDate.now()));
			
			webDriver.appendTextInFrame(txtAnyoConstruccion, cuerpoFrame, String.valueOf(year - 49));
		}

		String anyoRehabAguas = getTestVar(Constants.ANYO_REHAB_AGUAS) == null ? ""
			: getTestVar(Constants.ANYO_REHAB_AGUAS);
		
		if(anyoRehabAguas.equals(String.valueOf(webDriver.getTextInFrame(txtAnyoConstruccion, cuerpoFrame)))
			&& getTestVar(Constants.NIVEL_REHAB_AGUAS) != null) {
			int year = Integer.parseInt(webDriver.getTextInFrame(txtAnyoConstruccion, cuerpoFrame));
			webDriver.appendTextInFrame(txtAnyoRehabAguas, cuerpoFrame, String.valueOf(year + 1));
			webDriver
				.clickElementFromDropDownByTextInFrame(cmbNivelRehabAguas, cuerpoFrame, getTestVar(anyoRehabAguas));
		}

		String anyoRehabIntegral = getTestVar(Constants.ANYO_REHAB_INTEGRAL);
		
		if(anyoRehabIntegral != null) {
			webDriver.appendTextInFrame(txtAnyoRehabIntegral, cuerpoFrame, anyoRehabIntegral);
		}

		String m2Viviendas = webDriver.getTextInFrame(txtM2Viviendas, cuerpoFrame);
		
		if(getTestVar(Constants.M2_VIVIENDAS) != null && !m2Viviendas.equals(getTestVar(Constants.M2_VIVIENDAS))) {
			GetCapitales();

			GetValuesBefore();

			webDriver.appendTextInFrame(txtM2Viviendas, cuerpoFrame, getTestVar(Constants.M2_VIVIENDAS));
			webDriver.tabulateElementInFrame(txtM2Viviendas, cuerpoFrame);

			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Garajes = webDriver.getTextInFrame(txtM2Garajes, cuerpoFrame);
		
		if(!m2Garajes.equals(getTestVar(Constants.M2_GARAJES)) && getTestVar(Constants.M2_GARAJES) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2Garajes, cuerpoFrame, getTestVar(Constants.M2_GARAJES));
			webDriver.tabulateElementInFrame(txtM2Garajes, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 garajes");
		}

		String m2Oficinas = webDriver.getTextInFrame(txtM2Oficinas, cuerpoFrame);
		
		if(!m2Oficinas.equals(getTestVar(Constants.M2_OFICINAS)) && getTestVar(Constants.M2_OFICINAS) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2Oficinas, cuerpoFrame, getTestVar(Constants.M2_OFICINAS));
			webDriver.tabulateElementInFrame(txtM2Oficinas, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = webDriver.getTextInFrame(txtM2ZonasAjardinadas, cuerpoFrame);
		
		if(!m2ZonasAjardinadas.equals(getTestVar(Constants.M2_ZONAS_AJARDINADAS)) && getTestVar(Constants.M2_ZONAS_AJARDINADAS) != null) {
			webDriver.appendTextInFrame(txtM2ZonasAjardinadas, cuerpoFrame, getTestVar(Constants.M2_ZONAS_AJARDINADAS));
			webDriver.tabulateElementInFrame(txtM2ZonasAjardinadas, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		String numeroViviendas = webDriver.getTextInFrame(txtNoViviendas, cuerpoFrame);
		if(getTestVar(Constants.NUM_VIVIENDAS) != null && !numeroViviendas.equals(getTestVar(Constants.NUM_VIVIENDAS))) {
			webDriver.appendTextInFrame(txtNoViviendas, cuerpoFrame, getTestVar(Constants.NUM_VIVIENDAS));
		}

		String numeroPlantasALto = webDriver.getTextInFrame(txtNumeroPlantasAlto, cuerpoFrame);
		if(!numeroPlantasALto.equals(getTestVar(Constants.NUM_PLANTAS_ALTO)) && getTestVar(Constants.NUM_PLANTAS_ALTO) != null) {
			webDriver.appendTextInFrame(txtNumeroPlantasAlto, cuerpoFrame, getTestVar(Constants.NUM_PLANTAS_ALTO));
		}

		String numeroPlantasSotano = webDriver.getTextInFrame(txtNumeroPlantasSotano, cuerpoFrame);
		if(!numeroPlantasSotano.equals(getTestVar(Constants.NUM_PLANTAS_SOTANO)) && getTestVar(Constants.NUM_PLANTAS_SOTANO) != null) {
			webDriver.appendTextInFrame(txtNumeroPlantasSotano, cuerpoFrame, getTestVar(Constants.NUM_PLANTAS_SOTANO));
		}

		String numeroEdificios = webDriver.getTextInFrame(txtNumeroEdificios, cuerpoFrame);
		if(!numeroEdificios.equals(getTestVar(Constants.NUM_EDIFICIOS)) && getTestVar(Constants.NUM_EDIFICIOS) != null) {
			webDriver.appendTextInFrame(txtNumeroEdificios, cuerpoFrame, getTestVar(Constants.NUM_EDIFICIOS));
		}

		if(Boolean.parseBoolean(getTestVar(Constants.GASOLINERA_MENOS_50M))) {
			webDriver.clickInFrame(chkGasolineraMenos50M, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.CALEFACCION_CENTRAL)) 
			&& !webDriver.isSelected(chkCalefaccionCentralAguaCalienteCentralizada)) {
			webDriver.clickInFrame(chkCalefaccionCentralAguaCalienteCentralizada, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.DEPOSITO_COMBUSTIBLE))) {
			webDriver.clickInFrame(chkDepositoCombustible, cuerpoFrame);
		}

		webDriver.clickInFrame(txtCapitalContinente, cuerpoFrame);
		// webDriver.exitFrame();
		// ModificarDatosActividadComercial();

		debugEnd();
		
		return this;
	}

	// This function modifies the values of the fields located in the page. All the values are
	// modified if they are different than the ones present
	// in the object TestCasse Data inside the values whose variables start with Modified.
	public DetallesRiesgoPage ModificarDatosRiesgo() throws ParseException {
		debugBegin();

		// Modify Año rehabilitación de aguas comunitarias
		String anyoRehabAguas = webDriver.getTextInFrame(txtAnyoRehabAguas, cuerpoFrame);
		String anyoConstruccion = webDriver.getTextInFrame(txtAnyoConstruccion, cuerpoFrame);

		if(getTestVar(Constants.NIVEL_REHAB_AGUAS) != null) {
			if(anyoRehabAguas.isEmpty()) {
				webDriver.appendTextInFrame(txtAnyoRehabAguas, cuerpoFrame, String.valueOf(Integer.parseInt(anyoConstruccion) + 1));
				webDriver.clickElementFromDropDownByTextInFrame(cmbNivelRehabAguas, cuerpoFrame, getTestVar(Constants.NIVEL_REHAB_AGUAS));
				setTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES, webDriver.getTextInFrame(txtAnyoRehabAguas, cuerpoFrame));
			} else {
				// If Año rehabilitación de aguas comunitarias is already present, 
				// then input Año rehabilitación de aguas comunitarias
				// + 1. Required if we want to execute this test in the same week, before database reset.
				webDriver.appendText(txtAnyoRehabAguas, String.valueOf(Integer.parseInt(anyoRehabAguas) + 1));
				webDriver.clickElementFromDropDownByTextInFrame(cmbNivelRehabAguas, cuerpoFrame, getTestVar(Constants.NIVEL_REHAB_AGUAS));
				setTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES, webDriver.getTextInFrame(txtAnyoRehabAguas, cuerpoFrame));
			}
		}

		String numeroEdificios = webDriver.getTextInFrame(txtNumeroEdificios, cuerpoFrame);
		if(!numeroEdificios.equals(getTestVar(Constants.CAMBIO_NUM_EDIFICIOS)) && getTestVar(Constants.CAMBIO_NUM_EDIFICIOS) != null) {
			webDriver.appendTextInFrame(txtNumeroEdificios, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_EDIFICIOS));
		}

		String numeroViviendas = webDriver.getTextInFrame(txtNoViviendas, cuerpoFrame);
		if(!numeroViviendas.equals(getTestVar(Constants.CAMBIO_NUM_VIVIENDAS)) && getTestVar(Constants.CAMBIO_NUM_VIVIENDAS) != null) {
			webDriver.appendTextInFrame(txtNoViviendas, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_VIVIENDAS));
		}

		String numeroLocales = webDriver.getTextInFrame(txtNumeroLocales, cuerpoFrame);
		if(!numeroLocales.equals(getTestVar(Constants.CAMBIO_NUM_LOCALES)) && getTestVar(Constants.CAMBIO_NUM_LOCALES) != null) {
			webDriver.appendTextInFrame(txtNumeroLocales, cuerpoFrame, getTestVar(Constants.CAMBIO_NUM_LOCALES));
		}

		String m2ContruidosTotales = webDriver.getTextInFrame(txtM2ContruidosTotales, cuerpoFrame);
		if(m2ContruidosTotales.equals(-1)) {
			webDriver.appendTextInFrame(txtM2ContruidosTotales, cuerpoFrame, getTestVar(Constants.M2_CONSTRUIDOS));
		}

		String m2Viviendas = webDriver.getTextInFrame(txtM2Viviendas, cuerpoFrame);
		if(!m2Viviendas.equals(getTestVar(Constants.CAMBIO_M2_VIVIENDAS)) && getTestVar(Constants.CAMBIO_M2_VIVIENDAS) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2Viviendas, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_VIVIENDAS));
			webDriver.tabulateElementInFrame(txtM2Viviendas, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 viviendas");
			setTestVar(Constants.M2_CONSTRUIDOS, webDriver.getTextInFrame(txtM2ContruidosTotales, cuerpoFrame));
		}

		String m2Garajes = webDriver.getTextInFrame(txtM2Viviendas, cuerpoFrame);
		if(!m2Garajes.equals(getTestVar(Constants.CAMBIO_M2_GARAJES)) && getTestVar(Constants.CAMBIO_M2_GARAJES) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2Garajes, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_GARAJES));
			webDriver.tabulateElementInFrame(txtM2Garajes, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Oficinas = webDriver.getTextInFrame(txtM2Oficinas, cuerpoFrame);
		if(!m2Oficinas.equals(getTestVar(Constants.CAMBIO_M2_OFICINAS)) && getTestVar(Constants.CAMBIO_M2_OFICINAS) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2Oficinas, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_OFICINAS));
			webDriver.tabulateElementInFrame(txtM2Oficinas, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = webDriver.getTextInFrame(txtM2ZonasAjardinadas, cuerpoFrame);
		if(!m2ZonasAjardinadas.equals(getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS)) && getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS) != null) {
			GetValuesBefore();
			webDriver.appendTextInFrame(txtM2ZonasAjardinadas, cuerpoFrame, getTestVar(Constants.CAMBIO_M2_ZONAS_AJARDINADAS));
			webDriver.tabulateElementInFrame(txtM2ZonasAjardinadas, cuerpoFrame);
			GetValuesAfter();
			CompareValues(Constants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		// ModificarDatosActividadComercial();
		debugEnd();
		
		return this;
	}

	// private DetallesRiesgoPage ModificarDatosActividadComercial()
	// {
	// logger.debug("BEGIN - ModificarDatosActividadComercial");
	//
	// webDriver.SwitchToFrame(cuerpoFrame);
	// String m2ActividadComercial = webDriver.getText(txtM2Locales);
	// if (Integer.valueOf(m2ActividadComercial.replace(".", "")) > 0)
	// {
	// webDriver.ClickOnWebElement(btnAnadirActividadComercial);
	// webDriver.ClickOnWebElement(btnAnadir);
	// webDriver.SendValueToWebElement(txtActividadDescripcion,
	// MutuaPropietariosConstants.ActividadComercialDescripcion);
	// webDriver.SendValueToWebElement(txtActividadPorcentaje,
	// MutuaPropietariosConstants.ActividadComercialOPorcentaje);
	// webDriver.SendValueToWebElement(txtActividadM2,
	// m2ActividadComercial);
	// webDriver.ClickOnWebElement(btnGuardarActividadesComerciales);
	// }
	// webDriver.exitFrame();
	// logger.debug("END - ModificarDatosActividadComercial");
	// }

	private DetallesRiesgoPage GetCapitales() throws ParseException {
		debugBegin();

		webDriver.waitWithDriver(2000);
		
		if(!webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame).isEmpty()) {
			webDriver.scrollToBottom();
			CapitalTotalAsegurado = nf.parse(webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame)).doubleValue();
			CapitalContenido = nf.parse(webDriver.getTextInFrame(txtCapitalContenido, cuerpoFrame)).doubleValue();
			CapitalContinente = nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame)).doubleValue();
		}

		debugEnd();
		
		return this;
	}

	// private boolean IsCapitalesVaried() throws ParseException
	// {
	// logger.debug("BEGIN - IsCapitalesVaried");
	// Double CapitalTotalAseguradoSavedValue = CapitalTotalAsegurado;
	// Double CapitalContenidoSavedValue = CapitalContenido;
	// Double CapitalContinenteSavedValue = CapitalContinente;
	//
	// Double CapitalTotalAseguradoTemp =
	// nf.parse(webDriver.getText(txtCapitalContinenteTotalAsegurado)).doubleValue();
	// Double CapitalContenidoTemp =
	// nf.parse(webDriver.getText(txtCapitalContenido)).doubleValue();
	// Double CapitalContinenteTemp =
	// nf.parse(webDriver.getText(txtCapitalContinente)).doubleValue();
	//
	// logger.debug("END - IsCapitalesVaried");
	//
	// if (CapitalTotalAseguradoSavedValue == CapitalTotalAseguradoTemp &&
	// CapitalContenidoSavedValue
	// == CapitalContenidoTemp
	// && CapitalContinenteSavedValue == CapitalContinenteTemp)
	// {
	// return true;
	// }
	// return false;
	// }

	private DetallesRiesgoPage CheckForInfraseguroOrSupraSeguro() throws ParseException {
		debugBegin();

		// Double CapitalTotalAsegurado = nf
		// .parse(webDriver.getText(txtCapitalContinenteTotalAsegurado))
		// .doubleValue();
		// Double CapitalContenido =
		// nf.parse(webDriver.getText(txtCapitalContenido))
		// .doubleValue();
		Double capitalContiente = nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame)).doubleValue();

		if(capitalContiente > CapitalContinente) {
			setTestVar(Constants.INFRA_SEGURO, "true");
		}

		if(capitalContiente < CapitalContinente) {
			setTestVar(Constants.SUPRA_SEGURO, "true");
		}

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage clickOnContinuar() {
		debugBegin();
		// CheckForInfraseguroOrSupraSeguro();
		// cuerpoFrame.click();

		webDriver.scrollToBottom();

		webDriver.waitWithDriver(8000);

		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

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

	public DetallesRiesgoPage GetValuesBefore() throws ParseException {
		if(!webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame).isEmpty()) {
			CapitalContenidoBefore = nf.parse(webDriver.getTextInFrame(txtCapitalContenido, cuerpoFrame)).doubleValue();
			CapitalContinenteBefore = nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame)).doubleValue();
			CapitalTotalAseguradoBefore = nf.parse(webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame)).doubleValue();
		}
		
		return this;
	}

	public DetallesRiesgoPage GetValuesAfter() throws ParseException {
		CapitalContenidoAfter = nf.parse(webDriver.getTextInFrame(txtCapitalContenido, cuerpoFrame)).doubleValue();
		CapitalContienteAfter = nf.parse(webDriver.getTextInFrame(txtCapitalContinente, cuerpoFrame)).doubleValue();
		CapitalTotalAseguradoAfter = nf.parse(webDriver.getTextInFrame(txtCapitalContinenteTotalAsegurado, cuerpoFrame)).doubleValue();
		
		return this;
	}

	public DetallesRiesgoPage CompareValues(String comparisonType, String modification) {
		switch(comparisonType) {
			case Constants.NotEqual:
				if(CapitalContenidoBefore == CapitalContenidoAfter || CapitalContinenteBefore == CapitalContienteAfter
					|| CapitalTotalAseguradoBefore == CapitalTotalAseguradoAfter) {
					setTestVar(Constants.ERROR_CAMBIO_CANTIDADES, "true");
					setTestVar(Constants.MENSAJE_ERROR_CAMBIO_CANTIDADES, "El valor de las cantiadaes no ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);
				}

				break;
			case Constants.Equal:
				if(CapitalContenidoBefore != CapitalContenidoAfter || CapitalContinenteBefore != CapitalContienteAfter
					|| CapitalTotalAseguradoBefore != CapitalTotalAseguradoAfter) {
					setTestVar(Constants.ERROR_CAMBIO_CANTIDADES, "true");
					setTestVar(Constants.MENSAJE_ERROR_CAMBIO_CANTIDADES, "El valor de las cantiadaes ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);
				}

				break;
			default:
		}
		
		return this;
	}

	public DetallesRiesgoPage CheckAvisoGarajes() {
		debugBegin();
		
		if(Boolean.parseBoolean(getTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES))) {
			if(webDriver.getElements(lblAvisoGarajes).size() != 1) {
				setTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES, "true");
			}
			
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		}
		
		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage CheckAvisoNoTieneRefCatastral() {
		debugBegin();
		
		if (webDriver.isPresentInFrame(avisoNoTieneRefCatastral, cuerpoFrame)){
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		}

		debugEnd();
		
		return this;
	}

	public DetallesRiesgoPage CheckAvisoGarajesWithException() {
		debugBegin();
		
		if(Boolean.parseBoolean(getTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES)) 
			&& Boolean.parseBoolean(getTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES))) {
			Assert.assertTrue(!Boolean.parseBoolean(getTestVar(Constants.SIN_MENSAJE_AVISO_GARAJES)), 
				Constants.AvisoGarajesErrorMessage);
		}

		debugEnd();
		
		return this;
	}

	public boolean IsFieldEnabled(String fieldName) {
		boolean result = false;
		
		webDriver.switchToFrame(cuerpoFrame);
		
		switch(fieldName) {
			case "M2 Trasteros":
				if(webDriver.isEnabled(txtM2Trasteros)) {
					result = true;
				}
				
				break;
			case "No plantas bajo rasante":
				if(webDriver.isEnabled(txtNumeroPlantasSotano)) {
					result = true;
				}
				
				break;
			case "No plantas en alto":
				if(webDriver.isEnabled(txtNumeroPlantasAlto)) {
					result = true;
				}
				
				break;
			case "M2 Garajes":
				// isDisplayed
				if(webDriver.isPresent(txtM2Garajes)) {
					result = true;
				}
				
				break;
			case "No Plazas de garaje":
				// isDisplayed
				if(webDriver.isPresent(txtNumPlazasGaraje)) {
					result = true;
				}
				
				break;
			default:
		}
		
		webDriver.exitFrame();
		
		return result;
	}

	public DetallesRiesgoPage enterAnyoConstruccionMoreThan50() {
		int year = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(LocalDate.now()));
		
		webDriver.appendTextInFrame(txtAnyoConstruccion, cuerpoFrame, String.valueOf(year - 51));
		
		return this;
	}
	// endregion
}
