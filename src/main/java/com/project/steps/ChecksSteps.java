package com.project.steps;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.testCasesData.Pages.ClientesPage;
import com.mutuaPropietarios.testCasesData.Pages.ContratacionPage_MAC;
import com.mutuaPropietarios.testCasesData.Pages.DetallesRiesgoPage;
import com.mutuaPropietarios.testCasesData.Pages.FichaEdificioPage;
import com.mutuaPropietarios.testCasesData.Pages.GestionAutorizacionesPage;
import com.mutuaPropietarios.testCasesData.Pages.GestionCotizacionesBuscadorPage;
import com.mutuaPropietarios.testCasesData.Pages.GestionOnlineHomePage;
import com.mutuaPropietarios.testCasesData.Pages.GestionPolizasBuscadorPage;
import com.mutuaPropietarios.testCasesData.Pages.GestionPolizasConsultarPage;
import com.mutuaPropietarios.testCasesData.Pages.InnovaHomePage;
import com.mutuaPropietarios.testCasesData.Pages.InquilinosAvalistasPage_MAC;
import com.mutuaPropietarios.testCasesData.Pages.MediadoresFichaMediadorPage;
import com.mutuaPropietarios.testCasesData.Pages.MensajeConfirmacionPage;
import com.mutuaPropietarios.testCasesData.Pages.PrecioPorModalidadPage_MAC;
import com.mutuaPropietarios.testCasesData.Pages.ValidacionExcepcionesReglasDetallesRiesgoPage;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

import cucumber.api.java.es.Entonces;

public class ChecksSteps
{
	private BrowserContext browserContext;
	private TestCaseData tCData;
	// private TestCaseData tCData;
	Locale locale = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(this.locale);
	final static Logger logger = LoggerFactory.getLogger(ChecksSteps.class);
	
	public ChecksSteps(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.tCData = browserContext.getTestCaseData();
	}
	
	@Entonces("^el edificio se encuentra$")
	public void el_edificio_se_encuentra() throws Throwable
	{
		logger.debug("BEGIN - el_edificio_se_encuentra");
		
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
		org.junit.Assert.assertTrue(fichaEdificioPage.checkResultadoDireccion());

		logger.debug("END - el_edificio_se_encuentra");
	}
	
	@Entonces("^se visualiza la cabecera de la ficha de edificio$")
	public void visualiza_cabecera_ficha_edificio() throws Throwable
	{
		logger.debug("BEGIN - visualiza_cabecera_ficha_edificio");
		
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
		org.junit.Assert.assertTrue(fichaEdificioPage.checkCabeceraFicha());

		logger.debug("END - visualiza_cabecera_ficha_edificio");
	}
	
	@Entonces("^se visualiza la pestaña Resumen de la ficha de edificio$")
	public void visualiza_pestana_resumen_ficha_edificio() throws Throwable
	{
		logger.debug("BEGIN - visualiza_pestana_resumen_ficha_edificio");
		
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
		org.junit.Assert.assertTrue(fichaEdificioPage.checkPestanaResumenVisible());

		logger.debug("END - visualiza_pestana_resumen_ficha_edificio");
	}
	
	@Entonces("^se visualiza la pestaña Pólizas de la ficha de edificio$")
	public void visualiza_pestana_polizas_ficha_edificio() throws Throwable
	{
		logger.debug("BEGIN - visualiza_pestana_polizas_ficha_edificio");
		
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(this.browserContext);
		org.junit.Assert.assertTrue(fichaEdificioPage.checkPestanaPolizasVisible());

		logger.debug("END - visualiza_pestana_polizas_ficha_edificio");
	}

	@Entonces("^el cliente se encuentra$")
	public void el_cliente_se_encuentra() throws Throwable
	{
		logger.debug("BEGIN - el_cliente_se_encuentra");

		ClientesPage clientePage = new ClientesPage(this.browserContext);
		org.junit.Assert.assertTrue(clientePage.checkResultadoNIF());
		// TODO Agregar la comprobacion de resultado de busqueda en la ficha cliente

		logger.debug("END - el_cliente_se_encuentra");
	}
	
