package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class TomadorYAseguradoPage
{
	final static Logger logger = LoggerFactory.getLogger(TomadorYAseguradoPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;

	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	// @FindBy(xpath = ".//*[text()='Continuar']")
	@FindBy(css = "button[ng-click*='continuar(tomador']")
	private WebElement btnContinuar;

	@FindBy(xpath = ".//*[text()='Añadir datos tomador']")
	private WebElement btnAnadirDatosTomadorPantallaPrincipal;

	@FindBy(name = "fechaNacimiento")
	private WebElement txtFechaNacimiento;

	@FindBy(xpath = ".//*[text() = 'Utilizar la misma dirección del riesgo asegurado']/../input")
	private WebElement rdnUtilizarMismaDireccionAsegurado;

	@FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir datos tomador']")
	private WebElement btnAnadirDatosTomador;

	@FindBy(xpath = ".//*[text()='Aceptar']")
	private WebElement btnAceptar;

	@FindBy(id = "prefijoTlfFijo")
	private WebElement txtPrefijoTelefonoFijo;

	@FindBy(xpath = ".//*[contains(@ng-bind-html,'ypeaheadHighlight')]")
	private WebElement lblPrefijo;

	@FindBy(id = "tlfFijo")
	private WebElement txtTelefonoFijo;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='1']")
	private WebElement chbTelefonoFijoHorarioAtencionManana;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='4']")
	private WebElement chbTelefonoFijoHorarioAtencionDeLunesAViernes;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='2']")
	private WebElement chbTelefonoFijoHorarioAtencionTarde;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='5']")
	private WebElement chbTelefonoFijoHorarioAtencionFinDeSemana;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfFijo' and @value='3']")
	private WebElement chbTelefonoFijoHorarioAtencionNoche;

	@FindBy(id = "prefijoTlfMovil")
	private WebElement txtTelefonoMovilPrefijo;

	@FindBy(id = "tlfMovil")
	private WebElement txtTelefonoMovil;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='1']")
	private WebElement chbTelefonoMovilHorarioAtencionManana;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='4']")
	private WebElement chbTelefonoMovilHorarioAtencionDeLunesAViernes;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='2']")
	private WebElement chbTelefonoMovilHorarioAtencionTarde;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='5']")
	private WebElement chbTelefonoMovilHorarioAtencionFinDeSemana;

	@FindBy(xpath = ".//*[@name = 'horarioAtenTlfMovil' and @value='3']")
	private WebElement chbTelefonoMovilHorarioAtencionNoche;

	@FindBy(id = "asegPpalEsTomadorNo")
	private WebElement cbkAseguradoDiferenteToamdor;

	@FindBy(xpath = ".//*[text()='Añadir datos asegurado principal']")
	private WebElement btnAddDataOfTheAseguradoPrincipal;

	@FindBy(id = "tipoDocumento")
	private WebElement cbkAeguradoTipoDocumento;

	@FindBy(id = "numeroDocumento")
	private WebElement txtAseguradoNumeroDocumento;

	@FindBy(id = "nombreAsegurado")
	private WebElement txtAseguradoNombre;

	@FindBy(id = "apellido1Asegurado")
	private WebElement txtAseguradoApellido1;

	@FindBy(id = "apellido2Asegurado")
	private WebElement txtAseguradoApellido2;

	@FindBy(xpath = ".//*[@ng-model='mismaDireccionRiesgo']")
	private WebElement chkAseguradoMismaDireccionDelRiesgo;

	@FindBy(xpath = ".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']")
	private WebElement btnAddAseguradoPrincipalModalWindow;

	@FindBy(xpath = ".//*[@name='tomadorAseguradoForm']//*[text()='Modificar datos tomador']")
	private WebElement btnModificarDatosTomador;
	// endregion

	public TomadorYAseguradoPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}

	// region methods
	public void AddDatosTomador()
	{
		logger.debug("BEGIN - AddDatosTomador");

		if (this.tData.getTomador().equals(ProjectConstants.NuevoTomadorYAseguradoPrincipal))
		{
			this.wh.moveToElementInFrameWithJavaScript(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);

			if (this.browserContext.getTestCaseData().getIncluirTelefonosYHorarioAtencionTomador()
					.equals(ProjectConstants.TelefonosTomadorIncluidos))
			{
				this.AddTelefonosYHorariosAtencionTomador();
			}

			this.wh.clickOnWebElementInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
			this.wh.sendValueToWebElementInFrame(this.txtFechaNacimiento, this.cuerpoFrame,
					this.browserContext.getTestCaseData().getTomadorFechaNacimiento());

			this.wh.clickOnWebElementInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);

			this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
		}

		logger.debug("END - AddDatosTomador");
	}

	public void addStaticDatosTomador()
	{
		logger.debug("BEGIN - addStaticDatosTomador");
		
		this.wh.moveToElementInFrameWithJavaScript(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomadorPantallaPrincipal, this.cuerpoFrame);
		
		this.wh.clickOnWebElementInFrame(this.txtFechaNacimiento, this.cuerpoFrame);
		this.wh.sendValueToWebElementInFrame(this.txtFechaNacimiento, this.cuerpoFrame, "08/01/1979");
		
		this.wh.clickOnWebElementInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);
		
		this.wh.clickOnWebElementInFrame(this.btnAnadirDatosTomador, this.cuerpoFrame);
		this.wh.clickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
		
		logger.debug("END - addStaticDatosTomador");
	}

	public void AddTelefonosYHorariosAtencionTomador()
	{
		this.wh.clickOnWebElementInFrame(this.txtTelefonoFijo, this.cuerpoFrame);
		this.wh.sendValueToWebElementInFrame(this.txtTelefonoFijo, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorTelefonoFijo());

		this.wh.sendValueToWebElementInFrame(this.txtPrefijoTelefonoFijo, this.cuerpoFrame,
				this.browserContext.getTestCaseData().getTomadorTelefonoFijoPrefijo());
		this.wh.waitForPageLoadToFinish();
		this.wh.clickOnWebElementInFrame(this.lblPrefijo, this.cuerpoFrame);

		List<String> TelefonoFijoHorarioAtencion = this.browserContext.getTestCaseData().getTomadorTelefonoFijoHorarioAtencion();

		TelefonoFijoHorarioAtencion.forEach(option ->
		{
			switch (option)
			{
				case ProjectConstants.Manana:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoFijoHorarioAtencionManana, this.cuerpoFrame);
					break;

				case ProjectConstants.Tarde:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoFijoHorarioAtencionTarde, this.cuerpoFrame);
					break;

				case ProjectConstants.Noche:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoFijoHorarioAtencionNoche, this.cuerpoFrame);
					break;

				case ProjectConstants.FinDeSemana:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoFijoHorarioAtencionFinDeSemana, this.cuerpoFrame);
					break;

				case ProjectConstants.DeLunesAViernes:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoFijoHorarioAtencionDeLunesAViernes, this.cuerpoFrame);
					break;
			}
		});

		this.wh.sendValueToWebElementInFrame(this.txtTelefonoMovil, this.cuerpoFrame, this.browserContext.getTestCaseData().getTomadorTelefonoMovil());

		this.wh.sendValueToWebElementInFrame(this.txtTelefonoMovilPrefijo, this.cuerpoFrame,
				this.browserContext.getTestCaseData().getTomadorTelefonoMovilPrefijo());
		this.wh.clickOnWebElementInFrame(this.lblPrefijo, this.cuerpoFrame);

		List<String> TelefonoMovilHorarioAtencion = this.browserContext.getTestCaseData().getTomadorTelefonoMovilHorarioAtencion();

		TelefonoMovilHorarioAtencion.forEach(option ->
		{
			switch (option)
			{
				case ProjectConstants.Manana:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoMovilHorarioAtencionManana, this.cuerpoFrame);
					break;

				case ProjectConstants.Tarde:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoMovilHorarioAtencionTarde, this.cuerpoFrame);
					break;

				case ProjectConstants.Noche:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoMovilHorarioAtencionNoche, this.cuerpoFrame);
					break;

				case ProjectConstants.FinDeSemana:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoMovilHorarioAtencionFinDeSemana, this.cuerpoFrame);
					break;

				case ProjectConstants.DeLunesAViernes:
					this.wh.clickOnWebElementInFrame(this.chbTelefonoMovilHorarioAtencionDeLunesAViernes, this.cuerpoFrame);
					break;
			}
		});
	}

	public void clickOnContinuar()
	{
		logger.debug("BEGIN - ClickOnContinuar");
		this.wh.scrollToEndOfPage();
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}

	public void AddDatosTomadorDiferenteAsegurado()
	{
		logger.debug("BEGIN - AddDatosTomadorDiferenteAsegurado");
		if (this.browserContext.getTestCaseData().getAseguradoPrincipalDiferenteDelTomador()
				.equals(ProjectConstants.AseguradoPrincipalDiferenteTomador))
		{
			this.wh.clickOnWebElementInFrame(this.cbkAseguradoDiferenteToamdor, this.cuerpoFrame);
			this.wh.moveToElementInFrameWithJavaScript(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrameWithJavaScript(this.btnAddDataOfTheAseguradoPrincipal, this.cuerpoFrame);
			// this.wh.ClickOnWebElement(this.btnAddDataOfTheAseguradoPrincipal);
			this.wh.selectValueInDropDownInFrame(this.cbkAeguradoTipoDocumento, this.cuerpoFrame, ProjectConstants.NIF);
			this.browserContext.getTestCaseData().setAseguradoDni(DniGeneratorHelper.generaNif(null));
			this.wh.sendValueToWebElementInFrame(this.txtAseguradoNumeroDocumento, this.cuerpoFrame,
					this.browserContext.getTestCaseData().getAseguradoDni());
			this.wh.sendValueToWebElementInFrame(this.txtAseguradoNombre, this.cuerpoFrame, this.browserContext.getTestCaseData().getAseguradoNombre());
			this.wh.sendValueToWebElementInFrame(this.txtAseguradoApellido1, this.cuerpoFrame,
					this.browserContext.getTestCaseData().getAseguradoApellido1());
			this.wh.sendValueToWebElementInFrame(this.txtAseguradoApellido2, this.cuerpoFrame,
					this.browserContext.getTestCaseData().getAseguradoApellido2());
			this.wh.clickOnWebElementInFrame(this.rdnUtilizarMismaDireccionAsegurado, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrame(this.btnAddAseguradoPrincipalModalWindow, this.cuerpoFrame);
			this.wh.clickOnWebElementInFrame(this.btnAceptar, this.cuerpoFrame);
		}
		logger.debug("END - AddDatosTomadorDiferenteAsegurado");
	}
	// endregion
}
