package com.amaris.project.pages;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import com.amaris.project.ProjectConstants;

public class TomadorYAseguradoPage_MAC extends PageObject {

	public TomadorYAseguradoPage_MAC(UserStory userS) {
		super(userS);
	}

	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement mainFrame;
	private By mainFrame = By.cssSelector("#mainFrame");
	//
	// // DATOS TOMADOR
	// @FindBy(xpath = ".//*[text()='Tomador']")
	// private WebElement btnTomador;
	//
	// @FindBy(xpath = "//*[@id='TOMADOR_TIPOTOMASEG_CONF']")
	// private WebElement drpDwnAlta;
	private By drpDwnAlta = By.cssSelector("#TOMADOR_TIPOTOMASEG_CONF");
	//
	// @FindBy(xpath = "//*[@id='TOMADOR_TIPOPERSONA_CONF']")
	// private WebElement drpDwnTipoPersona;
	private By drpDwnTipoPersona = By.cssSelector("#TOMADOR_TIPOPERSONA_CONF");
	//
	// @FindBy(xpath = "//*[@id='TOMADOR_TIPODOCFIS_CONF']")
	// private WebElement drpDwnDocumento;
	private By drpDwnDocumento = By.cssSelector("#TOMADOR_TIPODOCFIS_CONF");

	// @FindBy(xpath = "//*[@id='TOMADOR_MEDIOPAGO_CONF']")
	// private WebElement drpDwnMedioPago;
	private By drpDwnMedioPago = By.cssSelector("#TOMADOR_MEDIOPAGO_CONF");

	//
	// @FindBy(xpath = ".//*[text()='Asegurado']")
	// private WebElement btnAsegurado;
	//
	// @FindBy(xpath = ".//*[text()='Fisica']")
	// private WebElement btnFisica;
	//
	// @FindBy(xpath = ".//*[text()='NIF']")
	// private WebElement btnNIF;
	//
	// @FindBy(xpath = ".//*[text()='Mediador']")
	// private WebElement btnMedioPagoMediador;
	//
	// @FindBy(xpath = ".//*[text()='Documento']")
	// private WebElement txtDocumento;
	//
	// @FindBy(xpath = "//*[@id='botonGrabar']")
	// private WebElement btnAnadirDatosTomador;
	private By btnAnadirDatosTomador = By.cssSelector("#botonGrabar");

	private By btnAnadirDatosTomadorPantallaPrincipal = By.id("addTomaAsegurados");

	//
	// @FindBy(xpath = "//*[@id='botonInmuebleVisual']")
	// private WebElement btnAnadirDireccion;
	private By btnAnadirDireccion = By.cssSelector("#botonInmuebleVisual");

	//
	// @FindBy(xpath = "//*[@id='TOMADOR_DOCUMENTOFIS_CONF']")
	// private WebElement txtTomadorDNI;
	private By txtTomadorDNI = By.cssSelector("#TOMADOR_DOCUMENTOFIS_CONF");

	//
	// @FindBy(xpath = "//*[@id='TOMADOR_NOMBREFIS_CONF']")
	// private WebElement txtTomadorNombre;
	private By txtTomadorNombre = By.cssSelector("#TOMADOR_NOMBREFIS_CONF");

	//
	// @FindBy(xpath = "//*[@id='TOMADOR_APELL1FIS_CONF']")
	// private WebElement txtTomadorPrimerApellido;
	private By txtTomadorPrimerApellido = By.cssSelector("#TOMADOR_APELL1FIS_CONF");

	//
	// @FindBy(xpath = "//*[@id='TOMADOR_APELL2FIS_CONF']")
	// private WebElement txtTomadorSegundoApellido;
	private By txtTomadorSegundoApellido = By.cssSelector("#TOMADOR_APELL2FIS_CONF");

	//
	// @FindBy(xpath = "//*[@id='botoncapaUbicacionIntervinientes']")
	// private WebElement btnRellenarDireccion;
	private By btnRellenarDireccion = By.cssSelector("#botoncapaUbicacionIntervinientes");

	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_PROVINCIA_ARVATO_TOM']")
	// private WebElement txtProvincia;
	private By txtProvincia = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO_TOM");

	//
	// @FindBy(xpath = "/html/body/ul[2]/li/a")
	// private WebElement itemProvincia;
	private By itemProvincia = By.xpath("/html/body/ul[2]/li/a");
	// private By itemProvincia = By.cssSelector("/html/body/ul[2]/li/a");

	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_POBLACION_ARVATO_TOM']")
	// private WebElement txtPoblacion;
	private By txtPoblacion = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO_TOM");

	//
	// @FindBy(xpath = "/html/body/ul[3]/li/a")
	// private WebElement itemPoblacion;
	private By itemPoblacion = By.xpath("/html/body/ul[3]/li/a");
	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_NOMVIA_ARVATO_TOM']")
	// private WebElement txtNomVia;
	private By txtNomVia = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO_TOM");

	//
	// @FindBy(xpath = "/html/body/ul[4]/li/a")
	// private WebElement itemNomVia;
	private By itemNomVia = By.xpath("/html/body/ul[4]/li/a");

	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_NUMVIA_TOM']")
	// private WebElement txtNumVia;
	private By txtNumVia = By.cssSelector("#ALTACLIE_BS_NUMVIA_TOM");

	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_TIPOVIA_ARVATO_TOM']")
	// private WebElement drpDwnTipoVia;
	private By drpDwnTipoVia = By.cssSelector("#ALTACLIE_BS_TIPOVIA_ARVATO_TOM");

