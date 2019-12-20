package com.amaris.project.pages.productos.mac;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class InmueblePageMac extends PageObject {

	// // region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By anyadirInmueblePantallaPrincipalBtn = By.cssSelector("#botonAddInmueble");
	private By anyadirInmuebleModalInput = By.cssSelector("#AnyadirInmu");
	private By provinciaInput = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO");
	private By nombreViaInput = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO");
	private By numeroViaInput = By.cssSelector("#ALTACLIE_BS_NUMVIA");

	private By poblacionBtn = By.xpath(".//*[@id='ui-active-menuitem']");
	private By nomViaBtn = By.xpath(".//*[@id='ui-active-menuitem']");
	// endregion

	public InmueblePageMac(UserStory userS) {
		super(userS);
	}

	// region Methods
	public InmueblePageMac addInmuebleByAddress() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);

		webDriver.click(anyadirInmueblePantallaPrincipalBtn);

		webDriver.appendText(provinciaInput, getScenarioVar(Constants.PROVINCIA_INMUEBLE));
		webDriver.waitWithDriver(3000);
		webDriver.click(poblacionBtn);

		webDriver.appendText(poblacionInput, getScenarioVar(Constants.POBLACION_INMUEBLE));
		webDriver.waitWithDriver(3000);
		webDriver.click(poblacionBtn);

		webDriver.appendText(nombreViaInput, getScenarioVar(Constants.NOMBRE_VIA_INMUEBLE));
		webDriver.waitWithDriver(3000);
		webDriver.click(nomViaBtn);

		webDriver.appendText(numeroViaInput, getData(Constants.FICHERO_NUM_VIA).getValue(userS.getScenario(), Constants.NUM_VIA_INMUEBLE));
		webDriver.waitWithDriver(3000);
		webDriver.click(nombreViaInput);

		webDriver.click(anyadirInmuebleModalInput);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}
	// endregion
}
