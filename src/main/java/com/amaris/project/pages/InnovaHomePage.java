package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class InnovaHomePage extends PageObject {

	// region webelements
	private By leftFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");

	private By btnMutuaEdificioConfort = By.xpath(".//*[normalize-space(text())='Mutua edificio confort']");
	private By btnMutuaAlquilerConfort = By.cssSelector("a[href*='codmenu=510']");
	private By btnGestionProjectosSimulaciones = By.cssSelector("a[href*='codmenu=GESTION_COTIZACIONES']");

	private By btnSiniestros = By.xpath(".//*[text()='Siniestros']");
	private By btnMediadores = By.xpath(".//*[contains(text(),'Mediadores')]");
	private By btnNuevoProjecto = By.xpath(".//*[normalize-space(text())='Nuevo proyecto']");
	private By btnNuevaSimulacion = By.xpath(".//*[normalize-space(text())='Nueva Simulación']");
	private By btnMenuPrincipal = By.cssSelector("#boton1");
	private By btnMapaSitio = By.xpath(".//*[contains(text(),'Mapa del sitio')]");
	
	private By btnGestionProjectoSimulacion = By.xpath(".//*[text()='Gestión de proyecto/simulación']");
	private By btnGestionCotizaciones = By.xpath(".//*[text()='Gestión de cotizaciones']");
	private By btnGestionPolizas = By.xpath(".//*[@title='Gestión de pólizas']");
	private By btnGestionPolizasMenu = By.cssSelector("a[href*='codmenu=GESTIONDPOLIZAS']");
	private By btnGestionAutorizaciones = By.cssSelector("[title*='Gestión de autorizaciones']");

	private By btnMenuMEC = By.cssSelector("#boton2");
	private By btnMHC = By.cssSelector("a[href*='codmenu=660']");
	// endregion

	public InnovaHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public InnovaHomePage createNewProject() {
		debugBegin();
		webDriver.doubleClickInFrame(btnNuevoProjecto, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openNewSimulationMec() {
		debugBegin();
		webDriver.doubleClickInFrame(btnNuevaSimulacion, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openMutuaEdificioConfort() {
		debugBegin();
		webDriver.moveToElementInFrame(btnMutuaEdificioConfort, leftFrame);
		webDriver.doubleClickInFrame(btnMutuaEdificioConfort, leftFrame);
		// webDriver.waitForPageLoadWithAngular();
		debugEnd();
		
		return this;
	}

	public InnovaHomePage OpenMutuaAlquilerConfort() {
		debugBegin();
		webDriver.moveToElementInFrame(btnMutuaAlquilerConfort, leftFrame);
		webDriver.doubleClickInFrame(btnMutuaAlquilerConfort, leftFrame);
		// webDriver.waitForPageLoadWithAngular();
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openGestionCotizaciones() {
		debugBegin();

		// TODO Codigo original usaba doble clicks, comprobar si hace falta
		webDriver.clickInFrame(btnMapaSitio, topFrame);
		webDriver.clickInFrame(btnGestionCotizaciones, mainFrame);
		
		debugEnd();
		
		return this;
	}

	public InnovaHomePage OpenGestionPolizas() {
		debugBegin();

		webDriver.clickInFrame(btnMapaSitio, topFrame);
		webDriver.clickInFrame(btnGestionPolizas, mainFrame);

		debugEnd();
		
		return this;
	}

	public InnovaHomePage OpenGestionAutorizaciones() {
		debugBegin();

		webDriver.scrollToElementInFrame(btnGestionAutorizaciones, leftFrame);
		webDriver.clickInFrame(btnGestionAutorizaciones, leftFrame);
		
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openMenuMEC() {
		debugBegin();
		webDriver.doubleClickInFrame(btnMenuMEC, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openInnovaHome() {
		debugBegin();
		
		// TODO Comprobar si el codigo comentado hace falta
		// webDriver.doubleClickInFrame(btnMenuPrincipal, menuFrame);
		// webDriver.moveToElementInFrameWithJavaScript(btnMenuPrincipal, menuFrame);
		webDriver.clickInFrame(btnMenuPrincipal, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openSiniestros() {
		debugBegin();
		webDriver.doubleClickInFrame(btnSiniestros, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openMediadores() {
		debugBegin();
		webDriver.doubleClickInFrame(btnMediadores, leftFrame);
		debugEnd();
		
		return this;
	}

	public InnovaHomePage openMHC() {
		debugBegin();
		webDriver.doubleClickInFrame(btnMHC, leftFrame);
		debugEnd();
		
		return this;
	}

	// endregion
}