	//
	// @FindBy(xpath = "//*[@id='ALTACLIE_BS_CODPOST_ARVATO_TOM']")
	// private WebElement txtCodigoPostal;
	private By txtCodigoPostal = By.cssSelector("#ALTACLIE_BS_CODPOST_ARVATO_TOM");

	//
	// @FindBy(xpath = "//*[@id='fechaNacimiento']")
	// private WebElement txtFechaNacimiento;
	private By txtFechaNacimiento = By.cssSelector("#fechaNacimiento");

	//
	// @FindBy(xpath = "//*[@id='bloque2Tomador']")
	// private WebElement txtIBAN;
	private By txtIBAN = By.cssSelector("#bloque2Tomador");

	//
	// public TomadorYAseguradoPage_MAC(BrowserContext browserContext)
	// {
	// this.webDriver = browserContext.webElementHelper;
	// this.browserContext = browserContext;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	public void executeActionsInTomadorYAseguradoPage() {
		// Add datos tomador
		this.AddDatosTomadorAsegurado();
	}

	public void AddDatosTomadorAsegurado() {
		debugBegin();
		if(!this.getScenarioVar("tipo_alta").equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal)) {
			// this.webDriver.moveToElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal,
			// this.mainFrame);
			this.webDriver.clickInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.mainFrame);

			// Select Tomador
			this.seleccionarTomador("Tomador");
			// Select persona fisica
			this.seleccionarTipoPersona("Física");
			// Select documento tomador DNI
			this.seleccionarTipoDocumento("NIF");

			// Select documento tomador
			setTestVar("tomador_dni", DniGeneratorHelper.generateNif(null));
			this.webDriver.appendTextInFrame(this.txtTomadorDNI, this.mainFrame, String.valueOf(getTestVar("tomador_dni")));
			// Select nombre tomador
			this.webDriver.appendTextInFrame(this.txtTomadorNombre, this.mainFrame, String.valueOf(getScenarioVar("nombre_tomador")));
			// Select primer apellido
			this.webDriver.appendTextInFrame(this.txtTomadorPrimerApellido, this.mainFrame, String.valueOf(getScenarioVar("primer_apellido_tomador")));
			// Select segundo apellido
			this.webDriver.appendTextInFrame(this.txtTomadorSegundoApellido, this.mainFrame, String.valueOf(getScenarioVar("segundo_apellido_tomador")));

			// Domicilio
			this.webDriver.clickInFrame(this.btnRellenarDireccion, this.mainFrame);
			// Provincia
			this.webDriver.appendTextInFrame(this.txtProvincia, this.mainFrame, String.valueOf(getScenarioVar("provincia")));
			// this.webDriver.waitForElementToBeClickableInFrame(this.itemProvincia,
			// this.mainFrame);
			this.webDriver.clickInFrame(this.itemProvincia, this.mainFrame);
			// Poblacion
			this.webDriver.appendTextInFrame(this.txtPoblacion, this.mainFrame, String.valueOf(getScenarioVar("poblacion")));
			this.webDriver.clickInFrame(this.itemPoblacion, this.mainFrame);
			// Nombre via
			this.webDriver.appendTextInFrame(this.txtNomVia, this.mainFrame, String.valueOf(getScenarioVar("nombre_via")));
			this.webDriver.clickInFrame(this.itemNomVia, this.mainFrame);
			// Obtener numero via de DatosMACddd.csv
			this.webDriver.appendTextInFrame(this.txtNumVia, this.mainFrame, String.valueOf(getData("fichero_numero_via").getValue(userS.getScenario(), "numero_via")));
			// Click añadir direccion
			this.webDriver.clickInFrame(this.btnAnadirDireccion, this.mainFrame);
			// Fecha nacimiento
			this.webDriver.appendTextInFrame(this.txtFechaNacimiento, this.mainFrame, String.valueOf(this.getScenarioVar("fecha_nacimiento")));
			// Medio pago
			this.seleccionarMedioPago();

			this.webDriver.clickInFrame(this.btnAnadirDatosTomador, this.mainFrame);
		}
		debugEnd();
	}

	public void seleccionarTomador(String tomador) {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnAlta, this.mainFrame, tomador);

		// /*
		// * switch (tomador) { case MutuaPropietariosConstants.ALTA_TOMADOR:
		// this.webDriver.SelectValueInDropDownInFrame(this.btnElegirAlta,
		// this.mainFrame,
		// * tomador); break; case MutuaPropietariosConstants.ALTA_ASEGURADO:
		// this.webDriver.SelectValueInDropDownInFrame(this.btnElegirAlta,
		// this.mainFrame,
		// * tomador); break; }
		// */
		//
		debugEnd();
	}

	//
	public void seleccionarTipoDocumento(String tipoDocumento) {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnDocumento, this.mainFrame, tipoDocumento);
		debugEnd();
	}

	public void seleccionarTipoPersona(String tipoPersona) {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnTipoPersona, this.mainFrame, tipoPersona);
		debugEnd();
	}

	public void seleccionarMedioPago() {
		debugBegin();
		if(this.getScenarioVar("medio_pago").equals("mediador")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnMedioPago, this.mainFrame, "Mediador");
			debugEnd();
		}

		if(this.getScenarioVar("medio_pago").equals("domiciliacion_bancaria")) {
			this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnMedioPago, this.mainFrame, "Domiciliación bancaria");
			this.webDriver.appendTextInFrame(this.txtIBAN, this.mainFrame, String.valueOf(this.getScenarioVar("numero_cuenta").substring(2)));

		}

		debugEnd();
	}
}
