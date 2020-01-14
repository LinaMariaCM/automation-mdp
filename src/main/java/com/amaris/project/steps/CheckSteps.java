package com.amaris.project.steps;

import com.amaris.project.pages.administracion.mediadores.FichaMediadorPage;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.clientes.ClientePage;
import com.amaris.project.pages.administracion.fichaedificio.FichaEdificioPage;
import com.amaris.project.pages.administracion.mediadores.FichaMediadorPage;
import com.amaris.project.pages.administracion.gestionautorizaciones.GestionAutorizacionesPage;
import com.amaris.project.pages.comun.ValidacionExcepcionesReglasDetallesRiesgoPage;
import com.amaris.project.pages.comun.gestiononline.GestionOnlineHomePage;
import com.amaris.project.pages.comun.innova.InnovaHomePage;
import com.amaris.project.pages.productos.DetallesRiesgoPage;
import com.amaris.project.pages.productos.GestionCotizacionesBuscadorPage;
import com.amaris.project.pages.productos.GestionPolizasBuscadorPage;
import com.amaris.project.pages.productos.GestionPolizasConsultarPage;
import com.amaris.project.pages.productos.MensajeConfirmacionPage;
import com.amaris.project.pages.productos.mac.ContratacionPageMac;
import com.amaris.project.pages.productos.mac.InquilinosAvalistasPageMac;
import com.amaris.project.pages.productos.mac.PrecioPorModalidadPageMac;

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

	public void el_resultado_es_que_el_projecto_se_crea_correctamente() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			// For the time being we check that the policy appears correctly in Innov@, 
			// but this should be changed to check the policy in GO.
			new ActionSteps(userS)
				.login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			// Here we check if the policy created in GO appears correctly in Innov@ Login
			new ActionSteps(userS)
				.login(getScenarioVar(Constants.CAMBIO_ACCESO), getScenarioVar(Constants.USUARIO));
		}

		new InnovaHomePage(userS).openGestionPolizas();

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA))
			.consultarPoliza();

		new GestionPolizasConsultarPage(userS).checkPolizaNumber();
	}

	public void el_valor_de_los_capitales_varia() {
		// TODO Dejar un solo metodo con el nombre comprobar_capitales_modificados
		el_valor_de_los_capitales_varia_una_vez_se_añade_la_cobertura_opcional();
	}

	public void el_resultado_es_que_el_proyecto_se_crea_correctamente() {
		Assert.assertTrue(new ContratacionPageMac(userS).checkPolizaCreada());
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

		switch(aviso) {
			case Constants.AvisoPeritajeAntiguead:
				check = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoPeritajeConstructionYearGreaterThan50();
				break;
			case Constants.AvisoPeritajePlantasSotano:
				check = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoPeritajePlantasSotano();
				break;
			case Constants.AvisoPeritajeCapitalContinente:
				check = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoPeritajeCapitalContinenteGreaterThan15000000();
				break;
			case Constants.AvisoPlantasSotanoGreaterThan10:
				check = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoPlantasSotanoMoreThan10();
				break;
			case Constants.AvisoRiesgoAgravado:
				check = new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoRiesgoAgravado();
				break;
			case Constants.AvisoComunidadesEnTramite:
				new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoComuniadesEnTramite();
				break;
			case Constants.AvisoPlantasAltoGreaterThan20:
				new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoPlantasAlto();
				break;
			case Constants.AvisoModificacionAnyoContruccionGherkin:
				new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoConstructionYearWithException();
				break;
			case Constants.AvisoModificacionRehabilitacionIntegral:
				new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
					.checkAvisoRehabilitacionIntegralWithException();
				break;
			case Constants.AvisoGarajes:
				new DetallesRiesgoPage(userS)
					.checkAvisoGarajesWithException();
				break;
			default:
				throw new Exception(Constants.AvisoNoContemplado);
		}

		if(check) {
			new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
				.checkAviso(aviso);
		}
	}

	public void la_cotizacion_se_actualiza_correctamente() {
		new MensajeConfirmacionPage(userS)
			.checkIfPageHasLoadedCorrectly();
	}

	public void la_copia_tomador_deberia_tener_los_nuevos_datos() {
		new MensajeConfirmacionPage(userS)
			.checkIfPageHasLoadedCorrectly()
			.searchTextInCopiaTomadorPDF();
	}

	public void el_campo_cotización_contiene_el_valor() {
		String cotizacion = new GestionCotizacionesBuscadorPage(userS).getCotizacion();

		Assert.assertTrue(cotizacion.contains(getScenarioVar(Constants.NUM_COTIZACION)));
	}

	public void la_poliza_muestra_en_la_pestanya(String toBeChecked, String tab) throws Exception {
		new InnovaHomePage(userS)
			.openGestionPolizas();

		new GestionPolizasBuscadorPage(userS)
			.buscarPorNumeroPoliza(getScenarioVar(Constants.NUM_POLIZA))
			.consultarPoliza();

		switch(toBeChecked) {
			case Constants.PolizaDetailConstructionYear:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailConstructionYear, getScenarioVar(Constants.ANYO_CONSTRUIDO));
				break;
			case Constants.PolizaDetailCapitalContinente:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCapitalContinente, getScenarioVar(Constants.CAPITAL_CONTINENTE));
				break;
			case Constants.PolizaDetailCapitalContenido:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCapitalContenido, getScenarioVar(Constants.CAPITAL_CONTENIDO));
				break;
			case Constants.PolizaDetailNuevaClausulaHipotecaria:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabClausulas, Constants.PolizaDetailNuevaClausulaHipotecaria, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailLocalesExcluidos:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailLocalesExcluidos, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailDepositoCombustible:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailDepositoCombustible, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailCalefaccionCentral:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCalefaccionCentral, Constants.DescuentoRecargoNotSpecified);
				break;
			case Constants.PolizaDetailPlacaSolar:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailPlacaSolar, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_VALOR) + " €");
				break;
			case Constants.PolizaDetailMaquinaria:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailMaquinaria, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR) + " €");
				break;
			case Constants.PolizaDetailNoRecargo:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoRecargo, null);
				break;
			case Constants.PolizaDetailRecargo:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoRecargo, Constants.PolizaDetailDescuentoValue);
				break;
			case Constants.PolizaDetailNoDescuento:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailNoDescuento, null);
				break;
			case Constants.PolizaDetailDescuento:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailDescuentoValue, Constants.PorcentajeDescuentoRecargo)
					.checkValueInTab(Constants.PolizaDetailTabImportes, Constants.PolizaDetailDescuento, Constants.TipoDescuento);
				break;
			case Constants.PolizaDetailClausula:
				new GestionPolizasConsultarPage(userS)
					.checkClausulas();
				break;
			case Constants.PolizaDetailM2ConstruidosTotales:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailM2ConstruidosTotales, getTestVar(Constants.M2_CONSTRUIDOS));
				break;
			case Constants.PolizaDetailYearAndRehabilitationLevel:
				new GestionPolizasConsultarPage(userS)
					.checkAnyoAndNivelRehabilitacion();
				break;
			case Constants.PolizaDetailYearRehabilitacionIntegral:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailYearRehabilitacionIntegral, getTestVar(Constants.M2_CONSTRUIDOS));
				break;
			case Constants.PolizaDetailCalidadConstruccion:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailCalidadConstruccion, getTestVar(Constants.CALIDAD_CONSTRUCCION));
				break;
			case Constants.PolizaDetailFranquiciaVoluntaria:
				new GestionPolizasConsultarPage(userS)
					.checkValueInTab(Constants.PolizaDetailTabDetallesRiesgo, Constants.PolizaDetailFranquiciaVoluntaria, getTestVar(Constants.FRANQUICIA_VOLUNTARIA));
				break;
			default:
				throw new Exception(String.format("El checqueo para %s no se ha implementado", toBeChecked));
		}
	}

	public void esta_habilitado_el_campo(String fieldValue) {
		DetallesRiesgoPage detallesRiesgoPage = new DetallesRiesgoPage(userS);

		Assert.assertTrue(detallesRiesgoPage.isFieldEnabled(fieldValue), String.format("El campo %s no está habilitado", fieldValue));
	}

	public void el_proyecto_MAC_se_deniega() {
		Assert.assertTrue(new InquilinosAvalistasPageMac(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Se ha denegado la emisión del proyecto")));
	}

	public void el_proyecto_MAC_se_acepta() {
		Assert.assertTrue(new InquilinosAvalistasPageMac(userS).recuperarTextoMensajeValidacionOK()
			.contains("El proyecto deberá ser revisado por compañía, debe adjuntar los documentos obligatorios del estudio de viabilidad, por favor cuando termine todas las gestiones no olvide pulsar el botón Enviar a Compañía. Puede continuar al siguiente paso, para seguir rellenando el resto de campos de la cotización, pero no podrá emitirla."));
	}

	public void el_proyecto_esta_en_estado_denegado() {
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			// Assert.assertEquals(String.format("Denegado"), new GestionOnlineHomePage(userS).recuperarEstadoPoliza());
			Assert.assertTrue(String.format("Denegado").contentEquals(new GestionOnlineHomePage(userS).recuperarEstadoPoliza()) || String.format("Denegat").contentEquals(new GestionOnlineHomePage(userS).recuperarEstadoPoliza()));
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			Assert.assertEquals(String.format("Desestimada"), new GestionCotizacionesBuscadorPage(userS).getEstadoCotizacion());
		}
	}

	public void se_puede_autorizar_usando_el_acceso_Innova_y_usuario(String loginAcess, String user) throws Exception {
		new InquilinosAvalistasPageMac(userS)
			.enviarACompania();

		userS.getWebDriver().quit();

		debugInfo("Valor accesoAuth: " + getScenarioVar(Constants.ACCESO_AUTORIZADO));
		new ActionSteps(userS)
			.login(getScenarioVar(Constants.ACCESO_AUTORIZADO), getScenarioVar(Constants.USUARIO_AUTORIZADO));

		// Abrir la busqueda de autorizaciones
		new InnovaHomePage(userS)
			.openGestionAutorizaciones();

		String resultadoAutorizacion = new GestionAutorizacionesPage(userS)
			.buscarAutorizaciones("Proceso de cotización", "Pendiente de autorizar", getTestVar(Constants.NUM_COTIZACION))
			.autorizar()
			.recuperarResultadoAutorizacion();

		Assert.assertTrue(resultadoAutorizacion.contains("ha sido autorizada correctamente."));
	}

//REVISAR SI ESTE CÓDIGO REALMENTE ES RELEVANTE
	public void datos_prospect_grabados_coinciden() {
		String nombreComercial = getTestVar(Constants.NOMBRE_COMERCIAL_PROSPECT).toUpperCase();

		Assert.assertTrue(new FichaMediadorPage(userS).getContenidoTituloPagina()

			.contains(nombreComercial));
	}

	public void datos_mediador_grabados_coinciden() {
		if(getScenarioVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Igual que el fiscal")) {
			String nombreComercial = (getScenarioVar(Constants.NOMBRE_MEDIADOR) + " "
				+ getScenarioVar(Constants.PRIMER_APELLIDO_MEDIADOR) + " "
				+ getScenarioVar(Constants.SEGUNDO_APELLIDO_MEDIADOR))
					.toUpperCase();

			debugInfo("Nombre comercial: " + nombreComercial);

			Assert.assertTrue(new FichaMediadorPage(userS).getContenidoTituloPagina()

				.contains(nombreComercial));
		} else if(getScenarioVar(Constants.TIPO_NOMBRE_MEDIADOR).equals("Diferente que el fiscal")) {
			String nombreComercial = getScenarioVar(Constants.NOMBRE_MEDIADOR).toUpperCase();
			
			Assert.assertTrue(new FichaMediadorPage(userS).getContenidoTituloPagina()

				.contains(nombreComercial));
		}
	}

	public void deberia_aparecer_error_rebasada_la_renta_máxima_permitida() {
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(new PrecioPorModalidadPageMac(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Rebasada la renta máxima permitida de 3.000,00 €")));
	}

	public void deberia_aparecer_error_situacion_reasegurado() {
		// Comprobar que sale el error correspondiente
		Assert.assertTrue(new PrecioPorModalidadPageMac(userS).recuperarTextoMensajeError()
			.contains(String.format("¡Error! Situación de reaseguro no es posible la contratación")));
	}

	public void no_deberia_estar_habilitado_convertir_a_proyecto() {
		// Comprobar que se queda deshabilitado Convertir a proyecto
		Assert.assertFalse(new PrecioPorModalidadPageMac(userS).checkConvertirAProyectoIsPresent());
	}
}