package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class TomadorYAseguradoPage {
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	// @FindBy(css = "button[ng-click*='continuar(tomador']")
	private By btnContinuar = By.cssSelector("button[ng-click*='continuar(tomador']");

	// @FindBy(xpath = ".//*[text()='Añadir datos tomador']")
	private By btnAnadirDatosTomadorPantallaPrincipal = By.xpath(".//*[text()='Añadir datos tomador']");

	// @FindBy(name = "fechaNacimiento")
	private By txtFechaNacimiento = By.name("fechaNacimiento");

	// @FindBy(xpath = ".//*[text() = 'Utilizar la misma dirección del riesgo
	// asegurado']/../input")
	private By rdnUtilizarMismaDireccionAsegurado = By.xpath(".//*[text() = 'Utilizar la misma dirección del riesgo asegurado']/../input");

	// @FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir datos
	// tomador']")
	private By btnAnadirDatosTomador = By.xpath(".//*[@class='modal-footer']/button[text()='Añadir datos tomador']");

	// @FindBy(xpath = ".//*[text()='Aceptar']")
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");

	// @FindBy(id = "prefijoTlfFijo")
	private By txtPrefijoTelefonoFijo = By.cssSelector("prefijoTlfFijo");

	// @FindBy(xpath = ".//*[contains(@ng-bind-html,'ypeaheadHighlight')]")
	private By lblPrefijo = By.xpath(".//*[contains(@ng-bind-html,'ypeaheadHighlight')]");

	// @FindBy(id = "tlfFijo")
	private By txtTelefonoFijo = By.cssSelector("tlfFijo");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='1']")
	private By chbTelefonoFijoHorarioAtencionManana = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='1']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='4']")
	private By chbTelefonoFijoHorarioAtencionDeLunesAViernes = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='4']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='2']")
	private By chbTelefonoFijoHorarioAtencionTarde = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='2']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='5']")
	private By chbTelefonoFijoHorarioAtencionFinDeSemana = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='5']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='3']")
	private By chbTelefonoFijoHorarioAtencionNoche = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='3']");

	// @FindBy(id = "prefijoTlfMovil")
	private By txtTelefonoMovilPrefijo = By.cssSelector("prefijoTlfMovil");

	// @FindBy(id = "tlfMovil")
	private By txtTelefonoMovil = By.cssSelector("tlfMovil");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='1']")
	private By chbTelefonoMovilHorarioAtencionManana = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='1']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='4']")
	private By chbTelefonoMovilHorarioAtencionDeLunesAViernes = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='4']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='2']")
	private By chbTelefonoMovilHorarioAtencionTarde = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='2']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='5']")
	private By chbTelefonoMovilHorarioAtencionFinDeSemana = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='5']");

	// @FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='3']")
	private By chbTelefonoMovilHorarioAtencionNoche = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='3']");

	// @FindBy(id = "asegPpalEsTomadorNo")
	private By cbkAseguradoDiferenteToamdor = By.cssSelector("asegPpalEsTomadorNo");

	// @FindBy(xpath = ".//*[text()='Añadir datos asegurado principal']")
	private By btnAddDataOfTheAseguradoPrincipal = By.xpath(".//*[text()='Añadir datos asegurado principal']");

	// @FindBy(id = "tipoDocumento")
	private By cbkAeguradoTipoDocumento = By.cssSelector("tipoDocumento");

	// @FindBy(id = "numeroDocumento")
	private By txtAseguradoNumeroDocumento = By.cssSelector("numeroDocumento");

	// @FindBy(id = "nombreAsegurado")
	private By txtAseguradoNombre = By.cssSelector("nombreAsegurado");

	// @FindBy(id = "apellido1Asegurado")
	private By txtAseguradoApellido1 = By.cssSelector("apellido1Asegurado");

	// @FindBy(id = "apellido2Asegurado")
	private By txtAseguradoApellido2 = By.cssSelector("apellido2Asegurado");

	// @FindBy(xpath = ".//*[@ng-model='mismaDireccionRiesgo']")
	private By chkAseguradoMismaDireccionDelRiesgo = By.xpath(".//*[@ng-model='mismaDireccionRiesgo']");

	// @FindBy(xpath = ".//div[@class='modal-footer']/button[text()='Añadir
	// datos asegurado principal']")
	private By btnAddAseguradoPrincipalModalWindow = By.xpath(".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']");

	// @FindBy(xpath = ".//*[@name='tomadorAseguradoForm']//*[text()='Modificar
	// datos tomador']")
	private By btnModificarDatosTomador = By.xpath(".//*[@name='tomadorAseguradoForm']//*[text()='Modificar datos tomador']");
	// endregion

	public TomadorYAseguradoPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public TomadorYAseguradoPage addDatosTomador() {
		logger.debug("BEGIN - AddDatosTomador");

		// if
		// (this.tData.getTomador().equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal))
		if(this.tCData.getTestVar(testId, "Tomador").equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal)) {
			// this.webDriver.moveToElementInFrameWithJavaScript(this.btnAnadirDatosTomadorPantallaPrincipal,
			// this.cuerpoFrame);
			this.webDriver.moveToElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);

			// if
			// (this.browserContext.getTestCaseData().getIncluirTelefonosYHorarioAtencionTomador()
			if(this.tCData.getTestVar(testId, "incluirTelefonosYHorarioAtencionTomador")
				.equals(ProjectConstants.TelefonosTomadorIncluidos)) {
				this.AddTelefonosYHorariosAtencionTomador();
			}

			this.webDriver.clickInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
			this.webDriver.appendTextInFrame(this.txtFechaNacimiento, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorFechaNacimiento"));

			this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);

			this.webDriver.clickInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
		}

		logger.debug("END - AddDatosTomador");

		return this;
	}

	public void addStaticDatosTomador() {
		logger.debug("BEGIN - addStaticDatosTomador");

		this.webDriver.moveToElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);

		this.webDriver.clickInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
		this.webDriver.appendTextInFrame(this.txtFechaNacimiento, this.cuerpoFrame, "08/01/1979");

		this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);

		this.webDriver.clickInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);

		logger.debug("END - addStaticDatosTomador");
	}

	public void AddTelefonosYHorariosAtencionTomador() {
		this.webDriver.clickInFrame(this.txtTelefonoFijo, this.cuerpoFrame);
		this.webDriver.appendTextInFrame(this.txtTelefonoFijo, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorTelefonoFijo"));

		this.webDriver.appendTextInFrame(this.txtPrefijoTelefonoFijo, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorTelefonoFijoPrefijo"));
		// this.webDriver.waitForPageLoadToFinish();
		this.webDriver.clickInFrame(this.lblPrefijo, this.cuerpoFrame);

		// List<String> TelefonoFijoHorarioAtencion =
		// this.tCData.getTestListVar(testId, "TelefonoFijoHorarioAtencion");
		//
		// TelefonoFijoHorarioAtencion.forEach(option ->
		// {
		// switch (option)
		// {
		// case ProjectConstants.Manana:
		// this.webDriver.clickInFrame(this.chbTelefonoFijoHorarioAtencionManana,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Tarde:
		// this.webDriver.clickInFrame(this.chbTelefonoFijoHorarioAtencionTarde,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Noche:
		// this.webDriver.clickInFrame(this.chbTelefonoFijoHorarioAtencionNoche,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.FinDeSemana:
		// this.webDriver.clickInFrame(this.chbTelefonoFijoHorarioAtencionFinDeSemana,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.DeLunesAViernes:
		// this.webDriver.clickInFrame(this.chbTelefonoFijoHorarioAtencionDeLunesAViernes,
		// this.cuerpoFrame);
		// break;
		// }
		// });

		this.webDriver.appendTextInFrame(this.txtTelefonoMovil, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorTelefonoMovil"));

		this.webDriver.appendTextInFrame(this.txtTelefonoMovilPrefijo, this.cuerpoFrame, this.tCData.getTestVar(testId, "TomadorTelefonoMovilPrefijo"));
		this.webDriver.clickInFrame(this.lblPrefijo, this.cuerpoFrame);
		//
		// List<String> TelefonoMovilHorarioAtencion =
		// this.tCData.getTestListVar(testId, "TelefonoMovilHorarioAtencion");
		//
		// TelefonoMovilHorarioAtencion.forEach(option ->
		// {
		// switch (option)
		// {
		// case ProjectConstants.Manana:
		// this.webDriver.clickInFrame(this.chbTelefonoMovilHorarioAtencionManana,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Tarde:
		// this.webDriver.clickInFrame(this.chbTelefonoMovilHorarioAtencionTarde,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Noche:
		// this.webDriver.clickInFrame(this.chbTelefonoMovilHorarioAtencionNoche,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.FinDeSemana:
		// this.webDriver.clickInFrame(this.chbTelefonoMovilHorarioAtencionFinDeSemana,
		// this.cuerpoFrame);
		// break;
		//
		// case ProjectConstants.DeLunesAViernes:
		// this.webDriver.clickInFrame(this.chbTelefonoMovilHorarioAtencionDeLunesAViernes,
		// this.cuerpoFrame);
		// break;
		// }
		// });
	}

	public TomadorYAseguradoPage clickOnContinuar() {
		logger.debug("BEGIN - ClickOnContinuar");
		this.webDriver.scrollToBottom();
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
		
		return this;
	}

	public TomadorYAseguradoPage addDatosTomadorDiferenteAsegurado() {
		logger.debug("BEGIN - AddDatosTomadorDiferenteAsegurado");
		if(this.tCData.getTestVar(testId, "AseguradoPrincipalDiferenteDelTomador")
			.equals(ProjectConstants.AseguradoPrincipalDiferenteTomador)) {
			this.webDriver.clickInFrame(this.cbkAseguradoDiferenteToamdor, this.cuerpoFrame);
			this.webDriver.moveToElementInFrame(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			// this.wh.ClickOnWebElement(this.btnAddDataOfTheAseguradoPrincipal);
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cbkAeguradoTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
			// this.browserContext.getTestCaseData().setAseguradoDni(DniGeneratorHelper.generaNif(null));
			this.tCData.setTestVar(testId, "TomadorDNI", DniGeneratorHelper.generaNif(null));
			this.webDriver.appendTextInFrame(this.txtAseguradoNumeroDocumento, this.cuerpoFrame, this.tCData.getTestVar(testId, "AseguradoDNI"));
			this.webDriver.appendTextInFrame(this.txtAseguradoNombre, this.cuerpoFrame, this.tCData.getTestVar(testId, "AseguradoNombre"));
			this.webDriver.appendTextInFrame(this.txtAseguradoApellido1, this.cuerpoFrame, this.tCData.getTestVar(testId, "AseguradoPrimerApellido"));
			this.webDriver.appendTextInFrame(this.txtAseguradoApellido2, this.cuerpoFrame, this.tCData.getTestVar(testId, "AseguradoSegundoApellido"));
			this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAddAseguradoPrincipalModalWindow, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
		}
		logger.debug("END - AddDatosTomadorDiferenteAsegurado");
		
		return this;
	}
	// endregion
}
