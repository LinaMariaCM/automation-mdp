package com.amaris.project.steps;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.AsignarMediadorPage;
import com.amaris.project.pages.ClausulasPage;
import com.amaris.project.pages.DatosBancariosPage;
import com.amaris.project.pages.DatosBasicosTomadorPage;
import com.amaris.project.pages.DetallesRiesgoPage;
import com.amaris.project.pages.GestionOnlineHomePage;
import com.amaris.project.pages.PrecioPage;
import com.amaris.project.pages.PrecioPorModalidadPage;
import com.amaris.project.pages.PrecioPorModalidadPage_MAC;
import com.amaris.project.pages.TomadorYAseguradoPage;
import com.amaris.project.pages.UbicacionRiesgoPage;
import com.amaris.project.pages.ValidacionExcepcionesReglasDetallesRiesgoPage;
import com.amaris.project.pages.ValidacionExcepcionesReglasPage;
import com.amaris.project.pages.ValidacionesExcepcionesReglasUbicacionRiesgoPage;
import com.amaris.project.utils.ClausulasHelper;
import com.amaris.project.utils.MotivosSuplementoHelper;

public class DataEntrySteps extends InteractionObject {

	public DataEntrySteps(UserStory userStory) {
		super(userStory);
	}

	public void marcado_el_check_Asegurar_unicamente_los_garajes() {
		setTestVar(Constants.ASEGURAR_UNICAMENTE_GARAJES, "true");
	}

	public void la_cobertura_opcional_de_rotura_de_maquinaria_para_la_opcion_por_un_valor_de_euros() {
		// Si coberturaMaquinariaTipo y coberturaMaquinariaValor no son == null,
		// entonces coberturaMaquinaIncluida
		setTestVar(Constants.COBERTURA_MAQUINA_INCLUIDA, Constants.CoberturaOpcionalncluida);
	}

	public void anado_la_cobertura_de_accidentes_personales_de_empleados_para_un_empleado() {
		setTestVar(Constants.COBERTURA_ACCIDENTES_EMPLEADOS_INCLUIDA, Constants.CoberturaOpcionalncluida);
	}

	public void anado_la_cobertura_de_rotura_de_instalaciones_de_energia_solar_para_por_un_valor_de() {
		// Si descripcion y valor no son == null,
		// entonces coberturaEnergiaSolarIncluida
		setTestVar(Constants.COBERTURA_ENERGIA_SOLAR_INCLUIDA, Constants.CoberturaOpcionalncluida);
	}

	public void añado_la_clausula_hipotecaria() {
		ClausulasHelper.addClausula(getScenarioVar(Constants.CLAUSULA), userS);
	}

	public void le_añado_una_clausula_hipotecaria() {
		setTestVar(Constants.CLAUSULA_HIPOTECARIA, "true");
	}

	public void el_asegurado_es_diferente_del_tomador() {
		setTestVar(Constants.ASEGURADO_DIFERENTE_TOMADOR, Constants.AseguradoPrincipalDiferenteTomador);
	}

	public void el_documento_tomador_es_aleatoreo() {
		setTestVar(Constants.DNI_TOMADOR, DniGeneratorHelper.generateNif());
	}

	public void añado_los_teléfonos_del_tomador_y_los_horarios_de_atención() {
		setTestVar(Constants.INCLUIR_TELEFONOS_TOMADOR, Constants.TelefonosTomadorIncluidos);
	}

	public void subo_un_fichero() {
		setTestVar(Constants.SUBIR_FICHERO, "true");
	}

	public void con_el_número_de_poliza() {
		setTestVar(Constants.NUM_POLIZA, new DatosBancariosPage(userS).GetPolizaNumber());
	}

	public void se_modifica_el_año_de_rehabiliación_integral_a(Integer anyoRehabilitacionIntegral) {
		setTestVar(Constants.ANYO_REHAB_INTEGRAL, Integer.toString(anyoRehabilitacionIntegral));
	}

	public void selecciono_Hay_una_gasolinera_a_menos_de_50m() {
		setTestVar(Constants.GASOLINERA_MENOS_50M, "true");
	}

