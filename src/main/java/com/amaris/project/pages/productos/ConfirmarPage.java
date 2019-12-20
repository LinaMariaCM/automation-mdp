package com.amaris.project.pages.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.MotivosSuplementoHelper;

public class ConfirmarPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By nextMotivosSuplementoPageBtn = By.xpath(".//*[@aria-label='Siguiente' and contains(@ng-click,'cms.paginator.update(cms.paginator.current + 1)')]");

	private By continuarBtn = By.xpath(".//*[text()='Continuar']");

	private By suplementoCheckbox = By.xpath(".//td[1]/input");
	private By suplementoText = By.xpath(".//td[2]");
	// endregion

	public ConfirmarPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ConfirmarPage activateMotivosSuplementoAndClickOnContinuar() {
		activateMotivosSuplemento();
		clickContinuar();

		return this;
	}

	public ConfirmarPage activateMotivosSuplemento() {
		boolean exists = true;

		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {
			activateMotivosSuplementoInPage(pageNumber);

			if(!existToBeActivatedMotivosSuplemento(pageNumber)) {
				exists = false;
				break;
			} else {
				try {
					webDriver.clickInFrame(nextMotivosSuplementoPageBtn, cuerpoFrame);
				} catch(Exception e) {
					debugError("El boton siguiente no ha aparecido");
				}
			}
		}

		Assert.assertFalse(exists, "El motivo del suplemento no se ha podido seleccionar");

		return this;
	}

	public ConfirmarPage clickContinuar() {
		debugBegin();
		webDriver.scrollToBottomInFrame(cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public List<MotivosSuplementoHelper> getMotivosSuplementoInPage(int pageNumber) {
		debugBegin();

		List<MotivosSuplementoHelper> motivosSuplementoTemp = new ArrayList<>();
		List<MotivosSuplementoHelper> motivosSuplemento = new ArrayList<>();
		motivosSuplemento.addAll(getMotivosSuplementoInPage(pageNumber));

		motivosSuplemento.forEach(p -> motivosSuplementoTemp.add(new MotivosSuplementoHelper(false,
			webDriver.getTextInFrame(suplementoText, cuerpoFrame),
			webDriver.getElementInFrame(suplementoCheckbox, cuerpoFrame),
			pageNumber)));

		debugEnd();

		return motivosSuplementoTemp;
	}

	private ConfirmarPage activateMotivosSuplementoInPage(int pageNumber) {
		debugBegin();

		List<MotivosSuplementoHelper> motivosSuplemento = new ArrayList<>();
		motivosSuplemento.addAll(getMotivosSuplementoInPage(pageNumber));

		motivosSuplemento.stream().filter(p -> MotivosSuplementoHelper.getMotivosSuplementos(userS).containsKey(p.getDescription()))
			.forEach(x -> {
				webDriver.clickInFrame(x.getCheckbox(), cuerpoFrame);

				if(x.getSelected().equals(false)
					&& MotivosSuplementoHelper.getMotivosSuplementos(userS).get(x.getDescription())) {
					x.setSelected(true);
				} else if(x.getSelected().equals(true)
					&& !MotivosSuplementoHelper.getMotivosSuplementos(userS).get(x.getDescription())) {
					x.setSelected(false);
				}
			});

		debugEnd();

		return this;
	}

	private boolean existToBeActivatedMotivosSuplemento(int pageNumber) {
		debugBegin();

		boolean result = false;

		List<MotivosSuplementoHelper> motivosSuplemento = new ArrayList<>();
		motivosSuplemento.addAll(getMotivosSuplementoInPage(pageNumber));

		List<MotivosSuplementoHelper> motivosSuplementoTemp = motivosSuplemento.stream()
			.filter(p -> MotivosSuplementoHelper.getMotivosSuplementos(userS).containsKey(p.getDescription())
				&& p.getSelected().equals(MotivosSuplementoHelper.getMotivosSuplementos(userS).get(p.getDescription())))
			.collect(Collectors.toList());

		if(motivosSuplementoTemp.size() != MotivosSuplementoHelper.getMotivosSuplementos(userS).size()) {
			result = true;
		}

		debugEnd();

		return result;
	}
	// endregion
}