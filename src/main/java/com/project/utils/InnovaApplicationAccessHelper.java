package com.project.utils;

import java.awt.AWTException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.webDriver.BrowserContext;
import com.mutuaPropietarios.testCasesData.Pages.GestionCotizacionesBuscadorPage;
import com.mutuaPropietarios.testCasesData.Pages.GestionPolizasBuscadorPage;
import com.mutuaPropietarios.testCasesData.Pages.InnovaHomePage;
import com.mutuaPropietarios.testCasesData.Pages.InnovaLoginPage;
import com.project.ProjectConstants;
import com.project.TestCaseData;

public class InnovaApplicationAccessHelper implements IApplicationAccessHelper
{
	final static Logger logger = LoggerFactory.getLogger(InnovaApplicationAccessHelper.class);
	BrowserContext browserContext;
	TestCaseData tData;
	private InnovaHomePage innovaHomePage;
	
	public InnovaApplicationAccessHelper(BrowserContext browserContext2) throws IOException
	{
		this.browserContext = browserContext2;
	}
	
	@Override
	public void CreateProject()
	{
		this.innovaHomePage.CreateNewProject();
	}
	
	@Override
	public void CreateSimulation()
	{
		this.innovaHomePage.CreateNewSimulation();
	}
	
	@Override
	public void login(
			String userId, String password) throws Exception
	{
		switch (this.browserContext.getProperties().environment)
		{
			case ProjectConstants.PreEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomePre);
				break;
			case ProjectConstants.UatEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUAT);
				break;
			case ProjectConstants.V7Environment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeV7);
				break;
			case ProjectConstants.QAEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeQA);
				break;
			case ProjectConstants.ATMIRAEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeATMIRA);
				break;
			case ProjectConstants.UpgradeEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUpgrade);
				break;
			case ProjectConstants.SiniestrosEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeSiniestros);
				break;
			case ProjectConstants.MigracionEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeMigracion);
				break;
			case ProjectConstants.UatPjEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeUatPj);
				break;
			case ProjectConstants.HogarMigEnvironment:
				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaInnovaHomeHogarMig);
				break;
			default:
				throw new Exception("Environment not available");
		}
		this.browserContext.getWebDriver().manage().window().maximize();
		this.browserContext.getTestCaseData().setMainWindowHandle(this.browserContext.webElementHelper.getMainWindowHandle());
		InnovaLoginPage innovaLoginPage = new InnovaLoginPage(this.browserContext);
		innovaLoginPage.login(userId, password);
		this.innovaHomePage = new InnovaHomePage(this.browserContext);
	}
	
	@Override
	public void OpenMutuaEdificioConfort() throws AWTException, InterruptedException
	{
		this.innovaHomePage.openMutuaEdificioConfort();
	}
	
	@Override
	public void openGestionCotizaciones()
	{
		this.innovaHomePage.OpenGestionCotizaciones();
	}
	
	@Override
	public void searchCotizacion(
			String cotizacion)
	{
		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
		gestionCotizacionesBuscacorPage.searchCotizacion(cotizacion);
	}
	
	@Override
	public void OpenGestionPolizas()
	{
		this.innovaHomePage.OpenGestionPolizas();
	}
	
	@Override
	public void SearchPolizaByPolizaNumber(
			String poliza)
	{
		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
		gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(poliza);
	}
	
	@Override
	public void loginAndSearchCotizacion(
			String userId, String password, String cotizacion) throws Exception
	{
		this.login(userId, password);
		// this.OpenMutuaEdificioConfort();
		this.openGestionCotizaciones();
		this.searchCotizacion(cotizacion);
	}
	
	@Override
	public void LoginAndSearchPolizaByPolizaNumber(
			String userId, String password, String poliza) throws Exception
	{
		this.login(userId, password);
		this.OpenGestionPolizas();
		this.SearchPolizaByPolizaNumber(poliza);
	}
	
	@Override
	public void LoginAndCreateProjectMEC(
			String userId, String password) throws Exception
	{
		this.login(userId, password);
		this.OpenMutuaEdificioConfort();
		this.CreateProject();
	}
	
	@Override
	public void LoginAndCreateProjectMAC(
			String userId, String password) throws Exception
	{
		this.login(userId, password);
		this.OpenMutuaAlquilerConfort();
		this.CreateProject();
	}
	
	@Override
	public void LoginAndCreateSimulation(
			String userId, String password) throws Exception
	{
		this.login(userId, password);
		
		this.OpenMutuaEdificioConfort();

		this.CreateSimulation();
	}
	
	@Override
	public void LoginAndSearchPolizaByNifNie(
			String userId, String password, String nifNie) throws Exception
	{
		this.login(userId, password);
		this.OpenGestionPolizas();
		this.SearchPolizaByNifNie(nifNie);
	}
	
	@Override
	public void SearchPolizaByNifNie(
			String nifNie)
	{
		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
		gestionPolizasBuscadorPage.SearchPolizaByNifNumber(nifNie);
	}

	@Override
	public void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException
	{
		this.innovaHomePage.OpenMutuaAlquilerConfort();
		
	}
	
	@Override
	public void LoginAndSearchAutorizacion(
			String userId, String password) throws Exception
	{
		this.login(userId, password);
	}
	
}
