package com.amaris.project.steps;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.automation.model.utils.InitUtils;
import com.amaris.automation.model.webdriver.DriverHelper;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.By;

import com.amaris.project.Constants;
import com.amaris.project.pages.*;

public class Steps extends InteractionObject {

	public Steps(UserStory userStory) {
		super(userStory);
	}

	public static String getDayOfWeek() {
		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US);
	}

	public void login(String accessType, String user) throws Exception {
		debugBegin();
		// this.scenario = scenario;
		/*
		 * this.webDriver = WebDriverCreation.CreateWebDriver(BrowserType.valueOf(this.
		 * configurationProperties.Browser)); this.webElementHelper = new WebElementHelper(this.webDriver,
		 * this.scenario, this.configurationProperties); this.webDriverConfiguration = new
		 * CommonConfiguration(this.webDriver); this.webDriverConfiguration.SetWebDriverTimeouts();
		 * this.webDriverConfiguration.MaximizeWindow();
		 */

		// com.amaris.project.utils.IApplicationAccessHelper.initialize(AccessType,
		// webDriver);
		String environment = InitUtils.getStringConfigVariable("environment", userS.getConfigData());
		System.out.println("*** environment: " + environment);
		System.out.println("*** access type: " + accessType);
		System.out.println("*** user: " + user);
		new LoginPage(userS).logIn(environment, accessType, user);
		debugEnd();
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

		// loginAcess = this.userS.getTestVar("acceso");

		// userS.getTestVar("acceso");
		// userS.getConfigVar("gestion_online_disponible");
		// if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
		// &&
		// userS.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
		// &&
		// this.userS.getTestVar("get_propeties").equals(ProjectConstants.GestionOnlineDisponible)
		// &&
		// Boolean.parseBoolean(this.userS.getConfigVar("GestionOnlineDisponible"))
		// || loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
		// Convertir a un step de ir a X entorno pasado por el parametro
		// "acceso"

		this.login(loginAcess, user);

		// Convertir a un step de logearse con el usuario X, parando el
		// usuario por el parametro "usuario"

		// this.userS.getTestVar("login_access");
		// this.LoginAndCreateSimulation(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun);
		// this.loginAndCreateSimulation(this.userS.getTestVar("usuario"),
		// this.userS.getConfigVar("passwordComun"));

		// String mediador = this.tCData.getMediador();
		String mediador = this.userS.getScenarioVar("mediador");

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) { // &&
																	// !mediador.equals("640"))
																	// {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();
			// new GestionOnlineHomePage(userS).createNewSimulation();
			// new
			// AsignarMediadorPage(userS).selectMediadorAndClickOnContinuar(userS.getScenario());
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			this.openSimulationMec();
			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		// The testId variable has been set here because the FillTomadorData
		// from DatosBasicosTomadorPage requires it. Not sure if this is the
		// proper usage.
		String testId = userS.getWebDriver().getId() == null ? "" : userS.getWebDriver().getId();

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
			.clickOnConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar("tomador"))
			.clickOnContinuar();

		new PrecioPorModalidadPage(userS)
			// .executeActionsInPrecioPorModalidadPage();
			.clickOnContinuar();

		new ValidacionExcepcionesReglasPage(userS)
			.clickOnContinuarButton();

		new ClausulasPage(userS)
			.activateclausesAndClickOnContinue();

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
			.clickOnContinuar();

		new DocumentacionPage(userS)
			.SubirFichero();

		new DatosBancariosPage(userS)
			.introducirFormaPagoYPulsarContratar();

		// userS.writeTestCaseData();
		userS.getWebDriver().quit();

		new DocumentacionPage(userS)
			.SubirFichero();

		new DatosBancariosPage(userS)
			.introducirFormaPagoYPulsarContratar();

		userS.getWebDriver().quit();
		// }

		debugEnd();
	}

	// @Cuando("^selecciono Hay una gasolinera a menos de '(\\d+)'$") public
	void selecciono_Hay_una_gasolinera_a_menos_de_m(int arg1) {
		this.userS.setTestVar("gasolinera_menos_50m", "true");
		// userS.getTestCaseData().setGasolineraMenos50M(true);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////////////////////////////////////////////////////////// ///// DATA ENTRY STEPS
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 *
	 *
	 *
	 * // private DetallesRiesgoPage detallesRiesgoPage; //final static Logger logger =
	 * LoggerFactory.getLogger(CommonSteps.class);
	 *
	 *
	 *
	 * // //@Dado("^marcado el check Asegurar unicamente los garajes$") public void
	 * marcado_el_check_Asegurar_unicamente_los_garajes() { userS.setTestVar("asegurar_garajes", "true");
	 * //userS.getTestVar("asegurar_garajes"); //userS.getTestCaseData().setAsegurarUnicamenteGarajes(true ); }
	 *
	 * // //@Dado("^el dni \"([^\"]*)\"$") public void el_dni( String dniNumber) { logger.debug("BEGIN - el_dni"); //
	 * userS.getTestCaseData().setTomadorDNI(dniNumber); logger.debug("END - el_dni"); }
	 *
	 * // //@Dado("^el numero de cuenta es \"([^\"]*)\"$") public void la_cuenta( String numeroCuenta) {
	 * logger.debug("BEGIN - la_cuenta"); // userS.getTestCaseData().setNumeroCuenta( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), numeroCuenta, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - la_cuenta"); }
	 *
	 * // //@Dado("^la fecha de contrato del alquiler es \"([^\"]*)\"$") public void fecha_contrato_alquiler( String
	 * fecha) { logger.debug("BEGIN - fecha_contrato_alquiler"); //
	 * userS.getTestCaseData().setFechaContratoAlquiler(fecha); logger.debug("END - fecha_contrato_alquiler"); }
	 *
	 * //@Dado("^el inmueble con la dirección \"([^\"]*)\"$") public void el_inmueble( String direccion) {
	 * logger.debug("BEGIN - el_inmueble"); // userS.getTestCaseData().setInmueble(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), direccion, // userS.getTestCaseData().getTestID()));
	 * logger.debug("END - el_inmueble"); }
	 *
	 * //@Dado("^la provincia del inmueble es \"([^\"]*)\"$") public void provincia_inmueble( String provincia) {
	 * logger.debug("BEGIN - provincia_inmueble"); // userS.getTestCaseData().setInmuebleProvincia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), provincia, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_inmueble"); }
	 *
	 * // //@Dado("^la poblacion del inmueble es \"([^\"]*)\"$") public void poblacion_inmueble( String poblacion) {
	 * logger.debug("BEGIN - poblacion_inmueble"); // userS.getTestCaseData().setInmueblePoblacion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), poblacion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_inmueble"); }
	 *
	 * //@Dado("^la direccion del inmueble es \"([^\"]*)\"$") public void direccion_inmueble( String direccion) {
	 * logger.debug("BEGIN - direccion_inmueble"); // userS.getTestCaseData().setInmuebleNombreVia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), direccion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_inmueble"); }
	 *
	 * //@Dado("^el numero de portal del inmueble es \"([^\"]*)\"$") public void portal_inmueble( String portal) {
	 * logger.debug("BEGIN - portal_inmueble"); // userS.getTestCaseData().setInmuebleNumeroVia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), portal, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - portal_inmueble"); }
	 *
	 * //@Dado("^el número de edificios es \"([^\"]*)\"$") public void el_numero_de_edificios( String numeroEdificios) {
	 * logger.debug("BEGIN - el_numero_de_edificios"); // userS.getTestCaseData() //
	 * .setNumeroEdificios(getValuesDataSet(userS.getTestCaseData( ).gethMapDataSet(), numeroEdificios, //
	 * userS.getTestCaseData().getTestID()) != null ? // Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), numeroEdificios, // userS.getTestCaseData().getTestID())) : null);
	 * logger.debug("END - el_numero_de_edificios"); }
	 *
	 * ////@Dado("^el mediador \"([^\"]*)\"$") public void el_mediador( String codigoMediador) {
	 * logger.debug("BEGIN - el_mediador"); // userS.getTestCaseData();
	 * setMediador(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), codigoMediador, //
	 * userS.getTestCaseData().getTestID()) != null ? // Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), codigoMediador, // userS.getTestCaseData().getTestID())) : null);
	 * logger.debug("END - el_mediador");
	 *
	 * }
	 *
	 * // //@Dado("^el medio de pago es \"([^\"]*)\"$") public void el_medio_de_pago_es( String medioPago) {
	 * logger.debug("BEGIN - el_medio_de_pago_es"); // userS.getTestCaseData().setMedioPago( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), medioPago, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - el_medio_de_pago_es"); }
	 *
	 * // //@
	 * Dado("^la cobertura opcional de rotura de maquinaria para la opción: \"([^\"]*)\" por un valor de \"([^\"]*)\" euros$"
	 * ) public void la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opcion_por_un_valor_de_euros( String
	 * coberturaMaquinariaTipo, String coberturaMaquinariaValor) { logger.
	 * debug("BEGIN - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros" );
	 * userS.getTestCaseData(). setCoberturaOpcionalMaquinaHerramientaIncluida(ProjectConstants.
	 * CoberturaOpcionalncluida); logger.
	 * debug("END - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros" ); }
	 *
	 * //@ Dado("^la cobertura de accidentes personales de empleados para un empleado$" ) public void
	 * anado_la_cobertura_de_accidentes_personales_de_empleados_para_un_empleado () { logger.
	 * debug("BEGIN - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opcion_por_un_valor_de_euros" );
	 * userS.getTestCaseData() .setCoberturaOpcionalAccidentesPersonalesEmpleadosIncluida(
	 * ProjectConstants.CoberturaOpcionalncluida); logger.
	 * debug("END - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros" ); }
	 *
	 * //@
	 * Dado("^la cobertura de rotura de instalaciones de energía solar para \"([^\"]*)\" por un valor de \"([^\"]*)\"$"
	 * ) public void anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de( String
	 * descripcion, String valor) { logger.
	 * debug("BEGIN - anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de" );
	 * userS.getTestCaseData(). setCoberturaOpcionalInstalacionesFotovoltaicasIncluida(ProjectConstants.
	 * CoberturaOpcionalncluida); logger.
	 * debug("END - anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de" ); }
	 *
	 * //@Dado("^la clausula \"([^\"]*)\"$") public void añado_la_clausula_hipotecaria( String clausula) {
	 * userS.getTestCaseData().setModificarClausulas( ProjectConstants.ModificarClausulas);
	 * userS.getTestCaseData().setClausulas( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), clausula,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^le incluyo la clausula \"([^\"]*)\"$") public void le_añado_la_clausula( String clausula) {
	 * userS.getTestCaseData().setModificarClausulas( ProjectConstants.ModificarClausulas);
	 * userS.getTestCaseData().setClausulas( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), clausula,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^le incluyo una clausula hipotecaria$") public void le_añado_una_clausula_hipotecaria() {
	 * userS.getTestCaseData().setClausulaHipotecaria(true); }
	 *
	 * //@Dado("^el asegurado es diferente del tomador$") public void el_asegurado_es_diferente_del_tomador() {
	 * userS.getTestCaseData(). setAseguradoPrincipalDiferenteDelTomador(ProjectConstants.
	 * AseguradoPrincipalDiferenteTomador); }
	 *
	 * //@Dado("^el tomador es \"([^\"]*)\"$") public void el_tomador( String tomador) {
	 * logger.debug("BEGIN - el_tomador"); logger.debug("END - el_tomador"); }
	 *
	 * // //@Dado("^el tipo de persona es \"([^\"]*)\"$") public void tipo_de_persona( String tipo) {
	 * logger.debug("BEGIN - tipo_de_persona"); userS.getTestCaseData().setTipoPersona(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), tipo, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - tipo_de_persona"); }
	 *
	 * //@Dado("^el documento de tomador es aleatoreo$") public void el_documento_tomador_es_aleatoreo() {
	 * userS.getTestCaseData().setTomadorDocumento( DniGeneratorHelper.generaNif(null)); }
	 *
	 * //@Dado("^el documento de tomador es \"([^\"]*)\"$") public void documento_tomador( String documento) {
	 * logger.debug("BEGIN - documento_tomador"); userS.getTestCaseData().setTomadorDocumento(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), documento, userS.getTestCaseData().getTestID()));
	 * logger.debug("BEGIN - documento_tomador"); }
	 *
	 * //@Dado("^el nombre de tomador es \"([^\"]*)\"$") public void nombre_tomador( String nombre) {
	 * logger.debug("BEGIN - nombre_tomador"); // userS.getTestCaseData().setTomadorNombre( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombre, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - nombre_tomador"); }
	 *
	 * //@Dado("^el primer apellido de tomador es \"([^\"]*)\"$") public void primer_apellido_tomador( String apellido)
	 * { logger.debug("BEGIN - primer_apellido_tomador"); // userS.getTestCaseData().setTomadorPrimerApellido( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), apellido, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - primer_apellido_tomador"); }
	 *
	 * //@Dado("^la provincia es \"([^\"]*)\"$") public void provincia( String provincia) {
	 * logger.debug("BEGIN - provincia_tomador"); // userS.getTestCaseData().setProvincia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), provincia, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_tomador"); }
	 *
	 * //@Dado("^la poblacion es \"([^\"]*)\"$") public void poblacion( String poblacion) {
	 * logger.debug("BEGIN - poblacion_tomador"); // userS.getTestCaseData().setPoblacion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), poblacion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_tomador"); }
	 *
	 * //@Dado("^la via es \"([^\"]*)\"$") public void direccion( String direccion) {
	 * logger.debug("BEGIN - direccion_tomador"); // userS.getTestCaseData().setNombreVia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), direccion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_tomador"); }
	 *
	 * //@Dado("^el numero de portal es \"([^\"]*)\"$") public void numero_portal( String numero) {
	 * logger.debug("BEGIN - numero_portal_tomador"); // userS.getTestCaseData().setNumVia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), numero, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - numero_portal_tomador"); }
	 *
	 * //@Dado("^la provincia de tomador es \"([^\"]*)\"$") public void provincia_tomador( String provincia) {
	 * logger.debug("BEGIN - provincia_tomador"); // userS.getTestCaseData().setTomadorProvincia( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), provincia, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_tomador"); }
	 *
	 * //@Dado("^la poblacion de tomador es \"([^\"]*)\"$") public void poblacion_tomador( String poblacion) {
	 * logger.debug("BEGIN - poblacion_tomador"); // userS.getTestCaseData().setTomadorPoblacion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), poblacion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_tomador"); }
	 *
	 * //@Dado("^la direccion de tomador es \"([^\"]*)\"$") public void direccion_tomador( String direccion) {
	 * logger.debug("BEGIN - direccion_tomador"); // userS.getTestCaseData().setTomadorDireccion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), direccion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_tomador"); }
	 *
	 * //@Dado("^el numero de portal de tomador es \"([^\"]*)\"$") public void numero_portal_tomador( String numero) {
	 * logger.debug("BEGIN - numero_portal_tomador"); // userS.getTestCaseData().setTomadorNumeroPortal( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), numero, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - numero_portal_tomador"); }
	 *
	 * //@Dado("^la fecha de nacimiento de tomador es \"([^\"]*)\"$") public void fecha_nacimiento_tomador( String
	 * fecha) { logger.debug("BEGIN - fecha_nacimiento_tomador"); // userS.getTestCaseData().setTomadorFechaNacimiento(
	 * // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), fecha, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - fecha_nacimiento_tomador"); }
	 *
	 * //@Dado("^los teléfonos y los horarios de atención del tomador$") public void
	 * añado_los_teléfonos_del_tomador_y_los_horarios_de_atención() { userS.getTestCaseData().
	 * setIncluirTelefonosYHorarioAtencionTomador(ProjectConstants. TelefonosTomadorIncluidos); }
	 *
	 * //@Dado("^subo un fichero$") public void subo_un_fichero() { userS.getTestCaseData().setAddFile(true); }
	 *
	 * //@Dado("^la modalidad \"([^\"]*)\"$") public void la_modalidad( String modalidad) {
	 * logger.debug("BEGIN - la_modalidad");
	 *
	 * logger.debug("END - la_modalidad"); }
	 *
	 * //@Dado("^la referencia catastral \"([^\"]*)\"$") public void la_referencia_catastral( String
	 * referenciaCatastral) { logger.debug("BEGIN - la_referencia_catastral"); //
	 * userS.getTestCaseData().setReferenciaCatastral( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), //
	 * referenciaCatastral, userS.getTestCaseData().getTestID())); logger.debug("END - la_referencia_catastral"); }
	 *
	 * //@Dado("^selecciono como número de plantas en alto \"([^\"]*)\"$") public void
	 * selecciono_como_número_de_plantas_en_alto( String NumPlantasAlto) {
	 * logger.debug("BEGIN - selecciono_como_número_de_plantas_en_alto");
	 * logger.debug("END - selecciono_como_número_de_plantas_en_alto"); }
	 *
	 * //@Dado("^selecciono como número de plantas de sotano \"([^\"]*)\"$") public void
	 * selecciono_como_número_de_plantas_de_sotano( String NumPlantasSotano) {
	 * logger.debug("BEGIN - selecciono_como_número_de_plantas_de_sotano");
	 * logger.debug("END - selecciono_como_número_de_plantas_de_sotano"); }
	 *
	 * //@Dado("^el número de cotización \"([^\"]*)\"$") public void el_numero_de_cotizacion( String noCotizacion) {
	 * logger.debug("BEGIN - el_número_de_cotización"); // userS.getTestCaseData().setNoCotizacion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), noCotizacion, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - el_número_de_cotización"); }
	 *
	 * //@Dado("^el número de viviendas es \"([^\"]*)\"$") public void el_número_de_viviendas_es( String
	 * numeroViviendas) { logger.debug("BEGIN - el_número_de_viviendas_es"); // userS.getTestCaseData() //
	 * .setNumeroViviendas(getValuesDataSet(userS.getTestCaseData( ).gethMapDataSet(), numeroViviendas, //
	 * userS.getTestCaseData().getTestID()) != null // ? Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), numeroViviendas, // userS.getTestCaseData().getTestID())) // : null);
	 * logger.debug("END - el_número_de_viviendas_es"); }
	 *
	 * //@Dado("^el número de locales es \"([^\"]*)\"$") public void el_número_de_locales_es( String numeroLocales) {
	 * logger.debug("BEGIN - el_número_de_locales_es"); // userS.getTestCaseData() //
	 * .setNumeroLocalesComerciales(getValuesDataSet(userS. getTestCaseData().gethMapDataSet(), numeroLocales, //
	 * userS.getTestCaseData().getTestID()) != null ? // Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), numeroLocales, // userS.getTestCaseData().getTestID())) // : null);
	 * logger.debug("END - el_número_de_locales_es");
	 *
	 * }
	 *
	 * //@Dado("^el valor de m2 viviendas es '(\\d+)'$") public void el_valor_de_m_viviendas_es( String m2Viviendas) {
	 * logger.debug("BEGIN - el_valor_de_m_viviendas_es"); userS.getTestCaseData().setM2Vivienda(m2Viviendas);
	 * logger.debug("END - el_valor_de_m_viviendas_es"); }
	 *
	 * //@Dado("^el valor de m2 zonas ajardinadas es '(\\d+)'$") public void el_valor_de_m_zonas_ajardinadas_es( String
	 * m2ZonasAjardinadas) { }
	 *
	 * //@Dado("^el valor de m2 oficinas es '(\\d+)'$") public void el_valor_de_m_oficinas_es( String m2Oficinas) { }
	 *
	 * //@Dado("^el valor de m2 garajes es '(\\d+)'$") public void el_valor_de_m_garajes_es( String m2Garajes) {
	 * logger.debug("BEGIN - el_valor_de_m_garajes_es"); userS.getTestCaseData().setM2Garajes(m2Garajes);
	 * logger.debug("END - el_valor_de_m_garajes_es"); }
	 *
	 * //@Dado("^el año de construcción del edificio es \"([^\"]*)\"$") public void
	 * el_año_de_construcción_del_edificio_es( String anyoConstruccion) { if
	 * (anyoConstruccion.equals(ProjectConstants.MayorDe50)) { userS.getTestCaseData().setAnyoConstruccion(
	 * ProjectConstants.MayorDe50); } else { userS.getTestCaseData().setAnyoConstruccion(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), anyoConstruccion,
	 * userS.getTestCaseData().getTestID())); } }
	 *
	 * //@Dado("^el número de poliza \"([^\"]*)\"$") public void el_número_de_poliza( String noPoliza) { //
	 * userS.getTestCaseData().setNumPoliza(Integer.parseInt( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), noPoliza, userS.getTestCaseData().getTestID()))); }
	 *
	 * //@Dado("^fecha de siniestro es \"([^\"]*)\"$") public void fecha_siniestro_es( String fecha) {
	 * userS.getTestCaseData().setFechaSiniestro( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), fecha,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^causa de siniestro es \"([^\"]*)\"$") public void causa_siniestro_es( String causa) {
	 * userS.getTestCaseData().setCausaSiniestro( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), causa,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^rol de la persona de contacto es \"([^\"]*)\"$") public void rol_persona_contacto_es( String rol) {
	 * userS.getTestCaseData().setRolPersonaContacto( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), rol,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^nombre de la persona de contacto es \"([^\"]*)\"$") public void nombre_persona_contacto_es( String
	 * nombre) { userS.getTestCaseData().setNombrePersonaContacto(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombre, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^apellido de la persona de contacto es \"([^\"]*)\"$") public void apellido_persona_contacto_es( String
	 * apellido) { userS.getTestCaseData().setApellidoPersonaContacto(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), apellido, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^telefono de la persona de contacto es \"([^\"]*)\"$") public void telefono_persona_contacto_es( String
	 * telefono) { userS.getTestCaseData().setTelefonoPersonaContacto(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), telefono, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^descripcion de siniestro es \"([^\"]*)\"$") public void descripcion_siniestro_es( String descripcion) {
	 * userS.getTestCaseData().setDescripcionSiniestro( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * descripcion, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Cuando("^con el número de poliza$") public void con_el_número_de_poliza() { DatosBancariosPage
	 * datosBancariosPage = new DatosBancariosPage(userS); userS.getTestCaseData().setNumPoliza(datosBancariosPage.
	 * GetPolizaNumber()); }
	 *
	 * //@Cuando("^cambio el medio de pago a \"([^\"]*)\"$") public void cambio_el_medio_de_pago_a( String medioPago) {
	 * logger.debug("BEGIN - cambio_el_medio_de_pago_a"); // userS.getTestCaseData().setCambioMedioPago( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), medioPago, userS.getTestCaseData().getTestID()));
	 * logger.debug("END - cambio_el_medio_de_pago_a"); }
	 *
	 * //@Cuando("^cambio la referencia catastral por \"([^\"]*)\"$") public void cambio_la_referencia_catastral_por(
	 * String referenciaCatastral) { logger.debug("BEGIN - cambio_la_referencia_catastral_por");
	 * userS.getTestCaseData().setModifiedReferenciaCatastral(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), referenciaCatastral,
	 * userS.getTestCaseData().getTestID())); logger.debug("END - cambio_la_referencia_catastral_por"); }
	 *
	 * //@Cuando("^cambio el número de viviendas a \"([^\"]*)\"$") public void modifico_el_numero_de_viviendas_a( String
	 * numeroViviendas) { logger.debug("BEGIN - cambio_el_numero_de_viviendas_a"); //
	 * userS.getTestCaseData().setNumeroViviendas(Integer.parseInt
	 * (getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), // numeroViviendas,
	 * userS.getTestCaseData().getTestID()))); // userS.getTestCaseData().setNumeroViviendas(numeroViviendas) ;
	 * logger.debug("END - cambio_el_numero_de_viviendas_a("); }
	 *
	 * //@Cuando("^cambio el número de edificios a \"([^\"]*)\"$") public void cambio_el_numero_de_edificios_a( String
	 * numeroEdificios) { logger.debug("BEGIN - cambio_el_numero_de_edificios_a"); //
	 * userS.getTestCaseData().setNumeroEdificios(numeroEdificios) ; //
	 * userS.getTestCaseData().setNumeroEdificios(Integer.parseInt
	 * (getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), // numeroEdificios,
	 * userS.getTestCaseData().getTestID()))); logger.debug("END - cambio_el_numero_de_edificios_a("); }
	 *
	 * //@Cuando("^cambio el número de locales a \"([^\"]*)\"$") public void modifico_el_número_de_locale_s_a( String
	 * numeroLocales) {
	 *
	 * logger.debug("BEGIN - modifico_el_número_de_locale_s_a"); //
	 * userS.getTestCaseData().setNumeroLocalesComerciales(Integer .parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), // numeroLocales, userS.getTestCaseData().getTestID())));
	 * logger.debug("END - modifico_el_número_de_locale_s_a(");
	 *
	 * }
	 *
	 * //@Cuando("^cambio los valores de m2 viviendas a \"([^\"]*)\"$") public void cambio_los_valores_de_m_viviendas_a(
	 * String m2Viviendas) { userS.getTestCaseData() .setModifiedM2Viviendas(getValuesDataSet(userS.
	 * getTestCaseData().gethMapDataSet(), m2Viviendas, userS.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), m2Viviendas,
	 * userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de m2 zonas ajardinadas a \"([^\"]*)\"$") public void
	 * cambio_los_valores_de_m_zonas_ajardinadas_a( String m2ZonasAjardinadas) { userS.getTestCaseData()
	 * .setModifiedM2ZonasAjardinadas(getValuesDataSet(userS. getTestCaseData().gethMapDataSet(), m2ZonasAjardinadas,
	 * userS.getTestCaseData().getTestID()) != null ? Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), m2ZonasAjardinadas, userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de  m2 oficinas a \"([^\"]*)\"$") public void cambio_los_valores_de_m_oficinas_a(
	 * String m2Oficinas) { userS.getTestCaseData() .setModifiedM2Oficinas(getValuesDataSet(userS.
	 * getTestCaseData().gethMapDataSet(), m2Oficinas, userS.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), m2Oficinas,
	 * userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de m2 garajes a \"([^\"]*)\"$") public void cambio_los_valores_de_m_garajes_a(
	 * String m2Garajes) { // Write code here that turns the phrase above into concrete actions
	 * userS.getTestCaseData().setModifiedM2Garajes( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * m2Garajes, userS.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), m2Garajes,
	 * userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio el año construcción a \"([^\"]*)\"$$") public void cambio_el_anyo_construccion_a( String
	 * anyoConstruccion) { // userS.getTestCaseData().setAnyoConstruccion(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), // anyoConstruccion,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@ Cuando("^modifico el año de rehabilitacion de conducciones comunitarias a \"([^\"]*)\"$" ) public void
	 * se_modifica_el_año_de_rehabilitacion_de_conducciones_comunitarias( Integer anyoRehabilicion) { //
	 * userS.getTestCaseData(). setAnyoRehabilitacionConstruccionesComunitarias(anyoRehabilicion); }
	 *
	 * //@ Cuando("^selecciono como nivel de rehabilitación de conducciones de aguas comunitarias \"([^\"]*)\"$" )
	 * public void se_selecciona_como_nivel_de_rehabilitación_de_conducciones_de_aguas_comunitarias( String
	 * nivelRehabilitacion) { // userS.getTestCaseData().
	 * setNivelRehabilitacionConduccionesAguasComunitarias(nivelRehabilitacion); }
	 *
	 * //@Cuando("^se modifica el año de rehabiliación integral a '(\\d+)'$") public void
	 * se_modifica_el_año_de_rehabiliación_integral_a( Integer anyoRehabilitacionIntegral) {
	 * userS.getTestCaseData().setAnyoRehabilitacionIntegral( anyoRehabilitacionIntegral); }
	 *
	 * //@Cuando("^selecciono Hay una gasolinera a menos de '(\\d+)'$") public void
	 * selecciono_Hay_una_gasolinera_a_menos_de_m( int arg1) { userS.getTestCaseData().setGasolineraMenos50M(true); }
	 *
	 * //@Cuando("^le agrego \"([^\"]*)\" como motivo del suplemento$") public void
	 * le_agrego_como_motivo_del_suplemento( String motivoSuplemento) {
	 * MotivosSuplementoHelper.addMotivosSuplementos(motivoSuplemento, true)
	 * userS.getTestCaseData().setMotivosSuplemento(true, motivoSuplemento); }
	 *
	 * //@Cuando("^le quito \"([^\"]*)\" como motivo del suplemento$") public void le_quito_como_motivo_del_suplemento(
	 * String motivoSuplemento) { userS.getTestCaseData().setMotivosSuplemento(false, motivoSuplemento); }
	 *
	 * //@Cuando("^selecciono como tomador \"([^\"]*)\"$") public void selecciono_como_tomador( String tomador) { //
	 * userS.getTestCaseData().setTomador( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), tomador,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Cuando("^se modifica el año de construcción a \"([^\"]*)\"$") public void se_modifica_el_año_de_construcción(
	 * String anyoConstruccion) { userS.getTestCaseData().setAnyoConstruccion( anyoConstruccion); }
	 *
	 * //@Cuando("^se excluyen los garajes$") public void se_excluyen_los_garajes() {
	 * userS.getTestCaseData().setExcluirGarajes(true); }
	 *
	 * //@Cuando("^se excluyen los locales$") public void se_excluyen_los_locales() {
	 * userS.getTestCaseData().setExcluirLocales(true); }
	 *
	 * //@Cuando("^se modifica la calidad de construcción por \"([^\"]*)\"$") public void
	 * se_modifica_la_calidad_de_construcción_por( String calidadConstruccion) {
	 * userS.getTestCaseData().setCalidadConstruccion( calidadConstruccion); }
	 *
	 * ////@Dado("^cambio la modalidad a \"([^\"]*)\"$") public void cambio_la_modalidad_a( String modalidad) { //
	 * userS.getTestCaseData().setModalidad(modalidad); }
	 *
	 * //@Dado("^la deshabilitación es \"([^\"]*)\"$") public void la_deshabilitación_es( String deshabilitacion) {
	 * userS.getTestCaseData().setDeshabilitacion(deshabilitacion) ; }
	 *
	 * //@ Dado("^el porcentaje de edificio construido en madera es \"([^\"]*)\"$") public void
	 * el_porcentaje_de_edificio_construido_en_madera_es( String porcentajeMadera) {
	 * userS.getTestCaseData().setEdificioMadera(porcentajeMadera) ; }
	 *
	 * //@Dado("^el capital continente se reduce en \"([^\"]*)\"$") public void el_capital_continente_se_reduce_en(
	 * String capitalContinente) { userS.getTestCaseData().setCapitalContinenteVariacion(true) ; userS.getTestCaseData()
	 * .setCapitalContinente(getValuesDataSet(userS. getTestCaseData().gethMapDataSet(), capitalContinente,
	 * userS.getTestCaseData().getTestID()) != null ? Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), capitalContinente, userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Dado("^el capital continente se incrementa en \"([^\"]*)\"$") public void
	 * el_capital_continente_se_incrementa_en( String capitalContinente) {
	 * userS.getTestCaseData().setCapitalContinenteVariacion(true) ; userS.getTestCaseData()
	 * .setCapitalContinente(getValuesDataSet(userS. getTestCaseData().gethMapDataSet(), capitalContinente,
	 * userS.getTestCaseData().getTestID()) != null ? Integer.parseInt(getValuesDataSet(userS.getTestCaseData().
	 * gethMapDataSet(), capitalContinente, userS.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Dado("^añado una franquicia voluntaria de \"([^\"]*)\"$") public void añado_una_franquicia_voluntaria_de(
	 * String franquiciaVoluntaria) { // userS.getTestCaseData().setFranquiciaVoluntaria(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), // franquiciaVoluntaria,
	 * userS.getTestCaseData().getTestID())); // userS.getTestCaseData().setFranquiciaVoluntaria( franquiciaVoluntaria);
	 * }
	 *
	 * //@ Cuando("^se modifica el capital de franquicia voluntaria a \"([^\"]*)\"$" ) public void
	 * se_modifica_el_capital_de_franquicia_voluntaria_a( String franquiciaVoluntaria) { //
	 * userS.getTestCaseData().setFranquiciaVoluntaria( franquiciaVoluntaria); }
	 *
	 * //@Dado("^el descuento es \"([^\"]*)\"$") public void el_descuento_es( String descuento) { //
	 * userS.getTestCaseData().setDescuento(descuento); }
	 *
	 * //@Dado("^un descuento$") public void un_descuento() { userS.getTestCaseData().setDescuentoEnabled(true); }
	 *
	 * //@Cuando("^le incluyo el recargo$") public void le_incluyo_un_recargo() {
	 * userS.getTestCaseData().setRecargo(true); }
	 *
	 * //@Cuando("^se excluye un recargo$") public void se_excluye_un_recargo() {
	 * userS.getTestCaseData().setRecargo(false); }
	 *
	 * //@Dado("^se agrega un descuento$") public void se_agrega_un_descuento() {
	 * userS.getTestCaseData().setDescuentoEnabled(true); }
	 *
	 * //@Dado("^se quita un descuento$") public void se_quita_un_descuento() {
	 * userS.getTestCaseData().setDescuentoEnabled(false); }
	 *
	 * //@Cuando("^le agrego la clausula \"([^\"]*)\"$") public void le_agrego_la_clausula( String clausula) {
	 * userS.getTestCaseData().setClausulas(clausula); }
	 *
	 * //@ Cuando("^se incluye el check de Calefacción central y/o agua caliente centralizada$" ) public void
	 * se_incluye_el_check_de_Calefacción_central_y_o_agua_caliente_centralizada () {
	 * userS.getTestCaseData().setCalefaccionCentral(true); }
	 *
	 * //@Cuando("^se incluye un deposito de combustible$") public void se_incluye_un_deposito_de_combustible() {
	 * userS.getTestCaseData().setDepositoCombustible(true); }
	 *
	 * //@Cuando("^se incrementa el capital contenido en '(\\d+)'$") public void se_incrementa_el_capital_contenido_en(
	 * Integer capitalContenido) { userS.getTestCaseData().setCapitalContenido( capitalContenido); }
	 *
	 * //@Cuando("^se reduce el capital contenido en '(\\d+)'$") public void se_reduce_el_capital_contenido_en( Integer
	 * capitalContenido) { userS.getTestCaseData().setCapitalContenido(- capitalContenido); }
	 *
	 *
	 * //@Dado("^la renta de alquiler mensual es \"([^\"]*)\"$") public void la_renta_de_alquiler_mensual_es( String
	 * rentaAlquilerMensual) { // userS.getTestCaseData() // .setRentaMensualAlquiler(getValuesDataSet(userS.
	 * getTestCaseData().gethMapDataSet(), rentaAlquilerMensual, // userS.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), rentaAlquilerMensual, //
	 * userS.getTestCaseData().getTestID())) // : null); }
	 *
	 * //@Dado("^con ingresos \"([^\"]*)\"$") public void con_ingresos( String ingresos) { //
	 * userS.getTestCaseData().setIngresosNetosInquilino( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * ingresos, userS.getTestCaseData().getTestID()) != null // ? Integer.parseInt( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), ingresos, userS.getTestCaseData().getTestID())) // :
	 * null); }
	 *
	 * //@Dado("^suma asegurada es \"([^\"]*)\"$") public void suma_asegurada( String sumaAsegurada) { //
	 * userS.getTestCaseData().setImpagoAlquiler( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * sumaAsegurada, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^franquicia es \"([^\"]*)\"$") public void franquiciaMAC( String franquiciaMAC) { //
	 * userS.getTestCaseData().setFranquiciaMAC( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * franquiciaMAC, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^los ingresos aval \"([^\"]*)\"$") public void los_ingresos_aval( String ingresosAval) { //
	 * userS.getTestCaseData() // .setIngresosAval(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(),
	 * ingresosAval, // userS.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), ingresosAval, //
	 * userS.getTestCaseData().getTestID())) // : null); }
	 *
	 * //@Dado("^el documento aleatoreo$") public void el_documento_aleatoreo() {
	 * userS.getTestCaseData().setDocumentoInquilino( DniGeneratorHelper.generaNif(null)); }
	 *
	 * //@Dado("^el documento \"([^\"]*)\"$") public void el_documento( String documento) { //
	 * userS.getTestCaseData().setDocumentoInquilino( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * documento, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el documento aval \"([^\"]*)\"$") public void el_documento_aval( String documentoAval) { //
	 * userS.getTestCaseData().setDocumentoAval( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * documentoAval, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre del inquilino \"([^\"]*)\"$") public void el_nombre_del_inquilino( String nombre) { //
	 * userS.getTestCaseData().setNombreInquilino( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombre,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre de aval \"([^\"]*)\"$") public void el_nombre_de_aval( String nombreAval) { //
	 * userS.getTestCaseData().setNombreAval( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombreAval,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("el primer apellido del inquilino \"([^\"]*)\"$") public void el_primer_apellido_del_inquilino( String
	 * apellido) { // userS.getTestCaseData().setPrimerApellidoInquilino( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), apellido, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("el primer apellido del aval \"([^\"]*)\"$") public void el_primer_apellido_del_aval( String
	 * apellidoAval) { // userS.getTestCaseData().setPrimerApellidoAval( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), apellidoAval, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^situacion laboral \"([^\"]*)\"$") public void situacion_laboral( String situacionLaboralInquilino) { //
	 * userS.getTestCaseData().setSituacionLaboralInquilino( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * // situacionLaboralInquilino, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^parentesco aval \"([^\"]*)\"$") public void parentesco_aval( String parentesco) { //
	 * userS.getTestCaseData().setParentescoAval( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * parentesco, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^situacion laboral aval \"([^\"]*)\"$") public void situacion_laboral_aval( String situacionLaboralAval)
	 * { // userS.getTestCaseData().setSituacionLaboralInquilino(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), // situacionLaboralAval,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el acceso \"([^\"]*)\"$") public void inicializo_acceso( String loginAccess) { // Access //
	 * userS.getTestCaseData().setAcceso( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), loginAccess,
	 * userS.getTestCaseData().getTestID())); // userS.InitializeVariables(userS. getTestCaseData().getAcceso()); }
	 *
	 * //@Dado("^el usuario \"([^\"]*)\"$") public void inicializo_usuario( String user) {
	 * System.out.println(userS.getFeature()); // User userS.getTestCaseData().setUsuario(
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), user, userS.getTestCaseData().getTestID()));
	 *
	 * // userS.applicationAccessHelper.Login(userS. getTestCaseData().getUsuario(), //
	 * userS.GetProperties().passwordComun); }
	 *
	 * //@Dado("^el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$") public void inicializo_acceso_y_usuario( String
	 * loginAccess, String user) { // Access // this.inicializo_acceso(loginAccess = this.userS.getTestVar("acceso"));
	 * // User // this.inicializo_usuario(user); }
	 *
	 * //@Dado("^el filtro de busqueda \"([^\"]*)\"$") public void inicializo_filtro_busqueda( String filtroBuscador) {
	 * userS.getTestCaseData().setFiltroBuscadorEdificio( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * filtroBuscador, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nivel estructura es \"([^\"]*)\"$") public void nivel_estructura( String nivelEstructura) { //
	 * userS.getTestCaseData().setNivelEstructura( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * nivelEstructura, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^tipo prospect es \"([^\"]*)\"$") public void tipo_prospect( String tipoProspect) { //
	 * userS.getTestCaseData().setTipoProspect( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * tipoProspect, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el tipo mediador es \"([^\"]*)\"$") public void tipo_mediador( String tipoMediador) { //
	 * userS.getTestCaseData().setTipoProspect( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * tipoProspect, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^numero registro DGS es \"([^\"]*)\"$") public void numero_resigtro_dgs( String dgs) { //
	 * userS.getTestCaseData() // .setDgs(getValuesDataSet(userS.getTestCaseData(). gethMapDataSet(), dgs,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^la actividad principal es \"([^\"]*)\"$") public void actividad_principal( String actividadPrincipal) {
	 * // userS.getTestCaseData().setActividadPrincipal( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), //
	 * actividadPrincipal, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^nombre comercial prospect es \"([^\"]*)\"$") public void nombre_comercial_prospect( String
	 * nombreComercialProspect) { // userS.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombreComercial,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre fiscal mediador es \"([^\"]*)\"$") public void nombre_fiscal_prospect( String
	 * nombreFiscalProspect) { // userS.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombreComercial,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el primer apellido mediador es \"([^\"]*)\"$") public void primer_apellido_mediador( String
	 * primerApellidoMediador) { // userS.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombreComercial,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el segundo apellido mediador es \"([^\"]*)\"$") public void segundo_apellido_mediador( String
	 * segundoApellidoMediador) { // userS.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), nombreComercial,
	 * userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^contacto responsable es \"([^\"]*)\"$") public void contacto_responsable( String contactoResponsable) {
	 * // userS.getTestCaseData().setContactoResponsable( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), //
	 * contactoResponsable, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^idioma es \"([^\"]*)\"$") public void idioma( String idioma) { // userS.getTestCaseData().setIdioma( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), idioma, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^telefono principal es \"([^\"]*)\"$") public void telefono_principal( String tlfPrincipal) { //
	 * userS.getTestCaseData().setTlfPrincipal( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(),
	 * tlfPrincipal, userS.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^ejecutivo comercial es \"([^\"]*)\"$") public void ejecutivo_comercial( String ejecutivoComercial) { //
	 * userS.getTestCaseData().setEjecutivoComercial( getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), //
	 * ejecutivoComercial, userS.getTestCaseData().getTestID())); }
	 *
	 * //@ Dado("^el usuario da de alta un proyecto en GO y lo guarda sin contratar$" ) public void
	 * el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar( String loginAcess, String user) { logger.
	 * debug("BEGIN - el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar" );
	 *
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * { userS.initializeVariables(loginAcess); userS.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), userS.getProperties().passwordComun);
	 *
	 * String mediador = this.tCData.getMediador(); if (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine) && this.tCData != null && !mediador.equals("640")) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(userS); asignarMediadorPage.selectMediadorAndClickOnContinuar(); }
	 * else if (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessInnova)) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador( ).toString());
	 * asignarMediadorPage.clickOnContinuarButton(); }
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.clickOnContinuar(); PrecioPage precioPage = new
	 * PrecioPage(webDriver, userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador()); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado(); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarGuardar(); userS.writeTestCaseData(); logger.
	 * debug("END - el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar" ); }
	 *
	 * }
	 *
	 * //@Dado("^se inicia un proyecto con modalidad \"([^\"]*)\"$") public void se_inicia_un_proyecto_con_modalidad(
	 * String Modalidad) {
	 *
	 * // Login userS.initializeVariables(this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndCreateProjectMAC(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * if (this.userS.getTestVar("acceso").equals("GestionOnline")) { GestionOnlineHomePage gestionOnlineHomePage = new
	 * GestionOnlineHomePage(userS); gestionOnlineHomePage.openMutuaAlquilerConfort(); } else if
	 * (this.userS.getTestVar("acceso").equals("Innova")) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager());
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar(); }
	 *
	 * // Seleccionar modalidad en Precio page PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); precioPorModalidadPage_MAC.selectModalidad(); }
	 *
	 *
	 *
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////////////////////////////////////////////////////////// ///// ACTION STEPS
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 *
	 *
	 * public ActionsSteps(BrowserContext browserContext) { userS = browserContext; this.tCData =
	 * userS.getTestCaseData(); }
	 *
	 * //@Cuando("^agrego un suplemento$") public void agrego_un_suplemento() { // Login
	 * userS.initializeVariables(this.userS.getTestVar("acceso")); userS.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), userS.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.AddSuplementoGeneral(); AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager()); asignarMediadorPage.clickOnContinuarButton();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton(); UbicacionRiesgoPage ubicacionRiesgoPage =
	 * new UbicacionRiesgoPage(userS); ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
	 * ubicacionRiesgoPage.editCalidadConstruccion(); ubicacionRiesgoPage.clickOnContinuar();
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate (); DatosBasicosTomadorPage
	 * datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar(); }
	 *
	 * //@Cuando("^agrego el motivo suplemento \"([^\"]*)\"$") public void agrego_el_motivo_suplemento( String
	 * motivoSuplemento) { userS.getTestCaseData().setMotivosSuplemento(true, motivoSuplemento); ConfirmarPolizaPage
	 * confirmarPolizaPage = new ConfirmarPolizaPage(userS); //
	 * confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
	 * confirmarPolizaPage.ActivateMotivosSuplemento(); }
	 *
	 * //@Cuando("^emito el suplemento$") public void emito_el_suplemento() { ConfirmarPolizaPage confirmarPolizaPage =
	 * new ConfirmarPolizaPage(userS); // confirmarPolizaPage.ActivateMotivosSuplemento();
	 * confirmarPolizaPage.ClickOnContinuar(); ValidacionExcepcionesReglasConfirmarPoliza
	 * validacionExcepcionesReglasConfirmarPoliza = new ValidacionExcepcionesReglasConfirmarPoliza( userS);
	 * validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton(); DatosBancariosPage datosBancariosPage = new
	 * DatosBancariosPage(webDriver, userS.getTestDataManager()); datosBancariosPage.ClickOnEmitirSuplemento(); }
	 *
	 * //@Cuando("^emito un suplemento general con motivo \"([^\"]*)\"$") public void
	 * emito_un_suplemento_general_con_motivo( String motivoSuplemento) {
	 *
	 * // Login userS.initializeVariables(this.userS.getTestVar("acceso")); userS.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), userS.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * // this.tCData.setSuplemento(true); GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(webDriver, userS.getTestDataManager());
	 * gestionPolizasBuscadorPage.AddSuplementoGeneral(); AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager()); asignarMediadorPage.clickOnContinuarButton();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton(); UbicacionRiesgoPage ubicacionRiesgoPage =
	 * new UbicacionRiesgoPage(userS); ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
	 * ubicacionRiesgoPage.editCalidadConstruccion(); ubicacionRiesgoPage.clickOnContinuar();
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate (); DatosBasicosTomadorPage
	 * datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * userS.getTestCaseData().setMotivosSuplemento(true, motivoSuplemento); ConfirmarPolizaPage confirmarPolizaPage =
	 * new ConfirmarPolizaPage(userS); confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
	 * ValidacionExcepcionesReglasConfirmarPoliza validacionExcepcionesReglasConfirmarPoliza = new
	 * ValidacionExcepcionesReglasConfirmarPoliza( userS);
	 * validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton(); DatosBancariosPage datosBancariosPage = new
	 * DatosBancariosPage(webDriver, userS.getTestDataManager()); // DocumentacionPage documentacionPage = new
	 * DocumentacionPage(userS); // documentacionPage.SubirFichero(); datosBancariosPage.ClickOnEmitirSuplemento(); //
	 * MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(webDriver,
	 * userS.getTestDataManager()); // mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly(); }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion y la convierto en una contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_una_simulacion_y_la_convierto_en_una_contratacion_usando_el_acceso_y_el_usuario( String
	 * loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * // Asignar mediador AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate (); PrecioPage precioPage = new
	 * PrecioPage(webDriver, userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this. tCData.getTomador());
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS);
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage(); ValidacionExcepcionesReglasPage
	 * validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado(); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarContratar();
	 *
	 * userS.writeTestCaseData(); userS.getWebDriver().quit(); }
	 *
	 * //@Cuando("^se modifica el proyecto en Innova y lo guarda de nuevo$") public void
	 * se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo( String loginAcess, String user) { loginAcess =
	 * this.tCData.getCambioAcceso();
	 *
	 * logger. debug("BEGIN - se modifica el proyecto en Innov@ y lo guarda de nuevo");
	 * userS.initializeVariables(loginAcess); userS.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getCambioUsuario(), userS.getProperties().passwordComun, this.tCData.getNoCotizacion());
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscacorPage.modificarProjecto(); AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager()); asignarMediadorPage.clickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(webDriver, userS.getTestDataManager());
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup(); ubicacionRiesgoPage.modifyReferenciaCatastral();
	 * ubicacionRiesgoPage.clickOnContinuar(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasPage
	 * validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS); datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver, userS.getTestDataManager());
	 * precioPorModalidadPage.seleccionarModalidad(); precioPorModalidadPage.clickOnContinuar();
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 * datosBancariosPage.ClickOnGuardar(); userS.writeTestCaseData(); userS.getWebDriver().quit(); logger.
	 * debug("END - se modifica el proyecto en Innov@ y lo guarda de nuevo");
	 *
	 * }
	 *
	 * //@ Cuando("^cambio la cotización usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * modifico_la_cotización( String loginAcess, String user) {
	 *
	 * // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess, // this.tCData.getTestID());
	 * loginAcess = this.tCData.getCambioAcceso();
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { logger.debug("BEGIN - modifico_la_cotización");
	 * userS.initializeVariables(loginAcess); userS.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getCambioUsuario(), userS.getProperties().passwordComun, this.tCData.getNoCotizacion());
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscacorPage.modificarProjecto(); AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager()); asignarMediadorPage.clickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(webDriver, userS.getTestDataManager());
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup(); ubicacionRiesgoPage.modifyReferenciaCatastral();
	 * ubicacionRiesgoPage.clickOnContinuar(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); //
	 * this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasPage
	 * validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS); datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver, userS.getTestDataManager());
	 * precioPorModalidadPage.seleccionarModalidad(); precioPorModalidadPage.clickOnContinuar();
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 * datosBancariosPage.modificarFormaPagoYPulsarContratar(); userS.writeTestCaseData(); //
	 * userS.getWebDriver().quit(); logger.debug("END - modifico_la_cotización"); } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion y convierto esta simulacion a un projecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * )
	 *
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion, y la convierto a un proyecto, y la guardo sin contratar usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_una_simulacion_y_la_convierto_a_un_proyecto_y_la_guardo_sin_contratar_usando( String
	 * loginAcess, String user) {
	 *
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * logger. debug("BEGIN - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando"
	 * ); if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * String mediador = this.tCData.getMediador(); if (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine) && this.tCData != null && !mediador.equals("640")) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(userS); asignarMediadorPage.selectMediadorAndClickOnContinuar(); }
	 * else if (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessInnova)) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador( ).toString());
	 * asignarMediadorPage.clickOnContinuarButton(); }
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); //
	 * this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.clickOnContinuar(); PrecioPage precioPage = new
	 * PrecioPage(webDriver, userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador()); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado(); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarGuardar(); userS.writeTestCaseData(); logger.
	 * debug("END - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando" ); }
	 *
	 * }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion que llega hasta la pantalla de detalles de riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 *
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); // this.detallesRiesgoPage.
	 * ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar(); } }
	 *
	 * //@
	 * Cuando("^doy de alta un proyecto que llega hasta la pantalla de detalles de riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario( String
	 * loginAcess, String user) { // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateProjectMEC(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun); AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate ();
	 *
	 * PrecioPage precioPage = new PrecioPage(webDriver, userS.getTestDataManager());
	 * precioPage.ClickOnConvertirAProjecto(); } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion que llega hasta la pantalla de precio usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun); AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador( ).toString());
	 * asignarMediadorPage.clickOnContinuarButton(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
	 * ubicacionRiesgoPage.clickOnContinuar(); ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate (); PrecioPage precioPage = new
	 * PrecioPage(webDriver, userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador()); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage(); }
	 *
	 * //@
	 * Cuando("^doy de alta un projecto que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) { userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateProjectMEC(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun); AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo(); ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage( userS);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate (); // PrecioPage precioPage = new
	 * PrecioPage(webDriver, userS.getTestDataManager()); // precioPage.ClickOConvertirAProjecto(); } }
	 *
	 * //@Cuando("^continuo en datos básicos del tomador$") public void continuo_en_datos_básicos_del_tomador() {
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(webDriver,
	 * userS.getTestDataManager()); datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this.
	 * tCData.getTomador()); }
	 *
	 * //@ Cuando("^lo consulto en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" )
	 * public void lo_consulto_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario( String loginAcess, String user)
	 * { userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso")); userS.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(), userS.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza())); }
	 *
	 * //@
	 * Cuando("^lo consulto por dni en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void lo_consulto_por_dni_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario( String loginAcess,
	 * String user) { userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndSearchPolizaByNifNie( this.tCData.getUsuario(),
	 * userS.getProperties().passwordComun, this.tCData.getTomadorDNI()); }
	 *
	 * //@
	 * Cuando("^Intento dar de alta una simulación que solo va a llegar hasta datos del riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void intento_dar_alta_simulacion_hasta_datos_riesgo( String loginAcess, String user) throws Exception {
	 *
	 * // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess, // this.tCData.getTestID());
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible) ||
	 * userS.getProperties().GestionOnlineDisponible.equals( ProjectConstants.GestionOnlineDisponible)) {
	 * logger.debug("BEGIN - intento_dar_alta_simulacion_hasta_datos_riesgo"); userS.initializeVariables(loginAcess);
	 * userS.applicationAccessHelper.LoginAndCreateSimulation(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun); AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador( ).toString());
	 * asignarMediadorPage.clickOnContinuarButton(); UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
	 * ubicacionRiesgoPage.clickOnContinuar(); DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); detallesRiesgoPage.completarDatosRiesgo(); detallesRiesgoPage.ClikOnContinuar();
	 * AvisoSistemaPage avisoSistemaPage = new AvisoSistemaPage(userS); avisoSistemaPage.CheckmsgAvisoPlantasAlto();
	 * userS.writeTestCaseData(); logger.debug("END - intento_dar_alta_simulacion_hasta_datos_riesgo"); } }
	 *
	 * //@ Cuando("^lo consulto en el buscador de cotizaciones usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void lo_consulto_en_el_buscador_de_cotizaciones( String loginAcess, String user) {
	 * logger.debug("BEGIN - lo_consulto_en_el_buscador_de_cotizaciones"); userS.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso")); userS.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), userS.getProperties().passwordComun, this.tCData.getNoCotizacion()); //
	 * userS.initializeVariables(loginAcess = this.tCData.getCambioAcceso()); //
	 * userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getCambioUsuario(), //
	 * userS.getProperties().passwordComun, // this.tCData.getNoCotizacion());
	 * logger.debug("END - lo_consulto_en_el_buscador_de_cotizaciones"); }
	 *
	 * //@Cuando("^continuo en Detalles de riesgo$") public void continuo_en_detalles_riesgo() {
	 * logger.debug("BEGIN - continuo_en_detalles_riesgo"); this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
	 * this.detallesRiesgoPage.ClikOnContinuar(); logger.debug("END - continuo_en_detalles_riesgo"); }
	 *
	 * //@Cuando("^modifico el capital continente a '(\\d+)'$") public void modifico_el_capital_continente_a( Integer
	 * capitalContinente) { this.tCData.setCapitalContinente(capitalContinente); }
	 *
	 * //@Cuando("^cierro el navegador$") public void cierro_navegador() { this.webDriver.quit(); }
	 *
	 * //@ Entonces("^el campo cotización contiene el valor del codigo de cotización$" ) public void
	 * el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() {
	 * logger.debug("BEGIN - el_campo_cotización_contiene_el_valor"); GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS); String cotizacion =
	 * gestionCotizacionesBuscacorPage.getCotizacion();
	 * Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
	 * logger.debug("END - el_campo_cotización_contiene_el_valor"); }
	 *
	 * //@ Dada("^se descargan los ficheros del suplemento en la carpeta \"([^\"]*)\"$" ) public void
	 * se_descargan_los_ficheros_del_suplemento_en_la_carpeta( String filesPath) { logger.
	 * debug("BEGIN - se_descargan_los_ficheros_del_suplemento_en_la_carpeta"); MensajeConfirmacionPage
	 * mensajeConfirmacionPage = new MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.DownlodadDocumentsToFolder(filesPath);
	 *
	 * logger. debug("END - se_descargan_los_ficheros_del_suplemento_en_la_carpeta"); }
	 *
	 * //@
	 * Cuando("^doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndCreateProjectMAC(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants. LoginAccessGestionLine)) // { //
	 * GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(webDriver, userS.getTestDataManager());
	 * // gestionOnlineHomePage.openMutuaAlquilerConfort(); // } if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessInnova)) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(userS); asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
	 * // InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager()); //
	 * innovaHomePage.OpenMutuaAlquilerConfort(); }
	 *
	 * // SCS Precio PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
	 *
	 * // SCS Inquilinos InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS); inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage(); }
	 *
	 * //@Cuando("^completo el proceso de contratacion MAC sin autorizacion$") public void
	 * completo_el_proceso_de_contratacion_MAC_sin_autorizacion() { logger.
	 * debug("BEGIN - completo_el_proceso_de_contratacion_MAC_sin_autorizacion" ); // Continuar
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.clickOnContinuar(); // Rellenar datos de contratacion, pagina 3
	 * TomadorYAseguradoPage_MAC tomadorYAseguradoPage_MAC = new TomadorYAseguradoPage_MAC(userS);
	 * tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
	 *
	 * InmueblePage_MAC inmueblePage_MAC = new InmueblePage_MAC(userS); inmueblePage_MAC.executeActionsInInmueblePage();
	 *
	 * DocumentacionPage_MAC documentacionPage_MAC = new DocumentacionPage_MAC(userS);
	 * documentacionPage_MAC.addDocumentContratacion();
	 *
	 * ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(userS);
	 * contratacionPage_MAC.seleccionarCheckYContratar(); logger.
	 * debug("END - completo_el_proceso_de_contratacion_MAC_sin_autorizacion"); }
	 *
	 * //@Cuando("^se informa de que la poliza no se puede emitir$") public void
	 * se_informa_de_que_la_poliza_no_se_puede_emitir() { // Compropar el estado de la poliza ContratacionPage_MAC
	 * contratacionPage_MAC = new ContratacionPage_MAC(userS);
	 *
	 * Assert.assertTrue(contratacionPage_MAC.checkPolizaError()); }
	 *
	 * //@ Cuando("^busco el proyecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * busco_el_proyecto_usando_el_acceso_y_el_usuario( String loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
	 *
	 * // Abrir el buscador de proyectos // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
	 * LoginAccessGestionLine)) // { // GestionOnlineHomePage gestionOnlineHomePage = new
	 * GestionOnlineHomePage(webDriver, userS.getTestDataManager()); // gestionOnlineHomePage.openMisProyectosWeb(); //
	 * gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC()) ;
	 *
	 * // userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getUsuario(), //
	 * userS.getProperties().passwordComun, this.tCData.getNoCotizacion()); // }
	 *
	 * // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants. LoginAccessInnova)) // { //
	 * userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getUsuario(), //
	 * userS.getProperties().passwordComun, this.tCData.getNoCotizacion()); // }
	 *
	 * }
	 *
	 * //@ Cuando("autorizo el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$" ) public void
	 * autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario( String loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(loginAcess = this.tCData.getAccesoAuth());
	 * userS.applicationAccessHelper.LoginAndSearchAutorizacion( this.tCData.getUsuarioAuth(),
	 * userS.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
	 * innovaHomePage.OpenGestionAutorizaciones(); GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar",
	 * this.tCData.getNoCotizacionMAC());
	 *
	 * // Autorizar el proyecto gestionAutorizacionesPage.autorizar(); }
	 *
	 * //@Cuando("envio el proyecto a la compañia") public void envio_el_proyecto_a__la_compania() {
	 * logger.debug("BEGIN - envio_el_proyecto_a__la_compania"); InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC
	 * = new InquilinosAvalistasPage_MAC(userS); inquilinosAvalistasPage_MAC.enviarACompania(); //
	 * userS.getWebDriver().quit(); logger.debug("END - envio_el_proyecto_a__la_compania"); }
	 *
	 * //@ Cuando("deniego el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$" ) public void
	 * deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario( String loginAcess, String user) { logger.
	 * debug("BEGIN - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario" ); // Login
	 * userS.initializeVariables(loginAcess = this.tCData.getAccesoAuth());
	 * userS.applicationAccessHelper.LoginAndSearchAutorizacion( this.tCData.getUsuarioAuth(),
	 * userS.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
	 * innovaHomePage.OpenGestionAutorizaciones(); GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar",
	 * this.tCData.getNoCotizacionMAC());
	 *
	 * // Denegar el proyecto gestionAutorizacionesPage.denegar(); userS.getWebDriver().quit(); logger.
	 * debug("END - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario"); }
	 *
	 * //@ Cuando("^completo el proceso de contratacion usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$" ) public
	 * void completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario( String loginAcess, String user) {
	 *
	 * loginAcess = this.userS.getTestVar("acceso"); if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) {
	 * // Login a GestionLine userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso")); //
	 * userS.applicationAccessHelper.LoginAndCreateProjectMAC(this .tCData.getUsuario(), //
	 * userS.getProperties().passwordComun);
	 *
	 * // userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getUsuario(), //
	 * userS.getProperties().passwordComun); userS.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), userS.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
	 *
	 * // Abrir el buscador de proyectos GestionOnlineHomePage gestionOnlineHomePage = new
	 * GestionOnlineHomePage(webDriver, userS.getTestDataManager()); // gestionOnlineHomePage.openMisProyectosWeb(); //
	 * gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC()) ;
	 *
	 * // Click en modificar gestionOnlineHomePage.modificarProyecto(); }
	 *
	 * else if (loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 *
	 * // Login to Innov@ userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.loginAndSearchCotizacion(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun, this.tCData.getNoCotizacionMAC());
	 *
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscadorPage.modificarProjecto(); AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(webDriver, userS.getTestDataManager());
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
	 *
	 * }
	 *
	 * PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.continuar();
	 *
	 * // Continuar InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.clickOnContinuar();
	 *
	 * // Rellenar datos de contratacion, pagina 3 TomadorYAseguradoPage_MAC tomadorYAseguradoPage_MAC = new
	 * TomadorYAseguradoPage_MAC(userS); tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
	 *
	 * InmueblePage_MAC inmueblePage_MAC = new InmueblePage_MAC(userS); inmueblePage_MAC.executeActionsInInmueblePage();
	 *
	 * DocumentacionPage_MAC documentacionPage_MAC = new DocumentacionPage_MAC(userS);
	 * documentacionPage_MAC.addDocumentContratacion();
	 *
	 * ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(userS);
	 * contratacionPage_MAC.seleccionarCheckYContratar(); }
	 *
	 * //@Cuando("^completo el proceso de contratacion MAC$") public void completo_el_proceso_de_contratacion_MAC() { //
	 * Click en contratar
	 *
	 * // Completar los datos
	 *
	 * //
	 *
	 * }
	 *
	 * //@ Cuando("^valido un proyecto \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public
	 * void valido_un_proyecto_usando_el_acceso_y_el_usuario( String loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.LoginAndCreateProjectMEC(this .tCData.getUsuario(),
	 * userS.getProperties().passwordComun);
	 *
	 * // Asignar mediador AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
	 *
	 * // SCS Precio PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
	 *
	 * // SCS Inquilinos InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS); inquilinosAvalistasPage_MAC.
	 * executeActionsInInquilinosAvalistasPageSinDocumentacion(); //
	 * inquilinosAvalistasPage_MAC.ValidacionViabilidadInquilino(); }
	 *
	 * //@Cuando("^valido el proyecto$") public void valido_el_proyecto() { InquilinosAvalistasPage_MAC
	 * inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino(); }
	 *
	 * //@ Cuando("^busco un edificio por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" )
	 * public void busco_un_edificio_por_usando_el_acceso_y_el_usuario( String filtroBuscador, String loginAcess, String
	 * user) {
	 *
	 * this.tCData.setFiltroBuscadorEdificio(getValuesDataSet(this.tCData. gethMapDataSet(), filtroBuscador,
	 * this.tCData.getTestID()));
	 *
	 * // Login userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
	 * fichaEdificioPage.accederAlBuscadorEdificios(); fichaEdificioPage.buscarConFiltroBusqueda(); }
	 *
	 * //@Cuando("^abro la ficha de edificio desde el grid de resultados$") public void
	 * abro_ficha_edificio_desde_grid_resultados() { // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new
	 * FichaEdificioPage(userS); fichaEdificioPage.openFichaEdificioDesdeGrid(); }
	 *
	 * //@ Cuando("^busco edificios por direcciones iterando con los datos del fichero \"([^\"]*)\"$" ) public void
	 * busco_edificios_por_direcciones_con_el_fichero( String nombreFichero) {
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
	 * fichaEdificioPage.accederAlBuscadorEdificios();
	 *
	 * fichaEdificioPage.setFiltroBusqueda(ProjectConstants. FILTRO_BUSCADOR_DIRECCION);
	 * fichaEdificioPage.iterarEdificiosPorDirecciones(getValuesDataSet(this. tCData.gethMapDataSet(), nombreFichero,
	 * this.tCData.getTestID())); }
	 *
	 * //@ Cuando("^busco edificios por direcciones en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void busco_edificios_por_direcciones_en_buscador_MEC_con_el_fichero( String nombreFichero) {
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMutuaEdificioConfort(); innovaHomePage.CreateNewProject();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.iterarEdificiosPorDirecciones(getValuesDataSet(this. tCData.gethMapDataSet(), nombreFichero,
	 * this.tCData.getTestID())); // fichaEdificioPage.setFiltroBusqueda(MutuaPropietariosConstants.
	 * FILTRO_BUSCADOR_DIRECCION); // fichaEdificioPage.IterarEdificiosPorDirecciones( //
	 * getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID())); }
	 *
	 * //@ Cuando("^busco edificios por referencias iterando con los datos del fichero \"([^\"]*)\"$" ) public void
	 * busco_edificios_por_referencias_con_el_fichero( String nombreFichero) { this.inicio_sesion();
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);
	 * fichaEdificioPage.accederAlBuscadorEdificios();
	 *
	 * fichaEdificioPage.setFiltroBusqueda(ProjectConstants. FILTRO_BUSCADOR_CATASTRAL);
	 * fichaEdificioPage.iterarEdificiosPorReferencias(getValuesDataSet(this. tCData.gethMapDataSet(), nombreFichero,
	 * this.tCData.getTestID())); }
	 *
	 * //@ Cuando("^busco edificios por referencias en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void busco_edificios_por_referencias_en_el_buscador_MEC_con_el_fichero( String nombreFichero) {
	 * this.inicio_sesion();
	 *
	 * // FichaEdificioPage InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
	 * innovaHomePage.openMutuaEdificioConfort(); innovaHomePage.CreateNewProject();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * System.out.println("Nombre fichero en action steps: " + nombreFichero); //
	 * ubicacionRiesgoPage.iterarEdificiosPorReferencias(getValuesDataSet(this. tCData.gethMapDataSet(), nombreFichero,
	 * this.tCData.getTestID())); ubicacionRiesgoPage.iterarEdificiosPorReferencias( System.getProperty("user.dir") +
	 * "/" + ProjectConstants.ResourcesFolder + "/" + this.tCData.value("fichero"));
	 *
	 * }
	 *
	 * //@Cuando("^modifico los ingresos a \"([^\"]*)\"$") public void modificar_ingresos( String ingresos) { //
	 * this.tCData.setIngresosNetosInquilino(getValuesDataSet(this.tCData. gethMapDataSet(), ingresos,
	 * this.tCData.getTestID()) != null // ? Integer.parseInt(getValuesDataSet(this.tCData.gethMapDataSet(), ingresos,
	 * this.tCData.getTestID())) : null);
	 *
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.modificarRentasInquilino();
	 *
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
	 *
	 * }
	 *
	 * //@Cuando("^añado avalista$") public void anado_avalista() { InquilinosAvalistasPage_MAC
	 * inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS); inquilinosAvalistasPage_MAC.addDatosAval();
	 *
	 * inquilinosAvalistasPage_MAC.anadirDocumentacionAval();
	 *
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino(); }
	 *
	 * //@Cuando("^inicio sesion$") public void inicio_sesion() { System.out.println("Acceso: " +
	 * this.userS.getTestVar("acceso")); userS.initializeVariables(this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun); }
	 *
	 * //@ Cuando("^inicio sesion con el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * inicio_sesion_con_acceso_y_usuario( String loginAccess, String user) { // this.tCData.setAcceso( //
	 * getValuesDataSet(this.tCData.gethMapDataSet(), loginAccess, this.tCData.getTestID())); //
	 * this.tCData.setUsuario(this.tCData.getUsuario());
	 *
	 * userS.initializeVariables(this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun); }
	 *
	 * //@ Cuando("^doy de alta una simulación actualizando datos iterando por el fichero \"([^\"]*)\"$" ) public void
	 * doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero( String fileName) { logger.
	 * debug("BEGIN - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero" ); String logText = "", address =
	 * ""; this.tCData.setInmueble("direccion por defecto"); // fileName =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID()); fileName =
	 * this.tCData.value("fichero"); System.out.println("Filename: " + fileName); fileName = fileName.substring(0,
	 * fileName.length() - 4); System.out.println("Filename: " + fileName);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray( System.getProperty("user.dir") + "/" +
	 * ProjectConstants.ResourcesFolder + "/" + fileName + ".csv", false); // String[][] datosAltoValor =
	 * loadDataFileToArray(fileName, false);
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) { innovaHomePage.CreateNewSimulation(); // address =
	 * getValuesDataSetByID(datosAltoValor, "provincia", i) + ", " + getValuesDataSetByID(datosAltoValor, "poblacion",
	 * i) + ", " // + getValuesDataSetByID(datosAltoValor, "direccion", i) + ", " + getValuesDataSetByID(datosAltoValor,
	 * "numero", i);
	 *
	 * // address = getValuesDataSetByID(datosAltoValor, "ref_catastral", i);
	 *
	 * this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor, "ref_catastral", i)); //
	 * this.tCData.setDireccionProvincia(getValuesDataSetByID(datosAltoValor, "provincia", i)); //
	 * this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosAltoValor, "poblacion", i)); //
	 * this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosAltoValor, "direccion", i)); //
	 * this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosAltoValor, "numero", i)); // String codigoPostal =
	 * getValuesDataSetByID(datosAltoValor, "codigo_postal", i); //
	 * this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try { UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS);
	 *
	 * if (!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) { logText +=
	 * "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
	 * System.out.println("Mas de una referencia catastral encontrada"); userS.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome(); innovaHomePage.openMutuaEdificioConfort(); writeFile(fileName +
	 * " (log file).txt", logText); continue; } ubicacionRiesgoPage.closeNotification();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); String anyoConstruccion =
	 * this.detallesRiesgoPage.completarDatosRiesgoMinimos(); this.detallesRiesgoPage.ClikOnContinuar();
	 *
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS); //
	 * precioPorModalidadPage.modificarRC("600.000,00"); //
	 * precioPorModalidadPage.agregarDescuento(getValuesDataSet(this.tCData. gethMapDataSet(),
	 * this.tCData.getDescuento(), // this.tCData.getTestID()));
	 * precioPorModalidadPage.agregarDescuento(this.tCData.getDescuento());
	 *
	 * String precioTotal = precioPorModalidadPage.getPrecioTotal(); precioPorModalidadPage.clickOnGuardar(); String
	 * numSimulacion = precioPorModalidadPage.getNumSimulacion();
	 *
	 * datosAltoValor = setValuesDataSetByID(datosAltoValor, "prima_total", i, precioTotal); datosAltoValor =
	 * setValuesDataSetByID(datosAltoValor, "anyo_antiguedad", i, anyoConstruccion); datosAltoValor =
	 * setValuesDataSetByID(datosAltoValor, "numero_proyecto", i, numSimulacion);
	 *
	 * writeArrayIntoCSVFile(fileName + " (modificado).csv", datosAltoValor);
	 *
	 * precioPorModalidadPage.clickOnCancelar(); } catch (Exception e) { logText +=
	 * "Comprobacion de datos no contemplada para la direccion " + address + "\n"; writeFile(fileName +
	 * " (log file).txt", logText); System.out.println("Comprobaciones de datos no contempladas");
	 * userS.webElementHelper.exitFromFrame(); innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * userS.getWebDriver().quit();
	 *
	 * logger. debug("END - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero" ); }
	 *
	 * //@Cuando("^prueba$") public void prueba() { // this.tCData.prueba(); }
	 *
	 * //@ Cuando("^modifico un proyecto iterando por el fichero \"([^\"]*)\" cambiando el mediador$" ) public void
	 * modifico_proyecto_iterando_cambio_mediador( String fileName) {
	 * logger.debug("BEGIN - modifico_proyecto_iterando_cambio_mediador"); fileName =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID()); fileName =
	 * fileName.substring(0, fileName.length() - 4); // fileName = tCData.value("fileName") // DataObject data = new
	 * DataObject(FileUtils.csvFileToMData(tCData.value("fileName"))); this.inicio_sesion();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray(fileName + ".csv", false);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.OpenGestionCotizaciones();
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) { // data.setKey(Integer.toString(i)); //
	 * data.value("ref_catastral"); String cotizacion = getValuesDataSetByID(datosAltoValor, "numero_proyecto", i);
	 *
	 * if (cotizacion == null || cotizacion.isEmpty()) continue;
	 *
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscadorPage.searchCotizacion(cotizacion);
	 * gestionCotizacionesBuscadorPage.modificarProjecto();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS); ubicacionRiesgoPage.clickOnGuardar();
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup();
	 *
	 * innovaHomePage.openInnovaHome(); innovaHomePage.OpenGestionCotizaciones(); }
	 *
	 * userS.getWebDriver().quit();
	 *
	 * logger.debug("END - modifico_proyecto_iterando_cambio_mediador"); }
	 *
	 * //@ Cuando("^doy de alta un proyecto actualizando datos iterando por el fichero \"([^\"]*)\"$" ) public void
	 * doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero( String fileName) { logger.
	 * debug("BEGIN - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero" ); String logText = "", address =
	 * ""; this.tCData.setInmueble("direccion por defecto"); fileName = getValuesDataSet(this.tCData.gethMapDataSet(),
	 * fileName, this.tCData.getTestID()); fileName = fileName.substring(0, fileName.length() - 4);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosCargaMEC = loadDataFileToArray(fileName + ".csv", false); datosCargaMEC =
	 * addColumnToArray(datosCargaMEC, "capital_continente"); datosCargaMEC = addColumnToArray(datosCargaMEC,
	 * "total_asegurado"); datosCargaMEC = addColumnToArray(datosCargaMEC, "capital_contenido"); datosCargaMEC =
	 * addColumnToArray(datosCargaMEC, "precios_antes_proyecto"); datosCargaMEC = addColumnToArray(datosCargaMEC,
	 * "precios_despues_proyecto"); datosCargaMEC = addColumnToArray(datosCargaMEC, "precio_basic"); datosCargaMEC =
	 * addColumnToArray(datosCargaMEC, "precio_plus");
	 *
	 * for (int i = 1; i < datosCargaMEC.length; i++) { innovaHomePage.CreateNewSimulation(); address =
	 * getValuesDataSetByID(datosCargaMEC, "provincia", i) + ", " + getValuesDataSetByID(datosCargaMEC, "poblacion", i)
	 * + ", " + getValuesDataSetByID(datosCargaMEC, "direccion", i) + ", " + getValuesDataSetByID(datosCargaMEC,
	 * "numero", i);
	 *
	 * this.tCData.setDireccionProvincia(getValuesDataSetByID(datosCargaMEC, "provincia", i));
	 * this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosCargaMEC, "poblacion", i));
	 * this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosCargaMEC, "direccion", i));
	 * this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosCargaMEC, "numero", i)); String codigoPostal =
	 * getValuesDataSetByID(datosCargaMEC, "codigo_postal", i);
	 * this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" + codigoPostal : codigoPostal);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try { UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS);
	 *
	 * if (!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) { logText +=
	 * "Mas de una referencia catastral encontrada para la direccion " + address + "\n";
	 * System.out.println("Mas de una referencia catastral encontrada"); userS.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome(); innovaHomePage.openMutuaEdificioConfort(); writeFile(fileName +
	 * " (log file).txt", logText); continue; } ubicacionRiesgoPage.closeNotification();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); this.detallesRiesgoPage.completarDatosRiesgoMinimos();
	 *
	 * String capitalContinente = this.detallesRiesgoPage.getCapitalContinente(); String totalAsegurado =
	 * this.detallesRiesgoPage.getCapitalContinenteTotalAsegurado(); String capitalContenido =
	 * this.detallesRiesgoPage.getCapitalContenido();
	 *
	 * this.detallesRiesgoPage.ClikOnContinuar();
	 *
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(userS); String precioComplet =
	 * precioPorModalidadPage.getPrecioTotal(); String precioBasic = precioPorModalidadPage.getPrecioBasic(); String
	 * precioPlus = precioPorModalidadPage.getPrecioPlus();
	 *
	 * precioPorModalidadPage.clickOnGuardar(); // TODO // Convertir a proyecto // seguir los pasos // Terminar de crear
	 * la poliza
	 *
	 * // escribir los datos: numeroProyecto, precios antes de proyecto, precios despues de // proyecto
	 *
	 * datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_continente", i, capitalContinente); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "total_asegurado", i, totalAsegurado); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "capital_contenido", i, capitalContenido); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "prima_total", i, precioComplet); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "precio_basic", i, precioBasic); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "precio_plus", i, precioPlus); // datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "numero_proyecto", i, numSimulacion);
	 *
	 * writeArrayIntoCSVFile(fileName + " - " + new ConfigurationProperties().environment + " (resultados).csv",
	 * datosCargaMEC);
	 *
	 * innovaHomePage.openInnovaHome(); innovaHomePage.openMutuaEdificioConfort(); } catch (Exception e) { logText +=
	 * "Comprobacion de datos no contemplada para la direccion " + address + "\n"; writeFile(fileName +
	 * " (log file).txt", logText); System.out.println("Comprobaciones de datos no contempladas\n\t- " + e.toString());
	 * userS.webElementHelper.exitFromFrame(); innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * userS.getWebDriver().quit();
	 *
	 * logger. debug("END - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero" ); }
	 *
	 * //@
	 * Cuando("^se da de alta un proyecto MEC donde la antiguedad del edificio es mayor que 50 anyos y se solicita peritacion, iterando por el fichero \"([^\"]*)\""
	 * ) public void se_dan_de_alta_masivamente_proyectos_MEC_donde_la_antiguedad_del_edificio_es_mayor_que_50_anyos(
	 * String fileName) { logger. debug("BEGIN - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50"); String
	 * logText = "", address = ""; // this.tCData.setInmueble("direccion por defecto"); fileName =
	 * this.tCData.value("fichero"); System.out.println("Filename: " + fileName); fileName = fileName.substring(0,
	 * fileName.length() - 4); System.out.println("Filename: " + fileName);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray( System.getProperty("user.dir") + "/" +
	 * ProjectConstants.ResourcesFolder + "/" + fileName + ".csv", false);
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) { innovaHomePage.CreateNewProject();
	 *
	 * this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor, "ref_catastral", i));
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try { UbicacionRiesgoPage ubicacionRiesgoPage = new
	 * UbicacionRiesgoPage(userS); ubicacionRiesgoPage.fillInmuebleAndClickOnContinue(); //
	 * ubicacionRiesgoPage.closeNotification(); // ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( userS);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada() ; this.detallesRiesgoPage = new
	 * DetallesRiesgoPage(webDriver, userS.getTestDataManager()); this.detallesRiesgoPage.completarDatosRiesgoMinimos();
	 * // Enter values madera and deshabitación. this.detallesRiesgoPage.enterAnyoConstruccionMoreThan50();
	 * this.detallesRiesgoPage.ClikOnContinuar(); ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS); validacionExcepcionesReglasPage.clickOnContinuarButton();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.fillStaticTomadorData(); datosBasicosTomadorPage.clickOnContinuar();
	 * PrecioPorModalidadPage precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.clickOnContinuar(); // ValidacionExcepcionesReglasPage
	 * validacionExcepcionesReglasPage = new ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage tomadorYAseguradoPage = new
	 * TomadorYAseguradoPage(webDriver, userS.getTestDataManager()); tomadorYAseguradoPage.addStaticDatosTomador(); //
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado(); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver, userS.getTestDataManager());
	 *
	 * datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion(); // userS.writeTestCaseData(); //
	 * userS.getWebDriver().quit();
	 *
	 * Iterable<String> PeritajeIterator = Splitter.on(' ').split(datosBancariosPage.getMensajePeritaje()); String[]
	 * PeritajeList = Iterables.toArray(PeritajeIterator, String.class);
	 *
	 * logText += "Solicitud peritaje concluida para referencia catastral " + getValuesDataSetByID(datosAltoValor,
	 * "ref_catastral", i) + " (Proyecto: " + datosBancariosPage.getProjectNumber() + ", " + "Referencia solicitud: " +
	 * PeritajeList[7] + ")" + "\n"; writeFile(fileName + " (log file).txt", logText);
	 *
	 * innovaHomePage.openInnovaHome(); innovaHomePage.openMutuaEdificioConfort(); } catch (Exception e) { logText +=
	 * "Comprobacion de datos no contemplada para la referencia catastral " + getValuesDataSetByID(datosAltoValor,
	 * "ref_catastral", i) + "\n"; writeFile(fileName + " (log file).txt", logText);
	 * System.out.println("Comprobaciones de datos no contempladas"); userS.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome(); innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * userS.getWebDriver().quit();
	 *
	 * logger. debug("END - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50"); }
	 *
	 * //@ Cuando("^busco un cliente por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public
	 * void busco_un_cliente_por_usando_el_acceso_y_el_usuario( String filtroBuscador, String loginAcess, String user) {
	 *
	 * this.tCData.setFiltroBuscadorCliente(getValuesDataSet(this.tCData. gethMapDataSet(), filtroBuscador,
	 * this.tCData.getTestID()));
	 *
	 * // Login userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * // Clientes Page ClientesPage clientesPage = new ClientesPage(webDriver, userS.getTestDataManager());
	 * clientesPage.accederAlBuscadorClientes(); clientesPage.buscarConFiltroBusqueda(); }
	 *
	 * //@ Cuando("^doy de alta un nuevo tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * doy_alta_nuevo_tomador_usando_el_acceso_y_el_usuario( String loginAcess, String user) {
	 *
	 * // Login userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * // Clientes Page ClientesPage clientesPage = new ClientesPage(webDriver, userS.getTestDataManager());
	 * clientesPage.accederAlBuscadorClientes(); clientesPage.crearNuevoTomador(); }
	 *
	 * //@
	 * Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\" iterando por el fichero \"([^\"]*)\"$"
	 * ) public void doy_de_alta_prospect_usando_acceso_y_usuario_iterando_fichero( String loginAcess, String user,
	 * String fileName) { fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName, this.tCData.getTestID());
	 * fileName = fileName.substring(0, fileName.length() - 4);
	 *
	 * this.inicio_sesion();
	 *
	 * String[][] datosMediadores = loadDataFileToArray(fileName + ".csv", false);
	 *
	 * for (int i = 1; i < datosMediadores.length; i++) {
	 * this.tCData.setNivelEstructura(getValuesDataSetByID(datosMediadores, "nivelEstructura", i));
	 * this.tCData.setTipoProspect(getValuesDataSetByID(datosMediadores, "tipoProspect", i));
	 * this.tCData.setActividadPrincipal(getValuesDataSetByID(datosMediadores, "actividadPrincipal", i));
	 * this.tCData.setNombreComercialProspect(getValuesDataSetByID( datosMediadores, "nomComercial", i));
	 * this.tCData.setContactoResponsable(getValuesDataSetByID(datosMediadores, "contactoResponsable", i));
	 * this.tCData.setIdioma(getValuesDataSetByID(datosMediadores, "idioma", i));
	 * this.tCData.setTlfPrincipal(getValuesDataSetByID(datosMediadores, "tlfPrincipal", i));
	 * this.tCData.setEjecutivoComercial(getValuesDataSetByID(datosMediadores, "ejecutivoComercial", i));
	 * this.tCData.setProvincia(getValuesDataSetByID(datosMediadores, "provincia", i));
	 * this.tCData.setPoblacion(getValuesDataSetByID(datosMediadores, "poblacion", i));
	 * this.tCData.setNombreVia(getValuesDataSetByID(datosMediadores, "nombreVia", i));
	 *
	 * try { userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver, userS.getTestDataManager());
	 * mediadoresHomePage.openAltaProspect();
	 *
	 * MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(userS);
	 * mediadoresAltaProspectPage.executeActionsAltaProspectPage();
	 *
	 * } catch (Exception e) {
	 *
	 * } } }
	 *
	 * //@ Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * doy_de_alta_prospect_usando_acceso_y_usuario( String loginAcess, String user) {
	 *
	 * userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver, userS.getTestDataManager());
	 * mediadoresHomePage.openAltaProspect();
	 *
	 * MediadoresAltaProspectPage mediadoresAltaProspectPage = new MediadoresAltaProspectPage(userS);
	 * mediadoresAltaProspectPage.executeActionsAltaProspectPage();
	 *
	 * }
	 *
	 * //@ Cuando("^doy de alta un mediador usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * doy_de_alta_mediador_usando_acceso_y_usuario( String loginAcess, String user) {
	 *
	 * userS.initializeVariables(loginAcess = this.userS.getTestVar("acceso"));
	 * userS.applicationAccessHelper.login(this.tCData.getUsuario( ), userS.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver, userS.getTestDataManager());
	 * innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver, userS.getTestDataManager());
	 * mediadoresHomePage.openAltaMediador();
	 *
	 * MediadoresAltaMediadorPage mediadoresAltaMediadorPage = new MediadoresAltaMediadorPage(userS);
	 * mediadoresAltaMediadorPage.executeActionsAltaMediadorPage();
	 *
	 * }
	 *
	 * //@ Cuando("^comunico un siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * comunico_siniestro( String loginAcess, String user) { userS.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso")); userS.applicationAccessHelper.login(this.tCData.getUsuario( ),
	 * userS.getProperties().passwordComun);
	 *
	 * }
	 *
	 * //@ Cuando("^busco el siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$" ) public void
	 * busco_siniestro( String loginAcess, String user) { userS.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso")); userS.applicationAccessHelper.login(this.tCData.getUsuario( ),
	 * userS.getProperties().passwordComun);
	 *
	 * }
	 *
	 * //@Cuando("^la renta mensual alquiler es \"([^\"]*)\"$") public void la_renta_mensual_es( String
	 * rentaMensualAlquiler) { PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); precioPorModalidadPage_MAC.CompletarRentaMensualAlquiler(); }
	 *
	 * //@Cuando("^la suma asegurada de impago alquiler es \"([^\"]*)\" meses$") public void
	 * la_suma_asegurada_de_impago_alquiler_es( String sumaAseguradaImpagoAlquiler) { PrecioPorModalidadPage_MAC
	 * precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.seleccionarImpagoAlquiler(); }
	 *
	 *
	 *
	 *
	 * /////////////////////////////////////////////////////////////////////////
	 * //////////////////////////////////////////////////// ////// CHECK STEPS
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////
	 *
	 *
	 *
	 * public ChecksSteps(BrowserContext browserContext) { userS = browserContext; this.tCData =
	 * browserContext.getTestCaseData(); }
	 *
	 * //@Entonces("^el edificio se encuentra$") public void el_edificio_se_encuentra() {
	 * logger.debug("BEGIN - el_edificio_se_encuentra");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver, userS.getTestDataManager());
	 * org.testng.Assert.assertTrue(fichaEdificioPage.checkResultadoDireccion()) ;
	 *
	 * logger.debug("END - el_edificio_se_encuentra"); }
	 *
	 * //@Entonces("^se visualiza la cabecera de la ficha de edificio$") public void visualiza_cabecera_ficha_edificio()
	 * { logger.debug("BEGIN - visualiza_cabecera_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver, userS.getTestDataManager());
	 * org.testng.Assert.assertTrue(fichaEdificioPage.checkCabeceraFicha());
	 *
	 * logger.debug("END - visualiza_cabecera_ficha_edificio"); }
	 *
	 * //@Entonces("^se visualiza la pestaña Resumen de la ficha de edificio$") public void
	 * visualiza_pestana_resumen_ficha_edificio() { logger.debug("BEGIN - visualiza_pestana_resumen_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver, userS.getTestDataManager());
	 * org.testng.Assert.assertTrue(fichaEdificioPage. checkPestanaResumenVisible( ));
	 *
	 * logger.debug("END - visualiza_pestana_resumen_ficha_edificio"); }
	 *
	 * //@Entonces("^se visualiza la pestaña Pólizas de la ficha de edificio$") public void
	 * visualiza_pestana_polizas_ficha_edificio() { logger.debug("BEGIN - visualiza_pestana_polizas_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver, userS.getTestDataManager());
	 * org.testng.Assert.assertTrue(fichaEdificioPage. checkPestanaPolizasVisible( ));
	 *
	 * logger.debug("END - visualiza_pestana_polizas_ficha_edificio"); }
	 *
	 * //@Entonces("^el cliente se encuentra$") public void el_cliente_se_encuentra() {
	 * logger.debug("BEGIN - el_cliente_se_encuentra");
	 *
	 * ClientesPage clientePage = new ClientesPage(webDriver, userS.getTestDataManager());
	 * org.testng.Assert.assertTrue(clientePage.checkResultadoNIF()); // TODO Agregar la comprobacion de resultado de
	 * busqueda en la ficha cliente
	 *
	 * logger.debug("END - el_cliente_se_encuentra"); }
	 *
	 * // //@Entonces("^el resultado es que el projecto se crea correctamente$") // public void
	 * el_resultado_es_que_el_projecto_se_crea_correctamente() // { // logger.
	 * debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente"); // if
	 * (userS.getTestCaseData().getGestionOnlineDisponible(). equals(MutuaPropietariosConstants.LoginAccessInnova)) // {
	 * // org.testng.Assert.assertNotNull(userS.getTestCaseData(). getNoCotizacion()); // } // logger.
	 * debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente"); // }
	 *
	 * //@Entonces("^el resultado es que el projecto se crea correctamente$") public void
	 * el_resultado_es_que_el_projecto_se_crea_correctamente() { logger.
	 * debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente");
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessInnova)) { // For the time being we check
	 * that the policy appears correctly in Innov@, but this should be changed to check the policy in GO.
	 *
	 * userS.initializeVariables(this.tCData.getCambioAcceso()); userS.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(), userS.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza())); gestionPolizasBuscadorPage.ConsultarPoliza();
	 * GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager()); gestionPolizasConsultarPage.CheckPolizaNumber();
	 *
	 * }
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessGestionLine)) { // Here we check if the
	 * policy created in GO appears correctly in Innov@ // Login
	 * userS.initializeVariables(this.tCData.getCambioAcceso()); userS.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(), userS.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza())); gestionPolizasBuscadorPage.ConsultarPoliza();
	 * GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager()); gestionPolizasConsultarPage.CheckPolizaNumber();
	 *
	 * }
	 *
	 * logger. debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente"); }
	 *
	 * //@Entonces("^el valor de los capitales varia$") public void el_valor_de_los_capitales_varia() { if
	 * (userS.getTestCaseData().isCantidadesModifiedError()) { throw new AssertionError(userS.getTestCaseData().
	 * getCantidadesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^resultado es que el projecto se crea correctamente$") public void
	 * el_resultado_es_que_el_proyecto_se_crea_correctamente() { ContratacionPage_MAC contratacionPage_MAC = new
	 * ContratacionPage_MAC(userS); Assert.assertTrue(contratacionPage_MAC.checkPolizaCreada()); }
	 *
	 * //@ Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un infraseguro$" ) public void
	 * el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_infraseguro () { // Este paso es puramente
	 * informativo. Esta comprobación se hace cada vez que se crea un // ifraseguro en la pantalla de validacion
	 * excepciones // reglas }
	 *
	 * //@Entonces("^aparece una clausula adicional$") public void aparece_una_clausula_adicional() { // Este paso es
	 * puramente informativo. Esta comprobación se hace cadea vez que se crea un // infraseguro en la pantalla de
	 * clausulas }
	 *
	 * //@ Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un supraseguro$" ) public void
	 * el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_supraseguro () { // Este paso es puramente
	 * informativo. Esta comprobación se hace cada vez que se crea un // supraseguro en la pantalla de validacion
	 * excepciones // reglas }
	 *
	 * //@Entonces("^los datos de ese cliente se completan automáticamente$") public void
	 * los_datos_de_ese_cliente_se_completan_automáticamente() { // Este paso es puramente informativo. Esta
	 * comprobación se hace en la pantalla de datos basicos // tomador al seleccionar como cliente un cliente //
	 * existente }
	 *
	 * //@Entonces("^sale un aviso si el precio no cambia$") public void sale_un_aviso_si_el_precio_no_cambia() { if
	 * (userS.getTestCaseData().isCapitalesModifiedError()) { throw new AssertionError(userS.getTestCaseData().
	 * getCapitalesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^se añade una franquicia obligatoria$") public void se_añade_una_franquicia_obligatoria() { // Este
	 * paso es puramente informativo. Esta comprobación se hace en la pantalla de Precio cada // vez que se añade un
	 * descuento. }
	 *
	 * //@ Entonces("^el valor de los capitales varia una vez se añade la cobertura opcional$" ) public void
	 * el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional() { if
	 * (userS.getTestCaseData().isCapitalesModifiedError()) { throw new AssertionError(userS.getTestCaseData().
	 * getCapitalesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^aparece aviso \"([^\"]*)\"$") public void aparece_aviso( String aviso) {
	 * ValidacionExcepcionesReglasDetallesRiesgoPage validacionDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( userS); boolean check = false;
	 *
	 * switch (aviso) { case ProjectConstants.AvisoPeritajeAntiguead: check = validacionDetallesRiesgoPage.
	 * CheckAvisoPeritajeConstructionYearGreaterThan50(); break; case ProjectConstants.AvisoPeritajePlantasSotano: check
	 * = validacionDetallesRiesgoPage.CheckAvisoPeritajePlantasSotano(); break; case
	 * ProjectConstants.AvisoPeritajeCapitalContinente: check = validacionDetallesRiesgoPage.
	 * CheckAvisoPeritajeCapitalContinenteGreaterThan15000000(); break; case
	 * ProjectConstants.AvisoPlantasSotanoGreaterThan10: check =
	 * validacionDetallesRiesgoPage.CheckAvisoPlantasSotanoMoreThan10(); break; case
	 * ProjectConstants.AvisoRiesgoAgravado: check = validacionDetallesRiesgoPage.CheckAvisoRiesgoAgravado(); break;
	 * case ProjectConstants.AvisoComunidadesEnTramite: validacionDetallesRiesgoPage.CheckAvisoComuniadesEnTramite();
	 * break; case ProjectConstants.AvisoPlantasAltoGreaterThan20: validacionDetallesRiesgoPage.CheckAvisoPlantasAlto();
	 * break; case ProjectConstants.AvisoModificacionAnyoContruccionGherkin:
	 * validacionDetallesRiesgoPage.CheckAvisoConstructionYearWithException(); break; case
	 * ProjectConstants.AvisoModificacionRehabilitacionIntegral: validacionDetallesRiesgoPage.
	 * CheckAvisoRehabilitacionIntegralWithException(); break; case ProjectConstants.AvisoGarajes: DetallesRiesgoPage
	 * detallesRiesgoPage = new DetallesRiesgoPage(userS); detallesRiesgoPage.CheckAvisoGarajesWithException(); break;
	 * default: throw new Exception(ProjectConstants.AvisoNoContemplado); } if (check)
	 * validacionDetallesRiesgoPage.CheckAviso(aviso); }
	 *
	 * //@ Entonces("^aparece un mensaje indicando que el projecto será revisado por la compañia$" ) public void
	 * aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia () { logger.
	 * debug("BEGIN - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia" ); // Pure informative
	 * step. This check is performed with the function logger.
	 * debug("END - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia" ); }
	 *
	 * //@Entonces("^la cotizacion se actualiza correctamente$") public void la_cotizacion_se_actualiza_correctamente()
	 * { logger.debug("BEGIN - la_cotizacion_se_actualiza_correctamente"); MensajeConfirmacionPage
	 * mensajeConfirmacionPage = new MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
	 * logger.debug("END - la_cotizacion_se_actualiza_correctamente");
	 *
	 * }
	 *
	 * //@Entonces("^la copia tomador deberia tener los nuevos datos$") public void
	 * la_copia_tomador_deberia_tener_los_nuevos_datos() {
	 * logger.debug("BEGIN - la_copia_tomador_deberia_tener_los_nuevos_datos"); MensajeConfirmacionPage
	 * mensajeConfirmacionPage = new MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly(); mensajeConfirmacionPage.searchTextInCopiaTomadorPDF();
	 * logger.debug("END - la_copia_tomador_deberia_tener_los_nuevos_datos");
	 *
	 * }
	 *
	 * //@
	 * Entonces("^el resultado es que aparece un mensaje de error y los campos deshabilitación y edificio madera aparecen resaltados en rojo$"
	 * ) public void
	 * el_resultado_es_que_aparece_un_mensaje_de_error_y_los_campos_deshabilitación_y_edificio_madera_aparecen_resaltados_en_rojo
	 * () throws Throwable { // Step puramente informativo. Los chequeos se hacen en el paso que crea la simulación. }
	 *
	 * //@Entonces("^se muestra la ventana para imprimir la poliza$") public void
	 * se_muestra_la_ventana_para_imprimir_la_poliza() { // Step puramente informativo. Los chequeos se hacen en el
	 * último paso de la simulacion, en la // pantalla con el listado de documentos }
	 *
	 * //@Entonces("^la poliza muestra \"([^\"]*)\" en la solapa Coberturas$") public void
	 * la_poliza_muestra_en_la_solapa_Coberturas( String arg1) {
	 *
	 * }
	 *
	 * //@Entonces("^el campo cotización contiene el valor \"([^\"]*)\"$") public void
	 * el_campo_cotización_contiene_el_valor( String cotizacionValue) {
	 * logger.debug("BEGIN - el_campo_cotización_contiene_el_valor"); GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS); String cotizacion =
	 * gestionCotizacionesBuscacorPage.getCotizacion();
	 * Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
	 * logger.debug("END - el_campo_cotización_contiene_el_valor"); }
	 *
	 * //@Entonces("^la poliza \"([^\"]*)\" en la pestaña \"([^\"]*)\"$") public void la_poliza_muestra_en_la_pestanya(
	 * String toBeChecked, String tab) { userS.applicationAccessHelper.OpenGestionPolizas(); GestionPolizasBuscadorPage
	 * gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza())); gestionPolizasBuscadorPage.ConsultarPoliza();
	 * GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager());
	 *
	 * switch (toBeChecked) { case ProjectConstants.PolizaDetailConstructionYear:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailConstructionYear, this.tCData.getAnyoConstruccion()); break; case
	 * ProjectConstants.PolizaDetailCapitalContinente: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailCapitalContinente,
	 * this.nf.format(this.tCData.getCapitalContinente()).toString()); break; case
	 * ProjectConstants.PolizaDetailCapitalContenido: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailCapitalContenido,
	 * this.nf.format(this.tCData.getCapitalContenido()).toString()); break; case
	 * ProjectConstants.PolizaDetailNuevaClausulaHipotecaria:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabClausulas,
	 * ProjectConstants.PolizaDetailNuevaClausulaHipotecaria, ProjectConstants.DescuentoRecargoNotSpecified); break;
	 * case ProjectConstants.PolizaDetailLocalesExcluidos: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailLocalesExcluidos,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case ProjectConstants.PolizaDetailDepositoCombustible:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailDepositoCombustible, ProjectConstants.DescuentoRecargoNotSpecified); break; case
	 * ProjectConstants.PolizaDetailCalefaccionCentral: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailCalefaccionCentral,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case ProjectConstants.PolizaDetailPlacaSolar:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailPlacaSolar, userS.getTestCaseData().getInstalacionesFotovoltaicasValor( ) + " €");
	 * break; case ProjectConstants.PolizaDetailMaquinaria:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailMaquinaria, userS.getTestCaseData().getCoberturaOpcionalMaquinariaValor () + " €");
	 * break; case ProjectConstants.PolizaDetailNoRecargo: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailNoRecargo, null); break; case
	 * ProjectConstants.PolizaDetailRecargo: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailNoRecargo, ProjectConstants.PolizaDetailDescuentoValue);
	 * break; case ProjectConstants.PolizaDetailNoDescuento:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabImportes,
	 * ProjectConstants.PolizaDetailNoDescuento, null); break; case ProjectConstants.PolizaDetailDescuento:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabImportes,
	 * ProjectConstants.PolizaDetailDescuentoValue, ProjectConstants.PorcentajeDescuentoRecargo);
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabImportes,
	 * ProjectConstants.PolizaDetailDescuento, ProjectConstants.TipoDescuento); break; case
	 * ProjectConstants.PolizaDetailClausula: gestionPolizasConsultarPage.CheckClausulas(); break; case
	 * ProjectConstants.PolizaDetailM2ConstruidosTotales: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailM2ConstruidosTotales,
	 * this.nf.format(this.tCData.getM2ContruidosTotales()).toString()); break; case
	 * ProjectConstants.PolizaDetailYearAndRehabilitationLevel:
	 * gestionPolizasConsultarPage.CheckAnyoAndNivelRehabilitacion(); break; case
	 * ProjectConstants.PolizaDetailYearRehabilitacionIntegral:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailYearRehabilitacionIntegral, this.tCData.getM2ContruidosTotales().toString()); break;
	 * case ProjectConstants.PolizaDetailCalidadConstruccion:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants. PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailCalidadConstruccion, this.tCData.getCalidadConstruccion()); break; case
	 * ProjectConstants.PolizaDetailFranquiciaVoluntaria: gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailFranquiciaVoluntaria,
	 * this.tCData.getFranquiciaVoluntaria()); break; default: throw new
	 * Exception(String.format("El checqueo para %s no se ha implementado", toBeChecked)); } }
	 *
	 * //@Entonces("^esta habilitado el campo \"([^\"]*)\"$") public void esta_habilitado_el_campo( String fieldValue) {
	 * DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(webDriver, userS.getTestDataManager());
	 * Assert.assertTrue(String.format("El campo %s no está habilitado", fieldValue),
	 * detallesRiesgoPage.IsFieldEnabled(fieldValue)); }
	 *
	 * //@Entonces("^el proyecto MAC se deniega$") public void el_proyecto_MAC_se_deniega() {
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * Assert.assertTrue( inquilinosAvalistasPage_MAC.recuperarTextoMensajeError().contains(String.
	 * format("¡Error! Se ha denegado la emisión del proyecto"))); }
	 *
	 * //@Entonces("^el proyecto MAC se acepta$") public void el_proyecto_MAC_se_acepta() { InquilinosAvalistasPage_MAC
	 * inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * Assert.assertTrue(inquilinosAvalistasPage_MAC. recuperarTextoMensajeValidacionOK().contains(
	 * "El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."
	 * )); }
	 *
	 * //@Entonces("^el proyecto esta en estado denegado$") public void el_proyecto_esta_en_estado_denegado() { if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessGestionLine)) { GestionOnlineHomePage
	 * gestionOnlineHomePage = new GestionOnlineHomePage(userS); Assert.assertEquals(String.format("Denegado"),
	 * gestionOnlineHomePage.recuperarEstadoPoliza()); }
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants. LoginAccessInnova)) {
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(userS);
	 * Assert.assertEquals(String.format("Desestimada"), gestionCotizacionesBuscadorPage.getEstadoCotizacion()); }
	 *
	 * }
	 *
	 * //@ Entonces("se puede autorizar usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$" ) public void
	 * se_puede_autorizar_usando_el_acceso_Innova_y_usuario( String loginAcess, String user) { // Enviar el proyecto
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.enviarACompania();
	 *
	 * // Cerrar el navegador userS.getWebDriver().quit();
	 *
	 * // Login // userS.initializeVariables( // getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), loginAcess,
	 * userS.getTestCaseData().getTestID())); // userS.applicationAccessHelper.LoginAndSearchAutorizacion( //
	 * getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), user, userS.getTestCaseData().getTestID()), //
	 * userS.getProperties().passwordComun);
	 *
	 * System.out.println("Valor accesoAuth: " + this.tCData.getAccesoAuth());
	 * userS.initializeVariables(this.tCData.getAccesoAuth()); userS.applicationAccessHelper.LoginAndSearchAutorizacion(
	 * this.tCData.getUsuarioAuth(), userS.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
	 * innovaHomePage.OpenGestionAutorizaciones(); GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar",
	 * userS.getTestCaseData().getNoCotizacionMAC());
	 *
	 * // Autorizar el proyecto gestionAutorizacionesPage.autorizar(); Assert.assertTrue(gestionAutorizacionesPage.
	 * recuperarResultadoAutorizacion(). contains("ha sido autorizada correctamente.")); }
	 *
	 * //@Entonces("^los datos de prospect grabados coinciden$") public void datos_prospect_grabados_coinciden() {
	 * String nombreComercial = String.valueOf(this.tCData.getNombreComercialProspect()).toUpperCase();
	 * MediadoresFichaMediadorPage fichaMediadorPage = new MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains( nombreComercial)); }
	 *
	 * //@Entonces("^los datos de mediador grabados coinciden$") public void datos_mediador_grabados_coinciden() { if
	 * (this.tCData.getTipoNombreComercialMediador(). equals("Igual que el fiscal")) { String nombreComercial = String
	 * .valueOf( this.tCData.getNombreFiscalMediador() + " " + this.tCData.getPrimerApellidoMediador() + " " +
	 * this.tCData.getSegundoApellidoMediador()) .toUpperCase(); System.out.println("*** Nombre comercial" +
	 * nombreComercial); MediadoresFichaMediadorPage fichaMediadorPage = new MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains( nombreComercial)); }
	 *
	 * if (this.tCData.getTipoNombreComercialMediador(). equals("Diferente que el fiscal")) { String nombreComercial =
	 * String.valueOf(this.tCData.getNombreComercialMediador()).toUpperCase(); MediadoresFichaMediadorPage
	 * fichaMediadorPage = new MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains( nombreComercial)); }
	 *
	 * }
	 *
	 * //@ Entonces("^debería aparecer ¡Error! Rebasada la renta máxima permitida de 3.000,00 €$" ) public void
	 * deberia_aparecer_error_rebasada_la_renta_máxima_permitida() { PrecioPorModalidadPage_MAC
	 * precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS); // Comprobar que sale el error
	 * correspondiente Assert.assertTrue( precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.
	 * format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €"))); }
	 *
	 * //@ Entonces("^debería aparecer ¡Error! Situación de reaseguro no es posible la contratación$" ) public void
	 * deberia_aparecer_error_situacion_reasegurado() { PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); // Comprobar que sale el error correspondiente
	 * Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError() .contains(String.
	 * format("¡Error! Situación de reaseguro no es posible la contratación"))); }
	 *
	 * //@Entonces("^no debería estar habilitado Convertir a proyecto$") public void
	 * no_deberia_estar_habilitado_convertir_a_proyecto() { PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); // Comprobar que se queda deshabilitado Convertir a proyecto
	 * Assert.assertFalse(precioPorModalidadPage_MAC. checkConvertirAProyectoIsPresent()); }
	 *
	 *
	 *
	 */

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////// 18-04-18 DESDE GESTION ONLINE ACCESS HELPER
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 *
	 * public void CreateProject() { this.gestionOnlineHomePage.createNewProject(); }
	 *
	 * public void CreateSimulation() { this.gestionOnlineHomePage.createNewSimulation(); }
	 *
	 * public void OpenMutuaEdificioConfort() { this.gestionOnlineHomePage.openMutuaEdificioConfort(); }
	 *
	 * // @Override // public void openMisProyectosWeb() throws AWTException, // InterruptedException, IOException // {
	 * // this.gestionOnlineHomePage.openMisProyectosWeb();
	 *
	 * // }
	 *
	 * public void searchCotizacion(String cotizacion) { // GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscacorPage = new // GestionCotizacionesBuscadorPage(userS); //
	 * gestionCotizacionesBuscacorPage.searchCotizacion(cotizacion);
	 * this.gestionOnlineHomePage.buscarProyectoWeb(cotizacion); }
	 *
	 * public void OpenGestionPolizas() { // this.gestionOnlineHomePage.openGestionCotizaciones(); }
	 *
	 * public void SearchPolizaByPolizaNumber(String poliza) { GestionPolizasBuscadorPage gestionPolizasBuscadorPage =
	 * new GestionPolizasBuscadorPage(userS); gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(poliza); }
	 *
	 * public void loginAndSearchCotizacion(String userId, String password, String cotizacion) throws Exception {
	 * this.login(userId, password); // this.OpenMutuaEdificioConfort(); this.openGestionCotizaciones();
	 * this.searchCotizacion(cotizacion); }
	 *
	 * public void LoginAndSearchPolizaByPolizaNumber(String userId, String password, String poliza) throws Exception {
	 * this.login(userId, password); this.OpenGestionPolizas(); this.SearchPolizaByPolizaNumber(poliza); }
	 *
	 * public void LoginAndCreateProjectMEC(String userId, String password) throws Exception { this.login(userId,
	 * password); this.OpenMutuaEdificioConfort(); this.CreateProject(); }
	 *
	 * public void LoginAndCreateProjectMAC(String userId, String password) throws Exception { this.login(userId,
	 * password); this.OpenMutuaAlquilerConfort(); this.CreateProject(); }
	 *
	 * public void LoginAndCreateSimulation(String userId, String password) throws Exception { this.login(userId,
	 * password);
	 *
	 * this.OpenMutuaEdificioConfort();
	 *
	 * // this.CreateSimulation(); }
	 *
	 * public void LoginAndSearchPolizaByNifNie(String userId, String password, String nifNie) throws Exception {
	 * this.login(userId, password); this.OpenGestionPolizas();
	 *
	 * }
	 *
	 * public void SearchPolizaByNifNie(String nifNie) { GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS); gestionPolizasBuscadorPage.SearchPolizaByNifNumber(nifNie); }
	 *
	 * public void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException { new
	 * GestionOnlineHomePage(webDriver, userS.getTestDataManager()).openMutuaAlquilerConfort(); }
	 *
	 * public void LoginAndSearchAutorizacion(String userId, String password) throws Exception { this.login(userId,
	 * password); }
	 *
	 * public void openGestionCotizaciones() throws AWTException, InterruptedException, IOException {
	 * this.gestionOnlineHomePage.openMisProyectosWeb(); }
	 *
	 * ///////////////////////////////////////////////////////////////////////// ///////////////////////////// /////////
	 * 18-04-18 DESDE INNOVA ACCESS HELPER /////////////////////////////////////////////////////////////////////////
	 * /////////////////////////////
	 *
	 */
	// public void loginAndCreateSimulation(String userId, String password)
	// throws Exception {
	//
	// // this.logIn(userId, password);
	//
	// new InnovaHomePage(userS).openMutuaEdificioConfort();
	//
	// // this.logIn(userId, password);
	//
	// // this.OpenMutuaEdificioConfort();
	//
	// new InnovaHomePage(userS).createNewSimulation();
	//
	// // this.CreateSimulation();
	// }

	public void openSimulationMec() {
		new InnovaHomePage(userS).openMutuaEdificioConfort();
		new InnovaHomePage(userS).openNewSimulationMec();
	}

	public void crear_un_proyecto_MAC(String loginAccess, String user) throws Exception {
		debugBegin();
		// Login
		this.login(loginAccess, user);

		// Create project MAC
		this.createProjectMAC(loginAccess);

		// Assign mediador
		String mediador = getScenarioVar("mediador");
		if(loginAccess.equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		} else if(loginAccess.equals(Constants.LoginAccessInnova)) {

			new AsignarMediadorPage(userS)
				.SeleccionarMediadorMACPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		// Precio
		new PrecioPorModalidadPage_MAC(userS)
			.executeActionsInPrecioPorModalidadPage();

		// SCS Precio
		// PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
		// PrecioPorModalidadPage_MAC(userS);
		// precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();

		// Inquilinos
		new InquilinosAvalistasPage_MAC(userS).executeActionsInInquilinosAvalistasPage();

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
			new InnovaHomePage(userS).openNewProjectMec();
		}
		debugEnd();
	}

	public void searchAuthorisation() throws Exception {
		new InnovaHomePage(userS).OpenGestionAutorizaciones();
		new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION));

	}

	public void enviar_el_proyecto_a_la_compania() {
		debugBegin();
		new InquilinosAvalistasPage_MAC(userS).enviarACompania();
		// userS.getWebDriver().quit();
		debugEnd();
	}

	public void cerrar_navegador() {
		debugBegin();
		userS.getWebDriver().quit();
		debugEnd();
	}

	public void autorizar_el_proyecto_MAC(
		String loginAcess, String user) throws Exception {

		// Login
		// this.LoginAndSearchAutorizacion(this.tCData.getUsuarioAuth(),
		// userS.getProperties().passwordComun);
		// this.loginAndCreateProjectMAC(getTestVar("usuario"),
		// getConfigVar("passwordComun"));
		// Abrir la busqueda de autorizaciones
		// new InnovaHomePage(userS).OpenGestionAutorizaciones();
		// new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de
		// cotización", "Pendiente de autorizar",
		// this.tCData.getNoCotizacionMAC());

		// Autorizar el proyecto
		// gestionAutorizacionesPage.autorizar();
	}

	public void login_y_autorizar_el_proyecto_MAC(String loginAccess, String user) throws Exception {
		debugBegin();
		this.login(loginAccess, user);
		this.searchAuthorisation();
		new GestionAutorizacionesPage(userS).autorizar();

		userS.getWebDriver().quit();
		debugEnd();
	}

	public void completo_el_proceso_de_contratacion_MAC(String accessType, String user) throws Exception {
		debugBegin();
		this.login(accessType, user);

		if(accessType.equals(Constants.LoginAccessGestionLine)) {

			new GestionOnlineHomePage(userS).openMisProyectosWeb().buscarProyectoWeb(getTestVar(Constants.NUM_COTIZACION));
			new GestionOnlineHomePage(userS).modificarProyecto();

		} else if(accessType.equals(Constants.LoginAccessInnova)) {
			new InnovaHomePage(userS).openGestionCotizaciones();
			new GestionCotizacionesBuscadorPage(userS).searchCotizacion(getTestVar(Constants.NUM_COTIZACION));
			new GestionCotizacionesBuscadorPage(userS).modificarProjecto();
			new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar();
		}

		new PrecioPorModalidadPage_MAC(userS).clickContinuar();
		new InquilinosAvalistasPage_MAC(userS).clickContinuar();
		// Completar paso Contratación
		new ContratacionPage_MAC(userS).ExecuteActionsInContratacionPage();

		// loginAcess = this.tCData.getAcceso();
		// if
		// (loginAcess.equals(MutuaPropietariosConstants.LoginAccessGestionLine))
		// {
		// // Login a GestionLine
		// userS.initializeVariables(loginAcess =
		// this.tCData.getAcceso());
		// //
		// userS.applicationAccessHelper.LoginAndCreateProjectMAC(this.tCData.getUsuario(),
		// // userS.getProperties().passwordComun);
		//
		// //
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// // userS.getProperties().passwordComun);
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// this.tCData.getNoCotizacionMAC());
		//
		// // Abrir el buscador de proyectos
		// GestionOnlineHomePage gestionOnlineHomePage = new
		// GestionOnlineHomePage(userS);
		// // gestionOnlineHomePage.openMisProyectosWeb();
		// //
		// gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC());
		//
		// // Click en modificar
		// gestionOnlineHomePage.modificarProyecto();
		// }
		//
		// else if
		// (loginAcess.equals(MutuaPropietariosConstants.LoginAccessInnova))
		// {
		//
		// // Login to Innov@
		// userS.initializeVariables(loginAcess =
		// this.tCData.getAcceso());
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// this.tCData.getNoCotizacionMAC());
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
	 * 
	 */

	public void accederCliente() {
		debugBegin();
		
		new ClientePage(userS).clickNuevoTomador();
		new ClientePage(userS).clickNuevoTomadorSecond();
		new ClientePage(userS).datosTomador();
		new ClientePage(userS).localizacionDomicilioTomador();

		debugEnd();

	}

	public void marcaCliente() {

		new ClientePage(userS).clickNuevoTomador();

	}

	public void buscaClientePorNif() {

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

		// Accedemos a siniestros desde INNOVA

		if(acceso.compareTo("Innova") == 0) {

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
		}

		// Accedemos a siniestros desde Gestión On Line

		else if(acceso.compareTo("GOL") == 0) {

			new GestionOnlineHomePage(userS).openSiniestros();

		}

		debugEnd();
	}

	// ALTA SINIESTRO ALTERNATIVA

	public void alta_siniestroAlt(String acceso, String numPoliza, boolean asistencia, boolean otrosImplicados, boolean encargo) throws Exception {
		debugBegin();
		String ramo = "";

		// Accedemos a siniestros desde INNOVA

		if(acceso.compareTo("Innova") == 0) {

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
			//
			altaApertura.buscarPorNumPoliza(ramo, numPoliza);
			altaApertura.continuarPrimeraPoliza();

			// 1.Declaración
			SiniestrosAltaAperturaDeclaracionPage datosDeclaracion = new SiniestrosAltaAperturaDeclaracionPage(userS);
			datosDeclaracion.altaDatosBasicos("MEDI", "MAIL");
			datosDeclaracion.datosPersonaExtra("NORIE", "NombreInq", "ApellidoInq", "OtroInq", "NIF", "36155457D", "", "666123123", "", "", "H", true, "", true, "", "", "", "", "", "", "", "");

			// Comprobamos si necesita asistencia
			if(asistencia) {
				datosDeclaracion.altaConAsistencia(true, false, "", "Daños ubicados en el interior del riesgo asegurado", true, false, "");
			} else {
				if(datosDeclaracion.posibilidadAsistencia()) datosDeclaracion.altaSinAsistencia();
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
		}

		// Accedemos a siniestros desde Gestión On Line

		else if(acceso.compareTo("GOL") == 0) {

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
			//
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

		if(acceso.compareTo("Innova") == 0) {
			// Página de confirmación
			SiniestrosConfirmacionPage confirmarAltaSiniestro = new SiniestrosConfirmacionPage(userS);
			confirmarAltaSiniestro.confirmarSiniestroOK();
		}
	}

	// Accedemos a siniestros desde Gestión On Line
	/*
	 * else if(acceso.compareTo("GOL") == 0) {
	 * 
	 * GestionOnlineHomePage goHome = new GestionOnlineHomePage(userS); goHome.openSiniestros();
	 * 
	 * }
	 */
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

	public void se_informa_de_que_la_poliza_no_se_puede_emitir() { // Compropar
																	// el estado
		Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaError());
	}

	// MAC: MODIFICAR INGRESOS

	public void modificar_ingresos(String ingresos) {
		userS.setTestVar("ingresos", ingresos);
	}

	// MAC AÑADIR AVALISTA

	public void anyado_avalista() throws AWTException, InterruptedException {
		InquilinosAvalistasPage_MAC avalista = new InquilinosAvalistasPage_MAC(userS);
		avalista.addDatosAval();

		avalista.anadirDocumentacionAval();

		avalista.validacionViabilidadInquilino();
	}

	// MAC DENIEGO EL PROYECTO MAC USANDO ACCESO Y USUARIO

	public void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
		String loginAccess, String user) throws Exception {
		this.debugBegin();
		this.login(loginAccess, user);

		// Abrir la busqueda de autorizaciones
		InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
		innovaHomePage.OpenGestionAutorizaciones();
		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(userS);
		gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", userS.getTestVar("num_cotizacion"));

		// Denegar el proyecto gestionAutorizacionesPage.denegar();
		userS.getWebDriver().quit();
		this.debugEnd();

	}

	public void busco_el_proyecto_usando_el_acceso_y_el_usuario(
		String loginAccess, String user) throws Exception {

		// Login
		// userS.initializeVariables(this.userS.getTestVar("acceso"));
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// this.tCData.getNoCotizacionMAC());

		this.login(loginAccess, user);

		// Abrir el buscador de proyectos //

		// if(this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
		// LoginAccessGestionLine))
		// { GestionOnlineHomePage
		// gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
		// userS.getTestDataManager());
		// gestionOnlineHomePage.openMisProyectosWeb();
		// gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC());

		GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(userS);
		gestionOnlineHomePage.openMisProyectosWeb();
		gestionOnlineHomePage.buscarProyectoWeb(userS.getTestVar("num_cotizacion"));

		//
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun,
		// this.tCData.getNoCotizacion()); }
		// if
		// (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.LoginAccessInnova))
		// // {
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// userS.getProperties().passwordComun, this.tCData.getNoCotizacion());
		// // }

	}

	public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(
		String loginAccess, String user) throws Exception {

		// Login
		// userS.initializeVariables(this.userS.getTestVar("acceso"));
		// userS.applicationAccessHelper.LoginAndCreateProjectMAC(this
		// .tCData.getUsuario(), userS.getProperties().passwordComun);

		this.login(loginAccess, user);

		if(this.userS.getScenarioVar("acceso").equals(Constants.LoginAccessGestionLine)) { // GestionOnlineHomePage

			new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();

		} else if(this.userS.getScenarioVar("acceso").equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar();
			new InnovaHomePage(userS).OpenMutuaAlquilerConfort();
		}

		// SCS Precio
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
		precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();

		// SCS Inquilinos
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
		inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage();
	}

	public void el_proyecto_MAC_se_deniega() {

		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
		Assert.assertTrue(inquilinosAvalistasPage_MAC.recuperarTextoMensajeError().contains(String.format("¡Error! Se ha denegado la emisión del proyecto")));
	}

	public void el_proyecto_MAC_se_acepta() {
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
		Assert.assertTrue(inquilinosAvalistasPage_MAC.recuperarTextoMensajeValidacionOK()
			.contains("El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."));
	}

	public void el_proyecto_esta_en_estado_denegado() {
		if(this.userS.getTestVar("acceso").equals(Constants.LoginAccessGestionLine)) {
			GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(userS);
			Assert.assertEquals(String.format("Denegado"), gestionOnlineHomePage.recuperarEstadoPoliza());
		}

		else if(this.userS.getTestVar("acceso").equals(Constants.LoginAccessInnova)) {
			GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(userS);
			Assert.assertEquals(String.format("Desestimada"), gestionCotizacionesBuscadorPage.getEstadoCotizacion());
		}

	}

	public void el_resultado_es_que_el_proyecto_se_crea_correctamente() {

		Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaCreada());
	}

	public void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() throws InterruptedException, AWTException {
		debugBegin();

		new InquilinosAvalistasPage_MAC(userS).clickContinuar(); // Rellenar
																	// datos de
																	// contratacion,
																	// pagina 3

		new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();

		new InmueblePage_MAC(userS).executeActionsInInmueblePage();

		new DocumentacionPage_MAC(userS).addDocumentContratacion();

		new ContratacionPage_MAC(userS).seleccionarCheckYContratar();

		debugEnd();
	}

	public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(String loginAccess, String user) throws Exception {
		// Enviar el proyecto

		new InquilinosAvalistasPage_MAC(userS).enviarACompania();

		// Cerrar el navegador

		userS.getWebDriver().quit();

		// Login //

		this.login(loginAccess, user);

		// Abrir la busqueda de autorizaciones

		new InnovaHomePage(userS).OpenGestionAutorizaciones();

		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(userS);
		new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", this.userS.getTestVar("num_cotizacion"));

		// Autorizar el proyecto gestionAutorizacionesPage.autorizar();

		Assert.assertTrue(gestionAutorizacionesPage.recuperarResultadoAutorizacion().contains("ha sido autorizada correctamente."));
	}

	public void la_renta_mensual_es(String rentaMensualAlquiler) {
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
		precioPorModalidadPage_MAC.completarRentaMensualAlquiler();
	}

	public void se_inicia_un_proyecto_con_modalidad(String Modalidad) throws Exception {

		// Login

		login(userS.getConfigVar("Acceso"), userS.getConfigVar("Usuario"));

		if(this.userS.getTestVar("acceso").equals("GestionOnline")) {
			new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();;
		} else if(this.userS.getTestVar("acceso").equals("Innova")) {
			new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar();
		}

		// Seleccionar modalidad en Precio page PrecioPorModalidadPage_MAC

		new PrecioPorModalidadPage_MAC(userS).selectModalidad();
	}

	public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida() {
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
		Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €")));
	}

	public void no_deberia_estar_habilitado_convertir_a_proyecto() {
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);

		Assert.assertFalse(precioPorModalidadPage_MAC.checkConvertirAProyectoIsPresent());
	}

	public void deberia_aparecer_error_situacion_reasegurado() {
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);

		Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.format("¡Error! Situación de reaseguro no es posible la contratación")));
	}

	public void la_suma_asegurada_de_impago_alquiler_es(String sumaAseguradaImpagoAlquiler) {
		new PrecioPorModalidadPage_MAC(userS).seleccionarImpagoAlquiler();
	}

	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_usando(
		String loginAcess, String user) throws Exception

	{
		debugBegin();

		this.login(loginAcess, user);
		

		String mediador = this.userS.getScenarioVar("mediador");

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			this.openSimulationMec();
			new AsignarMediadorPage(userS).TerminaProcesando().seleccionarMediadorPorCodigo(mediador).clickOnContinuarButton();
		}

		new UbicacionRiesgoPage(userS).fillInmuebleAndClickOnContinue();
		
		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();
		
		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgoMinimos();
		
		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();
		
		new PrecioPage(userS).clickOnConvertirAProjecto();
		
		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.fillTomadorData(this.getTestVar("Tomador"));
		datosBasicosTomadorPage.clickOnContinuar();
		
		
		new PrecioPorModalidadPage(userS).executeActionsInPrecioPorModalidadPage();
		
		new ValidacionExcepcionesReglasPage(userS).clickOnContinuarButton();
		
		new ClausulasPage(userS).activateclausesAndClickOnContinue();
		
		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
		tomadorYAseguradoPage.addDatosTomador();
		tomadorYAseguradoPage.addDatosTomadorDiferenteAsegurado();
		tomadorYAseguradoPage.clickOnContinuar();
		
		new DocumentacionPage(userS).SubirFichero();
		
		new DatosBancariosPage(userS).introducirFormaPagoYPulsarContratar();
		
		// this.browserContext.writeTestCaseData();

		userS.getWebDriver().quit();

		debugEnd();
	}
	
	public void doy_de_alta_una_simulacion_MEC_y_la_convierto_en_un_proyecto_y_guardo_sin_contratar_usando(
		String loginAcess, String user) throws Exception

	{
		debugBegin();

		this.login(loginAcess, user);
		System.out.println("TOKEN 1");
		

		String mediador = this.userS.getScenarioVar("mediador");

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			this.openSimulationMec();
			new AsignarMediadorPage(userS).TerminaProcesando().seleccionarMediadorPorCodigo(mediador).clickOnContinuarButton();
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

		this.login(loginAcess, user);

		String mediador = this.userS.getScenarioVar("mediador");

		if(loginAcess.equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			this.openSimulationMec();
			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(mediador)
				.clickOnContinuarButton();
		}

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.addInmueble(userS.getTestVar("inmueble"));
		ubicacionRiesgoPage.clickOnContinuar();

		ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS);
		validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();

		new PrecioPage(userS).clickOnConvertirAProjecto();

		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.fillTomadorData(userS.getTestVar("tomador"));
		datosBasicosTomadorPage.clickOnContinuar();

		new PrecioPorModalidadPage(userS).executeActionsInPrecioPorModalidadPage();

		this.debugEnd();
	}

	public void aparece_aviso(String aviso) throws Exception {
		ValidacionExcepcionesReglasDetallesRiesgoPage validacionDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS);
		boolean check = false;

		switch(aviso) {
			case Constants.AvisoPeritajeAntiguead:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajeConstructionYearGreaterThan50();
				break;
			case Constants.AvisoPeritajePlantasSotano:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajePlantasSotano();
				break;
			case Constants.AvisoPeritajeCapitalContinente:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajeCapitalContinenteGreaterThan15000000();
				break;
			case Constants.AvisoPlantasSotanoGreaterThan10:
				check = validacionDetallesRiesgoPage.CheckAvisoPlantasSotanoMoreThan10();
				break;
			case Constants.AvisoRiesgoAgravado:
				check = validacionDetallesRiesgoPage.CheckAvisoRiesgoAgravado();
				break;
			case Constants.AvisoComunidadesEnTramite:
				validacionDetallesRiesgoPage.CheckAvisoComuniadesEnTramite();
				break;
			case Constants.AvisoPlantasAltoGreaterThan20:
				validacionDetallesRiesgoPage.CheckAvisoPlantasAlto();
				break;
			case Constants.AvisoModificacionAnyoContruccionGherkin:
				validacionDetallesRiesgoPage.CheckAvisoConstructionYearWithException();
				break;
			case Constants.AvisoModificacionRehabilitacionIntegral:
				validacionDetallesRiesgoPage.CheckAvisoRehabilitacionIntegralWithException();
				break;
			case Constants.AvisoGarajes:
				DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(userS);
				detallesRiesgoPage.CheckAvisoGarajesWithException();
				break;

			default:
				throw new Exception(Constants.AvisoNoContemplado);
		}
		if(check)
			validacionDetallesRiesgoPage.CheckAviso(aviso);
	}

	public void intento_dar_alta_simulacion_hasta_datos_riesgo(String loginAcess, String user) throws Exception {

		// loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
		// loginAcess, // this.tCData.getTestID()); loginAcess =
		// this.userS.getTestVar("acceso");

		// if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
		// this.browserContext.getProperties().GestionOnlineDisponible.equals(
		// ProjectConstants.GestionOnlineDisponible) ||
		// this.browserContext.getProperties().GestionOnlineDisponible.equals(
		// ProjectConstants.GestionOnlineDisponible))
		// {

		debugBegin();

		this.login(loginAcess, user);

		String mediador = this.userS.getScenarioVar("mediador");

		if(loginAcess.equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
		} else if(loginAcess.equals(Constants.LoginAccessInnova)) {
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.seleccionarMediadorPorCodigo(userS.getScenarioVar("mediador"));
			asignarMediadorPage.clickOnContinuarButton();
		}

		UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
		ubicacionRiesgoPage.addInmueble(userS.getTestVar("inmueble"));
		ubicacionRiesgoPage.clickOnContinuar();
		DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(userS);
		detallesRiesgoPage.completarDatosRiesgo();
		detallesRiesgoPage.clickOnContinuar();

		debugEnd();
		// }
	}

	public void lo_consulto_en_el_buscador_de_cotizaciones(String loginAccess, String user) throws Exception {
		debugBegin();

		this.login(loginAccess, user);

		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
		// .tCData.getCambioUsuario(), //
		// this.browserContext.getProperties().passwordComun, //
		// this.tCData.getNoCotizacion());

		new InnovaHomePage(userS).openGestionCotizaciones();

		new GestionCotizacionesBuscadorPage(userS).searchCotizacion(userS.getScenarioVar("num_cotizacion"));

		debugEnd();
	}

	public void el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() {
		debugBegin();
		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(userS);
		String cotizacion = gestionCotizacionesBuscacorPage.getCotizacion();
		Assert.assertTrue(cotizacion.contains(this.userS.getScenarioVar("num_cotizacion")));
		debugEnd();
	}

	public void el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar(String loginAcess, String user) throws InterruptedException, IOException, Exception {
		debugBegin();

		// loginAcess = this.userS.getTestVar("acceso");

		// this.browserContext.initializeVariables(loginAcess);
		//
		// this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
		// .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
		//
		// String mediador = this.tCData.getMediador();
		//
		// if(this.userS.getTestVar("acceso").equals(ProjectConstants.LoginAccessGestionLine)
		// && this.tCData != null && !mediador.equals("640")) {
		// AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		// asignarMediadorPage.selectMediadorAndClickOnContinuar();
		//
		// } else
		// if(this.userS.getTestVar("acceso").equals(ProjectConstants.LoginAccessInnova))
		// {
		// AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
		// asignarMediadorPage.SeleccionarMediadorPorCodigo(userS.getScenarioVar("mediador").toString());
		// asignarMediadorPage.clickOnContinuarButton();
		// }

		this.login(loginAcess, user);

		new UbicacionRiesgoPage(userS).fillInmuebleAndClickOnContinue();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).clickOnContinuar();

		new PrecioPage(userS).clickOnConvertirAProjecto();

		DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
		datosBasicosTomadorPage.fillTomadorData(userS.getTestVar("Tomador"));
		datosBasicosTomadorPage.clickOnContinuar();

		new PrecioPorModalidadPage(userS).executeActionsInPrecioPorModalidadPage();

		new ValidacionExcepcionesReglasPage(userS).clickOnContinuarButton();

		new ClausulasPage(userS).activateclausesAndClickOnContinue();

		TomadorYAseguradoPage tomadorYAseguradoPage = new TomadorYAseguradoPage(userS);
		tomadorYAseguradoPage.addDatosTomador();

		tomadorYAseguradoPage.addDatosTomadorDiferenteAsegurado();
		tomadorYAseguradoPage.clickOnContinuar();

		DatosBancariosPage datosBancariosPage = new DatosBancariosPage(userS);
		datosBancariosPage.introducirFormaPagoYPulsarGuardar();

		// this.browserContext.writeTestCaseData(); ---------> revisar

		debugEnd();

	}

	public void se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(String loginAccess, String user) throws Exception {
		// loginAcess = this.tCData.getCambioAcceso();

		debugBegin();

		// userS.initializeVariables(loginAcess);
		// userS.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getCambioUsuario(),
		// userS.getProperties().passwordComun, this.tCData.getNoCotizacion());

		this.login(loginAccess, user);

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

		// userS.writeTestCaseData();
		userS.getWebDriver().quit();

		debugEnd();

	}

	public void el_resultado_es_que_el_proyecto_MEC_se_crea_correctamente() throws Exception {
		debugBegin();

		this.login(this.userS.getTestVar("acceso"), this.userS.getTestVar("usuario"));

		if(this.userS.getTestVar("acceso").equals(Constants.LoginAccessInnova)) {

			// userS.initializeVariables(this.tCData.getCambioAcceso());
			// userS.applicationAccessHelper.
			// LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),
			// userS.getProperties().passwordComun,
			// String.valueOf(this.tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
			gestionPolizasBuscadorPage.buscarPorNumeroPoliza(getTestVar("NumPoliza"));
			gestionPolizasBuscadorPage.ConsultarPoliza();

			new GestionPolizasConsultarPage(userS).CheckPolizaNumber();

		}

		if(this.userS.getTestVar("acceso").equals(Constants.LoginAccessGestionLine)) {

			// userS.initializeVariables(this.tCData.getCambioAcceso());
			// userS.applicationAccessHelper.
			// LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),userS.getProperties().passwordComun,String.valueOf(this.tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(userS);
			gestionPolizasBuscadorPage.buscarPorNumeroPoliza(getTestVar("NumPoliza"));
			gestionPolizasBuscadorPage.ConsultarPoliza();

			new GestionPolizasConsultarPage(userS).CheckPolizaNumber();

		}

		debugEnd();

	}

	public void LoginAndSearchPolizaByPolizaNumber(String userId, String password, String poliza) throws Exception {
		this.login(userId, password);
		this.OpenGestionPolizas();
		this.SearchPolizaByPolizaNumber(poliza);
	}

	public void OpenGestionPolizas() {
		new GestionOnlineHomePage(userS).openGestionCotizaciones();
	}

	public void SearchPolizaByPolizaNumber(String poliza) {
		new GestionPolizasBuscadorPage(userS).buscarPorNumeroPoliza(poliza);
	}

	public void marcado_el_check_Asegurar_unicamente_los_garajes() {
		setTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES, "true");
	}

	public void doy_de_alta_una_simulacion_MEC_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(String loginAccess, String user) throws Exception {
	
		debugBegin();
		
		//loginAcess = this.userS.getTestVar("acceso");
		
		if (loginAccess.equals(Constants.LoginAccessGestionLine)
			&& getConfigVar("GestionOnlineDisponible").equals(Constants.GestionOnlineDisponible) 
			|| loginAccess.equals(Constants.LoginAccessInnova)) {
			
			System.out.println("¡¡¡HOLA MUNDO!!!");
			
			this.login(loginAccess, user);
			
			this.openSimulationMec();
			
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			System.out.println("TOKEN 1");
			ubicacionRiesgoPage.addInmuebleByAddress();
			System.out.println("TOKEN 2");
			ubicacionRiesgoPage.clickOnContinuar();	
			
			/**
			this.login(loginAccess, user);
			//userS.initializeVariables(loginAcess);
			//userS.applicationAccessHelper.LoginAndCreateSimulation(this.tCData.getUsuario(), userS.getProperties().passwordComun);
			
			
			
			AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
			asignarMediadorPage.selectMediadorAndClickOnContinuar();
			
			UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
			
			ValidacionesExcepcionesReglasUbicacionRiesgoPage
			validacionesExcepcionesReglasUbicacionRiesgo = new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS);
			validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			
			this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver, userS.getTestDataManager()); // this.detallesRiesgoPage.
			ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
			this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
			
			*/
			
			 
			}
		
		System.out.println("S'ACABAO");
	
		debugEnd();
	}
	// FIN
}
