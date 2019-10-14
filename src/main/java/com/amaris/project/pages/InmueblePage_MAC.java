package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

import org.openqa.selenium.By;

public class InmueblePage_MAC extends PageObject {

	// // region webelements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By btnAnadirInmueblePantallaPrincipal = By.cssSelector("#botonAddInmueble");
	private By btnAnadirInmuebleModal = By.cssSelector("#AnyadirInmu");
	private By txtProvincia = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO");
	private By txtPoblacion = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO");
	private By txtNombreVia = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO");
	private By txtNumeroVia = By.cssSelector("#ALTACLIE_BS_NUMVIA");
	
	// TODO comprobar selector repetido
	private By itemProvincia = By.xpath(".//*[@id='ui-active-menuitem']");
	private By itemPoblacion = By.xpath(".//*[@id='ui-active-menuitem']");
	private By itemNomVia = By.xpath(".//*[@id='ui-active-menuitem']");
	// endregion

	public InmueblePage_MAC(UserStory userS) {
		super(userS);
	}
	
	// region Methods
	public InmueblePage_MAC executeActionsInInmueblePage() {
		// TODO I mean... really?
		return AddInmuebleByAddress();
	}

	public InmueblePage_MAC AddInmuebleByAddress() {
		debugBegin();
		webDriver.switchToFrame(mainFrame);
		
		webDriver.click(btnAnadirInmueblePantallaPrincipal);
		
		
		webDriver.appendText(txtProvincia, getScenarioVar("provincia_inm"));
		webDriver.waitWithDriver(3000);
		webDriver.click(itemProvincia);
		
		
		webDriver.appendText(txtPoblacion, getScenarioVar("poblacion_inm"));
		webDriver.waitWithDriver(3000);
		webDriver.click(itemPoblacion);
		
		
		webDriver.appendText(txtNombreVia, getScenarioVar("nombre_via_inm"));
		webDriver.waitWithDriver(3000);
		webDriver.click(itemNomVia);
		
		
		webDriver.appendText(txtNumeroVia, 
			getData(Constants.FICHERO_NUM_VIA).getValue(userS.getScenario(), Constants.NUM_VIA_INMUEBLE));
		webDriver.waitWithDriver(3000);
		webDriver.click(txtNombreVia);
	
		
		webDriver.click(btnAnadirInmuebleModal);
		
		webDriver.exitFrame();
		debugEnd();
		
		return this;
	}
	// endregion
}
