package com.project.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import com.automation.configuration.AutomationConstants;
import com.automation.model.utils.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;

import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DetallesRiesgoPage { /*
									 * final static Logger logger =
									 * LoggerFactory.getLogger(
									 * DetallesRiesgoPage.class); BrowserContext
									 * browserContext; TestCaseData tData;
									 * private WebElementHelper wh;
									 */

	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

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
	public DetallesRiesgoPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public void executeActionsInPageDetallesRiesgoPage() throws Exception {
		logger.debug("BEGIN - ExecuteActionsInPageDetallesRiesgoPage");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
		this.clickOnContinuar();
		logger.debug("END - ExecuteActionsInPageDetallesRiesgoPage");
	}

	public void completarDatosEnDetallesRiesgo() throws Exception {
		logger.debug("BEGIN - completarDatosEnDetallesRiesgo");
		this.CheckAvisoGarajes();
		// this.GetCapitales();
		this.completarDatosRiesgo();
		this.clickOnContinuar();
		logger.debug("END - completarDatosEnDetallesRiesgo");
	}

	public void modificarDatosEnDetallesRiesgo() throws Exception {
		logger.debug("BEGIN - modificarDatosEnDetallesRiesgo");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		this.clickOnContinuar();
		logger.debug("END - modificarDatosEnDetallesRiesgo");
	}

	public void ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue() throws Exception {
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
	}

	public void completarDatosEnDetallesRiesgoSinContinuar() throws Exception {
		logger.debug("BEGIN - completarDatosEnDetallesRiesgoSinContinuar");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		logger.debug("END - completarDatosEnDetallesRiesgoSinContinuar");
	}

	public void modificarDatosEnDetallesRiesgoSinContinuar() throws Exception {
		logger.debug("BEGIN - modificarDatosEnDetallesRiesgoSinContinuar");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		logger.debug("END - modificarDatosEnDetallesRiesgoSinContinuar");
	}

	// This function modifies the values of the fields located in the page. All
	// the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data.
	public String completarDatosRiesgoMinimos() throws Exception {
		logger.debug("BEGIN - completarDatosRiesgoMinimos");
		String value = "";
		this.webDriver.switchToFrame(this.cuerpoFrame);
		//String edificioMadera = this.webDriver.getText(this.firstOptionEdifMad);
		// if
		// (!edificioMadera.equals(this.tCData.getTestVar(testId,"edificioMadera"))
		// &&
		// !this.tCData.getTestVar(testId,"edificioMadera").equals(""))
		
		this.webDriver.waitWithDriver(5000);
		
		//if(!edificioMadera.equals(this.tCData.getTestVar(testId, "edificioMadera")) && !this.tCData.getTestVar(testId, "edificioMadera").equals("")) {
			// this.webDriver.selectValueInDropDown(this.cmbEdificioMadera,
			// this.tCData.getTestVar(testId, "edificioMadera"));
			//this.webDriver.clickElementFromDropDownByText(this.cmbEdificioMadera, this.tCData.getTestVar(testId, "edificioMadera"));
		//} else if(this.tCData.getTestVar(testId, "edificioMadera").equals("")
			//&& !edificioMadera.equals("")) { throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página"); }

		//this.webDriver.clickElementFromDropDownByText(this.cmbEdificioMadera, this.tCData.getTestVar(testId, "edificioMadera"));
		this.webDriver.clickElementFromDropDownByText(this.edifConstruccionMadera, "No");
		
		
		//String deshabilitacion = this.webDriver.getText(this.edifConstruccionMadera);
//		if(!deshabilitacion.equals(this.tCData.getTestVar(testId, "deshabilitacion")) && !this.tCData.getTestVar(testId, "deshabilitacion").equals("")) {
//			this.webDriver.clickElementFromDropDownByText(this.cmbDeshabilitacion, this.tCData.getTestVar(testId, "deshabilitacion"));
//		} else if(this.tCData.getTestVar(testId, "deshabilitacion").equals("")
//			&& !deshabilitacion.equals("")) { throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página"); }

		this.webDriver.clickElementFromDropDownByText(this.deshabilitacion, ProjectConstants.DeshabitacionInferior);
		
		
//		value = this.webDriver.getText(this.txtAnyoConstruccion);
		
		/* AÑO DE CONSTRUCCION Y REHABILITACIONES*/
		this.webDriver.scrollToElement(this.txtAnyoConstruccion);
		this.webDriver.waitWithDriver(5000);
		this.webDriver.clearText(this.txtAnyoConstruccion);
		this.webDriver.appendText(this.txtAnyoConstruccion, "2000");
		this.webDriver.waitWithDriver(5000);
		
		/* SUPERFICIES */

//		this.webDriver.appendText(by, text);
//		this.webDriver.appendText(by, text);
//		this.webDriver.appendText(by, text);
//		this.webDriver.appendText(by, text);
		
		this.webDriver.exitFrame();
		this.webDriver.waitWithDriver(5000);
		this.clickOnContinuar();
		
		logger.debug("END - completarDatosRiesgoMinimos");
		return value;
	}

	public String getCapitalContinente() throws Exception {
		logger.debug("GET - getCapitalContinente");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame);
	}

	public String getCapitalContenido() throws Exception {
		logger.debug("GET - getCapitalContenido");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContenido, this.cuerpoFrame);
	}

	public String getCapitalContinenteTotalAsegurado() throws Exception {
		logger.debug("GET - getCapitalContinenteTotalAsegurado");
		this.webDriver.scrollToBottom();
		return this.webDriver.getTextInFrame(this.txtCapitalContinenteTotalAsegurado, this.cuerpoFrame);
	}

	public void completarDatosRiesgo() throws Exception {
		logger.debug("BEGIN - CompletarDatosRiesgo");
		// this.webDriver.switchToFrame(this.cuerpoFrame);

		// if (this.tCData.getCapitalContinente() != null)
		if(this.tCData.getTestVar(testId, "capitalContinente") != null) {
			// if (this.tCData.isCapitalContinenteVariacion())
			if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "capitalContinenteVariacion"))) {
				// Double capitalContinenteModified =
				// this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame))
				// .doubleValue() +
				// this.tCData.getCapitalContinente().doubleValue();

				Double capitalContinenteModified = this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame))
					.doubleValue() + Double.parseDouble(this.tCData.getTestVar(testId, "capitalContinente"));

				// this.webDriver.appendTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame, String.valueOf(capitalContinenteModified));
				this.webDriver.appendTextInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(capitalContinenteModified));
				this.webDriver.tabulateElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				// this.tCData.setCapitalContinente(capitalContinenteModified);
				this.tCData.setConfigVar("CapitalContinente", "capitalContinenteModified");

			} else {
				// this.webDriver.appendTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame,
				// String.valueOf(this.tCData.getConfigVar("CapitalContinente")));
				this.webDriver.appendTextInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(this.tCData.getConfigVar("CapitalContinente")));
				this.webDriver.tabulateElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				// this.tCData.setCapitalContinente(this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContinente,
				// this.cuerpoFrame)));
				this.tCData.setConfigVar("CapitalContinente", this.webDriver.getTextInFrame(this.txtCapitalContinente, this.cuerpoFrame));
			}
		}

		// if (this.tCData.getCapitalContenido() != null)
		if(this.tCData.getTestVar(testId, "CapitalContenido") != null) {
			// Double capitalContenidoModified =
			// this.nf.parse(this.webDriver.getTextInFrame(this.txtCapitalContenido,
			// this.cuerpoFrame)).doubleValue()
			// + this.tCData.getCapitalContenido().doubleValue();

			Double capitalContenidoModified = Double.parseDouble(this.webDriver.getTextInFrame(this.txtCapitalContenido, this.cuerpoFrame))
				+ Double.parseDouble(this.tCData.getTestVar(testId, "CapitalContenido"));
			this.webDriver.appendTextInFrame(this.txtCapitalContenido, this.cuerpoFrame, this.nf.format(capitalContenidoModified).toString());
			this.webDriver.tabulateElementInFrame(this.txtCapitalContenido, this.cuerpoFrame);
			// this.tCData.setCapitalContenido(capitalContenidoModified);
			this.tCData.setTestVar(testId, "CapitalContenido", "capitalContenidoModified");
		}

		// String edificioMadera =
		// this.webDriver.getTextInFrame(this.cmbEdificioMadera,
		// this.cuerpoFrame);
		// if(!edificioMadera.equals(this.tCData.getTestVar(testId,"edificioMadera"))
		// && !this.tCData.getTestVar(testId,"edificioMadera").equals("")) {
		// this.webDriver.selectValueInDropDownInFrame(this.cmbEdificioMadera,
		// this.cuerpoFrame, this.tCData.getTestVar(testId,"edificioMadera"));
		// } else if(this.tCData.getTestVar(testId,"edificioMadera").equals("")
		// && !edificioMadera.equals("")) { throw new Exception("El valor del
		// campo porcentaje edificio madera no es blanco al entrar en la
		// página"); }
		// this.webDriver.waitWithDriver(2000);


		String edificioMaderaWeb = this.webDriver.getTextInFrame(this.firstOptionEdifMad, this.cuerpoFrame);
		String edificioMaderaDatos = this.tCData.getScenarioVar(testId, "edificio_madera") == null ? "" : this.tCData.getScenarioVar(testId, "edificio_madera");

		if(!edificioMaderaWeb.equals(edificioMaderaDatos) && !edificioMaderaDatos.equals("")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbEdificioMadera, this.cuerpoFrame, edificioMaderaDatos);
		} else if(edificioMaderaDatos.isEmpty() && !edificioMaderaWeb.isEmpty()) {
			throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página");
		}

		String deshabitacionDatos = this.tCData.getTestVar(testId, "deshabitacion") == null ? "" : this.tCData.getTestVar(testId, "deshabitacion");
		String deshabilitacionWeb = this.webDriver.getTextInFrame(this.cmbDeshabilitacion, this.cuerpoFrame);
		
		if(!deshabilitacionWeb.equals(deshabitacionDatos) && !deshabitacionDatos.equals("")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbDeshabilitacion, this.cuerpoFrame, this.tCData.getTestVar(testId, "deshabilitacion"));
		} else if(deshabitacionDatos.isEmpty()	&& !deshabilitacionWeb.isEmpty()) {
			throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página"); }

		String m2ContruidosTotales = this.webDriver.getTextInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame);
		if(m2ContruidosTotales.equals(-1)) {
			this.webDriver.appendTextInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "M2ContruidosTotales")));
		}

		String AnyoConstruccion = this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame);

		if(this.tCData.getTestVar(testId, "anyConstrucion") != null && this.tCData.getTestVar(testId, "anyConstrucion").equals(ProjectConstants.MayorDe50)) {
			DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
			DateTime dateTime = DateTime.now(timeZone);
			int year = dateTime.year().get();

			this.webDriver.appendTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(year - 51));
		}
		// else if (!AnyoConstruccion.equals(this.tCData.getTestVar(testId,
		// "anyConstrucion"))
		// && !this.tCData.getTestVar(testId, "anyConstrucion").equals("-1"))
		else if(this.tCData.getTestVar(testId, "anyConstrucion") != null && !AnyoConstruccion.equals(this.tCData.getTestVar(testId, "anyConstrucion"))) {
			this.webDriver.appendTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "anyConstrucion")));
		}

		// String AnyoRehabilitacionAguasComunitarias =
		// this.webDriver.getTextInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias,
		// this.cuerpoFrame);
		// if
		// (!AnyoRehabilitacionAguasComunitarias.equals(String.valueOf(this.tCData.getAnyoRehabilitacionConstruccionesComunitarias()))
		// && this.tCData.getAnyoRehabilitacionConstruccionesComunitarias() !=
		// null)
		// {
		// this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias,
		// this.cuerpoFrame,
		// String.valueOf(this.tCData.getAnyoRehabilitacionConstruccionesComunitarias()));
		// }

		
		String AnyoRehabilitacionAguasComunitariasDatos = this.tCData.getTestVar(testId, "anyoRehabilitacionAguasComunitarias") == null ? "" : this.tCData.getTestVar(testId, "anyoRehabilitacionAguasComunitarias");
		String AnyoRehabilitacionAguasComunitariasWeb = this.webDriver.getTextInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame);
		if(AnyoRehabilitacionAguasComunitariasDatos.equals(String.valueOf(this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame)))
			&& this.tCData.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias") != null) {
			int year = Integer.parseInt(this.webDriver.getTextInFrame(this.txtAnyoConstruccion, this.cuerpoFrame));
			this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame, String.valueOf(year + 1));
			this.webDriver
				.clickElementFromDropDownByTextInFrame(this.cmbNivelRehabilitacionAguas, this.cuerpoFrame, this.tCData.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
		}

		// String NivelDeshabilitacionConstruccionesComunitarias =
		// this.webDriver.getTextInFrame(this.cmbNivelRehabilitacionAguas,
		// this.cuerpoFrame);
		// if (NivelDeshabilitacionConstruccionesComunitarias != null)
		// {
		// this.webDriver.selectValueInDropDownInFrame(this.cmbNivelRehabilitacionAguas,
		// this.cuerpoFrame,
		// this.tCData.getNivelRehabilitacionConduccionesAguasComunitarias());
		// }

		String AnyoRehabilitacionIntegral = String.valueOf(this.tCData.getTestVar(testId, "anyoRehabilitacionIntegral"));
		if(AnyoRehabilitacionIntegral != null && !AnyoRehabilitacionIntegral.equals("null")) {
			this.webDriver.appendTextInFrame(this.txtAnyoRehabilitacionIntegral, this.cuerpoFrame, AnyoRehabilitacionIntegral);
		}

		String m2Viviendas = this.webDriver.getTextInFrame(this.txtM2Viviendas, this.cuerpoFrame);
		// if (!m2Viviendas.equals(this.tCData.getTestVar(testId,
		// "M2Viviendas")) &&
		// !this.tCData.getTestVar(testId, "M2Viviendas").equals(-1))
		if(this.tCData.getTestVar(testId, "M2Viviendas") != null && !m2Viviendas.equals(this.tCData.getTestVar(testId, "M2Viviendas"))) {
			this.GetCapitales();

			this.GetValuesBefore();

			this.webDriver.appendTextInFrame(this.txtM2Viviendas, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "M2Viviendas")));
			this.webDriver.tabulateElementInFrame(this.txtM2Viviendas, this.cuerpoFrame);

			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Garajes = this.webDriver.getTextInFrame(this.txtM2Garajes, this.cuerpoFrame);
		if(!m2Garajes.equals(this.tCData.getTestVar(testId, "M2Garajes")) && this.tCData.getTestVar(testId, "M2Garajes") != null) {
			this.GetValuesBefore();
			this.webDriver.appendTextInFrame(this.txtM2Garajes, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "M2Garajes")));
			this.webDriver.tabulateElementInFrame(this.txtM2Garajes, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 garajes");
		}

		String m2Oficinas = this.webDriver.getTextInFrame(this.txtM2Oficinas, this.cuerpoFrame);
		if(!m2Oficinas.equals(this.tCData.getTestVar(testId, "M2Oficinas")) && this.tCData.getTestVar(testId, "M2Oficinas") != null) {
			this.GetValuesBefore();
			this.webDriver.appendTextInFrame(this.txtM2Oficinas, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "M2Oficinas")));
			this.webDriver.tabulateElementInFrame(this.txtM2Oficinas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = this.webDriver.getTextInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
		if(!m2ZonasAjardinadas.equals(this.tCData.getTestVar(testId, "M2ZonasAjardinadas")) && this.tCData.getTestVar(testId, "M2ZonasAjardinadas") != null) {

			this.webDriver.appendTextInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "M2ZonasAjardinadas")));
			this.webDriver.tabulateElementInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		String numeroViviendas = this.webDriver.getTextInFrame(this.txtNoViviendas, this.cuerpoFrame);
		if(this.tCData.getTestVar(testId, "NumeroViviendas") != null && !numeroViviendas.equals(this.tCData.getTestVar(testId, "NumeroViviendas"))) {
			this.webDriver.appendTextInFrame(this.txtNoViviendas, this.cuerpoFrame, this.tCData.getTestVar(testId, "NumeroViviendas"));
		}

		String numeroPlantasALto = this.webDriver.getTextInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame);
		if(!numeroPlantasALto.equals(this.tCData.getTestVar(testId, "NumeroPlantasAlto")) && this.tCData.getTestVar(testId, "NumeroPlantasAlto") != null) {
			this.webDriver.appendTextInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame, String.valueOf(this.tCData.getTestVar(testId, "NumeroPlantasAlto")));
		}

		String numeroPlantasSotano = this.webDriver.getTextInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame);
		if(!numeroPlantasSotano.equals(this.tCData.getTestVar(testId, "NumeroPlantasSotano")) && this.tCData.getTestVar(testId, "NumeroPlantasSotano") != null) {
			// this.webDriver.appendTextInFrame(this.txtNumeroPlantasSotano,
			// this.cuerpoFrame,
			// String.valueOf(this.tCData.getNumeroPlantasSotano()));
			this.webDriver.appendTextInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame, this.tCData.getTestVar(testId, "NumeroPlantasSotano"));
		}

		String numeroEdificios = this.webDriver.getTextInFrame(this.txtNumeroEdificios, this.cuerpoFrame);
		if(!numeroEdificios.equals(this.tCData.getTestVar(testId, "NumeroEdificios")) && this.tCData.getTestVar(testId, "NumeroEdificios") != null) {
			this.webDriver.appendTextInFrame(this.txtNumeroEdificios, this.cuerpoFrame, this.tCData.getTestVar(testId, "NumeroEdificios"));
		}

		// boolean GasolineraMenos50M =
		// this.browserContext.getTestCaseData().isGasolineraMenos50M();
		//
		// if(GasolineraMenos50M) {
		// this.webDriver.clickInFrame(this.chkGasolineraMenos50M,
		// this.cuerpoFrame);
		// }
		//
		// boolean CalefaccionCentral = this.tCData.isCalefaccionCentral();
		// if(CalefaccionCentral &&
		// !this.chkCalefaccionCentralAguaCalienteCentralizada.isSelected()) {
		// this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada,
		// this.cuerpoFrame);
		// }
		//
		// boolean DepositoCombustible = this.tCData.isDepositoCombustible();
		// if(DepositoCombustible) {
		// this.webDriver.clickInFrame(this.chkDepositoCombustible,
		// this.cuerpoFrame);
		// }

		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "gasolinera_menos_50m"))) {
			this.webDriver.clickInFrame(this.chkGasolineraMenos50M, this.cuerpoFrame);
		}

		// boolean CalefaccionCentral = this.tCData.isCalefaccionCentral();

		// if(Boolean.parseBoolean(this.tCData.getTestVar(testId,
		// "CalefaccionCentral")) &&
		// !this.chkCalefaccionCentralAguaCalienteCentralizada.isSelected()) {
		// this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada,
		// this.cuerpoFrame);
		// }

		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "CalefaccionCentral")) && !this.webDriver.isSelected(chkCalefaccionCentralAguaCalienteCentralizada)) {
			this.webDriver.clickInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada, this.cuerpoFrame);
		}

		// boolean DepositoCombustible = this.tCData.isDepositoCombustible();
		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "deposito_combustible"))) {
			this.webDriver.clickInFrame(this.chkDepositoCombustible, this.cuerpoFrame);
		}

		// this.webDriver.exitFrame();
		// this.ModificarDatosActividadComercial();

		logger.debug("END - CompletarDatosRiesgo");
	}

	// This function modifies the values of the fields located in the page. All
	// the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data inside the values whose variables start with
	// Modified.
	public void ModificarDatosRiesgo() throws ParseException {
		logger.debug("BEGIN - ModificarDatosRiesgo");
		this.webDriver.switchToFrame(this.cuerpoFrame);

		// Modify Año rehabilitación de aguas comunitarias
		String AnyoRehabilitacionAguasComunitarias = this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias);
		String AnyoConstruccion = this.webDriver.getText(this.txtAnyoConstruccion);

		// if(this.tCData.getNivelRehabilitacionConduccionesAguasComunitarias()
		// != null) {
		// if(AnyoRehabilitacionAguasComunitarias.isEmpty()) {
		// this.webDriver.sendValueToWebElement(this.txtAnyoRehabilitacionAguasComunitarias,
		// String.valueOf(Integer.parseInt(AnyoConstruccion) + 1));
		// this.webDriver.selectValueInDropDown(this.cmbNivelRehabilitacionAguas,
		// this.tCData.getNivelRehabilitacionConduccionesAguasComunitarias());
		// this.tCData.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
		// }

		if(this.tCData.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias") != null) {
			if(AnyoRehabilitacionAguasComunitarias.isEmpty()) {
				this.webDriver.appendText(this.txtAnyoRehabilitacionAguasComunitarias, String.valueOf(Integer.parseInt(AnyoConstruccion) + 1));
				this.webDriver.clickElementFromDropDownByText(this.cmbNivelRehabilitacionAguas, this.tCData.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
				// this.tCData.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
				this.tCData.setTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias", this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
			}
			if(!AnyoRehabilitacionAguasComunitarias.isEmpty()) {
				// If Año rehabilitación de aguas comunitarias is already
				// present, then input Año rehabilitación de aguas comunitarias
				// + 1. Required if we
				// want to execute this test in the same week, before database
				// reset.
				this.webDriver.appendText(this.txtAnyoRehabilitacionAguasComunitarias, String.valueOf(Integer.parseInt(AnyoRehabilitacionAguasComunitarias) + 1));
				this.webDriver.clickElementFromDropDownByText(this.cmbNivelRehabilitacionAguas, this.tCData.getTestVar(testId, "NivelRehabilitacionConduccionesAguasComunitarias"));
				// this.tCData.setAnyoRehabilitacionConstruccionesComunitarias(this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));
				this.tCData.setTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias", this.webDriver.getText(this.txtAnyoRehabilitacionAguasComunitarias));

			}

		}

		String numeroEdificios = this.webDriver.getText(this.txtNumeroEdificios);
		if(!numeroEdificios.equals(this.tCData.getTestVar(testId, "CambioNumEdificios")) && this.tCData.getTestVar(testId, "CambioNumEdificios") != null) {
			this.webDriver.appendText(this.txtNumeroEdificios, this.tCData.getTestVar(testId, "CambioNumEdificios"));
		}

		String numeroViviendas = this.webDriver.getText(this.txtNoViviendas);
		if(!numeroViviendas.equals(this.tCData.getTestVar(testId, "cambio_num_viviendas")) && this.tCData.getTestVar(testId, "cambio_num_viviendas") != null) {
			this.webDriver.appendText(this.txtNoViviendas, this.tCData.getTestVar(testId, "cambio_num_viviendas"));
		}

		String numeroLocales = this.webDriver.getText(this.txtNumeroLocales);
		if(!numeroLocales.equals(this.tCData.getTestVar(testId, "cambio_num_locales")) && this.tCData.getTestVar(testId, "cambio_num_locales") != null) {
			this.webDriver.appendText(this.txtNumeroLocales, this.tCData.getTestVar(testId, "cambio_num_locales"));
		}

		String m2ContruidosTotales = this.webDriver.getText(this.txtM2ContruidosTotales);
		if(m2ContruidosTotales.equals(-1)) {
			this.webDriver.appendText(this.txtM2ContruidosTotales, String.valueOf(this.tCData.getTestVar(testId, "M2ContruidosTotales")));
		}

		String m2Viviendas = this.webDriver.getText(this.txtM2Viviendas);
		if(!m2Viviendas.equals(this.tCData.getTestVar(testId, "ModifiedM2Viviendas")) && this.tCData.getTestVar(testId, "ModifiedM2Viviendas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Viviendas, String.valueOf(this.tCData.getTestVar(testId, "ModifiedM2Viviendas")));
			this.webDriver.tabulateElement(this.txtM2Viviendas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.tCData.setTestVar(testId, "M2ContruidosTotales", this.webDriver.getText(this.txtM2ContruidosTotales));

		}

		String m2Garajes = this.webDriver.getText(this.txtM2Viviendas);
		if(!m2Garajes.equals(this.tCData.getTestVar(testId, "modifiedM2Garajes")) && this.tCData.getTestVar(testId, "modifiedM2Garajes") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Garajes, String.valueOf(this.tCData.getTestVar(testId, "modifiedM2Garajes")));
			this.webDriver.tabulateElement(this.txtM2Garajes);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		String m2Oficinas = this.webDriver.getText(this.txtM2Oficinas);
		if(!m2Oficinas.equals(this.tCData.getTestVar(testId, "ModifiedM2Oficinas")) && this.tCData.getTestVar(testId, "ModifiedM2Oficinas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2Oficinas, String.valueOf(this.tCData.getTestVar(testId, "ModifiedM2Oficinas")));
			this.webDriver.tabulateElement(this.txtM2Oficinas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		String m2ZonasAjardinadas = this.webDriver.getText(this.txtM2ZonasAjardinadas);
		if(!m2ZonasAjardinadas.equals(this.tCData.getTestVar(testId, "ModifiedM2ZonasAjardinadas")) && this.tCData.getTestVar(testId, "ModifiedM2ZonasAjardinadas") != null) {
			this.GetValuesBefore();
			// this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.appendText(this.txtM2ZonasAjardinadas, String.valueOf(this.tCData.getTestVar(testId, "ModifiedM2ZonasAjardinadas")));
			this.webDriver.tabulateElement(this.txtM2ZonasAjardinadas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
			// this.webDriver.switchToFrame(this.cuerpoFrame);
		}

		this.webDriver.exitFrame();
		// this.ModificarDatosActividadComercial();
		logger.debug("END - ModificarDatosRiesgo");

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
		logger.debug("BEGIN - GetCapitales");

		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(2000);
		this.webDriver.scrollToBottom();
		this.CapitalTotalAsegurado = this.nf.parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.CapitalContenido = this.nf.parse(this.webDriver.getText(this.txtCapitalContenido)).doubleValue();
		this.CapitalContinente = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();
		this.webDriver.exitFrame();
		logger.debug("END - GetCapitales");
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
		logger.debug("BEGIN - CheckForInfraseguro");
		this.webDriver.switchToFrame(this.cuerpoFrame);

		// Double CapitalTotalAsegurado = this.nf
		// .parse(this.webDriver.getText(this.txtCapitalContinenteTotalAsegurado))
		// .doubleValue();
		// Double CapitalContenido =
		// this.nf.parse(this.webDriver.getText(this.txtCapitalContenido))
		// .doubleValue();
		Double CapitalContiente = this.nf.parse(this.webDriver.getText(this.txtCapitalContinente)).doubleValue();

		if(CapitalContiente > this.CapitalContinente) {
			this.tCData.setTestVar(testId, "Infraseguro", "true");
		}

		if(CapitalContiente < this.CapitalContinente) {
			this.tCData.setTestVar(testId, "SupraSeguro", "true");
		}

		this.webDriver.exitFrame();
		logger.debug("END - CheckForInfraseguro");
	}

	public void clickOnContinuar() throws ParseException {
		logger.debug("BEGIN - ClikOnContinuar");
		// this.CheckForInfraseguroOrSupraSeguro();
		// this.cuerpoFrame.click();
		this.webDriver.scrollToBottom();

		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);

		//TODO - This is supposed to check that the madera and deshabitacion fields are mandatory, but currently gives a NULL pointer exception.  Perhaps is should be moved out of ClikOnContinuar.
		/*if(this.tCData.getTestVar(testId, "edificio_madera").equals("") && this.tCData.getTestVar(testId, "deshabitacion").equals("")) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.click(this.btnCamposObligatiosModalWindowAceptar);

			String color1 = this.webDriver.getElement(cmbDeshabilitacion).getCssValue("border-color");
			String color2 = this.webDriver.getElement(cmbEdificioMadera).getCssValue("border-color");

			Assert.assertTrue("El campo deshabilitación no tiene un borde rojo", color1.equals("rgb(169, 68, 66)"));
			Assert.assertTrue("El campo edificio madera no tiene un borde rojo", color2.equals("rgb(169, 68, 66)"));
			this.webDriver.exitFrame();
		}*/

		this.webDriver.scrollToBottom();
		logger.debug("END - ClikOnContinuar");
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
					// this.tCData.setCantidadesModifiedError(true);
					this.tCData.setTestVar(testId, "cantidadesModifiedError", "true");
					// this.tCData.setCantidadesModifiedErrorMessage(
					// String.format("El valor de las cantiadaes no ha variado
					// en la pantalla de detalles de riesgo despues de %s",
					// Modification));
					this.tCData.setTestVar(testId, "cantidadesModifiedErrorMessage", "El valor de las cantiadaes no ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);

				}
				break;

			case ProjectConstants.Equal:
				if(this.CapitalContenidoBefore != this.CapitalContenidoAfter || this.CapitalContinenteBefore != this.CapitalContienteAfter
					|| this.CapitalTotalAseguradoBefore != this.CapitalTotalAseguradoAfter) {
					// this.tCData.setCantidadesModifiedError(true);
					// this.tCData.setCantidadesModifiedErrorMessage(
					// String.format("El valor de las cantidades ha variado en
					// la pantalla de detalles de riesgo despues de %s",
					// modification));
					this.tCData.setTestVar(testId, "cantidadesModifiedError", "true");
					this.tCData.setTestVar(testId, "cantidadesModifiedErrorMessage", "El valor de las cantiadaes ha variado en la pantalla "
						+ "de detalles de riesgo despues de ," + modification);

				}
				break;
		}

	}

	public void CheckAvisoGarajes() {
		logger.debug("BEGIN - CheckAvisoGarajes");
		// if (this.tCData.isAsegurarUnicamenteGarajes())
		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "AsegurarUnicamenteGarajes"))) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			if(this.lblAvisoGarajes.size() != 1) {
				// this.tCData.setAvisoGarajesMsgNotPressent(true);
				this.tCData.setTestVar(testId, "AsegurarUnicamenteGarajes", "true");
				this.webDriver.exitFrame();
			}
			this.webDriver.click(this.btnAceptar);
			this.webDriver.exitFrame();
		}
		logger.debug("END - CheckAvisoGarajes");
	}

	public void CheckAvisoGarajesWithException() {
		// if (this.tCData.isAsegurarUnicamenteGarajes())
		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "AsegurarUnicamenteGarajes"))) {
			if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "AvisoGarajesMsgNotPressent"))) {
				Assert.assertTrue(ProjectConstants.AvisoGarajesErrorMessage, !Boolean.parseBoolean(this.tCData.getTestVar(testId, "isAvisoGarajesMsgNotPressent")));
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
