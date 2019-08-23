package com.amaris.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.MotivosSuplementoHelper;

public class ConfirmarPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By rowWithMotivoSuplemento = By.xpath(".//tr[td[input]]");
	private List<WebElement> rowWithMotivoSuplementoList = new ArrayList<>();

	private By btnNextMotivosSuplementoPage = By.xpath(".//*[@aria-label='Siguiente' and contains(@ng-click,'cms.paginator.update(cms.paginator.current + 1)')]");

	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	private String xPathFilterSuplementoCheckbox = ".//td[1]/input";
	private String xPathFilterSuplementoText = ".//td[2]";
	// endregion

	public ConfirmarPage(UserStory userS) {
		super(userS);
	}

	private List<MotivosSuplementoHelper> motivosSuplemento = new ArrayList<>();

	// region methods

	public ConfirmarPage ActivateMotivosSuplementoAndClickOnContinuar() {
		ActivateMotivosSuplemento();
		ClickOnContinuar();

		return this;
	}

	public ConfirmarPage ActivateMotivosSuplemento() {
		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {

			ActivateMotivosSuplementoInPage(pageNumber);

			if(!ExistToBeActivatedMotivosSuplemento()) {
				break;
			} else {
				try {
					webDriver.clickInFrame(btnNextMotivosSuplementoPage, cuerpoFrame);
				} catch(Exception e) {
					debugError("El boton siguiente no ha aparecido");
				}
			}
		}

		Assert.assertFalse(ExistToBeActivatedMotivosSuplemento(), "El motivo del suplemento no se ha podido seleccionar");

		return this;
	}

	public ConfirmarPage ClickOnContinuar() {
		debugBegin();
		// webDriver.waitForPageLoadWithAngular();
		// wh.waitForPageLoadWithAngular();
		webDriver.scrollToBottom();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public List<MotivosSuplementoHelper> GetMotivosSuplementoInPage(Integer pageNumber) {
		debugBegin();
		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.waitForPageLoadWithAngular();

		List<MotivosSuplementoHelper> motivosSuplementoTemp = new ArrayList<>();

		rowWithMotivoSuplementoList.forEach(p -> {
			WebElement element = p.findElement(By.xpath(xPathFilterSuplementoCheckbox));

			if(element.isSelected()) {
				motivosSuplementoTemp.add(new MotivosSuplementoHelper(true,
					p.findElement(By.xpath(xPathFilterSuplementoText)).getText(),
					p.findElement(By.xpath(xPathFilterSuplementoCheckbox)),
					pageNumber));
			} else {
				motivosSuplementoTemp.add(new MotivosSuplementoHelper(false,
					p.findElement(By.xpath(xPathFilterSuplementoText)).getText(),
					p.findElement(By.xpath(xPathFilterSuplementoCheckbox)),
					pageNumber));
			}
		});
		// webDriver.exitFrame();

		debugEnd();

		return motivosSuplementoTemp;
	}

	private ConfirmarPage ActivateMotivosSuplementoInPage(Integer pageNumber) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		motivosSuplemento.addAll(GetMotivosSuplementoInPage(pageNumber));

		motivosSuplemento.stream().filter(p -> MotivosSuplementoHelper.getMotivosSuplementos(userS).containsKey(p.getDescription()))
			.forEach(x -> {
				if(x.getSelected().equals(false) && MotivosSuplementoHelper.getMotivosSuplementos(userS).get(x.getDescription())) {
					// wh.clickOnWebElementInFrame(x.getCheckbox(), cuerpoFrame);
					webDriver.click(x.getCheckbox());
					x.setSelected(true);
				} else if(x.getSelected().equals(true) && !MotivosSuplementoHelper.getMotivosSuplementos(userS).get(x.getDescription())) {
					// wh.clickOnWebElementInFrame(x.getCheckbox(), cuerpoFrame);
					webDriver.click(x.getCheckbox());
					x.setSelected(false);
				}
			});

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	private boolean ExistToBeActivatedMotivosSuplemento() {
		debugBegin();

		boolean result = false;

		List<MotivosSuplementoHelper> motivosSuplementoTemp = motivosSuplemento.stream()
			.filter(p -> MotivosSuplementoHelper.getMotivosSuplementos(userS).containsKey(p.getDescription())
				&&
				p.getSelected().equals(MotivosSuplementoHelper.getMotivosSuplementos(userS).get(p.getDescription())))
			.collect(Collectors.toList());

		if(motivosSuplementoTemp.size() != MotivosSuplementoHelper.getMotivosSuplementos(userS).size()) {
			result = true;
		}

		debugEnd();

		return result;
	}
	// endregion
}