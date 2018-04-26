package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PrecioPorModalidadPage_MAC
{

//	// region webelements
//	@FindBy(name = "cuerpo")
//	private WebElement cuerpoFrame;
//
//	@FindBy(id = "nombdato_MODALIDAD_1")
//	private WebElement drpdwnModalidad;
//
//	@FindBy(id = "DTRIESALQCONF_RENTA")
//	// @FindBy(xpath = ".//*[text()='Renta mensual alquiler']")
//	private WebElement txtRenta;
//
//	// @FindBy(xpath = ".//*[text()='Convertir a proyecto']")
//	@FindBy(id = "botonContinuar")
//	private WebElement btnConvertirProyecto;
//
//	@FindBy(id = "selCobertura")
//	private WebElement drpdnImpagoAlquiler;
//
//	@FindBy(id = "selFranquicia")
//	private WebElement drpdnFranquicia;
//
//	@FindBy(id = "botonContinuar")
//	private WebElement btnContinuar;
//	
//	@FindBy(css = "div[class *= 'alert alert-danger alert-dismissable'")
//	private WebElement msjError;
//
//	// @FindBy(id = "RAUTCAPMAXCONF")
//	// private WebElement msjErrorRebasada;
//
//	// @FindBy(id = "REASRENTAALQ")
//	// private WebElement msjErrorReaseguro;
//
//	BrowserContext browserContext;
//
//	private WebElementHelper wh;
//
//	final static Logger logger = LoggerFactory.getLogger(PrecioPorModalidadPage_MAC.class);
//
//	public PrecioPorModalidadPage_MAC(BrowserContext browserContext)
//	{
//		this.browserContext = browserContext;
//		this.wh = browserContext.webElementHelper;
//		PageFactory.initElements(browserContext.getWebDriver(), this);
//	}
//
//	public void executeActionsInPrecioPorModalidadPage() throws InterruptedException, IOException
//	{
//		this.CompletarRentaMensualAlquiler();
//		this.completarGarantiasBasicas();
//		this.ClickOnConvertirAProyecto();
//	}
//
//	public void CompletarRentaMensualAlquiler() throws IOException
//	{
//		logger.debug("BEGIN - CompletarRentaMensualAlquiler");
//		this.wh.clearAndSetTextInWebElementInFrame(this.txtRenta, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getRentaMensualAlquiler()));
//		this.wh.changeFocusOfWebElementInFrame(this.txtRenta, this.cuerpoFrame);
//		logger.debug("END - CompletarRentaMensualAlquiler");
//	}
//
//	// region methods
//	public void ClickOnConvertirAProyecto() throws InterruptedException
//	{
//		logger.debug("BEGIN - ClickOnConvertirAProyecto");
//		// this.wh.scrollToEndOfPage();
//		// this.wh.scrollToWebElementWithJavaScriptInFrame(this.btnConvertirProyecto, this.cuerpoFrame);
//		this.wh.clickOnWebElementInFrame(this.btnConvertirProyecto, this.cuerpoFrame);
//		logger.debug("END - ClickOnConvertirAProyecto");
//	}
//
//	public void completarGarantiasBasicas() throws IOException
//	{
//		logger.debug("BEGIN - completarGarantiasBasicas");
//		String ImpagoAlquiler = this.browserContext.getTestCaseData().getImpagoAlquiler();
//		String Franquicia = this.browserContext.getTestCaseData().getFranquiciaMAC();
//
//		if (ImpagoAlquiler != null)
//		{
//			this.seleccionarImpagoAlquiler();
//		}
//		if (Franquicia != null)
//		{
//			this.seleccionarFranquicia();
//		}
//		logger.debug("END - completarGarantiasBasicas");
//	}
//
//	public void seleccionarImpagoAlquiler() throws IOException
//	{
//		logger.debug("BEGIN - seleccionarImpagoAlquiler");
//		this.wh.selectValueInDropDownInFrame(this.drpdnImpagoAlquiler, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getImpagoAlquiler()));
//		logger.debug("END - seleccionarImpagoAlquiler");
//	}
//
//	public void seleccionarFranquicia() throws IOException
//	{
//		logger.debug("BEGIN - seleccionarFranquicia");
//		this.wh.selectValueInDropDownInFrame(this.drpdnFranquicia, this.cuerpoFrame,
//				String.valueOf(this.browserContext.getTestCaseData().getFranquiciaMAC()));
//		logger.debug("END - seleccionarFranquicia");
//	}
//
//	public void continuar()
//	{
//		logger.debug("BEGIN - Continuar");
//
//		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
//		logger.debug("END - Continuar");
//	}
//
//	public void selectModalidad()
//	{
//		logger.debug("BEGIN - selectModalidad");
//		this.wh.selectValueInDropDownInFrame(this.drpdwnModalidad, this.cuerpoFrame, this.browserContext.getTestCaseData().getModalidad());
//		logger.debug("END - selectModalidad");
//	}
//
//	public String recuperarTextoMensajeError()
//	{
//		logger.debug("BEGIN - recuperarTextoMensajeError");
//		this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame).substring(2); // Se pone substring para quitar el aspa del boton cerrar que
//																																												 // aparece al principio del mensaje devuelto.
//		// logger.debug("ERROR RECUPERADO - " + this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame).substring(2));
//		logger.debug("END - recuperarTextoMensajeError");
//		return this.wh.getTextFromWebElementInFrame(this.msjError, this.cuerpoFrame);
//	}
//
//	public boolean checkConvertirAProyectoIsPresent()
//	{
//		logger.debug("BEGIN - checkConvertirAProyectoIsEnabled");
//		logger.debug("END - checkConvertirAProyectoIsEnabled");
//		return this.wh.webElementInFrameIsPresent(this.btnConvertirProyecto, this.cuerpoFrame);
//	}
	// endregion
}
