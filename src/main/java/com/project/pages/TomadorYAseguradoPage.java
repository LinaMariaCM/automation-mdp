package com.project.pages;

import org.openqa.selenium.By;
import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class TomadorYAseguradoPage extends PageObject {

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

	public TomadorYAseguradoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public TomadorYAseguradoPage addDatosTomador() {
		debugBegin();

		// if
		// (this.tData.getTomador().equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal))
		if(this.testDataM.getTestVar(testId, "Tomador").equals(ProjectConstants.TomadorYAseguradoPrincipal)) {
			// this.webDriver.moveToElementInFrameWithJavaScript(this.btnAnadirDatosTomadorPantallaPrincipal,
			// this.cuerpoFrame);
			this.webDriver.moveToElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);

			// if
			// (this.browserContext.getTestCaseData().getIncluirTelefonosYHorarioAtencionTomador()
			if(this.testDataM.getTestVar(testId, "incluirTelefonosYHorarioAtencionTomador")
				.equals(ProjectConstants.TelefonosTomadorIncluidos)) {
				this.AddTelefonosYHorariosAtencionTomador();
			}

			this.webDriver.clickInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
			this.webDriver.appendTextInFrame(this.txtFechaNacimiento, this.cuerpoFrame, this.testDataM.getTestVar(testId, "TomadorFechaNacimiento"));

			this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);

			this.webDriver.clickInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addStaticDatosTomador() {
		debugBegin();

		this.webDriver.moveToElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);

		this.webDriver.clickInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
		this.webDriver.appendTextInFrame(this.txtFechaNacimiento, this.cuerpoFrame, "08/01/1979");

		this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);

		this.webDriver.clickInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage AddTelefonosYHorariosAtencionTomador() {
		this.webDriver.clickInFrame(this.txtTelefonoFijo, this.cuerpoFrame);
		this.webDriver.appendTextInFrame(this.txtTelefonoFijo, this.cuerpoFrame, this.testDataM.getTestVar(testId, "TomadorTelefonoFijo"));

		this.webDriver.appendTextInFrame(this.txtPrefijoTelefonoFijo, this.cuerpoFrame, this.testDataM.getTestVar(testId, "TomadorTelefonoFijoPrefijo"));
		// this.webDriver.waitForPageLoadToFinish();
		this.webDriver.clickInFrame(this.lblPrefijo, this.cuerpoFrame);

		// List<String> TelefonoFijoHorarioAtencion =
		// this.testDataM.getTestListVar(testId, "TelefonoFijoHorarioAtencion");
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

		this.webDriver.appendTextInFrame(this.txtTelefonoMovil, this.cuerpoFrame, this.testDataM.getTestVar(testId, "TomadorTelefonoMovil"));

		this.webDriver.appendTextInFrame(this.txtTelefonoMovilPrefijo, this.cuerpoFrame, this.testDataM.getTestVar(testId, "TomadorTelefonoMovilPrefijo"));
		this.webDriver.clickInFrame(this.lblPrefijo, this.cuerpoFrame);
		//
		// List<String> TelefonoMovilHorarioAtencion =
		// this.testDataM.getTestListVar(testId, "TelefonoMovilHorarioAtencion");
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

		return this;
	}

	public TomadorYAseguradoPage clickOnContinuar() {
		debugBegin();
		this.webDriver.scrollToBottom();
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addDatosTomadorDiferenteAsegurado() {
		debugBegin();
		if(this.testDataM.getTestVar(testId, "AseguradoPrincipalDiferenteDelTomador")
			.equals(ProjectConstants.AseguradoPrincipalDiferenteTomador)) {
			this.webDriver.clickInFrame(this.cbkAseguradoDiferenteToamdor, this.cuerpoFrame);
			this.webDriver.moveToElementInFrame(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			// this.wh.ClickOnWebElement(this.btnAddDataOfTheAseguradoPrincipal);
			this.webDriver.clickElementFromDropDownByTextInFrame(this.cbkAeguradoTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
			// this.browserContext.getTestCaseData().setAseguradoDni(DniGeneratorHelper.generaNif(null));
			this.testDataM.setTestVar(testId, "TomadorDNI", DniGeneratorHelper.generaNif(null));
			this.webDriver.appendTextInFrame(this.txtAseguradoNumeroDocumento, this.cuerpoFrame, this.testDataM.getTestVar(testId, "AseguradoDNI"));
			this.webDriver.appendTextInFrame(this.txtAseguradoNombre, this.cuerpoFrame, this.testDataM.getTestVar(testId, "AseguradoNombre"));
			this.webDriver.appendTextInFrame(this.txtAseguradoApellido1, this.cuerpoFrame, this.testDataM.getTestVar(testId, "AseguradoPrimerApellido"));
			this.webDriver.appendTextInFrame(this.txtAseguradoApellido2, this.cuerpoFrame, this.testDataM.getTestVar(testId, "AseguradoSegundoApellido"));
			this.webDriver.clickInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAddAseguradoPrincipalModalWindow, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
		}

		debugEnd();

		return this;
	}
	// endregion
}
