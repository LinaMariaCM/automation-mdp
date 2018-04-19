package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class PrecioValidacionExcepcionesReglasPage
{
  final static Logger logger = LoggerFactory.getLogger(PrecioValidacionExcepcionesReglasPage.class);
  BrowserContext browserContext;
  private WebElementHelper wh;
  TestCaseData tData;

  // region webelements
  @FindBy(name = "cuerpo")
  private WebElement cuerpoFrame;

  @FindBy(xpath = ".//*[text()='Continuar']")
  private WebElement btnContinuar;
  // endregion

  public PrecioValidacionExcepcionesReglasPage(
      BrowserContext browserContext)
  {
    this.browserContext = browserContext;
    this.wh = browserContext.webElementHelper;
    this.tData = browserContext.getTestCaseData();
    PageFactory.initElements(browserContext.getWebDriver(), this);
  }

  // region methods
  public void ClickOnContinuar()
  {
    logger.debug("BEGIN - ClickOnContinuar");
    this.browserContext.webElementHelper.switchToFrame(this.cuerpoFrame);
    // this.browserContext.webElementHelper.ScrollToEndOfPage();

    this.btnContinuar.click();

    this.browserContext.webElementHelper.exitFromFrame();
    logger.debug("END - ClickOnContinuar");
  }
  // endregion
}
