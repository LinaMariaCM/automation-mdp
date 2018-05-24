package com.project.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DetallesRiesgoPage extends PageObject {

	Locale locale = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(this.locale);
	Double CapitalTotalAsegurado = null;
	Double CapitalContenido = null;
	Double CapitalContinente = null;

	Double CapitalContenidoBefore = null;
	Double CapitalContenidoAfter = null;
	Double CapitalTotalAseguradoBefore = null;
	Double CapitalTotalAseguradoAfter = null;
	Double CapitalContinenteBefore = null;
	Double CapitalContienteAfter = null;

	// region webelements
	// @FindBy(id = "mainFrame")
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	// @FindBy(id = "edifConstruccionMadera")
	private By cmbEdificioMadera = By.cssSelector("#edifConstruccionMadera");
	private By firstOptionEdifMad = By.cssSelector("#edifConstruccionMadera option");
	private By edifConstruccionMadera = By.id("edifConstruccionMadera");

	// @FindBy(id = "deshabilitacion")
	private By cmbDeshabilitacion = By.cssSelector("#deshabilitacion option");
	private By deshabilitacion = By.id("deshabilitacion");

	// @FindBy(xpath = ".//*[contains(text(),'Continuar')]")
	private By btnContinuar = By.xpath(".//*[contains(text(),'Continuar')]");

	// @FindBy(name = "m2Viviendas")
	private By txtM2Viviendas = By.cssSelector("#m2Viviendas");

	// @FindBy(id = "m2Oficinas")
	private By txtM2Oficinas = By.cssSelector("#m2Oficinas");

	// @FindBy(id = "m2Garajes")
	private By txtM2Garajes = By.cssSelector("#m2Garajes");

	// @FindBy(id = "m2ZonasAjardinadas")
	private By txtM2ZonasAjardinadas = By.cssSelector("#m2ZonasAjardinadas");

	// @FindBy(name = "numViviendas")
	private By txtNoViviendas = By.name("numViviendas");

	// @FindBy(name = "numPlantasAlto")
	private By txtNumeroPlantasAlto = By.name("numPlantasAlto");

	// @FindBy(name = "numPlantasSotano")
	private By txtNumeroPlantasSotano = By.name("numPlantasSotano");

	// @FindBy(id = "numEdificios")
	private By txtNumeroEdificios = By.cssSelector("#numEdificios");

	// @FindBy(name = "numLocales")
	private By txtNumeroLocales = By.name("numLocales");

	// @FindBy(id = "anyoConstruccion")
	private By txtAnyoConstruccion = By.cssSelector("#anyoConstruccion");

	// @FindBy(xpath = ".//*[text()='Añadir actividad comercial']")
	private By btnAnadirActividadComercial = By.xpath(".//*[text()='Añadir actividad comercial']");

	// @FindBy(xpath = ".//*[text()='Añadir']")
	private By btnAnadir = By.xpath(".//*[text()='Añadir']");

	// @FindBy(xpath = ".//*[@ng-model='actividad.descripcion']")
	private By txtActividadDescripcion = By.xpath(".//*[@ng-model='actividad.descripcion']");

	// @FindBy(xpath = ".//*[@ng-model='actividad.m2']")
	private By txtActividadM2 = By.xpath(".//*[@ng-model='actividad.m2']");

	// @FindBy(xpath = ".//*[@ng-model='actividad.porcentaje']")
	private By txtActividadPorcentaje = By.xpath(".//*[@ng-model='actividad.porcentaje']");

	// @FindBy(xpath = ".//*[@ng-model='dr.moduloDetallesRiesgo.m2locales']")
	private By txtM2Locales = By.xpath(".//*[@ng-model='dr.moduloDetallesRiesgo.m2locales']");

	// @FindBy(xpath = ".//*[text()='Guardar' and
	// @ng-disabled='formActividadesComerciales.$invalid']")
	private By btnGuardarActividadesComerciales = By.xpath(".//*[text()='Guardar' and @ng-disabled='formActividadesComerciales.$invalid']");

	// @FindBy(id = "capitalContinenteTotalAsegurado")
	private By txtCapitalContinenteTotalAsegurado = By.cssSelector("#capitalContinenteTotalAsegurado");

	// @FindBy(id = "capitalContenido")
	private By txtCapitalContenido = By.cssSelector("#capitalContenido");

	// @FindBy(id = "capitalContinente")
	private By txtCapitalContinente = By.cssSelector("#capitalContinente");

	// @FindBy(xpath = ".//*[text()='No se han rellenado los campos
	// obligatorios.']/../../../..//button[text()='Aceptar']")
	private By btnCamposObligatiosModalWindowAceptar = By.xpath(".//*[text()='No se han rellenado los campos obligatorios.']/../../../..//button[text()='Aceptar']");

	// @FindBy(id = "edifGasolineraMenos50m")
	private By chkGasolineraMenos50M = By.cssSelector("#edifGasolineraMenos50m");

	// @FindBy(id = "edifCalefaccionCentral")
	private By chkCalefaccionCentralAguaCalienteCentralizada = By.cssSelector("#edifCalefaccionCentral");

	// @FindBy(id = "edifDepositoCombustible")
	private By chkDepositoCombustible = By.cssSelector("#edifDepositoCombustible");

	// @FindBy(id = "anyoRehabAguasCom")
	private By txtAnyoRehabilitacionAguasComunitarias = By.cssSelector("#anyoRehabAguasCom");

	// @FindBy(id = "nivelRehabAguasCom")
	private By cmbNivelRehabilitacionAguas = By.cssSelector("#nivelRehabAguasCom");

	// @FindBy(id = "anyoRehabIntegral")
	private By txtAnyoRehabilitacionIntegral = By.cssSelector("#anyoRehabIntegral");

	// @FindBy(id = "m2ConstruidosTotales")
	private By txtM2ContruidosTotales = By.cssSelector("#m2ConstruidosTotales");

	// @FindBy(xpath = ".//*[text()='Los datos de superficies (m']")
	private List<By> lblAvisoGarajes;

	// @FindBy(xpath = ".//*[@id='modalErrores']//*[text()='Aceptar']")
	private By btnAceptar = By.xpath(".//*[@id='modalErrores']//*[text()='Aceptar']");

	// @FindBy(id = "m2Trasteros")
	private By txtM2Trasteros = By.cssSelector("#m2Trasteros");

	// @FindBy(id = "numPlantasSotano")
	private By txtNumPlantasBajoRasante = By.cssSelector("#numPlantasSotano");

	// @FindBy(id = "numPlazasGarajes")
	private By txtNumPlazasGaraje = By.cssSelector("#numPlazasGarajes");

	// endregion

	/*
	 * public DetallesRiesgoPage(BrowserContext browserContext) throws Exception
	 * { this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); //
	 * this.ExecuteActionsInPageDetallesRiesgoPage(); }
	 */
	public DetallesRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void executeActionsInPageDetallesRiesgoPage() throws Exception {
		debugBegin();
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
		this.clickOnContinuar();
		debugEnd();
	}

	public void completarDatosEnDetallesRiesgo() throws Exception {
		debugBegin();
		// this.CheckAvisoGarajes();
		// this.GetCapitales();
		this.completarDatosRiesgo();
		this.clickOnContinuar();
		debugEnd();
	}

	public void modificarDatosEnDetallesRiesgo() throws Exception {
		debugBegin();
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		this.clickOnContinuar();
		debugEnd();
	}

	public void ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue() throws Exception {
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
	}

	public void completarDatosEnDetallesRiesgoSinContinuar() throws Exception {
		debugBegin();
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		debugEnd();
	}

	public void modificarDatosEnDetallesRiesgoSinContinuar() throws Exception {
		debugBegin();
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		debugEnd();
	}

	// This function modifies the values of the fields located in the page. All
	// the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data.
	public String completarDatosRiesgoMinimos() {
		debugBegin();
		
		String value = "";
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// String edificioMadera =
		// this.webDriver.getText(this.firstOptionEdifMad);
		// if
		// (!edificioMadera.equals(this.testDataM.getTestVar(testId,"edificioMadera"))
		// &&
		// !this.testDataM.getTestVar(testId,"edificioMadera").equals(""))

		//this.webDriver.waitWithDriver(5000);

		// if(!edificioMadera.equals(this.testDataM.getTestVar(testId,
		// "edificioMadera")) && !this.testDataM.getTestVar(testId,
		// "edificioMadera").equals("")) {
		// this.webDriver.selectValueInDropDown(this.cmbEdificioMadera,
		// this.testDataM.getTestVar(testId, "edificioMadera"));
		// this.webDriver.clickElementFromDropDownByText(this.cmbEdificioMadera,
		// this.testDataM.getTestVar(testId, "edificioMadera"));
		// } else if(this.testDataM.getTestVar(testId, "edificioMadera").equals("")
		// && !edificioMadera.equals("")) { throw new Exception("El valor del
		// campo porcentaje edificio madera no es blanco al entrar en la
		// página"); }

		// this.webDriver.clickElementFromDropDownByText(this.cmbEdificioMadera,
		// this.testDataM.getTestVar(testId, "edificioMadera"));
		this.webDriver.clickElementFromDropDownByText(this.edifConstruccionMadera, "No");

		// String deshabilitacion =
		// this.webDriver.getText(this.edifConstruccionMadera);
		// if(!deshabilitacion.equals(this.testDataM.getTestVar(testId,
		// "deshabilitacion")) && !this.testDataM.getTestVar(testId,
		// "deshabilitacion").equals("")) {
		// this.webDriver.clickElementFromDropDownByText(this.cmbDeshabilitacion,
		// this.testDataM.getTestVar(testId, "deshabilitacion"));
		// } else if(this.testDataM.getTestVar(testId,
		// "deshabilitacion").equals("")
		// && !deshabilitacion.equals("")) { throw new Exception("El valor del
		// campo deshabilitación no es blanco al entrar en la página"); }

		this.webDriver.clickElementFromDropDownByText(this.deshabilitacion, ProjectConstants.DeshabitacionInferior);

		// value = this.webDriver.getText(this.txtAnyoConstruccion);

		/* AÑO DE CONSTRUCCION Y REHABILITACIONES */
		this.webDriver.scrollToElement(this.txtAnyoConstruccion);
		this.webDriver.waitWithDriver(1000);
		this.webDriver.clearText(this.txtAnyoConstruccion);
		this.webDriver.appendText(this.txtAnyoConstruccion, "2000");
		this.webDriver.waitWithDriver(1000);

		/* SUPERFICIES */

		// this.webDriver.appendText(by, text);
		// this.webDriver.appendText(by, text);
		// this.webDriver.appendText(by, text);
		// this.webDriver.appendText(by, text);

		this.webDriver.exitFrame();
		this.webDriver.waitWithDriver(1000);
		this.clickOnContinuar();

		debugEnd();
		return value;
	}

	public String getCapitalContinente() {
		debugInfo("GET - getCapitalContinente");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame);
	}

	public String getCapitalContenido() throws Exception {
		debugInfo("GET - getCapitalContenido");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContenido, this.cuerpoFrame);
	}

	public String getCapitalContinenteTotalAsegurado() throws Exception {
		debugInfo("GET - getCapitalContinenteTotalAsegurado");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContinenteTotalAsegurado, this.cuerpoFrame);
	}

	public void completarDatosRiesgo() throws Exception {
		debugBegin();
		// this.webDriver.switchToFrame(this.cuerpoFrame);

		// if (this.testDataM.getCapitalContinente() != null)
		if(this.testDataM.getTestVar(testId, "capitalContinente") != null) {
			// if (this.testDataM.isCapitalContinenteVariacion())
			if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "capitalContinenteVariacion"))) {
				// Double capitalContinenteModified =
				// this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame))
				// .doubleValue() +
				// this.testDataM.getCapitalContinente().doubleValue();

				Double capitalContinenteModified = this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame))
					.doubleValue() + Double.parseDouble(this.testDataM.getTestVar(testId, "capitalContinente"));

				// this.webDriver.appendTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame, String.valueOf(capitalContinenteModified));
				this.webDriver.appendTextInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(capitalContinenteModified));
				this.webDriver.tabulateElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				// this.testDataM.setCapitalContinente(capitalContinenteModified);
				this.testDataM.setConfigVar("CapitalContinente", "capitalContinenteModified");

			} else {
				// this.webDriver.appendTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame,
				// String.valueOf(this.testDataM.getConfigVar("CapitalContinente")));
				this.webDriver.appendTextInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(this.testDataM.getConfigVar("CapitalContinente")));
				this.webDriver.tabulateElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				// this.testDataM.setCapitalContinente(this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame)));
				this.testDataM.setConfigVar("CapitalContinente", this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame));
			}
		}

		// if (this.testDataM.getCapitalContenido() != null)
		if(this.testDataM.getTestVar(testId, "CapitalContenido") != null) {
			// Double capitalContenidoModified =
			// this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContenido,
			// this.cuerpoFrame)).doubleValue()
			// + this.testDataM.getCapitalContenido().doubleValue();

			Double capitalContenidoModified = Double.parseDouble(this.webDriver.getTextInFrame(this.txtCapitalContenido, this.cuerpoFrame))
				+ Double.parseDouble(this.testDataM.getTestVar(testId, "CapitalContenido"));
			this.webDriver.appendTextInFrame(this.txtCapitalContenido, this.cuerpoFrame, this.nf.format(capitalContenidoModified).toString());
			this.webDriver.tabulateElementInFrame(this.txtCapitalContenido, this.cuerpoFrame);
			// this.testDataM.setCapitalContenido(capitalContenidoModified);
			this.testDataM.setTestVar(testId, "CapitalContenido", "capitalContenidoModified");
		}

		// String edificioMadera =
		// this.webDriver.getTextInFrame(this.cmbEdificioMadera,
		// this.cuerpoFrame);
		// if(!edificioMadera.equals(this.testDataM.getTestVar(testId,"edificioMadera"))
		// && !this.testDataM.getTestVar(testId,"edificioMadera").equals("")) {
		// this.webDriver.selectValueInDropDownInFrame(this.cmbEdificioMadera,
		// this.cuerpoFrame, this.testDataM.getTestVar(testId,"edificioMadera"));
		// } else if(this.testDataM.getTestVar(testId,"edificioMadera").equals("")
		// && !edificioMadera.equals("")) { throw new Exception("El valor del
		// campo porcentaje edificio madera no es blanco al entrar en la
		// página"); }
		// this.webDriver.waitWithDriver(2000);

		String edificioMaderaWeb = this.webDriver.getTextInFrame(this.firstOptionEdifMad, this.cuerpoFrame);
		String edificioMaderaDatos = this.testDataM.getScenarioVar(testId, "edificio_madera") == null ? "" : this.testDataM.getScenarioVar(testId, "edificio_madera");

		if(!edificioMaderaWeb.equals(edificioMaderaDatos) && !edificioMaderaDatos.equals("")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbEdificioMadera, this.cuerpoFrame, edificioMaderaDatos);
		} else if(edificioMaderaDatos.isEmpty() && !edificioMaderaWeb.isEmpty()) { throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página"); }

		String deshabitacionDatos = this.testDataM.getTestVar(testId, "deshabitacion") == null ? "" : this.testDataM.getTestVar(testId, "deshabitacion");
		String deshabilitacionWeb = this.webDriver.getTextInFrame(this.cmbDeshabilitacion, this.cuerpoFrame);

		if(!deshabilitacionWeb.equals(deshabitacionDatos) && !deshabitacionDatos.equals("")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbDeshabilitacion, this.cuerpoFrame, this.testDataM.getTestVar(testId, "deshabilitacion"));
		} else if(deshabitacionDatos.isEmpty() && !deshabilitacionWeb.isEmpty()) { throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página"); }

		String m2ContruidosTotales = this.webDriver.getTextInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame);
		if(m2ContruidosTotales.equals(-1)) {
			this.webDriver.appendTextInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "M2ContruidosTotales")));
		}

		String AnyoConstruccion = this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame);

		if(this.testDataM.getTestVar(testId, "anyConstrucion") != null && this.testDataM.getTestVar(testId, "anyConstrucion").equals(ProjectConstants.MayorDe50)) {
			DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
			DateTime dateTime = DateTime.now(timeZone);
			int year = dateTime.year().get();

			this.webDriver.appendTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(year - 51));
		}
		// else if (!AnyoConstruccion.equals(this.testDataM.getTestVar(testId,
		// "anyConstrucion"))
		// && !this.testDataM.getTestVar(testId, "anyConstrucion").equals("-1"))
		else if(this.testDataM.getTestVar(testId, "anyConstrucion") != null && !AnyoConstruccion.equals(this.testDataM.getTestVar(testId, "anyConstrucion"))) {
			this.webDriver.appendTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "anyConstrucion")));
		}

		// String AnyoRehabilitacionAguasComunitarias =
		// this.webDriver.getTextInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias,
		// this.cuerpoFrame);
		// if
		// (!AnyoRehabilitacionAguasComunitarias.equals(String.valueOf(this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias()))
		// && this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias() !=
		// null)
		// {
		// this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias,
		// this.cuerpoFrame,
		// String.valueOf(this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias()));
		// }

		String AnyoRehabilitacionAguasComunitariasDatos = this.testDataM.getTestVar(testId, "anyoRehabilitacionAguasComunitarias") == null ? ""
			: this.testDataM.getTestVar(testId, "anyoRehabilitacionAguasComunitarias");
		String AnyoRehabilitacionAguasComunitariasWeb = this.webDriver.getTextInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame);
		if(AnyoRehabilitacionAguasComunitariasDatos.equals(String.valueOf(this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame)))
			&& this.testDataM.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias") != null) {
			int year = Integer.parseInt(this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame));
			this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame, String.valueOf(year + 1));
			this.webDriver
				.clickElementFromDropDownByTextInFrame(this.cmbNivelRehabilitacionAguas, this.cuerpoFrame, this.testDataM.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
		}

		// String NivelDeshabilitacionConstruccionesComunitarias =
		// this.webDriver.getTextInFrame(this.cmbNivelRehabilitacionAguas,
		// this.cuerpoFrame);
		// if (NivelDeshabilitacionConstruccionesComunitarias != null)
		// {
		// this.webDriver.selectValueInDropDownInFrame(this.cmbNivelRehabilitacionAguas,
		// this.cuerpoFrame,
		// this.testDataM.getNivelRehabilitacionConduccionesAguasComunitarias());
		// }

		String AnyoRehabilitacionIntegral = String.valueOf(this.testDataM.getTestVar(testId, "anyoRehabilitacionIntegral"));
		if(AnyoRehabilitacionIntegral != null && !AnyoRehabilitacionIntegral.equals("null")) {
			this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionIntegral, this.cuerpoFrame, AnyoRehabilitacionIntegral);
		}

		String m2Viviendas = this.webDriver.getTextInFrame(this.txtM2Viviendas, this.cuerpoFrame);
		// if (!m2Viviendas.equals(this.testDataM.getTestVar(testId,
		// "M2Viviendas")) &&
		// !this.testDataM.getTestVar(testId, "M2Viviendas").equals(-1))
		if(this.testDataM.getTestVar(testId, "M2Viviendas") != null && !m2Viviendas.equals(this.testDataM.getTestVar(testId, "M2Viviendas"))) {
			this.GetCapitales();

			this.GetValuesBefore();

			this.webDriver.appendTextInFrame(this.txtM2Viviendas, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "M2Viviendas")));
			this.webDriver.tabulateElementInFrame(this.txtM2Viviendas, this.cuerpoFrame);

			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Garajes = this.webDriver.getTextInFrame(this.txtM2Garajes, this.cuerpoFrame);
		if(!m2Garajes.equals(this.testDataM.getTestVar(testId, "M2Garajes")) && this.testDataM.getTestVar(testId, "M2Garajes") != null) {
			this.GetValuesBefore();
			this.webDriver.appendTextInFrame(this.txtM2Garajes, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "M2Garajes")));
			this.webDriver.tabulateElementInFrame(this.txtM2Garajes, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 garajes");
		}

		String m2Oficinas = this.webDriver.getTextInFrame(this.txtM2Oficinas, this.cuerpoFrame);
		if(!m2Oficinas.equals(this.testDataM.getTestVar(testId, "M2Oficinas")) && this.testDataM.getTestVar(testId, "M2Oficinas") != null) {
			this.GetValuesBefore();
			this.webDriver.appendTextInFrame(this.txtM2Oficinas, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "M2Oficinas")));
			this.webDriver.tabulateElementInFrame(this.txtM2Oficinas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = this.webDriver.getTextInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
		if(!m2ZonasAjardinadas.equals(this.testDataM.getTestVar(testId, "M2ZonasAjardinadas")) && this.testDataM.getTestVar(testId, "M2ZonasAjardinadas") != null) {

			this.webDriver.appendTextInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "M2ZonasAjardinadas")));
			this.webDriver.tabulateElementInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		String numeroViviendas = this.webDriver.getTextInFrame(this.txtNoViviendas, this.cuerpoFrame);
		if(this.testDataM.getTestVar(testId, "NumeroViviendas") != null && !numeroViviendas.equals(this.testDataM.getTestVar(testId, "NumeroViviendas"))) {
			this.webDriver.appendTextInFrame(this.txtNoViviendas, this.cuerpoFrame, this.testDataM.getTestVar(testId, "NumeroViviendas"));
		}

		String numeroPlantasALto = this.webDriver.getTextInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame);
		if(!numeroPlantasALto.equals(this.testDataM.getTestVar(testId, "NumeroPlantasAlto")) && this.testDataM.getTestVar(testId, "NumeroPlantasAlto") != null) {
			this.webDriver.appendTextInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame, String.valueOf(this.testDataM.getTestVar(testId, "NumeroPlantasAlto")));
		}

		String numeroPlantasSotano = this.webDriver.getTextInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame);
		if(!numeroPlantasSotano.equals(this.testDataM.getTestVar(testId, "NumeroPlantasSotano")) && this.testDataM.getTestVar(testId, "NumeroPlantasSotano") != null) {
			// this.webDriver.appendTextInFrame(this.txtNumeroPlantasSotano,
			// this.cuerpoFrame,
			// String.valueOf(this.testDataM.getNumeroPlantasSotano()));
			this.webDriver.appendTextInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame, this.testDataM.getTestVar(testId, "NumeroPlantasSotano"));
		}

		String numeroEdificios = this.webDriver.getTextInFrame(this.txtNumeroEdificios, this.cuerpoFrame);
		if(!numeroEdificios.equals(this.testDataM.getTestVar(testId, "NumeroEdificios")) && this.testDataM.getTestVar(testId, "NumeroEdificios") != null) {
			this.webDriver.appendTextInFrame(this.txtNumeroEdificios, this.cuerpoFrame, this.testDataM.getTestVar(testId, "NumeroEdificios"));
		}

		// boolean GasolineraMenos50M =
		// this.browserContext.getTestCaseData().isGasolineraMenos50M();
		//
		// if(GasolineraMenos50M) {
		// this.webDriver.clickInFrame(this.chkGasolineraMenos50M,
		// this.cuerpoFrame);
		// }
		//
		// boolean CalefaccionCentral = this.testDataM.isCalefaccionCentral();
		// if(CalefaccionCentral &&
		// !this.chkCalefaccionCentralAguaCalienteCentralizada.isSelected()) {
		// this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada,
		// this.cuerpoFrame);
		// }
		//
		// boolean DepositoCombustible = this.testDataM.isDepositoCombustible();
		// if(DepositoCombustible) {
		// this.webDriver.clickInFrame(this.chkDepositoCombustible,
		// this.cuerpoFrame);
		// }

		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "gasolinera_menos_50m"))) {
			this.webDriver.clickInFrame(this.chkGasolineraMenos50M, this.cuerpoFrame);
		}

		// boolean CalefaccionCentral = this.testDataM.isCalefaccionCentral();

		// if(Boolean.parseBoolean(this.testDataM.getTestVar(testId,
		// "CalefaccionCentral")) &&
		// !this.chkCalefaccionCentralAguaCalienteCentralizada.isSelected()) {
		// this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada,
		// this.cuerpoFrame);
		// }

		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "CalefaccionCentral")) && !this.webDriver.isSelected(chkCalefaccionCentralAguaCalienteCentralizada)) {
			this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada, this.cuerpoFrame);
		}

		// boolean DepositoCombustible = this.testDataM.isDepositoCombustible();
		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "deposito_combustible"))) {
			this.webDriver.clickInFrame(this.chkDepositoCombustible, this.cuerpoFrame);
		}

		// this.webDriver.exitFrame();
		// this.ModificarDatosActividadComercial();

		debugEnd();
	}

	// This function modifies the values of the fields located in the page. All
	// the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data inside the values whose variables start with
	// Modified.
	public void ModificarDatosRiesgo() throws ParseException {
		debugBegin();
		
		this.webDriver.switchToFrame(this.cuerpoFrame);

		// Modify Año rehabilitación de aguas comunitarias
		String AnyoRehabilitacionAguasComunitarias = this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias);
		String AnyoConstruccion = this.webDriver.getText(this.txtAnyoConstruccion);

		// if(this.testDataM.getNivelRehabilitacionConduccionesAguasComunitarias()
		// != null) {
		// if(AnyoRehabilitacionAguasComunitarias.isEmpty()) {
		// this.webDriver.sendValueToWebElement(this.txtAnyoRehabilitacionAguasComunitarias,
		// String.valueOf(Integer.parseInt(AnyoConstruccion) + 1));
		// this.webDriver.selectValueInDropDown(this.cmbNivelRehabilitacionAguas,
		// this.testDataM.getNivelRehabilitacionConduccionesAguasComunitarias());
		// this.testDataM.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
		// }

		if(this.testDataM.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias") != null) {
			if(AnyoRehabilitacionAguasComunitarias.isEmpty()) {
				this.webDriver.appendText(this.txtAnyoRehabilitacionAguasComunitarias, String.valueOf(Integer.parseInt(AnyoConstruccion) + 1));
				this.webDriver.clickElementFromDropDownByText(this.cmbNivelRehabilitacionAguas, this.testDataM.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
				// this.testDataM.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
				this.testDataM.setTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias", this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
			}
			if(!AnyoRehabilitacionAguasComunitarias.isEmpty()) {
				// If Año rehabilitación de aguas comunitarias is already
				// present, then input Año rehabilitación de aguas comunitarias
				// + 1. Required if we
				// want to execute this test in the same week, before database
				// reset.
				this.webDriver.appendText(this.txtAnyoRehabilitacionAguasComunitarias, String.valueOf(Integer.parseInt(AnyoRehabilitacionAguasComunitarias) + 1));
				this.webDriver.clickElementFromDropDownByText(this.cmbNivelRehabilitacionAguas, this.testDataM.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
				// this.testDataM.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
				this.testDataM.setTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias", this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));

			}

		}

		String numeroEdificios = this.webDriver.getText(this.txtNumeroEdificios);
		if(!numeroEdificios.equals(this.testDataM.getTestVar(testId, "CambioNumEdificios")) && this.testDataM.getTestVar(testId, "CambioNumEdificios") != null) {
			this.webDriver.appendText(this.txtNumeroEdificios, this.testDataM.getTestVar(testId, "CambioNumEdificios"));
		}

		String numeroViviendas = this.webDriver.getText(this.txtNoViviendas);
		if(!numeroViviendas.equals(this.testDataM.getTestVar(testId, "cambio_num_viviendas")) && this.testDataM.getTestVar(testId, "cambio_num_viviendas") != null) {
			this.webDriver.appendText(this.txtNoViviendas, this.testDataM.getTestVar(testId, "cambio_num_viviendas"));
		}

		String numeroLocales = this.webDriver.getText(this.txtNumeroLocales);
		if(!numeroLocales.equals(this.testDataM.getTestVar(testId, "cambio_num_locales")) && this.testDataM.getTestVar(testId, "cambio_num_locales") != null) {
			this.webDriver.appendText(this.txtNumeroLocales, this.testDataM.getTestVar(testId, "cambio_num_locales"));
		}

		String m2ContruidosTotales = this.webDriver.getText(this.txtM2ContruidosTotales);
		if(m2ContruidosTotales.equals(-1)) {
			this.webDriver.appendText(this.txtM2ContruidosTotales, String.valueOf(this.testDataM.getTestVar(testId, "M2ContruidosTotales")));
		}

		String m2Viviendas = this.webDriver.getText(this.txtM2Viviendas);
		if(!m2Viviendas.equals(this.testDataM.getTestVar(testId, "ModifiedM2Viviendas")) && this.testDataM.getTestVar(testId, "ModifiedM2Viviendas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Viviendas, String.valueOf(this.testDataM.getTestVar(testId, "ModifiedM2Viviendas")));
			this.webDriver.tabulateElement(this.txtM2Viviendas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.testDataM.setTestVar(testId, "M2ContruidosTotales", this.webDriver.getText(this.txtM2ContruidosTotales));

		}

		String m2Garajes = this.webDriver.getText(this.txtM2Viviendas);
		if(!m2Garajes.equals(this.testDataM.getTestVar(testId, "modifiedM2Garajes")) && this.testDataM.getTestVar(testId, "modifiedM2Garajes") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Garajes, String.valueOf(this.testDataM.getTestVar(testId, "modifiedM2Garajes")));
			this.webDriver.tabulateElement(this.txtM2Garajes);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		String m2Oficinas = this.webDriver.getText(this.txtM2Oficinas);
		if(!m2Oficinas.equals(this.testDataM.getTestVar(testId, "ModifiedM2Oficinas")) && this.testDataM.getTestVar(testId, "ModifiedM2Oficinas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Oficinas, String.valueOf(this.testDataM.getTestVar(testId, "ModifiedM2Oficinas")));
			this.webDriver.tabulateElement(this.txtM2Oficinas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		String m2ZonasAjardinadas = this.webDriver.getText(this.txtM2ZonasAjardinadas);
		if(!m2ZonasAjardinadas.equals(this.testDataM.getTestVar(testId, "ModifiedM2ZonasAjardinadas")) && this.testDataM.getTestVar(testId, "ModifiedM2ZonasAjardinadas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2ZonasAjardinadas, String.valueOf(this.testDataM.getTestVar(testId, "ModifiedM2ZonasAjardinadas")));
			this.webDriver.tabulateElement(this.txtM2ZonasAjardinadas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		this.webDriver.exitFrame();
		// this.ModificarDatosActividadComercial();
		debugEnd();
	}

	// private void ModificarDatosActividadComercial()
	// {
	// logger.debug("BEGIN - ModificarDatosActividadComercial");
	//
	// this.webDriver.SwitchToFrame(this.cuerpoFrame);
	// String m2ActividadComercial = this.webDriver.getText(this.txtM2Locales);
	// if (Integer.valueOf(m2ActividadComercial.replace(".", "")) > 0)
	// {
	// this.webDriver.ClickOnWebElement(this.btnAnadirActividadComercial);
	// this.webDriver.ClickOnWebElement(this.btnAnadir);
	// this.webDriver.SendValueToWebElement(this.txtActividadDescripcion,
	// MutuaPropietariosConstants.ActividadComercialDescripcion);
	// this.webDriver.SendValueToWebElement(this.txtActividadPorcentaje,
	// MutuaPropietariosConstants.ActividadComercialOPorcentaje);
	// this.webDriver.SendValueToWebElement(this.txtActividadM2,
	// m2ActividadComercial);
	// this.webDriver.ClickOnWebElement(this.btnGuardarActividadesComerciales);
	// }
	// this.webDriver.exitFrame();
	// logger.debug("END - ModificarDatosActividadComercial");
	// }

	private void GetCapitales() throws ParseException {
		debugBegin();

		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(2000);
		this.webDriver.scrollToBottom();
		this.CapitalTotalAsegurado = this.nf.parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.CapitalContenido = this.nf.parse(this.webDriver.getText(this.txtCapitalContenido)).doubleValue();
		this.CapitalContinente = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();
		this.webDriver.exitFrame();
		
		debugEnd();
	}

	// private boolean IsCapitalesVaried() throws ParseException
	// {
	// logger.debug("BEGIN - IsCapitalesVaried");
	// Double CapitalTotalAseguradoSavedValue = this.CapitalTotalAsegurado;
	// Double CapitalContenidoSavedValue = this.CapitalContenido;
	// Double CapitalContinenteSavedValue = this.CapitalContinente;
	//
	// Double CapitalTotalAseguradoTemp =
	// this.nf.parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
	// Double CapitalContenidoTemp =
	// this.nf.parse(this.webDriver.getText(this.txtCapitalContenido)).doubleValue();
	// Double CapitalContinenteTemp =
	// this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();
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

	private void CheckForInfraseguroOrSupraSeguro() throws ParseException {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);

		// Double CapitalTotalAsegurado = this.nf
		// .parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado))
		// .doubleValue();
		// Double CapitalContenido =
		// this.nf.parse(this.webDriver.getText(this.txtCapitalContenido))
		// .doubleValue();
		Double CapitalContiente = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();

		if(CapitalContiente > this.CapitalContinente) {
			this.testDataM.setTestVar(testId, "Infraseguro", "true");
		}

		if(CapitalContiente < this.CapitalContinente) {
			this.testDataM.setTestVar(testId, "SupraSeguro", "true");
		}

		this.webDriver.exitFrame();
		debugEnd();
	}

	public void clickOnContinuar() {
		debugBegin();
		// this.CheckForInfraseguroOrSupraSeguro();
		// this.cuerpoFrame.click();
		this.webDriver.scrollToBottom();

		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);

		// TODO - This is supposed to check that the madera and deshabitacion
		// fields are mandatory, but currently gives a NULL pointer exception.
		// Perhaps is should be moved out of ClikOnContinuar.
		/*
		 * if(this.testDataM.getTestVar(testId, "edificio_madera").equals("") &&
		 * this.testDataM.getTestVar(testId, "deshabitacion").equals("")) {
		 * this.webDriver.switchToFrame(this.cuerpoFrame);
		 * this.webDriver.click(this.btnCamposObligatiosModalWindowAceptar);
		 * 
		 * String color1 =
		 * this.webDriver.getElement(cmbDeshabilitacion).getCssValue(
		 * "border-color"); String color2 =
		 * this.webDriver.getElement(cmbEdificioMadera).getCssValue(
		 * "border-color");
		 * 
		 * Assert.assertTrue("El campo deshabilitación no tiene un borde rojo",
		 * color1.equals("rgb(169, 68, 66)"));
		 * Assert.assertTrue("El campo edificio madera no tiene un borde rojo",
		 * color2.equals("rgb(169, 68, 66)")); this.webDriver.exitFrame(); }
		 */

		this.webDriver.scrollToBottom();
		debugEnd();
	}

	public void GetValuesBefore() throws ParseException {
		this.webDriver.exitFrame();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.CapitalContenidoBefore = this.nf.parse(this.webDriver.getText(this.txtCapitalContenido)).doubleValue();
		this.CapitalContinenteBefore = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();
		this.CapitalTotalAseguradoBefore = this.nf.parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.webDriver.exitFrame();
	}

	public void GetValuesAfter() throws ParseException {
		this.webDriver.exitFrame();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.CapitalContenidoAfter = this.nf.parse(this.webDriver.getText(this.txtCapitalContenido)).doubleValue();
		this.CapitalContienteAfter = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();
		this.CapitalTotalAseguradoAfter = this.nf.parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.webDriver.exitFrame();
	}

	public void CompareValues(
		String comparisonType, String modification) {

		switch(comparisonType) {
			case ProjectConstants.NotEqual:
				if(this.CapitalContenidoBefore == this.CapitalContenidoAfter || this.CapitalContinenteBefore == this.CapitalContienteAfter
					|| this.CapitalTotalAseguradoBefore == this.CapitalTotalAseguradoAfter) {
					// this.testDataM.setCantidadesModifiedError(true);
					this.testDataM.setTestVar(testId, "cantidadesModifiedError", "true");
					// this.testDataM.setCantidadesModifiedErrorMessage(
					// String.format("El valor de las cantiadaes no ha variado
					// en la pantalla de detalles de riesgo despues de %s",
					// Modification));
					this.testDataM.setTestVar(testId, "cantidadesModifiedErrorMessage", "El valor de las cantiadaes no ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);

				}
				break;

			case ProjectConstants.Equal:
				if(this.CapitalContenidoBefore != this.CapitalContenidoAfter || this.CapitalContinenteBefore != this.CapitalContienteAfter
					|| this.CapitalTotalAseguradoBefore != this.CapitalTotalAseguradoAfter) {
					// this.testDataM.setCantidadesModifiedError(true);
					// this.testDataM.setCantidadesModifiedErrorMessage(
					// String.format("El valor de las cantidades ha variado en
					// la pantalla de detalles de riesgo despues de %s",
					// modification));
					this.testDataM.setTestVar(testId, "cantidadesModifiedError", "true");
					this.testDataM.setTestVar(testId, "cantidadesModifiedErrorMessage", "El valor de las cantiadaes ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);

				}
				break;
		}

	}

	public void CheckAvisoGarajes() {
		debugBegin();
		// if (this.testDataM.isAsegurarUnicamenteGarajes())
		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "AsegurarUnicamenteGarajes"))) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			if(this.lblAvisoGarajes.size() != 1) {
				// this.testDataM.setAvisoGarajesMsgNotPressent(true);
				this.testDataM.setTestVar(testId, "AsegurarUnicamenteGarajes", "true");
				this.webDriver.exitFrame();
			}
			this.webDriver.click(this.btnAceptar);
			this.webDriver.exitFrame();
		}
		debugEnd();
	}

	public void CheckAvisoGarajesWithException() {
		// if (this.testDataM.isAsegurarUnicamenteGarajes())
		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "AsegurarUnicamenteGarajes"))) {
			if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "AvisoGarajesMsgNotPressent"))) {
				Assert.assertTrue(ProjectConstants.AvisoGarajesErrorMessage, !Boolean.parseBoolean(this.testDataM.getTestVar(testId, "isAvisoGarajesMsgNotPressent")));
			}
		}
	}

	public boolean IsFieldEnabled(
		String fieldName) {
		this.webDriver.switchToFrame(this.cuerpoFrame);
		switch(fieldName) {
			case "M2 Trasteros":
				if(this.webDriver.isEnabled(this.txtM2Trasteros)) {
					this.webDriver.exitFrame();
					return true;
				}
				break;
			// txtNumeroPlantasSotano
			case "No plantas bajo rasante":
				if(this.webDriver.isEnabled(this.txtNumeroPlantasSotano)) {
					this.webDriver.exitFrame();
					return true;
				}
				break;
			// this.txtNumeroPlantasAlto
			case "No plantas en alto":
				if(webDriver.isEnabled(this.txtNumeroPlantasAlto)) {
					this.webDriver.exitFrame();
					return true;
				}
				break;
			// txtM2Garajes
			case "M2 Garajes":
				// if(this.webDriver.isDisplayed(this.txtM2Garajes)) {
				// this.webDriver.exitFrame();
				// return true;
				// }
				if(this.webDriver.isPresent(this.txtM2Garajes)) {
					this.webDriver.exitFrame();
					return true;
				}
				break;

			// case "No Plazas de garaje":
			// if(this.txtNumPlazasGaraje.isDisplayed()) {
			// this.webDriver.exitFrame();
			// return true;
			// }
			// txtNumPlazasGaraje
			case "No Plazas de garaje":
				if(this.webDriver.isPresent(this.txtNumPlazasGaraje)) {
					this.webDriver.exitFrame();
					return true;
				}
				break;

			default:
				this.webDriver.exitFrame();
				return false;
		}
		this.webDriver.exitFrame();
		return false;
	}

	public void enterAnyoConstruccionMoreThan50() throws ParseException {
		DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
		DateTime dateTime = DateTime.now(timeZone);
		int year = dateTime.year().get();
		// this.webDriver.appendTextInFrame(this.txtAnyoConstruccion,
		// this.cuerpoFrame, String.valueOf(year - 51));
		this.webDriver.sendKeysFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(year - 51));
	}

	// endregion
}
