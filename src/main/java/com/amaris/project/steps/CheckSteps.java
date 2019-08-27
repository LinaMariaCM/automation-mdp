package com.amaris.project.steps;

import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.ClientePage;
import com.amaris.project.pages.ContratacionPage_MAC;
import com.amaris.project.pages.DetallesRiesgoPage;
import com.amaris.project.pages.FichaEdificioPage;
import com.amaris.project.pages.GestionAutorizacionesPage;
import com.amaris.project.pages.GestionCotizacionesBuscadorPage;
import com.amaris.project.pages.GestionOnlineHomePage;
import com.amaris.project.pages.GestionPolizasBuscadorPage;
import com.amaris.project.pages.GestionPolizasConsultarPage;
import com.amaris.project.pages.InnovaHomePage;
import com.amaris.project.pages.InquilinosAvalistasPage_MAC;
import com.amaris.project.pages.MediadoresFichaMediadorPage;
import com.amaris.project.pages.MensajeConfirmacionPage;
import com.amaris.project.pages.PrecioPorModalidadPage_MAC;
import com.amaris.project.pages.ValidacionExcepcionesReglasDetallesRiesgoPage;

public class CheckSteps extends InteractionObject {

	public CheckSteps(UserStory userS) {
		super(userS);
	}

	public void el_edificio_se_encuentra() {
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);