	// @Entonces("^el resultado es que el projecto se crea correctamente$")
	// public void el_resultado_es_que_el_projecto_se_crea_correctamente() throws Throwable
	// {
	// logger.debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente");
	// if (this.browserContext.getTestCaseData().getGestionOnlineDisponible().equals(MutuaPropietariosConstants.LoginAccessInnova))
	// {
	// org.junit.Assert.assertNotNull(this.browserContext.getTestCaseData().getNoCotizacion());
	// }
	// logger.debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente");
	// }

	@Entonces("^el resultado es que el projecto se crea correctamente$")
	public void el_resultado_es_que_el_projecto_se_crea_correctamente() throws Throwable
	{
		logger.debug("BEGIN - el_resultado_es_que_el_projecto_se_crea_correctamente");

		if (this.tCData.getAcceso().equals(ProjectConstants.LoginAccessInnova))
		{
			// For the time being we check that the policy appears correctly in Innov@, but this should be changed to check the policy in GO.

			this.browserContext.initializeVariables(this.tCData.getCambioAcceso());
			this.browserContext.applicationAccessHelper.LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),
					this.browserContext.getProperties().passwordComun, String.valueOf(this.tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
			gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this.browserContext.getTestCaseData().getNumPoliza()));
			gestionPolizasBuscadorPage.ConsultarPoliza();
			GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(this.browserContext);
			gestionPolizasConsultarPage.CheckPolizaNumber();
			
		}

		if (this.tCData.getAcceso().equals(ProjectConstants.LoginAccessGestionLine))
		{
			// Here we check if the policy created in GO appears correctly in Innov@
			// Login
			this.browserContext.initializeVariables(this.tCData.getCambioAcceso());
			this.browserContext.applicationAccessHelper.LoginAndSearchPolizaByPolizaNumber(this.tCData.getCambioUsuario(),
					this.browserContext.getProperties().passwordComun, String.valueOf(this.tCData.getNumPoliza()));

			GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
			gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this.browserContext.getTestCaseData().getNumPoliza()));
			gestionPolizasBuscadorPage.ConsultarPoliza();
			GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(this.browserContext);
			gestionPolizasConsultarPage.CheckPolizaNumber();

		}

		logger.debug("END - el_resultado_es_que_el_projecto_se_crea_correctamente");
	}
	
	@Entonces("^el valor de los capitales varia$")
	public void el_valor_de_los_capitales_varia() throws Throwable
	{
		if (this.browserContext.getTestCaseData().isCantidadesModifiedError())
		{
			throw new AssertionError(this.browserContext.getTestCaseData().getCantidadesModifiedErrorMessage());
		}
	}
	
	@Entonces("^resultado es que el projecto se crea correctamente$")
	public void el_resultado_es_que_el_proyecto_se_crea_correctamente() throws Throwable
	{
		ContratacionPage_MAC contratacionPage_MAC = new ContratacionPage_MAC(this.browserContext);
		Assert.assertTrue(contratacionPage_MAC.checkPolizaCreada());
	}
	
	@Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un infraseguro$")
	public void el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_infraseguro() throws Throwable
	{
		// Este paso es puramente informativo. Esta comprobación se hace cada vez que se crea un
		// ifraseguro en la pantalla de validacion excepciones
		// reglas
	}
	
	@Entonces("^aparece una clausula adicional$")
	public void aparece_una_clausula_adicional() throws Throwable
	{
		// Este paso es puramente informativo. Esta comprobación se hace cadea vez que se crea un
		// infraseguro en la pantalla de clausulas
	}
	
	@Entonces("^el resultado es que aparece un mensaje indicando que se va a crear un supraseguro$")
	public void el_resultado_es_que_aparece_un_mensaje_indicando_que_se_va_a_crear_un_supraseguro() throws Throwable
	{
		// Este paso es puramente informativo. Esta comprobación se hace cada vez que se crea un
		// supraseguro en la pantalla de validacion excepciones
		// reglas
	}
	
	@Entonces("^los datos de ese cliente se completan automáticamente$")
	public void los_datos_de_ese_cliente_se_completan_automáticamente() throws Throwable
	{
		// Este paso es puramente informativo. Esta comprobación se hace en la pantalla de datos basicos
		// tomador al seleccionar como cliente un cliente
		// existente
	}
	
	@Entonces("^sale un aviso si el precio no cambia$")
	public void sale_un_aviso_si_el_precio_no_cambia() throws Throwable
	{
		if (this.browserContext.getTestCaseData().isCapitalesModifiedError())
		{
			throw new AssertionError(this.browserContext.getTestCaseData().getCapitalesModifiedErrorMessage());
		}
	}
	
	@Entonces("^se añade una franquicia obligatoria$")
	public void se_añade_una_franquicia_obligatoria() throws Throwable
	{
		// Este paso es puramente informativo. Esta comprobación se hace en la pantalla de Precio cada
		// vez que se añade un descuento.
	}
	
	@Entonces("^el valor de los capitales varia una vez se añade la cobertura opcional$")
	public void el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional() throws Throwable
	{
		if (this.browserContext.getTestCaseData().isCapitalesModifiedError())
		{
			throw new AssertionError(this.browserContext.getTestCaseData().getCapitalesModifiedErrorMessage());
		}
	}
	
	@Entonces("^aparece aviso \"([^\"]*)\"$")
	public void aparece_aviso(
			String aviso) throws Throwable
	{
		ValidacionExcepcionesReglasDetallesRiesgoPage validacionDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(
				this.browserContext);
		boolean check = false;
		
		switch (aviso)
		{
			case ProjectConstants.AvisoPeritajeAntiguead:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajeConstructionYearGreaterThan50();
				break;
			case ProjectConstants.AvisoPeritajePlantasSotano:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajePlantasSotano();
				break;
			case ProjectConstants.AvisoPeritajeCapitalContinente:
				check = validacionDetallesRiesgoPage.CheckAvisoPeritajeCapitalContinenteGreaterThan15000000();
				break;
			case ProjectConstants.AvisoPlantasSotanoGreaterThan10:
				check = validacionDetallesRiesgoPage.CheckAvisoPlantasSotanoMoreThan10();
				break;
			case ProjectConstants.AvisoRiesgoAgravado:
				check = validacionDetallesRiesgoPage.CheckAvisoRiesgoAgravado();
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
				validacionDetallesRiesgoPage.CheckAvisoRehabilitacionIntegralWithException();
				break;
			case ProjectConstants.AvisoGarajes:
				DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
				detallesRiesgoPage.CheckAvisoGarajesWithException();
				break;
			default:
				throw new Exception(ProjectConstants.AvisoNoContemplado);
		}
		if (check)
			validacionDetallesRiesgoPage.CheckAviso(aviso);
	}
	
	@Entonces("^aparece un mensaje indicando que el projecto será revisado por la compañia$")
	public void aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia() throws Throwable
	{
		logger.debug("BEGIN - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia");
		// Pure informative step. This check is performed with the function
		logger.debug("END - aparece_un_mensaje_indicando_que_el_projecto_será_revisado_por_la_compañia");
	}
	
	@Entonces("^la cotizacion se actualiza correctamente$")
	public void la_cotizacion_se_actualiza_correctamente() throws Throwable
	{
		logger.debug("BEGIN - la_cotizacion_se_actualiza_correctamente");
		MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(this.browserContext);
		mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
		logger.debug("END - la_cotizacion_se_actualiza_correctamente");
		
	}
	
	@Entonces("^la copia tomador deberia tener los nuevos datos$")
	public void la_copia_tomador_deberia_tener_los_nuevos_datos() throws Throwable
	{
		logger.debug("BEGIN - la_copia_tomador_deberia_tener_los_nuevos_datos");
		MensajeConfirmacionPage mensajeConfirmacionPage = new MensajeConfirmacionPage(this.browserContext);
		mensajeConfirmacionPage.CheckIfPageHasLoadedCorrectly();
		mensajeConfirmacionPage.searchTextInCopiaTomadorPDF();
		logger.debug("END - la_copia_tomador_deberia_tener_los_nuevos_datos");
		
	}

	@Entonces("^el resultado es que aparece un mensaje de error y los campos deshabilitación y edificio madera aparecen resaltados en rojo$")
	public void el_resultado_es_que_aparece_un_mensaje_de_error_y_los_campos_deshabilitación_y_edificio_madera_aparecen_resaltados_en_rojo()
			throws Throwable
	{
		// Step puramente informativo. Los chequeos se hacen en el paso que crea la simulación.
	}
	
	@Entonces("^se muestra la ventana para imprimir la poliza$")
	public void se_muestra_la_ventana_para_imprimir_la_poliza() throws Throwable
	{
		// Step puramente informativo. Los chequeos se hacen en el último paso de la simulacion, en la
		// pantalla con el listado de documentos
	}
	
	@Entonces("^la poliza muestra \"([^\"]*)\" en la solapa Coberturas$")
	public void la_poliza_muestra_en_la_solapa_Coberturas(
			String arg1) throws Throwable
	{
		
	}
	
	@Entonces("^el campo cotización contiene el valor \"([^\"]*)\"$")
	public void el_campo_cotización_contiene_el_valor(
			String cotizacionValue) throws Throwable
	{
		logger.debug("BEGIN - el_campo_cotización_contiene_el_valor");
		GestionCotizacionesBuscadorPage gestionCotizacionesBuscacorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
		String cotizacion = gestionCotizacionesBuscacorPage.getCotizacion();
		Assert.assertTrue(cotizacion.contains(this.tCData.getNoCotizacion()));
		logger.debug("END - el_campo_cotización_contiene_el_valor");
	}
	
	@Entonces("^la poliza \"([^\"]*)\" en la pestaña \"([^\"]*)\"$")
	public void la_poliza_muestra_en_la_pestanya(
			String toBeChecked, String tab) throws Throwable
	{
		this.browserContext.applicationAccessHelper.OpenGestionPolizas();
		GestionPolizasBuscadorPage gestionPolizasBuscadorPage = new GestionPolizasBuscadorPage(this.browserContext);
		gestionPolizasBuscadorPage.SearchPolizaByPolizaNumber(String.valueOf(this.browserContext.getTestCaseData().getNumPoliza()));
		gestionPolizasBuscadorPage.ConsultarPoliza();
		GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(this.browserContext);
		
		switch (toBeChecked)
		{
			case ProjectConstants.PolizaDetailConstructionYear:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailConstructionYear, this.tCData.getAnyoConstruccion());
				break;
			case ProjectConstants.PolizaDetailCapitalContinente:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailCapitalContinente, this.nf.format(this.tCData.getCapitalContinente()).toString());
				break;
			case ProjectConstants.PolizaDetailCapitalContenido:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailCapitalContenido, this.nf.format(this.tCData.getCapitalContenido()).toString());
				break;
			case ProjectConstants.PolizaDetailNuevaClausulaHipotecaria:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabClausulas,
						ProjectConstants.PolizaDetailNuevaClausulaHipotecaria, ProjectConstants.DescuentoRecargoNotSpecified);
				break;
			case ProjectConstants.PolizaDetailLocalesExcluidos:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailLocalesExcluidos, ProjectConstants.DescuentoRecargoNotSpecified);
				break;
			case ProjectConstants.PolizaDetailDepositoCombustible:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailDepositoCombustible, ProjectConstants.DescuentoRecargoNotSpecified);
				break;
			case ProjectConstants.PolizaDetailCalefaccionCentral:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailCalefaccionCentral, ProjectConstants.DescuentoRecargoNotSpecified);
				break;
			case ProjectConstants.PolizaDetailPlacaSolar:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailPlacaSolar, this.browserContext.getTestCaseData().getInstalacionesFotovoltaicasValor() + " €");
				break;
			case ProjectConstants.PolizaDetailMaquinaria:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailMaquinaria, this.browserContext.getTestCaseData().getCoberturaOpcionalMaquinariaValor() + " €");
				break;
			case ProjectConstants.PolizaDetailNoRecargo:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabImportes,
						ProjectConstants.PolizaDetailNoRecargo, null);
				break;
			case ProjectConstants.PolizaDetailRecargo:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabImportes,
						ProjectConstants.PolizaDetailNoRecargo, ProjectConstants.PolizaDetailDescuentoValue);
				break;
			case ProjectConstants.PolizaDetailNoDescuento:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabImportes,
						ProjectConstants.PolizaDetailNoDescuento, null);
				break;
			case ProjectConstants.PolizaDetailDescuento:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabImportes,
						ProjectConstants.PolizaDetailDescuentoValue, ProjectConstants.PorcentajeDescuentoRecargo);
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabImportes,
						ProjectConstants.PolizaDetailDescuento, ProjectConstants.TipoDescuento);
				break;
			case ProjectConstants.PolizaDetailClausula:
				gestionPolizasConsultarPage.CheckClausulas();
				break;
			case ProjectConstants.PolizaDetailM2ConstruidosTotales:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailM2ConstruidosTotales, this.nf.format(this.tCData.getM2ContruidosTotales()).toString());
				break;
			case ProjectConstants.PolizaDetailYearAndRehabilitationLevel:
				gestionPolizasConsultarPage.CheckAnyoAndNivelRehabilitacion();
				break;
			case ProjectConstants.PolizaDetailYearRehabilitacionIntegral:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailYearRehabilitacionIntegral, this.tCData.getM2ContruidosTotales().toString());
				break;
			case ProjectConstants.PolizaDetailCalidadConstruccion:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailCalidadConstruccion, this.tCData.getCalidadConstruccion());
				break;
			case ProjectConstants.PolizaDetailFranquiciaVoluntaria:
				gestionPolizasConsultarPage.CheckValueInTab(ProjectConstants.PolizaDetailTabDetallesRiesgo,
						ProjectConstants.PolizaDetailFranquiciaVoluntaria, this.tCData.getFranquiciaVoluntaria());
				break;
			default:
				throw new Exception(String.format("El checqueo para %s no se ha implementado", toBeChecked));
		}
	}
	
	@Entonces("^esta habilitado el campo \"([^\"]*)\"$")
	public void esta_habilitado_el_campo(
			String fieldValue) throws Throwable
	{
		DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(this.browserContext);
		Assert.assertTrue(String.format("El campo %s no está habilitado", fieldValue), detallesRiesgoPage.IsFieldEnabled(fieldValue));
	}
	
	@Entonces("^el proyecto MAC se deniega$")
	public void el_proyecto_MAC_se_deniega() throws Throwable
	{
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
		Assert.assertTrue(
				inquilinosAvalistasPage_MAC.recuperarTextoMensajeError().contains(String.format("¡Error! Se ha denegado la emisión del proyecto")));
	}

	@Entonces("^el proyecto MAC se acepta$")
	public void el_proyecto_MAC_se_acepta() throws Throwable
	{
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
		Assert.assertTrue(inquilinosAvalistasPage_MAC.recuperarTextoMensajeValidacionOK().contains(
				"El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."));
	}
	
	@Entonces("^el proyecto esta en estado denegado$")
	public void el_proyecto_esta_en_estado_denegado() throws Throwable
	{
		if (this.tCData.getAcceso().equals(ProjectConstants.LoginAccessGestionLine))
		{
			GestionOnlineHomePage gestionOnlineHomePage = new GestionOnlineHomePage(this.browserContext);
			Assert.assertEquals(String.format("Denegado"), gestionOnlineHomePage.recuperarEstadoPoliza());
		}

		if (this.tCData.getAcceso().equals(ProjectConstants.LoginAccessInnova))
		{
			GestionCotizacionesBuscadorPage gestionCotizacionesBuscadorPage = new GestionCotizacionesBuscadorPage(this.browserContext);
			Assert.assertEquals(String.format("Desestimada"), gestionCotizacionesBuscadorPage.getEstadoCotizacion());
		}

	}

	@Entonces("se puede autorizar usando el acceso \"([^\"]*)\" y usuario \"([^\"]*)\"$")
	public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(
			String loginAcess, String user) throws Throwable
	{
		// Enviar el proyecto
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(this.browserContext);
		inquilinosAvalistasPage_MAC.enviarACompania();

		// Cerrar el navegador
		this.browserContext.getWebDriver().quit();
		
		// Login
		// this.browserContext.initializeVariables(
		// getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(), loginAcess, this.browserContext.getTestCaseData().getTestID()));
		// this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(
		// getValuesDataSet(this.browserContext.getTestCaseData().gethMapDataSet(), user, this.browserContext.getTestCaseData().getTestID()),
		// this.browserContext.getProperties().passwordComun);
		
		System.out.println("Valor accesoAuth: " + this.tCData.getAccesoAuth());
		this.browserContext.initializeVariables(this.tCData.getAccesoAuth());
		this.browserContext.applicationAccessHelper.LoginAndSearchAutorizacion(this.tCData.getUsuarioAuth(),
				this.browserContext.getProperties().passwordComun);
		
		// Abrir la busqueda de autorizaciones
		InnovaHomePage innovaHomePage = new InnovaHomePage(this.browserContext);
		innovaHomePage.OpenGestionAutorizaciones();
		GestionAutorizacionesPage gestionAutorizacionesPage = new GestionAutorizacionesPage(this.browserContext);
		gestionAutorizacionesPage.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar",
				this.browserContext.getTestCaseData().getNoCotizacionMAC());

		// Autorizar el proyecto
		gestionAutorizacionesPage.autorizar();
		Assert.assertTrue(gestionAutorizacionesPage.recuperarResultadoAutorizacion().contains("ha sido autorizada correctamente."));
	}
	
	@Entonces("^los datos de prospect grabados coinciden$")
	public void datos_prospect_grabados_coinciden() throws Throwable
	{
		String nombreComercial = String.valueOf(this.tCData.getNombreComercialProspect()).toUpperCase();
		MediadoresFichaMediadorPage fichaMediadorPage = new MediadoresFichaMediadorPage(this.browserContext);
		Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(nombreComercial));
	}
	
	@Entonces("^los datos de mediador grabados coinciden$")
	public void datos_mediador_grabados_coinciden() throws Throwable
	{
		if (this.tCData.getTipoNombreComercialMediador().equals("Igual que el fiscal"))
		{
			String nombreComercial = String
					.valueOf(
							this.tCData.getNombreFiscalMediador() + " " + this.tCData.getPrimerApellidoMediador() + " " + this.tCData.getSegundoApellidoMediador())
					.toUpperCase();
			System.out.println("*** Nombre comercial" + nombreComercial);
			MediadoresFichaMediadorPage fichaMediadorPage = new MediadoresFichaMediadorPage(this.browserContext);
			Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(nombreComercial));
		}

		if (this.tCData.getTipoNombreComercialMediador().equals("Diferente que el fiscal"))
		{
			String nombreComercial = String.valueOf(this.tCData.getNombreComercialMediador()).toUpperCase();
			MediadoresFichaMediadorPage fichaMediadorPage = new MediadoresFichaMediadorPage(this.browserContext);
			Assert.assertTrue(fichaMediadorPage.getContenidoTituloPagina().contains(nombreComercial));
		}
		
	}

	@Entonces("^debería aparecer ¡Error! Rebasada la renta máxima permitida de 3.000,00 €$")
	public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida() throws Throwable
	{
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(
				precioPorModalidadPage_MAC.recuperarTextoMensajeError().contains(String.format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €")));
	}

	@Entonces("^debería aparecer ¡Error! Situación de reaseguro no es posible la contratación$")
	public void deberia_aparecer_error_situacion_reasegurado() throws Throwable
	{
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(precioPorModalidadPage_MAC.recuperarTextoMensajeError()
				.contains(String.format("¡Error! Situación de reaseguro no es posible la contratación")));
	}

	@Entonces("^no debería estar habilitado Convertir a proyecto$")
	public void no_deberia_estar_habilitado_convertir_a_proyecto() throws Throwable
	{
		PrecioPorModalidadPage_MAC precioPorModalidadPage_MAC = new PrecioPorModalidadPage_MAC(this.browserContext);
		// Comprobar que se queda deshabilitado Convertir a proyecto
		Assert.assertFalse(precioPorModalidadPage_MAC.checkConvertirAProyectoIsPresent());
	}
	
}
