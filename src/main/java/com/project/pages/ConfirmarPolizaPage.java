package com.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.Helpers.MotivosSuplementoHelper;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ConfirmarPolizaPage
{
	final static Logger logger = LoggerFactory.getLogger(ClausulasPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	
	// region webelements
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;
	
	@FindBy(xpath = ".//tr[td[input]]")
	private List<WebElement> rowWithMotivoSuplemento;
	
	@FindBy(xpath = ".//*[@aria-label='Siguiente' and contains(@ng-click,'cms.paginator.update(cms.paginator.current + 1)')]")
	private WebElement btnNextMotivosSuplementoPage;
	
	@FindBy(xpath = ".//*[text()='Continuar']")
	private WebElement btnContinuar;
	// endregion
	
	private String xPathFilterSuplementoCheckbox = ".//td[1]/input";
	private String xPathFilterSuplementoText = ".//td[2]";
	
	private List<MotivosSuplementoHelper> motivosSuplemento = new ArrayList<>();
	
	public ConfirmarPolizaPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	}
	
	// region methods
	
	public void ActivateMotivosSuplementoAndClickOnContinuar()
	{
		this.ActivateMotivosSuplemento();
		this.ClickOnContinuar();
	}
	
	public void ActivateMotivosSuplemento()
	{
		for (int pageNumber = 1; pageNumber <= 6; pageNumber++)
		{
			
			this.ActivateMotivosSuplementoInPage(pageNumber);
			
			if (!this.ExistToBeActivatedMotivosSuplemento())
			{
				break;
			}
			else
			{
				try
				{
					this.wh.clickOnWebElementInFrame(this.btnNextMotivosSuplementoPage, this.cuerpoFrame);
				}
				catch (Exception e)
				{
					logger.trace("El boton siguiente no ha aparecido", e);
				}
			}
		}
		
		Assert.assertFalse("El motivo del suplemento no se ha podido seleccionar", this.ExistToBeActivatedMotivosSuplemento());
	}
	
	public void ClickOnContinuar()
	{
		logger.debug("BEGIN - ClickOnContinuar");
		// this.wh.waitForPageLoadWithAngular();
		// this.wh.waitForPageLoadWithAngular();
		this.wh.scrollToEndOfPage();
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}
	
	public List<MotivosSuplementoHelper> GetMotivosSuplementoInPage(
			Integer pageNumber)
	{
		logger.debug("BEGIN - GetListMotivosSuplementoInPage");
		// this.wh.switchToFrame(this.cuerpoFrame);
		this.wh.waitForPageLoadWithAngular();
		
		List<MotivosSuplementoHelper> motivosSuplementoTemp = new ArrayList<>();
		
		this.rowWithMotivoSuplemento.forEach(p ->
		{
			WebElement element = p.findElement(By.xpath(this.xPathFilterSuplementoCheckbox));
			if (element.isSelected())
			{
				motivosSuplementoTemp.add(new MotivosSuplementoHelper(true, p.findElement(By.xpath(this.xPathFilterSuplementoText)).getText(),
						p.findElement(By.xpath(this.xPathFilterSuplementoCheckbox)), pageNumber));
			}
			else
			{
				motivosSuplementoTemp.add(new MotivosSuplementoHelper(false, p.findElement(By.xpath(this.xPathFilterSuplementoText)).getText(),
						p.findElement(By.xpath(this.xPathFilterSuplementoCheckbox)), pageNumber));
			}
		});
		// this.wh.exitFromFrame();
		logger.debug("END - GetListMotivosSuplementoInPage");
		
		return motivosSuplementoTemp;
	}
	
	private void ActivateMotivosSuplementoInPage(
			Integer pageNumber)
	{
		this.wh.switchToFrame(this.cuerpoFrame);
		this.motivosSuplemento.addAll(this.GetMotivosSuplementoInPage(pageNumber));
		this.motivosSuplemento.stream().filter(p -> this.browserContext.getTestCaseData().getMotivosSuplemento().containsKey(p.getDescription()))
				.forEach(x ->
				{
					if (x.getSelected().equals(false) && this.browserContext.getTestCaseData().getMotivosSuplemento().get(x.getDescription()))
					{
						
						// this.wh.clickOnWebElementInFrame(x.getCheckbox(), this.cuerpoFrame);
						this.wh.clickOnWebElement(x.getCheckbox());
						x.setSelected(true);
					}
					else if (x.getSelected().equals(true) && !this.browserContext.getTestCaseData().getMotivosSuplemento().get(x.getDescription()))
					{
						
						// this.wh.clickOnWebElementInFrame(x.getCheckbox(), this.cuerpoFrame);
						this.wh.clickOnWebElement(x.getCheckbox());
						x.setSelected(false);
					}

				});
		this.wh.exitFromFrame();
	}
	
	private boolean ExistToBeActivatedMotivosSuplemento()
	{
		List<MotivosSuplementoHelper> motivosSuplementoTemp = this.motivosSuplemento.stream()
				.filter(p -> this.browserContext.getTestCaseData().getMotivosSuplemento().containsKey(p.getDescription())
						&& p.getSelected().equals(this.browserContext.getTestCaseData().getMotivosSuplemento().get(p.getDescription())))
				.collect(Collectors.toList());
		
		if (motivosSuplementoTemp.size() == this.browserContext.getTestCaseData().getMotivosSuplemento().size())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// endregion
}