		Assert.assertTrue(fichaEdificioPage.checkResultadoDireccion());
	}

	public void visualiza_cabecera_ficha_edificio() {
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);

		Assert.assertTrue(fichaEdificioPage.checkCabeceraFicha());
	}

	public void visualiza_pestana_resumen_ficha_edificio() {
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);

		Assert.assertTrue(fichaEdificioPage.checkPestanaResumenVisible());
	}

	public void visualiza_pestana_polizas_ficha_edificio() {
		FichaEdificioPage fichaEdificioPage = new FichaEdificioPage(userS);

		Assert.assertTrue(fichaEdificioPage.checkPestanaPolizasVisible());
	}

	public void el_cliente_se_encuentra() {
		ClientePage clientePage = new ClientePage(userS);

		Assert.assertTrue(clientePage.checkResultadoNIF());
		// TODO Agregar la comprobacion de resultado de busqueda en la ficha cliente
	}

	public void el_resultado_es_que_el_projecto_se_crea_correctamente() throws Exception {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			// For the time being we check that the policy appears correctly in Innov@, but this should be changed to
			// check the policy in GO.
			new ActionSteps(userS).login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			// Here we check if the policy created in GO appears correctly in Innov@
			// Login
			new ActionSteps(userS).login(getScenarioVar(Constants.CAMBIO_ACCESO), getScenarioVar(Constants.USUARIO));
		}

		new InnovaHomePage(userS).OpenGestionPolizas();

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA))
			.ConsultarPoliza();

		new GestionPolizasConsultarPage(userS).CheckPolizaNumber();
	}

	public void el_valor_de_los_capitales_varia() {
		// TODO Dejar un solo metodo con el nombre comprobar_capitales_modificados
		el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
	}

	public void el_resultado_es_que_el_proyecto_se_crea_correctamente() {
		Assert.assertTrue(new ContratacionPage_MAC(userS).checkPolizaCreada());
	}

	public void sale_un_aviso_si_el_precio_no_cambia() {
		// TODO Dejar un solo metodo con el nombre comprobar_capitales_modificados
		el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
	}

	public void el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional() {
		if(Boolean.parseBoolean(getScenarioVar(Constants.CAPITALES_MODIFIED_ERROR))) {
			debugInfo("Mensaje capitales modificados:" + getScenarioVar(Constants.CAPITALES_MODIFIED_MESSAGE));

			throw new AssertionError(getScenarioVar(Constants.CAPITALES_MODIFIED_MESSAGE));
		}
	}

	public void aparece_aviso(String aviso) throws Exception {
		boolean check = false;
		ValidacionExcepcionesReglasDetallesRiesgoPage validacionDetallesRiesgoPage = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS);

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
				new DetallesRiesgoPage(userS)
					.CheckAvisoGarajesWithException();
				break;
			default:
				throw new Exception(Constants.AvisoNoContemplado);
		}

		if(check) {
			validacionDetallesRiesgoPage.CheckAviso(aviso);
		}
	}

	public void la_cotizacion_se_actualiza_correctamente() {
		new MensajeConfirmacionPage(userS)
			.CheckIfPageHasLoadedCorrectly();
	}

	public void la_copia_tomador_deberia_tener_los_nuevos_datos() {
		new MensajeConfirmacionPage(userS)
			.CheckIfPageHasLoadedCorrectly()
			.searchTextInCopiaTomadorPDF();
	}

	public void el_campo_cotización_contiene_el_valor() {
		String cotizacion = new GestionCotizacionesBuscadorPage(userS).getCotizacion();

		Assert.assertTrue(cotizacion.contains(getScenarioVar(Constants.NUM_COTIZACION)));
	}

	public void la_poliza_muestra_en_la_pestanya(String toBeChecked, String tab) throws Exception {
		new InnovaHomePage(userS).OpenGestionPolizas();

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA))
			.ConsultarPoliza();

		GestionPolizasConsultarPage gestionPolizasConsultarPage = new GestionPolizasConsultarPage(userS);

		switch(toBeChecked) {
			case Constants.PolizaDetailConstructionYear:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailConstructionYear, getScenarioVar(Constants.ANYO_CONSTRUIDO));
				break;
			case Constants.PolizaDetailCapitalContinente:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCapitalContinente, getScenarioVar(Constants.CAPITAL_CONTINENTE));
				break;
			case Constants.PolizaDetailCapitalContenido:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCapitalContenido, getScenarioVar(Constants.CAPITAL_CONTENIDO));
				break;
			case Constants.PolizaDetailNuevaClausulaHipotecaria:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabClausulas, Constants.PolizaDetailNuevaClausulaHipotecaria, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailLocalesExcluidos:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailLocalesExcluidos, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailDepositoCombustible:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailDepositoCombustible, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailCalefaccionCentral:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCalefaccionCentral, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailPlacaSolar:
				gestionPolizasConsultarPage
					.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailPlacaSolar, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_VALOR) + " €");
				break;
			case Constants.PolizaDetailMaquinaria:
				gestionPolizasConsultarPage
					.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailMaquinaria, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR) + " €");
				break;
			case Constants.PolizaDetailNoRecargo:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoRecargo, null);
				break;
			case Constants.PolizaDetailRecargo:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoRecargo, Constants.PolizaDetailDescuentoValue);
				break;
			case Constants.PolizaDetailNoDescuento:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoDescuento, null);
				break;
			case Constants.PolizaDetailDescuento:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailDescuentoValue, Constants.PorcentajeDescuentoRecargo);
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailDescuento, Constants.TipoDescuento);
				break;
			case Constants.PolizaDetailClausula:
				gestionPolizasConsultarPage.CheckClausulas();
				break;
			case Constants.PolizaDetailM2ConstruidosTotales:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailM2ConstruidosTotales, getTestVar(Constants.M2_CONSTRUIDOS));
				break;
			case Constants.PolizaDetailYearAndRehabilitationLevel:
				gestionPolizasConsultarPage.CheckAnyoAndNivelRehabilitacion();
				break;
			case Constants.PolizaDetailYearRehabilitacionIntegral:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailYearRehabilitacionIntegral, getTestVar(Constants.M2_CONSTRUIDOS));
				break;
			case Constants.PolizaDetailCalidadConstruccion:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCalidadConstruccion, getTestVar(Constants.CALIDAD_CONSTRUCCION));
				break;
			case Constants.PolizaDetailFranquiciaVoluntaria:
				gestionPolizasConsultarPage.CheckValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailFranquiciaVoluntaria, getTestVar(Constants.FRANQUICIA_VOLUNTARIA));
				break;
			default:
				throw new Exception(String.format("El checqueo para %s no se ha implementado", toBeChecked));
		}
	}

	public void esta_habilitado_el_campo(String fieldValue) {
		DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(userS);

		Assert.assertTrue(detallesRiesgoPage.IsFieldEnabled(fieldValue), String.format("El campo %s no está habilitado", fieldValue));
	}

	public void el_proyecto_MAC_se_deniega() {
		Assert.assertTrue(new InquilinosAvalistasPage_MAC(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Se ha denegado la emisión del proyecto")));
	}

	public void el_proyecto_MAC_se_acepta() {
		Assert.assertTrue(new InquilinosAvalistasPage_MAC(userS).recuperarTextoMensajeValidacionOK()
			.contains("El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."));
	}

	public void el_proyecto_esta_en_estado_denegado() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			Assert.assertEquals(String.format("Denegado"), new GestionOnlineHomePage(userS).recuperarEstadoPoliza());
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			Assert.assertEquals(String.format("Desestimada"), new GestionCotizacionesBuscadorPage(userS).getEstadoCotizacion());
		}
	}

	public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(String loginAcess, String user) throws Exception {
		// Enviar el proyecto
		InquilinosAvalistasPage_MAC inquilinosAvalistasPage_MAC = new InquilinosAvalistasPage_MAC(userS);
		inquilinosAvalistasPage_MAC.enviarACompania();

		// Cerrar el navegador
		userS.getWebDriver().quit();

		// Login
		// userS.initializeVariables(
		// getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), loginAcess, userS.getTestCaseData().getTestID()));
		// userS.applicationAccessHelper.LoginAndSearchAutorizacion(
		// getValuesDataSet(userS.getTestCaseData().gethMapDataSet(), user, userS.getTestCaseData().getTestID()),
		// userS.getProperties().passwordComun);

		debugInfo("Valor accesoAuth: " + getScenarioVar(Constants.ACCESO_AUTORIZADO));

		new ActionSteps(userS).login(getScenarioVar(Constants.ACCESO_AUTORIZADO), getScenarioVar(Constants.USUARIO_AUTORIZADO));

		// Abrir la busqueda de autorizaciones
		new InnovaHomePage(userS).OpenGestionAutorizaciones();

		String resultadoAutorizacion = new GestionAutorizacionesPage(userS)
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION))
			.autorizar()
			.recuperarResultadoAutorizacion();

		Assert.assertTrue(resultadoAutorizacion.contains("ha sido autorizada correctamente."));
	}

	public void datos_prospect_grabados_coinciden() {
		String nombreComercial = getTestVar(Constants.NOMBRE_COMERCIAL_PROSPECT).toUpperCase();

		Assert.assertTrue(new MediadoresFichaMediadorPage(userS).getContenidoTituloPagina()
			.contains(nombreComercial));
	}

	public void datos_mediador_grabados_coinciden() {
		if(getScenarioVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Igual que el fiscal")) {
			String nombreComercial = (getScenarioVar(Constants.NOMBRE_MEDIADOR) + " "
				+ getScenarioVar(Constants.PRIMER_APELLIDO_MEDIADOR) + " "
				+ getScenarioVar(Constants.SEGUNDO_APELLIDO_MEDIADOR))
					.toUpperCase();

			debugInfo("*** Nombre comercial" + nombreComercial);
			Assert.assertTrue(new MediadoresFichaMediadorPage(userS).getContenidoTituloPagina()
				.contains(nombreComercial));
		} else if(getScenarioVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Diferente que el fiscal")) {
			String nombreComercial = getScenarioVar(Constants.NOMBRE_MEDIADOR).toUpperCase();

			Assert.assertTrue(new MediadoresFichaMediadorPage(userS).getContenidoTituloPagina()
				.contains(nombreComercial));
		}
	}

	public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida() {
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(new PrecioPorModalidadPage_MAC(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €")));
	}

	public void deberia_aparecer_error_situacion_reasegurado() {
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(new PrecioPorModalidadPage_MAC(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Situación de reaseguro no es posible la contratación")));
	}

	public void no_deberia_estar_habilitado_convertir_a_proyecto() {
		// Comprobar que se queda deshabilitado Convertir a proyecto
		Assert.assertFalse(new PrecioPorModalidadPage_MAC(userS).checkConvertirAProyectoIsPresent());
	}
}