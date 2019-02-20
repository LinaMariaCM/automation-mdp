package com.project.steps;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.StepObject;
import com.automation.model.webdriver.DriverHelper;
import com.project.pages.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.awt.AWTException;
import java.io.IOException;
import java.lang.*;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.project.ProjectConstants;

//import static com.mutuaPropietarios.testCasesData.utils.Utils.getValuesDataSet;

public class Steps extends StepObject {

	public Steps(UserStory userStory) {
		super(userStory);

	}

	public static String getDayOfWeek() {
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		return dow.getDisplayName(TextStyle.SHORT, Locale.US);
	}

	public void login(String accessType, String user) throws Exception {
		debugBegin();
		// this.scenario = scenario;
		/*
		 * this.webDriver =
		 * WebDriverCreation.CreateWebDriver(BrowserType.valueOf(this.
		 * configurationProperties.Browser)); this.webElementHelper = new
		 * WebElementHelper(this.webDriver, this.scenario,
		 * this.configurationProperties); this.webDriverConfiguration = new
		 * CommonConfiguration(this.webDriver);
		 * this.webDriverConfiguration.SetWebDriverTimeouts();
		 * this.webDriverConfiguration.MaximizeWindow();
		 */

		// com.project.utils.IApplicationAccessHelper.initialize(AccessType,
		// webDriver);
		System.out.println("*** environment: " + (userS.getConfigVar("environment")));
		System.out.println("*** access type: " + accessType);
		System.out.println("*** user: " + user);
		new LoginPage(userS).logIn(userS.getConfigVar("environment"), accessType, user);
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
		//if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)
			// &&
			// this.browserContext.getProperties().GestionOnlineDisponible.equals(ProjectConstants.GestionOnlineDisponible)
			//&& this.userS.getTestVar("get_propeties").equals(ProjectConstants.GestionOnlineDisponible)
			//&& Boolean.parseBoolean(this.userS.getConfigVar("GestionOnlineDisponible"))
			//|| loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
			// Convertir a un step de ir a X entorno pasado por el parametro
			// "acceso"

			this.login(loginAcess, user);

			// Convertir a un step de logearse con el usuario X, parando el
			// usuario por el parametro "usuario"

			//this.userS.getTestVar("login_access");
			//this.LoginAndCreateSimulation(this.tCData.getUsuario(),
			// this.browserContext.getProperties().passwordComun);
			//this.loginAndCreateSimulation(this.userS.getTestVar("usuario"), this.userS.getConfigVar("passwordComun"));

			// String mediador = this.tCData.getMediador();
			String mediador = this.userS.getScenarioVar("mediador");

			if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) { // && !mediador.equals("640")) {
				new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();
				//new GestionOnlineHomePage(userS).createNewSimulation();
				//new AsignarMediadorPage(userS).selectMediadorAndClickOnContinuar(userS.getScenario());
			} else if(loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
				this.openSimulationMec();
				new AsignarMediadorPage(userS)
					.seleccionarMediadorPorCodigo(mediador)
					.clickOnContinuarButton();
			}

			// The testId variable has been set here because the FillTomadorData
			// from DatosBasicosTomadorPage requires it. Not sure if this is the
			// proper usage.
			String testId = userS.getDriver().getId() == null ? "" : userS.getDriver().getId();

			new UbicacionRiesgoPage(userS)
				.fillInmuebleAndClickOnContinue(userS.getScenario());

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
				//.executeActionsInPrecioPorModalidadPage();
				.clickOnContinuar();

			new ValidacionExcepcionesReglasPage(userS)
				.clickOnContinuarButton();

			new ClausulasPage(userS)
				.activateclausesAndClickOnContinue();

			// new DatosBasicosTomadorPage(userS)
			// .fillTomadorData(getScenarioVar("tomador"))
			// .clickOnContinuar();

			//new DatosBasicosTomadorPage(userS)
			//	.anyadirDatosMin();

			//new PrecioPorModalidadPage(userS)
			//	.executeActionsInPrecioPorModalidadPage();

			//new ValidacionExcepcionesReglasPage(userS)
			//	.clickOnContinuarButton();

			//new ClausulasPage(userS)
			//	.activateclausesAndClickOnContinue();

			new TomadorYAseguradoPage(userS)
				.addDatosTomador()
				.addDatosTomadorDiferenteAsegurado()
				.clickOnContinuar();

			new DocumentacionPage(userS)
				.SubirFichero();

			new DatosBancariosPage(userS)
				.introducirFormaPagoYPulsarContratar();

			// this.browserContext.writeTestCaseData();
			userS.getDriver().quit();

			new DocumentacionPage(userS)
				.SubirFichero();

			new DatosBancariosPage(userS)
				.introducirFormaPagoYPulsarContratar();

			userS.getDriver().quit();
		//}