	public void le_agrego_como_motivo_del_suplemento(String motivoSuplemento) {
		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, true, userS);
	}

	public void le_quito_como_motivo_del_suplemento(String motivoSuplemento) {
		MotivosSuplementoHelper.addMotivoSuplemento(motivoSuplemento, false, userS);
	}

	public void se_modifica_el_año_de_construcción(String anyoConstruccion) {
		setTestVar(Constants.ANYO_CONSTRUIDO, anyoConstruccion);
	}

	public void se_excluyen_los_garajes() {
		setTestVar(Constants.EXCLUIR_GARAJES, "true");
	}

	public void se_excluyen_los_locales() {
		setTestVar(Constants.EXCLUIR_LOCALES, "true");
	}

	public void se_modifica_la_calidad_de_construcción_por(String calidadConstruccion) {
		setTestVar(Constants.CALIDAD_CONSTRUCCION, calidadConstruccion);
	}

	public void el_capital_continente_se_reduce_en(String capitalContinente) {
		setTestVar(Constants.CAPITAL_CONTINENTE_VARIACION, "true");
		setTestVar(Constants.CAPITAL_CONTINENTE, capitalContinente);
	}

	public void el_capital_continente_se_incrementa_en(String capitalContinente) {
		setTestVar(Constants.CAPITAL_CONTINENTE_VARIACION, "true");
		setTestVar(Constants.CAPITAL_CONTINENTE, capitalContinente);
	}

	public void se_modifica_el_capital_de_franquicia_voluntaria_a(String franquiciaVoluntaria) {
		setTestVar(Constants.FRANQUICIA_VOLUNTARIA, franquiciaVoluntaria);
	}

	public void le_incluyo_un_recargo() {
		setTestVar(Constants.RECARGO, "true");
	}

	public void se_excluye_un_recargo() {
		setTestVar(Constants.RECARGO, "false");
	}

	public void se_agrega_un_descuento() {
		setTestVar(Constants.DESCUENTO_HABILITADO, "true");
	}

	public void se_quita_un_descuento() {
		setTestVar(Constants.DESCUENTO_HABILITADO, "false");
	}

	public void le_agrego_la_clausula(String clausula) {
		ClausulasHelper.addClausula(clausula, userS);
	}

	public void se_incluye_el_check_de_Calefacción_central_y_o_agua_caliente_centralizada() {
		setTestVar(Constants.CALEFACCION_CENTRAL, "true");
	}

	public void se_incluye_un_deposito_de_combustible() {
		setTestVar(Constants.DEPOSITO_COMBUSTIBLE, "true");
	}

	public void se_incrementa_el_capital_contenido_en(Integer capitalContenido) {
		setTestVar(Constants.CAPITAL_CONTENIDO, Integer.toString(capitalContenido));
	}

	public void se_reduce_el_capital_contenido_en(Integer capitalContenido) {
		setTestVar(Constants.CAPITAL_CONTENIDO, Integer.toString(-capitalContenido));
	}

	public void el_documento_aleatoreo() {
		setTestVar(Constants.DOCUMENTO_INQUILINO, DniGeneratorHelper.generateNif());
	}

	public void el_usuario_da_de_alta_un_proyecto_en_GO_y_lo_guarda_sin_contratar(String loginAcess, String user) throws Exception {
		debugBegin();

		new Steps(userS).login(loginAcess, user);

		String mediador = getScenarioVar(Constants.MEDIADOR);
		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine) && !mediador.equals("640")) {
			new AsignarMediadorPage(userS)
				.selectMediadorAndClickOnContinuar();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.seleccionarMediadorPorCodigo(getScenarioVar(Constants.ACCESO))
				.clickOnContinuarButton();
		}

		new UbicacionRiesgoPage(userS)
			.fillInmuebleAndClickOnContinue();

		new ValidacionesExcepcionesReglasUbicacionRiesgoPage(userS)
			.isUbicacionRiesgoUtilizada();

		new DetallesRiesgoPage(userS)
			.completarDatosEnDetallesRiesgo();

		new ValidacionExcepcionesReglasDetallesRiesgoPage(userS)
			.clickOnContinuar();

		new PrecioPage(userS)
			.clickOnConvertirAProjecto();

		new DatosBasicosTomadorPage(userS)
			.fillTomadorData(getScenarioVar(Constants.TOMADOR))
			.clickOnContinuar();

		new PrecioPorModalidadPage(userS)
			.executeActionsInPrecioPorModalidadPage();

		new ValidacionExcepcionesReglasPage(userS)
			.clickOnContinuarButton();

		new ClausulasPage(userS)
			.activateclausesAndClickOnContinue();

		new TomadorYAseguradoPage(userS)
			.addDatosTomador()
			.addDatosTomadorDiferenteAsegurado()
			.clickOnContinuar();

		new DatosBancariosPage(userS)
			.introducirFormaPagoYPulsarGuardar();

		debugInfo("El projecto con el codigo " + getScenarioVar(Constants.NUM_COTIZACION) + " se ha creado");
		debugInfo("El nombre del tomador es: " + getScenarioVar(Constants.NOMBRE_TOMADOR));
		debugInfo("El primer apellido del tomador es: " + getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
		debugInfo("El segundo apellido del tomador es: " + getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));
		debugInfo("El dni del tomador es: " + getScenarioVar(Constants.DNI_TOMADOR));

		if(getScenarioVar(Constants.NUM_POLIZA) != null) {
			debugInfo("El numero de poliza es: %s" + getScenarioVar(Constants.NUM_POLIZA));
		}

		debugEnd();
	}

	public void se_inicia_un_proyecto_con_modalidad() throws Exception {
		new Steps(userS).login(getScenarioVar(Constants.ACCESO), getScenarioVar(Constants.USUARIO));

		if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessGestionLine)) {
			new GestionOnlineHomePage(userS)
				.openContratarMutuaAlquilerConfort();
		} else if(getScenarioVar(Constants.ACCESO).equals(Constants.LoginAccessInnova)) {
			new AsignarMediadorPage(userS)
				.SelectMediadorMACAndClickOnContinuar();
		}

		// Seleccionar modalidad en Precio page
		new PrecioPorModalidadPage_MAC(userS)
			.selectModalidad();
	}

}
