package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasConfirmarPoliza extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.name("botonContinuar");
	private By btnEmitirSuplemento = By.xpath(".//*[text()='Emitir suplemento' and @ng-click='db.contratar(formDatosBancarios)']");
	// endregion

	public ValidacionExcepcionesReglasConfirmarPoliza(UserStory userS) {
		super(userS);
	}

	// region methods
	public ValidacionExcepcionesReglasConfirmarPoliza ClickOnContinuarButton() {
		debugBegin();
		// if
		// (this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoInclusionExclusionDescuento)
		// ||
		// this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoinclusionMaquinaria)
		// ||
		// this.tData.getMotivosSuplemento().containsKey(MutuaPropietariosConstants.MotivoSuplementoInclusionEnergiaSolar))
		// {
		boolean arePresent = webDriver.waitForElementToBeClickableInFrame(btnContinuar, cuerpoFrame) != null;
		arePresent = arePresent && webDriver.waitForElementToBeClickableInFrame(btnEmitirSuplemento, cuerpoFrame) != null;

		if(arePresent) {
			webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}
	// endregion
}