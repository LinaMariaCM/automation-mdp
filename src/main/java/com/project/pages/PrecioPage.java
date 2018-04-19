package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class PrecioPage
{
	final static Logger logger = LoggerFactory.getLogger(PrecioPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;
	
	// private String cssFilterSelectedCheckboxes = "input:checked[type=checkbox]";
	// private String xPathFilterClausulaText = "/td[6]";
	// private String xPathFilterClausulaNumber = "/td[4]";
	
	@FindBy(xpath = ".//*[contains(text(),'Convertir a proyecto')]")
	private WebElement btnConvertirAProyecto;
	
	// checkbox of a clausula
	// @FindBy(xpath = ".//tr[td[contains(text(),'Responsabilidad Civil y daños propios causados por
	// aguas comunitarias') and
	// contains(@ng-bind-html,'item.descripcion')]]/td[1]/input")
	// private WebElement chkClausula;
	
	// @FindBy(css = "input:checked[type=checkbox]")
	// private WebElement chkSelectedCheckboxes;
	
	// Rows with a checkbox and a clausula
	@FindBy(xpath = ".//tr[td[input]]")
	private List<WebElement> rowCheckboxWithClausula;
	
	@FindBy(xpath = ".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private WebElement clausulaPageSelector;
	
	@FindBy(xpath = ".//*[text()='Continuar']")
	private WebElement btnContinuar;
	
	@FindBy(css = "table.wideBox strong")
	private WebElement msgAvisoSistema;

	@FindBy(id = "logo")
	private WebElement logoMutua;
	
	@FindBy(id = "jt2")
	private WebElement productoMec;

	// endregion
	
	public PrecioPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	public void ExecuteActionsInPrecioPage()
	{
		
	}
	
	// region methods
	public void ClickOnConvertirAProjecto()
	{
		logger.debug("BEGIN - ClickOnConvertirAProjecto");
		this.wh.clickOnWebElementInFrame(this.btnConvertirAProyecto, this.cuerpoFrame);

		if (this.wh.webElementInFrameIsPresent(this.msgAvisoSistema, this.cuerpoFrame))
		{
			System.out.println("*** Excepción general al convertir a proyecto.");
		}
		logger.debug("END - ClickOnConvertirAProjecto");
	}
	
}
