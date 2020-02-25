package com.amaris.project.pages.comun.innova;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class InnovaHomePage extends PageObject {

	// region WebElements
	private By leftFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By logoMutuaBtn = By.cssSelector("#logo");

	private By mutuaEdificioConfortBtn = By.xpath(".//*[normalize-space(text())='Mutua edificio confort']");
	private By mutuaAlquilerConfortBtn = By.cssSelector("a[href*='codmenu=510']");
	private By gestionProjectosSimulacionesBtn = By.cssSelector("a[href*='codmenu=GESTION_COTIZACIONES']");

	private By siniestrosBtn = By.xpath(".//*[text()='Siniestros']");
	private By mediadoresBtn = By.cssSelector("#jt14");
	private By nuevoProjectoBtn = By.xpath(".//*[normalize-space(text())='Nuevo proyecto']");
	private By nuevaSimulacionBtn = By.xpath(".//*[normalize-space(text())='Nueva Simulación']");
	private By menuPrincipalBtn = By.cssSelector("#boton1");
	private By mapaSitioBtn = By.xpath(".//*[contains(text(),'Mapa del sitio')]");

	private By gestionProjectoSimulacionBtn = By.xpath(".//*[text()='Gestión de proyecto/simulación']");
	private By gestionCotizacionesBtn = By.xpath(".//*[text()='Gestión de cotizaciones']");
	private By gestionPolizasBtn = By.xpath(".//*[@title='Gestión de pólizas']");
	private By gestionPolizasMenuBtn = By.cssSelector("a[href*='codmenu=GESTIONDPOLIZAS']");
	private By gestionAutorizacionesBtn = By.cssSelector("[title*='Gestión de autorizaciones']");

	private By menuMecBtn = By.cssSelector("#boton2");
	private By mhcBtn = By.cssSelector("a[href*='codmenu=660']");
	private By gestionPagosBtn = By.cssSelector("[title = 'Gestión de pagos de siniestros  ']");
	private By productoBtn = By.cssSelector("#jt1");
	// endregion

	public InnovaHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public InnovaHomePage createNewProject() {
		debugBegin();
		webDriver.clickInFrame(nuevoProjectoBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openNewSimulationMec() {
		debugBegin();
		webDriver.clickInFrame(nuevaSimulacionBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openMutuaEdificioConfort() {
		debugBegin();
		webDriver.clickInFrame(mutuaEdificioConfortBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage OpenMutuaAlquilerConfort() {
		debugBegin();
		webDriver.clickInFrame(mutuaAlquilerConfortBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openGestionCotizaciones() {
		debugBegin();

		// TODO Codigo original usaba doble clicks, comprobar si hace falta
		webDriver.clickInFrame(mapaSitioBtn, topFrame);
		webDriver.clickInFrame(gestionCotizacionesBtn, mainFrame);

		debugEnd();

		return this;
	}

	public InnovaHomePage openGestionPolizas() {
		debugBegin();

		webDriver.clickInFrame(mapaSitioBtn, topFrame);
		webDriver.clickInFrame(gestionPolizasBtn, mainFrame);

		debugEnd();

		return this;
	}

	public InnovaHomePage openGestionAutorizaciones() {
		debugBegin();

		webDriver.clickInFrame(gestionAutorizacionesBtn, leftFrame);

		debugEnd();

		return this;
	}

	public InnovaHomePage openMenuMEC() {
		debugBegin();
		webDriver.clickInFrame(menuMecBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openInnovaHome() {
		debugBegin();

		webDriver.clickInFrame(menuPrincipalBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openSiniestros() {
		debugBegin();
		
		webDriver.waitWithDriver(8000);
		
		if(webDriver.isPresentInFrame(logoMutuaBtn, topFrame)) {
			webDriver.clickInFrame(logoMutuaBtn, topFrame);
			webDriver.waitWithDriver(3000);
		}

		webDriver.clickInFrame(siniestrosBtn, leftFrame);
		
		debugEnd();

		return this;
	}

	public InnovaHomePage openMediadores() {
		debugBegin();

		webDriver.clickInFrame(productoBtn, leftFrame);
		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(mediadoresBtn, leftFrame);
		webDriver.waitWithDriver(12000);
		debugEnd();

		return this;
	}

	public InnovaHomePage openMHC() {
		debugBegin();
		webDriver.clickInFrame(mhcBtn, leftFrame);
		debugEnd();

		return this;
	}

	public InnovaHomePage openGestionPagos() {
		debugBegin();
		webDriver.clickInFrame(gestionPagosBtn, leftFrame);
		debugEnd();

		return this;
	}

	// endregion
}
