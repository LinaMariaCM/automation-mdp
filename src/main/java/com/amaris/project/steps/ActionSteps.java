package com.amaris.project.steps;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.automation.model.utils.ArrayUtils;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.InitUtils;
import com.amaris.automation.model.webdriver.DriverHelper;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.By;

import com.amaris.project.Constants;
import com.amaris.project.pages.*;
import com.amaris.project.utils.ClausulasHelper;
import com.amaris.project.utils.MotivosSuplementoHelper;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class ActionSteps extends InteractionObject {

	public ActionSteps(UserStory userStory) {
		super(userStory);
	}

	public static String getDayOfWeek() {
		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US);
	}

	public void login(String accessType, String user) throws Exception {
		debugBegin();
		// scenario = scenario;
		/*
		 * webDriver = WebDriverCreation.CreateWebDriver(BrowserType.valueOf( configurationProperties.Browser));
		 * webElementHelper = new WebElementHelper(webDriver, scenario, configurationProperties); webDriverConfiguration
		 * = new CommonConfiguration(webDriver); webDriverConfiguration.SetWebDriverTimeouts();
		 * webDriverConfiguration.MaximizeWindow();
		 */

		// com.amaris.project.utils.IApplicationAccessHelper.initialize(AccessType,
		// webDriver);
		String environment = InitUtils.getStringConfigVariable(Constants.ENTORNO, userS.getConfigData());
		System.out.println("*** environment: " + environment);
		System.out.println("*** access type: " + accessType);
		System.out.println("*** user: " + user);
		new LoginPage(userS).logIn(environment, accessType, user);
		debugEnd();
	}

	public void inicio_sesion_con_acceso_y_usuario() throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
	}

	public void buscar_poliza_por_numero_de_poliza(String poliza) {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS).OpenGestionPolizas();
		}

		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
		gestionPolizasBuscadorPage.buscarPorNumeroPoliza(poliza);
	}

	public void buscar_poliza_por_numero_documento(String numDocumento) {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS).OpenGestionPolizas();
		}

		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
		gestionPolizasBuscadorPage.buscarPolizaPorNumeroNif(numDocumento);
	}

	public void buscar_cotizacion_por_numero_cotizacion(String acceso, String noCotizacion) {
		if(acceso.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openGestionCotizaciones();

			new GestionCotizacionesBuscadorPage(userS)
				.searchCotizacion(noCotizacion);
		} else if(acceso.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openMisProyectosWeb()
				.buscarProyectoWeb(noCotizacion);
		}
	}

	public void crear_proyecto_MEC() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openMutuaEdificioConfort()
				.createNewProject();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaEdificioConfort()
				.createNewProject();
		}
	}

	public void crear_proyecto_MAC() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.OpenMutuaAlquilerConfort()
				.createNewProject();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaAlquilerConfort()
				.createNewProject();
		}
	}

	public void crear_simulacion() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.OpenMutuaAlquilerConfort()
				.openNewSimulationMec();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaAlquilerConfort()
				.createNewSimulation();
		}
	}

	// método pensado para acabar con las esperas que cortan la ejecución
	// automática

	public static void waitForIt(DriverHelper webDriver) {
		By loaderModal = By.cssSelector("#modalLoader");
		By procesandoWindow = By.cssSelector(".smallbox");

		if(webDriver.isPresent(loaderModal)) webDriver.waitForElementNotToBeClickable(loaderModal);
		else webDriver.waitWithDriver(2500);

		if(webDriver.isPresent(procesandoWindow)) webDriver.waitForElementNotToBeClickable(procesandoWindow);
		else webDriver.waitWithDriver(2500);

	}

	// método pensado para acabar con las esperas que cortan la ejecución
	// automática genérico

	public static void waitForIt(DriverHelper webDriver, By by) {
		if(webDriver.isPresent(by)) webDriver.waitForElementNotToBeClickable(by);
		else webDriver.waitWithDriver(2500);
	}

	// mismo método con 2 elementos genéricos de entrada
	public static void waitForIt(DriverHelper webDriver, By by, By cy) {
		waitForIt(webDriver, by);
		waitForIt(webDriver, cy);
	}

	// cuando se necesita esperar x milisegundos
	public static void waitForIt(DriverHelper webDriver, int x) {
		webDriver.waitWithDriver(x);
	}

	public void contratar_poliza_MEC(String loginAcess, String user) throws Exception {
		debugBegin();

		// loginAcess = userS.getTestVar(Constants.ACCESO);

		// userS.getTestVar(Constants.ACCESO);
		// userS.getConfigVar("gestion_online_disponible");
		// if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
		// &&
		// getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(ProjectConstants.GestionOnlineDisponible)
		// &&
		// userS.getTestVar("get_propeties").equals(ProjectConstants.GestionOnlineDisponible)
		// &&
		// Boolean.parseBoolean(userS.getConfigVar("GestionOnlineDisponible"))
		// || loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
		// Convertir a un step de ir a X entorno pasado por el parametro
		// Constants.ACCESO

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) { // && !mediador.equals("640")) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();
			// new GestionOnlineHomePage(userS).createNewSimulation();
			// new
			// AsignarMediadorPage(userS).selectMediadorAndClickOnContinuar(userS.getScenario());
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();
			new AsignarMediadorPage(userS)
				.SeleccionarMediadorPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		// The testId variable has been set here because the FillTomadorData
		// from DatosBasicosTomadorPage requires it. Not sure if this is the
		// proper usage.
		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickOnContinue();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgoMinimos();

		// new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
		// .ClickOnContinuarAndValidate();

		// Revisar si el paso de parámetros es el adecuado
		// new
		// ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();

		// Revisar si el paso de parámetros es el adecuado
		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.ClickOnContinuarAndValidate();

		new PrecioPage(userS)
			.ClickOnConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.FillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickOnContinuar();

		new PrecioPorModalidadPage(userS)
			// .executeActionsInPrecioPorModalidadPage();
			.clickOnContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickOnContinuarButton();

		new ClausulasPage(userS)
			.ActivateclausesAndClickOnContinue();

		// new DatosBasicosTomadorPage(userS)
		// .fillTomadorData(getScenarioVar("tomador"))
		// .clickOnContinuar();

		// new DatosBasicosTomadorPage(userS)
		// .anyadirDatosMin();

		// new PrecioPorModalidadPage(userS)
		// .executeActionsInPrecioPorModalidadPage();

		// new ValidacionExcepcionesReglasPage(userS)
		// .clickOnContinuarButton();

		// new ClausulasPage(userS)
		// .activateclausesAndClickOnContinue();

		new TomadorYAseguradoPage(userS)
			.AddDatosTomador()
			.AddDatosTomadorDiferenteAsegurado()
			.clickOnContinuar();

		new DocumentacionPage(userS)
			.SubirFichero();

		new DatosBancariosPage(userS)
			.introducirFormaPagoYPulsarContratar();

		// new DataSteps(userS).imprimir_informacion_del_proyecto();
		userS.getWebDriver().quit();

		new DocumentacionPage(userS)
			.SubirFichero();

		new DatosBancariosPage(userS)
			.introducirFormaPagoYPulsarContratar();

		userS.getWebDriver().quit();
		// }

		debugEnd();
	}

	public void selecciono_Hay_una_gasolinera_a_menos_de_m(int arg1) {
		userS.setTestVar(Constants.GASOLINERA_MENOS_50M, "true");
		// userS.getTestCaseData().setGasolineraMenos50M(true);
	}

	public void openSimulationMec() {
		new InnovaHomePage(userS).openMutuaEdificioConfort();
		new InnovaHomePage(userS).openNewSimulationMec();
	}

	public void crear_un_proyecto_MAC(String loginAccess, String user) throws Exception {
		debugBegin();
		// Login
		login(loginAccess, user);

		// Create project MAC
		createProjectMAC(loginAccess);

		// Assign mediador
		String mediador = getScenarioVar(Constants.MEDIADOR);
		if(loginAccess.equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		} else if(loginAccess.equals(Constants.LoginAccessInnova)) {

			new AsignarMediadorPage(userS)
				.SeleccionarMediadorMACPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		// Precio
		new PrecioPorModalidadPageMAC(userS)
			.executeActionsInPrecioPorModalidadPage();

		// SCS Precio
		// PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
		// PrecioPorModalidadPage_MAC(userS);
		// precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();

		// Inquilinos
		new InquilinosAvalistasPageMAC(userS).executeActionsInInquilinosAvalistasPage();

		// SCS Inquilinos
		// InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
		// InquilinosAvalistasPage_MAC(userS);
		// inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage();
		debugEnd();
	}

	public void createProjectMAC(String accessType) throws Exception {
		debugBegin();

		if(accessType.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();
		} else if(accessType.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS).OpenMutuaAlquilerConfort();
			new InnovaHomePage(userS).createNewProject();
		}

		debugEnd();
	}

	public void searchAuthorisation() throws Exception {
		new InnovaHomePage(userS).OpenGestionAutorizaciones();
		new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION));
	}

	public void enviar_el_proyecto_a_la_compania() {
		debugBegin();
		new InquilinosAvalistasPageMAC(userS).enviarACompania();
		debugEnd();
	}

	public void login_y_autorizar_el_proyecto_MAC(String loginAccess, String user) throws Exception {
		debugBegin();
		login(loginAccess, user);
		searchAuthorisation();
		new GestionAutorizacionesPage(userS).autorizar();

		userS.getWebDriver().quit();
		debugEnd();
	}

	public void completo_el_proceso_de_contratacion_MAC(String accessType, String user) throws Exception {
		debugBegin();
		login(accessType, user);

		if(accessType.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openMisProyectosWeb()
				.buscarProyectoWeb(getTestVar(Constants.NUM_COTIZACION));

			new GestionOnlineHomePage(userS)
				.modificarProyecto();
		} else if(accessType.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openGestionCotizaciones();

			new GestionCotizacionesBuscadorPage(userS)
				.searchCotizacion(getTestVar(Constants.NUM_COTIZACION));

			new GestionCotizacionesBuscadorPage(userS)
				.modificarProjecto();

			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		}

		new PrecioPorModalidadPageMAC(userS).clickContinuar();
		new InquilinosAvalistasPageMAC(userS).clickContinuar();
		// Completar paso Contratación
		new ContratacionPage_MAC(userS).ExecuteActionsInContratacionPage();

		// loginAcess = getScenarioVar(Constants.ACCESO);
		// if
		// (loginAcess.equals(Constants.LoginAccessGestionLine))
		// {
		// // Login a GestionLine
		// userS.initializeVariables(loginAcess =
		// getScenarioVar(Constants.ACCESO));
		// //
		// userS.applicationAccessHelper.LoginAndCreateProjectMAC(tCData.getUsuario(),
		// // userS.getProperties().passwordComun);
		//
		// //
		// userS.applicationAccessHelper.loginAndSearchCotizacion(tCData.getUsuario(),
		// // userS.getProperties().passwordComun);
		// userS.applicationAccessHelper.loginAndSearchCotizacion(tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// tCData.getNoCotizacionMAC());
		//
		// // Abrir el buscador de proyectos
		// GestionOnlineHomePage gestionOnlineHomePage = new
		// GestionOnlineHomePage(userS);
		// // gestionOnlineHomePage.openMisProyectosWeb();
		// //
		// gestionOnlineHomePage.buscarProyectoWeb(tCData.getNoCotizacionMAC());
		//
		// // Click en modificar
		// gestionOnlineHomePage.modificarProyecto();
		// }
		//
		// else if
		// (loginAcess.equals(Constants.LoginAccessInnova))
		// {
		//
		// // Login to Innov@
		// userS.initializeVariables(loginAcess =
		// getScenarioVar(Constants.ACCESO));
		// userS.applicationAccessHelper.loginAndSearchCotizacion(tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// tCData.getNoCotizacionMAC());
		//
		// GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new
		// GestionCotizacionesBuscadorPage(userS);
		// gestionCotizacionesBuscadorPage.modificarProjecto();
		// AsignarMediadorPage asignarMediadorPage = new
		// AsignarMediadorPage(userS);
		// asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
		//
		// }
		//

		debugEnd();

	}

	/*
	 * ############## # SINIESTROS # ##############
	 */

	public void accederCliente() {
		debugBegin();

		new ClientePage(userS).accederAlBuscadorClientes();
		new ClientePage(userS).clickNuevoTomadorSecond();
		new ClientePage(userS).datosTomador();
		new ClientePage(userS).localizacionDomicilioTomador();

		debugEnd();

	}

	public void marcaCliente() {

		new ClientePage(userS).accederAlBuscadorClientes();

	}

	public void buscaClientePorNif() {

		new ClientePage(userS).buscarClientePorNIF();

	}
	public void buscaClientePorNombre() {

		new ClientePage(userS).buscarClientePorNIF();

	}


	public void buscadorCliente() {
		new ClientePage(userS).clickContiuarResultadoBusqueda();

	}

	public void marcaRelacion() {
		new ClientePage(userS).marcaRelacion();

	}

	public void marcaNegativa() {
		new ClientePage(userS).anadirMarcaNegativa();

	}

	// ALTA SINIESTRO

	public void alta_siniestro(String acceso, String numPoliza) throws Exception {
		debugBegin();

		if(acceso.equals(Constants.LoginAccessInnova)) {
			// Accedemos a siniestros desde INNOVA
			new InnovaHomePage(userS).openSiniestros();

			// Elegimos la opción "alta" de siniestros
			new SiniestrosHomePage(userS).openAperturaAlta();

			// Buscamos una póliza por Nº póliza
			new GestionPolizasBuscadorPage(userS).buscarPorNumeroPoliza(numPoliza);
			new GestionPolizasBuscadorPage(userS).SeleccionarResultado();

			// 1.Declaración
			new SiniestrosAltaAperturaDeclaracionPage(userS).completarMinimos(numPoliza);
			// new
			// SiniestrosAltaAperturaDeclaracionPage(userS).altaDatosBasicos("",
			// tipoDeclarante, medioDeclaracion);
			// Validamos cosas
			new ValidacionExcepcionesReglasPage(userS).ContinuarAltaSiniestro();

			// Completamos el apartado de Ocurrencia
			new SiniestrosAltaAperturaOcurrenciaPage(userS).datosMinOcurrencia(numPoliza);

			// Validamos más cosas
			new ValidacionExcepcionesReglasPage(userS).ContinuarAltaSiniestro();

			new SiniestrosImplicadoAseguradoPage(userS).aperturaSinietro();

			// Página de confirmación
			new SiniestrosConfirmacionPage(userS).check();
		} else if(acceso.equals(Constants.LoginAccessGestionLine)) {
			// Accedemos a siniestros desde Gestión On Line
			new GestionOnlineHomePage(userS).openSiniestros();
		}

		debugEnd();
	}

	// ALTA SINIESTRO ALTERNATIVA
	public void alta_siniestroAlt(String acceso, String numPoliza, boolean asistencia, boolean otrosImplicados, boolean encargo) throws Exception {
		debugBegin();
		String ramo = "";

		// Accedemos a siniestros desde INNOVA
		if(acceso.equals(Constants.LoginAccessInnova)) {
			InnovaHomePage innovaHome = new InnovaHomePage(userS);
			innovaHome.openSiniestros();

			// Elegimos la opción "alta" de siniestros
			SiniestrosHomePage siniestrosHome = new SiniestrosHomePage(userS);
			siniestrosHome.openAperturaAlta();

			// Buscamos una póliza por Nº póliza
			SiniestrosAltaAperturaPage altaApertura = new SiniestrosAltaAperturaPage(userS);
			if(numPoliza.startsWith("510")) ramo = "510";
			else if(numPoliza.startsWith("920") || numPoliza.startsWith("900")) ramo = "920";
			else if(numPoliza.startsWith("660")) ramo = "660";
			else if(numPoliza.startsWith("400") || numPoliza.startsWith("200") || numPoliza.startsWith("150") || (numPoliza.startsWith("500") && !numPoliza.startsWith("5000"))) ramo = "500";
			else if(numPoliza.startsWith("5000") || numPoliza.startsWith("600") || numPoliza.startsWith("610") || numPoliza.startsWith("620") || numPoliza.startsWith("630")
				|| numPoliza.startsWith("640")) ramo = "640";

			altaApertura.buscarPorNumPoliza(ramo, numPoliza);
			altaApertura.continuarPrimeraPoliza();

			// 1.Declaración
			SiniestrosAltaAperturaDeclaracionPage datosDeclaracion = new SiniestrosAltaAperturaDeclaracionPage(userS);
			datosDeclaracion.altaDatosBasicos("MEDI", "MAIL");
			datosDeclaracion.datosPersonaExtra("NORIE", "NombreInq", "ApellidoInq", "OtroInq", "NIF", "36155457D", "", "666123123", "", "", "H", true, "prueba@esto.es", true, "", "", "", "", "", "", "", "");

			// Comprobamos si necesita asistencia
			if(asistencia) {
				datosDeclaracion.altaConAsistencia(true, false, "", "Daños ubicados en el interior del riesgo asegurado", true, false, "");
			} else if(datosDeclaracion.posibilidadAsistencia()) {
				datosDeclaracion.altaSinAsistencia();
			}

			datosDeclaracion.clickContinuar();

			// Validamos cosas
			ValidacionExcepcionesReglasPage validarReglas = new ValidacionExcepcionesReglasPage(userS);
			if(validarReglas.comprobarNombrePagina().contains("excepciones")) validarReglas.clickOnContinuarButton();

			// Completamos el apartado de Ocurrencia
			SiniestrosAltaAperturaOcurrenciaPage datosOcurrencia = new SiniestrosAltaAperturaOcurrenciaPage(userS);
			datosOcurrencia.altaRiesgoAsegurado();

			String gCausa = "";
			String tCausa = "";
			String gremio = "";

			if(ramo == "510" || ramo == "500") {
				gCausa = "GC02";
				tCausa = "TC002000";
				gremio = "1";
			} else if(ramo == "920") {
				gCausa = "GC25";
				tCausa = "TC025000";
				gremio = "1";
			} else if(ramo == "640") {
				gCausa = "GC51";
				tCausa = "TC002000";
				gremio = "1";
			} else if(ramo == "660") {
				gCausa = "GC32";
				tCausa = "TC002000";
				gremio = "1";
			}

			datosOcurrencia.altaSeleccionarCausas(gCausa, tCausa, gremio);
			datosOcurrencia.altaRellenarDatos("Descripción test para realizar un alta de siniestro", otrosImplicados, encargo);
			datosOcurrencia.clickContinuar();

			// Validamos más cosas
			ValidacionExcepcionesReglasPage validarReglas2 = new ValidacionExcepcionesReglasPage(userS);
			if(validarReglas2.comprobarNombrePagina().contains("excepciones")) validarReglas2.clickOnContinuarButton();

			// Completamos el apartado de Implicado asegurado
			SiniestrosImplicadoAseguradoPage implicadoAsegurado = new SiniestrosImplicadoAseguradoPage(userS);
			implicadoAsegurado.clickApertura();

			// Comprobamos si se requiere añadir un implicado extra
			if(otrosImplicados) {
				SiniestrosOtrosImplicadosAlta altaOtrosImplicados = new SiniestrosOtrosImplicadosAlta(userS);
				altaOtrosImplicados.clickNuevoImplicado();
				SiniestrosOtrosImplicadosDatos otroImplicadoDatos = new SiniestrosOtrosImplicadosDatos(userS);
				otroImplicadoDatos.introducirDatosPersonales("LESI", "NORIE", "Implicado", "Exra", "Segundo", "NIF", "77315592B", "666885985", "", "", "implicadoextra@mail.com");
				otroImplicadoDatos.introducirDatosDireccion("", "", "", "", "", "", "", "", "ES21", "2100", "0001", "05", "0000000001");
				otroImplicadoDatos.clickGrabar();
				altaOtrosImplicados.clickContinuar();
			}

			// Comprobamos si se requiere añadir un encargo
			if(encargo) {
				SiniestrosEncargoAlta altaEncargo = new SiniestrosEncargoAlta(userS);
				altaEncargo.clickNuevoEncargo();
				SiniestrosEncargoDatos encargoDatos = new SiniestrosEncargoDatos(userS);
				encargoDatos.seleccionarTipoEncargo("PGRA", "PERIGRAL", "PERITACI");
				encargoDatos.seleccionarDatosEncargo(new Date(), "");
				encargoDatos.clickGrabar();
				altaEncargo.clickContinuar();
			}

			// Página de confirmación
			SiniestrosConfirmacionPage confirmarAltaSiniestro = new SiniestrosConfirmacionPage(userS);
			confirmarAltaSiniestro.confirmarSiniestroOK();
			
			
			// Accedemos a siniestros desde Gestión On Line
		} else if(acceso.equals(Constants.LoginAccessGestionLine)) {
			

			// Seleccionamos la opcion alta siniestros
			GestionOnlineHomePage goHome = new GestionOnlineHomePage(userS);
			goHome.seleccionaIdiomaCast();
			goHome.altaSiniestros();

			// Damos de alta el siniestro
			GestionOnlineAltaSiniestro altaSiniestroGOL = new GestionOnlineAltaSiniestro(userS);
			altaSiniestroGOL.altaInfoPoliza(numPoliza, "");
			if(numPoliza.startsWith("510")) ramo = "510";
			else if(numPoliza.startsWith("920") || numPoliza.startsWith("900")) ramo = "920";
			else if(numPoliza.startsWith("660")) ramo = "660";
			else if(numPoliza.startsWith("400") || numPoliza.startsWith("200") || numPoliza.startsWith("150") || (numPoliza.startsWith("500") && !numPoliza.startsWith("5000"))) ramo = "500";
			else if(numPoliza.startsWith("5000") || numPoliza.startsWith("600") || numPoliza.startsWith("610") || numPoliza.startsWith("620") || numPoliza.startsWith("630")
				|| numPoliza.startsWith("640")) ramo = "640";

			String causa = "";
			if(ramo == "510" || ramo == "500") {
				causa = "1";
			} else if(ramo == "920") {
				causa = "2";
			} else if(ramo == "640") {
				causa = "3";
			} else if(ramo == "660") {
				causa = "4";
			}

			altaSiniestroGOL.altaCausaDescripcion(causa, "Descripción para la apertura del sinestro de prueba automática", "");
			altaSiniestroGOL.altaCuentaSiniestro();
			altaSiniestroGOL.altaPersonaContacto("INQVE__11", "Jose", "Martinez", "Perez", "666502101", "mail@mail.com");
			altaSiniestroGOL.altaDireccionContacto(true, "", "", "", "", "", "", "", "");
			altaSiniestroGOL.altaObservaciones("TEST Automatico apertura siniestro");
			altaSiniestroGOL.clickEnviar();
			altaSiniestroGOL.checkYaExisteSiniestro();
			altaSiniestroGOL.comprobarOK();
		}

		if(acceso.equals(Constants.LoginAccessInnova)) {
			// Página de confirmación
			SiniestrosConfirmacionPage confirmarAltaSiniestro = new SiniestrosConfirmacionPage(userS);
			confirmarAltaSiniestro.confirmarSiniestroOK();
		}
	}

	// TRAMITAR SINIESTRO
	public void tramitar_siniestro(String acceso, String numPoliza) throws Exception {
		debugBegin();

		// necesitamos dar de alta previamente un siniestro
		alta_siniestro(acceso, numPoliza);

		new SiniestrosConfirmacionPage(userS).tramitarSiniestro();

		debugEnd();
	}

	// REALIZAR PAGO DE UN SINIESTRO (desde dar de alta un pago en siniestro
	// hasta confirmarlo)

	// realizar_pago_sinietro

	// MAC: SE INFORMA DE QUE LA POLIZA NO SE PUEDE EMITIR
	public void se_informa_de_que_la_poliza_no_se_puede_emitir() {
		// Compropar el estado
		Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaError());
	}

	// MAC: MODIFICAR INGRESOS
	public void modificar_ingresos(String ingresos) {
		userS.setTestVar(Constants.INGRESOS_INQUILINO, ingresos);
	}

	// MAC AÑADIR AVALISTA
	public void anyado_avalista() {
		InquilinosAvalistasPageMAC avalista = new InquilinosAvalistasPageMAC(userS);
		avalista.addDatosAval();

		avalista.anadirDocumentacionAval();

		avalista.validacionViabilidadInquilino();
	}

	// MAC DENIEGO EL PROYECTO MAC USANDO ACCESO Y USUARIO
	public void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(String loginAccess, String user) throws Exception {
		debugBegin();
		login(loginAccess, user);

		// Abrir la busqueda de autorizaciones
		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.OpenGestionAutorizaciones();
		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(userS);
		gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", userS.getTestVar("num_cotizacion"));

		// Denegar el proyecto gestionAutorizacionesPage.denegar();
		userS.getWebDriver().quit();

		debugEnd();
	}

	public void busco_el_proyecto_usando_el_acceso_y_el_usuario(String loginAccess, String user) throws Exception {
		// Login
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// Abrir el buscador de proyectos //
		GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(userS);
		gestionOnlineHomePage.openMisProyectosWeb();
		gestionOnlineHomePage.buscarProyectoWeb(userS.getTestVar(Constants.NUM_COTIZACION));
	}

	public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(String loginAccess, String user) throws Exception {
		// Login
		login(loginAccess, user);
		
		crear_proyecto_MAC();

		if(loginAccess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar();
		}

		// SCS Precio
		PrecioPorModalidadPageMAC precioPorModalidadPageMAC = new PrecioPorModalidadPageMAC(userS);
		precioPorModalidadPageMAC.executeActionsInPrecioPorModalidadPage();

		// SCS Inquilinos
		InquilinosAvalistasPageMAC inquilinosAvalistasPageMAC = new InquilinosAvalistasPageMAC(userS);
		inquilinosAvalistasPageMAC.executeActionsInInquilinosAvalistasPage();
	}

	public void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() {
		debugBegin();

		// Rellenar datos de contratacion, pagina 3
		new InquilinosAvalistasPageMAC(userS).clickContinuar();

		new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();

		new InmueblePage_MAC(userS).executeActionsInInmueblePage();

		new DocumentacionPage_MAC(userS).addDocumentContratacion();

		new ContratacionPage_MAC(userS).seleccionarCheckYContratar();

		debugEnd();
	}

	public void la_renta_mensual_es() {
		PrecioPorModalidadPageMAC precioPorModalidadPage_MAC = new PrecioPorModalidadPageMAC(userS);
		precioPorModalidadPage_MAC.completarRentaMensualAlquiler();
	}

	public void la_suma_asegurada_de_impago_alquiler_es() {
		new PrecioPorModalidadPageMAC(userS).seleccionarImpagoAlquiler();
	}

	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(String loginAcess, String user) throws Exception {
		debugBegin();

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();
			new AsignarMediadorPage(userS).TerminaProcesando().SeleccionarMediadorPorCodigo(mediador).clickOnContinuarButton();
		}

		new UbicacionRiesgoPage(userS).fillInmuebleAndClickOnContinue();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgoMinimos();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();

		new PrecioPage(userS).ClickOnConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.FillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickOnContinuar();

		new PrecioPorModalidadPage(userS).ExecuteActionsInPrecioPorModalidadPage();

		new ValidacionExcepcionesReglasPage(userS).clickOnContinuarButton();

		new ClausulasPage(userS).ActivateclausesAndClickOnContinue();

		new TomadorYAseguradoPage(userS)
			.AddDatosTomador()
			.AddDatosTomadorDiferenteAsegurado()
			.clickOnContinuar();

		new DocumentacionPage(userS).SubirFichero();

		new DatosBancariosPage(userS).introducirFormaPagoYPulsarContratar();

		// new DataSteps(userS).imprimir_informacion_del_proyecto();

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_y_guardo_sin_contratar_usando(String loginAcess, String user) throws Exception {
		debugBegin();

		login(loginAcess, user);
		System.out.println("TOKEN 1");

		String mediador = getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();
			new AsignarMediadorPage(userS).TerminaProcesando().SeleccionarMediadorPorCodigo(mediador).clickOnContinuarButton();
		}
		System.out.println("TOKEN 2");

		new UbicacionRiesgoPage(userS).fillInmuebleAndClickOnContinue();

		System.out.println("TOKEN 3");

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();
		System.out.println("TOKEN 4");

		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgoMinimos();
		System.out.println("TOKEN 5");

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		debugBegin();

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();
			new AsignarMediadorPage(userS)
				.SeleccionarMediadorPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.addInmueble(getScenarioVar(Constants.INMUEBLE));
		ubicacionRiesgoPage.clickOnContinuar();

		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS);
		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();

		new PrecioPage(userS).ClickOnConvertirAProjecto();

		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.FillTomadorData(userS.getScenarioVar(Constants.TOMADOR));
		datosBasicosTomadorPage.clickOnContinuar();

		new PrecioPorModalidadPage(userS).ExecuteActionsInPrecioPorModalidadPage();

		debugEnd();
	}

	public void intento_dar_alta_simulacion_hasta_datos_riesgo(String loginAcess, String user) throws Exception {
		// loginAcess = getValuesDataSet(tCData.gethMapDataSet(),
		// loginAcess, // tCData.getTestID()); loginAcess =
		// userS.getTestVar(Constants.ACCESO);

		// if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
		// getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(
		// ProjectConstants.GestionOnlineDisponible) ||
		// getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(
		// ProjectConstants.GestionOnlineDisponible))
		// {

		debugBegin();

		login(loginAcess, user);

		String mediador = getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.SeleccionarMediadorPorCodigo(getScenarioVar(Constants.MEDIADOR));
			asignarMediadorPage.clickOnContinuarButton();
		}

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.addInmueble(userS.getTestVar(Constants.INMUEBLE));
		ubicacionRiesgoPage.clickOnContinuar();
		DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(userS);
		detallesRiesgoPage.completarDatosRiesgo();
		detallesRiesgoPage.clickOnContinuar();

		debugEnd();
	}

	public void lo_consulto_en_el_buscador_de_cotizaciones(String loginAccess, String user) throws Exception {
		debugBegin();

		login(loginAccess, user);

		// userS.applicationAccessHelper.loginAndSearchCotizacion(this
		// .tCData.getCambioUsuario(), //
		// userS.getProperties().passwordComun, //
		// tCData.getNoCotizacion());

		new InnovaHomePage(userS).openGestionCotizaciones();

		new GestionCotizacionesBuscadorPage(userS).searchCotizacion(getScenarioVar(Constants.NUM_COTIZACION));

		debugEnd();
	}

	public void el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() {
		debugBegin();
		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
		String cotizacion = gestionCotizacionesBuscacorPage.getCotizacion();
		Assert.assertTrue(cotizacion.contains(getScenarioVar(Constants.NUM_COTIZACION)));
		debugEnd();
	}

	public void se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(String loginAccess, String user) throws Exception {
		// loginAcess = getScenarioVar(Constants.CAMBIO_ACCESO);

		debugBegin();

		// userS.initializeVariables(loginAcess);
		// userS.applicationAccessHelper.loginAndSearchCotizacion(tCData.getCambioUsuario(),
		// userS.getProperties().passwordComun, tCData.getNoCotizacion());

		login(loginAccess, user);

		new GestionCotizacionesBuscadorPage(userS).modificarProjecto();

		new AsignarMediadorPage(userS).clickOnContinuarButton();

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.closeAvisoSistemaPopup();
		ubicacionRiesgoPage.modifyReferenciaCatastral();
		ubicacionRiesgoPage.clickOnContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).modificarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasPage(userS).clickOnContinuarButton();

		new DatosBasicosTomadorPage(userS).clickOnContinuar();

		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
		precioPorModalidadPage.seleccionarModalidad();
		precioPorModalidadPage.clickOnContinuar();

		// validacionExcepcionesReglasPage.clickOnContinuarButton();

		new ClausulasPage(userS).clickOnContinuar();

		new TomadorYAseguradoPage(userS).clickOnContinuar();

		new DatosBancariosPage(userS).ClickOnGuardar();

		// new DataSteps(userS).imprimir_informacion_del_proyecto();
		userS.getWebDriver().quit();

		debugEnd();

	}

	public void el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente() throws Exception {
		debugBegin();

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			// userS.initializeVariables(getScenarioVar(Constants.CAMBIO_ACCESO));
			// userS.applicationAccessHelper.
			// LoginAndSearchPolizaByPolizaNumber(tCData.getCambioUsuario(),
			// userS.getProperties().passwordComun,
			// String.valueOf(tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
			gestionPolizasBuscadorPage.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA));
			gestionPolizasBuscadorPage.ConsultarPoliza();

			new GestionPolizasConsultarPage(userS).CheckPolizaNumber();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			// userS.initializeVariables(getScenarioVar(Constants.CAMBIO_ACCESO));
			// userS.applicationAccessHelper.
			// LoginAndSearchPolizaByPolizaNumber(tCData.getCambioUsuario(),userS.getProperties().passwordComun,String.valueOf(tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
			gestionPolizasBuscadorPage.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA));
			gestionPolizasBuscadorPage.ConsultarPoliza();

			new GestionPolizasConsultarPage(userS).CheckPolizaNumber();
		}

		debugEnd();

	}

	public void LoginAndSearchPolizaByPolizaNumber(String userId, String password, String poliza) throws Exception {
		login(userId, password);
		OpenGestionPolizas();
		SearchPolizaByPolizaNumber(poliza);
	}

	public void OpenGestionPolizas() {
		new GestionOnlineHomePage(userS).openGestionCotizaciones();
	}

	public void SearchPolizaByPolizaNumber(String poliza) {
		new GestionPolizasBuscadorPage(userS).buscarPorNumeroPoliza(poliza);
	}

	public void doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(String loginAccess, String user) throws Exception {
		debugBegin();

		if(loginAccess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAccess.equals(Constants.LoginAccessInnova)) {
			login(loginAccess, user);

			openSimulationMec();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();

			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			System.out.println("TOKEN 1");
			ubicacionRiesgoPage.addInmuebleByAddress();
			System.out.println("TOKEN 2");
			ubicacionRiesgoPage.clickOnContinuar();

			/**
			 * login(loginAccess, user); //userS.initializeVariables(loginAcess);
			 * //userS.applicationAccessHelper.LoginAndCreateSimulation(tCData.getUsuario(),
			 * userS.getProperties().passwordComun);
			 * 
			 * 
			 * 
			 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
			 * 
			 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			 * 
			 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
			 * ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS);
			 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			 * 
			 * detallesRiesgoPage = new DetallesRiesgoPage(webDriver, userS.getTestDataManager()); //
			 * detallesRiesgoPage. ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
			 * detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
			 * 
			 */
		}

		debugEnd();
	}

	/*
	 * ############## # Action Steps # ##############
	 */
	public void agrego_un_suplemento() throws Exception {
		// Login
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));

		new GestionPolizasBuscadorPage(userS)
			.AddSuplementoGeneral();

		new AsignarMediadorPage(userS)
			.clickOnContinuarButton();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.ClickOnContinuarButton();

		new UbicacionRiesgoPage(userS)
			.editInmuebleAndExcluirGarajesYLocales()
			.editCalidadConstruccion()
			.clickOnContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).modificarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.ClickOnContinuarAndValidate();

		new DatosBasicosTomadorPage(userS)
			.clickOnContinuar();

		new PrecioPorModalidadPage(userS)
			.ExecuteActionsInPrecioPorModalidadPage();

		new ValidacionExcepcionesReglasPage(userS)
			.clickOnContinuarButton();

		new ClausulasPage(userS)
			.ActivateclausesAndClickOnContinue();

		new TomadorYAseguradoPage(userS)
			.clickOnContinuar();
	}

	public void agrego_el_motivo_suplemento(String motivoSuplemento) {
		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, true, userS);

		new ConfirmarPage(userS)
			// .ActivateMotivosSuplementoAndClickOnContinuar();
			.ActivateMotivosSuplemento();
	}

	public void emito_el_suplemento() {
		new ConfirmarPage(userS)
			// .ActivateMotivosSuplemento();
			.ClickOnContinuar();

		new ValidacionExcepcionesReglasConfirmarPoliza(userS)
			.ClickOnContinuarButton();

		new DatosBancariosPage(userS)
			.ClickOnEmitirSuplemento();
	}

	public void emito_un_suplemento_general_con_motivo(String motivoSuplemento) throws Exception {
		// Login
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));

		// tCData.setSuplemento(true);
		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
		gestionPolizasBuscadorPage.AddSuplementoGeneral();
		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		asignarMediadorPage.clickOnContinuarButton();
		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
			userS);
		validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton();
		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
		ubicacionRiesgoPage.editCalidadConstruccion();
		ubicacionRiesgoPage.clickOnContinuar();
		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.modificarDatosEnDetallesRiesgo();

		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
			userS);
		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.clickOnContinuar();
		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
		validacionExcepcionesReglasPage.clickOnContinuarButton();
		ClausulasPage clausulasPage = new ClausulasPage(userS);
		clausulasPage.ActivateclausesAndClickOnContinue();
		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
		tomadorYAseguradoPage.clickOnContinuar();

		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, true, userS);

		ConfirmarPage confirmarPolizaPage = new ConfirmarPage(userS);
		confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();

		new ValidacionExcepcionesReglasConfirmarPoliza(userS)
			.ClickOnContinuarButton();

		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
		// DocumentacionPage documentacionPage = new DocumentacionPage(userS);
		// documentacionPage.SubirFichero();
		datosBancariosPage.ClickOnEmitirSuplemento();
		// MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(userS);
		// mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
	}

	public void doy_de_alta_una_simulacion_y_la_convierto_en_una_contratacion_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		// Login
		login(loginAcess, user);
		crear_simulacion();

		// Asignar mediador
		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		asignarMediadorPage.selectMediadorAndClickOnContinuar();

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
			userS);
		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosEnDetallesRiesgo();

		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
			userS);
		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
		PrecioPage precioPage = new PrecioPage(userS);
		precioPage.ClickOnConvertirAProjecto();
		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(getScenarioVar(Constants.TOMADOR));
		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
		validacionExcepcionesReglasPage.clickOnContinuarButton();
		ClausulasPage clausulasPage = new ClausulasPage(userS);
		clausulasPage.ActivateclausesAndClickOnContinue();
		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
		tomadorYAseguradoPage.AddDatosTomador();
		tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
		tomadorYAseguradoPage.clickOnContinuar();
		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
		datosBancariosPage.introducirFormaPagoYPulsarContratar();

		new DataSteps(userS).imprimir_informacion_del_proyecto();
		userS.getWebDriver().quit();
	}

	public void modifico_la_cotización(String loginAcess, String user) throws Exception {
		debugBegin();
		// loginAcess = getValuesDataSet(tCData.gethMapDataSet(), loginAcess,
		// tCData.getTestID());
		loginAcess = getScenarioVar(Constants.CAMBIO_ACCESO);
		user = getScenarioVar(Constants.CAMBIO_USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			buscar_cotizacion_por_numero_cotizacion(loginAcess, getScenarioVar(Constants.NUM_COTIZACION));

			GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
			gestionCotizacionesBuscacorPage.modificarProjecto();
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.clickOnContinuarButton();
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.closeAvisoSistemaPopup();
			ubicacionRiesgoPage.modifyReferenciaCatastral();
			ubicacionRiesgoPage.clickOnContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				// .executeActionsInPageDetallesRiesgoPage();
				.modificarDatosEnDetallesRiesgo();

			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
			validacionExcepcionesReglasPage.clickOnContinuarButton();
			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
			datosBasicosTomadorPage.clickOnContinuar();
			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
			precioPorModalidadPage.seleccionarModalidad();
			precioPorModalidadPage.clickOnContinuar();
			validacionExcepcionesReglasPage.clickOnContinuarButton();
			ClausulasPage clausulasPage = new ClausulasPage(userS);
			clausulasPage.clickOnContinuar();
			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
			tomadorYAseguradoPage.clickOnContinuar();
			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
			datosBancariosPage.modificarFormaPagoYPulsarContratar();
			new DataSteps(userS).imprimir_informacion_del_proyecto();
			// userS.getWebDriver().quit();
			debugEnd();
		}
	}

	public void doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(String loginAcess, String user) throws Exception {
		debugBegin();

		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_simulacion();

			String mediador = getScenarioVar(Constants.MEDIADOR);
			if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				asignarMediadorPage.selectMediadorAndClickOnContinuar();
			} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				asignarMediadorPage.SeleccionarMediadorPorCodigo(getScenarioVar(Constants.MEDIADOR));
				asignarMediadorPage.clickOnContinuarButton();
			}

			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
				userS);
			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				// .executeActionsInPageDetallesRiesgoPage();
				.completarDatosEnDetallesRiesgo();

			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
				userS);
			validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
			PrecioPage precioPage = new PrecioPage(userS);
			precioPage.ClickOnConvertirAProjecto();
			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
			datosBasicosTomadorPage.FillTomadorData(getScenarioVar(Constants.TOMADOR));
			datosBasicosTomadorPage.clickOnContinuar();
			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
			precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
			validacionExcepcionesReglasPage.clickOnContinuarButton();
			ClausulasPage clausulasPage = new ClausulasPage(userS);
			clausulasPage.ActivateclausesAndClickOnContinue();
			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
			tomadorYAseguradoPage.AddDatosTomador();
			tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
			tomadorYAseguradoPage.clickOnContinuar();
			DocumentacionPage documentacionPage = new DocumentacionPage(userS);
			documentacionPage.SubirFichero();
			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
			datosBancariosPage.introducirFormaPagoYPulsarContratar();
			new DataSteps(userS).imprimir_informacion_del_proyecto();
			userS.getWebDriver().quit();
		}

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_y_la_convierto_a_un_proyecto_y_la_guardo_sin_contratar_usando(String loginAcess, String user) throws Exception {
		debugBegin();

		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_simulacion();

			String mediador = getScenarioVar(Constants.MEDIADOR);
			if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				asignarMediadorPage.selectMediadorAndClickOnContinuar();
			} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				asignarMediadorPage.SeleccionarMediadorPorCodigo(getScenarioVar(Constants.MEDIADOR));
				asignarMediadorPage.clickOnContinuarButton();
			}

			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
				userS);
			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			new DetallesRiesgoPage(userS)
				// .executeActionsInPageDetallesRiesgoPage();
				.completarDatosEnDetallesRiesgo();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).clickOnContinuar();

			PrecioPage precioPage = new PrecioPage(userS);
			precioPage.ClickOnConvertirAProjecto();
			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
			datosBasicosTomadorPage.FillTomadorData(getScenarioVar(Constants.TOMADOR));
			datosBasicosTomadorPage.clickOnContinuar();
			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
			precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
			validacionExcepcionesReglasPage.clickOnContinuarButton();
			ClausulasPage clausulasPage = new ClausulasPage(userS);
			clausulasPage.ActivateclausesAndClickOnContinue();
			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
			tomadorYAseguradoPage.AddDatosTomador();
			tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
			tomadorYAseguradoPage.clickOnContinuar();
			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
			datosBancariosPage.introducirFormaPagoYPulsarGuardar();
			new DataSteps(userS).imprimir_informacion_del_proyecto();
		}

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_simulacion();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
				userS);
			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			new DetallesRiesgoPage(userS)
				// .ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
				.completarDatosEnDetallesRiesgoSinContinuar();
		}
	}

	public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_proyecto_MEC();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();
			new DetallesRiesgoPage(userS)
				.completarDatosEnDetallesRiesgoSinContinuar();
		}
	}

	public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_simulacion();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.completarDatosEnDetallesRiesgo();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.ClickOnContinuarAndValidate();

			PrecioPage precioPage = new PrecioPage(userS);
			precioPage.ClickOnConvertirAProjecto();
		}
	}

	public void doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			crear_proyecto_MEC();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
				userS);
			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();
			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
				userS);
			validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
			// PrecioPage precioPage = new PrecioPage(userS);
			// precioPage.ClickOConvertirAProjecto();
		}
	}

	public void continuo_en_datos_básicos_del_tomador() throws Exception {
		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(getScenarioVar(Constants.TOMADOR));
	}

	public void lo_consulto_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));
	}

	public void lo_consulto_por_dni_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_poliza_por_numero_documento(getScenarioVar(Constants.DNI_TOMADOR));
	}

	public void continuo_en_detalles_riesgo() throws Exception {
		debugBegin();

		new DetallesRiesgoPage(userS)
			.completarDatosEnDetallesRiesgoSinContinuar()
			.clickOnContinuar();

		debugEnd();
	}

	public void modifico_el_capital_continente_a(String capitalContinente) {
		setTestVar(Constants.CAPITAL_CONTINENTE, capitalContinente);
	}

	public void cierro_navegador() {
		userS.getWebDriver().quit();
	}

	public void se_descargan_los_ficheros_del_suplemento_en_la_carpeta(String filesPath) {
		debugBegin();

		new MensajeConfirmacionPage(userS)
			.DownlodadDocumentsToFolder(filesPath);

		debugEnd();
	}

	public void autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(String loginAcess, String user) throws Exception {
		login(loginAcess, user);

		// Abrir la busqueda de autorizaciones
		new InnovaHomePage(userS).OpenGestionAutorizaciones();
		
		new GestionAutorizacionesPage(userS)
		//debugInfo("cotizacio:" + noCotizacion);
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION))
			.autorizar();
	}

	public void envio_el_proyecto_a__la_compania() {
		debugBegin();
		InquilinosAvalistasPageMAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPageMAC(userS);
		inquilinosAvalistasPage_MAC.enviarACompania();
		// userS.getWebDriver().quit();
		debugEnd();
	}

	public void completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario(String loginAcess, String user) throws Exception {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_cotizacion_por_numero_cotizacion(loginAcess, getTestVar(Constants.NUM_COTIZACION));

		// Abrir el buscador de proyectos
		new GestionOnlineHomePage(userS)
			.modificarProyecto();

		if(loginAcess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		}

		new PrecioPorModalidadPageMAC(userS).clickContinuar();
		new InquilinosAvalistasPageMAC(userS).clickContinuar();

		// Rellenar datos de contratacion, pagina 3
		new TomadorYAseguradoPage_MAC(userS)
			.executeActionsInTomadorYAseguradoPage();

		new InmueblePage_MAC(userS)
			.executeActionsInInmueblePage();

		new DocumentacionPage_MAC(userS)
			.addDocumentContratacion();

		new ContratacionPage_MAC(userS)
			.seleccionarCheckYContratar();
	}

	public void valido_un_proyecto_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		// Login
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		crear_proyecto_MEC();

		// Asignar mediador
		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();

		// SCS Precio
		PrecioPorModalidadPageMAC precioPorModalidadPage_MAC = new PrecioPorModalidadPageMAC(userS);
		precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();

		// SCS Inquilinos
		InquilinosAvalistasPageMAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPageMAC(userS);
		inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPageSinDocumentacion();
		// inquilinosAvalistasPage_MAC.ValidacionViabilidadInquilino();
	}

	public void valido_el_proyecto() {
		InquilinosAvalistasPageMAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPageMAC(userS);
		inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
	}

	public void busco_un_edificio_por_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		setTestVar(Constants.FILTRO_BUSCADOR_EDIFICIO, getScenarioVar(Constants.FILTRO_BUSCADOR_EDIFICIO));
		// Login
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);
		login(loginAcess, user);

		// FichaEdificioPage
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
		fichaEdificioPage.accederAlBuscadorEdificios();
		fichaEdificioPage.buscarConFiltroBusqueda();
	}

	public void abro_ficha_edificio_desde_grid_resultados() {
		// FichaEdificioPage
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
		fichaEdificioPage.openFichaEdificioDesdeGrid();
	}

	public void busco_edificios_por_direcciones_con_el_fichero() {
		// FichaEdificioPage
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
		fichaEdificioPage.accederAlBuscadorEdificios();

		fichaEdificioPage.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_DIRECCION);
		fichaEdificioPage.iterarEdificiosPorDirecciones(getScenarioVar(Constants.FICHERO));
	}

	public void busco_edificios_por_direcciones_en_buscador_MEC_con_el_fichero() throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();
		innovaHomePage.createNewProject();

		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		asignarMediadorPage.selectMediadorAndClickOnContinuar();

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.iterarEdificiosPorDirecciones(getScenarioVar(Constants.FICHERO));
		// fichaEdificioPage.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_DIRECCION);
		// fichaEdificioPage.IterarEdificiosPorDirecciones(
		// getValuesDataSet(tCData.gethMapDataSet(), nombreFichero, tCData.getTestID()));
	}

	public void busco_edificios_por_referencias_con_el_fichero() throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// FichaEdificioPage
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
		fichaEdificioPage.accederAlBuscadorEdificios();

		fichaEdificioPage.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_CATASTRAL);
		fichaEdificioPage.iterarEdificiosPorReferencias(getScenarioVar(Constants.FICHERO));
	}

	public void busco_edificios_por_referencias_en_el_buscador_MEC_con_el_fichero() throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// FichaEdificioPage
		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();
		innovaHomePage.createNewProject();

		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		asignarMediadorPage.selectMediadorAndClickOnContinuar();

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);

		debugInfo("Nombre fichero en action steps: " + getScenarioVar(Constants.FICHERO));
		ubicacionRiesgoPage.iterarEdificiosPorReferencias(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + getScenarioVar(Constants.FICHERO));
	}

	public void anado_avalista() {
		InquilinosAvalistasPageMAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPageMAC(userS);
		inquilinosAvalistasPage_MAC.addDatosAval();

		inquilinosAvalistasPage_MAC.anadirDocumentacionAval();

		inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
	}

	private static int getIndexInArray(
		String[] array, String compareString) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].equals(compareString))
				return i;
		}

		return -1;
	}

	private static String getValuesDataSetByID(
		String[][] array, String string, int index) {
		String value = null;

		if(getIndexInArray(array[0], string) >= 0) {
			value = array[index][getIndexInArray(array[0], string)];
		}

		return value;
	}

	private static String[][] setValuesDataSetByID(
		String[][] array, String string, int index, String newValue) {

		if(getIndexInArray(array[0], string) >= 0) {
			array[index][getIndexInArray(array[0], string)] = newValue;
		}

		return array;
	}

	public void doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero() throws Exception {
		debugBegin();

		String logText = "", address = "";
		setScenarioVar(Constants.INMUEBLE, "direccion por defecto");

		String fileName = getScenarioVar(Constants.FICHERO);
		debugInfo("Filename: " + fileName);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int i = 1; i < datosAltoValor.length; i++) {
			innovaHomePage.openNewSimulationMec();
			// address = getValuesDataSetByID(datosAltoValor, "provincia", i) + ", " +
			// getValuesDataSetByID(datosAltoValor, "poblacion", i) + ", "
			// + getValuesDataSetByID(datosAltoValor, "direccion", i) + ", " + getValuesDataSetByID(datosAltoValor,
			// "numero", i);

			// address = getValuesDataSetByID(datosAltoValor, "ref_catastral", i);

			setScenarioVar(Constants.REFERENCIA_CATASTRAL, getValuesDataSetByID(datosAltoValor, Constants.REFERENCIA_CATASTRAL, i));
			// tCData.setDireccionProvincia(getValuesDataSetByID(datosAltoValor, "provincia", i));
			// tCData.setDireccionPoblacion(getValuesDataSetByID(datosAltoValor, "poblacion", i));
			// tCData.setDireccionNombreVia(getValuesDataSetByID(datosAltoValor, "direccion", i));
			// tCData.setDireccionNumeroVia(getValuesDataSetByID(datosAltoValor, "numero", i));
			// String codigoPostal = getValuesDataSetByID(datosAltoValor, "codigo_postal", i);
			// tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();

			try {
				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);

				if(!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) {
					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
					debugInfo("Mas de una referencia catastral encontrada");

					userS.getWebDriver().exitFrame();
					innovaHomePage.openInnovaHome();
					innovaHomePage.openMutuaEdificioConfort();

					writeFile(fileName + " (log file).txt", logText);
					continue;
				}

				ubicacionRiesgoPage.closeNotification();
				ubicacionRiesgoPage.clickOnContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

				String anyoConstruccion = new DetallesRiesgoPage(userS).completarDatosRiesgoMinimos();
				new DetallesRiesgoPage(userS).clickOnContinuar();

				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
				// precioPorModalidadPage.modificarRC("600.000,00");
				// precioPorModalidadPage.agregarDescuento(getValuesDataSet(tCData.gethMapDataSet(),
				// tCData.getDescuento(),
				// tCData.getTestID()));
				precioPorModalidadPage.agregarDescuento(getScenarioVar(Constants.DESCUENTO));

				String precioTotal = precioPorModalidadPage.getPrecioTotal();
				precioPorModalidadPage.clickOnGuardar();
				String numSimulacion = precioPorModalidadPage.getNumSimulacion();

				datosAltoValor = setValuesDataSetByID(datosAltoValor, "prima_total", i, precioTotal);
				datosAltoValor = setValuesDataSetByID(datosAltoValor, "anyo_antiguedad", i, anyoConstruccion);
				datosAltoValor = setValuesDataSetByID(datosAltoValor, "numero_proyecto", i, numSimulacion);

				appendMatrixToCsvFile(fileName + " (modificado).csv", datosAltoValor);

				precioPorModalidadPage.clickOnCancelar();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas");

				userS.getWebDriver().exitFrame();
				innovaHomePage.openInnovaHome();
				innovaHomePage.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void modifico_proyecto_iterando_cambio_mediador() throws Exception {
		debugBegin();

		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);
		// fileName = tCData.value("fileName")
		// DataObject data = new DataObject(FileUtils.csvFileToMData(tCData.value("fileName")));
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(fileName + ".csv", false);

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openGestionCotizaciones();

		for(int i = 1; i < datosAltoValor.length; i++) {
			// data.setKey(Integer.toString(i));
			// data.value("ref_catastral");
			String cotizacion = getValuesDataSetByID(datosAltoValor, "numero_proyecto", i);

			if(cotizacion == null || cotizacion.isEmpty())
				continue;

			GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(userS);
			gestionCotizacionesBuscadorPage.searchCotizacion(cotizacion);
			gestionCotizacionesBuscadorPage.modificarProjecto();

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();

			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.clickOnGuardar();
			ubicacionRiesgoPage.closeAvisoSistemaPopup();

			innovaHomePage.openInnovaHome();
			innovaHomePage.openGestionCotizaciones();
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero() throws Exception {
		debugBegin();

		String logText = "", address = "";

		setScenarioVar(Constants.INMUEBLE, "direccion por defecto");
		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();

		String[][] datosCargaMEC = FileUtils.csvFileToMatrix(fileName + ".csv", false);
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "capital_continente");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "total_asegurado");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "capital_contenido");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precios_antes_proyecto");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precios_despues_proyecto");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precio_basic");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precio_plus");

		for(int i = 1; i < datosCargaMEC.length; i++) {
			innovaHomePage.openNewSimulationMec();
			address = getValuesDataSetByID(datosCargaMEC, "provincia", i) + ", " + getValuesDataSetByID(datosCargaMEC, "poblacion", i) + ", "
				+ getValuesDataSetByID(datosCargaMEC, "direccion", i) + ", " + getValuesDataSetByID(datosCargaMEC, "numero", i);

			setScenarioVar(Constants.PROVINCIA, getValuesDataSetByID(datosCargaMEC, "provincia", i));
			setScenarioVar(Constants.POBLACION, getValuesDataSetByID(datosCargaMEC, "poblacion", i));
			setScenarioVar(Constants.NOMBRE_VIA, getValuesDataSetByID(datosCargaMEC, "direccion", i));
			setScenarioVar(Constants.NUM_VIA, getValuesDataSetByID(datosCargaMEC, "numero", i));
			String codigoPostal = getValuesDataSetByID(datosCargaMEC, "codigo_postal", i);
			setScenarioVar(Constants.CODIGO_POSTAL, codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			try {
				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);

				if(!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) {
					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
					System.out.println("Mas de una referencia catastral encontrada");
					userS.getWebDriver().exitFrame();
					innovaHomePage.openInnovaHome();
					innovaHomePage.openMutuaEdificioConfort();
					writeFile(fileName + " (log file).txt", logText);
					continue;
				}
				ubicacionRiesgoPage.closeNotification();
				ubicacionRiesgoPage.clickOnContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();
				new DetallesRiesgoPage(userS).completarDatosRiesgoMinimos();

				String capitalContinente = new DetallesRiesgoPage(userS).getCapitalContinente();
				String totalAsegurado = new DetallesRiesgoPage(userS).getCapitalContinenteTotalAsegurado();
				String capitalContenido = new DetallesRiesgoPage(userS).getCapitalContenido();

				new DetallesRiesgoPage(userS).clickOnContinuar();

				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
				String precioComplet = precioPorModalidadPage.getPrecioTotal();
				String precioBasic = precioPorModalidadPage.getPrecioBasic();
				String precioPlus = precioPorModalidadPage.getPrecioPlus();

				precioPorModalidadPage.clickOnGuardar();
				// TODO
				// Convertir a proyecto
				// seguir los pasos
				// Terminar de crear la poliza

				// escribir los datos: numeroProyecto, precios antes de proyecto, precios despues de
				// proyecto

				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_continente", i, capitalContinente);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "total_asegurado", i, totalAsegurado);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_contenido", i, capitalContenido);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "prima_total", i, precioComplet);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_basic", i, precioBasic);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_plus", i, precioPlus);
				// datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "numero_proyecto", i, numSimulacion);

				writeMatrixToCsvFile(fileName + " - " + getConfigVar(Constants.ENTORNO) + " (resultados).csv", datosCargaMEC);

				innovaHomePage.openInnovaHome();
				innovaHomePage.openMutuaEdificioConfort();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas\n\t- " + e.toString());

				userS.getWebDriver().exitFrame();
				innovaHomePage.openInnovaHome();
				innovaHomePage.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void se_dan_de_alta_masivamente_proyectos_MEC_donde_la_antiguedad_del_edificio_es_mayor_que_50_anyos() throws Exception {
		debugBegin();

		String logText = "";

		String fileName = getScenarioVar(Constants.FICHERO);
		debugInfo("Filename: " + fileName);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int i = 1; i < datosAltoValor.length; i++) {
			innovaHomePage.createNewProject();

			setScenarioVar(Constants.REFERENCIA_CATASTRAL, getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();

			try {
				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);

				ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
				// ubicacionRiesgoPage.closeNotification();
				// ubicacionRiesgoPage.clickOnContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

				new DetallesRiesgoPage(userS)
					.completarDatosRiesgoMinimos(); // Enter values madera and deshabitación.

				new DetallesRiesgoPage(userS).enterAnyoConstruccionMoreThan50()
					.clickOnContinuar();

				ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
				validacionExcepcionesReglasPage.clickOnContinuarButton();

				DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
				datosBasicosTomadorPage.fillStaticTomadorData();
				datosBasicosTomadorPage.clickOnContinuar();

				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
				precioPorModalidadPage.clickOnContinuar();
				// ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
				// ValidacionExcepcionesReglasPage(userS);
				validacionExcepcionesReglasPage.clickOnContinuarButton();

				ClausulasPage clausulasPage = new ClausulasPage(userS);
				clausulasPage.clickOnContinuar();

				TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
				tomadorYAseguradoPage.addStaticDatosTomador();
				// tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();

				tomadorYAseguradoPage.clickOnContinuar();
				DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);

				datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion();
				// new DataSteps(userS).imprimir_informacion_del_proyecto();
				// userS.getWebDriver().quit();

				Iterable<String> PeritajeIterator = Splitter.on(' ').split(datosBancariosPage.getMensajePeritaje());
				String[] PeritajeList = Iterables.toArray(PeritajeIterator, String.class);

				logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
					+ " (Proyecto: " + datosBancariosPage.getProjectNumber() + ", " + "Referencia solicitud: " + PeritajeList[7] + ")" + "\n";
				writeFile(fileName + " (log file).txt", logText);

				debugInfo("Solicitud verificación OK.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + " (Proyecto: "
					+ datosBancariosPage.getProjectNumber() + ", " + "Referencia solicitud: " + PeritajeList[7] + ")" + "\n");

				innovaHomePage.openInnovaHome();
				innovaHomePage.openMutuaEdificioConfort();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
					+ "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas");
				debugInfo("Solicitud verificación KO.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

				userS.getWebDriver().exitFrame();
				innovaHomePage.openInnovaHome();
				innovaHomePage.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void busco_un_cliente_por_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		// Login
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// Clientes Page
		ClientePage clientesPage = new ClientePage(userS);
		clientesPage.accederAlBuscadorClientes();
		clientesPage.buscarConFiltroBusqueda();
	}

	public void doy_alta_nuevo_tomador_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		// Login
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// Clientes Page
		ClientePage clientesPage = new ClientePage(userS);
		clientesPage.accederAlBuscadorClientes();
		clientesPage.clickNuevoTomadorSecond();
	}

	public void doy_de_alta_prospect_usando_acceso_y_usuario_iterando_fichero(String loginAcess, String user) throws Exception {
		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		String[][] datosMediadores = FileUtils.csvFileToMatrix(fileName + ".csv", false);

		for(int i = 1; i < datosMediadores.length; i++) {
			setScenarioVar(Constants.NIVEL_ESTRUCTURA, getValuesDataSetByID(datosMediadores, "nivelEstructura", i));
			setScenarioVar(Constants.TIPO_PROSPECT, getValuesDataSetByID(datosMediadores, "tipoProspect", i));
			setScenarioVar(Constants.ACTIVIDAD_PRINCIPAL, getValuesDataSetByID(datosMediadores, "actividadPrincipal", i));
			setScenarioVar(Constants.NOMBRE_COMERCIAL_PROSPECT, getValuesDataSetByID(datosMediadores, "nomComercial", i));
			setScenarioVar(Constants.CONTACTO_RESPONSABLE, getValuesDataSetByID(datosMediadores, "contactoResponsable", i));
			setScenarioVar(Constants.IDIOMA, getValuesDataSetByID(datosMediadores, "idioma", i));
			setScenarioVar(Constants.TLF_PRINCIPAL, getValuesDataSetByID(datosMediadores, "tlfPrincipal", i));
			setScenarioVar(Constants.EJECUTIVO_COMERCIAL, getValuesDataSetByID(datosMediadores, "ejecutivoComercial", i));
			setScenarioVar(Constants.PROVINCIA, getValuesDataSetByID(datosMediadores, "provincia", i));
			setScenarioVar(Constants.POBLACION, getValuesDataSetByID(datosMediadores, "poblacion", i));
			setScenarioVar(Constants.NOMBRE_VIA, getValuesDataSetByID(datosMediadores, "nombreVia", i));

			try {
				login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

				InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
				innovaHomePage.openMediadores();

				MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(userS);
				mediadoresHomePage.openAltaProspect();

				MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(userS);
				mediadoresAltaProspectPage.executeActionsAltaProspectPage();

			} catch(Exception e) {

			}
		}
	}

	public void doy_de_alta_prospect_usando_acceso_y_usuario(String loginAcess, String user) throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMediadores();

		MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(userS);
		mediadoresHomePage.openAltaProspect();

		MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(userS);
		mediadoresAltaProspectPage.executeActionsAltaProspectPage();
	}

	public void doy_de_alta_mediador_usando_acceso_y_usuario(String loginAcess, String user) throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMediadores();

		MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(userS);
		mediadoresHomePage.openAltaMediador();

		MediadoresAltaMediadorPage mediadoresAltaMediadorPage = new MediadoresAltaMediadorPage(userS);
		mediadoresAltaMediadorPage.executeActionsAltaMediadorPage();
	}

	public void comunico_siniestro(String loginAcess, String user) throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// TODO Rellenar
	}

	public void busco_siniestro(String loginAcess, String user) throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// TODO Rellenar
	}

	public void se_dan_de_alta_masivamente_proyectos_MEC_empleando_distintos_mediadores() throws Exception {
		debugBegin();

		debugInfo("Cargando referencias...\n");
		String logText = "";
		String fileName = getScenarioVar(Constants.FICHERO);
		debugInfo("Filename: " + fileName);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		debugInfo("Cargando mediadores...\n");
		String fileNameB = getScenarioVar("ficheroMedCoa");
		debugInfo("Filename: " + fileNameB);
		fileNameB = fileNameB.substring(0, fileNameB.length() - 4);
		debugInfo("Filename: " + fileNameB);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.openMutuaEdificioConfort();

		String[][] datosAltoValorMedCoa = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileNameB + ".csv", false);
		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int j = 1; j < datosAltoValorMedCoa.length; j++) {
			for(int i = 1; i < datosAltoValor.length; i++) {
				innovaHomePage.createNewProject();

				setScenarioVar(Constants.REFERENCIA_CATASTRAL, getValuesDataSetByID(datosAltoValor, Constants.REFERENCIA_CATASTRAL, i));

				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				asignarMediadorPage.selectMediadorAndClickOnContinuar(getValuesDataSetByID(datosAltoValorMedCoa, "Codigo_Coaseguro", j));

				try {
					UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
					ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
					// ubicacionRiesgoPage.closeNotification();
					// ubicacionRiesgoPage.clickOnContinuar();

					new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

					new DetallesRiesgoPage(userS)
						.completarDatosRiesgoMinimos(); // Enter values madera and deshabitación.
					// .enterAnyoConstruccionMoreThan50();
					new DetallesRiesgoPage(userS).clickOnContinuar();

					ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
					validacionExcepcionesReglasPage.clickOnContinuarButton();
					DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
					datosBasicosTomadorPage.fillStaticTomadorData();
					datosBasicosTomadorPage.clickOnContinuar();
					PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
					precioPorModalidadPage.clickOnContinuar();
					// ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
					// ValidacionExcepcionesReglasPage(userS);
					validacionExcepcionesReglasPage.clickOnContinuarButton();
					ClausulasPage clausulasPage = new ClausulasPage(userS);
					clausulasPage.clickOnContinuar();
					TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
					tomadorYAseguradoPage.addStaticDatosTomador();
					// tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
					tomadorYAseguradoPage.clickOnContinuar();
					DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);

					// datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion();
					// new DataSteps(userS).imprimir_informacion_del_proyecto();
					// userS.getWebDriver().quit();

					// Iterable<String> PeritajeIterator = Splitter.on('
					// ').split(datosBancariosPage.getMensajePeritaje());
					// String[] PeritajeList = Iterables.toArray(PeritajeIterator, String.class);

					logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
						+ " (Proyecto: " + datosBancariosPage.getProjectNumber() + ")" + "\n";
					writeFile(fileName + " (log file).txt", logText);

					debugInfo("Solicitud verificación OK.  Ref. catastral: "
						+ getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + " (Proyecto: " + datosBancariosPage.getProjectNumber() + ")" + "\n");

					innovaHomePage.openInnovaHome();
					innovaHomePage.openMutuaEdificioConfort();
				} catch(Exception e) {
					logText += "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
						+ "\n";
					writeFile(fileName + " (log file).txt", logText);
					debugInfo("Comprobaciones de datos no contempladas");
					debugInfo("Solicitud verificación KO.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

					userS.getWebDriver().exitFrame();
					innovaHomePage.openInnovaHome();
					innovaHomePage.openMutuaEdificioConfort();
				}
			}
		}

		userS.getWebDriver().quit();

		debugBegin();
	}
}