		debugEnd();
	}

	// @Cuando("^selecciono Hay una gasolinera a menos de '(\\d+)'$") public
	void selecciono_Hay_una_gasolinera_a_menos_de_m(int arg1) {
		this.userS.setTestVar("gasolinera_menos_50m", "true");
		// this.browserContext.getTestCaseData().setGasolineraMenos50M(true);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 * ///// DATA ENTRY STEPS
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 *
	 *
	 *
	 * // private DetallesRiesgoPage detallesRiesgoPage; //final static Logger
	 * logger = LoggerFactory.getLogger(CommonSteps.class);
	 *
	 *
	 *
	 * // //@Dado("^marcado el check Asegurar unicamente los garajes$") public
	 * void marcado_el_check_Asegurar_unicamente_los_garajes() {
	 * userS.setTestVar("asegurar_garajes", "true");
	 * //userS.getTestVar("asegurar_garajes");
	 * //this.browserContext.getTestCaseData().setAsegurarUnicamenteGarajes(true
	 * ); }
	 *
	 * // //@Dado("^el dni \"([^\"]*)\"$") public void el_dni( String dniNumber)
	 * { logger.debug("BEGIN - el_dni"); //
	 * this.browserContext.getTestCaseData().setTomadorDNI(dniNumber);
	 * logger.debug("END - el_dni"); }
	 *
	 * // //@Dado("^el numero de cuenta es \"([^\"]*)\"$") public void
	 * la_cuenta( String numeroCuenta) { logger.debug("BEGIN - la_cuenta"); //
	 * this.browserContext.getTestCaseData().setNumeroCuenta( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * numeroCuenta, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - la_cuenta"); }
	 *
	 * // //@Dado("^la fecha de contrato del alquiler es \"([^\"]*)\"$") public
	 * void fecha_contrato_alquiler( String fecha) {
	 * logger.debug("BEGIN - fecha_contrato_alquiler"); //
	 * this.browserContext.getTestCaseData().setFechaContratoAlquiler(fecha);
	 * logger.debug("END - fecha_contrato_alquiler"); }
	 *
	 * //@Dado("^el inmueble con la dirección \"([^\"]*)\"$") public void
	 * el_inmueble( String direccion) { logger.debug("BEGIN - el_inmueble"); //
	 * this.browserContext.getTestCaseData().setInmueble(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * direccion, // this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - el_inmueble"); }
	 *
	 * //@Dado("^la provincia del inmueble es \"([^\"]*)\"$") public void
	 * provincia_inmueble( String provincia) {
	 * logger.debug("BEGIN - provincia_inmueble"); //
	 * this.browserContext.getTestCaseData().setInmuebleProvincia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * provincia, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_inmueble"); }
	 *
	 * // //@Dado("^la poblacion del inmueble es \"([^\"]*)\"$") public void
	 * poblacion_inmueble( String poblacion) {
	 * logger.debug("BEGIN - poblacion_inmueble"); //
	 * this.browserContext.getTestCaseData().setInmueblePoblacion( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * poblacion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_inmueble"); }
	 *
	 * //@Dado("^la direccion del inmueble es \"([^\"]*)\"$") public void
	 * direccion_inmueble( String direccion) {
	 * logger.debug("BEGIN - direccion_inmueble"); //
	 * this.browserContext.getTestCaseData().setInmuebleNombreVia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * direccion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_inmueble"); }
	 *
	 * //@Dado("^el numero de portal del inmueble es \"([^\"]*)\"$") public void
	 * portal_inmueble( String portal) {
	 * logger.debug("BEGIN - portal_inmueble"); //
	 * this.browserContext.getTestCaseData().setInmuebleNumeroVia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * portal, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - portal_inmueble"); }
	 *
	 * //@Dado("^el número de edificios es \"([^\"]*)\"$") public void
	 * el_numero_de_edificios( String numeroEdificios) {
	 * logger.debug("BEGIN - el_numero_de_edificios"); //
	 * this.browserContext.getTestCaseData() //
	 * .setNumeroEdificios(getValuesDataSet(this.browserContext.getTestCaseData(
	 * ).gethMapDataSet(), numeroEdificios, //
	 * this.browserContext.getTestCaseData().getTestID()) != null ? //
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), numeroEdificios, //
	 * this.browserContext.getTestCaseData().getTestID())) : null);
	 * logger.debug("END - el_numero_de_edificios"); }
	 *
	 * ////@Dado("^el mediador \"([^\"]*)\"$") public void el_mediador( String
	 * codigoMediador) { logger.debug("BEGIN - el_mediador"); //
	 * this.browserContext.getTestCaseData();
	 * setMediador(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), codigoMediador, //
	 * this.browserContext.getTestCaseData().getTestID()) != null ? //
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), codigoMediador, //
	 * this.browserContext.getTestCaseData().getTestID())) : null);
	 * logger.debug("END - el_mediador");
	 *
	 * }
	 *
	 * // //@Dado("^el medio de pago es \"([^\"]*)\"$") public void
	 * el_medio_de_pago_es( String medioPago) {
	 * logger.debug("BEGIN - el_medio_de_pago_es"); //
	 * this.browserContext.getTestCaseData().setMedioPago( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * medioPago, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - el_medio_de_pago_es"); }
	 *
	 * // //@
	 * Dado("^la cobertura opcional de rotura de maquinaria para la opción: \"([^\"]*)\" por un valor de \"([^\"]*)\" euros$"
	 * ) public void
	 * la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opcion_por_un_valor_de_euros(
	 * String coberturaMaquinariaTipo, String coberturaMaquinariaValor) {
	 * logger.
	 * debug("BEGIN - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros"
	 * ); this.browserContext.getTestCaseData().
	 * setCoberturaOpcionalMaquinaHerramientaIncluida(ProjectConstants.
	 * CoberturaOpcionalncluida); logger.
	 * debug("END - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros"
	 * ); }
	 *
	 * //@
	 * Dado("^la cobertura de accidentes personales de empleados para un empleado$"
	 * ) public void
	 * anado_la_cobertura_de_accidentes_personales_de_empleados_para_un_empleado
	 * () { logger.
	 * debug("BEGIN - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opcion_por_un_valor_de_euros"
	 * ); this.browserContext.getTestCaseData()
	 * .setCoberturaOpcionalAccidentesPersonalesEmpleadosIncluida(
	 * ProjectConstants.CoberturaOpcionalncluida); logger.
	 * debug("END - la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opion_por_un_valor_de_euros"
	 * ); }
	 *
	 * //@
	 * Dado("^la cobertura de rotura de instalaciones de energía solar para \"([^\"]*)\" por un valor de \"([^\"]*)\"$"
	 * ) public void
	 * anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de(
	 * String descripcion, String valor) { logger.
	 * debug("BEGIN - anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de"
	 * ); this.browserContext.getTestCaseData().
	 * setCoberturaOpcionalInstalacionesFotovoltaicasIncluida(ProjectConstants.
	 * CoberturaOpcionalncluida); logger.
	 * debug("END - anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de"
	 * ); }
	 *
	 * //@Dado("^la clausula \"([^\"]*)\"$") public void
	 * añado_la_clausula_hipotecaria( String clausula) {
	 * this.browserContext.getTestCaseData().setModificarClausulas(
	 * ProjectConstants.ModificarClausulas);
	 * this.browserContext.getTestCaseData().setClausulas(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * clausula, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^le incluyo la clausula \"([^\"]*)\"$") public void
	 * le_añado_la_clausula( String clausula) {
	 * this.browserContext.getTestCaseData().setModificarClausulas(
	 * ProjectConstants.ModificarClausulas);
	 * this.browserContext.getTestCaseData().setClausulas(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * clausula, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^le incluyo una clausula hipotecaria$") public void
	 * le_añado_una_clausula_hipotecaria() {
	 * this.browserContext.getTestCaseData().setClausulaHipotecaria(true); }
	 *
	 * //@Dado("^el asegurado es diferente del tomador$") public void
	 * el_asegurado_es_diferente_del_tomador() {
	 * this.browserContext.getTestCaseData().
	 * setAseguradoPrincipalDiferenteDelTomador(ProjectConstants.
	 * AseguradoPrincipalDiferenteTomador); }
	 *
	 * //@Dado("^el tomador es \"([^\"]*)\"$") public void el_tomador( String
	 * tomador) { logger.debug("BEGIN - el_tomador");
	 * logger.debug("END - el_tomador"); }
	 *
	 * // //@Dado("^el tipo de persona es \"([^\"]*)\"$") public void
	 * tipo_de_persona( String tipo) { logger.debug("BEGIN - tipo_de_persona");
	 * this.browserContext.getTestCaseData().setTipoPersona(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * tipo, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - tipo_de_persona"); }
	 *
	 * //@Dado("^el documento de tomador es aleatoreo$") public void
	 * el_documento_tomador_es_aleatoreo() {
	 * this.browserContext.getTestCaseData().setTomadorDocumento(
	 * DniGeneratorHelper.generaNif(null)); }
	 *
	 * //@Dado("^el documento de tomador es \"([^\"]*)\"$") public void
	 * documento_tomador( String documento) {
	 * logger.debug("BEGIN - documento_tomador");
	 * this.browserContext.getTestCaseData().setTomadorDocumento(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * documento, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("BEGIN - documento_tomador"); }
	 *
	 * //@Dado("^el nombre de tomador es \"([^\"]*)\"$") public void
	 * nombre_tomador( String nombre) { logger.debug("BEGIN - nombre_tomador");
	 * // this.browserContext.getTestCaseData().setTomadorNombre( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombre, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - nombre_tomador"); }
	 *
	 * //@Dado("^el primer apellido de tomador es \"([^\"]*)\"$") public void
	 * primer_apellido_tomador( String apellido) {
	 * logger.debug("BEGIN - primer_apellido_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorPrimerApellido( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * apellido, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - primer_apellido_tomador"); }
	 *
	 * //@Dado("^la provincia es \"([^\"]*)\"$") public void provincia( String
	 * provincia) { logger.debug("BEGIN - provincia_tomador"); //
	 * this.browserContext.getTestCaseData().setProvincia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * provincia, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_tomador"); }
	 *
	 * //@Dado("^la poblacion es \"([^\"]*)\"$") public void poblacion( String
	 * poblacion) { logger.debug("BEGIN - poblacion_tomador"); //
	 * this.browserContext.getTestCaseData().setPoblacion( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * poblacion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_tomador"); }
	 *
	 * //@Dado("^la via es \"([^\"]*)\"$") public void direccion( String
	 * direccion) { logger.debug("BEGIN - direccion_tomador"); //
	 * this.browserContext.getTestCaseData().setNombreVia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * direccion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_tomador"); }
	 *
	 * //@Dado("^el numero de portal es \"([^\"]*)\"$") public void
	 * numero_portal( String numero) {
	 * logger.debug("BEGIN - numero_portal_tomador"); //
	 * this.browserContext.getTestCaseData().setNumVia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * numero, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - numero_portal_tomador"); }
	 *
	 * //@Dado("^la provincia de tomador es \"([^\"]*)\"$") public void
	 * provincia_tomador( String provincia) {
	 * logger.debug("BEGIN - provincia_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorProvincia( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * provincia, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - provincia_tomador"); }
	 *
	 * //@Dado("^la poblacion de tomador es \"([^\"]*)\"$") public void
	 * poblacion_tomador( String poblacion) {
	 * logger.debug("BEGIN - poblacion_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorPoblacion( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * poblacion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - poblacion_tomador"); }
	 *
	 * //@Dado("^la direccion de tomador es \"([^\"]*)\"$") public void
	 * direccion_tomador( String direccion) {
	 * logger.debug("BEGIN - direccion_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorDireccion( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * direccion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - direccion_tomador"); }
	 *
	 * //@Dado("^el numero de portal de tomador es \"([^\"]*)\"$") public void
	 * numero_portal_tomador( String numero) {
	 * logger.debug("BEGIN - numero_portal_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorNumeroPortal( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * numero, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - numero_portal_tomador"); }
	 *
	 * //@Dado("^la fecha de nacimiento de tomador es \"([^\"]*)\"$") public
	 * void fecha_nacimiento_tomador( String fecha) {
	 * logger.debug("BEGIN - fecha_nacimiento_tomador"); //
	 * this.browserContext.getTestCaseData().setTomadorFechaNacimiento( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * fecha, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - fecha_nacimiento_tomador"); }
	 *
	 * //@Dado("^los teléfonos y los horarios de atención del tomador$") public
	 * void añado_los_teléfonos_del_tomador_y_los_horarios_de_atención() {
	 * this.browserContext.getTestCaseData().
	 * setIncluirTelefonosYHorarioAtencionTomador(ProjectConstants.
	 * TelefonosTomadorIncluidos); }
	 *
	 * //@Dado("^subo un fichero$") public void subo_un_fichero() {
	 * this.browserContext.getTestCaseData().setAddFile(true); }
	 *
	 * //@Dado("^la modalidad \"([^\"]*)\"$") public void la_modalidad( String
	 * modalidad) { logger.debug("BEGIN - la_modalidad");
	 *
	 * logger.debug("END - la_modalidad"); }
	 *
	 * //@Dado("^la referencia catastral \"([^\"]*)\"$") public void
	 * la_referencia_catastral( String referenciaCatastral) {
	 * logger.debug("BEGIN - la_referencia_catastral"); //
	 * this.browserContext.getTestCaseData().setReferenciaCatastral(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // referenciaCatastral,
	 * this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - la_referencia_catastral"); }
	 *
	 * //@Dado("^selecciono como número de plantas en alto \"([^\"]*)\"$")
	 * public void selecciono_como_número_de_plantas_en_alto( String
	 * NumPlantasAlto) {
	 * logger.debug("BEGIN - selecciono_como_número_de_plantas_en_alto");
	 * logger.debug("END - selecciono_como_número_de_plantas_en_alto"); }
	 *
	 * //@Dado("^selecciono como número de plantas de sotano \"([^\"]*)\"$")
	 * public void selecciono_como_número_de_plantas_de_sotano( String
	 * NumPlantasSotano) {
	 * logger.debug("BEGIN - selecciono_como_número_de_plantas_de_sotano");
	 * logger.debug("END - selecciono_como_número_de_plantas_de_sotano"); }
	 *
	 * //@Dado("^el número de cotización \"([^\"]*)\"$") public void
	 * el_numero_de_cotizacion( String noCotizacion) {
	 * logger.debug("BEGIN - el_número_de_cotización"); //
	 * this.browserContext.getTestCaseData().setNoCotizacion( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * noCotizacion, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - el_número_de_cotización"); }
	 *
	 * //@Dado("^el número de viviendas es \"([^\"]*)\"$") public void
	 * el_número_de_viviendas_es( String numeroViviendas) {
	 * logger.debug("BEGIN - el_número_de_viviendas_es"); //
	 * this.browserContext.getTestCaseData() //
	 * .setNumeroViviendas(getValuesDataSet(this.browserContext.getTestCaseData(
	 * ).gethMapDataSet(), numeroViviendas, //
	 * this.browserContext.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), numeroViviendas, //
	 * this.browserContext.getTestCaseData().getTestID())) // : null);
	 * logger.debug("END - el_número_de_viviendas_es"); }
	 *
	 * //@Dado("^el número de locales es \"([^\"]*)\"$") public void
	 * el_número_de_locales_es( String numeroLocales) {
	 * logger.debug("BEGIN - el_número_de_locales_es"); //
	 * this.browserContext.getTestCaseData() //
	 * .setNumeroLocalesComerciales(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), numeroLocales, //
	 * this.browserContext.getTestCaseData().getTestID()) != null ? //
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), numeroLocales, //
	 * this.browserContext.getTestCaseData().getTestID())) // : null);
	 * logger.debug("END - el_número_de_locales_es");
	 *
	 * }
	 *
	 * //@Dado("^el valor de m2 viviendas es '(\\d+)'$") public void
	 * el_valor_de_m_viviendas_es( String m2Viviendas) {
	 * logger.debug("BEGIN - el_valor_de_m_viviendas_es");
	 * this.browserContext.getTestCaseData().setM2Vivienda(m2Viviendas);
	 * logger.debug("END - el_valor_de_m_viviendas_es"); }
	 *
	 * //@Dado("^el valor de m2 zonas ajardinadas es '(\\d+)'$") public void
	 * el_valor_de_m_zonas_ajardinadas_es( String m2ZonasAjardinadas) { }
	 *
	 * //@Dado("^el valor de m2 oficinas es '(\\d+)'$") public void
	 * el_valor_de_m_oficinas_es( String m2Oficinas) { }
	 *
	 * //@Dado("^el valor de m2 garajes es '(\\d+)'$") public void
	 * el_valor_de_m_garajes_es( String m2Garajes) {
	 * logger.debug("BEGIN - el_valor_de_m_garajes_es");
	 * this.browserContext.getTestCaseData().setM2Garajes(m2Garajes);
	 * logger.debug("END - el_valor_de_m_garajes_es"); }
	 *
	 * //@Dado("^el año de construcción del edificio es \"([^\"]*)\"$") public
	 * void el_año_de_construcción_del_edificio_es( String anyoConstruccion) {
	 * if (anyoConstruccion.equals(ProjectConstants.MayorDe50)) {
	 * this.browserContext.getTestCaseData().setAnyoConstruccion(
	 * ProjectConstants.MayorDe50); } else {
	 * this.browserContext.getTestCaseData().setAnyoConstruccion(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * anyoConstruccion, this.browserContext.getTestCaseData().getTestID())); }
	 * }
	 *
	 * //@Dado("^el número de poliza \"([^\"]*)\"$") public void
	 * el_número_de_poliza( String noPoliza) { //
	 * this.browserContext.getTestCaseData().setNumPoliza(Integer.parseInt( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * noPoliza, this.browserContext.getTestCaseData().getTestID()))); }
	 *
	 * //@Dado("^fecha de siniestro es \"([^\"]*)\"$") public void
	 * fecha_siniestro_es( String fecha) {
	 * this.browserContext.getTestCaseData().setFechaSiniestro(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * fecha, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^causa de siniestro es \"([^\"]*)\"$") public void
	 * causa_siniestro_es( String causa) {
	 * this.browserContext.getTestCaseData().setCausaSiniestro(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * causa, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^rol de la persona de contacto es \"([^\"]*)\"$") public void
	 * rol_persona_contacto_es( String rol) {
	 * this.browserContext.getTestCaseData().setRolPersonaContacto(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * rol, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^nombre de la persona de contacto es \"([^\"]*)\"$") public void
	 * nombre_persona_contacto_es( String nombre) {
	 * this.browserContext.getTestCaseData().setNombrePersonaContacto(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombre, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^apellido de la persona de contacto es \"([^\"]*)\"$") public
	 * void apellido_persona_contacto_es( String apellido) {
	 * this.browserContext.getTestCaseData().setApellidoPersonaContacto(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * apellido, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^telefono de la persona de contacto es \"([^\"]*)\"$") public
	 * void telefono_persona_contacto_es( String telefono) {
	 * this.browserContext.getTestCaseData().setTelefonoPersonaContacto(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * telefono, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^descripcion de siniestro es \"([^\"]*)\"$") public void
	 * descripcion_siniestro_es( String descripcion) {
	 * this.browserContext.getTestCaseData().setDescripcionSiniestro(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * descripcion, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Cuando("^con el número de poliza$") public void
	 * con_el_número_de_poliza() { DatosBancariosPage datosBancariosPage = new
	 * DatosBancariosPage(userS);
	 * this.browserContext.getTestCaseData().setNumPoliza(datosBancariosPage.
	 * GetPolizaNumber()); }
	 *
	 * //@Cuando("^cambio el medio de pago a \"([^\"]*)\"$") public void
	 * cambio_el_medio_de_pago_a( String medioPago) {
	 * logger.debug("BEGIN - cambio_el_medio_de_pago_a"); //
	 * this.browserContext.getTestCaseData().setCambioMedioPago( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * medioPago, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - cambio_el_medio_de_pago_a"); }
	 *
	 * //@Cuando("^cambio la referencia catastral por \"([^\"]*)\"$") public
	 * void cambio_la_referencia_catastral_por( String referenciaCatastral) {
	 * logger.debug("BEGIN - cambio_la_referencia_catastral_por");
	 * this.browserContext.getTestCaseData().setModifiedReferenciaCatastral(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * referenciaCatastral, this.browserContext.getTestCaseData().getTestID()));
	 * logger.debug("END - cambio_la_referencia_catastral_por"); }
	 *
	 * //@Cuando("^cambio el número de viviendas a \"([^\"]*)\"$") public void
	 * modifico_el_numero_de_viviendas_a( String numeroViviendas) {
	 * logger.debug("BEGIN - cambio_el_numero_de_viviendas_a"); //
	 * this.browserContext.getTestCaseData().setNumeroViviendas(Integer.parseInt
	 * (getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // numeroViviendas, this.browserContext.getTestCaseData().getTestID())));
	 * //
	 * this.browserContext.getTestCaseData().setNumeroViviendas(numeroViviendas)
	 * ; logger.debug("END - cambio_el_numero_de_viviendas_a("); }
	 *
	 * //@Cuando("^cambio el número de edificios a \"([^\"]*)\"$") public void
	 * cambio_el_numero_de_edificios_a( String numeroEdificios) {
	 * logger.debug("BEGIN - cambio_el_numero_de_edificios_a"); //
	 * this.browserContext.getTestCaseData().setNumeroEdificios(numeroEdificios)
	 * ; //
	 * this.browserContext.getTestCaseData().setNumeroEdificios(Integer.parseInt
	 * (getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // numeroEdificios, this.browserContext.getTestCaseData().getTestID())));
	 * logger.debug("END - cambio_el_numero_de_edificios_a("); }
	 *
	 * //@Cuando("^cambio el número de locales a \"([^\"]*)\"$") public void
	 * modifico_el_número_de_locale_s_a( String numeroLocales) {
	 *
	 * logger.debug("BEGIN - modifico_el_número_de_locale_s_a"); //
	 * this.browserContext.getTestCaseData().setNumeroLocalesComerciales(Integer
	 * .parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), // numeroLocales,
	 * this.browserContext.getTestCaseData().getTestID())));
	 * logger.debug("END - modifico_el_número_de_locale_s_a(");
	 *
	 * }
	 *
	 * //@Cuando("^cambio los valores de m2 viviendas a \"([^\"]*)\"$") public
	 * void cambio_los_valores_de_m_viviendas_a( String m2Viviendas) {
	 * this.browserContext.getTestCaseData()
	 * .setModifiedM2Viviendas(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), m2Viviendas,
	 * this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), m2Viviendas,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de m2 zonas ajardinadas a \"([^\"]*)\"$")
	 * public void cambio_los_valores_de_m_zonas_ajardinadas_a( String
	 * m2ZonasAjardinadas) { this.browserContext.getTestCaseData()
	 * .setModifiedM2ZonasAjardinadas(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), m2ZonasAjardinadas,
	 * this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), m2ZonasAjardinadas,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de  m2 oficinas a \"([^\"]*)\"$") public
	 * void cambio_los_valores_de_m_oficinas_a( String m2Oficinas) {
	 * this.browserContext.getTestCaseData()
	 * .setModifiedM2Oficinas(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), m2Oficinas,
	 * this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), m2Oficinas,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio los valores de m2 garajes a \"([^\"]*)\"$") public
	 * void cambio_los_valores_de_m_garajes_a( String m2Garajes) { // Write code
	 * here that turns the phrase above into concrete actions
	 * this.browserContext.getTestCaseData().setModifiedM2Garajes(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * m2Garajes, this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), m2Garajes,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Cuando("^cambio el año construcción a \"([^\"]*)\"$$") public void
	 * cambio_el_anyo_construccion_a( String anyoConstruccion) { //
	 * this.browserContext.getTestCaseData().setAnyoConstruccion(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // anyoConstruccion, this.browserContext.getTestCaseData().getTestID()));
	 * }
	 *
	 * //@
	 * Cuando("^modifico el año de rehabilitacion de conducciones comunitarias a \"([^\"]*)\"$"
	 * ) public void
	 * se_modifica_el_año_de_rehabilitacion_de_conducciones_comunitarias(
	 * Integer anyoRehabilicion) { // this.browserContext.getTestCaseData().
	 * setAnyoRehabilitacionConstruccionesComunitarias(anyoRehabilicion); }
	 *
	 * //@
	 * Cuando("^selecciono como nivel de rehabilitación de conducciones de aguas comunitarias \"([^\"]*)\"$"
	 * ) public void
	 * se_selecciona_como_nivel_de_rehabilitación_de_conducciones_de_aguas_comunitarias(
	 * String nivelRehabilitacion) { // this.browserContext.getTestCaseData().
	 * setNivelRehabilitacionConduccionesAguasComunitarias(nivelRehabilitacion);
	 * }
	 *
	 * //@Cuando("^se modifica el año de rehabiliación integral a '(\\d+)'$")
	 * public void se_modifica_el_año_de_rehabiliación_integral_a( Integer
	 * anyoRehabilitacionIntegral) {
	 * this.browserContext.getTestCaseData().setAnyoRehabilitacionIntegral(
	 * anyoRehabilitacionIntegral); }
	 *
	 * //@Cuando("^selecciono Hay una gasolinera a menos de '(\\d+)'$") public
	 * void selecciono_Hay_una_gasolinera_a_menos_de_m( int arg1) {
	 * this.browserContext.getTestCaseData().setGasolineraMenos50M(true); }
	 *
	 * //@Cuando("^le agrego \"([^\"]*)\" como motivo del suplemento$") public
	 * void le_agrego_como_motivo_del_suplemento( String motivoSuplemento) {
	 * this.browserContext.getTestCaseData().setMotivosSuplemento(true,
	 * motivoSuplemento); }
	 *
	 * //@Cuando("^le quito \"([^\"]*)\" como motivo del suplemento$") public
	 * void le_quito_como_motivo_del_suplemento( String motivoSuplemento) {
	 * this.browserContext.getTestCaseData().setMotivosSuplemento(false,
	 * motivoSuplemento); }
	 *
	 * //@Cuando("^selecciono como tomador \"([^\"]*)\"$") public void
	 * selecciono_como_tomador( String tomador) { //
	 * this.browserContext.getTestCaseData().setTomador( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * tomador, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Cuando("^se modifica el año de construcción a \"([^\"]*)\"$") public
	 * void se_modifica_el_año_de_construcción( String anyoConstruccion) {
	 * this.browserContext.getTestCaseData().setAnyoConstruccion(
	 * anyoConstruccion); }
	 *
	 * //@Cuando("^se excluyen los garajes$") public void
	 * se_excluyen_los_garajes() {
	 * this.browserContext.getTestCaseData().setExcluirGarajes(true); }
	 *
	 * //@Cuando("^se excluyen los locales$") public void
	 * se_excluyen_los_locales() {
	 * this.browserContext.getTestCaseData().setExcluirLocales(true); }
	 *
	 * //@Cuando("^se modifica la calidad de construcción por \"([^\"]*)\"$")
	 * public void se_modifica_la_calidad_de_construcción_por( String
	 * calidadConstruccion) {
	 * this.browserContext.getTestCaseData().setCalidadConstruccion(
	 * calidadConstruccion); }
	 *
	 * ////@Dado("^cambio la modalidad a \"([^\"]*)\"$") public void
	 * cambio_la_modalidad_a( String modalidad) { //
	 * this.browserContext.getTestCaseData().setModalidad(modalidad); }
	 *
	 * //@Dado("^la deshabilitación es \"([^\"]*)\"$") public void
	 * la_deshabilitación_es( String deshabilitacion) {
	 * this.browserContext.getTestCaseData().setDeshabilitacion(deshabilitacion)
	 * ; }
	 *
	 * //@
	 * Dado("^el porcentaje de edificio construido en madera es \"([^\"]*)\"$")
	 * public void el_porcentaje_de_edificio_construido_en_madera_es( String
	 * porcentajeMadera) {
	 * this.browserContext.getTestCaseData().setEdificioMadera(porcentajeMadera)
	 * ; }
	 *
	 * //@Dado("^el capital continente se reduce en \"([^\"]*)\"$") public void
	 * el_capital_continente_se_reduce_en( String capitalContinente) {
	 * this.browserContext.getTestCaseData().setCapitalContinenteVariacion(true)
	 * ; this.browserContext.getTestCaseData()
	 * .setCapitalContinente(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), capitalContinente,
	 * this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), capitalContinente,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Dado("^el capital continente se incrementa en \"([^\"]*)\"$") public
	 * void el_capital_continente_se_incrementa_en( String capitalContinente) {
	 * this.browserContext.getTestCaseData().setCapitalContinenteVariacion(true)
	 * ; this.browserContext.getTestCaseData()
	 * .setCapitalContinente(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), capitalContinente,
	 * this.browserContext.getTestCaseData().getTestID()) != null ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), capitalContinente,
	 * this.browserContext.getTestCaseData().getTestID())) : null); }
	 *
	 * //@Dado("^añado una franquicia voluntaria de \"([^\"]*)\"$") public void
	 * añado_una_franquicia_voluntaria_de( String franquiciaVoluntaria) { //
	 * this.browserContext.getTestCaseData().setFranquiciaVoluntaria(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // franquiciaVoluntaria,
	 * this.browserContext.getTestCaseData().getTestID())); //
	 * this.browserContext.getTestCaseData().setFranquiciaVoluntaria(
	 * franquiciaVoluntaria); }
	 *
	 * //@
	 * Cuando("^se modifica el capital de franquicia voluntaria a \"([^\"]*)\"$"
	 * ) public void se_modifica_el_capital_de_franquicia_voluntaria_a( String
	 * franquiciaVoluntaria) { //
	 * this.browserContext.getTestCaseData().setFranquiciaVoluntaria(
	 * franquiciaVoluntaria); }
	 *
	 * //@Dado("^el descuento es \"([^\"]*)\"$") public void el_descuento_es(
	 * String descuento) { //
	 * this.browserContext.getTestCaseData().setDescuento(descuento); }
	 *
	 * //@Dado("^un descuento$") public void un_descuento() {
	 * this.browserContext.getTestCaseData().setDescuentoEnabled(true); }
	 *
	 * //@Cuando("^le incluyo el recargo$") public void le_incluyo_un_recargo()
	 * { this.browserContext.getTestCaseData().setRecargo(true); }
	 *
	 * //@Cuando("^se excluye un recargo$") public void se_excluye_un_recargo()
	 * { this.browserContext.getTestCaseData().setRecargo(false); }
	 *
	 * //@Dado("^se agrega un descuento$") public void se_agrega_un_descuento()
	 * { this.browserContext.getTestCaseData().setDescuentoEnabled(true); }
	 *
	 * //@Dado("^se quita un descuento$") public void se_quita_un_descuento() {
	 * this.browserContext.getTestCaseData().setDescuentoEnabled(false); }
	 *
	 * //@Cuando("^le agrego la clausula \"([^\"]*)\"$") public void
	 * le_agrego_la_clausula( String clausula) {
	 * this.browserContext.getTestCaseData().setClausulas(clausula); }
	 *
	 * //@
	 * Cuando("^se incluye el check de Calefacción central y/o agua caliente centralizada$"
	 * ) public void
	 * se_incluye_el_check_de_Calefacción_central_y_o_agua_caliente_centralizada
	 * () { this.browserContext.getTestCaseData().setCalefaccionCentral(true); }
	 *
	 * //@Cuando("^se incluye un deposito de combustible$") public void
	 * se_incluye_un_deposito_de_combustible() {
	 * this.browserContext.getTestCaseData().setDepositoCombustible(true); }
	 *
	 * //@Cuando("^se incrementa el capital contenido en '(\\d+)'$") public void
	 * se_incrementa_el_capital_contenido_en( Integer capitalContenido) {
	 * this.browserContext.getTestCaseData().setCapitalContenido(
	 * capitalContenido); }
	 *
	 * //@Cuando("^se reduce el capital contenido en '(\\d+)'$") public void
	 * se_reduce_el_capital_contenido_en( Integer capitalContenido) {
	 * this.browserContext.getTestCaseData().setCapitalContenido(-
	 * capitalContenido); }
	 *
	 *
	 * //@Dado("^la renta de alquiler mensual es \"([^\"]*)\"$") public void
	 * la_renta_de_alquiler_mensual_es( String rentaAlquilerMensual) { //
	 * this.browserContext.getTestCaseData() //
	 * .setRentaMensualAlquiler(getValuesDataSet(this.browserContext.
	 * getTestCaseData().gethMapDataSet(), rentaAlquilerMensual, //
	 * this.browserContext.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), rentaAlquilerMensual, //
	 * this.browserContext.getTestCaseData().getTestID())) // : null); }
	 *
	 * //@Dado("^con ingresos \"([^\"]*)\"$") public void con_ingresos( String
	 * ingresos) { //
	 * this.browserContext.getTestCaseData().setIngresosNetosInquilino( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * ingresos, this.browserContext.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * ingresos, this.browserContext.getTestCaseData().getTestID())) // : null);
	 * }
	 *
	 * //@Dado("^suma asegurada es \"([^\"]*)\"$") public void suma_asegurada(
	 * String sumaAsegurada) { //
	 * this.browserContext.getTestCaseData().setImpagoAlquiler( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * sumaAsegurada, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^franquicia es \"([^\"]*)\"$") public void franquiciaMAC( String
	 * franquiciaMAC) { //
	 * this.browserContext.getTestCaseData().setFranquiciaMAC( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * franquiciaMAC, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^los ingresos aval \"([^\"]*)\"$") public void
	 * los_ingresos_aval( String ingresosAval) { //
	 * this.browserContext.getTestCaseData() //
	 * .setIngresosAval(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), ingresosAval, //
	 * this.browserContext.getTestCaseData().getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), ingresosAval, //
	 * this.browserContext.getTestCaseData().getTestID())) // : null); }
	 *
	 * //@Dado("^el documento aleatoreo$") public void el_documento_aleatoreo()
	 * { this.browserContext.getTestCaseData().setDocumentoInquilino(
	 * DniGeneratorHelper.generaNif(null)); }
	 *
	 * //@Dado("^el documento \"([^\"]*)\"$") public void el_documento( String
	 * documento) { //
	 * this.browserContext.getTestCaseData().setDocumentoInquilino( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * documento, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el documento aval \"([^\"]*)\"$") public void
	 * el_documento_aval( String documentoAval) { //
	 * this.browserContext.getTestCaseData().setDocumentoAval( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * documentoAval, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre del inquilino \"([^\"]*)\"$") public void
	 * el_nombre_del_inquilino( String nombre) { //
	 * this.browserContext.getTestCaseData().setNombreInquilino( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombre, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre de aval \"([^\"]*)\"$") public void
	 * el_nombre_de_aval( String nombreAval) { //
	 * this.browserContext.getTestCaseData().setNombreAval( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombreAval, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("el primer apellido del inquilino \"([^\"]*)\"$") public void
	 * el_primer_apellido_del_inquilino( String apellido) { //
	 * this.browserContext.getTestCaseData().setPrimerApellidoInquilino( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * apellido, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("el primer apellido del aval \"([^\"]*)\"$") public void
	 * el_primer_apellido_del_aval( String apellidoAval) { //
	 * this.browserContext.getTestCaseData().setPrimerApellidoAval( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * apellidoAval, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^situacion laboral \"([^\"]*)\"$") public void
	 * situacion_laboral( String situacionLaboralInquilino) { //
	 * this.browserContext.getTestCaseData().setSituacionLaboralInquilino(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // situacionLaboralInquilino,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^parentesco aval \"([^\"]*)\"$") public void parentesco_aval(
	 * String parentesco) { //
	 * this.browserContext.getTestCaseData().setParentescoAval( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * parentesco, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^situacion laboral aval \"([^\"]*)\"$") public void
	 * situacion_laboral_aval( String situacionLaboralAval) { //
	 * this.browserContext.getTestCaseData().setSituacionLaboralInquilino(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // situacionLaboralAval,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el acceso \"([^\"]*)\"$") public void inicializo_acceso( String
	 * loginAccess) { // Access //
	 * this.browserContext.getTestCaseData().setAcceso( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * loginAccess, this.browserContext.getTestCaseData().getTestID())); //
	 * this.browserContext.InitializeVariables(this.browserContext.
	 * getTestCaseData().getAcceso()); }
	 *
	 * //@Dado("^el usuario \"([^\"]*)\"$") public void inicializo_usuario(
	 * String user) { System.out.println(this.browserContext.getFeature()); //
	 * User this.browserContext.getTestCaseData().setUsuario(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * user, this.browserContext.getTestCaseData().getTestID()));
	 *
	 * // this.browserContext.applicationAccessHelper.Login(this.browserContext.
	 * getTestCaseData().getUsuario(), //
	 * this.browserContext.GetProperties().passwordComun); }
	 *
	 * //@Dado("^el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$") public void
	 * inicializo_acceso_y_usuario( String loginAccess, String user) { // Access
	 * // this.inicializo_acceso(loginAccess = this.userS.getTestVar("acceso"));
	 * // User // this.inicializo_usuario(user); }
	 *
	 * //@Dado("^el filtro de busqueda \"([^\"]*)\"$") public void
	 * inicializo_filtro_busqueda( String filtroBuscador) {
	 * this.browserContext.getTestCaseData().setFiltroBuscadorEdificio(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * filtroBuscador, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nivel estructura es \"([^\"]*)\"$") public void
	 * nivel_estructura( String nivelEstructura) { //
	 * this.browserContext.getTestCaseData().setNivelEstructura( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nivelEstructura, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^tipo prospect es \"([^\"]*)\"$") public void tipo_prospect(
	 * String tipoProspect) { //
	 * this.browserContext.getTestCaseData().setTipoProspect( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * tipoProspect, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el tipo mediador es \"([^\"]*)\"$") public void tipo_mediador(
	 * String tipoMediador) { //
	 * this.browserContext.getTestCaseData().setTipoProspect( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * tipoProspect, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^numero registro DGS es \"([^\"]*)\"$") public void
	 * numero_resigtro_dgs( String dgs) { //
	 * this.browserContext.getTestCaseData() //
	 * .setDgs(getValuesDataSet(this.browserContext.getTestCaseData().
	 * gethMapDataSet(), dgs,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^la actividad principal es \"([^\"]*)\"$") public void
	 * actividad_principal( String actividadPrincipal) { //
	 * this.browserContext.getTestCaseData().setActividadPrincipal(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // actividadPrincipal,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^nombre comercial prospect es \"([^\"]*)\"$") public void
	 * nombre_comercial_prospect( String nombreComercialProspect) { //
	 * this.browserContext.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombreComercial, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el nombre fiscal mediador es \"([^\"]*)\"$") public void
	 * nombre_fiscal_prospect( String nombreFiscalProspect) { //
	 * this.browserContext.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombreComercial, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el primer apellido mediador es \"([^\"]*)\"$") public void
	 * primer_apellido_mediador( String primerApellidoMediador) { //
	 * this.browserContext.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombreComercial, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^el segundo apellido mediador es \"([^\"]*)\"$") public void
	 * segundo_apellido_mediador( String segundoApellidoMediador) { //
	 * this.browserContext.getTestCaseData().setNombreComercial( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * nombreComercial, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^contacto responsable es \"([^\"]*)\"$") public void
	 * contacto_responsable( String contactoResponsable) { //
	 * this.browserContext.getTestCaseData().setContactoResponsable(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // contactoResponsable,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^idioma es \"([^\"]*)\"$") public void idioma( String idioma) {
	 * // this.browserContext.getTestCaseData().setIdioma( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * idioma, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^telefono principal es \"([^\"]*)\"$") public void
	 * telefono_principal( String tlfPrincipal) { //
	 * this.browserContext.getTestCaseData().setTlfPrincipal( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * tlfPrincipal, this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@Dado("^ejecutivo comercial es \"([^\"]*)\"$") public void
	 * ejecutivo_comercial( String ejecutivoComercial) { //
	 * this.browserContext.getTestCaseData().setEjecutivoComercial(
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * // ejecutivoComercial,
	 * this.browserContext.getTestCaseData().getTestID())); }
	 *
	 * //@
	 * Dado("^el usuario da de alta un proyecto en GO y lo guarda sin contratar$"
	 * ) public void
	 * el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar( String
	 * loginAcess, String user) { logger.
	 * debug("BEGIN - el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar"
	 * );
	 *
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * { this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * String mediador = this.tCData.getMediador(); if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine) && this.tCData != null &&
	 * !mediador.equals("640")) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); } else if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessInnova)) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador(
	 * ).toString()); asignarMediadorPage.clickOnContinuarButton(); }
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.clickOnContinuar();
	 * PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
	 * tomadorYAseguradoPage.clickOnContinuar(); DatosBancariosPage
	 * datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarGuardar();
	 * this.browserContext.writeTestCaseData(); logger.
	 * debug("END - el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar"
	 * ); }
	 *
	 * }
	 *
	 * //@Dado("^se inicia un proyecto con modalidad \"([^\"]*)\"$") public void
	 * se_inicia_un_proyecto_con_modalidad( String Modalidad) {
	 *
	 * // Login
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * if (this.userS.getTestVar("acceso").equals("GestionOnline")) {
	 * GestionOnlineHomePage gestionOnlineHomePage = new
	 * GestionOnlineHomePage(userS);
	 * gestionOnlineHomePage.openMutuaAlquilerConfort(); } else if
	 * (this.userS.getTestVar("acceso").equals("Innova")) { AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar(); }
	 *
	 * // Seleccionar modalidad en Precio page PrecioPorModalidadPage_MAC
	 * precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.selectModalidad(); }
	 *
	 *
	 *
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 * ///// ACTION STEPS
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////////////////////////////////////////////////
	 *
	 *
	 * public ActionsSteps(BrowserContext browserContext) { this.browserContext
	 * = browserContext; this.tCData = this.browserContext.getTestCaseData(); }
	 *
	 * //@Cuando("^agrego un suplemento$") public void agrego_un_suplemento() {
	 * // Login
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.AddSuplementoGeneral(); AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.clickOnContinuarButton();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
	 * ubicacionRiesgoPage.editCalidadConstruccion();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * (); DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar(); }
	 *
	 * //@Cuando("^agrego el motivo suplemento \"([^\"]*)\"$") public void
	 * agrego_el_motivo_suplemento( String motivoSuplemento) {
	 * this.browserContext.getTestCaseData().setMotivosSuplemento(true,
	 * motivoSuplemento); ConfirmarPolizaPage confirmarPolizaPage = new
	 * ConfirmarPolizaPage(userS); //
	 * confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
	 * confirmarPolizaPage.ActivateMotivosSuplemento(); }
	 *
	 * //@Cuando("^emito el suplemento$") public void emito_el_suplemento() {
	 * ConfirmarPolizaPage confirmarPolizaPage = new ConfirmarPolizaPage(userS);
	 * // confirmarPolizaPage.ActivateMotivosSuplemento();
	 * confirmarPolizaPage.ClickOnContinuar();
	 * ValidacionExcepcionesReglasConfirmarPoliza
	 * validacionExcepcionesReglasConfirmarPoliza = new
	 * ValidacionExcepcionesReglasConfirmarPoliza( this.browserContext);
	 * validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBancariosPage.ClickOnEmitirSuplemento(); }
	 *
	 * //@Cuando("^emito un suplemento general con motivo \"([^\"]*)\"$") public
	 * void emito_un_suplemento_general_con_motivo( String motivoSuplemento) {
	 *
	 * // Login
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * // this.tCData.setSuplemento(true); GestionPolizasBuscadorPage
	 * gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(webDriver,
	 * userS.getTestDataManager());
	 * gestionPolizasBuscadorPage.AddSuplementoGeneral(); AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.clickOnContinuarButton();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.ClickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.editInmuebleAndExcluirGarajesYLocales();
	 * ubicacionRiesgoPage.editCalidadConstruccion();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * (); DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * this.browserContext.getTestCaseData().setMotivosSuplemento(true,
	 * motivoSuplemento); ConfirmarPolizaPage confirmarPolizaPage = new
	 * ConfirmarPolizaPage(userS);
	 * confirmarPolizaPage.ActivateMotivosSuplementoAndClickOnContinuar();
	 * ValidacionExcepcionesReglasConfirmarPoliza
	 * validacionExcepcionesReglasConfirmarPoliza = new
	 * ValidacionExcepcionesReglasConfirmarPoliza( this.browserContext);
	 * validacionExcepcionesReglasConfirmarPoliza.ClickOnContinuarButton();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager()); // DocumentacionPage documentacionPage = new
	 * DocumentacionPage(userS); // documentacionPage.SubirFichero();
	 * datosBancariosPage.ClickOnEmitirSuplemento(); // MensajeConfirmacionPage
	 * mensajeConfirmacionPage = new MensajeConfirmacionPage(webDriver,
	 * userS.getTestDataManager()); //
	 * mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly(); }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion y la convierto en una contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_y_la_convierto_en_una_contratacion_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * // Asignar mediador AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * (); PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this.
	 * tCData.getTomador()); PrecioPorModalidadPage precioPorModalidadPage = new
	 * PrecioPorModalidadPage(userS);
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
	 * tomadorYAseguradoPage.clickOnContinuar(); DatosBancariosPage
	 * datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarContratar();
	 *
	 * this.browserContext.writeTestCaseData();
	 * this.browserContext.getWebDriver().quit(); }
	 *
	 * //@Cuando("^se modifica el proyecto en Innova y lo guarda de nuevo$")
	 * public void se_modifica_el_proyecto_en_Innova_y_lo_guarda_de_nuevo(
	 * String loginAcess, String user) { loginAcess =
	 * this.tCData.getCambioAcceso();
	 *
	 * logger.
	 * debug("BEGIN - se modifica el proyecto en Innov@ y lo guarda de nuevo");
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getCambioUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacion()); GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscacorPage = new
	 * GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscacorPage.modificarProjecto(); AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.clickOnContinuarButton(); UbicacionRiesgoPage
	 * ubicacionRiesgoPage = new UbicacionRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup();
	 * ubicacionRiesgoPage.modifyReferenciaCatastral();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.seleccionarModalidad();
	 * precioPorModalidadPage.clickOnContinuar();
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager()); datosBancariosPage.ClickOnGuardar();
	 * this.browserContext.writeTestCaseData();
	 * this.browserContext.getWebDriver().quit(); logger.
	 * debug("END - se modifica el proyecto en Innov@ y lo guarda de nuevo");
	 *
	 * }
	 *
	 * //@
	 * Cuando("^cambio la cotización usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void modifico_la_cotización( String loginAcess, String user) {
	 *
	 * // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
	 * loginAcess, // this.tCData.getTestID()); loginAcess =
	 * this.tCData.getCambioAcceso();
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * logger.debug("BEGIN - modifico_la_cotización");
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getCambioUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacion()); GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscacorPage = new
	 * GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscacorPage.modificarProjecto(); AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.clickOnContinuarButton(); UbicacionRiesgoPage
	 * ubicacionRiesgoPage = new UbicacionRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup();
	 * ubicacionRiesgoPage.modifyReferenciaCatastral();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); //
	 * this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
	 * this.detallesRiesgoPage.modificarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.seleccionarModalidad();
	 * precioPorModalidadPage.clickOnContinuar();
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.clickOnContinuar();
	 * DatosBancariosPage datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBancariosPage.modificarFormaPagoYPulsarContratar();
	 * this.browserContext.writeTestCaseData(); //
	 * this.browserContext.getWebDriver().quit();
	 * logger.debug("END - modifico_la_cotización"); } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion y convierto esta simulacion a un projecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * )
	 *
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion, y la convierto a un proyecto, y la guardo sin contratar usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_y_la_convierto_a_un_proyecto_y_la_guardo_sin_contratar_usando(
	 * String loginAcess, String user) {
	 *
	 * loginAcess = this.userS.getTestVar("acceso");
	 *
	 * logger.
	 * debug("BEGIN - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando"
	 * ); if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * String mediador = this.tCData.getMediador(); if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine) && this.tCData != null &&
	 * !mediador.equals("640")) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); } else if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessInnova)) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador(
	 * ).toString()); asignarMediadorPage.clickOnContinuarButton(); }
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); //
	 * this.detallesRiesgoPage.executeActionsInPageDetallesRiesgoPage();
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.clickOnContinuar();
	 * PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.ActivateclausesAndClickOnContinue(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager()); tomadorYAseguradoPage.AddDatosTomador();
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
	 * tomadorYAseguradoPage.clickOnContinuar(); DatosBancariosPage
	 * datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBancariosPage.introducirFormaPagoYPulsarGuardar();
	 * this.browserContext.writeTestCaseData(); logger.
	 * debug("END - doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_y_la_guardo_sin_contratar_usando"
	 * ); }
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
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); // this.detallesRiesgoPage.
	 * ExecuteActionsInPageDetallesRiesgoPageWithoutClickinOnContinue();
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar(); } }
	 *
	 * //@
	 * Cuando("^doy de alta un proyecto que llega hasta la pantalla de detalles de riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_detalles_de_riesgo_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { // loginAcess =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { // loginAcess =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * ();
	 *
	 * PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto(); } }
	 *
	 * //@
	 * Cuando("^doy de alta una simulacion que llega hasta la pantalla de precio usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador(
	 * ).toString()); asignarMediadorPage.clickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
	 * ubicacionRiesgoPage.clickOnContinuar();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * (); PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); precioPage.ClickOnConvertirAProjecto();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.FillTomadorData(this.tCData.getTomador());
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager());
	 * precioPorModalidadPage.ExecuteActionsInPrecioPorModalidadPage(); }
	 *
	 * //@
	 * Cuando("^doy de alta un projecto que llega hasta la pantalla de datos básicos del tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_un_projecto_que_llega_hasta_la_pantalla_de_datos_básicos_del_tomador_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) { // loginAcess =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), loginAcess,
	 * this.tCData.getTestID()); loginAcess = this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue();
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgo();
	 * ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionExcepcionesReglasDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * validacionExcepcionesReglasDetallesRiesgoPage.ClickOnContinuarAndValidate
	 * (); // PrecioPage precioPage = new PrecioPage(webDriver,
	 * userS.getTestDataManager()); // precioPage.ClickOConvertirAProjecto(); }
	 * }
	 *
	 * //@Cuando("^continuo en datos básicos del tomador$") public void
	 * continuo_en_datos_básicos_del_tomador() { DatosBasicosTomadorPage
	 * datosBasicosTomadorPage = new DatosBasicosTomadorPage(webDriver,
	 * userS.getTestDataManager());
	 * datosBasicosTomadorPage.ExecuteActionsInPageTomadorYAseguradoPage(this.
	 * tCData.getTomador()); }
	 *
	 * //@
	 * Cuando("^lo consulto en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * lo_consulto_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza())); }
	 *
	 * //@
	 * Cuando("^lo consulto por dni en el buscador de polizas usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * lo_consulto_por_dni_en_el_buscador_de_polizas_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndSearchPolizaByNifNie(
	 * this.tCData.getUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * this.tCData.getTomadorDNI()); }
	 *
	 * //@
	 * Cuando("^Intento dar de alta una simulación que solo va a llegar hasta datos del riesgo usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void intento_dar_alta_simulacion_hasta_datos_riesgo( String
	 * loginAcess, String user) throws Exception {
	 *
	 * // loginAcess = getValuesDataSet(this.tCData.gethMapDataSet(),
	 * loginAcess, // this.tCData.getTestID()); loginAcess =
	 * this.userS.getTestVar("acceso");
	 *
	 * if (loginAcess.equals(ProjectConstants.LoginAccessGestionLine) &&
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible) ||
	 * this.browserContext.getProperties().GestionOnlineDisponible.equals(
	 * ProjectConstants.GestionOnlineDisponible)) {
	 * logger.debug("BEGIN - intento_dar_alta_simulacion_hasta_datos_riesgo");
	 * this.browserContext.initializeVariables(loginAcess);
	 * this.browserContext.applicationAccessHelper.LoginAndCreateSimulation(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.SeleccionarMediadorPorCodigo(this.tCData.getMediador(
	 * ).toString()); asignarMediadorPage.clickOnContinuarButton();
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.addInmueble(this.tCData.getInmueble());
	 * ubicacionRiesgoPage.clickOnContinuar(); DetallesRiesgoPage
	 * detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); detallesRiesgoPage.completarDatosRiesgo();
	 * detallesRiesgoPage.ClikOnContinuar(); AvisoSistemaPage avisoSistemaPage =
	 * new AvisoSistemaPage(userS); avisoSistemaPage.CheckmsgAvisoPlantasAlto();
	 * this.browserContext.writeTestCaseData();
	 * logger.debug("END - intento_dar_alta_simulacion_hasta_datos_riesgo"); } }
	 *
	 * //@
	 * Cuando("^lo consulto en el buscador de cotizaciones usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void lo_consulto_en_el_buscador_de_cotizaciones( String
	 * loginAcess, String user) {
	 * logger.debug("BEGIN - lo_consulto_en_el_buscador_de_cotizaciones");
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacion()); //
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.tCData.getCambioAcceso()); //
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getCambioUsuario(), //
	 * this.browserContext.getProperties().passwordComun, //
	 * this.tCData.getNoCotizacion());
	 * logger.debug("END - lo_consulto_en_el_buscador_de_cotizaciones"); }
	 *
	 * //@Cuando("^continuo en Detalles de riesgo$") public void
	 * continuo_en_detalles_riesgo() {
	 * logger.debug("BEGIN - continuo_en_detalles_riesgo");
	 * this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosEnDetallesRiesgoSinContinuar();
	 * this.detallesRiesgoPage.ClikOnContinuar();
	 * logger.debug("END - continuo_en_detalles_riesgo"); }
	 *
	 * //@Cuando("^modifico el capital continente a '(\\d+)'$") public void
	 * modifico_el_capital_continente_a( Integer capitalContinente) {
	 * this.tCData.setCapitalContinente(capitalContinente); }
	 *
	 * //@Cuando("^cierro el navegador$") public void cierro_navegador() {
	 * this.webDriver.quit(); }
	 *
	 * //@
	 * Entonces("^el campo cotización contiene el valor del codigo de cotización$"
	 * ) public void
	 * el_campo_cotización_contiene_el_valor_del_codigo_de_cotizacion() {
	 * logger.debug("BEGIN - el_campo_cotización_contiene_el_valor");
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new
	 * GestionCotizacionesBuscadorPage(userS); String cotizacion =
	 * gestionCotizacionesBuscacorPage.getCotizacion();
	 * Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
	 * logger.debug("END - el_campo_cotización_contiene_el_valor"); }
	 *
	 * //@
	 * Dada("^se descargan los ficheros del suplemento en la carpeta \"([^\"]*)\"$"
	 * ) public void se_descargan_los_ficheros_del_suplemento_en_la_carpeta(
	 * String filesPath) { logger.
	 * debug("BEGIN - se_descargan_los_ficheros_del_suplemento_en_la_carpeta");
	 * MensajeConfirmacionPage mensajeConfirmacionPage = new
	 * MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.DownlodadDocumentsToFolder(filesPath);
	 *
	 * logger.
	 * debug("END - se_descargan_los_ficheros_del_suplemento_en_la_carpeta"); }
	 *
	 * //@
	 * Cuando("^doy de alta un proyecto MAC que llega hasta la pantalla contratación usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 *
	 * // Login
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
	 * LoginAccessGestionLine)) // { // GestionOnlineHomePage
	 * gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
	 * userS.getTestDataManager()); //
	 * gestionOnlineHomePage.openMutuaAlquilerConfort(); // } if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessInnova)) { AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar(); //
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); //
	 * innovaHomePage.OpenMutuaAlquilerConfort(); }
	 *
	 * // SCS Precio PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
	 *
	 * // SCS Inquilinos InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC
	 * = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage(); }
	 *
	 * //@Cuando("^completo el proceso de contratacion MAC sin autorizacion$")
	 * public void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() {
	 * logger.
	 * debug("BEGIN - completo_el_proceso_de_contratacion_MAC_sin_autorizacion"
	 * ); // Continuar InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC =
	 * new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.clickOnContinuar(); // Rellenar datos de
	 * contratacion, pagina 3 TomadorYAseguradoPage_MAC
	 * tomadorYAseguradoPage_MAC = new
	 * TomadorYAseguradoPage_MAC(userS);
	 * tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
	 *
	 * InmueblePage_MAC inmueblePage_MAC = new
	 * InmueblePage_MAC(userS);
	 * inmueblePage_MAC.executeActionsInInmueblePage();
	 *
	 * DocumentacionPage_MAC documentacionPage_MAC = new
	 * DocumentacionPage_MAC(userS);
	 * documentacionPage_MAC.addDocumentContratacion();
	 *
	 * ContratacionPage_MAC contratacionPage_MAC = new
	 * ContratacionPage_MAC(userS);
	 * contratacionPage_MAC.seleccionarCheckYContratar(); logger.
	 * debug("END - completo_el_proceso_de_contratacion_MAC_sin_autorizacion");
	 * }
	 *
	 * //@Cuando("^se informa de que la poliza no se puede emitir$") public void
	 * se_informa_de_que_la_poliza_no_se_puede_emitir() { // Compropar el estado
	 * de la poliza ContratacionPage_MAC contratacionPage_MAC = new
	 * ContratacionPage_MAC(userS);
	 *
	 * Assert.assertTrue(contratacionPage_MAC.checkPolizaError()); }
	 *
	 * //@
	 * Cuando("^busco el proyecto usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void busco_el_proyecto_usando_el_acceso_y_el_usuario( String
	 * loginAcess, String user) {
	 *
	 * // Login
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacionMAC());
	 *
	 * // Abrir el buscador de proyectos // if
	 * (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
	 * LoginAccessGestionLine)) // { // GestionOnlineHomePage
	 * gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
	 * userS.getTestDataManager()); //
	 * gestionOnlineHomePage.openMisProyectosWeb(); //
	 * gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC())
	 * ;
	 *
	 * //
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), //
	 * this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacion()); // }
	 *
	 * // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
	 * LoginAccessInnova)) // { //
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), //
	 * this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacion()); // }
	 *
	 * }
	 *
	 * //@
	 * Cuando("autorizo el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$"
	 * ) public void autorizo_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
	 * String loginAcess, String user) {
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.tCData.getAccesoAuth());
	 * this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(
	 * this.tCData.getUsuarioAuth(),
	 * this.browserContext.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage =
	 * new InnovaHomePage(userS); innovaHomePage.OpenGestionAutorizaciones();
	 * GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización",
	 * "Pendiente de autorizar", this.tCData.getNoCotizacionMAC());
	 *
	 * // Autorizar el proyecto gestionAutorizacionesPage.autorizar(); }
	 *
	 * //@Cuando("envio el proyecto a la compañia") public void
	 * envio_el_proyecto_a__la_compania() {
	 * logger.debug("BEGIN - envio_el_proyecto_a__la_compania");
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.enviarACompania(); //
	 * this.browserContext.getWebDriver().quit();
	 * logger.debug("END - envio_el_proyecto_a__la_compania"); }
	 *
	 * //@
	 * Cuando("deniego el proyecto MAC usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$"
	 * ) public void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
	 * String loginAcess, String user) { logger.
	 * debug("BEGIN - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario"
	 * ); // Login this.browserContext.initializeVariables(loginAcess =
	 * this.tCData.getAccesoAuth());
	 * this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(
	 * this.tCData.getUsuarioAuth(),
	 * this.browserContext.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage =
	 * new InnovaHomePage(userS); innovaHomePage.OpenGestionAutorizaciones();
	 * GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización",
	 * "Pendiente de autorizar", this.tCData.getNoCotizacionMAC());
	 *
	 * // Denegar el proyecto gestionAutorizacionesPage.denegar();
	 * this.browserContext.getWebDriver().quit(); logger.
	 * debug("END - deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario");
	 * }
	 *
	 * //@
	 * Cuando("^completo el proceso de contratacion usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$"
	 * ) public void
	 * completo_el_proceso_de_contratacion_usando_el_acceso_y_usuario( String
	 * loginAcess, String user) {
	 *
	 * loginAcess = this.userS.getTestVar("acceso"); if
	 * (loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) { // Login a
	 * GestionLine this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso")); //
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this
	 * .tCData.getUsuario(), //
	 * this.browserContext.getProperties().passwordComun);
	 *
	 * //
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), //
	 * this.browserContext.getProperties().passwordComun);
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacionMAC());
	 *
	 * // Abrir el buscador de proyectos GestionOnlineHomePage
	 * gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
	 * userS.getTestDataManager()); //
	 * gestionOnlineHomePage.openMisProyectosWeb(); //
	 * gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC())
	 * ;
	 *
	 * // Click en modificar gestionOnlineHomePage.modificarProyecto(); }
	 *
	 * else if (loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
	 *
	 * // Login to Innov@ this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun,
	 * this.tCData.getNoCotizacionMAC());
	 *
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new
	 * GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscadorPage.modificarProjecto(); AsignarMediadorPage
	 * asignarMediadorPage = new AsignarMediadorPage(webDriver,
	 * userS.getTestDataManager());
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
	 *
	 * }
	 *
	 * PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.continuar();
	 *
	 * // Continuar InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC =
	 * new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.clickOnContinuar();
	 *
	 * // Rellenar datos de contratacion, pagina 3 TomadorYAseguradoPage_MAC
	 * tomadorYAseguradoPage_MAC = new
	 * TomadorYAseguradoPage_MAC(userS);
	 * tomadorYAseguradoPage_MAC.executeActionsInTomadorYAseguradoPage();
	 *
	 * InmueblePage_MAC inmueblePage_MAC = new
	 * InmueblePage_MAC(userS);
	 * inmueblePage_MAC.executeActionsInInmueblePage();
	 *
	 * DocumentacionPage_MAC documentacionPage_MAC = new
	 * DocumentacionPage_MAC(userS);
	 * documentacionPage_MAC.addDocumentContratacion();
	 *
	 * ContratacionPage_MAC contratacionPage_MAC = new
	 * ContratacionPage_MAC(userS);
	 * contratacionPage_MAC.seleccionarCheckYContratar(); }
	 *
	 * //@Cuando("^completo el proceso de contratacion MAC$") public void
	 * completo_el_proceso_de_contratacion_MAC() { // Click en contratar
	 *
	 * // Completar los datos
	 *
	 * //
	 *
	 * }
	 *
	 * //@
	 * Cuando("^valido un proyecto \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void valido_un_proyecto_usando_el_acceso_y_el_usuario( String
	 * loginAcess, String user) {
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.LoginAndCreateProjectMEC(this
	 * .tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
	 *
	 * // Asignar mediador AsignarMediadorPage asignarMediadorPage = new
	 * AsignarMediadorPage(userS);
	 * asignarMediadorPage.SelectMediadorMACAndClickOnContinuar();
	 *
	 * // SCS Precio PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
	 *
	 * // SCS Inquilinos InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC
	 * = new InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.
	 * executeActionsInInquilinosAvalistasPageSinDocumentacion(); //
	 * inquilinosAvalistasPage_MAC.ValidacionViabilidadInquilino(); }
	 *
	 * //@Cuando("^valido el proyecto$") public void valido_el_proyecto() {
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino(); }
	 *
	 * //@
	 * Cuando("^busco un edificio por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void busco_un_edificio_por_usando_el_acceso_y_el_usuario( String
	 * filtroBuscador, String loginAcess, String user) {
	 *
	 * this.tCData.setFiltroBuscadorEdificio(getValuesDataSet(this.tCData.
	 * gethMapDataSet(), filtroBuscador, this.tCData.getTestID()));
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new
	 * FichaEdificioPage(userS); fichaEdificioPage.accederAlBuscadorEdificios();
	 * fichaEdificioPage.buscarConFiltroBusqueda(); }
	 *
	 * //@Cuando("^abro la ficha de edificio desde el grid de resultados$")
	 * public void abro_ficha_edificio_desde_grid_resultados() { //
	 * FichaEdificioPage FichaEdificioPage fichaEdificioPage = new
	 * FichaEdificioPage(userS); fichaEdificioPage.openFichaEdificioDesdeGrid();
	 * }
	 *
	 * //@
	 * Cuando("^busco edificios por direcciones iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void busco_edificios_por_direcciones_con_el_fichero( String
	 * nombreFichero) {
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new
	 * FichaEdificioPage(userS); fichaEdificioPage.accederAlBuscadorEdificios();
	 *
	 * fichaEdificioPage.setFiltroBusqueda(ProjectConstants.
	 * FILTRO_BUSCADOR_DIRECCION);
	 * fichaEdificioPage.iterarEdificiosPorDirecciones(getValuesDataSet(this.
	 * tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID())); }
	 *
	 * //@
	 * Cuando("^busco edificios por direcciones en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void
	 * busco_edificios_por_direcciones_en_buscador_MEC_con_el_fichero( String
	 * nombreFichero) { this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMutuaEdificioConfort();
	 * innovaHomePage.CreateNewProject();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.iterarEdificiosPorDirecciones(getValuesDataSet(this.
	 * tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID())); //
	 * fichaEdificioPage.setFiltroBusqueda(MutuaPropietariosConstants.
	 * FILTRO_BUSCADOR_DIRECCION); //
	 * fichaEdificioPage.IterarEdificiosPorDirecciones( //
	 * getValuesDataSet(this.tCData.gethMapDataSet(), nombreFichero,
	 * this.tCData.getTestID())); }
	 *
	 * //@
	 * Cuando("^busco edificios por referencias iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void busco_edificios_por_referencias_con_el_fichero( String
	 * nombreFichero) { this.inicio_sesion();
	 *
	 * // FichaEdificioPage FichaEdificioPage fichaEdificioPage = new
	 * FichaEdificioPage(userS); fichaEdificioPage.accederAlBuscadorEdificios();
	 *
	 * fichaEdificioPage.setFiltroBusqueda(ProjectConstants.
	 * FILTRO_BUSCADOR_CATASTRAL);
	 * fichaEdificioPage.iterarEdificiosPorReferencias(getValuesDataSet(this.
	 * tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID())); }
	 *
	 * //@
	 * Cuando("^busco edificios por referencias en el buscador MEC iterando con los datos del fichero \"([^\"]*)\"$"
	 * ) public void
	 * busco_edificios_por_referencias_en_el_buscador_MEC_con_el_fichero( String
	 * nombreFichero) { this.inicio_sesion();
	 *
	 * // FichaEdificioPage InnovaHomePage innovaHomePage = new
	 * InnovaHomePage(userS); innovaHomePage.openMutuaEdificioConfort();
	 * innovaHomePage.CreateNewProject();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * System.out.println("Nombre fichero en action steps: " + nombreFichero);
	 * //
	 * ubicacionRiesgoPage.iterarEdificiosPorReferencias(getValuesDataSet(this.
	 * tCData.gethMapDataSet(), nombreFichero, this.tCData.getTestID()));
	 * ubicacionRiesgoPage.iterarEdificiosPorReferencias(
	 * System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder +
	 * "/" + this.tCData.value("fichero"));
	 *
	 * }
	 *
	 * //@Cuando("^modifico los ingresos a \"([^\"]*)\"$") public void
	 * modificar_ingresos( String ingresos) { //
	 * this.tCData.setIngresosNetosInquilino(getValuesDataSet(this.tCData.
	 * gethMapDataSet(), ingresos, this.tCData.getTestID()) != null // ?
	 * Integer.parseInt(getValuesDataSet(this.tCData.gethMapDataSet(), ingresos,
	 * this.tCData.getTestID())) : null);
	 *
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.modificarRentasInquilino();
	 *
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino();
	 *
	 * }
	 *
	 * //@Cuando("^añado avalista$") public void anado_avalista() {
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.addDatosAval();
	 *
	 * inquilinosAvalistasPage_MAC.anadirDocumentacionAval();
	 *
	 * inquilinosAvalistasPage_MAC.validacionViabilidadInquilino(); }
	 *
	 * //@Cuando("^inicio sesion$") public void inicio_sesion() {
	 * System.out.println("Acceso: " + this.userS.getTestVar("acceso"));
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun); }
	 *
	 * //@
	 * Cuando("^inicio sesion con el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void inicio_sesion_con_acceso_y_usuario( String loginAccess,
	 * String user) { // this.tCData.setAcceso( //
	 * getValuesDataSet(this.tCData.gethMapDataSet(), loginAccess,
	 * this.tCData.getTestID())); //
	 * this.tCData.setUsuario(this.tCData.getUsuario());
	 *
	 * this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun); }
	 *
	 * //@
	 * Cuando("^doy de alta una simulación actualizando datos iterando por el fichero \"([^\"]*)\"$"
	 * ) public void
	 * doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero( String
	 * fileName) { logger.
	 * debug("BEGIN - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero"
	 * ); String logText = "", address = "";
	 * this.tCData.setInmueble("direccion por defecto"); // fileName =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), fileName,
	 * this.tCData.getTestID()); fileName = this.tCData.value("fichero");
	 * System.out.println("Filename: " + fileName); fileName =
	 * fileName.substring(0, fileName.length() - 4);
	 * System.out.println("Filename: " + fileName);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray(
	 * System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder +
	 * "/" + fileName + ".csv", false); // String[][] datosAltoValor =
	 * loadDataFileToArray(fileName, false);
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) {
	 * innovaHomePage.CreateNewSimulation(); // address =
	 * getValuesDataSetByID(datosAltoValor, "provincia", i) + ", " +
	 * getValuesDataSetByID(datosAltoValor, "poblacion", i) + ", " // +
	 * getValuesDataSetByID(datosAltoValor, "direccion", i) + ", " +
	 * getValuesDataSetByID(datosAltoValor, "numero", i);
	 *
	 * // address = getValuesDataSetByID(datosAltoValor, "ref_catastral", i);
	 *
	 * this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor,
	 * "ref_catastral", i)); //
	 * this.tCData.setDireccionProvincia(getValuesDataSetByID(datosAltoValor,
	 * "provincia", i)); //
	 * this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosAltoValor,
	 * "poblacion", i)); //
	 * this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosAltoValor,
	 * "direccion", i)); //
	 * this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosAltoValor,
	 * "numero", i)); // String codigoPostal =
	 * getValuesDataSetByID(datosAltoValor, "codigo_postal", i); //
	 * this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" +
	 * codigoPostal : codigoPostal);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try {
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 *
	 * if (!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) { logText +=
	 * "Mas de una referencia catastral encontrada para la direccion " + address
	 * + "\n"; System.out.println("Mas de una referencia catastral encontrada");
	 * this.browserContext.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); writeFile(fileName +
	 * " (log file).txt", logText); continue; }
	 * ubicacionRiesgoPage.closeNotification();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager()); String anyoConstruccion =
	 * this.detallesRiesgoPage.completarDatosRiesgoMinimos();
	 * this.detallesRiesgoPage.ClikOnContinuar();
	 *
	 * PrecioPorModalidadPage precioPorModalidadPage = new
	 * PrecioPorModalidadPage(userS); //
	 * precioPorModalidadPage.modificarRC("600.000,00"); //
	 * precioPorModalidadPage.agregarDescuento(getValuesDataSet(this.tCData.
	 * gethMapDataSet(), this.tCData.getDescuento(), //
	 * this.tCData.getTestID()));
	 * precioPorModalidadPage.agregarDescuento(this.tCData.getDescuento());
	 *
	 * String precioTotal = precioPorModalidadPage.getPrecioTotal();
	 * precioPorModalidadPage.clickOnGuardar(); String numSimulacion =
	 * precioPorModalidadPage.getNumSimulacion();
	 *
	 * datosAltoValor = setValuesDataSetByID(datosAltoValor, "prima_total", i,
	 * precioTotal); datosAltoValor = setValuesDataSetByID(datosAltoValor,
	 * "anyo_antiguedad", i, anyoConstruccion); datosAltoValor =
	 * setValuesDataSetByID(datosAltoValor, "numero_proyecto", i,
	 * numSimulacion);
	 *
	 * writeArrayIntoCSVFile(fileName + " (modificado).csv", datosAltoValor);
	 *
	 * precioPorModalidadPage.clickOnCancelar(); } catch (Exception e) { logText
	 * += "Comprobacion de datos no contemplada para la direccion " + address +
	 * "\n"; writeFile(fileName + " (log file).txt", logText);
	 * System.out.println("Comprobaciones de datos no contempladas");
	 * this.browserContext.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * this.browserContext.getWebDriver().quit();
	 *
	 * logger.
	 * debug("END - doy_alta_simulacion_actualizando_datos_iterando_por_el_fichero"
	 * ); }
	 *
	 * //@Cuando("^prueba$") public void prueba() { // this.tCData.prueba(); }
	 *
	 * //@
	 * Cuando("^modifico un proyecto iterando por el fichero \"([^\"]*)\" cambiando el mediador$"
	 * ) public void modifico_proyecto_iterando_cambio_mediador( String
	 * fileName) {
	 * logger.debug("BEGIN - modifico_proyecto_iterando_cambio_mediador");
	 * fileName = getValuesDataSet(this.tCData.gethMapDataSet(), fileName,
	 * this.tCData.getTestID()); fileName = fileName.substring(0,
	 * fileName.length() - 4); // fileName = tCData.value("fileName") //
	 * DataObject data = new
	 * DataObject(FileUtils.csvFileToMData(tCData.value("fileName")));
	 * this.inicio_sesion();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray(fileName + ".csv",
	 * false);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.OpenGestionCotizaciones();
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) { //
	 * data.setKey(Integer.toString(i)); // data.value("ref_catastral"); String
	 * cotizacion = getValuesDataSetByID(datosAltoValor, "numero_proyecto", i);
	 *
	 * if (cotizacion == null || cotizacion.isEmpty()) continue;
	 *
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new
	 * GestionCotizacionesBuscadorPage(userS);
	 * gestionCotizacionesBuscadorPage.searchCotizacion(cotizacion);
	 * gestionCotizacionesBuscadorPage.modificarProjecto();
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar();
	 *
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.clickOnGuardar();
	 * ubicacionRiesgoPage.closeAvisoSistemaPopup();
	 *
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.OpenGestionCotizaciones(); }
	 *
	 * this.browserContext.getWebDriver().quit();
	 *
	 * logger.debug("END - modifico_proyecto_iterando_cambio_mediador"); }
	 *
	 * //@
	 * Cuando("^doy de alta un proyecto actualizando datos iterando por el fichero \"([^\"]*)\"$"
	 * ) public void
	 * doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero( String
	 * fileName) { logger.
	 * debug("BEGIN - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero"
	 * ); String logText = "", address = "";
	 * this.tCData.setInmueble("direccion por defecto"); fileName =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), fileName,
	 * this.tCData.getTestID()); fileName = fileName.substring(0,
	 * fileName.length() - 4);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosCargaMEC = loadDataFileToArray(fileName + ".csv", false);
	 * datosCargaMEC = addColumnToArray(datosCargaMEC, "capital_continente");
	 * datosCargaMEC = addColumnToArray(datosCargaMEC, "total_asegurado");
	 * datosCargaMEC = addColumnToArray(datosCargaMEC, "capital_contenido");
	 * datosCargaMEC = addColumnToArray(datosCargaMEC,
	 * "precios_antes_proyecto"); datosCargaMEC =
	 * addColumnToArray(datosCargaMEC, "precios_despues_proyecto");
	 * datosCargaMEC = addColumnToArray(datosCargaMEC, "precio_basic");
	 * datosCargaMEC = addColumnToArray(datosCargaMEC, "precio_plus");
	 *
	 * for (int i = 1; i < datosCargaMEC.length; i++) {
	 * innovaHomePage.CreateNewSimulation(); address =
	 * getValuesDataSetByID(datosCargaMEC, "provincia", i) + ", " +
	 * getValuesDataSetByID(datosCargaMEC, "poblacion", i) + ", " +
	 * getValuesDataSetByID(datosCargaMEC, "direccion", i) + ", " +
	 * getValuesDataSetByID(datosCargaMEC, "numero", i);
	 *
	 * this.tCData.setDireccionProvincia(getValuesDataSetByID(datosCargaMEC,
	 * "provincia", i));
	 * this.tCData.setDireccionPoblacion(getValuesDataSetByID(datosCargaMEC,
	 * "poblacion", i));
	 * this.tCData.setDireccionNombreVia(getValuesDataSetByID(datosCargaMEC,
	 * "direccion", i));
	 * this.tCData.setDireccionNumeroVia(getValuesDataSetByID(datosCargaMEC,
	 * "numero", i)); String codigoPostal = getValuesDataSetByID(datosCargaMEC,
	 * "codigo_postal", i);
	 * this.tCData.setDireccionCodigoPostal(codigoPostal.length() == 4 ? "0" +
	 * codigoPostal : codigoPostal);
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try {
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 *
	 * if (!ubicacionRiesgoPage.fillInmuebleAndGetAvailability()) { logText +=
	 * "Mas de una referencia catastral encontrada para la direccion " + address
	 * + "\n"; System.out.println("Mas de una referencia catastral encontrada");
	 * this.browserContext.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); writeFile(fileName +
	 * " (log file).txt", logText); continue; }
	 * ubicacionRiesgoPage.closeNotification();
	 * ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosRiesgoMinimos();
	 *
	 * String capitalContinente =
	 * this.detallesRiesgoPage.getCapitalContinente(); String totalAsegurado =
	 * this.detallesRiesgoPage.getCapitalContinenteTotalAsegurado(); String
	 * capitalContenido = this.detallesRiesgoPage.getCapitalContenido();
	 *
	 * this.detallesRiesgoPage.ClikOnContinuar();
	 *
	 * PrecioPorModalidadPage precioPorModalidadPage = new
	 * PrecioPorModalidadPage(userS); String precioComplet =
	 * precioPorModalidadPage.getPrecioTotal(); String precioBasic =
	 * precioPorModalidadPage.getPrecioBasic(); String precioPlus =
	 * precioPorModalidadPage.getPrecioPlus();
	 *
	 * precioPorModalidadPage.clickOnGuardar(); // TODO // Convertir a proyecto
	 * // seguir los pasos // Terminar de crear la poliza
	 *
	 * // escribir los datos: numeroProyecto, precios antes de proyecto, precios
	 * despues de // proyecto
	 *
	 * datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "capital_continente",
	 * i, capitalContinente); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "total_asegurado", i,
	 * totalAsegurado); datosCargaMEC = setValuesDataSetByID(datosCargaMEC,
	 * "capital_contenido", i, capitalContenido); datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "prima_total", i, precioComplet);
	 * datosCargaMEC = setValuesDataSetByID(datosCargaMEC, "precio_basic", i,
	 * precioBasic); datosCargaMEC = setValuesDataSetByID(datosCargaMEC,
	 * "precio_plus", i, precioPlus); // datosCargaMEC =
	 * setValuesDataSetByID(datosCargaMEC, "numero_proyecto", i, numSimulacion);
	 *
	 * writeArrayIntoCSVFile(fileName + " - " + new
	 * ConfigurationProperties().environment + " (resultados).csv",
	 * datosCargaMEC);
	 *
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } catch (Exception e) {
	 * logText += "Comprobacion de datos no contemplada para la direccion " +
	 * address + "\n"; writeFile(fileName + " (log file).txt", logText);
	 * System.out.println("Comprobaciones de datos no contempladas\n\t- " +
	 * e.toString()); this.browserContext.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * this.browserContext.getWebDriver().quit();
	 *
	 * logger.
	 * debug("END - doy_alta_proyecto_actualizando_datos_iterando_por_el_fichero"
	 * ); }
	 *
	 * //@
	 * Cuando("^se da de alta un proyecto MEC donde la antiguedad del edificio es mayor que 50 anyos y se solicita peritacion, iterando por el fichero \"([^\"]*)\""
	 * ) public void
	 * se_dan_de_alta_masivamente_proyectos_MEC_donde_la_antiguedad_del_edificio_es_mayor_que_50_anyos(
	 * String fileName) { logger.
	 * debug("BEGIN - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50");
	 * String logText = "", address = ""; //
	 * this.tCData.setInmueble("direccion por defecto"); fileName =
	 * this.tCData.value("fichero"); System.out.println("Filename: " +
	 * fileName); fileName = fileName.substring(0, fileName.length() - 4);
	 * System.out.println("Filename: " + fileName);
	 *
	 * this.inicio_sesion();
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMutuaEdificioConfort();
	 *
	 * String[][] datosAltoValor = loadDataFileToArray(
	 * System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder +
	 * "/" + fileName + ".csv", false);
	 *
	 * for (int i = 1; i < datosAltoValor.length; i++) {
	 * innovaHomePage.CreateNewProject();
	 *
	 * this.tCData.setReferenciaCatastral(getValuesDataSetByID(datosAltoValor,
	 * "ref_catastral", i));
	 *
	 * AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
	 * asignarMediadorPage.selectMediadorAndClickOnContinuar(); try {
	 * UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
	 * ubicacionRiesgoPage.fillInmuebleAndClickOnContinue(); //
	 * ubicacionRiesgoPage.closeNotification(); //
	 * ubicacionRiesgoPage.clickOnContinuar();
	 *
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage
	 * validacionesExcepcionesReglasUbicacionRiesgo = new
	 * ValidacionesExcepcionesReglasUbicacionRiesgoPage( this.browserContext);
	 * validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada()
	 * ; this.detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * this.detallesRiesgoPage.completarDatosRiesgoMinimos(); // Enter values
	 * madera and deshabitación.
	 * this.detallesRiesgoPage.enterAnyoConstruccionMoreThan50();
	 * this.detallesRiesgoPage.ClikOnContinuar();
	 * ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton();
	 * DatosBasicosTomadorPage datosBasicosTomadorPage = new
	 * DatosBasicosTomadorPage(userS);
	 * datosBasicosTomadorPage.fillStaticTomadorData();
	 * datosBasicosTomadorPage.clickOnContinuar(); PrecioPorModalidadPage
	 * precioPorModalidadPage = new PrecioPorModalidadPage(webDriver,
	 * userS.getTestDataManager()); precioPorModalidadPage.clickOnContinuar();
	 * // ValidacionExcepcionesReglasPage validacionExcepcionesReglasPage = new
	 * ValidacionExcepcionesReglasPage(userS);
	 * validacionExcepcionesReglasPage.clickOnContinuarButton(); ClausulasPage
	 * clausulasPage = new ClausulasPage(userS);
	 * clausulasPage.clickOnContinuar(); TomadorYAseguradoPage
	 * tomadorYAseguradoPage = new TomadorYAseguradoPage(webDriver,
	 * userS.getTestDataManager());
	 * tomadorYAseguradoPage.addStaticDatosTomador(); //
	 * tomadorYAseguradoPage.AddDatosTomadorDiferenteAsegurado();
	 * tomadorYAseguradoPage.clickOnContinuar(); DatosBancariosPage
	 * datosBancariosPage = new DatosBancariosPage(webDriver,
	 * userS.getTestDataManager());
	 *
	 * datosBancariosPage.introducirFormaPagoYPulsarSolicitarPeritacion(); //
	 * this.browserContext.writeTestCaseData(); //
	 * this.browserContext.getWebDriver().quit();
	 *
	 * Iterable<String> PeritajeIterator = Splitter.on('
	 * ').split(datosBancariosPage.getMensajePeritaje()); String[] PeritajeList
	 * = Iterables.toArray(PeritajeIterator, String.class);
	 *
	 * logText += "Solicitud peritaje concluida para referencia catastral " +
	 * getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + " (Proyecto: "
	 * + datosBancariosPage.getProjectNumber() + ", " + "Referencia solicitud: "
	 * + PeritajeList[7] + ")" + "\n"; writeFile(fileName + " (log file).txt",
	 * logText);
	 *
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } catch (Exception e) {
	 * logText +=
	 * "Comprobacion de datos no contemplada para la referencia catastral " +
	 * getValuesDataSetByID(datosAltoValor, "ref_catastral", i) + "\n";
	 * writeFile(fileName + " (log file).txt", logText);
	 * System.out.println("Comprobaciones de datos no contempladas");
	 * this.browserContext.webElementHelper.exitFromFrame();
	 * innovaHomePage.openInnovaHome();
	 * innovaHomePage.openMutuaEdificioConfort(); } }
	 *
	 * this.browserContext.getWebDriver().quit();
	 *
	 * logger.
	 * debug("END - alta_masiva_proyectos_MEC_antiguedad_edificio_mayor_50"); }
	 *
	 * //@
	 * Cuando("^busco un cliente por \"([^\"]*)\" usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void busco_un_cliente_por_usando_el_acceso_y_el_usuario( String
	 * filtroBuscador, String loginAcess, String user) {
	 *
	 * this.tCData.setFiltroBuscadorCliente(getValuesDataSet(this.tCData.
	 * gethMapDataSet(), filtroBuscador, this.tCData.getTestID()));
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * // Clientes Page ClientesPage clientesPage = new ClientesPage(webDriver,
	 * userS.getTestDataManager()); clientesPage.accederAlBuscadorClientes();
	 * clientesPage.buscarConFiltroBusqueda(); }
	 *
	 * //@
	 * Cuando("^doy de alta un nuevo tomador usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_alta_nuevo_tomador_usando_el_acceso_y_el_usuario(
	 * String loginAcess, String user) {
	 *
	 * // Login this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * // Clientes Page ClientesPage clientesPage = new ClientesPage(webDriver,
	 * userS.getTestDataManager()); clientesPage.accederAlBuscadorClientes();
	 * clientesPage.crearNuevoTomador(); }
	 *
	 * //@
	 * Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\" iterando por el fichero \"([^\"]*)\"$"
	 * ) public void
	 * doy_de_alta_prospect_usando_acceso_y_usuario_iterando_fichero( String
	 * loginAcess, String user, String fileName) { fileName =
	 * getValuesDataSet(this.tCData.gethMapDataSet(), fileName,
	 * this.tCData.getTestID()); fileName = fileName.substring(0,
	 * fileName.length() - 4);
	 *
	 * this.inicio_sesion();
	 *
	 * String[][] datosMediadores = loadDataFileToArray(fileName + ".csv",
	 * false);
	 *
	 * for (int i = 1; i < datosMediadores.length; i++) {
	 * this.tCData.setNivelEstructura(getValuesDataSetByID(datosMediadores,
	 * "nivelEstructura", i));
	 * this.tCData.setTipoProspect(getValuesDataSetByID(datosMediadores,
	 * "tipoProspect", i));
	 * this.tCData.setActividadPrincipal(getValuesDataSetByID(datosMediadores,
	 * "actividadPrincipal", i));
	 * this.tCData.setNombreComercialProspect(getValuesDataSetByID(
	 * datosMediadores, "nomComercial", i));
	 * this.tCData.setContactoResponsable(getValuesDataSetByID(datosMediadores,
	 * "contactoResponsable", i));
	 * this.tCData.setIdioma(getValuesDataSetByID(datosMediadores, "idioma",
	 * i)); this.tCData.setTlfPrincipal(getValuesDataSetByID(datosMediadores,
	 * "tlfPrincipal", i));
	 * this.tCData.setEjecutivoComercial(getValuesDataSetByID(datosMediadores,
	 * "ejecutivoComercial", i));
	 * this.tCData.setProvincia(getValuesDataSetByID(datosMediadores,
	 * "provincia", i));
	 * this.tCData.setPoblacion(getValuesDataSetByID(datosMediadores,
	 * "poblacion", i));
	 * this.tCData.setNombreVia(getValuesDataSetByID(datosMediadores,
	 * "nombreVia", i));
	 *
	 * try { this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver,
	 * userS.getTestDataManager()); mediadoresHomePage.openAltaProspect();
	 *
	 * MediadoresAltaProspectPage mediadoresAltaProspectPage = new
	 * MediadoresAltaProspectPage(userS);
	 * mediadoresAltaProspectPage.executeActionsAltaProspectPage();
	 *
	 * } catch (Exception e) {
	 *
	 * } } }
	 *
	 * //@
	 * Cuando("^doy de alta un prospect usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_prospect_usando_acceso_y_usuario( String
	 * loginAcess, String user) {
	 *
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver,
	 * userS.getTestDataManager()); mediadoresHomePage.openAltaProspect();
	 *
	 * MediadoresAltaProspectPage mediadoresAltaProspectPage = new
	 * MediadoresAltaProspectPage(userS);
	 * mediadoresAltaProspectPage.executeActionsAltaProspectPage();
	 *
	 * }
	 *
	 * //@
	 * Cuando("^doy de alta un mediador usando el \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void doy_de_alta_mediador_usando_acceso_y_usuario( String
	 * loginAcess, String user) {
	 *
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
	 * userS.getTestDataManager()); innovaHomePage.openMediadores();
	 *
	 * MediadoresHomePage mediadoresHomePage = new MediadoresHomePage(webDriver,
	 * userS.getTestDataManager()); mediadoresHomePage.openAltaMediador();
	 *
	 * MediadoresAltaMediadorPage mediadoresAltaMediadorPage = new
	 * MediadoresAltaMediadorPage(userS);
	 * mediadoresAltaMediadorPage.executeActionsAltaMediadorPage();
	 *
	 * }
	 *
	 * //@
	 * Cuando("^comunico un siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void comunico_siniestro( String loginAcess, String user) {
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * }
	 *
	 * //@
	 * Cuando("^busco el siniestro usando el acceso \"([^\"]*)\" y el usuario \"([^\"]*)\"$"
	 * ) public void busco_siniestro( String loginAcess, String user) {
	 * this.browserContext.initializeVariables(loginAcess =
	 * this.userS.getTestVar("acceso"));
	 * this.browserContext.applicationAccessHelper.login(this.tCData.getUsuario(
	 * ), this.browserContext.getProperties().passwordComun);
	 *
	 * }
	 *
	 * //@Cuando("^la renta mensual alquiler es \"([^\"]*)\"$") public void
	 * la_renta_mensual_es( String rentaMensualAlquiler) {
	 * PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
	 * precioPorModalidadPage_MAC.CompletarRentaMensualAlquiler(); }
	 *
	 * //@Cuando("^la suma asegurada de impago alquiler es \"([^\"]*)\" meses$")
	 * public void la_suma_asegurada_de_impago_alquiler_es( String
	 * sumaAseguradaImpagoAlquiler) { PrecioPorModalidadPage_MAC
	 * precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS);
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
	 * public ChecksSteps(BrowserContext browserContext) { this.browserContext =
	 * browserContext; this.tCData = browserContext.getTestCaseData(); }
	 *
	 * //@Entonces("^el edificio se encuentra$") public void
	 * el_edificio_se_encuentra() {
	 * logger.debug("BEGIN - el_edificio_se_encuentra");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver,
	 * userS.getTestDataManager());
	 * org.junit.Assert.assertTrue(fichaEdificioPage.checkResultadoDireccion());
	 *
	 * logger.debug("END - el_edificio_se_encuentra"); }
	 *
	 * //@Entonces("^se visualiza la cabecera de la ficha de edificio$") public
	 * void visualiza_cabecera_ficha_edificio() {
	 * logger.debug("BEGIN - visualiza_cabecera_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver,
	 * userS.getTestDataManager());
	 * org.junit.Assert.assertTrue(fichaEdificioPage.checkCabeceraFicha());
	 *
	 * logger.debug("END - visualiza_cabecera_ficha_edificio"); }
	 *
	 * //@Entonces("^se visualiza la pestaña Resumen de la ficha de edificio$")
	 * public void visualiza_pestana_resumen_ficha_edificio() {
	 * logger.debug("BEGIN - visualiza_pestana_resumen_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver,
	 * userS.getTestDataManager());
	 * org.junit.Assert.assertTrue(fichaEdificioPage.checkPestanaResumenVisible(
	 * ));
	 *
	 * logger.debug("END - visualiza_pestana_resumen_ficha_edificio"); }
	 *
	 * //@Entonces("^se visualiza la pestaña Pólizas de la ficha de edificio$")
	 * public void visualiza_pestana_polizas_ficha_edificio() {
	 * logger.debug("BEGIN - visualiza_pestana_polizas_ficha_edificio");
	 *
	 * FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(webDriver,
	 * userS.getTestDataManager());
	 * org.junit.Assert.assertTrue(fichaEdificioPage.checkPestanaPolizasVisible(
	 * ));
	 *
	 * logger.debug("END - visualiza_pestana_polizas_ficha_edificio"); }
	 *
	 * //@Entonces("^el cliente se encuentra$") public void
	 * el_cliente_se_encuentra() {
	 * logger.debug("BEGIN - el_cliente_se_encuentra");
	 *
	 * ClientesPage clientePage = new ClientesPage(webDriver,
	 * userS.getTestDataManager());
	 * org.junit.Assert.assertTrue(clientePage.checkResultadoNIF()); // TODO
	 * Agregar la comprobacion de resultado de busqueda en la ficha cliente
	 *
	 * logger.debug("END - el_cliente_se_encuentra"); }
	 *
	 * // //@Entonces("^el resultado es que el projecto se crea correctamente$")
	 * // public void el_resultado_es_que_el_projecto_se_crea_correctamente() //
	 * { // logger.
	 * debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente");
	 * // if
	 * (this.browserContext.getTestCaseData().getGestionOnlineDisponible().
	 * equals(MutuaPropietariosConstants.LoginAccessInnova)) // { //
	 * org.junit.Assert.assertNotNull(this.browserContext.getTestCaseData().
	 * getNoCotizacion()); // } // logger.
	 * debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente"); //
	 * }
	 *
	 * //@Entonces("^el resultado es que el projecto se crea correctamente$")
	 * public void el_resultado_es_que_el_projecto_se_crea_correctamente() {
	 * logger.
	 * debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente");
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessInnova)) { // For the time being we check that the policy
	 * appears correctly in Innov@, but this should be changed to check the
	 * policy in GO.
	 *
	 * this.browserContext.initializeVariables(this.tCData.getCambioAcceso());
	 * this.browserContext.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza()));
	 * gestionPolizasBuscadorPage.ConsultarPoliza(); GestionPolizasConsultarPage
	 * gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager());
	 * gestionPolizasConsultarPage.CheckPolizaNumber();
	 *
	 * }
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine)) { // Here we check if the policy created in GO
	 * appears correctly in Innov@ // Login
	 * this.browserContext.initializeVariables(this.tCData.getCambioAcceso());
	 * this.browserContext.applicationAccessHelper.
	 * LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),
	 * this.browserContext.getProperties().passwordComun,
	 * String.valueOf(this.tCData.getNumPoliza()));
	 *
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza()));
	 * gestionPolizasBuscadorPage.ConsultarPoliza(); GestionPolizasConsultarPage
	 * gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager());
	 * gestionPolizasConsultarPage.CheckPolizaNumber();
	 *
	 * }
	 *
	 * logger.
	 * debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente"); }
	 *
	 * //@Entonces("^el valor de los capitales varia$") public void
	 * el_valor_de_los_capitales_varia() { if
	 * (this.browserContext.getTestCaseData().isCantidadesModifiedError()) {
	 * throw new AssertionError(this.browserContext.getTestCaseData().
	 * getCantidadesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^resultado es que el projecto se crea correctamente$")
	 * public void el_resultado_es_que_el_proyecto_se_crea_correctamente() {
	 * ContratacionPage_MAC contratacionPage_MAC = new
	 * ContratacionPage_MAC(userS);
	 * Assert.assertTrue(contratacionPage_MAC.checkPolizaCreada()); }
	 *
	 * //@
	 * Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un infraseguro$"
	 * ) public void
	 * el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_infraseguro
	 * () { // Este paso es puramente informativo. Esta comprobación se hace
	 * cada vez que se crea un // ifraseguro en la pantalla de validacion
	 * excepciones // reglas }
	 *
	 * //@Entonces("^aparece una clausula adicional$") public void
	 * aparece_una_clausula_adicional() { // Este paso es puramente informativo.
	 * Esta comprobación se hace cadea vez que se crea un // infraseguro en la
	 * pantalla de clausulas }
	 *
	 * //@
	 * Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un supraseguro$"
	 * ) public void
	 * el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_supraseguro
	 * () { // Este paso es puramente informativo. Esta comprobación se hace
	 * cada vez que se crea un // supraseguro en la pantalla de validacion
	 * excepciones // reglas }
	 *
	 * //@Entonces("^los datos de ese cliente se completan automáticamente$")
	 * public void los_datos_de_ese_cliente_se_completan_automáticamente() { //
	 * Este paso es puramente informativo. Esta comprobación se hace en la
	 * pantalla de datos basicos // tomador al seleccionar como cliente un
	 * cliente // existente }
	 *
	 * //@Entonces("^sale un aviso si el precio no cambia$") public void
	 * sale_un_aviso_si_el_precio_no_cambia() { if
	 * (this.browserContext.getTestCaseData().isCapitalesModifiedError()) {
	 * throw new AssertionError(this.browserContext.getTestCaseData().
	 * getCapitalesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^se añade una franquicia obligatoria$") public void
	 * se_añade_una_franquicia_obligatoria() { // Este paso es puramente
	 * informativo. Esta comprobación se hace en la pantalla de Precio cada //
	 * vez que se añade un descuento. }
	 *
	 * //@
	 * Entonces("^el valor de los capitales varia una vez se añade la cobertura opcional$"
	 * ) public void
	 * el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional()
	 * { if (this.browserContext.getTestCaseData().isCapitalesModifiedError()) {
	 * throw new AssertionError(this.browserContext.getTestCaseData().
	 * getCapitalesModifiedErrorMessage()); } }
	 *
	 * //@Entonces("^aparece aviso \"([^\"]*)\"$") public void aparece_aviso(
	 * String aviso) { ValidacionExcepcionesReglasDetallesRiesgoPage
	 * validacionDetallesRiesgoPage = new
	 * ValidacionExcepcionesReglasDetallesRiesgoPage( this.browserContext);
	 * boolean check = false;
	 *
	 * switch (aviso) { case ProjectConstants.AvisoPeritajeAntiguead: check =
	 * validacionDetallesRiesgoPage.
	 * CheckAvisoPeritajeConstructionYearGreaterThan50(); break; case
	 * ProjectConstants.AvisoPeritajePlantasSotano: check =
	 * validacionDetallesRiesgoPage.CheckAvisoPeritajePlantasSotano(); break;
	 * case ProjectConstants.AvisoPeritajeCapitalContinente: check =
	 * validacionDetallesRiesgoPage.
	 * CheckAvisoPeritajeCapitalContinenteGreaterThan15000000(); break; case
	 * ProjectConstants.AvisoPlantasSotanoGreaterThan10: check =
	 * validacionDetallesRiesgoPage.CheckAvisoPlantasSotanoMoreThan10(); break;
	 * case ProjectConstants.AvisoRiesgoAgravado: check =
	 * validacionDetallesRiesgoPage.CheckAvisoRiesgoAgravado(); break; case
	 * ProjectConstants.AvisoComunidadesEnTramite:
	 * validacionDetallesRiesgoPage.CheckAvisoComuniadesEnTramite(); break; case
	 * ProjectConstants.AvisoPlantasAltoGreaterThan20:
	 * validacionDetallesRiesgoPage.CheckAvisoPlantasAlto(); break; case
	 * ProjectConstants.AvisoModificacionAnyoContruccionGherkin:
	 * validacionDetallesRiesgoPage.CheckAvisoConstructionYearWithException();
	 * break; case ProjectConstants.AvisoModificacionRehabilitacionIntegral:
	 * validacionDetallesRiesgoPage.
	 * CheckAvisoRehabilitacionIntegralWithException(); break; case
	 * ProjectConstants.AvisoGarajes: DetallesRiesgoPage detallesRiesgoPage =
	 * new DetallesRiesgoPage(userS);
	 * detallesRiesgoPage.CheckAvisoGarajesWithException(); break; default:
	 * throw new Exception(ProjectConstants.AvisoNoContemplado); } if (check)
	 * validacionDetallesRiesgoPage.CheckAviso(aviso); }
	 *
	 * //@
	 * Entonces("^aparece un mensaje indicando que el projecto será revisado por la compañia$"
	 * ) public void
	 * aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia
	 * () { logger.
	 * debug("BEGIN - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia"
	 * ); // Pure informative step. This check is performed with the function
	 * logger.
	 * debug("END - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia"
	 * ); }
	 *
	 * //@Entonces("^la cotizacion se actualiza correctamente$") public void
	 * la_cotizacion_se_actualiza_correctamente() {
	 * logger.debug("BEGIN - la_cotizacion_se_actualiza_correctamente");
	 * MensajeConfirmacionPage mensajeConfirmacionPage = new
	 * MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
	 * logger.debug("END - la_cotizacion_se_actualiza_correctamente");
	 *
	 * }
	 *
	 * //@Entonces("^la copia tomador deberia tener los nuevos datos$") public
	 * void la_copia_tomador_deberia_tener_los_nuevos_datos() {
	 * logger.debug("BEGIN - la_copia_tomador_deberia_tener_los_nuevos_datos");
	 * MensajeConfirmacionPage mensajeConfirmacionPage = new
	 * MensajeConfirmacionPage(userS);
	 * mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
	 * mensajeConfirmacionPage.searchTextInCopiaTomadorPDF();
	 * logger.debug("END - la_copia_tomador_deberia_tener_los_nuevos_datos");
	 *
	 * }
	 *
	 * //@
	 * Entonces("^el resultado es que aparece un mensaje de error y los campos deshabilitación y edificio madera aparecen resaltados en rojo$"
	 * ) public void
	 * el_resultado_es_que_aparece_un_mensaje_de_error_y_los_campos_deshabilitación_y_edificio_madera_aparecen_resaltados_en_rojo
	 * () throws Throwable { // Step puramente informativo. Los chequeos se
	 * hacen en el paso que crea la simulación. }
	 *
	 * //@Entonces("^se muestra la ventana para imprimir la poliza$") public
	 * void se_muestra_la_ventana_para_imprimir_la_poliza() { // Step puramente
	 * informativo. Los chequeos se hacen en el último paso de la simulacion, en
	 * la // pantalla con el listado de documentos }
	 *
	 * //@Entonces("^la poliza muestra \"([^\"]*)\" en la solapa Coberturas$")
	 * public void la_poliza_muestra_en_la_solapa_Coberturas( String arg1) {
	 *
	 * }
	 *
	 * //@Entonces("^el campo cotización contiene el valor \"([^\"]*)\"$")
	 * public void el_campo_cotización_contiene_el_valor( String
	 * cotizacionValue) {
	 * logger.debug("BEGIN - el_campo_cotización_contiene_el_valor");
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new
	 * GestionCotizacionesBuscadorPage(userS); String cotizacion =
	 * gestionCotizacionesBuscacorPage.getCotizacion();
	 * Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
	 * logger.debug("END - el_campo_cotización_contiene_el_valor"); }
	 *
	 * //@Entonces("^la poliza \"([^\"]*)\" en la pestaña \"([^\"]*)\"$") public
	 * void la_poliza_muestra_en_la_pestanya( String toBeChecked, String tab) {
	 * this.browserContext.applicationAccessHelper.OpenGestionPolizas();
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this
	 * .browserContext.getTestCaseData().getNumPoliza()));
	 * gestionPolizasBuscadorPage.ConsultarPoliza(); GestionPolizasConsultarPage
	 * gestionPolizasConsultarPage = new GestionPolizasConsultarPage(webDriver,
	 * userS.getTestDataManager());
	 *
	 * switch (toBeChecked) { case
	 * ProjectConstants.PolizaDetailConstructionYear:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailConstructionYear,
	 * this.tCData.getAnyoConstruccion()); break; case
	 * ProjectConstants.PolizaDetailCapitalContinente:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailCapitalContinente,
	 * this.nf.format(this.tCData.getCapitalContinente()).toString()); break;
	 * case ProjectConstants.PolizaDetailCapitalContenido:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailCapitalContenido,
	 * this.nf.format(this.tCData.getCapitalContenido()).toString()); break;
	 * case ProjectConstants.PolizaDetailNuevaClausulaHipotecaria:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabClausulas,
	 * ProjectConstants.PolizaDetailNuevaClausulaHipotecaria,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case
	 * ProjectConstants.PolizaDetailLocalesExcluidos:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailLocalesExcluidos,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case
	 * ProjectConstants.PolizaDetailDepositoCombustible:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailDepositoCombustible,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case
	 * ProjectConstants.PolizaDetailCalefaccionCentral:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailCalefaccionCentral,
	 * ProjectConstants.DescuentoRecargoNotSpecified); break; case
	 * ProjectConstants.PolizaDetailPlacaSolar:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailPlacaSolar,
	 * this.browserContext.getTestCaseData().getInstalacionesFotovoltaicasValor(
	 * ) + " €"); break; case ProjectConstants.PolizaDetailMaquinaria:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo, ProjectConstants.PolizaDetailMaquinaria,
	 * this.browserContext.getTestCaseData().getCoberturaOpcionalMaquinariaValor
	 * () + " €"); break; case ProjectConstants.PolizaDetailNoRecargo:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailNoRecargo, null);
	 * break; case ProjectConstants.PolizaDetailRecargo:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailNoRecargo,
	 * ProjectConstants.PolizaDetailDescuentoValue); break; case
	 * ProjectConstants.PolizaDetailNoDescuento:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailNoDescuento, null);
	 * break; case ProjectConstants.PolizaDetailDescuento:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailDescuentoValue,
	 * ProjectConstants.PorcentajeDescuentoRecargo);
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabImportes, ProjectConstants.PolizaDetailDescuento,
	 * ProjectConstants.TipoDescuento); break; case
	 * ProjectConstants.PolizaDetailClausula:
	 * gestionPolizasConsultarPage.CheckClausulas(); break; case
	 * ProjectConstants.PolizaDetailM2ConstruidosTotales:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailM2ConstruidosTotales,
	 * this.nf.format(this.tCData.getM2ContruidosTotales()).toString()); break;
	 * case ProjectConstants.PolizaDetailYearAndRehabilitationLevel:
	 * gestionPolizasConsultarPage.CheckAnyoAndNivelRehabilitacion(); break;
	 * case ProjectConstants.PolizaDetailYearRehabilitacionIntegral:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailYearRehabilitacionIntegral,
	 * this.tCData.getM2ContruidosTotales().toString()); break; case
	 * ProjectConstants.PolizaDetailCalidadConstruccion:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailCalidadConstruccion,
	 * this.tCData.getCalidadConstruccion()); break; case
	 * ProjectConstants.PolizaDetailFranquiciaVoluntaria:
	 * gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.
	 * PolizaDetailTabDetallesRiesgo,
	 * ProjectConstants.PolizaDetailFranquiciaVoluntaria,
	 * this.tCData.getFranquiciaVoluntaria()); break; default: throw new
	 * Exception(String.format("El checqueo para %s no se ha implementado",
	 * toBeChecked)); } }
	 *
	 * //@Entonces("^esta habilitado el campo \"([^\"]*)\"$") public void
	 * esta_habilitado_el_campo( String fieldValue) { DetallesRiesgoPage
	 * detallesRiesgoPage = new DetallesRiesgoPage(webDriver,
	 * userS.getTestDataManager());
	 * Assert.assertTrue(String.format("El campo %s no está habilitado",
	 * fieldValue), detallesRiesgoPage.IsFieldEnabled(fieldValue)); }
	 *
	 * //@Entonces("^el proyecto MAC se deniega$") public void
	 * el_proyecto_MAC_se_deniega() { InquilinosAvalistasPage_MAC
	 * inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS); Assert.assertTrue(
	 * inquilinosAvalistasPage_MAC.recuperarTextoMensajeError().contains(String.
	 * format("¡Error! Se ha denegado la emisión del proyecto"))); }
	 *
	 * //@Entonces("^el proyecto MAC se acepta$") public void
	 * el_proyecto_MAC_se_acepta() { InquilinosAvalistasPage_MAC
	 * inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * Assert.assertTrue(inquilinosAvalistasPage_MAC.
	 * recuperarTextoMensajeValidacionOK().contains(
	 * "El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."
	 * )); }
	 *
	 * //@Entonces("^el proyecto esta en estado denegado$") public void
	 * el_proyecto_esta_en_estado_denegado() { if
	 * (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessGestionLine)) { GestionOnlineHomePage gestionOnlineHomePage =
	 * new GestionOnlineHomePage(userS);
	 * Assert.assertEquals(String.format("Denegado"),
	 * gestionOnlineHomePage.recuperarEstadoPoliza()); }
	 *
	 * if (this.userS.getTestVar("acceso").equals(ProjectConstants.
	 * LoginAccessInnova)) { GestionCotizacionesBuscadorPage
	 * gestionCotizacionesBuscadorPage = new
	 * GestionCotizacionesBuscadorPage(userS);
	 * Assert.assertEquals(String.format("Desestimada"),
	 * gestionCotizacionesBuscadorPage.getEstadoCotizacion()); }
	 *
	 * }
	 *
	 * //@
	 * Entonces("se puede autorizar usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$"
	 * ) public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(
	 * String loginAcess, String user) { // Enviar el proyecto
	 * InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new
	 * InquilinosAvalistasPage_MAC(userS);
	 * inquilinosAvalistasPage_MAC.enviarACompania();
	 *
	 * // Cerrar el navegador this.browserContext.getWebDriver().quit();
	 *
	 * // Login // this.browserContext.initializeVariables( //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * loginAcess, this.browserContext.getTestCaseData().getTestID())); //
	 * this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(
	 * //
	 * getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(),
	 * user, this.browserContext.getTestCaseData().getTestID()), //
	 * this.browserContext.getProperties().passwordComun);
	 *
	 * System.out.println("Valor accesoAuth: " + this.tCData.getAccesoAuth());
	 * this.browserContext.initializeVariables(this.tCData.getAccesoAuth());
	 * this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(
	 * this.tCData.getUsuarioAuth(),
	 * this.browserContext.getProperties().passwordComun);
	 *
	 * // Abrir la busqueda de autorizaciones InnovaHomePage innovaHomePage =
	 * new InnovaHomePage(userS); innovaHomePage.OpenGestionAutorizaciones();
	 * GestionAutorizacionesPage gestionAutorizacionesPage = new
	 * GestionAutorizacionesPage(webDriver, userS.getTestDataManager());
	 * gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización",
	 * "Pendiente de autorizar",
	 * this.browserContext.getTestCaseData().getNoCotizacionMAC());
	 *
	 * // Autorizar el proyecto gestionAutorizacionesPage.autorizar();
	 * Assert.assertTrue(gestionAutorizacionesPage.
	 * recuperarResultadoAutorizacion().
	 * contains("ha sido autorizada correctamente.")); }
	 *
	 * //@Entonces("^los datos de prospect grabados coinciden$") public void
	 * datos_prospect_grabados_coinciden() { String nombreComercial =
	 * String.valueOf(this.tCData.getNombreComercialProspect()).toUpperCase();
	 * MediadoresFichaMediadorPage fichaMediadorPage = new
	 * MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(
	 * nombreComercial)); }
	 *
	 * //@Entonces("^los datos de mediador grabados coinciden$") public void
	 * datos_mediador_grabados_coinciden() { if
	 * (this.tCData.getTipoNombreComercialMediador().
	 * equals("Igual que el fiscal")) { String nombreComercial = String
	 * .valueOf( this.tCData.getNombreFiscalMediador() + " " +
	 * this.tCData.getPrimerApellidoMediador() + " " +
	 * this.tCData.getSegundoApellidoMediador()) .toUpperCase();
	 * System.out.println("*** Nombre comercial" + nombreComercial);
	 * MediadoresFichaMediadorPage fichaMediadorPage = new
	 * MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(
	 * nombreComercial)); }
	 *
	 * if (this.tCData.getTipoNombreComercialMediador().
	 * equals("Diferente que el fiscal")) { String nombreComercial =
	 * String.valueOf(this.tCData.getNombreComercialMediador()).toUpperCase();
	 * MediadoresFichaMediadorPage fichaMediadorPage = new
	 * MediadoresFichaMediadorPage(userS);
	 * Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(
	 * nombreComercial)); }
	 *
	 * }
	 *
	 * //@
	 * Entonces("^debería aparecer ¡Error! Rebasada la renta máxima permitida de 3.000,00 €$"
	 * ) public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida()
	 * { PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); // Comprobar que sale el
	 * error correspondiente Assert.assertTrue(
	 * precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.
	 * format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €"))); }
	 *
	 * //@
	 * Entonces("^debería aparecer ¡Error! Situación de reaseguro no es posible la contratación$"
	 * ) public void deberia_aparecer_error_situacion_reasegurado() {
	 * PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); // Comprobar que sale el
	 * error correspondiente
	 * Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError()
	 * .contains(String.
	 * format("¡Error! Situación de reaseguro no es posible la contratación")));
	 * }
	 *
	 * //@Entonces("^no debería estar habilitado Convertir a proyecto$") public
	 * void no_deberia_estar_habilitado_convertir_a_proyecto() {
	 * PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new
	 * PrecioPorModalidadPage_MAC(userS); // Comprobar que se
	 * queda deshabilitado Convertir a proyecto
	 * Assert.assertFalse(precioPorModalidadPage_MAC.
	 * checkConvertirAProyectoIsPresent()); }
	 *
	 *
	 *
	 */

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////// 18-04-18 DESDE GESTION ONLINE ACCESS HELPER
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 *
	 * public void CreateProject() {
	 * this.gestionOnlineHomePage.createNewProject(); }
	 *
	 * public void CreateSimulation() {
	 * this.gestionOnlineHomePage.createNewSimulation(); }
	 *
	 * public void OpenMutuaEdificioConfort() {
	 * this.gestionOnlineHomePage.openMutuaEdificioConfort(); }
	 *
	 * // @Override // public void openMisProyectosWeb() throws AWTException, //
	 * InterruptedException, IOException // { //
	 * this.gestionOnlineHomePage.openMisProyectosWeb();
	 *
	 * // }
	 *
	 * public void searchCotizacion(String cotizacion) { //
	 * GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new //
	 * GestionCotizacionesBuscadorPage(userS); //
	 * gestionCotizacionesBuscacorPage.searchCotizacion(cotizacion);
	 * this.gestionOnlineHomePage.buscarProyectoWeb(cotizacion); }
	 *
	 * public void OpenGestionPolizas() { //
	 * this.gestionOnlineHomePage.openGestionCotizaciones(); }
	 *
	 * public void SearchPolizaByPolizaNumber(String poliza) {
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(poliza); }
	 *
	 * public void loginAndSearchCotizacion(String userId, String password,
	 * String cotizacion) throws Exception { this.login(userId, password); //
	 * this.OpenMutuaEdificioConfort(); this.openGestionCotizaciones();
	 * this.searchCotizacion(cotizacion); }
	 *
	 * public void LoginAndSearchPolizaByPolizaNumber(String userId, String
	 * password, String poliza) throws Exception { this.login(userId, password);
	 * this.OpenGestionPolizas(); this.SearchPolizaByPolizaNumber(poliza); }
	 *
	 * public void LoginAndCreateProjectMEC(String userId, String password)
	 * throws Exception { this.login(userId, password);
	 * this.OpenMutuaEdificioConfort(); this.CreateProject(); }
	 *
	 * public void LoginAndCreateProjectMAC(String userId, String password)
	 * throws Exception { this.login(userId, password);
	 * this.OpenMutuaAlquilerConfort(); this.CreateProject(); }
	 *
	 * public void LoginAndCreateSimulation(String userId, String password)
	 * throws Exception { this.login(userId, password);
	 *
	 * this.OpenMutuaEdificioConfort();
	 *
	 * // this.CreateSimulation(); }
	 *
	 * public void LoginAndSearchPolizaByNifNie(String userId, String password,
	 * String nifNie) throws Exception { this.login(userId, password);
	 * this.OpenGestionPolizas();
	 *
	 * }
	 *
	 * public void SearchPolizaByNifNie(String nifNie) {
	 * GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new
	 * GestionPolizasBuscadorPage(userS);
	 * gestionPolizasBuscadorPage.SearchPolizaByNifNumber(nifNie); }
	 *
	 * public void OpenMutuaAlquilerConfort() throws AWTException,
	 * InterruptedException, IOException { new GestionOnlineHomePage(webDriver,
	 * userS.getTestDataManager()).openMutuaAlquilerConfort(); }
	 *
	 * public void LoginAndSearchAutorizacion(String userId, String password)
	 * throws Exception { this.login(userId, password); }
	 *
	 * public void openGestionCotizaciones() throws AWTException,
	 * InterruptedException, IOException {
	 * this.gestionOnlineHomePage.openMisProyectosWeb(); }
	 *
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////////////////// ///////// 18-04-18 DESDE INNOVA ACCESS
	 * HELPER
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////////////////
	 *
	 */
//	public void loginAndCreateSimulation(String userId, String password) throws Exception {
//
//		// this.logIn(userId, password);
//
//		new InnovaHomePage(userS).openMutuaEdificioConfort();
//
//		// this.logIn(userId, password);
//
//		// this.OpenMutuaEdificioConfort();
//
//		new InnovaHomePage(userS).createNewSimulation();
//
//		// this.CreateSimulation();
//	}

	public void openSimulationMec() throws Exception {
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
		if(loginAccess.equals(ProjectConstants.LoginAccessGestionLine) && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		} else if(loginAccess.equals(ProjectConstants.LoginAccessInnova)) {
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
		if(accessType.equals(ProjectConstants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();
		} else if(accessType.equals(ProjectConstants.LoginAccessInnova)) {
			new InnovaHomePage(userS).OpenMutuaAlquilerConfort();
			new InnovaHomePage(userS).openNewProjectMec();
		}
		debugEnd();
	}

	public void searchAuthorisation() throws Exception {
		new InnovaHomePage(userS).OpenGestionAutorizaciones();
		new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", this.getTestVar("NumCotizacion"));

	}

	public void enviar_el_proyecto_a_la_compania() {
		debugBegin();
		new InquilinosAvalistasPage_MAC(userS).enviarACompania();
		userS.getDriver().quit();
		debugEnd();
	}

	public void cerrar_navegador() {
		debugBegin();
		userS.getDriver().quit();
		debugEnd();
	}

	public void autorizar_el_proyecto_MAC(
		String loginAcess, String user) throws Exception {

		// Login
		// this.LoginAndSearchAutorizacion(this.tCData.getUsuarioAuth(),
		// this.browserContext.getProperties().passwordComun);
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
		this.login(loginAccess, user);
		this.searchAuthorisation();
		new GestionAutorizacionesPage(userS).autorizar();

		userS.getDriver().quit();
	}

	public void completo_el_proceso_de_contratacion_MAC(String accessType, String user) throws Exception {
		debugBegin();
		this.login(accessType, user);

		if(accessType.equals(ProjectConstants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				// .openMutuaAlquilerConfort()
				.openMisProyectosWeb()
				.buscarProyectoWeb(this.getTestVar("NumCotizacion"));
			new GestionOnlineHomePage(userS).modificarProyecto();

		} else if(accessType.equals(ProjectConstants.LoginAccessInnova)) {
			new InnovaHomePage(userS).openGestionCotizaciones();
			new GestionCotizacionesBuscadorPage(userS).searchCotizacion(this.getTestVar("NumCotizacion"));
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
		// this.browserContext.initializeVariables(loginAcess =
		// this.tCData.getAcceso());
		// //
		// this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this.tCData.getUsuario(),
		// // this.browserContext.getProperties().passwordComun);
		//
		// //
		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// // this.browserContext.getProperties().passwordComun);
		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// this.browserContext.getProperties().passwordComun,
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
		// this.browserContext.initializeVariables(loginAcess =
		// this.tCData.getAcceso());
		// this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
		// this.browserContext.getProperties().passwordComun,
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

	// ALTA SINIESTRO
	public void alta_siniestro(String acceso, String numPoliza) throws Exception {
		debugBegin();
		
		// Accedemos a siniestros desde INNOVA
		
		if(acceso.compareTo("Innova") == 0){
			
			new InnovaHomePage(userS).openSiniestros();
					
			// Elegimos la opción "alta" de siniestros
			new SiniestrosHomePage(userS).openAperturaAlta();
	
			// Buscamos una póliza por Nº póliza
			new GestionPolizasBuscadorPage(userS).BuscarPorNumeroPoliza(numPoliza);
			new GestionPolizasBuscadorPage(userS).SeleccionarResultado();
	
			// 1.Declaración
			new SiniestrosAltaAperturaDeclaracionPage(userS).completarMinimos(numPoliza);
			//new SiniestrosAltaAperturaDeclaracionPage(userS).altaDatosBasicos("", tipoDeclarante, medioDeclaracion);
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
		public void alta_siniestroAlt(String acceso, String numPoliza, boolean asistencia) throws Exception {
			debugBegin();
			String ramo = "";
			
			// Accedemos a siniestros desde INNOVA
			
			if(acceso.compareTo("Innova") == 0){
				
				InnovaHomePage innovaHome = new InnovaHomePage(userS);
				innovaHome.openSiniestros();
						
				// Elegimos la opción "alta" de siniestros
				SiniestrosHomePage siniestrosHome = new SiniestrosHomePage(userS);
				siniestrosHome.openAperturaAlta();
				
				// Buscamos una póliza por Nº póliza
				SiniestrosAltaAperturaPage altaApertura = new SiniestrosAltaAperturaPage(userS);
				if(numPoliza.startsWith("510")) ramo = "510";
				else if(numPoliza.startsWith("920")||numPoliza.startsWith("900")) ramo = "920";
				else if(numPoliza.startsWith("660")) ramo = "660";
				else if(numPoliza.startsWith("400")||numPoliza.startsWith("200")||numPoliza.startsWith("150")||(numPoliza.startsWith("500")&&!numPoliza.startsWith("5000"))) ramo = "500";
				else if(numPoliza.startsWith("5000")||numPoliza.startsWith("600")||numPoliza.startsWith("610")||numPoliza.startsWith("620")||numPoliza.startsWith("630")||numPoliza.startsWith("640")) ramo = "640";
				//
				altaApertura.buscarNumPoliza(ramo, numPoliza);
				altaApertura.continuarPrimeraPoliza();
		
				// 1.Declaración
				SiniestrosAltaAperturaDeclaracionPage datosDeclaracion = new SiniestrosAltaAperturaDeclaracionPage(userS);
				datosDeclaracion.altaDatosBasicos("MEDI", "MAIL");
				//Comprobamos si necesita asistencia
				if(asistencia) {
					datosDeclaracion.altaConAsistencia(true, false, "", "Daños ubicados en el interior del riesgo asegurado", true, false, "");
				}
				else {
					if(datosDeclaracion.posibilidadAsistencia())datosDeclaracion.altaSinAsistencia();
				}
				datosDeclaracion.clickContinuar();
				
				// Validamos cosas
				ValidacionExcepcionesReglasPage validarReglas = new ValidacionExcepcionesReglasPage(userS);
				if(validarReglas.comprobarNombrePagina().contains("excepciones"))validarReglas.clickContinuar();
		
				// Completamos el apartado de Ocurrencia
				SiniestrosAltaAperturaOcurrenciaPage datosOcurrencia = new SiniestrosAltaAperturaOcurrenciaPage(userS); 
				datosOcurrencia.altaRiesgoAsegurado();
				String gCausa = "";
				String tCausa = "";
				String gremio = "";
				if(ramo=="510" || ramo=="660" || ramo=="500" || ramo=="640")
				{
					gCausa="GC02";
					tCausa="TC002000";
					gremio="1";
				}
				else if(ramo=="920")
				{
					gCausa="GC25";
					tCausa="TC025000";
					gremio="1";
				}
				datosOcurrencia.altaSeleccionarCausas(gCausa, tCausa, gremio);
				datosOcurrencia.altaRellenarDatos("Descripción test para realizar un alta de siniestro", false, false);
				datosOcurrencia.clickContinuar();
				
				// Validamos más cosas
				ValidacionExcepcionesReglasPage validarReglas2 = new ValidacionExcepcionesReglasPage(userS);
				if(validarReglas2.comprobarNombrePagina().contains("excepciones"))validarReglas2.clickContinuar();
				
				// Completamos el apartado de Implicado asegurado
				SiniestrosImplicadoAseguradoPage implicadoAsegurado = new SiniestrosImplicadoAseguradoPage(userS);
				implicadoAsegurado.clickApertura();
										
				// Página de confirmación
				SiniestrosConfirmacionPage confirmarAltaSiniestro = new SiniestrosConfirmacionPage(userS);
				confirmarAltaSiniestro.confirmarSiniestroOK();
				}
			
			// Accedemos a siniestros desde Gestión On Line
			
			else if(acceso.compareTo("GOL") == 0) {
				
				new GestionOnlineHomePage(userS).openSiniestros();
				
				
				
			}

			debugEnd();
		}
	
	
		
	//TRAMITAR SINIESTRO
	
	public void tramitar_siniestro(String acceso, String numPoliza) throws Exception {
		debugBegin();
		
		//necesitamos dar de alta previamente un siniestro
		
		alta_siniestro(acceso, numPoliza);
		
		new SiniestrosConfirmacionPage(userS).tramitarSiniestro();		
		
		debugEnd();
	}	
	
	// REALIZAR PAGO DE UN SINIESTRO (desde dar de alta un pago en siniestro hasta confirmarlo)
	
	//realizar_pago_sinietro

	
	
	//MAC: SE INFORMA DE QUE LA POLIZA NO SE PUEDE EMITIR
	
		public void se_informa_de_que_la_poliza_no_se_puede_emitir() { // Compropar el estado	
		Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaError());
	}
	
	
	//MAC: MODIFICAR INGRESOS 	 
	
		public void modificar_ingresos( String ingresos) { 
	  userS.setTestVar("ingresos", ingresos);
}
	
	//MAC AÑADIR AVALISTA
	
		 public void anyado_avalista() throws AWTException,
		 InterruptedException {
		 InquilinosAvalistasPage_MAC avalista = new InquilinosAvalistasPage_MAC(userS);
		 avalista.addDatosAval();
		 
		 avalista.anadirDocumentacionAval();
		 
		 avalista.validacionViabilidadInquilino(); }
	
	//MAC DENIEGO EL PROYECTO MAC USANDO ACCESO Y USUARIO
		 
		 public void deniego_el_proyecto_MAC_usando_el_acceso_Innova_y_usuario(
		  String loginAccess, String user) throws Exception 
		 { 
			this.debugBegin();
			this.login(loginAccess, user);

		  // Abrir la busqueda de autorizaciones
			InnovaHomePage innovaHomePage = new InnovaHomePage(userS) ;
		  innovaHomePage.OpenGestionAutorizaciones();
		  GestionAutorizacionesPage gestionAutorizacionesPage = new  GestionAutorizacionesPage(userS);
		  gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", userS.getTestVar("num_cotizacion"));
		 
		  // Denegar el proyecto gestionAutorizacionesPage.denegar();
		  userS.getDriver().quit();
		 this.debugEnd();
		 
		} 
	
		 public void busco_el_proyecto_usando_el_acceso_y_el_usuario(
			 String loginAccess, String user) throws Exception
		 	{
			 
			  // Login
			  //this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
			  //this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun,
			  //this.tCData.getNoCotizacionMAC());
			  
			  this.login(loginAccess, user);
			 
			  // Abrir el buscador de proyectos // 
			  
//			  if(this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants. LoginAccessGestionLine))  
//			  {  GestionOnlineHomePage
//			  gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
//			  userS.getTestDataManager()); 
//			  gestionOnlineHomePage.openMisProyectosWeb(); 
//			  gestionOnlineHomePage.buscarProyectoWeb(this.tCData.getNoCotizacionMAC());

			  GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(userS);
			  gestionOnlineHomePage.openMisProyectosWeb();
			  gestionOnlineHomePage.buscarProyectoWeb(userS.getTestVar("num_cotizacion"));
			  
//			  
//			  this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(),
//			  this.browserContext.getProperties().passwordComun,
//			  this.tCData.getNoCotizacion());  }
			//  if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.LoginAccessInnova)) // { 
			//  this.browserContext.applicationAccessHelper.loginAndSearchCotizacion(this.tCData.getUsuario(), this.browserContext.getProperties().passwordComun, this.tCData.getNoCotizacion()); // }
			 
			  }
			 
		 public void doy_de_alta_un_proyecto_que_llega_hasta_la_pantalla_de_contratacion_usando_el_acceso_y_el_usuario(
			 String loginAccess, String user) throws Exception
		 	{
		 
			  // Login
			  //this.browserContext.initializeVariables(this.userS.getTestVar("acceso"));
			  //this.browserContext.applicationAccessHelper.LoginAndCreateProjectMAC(this
			  //.tCData.getUsuario(), this.browserContext.getProperties().passwordComun);
			 
			  this.login(loginAccess, user);
			  
			  
//			  // if (this.userS.getTestVar("acceso").equals(MutuaPropietariosConstants.
//			  LoginAccessGestionLine)) // { // GestionOnlineHomePage
//			  gestionOnlineHomePage = new GestionOnlineHomePage(webDriver,
//			  userS.getTestDataManager()); //
//			  gestionOnlineHomePage.openMutuaAlquilerConfort(); // } if
//			  (this.userS.getTestVar("acceso").equals(ProjectConstants.
//			  LoginAccessInnova)) { AsignarMediadorPage asignarMediadorPage = new
//			  AsignarMediadorPage(userS);
//			  asignarMediadorPage.SelectMediadorMACAndClickOnContinuar(); //
//			  InnovaHomePage innovaHomePage = new InnovaHomePage(webDriver,
//			  userS.getTestDataManager()); //
//			  innovaHomePage.OpenMutuaAlquilerConfort(); }
			 
			  new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort();

			  new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar(); 
			  
			  new InnovaHomePage(userS).OpenMutuaAlquilerConfort();
			  
			  
			  // SCS Precio 
			  PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
			  precioPorModalidadPage_MAC.executeActionsInPrecioPorModalidadPage();
			 
			  // SCS Inquilinos
			  InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC
			  = new InquilinosAvalistasPage_MAC(userS);
			  inquilinosAvalistasPage_MAC.executeActionsInInquilinosAvalistasPage();
		  }
		 
		 
		 public void el_proyecto_MAC_se_deniega() { 
			 
			 InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
			 Assert.assertTrue(
			  inquilinosAvalistasPage_MAC.recuperarTextoMensajeError().contains(String.
			  format("¡Error! Se ha denegado la emisión del proyecto")));
		}
		 
		 public void el_proyecto_MAC_se_acepta() { InquilinosAvalistasPage_MAC
		  inquilinosAvalistasPage_MAC = new
		  InquilinosAvalistasPage_MAC(userS);
		  Assert.assertTrue(inquilinosAvalistasPage_MAC.
		  recuperarTextoMensajeValidacionOK().contains(
		  "El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."
		  )); }
		 
		public void el_proyecto_esta_en_estado_denegado() 
		{ 
			if(this.userS.getTestVar("acceso").equals(ProjectConstants.LoginAccessGestionLine))
			{ 
				GestionOnlineHomePage gestionOnlineHomePage =
				new GestionOnlineHomePage(userS);
				Assert.assertEquals(String.format("Denegado"),
				gestionOnlineHomePage.recuperarEstadoPoliza()); 
			}
		 
			else if (this.userS.getTestVar("acceso").equals(ProjectConstants.LoginAccessInnova))
			{	
			  	GestionCotizacionesBuscadorPage
				gestionCotizacionesBuscadorPage = new
				GestionCotizacionesBuscadorPage(userS);
				Assert.assertEquals(String.format("Desestimada"),
				gestionCotizacionesBuscadorPage.getEstadoCotizacion());
		  	}
		 
		  }	 
	
		
		 public void el_resultado_es_que_el_proyecto_se_crea_correctamente() {

		 Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaCreada()); }
		

		  public void completo_el_proceso_de_contratacion_MAC_sin_autorizacion() throws InterruptedException 
		  {
			  debugBegin(); 
			  
			  new InquilinosAvalistasPage_MAC(userS).clickContinuar(); // Rellenar datos de contratacion, pagina 3 
			  
			  new TomadorYAseguradoPage_MAC(userS).executeActionsInTomadorYAseguradoPage();
			 
			  new InmueblePage_MAC(userS).executeActionsInInmueblePage();
			 
			  new DocumentacionPage_MAC(userS).addDocumentContratacion();
			 
			  new ContratacionPage_MAC(userS).seleccionarCheckYContratar();
			  
			  debugEnd();
		  }
		 
		
		  public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(String loginAccess, String user) throws Exception
		  {
			  // Enviar el proyecto

			  new InquilinosAvalistasPage_MAC(userS).enviarACompania();
			 
			  // Cerrar el navegador 
			  
			  userS.getDriver().quit();
			 
			  // Login // 
			 
			  this.login(loginAccess, user);
			  			 
			  // Abrir la busqueda de autorizaciones
			 
			  new InnovaHomePage(userS).OpenGestionAutorizaciones();
			  
			  GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(userS);
			  new GestionAutorizacionesPage(userS).buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", this.userS.getTestVar("num_cotizacion"));
			 
			  // Autorizar el proyecto gestionAutorizacionesPage.autorizar();
			  
			  Assert.assertTrue(gestionAutorizacionesPage.recuperarResultadoAutorizacion().contains("ha sido autorizada correctamente.")); }
			  
		  
			  public void la_renta_mensual_es( String rentaMensualAlquiler) {
			  PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
			  precioPorModalidadPage_MAC.completarRentaMensualAlquiler();
		}
			  
			  
			  
		public void se_inicia_un_proyecto_con_modalidad(String Modalidad) throws Exception {
				 
				// Login
				
			 login(userS.getConfigVar("Acceso"),  userS.getConfigVar("Usuario"));
			  
			  		
				  if (this.userS.getTestVar("acceso").equals("GestionOnline"))
				  {
					  new GestionOnlineHomePage(userS).openContratarMutuaAlquilerConfort(); ;
				  }   
				  else if(this.userS.getTestVar("acceso").equals("Innova"))
				  {
					 new AsignarMediadorPage(userS).SelectMediadorMACAndClickOnContinuar();
				  }
				 
				  // Seleccionar modalidad en Precio page PrecioPorModalidadPage_MAC
				  
				  new PrecioPorModalidadPage_MAC(userS).selectModalidad(); 
			}
			
		public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida()
			  {
				PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
				Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.
				format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €"))); 
			  }
			 
				 	  			  		
		  public void no_deberia_estar_habilitado_convertir_a_proyecto() 
		  {
			  PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
			  
			  Assert.assertFalse(precioPorModalidadPage_MAC.checkConvertirAProyectoIsPresent()); 
		  }
		 
			 
			 
		  public void deberia_aparecer_error_situacion_reasegurado() 
		  {
			  PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(userS);
			  
			  Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.
			  format("¡Error! Situación de reaseguro no es posible la contratación")));
		  }
		
		  
			 
		  public void la_suma_asegurada_de_impago_alquiler_es(String sumaAseguradaImpagoAlquiler)
		  { 
			  new PrecioPorModalidadPage_MAC(userS).seleccionarImpagoAlquiler(); 
		  }
			 
		  
		  public void doy_de_alta_una_simulacion_y_la_convierto_en_un_proyecto_usando(
				String loginAcess, String user) throws Exception
		  
		  {		
			debugBegin();
			
			this.login(loginAcess, user);

			String mediador = this.userS.getScenarioVar("mediador");

			if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) { 
				new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

			} else if(loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
				this.openSimulationMec();
				new AsignarMediadorPage(userS)
					.seleccionarMediadorPorCodigo(mediador)
					.clickOnContinuarButton();
			}

			new UbicacionRiesgoPage(userS).fillInmuebleAndClickOnContinue(userS.getScenario());
			
			new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS).isUbicacionRiesgoUtilizada();
			
			new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();
			
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
			
			//this.browserContext.writeTestCaseData();

			userS.getDriver().quit();
				
				debugEnd();
			}

		
		 public void doy_de_alta_una_simulacion_que_llega_hasta_la_pantalla_de_precio_usando_el_acceso_y_el_usuario(
			  String loginAcess, String user) throws Exception
		 {


				debugBegin();
				
				this.login(loginAcess, user);

				String mediador = this.userS.getScenarioVar("mediador");

				if(loginAcess.equals(ProjectConstants.LoginAccessGestionLine)) { 
					new GestionOnlineHomePage(userS).openContratarMutuaEdificioConfort();

				} else if(loginAcess.equals(ProjectConstants.LoginAccessInnova)) {
					this.openSimulationMec();
					new AsignarMediadorPage(userS)
						.seleccionarMediadorPorCodigo(mediador)
						.clickOnContinuarButton();
				}

			  
			  UbicacionRiesgoPage ubicacionRiesgoPage = new UbicacionRiesgoPage(userS);
			  ubicacionRiesgoPage.addInmueble(userS.getTestVar("inmueble"));
			  ubicacionRiesgoPage.clickOnContinuar();
			  
			  ValidacionesExcepcionesReglasUbicacionRiesgoPage validacionesExcepcionesReglasUbicacionRiesgo = new
			  ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS);
			  validacionesExcepcionesReglasUbicacionRiesgo.isUbicacionRiesgoUtilizada();
			  
			  new DetallesRiesgoPage(userS).completarDatosEnDetallesRiesgo();
			  
			  new ValidacionExcepcionesReglasDetallesRiesgoPage(userS).ClickOnContinuarAndValidate();
			  
			  new PrecioPage(userS).clickOnConvertirAProjecto();
			  
			  DatosBasicosTomadorPage datosBasicosTomadorPage = new DatosBasicosTomadorPage(userS);
			  datosBasicosTomadorPage.fillTomadorData(userS.getTestVar("tomador"));
			  datosBasicosTomadorPage.clickOnContinuar();
			  
			  new PrecioPorModalidadPage(userS).executeActionsInPrecioPorModalidadPage();
			  
		 }
			 
		 
		  public void aparece_aviso(String aviso) throws Exception
		  {
			  ValidacionExcepcionesReglasDetallesRiesgoPage
			  validacionDetallesRiesgoPage = new
			  ValidacionExcepcionesReglasDetallesRiesgoPage(userS);
			  boolean check = false;
			 
			  switch (aviso)
			  { 
				  case ProjectConstants.AvisoPeritajeAntiguead: check =
				  validacionDetallesRiesgoPage.
				  CheckAvisoPeritajeConstructionYearGreaterThan50();
				  break;
				  case ProjectConstants.AvisoPeritajePlantasSotano: check =
				  validacionDetallesRiesgoPage.CheckAvisoPeritajePlantasSotano();
				  break;
				  case ProjectConstants.AvisoPeritajeCapitalContinente: check =
				  validacionDetallesRiesgoPage.
				  CheckAvisoPeritajeCapitalContinenteGreaterThan15000000();
				  break;
				  case ProjectConstants.AvisoPlantasSotanoGreaterThan10: check =
				  validacionDetallesRiesgoPage.CheckAvisoPlantasSotanoMoreThan10();
				  break;
				  case ProjectConstants.AvisoRiesgoAgravado: check =
				  validacionDetallesRiesgoPage.CheckAvisoRiesgoAgravado();
				  break;
				  case ProjectConstants.AvisoComunidadesEnTramite:
				  validacionDetallesRiesgoPage.CheckAvisoComuniadesEnTramite();
				  break; 
				  case ProjectConstants.AvisoPlantasAltoGreaterThan20:
				  validacionDetallesRiesgoPage.CheckAvisoPlantasAlto(); 
				  break; 
				  case ProjectConstants.AvisoModificacionAnyoContruccionGherkin:
				  validacionDetallesRiesgoPage.CheckAvisoConstructionYearWithException();
				  break;
				  case ProjectConstants.AvisoModificacionRehabilitacionIntegral:
				  validacionDetallesRiesgoPage.
				  CheckAvisoRehabilitacionIntegralWithException();
				  break; 
				  case ProjectConstants.AvisoGarajes: DetallesRiesgoPage detallesRiesgoPage =
				  new DetallesRiesgoPage(userS);
				  detallesRiesgoPage.CheckAvisoGarajesWithException();
				  break;
				  
				  default: throw new Exception(ProjectConstants.AvisoNoContemplado); } if (check)
				  validacionDetallesRiesgoPage.CheckAviso(aviso);
			  }
		 
		 
		  
//FIN				 
}


