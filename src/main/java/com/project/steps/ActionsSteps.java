package com.project.steps;

public class ActionsSteps {
	
//	private UserStory userS;
//	private DriverHelper webDriver;
//	final static Logger logger = LoggerFactory.getLogger(Steps.class);
//
//	public ActionsSteps(DriverHelper driver) {
//		this.webDriver = driver;
//	}
//
//	public ActionsSteps(UserStory userStory) {
//		this.userS = userStory;
//		this.webDriver = userS.getDriver();
//	}
//
//	public static void agrego_un_suplemento() throws Throwable {
//		// Login
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper
//			.LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, String.valueOf(this.tCData.getNumPoliza()));
//
//		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
//		gestionPolizasBuscadorPage.AddSuplementoGeneral();
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.clickOnContinuarButton();
//		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//			this.browserContext);
//		validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton();
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
//		ubicacionRiesgoPage.editCalidadConstruccion();
//		ubicacionRiesgoPage.clickOnContinuar();
//		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
//		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//			this.browserContext);
//		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.clickOnContinuar();
//		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//		validacionExcepcionesReglasPage.clickOnContinuarButton();
//		ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//		clausulasPage.ActivateclausesAndClickOnContinue();
//		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//		tomadorYAseguradoPage.clickOnContinuar();
//	}
//
//	@Cuando("^agrego el motivo suplemento \"([^\"]*)\"$")
//	public static void agrego_el_motivo_suplemento(
//		String motivoSuplemento) throws Throwable {
//		this.browserContext.getTestCaseData().setMotivosSuplemento(true, motivoSuplemento);
//		ConfirmarPolizaPage confirmarPolizaPage = new ConfirmarPolizaPage(this.browserContext);
//		// confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
//		confirmarPolizaPage.ActivateMotivosSuplemento();
//	}
//
//	@Cuando("^emito el suplemento$")
//	public static void emito_el_suplemento() throws Throwable {
//		ConfirmarPolizaPage confirmarPolizaPage = new ConfirmarPolizaPage(this.browserContext);
//		// confirmarPolizaPage.ActivateMotivosSuplemento();
//		confirmarPolizaPage.ClickOnContinuar();
//		ValidacionExcepcionesReglasConfirmarPoliza validacionExcepcionesReglasConfirmarPoliza = new ValidacionExcepcionesReglasConfirmarPoliza(
//			this.browserContext);
//		validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton();
//		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//		datosBancariosPage.ClickOnEmitirSuplemento();
//	}
//
//	@Cuando("^emito un suplemento general con motivo \"([^\"]*)\"$")
//	public static void emito_un_suplemento_general_con_motivo(
//		String motivoSuplemento) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper
//			.LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, String.valueOf(this.tCData.getNumPoliza()));
//
//		// this.tCData.setSuplemento(true);
//		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
//		gestionPolizasBuscadorPage.AddSuplementoGeneral();
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.clickOnContinuarButton();
//		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//			this.browserContext);
//		validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton();
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
//		ubicacionRiesgoPage.editCalidadConstruccion();
//		ubicacionRiesgoPage.clickOnContinuar();
//		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
//		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//			this.browserContext);
//		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.clickOnContinuar();
//		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//		validacionExcepcionesReglasPage.clickOnContinuarButton();
//		ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//		clausulasPage.ActivateclausesAndClickOnContinue();
//		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//		tomadorYAseguradoPage.clickOnContinuar();
//		this.browserContext.getTestCaseData().setMotivosSuplemento(true, motivoSuplemento);
//		ConfirmarPolizaPage confirmarPolizaPage = new ConfirmarPolizaPage(this.browserContext);
//		confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
//		ValidacionExcepcionesReglasConfirmarPoliza validacionExcepcionesReglasConfirmarPoliza = new ValidacionExcepcionesReglasConfirmarPoliza(
//			this.browserContext);
//		validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton();
//		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//		// DocumentacionPage documentacionPage = new
//		// DocumentacionPage(this.browserContext);
//		// documentacionPage.SubirFichero();
//		datosBancariosPage.ClickOnEmitirSuplemento();
//		// MensajeConfirmacionPage mensajeConfirmacionPage = new
//		// MensajeConfirmacionPage(this.browserContext);
//		// mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
//	}
//
//	@Cuando("^doy de alta una simulacion y la convierto en una contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_y_la_convierto_en_una_contratacion_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// Asignar mediador
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.selectMediadorAndClickOnContinuar();
//
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//			this.browserContext);
//		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//			this.browserContext);
//		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//		PrecioPage precioPage = new PrecioPage(this.browserContext);
//		precioPage.ClickOnConvertirAProjecto();
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this.tCData.getTomador());
//		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//		validacionExcepcionesReglasPage.clickOnContinuarButton();
//		ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//		clausulasPage.ActivateclausesAndClickOnContinue();
//		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//		tomadorYAseguradoPage.AddDatosTomador();
//		tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
//		tomadorYAseguradoPage.clickOnContinuar();
//		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//		datosBancariosPage.introducirFormaPagoYPulsarContratar();
//
//		this.browserContext.writeTestCaseData();
//		this.browserContext.getWebDriver().quit();
//	}
//
//	@Cuando("^se modifica el proyecto en Innova y lo guarda de nuevo$")
//	public static void se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(
//		String loginAcess, String user) throws Throwable {
//		loginAcess = this.tCData.getCambioAcceso();
//
//		logger.debug("BEGIN - se modifica el proyecto en Innov@ y lo guarda de nuevo");
//		this.browserContext.initializeVariables(loginAcess);
//		this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getCambioUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacion());
//		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//		gestionCotizacionesBuscacorPage.modificarProjecto();
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.clickOnContinuarButton();
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.closeAvisoSistemaPopup();
//		ubicacionRiesgoPage.modifyReferenciaCatastral();
//		ubicacionRiesgoPage.clickOnContinuar();
//		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//			this.browserContext);
//		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
//		ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//		validacionExcepcionesReglasPage.clickOnContinuarButton();
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.clickOnContinuar();
//		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//		precioPorModalidadPage.seleccionarModalidad();
//		precioPorModalidadPage.clickOnContinuar();
//		validacionExcepcionesReglasPage.clickOnContinuarButton();
//		ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//		clausulasPage.clickOnContinuar();
//		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//		tomadorYAseguradoPage.clickOnContinuar();
//		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//		datosBancariosPage.ClickOnGuardar();
//		this.browserContext.writeTestCaseData();
//		this.browserContext.getWebDriver().quit();
//		logger.debug("END - se modifica el proyecto en Innov@ y lo guarda de nuevo");
//
//	}
//
//	@Cuando("^cambio la cotización usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void modifico_la_cotización(
//		String loginAcess, String user) throws Throwable {
//
//		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
//		// loginAcess,
//		// this.tCData.getTestID());
//		loginAcess = this.tCData.getCambioAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			logger.debug("BEGIN - modifico_la_cotización");
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getCambioUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacion());
//			GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//			gestionCotizacionesBuscacorPage.modificarProjecto();
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.clickOnContinuarButton();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.closeAvisoSistemaPopup();
//			ubicacionRiesgoPage.modifyReferenciaCatastral();
//			ubicacionRiesgoPage.clickOnContinuar();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			// this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
//			this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
//			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//			validacionExcepcionesReglasPage.clickOnContinuarButton();
//			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//			datosBasicosTomadorPage.clickOnContinuar();
//			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//			precioPorModalidadPage.seleccionarModalidad();
//			precioPorModalidadPage.clickOnContinuar();
//			validacionExcepcionesReglasPage.clickOnContinuarButton();
//			ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//			clausulasPage.clickOnContinuar();
//			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//			tomadorYAseguradoPage.clickOnContinuar();
//			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//			datosBancariosPage.modificarFormaPagoYPulsarContratar();
//			this.browserContext.writeTestCaseData();
//			// this.browserContext.getWebDriver().quit();
//			logger.debug("END - modifico_la_cotización");
//		}
//	}
//
//	@Cuando("^doy de alta una simulacion y convierto esta simulacion a un projecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(
//		String loginAcess, String user) throws Throwable {
//
//		loginAcess = this.tCData.getAcceso();
//
//		logger.debug("BEGIN - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando");
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//			String mediador = this.tCData.getMediador();
//			if(this.tCData.getAcceso().equals(ProjectConstants.LoginAccessGestionLine) && this.tCData != null && !mediador.equals("640")) {
//				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//				asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			} else if(this.tCData.getAcceso().equals(ProjectConstants.LoginAccessInnova)) {
//				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//				asignarMediadorPage.seleccionarMediadorPorCodigo(this.tCData.getMediador().toString());
//				asignarMediadorPage.clickOnContinuarButton();
//			}
//
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			// this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
//			this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//				this.browserContext);
//			validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//			PrecioPage precioPage = new PrecioPage(this.browserContext);
//			precioPage.ClickOnConvertirAProjecto();
//			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//			datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
//			datosBasicosTomadorPage.clickOnContinuar();
//			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//			precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//			validacionExcepcionesReglasPage.clickOnContinuarButton();
//			ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//			clausulasPage.ActivateclausesAndClickOnContinue();
//			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//			tomadorYAseguradoPage.AddDatosTomador();
//			tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
//			tomadorYAseguradoPage.clickOnContinuar();
//			DocumentacionPage documentacionPage = new DocumentacionPage(this.browserContext);
//			documentacionPage.SubirFichero();
//			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//			datosBancariosPage.introducirFormaPagoYPulsarContratar();
//			this.browserContext.writeTestCaseData();
//			this.browserContext.getWebDriver().quit();
//			logger.debug("END - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando");
//		}
//
//	}
//
//	@Cuando("^doy de alta una simulacion, y la convierto a un proyecto, y la guardo sin contratar usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_y_la_convierto_a_un_proyecto_y_la_guardo_sin_contratar_usando(
//		String loginAcess, String user) throws Throwable {
//
//		loginAcess = this.tCData.getAcceso();
//
//		logger.debug("BEGIN - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando");
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//			String mediador = this.tCData.getMediador();
//			if(this.tCData.getAcceso().equals(ProjectConstants.LoginAccessGestionLine) && this.tCData != null && !mediador.equals("640")) {
//				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//				asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			} else if(this.tCData.getAcceso().equals(ProjectConstants.LoginAccessInnova)) {
//				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//				asignarMediadorPage.seleccionarMediadorPorCodigo(this.tCData.getMediador().toString());
//				asignarMediadorPage.clickOnContinuarButton();
//			}
//
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			// this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
//			this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//				this.browserContext);
//			validacionExcepcionesReglasDetallesRiesgoPage.clickOnContinuar();
//			PrecioPage precioPage = new PrecioPage(this.browserContext);
//			precioPage.ClickOnConvertirAProjecto();
//			DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//			datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
//			datosBasicosTomadorPage.clickOnContinuar();
//			PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//			precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//			ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//			validacionExcepcionesReglasPage.clickOnContinuarButton();
//			ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//			clausulasPage.ActivateclausesAndClickOnContinue();
//			TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//			tomadorYAseguradoPage.AddDatosTomador();
//			tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
//			tomadorYAseguradoPage.clickOnContinuar();
//			DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//			datosBancariosPage.introducirFormaPagoYPulsarGuardar();
//			this.browserContext.writeTestCaseData();
//			logger.debug("END - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando");
//		}
//
//	}
//
//	@Cuando("^doy de alta una simulacion que llega hasta la pantalla de detalles de riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		loginAcess = this.tCData.getAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			// this.detallesRiesgoPage.ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
//			this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
//		}
//	}
//
//	@Cuando("^doy de alta un proyecto que llega hasta la pantalla de detalles de riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
//		// loginAcess, this.tCData.getTestID());
//		loginAcess = this.tCData.getAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		}
//	}
//
//	@Cuando("^doy de alta una simulacion que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
//		// loginAcess, this.tCData.getTestID());
//		loginAcess = this.tCData.getAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//				this.browserContext);
//			validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//
//			PrecioPage precioPage = new PrecioPage(this.browserContext);
//			precioPage.ClickOnConvertirAProjecto();
//		}
//	}
//
//	@Cuando("^doy de alta una simulacion que llega hasta la pantalla de precio usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.seleccionarMediadorPorCodigo(this.tCData.getMediador().toString());
//		asignarMediadorPage.clickOnContinuarButton();
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
//		ubicacionRiesgoPage.clickOnContinuar();
//		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//			this.browserContext);
//		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//		ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//			this.browserContext);
//		validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//		PrecioPage precioPage = new PrecioPage(this.browserContext);
//		precioPage.ClickOnConvertirAProjecto();
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
//		datosBasicosTomadorPage.clickOnContinuar();
//		PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//		precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
//	}
//
//	@Cuando("^doy de alta un projecto que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
//		// loginAcess, this.tCData.getTestID());
//		loginAcess = this.tCData.getAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//			ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//				this.browserContext);
//			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//			this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
//			ValidacionExcepcionesReglasDetallesRiesgoPage validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
//				this.browserContext);
//			validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate();
//			// PrecioPage precioPage = new PrecioPage(this.browserContext);
//			// precioPage.ClickOConvertirAProjecto();
//		}
//	}
//
//	@Cuando("^continuo en datos básicos del tomador$")
//	public static void continuo_en_datos_básicos_del_tomador() throws Throwable {
//		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//		datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this.tCData.getTomador());
//	}
//
//	@Cuando("^lo consulto en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void lo_consulto_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper
//			.LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, String.valueOf(this.tCData.getNumPoliza()));
//	}
//
//	@Cuando("^lo consulto por dni en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void lo_consulto_por_dni_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.LoginAndSearchPolizaByNifNie(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getTomadorDNI());
//	}
//
//	@Cuando("^Intento dar de alta una simulación que solo va a llegar hasta datos del riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void intento_dar_alta_simulacion_hasta_datos_riesgo(
//		String loginAcess, String user) throws Exception {
//
//		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
//		// loginAcess,
//		// this.tCData.getTestID());
//		loginAcess = this.tCData.getAcceso();
//
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
//			&& this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
//			|| this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)) {
//			logger.debug("BEGIN - intento_dar_alta_simulacion_hasta_datos_riesgo");
//			this.browserContext.initializeVariables(loginAcess);
//			this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.seleccionarMediadorPorCodigo(this.tCData.getMediador().toString());
//			asignarMediadorPage.clickOnContinuarButton();
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
//			ubicacionRiesgoPage.clickOnContinuar();
//			DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//			detallesRiesgoPage.completarDatosRiesgo();
//			detallesRiesgoPage.ClikOnContinuar();
//			AvisoSistemaPage avisoSistemaPage = new AvisoSistemaPage(this.browserContext);
//			avisoSistemaPage.CheckmsgAvisoPlantasAlto();
//			this.browserContext.writeTestCaseData();
//			logger.debug("END - intento_dar_alta_simulacion_hasta_datos_riesgo");
//		}
//	}
//
//	@Cuando("^lo consulto en el buscador de cotizaciones usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void lo_consulto_en_el_buscador_de_cotizaciones(
//		String loginAcess, String user) throws Throwable {
//		logger.debug("BEGIN - lo_consulto_en_el_buscador_de_cotizaciones");
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacion());
//		// this.browserContext.initializeVariables(loginAcess =
//		// this.tCData.getCambioAcceso());
//		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getCambioUsuario(),
//		// this.browserContext.getProperties().passwordComun,
//		// this.tCData.getNoCotizacion());
//		logger.debug("END - lo_consulto_en_el_buscador_de_cotizaciones");
//	}
//
//	@Cuando("^continuo en Detalles de riesgo$")
//	public static void continuo_en_detalles_riesgo() throws Throwable {
//		logger.debug("BEGIN - continuo_en_detalles_riesgo");
//		this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//		this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
//		this.detallesRiesgoPage.ClikOnContinuar();
//		logger.debug("END - continuo_en_detalles_riesgo");
//	}
//
//	@Cuando("^modifico el capital continente a '(\\d+)'$")
//	public static void modifico_el_capital_continente_a(
//		Integer capitalContinente) throws Throwable {
//		this.tCData.setCapitalContinente(capitalContinente);
//	}
//
//	@Cuando("^cierro el navegador$")
//	public static void cierro_navegador() throws Throwable {
//		this.browserContext.getWebDriver().quit();
//	}
//
//	@Entonces("^el campo cotización contiene el valor del codigo de cotización$")
//	public static void el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() throws Throwable {
//		logger.debug("BEGIN - el_campo_cotización_contiene_el_valor");
//		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//		String cotizacion = gestionCotizacionesBuscacorPage.getCotizacion();
//		Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
//		logger.debug("END - el_campo_cotización_contiene_el_valor");
//	}
//
//	@Dada("^se descargan los ficheros del suplemento en la carpeta \"([^\"]*)\"$")
//	public static void se_descargan_los_ficheros_del_suplemento_en_la_carpeta(
//		String filesPath) throws Throwable {
//		logger.debug("BEGIN - se_descargan_los_ficheros_del_suplemento_en_la_carpeta");
//		MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(this.browserContext);
//		mensajeConfirmacionPage.DownlodadDocumentsToFolder(filesPath);
//
//		logger.debug("END - se_descargan_los_ficheros_del_suplemento_en_la_carpeta");
//	}
//
//	@Cuando("^doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// if
//		// (this.tCData.getAcceso().equals(MutuaPropietariosConstants.LoginAccessGestionLine))
//		// {
//		// GestionOnlineHomePage gestionOnlineHomePage = new
//		// GestionOnlineHomePage(this.browserContext);
//		// gestionOnlineHomePage.openMutuaAlquilerConfort();
//		// }
//		if(this.tCData.getAcceso().equals(ProjectConstants.LoginAccessInnova)) {
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
//			// InnovaHomePage innovaHomePage = new
//			// InnovaHomePage(this.browserContext);
//			// innovaHomePage.OpenMutuaAlquilerConfort();
//		}
//
//		// SCS Precio
//		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
//		precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
//
//		// SCS Inquilinos
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage();
//	}
//
//	@Cuando("^completo el proceso de contratacion MAC sin autorizacion$")
//	public static void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() throws Throwable {
//		logger.debug("BEGIN - completo_el_proceso_de_contratacion_MAC_sin_autorizacion");
//		// Continuar
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.clickOnContinuar();
//		// Rellenar datos de contratacion, pagina 3
//		TomadorYAseguradoPage_MAC tomadorYAseguradoPage_MAC = new TomadorYAseguradoPage_MAC(this.browserContext);
//		tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
//
//		InmueblePage_MAC inmueblePage_MAC = new InmueblePage_MAC(this.browserContext);
//		inmueblePage_MAC.executeActionsInInmueblePage();
//
//		DocumentacionPage_MAC documentacionPage_MAC = new DocumentacionPage_MAC(this.browserContext);
//		documentacionPage_MAC.addDocumentContratacion();
//
//		ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(this.browserContext);
//		contratacionPage_MAC.seleccionarCheckYContratar();
//		logger.debug("END - completo_el_proceso_de_contratacion_MAC_sin_autorizacion");
//	}
//
//	@Cuando("^se informa de que la poliza no se puede emitir$")
//	public static void se_informa_de_que_la_poliza_no_se_puede_emitir() throws Throwable {
//		// Compropar el estado de la poliza
//		ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(this.browserContext);
//
//		Assert.assertTrue(contratacionPage_MAC.checkPolizaError());
//	}
//
//	@Cuando("^busco el proyecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void busco_el_proyecto_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
//
//		// Abrir el buscador de proyectos
//		// if
//		// (this.tCData.getAcceso().equals(MutuaPropietariosConstants.LoginAccessGestionLine))
//		// {
//		// GestionOnlineHomePage gestionOnlineHomePage = new
//		// GestionOnlineHomePage(this.browserContext);
//		// gestionOnlineHomePage.openMisProyectosWeb();
//		// gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC());
//
//		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
//		// this.browserContext.getProperties().passwordComun,
//		// this.tCData.getNoCotizacion());
//		// }
//
//		// if
//		// (this.tCData.getAcceso().equals(MutuaPropietariosConstants.LoginAccessInnova))
//		// {
//		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
//		// this.browserContext.getProperties().passwordComun,
//		// this.tCData.getNoCotizacion());
//		// }
//
//	}
//
//	@Cuando("autorizo el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$")
//	public static void autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAccesoAuth());
//		this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(this.tCData.getUsuarioAuth(), this.browserContext.getProperties().passwordComun);
//
//		// Abrir la busqueda de autorizaciones
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.OpenGestionAutorizaciones();
//		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(this.browserContext);
//		gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", this.tCData.getNoCotizacionMAC());
//
//		// Autorizar el proyecto
//		gestionAutorizacionesPage.autorizar();
//	}
//
//	@Cuando("envio el proyecto a la compañia")
//	public static void envio_el_proyecto_a__la_compania() throws Throwable {
//		logger.debug("BEGIN - envio_el_proyecto_a__la_compania");
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.enviarACompania();
//		// this.browserContext.getWebDriver().quit();
//		logger.debug("END - envio_el_proyecto_a__la_compania");
//	}
//
//	@Cuando("deniego el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$")
//	public static void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
//		String loginAcess, String user) throws Throwable {
//		logger.debug("BEGIN - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario");
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAccesoAuth());
//		this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(this.tCData.getUsuarioAuth(), this.browserContext.getProperties().passwordComun);
//
//		// Abrir la busqueda de autorizaciones
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.OpenGestionAutorizaciones();
//		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(this.browserContext);
//		gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", this.tCData.getNoCotizacionMAC());
//
//		// Denegar el proyecto
//		gestionAutorizacionesPage.denegar();
//		this.browserContext.getWebDriver().quit();
//		logger.debug("END - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario");
//	}
//
//	@Cuando("^completo el proceso de contratacion usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$")
//	public static void completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		loginAcess = this.tCData.getAcceso();
//		if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) {
//			// Login a GestionLine
//			this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//			// this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this.tCData.getUsuario(),
//			// this.browserContext.getProperties().passwordComun);
//
//			// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
//			// this.browserContext.getProperties().passwordComun);
//			this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
//
//			// Abrir el buscador de proyectos
//			GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(this.browserContext);
//			// gestionOnlineHomePage.openMisProyectosWeb();
//			// gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC());
//
//			// Click en modificar
//			gestionOnlineHomePage.modificarProyecto();
//		}
//
//		else if(loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
//
//			// Login to Innov@
//			this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//			this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
//
//			GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//			gestionCotizacionesBuscadorPage.modificarProjecto();
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
//
//		}
//
//		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
//		precioPorModalidadPage_MAC.continuar();
//
//		// Continuar
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.clickOnContinuar();
//
//		// Rellenar datos de contratacion, pagina 3
//		TomadorYAseguradoPage_MAC tomadorYAseguradoPage_MAC = new TomadorYAseguradoPage_MAC(this.browserContext);
//		tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
//
//		InmueblePage_MAC inmueblePage_MAC = new InmueblePage_MAC(this.browserContext);
//		inmueblePage_MAC.executeActionsInInmueblePage();
//
//		DocumentacionPage_MAC documentacionPage_MAC = new DocumentacionPage_MAC(this.browserContext);
//		documentacionPage_MAC.addDocumentContratacion();
//
//		ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(this.browserContext);
//		contratacionPage_MAC.seleccionarCheckYContratar();
//	}
//
//	@Cuando("^completo el proceso de contratacion MAC$")
//	public static void completo_el_proceso_de_contratacion_MAC() throws Throwable {
//		// Click en contratar
//
//		// Completar los datos
//
//		//
//
//	}
//
//	@Cuando("^valido un proyecto \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void valido_un_proyecto_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// Asignar mediador
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
//
//		// SCS Precio
//		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
//		precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
//
//		// SCS Inquilinos
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPageSinDocumentacion();
//		// inquilinosAvalistasPage_MAC.ValidacionViabilidadInquilino();
//	}
//
//	@Cuando("^valido el proyecto$")
//	public static void valido_el_proyecto() throws Throwable {
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
//	}
//
//	@Cuando("^busco un edificio por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void busco_un_edificio_por_usando_el_acceso_y_el_usuario(
//		String filtroBuscador, String loginAcess, String user) throws Throwable {
//
//		this.tCData.setFiltroBuscadorEdificio(getValuesDataSet(this.tCData.gethMapDataSet(), filtroBuscador, this.tCData.getTestID()));
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// FichaEdificioPage
//		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
//		fichaEdificioPage.accederAlBuscadorEdificios();
//		fichaEdificioPage.buscarConFiltroBusqueda();
//	}
//
//	@Cuando("^abro la ficha de edificio desde el grid de resultados$")
//	public static void abro_ficha_edificio_desde_grid_resultados() throws Throwable {
//		// FichaEdificioPage
//		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
//		fichaEdificioPage.openFichaEdificioDesdeGrid();
//	}
//
//	@Cuando("^busco edificios por direcciones iterando con los datos del fichero \"([^\"]*)\"$")
//	public static void busco_edificios_por_direcciones_con_el_fichero(
//		String nombreFichero) throws Throwable {
//
//		// FichaEdificioPage
//		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
//		fichaEdificioPage.accederAlBuscadorEdificios();
//
//		fichaEdificioPage.setFiltroBusqueda(ProjectConstants.FILTRO_BUSCADOR_DIRECCION);
//		fichaEdificioPage.iterarEdificiosPorDirecciones(getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID()));
//	}
//
//	@Cuando("^busco edificios por direcciones en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$")
//	public static void busco_edificios_por_direcciones_en_buscador_MEC_con_el_fichero(
//		String nombreFichero) throws Throwable {
//		this.inicio_sesion();
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMutuaEdificioConfort();
//		innovaHomePage.CreateNewProject();
//
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.selectMediadorAndClickOnContinuar();
//
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		ubicacionRiesgoPage.iterarEdificiosPorDirecciones(getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID()));
//		// fichaEdificioPage.setFiltroBusqueda(MutuaPropietariosConstants.FILTRO_BUSCADOR_DIRECCION);
//		// fichaEdificioPage.IterarEdificiosPorDirecciones(
//		// getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero,
//		// this.tCData.getTestID()));
//	}
//
//	@Cuando("^busco edificios por referencias iterando con los datos del fichero \"([^\"]*)\"$")
//	public static void busco_edificios_por_referencias_con_el_fichero(
//		String nombreFichero) throws Throwable {
//		this.inicio_sesion();
//
//		// FichaEdificioPage
//		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
//		fichaEdificioPage.accederAlBuscadorEdificios();
//
//		fichaEdificioPage.setFiltroBusqueda(ProjectConstants.FILTRO_BUSCADOR_CATASTRAL);
//		fichaEdificioPage.iterarEdificiosPorReferencias(getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID()));
//	}
//
//	@Cuando("^busco edificios por referencias en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$")
//	public static void busco_edificios_por_referencias_en_el_buscador_MEC_con_el_fichero(
//		String nombreFichero) throws Throwable {
//		this.inicio_sesion();
//
//		// FichaEdificioPage
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMutuaEdificioConfort();
//		innovaHomePage.CreateNewProject();
//
//		AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//		asignarMediadorPage.selectMediadorAndClickOnContinuar();
//
//		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//		System.out.println("Nombre fichero en action steps: " + nombreFichero);
//		// ubicacionRiesgoPage.iterarEdificiosPorReferencias(getValuesDataSet(this.tCData.gethMapDataSet(),
//		// nombreFichero, this.tCData.getTestID()));
//		ubicacionRiesgoPage.iterarEdificiosPorReferencias(System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder + "/" + this.tCData.value("fichero"));
//
//	}
//
//	@Cuando("^modifico los ingresos a \"([^\"]*)\"$")
//	public static void modificar_ingresos(
//		String ingresos) throws Throwable {
//		// this.tCData.setIngresosNetosInquilino(getValuesDataSet(this.tCData.gethMapDataSet(),
//		// ingresos, this.tCData.getTestID()) != null
//		// ? Integer.parseInt(getValuesDataSet(this.tCData.gethMapDataSet(),
//		// ingresos, this.tCData.getTestID())) : null);
//
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.modificarRentasInquilino();
//
//		inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
//
//	}
//
//	@Cuando("^añado avalista$")
//	public static void anado_avalista() throws Throwable {
//		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
//		inquilinosAvalistasPage_MAC.addDatosAval();
//
//		inquilinosAvalistasPage_MAC.anadirDocumentacionAval();
//
//		inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
//	}
//
//	@Cuando("^inicio sesion$")
//	public static void inicio_sesion() throws Throwable {
//		System.out.println("Acceso: " + this.tCData.getAcceso());
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//	}
//
//	@Cuando("^inicio sesion con el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void inicio_sesion_con_acceso_y_usuario(
//		String loginAccess, String user) throws Throwable {
//		// this.tCData.setAcceso(
//		// getValuesDataSet(this.tCData.gethMapDataSet(), loginAccess,
//		// this.tCData.getTestID()));
//		// this.tCData.setUsuario(this.tCData.getUsuario());
//
//		this.browserContext.initializeVariables(this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//	}
//
//	@Cuando("^doy de alta una simulación actualizando datos iterando por el fichero \"([^\"]*)\"$")
//	public static void doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero(
//		String fileName) throws Throwable {
//		logger.debug("BEGIN - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero");
//		String logText = "", address = "";
//		this.tCData.setInmueble("direccion por defecto");
//		// fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName,
//		// this.tCData.getTestID());
//		fileName = this.tCData.value("fichero");
//		System.out.println("Filename: " + fileName);
//		fileName = fileName.substring(0, fileName.length() - 4);
//		System.out.println("Filename: " + fileName);
//
//		this.inicio_sesion();
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMutuaEdificioConfort();
//
//		String[][] datosAltoValor = loadDataFileToArray(System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder + "/" + fileName + ".csv", false);
//		// String[][] datosAltoValor = loadDataFileToArray(fileName, false);
//		/*
//		 * HashMap<String, HashMap<String, String>> datosAltoValor =
//		 * loadDataFileToHashMap( getValuesDataSet(this.tCData.gethMapDataSet(),
//		 * fileName, this.tCData.getTestID()), false);
//		 */
//
//		for(int i = 1; i < datosAltoValor.length; i++) {
//			innovaHomePage.CreateNewSimulation();
//			// address = getValuesDataSetByID(datosAltoValor, "provincia", i) +
//			// ", " + getValuesDataSetByID(datosAltoValor, "poblacion", i) + ",
//			// "
//			// + getValuesDataSetByID(datosAltoValor, "direccion", i) + ", " +
//			// getValuesDataSetByID(datosAltoValor, "numero", i);
//
//			// address = getValuesDataSetByID(datosAltoValor, "ref_catastral",
//			// i);
//
//			this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor, "ref_catastral", i));
//			// this.tCData.setDireccionProvincia(getValuesDataSetByID(datosAltoValor,
//			// "provincia", i));
//			// this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosAltoValor,
//			// "poblacion", i));
//			// this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosAltoValor,
//			// "direccion", i));
//			// this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosAltoValor,
//			// "numero", i));
//			// String codigoPostal = getValuesDataSetByID(datosAltoValor,
//			// "codigo_postal", i);
//			// this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ?
//			// "0" + codigoPostal : codigoPostal);
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			try {
//				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//
//				if(!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) {
//					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
//					System.out.println("Mas de una referencia catastral encontrada");
//					this.browserContext.webElementHelper.exitFromFrame();
//					innovaHomePage.openInnovaHome();
//					innovaHomePage.openMutuaEdificioConfort();
//					writeFile(fileName + " (log file).txt", logText);
//					continue;
//				}
//				ubicacionRiesgoPage.closeNotification();
//				ubicacionRiesgoPage.clickOnContinuar();
//
//				ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//					this.browserContext);
//				validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//				this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//				String anyoConstruccion = this.detallesRiesgoPage.completarDatosRiesgoMinimos();
//				this.detallesRiesgoPage.ClikOnContinuar();
//
//				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//				// precioPorModalidadPage.modificarRC("600.000,00");
//				// precioPorModalidadPage.agregarDescuento(getValuesDataSet(this.tCData.gethMapDataSet(),
//				// this.tCData.getDescuento(),
//				// this.tCData.getTestID()));
//				precioPorModalidadPage.agregarDescuento(this.tCData.getDescuento());
//
//				String precioTotal = precioPorModalidadPage.getPrecioTotal();
//				precioPorModalidadPage.clickOnGuardar();
//				String numSimulacion = precioPorModalidadPage.getNumSimulacion();
//
//				datosAltoValor = setValuesDataSetByID(datosAltoValor, "prima_total", i, precioTotal);
//				datosAltoValor = setValuesDataSetByID(datosAltoValor, "anyo_antiguedad", i, anyoConstruccion);
//				datosAltoValor = setValuesDataSetByID(datosAltoValor, "numero_proyecto", i, numSimulacion);
//
//				writeArrayIntoCSVFile(fileName + " (modificado).csv", datosAltoValor);
//
//				precioPorModalidadPage.clickOnCancelar();
//			} catch(Exception e) {
//				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
//				writeFile(fileName + " (log file).txt", logText);
//				System.out.println("Comprobaciones de datos no contempladas");
//				this.browserContext.webElementHelper.exitFromFrame();
//				innovaHomePage.openInnovaHome();
//				innovaHomePage.openMutuaEdificioConfort();
//			}
//		}
//
//		this.browserContext.getWebDriver().quit();
//
//		logger.debug("END - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero");
//	}
//
//	@Cuando("^prueba$")
//	public static void prueba() throws Throwable {
//		// this.tCData.prueba();
//	}
//
//	@Cuando("^modifico un proyecto iterando por el fichero \"([^\"]*)\" cambiando el mediador$")
//	public static void modifico_proyecto_iterando_cambio_mediador(
//		String fileName) throws Throwable {
//		logger.debug("BEGIN - modifico_proyecto_iterando_cambio_mediador");
//		fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID());
//		fileName = fileName.substring(0, fileName.length() - 4);
//		// fileName = tCData.value("fileName")
//		// DataObject data = new
//		// DataObject(FileUtils.csvFileToMData(tCData.value("fileName")));
//		this.inicio_sesion();
//
//		String[][] datosAltoValor = loadDataFileToArray(fileName + ".csv", false);
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.OpenGestionCotizaciones();
//
//		for(int i = 1; i < datosAltoValor.length; i++) {
//			// data.setKey(Integer.toString(i));
//			// data.value("ref_catastral");
//			String cotizacion = getValuesDataSetByID(datosAltoValor, "numero_proyecto", i);
//
//			if(cotizacion == null || cotizacion.isEmpty())
//				continue;
//
//			GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
//			gestionCotizacionesBuscadorPage.searchCotizacion(cotizacion);
//			gestionCotizacionesBuscadorPage.modificarProjecto();
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//
//			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//			ubicacionRiesgoPage.clickOnGuardar();
//			ubicacionRiesgoPage.closeAvisoSistemaPopup();
//
//			innovaHomePage.openInnovaHome();
//			innovaHomePage.OpenGestionCotizaciones();
//		}
//
//		this.browserContext.getWebDriver().quit();
//
//		logger.debug("END - modifico_proyecto_iterando_cambio_mediador");
//	}
//
//	@Cuando("^doy de alta un proyecto actualizando datos iterando por el fichero \"([^\"]*)\"$")
//	public static void doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero(
//		String fileName) throws Throwable {
//		logger.debug("BEGIN - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero");
//		String logText = "", address = "";
//		this.tCData.setInmueble("direccion por defecto");
//		fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID());
//		fileName = fileName.substring(0, fileName.length() - 4);
//
//		this.inicio_sesion();
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMutuaEdificioConfort();
//
//		String[][] datosCargaMEC = loadDataFileToArray(fileName + ".csv", false);
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "capital_continente");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "total_asegurado");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "capital_contenido");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "precios_antes_proyecto");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "precios_despues_proyecto");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "precio_basic");
//		datosCargaMEC = addColumnToArray(datosCargaMEC, "precio_plus");
//		/*
//		 * HashMap<String, HashMap<String, String>> datosAltoValor =
//		 * loadDataFileToHashMap( getValuesDataSet(this.tCData.gethMapDataSet(),
//		 * fileName, this.tCData.getTestID()), false);
//		 */
//
//		for(int i = 1; i < datosCargaMEC.length; i++) {
//			innovaHomePage.CreateNewSimulation();
//			address = getValuesDataSetByID(datosCargaMEC, "provincia", i) + ", " + getValuesDataSetByID(datosCargaMEC, "poblacion", i) + ", "
//				+ getValuesDataSetByID(datosCargaMEC, "direccion", i) + ", " + getValuesDataSetByID(datosCargaMEC, "numero", i);
//
//			this.tCData.setDireccionProvincia(getValuesDataSetByID(datosCargaMEC, "provincia", i));
//			this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosCargaMEC, "poblacion", i));
//			this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosCargaMEC, "direccion", i));
//			this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosCargaMEC, "numero", i));
//			String codigoPostal = getValuesDataSetByID(datosCargaMEC, "codigo_postal", i);
//			this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			try {
//				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//
//				if(!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) {
//					logText += "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
//					System.out.println("Mas de una referencia catastral encontrada");
//					this.browserContext.webElementHelper.exitFromFrame();
//					innovaHomePage.openInnovaHome();
//					innovaHomePage.openMutuaEdificioConfort();
//					writeFile(fileName + " (log file).txt", logText);
//					continue;
//				}
//				ubicacionRiesgoPage.closeNotification();
//				ubicacionRiesgoPage.clickOnContinuar();
//
//				ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//					this.browserContext);
//				validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//				this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//				this.detallesRiesgoPage.completarDatosRiesgoMinimos();
//
//				String capitalContinente = this.detallesRiesgoPage.getCapitalContinente();
//				String totalAsegurado = this.detallesRiesgoPage.getCapitalContinenteTotalAsegurado();
//				String capitalContenido = this.detallesRiesgoPage.getCapitalContenido();
//
//				this.detallesRiesgoPage.ClikOnContinuar();
//
//				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//				String precioComplet = precioPorModalidadPage.getPrecioTotal();
//				String precioBasic = precioPorModalidadPage.getPrecioBasic();
//				String precioPlus = precioPorModalidadPage.getPrecioPlus();
//
//				precioPorModalidadPage.clickOnGuardar();
//				// TODO
//				// Convertir a proyecto
//				// seguir los pasos
//				// Terminar de crear la poliza
//
//				// escribir los datos: numeroProyecto, precios antes de
//				// proyecto, precios despues de
//				// proyecto
//
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_continente", i, capitalContinente);
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "total_asegurado", i, totalAsegurado);
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_contenido", i, capitalContenido);
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "prima_total", i, precioComplet);
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_basic", i, precioBasic);
//				datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_plus", i, precioPlus);
//				// datosCargaMEC = setValuesDataSetByID(datosCargaMEC,
//				// "numero_proyecto", i, numSimulacion);
//
//				writeArrayIntoCSVFile(fileName + " - " + new ConfigurationProperties().environment + " (resultados).csv", datosCargaMEC);
//
//				innovaHomePage.openInnovaHome();
//				innovaHomePage.openMutuaEdificioConfort();
//			} catch(Exception e) {
//				logText += "Comprobacion de datos no contemplada para la direccion " + address + "\n";
//				writeFile(fileName + " (log file).txt", logText);
//				System.out.println("Comprobaciones de datos no contempladas\n\t- " + e.toString());
//				this.browserContext.webElementHelper.exitFromFrame();
//				innovaHomePage.openInnovaHome();
//				innovaHomePage.openMutuaEdificioConfort();
//			}
//		}
//
//		this.browserContext.getWebDriver().quit();
//
//		logger.debug("END - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero");
//	}
//
//	@Cuando("^se da de alta un proyecto MEC donde la antiguedad del edificio es mayor que 50 anyos y se solicita peritacion, iterando por el fichero \"([^\"]*)\"")
//	public static void se_dan_de_alta_masivamente_proyectos_MEC_donde_la_antiguedad_del_edificio_es_mayor_que_50_anyos(
//		String fileName) throws Throwable {
//		logger.debug("BEGIN - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50");
//		String logText = "", address = "";
//		// this.tCData.setInmueble("direccion por defecto");
//		fileName = this.tCData.value("fichero");
//		System.out.println("Filename: " + fileName);
//		fileName = fileName.substring(0, fileName.length() - 4);
//		System.out.println("Filename: " + fileName);
//
//		this.inicio_sesion();
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMutuaEdificioConfort();
//
//		String[][] datosAltoValor = loadDataFileToArray(System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder + "/" + fileName + ".csv", false);
//
//		for(int i = 1; i < datosAltoValor.length; i++) {
//			innovaHomePage.CreateNewProject();
//
//			this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor, "ref_catastral", i));
//
//			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(this.browserContext);
//			asignarMediadorPage.selectMediadorAndClickOnContinuar();
//			try {
//				UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(this.browserContext);
//				ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
//				// ubicacionRiesgoPage.closeNotification();
//				// ubicacionRiesgoPage.clickOnContinuar();
//
//				ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(
//					this.browserContext);
//				validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
//				this.detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
//				this.detallesRiesgoPage.completarDatosRiesgoMinimos(); // Enter
//																		// values
//																		// madera
//																		// and
//																		// deshabitación.
//				this.detallesRiesgoPage.enterAnyoConstruccionMoreThan50();
//				this.detallesRiesgoPage.ClikOnContinuar();
//				ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(this.browserContext);
//				validacionExcepcionesReglasPage.clickOnContinuarButton();
//				DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(this.browserContext);
//				datosBasicosTomadorPage.fillStaticTomadorData();
//				datosBasicosTomadorPage.clickOnContinuar();
//				PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(this.browserContext);
//				precioPorModalidadPage.clickOnContinuar();
//				// ValidacionExcepcionesReglasPage
//				// validacionExcepcionesReglasPage = new
//				// ValidacionExcepcionesReglasPage(this.browserContext);
//				validacionExcepcionesReglasPage.clickOnContinuarButton();
//				ClausulasPage clausulasPage = new ClausulasPage(this.browserContext);
//				clausulasPage.clickOnContinuar();
//				TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(this.browserContext);
//				tomadorYAseguradoPage.addStaticDatosTomador();
//				// tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
//				tomadorYAseguradoPage.clickOnContinuar();
//				DatosBancariosPage datosBancariosPage = new DatosBancariosPage(this.browserContext);
//
//				datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion();
//				// this.browserContext.writeTestCaseData();
//				// this.browserContext.getWebDriver().quit();
//
//				Iterable<String> PeritajeIterator = Splitter.on(' ').split(datosBancariosPage.getMensajePeritaje());
//				String[] PeritajeList = Iterables.toArray(PeritajeIterator, String.class);
//
//				logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
//					+ " (Proyecto: " + datosBancariosPage.getProjectNumber() + ", " + "Referencia solicitud: " + PeritajeList[7] + ")" + "\n";
//				writeFile(fileName + " (log file).txt", logText);
//
//				innovaHomePage.openInnovaHome();
//				innovaHomePage.openMutuaEdificioConfort();
//			} catch(Exception e) {
//				logText += "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor, "ref_catastral", i)
//					+ "\n";
//				writeFile(fileName + " (log file).txt", logText);
//				System.out.println("Comprobaciones de datos no contempladas");
//				this.browserContext.webElementHelper.exitFromFrame();
//				innovaHomePage.openInnovaHome();
//				innovaHomePage.openMutuaEdificioConfort();
//			}
//		}
//
//		this.browserContext.getWebDriver().quit();
//
//		logger.debug("END - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50");
//	}
//
//	@Cuando("^busco un cliente por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void busco_un_cliente_por_usando_el_acceso_y_el_usuario(
//		String filtroBuscador, String loginAcess, String user) throws Throwable {
//
//		this.tCData.setFiltroBuscadorCliente(getValuesDataSet(this.tCData.gethMapDataSet(), filtroBuscador, this.tCData.getTestID()));
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// Clientes Page
//		ClientesPage clientesPage = new ClientesPage(this.browserContext);
//		clientesPage.accederAlBuscadorClientes();
//		clientesPage.buscarConFiltroBusqueda();
//	}
//
//	@Cuando("^doy de alta un nuevo tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_alta_nuevo_tomador_usando_el_acceso_y_el_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		// Login
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		// Clientes Page
//		ClientesPage clientesPage = new ClientesPage(this.browserContext);
//		clientesPage.accederAlBuscadorClientes();
//		clientesPage.crearNuevoTomador();
//	}
//
//	@Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\" iterando por el fichero \"([^\"]*)\"$")
//	public static void doy_de_alta_prospect_usando_acceso_y_usuario_iterando_fichero(
//		String loginAcess, String user, String fileName) throws Throwable {
//		fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID());
//		fileName = fileName.substring(0, fileName.length() - 4);
//
//		this.inicio_sesion();
//
//		String[][] datosMediadores = loadDataFileToArray(fileName + ".csv", false);
//		/*
//		 * HashMap<String, HashMap<String, String>> datosAltoValor =
//		 * loadDataFileToHashMap( getValuesDataSet(this.tCData.gethMapDataSet(),
//		 * fileName, this.tCData.getTestID()), false);
//		 */
//
//		for(int i = 1; i < datosMediadores.length; i++) {
//			this.tCData.setNivelEstructura(getValuesDataSetByID(datosMediadores, "nivelEstructura", i));
//			this.tCData.setTipoProspect(getValuesDataSetByID(datosMediadores, "tipoProspect", i));
//			this.tCData.setActividadPrincipal(getValuesDataSetByID(datosMediadores, "actividadPrincipal", i));
//			this.tCData.setNombreComercialProspect(getValuesDataSetByID(datosMediadores, "nomComercial", i));
//			this.tCData.setContactoResponsable(getValuesDataSetByID(datosMediadores, "contactoResponsable", i));
//			this.tCData.setIdioma(getValuesDataSetByID(datosMediadores, "idioma", i));
//			this.tCData.setTlfPrincipal(getValuesDataSetByID(datosMediadores, "tlfPrincipal", i));
//			this.tCData.setEjecutivoComercial(getValuesDataSetByID(datosMediadores, "ejecutivoComercial", i));
//			this.tCData.setProvincia(getValuesDataSetByID(datosMediadores, "provincia", i));
//			this.tCData.setPoblacion(getValuesDataSetByID(datosMediadores, "poblacion", i));
//			this.tCData.setNombreVia(getValuesDataSetByID(datosMediadores, "nombreVia", i));
//
//			try {
//				this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//				this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//				InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//				innovaHomePage.openMediadores();
//
//				MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(this.browserContext);
//				mediadoresHomePage.openAltaProspect();
//
//				MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(this.browserContext);
//				mediadoresAltaProspectPage.executeActionsAltaProspectPage();
//
//			} catch(Exception e) {
//
//			}
//		}
//	}
//
//	@Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_prospect_usando_acceso_y_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMediadores();
//
//		MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(this.browserContext);
//		mediadoresHomePage.openAltaProspect();
//
//		MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(this.browserContext);
//		mediadoresAltaProspectPage.executeActionsAltaProspectPage();
//
//	}
//
//	@Cuando("^doy de alta un mediador usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void doy_de_alta_mediador_usando_acceso_y_usuario(
//		String loginAcess, String user) throws Throwable {
//
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
//		innovaHomePage.openMediadores();
//
//		MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(this.browserContext);
//		mediadoresHomePage.openAltaMediador();
//
//		MediadoresAltaMediadorPage mediadoresAltaMediadorPage = new MediadoresAltaMediadorPage(this.browserContext);
//		mediadoresAltaMediadorPage.executeActionsAltaMediadorPage();
//
//	}
//
//	@Cuando("^comunico un siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void comunico_siniestro(
//		String loginAcess, String user) throws Throwable {
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//	}
//
//	@Cuando("^busco el siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$")
//	public static void busco_siniestro(
//		String loginAcess, String user) throws Throwable {
//		this.browserContext.initializeVariables(loginAcess = this.tCData.getAcceso());
//		this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
//
//	}
//
//	@Cuando("^la renta mensual alquiler es \"([^\"]*)\"$")
//	public static void la_renta_mensual_es(
//		String rentaMensualAlquiler) throws Throwable {
//		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
//		precioPorModalidadPage_MAC.CompletarRentaMensualAlquiler();
//	}
//
//	@Cuando("^la suma asegurada de impago alquiler es \"([^\"]*)\" meses$")
//	public static void la_suma_asegurada_de_impago_alquiler_es(
//		String sumaAseguradaImpagoAlquiler) throws Throwable {
//		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
//		precioPorModalidadPage_MAC.seleccionarImpagoAlquiler();
//	}

}
