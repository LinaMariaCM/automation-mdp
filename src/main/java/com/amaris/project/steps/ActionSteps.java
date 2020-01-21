package com.amaris.project.steps;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.automation.model.utils.ArrayUtils;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.InitUtils;
import com.amaris.automation.model.utils.StringUtils;
import com.amaris.automation.model.webdriver.DriverHelper;

import java.net.URISyntaxException;
import java.util.Date;

import com.amaris.project.pages.administracion.mediadores.*;
import org.testng.Assert;
import org.openqa.selenium.By;

import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.clientes.ClientePage;
import com.amaris.project.pages.administracion.fichaedificio.FichaEdificioPage;
import com.amaris.project.pages.administracion.gestionautorizaciones.GestionAutorizacionesPage;
import com.amaris.project.pages.administracion.gestionpagos.GestionPagosPage;
import com.amaris.project.pages.productos.mac.AsignarMediadorPage;
import com.amaris.project.pages.administracion.siniestros.HomeSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaDeclaracionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaOcurrenciaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.ConfirmacionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.EncargoAltaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.EncargoDatosSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.ImplicadoAseguradoSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.ModificacionVerificacionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.ModificarValidacionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.OtrosImplicadosAltaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.apertura.OtrosImplicadosDatosSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.AgendaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.BloqueSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.ComunicacionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.DiarioSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.GestionCarpetaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.GestionOnlineAltaSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.GestionBuscadorSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.GestionSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.PagosSiniestrosPage;
import com.amaris.project.pages.administracion.siniestros.gestion.VistaSiniestrosPage;
import com.amaris.project.pages.comun.LoginPage;
import com.amaris.project.pages.comun.ValidacionExcepcionesReglasConfirmarPoliza;
import com.amaris.project.pages.comun.ValidacionExcepcionesReglasDetallesRiesgoPage;
import com.amaris.project.pages.comun.ValidacionExcepcionesReglasPage;
import com.amaris.project.pages.comun.ValidacionesExcepcionesReglasUbicacionRiesgoPage;
import com.amaris.project.pages.comun.gestiononline.GestionOnlineHomePage;
import com.amaris.project.pages.comun.innova.InnovaHomePage;
import com.amaris.project.pages.productos.ClausulasPage;
import com.amaris.project.pages.productos.ConfirmarPage;
import com.amaris.project.pages.productos.DatosBancariosPage;
import com.amaris.project.pages.productos.DatosBasicosTomadorPage;
import com.amaris.project.pages.productos.DetallesRiesgoPage;
import com.amaris.project.pages.productos.DocumentacionPage;
import com.amaris.project.pages.productos.GestionCotizacionesBuscadorPage;
import com.amaris.project.pages.productos.GestionPolizasBuscadorPage;
import com.amaris.project.pages.productos.GestionPolizasConsultarPage;
import com.amaris.project.pages.productos.MensajeConfirmacionPage;
import com.amaris.project.pages.productos.PrecioPage;
import com.amaris.project.pages.productos.PrecioPorModalidadPage;
import com.amaris.project.pages.productos.TomadorYAseguradoPage;
import com.amaris.project.pages.productos.UbicacionRiesgoPage;
import com.amaris.project.pages.productos.mac.ContratacionPageMac;
import com.amaris.project.pages.productos.mac.DocumentacionPageMac;
import com.amaris.project.pages.productos.mac.InmueblePageMac;
import com.amaris.project.pages.productos.mac.InquilinosAvalistasPageMac;
import com.amaris.project.pages.productos.mac.PrecioPorModalidadPageMac;
import com.amaris.project.pages.productos.mac.TomadorYAseguradoPageMac;
import com.amaris.project.utils.MotivosSuplementoHelper;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class ActionSteps extends InteractionObject {

	public ActionSteps(UserStory userStory) {
		super(userStory);
	}

	public void login(String accessType, String user) {
		debugBegin();

		String environment = InitUtils.getStringConfigVariable(Constants.ENTORNO, userS.getConfigData());

		debugInfo("Environment: " + environment);
		debugInfo("Access type: " + getTestVar(Constants.ACCESO));
		debugInfo("User: " + getTestVar(Constants.USUARIO));

		new LoginPage(userS)
			.logIn(environment, accessType, user);

		debugEnd();
	}

	public void inicio_sesion_con_acceso_y_usuario() {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
	}

	public void buscar_poliza_por_numero_de_poliza(String poliza) {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openGestionPolizas();
		}

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(poliza);
	}

	public void buscar_poliza_por_numero_documento(String numDocumento) {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openGestionPolizas();
		}

		new GestionPolizasBuscadorPage(userS)
			.buscarPolizaPorNumeroNif(numDocumento);
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

	// Método pensado para acabar con las esperas que cortan la ejecución automática
	public static void waitForIt(DriverHelper webDriver) {
		By loaderModal = By.cssSelector("#modalLoader");
		By procesandoWindow = By.cssSelector(".smallbox");

		if(webDriver.isPresent(loaderModal)) {
			webDriver.waitForElementNotToBeClickable(loaderModal);
		} else {
			webDriver.waitWithDriver(2500);
		}

		if(webDriver.isPresent(procesandoWindow)) {
			webDriver.waitForElementNotToBeClickable(procesandoWindow);
		} else {
			webDriver.waitWithDriver(2500);
		}
	}

	// Método pensado para acabar con las esperas que cortan la ejecución automática genérico
	public static void waitForIt(DriverHelper webDriver, By by) {
		if(webDriver.isPresent(by)) {
			webDriver.waitForElementNotToBeClickable(by);
		} else {
			webDriver.waitWithDriver(2500);
		}
	}

	// Mismo método con 2 elementos genéricos de entrada
	public static void waitForIt(DriverHelper webDriver, By by, By cy) {
		waitForIt(webDriver, by);
		waitForIt(webDriver, cy);
	}

	// Cuando se necesita esperar x milisegundos
	public static void waitForIt(DriverHelper webDriver, int x) {
		webDriver.waitWithDriver(x);
	}

	public void contratar_poliza_MEC(String loginAcess, String user) throws URISyntaxException {
		debugBegin();

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) { // && !mediador.equals("640")) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();
			// new GestionOnlineHomePage(userS).createNewSimulation();
			// new AsignarMediadorPage(userS).selectMediadorAndClickOnContinuar(userS.getScenario());
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();
			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(mediador)
				.clickContinuar();
		}

		// The testId variable has been set here because the FillTomadorData
		// from DatosBasicosTomadorPage requires it. Not sure if this is the
		// proper usage.
		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickContinuar();

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
			.clickContinuarAndValidate();

		new PrecioPage(userS)
			.clickConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			// .executeActionsInPrecioPorModalidadPage();
			.clickContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new ClausulasPage(userS)
			.activarClausulas()
			.completarClausulaHipotecaria()
			.clickContinuar();

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
			.addDatosTomador()
			.addDatosTomadorDiferenteAsegurado()
			.clickContinuar();

		new DocumentacionPage(userS)
			.subirFichero();

		new DatosBancariosPage(userS)
			.fillPaymentMethod(getTestVar(Constants.MEDIO_PAGO))
			.clickGuardar()
			.getProjectCodeNumberAndClickOnAceptarButton()
			.aceptarCondicionesLegales()
			.clickContratarAndGetPolizaNumber();

		// new DataSteps(userS).imprimir_informacion_del_proyecto();
		userS.getWebDriver().quit();

		new DocumentacionPage(userS)
			.subirFichero();

		new DatosBancariosPage(userS)
			.fillPaymentMethod(getTestVar(Constants.MEDIO_PAGO))
			.clickGuardar()
			.getProjectCodeNumberAndClickOnAceptarButton()
			.aceptarCondicionesLegales()
			.clickContratarAndGetPolizaNumber();

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void selecciono_Hay_una_gasolinera_a_menos_de_m(int arg1) {
		userS.setTestVar(Constants.GASOLINERA_MENOS_50M, "true");
	}

	public void openSimulationMec() {
		new InnovaHomePage(userS)
			.openMutuaEdificioConfort()
			.openNewSimulationMec();
	}

	public void crear_un_proyecto_MAC(String loginAccess, String user) {
		debugBegin();
		// Login
		login(loginAccess, user);

		// Create project MAC
		createProjectMAC(loginAccess);

		// Assign mediador
		String mediador = getScenarioVar(Constants.MEDIADOR);
		if(loginAccess.equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.selectMediadorMACAndClickContinuar();
		} else if(loginAccess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.seleccionarMediadorMACPorCodigo(mediador)
				.clickContinuar();
		}

		// Precio
		new PrecioPorModalidadPageMac(userS)
			.completarRentaMensualAlquiler()
			.completarGarantiasBasicas()
			.clickConvertirAProyecto();

		// SCS Precio
		// PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
		// PrecioPorModalidadPage_MAC(userS);
		// precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();

		// Inquilinos
		new InquilinosAvalistasPageMac(userS).executeActionsInInquilinosAvalistasPage();

		// SCS Inquilinos
		// InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
		// InquilinosAvalistasPage_MAC(userS);
		// inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage();
		debugEnd();
	}

	public void createProjectMAC(String accessType) {
		debugBegin();

		if(accessType.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();
		} else if(accessType.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS).OpenMutuaAlquilerConfort();
			new InnovaHomePage(userS).createNewProject();
		}

		debugEnd();
	}

	public void searchAuthorisation() {
		debugBegin();

		new InnovaHomePage(userS)
			.openGestionAutorizaciones();

		new GestionAutorizacionesPage(userS)
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION));

		debugEnd();
	}

	public void enviar_el_proyecto_a_la_compania() {
		debugBegin();

		new InquilinosAvalistasPageMac(userS)
			.enviarACompania();

		debugEnd();
	}

	public void login_y_autorizar_el_proyecto_MAC(String loginAccess, String user) {
		debugBegin();

		login(loginAccess, user);

		searchAuthorisation();
		new GestionAutorizacionesPage(userS)
			.autorizar();

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
				.selectMediadorMACAndClickContinuar();
		}

		new PrecioPorModalidadPageMac(userS).clickContinuar();
		new InquilinosAvalistasPageMac(userS).clickContinuar();

		// Completar paso Contratación
		new TomadorYAseguradoPageMac(userS)
			.addDatosTomadorAsegurado();

		new InmueblePageMac(userS)
			.addInmuebleByAddress();

		new DocumentacionPageMac(userS)
			.addDocumentContratacion();

		new ContratacionPageMac(userS)
			.seleccionarCheckYContratar();

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

	// ############## # SINIESTROS # ##############
	public void accederCliente() {
		debugBegin();

		new ClientePage(userS)
			.accederAlBuscadorClientes()
			.clickNuevoTomadorSecond()
			.datosTomador()
			.localizacionDomicilioTomador();

		debugEnd();
	}

	public void marcaCliente() {
		debugBegin();

		new ClientePage(userS)
			.accederAlBuscadorClientes();

		debugEnd();
	}

	public void buscaClientePorNif() {
		debugBegin();

		new ClientePage(userS)
			.buscarClientePorNIF();

		debugEnd();
	}

	public void buscaClientePorNombre() {
		debugBegin();

		new ClientePage(userS)
			.buscarClientePorNIF();

		debugEnd();
	}

	public void buscadorCliente() {
		debugBegin();

		new ClientePage(userS)
			.clickContiuarResultadoBusqueda();

		debugEnd();
	}

	public void marcaRelacion() {
		debugBegin();

		new ClientePage(userS)
			.marcaRelacion();

		debugEnd();
	}

	public void marcaNegativa() {
		debugBegin();

		new ClientePage(userS)
			.anyadirMarcaNegativa();

		debugEnd();
	}

	// ALTA SINIESTRO
	public void alta_siniestro(String acceso, String numPoliza) {
		debugBegin();

		if(acceso.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openSiniestros();

			new HomeSiniestrosPage(userS)
				.openAperturaAlta();

			new GestionPolizasBuscadorPage(userS)
				.buscarPorNumeroPoliza(numPoliza)
				.seleccionarResultado();

			new AltaAperturaDeclaracionSiniestrosPage(userS)
				.completarMinimos(numPoliza);

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();

			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.datosMinOcurrencia(numPoliza);

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();

			new ImplicadoAseguradoSiniestrosPage(userS)
				.aperturaSinietro();

			new ConfirmacionSiniestrosPage(userS)
				.check();
		} else if(acceso.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openSiniestros();
		}

		debugEnd();
	}

	// ALTA SINIESTRO ALTERNATIVA
	public void alta_siniestroAlt(String acceso, String numPoliza, String asistencia, String otrosImplicados, String encargo) {
		debugBegin();

		String ramo = "";

		if(acceso.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openSiniestros();

			new HomeSiniestrosPage(userS)
				.openAperturaAlta();

			// De no haber póliza se tomará una al azar de las últimas 50
			if(numPoliza == null || numPoliza.isEmpty()) {
				new AltaAperturaSiniestrosPage(userS)
					.buscar50Polizas()
					.continuarRandomPoliza();

			} else {
				// Buscamos una póliza por Nº póliza
				debugInfo("NUM POLIZA: " + numPoliza);

				if(numPoliza.startsWith("510")) {
					ramo = "510";
				} else if(numPoliza.startsWith("920") || numPoliza.startsWith("900")) {
					ramo = "920";
				} else if(numPoliza.startsWith("660")) {
					ramo = "660";
				} else if(numPoliza.startsWith("400") || numPoliza.startsWith("200") || numPoliza.startsWith("150")
					|| (numPoliza.startsWith("500") && !numPoliza.startsWith("5000"))) {
					ramo = "500";
				} else if(numPoliza.startsWith("5000") || numPoliza.startsWith("600") || numPoliza.startsWith("610")
					|| numPoliza.startsWith("620") || numPoliza.startsWith("630") || numPoliza.startsWith("640")) {
					ramo = "640";
				}

				new AltaAperturaSiniestrosPage(userS)
					.buscarPorNumPoliza(ramo, numPoliza)
					.continuarPrimeraPoliza();
			}
			// 1.Declaración
			new AltaAperturaDeclaracionSiniestrosPage(userS)
				.altaDatosBasicos("MEDI", "MAIL")
				.datosPersonaExtra("NORIE", "NombreInq", "ApellidoInq", "OtroInq", "NIF", "36155457D", "", "666123123", "", "", "H", "TRUE", "prueba@esto.es", "TRUE", "", "", "", "", "", "", "", "");

			// Comprobamos si necesita asistencia
			if(!asistencia.isEmpty()) {
				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.altaConAsistencia("", "", "", "Daños ubicados en el interior del riesgo asegurado", "", "");
			} else if(new AltaAperturaDeclaracionSiniestrosPage(userS).posibilidadAsistencia()) {
				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.altaSinAsistencia();
			}

			new AltaAperturaDeclaracionSiniestrosPage(userS)
				.clickContinuar();

			// Validamos cosas
			if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
				new ValidacionExcepcionesReglasPage(userS)
					.clickContinuar();
			}

			// Completamos el apartado de Ocurrencia
			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.altaRiesgoAsegurado();

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

			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.altaSeleccionarCausas(gCausa, tCausa, gremio)
				.altaRellenarDatos("Descripción test para realizar un alta de siniestro", otrosImplicados, encargo)
				.clickContinuar();

			// Validamos más cosas
			if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
				new ValidacionExcepcionesReglasPage(userS).clickContinuar();
			}

			// Completamos el apartado de Implicado asegurado
			new ImplicadoAseguradoSiniestrosPage(userS)
				.clickApertura();

			// Comprobamos si se requiere añadir un implicado extra
			if(!otrosImplicados.isEmpty()) {
				new OtrosImplicadosAltaSiniestrosPage(userS)
					.clickNuevoImplicado();

				new OtrosImplicadosDatosSiniestrosPage(userS)
					.introducirDatosPersonales("LESI", "NORIE", "Exra", "Segundo", "NIF", "77315592B", "666885985", "", "", "implicadoextra@mail.com")
					.introducirDatosDireccion("", "", "", "", "", "", "", "", "ES21", "2100", "0001", "05", "0000000001")
					.clickGrabar();

				new OtrosImplicadosAltaSiniestrosPage(userS)
					.clickContinuar();
			}

			// Comprobamos si se requiere añadir un encargo
			if(!encargo.isEmpty()) {
				new EncargoAltaSiniestrosPage(userS)
					.clickNuevoEncargo();

				new EncargoDatosSiniestrosPage(userS)
					.seleccionarTipoEncargo("PGRA", "PERIGRAL", "PERITACI")
					.seleccionarDatosEncargo(new Date(), "")
					.clickGrabar();

				new EncargoAltaSiniestrosPage(userS)
					.clickContinuar();
			}

			// Página de confirmación
			new ConfirmacionSiniestrosPage(userS)
				.confirmarSiniestroOK();

			// Accedemos a siniestros desde Gestión On Line
		} else if(acceso.equals(Constants.LoginAccessGestionLine)) {
			// Seleccionamos la opcion alta siniestros
			new GestionOnlineHomePage(userS)
				.seleccionaIdiomaCast()
				.altaSiniestros();

			// Damos de alta el siniestro
			new GestionOnlineAltaSiniestrosPage(userS)
				.altaInfoPoliza(numPoliza, "");

			if(numPoliza.startsWith("510")) {
				ramo = "510";
			} else if(numPoliza.startsWith("920") || numPoliza.startsWith("900")) {
				ramo = "920";
			} else if(numPoliza.startsWith("660")) {
				ramo = "660";
			} else if(numPoliza.startsWith("400") || numPoliza.startsWith("200") || numPoliza.startsWith("150")
				|| (numPoliza.startsWith("500") && !numPoliza.startsWith("5000"))) {
				ramo = "500";
			} else if(numPoliza.startsWith("5000") || numPoliza.startsWith("600") || numPoliza.startsWith("610")
				|| numPoliza.startsWith("620") || numPoliza.startsWith("630") || numPoliza.startsWith("640")) {
				ramo = "640";
			}

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

			new GestionOnlineAltaSiniestrosPage(userS)
				.altaCausaDescripcion(causa, "Descripción para la apertura del sinestro de prueba automática", "")
				.altaCuentaSiniestro()
				.altaPersonaContacto("INQVE__11", "Jose", "Martinez", "Perez", "666502101", "mail@mail.com")
				.altaDireccionContacto(true, "", "", "", "", "", "", "", "")
				.altaObservaciones("TEST Automatico apertura siniestro")
				.clickEnviar()
				.checkYaExisteSiniestro()
				.comprobarOk();
		}

		if(acceso.equals(Constants.LoginAccessInnova)) {
			new ConfirmacionSiniestrosPage(userS)
				.confirmarSiniestroOK();
		}
	}

	// TRAMITAR SINIESTRO
	public void tramitar_siniestro(String acceso, String numPoliza) {
		debugBegin();

		alta_siniestro(acceso, numPoliza);

		new ConfirmacionSiniestrosPage(userS)
			.tramitarSiniestro();

		debugEnd();
	}

	// REALIZAR PAGO DE UN SINIESTRO (desde dar de alta un pago en siniestro
	// hasta confirmarlo)

	// realizar_pago_sinietro

	// MAC: SE INFORMA DE QUE LA POLIZA NO SE PUEDE EMITIR
	public void se_informa_de_que_la_poliza_no_se_puede_emitir() {
		// Compropar el estado
		Assert.assertTrue(new ContratacionPageMac(userS).checkPolizaError());
	}

	// MAC: MODIFICAR INGRESOS
	public void modificar_ingresos(String ingresos) {
		userS.setTestVar(Constants.INGRESOS_INQUILINO, ingresos);
	}

	// MAC AÑADIR AVALISTA
	public void anyado_avalista() {
		new InquilinosAvalistasPageMac(userS)
			.addDatosAval()
			.anyadirDocumentacionAval()
			.validacionViabilidadInquilino();
	}

	// MAC DENIEGO EL PROYECTO MAC USANDO ACCESO Y USUARIO
	public void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(String loginAccess, String user) throws Exception {
		debugBegin();
		login(loginAccess, user);

		// Abrir la busqueda de autorizaciones
		new InnovaHomePage(userS)
			.openGestionAutorizaciones();

		new GestionAutorizacionesPage(userS)
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", userS.getTestVar(Constants.NUM_COTIZACION))
			.denegar();

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void busco_el_proyecto_usando_el_acceso_y_el_usuario(String loginAccess, String user) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new GestionOnlineHomePage(userS)
			.openMisProyectosWeb();

		debugInfo("NUM COTIZACION: " + userS.getTestVar(Constants.NUM_COTIZACION));

		new GestionOnlineHomePage(userS)
			.buscarProyectoWeb(userS.getTestVar(Constants.NUM_COTIZACION));

	}

	public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(String loginAccess, String user) throws Exception {
		login(loginAccess, user);

		crear_proyecto_MAC();

		if(loginAccess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS).selectMediadorMACAndClickContinuar();
		}

		// SCS Precio
		new PrecioPorModalidadPageMac(userS)
			.completarRentaMensualAlquiler()
			.completarGarantiasBasicas()
			.clickConvertirAProyecto();

		// SCS Inquilinos
		new InquilinosAvalistasPageMac(userS)
			.executeActionsInInquilinosAvalistasPage();
	}

	public void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() {
		debugBegin();

		new InquilinosAvalistasPageMac(userS)
			.clickContinuar();

		new TomadorYAseguradoPageMac(userS)
			.addDatosTomadorAsegurado();

		new InmueblePageMac(userS)
			.addInmuebleByAddress();

		new DocumentacionPageMac(userS)
			.addDocumentContratacion();

		new ContratacionPageMac(userS)
			.seleccionarCheckYContratar();

		debugEnd();
	}

	public void la_renta_mensual_es() {
		new PrecioPorModalidadPageMac(userS)
			.completarRentaMensualAlquiler();
	}

	public void la_suma_asegurada_de_impago_alquiler_es() {
		new PrecioPorModalidadPageMac(userS)
			.seleccionarImpagoAlquiler();
	}

	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(String loginAcess, String user) {
		debugBegin();

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaEdificioConfort();
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();

			new AsignarMediadorPage(userS)
				.terminaProcesando()
				.seleccionarMediadorPorCodigo(mediador)
				.clickContinuar();
		}

		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickContinuar()
			.waitProcesando();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada()
			.waitProcesando();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgoMinimos();
		new DetallesRiesgoPage(userS)
			.clickContinuar()
			.waitProcesando();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickContinuarAndValidate()
			.waitProcesando();

		// new PrecioPage(userS).clickOnConvertirAProjecto().waitProcesando();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar(Constants.TOMADOR))
			// .clickOnContinuar()
			.waitProcesando();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.completarCoberturaPorMaquinaria()
			.completarCoberturasEmpleados()
			.completarCoberturasEnergiaSolar()
			.completarFranquiciaVoluntaria()
			.completarOQuitarDescuentoRecargo()
			.clickContinuar()
			.waitProcesando();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new ClausulasPage(userS)
			.activarClausulas()
			.completarClausulaHipotecaria()
			.clickContinuar();

		/*
		 * new TomadorYAseguradoPage(userS) .AddDatosTomador() .AddDatosTomadorDiferenteAsegurado() .clickOnContinuar();
		 *
		 * new DocumentacionPage(userS).SubirFichero();
		 *
		 * new DatosBancariosPage(userS).introducirFormaPagoYPulsarContratar();
		 *
		 * // new DataSteps(userS).imprimir_informacion_del_proyecto();
		 *
		 */

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_y_guardo_sin_contratar_usando(String loginAcess, String user) {
		debugBegin();

		login(loginAcess, user);

		String mediador = getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();

			new AsignarMediadorPage(userS)
				.terminaProcesando()
				.seleccionarMediadorPorCodigo(mediador)
				.clickContinuar();
		}

		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgoMinimos();
		new DetallesRiesgoPage(userS)
			.clickContinuar();

		debugEnd();
	}

	public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		debugBegin();

		login(loginAcess, user);

		String mediador = userS.getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			openSimulationMec();

			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(mediador)
				.clickContinuar();
		}

		new UbicacionRiesgoPage(userS)
			.addInmueble(getScenarioVar(Constants.INMUEBLE));

		new UbicacionRiesgoPage(userS)
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgo()
			.clickContinuar();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickContinuarAndValidate();

		new PrecioPage(userS)
			.clickConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(userS.getScenarioVar(Constants.TOMADOR))
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.completarCoberturaPorMaquinaria()
			.completarCoberturasEmpleados()
			.completarCoberturasEnergiaSolar()
			.completarFranquiciaVoluntaria()
			.completarOQuitarDescuentoRecargo()
			.clickContinuar();

		debugEnd();
	}

	public void intento_dar_alta_simulacion_hasta_datos_riesgo(String loginAcess, String user) throws Exception {
		debugBegin();

		login(loginAcess, user);

		String mediador = getScenarioVar(Constants.MEDIADOR);

		if(loginAcess.equals(Constants.LoginAccessGestionLine) && mediador != null && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(mediador)
				.clickContinuar();
		}

		new UbicacionRiesgoPage(userS)
			.addInmueble(userS.getTestVar(Constants.INMUEBLE));
		new UbicacionRiesgoPage(userS)
			.clickContinuar();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgo()
			.clickContinuar();

		debugEnd();
	}

	public void lo_consulto_en_el_buscador_de_cotizaciones(String loginAccess, String user) {
		debugBegin();

		login(loginAccess, user);

		new InnovaHomePage(userS)
			.openGestionCotizaciones();

		new GestionCotizacionesBuscadorPage(userS)
			.searchCotizacion(getScenarioVar(Constants.NUM_COTIZACION));

		debugEnd();
	}

	public void el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() {
		debugBegin();

		String cotizacion = new GestionCotizacionesBuscadorPage(userS).getCotizacion();

		Assert.assertTrue(cotizacion.contains(getScenarioVar(Constants.NUM_COTIZACION)));

		debugEnd();
	}

	public void se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(String loginAccess, String user) {
		debugBegin();

		login(loginAccess, user);

		new GestionCotizacionesBuscadorPage(userS)
			.modificarProjecto();

		new AsignarMediadorPage(userS)
			.clickContinuar();

		new UbicacionRiesgoPage(userS)
			.closeAvisoSistemaPopup()
			.modifyReferenciaCatastral()
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.checkAvisoGarajes()
			.getCapitales()
			.modificarDatosRiesgo()
			.clickContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new DatosBasicosTomadorPage(userS)
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.clickContinuar();

		// validacionExcepcionesReglasPage.clickContinuar();

		new ClausulasPage(userS)
			.clickContinuar();

		new TomadorYAseguradoPage(userS)
			.clickContinuar();

		new DatosBancariosPage(userS)
			.clickGuardar();

		// new DataSteps(userS).imprimir_informacion_del_proyecto();
		userS.getWebDriver().quit();

		debugEnd();

	}

	public void el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente() {
		debugBegin();

		login(getScenarioVar(Constants.CAMBIO_ACCESO), getScenarioVar(Constants.CAMBIO_USUARIO));

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA))
			.consultarPoliza();

		new GestionPolizasConsultarPage(userS)
			.checkPolizaNumber();

		debugEnd();

	}

	public void doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(String loginAccess, String user) {
		debugBegin();

		if(loginAccess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAccess.equals(Constants.LoginAccessInnova)) {
			login(loginAccess, user);

			openSimulationMec();

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.addInmuebleByAddress();
			new UbicacionRiesgoPage(userS)
				.clickContinuar();

			/**
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
	public void agrego_un_suplemento() {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));

		new GestionPolizasBuscadorPage(userS)
			.addSuplementoGeneral();

		new AsignarMediadorPage(userS)
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.clickContinuar();

		new UbicacionRiesgoPage(userS)
			.editInmuebleAndExcluirGarajesYLocales()
			.editCalidadConstruccion()
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.checkAvisoGarajes()
			.getCapitales()
			.modificarDatosRiesgo()
			.clickContinuar();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickContinuarAndValidate();

		new DatosBasicosTomadorPage(userS)
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.completarCoberturaPorMaquinaria()
			.completarCoberturasEmpleados()
			.completarCoberturasEnergiaSolar()
			.completarFranquiciaVoluntaria()
			.completarOQuitarDescuentoRecargo()
			.clickContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new ClausulasPage(userS)
			.activarClausulas()
			.completarClausulaHipotecaria()
			.clickContinuar();

		new TomadorYAseguradoPage(userS)
			.clickContinuar();
	}

	public void agrego_el_motivo_suplemento(String motivoSuplemento) {
		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, true, userS);

		new ConfirmarPage(userS)
			// .ActivateMotivosSuplementoAndClickContinuar();
			.activateMotivosSuplemento();
	}

	public void emito_el_suplemento() {
		new ConfirmarPage(userS)
			// .ActivateMotivosSuplemento();
			.clickContinuar();

		new ValidacionExcepcionesReglasConfirmarPoliza(userS)
			.clickContinuar();

		new DatosBancariosPage(userS)
			.clickEmitirSuplemento();
	}

	public void emito_un_suplemento_general_con_motivo(String motivoSuplemento) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));

		// tCData.setSuplemento(true);
		new GestionPolizasBuscadorPage(userS)
			.addSuplementoGeneral();

		new AsignarMediadorPage(userS)
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.clickContinuar();

		new UbicacionRiesgoPage(userS)
			.editInmuebleAndExcluirGarajesYLocales()
			.editCalidadConstruccion()
			.clickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.checkAvisoGarajes()
			.getCapitales()
			.modificarDatosRiesgo()
			.clickContinuar();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickContinuarAndValidate();

		new DatosBasicosTomadorPage(userS)
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.completarCoberturaPorMaquinaria()
			.completarCoberturasEmpleados()
			.completarCoberturasEnergiaSolar()
			.completarFranquiciaVoluntaria()
			.completarOQuitarDescuentoRecargo()
			.clickContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new ClausulasPage(userS)
			.activarClausulas()
			.completarClausulaHipotecaria()
			.clickContinuar();

		new TomadorYAseguradoPage(userS)
			.clickContinuar();

		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, true, userS);

		new ConfirmarPage(userS)
			.activateMotivosSuplementoAndClickContinuar();

		new ValidacionExcepcionesReglasConfirmarPoliza(userS)
			.clickContinuar();

		// DocumentacionPage documentacionPage = new DocumentacionPage(userS);
		// documentacionPage.SubirFichero();
		new DatosBancariosPage(userS)
			.clickEmitirSuplemento();
		// MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(userS);
		// mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
	}

	public void doy_de_alta_una_simulacion_y_la_convierto_en_una_contratacion_usando_el_acceso_y_el_usuario(String loginAcess, String user) throws Exception {
		login(loginAcess, user);
		crear_simulacion();

		new AsignarMediadorPage(userS)
			.selectMediadorAndClickContinuar();

		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickContinuar();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosRiesgo()
			.clickContinuar();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickContinuarAndValidate();

		new PrecioPage(userS)
			.clickConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickContinuar();

		new PrecioPorModalidadPage(userS)
			.seleccionarModalidad()
			.completarCoberturaPorMaquinaria()
			.completarCoberturasEmpleados()
			.completarCoberturasEnergiaSolar()
			.completarFranquiciaVoluntaria()
			.completarOQuitarDescuentoRecargo()
			.clickContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickContinuar();

		new ClausulasPage(userS)
			.activarClausulas()
			.completarClausulaHipotecaria()
			.clickContinuar();

		new TomadorYAseguradoPage(userS)
			.addDatosTomador()
			.addDatosTomadorDiferenteAsegurado()
			.clickContinuar();

		new DatosBancariosPage(userS)
			.fillPaymentMethod(getTestVar(Constants.MEDIO_PAGO))
			.clickGuardar()
			.getProjectCodeNumberAndClickOnAceptarButton()
			.aceptarCondicionesLegales()
			.clickContratarAndGetPolizaNumber();

		new DataSteps(userS)
			.imprimir_informacion_del_proyecto();

		userS.getWebDriver().quit();
	}

	public void modifico_la_cotización(String loginAcess, String user) {
		debugBegin();

		loginAcess = getScenarioVar(Constants.CAMBIO_ACCESO);
		user = getScenarioVar(Constants.CAMBIO_USUARIO);

		if(loginAcess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar(Constants.GESTION_ONLINE_DISPONIBLE).equals(Constants.GestionOnlineDisponible)
			|| loginAcess.equals(Constants.LoginAccessInnova)) {
			login(loginAcess, user);
			buscar_cotizacion_por_numero_cotizacion(loginAcess, getScenarioVar(Constants.NUM_COTIZACION));

			new GestionCotizacionesBuscadorPage(userS)
				.modificarProjecto();

			new AsignarMediadorPage(userS)
				.clickContinuar();

			new UbicacionRiesgoPage(userS)
				.closeAvisoSistemaPopup()
				.modifyReferenciaCatastral()
				.clickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.checkAvisoGarajes()
				.getCapitales()
				.modificarDatosRiesgo()
				.clickContinuar();

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();

			new DatosBasicosTomadorPage(userS)
				.clickContinuar();

			new PrecioPorModalidadPage(userS)
				.seleccionarModalidad()
				.clickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.clickContinuar();

			new ClausulasPage(userS)
				.clickContinuar();

			new TomadorYAseguradoPage(userS)
				.clickContinuar();

			new DatosBancariosPage(userS)
				.fillPaymentMethod(getTestVar(Constants.CAMBIO_MEDIO_PAGO))
				.clickGuardar()
				.getProjectCodeNumberAndClickOnAceptarButton()
				.aceptarCondicionesLegales()
				.clickContratarAndGetPolizaNumber();

			new DataSteps(userS)
				.imprimir_informacion_del_proyecto();

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
				new AsignarMediadorPage(userS)
					.selectMediadorAndClickContinuar();
			} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
				new AsignarMediadorPage(userS)
					.seleccionarMediadorPorCodigo(mediador)
					.clickContinuar();
			}

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.completarDatosRiesgo()
				.clickContinuar();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.clickContinuarAndValidate();

			new PrecioPage(userS)
				.clickConvertirAProjecto();

			new DatosBasicosTomadorPage(userS)
				.fillTomadorData(getScenarioVar(Constants.TOMADOR))
				.clickContinuar();

			new PrecioPorModalidadPage(userS)
				.seleccionarModalidad()
				.completarCoberturaPorMaquinaria()
				.completarCoberturasEmpleados()
				.completarCoberturasEnergiaSolar()
				.completarFranquiciaVoluntaria()
				.completarOQuitarDescuentoRecargo()
				.clickContinuar();

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();

			new ClausulasPage(userS)
				.activarClausulas()
				.completarClausulaHipotecaria()
				.clickContinuar();

			new TomadorYAseguradoPage(userS)
				.addDatosTomador()
				.addDatosTomadorDiferenteAsegurado()
				.clickContinuar();
			new DocumentacionPage(userS)
				.subirFichero();

			new DatosBancariosPage(userS)
				.fillPaymentMethod(getTestVar(Constants.MEDIO_PAGO))
				.clickGuardar()
				.getProjectCodeNumberAndClickOnAceptarButton()
				.aceptarCondicionesLegales()
				.clickContratarAndGetPolizaNumber();

			new DataSteps(userS)
				.imprimir_informacion_del_proyecto();

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
				new AsignarMediadorPage(userS)
					.selectMediadorAndClickContinuar();
			} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
				new AsignarMediadorPage(userS)
					.seleccionarMediadorPorCodigo(mediador)
					.clickContinuar();
			}

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.completarDatosRiesgo()
				.clickContinuar();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.clickOnContinuar();

			new PrecioPage(userS)
				.clickConvertirAProjecto();

			new DatosBasicosTomadorPage(userS)
				.fillTomadorData(getScenarioVar(Constants.TOMADOR))
				.clickContinuar();

			new PrecioPorModalidadPage(userS)
				.seleccionarModalidad()
				.completarCoberturaPorMaquinaria()
				.completarCoberturasEmpleados()
				.completarCoberturasEnergiaSolar()
				.completarFranquiciaVoluntaria()
				.completarOQuitarDescuentoRecargo()
				.clickContinuar();

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();

			new ClausulasPage(userS)
				.activarClausulas()
				.completarClausulaHipotecaria()
				.clickContinuar();

			new TomadorYAseguradoPage(userS)
				.addDatosTomador()
				.addDatosTomadorDiferenteAsegurado()
				.clickContinuar();

			new DatosBancariosPage(userS)
				.fillPaymentMethod(getTestVar(Constants.MEDIO_PAGO))
				.clickGuardar()
				.getProjectCodeNumberAndClickOnAceptarButton();

			new DataSteps(userS)
				.imprimir_informacion_del_proyecto();
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

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.checkAvisoGarajes()
				.getCapitales()
				.completarDatosRiesgo();
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

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.checkAvisoGarajes()
				.getCapitales()
				.completarDatosRiesgo();
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

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.completarDatosRiesgo()
				.clickContinuar();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.clickContinuarAndValidate();

			new PrecioPage(userS)
				.clickConvertirAProjecto();
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

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickContinuar();

			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
				.isUbicacionRiesgoUtilizada();

			new DetallesRiesgoPage(userS)
				.completarDatosRiesgo()
				.clickContinuar();

			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.clickContinuarAndValidate();
			// PrecioPage precioPage = new PrecioPage(userS);
			// precioPage.clickOConvertirAProjecto();
		}
	}

	public void continuo_en_datos_básicos_del_tomador() throws Exception {
		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickContinuar();
	}

	public void lo_consulto_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_poliza_por_numero_de_poliza(getScenarioVar(Constants.NUM_POLIZA));
	}

	public void lo_consulto_por_dni_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_poliza_por_numero_documento(getScenarioVar(Constants.DNI_TOMADOR));
	}

	public void continuo_en_detalles_riesgo() throws Exception {
		debugBegin();

		new DetallesRiesgoPage(userS)
			.checkAvisoGarajes()
			.getCapitales()
			.completarDatosRiesgo()
			.clickContinuar();

		debugEnd();
	}

	public void modifico_el_capital_continente_a(String capitalContinente) {
		setTestVar(Constants.CAPITAL_CONTINENTE, capitalContinente);
	}

	public void cierro_navegador() {
		debugBegin();
		userS.getWebDriver().quit();
		debugEnd();
	}

	public void se_descargan_los_ficheros_del_suplemento_en_la_carpeta(String filesPath) {
		debugBegin();

		new MensajeConfirmacionPage(userS)
			.downlodadDocumentsToFolder(filesPath);

		debugEnd();
	}

	public void autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(String loginAcess, String user) {
		login(loginAcess, user);

		new InnovaHomePage(userS)
			.openGestionAutorizaciones();

		debugInfo("Cotizacion:" + getTestVar(Constants.NUM_COTIZACION));

		new GestionAutorizacionesPage(userS)
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION))
			.autorizar();
	}

	public void envio_el_proyecto_a__la_compania() {
		debugBegin();

		new InquilinosAvalistasPageMac(userS)
			.enviarACompania();
		// userS.getWebDriver().quit();
		debugEnd();
	}

	public void completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario(String loginAcess, String user) {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		buscar_cotizacion_por_numero_cotizacion(loginAcess, getTestVar(Constants.NUM_COTIZACION));

		new GestionOnlineHomePage(userS)
			.modificarProyecto();

		if(loginAcess.equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.selectMediadorMACAndClickContinuar();
		}

		new PrecioPorModalidadPageMac(userS)
			.clickContinuar();
		new InquilinosAvalistasPageMac(userS)
			.clickContinuar();

		// Rellenar datos de contratacion, pagina 3
		new TomadorYAseguradoPageMac(userS)
			.addDatosTomadorAsegurado();

		new InmueblePageMac(userS)
			.addInmuebleByAddress();

		new DocumentacionPageMac(userS)
			.addDocumentContratacion();

		new ContratacionPageMac(userS)
			.seleccionarCheckYContratar();
	}

	public void valido_un_proyecto_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		loginAcess = getScenarioVar(Constants.ACCESO);
		user = getScenarioVar(Constants.USUARIO);

		login(loginAcess, user);
		crear_proyecto_MEC();

		// Asignar mediador
		new AsignarMediadorPage(userS)
			.selectMediadorMACAndClickContinuar();

		// SCS Precio
		new PrecioPorModalidadPageMac(userS)
			.completarRentaMensualAlquiler()
			.completarGarantiasBasicas()
			.clickConvertirAProyecto();

		// SCS Inquilinos
		new InquilinosAvalistasPageMac(userS)
			.addDatosInquilino();
		// inquilinosAvalistasPage_MAC.ValidacionViabilidadInquilino();
	}

	public void valido_el_proyecto() {
		new InquilinosAvalistasPageMac(userS)
			.validacionViabilidadInquilino();
	}

	public void busco_un_edificio_por_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		setTestVar(Constants.FILTRO_BUSCADOR_EDIFICIO, getScenarioVar(Constants.FILTRO_BUSCADOR_EDIFICIO));

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new FichaEdificioPage(userS)
			.accederAlBuscadorEdificios()
			.buscarConFiltroBusqueda();
	}

	public void abro_ficha_edificio_desde_grid_resultados() {
		new FichaEdificioPage(userS)
			.openFichaEdificioDesdeGrid();
	}

	public void busco_edificios_por_direcciones_con_el_fichero() {
		new FichaEdificioPage(userS)
			.accederAlBuscadorEdificios()
			.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_DIRECCION)
			.iterarEdificiosPorDirecciones(getScenarioVar(Constants.FICHERO));
	}

	public void busco_edificios_por_direcciones_en_buscador_MEC_con_el_fichero() {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMutuaEdificioConfort()
			.createNewProject();

		new AsignarMediadorPage(userS)
			.selectMediadorAndClickContinuar();

		new UbicacionRiesgoPage(userS)
			.iterarEdificiosPorDirecciones(getScenarioVar(Constants.FICHERO));
		// fichaEdificioPage.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_DIRECCION);
		// fichaEdificioPage.IterarEdificiosPorDirecciones(
		// getValuesDataSet(tCData.gethMapDataSet(), nombreFichero, tCData.getTestID()));
	}

	public void busco_edificios_por_referencias_con_el_fichero() {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new FichaEdificioPage(userS)
			.accederAlBuscadorEdificios()
			.setFiltroBusqueda(Constants.FILTRO_BUSCADOR_CATASTRAL)
			.iterarEdificiosPorReferencias(getScenarioVar(Constants.FICHERO));
	}

	public void busco_edificios_por_referencias_en_el_buscador_MEC_con_el_fichero() throws Exception {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		// FichaEdificioPage
		new InnovaHomePage(userS)
			.openMutuaEdificioConfort()
			.createNewProject();

		new AsignarMediadorPage(userS)
			.selectMediadorAndClickContinuar();

		debugInfo("Nombre fichero en action steps: " + getScenarioVar(Constants.FICHERO));
		new UbicacionRiesgoPage(userS)
			.iterarEdificiosPorReferencias(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + getScenarioVar(Constants.FICHERO));
	}

	private static int getIndexInArray(String[] array, String compareString) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].equals(compareString)) { return i; }
		}

		return -1;
	}

	private static String getValuesDataSetByID(String[][] array, String string, int index) {
		String value = null;

		if(getIndexInArray(array[0], string) >= 0) {
			value = array[index][getIndexInArray(array[0], string)];
		}

		return value;
	}

	private static String[][] setValuesDataSetByID(String[][] array, String string, int index, String newValue) {
		if(getIndexInArray(array[0], string) >= 0) {
			array[index][getIndexInArray(array[0], string)] = newValue;
		}

		return array;
	}

	public void doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero() {
		debugBegin();

		String logText = "";
		String address = "";

		setScenarioVar(Constants.INMUEBLE, "direccion por defecto");

		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMutuaEdificioConfort();

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int i = 1; i < datosAltoValor.length; i++) {
			new InnovaHomePage(userS)
				.openNewSimulationMec();

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

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			try {
				if(!new UbicacionRiesgoPage(userS).fillInmuebleAndGetAvailability()) {
					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
					debugInfo("Mas de una referencia catastral encontrada");

					userS.getWebDriver().exitFrame();

					new InnovaHomePage(userS)
						.openInnovaHome()
						.openMutuaEdificioConfort();

					writeFile(fileName + " (log file).txt", logText);
					continue;
				}

				new UbicacionRiesgoPage(userS)
					.closeNotification();
				new UbicacionRiesgoPage(userS)
					.clickContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
					.isUbicacionRiesgoUtilizada();

				String anyoConstruccion = new DetallesRiesgoPage(userS)
						.completarDatosRiesgoMinimos();
				
				new DetallesRiesgoPage(userS)
					.clickContinuar();

				new PrecioPorModalidadPage(userS)
					// precioPorModalidadPage.modificarRC("600.000,00");
					// precioPorModalidadPage.agregarDescuento(getValuesDataSet(tCData.gethMapDataSet(),
					// tCData.getDescuento(),
					// tCData.getTestID()));
					.agregarDescuento(getScenarioVar(Constants.DESCUENTO));

				String precioTotal = new PrecioPorModalidadPage(userS).getPrecioTotal();

				new PrecioPorModalidadPage(userS)
					.clickGuardar();

				String numSimulacion = new PrecioPorModalidadPage(userS).getNumeroSimulacion();

				datosAltoValor = setValuesDataSetByID(datosAltoValor, "prima_total", i, precioTotal);
				datosAltoValor = setValuesDataSetByID(datosAltoValor, "anyo_antiguedad", i, anyoConstruccion);
				datosAltoValor = setValuesDataSetByID(datosAltoValor, "numero_proyecto", i, numSimulacion);

				appendMatrixToCsvFile(fileName + " (modificado).csv", datosAltoValor);

				new PrecioPorModalidadPage(userS)
					.clickCancelar();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas");

				userS.getWebDriver().exitFrame();

				new InnovaHomePage(userS)
					.openInnovaHome()
					.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void modifico_proyecto_iterando_cambio_mediador() {
		debugBegin();

		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(fileName + ".csv", false);

		new InnovaHomePage(userS)
			.openGestionCotizaciones();

		for(int i = 1; i < datosAltoValor.length; i++) {
			String cotizacion = getValuesDataSetByID(datosAltoValor, "numero_proyecto", i);

			if(cotizacion == null || cotizacion.isEmpty())
				continue;

			new GestionCotizacionesBuscadorPage(userS)
				.searchCotizacion(cotizacion)
				.modificarProjecto();

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			new UbicacionRiesgoPage(userS)
				.clickOnGuardar()
				.closeAvisoSistemaPopup();

			new InnovaHomePage(userS)
				.openInnovaHome()
				.openGestionCotizaciones();
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero() {
		debugBegin();

		String logText = "", address = "";

		setScenarioVar(Constants.INMUEBLE, "direccion por defecto");
		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMutuaEdificioConfort();

		String[][] datosCargaMEC = FileUtils.csvFileToMatrix(fileName + ".csv", false);
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "capital_continente");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "total_asegurado");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "capital_contenido");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precios_antes_proyecto");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precios_despues_proyecto");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precio_basic");
		datosCargaMEC = ArrayUtils.addColumnToMatrix(datosCargaMEC, "precio_plus");

		for(int i = 1; i < datosCargaMEC.length; i++) {
			new InnovaHomePage(userS)
				.openNewSimulationMec();

			address = getValuesDataSetByID(datosCargaMEC, "provincia", i) + ", " + getValuesDataSetByID(datosCargaMEC, "poblacion", i) + ", "
				+ getValuesDataSetByID(datosCargaMEC, "direccion", i) + ", " + getValuesDataSetByID(datosCargaMEC, "numero", i);

			setScenarioVar(Constants.PROVINCIA, getValuesDataSetByID(datosCargaMEC, "provincia", i));
			setScenarioVar(Constants.POBLACION, getValuesDataSetByID(datosCargaMEC, "poblacion", i));
			setScenarioVar(Constants.NOMBRE_VIA, getValuesDataSetByID(datosCargaMEC, "direccion", i));
			setScenarioVar(Constants.NUM_VIA, getValuesDataSetByID(datosCargaMEC, "numero", i));

			String codigoPostal = getValuesDataSetByID(datosCargaMEC, "codigo_postal", i);
			setScenarioVar(Constants.CODIGO_POSTAL, codigoPostal != null && codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);

			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickContinuar();
			try {
				if(!new UbicacionRiesgoPage(userS).fillInmuebleAndGetAvailability()) {
					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
					debugInfo("Mas de una referencia catastral encontrada");
					userS.getWebDriver().exitFrame();

					new InnovaHomePage(userS)
						.openInnovaHome()
						.openMutuaEdificioConfort();

					writeFile(fileName + " (log file).txt", logText);

					continue;
				}

				new UbicacionRiesgoPage(userS)
					.closeNotification();
				new UbicacionRiesgoPage(userS)
					.clickContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
					.isUbicacionRiesgoUtilizada();

				new DetallesRiesgoPage(userS)
					.completarDatosRiesgoMinimos();

				String capitalContinente = new DetallesRiesgoPage(userS).getCapitalContinente();
				String totalAsegurado = new DetallesRiesgoPage(userS).getCapitalContinenteTotalAsegurado();
				String capitalContenido = new DetallesRiesgoPage(userS).getCapitalContenido();

				new DetallesRiesgoPage(userS)
					.clickContinuar();

				String precioComplet = new PrecioPorModalidadPage(userS).getPrecioTotal();
				String precioBasic = new PrecioPorModalidadPage(userS).getPrecioBasic();
				String precioPlus = new PrecioPorModalidadPage(userS).getPrecioPlus();

				new PrecioPorModalidadPage(userS)
					.clickGuardar();

				// TODO Convertir a proyecto seguir los pasos Terminar de crear la poliza
				// escribir los datos: numeroProyecto, precios antes de proyecto, precios despues de proyecto

				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_continente", i, capitalContinente);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "total_asegurado", i, totalAsegurado);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_contenido", i, capitalContenido);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "prima_total", i, precioComplet);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_basic", i, precioBasic);
				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_plus", i, precioPlus);
				// datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "numero_proyecto", i, numSimulacion);

				writeMatrixToCsvFile(fileName + " - " + getConfigVar(Constants.ENTORNO) + " (resultados).csv", datosCargaMEC);

				new InnovaHomePage(userS)
					.openInnovaHome()
					.openMutuaEdificioConfort();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas\n\t- " + e.toString());

				userS.getWebDriver().exitFrame();

				new InnovaHomePage(userS)
					.openInnovaHome()
					.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void se_dan_de_alta_masivamente_proyectos_MEC_donde_la_antiguedad_del_edificio_es_mayor_que_50_anyos() {
		debugBegin();

		String logText = "";

		String fileName = getScenarioVar(Constants.FICHERO);
		debugInfo("Filename: " + fileName);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMutuaEdificioConfort();

		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int i = 1; i < datosAltoValor.length; i++) {
			new InnovaHomePage(userS)
				.createNewProject();

			setScenarioVar(Constants.REFERENCIA_CATASTRAL, getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

			new AsignarMediadorPage(userS)
				.selectMediadorAndClickContinuar();

			try {
				new UbicacionRiesgoPage(userS)
					.fillInmuebleAndClickContinuar();
				// ubicacionRiesgoPage.closeNotification();
				// ubicacionRiesgoPage.clickOnContinuar();

				new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

				new DetallesRiesgoPage(userS)
					.completarDatosRiesgoMinimos(); // Enter values madera and deshabitación.

				new DetallesRiesgoPage(userS).enterAnyoConstruccionMoreThan50()
					.clickContinuar();

				new ValidacionExcepcionesReglasPage(userS)
					.clickContinuar();

				new DatosBasicosTomadorPage(userS)
					.fillStaticTomadorData()
					.clickContinuar();

				new PrecioPorModalidadPage(userS)
					.clickContinuar();

				new ValidacionExcepcionesReglasPage(userS)
					.clickContinuar();

				new ClausulasPage(userS)
					.clickContinuar();

				new TomadorYAseguradoPage(userS)
					.addStaticDatosTomador()
					// tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
					.clickContinuar();

				new DatosBancariosPage(userS)
					.fillStaticIban();
				new DatosBancariosPage(userS)
					.clickGuardar()
					.getProjectCodeNumberAndClickOnAceptarButton()
					.aceptarCondicionesLegales()
					.clickSolicitarPeritacion()
					.enterDataSolicitudServicioTecnico();
				// new DataSteps(userS).imprimir_informacion_del_proyecto();
				// userS.getWebDriver().quit();

				Iterable<String> PeritajeIterator = Splitter.on(' ').split(new DatosBancariosPage(userS).getMensajePeritaje());
				String[] PeritajeList = Iterables.toArray(PeritajeIterator, String.class);

				logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
					+ " (Proyecto: " + getTestVar(Constants.NUMERO_PROYECTO) + ", " + "Referencia solicitud: " + PeritajeList[7] + ")" + "\n";
				writeFile(fileName + " (log file).txt", logText);

				debugInfo("Solicitud verificación OK.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + " (Proyecto: "
					+ getTestVar(Constants.NUMERO_PROYECTO) + ", " + "Referencia solicitud: " + PeritajeList[7] + ")" + "\n");

				new InnovaHomePage(userS)
					.openInnovaHome()
					.openMutuaEdificioConfort();
			} catch(Exception e) {
				logText += "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
					+ "\n";
				writeFile(fileName + " (log file).txt", logText);
				debugInfo("Comprobaciones de datos no contempladas");
				debugInfo("Solicitud verificación KO.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

				userS.getWebDriver().exitFrame();

				new InnovaHomePage(userS)
					.openInnovaHome()
					.openMutuaEdificioConfort();
			}
		}

		userS.getWebDriver().quit();

		debugEnd();
	}

	public void busco_un_cliente_por_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new ClientePage(userS)
			.accederAlBuscadorClientes()
			.buscarConFiltroBusqueda();
	}

	public void doy_alta_nuevo_tomador_usando_el_acceso_y_el_usuario(String loginAcess, String user) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new ClientePage(userS)
			.accederAlBuscadorClientes()
			.clickNuevoTomadorSecond();
	}

	public void doy_de_alta_prospect_usando_acceso_y_usuario_iterando_fichero(String loginAcess, String user) {
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

				new InnovaHomePage(userS)
					.openMediadores();

				new MediadoresHomePage(userS)
					.openAltaProspect();

				new MediadoresAltaProspectPage(userS)
					.executeActionsAltaProspectPage();
			} catch(Exception e) {}
		}
	}

	public void doy_de_alta_prospect_usando_acceso_y_usuario(String loginAcess, String user) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMediadores();

		new MediadoresHomePage(userS)
			.openAltaProspect();

		new MediadoresAltaProspectPage(userS)
			.executeActionsAltaProspectPage();
	}

	public void doy_de_alta_mediador_usando_acceso_y_usuario(String loginAcess, String user) {
		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMediadores();

		new MediadoresHomePage(userS)
			.openAltaMediador();

		new MediadoresAltaMediadorPage(userS)
			.executeActionsAltaMediadorPage();
	}

	public void comunico_siniestro() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));

		new GestionSiniestrosPage(userS)
			.goToComunicacion();

		new ComunicacionSiniestrosPage(userS)
			.nuevaComunicacion();

	}

	public void compruebo_comunicacion_siniestro() {
		new GestionSiniestrosPage(userS)
			.goToDiario();

		new DiarioSiniestrosPage(userS)
			.comprobarComunicacion();
	}

	public void anyado_anotacion_siniestro() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));

		new GestionSiniestrosPage(userS)
			.goToDiario();

		new ComunicacionSiniestrosPage(userS)
			.nuevaAnotacion();
	}

	public void compruebo_anotacion_siniestro() {
		new GestionSiniestrosPage(userS)
			.goToDiario();

		new DiarioSiniestrosPage(userS)
			.comprobarAnotacion();
	}

	public void busco_siniestro() {
		// TODO Rellenar
		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
	}

	public void se_dan_de_alta_masivamente_proyectos_MEC_empleando_distintos_mediadores() throws Exception {
		debugBegin();

		debugInfo("Cargando referencias...\n");
		String logText = "";
		String fileName = getScenarioVar(Constants.FICHERO);
		fileName = fileName.substring(0, fileName.length() - 4);
		debugInfo("Filename: " + fileName);

		debugInfo("Cargando mediadores...\n");
		String fileNameB = getScenarioVar("ficheroMedCoa");
		debugInfo("Filename: " + fileNameB);
		fileNameB = fileNameB.substring(0, fileNameB.length() - 4);
		debugInfo("Filename: " + fileNameB);

		login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		new InnovaHomePage(userS)
			.openMutuaEdificioConfort();

		String[][] datosAltoValorMedCoa = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileNameB + ".csv", false);
		String[][] datosAltoValor = FileUtils.csvFileToMatrix(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + fileName + ".csv", false);

		for(int j = 1; j < datosAltoValorMedCoa.length; j++) {
			for(int i = 1; i < datosAltoValor.length; i++) {
				new InnovaHomePage(userS)
					.createNewProject();

				setScenarioVar(Constants.REFERENCIA_CATASTRAL, getValuesDataSetByID(datosAltoValor, Constants.REFERENCIA_CATASTRAL, i));

				new AsignarMediadorPage(userS)
					.selectMediadorAndClickContinuar(getValuesDataSetByID(datosAltoValorMedCoa, "Codigo_Coaseguro", j));

				try {
					new UbicacionRiesgoPage(userS)
						.fillInmuebleAndClickContinuar();
					// ubicacionRiesgoPage.closeNotification();
					// ubicacionRiesgoPage.clickContinuar();

					new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
						.isUbicacionRiesgoUtilizada();

					new DetallesRiesgoPage(userS)
						.completarDatosRiesgoMinimos(); // Enter values madera and deshabitación.
					// .enterAnyoConstruccionMoreThan50();
					new DetallesRiesgoPage(userS)
						.clickContinuar();

					new ValidacionExcepcionesReglasPage(userS)
						.clickContinuar();
					new DatosBasicosTomadorPage(userS)
						.fillStaticTomadorData()
						.clickContinuar();

					new PrecioPorModalidadPage(userS)
						.clickContinuar();
					// ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
					// ValidacionExcepcionesReglasPage(userS);
					new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
						.clickContinuar();

					new ClausulasPage(userS)
						.clickContinuar();

					new TomadorYAseguradoPage(userS)
						.addStaticDatosTomador()
						// tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
						.clickContinuar();

					// datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion();
					// new DataSteps(userS).imprimir_informacion_del_proyecto();
					// userS.getWebDriver().quit();

					// Iterable<String> PeritajeIterator = Splitter.on('
					// ').split(datosBancariosPage.getMensajePeritaje());
					// String[] PeritajeList = Iterables.toArray(PeritajeIterator, String.class);

					logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
						+ " (Proyecto: " + getTestVar(Constants.NUMERO_PROYECTO) + ")" + "\n";
					writeFile(fileName + " (log file).txt", logText);

					debugInfo("Solicitud verificación OK.  Ref. catastral: "
						+ getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + " (Proyecto: " + getTestVar(Constants.NUMERO_PROYECTO) + ")" + "\n");

					new InnovaHomePage(userS)
						.openInnovaHome()
						.openMutuaEdificioConfort();
				} catch(Exception e) {
					logText += "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
						+ "\n";
					writeFile(fileName + " (log file).txt", logText);
					debugInfo("Comprobaciones de datos no contempladas");
					debugInfo("Solicitud verificación KO.  Ref. catastral: " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i));

					userS.getWebDriver().exitFrame();

					new InnovaHomePage(userS)
						.openInnovaHome()
						.openMutuaEdificioConfort();
				}
			}
		}

		userS.getWebDriver().quit();

		debugBegin();
	}

	// Alta Siniestro simple y por csv
	public void alta_siniestro_simple() {
		debugBegin();
		String ramo = "";

		if(getTestVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS)
				.openSiniestros();

			new HomeSiniestrosPage(userS)
				.openAperturaAlta();

			debugInfo("Numero poliza: " + getTestVar(Constants.NUM_POLIZA));
			if(getTestVar(Constants.NUM_POLIZA) == null || getTestVar(Constants.NUM_POLIZA).isEmpty()) {
				// De no haber póliza se tomará una al azar de las últimas 50
				new AltaAperturaSiniestrosPage(userS)
					.buscar50Polizas()
					.continuarRandomPoliza();
			} else {
				// Buscamos una póliza por Nº póliza
				if(getTestVar(Constants.NUM_POLIZA).startsWith("510")) {
					ramo = "510";
				} else if(getTestVar(Constants.NUM_POLIZA).startsWith("920") || getTestVar(Constants.NUM_POLIZA).startsWith("900")) {
					ramo = "920";
				} else if(getTestVar(Constants.NUM_POLIZA).startsWith("660")) {
					ramo = "660";
				} else if(getTestVar(Constants.NUM_POLIZA).startsWith("400") || getTestVar(Constants.NUM_POLIZA).startsWith("200")
					|| getTestVar(Constants.NUM_POLIZA).startsWith("150")
					|| (getTestVar(Constants.NUM_POLIZA).startsWith("500") && !getTestVar(Constants.NUM_POLIZA).startsWith("5000"))) {
					ramo = "500";
				} else if(getTestVar(Constants.NUM_POLIZA).startsWith("5000") || getTestVar(Constants.NUM_POLIZA).startsWith("600")
					|| getTestVar(Constants.NUM_POLIZA).startsWith("610") || getTestVar(Constants.NUM_POLIZA).startsWith("620")
					|| getTestVar(Constants.NUM_POLIZA).startsWith("630") || getTestVar(Constants.NUM_POLIZA).startsWith("640")) {
					ramo = "640";
				}

				new AltaAperturaSiniestrosPage(userS)
					.buscarPorNumPoliza(ramo, getTestVar(Constants.NUM_POLIZA))
					.continuarPrimeraPoliza();
			}

			// 1.Declaración
			new AltaAperturaDeclaracionSiniestrosPage(userS)
				.altaDatosDeclaracion(getTestVar(Constants.FECHA_OCURRENCIA), getTestVar(Constants.TIPO_DECLARANTE), getTestVar(Constants.MEDIO_DECLARACION), getTestVar(Constants.FECHA_DENUNCIA), getTestVar(Constants.DECLARACION_OBSERVACIONES))
				.altaDatosDeclarante(getTestVar(Constants.DECLARACION_NOMBRE), getTestVar(Constants.DECLARACION_PRIM_APELLIDO), getTestVar(Constants.DECLARACION_SEG_APELLIDO), getTestVar(Constants.DECLARACION_PREFIJO), getTestVar(Constants.DECLARACION_TELEFONO), getTestVar(Constants.DECLARACION_EMAIL), getTestVar(Constants.DECLARACION_EMAIL_NO_DISP))
				// Añadimos datos de persona extra
				.datosPersonaExtra(getTestVar(Constants.CONTACTO_ROL), getTestVar(Constants.CONTACTO_NOMBRE), getTestVar(Constants.CONTACTO_PRIM_APELLIDO), getTestVar(Constants.CONTACTO_SEG_APELLIDO), getTestVar(Constants.CONTACTO_TIPO_DOCUMENTO), getTestVar(Constants.CONTACTO_N_DOCUMENTO), getTestVar(Constants.CONTACTO_PREFIJO_TEL_UNO), getTestVar(Constants.CONTACTO_TELEFONO_UNO), getTestVar(Constants.CONTACTO_PREFIJO_TEL_DOS), getTestVar(Constants.CONTACTO_TELEFONO_DOS), getTestVar(Constants.CONTACTO_SEXO), getTestVar(Constants.CONTACTO_EMAIL_NO_DISP), getTestVar(Constants.CONTACTO_EMAIL), getTestVar(Constants.CONTACTO_VIVE_EN_RIESGO), getTestVar(Constants.CONTACTO_DIR_TIPO_VIA), getTestVar(Constants.CONTACTO_DIR_CALLE), getTestVar(Constants.CONTACTO_DIR_NUMERO), getTestVar(Constants.CONTACTO_DIR_PISO), getTestVar(Constants.CONTACTO_DIR_PUERTA), getTestVar(Constants.CONTACTO_DIR_CP), getTestVar(Constants.CONTACTO_DIR_POBLACION), getTestVar(Constants.CONTACTO_DIR_PROVINCIA));

			// Comprobamos si necesita asistencia
			if(getTestVar(Constants.ASISTENCIA) == null || getTestVar(Constants.ASISTENCIA).isEmpty()) {
				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.altaSinAsistencia()
					.clickContinuar();
			} else if(!getTestVar(Constants.ASISTENCIA).isEmpty()) {
				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.altaConAsistencia(getTestVar(Constants.ASISTENCIA), getTestVar(Constants.ASISTENCIA_URGENTE), getTestVar(Constants.ASISTENCIA_DANYOS_UBICADOS), getTestVar(Constants.ASISTENCIA_ORIGEN_DANYOS_REPARADOS), getTestVar(Constants.ASISTENCIA_DANYOS_A_CONSECUENCIA), getTestVar(Constants.ASISTENCIA_REF_EXTERNA))
					.clickContinuar();
			} else if(new AltaAperturaDeclaracionSiniestrosPage(userS).posibilidadAsistencia()) {
				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.altaSinAsistencia()
					.clickContinuar();
			}

			if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
				new ValidacionExcepcionesReglasPage(userS)
					.clickContinuar();
			}
			debugInfo("Hasta aquí llegamos : post-reglas de validación");
			// 2.Ocurrencia
			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.altaRiesgoAsegurado();

			/*
			 * SIN uso en NINGUNA PARTE String gCausa = ""; String tCausa = ""; String gremio = "";
			 *
			 * if(ramo == "510" || ramo == "500") { gCausa = "GC02"; tCausa = "TC002000"; gremio = "1"; } else if(ramo
			 * == "920") { gCausa = "GC25"; tCausa = "TC025000"; gremio = "1"; } else if(ramo == "640") { gCausa =
			 * "GC51"; tCausa = "TC002000"; gremio = "1"; } else if(ramo == "660") { gCausa = "GC32"; tCausa =
			 * "TC002000"; gremio = "1"; }
			 */
			debugInfo("Hay encargo?: " + getTestVar(Constants.ENCARGO));
			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.altaSeleccionarCausas(getTestVar(Constants.GRUPO_CAUSA_COD), getTestVar(Constants.TIPO_CAUSA_COD), getTestVar(Constants.GREMIO_CAUSA_COD))
				// datosOcurrencia.altaSeleccionarCausas(getTestVar(Constants.GRUPO_CAUSA_COD),
				// getTestVar(Constants.TIPO_CAUSA_COD), gremio);
				.altaRellenarDatos("Descripción test para realizar un alta de siniestro", getTestVar(Constants.OTROS_IMPLICADOS), getTestVar(Constants.ENCARGO));

			debugInfo("Alta rellenar datos causa");
			userS.getWebDriver().waitWithDriver(10000);

			// Si el csv contempla la opción de guardar en medio del alta
			if(getTestVar(Constants.GUARDAR_EN_ALTA) != null && !getTestVar(Constants.GUARDAR_EN_ALTA).isEmpty()) {
				debugInfo("Seleccionada opción de guardado, se procede a guardar el siniestros provisional");
				new AltaAperturaOcurrenciaSiniestrosPage(userS)
					.clickGuardarSalir();

				new GestionSiniestrosPage(userS)
					.clickLogo();

				new InnovaHomePage(userS)
					.openSiniestros();

				new GestionBuscadorSiniestrosPage(userS)
					.buscarPorNumeroSiniestro(getTestVar(Constants.SINIESTRO_PROVISIONAL), getTestVar(Constants.ANYO_SINIESTRO));

				new VistaSiniestrosPage(userS)
					.modificarAltaSiniestro();

				new AltaAperturaDeclaracionSiniestrosPage(userS)
					.clickContinuar();

				if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
					new ValidacionExcepcionesReglasPage(userS)
						.clickContinuar();
				}

			}

			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.clickContinuar();

			// Validamos más cosas
			if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
				userS.getWebDriver().waitWithDriver(10000);

				new ValidacionExcepcionesReglasPage(userS)
					.clickContinuar();
			}

			// Completamos el apartado de Implicado asegurado
			debugInfo("Implicado Asegurado, Numero poliza: " + getTestVar(Constants.NUM_POLIZA));
			// if(!getTestVar(Constants.NUM_POLIZA).startsWith("920")) {
			userS.getWebDriver().waitWithDriver(10000);

			new ImplicadoAseguradoSiniestrosPage(userS)
				.seleccionarImplicado()
				.clickApertura();
			// }

			// Comprobamos si se requiere añadir un implicado extra
			if(getTestVar(Constants.OTROS_IMPLICADOS) != null && !getTestVar(Constants.OTROS_IMPLICADOS).isEmpty()) {
				debugInfo("Comprobamos si se requiere añadir un implicado extra");
				new OtrosImplicadosAltaSiniestrosPage(userS)
					.clickNuevoImplicado();
				new OtrosImplicadosDatosSiniestrosPage(userS)
					// otroImplicadoDatos.introducirDatosPersonales("LESI", "NORIE", "Implicado", "Exra", "Segundo",
					// "NIF",
					// "77315592B", "666885985", "", "", "implicadoextra@mail.com");
					.introducirDatosPersonales(getTestVar(Constants.OTRO_ROL), getTestVar(Constants.OTRO_NOMBRE), getTestVar(Constants.OTRO_PRIM_APELLIDO), Constants.OTRO_SEG_APELLIDO, getTestVar(Constants.OTRO_TIPO_DOCUMENTO), getTestVar(Constants.OTRO_N_DOCUMENTO), getTestVar(Constants.OTRO_TELEFONO_UNO), getTestVar(Constants.OTRO_TELEFONO_DOS), getTestVar(Constants.OTRO_SEXO), getTestVar(Constants.OTRO_EMAIL))
					.introducirDatosDireccion("", "", "", "", "", "", "", "", "ES21", "2100", "0001", "05", "0000000001")
					.clickGrabar();

				new OtrosImplicadosAltaSiniestrosPage(userS)
					.clickContinuar();
			}

			// Comprobamos si se requiere añadir un encargo
			if(getTestVar(Constants.ENCARGO) != null && !getTestVar(Constants.ENCARGO).isEmpty()) {
				debugInfo("Comprobamos si se requiere encargo");
				new EncargoAltaSiniestrosPage(userS)
					.clickNuevoEncargo();

				new EncargoDatosSiniestrosPage(userS)
					.seleccionarTipoEncargo("PGRA", "PERIGRAL", "PERITACI")
					.seleccionarDatosEncargo(new Date(), "")
					.clickGrabar();

				new EncargoAltaSiniestrosPage(userS)
					.clickContinuar();
			}

			// Página de confirmación
			debugInfo("Confirmamos Siniestro");
			new ConfirmacionSiniestrosPage(userS)
				.confirmarSiniestroOK();

			// Si el siniestro es de tipo MAC tenemos que modificar el siniestro para asignar una causa válida para
			// emitir un pago

			if(getTestVar(Constants.NUM_POLIZA) != null && getTestVar(Constants.NUM_POLIZA).startsWith("920")
				&& getTestVar(Constants.TIPO_CAUSA_COD) != null && getTestVar(Constants.TIPO_CAUSA_COD).equalsIgnoreCase("TC025000")) {
				debugInfo("La póliza a la cual pertenece el siniestro es de tipo MAC, procedemos a modificar las causas para poder realizar pagos");
				new ConfirmacionSiniestrosPage(userS)
					.volverAHomeMutua();
					modifico_causas_siniestro_MAC();
			}

			// Accedemos a siniestros desde Gestión On Line
		} else if(getTestVar(Constants.ACCESO) != null && getTestVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			// Seleccionamos la opcion alta siniestros
			new GestionOnlineHomePage(userS)
				.seleccionaIdiomaCast()
				.altaSiniestros();

			// Damos de alta el siniestro
			new GestionOnlineAltaSiniestrosPage(userS)
				.altaInfoPoliza(getTestVar(Constants.NUM_POLIZA), "");

			if(getTestVar(Constants.NUM_POLIZA).startsWith("510")) {
				ramo = "510";
			} else if(getTestVar(Constants.NUM_POLIZA).startsWith("920") || getTestVar(Constants.NUM_POLIZA).startsWith("900")) {
				ramo = "920";
			} else if(getTestVar(Constants.NUM_POLIZA).startsWith("660")) {
				ramo = "660";
			} else if(getTestVar(Constants.NUM_POLIZA).startsWith("400") || getTestVar(Constants.NUM_POLIZA).startsWith("200")
				|| getTestVar(Constants.NUM_POLIZA).startsWith("150")
				|| (getTestVar(Constants.NUM_POLIZA).startsWith("500") && !getTestVar(Constants.NUM_POLIZA).startsWith("5000"))) {
				ramo = "500";
			} else if(getTestVar(Constants.NUM_POLIZA).startsWith("5000") || getTestVar(Constants.NUM_POLIZA).startsWith("600")
				|| getTestVar(Constants.NUM_POLIZA).startsWith("610")
				|| getTestVar(Constants.NUM_POLIZA).startsWith("620") || getTestVar(Constants.NUM_POLIZA).startsWith("630")
				|| getTestVar(Constants.NUM_POLIZA).startsWith("640")) {
				ramo = "640";
			}

			String causa = getTestVar(Constants.CAUSA_SINIESTRO);

			new GestionOnlineAltaSiniestrosPage(userS)
				.altaCausaDescripcion(causa, "Descripción para la apertura del sinestro de prueba automática", "")
				.altaCuentaSiniestro()
				.altaPersonaContacto("INQVE__11", "Jose", "Martinez", "Perez", "666502101", "mail@mail.com")
				.altaDireccionContacto(true, "", "", "", "", "", "", "", "")
				.altaObservaciones("TEST Automatico apertura siniestro")
				.clickEnviar()
				.checkYaExisteSiniestro()
				.comprobarOk();

			new ConfirmacionSiniestrosPage(userS)
				.confirmarSiniestroOK();
		}

		debugEnd();
	}

	public void tramito_siniestro_tras_alta() {
		debugBegin();

		new ConfirmacionSiniestrosPage(userS)
			.tramitarSiniestro();

		debugEnd();
	}

	public void compruebo_que_datos_han_viajado() {
		debugBegin();

		new GestionSiniestrosPage(userS)
			.mostrarInfoGeneral();

		new HomeSiniestrosPage(userS)
			.compararCampos();

		debugEnd();
	}

	public void comprobar_que_no_tenga_pagos_pendientes_ni_encargos() {
		debugBegin();

		// TODO fill

		debugEnd();
	}

	public void cierre_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		// buscadorSiniestro.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		boolean pagos = new PagosSiniestrosPage(userS).comprobarPagosPendientes();
		boolean encargos = new GestionCarpetaSiniestrosPage(userS).comprobarEncargos();
		boolean tareas = new AgendaSiniestrosPage(userS).comprobarTareasPendientes();

		debugInfo("Pago bool: " + pagos);
		debugInfo("Encargos bool: " + encargos);
		debugInfo("Tareas bool: " + tareas);

		new GestionSiniestrosPage(userS)
			.goToVista();

		new VistaSiniestrosPage(userS)
			.cierreSiniestro(pagos, encargos, tareas);

		// webDriver.waitWithDriver(2000);
		debugEnd();
	}

	public void comprobacion_cierre_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.comprobarSiniestroCerrado();

		debugEnd();
	}

	public void reapertura_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();
		// buscadorSiniestro.buscarPorNumeroPoliza("04067199", "2019","MEC");
		// buscadorSiniestro.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionCarpetaSiniestrosPage(userS)
			.nuevaCarpeta();

		debugEnd();
	}

	public void comprobacion_reapertura_siniestro() {
		debugBegin();

		// TODO Rellenar

		debugEnd();
	}

	public void realizo_pago_simple() {
		debugBegin();

		// En la pagina principal se busca la opcion siniestro
		new InnovaHomePage(userS)
			.openSiniestros();

		// Dentro de siniestros se busca la opcion gestion siniestro
		new GestionBuscadorSiniestrosPage(userS)
			.abrirGestionSiniestro();

		// Una vez dentro, se selecciona la opcion buscar por otros
		// gestionSiniestrosBuscador.buscarPorOtros("1/08/2019","15/09/2019","640","510");
		// gestionSiniestrosBuscador.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new PagosSiniestrosPage(userS)
			.nuevoPago();

		debugInfo("La carpeta está: " + getTestVar(Constants.ESTADO_CARPETA));
		debugInfo("El estado carpeta es: " + Constants.ESTADO_CARPETA_ABIERTA);

		if(getTestVar(Constants.ESTADO_CARPETA).equalsIgnoreCase(Constants.ESTADO_CARPETA_ABIERTA)) {
			if(getTestVar(Constants.NUM_POLIZA) != null && getTestVar(Constants.NUM_POLIZA).startsWith("510")) {
				new PagosSiniestrosPage(userS)
					.seleccionarTipoDePerceptor();
			} else {
				new PagosSiniestrosPage(userS)
					.seleccionarParticipantesExpediente();
			}

			new PagosSiniestrosPage(userS)
				.datosPerceptor()
				.importes("", "100,00", false)
				.verificacion();
		}

		debugEnd();
	}

	public void realizo_plan_pagos_MAC() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		// Comentados hasta que se resuelva el pago a carpeta
		new BloqueSiniestrosPage(userS)
			.iniciarPagoACarpeta();

		// Seleccion del siniestro a pagar
		new PagosSiniestrosPage(userS)
			.seleccionarParticipantesExpediente()
			.datosPerceptor()
			.importes("", "1000,00", true)
			.verificacion()
			.emitirPlanPagosMAC("", "", "120")
			.verificacion()
			.comprobarPlanPagosMac();

		debugInfo("test completado con éxito");
		debugEnd();
	}

	public void rehuso_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), (getTestVar(Constants.ANYO_SINIESTRO)));

		new DiarioSiniestrosPage(userS)
			.rehusarSiniestro();

		debugEnd();
	}

	public void reconsidero_siniestro_rehusado() {
		// TODO buscar siniestro (rehusado)
		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		// generar pago

		realizo_pago_simple();

		desbloqueo_pago();

		// completar flujo de pago

		gestionar_pago();

		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.goToDiario();

		// comprobar si estadop reconsiderado
		Assert.assertTrue(new DiarioSiniestrosPage(userS).comprobar_siniestro_reconsiderado());
	}

	public void transicionar_bloques() {
		debugBegin();
		new InnovaHomePage(userS).openSiniestros();
		new GestionBuscadorSiniestrosPage(userS).buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new BloqueSiniestrosPage(userS).transicionarBloqueCerrandoOrigen();
		debugEnd();
	}

	public void nueva_tarea_siniestros() {

		new InnovaHomePage(userS).openSiniestros();
		new GestionBuscadorSiniestrosPage(userS).buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new AgendaSiniestrosPage(userS).nuevaTarea();
		new AgendaSiniestrosPage(userS).comprobarTareasPendientes();
		new GestionSiniestrosPage(userS).clickLogo();
	}
	
	
	public void modifico_tarea_siniestros() {

		new InnovaHomePage(userS).openSiniestros();
		new GestionBuscadorSiniestrosPage(userS).buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		new AgendaSiniestrosPage(userS).detallesTarea(getTestVar(Constants.TAREA_TITULO));
		new AgendaSiniestrosPage(userS).comprobarTareasPendientes();
		new GestionSiniestrosPage(userS).clickLogo();
	}

	public void cierro_tarea_siniestros() {

		new InnovaHomePage(userS).openSiniestros();
		new GestionBuscadorSiniestrosPage(userS).buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));
		//new AgendaSiniestrosPage(userS).
		new AgendaSiniestrosPage(userS).comprobarTareaCerrada();
		new GestionSiniestrosPage(userS).clickLogo();
	}


	public void modificar_siniestro_datos() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.FECHA_SINIESTRO), getTestVar(Constants.TIPO_POLIZA));

		new VistaSiniestrosPage(userS)
			.modificarSiniestro();

		new AltaAperturaDeclaracionSiniestrosPage(userS)
			.modificarDatosSiniestro(getTestVar(Constants.DECLARACION_NOMBRE), getTestVar(Constants.DECLARACION_PRIM_APELLIDO), getTestVar(Constants.DECLARACION_SEG_APELLIDO), 
				getTestVar(Constants.DECLARACION_TELEFONO), getTestVar(Constants.DECLARACION_EMAIL));

		new ValidacionExcepcionesReglasPage(userS)
			.comprobarPaginaModificacion();

		new AltaAperturaOcurrenciaSiniestrosPage(userS)
			.modificarDescripcion(getTestVar(Constants.DESCRIPCION_SINIESTRO) + StringUtils.getRandomLetterChain(4));

		new ValidacionExcepcionesReglasPage(userS)
			.comprobarPaginaModificacion();

		new ModificarValidacionSiniestrosPage(userS)
			.validar();

		new ConfirmacionSiniestrosPage(userS)
			.confirmaModificacion();

		new VistaSiniestrosPage(userS)
			.irVistaSiniestroHistorico()
			.mapeoHistoricoModificarDatos(getTestVar(Constants.DECLARACION_NOMBRE), getTestVar(Constants.DECLARACION_PRIM_APELLIDO), getTestVar(Constants.DECLARACION_SEG_APELLIDO), 
				getTestVar(Constants.DECLARACION_TELEFONO), getTestVar(Constants.DECLARACION_EMAIL), getTestVar(Constants.DESCRIPCION_SINIESTRO));
	}

	public void modificar_siniestro_causa() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new VistaSiniestrosPage(userS)
			.modificarSiniestro();

		new AltaAperturaDeclaracionSiniestrosPage(userS)
			.continuarSinAcciones();

		new ValidacionExcepcionesReglasPage(userS)
			.comprobarPaginaModificacion();

		new AltaAperturaOcurrenciaSiniestrosPage(userS)
			.modificarCausa(getTestVar(Constants.GRUPO_CAUSA_COD), getTestVar(Constants.TIPO_CAUSA_COD));

		new ValidacionExcepcionesReglasPage(userS)
			.comprobarPaginaModificacion();

		new ModificarValidacionSiniestrosPage(userS)
			.validar();

		new ConfirmacionSiniestrosPage(userS)
			.confirmaModificacion();

		new GestionSiniestrosPage(userS)
			.comprobarCausa(getTestVar(Constants.TIPO_CAUSA));
	}

	public void cerrar_carpeta() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA));

		new GestionCarpetaSiniestrosPage(userS)
			.cerrarCarpeta();
	}

	public void realizo_recobro() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO)); // TIPO_POLIZA

		new GestionSiniestrosPage(userS)
			.reservasYExpecativas()
			.modificarReserva()
			.modificarExpectativa()
			.verificarTotales()
			.modificarExpectativasACero()
			.modificarReservaACero()
			.verificarTotales();
	}

	public void reservas_expectativas_0() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.TIPO_POLIZA));

		new GestionSiniestrosPage(userS)
			.reservasYExpecativas()
			.modificarExpectativasACero()
			.modificarReservaACero()
			.verificarTotales();
	}

	public void compruebo_carpeta_y_encargos() {
		new GestionSiniestrosPage(userS)
			.goToGestionDeCarpetas();

		if(new GestionCarpetaSiniestrosPage(userS).comprobarTipoCarpeta()) {
			debugInfo("ATENCIÓN	tipo carpeta IMAS.");
		}

		if(new GestionCarpetaSiniestrosPage(userS).comprobarEncargos()) {
			debugInfo("Encargos : Sí, hay encargos.");
		}
	}

	public void modifico_causas_siniestro_MAC() {
		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.goToVista();

		new VistaSiniestrosPage(userS)
			.modificarSiniestro();

		// 1.Declaración
		new AltaAperturaDeclaracionSiniestrosPage(userS)
			.clickContinuar();

		if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();
		}

		// 2.Ocurrencia
		new AltaAperturaOcurrenciaSiniestrosPage(userS)
			.modificarCausasEspecificasMAC()
			.clickContinuar();

		if(new ValidacionExcepcionesReglasPage(userS).comprobarNombrePagina().contains("excepciones")) {
			userS.getWebDriver().waitWithDriver(10000);

			new ValidacionExcepcionesReglasPage(userS)
				.clickContinuar();
		}

		// Aceptamos el apartado de Implicado asegurado
		new ImplicadoAseguradoSiniestrosPage(userS)
			.clickApertura();

		// Si hay un implicado extra, continuamos
		if(getTestVar(Constants.OTROS_IMPLICADOS) != null && !getTestVar(Constants.OTROS_IMPLICADOS).isEmpty()) {
			new OtrosImplicadosAltaSiniestrosPage(userS)
				.clickContinuar();
		}

		// Si hay encargo, aceptamos
		if(getTestVar(Constants.ENCARGO) != null && !getTestVar(Constants.ENCARGO).isEmpty()) {
			new EncargoAltaSiniestrosPage(userS)
				.clickContinuar();
		}

		// Verificacion de cambios en siniestros MAC
		new ModificacionVerificacionSiniestrosPage(userS)
			.mostrarCambios()
			.grabarCambios();

		// Página de confirmación
		debugInfo("Confirmamos si el Siniestro Mac ha sido modificado");
		new ConfirmacionSiniestrosPage(userS)
			.confirmarSiniestroOK();
	}

	public void compruebo_información_diario_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.goToDiario();

		new DiarioSiniestrosPage(userS)
			.mostrarInfoGeneral()
			.mostrarListadoMovimientos();

		debugEnd();
	}

	public void compruebo_siniestro_cerrado() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.comprobarSiniestroCerrado();

		debugEnd();
	}

	public void compruebo_siniestro_reaperturado() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.comprobarSiniestroReaperturadoOk();

		debugEnd();
	}

	public void comprobar_casos_error_declaracion_apertura_siniestro() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openAperturaAlta();

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getTestVar(Constants.NUM_POLIZA))
			.seleccionarResultado();

		// 1.Declaración
		new AltaAperturaDeclaracionSiniestrosPage(userS)
			.rellenarDatosMinimos()
			.fechaOcurrenciaFalloVacio()
			.fechaOcurrenciaFalloFormatoIncorrecto()
			.fechaOcurrenciaHoy()
			.tipoDeclaranteFalloVacio()
			.seleccionarTipoDeclarante()
			.medioDeclaracionFalloVacio()
			.seleccionarMedioDeclaracion()
			.emailDeclaranteFalloVacio()
			.emailDeclaranteFalloFormatoIncorrecto()
			.emailDeclaranteFalloNoDisponible();

		if(getTestVar(Constants.TIPO_POLIZA).equals(Constants.MEC)) {
			new AltaAperturaDeclaracionSiniestrosPage(userS)
				.asistenciaFalloVacio()
				.seleccionarAsistencia();
		}

		new AltaAperturaDeclaracionSiniestrosPage(userS)
			.fechaOcurrenciaFalloPosteriorHoy()
			.fechaOcurrenciaFalloAnteriorFechaVigenciaPoliza()
			.fechaOcurrenciaHoy()
			.personaContactoFalloAnyadir()
			.rolPersonaContactoFalloVacio()
			.seleccionarRolPersonaContacto()
			.nombrePersonaContactoFalloVacio()
			.escribirNombrePersonaContacto()
			.telefonoPersonaContactoFalloVacio()
			.telefonoPersonaContactoFalloAlfanumerico()
			.escribirTelefonoPersonaContacto()
			.emailPersonaContactoFalloVacio()
			.emailPersonaContactoFalloFormatoIncorrecto()
			.emailPersonaContactoFalloNoDisponible()
			.fechaDenunciaFalloVacio()
			.fechaDenunciaFalloFormatoIncorrecto()
			.fechaDenunciaFalloAnteriorOcurrencia()
			.fechaDenunciaFalloPosteriorHoy()
			.fechaDenunciaHoy()
			.clickContinuar();
		// .fechaOcurrenciaFalloHaceTresMeses();

		new AltaAperturaOcurrenciaSiniestrosPage(userS)
			.comprobarAvisos()
			.grupoCausaFalloVacio()
			.seleccionarGrupoCausa()
			.tipoCausaFalloVacio();

		if(getTestVar(Constants.TIPO_POLIZA).equals(Constants.MEC)) {
			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.seleccionarTipoCausa();
		} else {
			new AltaAperturaOcurrenciaSiniestrosPage(userS)
				.seleccionarTipoCausa("2000 AGUA");
		}

		new AltaAperturaOcurrenciaSiniestrosPage(userS)
			.descripcionSiniestroFalloVacio()
			.descripcionSiniestroFalloMinimoCaracteres()
			.escribirDescripcionSiniestro()
			.existenImplicadosFalloVacio()
			.seleccionarExistenImplicados()
			.necesitaEncargoFalloVacio()
			.seleccionarNecesitaEncargo();

		if(getTestVar(Constants.TIPO_POLIZA).equals(Constants.MEC)) {
			new ImplicadoAseguradoSiniestrosPage(userS)
				.capturaDatosSiniestro();
		}

		new ImplicadoAseguradoSiniestrosPage(userS)
			.anotacionesImplicadoTituloFalloVacio()
			.escribirAnotacionesImplicado();

		new OtrosImplicadosDatosSiniestrosPage(userS)
			.otrosImplicadosFalloVacio()
			.tipologiaImplicadoFalloVacio()
			.seleccionarTipologiaImplicado()
			.rolImplicadoFalloVacio()
			.seleccionarRolImplicado()
			.nombreImplicadoFalloVacio()
			.escribirNombreImplicado()
			.telefonoPrimeroImplicadoFalloVacio()
			.escribirTelefonoPrimeroImplicado()
			.telefonoSegundoImplicadoFalloFormatoIncorrecto()
			.escribirTelefonoSegundoImplicado()
			.emailImplicadoFalloVacio()
			.emailImplicadoFalloFormatoIncorrecto()
			.setDisponibilidadEmail(false)
			.ibanImplicadoFalloVacio()
			.escribirIbanImplicado("4543")
			.bancoImplicadoFalloVacio()
			.escribirBancoImplicado()
			.sucursalImplicadoFalloVacio()
			.escribirSucursalImplicado()
			.dcImplicadoFalloVacio()
			.escribirDcImplicado()
			.numeroCuentaImplicadoFalloVacio()
			.escribirNumeroCuentaImplicado()
			.setDisponibilidadIban(false)
			.clickGrabar()
			.clickContinuar();

		new EncargoDatosSiniestrosPage(userS)
			.anyadirEncargoFalloVacio()
			.tipoColaboradorFalloVacio()
			.seleccionarTipoColaborador()
			.tipoEncargoFalloVacio()
			.seleccionarTipoEncargo()
			.subtipoEncargoFalloVacio()
			.seleccionarSubtipoEncargo()
			.fechaEncargoFalloVacio()
			.fechaEncargoFormatoIncorrecto()
			.escribirfechaEncargo();

		new ConfirmacionSiniestrosPage(userS)
			.check();

		debugEnd();
	}

	public void desbloqueo_pago() {
		debugBegin();

		new InnovaHomePage(userS)
			.openSiniestros();

		new HomeSiniestrosPage(userS)
			.openGestionSiniestros();

		new GestionBuscadorSiniestrosPage(userS)
			.buscarPorNumeroSiniestro(getTestVar(Constants.NUMERO_SINIESTRO), getTestVar(Constants.ANYO_SINIESTRO));

		new GestionSiniestrosPage(userS)
			.goToPagos();

		new PagosSiniestrosPage(userS)
			.desbloquearPago();

		debugEnd();
	}

	public void gestionar_pago() {
		debugBegin();

		new InnovaHomePage(userS)
			.openGestionPagos();

		debugInfo("Autorizamos pago.");
		new GestionPagosPage(userS)
			.autorizar()
			.anyadirPagos()
			.buscarPagosPorSiniestro()
			.anyadirPagosALista()
			.continuarConPagos()
			.continuarConPagos()
			.autorizarPagos()
			.volverAlMenuGestionPagos();

		debugInfo("Confirmamos pago.");
		new GestionPagosPage(userS)
			.confirmar()
			.anyadirPagos()
			.buscarPagosPorFecha(null, null)
			.anyadirPagosALista()
			.continuarConPagos()
			.autorizarPagos()
			.volverAlMenuGestionPagos();

		debugInfo("Emitimos manualmente pago");
		new GestionPagosPage(userS)
			.emisionManual()
			.anyadirPagosAEmitir()
			.buscarPagosPorFecha(null, null)
			.anyadirPagosALista()
			.continuarConPagos()
			.emitirPago();

		debugEnd();
	}


	public void comprobaciones_ficha_mediador() {
		debugBegin();
		new InnovaHomePage(userS)
			.openMediadores();
		new MediadoresBuscadorPage(userS)
			.buscarMediadorPorId();
		new FichaMediadorPage(userS)
			.verificarCampoJerarquia();
		debugInfo("la comprobación de nivel jerarquico se ha completado");
		new FichaMediadorPage(userS)
			.verificarCampoNombreComercial()
			.solicitarAlta();
		debugEnd();
	}

	public void obtener_nombres_direcciones_mediador(){
	debugBegin();
		new InnovaHomePage(userS)
			.openMediadores();
		new MediadoresBuscadorPage(userS)
			.buscarMediadorPorId();
		new FichaMediadorPage(userS)
			.verificarDireccion();
	debugEnd();

	}


	public void alta_datos_basicos_mediador(){
		debugBegin();
		new InnovaHomePage(userS)
			.openMediadores();
		new MediadoresHomePage(userS)
			.openAltaMediador();
		new MediadoresAltaDatosDescriptivosPage (userS)
			.altaIntermediarioDescriptivosBasicos()
			.clickGuardarYSalir();
	/*	new FichaMediadorPage(userS)
			.comprobacionesVariadas();*/
		debugEnd();
	}
} // END
