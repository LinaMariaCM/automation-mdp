package com.amaris.project.utils;

import java.awt.AWTException;
import java.io.IOException;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.pages.GestionCotizacionesBuscadorPage;
import com.amaris.project.pages.InnovaHomePage;
import com.amaris.project.pages.InnovaLoginPage;
import com.amaris.project.Constants;

public class InnovaApplicationAccessHelper extends PageObject implements IApplicationAccessHelper {

	private InnovaHomePage innovaHomePage;

	public InnovaApplicationAccessHelper(UserStory userS) {
		super(userS);
	}

	@Override
	public void CreateProject() {
		this.innovaHomePage.createNewProject();
	}

	@Override
	public void CreateSimulation() {
		this.innovaHomePage.openNewSimulationMec();
	}

	@Override
	public void login(String userId, String password) throws Exception {
		switch(this.getTestVar("enviroment")) {
			case Constants.PreEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomePre);
				this.webDriver.go(getTestVar("InnovaHome-Pre"));
				break;
			case Constants.UatEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUAT);
				this.webDriver.go(getTestVar("InnovaHome-UAT"));
				break;
			case Constants.V7Environment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeV7);
				this.webDriver.go(getTestVar("InnovaHome-V7"));
				break;
			case Constants.QAEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeQA);
				this.webDriver.go(getTestVar("InnovaHome-QA"));
				break;
			case Constants.ATMIRAEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeATMIRA);
				this.webDriver.go(getTestVar("InnovaHome-ATMIRA"));
				break;
			case Constants.UpgradeEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUpgrade);
				this.webDriver.go(getTestVar("InnovaHome-Upgrade"));
				break;
			case Constants.SiniestrosEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeSiniestros);
				this.webDriver.go(getTestVar("InnovaHome-Siniestros"));
				break;
			case Constants.MigracionEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeMigracion);
				this.webDriver.go(getTestVar("InnovaHome-Migracion"));
				break;
			case Constants.UatPjEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUatPj);
				this.webDriver.go(getTestVar("InnovaHome-UatPj"));
				break;
			case Constants.HogarMigEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeHogarMig);
				this.webDriver.go(getTestVar("InnovaHome-HogarMig"));
				break;
			case Constants.RecibosCheckEnvironment:
				// this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeHogarMig);
				this.webDriver.go(getTestVar("InnovaHome-RecibosCheck"));
				break;
			default:
				throw new Exception("Environment not available");
		}

		// this.webDriver.maximizeWindow();

		this.setTestVar("mainWindowHandle", (this.webDriver.getMainWindowHandle()));
		InnovaLoginPage innovaLoginPage = new InnovaLoginPage(userS);
		innovaLoginPage.login(userId, password);
		this.innovaHomePage = new InnovaHomePage(userS);
	}

	@Override
	public void OpenMutuaEdificioConfort() throws AWTException, InterruptedException {
		this.innovaHomePage.openMutuaEdificioConfort();
	}

	@Override
	public void openGestionCotizaciones() {
		this.innovaHomePage.openGestionCotizaciones();
	}

	@Override
	public void searchCotizacion(String cotizacion) {
		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
		gestionCotizacionesBuscacorPage.searchCotizacion(cotizacion);
	}

	@Override
	public void OpenGestionPolizas() {
		this.innovaHomePage.OpenGestionPolizas();
	}

	@Override
	public void SearchPolizaByPolizaNumber(String poliza) {
		// GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
		// GestionPolizasBuscadorPage(userS);
		// gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(poliza);
	}

	@Override
	public void loginAndSearchCotizacion(String userId, String password, String cotizacion) throws Exception {
		this.login(userId, password);
		// this.OpenMutuaEdificioConfort();
		this.openGestionCotizaciones();
		this.searchCotizacion(cotizacion);
	}

	@Override
	public void LoginAndSearchPolizaByPolizaNumber(String userId, String password, String poliza) throws Exception {
		this.login(userId, password);
		this.OpenGestionPolizas();
		this.SearchPolizaByPolizaNumber(poliza);
	}

	@Override
	public void LoginAndCreateProjectMEC(String userId, String password) throws Exception {
		this.login(userId, password);
		this.OpenMutuaEdificioConfort();
		this.CreateProject();
	}

	@Override
	public void LoginAndCreateProjectMAC(String userId, String password) throws Exception {
		this.login(userId, password);
		this.OpenMutuaAlquilerConfort();
		this.CreateProject();
	}

	@Override
	public void LoginAndCreateSimulation(String userId, String password) throws Exception {
		this.login(userId, password);

		this.OpenMutuaEdificioConfort();

		this.CreateSimulation();
	}

	@Override
	public void LoginAndSearchPolizaByNifNie(String userId, String password, String nifNie) throws Exception {
		this.login(userId, password);
		this.OpenGestionPolizas();
		this.SearchPolizaByNifNie(nifNie);
	}

	@Override
	public void SearchPolizaByNifNie(String nifNie) {
		// GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
		// GestionPolizasBuscadorPage(userS);
		// gestionPolizasBuscadorPage.SearchPolizaByNifNumber(nifNie);
	}

	@Override
	public void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException {
		this.innovaHomePage.OpenMutuaAlquilerConfort();

	}

	@Override
	public void LoginAndSearchAutorizacion(String userId, String password) throws Exception {
		this.login(userId, password);
	}

}
