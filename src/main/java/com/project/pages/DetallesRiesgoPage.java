package com.project.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class DetallesRiesgoPage
{
	final static Logger logger = LoggerFactory.getLogger(DetallesRiesgoPage.class);
	BrowserContext browserContext;
	TestCaseData tData;
	private WebElementHelper wh;
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
	@FindBy(id = "mainFrame")
	private WebElement cuerpoFrame;
	
	@FindBy(id = "edifConstruccionMadera")
	private WebElement cmbEdificioMadera;
	
	@FindBy(id = "deshabilitacion")
	private WebElement cmbDeshabilitacion;
	
	@FindBy(xpath = ".//*[contains(text(),'Continuar')]")
	private WebElement btnContinuar;
	
	@FindBy(name = "m2Viviendas")
	private WebElement txtM2Viviendas;
	
	@FindBy(id = "m2Oficinas")
	private WebElement txtM2Oficinas;
	
	@FindBy(id = "m2Garajes")
	private WebElement txtM2Garajes;
	
	@FindBy(id = "m2ZonasAjardinadas")
	private WebElement txtM2ZonasAjardinadas;
	
	@FindBy(name = "numViviendas")
	private WebElement txtNoViviendas;
	
	@FindBy(name = "numPlantasAlto")
	private WebElement txtNumeroPlantasAlto;
	
	@FindBy(name = "numPlantasSotano")
	private WebElement txtNumeroPlantasSotano;
	
	@FindBy(id = "numEdificios")
	private WebElement txtNumeroEdificios;
	
	@FindBy(name = "numLocales")
	private WebElement txtNumeroLocales;
	
	@FindBy(id = "anyoConstruccion")
	private WebElement txtAnyoConstruccion;
	
	@FindBy(xpath = ".//*[text()='Añadir actividad comercial']")
	private WebElement btnAnadirActividadComercial;
	
	@FindBy(xpath = ".//*[text()='Añadir']")
	private WebElement btnAnadir;
	
	@FindBy(xpath = ".//*[@ng-model='actividad.descripcion']")
	private WebElement txtActividadDescripcion;
	
	@FindBy(xpath = ".//*[@ng-model='actividad.m2']")
	private WebElement txtActividadM2;
	
	@FindBy(xpath = ".//*[@ng-model='actividad.porcentaje']")
	private WebElement txtActividadPorcentaje;
	
	@FindBy(xpath = ".//*[@ng-model='dr.moduloDetallesRiesgo.m2locales']")
	private WebElement txtM2Locales;
	
	@FindBy(xpath = ".//*[text()='Guardar' and @ng-disabled='formActividadesComerciales.$invalid']")
	private WebElement btnGuardarActividadesComerciales;
	
	@FindBy(id = "capitalContinenteTotalAsegurado")
	private WebElement txtCapitalContinenteTotalAsegurado;
	
	@FindBy(id = "capitalContenido")
	private WebElement txtCapitalContenido;
	
	@FindBy(id = "capitalContinente")
	private WebElement txtCapitalContinente;
	
	@FindBy(xpath = ".//*[text()='No se han rellenado los campos obligatorios.']/../../../..//button[text()='Aceptar']")
	private WebElement btnCamposObligatiosModalWindowAceptar;
	
	@FindBy(id = "edifGasolineraMenos50m")
	private WebElement chkGasolineraMenos50M;
	
	@FindBy(id = "edifCalefaccionCentral")
	private WebElement chkCalefaccionCentralAguaCalienteCentralizada;
	
	@FindBy(id = "edifDepositoCombustible")
	private WebElement chkDepositoCombustible;
	
	@FindBy(id = "anyoRehabAguasCom")
	private WebElement txtAnyoRehabilitacionAguasComunitarias;
	
	@FindBy(id = "nivelRehabAguasCom")
	private WebElement cmbNivelRehabilitacionAguas;
	
	@FindBy(id = "anyoRehabIntegral")
	private WebElement txtAnyoRehabilitacionIntegral;
	
	@FindBy(id = "m2ConstruidosTotales")
	private WebElement txtM2ContruidosTotales;
	
	@FindBy(xpath = ".//*[text()='Los datos de superficies (m']")
	private List<WebElement> lblAvisoGarajes;
	
	@FindBy(xpath = ".//*[@id='modalErrores']//*[text()='Aceptar']")
	private WebElement btnAceptar;
	
	@FindBy(id = "m2Trasteros")
	private WebElement txtM2Trasteros;
	
	@FindBy(id = "numPlantasSotano")
	private WebElement txtNumPlantasBajoRasante;
	
	@FindBy(id = "numPlazasGarajes")
	private WebElement txtNumPlazasGaraje;
	
	// endregion
	
	public DetallesRiesgoPage(BrowserContext browserContext) throws Exception
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
		// this.ExecuteActionsInPageDetallesRiesgoPage();
	}
	
	// region methods
	public void executeActionsInPageDetallesRiesgoPage() throws Exception
	{
		logger.debug("BEGIN - ExecuteActionsInPageDetallesRiesgoPage");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
		this.ClikOnContinuar();
		logger.debug("END - ExecuteActionsInPageDetallesRiesgoPage");
	}
	
	public void completarDatosEnDetallesRiesgo() throws Exception
	{
		logger.debug("BEGIN - completarDatosEnDetallesRiesgo");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ClikOnContinuar();
		logger.debug("END - completarDatosEnDetallesRiesgo");
	}

	public void modificarDatosEnDetallesRiesgo() throws Exception
	{
		logger.debug("BEGIN - modificarDatosEnDetallesRiesgo");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		this.ClikOnContinuar();
		logger.debug("END - modificarDatosEnDetallesRiesgo");
	}
	
	public void ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue() throws Exception
	{
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		this.ModificarDatosRiesgo();
	}
	
	public void completarDatosEnDetallesRiesgoSinContinuar() throws Exception
	{
		logger.debug("BEGIN - completarDatosEnDetallesRiesgoSinContinuar");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.completarDatosRiesgo();
		logger.debug("END - completarDatosEnDetallesRiesgoSinContinuar");
	}

	public void modificarDatosEnDetallesRiesgoSinContinuar() throws Exception
	{
		logger.debug("BEGIN - modificarDatosEnDetallesRiesgoSinContinuar");
		this.CheckAvisoGarajes();
		this.GetCapitales();
		this.ModificarDatosRiesgo();
		logger.debug("END - modificarDatosEnDetallesRiesgoSinContinuar");
	}

	// This function modifies the values of the fields located in the page. All the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data.
	public String completarDatosRiesgoMinimos() throws Exception
	{
		logger.debug("BEGIN - completarDatosRiesgoMinimos");
		String value = "";
		this.wh.switchToFrame(this.cuerpoFrame);
		String edificioMadera = this.wh.getTextFromSelect(this.cmbEdificioMadera);
		if (!edificioMadera.equals(this.tData.getEdificioMadera()) && !this.tData.getEdificioMadera().equals(""))
		{
			this.wh.selectValueInDropDown(this.cmbEdificioMadera, this.tData.getEdificioMadera());
		}
		else if (this.tData.getEdificioMadera().equals("") && !edificioMadera.equals(""))
		{
			throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página");
		}
		
		String deshabilitacion = this.wh.getTextFromSelect(this.cmbDeshabilitacion);
		if (!deshabilitacion.equals(this.tData.getDeshabilitacion()) && !this.tData.getDeshabilitacion().equals(""))
		{
			this.wh.selectValueInDropDown(this.cmbDeshabilitacion, this.tData.getDeshabilitacion());
		}
		else if (this.tData.getDeshabilitacion().equals("") && !deshabilitacion.equals(""))
		{
			throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página");
		}
		
		value = this.wh.getTextFromWebElement(this.txtAnyoConstruccion);
		this.wh.exitFromFrame();

		logger.debug("END - completarDatosRiesgoMinimos");
		return value;
	}
	
	public String getCapitalContinente() throws Exception
	{
		logger.debug("GET - getCapitalContinente");
		this.wh.scrollToEndOfPage();
		return this.wh.getTextFromWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
	}
	
	public String getCapitalContenido() throws Exception
	{
		logger.debug("GET - getCapitalContenido");
		this.wh.scrollToEndOfPage();
		return this.wh.getTextFromWebElementInFrame(this.txtCapitalContenido, this.cuerpoFrame);
	}
	
	public String getCapitalContinenteTotalAsegurado() throws Exception
	{
		logger.debug("GET - getCapitalContinenteTotalAsegurado");
		this.wh.scrollToEndOfPage();
		return this.wh.getTextFromWebElementInFrame(this.txtCapitalContinenteTotalAsegurado, this.cuerpoFrame);
	}
	
	public void completarDatosRiesgo() throws Exception
	{
		logger.debug("BEGIN - CompletarDatosRiesgo");
		// this.wh.switchToFrame(this.cuerpoFrame);

		if (this.tData.getCapitalContinente() != null)
		{
			if (this.tData.isCapitalContinenteVariacion())
			{
				Double capitalContinenteModified = this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame))
						.doubleValue() + this.tData.getCapitalContinente().doubleValue();
				this.wh.sendValueToWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(capitalContinenteModified));
				this.wh.changeFocusOfWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				this.tData.setCapitalContinente(capitalContinenteModified);

			}
			else
			{
				this.wh.sendValueToWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame, String.valueOf(this.tData.getCapitalContinente()));
				this.wh.changeFocusOfWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame);
				this.tData.setCapitalContinente(this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame)));
			}
		}

		if (this.tData.getCapitalContenido() != null)
		{
			Double capitalContenidoModified = this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContenido, this.cuerpoFrame)).doubleValue()
					+ this.tData.getCapitalContenido().doubleValue();

			this.wh.sendValueToWebElementInFrame(this.txtCapitalContenido, this.cuerpoFrame, this.nf.format(capitalContenidoModified).toString());
			this.wh.changeFocusOfWebElementInFrame(this.txtCapitalContenido, this.cuerpoFrame);
			this.tData.setCapitalContenido(capitalContenidoModified);
		}

		String edificioMadera = this.wh.getTextFromSelectInFrame(this.cmbEdificioMadera, this.cuerpoFrame);
		if (!edificioMadera.equals(this.tData.getEdificioMadera()) && !this.tData.getEdificioMadera().equals(""))
		{
			this.wh.selectValueInDropDownInFrame(this.cmbEdificioMadera, this.cuerpoFrame, this.tData.getEdificioMadera());
		}
		else if (this.tData.getEdificioMadera().equals("") && !edificioMadera.equals(""))
		{
			throw new Exception("El valor del campo porcentaje edificio madera no es blanco al entrar en la página");
		}

		String deshabilitacion = this.wh.getTextFromSelectInFrame(this.cmbDeshabilitacion, this.cuerpoFrame);
		if (!deshabilitacion.equals(this.tData.getDeshabilitacion()) && !this.tData.getDeshabilitacion().equals(""))
		{
			this.wh.selectValueInDropDownInFrame(this.cmbDeshabilitacion, this.cuerpoFrame, this.tData.getDeshabilitacion());
		}
		else if (this.tData.getDeshabilitacion().equals("") && !deshabilitacion.equals(""))
		{
			throw new Exception("El valor del campo deshabilitación no es blanco al entrar en la página");
		}

		String m2ContruidosTotales = this.wh.getTextFromWebElementInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame);
		if (m2ContruidosTotales.equals(-1))
		{
			this.wh.sendValueToWebElementInFrame(this.txtM2ContruidosTotales, this.cuerpoFrame, String.valueOf(this.tData.getM2ContruidosTotales()));
		}

		String AnyoConstruccion = this.wh.getTextFromWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame);

		if (this.tData.getAnyoConstruccion() != null && this.tData.getAnyoConstruccion().equals(ProjectConstants.MayorDe50))
		{
			DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
			DateTime dateTime = DateTime.now(timeZone);
			int year = dateTime.year().get();

			this.wh.sendValueToWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(year - 51));
		}
		// else if (!AnyoConstruccion.equals(this.tData.getAnyoConstruccion()) && !this.tData.getAnyoConstruccion().equals("-1"))
		else if (this.tData.getAnyoConstruccion() != null && !AnyoConstruccion.equals(this.tData.getAnyoConstruccion()))
		{
			this.wh.sendValueToWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(this.tData.getAnyoConstruccion()));
		}

		// String AnyoRehabilitacionAguasComunitarias = this.wh.getTextFromWebElementInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias,
		// this.cuerpoFrame);
		// if (!AnyoRehabilitacionAguasComunitarias.equals(String.valueOf(this.tData.getAnyoRehabilitacionConstruccionesComunitarias()))
		// && this.tData.getAnyoRehabilitacionConstruccionesComunitarias() != null)
		// {
		// this.wh.sendValueToWebElementInFrame(this.txtAnyoRehabilitacionConstruccionesComunitarias, this.cuerpoFrame,
		// String.valueOf(this.tData.getAnyoRehabilitacionConstruccionesComunitarias()));
		// }

		String AnyoRehabilitacionAguasComunitarias = this.wh.getTextFromWebElementInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame);
		if (AnyoRehabilitacionAguasComunitarias.equals(String.valueOf(this.wh.getTextFromWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame)))
				&& this.tData.getNivelRehabilitacionConduccionesAguasComunitarias() != null)
		{
			int year = Integer.parseInt(this.wh.getTextFromWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame));
			this.wh.sendValueToWebElementInFrame(this.txtAnyoRehabilitacionAguasComunitarias, this.cuerpoFrame, String.valueOf(year + 1));
			this.wh.selectValueInDropDownInFrame(this.cmbNivelRehabilitacionAguas, this.cuerpoFrame,
					this.tData.getNivelRehabilitacionConduccionesAguasComunitarias());
		}

		// String NivelDeshabilitacionConstruccionesComunitarias = this.wh.getTextFromSelectInFrame(this.cmbNivelRehabilitacionAguas, this.cuerpoFrame);
		// if (NivelDeshabilitacionConstruccionesComunitarias != null)
		// {
		// this.wh.selectValueInDropDownInFrame(this.cmbNivelRehabilitacionAguas, this.cuerpoFrame,
		// this.tData.getNivelRehabilitacionConduccionesAguasComunitarias());
		// }

		String AnyoRehabilitacionIntegral = String.valueOf(this.tData.getAnyoRehabilitacionIntegral());
		if (AnyoRehabilitacionIntegral != null && !AnyoRehabilitacionIntegral.equals("null"))
		{
			this.wh.sendValueToWebElementInFrame(this.txtAnyoRehabilitacionIntegral, this.cuerpoFrame, AnyoRehabilitacionIntegral);
		}

		String m2Viviendas = this.wh.getTextFromWebElementInFrame(this.txtM2Viviendas, this.cuerpoFrame);
		// if (!m2Viviendas.equals(this.tData.getM2Vivienda()) && !this.tData.getM2Vivienda().equals(-1))
		if (this.tData.getM2Vivienda() != null && !m2Viviendas.equals(this.tData.getM2Vivienda()))
		{
			this.GetCapitales();

			this.GetValuesBefore();

			this.wh.sendValueToWebElementInFrame(this.txtM2Viviendas, this.cuerpoFrame, String.valueOf(this.tData.getM2Vivienda()));
			this.wh.changeFocusOfWebElementInFrame(this.txtM2Viviendas, this.cuerpoFrame);

			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
		}

		String m2Garajes = this.wh.getTextFromWebElementInFrame(this.txtM2Garajes, this.cuerpoFrame);
		if (!m2Garajes.equals(this.tData.getM2Garajes()) && this.tData.getM2Garajes() != null)
		{
			this.GetValuesBefore();
			this.wh.sendValueToWebElementInFrame(this.txtM2Garajes, this.cuerpoFrame, String.valueOf(this.tData.getM2Garajes()));
			this.wh.changeFocusOfWebElementInFrame(this.txtM2Garajes, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 garajes");
		}

		String m2Oficinas = this.wh.getTextFromWebElementInFrame(this.txtM2Oficinas, this.cuerpoFrame);
		if (!m2Oficinas.equals(this.tData.getM2Oficinas()) && this.tData.getM2Oficinas() != null)
		{
			this.GetValuesBefore();
			this.wh.sendValueToWebElementInFrame(this.txtM2Oficinas, this.cuerpoFrame, String.valueOf(this.tData.getM2Oficinas()));
			this.wh.changeFocusOfWebElementInFrame(this.txtM2Oficinas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
		}

		String m2ZonasAjardinadas = this.wh.getTextFromWebElementInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
		if (!m2ZonasAjardinadas.equals(this.tData.getM2ZonasAjardinadas()) && this.tData.getM2ZonasAjardinadas() != null)
		{

			this.wh.sendValueToWebElementInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame, String.valueOf(this.tData.getM2ZonasAjardinadas()));
			this.wh.changeFocusOfWebElementInFrame(this.txtM2ZonasAjardinadas, this.cuerpoFrame);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
		}

		String numeroViviendas = this.wh.getTextFromWebElementInFrame(this.txtNoViviendas, this.cuerpoFrame);
		if (this.tData.getNumeroViviendas() != null && !numeroViviendas.equals(this.tData.getNumeroViviendas()))
		{
			this.wh.sendValueToWebElementInFrame(this.txtNoViviendas, this.cuerpoFrame, this.tData.getNumeroViviendas());
		}

		String numeroPlantasALto = this.wh.getTextFromWebElementInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame);
		if (!numeroPlantasALto.equals(this.tData.getNumeroPlantasAlto()) && this.tData.getNumeroPlantasAlto() != null)
		{
			this.wh.sendValueToWebElementInFrame(this.txtNumeroPlantasAlto, this.cuerpoFrame, String.valueOf(this.tData.getNumeroPlantasAlto()));
		}

		String numeroPlantasSotano = this.wh.getTextFromWebElementInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame);
		if (!numeroPlantasSotano.equals(this.tData.getNumeroPlantasSotano()) && this.tData.getNumeroPlantasSotano() != null)
		{
			// this.wh.sendValueToWebElementInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame, String.valueOf(this.tData.getNumeroPlantasSotano()));
			this.wh.sendValueToWebElementInFrame(this.txtNumeroPlantasSotano, this.cuerpoFrame, this.tData.getNumeroPlantasSotano());
		}

		String numeroEdificios = this.wh.getTextFromWebElementInFrame(this.txtNumeroEdificios, this.cuerpoFrame);
		if (!numeroEdificios.equals(this.tData.getNumeroEdificios()) && this.tData.getNumeroEdificios() != null)
		{
			this.wh.sendValueToWebElementInFrame(this.txtNumeroEdificios, this.cuerpoFrame, this.tData.getNumeroEdificios());
		}

		boolean GasolineraMenos50M = this.browserContext.getTestCaseData().isGasolineraMenos50M();
		if (GasolineraMenos50M)
		{
			this.wh.clickOnWebElementInFrame(this.chkGasolineraMenos50M, this.cuerpoFrame);
		}

		boolean CalefaccionCentral = this.tData.isCalefaccionCentral();
		if (CalefaccionCentral && !this.chkCalefaccionCentralAguaCalienteCentralizada.isSelected())
		{
			this.wh.clickOnWebElementInFrame(this.chkCalefaccionCentralAguaCalienteCentralizada, this.cuerpoFrame);
		}

		boolean DepositoCombustible = this.tData.isDepositoCombustible();
		if (DepositoCombustible)
		{
			this.wh.clickOnWebElementInFrame(this.chkDepositoCombustible, this.cuerpoFrame);
		}

		// this.wh.exitFromFrame();
		// this.ModificarDatosActividadComercial();

		logger.debug("END - CompletarDatosRiesgo");
	}
	
	// This function modifies the values of the fields located in the page. All the values are
	// modified if they are different than the ones pressent
	// in the object TestCasse Data inside the values whose variables start with Modified.
	public void ModificarDatosRiesgo() throws ParseException
	{
		logger.debug("BEGIN - ModificarDatosRiesgo");
		this.wh.switchToFrame(this.cuerpoFrame);
		
		// Modify Año rehabilitación de aguas comunitarias
		String AnyoRehabilitacionAguasComunitarias = this.wh.getTextFromWebElement(this.txtAnyoRehabilitacionAguasComunitarias);
		String AnyoConstruccion = this.wh.getTextFromWebElement(this.txtAnyoConstruccion);
		
		if (this.tData.getNivelRehabilitacionConduccionesAguasComunitarias() != null)
		{
			if (AnyoRehabilitacionAguasComunitarias.isEmpty())
			{
				this.wh.sendValueToWebElement(this.txtAnyoRehabilitacionAguasComunitarias, String.valueOf(Integer.parseInt(AnyoConstruccion) + 1));
				this.wh.selectValueInDropDown(this.cmbNivelRehabilitacionAguas, this.tData.getNivelRehabilitacionConduccionesAguasComunitarias());
				this.tData.setAnyoRehabilitacionConstruccionesComunitarias(this.wh.getTextFromWebElement(this.txtAnyoRehabilitacionAguasComunitarias));
			}
			
			if (!AnyoRehabilitacionAguasComunitarias.isEmpty())
			{
				// If Año rehabilitación de aguas comunitarias is already present, then input Año rehabilitación de aguas comunitarias + 1. Required if we
				// want to execute this test in the same week, before database reset.
				this.wh.sendValueToWebElement(this.txtAnyoRehabilitacionAguasComunitarias,
						String.valueOf(Integer.parseInt(AnyoRehabilitacionAguasComunitarias) + 1));
				this.wh.selectValueInDropDown(this.cmbNivelRehabilitacionAguas, this.tData.getNivelRehabilitacionConduccionesAguasComunitarias());
				this.tData.setAnyoRehabilitacionConstruccionesComunitarias(this.wh.getTextFromWebElement(this.txtAnyoRehabilitacionAguasComunitarias));
			}
			
		}
		
		String numeroEdificios = this.wh.getTextFromWebElement(this.txtNumeroEdificios);
		if (!numeroEdificios.equals(this.tData.getCambioNumEdificios()) && this.tData.getCambioNumEdificios() != null)
		{
			this.wh.sendValueToWebElement(this.txtNumeroEdificios, this.tData.getCambioNumEdificios());
		}
		
		String numeroViviendas = this.wh.getTextFromWebElement(this.txtNoViviendas);
		if (!numeroViviendas.equals(this.tData.getCambioNumViviendas()) && this.tData.getCambioNumViviendas() != null)
		{
			this.wh.sendValueToWebElement(this.txtNoViviendas, this.tData.getCambioNumViviendas());
		}
		
		String numeroLocales = this.wh.getTextFromWebElement(this.txtNumeroLocales);
		if (!numeroLocales.equals(this.tData.getCambioNumLocalesComerciales()) && this.tData.getCambioNumLocalesComerciales() != null)
		{
			this.wh.sendValueToWebElement(this.txtNumeroLocales, this.tData.getCambioNumLocalesComerciales());
		}
		
		String m2ContruidosTotales = this.wh.getTextFromWebElement(this.txtM2ContruidosTotales);
		if (m2ContruidosTotales.equals(-1))
		{
			this.wh.sendValueToWebElement(this.txtM2ContruidosTotales, String.valueOf(this.tData.getM2ContruidosTotales()));
		}
		
		String m2Viviendas = this.wh.getTextFromWebElement(this.txtM2Viviendas);
		if (!m2Viviendas.equals(this.tData.getModifiedM2Viviendas()) && this.tData.getModifiedM2Viviendas() != null)
		{
			this.GetValuesBefore();
			// this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.sendValueToWebElement(this.txtM2Viviendas, String.valueOf(this.tData.getModifiedM2Viviendas()));
			this.wh.changeFocusOfWebElement(this.txtM2Viviendas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.wh.switchToFrame(this.cuerpoFrame);
			this.tData.setM2ContruidosTotales(this.nf.parse(this.wh.getTextFromWebElement(this.txtM2ContruidosTotales)).intValue());
		}
		
		String m2Garajes = this.wh.getTextFromWebElement(this.txtM2Viviendas);
		if (!m2Garajes.equals(this.tData.getModifiedM2Garajes()) && this.tData.getModifiedM2Garajes() != null)
		{
			this.GetValuesBefore();
			// this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.sendValueToWebElement(this.txtM2Garajes, String.valueOf(this.tData.getModifiedM2Garajes()));
			this.wh.changeFocusOfWebElement(this.txtM2Garajes);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 viviendas");
			// this.wh.switchToFrame(this.cuerpoFrame);
		}
		
		String m2Oficinas = this.wh.getTextFromWebElement(this.txtM2Oficinas);
		if (!m2Oficinas.equals(this.tData.getModifiedM2Oficinas()) && this.tData.getModifiedM2Oficinas() != null)
		{
			this.GetValuesBefore();
			// this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.sendValueToWebElement(this.txtM2Oficinas, String.valueOf(this.tData.getModifiedM2Oficinas()));
			this.wh.changeFocusOfWebElement(this.txtM2Oficinas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 oficinas");
			// this.wh.switchToFrame(this.cuerpoFrame);
		}
		
		String m2ZonasAjardinadas = this.wh.getTextFromWebElement(this.txtM2ZonasAjardinadas);
		if (!m2ZonasAjardinadas.equals(this.tData.getModifiedM2ZonasAjardinadas()) && this.tData.getModifiedM2ZonasAjardinadas() != null)
		{
			this.GetValuesBefore();
			// this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.sendValueToWebElement(this.txtM2ZonasAjardinadas, String.valueOf(this.tData.getModifiedM2ZonasAjardinadas()));
			this.wh.changeFocusOfWebElement(this.txtM2ZonasAjardinadas);
			this.GetValuesAfter();
			this.CompareValues(ProjectConstants.NotEqual, " variar el valor de m2 zonas ajardinadas");
			// this.wh.switchToFrame(this.cuerpoFrame);
		}
		
		this.wh.exitFromFrame();
		// this.ModificarDatosActividadComercial();
		logger.debug("END - ModificarDatosRiesgo");
		
	}
	
	// private void ModificarDatosActividadComercial()
	// {
	// logger.debug("BEGIN - ModificarDatosActividadComercial");
	//
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// String m2ActividadComercial = this.wh.GetTextFromWebElement(this.txtM2Locales);
	// if (Integer.valueOf(m2ActividadComercial.replace(".", "")) > 0)
	// {
	// this.wh.ClickOnWebElement(this.btnAnadirActividadComercial);
	// this.wh.ClickOnWebElement(this.btnAnadir);
	// this.wh.SendValueToWebElement(this.txtActividadDescripcion,
	// MutuaPropietariosConstants.ActividadComercialDescripcion);
	// this.wh.SendValueToWebElement(this.txtActividadPorcentaje,
	// MutuaPropietariosConstants.ActividadComercialOPorcentaje);
	// this.wh.SendValueToWebElement(this.txtActividadM2, m2ActividadComercial);
	// this.wh.ClickOnWebElement(this.btnGuardarActividadesComerciales);
	// }
	// this.wh.ExitFromFrame();
	// logger.debug("END - ModificarDatosActividadComercial");
	// }
	
	private void GetCapitales() throws ParseException
	{
		logger.debug("BEGIN - GetCapitales");
		// this.wh.switchToFrame(this.cuerpoFrame);
		// this.wh.scrollToEndOfPage();
		this.CapitalTotalAsegurado = this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContinenteTotalAsegurado, this.cuerpoFrame))
				.doubleValue();
		this.CapitalContenido = this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContenido, this.cuerpoFrame)).doubleValue();
		this.CapitalContinente = this.nf.parse(this.wh.getTextFromWebElementInFrame(this.txtCapitalContinente, this.cuerpoFrame)).doubleValue();
		// this.wh.exitFromFrame();
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
	// this.nf.parse(this.wh.GetTextFromWebElement(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
	// Double CapitalContenidoTemp =
	// this.nf.parse(this.wh.GetTextFromWebElement(this.txtCapitalContenido)).doubleValue();
	// Double CapitalContinenteTemp =
	// this.nf.parse(this.wh.GetTextFromWebElement(this.txtCapitalContinente)).doubleValue();
	//
	// logger.debug("END - IsCapitalesVaried");
	//
	// if (CapitalTotalAseguradoSavedValue == CapitalTotalAseguradoTemp && CapitalContenidoSavedValue
	// == CapitalContenidoTemp
	// && CapitalContinenteSavedValue == CapitalContinenteTemp)
	// {
	// return true;
	// }
	// return false;
	// }
	
	private void CheckForInfraseguroOrSupraSeguro() throws ParseException
	{
		logger.debug("BEGIN - CheckForInfraseguro");
		this.wh.switchToFrame(this.cuerpoFrame);
		
		// Double CapitalTotalAsegurado = this.nf
		// .parse(this.wh.GetTextFromWebElement(this.txtCapitalContinenteTotalAsegurado))
		// .doubleValue();
		// Double CapitalContenido =
		// this.nf.parse(this.wh.GetTextFromWebElement(this.txtCapitalContenido))
		// .doubleValue();
		Double CapitalContiente = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContinente)).doubleValue();
		
		if (CapitalContiente > this.CapitalContinente)
		{
			this.tData.setInfraseguro(true);
		}
		
		if (CapitalContiente < this.CapitalContinente)
		{
			this.tData.setSupraSeguro(true);
		}
		
		this.wh.exitFromFrame();
		logger.debug("END - CheckForInfraseguro");
	}
	
	public void ClikOnContinuar() throws ParseException
	{
		logger.debug("BEGIN - ClikOnContinuar");
		// this.CheckForInfraseguroOrSupraSeguro();
		// this.cuerpoFrame.click();
		this.wh.scrollToEndOfPage();
		
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		
		if (this.tData.getEdificioMadera().equals("") && this.tData.getDeshabilitacion().equals(""))
		{
			this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.clickOnWebElement(this.btnCamposObligatiosModalWindowAceptar);
			
			Assert.assertTrue("El campo deshabilitación no tiene un borde rojo", this.wh.checkFieldHasRedBorder(this.cmbDeshabilitacion));
			Assert.assertTrue("El campo edificio madera no tiene un borde rojo", this.wh.checkFieldHasRedBorder(this.cmbEdificioMadera));
			this.wh.exitFromFrame();
		}
		
		this.wh.scrollToEndOfPage();
		logger.debug("END - ClikOnContinuar");
	}
	
	public void GetValuesBefore() throws ParseException
	{
		this.wh.exitFromFrame();
		this.wh.switchToFrame(this.cuerpoFrame);
		this.CapitalContenidoBefore = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContenido)).doubleValue();
		this.CapitalContinenteBefore = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContinente)).doubleValue();
		this.CapitalTotalAseguradoBefore = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.wh.exitFromFrame();
	}
	
	public void GetValuesAfter() throws ParseException
	{
		this.wh.exitFromFrame();
		this.wh.switchToFrame(this.cuerpoFrame);
		this.CapitalContenidoAfter = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContenido)).doubleValue();
		this.CapitalContienteAfter = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContinente)).doubleValue();
		this.CapitalTotalAseguradoAfter = this.nf.parse(this.wh.getTextFromWebElement(this.txtCapitalContinenteTotalAsegurado)).doubleValue();
		this.wh.exitFromFrame();
	}
	
	public void CompareValues(
			String ComparisonType, String Modification)
	{
		
		switch (ComparisonType)
		{
			case ProjectConstants.NotEqual:
				if (this.CapitalContenidoBefore == this.CapitalContenidoAfter || this.CapitalContinenteBefore == this.CapitalContienteAfter
						|| this.CapitalTotalAseguradoBefore == this.CapitalTotalAseguradoAfter)
				{
					this.tData.setCantidadesModifiedError(true);
					this.tData.setCantidadesModifiedErrorMessage(
							String.format("El valor de las cantiadaes no ha variado en la pantalla de detalles de riesgo despues de %s", Modification));
				}
				break;
			
			case ProjectConstants.Equal:
				if (this.CapitalContenidoBefore != this.CapitalContenidoAfter || this.CapitalContinenteBefore != this.CapitalContienteAfter
						|| this.CapitalTotalAseguradoBefore != this.CapitalTotalAseguradoAfter)
				{
					this.tData.setCantidadesModifiedError(true);
					this.tData.setCantidadesModifiedErrorMessage(
							String.format("El valor de las cantidades ha variado en la pantalla de detalles de riesgo despues de %s", Modification));
				}
				break;
		}
		
	}
	
	public void CheckAvisoGarajes()
	{
		logger.debug("BEGIN - CheckAvisoGarajes");
		if (this.tData.isAsegurarUnicamenteGarajes())
		{
			this.wh.switchToFrame(this.cuerpoFrame);
			if (this.lblAvisoGarajes.size() != 1)
			{
				this.tData.setAvisoGarajesMsgNotPressent(true);
				this.wh.exitFromFrame();
			}
			this.wh.clickOnWebElement(this.btnAceptar);
			this.wh.exitFromFrame();
		}
		logger.debug("END - CheckAvisoGarajes");
	}
	
	public void CheckAvisoGarajesWithException()
	{
		if (this.tData.isAsegurarUnicamenteGarajes())
		{
			if (this.tData.isAvisoGarajesMsgNotPressent())
			{
				Assert.assertTrue(ProjectConstants.AvisoGarajesErrorMessage, !this.tData.isAvisoGarajesMsgNotPressent());
			}
		}
	}
	
	public boolean IsFieldEnabled(
			String fieldName)
	{
		this.wh.switchToFrame(this.cuerpoFrame);
		switch (fieldName)
		{
			case "M2 Trasteros":
				if (this.txtM2Trasteros.isEnabled())
				{
					this.wh.exitFromFrame();
					return true;
				}
				break;
			
			case "No plantas bajo rasante":
				if (this.txtNumeroPlantasSotano.isEnabled())
				{
					this.wh.exitFromFrame();
					return true;
				}
				break;
			
			case "No plantas en alto":
				if (this.txtNumeroPlantasAlto.isEnabled())
				{
					this.wh.exitFromFrame();
					return true;
				}
				break;
			
			case "M2 Garajes":
				if (this.txtM2Garajes.isDisplayed())
				{
					this.wh.exitFromFrame();
					return true;
				}
				break;
			
			case "No Plazas de garaje":
				if (this.txtNumPlazasGaraje.isDisplayed())
				{
					this.wh.exitFromFrame();
					return true;
				}
				break;
			
			default:
				this.wh.exitFromFrame();
				return false;
		}
		this.wh.exitFromFrame();
		return false;
	}
	
	public void enterAnyoConstruccionMoreThan50() throws ParseException
	{
		DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
		DateTime dateTime = DateTime.now(timeZone);
		int year = dateTime.year().get();
		this.wh.sendValueToWebElementInFrame(this.txtAnyoConstruccion, this.cuerpoFrame, String.valueOf(year - 51));
	}
	
	// endregion
}
