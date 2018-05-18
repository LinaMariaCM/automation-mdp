package com.project.utils;

//public class GestionOnlineAccessHelper implements IApplicationAccessHelper
//{
//	private BrowserContext browserContext;
//	private GestionOnlineHomePage gestionOnlineHomePage;
//
//	public GestionOnlineAccessHelper(BrowserContext browserContext) throws IOException
//	{
//		this.browserContext = browserContext;
//	}
//
//	@Override
//	public void CreateProject()
//	{
//		this.gestionOnlineHomePage.createNewProject();
//	}
//
//	@Override
//	public void CreateSimulation()
//	{
//		this.gestionOnlineHomePage.createNewSimulation();
//	}
//
//	@Override
//	public void login(
//			String userId, String password) throws Exception
//	{
//		switch (this.browserContext.getProperties().environment)
//		{
//			case ProjectConstants.PreEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlinePre);
//				break;
//			case ProjectConstants.UatEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineUAT);
//				break;
//			case ProjectConstants.QAEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineQA);
//				break;
//			case ProjectConstants.ATMIRAEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineATMIRA);
//				break;
//			case ProjectConstants.UpgradeEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineUpgrade);
//				break;
//			case ProjectConstants.SiniestrosEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineSiniestros);
//				break;
//			case ProjectConstants.V7Environment:
//				// this.browserContext.GetWebDriver().get(browserContext.GetProperties().mu);
//				break;
//			case ProjectConstants.MigracionEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineMigracion);
//				break;
//			case ProjectConstants.UatPjEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineUatPj);
//				break;
//			case ProjectConstants.HogarMigEnvironment:
//				this.browserContext.getWebDriver().get(this.browserContext.getProperties().mutuaGestionOnlineHogarMig);
//				break;
//			default:
//				throw new Exception("Environment not available");
//		}
//		this.browserContext.getTestCaseData().setMainWindowHandle(this.browserContext.webElementHelper.getMainWindowHandle());
//		GestionOnlineLoginPage gestionOnlineLoginPage = new GestionOnlineLoginPage(this.browserContext);
//		gestionOnlineLoginPage.Login(userId, password);
//		this.gestionOnlineHomePage = new GestionOnlineHomePage(this.browserContext);
//		this.gestionOnlineHomePage.acceptCookies();
//		this.gestionOnlineHomePage.closeNovedadesDialog();
//	}
//
//	@Override
//	public void OpenMutuaEdificioConfort() throws AWTException, InterruptedException, IOException
//	{
//		this.gestionOnlineHomePage.openMutuaEdificioConfort();
//	}
//
//	// @Override
//	// public void openMisProyectosWeb() throws AWTException, InterruptedException, IOException
//	// {
//	// this.gestionOnlineHomePage.openMisProyectosWeb();
//	
//	// }
//
//	@Override
//	public void searchCotizacion(
//			String cotizacion) throws AWTException, InterruptedException, IOException
//	{
//		// GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//		// gestionCotizacionesBuscacorPage.searchCotizacion(cotizacion);
//		this.gestionOnlineHomePage.buscarProyectoWeb(cotizacion);
//	}
//
//	@Override
//	public void OpenGestionPolizas()
//	{
//		// this.gestionOnlineHomePage.openGestionCotizaciones();
//	}
//
//	@Override
//	public void SearchPolizaByPolizaNumber(
//			String poliza)
//	{
//		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
//		gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(poliza);
//	}
//
//	@Override
//	public void loginAndSearchCotizacion(
//			String userId, String password, String cotizacion) throws Exception
//	{
//		this.login(userId, password);
//		// this.OpenMutuaEdificioConfort();
//		this.openGestionCotizaciones();
//		this.searchCotizacion(cotizacion);
//	}
//
//	@Override
//	public void LoginAndSearchPolizaByPolizaNumber(
//			String userId, String password, String poliza) throws Exception
//	{
//		this.login(userId, password);
//		this.OpenGestionPolizas();
//		this.SearchPolizaByPolizaNumber(poliza);
//	}
//
//	@Override
//	public void LoginAndCreateProjectMEC(
//			String userId, String password) throws Exception
//	{
//		this.login(userId, password);
//		this.OpenMutuaEdificioConfort();
//		this.CreateProject();
//	}
//
//	@Override
//	public void LoginAndCreateProjectMAC(
//			String userId, String password) throws Exception
//	{
//		this.login(userId, password);
//		this.OpenMutuaAlquilerConfort();
//		this.CreateProject();
//	}
//
//	@Override
//	public void LoginAndCreateSimulation(
//			String userId, String password) throws Exception
//	{
//		this.login(userId, password);
//		
//		this.OpenMutuaEdificioConfort();
//		
//		// this.CreateSimulation();
//	}
//
//	@Override
//	public void LoginAndSearchPolizaByNifNie(
//			String userId, String password, String nifNie) throws Exception
//	{
//		this.login(userId, password);
//		this.OpenGestionPolizas();
//
//	}
//
//	@Override
//	public void SearchPolizaByNifNie(
//			String nifNie)
//	{
//		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
//		gestionPolizasBuscadorPage.SearchPolizaByNifNumber(nifNie);
//	}
//	
//	@Override
//	public void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException
//	{
//		this.gestionOnlineHomePage.openMutuaAlquilerConfort();
//	}
//	
//	@Override
//	public void LoginAndSearchAutorizacion(
//			String userId, String password) throws Exception
//	{
//		this.login(userId, password);
//	}
//	
//	@Override
//	public void openGestionCotizaciones() throws AWTException, InterruptedException, IOException
//	{
//		this.gestionOnlineHomePage.openMisProyectosWeb();
//	}
//}
