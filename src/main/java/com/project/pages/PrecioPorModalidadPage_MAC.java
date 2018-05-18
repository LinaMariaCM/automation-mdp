package com.project.pages;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.webdriver.DriverHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrecioPorModalidadPage_MAC extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	private By cuerpoFrame = By.cssSelector("#mainFrame");

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
	public void executeActionsInPrecioPorModalidadPage(String scenario) throws InterruptedException {
		this.completarRentaMensualAlquiler(scenario);
		this.completarGarantiasBasicas(scenario);
		this.clickOnConvertirAProyecto();
	}

	//
	public void completarRentaMensualAlquiler(String scenario) {
		debugBegin();
		this.webDriver.clearAndAppendTextInFrame(this.txtRenta, this.cuerpoFrame, String.valueOf(testDataM.getScenarioVar(scenario, "renta_mensual_alquiler")));
		this.webDriver.tabulateElementInFrame(this.txtRenta, this.cuerpoFrame);
		debugEnd();
	}

	// public void CompletarRentaMensualAlquiler() throws IOException
	// {
	// logger.debug("BEGIN - CompletarRentaMensualAlquiler");
	// this.wh.clearAndSetTextInWebElementInFrame(this.txtRenta,
	// this.cuerpoFrame,
	// String.valueOf(this.browserContext.getTestCaseData().getRentaMensualAlquiler()));
	// this.wh.changeFocusOfWebElementInFrame(this.txtRenta, this.cuerpoFrame);
	// logger.debug("END - CompletarRentaMensualAlquiler");
	// }
	//
	public void clickOnConvertirAProyecto() throws InterruptedException {
		debugBegin();
		// this.wh.scrollToEndOfPage();
		// this.wh.scrollToWebElementWithJavaScriptInFrame(this.btnConvertirProyecto,
		// this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnConvertirProyecto, this.cuerpoFrame);
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
	public void completarGarantiasBasicas(String scenario) {
		debugBegin();
		String ImpagoAlquiler = testDataM.getScenarioVar(scenario, "impago_alquiler");
		String Franquicia = testDataM.getScenarioVar(scenario, "franquiciaMAC");

		if(ImpagoAlquiler != null) {
			this.seleccionarImpagoAlquiler(scenario);
		}
		
		if(Franquicia != null) {
			this.seleccionarFranquicia(scenario);
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
	public void seleccionarImpagoAlquiler(String scenario) {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdnImpagoAlquiler, this.cuerpoFrame, String.valueOf(this.testDataM.getScenarioVar(scenario, "impago_alquiler")));
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

	public void seleccionarFranquicia(String scenario) {
		debugBegin();
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdnFranquicia, this.cuerpoFrame, String.valueOf(testDataM.getScenarioVar(scenario, "franquiciaMAC")));
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
	// public void continuar()
	// {
	// logger.debug("BEGIN - Continuar");
	//
	// this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
	// logger.debug("END - Continuar");
	// }
	//
	// public void selectModalidad()
	// {
	// logger.debug("BEGIN - selectModalidad");
	// this.wh.selectValueInDropDownInFrame(this.drpdwnModalidad,
	// this.cuerpoFrame, this.browserContext.getTestCaseData().getModalidad());
	// logger.debug("END - selectModalidad");
	// }
	//
	// public String recuperarTextoMensajeError()
	// {
	// logger.debug("BEGIN - recuperarTextoMensajeError");
	// this.wh.getTextFromWebElementInFrame(this.msjError,
	// this.cuerpoFrame).substring(2); // Se pone substring para quitar el aspa
	// del boton cerrar que
	// // aparece al principio del mensaje devuelto.
	// // logger.debug("ERROR RECUPERADO - " +
	// this.wh.getTextFromWebElementInFrame(this.msjError,
	// this.cuerpoFrame).substring(2));
	// logger.debug("END - recuperarTextoMensajeError");
	// return this.wh.getTextFromWebElementInFrame(this.msjError,
	// this.cuerpoFrame);
	// }
	//
	// public boolean checkConvertirAProyectoIsPresent()
	// {
	// logger.debug("BEGIN - checkConvertirAProyectoIsEnabled");
	// logger.debug("END - checkConvertirAProyectoIsEnabled");
	// return this.wh.webElementInFrameIsPresent(this.btnConvertirProyecto,
	// this.cuerpoFrame);
	// }
	// endregion
}
