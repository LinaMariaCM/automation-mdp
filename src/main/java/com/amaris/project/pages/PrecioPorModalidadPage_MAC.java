package com.amaris.project.pages;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class PrecioPorModalidadPage_MAC extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	private By mainFrame = By.cssSelector("#mainFrame");

	// @FindBy(id = "nombdato_MODALIDAD_1")
	// private WebElement drpdwnModalidad;
	private By drpdwnModalidad = By.cssSelector("#nombdato_MODALIDAD_1");

	// @FindBy(id = "DTRIESALQCONF_RENTA")
	// private WebElement txtRenta;
	private By txtRenta = By.cssSelector("#DTRIESALQCONF_RENTA");

	// @FindBy(id = "botonContinuar")
	// private WebElement btnConvertirProyecto;
	private By btnConvertirProyecto = By.cssSelector("#botonContinuar");

	// @FindBy(id = "selCobertura")
	// private WebElement drpdnImpagoAlquiler;
	private By drpdnImpagoAlquiler = By.cssSelector("#selCobertura");

	// @FindBy(id = "selFranquicia")
	// private WebElement drpdnFranquicia;
	private By drpdnFranquicia = By.cssSelector("#selFranquicia");

	// @FindBy(id = "botonContinuar")
	// private WebElement btnContinuar;
	private By btnContinuar = By.cssSelector("#botonContinuar");

	// @FindBy(css = "div[class *= 'alert alert-danger alert-dismissable'")
	// private WebElement msjError;
	private By msjError = By.cssSelector("div[class *= 'alert alert-danger alert-dismissable'");

	// // @FindBy(id = "RAUTCAPMAXCONF")
	// // private WebElement msjErrorRebasada;
	private By msjErrorRebasada = By.cssSelector("#RAUTCAPMAXCONF");

	// /@FindBy(id = "REASRENTAALQ")
	// private WebElement msjErrorReaseguro;
	private By msjErrorReaseguro = By.cssSelector("REASRENTAALQ");

	// BrowserContext browserContext;
	// private WebElementHelper wh;
	//
	// final static Logger logger =
	// LoggerFactory.getLogger(PrecioPorModalidadPage_MAC.class);

	public PrecioPorModalidadPage_MAC(UserStory userS) {
		super(userS);
	}

	// public PrecioPorModalidadPage_MAC(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	public void executeActionsInPrecioPorModalidadPage() throws InterruptedException {
		debugBegin();
		this.webDriver.waitWithDriver(4000);
		this.completarRentaMensualAlquiler();
		this.completarGarantiasBasicas();

		this.clickOnConvertirAProyecto();
		debugEnd();
	}

	public void completarRentaMensualAlquiler() {
		debugBegin();

		webDriver.waitWithDriver(4000);

		this.webDriver.setTextInFrame(this.txtRenta, this.mainFrame, String.valueOf(getScenarioVar("renta_mensual_alquiler")));
		this.webDriver.tabulateElementInFrame(this.txtRenta, this.mainFrame);
		debugEnd();
	}

	// public void CompletarRentaMensualAlquiler()
	// {
	// debugBegin();
	// this.webDriver.setTextInFrame(this.txtRenta, this.mainFrame,
	// String.valueOf(userS.getTestVar("renta_mensual_alquiler")));
	// this.webDriver.tabulateElementInFrame(this.txtRenta, this.mainFrame);
	// debugEnd();
	// }

	public void clickOnConvertirAProyecto() {
		debugBegin();

		// this.wh.scrollToEndOfPage();
		// this.wh.scrollToWebElementWithJavaScriptInFrame(this.btnConvertirProyecto,
		// this.cuerpoFrame);
		// this.webDriver.waitForElementToBeClickableInFrame(this.btnConvertirProyecto,
		// this.mainFrame);
		this.webDriver.waitWithDriver(8000);
		this.webDriver.clickInFrame(this.btnConvertirProyecto, this.mainFrame);
		debugEnd();
	}

	// // region methods
	// public void ClickOnConvertirAProyecto() throws InterruptedException
	// {
	// logger.debug("BEGIN - ClickOnConvertirAProyecto");
	// // this.wh.scrollToEndOfPage();
	// //
	// this.wh.scrollToWebElementWithJavaScriptInFrame(this.btnConvertirProyecto,
	// this.cuerpoFrame);
	// this.wh.clickOnWebElementInFrame(this.btnConvertirProyecto,
	// this.cuerpoFrame);
	// logger.debug("END - ClickOnConvertirAProyecto");
	// }
	//
	public void completarGarantiasBasicas() {
		debugBegin();
		String ImpagoAlquiler = getScenarioVar("impago_alquiler");
		String Franquicia = getScenarioVar("franquiciaMAC");

		if(ImpagoAlquiler != null) {
			this.seleccionarImpagoAlquiler();
		}

		if(Franquicia != null) {
			this.seleccionarFranquicia();
		}
		debugEnd();
	}

	// public void completarGarantiasBasicas() throws IOException
	// {
	// logger.debug("BEGIN - completarGarantiasBasicas");
	// String ImpagoAlquiler =
	// this.browserContext.getTestCaseData().getImpagoAlquiler();
	// String Franquicia =
	// this.browserContext.getTestCaseData().getFranquiciaMAC();
	//
	// if (ImpagoAlquiler != null)
	// {
	// this.seleccionarImpagoAlquiler();
	// }
	// if (Franquicia != null)
	// {
	// this.seleccionarFranquicia();
	// }
	// logger.debug("END - completarGarantiasBasicas");
	// }
	//
	public void seleccionarImpagoAlquiler() {
		debugBegin();

		debugInfo("SCENARIO: " + userS.getScenario() + ", VALUE: " + getScenarioVar("impago_alquiler")
			+ ", SCENARIODATA: " + userS.getTestDataManager().getData(AutomationConstants.SCENARIO_DATA));

		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdnImpagoAlquiler, this.mainFrame, String.valueOf(getScenarioVar("impago_alquiler")));
		debugEnd();
	}

	// public void seleccionarImpagoAlquiler() throws IOException
	// {
	// logger.debug("BEGIN - seleccionarImpagoAlquiler");
	// this.wh.selectValueInDropDownInFrame(this.drpdnImpagoAlquiler,
	// this.cuerpoFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getImpagoAlquiler()));
	// logger.debug("END - seleccionarImpagoAlquiler");
	// }

	public void seleccionarFranquicia() {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdnFranquicia, this.mainFrame, String.valueOf(getScenarioVar("franquiciaMAC")));
		debugEnd();
	}

	// public void seleccionarFranquicia() throws IOException
	// {
	// logger.debug("BEGIN - seleccionarFranquicia");
	// this.wh.selectValueInDropDownInFrame(this.drpdnFranquicia,
	// this.cuerpoFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getFranquiciaMAC()));
	// logger.debug("END - seleccionarFranquicia");
	// }
	//

	public void clickContinuar() {
		debugBegin();

		// this.webDriver.waitForElementToBeClickableInFrame(this.btnContinuar,
		// this.mainFrame);
		this.webDriver.waitWithDriver(6000);

		this.webDriver.clickInFrame(this.btnContinuar, this.mainFrame);
		debugEnd();
	}

	// public void continuar()
	// {
	// logger.debug("BEGIN - Continuar");
	//
	// this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
	// logger.debug("END - Continuar");
	// }

	public void selectModalidad() {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdwnModalidad, this.mainFrame, userS.getTestVar("modalidad"));
		debugEnd();
	}

	public String recuperarTextoMensajeError() {
		debugBegin();
		this.webDriver.getTextInFrame(this.msjError, this.mainFrame).substring(2);
		// Se pone substring para quitar el aspa del boton cerrar que
		// aparece al principio del mensaje devuelto.
		debugError("ERROR RECUPERADO - ");
		this.webDriver.getTextInFrame(this.msjError, this.mainFrame).substring(2);
		debugEnd();
		return this.webDriver.getTextInFrame(this.msjError, this.mainFrame);
	}

	public boolean checkConvertirAProyectoIsPresent() {
		debugBegin();
		boolean checker = this.webDriver.isPresentInFrame(this.btnConvertirProyecto, this.mainFrame);
		debugEnd();
		return checker;

	}

	// endregion
}
