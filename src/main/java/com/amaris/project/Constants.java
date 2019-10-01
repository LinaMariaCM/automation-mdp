package com.amaris.project;

public class Constants {

	private Constants() {}
	
	// Web page
	public static final String CLIENT = "Mutua de Propietarios";
	public static final String USER_TYPE = "user_type";

	public static final String ENTORNO = "environment";
	public static final String ACCESO = "acceso";
	public static final String ACCESO_AUTORIZADO = "accesoAuth";
	public static final String CAMBIO_ACCESO = "cambio_acceso";
	public static final String USUARIO = "usuario";
	public static final String CAMBIO_USUARIO = "cambio_usuario";
	public static final String USUARIO_AUTORIZADO = "usuarioAuth";

	public static final String MAC = "Mac";
	public static final String MEC = "Mec";
	public static final String MEC_CON_PER = "MecConPer";
	public static final String MEC_MOT_SUP_GEN = "MecMotSupGen";
	public static final String MEC_PAR_RET_SIM = "MecParRetSim";
	public static final String MEC_PAR_RET_PRO = "MecParRetPro";
	public static final String MEC_SINIESTROS = "MecSin";
	public static final String ALTA_SINIESTROS = "AltaSin";

	public static final String GARAJES_CASE = "TST";
	public static final String MEDIADORES_CASE = "Med";
	public static final String FICHA_CLIENT = "fichaClient";
	public static final String SINIESTRO_CONVENCIONAL_CON_PERITO = "SinConvPer";

	// Mutua de Propietarios Constants

	public static final String DeshabitacionInferior = "Inferior al 75%";

	public static final String NuevoTomadorYAseguradoPrincipal = "nuevo_tomador_y_asegurado_principal";
	public static final String ClienteExistente = "cliente existente";
	public static final String LoginAccessInnova = "Innova";
	public static final String LoginAccessGestionLine = "GOL";
	public static final String MutuaEdificioConfort = "MUTUA EDIFICIO CONFORT";
	public static final String MutuaAlquierConfort = "MUTUA ALQUILER CONFORT";
	public static final String ModifiedDataInitialValue = "NOT_MODIFIED";
	public static final String Mediador = "Mediador";
	public static final String DomiciliacionBancaria = "Domiciliacin Bancaria";
	public static final String NIF = "NIF";
	public static final String CoberturaRoturaMaquinariaDescripcion = "Rotura de maquinaria";
	public static final String CoberturaMaquinariaAscensorDescripcion = "Maquinaria ascensor";
	public static final String CoberturaAccidentesPersonalesEmpleados = "Accidentes personales de empleados";
	public static final String ProfesionOtro = "Otro: Informar como texto libre.";
	public static final String ProfesionOtroDescripcion = "Informático";
	public static final String ProfesionVigilanteSeguridad = "Vigilante de Seguridad";
	public static final String BeneficiarioConjugeEHijosPartesIguales = "Cónyuge e hijos del asegurado por partes iguales";
	public static final String BeneficiariosOpcionTextoLibre = "Opción de Texto libre para indicar beneficiarios:";
	public static final String CoberturaOpcionalncluida = "si";
	public static final String TelefonosTomadorIncluidos = "si";
	public static final String CoberturaEnergiaSolarDescripcion = "Rotura de instalaciones de energía solar fotovoltaica";
	public static final String ConfigurationPropertiesFileName = "/configuration.properties";
	public static final String ResourcesFolder = "resources";
	public static final String Manana = "Mañana";
	public static final String Tarde = "Tarde";
	public static final String Noche = "Noche";
	public static final String DeLunesAViernes = "De Lunes A viernes";
	public static final String FinDeSemana = "Fin de semana";
	public static final String ReferenciaCatastralPorDefecto = "Referencia Catastral por defecto";
	public static final String DireccionPorDefecto = "direccion por defecto";
	public static final String DireccionNoNormalizada = "direccion no normalizada";
	public static final String ActividadComercialDescripcion = "Testing";
	public static final String ActividadComercialOPorcentaje = "100";
	public static final String AseguradoPrincipalDiferenteTomador = "si";
	public static final String ModificarClausulas = "si";
	public static final String GestionOnlineDisponible = "si";
	public static final String ModalidadCompleta = "completa";
	public static final String ModalidadBasic = "basic";
	public static final String ModalidadPlus = "plus";
	public static final String V7Environment = "V7";
	public static final String PreEnvironment = "Pre";
	public static final String UatEnvironment = "UAT";
	public static final String QAEnvironment = "QA";
	public static final String ATMIRAEnvironment = "ATMIRA";
	public static final String UpgradeEnvironment = "Upgrade";
	public static final String SiniestrosEnvironment = "Siniestros";
	public static final String MigracionEnvironment = "Migracion";
	public static final String UatPjEnvironment = "UatPj";
	public static final String HogarMigEnvironment = "HogarMig";
	public static final String RecibosCheckEnvironment = "RecibosCheck";
	public static final String CapitalContinenteNoHaVariado = "El capital continente no ha variado en la pantalla de detalles de riesgo";
	public static final String CapitalContenidoNoHaVariado = "El capital contenido no ha variado en la pantalla de detalles de riesgo";
	public static final String CapitalTotalNoHaVariado = "El capital total asegurado no ha variado en la pantalla de detalles de riesgo";
	public static final String ClausulaEncontradaYSeleccionada = "Found and selected";
	public static final String ClausulaNoEncontrada = "Not Found";
	public static final String ClausulaEncontradaYNoSeleccionada = "Found and not selected";
	public static final String AfterMaquinaria = "despues de añadir la cobertura de maquinaria";
	public static final String AfterEmpleados = "despues de añadir la cobertura de empleados";
	public static final String AfterEnergiaSolar = "despues de añadir la cobertura de energia solar";
	public static final String AfterModalidadChangeToPlus = "despues de cambiar la modalidad a plus";
	public static final String AfterModalidadChangeToBasic = "despues de cambiar la modalidad a basic";
	public static final String AfterAddingFranquiciaVoluntaria = "despues de añadir una franquicia voluntaria";
	public static final String AfterAddingDiscount = "después de añadir un descuento";
	public static final String AfterAddingAdditionalCharge = "después de añadir un recargo";
	public static final String Equal = "equal";
	public static final String NotEqual = "not equal";
	public static final String MayorDe50 = "mayor que 50 años";
	public static final String PorcentajeDescuentoRecargo = "10,00";
	public static final String TipoDescuento = "Comercial constante";
	public static final String TipoRecargo = "RECA";
	public static final String AvisoPeritajeAntiguead = "Peritaje: Debido a la antigüedad del edificio supera los 50 años, el riesgo debe ser peritado.";
	public static final String AvisoPeritajePlantasSotano = "Peritaje: Debido al número de plantas de sótano, el riesgo debe ser peritado. Una vez se finalice la peritación recibirá un mensaje informando de las acciones derivadas de ésta.";
	public static final String AvisoPeritajeCapitalContinente = "Peritaje: Debido al capital de continente solicitado, el riesgo debe ser peritado. Una vez se finalice la peritación recibirá un mensaje informando de las acciones derivadas de ésta.";
	public static final String AvisoPlantasSotanoGreaterThan10 = "Plantas de sótano > 10. Riesgo fuera de las normas de suscripción";
	public static final String AvisoPlantasAltoGreaterThan20 = "Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.";
	public static final String AvisoNoContemplado = "El aviso especificado en el gherkin no está contemplado";
	public static final String AvisoRiesgoAgravado = "Seleccionado un riesgo agravado. Riesgo fuera de las normas de suscripción ";
	public static final String AvisoModificacionAnyoConstruccion = "Debido a que se ha modificado el año de construcción y no coincide con catastro, el proyecto debe ser revisado por compañía . Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante";
	public static final String AvisoModificacionAnyoConstruccionNotPressent = "El mensaje de error que debía aparecer cuando se introduce un año de construcción más antiguo que 50 años no ha aparecido.";
	public static final String AvisoModificacionAnyoContruccionGherkin = "año construccion modificado";
	public static final String AvisoModificacionRehabilitacionIntegral = "Debido a que se ha modificado el año de rehabilitación integral y el año de rehabilitación de conducciones comunitarias, el proyecto debe ser revisado por la compañía. Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante.";
	public static final String AvisoModificacionRehabilitacionIntegralConduccionesComunitariasGherkin = "año rehabilitación y construcciones comunitarias";
	public static final String AvisoModificacionRehabilitacionIntegralNotPressent = "El aviso que debía aparecer cuando se modifica el año de rehabilitación integral no ha aparecido";
	public static final String AvisoModificacionAnyoRehabilitacion = "Modificación año rehabilitación conducciones comunitarias";

	public static final String TomadorCifEnTramite = "Cif_en_tramite";
	public static final String CIF = "CIF";
	public static final String AvisoComunidadesEnTramite = "No se permite introducir comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año.";
	public static final String NoModificarClausulas = "No";
	public static final String MotivoSuplementoInclusionExclusionDescuento = "Inclusión/exclusión descuento";
	public static final String MotivoSuplementoinclusionMaquinaria = "Inclusión maquinaria";
	public static final String MotivoSuplementoInclusionEnergiaSolar = "Inclusión placa solar";
	public static final String MotivoSuplementoModificacionNEdificios = "Modificación N° edificios";
	public static final String MotivoSuplementoModificacionNViviendas = "Modificación N° de viviendas";
	public static final String MotivoSuplementoModificacionNLocales = "Modificación N° de locales";
	public static final String CantidadDescuentoNoEspecificado = "No especificado";
	public static final String NivelRehabilitacionAguasRehabilitadoTotalidad = "Rehabilitado en su totalidad";
	public static final String CalidadConstruccionSencilla = "Sencilla";
	public static final String DescuentoRecargoNotSpecified = "No especificado";

	public static final String ClausulaHipotecariaNIF = "76233285S";
	public static final String ClausulaHipotecariaNombre = "Pedro";
	public static final String ClausulaHipotecariaApellido1 = "Duorden";
	public static final String ClausulaHipotecariaApellido2 = "Garcia";
	public static final String ClausulaHipotecariaEntidadBancaria = "ACTIVOBANK";
	public static final String ClausulaHipotecariaCoheficienteParticipacion = "10";
	public static final String PolizaDetailConstructionYear = "muestra el nuevo año de construccion";
	public static final String PolizaDetailConstructionYearErrorMessage = "El año de construcción no ha aparecido correctamente";
	public static final String PolizaDetailCapitalContinente = "muestra el nuevo monto del continente";
	public static final String PolizaDetailCapitalContinenteErrorMessage = "El capital continente no ha aparecido correctamente";
	public static final String PolizaDetailCapitalContenido = "muestra el nuevo monto del contenido";
	public static final String PolizaDetailCapitalContenidoErororMessage = "El capital contenido no ha aparecido correctamente";
	public static final String PolizaDetailNuevaClausulaHipotecaria = "muestra la nueva clausula hipotecaria";
	public static final String PolizaDetailNuevaClausulaHipotecariaErrorMessage = "La clausula hipotecaria no ha aparecido correctamente";
	public static final String PolizaDetailLocalesExcluidos = "muestra Locales excluidos";
	public static final String PolizaDetailLocalesExcluidosErrorMessage = "el texto Locales excluidos no ha aparecido";
	public static final String PolizaDetailDepositoCombustible = "muestra Depósito de combustible superior a 3000 l";
	public static final String PolizaDetailDepositoCombustibleErrorMessage = "el texto Depósito de combustible superior a 3000 l no ha aparecido";
	public static final String PolizaDetailCalefaccionCentral = "muestra Calefacción central y/o agua caliente";
	public static final String PolizaDetailCalefaccionCentralErrorMessage = "el texto Calefacción central y/o agua caliente no ha aparecido";
	public static final String PolizaDetailPlacaSolar = "muestra la garantia de placa solar y el valor";
	public static final String PolizaDetailPlacaSolarErrorMessage = "no ha aparecido la garantia de placa solar y el valor";
	public static final String PolizaDetailMaquinaria = "muestra la garantia de maquinaria y el valor";
	public static final String PolizaDetailMaquinariaErrorMessage = "no ha aparecido la garantia de maquinaria y el valor";
	public static final String PolizaDetailNoRecargo = "no muestra el recargo";
	public static final String PolizaDetailNoRecargoErrorMessage = "el recargo ha aparecido";
	public static final String PolizaDetailRecargo = "muestra el recargo";
	public static final String PolizaDetailRecargoErrorMessage = "el recargo no ha aparecido";
	public static final String PolizaDetailNoDescuento = "no muestra el descuento";
	public static final String PolizaDetailDescuento = "muestra el descuento";
	public static final String PolizaDetailDescuentoErrorMessage = "no ha aparecido el descuento";
	public static final String PolizaDetailDescuentoValue = "muestra el valor del descuento";
	public static final String PolizaDetailDescuentoValueErrorMessage = "no ha aparecido el descuento";
	public static final String PolizaDetailClausula = "muestra la clausula incluida";
	public static final String PolizaDetailM2ConstruidosTotales = "muestra el nuevo valor de M2 construidos totales";
	public static final String PolizaDetailM2ConstruidosTotalesErrorMessage = "el nuevo valor de M2 construidos totales no ha aparecido";
	public static final String PolizaDetailYearAndRehabilitationLevel = "muestra el año y el nivel de rehabilitación";
	public static final String PolizaDetailYearAndRehabilitationLevelErrorMessage = "no ha aparecido el año y el nivel de rehabilitación";
	public static final String PolizaDetailYearRehabilitacionIntegral = "muestra el año de rehabilitación general";
	public static final String PolizaDetailYearRehabilitacionIntegralErrorMessage = "no ha aparecido el año de rehabilitación general";
	public static final String PolizaDetailCalidadConstruccion = "muestra la nueva calidad de construccion";
	public static final String PolizaDetailCalidadConstruccionMessage = "no se ha mostrado la nueva calidad de construccion";
	public static final String PolizaDetailFranquiciaVoluntaria = "muestra el importe de la franquicia voluntaria";
	public static final String PolizaDetailFranquiciaVoluntariaErrorMessage = "no muestra el importe de la franquicia voluntaria";
	public static final String AvisoGarajesErrorMessage = "El mensaje Los datos de superficies (m2) son orientativos, por favor reviselos no ha aparecido";
	public static final String AvisoGarajes = "Los datos de superficies (m2) son orientativos, por favor reviselos";

	public static final String PolizaDetailTabDetallesRiesgo = "Detalles Riesgo";
	public static final String PolizaDetailTabClausulas = "Clausulas";
	public static final String PolizaDetailTabImportes = "Importes";
	public static final String PolizaDetailTabCoberturas = "Coberturas";

	public static final String NotPressent = "Not Pressent";
	public static final String UbicacionRiesgoYaUtilizadaError = "ERROR: La referencia catastral ya está utilizada. Cambiala";
	public static final String UbicacionRiesgoYaUtilizadaMsg = "AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.";
	public static final String UbicacionRiesgoConProjectosActivosMsg = "AVISO: Existen otros proyectos de suplemento activo para la misma póliza.";
	public static final String REPORTING_LVL_VERBOSE = "verbose";
	public static final String REPORTING_LVL_NORMAL = "normal";
	public static final String SITUACION_LABORAL_ASALARIADO_INDEFINIDO_MAYOR_2 = "Indefinido con antigüedad en la empresa superior a 2 meses";
	public static final String SITUACION_LABORAL = "situacion_laboral";
	public static final String SITUACION_LABORAL_ASALARIADO = "Asalariado";
	public static final String SITUACION_LABORAL_AUTONOMO_INDEFINIDO_MENOR_1 = "Indefinido con antigüedad en la empresa superior a 2 meses";
	public static final String SITUACION_LABORAL_AUTONOMO = "Autónomo";
	public static final String SIMULACION_EDIFICIO_CONFORT = "Edificio";
	public static final String SIMULACION_ALQUILER_CONFORT = "Alquiler";
	public static final String ALTA_TOMADOR = "Tomador";
	public static final String ALTA_ASEGURADO = "Asegurado";
	public static final String FILTRO_BUSCADOR_DIRECCION = "direccion";
	public static final String FILTRO_BUSCADOR_CATASTRAL = "catastral";
	public static final String FILTRO_BUSCADOR_PROYECTO = "proyecto";
	public static final String FILTRO_BUSCADOR_POLIZA = "poliza";
	public static final String FILTRO_BUSCADOR_MEDIADOR = "mediador";
	public static final String FILTRO_BUSCADOR_ESTADO = "estado";
	public static final String FILTRO_BUSCADOR_NIF = "nif";
	public static final String FILTRO_BUSCADOR_NOMBRE = "nombre";
	public static final String FILTRO_BUSCADOR_CONTACTO = "contacto";
	public static final String FILTRO_BUSCADOR_COLECTIVO = "colectivo";
	public static final String FILTRO_BUSCADOR_RECIBO = "recibo";
	public static final String FILTRO_BUSCADOR_COTIZACION = "cotizacion";
	public static final String FILTRO_BUSCADOR_CLIENTE = "filtro_buscador_cliente";
	public static final String FILTRO_BUSCADOR_EDIFICIO = "filtro_buscador_edificio";

	public static final String GESTION_ONLINE_DISPONIBLE = "gestion_online_disponible";
	
	public static final String CLAUSULA = "clausula";
	public static final String MODIFICAR_CLAUSULAS = "modificar_clausulas";
	public static final String CLAUSULA_HIPOTECARIA = "clausula_hipotecaria";

	public static final String MODALIDAD = "modalidad";
	public static final String MEDIO_PAGO = "medio_pago";
	public static final String CAMBIO_MEDIO_PAGO = "cambio_medio_pago";
	public static final String IBAN = "iban";
	public static final String NUM_CUENTA = "numero_cuenta";
	public static final String REFERENCIA_CATASTRAL = "ref_catastral";

	public static final String PROYECTO = "proyecto";

	public static final String CONTACTO_CLIENTE = "contacto_cliente";
	public static final String RECIBO_CLIENTE = "recibo_cliente";
	public static final String COLECTIVO_CLIENTE = "colectivo_cliente";
	public static final String NUM_COTIZACION = "num_cotizacion";
	public static final String NUM_POLIZA = "numero_poliza";

	public static final String TIPO_DOCUMENTO = "tipo_documento";

	public static final String TIPO_PROSPECT = "tipo_prospect";
	public static final String NOMBRE_PROSPECT = "nombre_prospect";

	public static final String TIPO_PERSONA = "tipo_persona";

	public static final String TIPO_MEDIADOR = "tipo_mediador";
	public static final String DOCUMENTO_MEDIADOR = "documento_mediador";
	public static final String NOMBRE_MEDIADOR = "nombre_mediador";
	public static final String PRIMER_APELLIDO_MEDIADOR = "primer_apellido_mediador";
	public static final String SEGUNDO_APELLIDO_MEDIADOR = "segundo_apellido_mediador";
	public static final String TIPO_NOMBRE_MEDIADOR = "tipo_nombre_mediador";

	public static final String TOMADOR = "tomador";
	public static final String DNI_TOMADOR = "dni_tomador";
	public static final String NOMBRE_TOMADOR = "nombre_tomador";
	public static final String PRIMER_APELLIDO_TOMADOR = "primer_apellido_tomador";
	public static final String SEGUNDO_APELLIDO_TOMADOR = "segundo_apellido_tomador";
	public static final String HORARIO_ATENCION_FIJO_TOMADOR = "horario_atencion_fijo_tomador";
	public static final String TELEFONO_FIJO_TOMADOR = "telefono_fijo_tomador";
	public static final String PREFIJO_TELEFONO_FIJO_TOMADOR = "prefijo_telefono_fijo_tomador";
	public static final String HORARIO_ATENCION_MOVIL_TOMADOR = "horario_atencion_movil_tomador";
	public static final String TELEFONO_MOVIL_TOMADOR = "telefono_movil_tomador";
	public static final String PREFIJO_TELEFONO_MOVIL_TOMADOR = "prefijo_telefono_movil_tomador";
	public static final String EMAIL_TOMADOR = "email_tomador";
	public static final String FECHA_NACIMIENTO_TOMADOR = "fecha_nacimiento_tomador";

	public static final String NOMBRE_CLIENTE = "nombre_cliente";
	public static final String PRIMER_APELLIDO_CLIENTE = "primer_apellido_cliente";
	public static final String SEGUNDO_APELLIDO_CLIENTE = "segundo_apellido_cliente";

	public static final String DOCUMENTO_EMPLEADO = "documento_empleado";
	public static final String NOMBRE_EMPLEADO = "nombre_empleado";
	public static final String PRIMER_APELLIDO_EMPLEADO = "primer_apellido_empleado";
	public static final String SEGUNDO_APELLIDO_EMPLEADO = "segundo_apellido_empleado";
	public static final String PROFESION_EMPLEADO = "profesion_empleado";
	public static final String DESCRIPCION_PROFESION_EMPLEADO = "descripcion_profesion_empleado";
	public static final String CAPITAL_EMPLEADO = "capital_empleado";
	public static final String FECHA_NACIMIENTO_EMPLEADO = "fecha_nacimiento_empleado";
	public static final String BENEFICIARIO_EMPLEADO = "beneficiario_empleado";
	public static final String DESCRIPCION_BENEFICIARIO_EMPLEADO = "descripcion_beneficiario_empleado";

	public static final String DOCUMENTO_INQUILINO = "documento_inquilino";
	public static final String NOMBRE_INQUILINO = "nombre_inquilino";
	public static final String PRIMER_APELLIDO_INQUILINO = "primer_apell_inquilino";
	public static final String INGRESOS_INQUILINO = "ingresos_inquilino";
	public static final String NUEVOS_INGRESOS_INQUILINO = "ingresos_inquilino_nuevos";

	public static final String DOCUMENTO_AVALISTA = "documento_aval";
	public static final String NOMBRE_AVALISTA = "nombre_aval";
	public static final String PRIMER_APELLIDO_AVALISTA = "primer_apell_aval";
	public static final String INGRESOS_AVALISTA = "ingresos_aval";
	public static final String NUEVOS_INGRESOS_AVALISTA = "ingresos_aval_nuevos";
	public static final String PARENTESCO_AVALISTA = "parentesco_aval";

	public static final String DOCUMENTO_ASEGURADO = "documento_asegurado";
	public static final String NOMBRE_ASEGURADO = "nombre_asegurado";
	public static final String PRIMER_APELLIDO_ASEGURADO = "primer_apellido_asegurado";
	public static final String SEGUNDO_APELLIDO_ASEGURADO = "segundo_apellido_asegurado";
	public static final String ASEGURADO_DIFERENTE_TOMADOR = "asegurado_diferente_tomador";

	public static final String CODIGO_POSTAL = "codigo_postal";
	public static final String CAPITAL_CONTINENTE = "capital_continente";
	public static final String CAPITAL_CONTINENTE_ANTES = "capital_continente_antes";
	public static final String CAPITAL_CONTINENTE_DESPUES = "capital_continente_despues";
	public static final String CAPITAL_CONTINENTE_VARIACION = "capital_continente_variacion";
	public static final String CAPITAL_CONTENIDO = "capital_contenido";
	public static final String CAPITAL_CONTENIDO_ANTES = "capital_contenido_antes";
	public static final String CAPITAL_CONTENIDO_DESPUES = "capital_contenido_despues";
	public static final String CAPITAL_TOTAL = "capital_total";
	public static final String CAPITAL_TOTAL_ANTES = "capital_total_antes";
	public static final String CAPITAL_TOTAL_DESPUES = "capital_total_despues";

	public static final String CONSTRUIDO_MADERA = "construido_madera";
	public static final String DESHABITACION = "deshabitacion";
	public static final String M2_CONSTRUIDOS = "m2_construidos";
	public static final String ANYO_CONSTRUIDO = "construccion_edificio";
	public static final String ANYO_CONSTRUIDO_MSG = "anyo_construido_msg";
	public static final String ANYO_REHAB_INTEGRAL = "anyo_rehabilitacion_integral";
	public static final String ANYO_REHAB_CONSTRUCCIONES = "anyo_rehabilitacion_construcciones";
	public static final String ANYO_REHAB_CONSTRUCCIONES_MSG = "anyo_rehabilitacion_construcciones_msg";
	public static final String ANYO_REHAB_AGUAS = "anyo_rehabilitacion_aguas";
	public static final String NIVEL_REHAB_AGUAS = "nivel_rehabilitacion_aguas";
	public static final String ESTADO_EDIFICIO = "estado_edificio";

	public static final String M2_VIVIENDAS = "m2_vivienda";
	public static final String M2_GARAJES = "m2_garajes";
	public static final String M2_OFICINAS = "m2_oficinas";
	public static final String M2_ZONAS_AJARDINADAS = "m2_ajardinadas";
	public static final String CAMBIO_M2_VIVIENDAS = "cambio_m2_viviendas";
	public static final String CAMBIO_M2_GARAJES = "cambio_m2_garajes";
	public static final String CAMBIO_M2_OFICINAS = "cambio_m2_oficinas";
	public static final String CAMBIO_M2_ZONAS_AJARDINADAS = "cambio_m2_zonas_ajardinadas";

	public static final String NUM_LOCALES = "num_locales";
	public static final String NUM_VIVIENDAS = "num_viviendas";
	public static final String NUM_EDIFICIOS = "num_edificios";
	public static final String NUM_PLANTAS_ALTO = "num_plantas_alto";
	public static final String NUM_PLANTAS_SOTANO = "num_plantas_sotano";
	public static final String CAMBIO_NUM_EDIFICIOS = "cambio_num_edificios";
	public static final String CAMBIO_NUM_VIVIENDAS = "cambio_num_viviendas";
	public static final String CAMBIO_NUM_LOCALES = "cambio_num_locales";

	public static final String GASOLINERA_MENOS_50M = "gasolinera_menos_50m";
	public static final String CALEFACCION_CENTRAL = "calefaccion_central";
	public static final String DEPOSITO_COMBUSTIBLE = "deposito_combustible";

	public static final String PROVINCIA = "provincia";
	public static final String POBLACION = "poblacion";
	public static final String NOMBRE_VIA = "nombre_via";
	public static final String NUM_VIA = "num_via";
	public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
	public static final String SEXO = "sexo";

	public static final String MEDIADOR = "mediador";

	public static final String INFRA_SEGURO = "infra_seguro";
	public static final String INFRA_SEGURO_MSG_APPEARED = "infra_seguro_msg_appeared";
	public static final String SUPRA_SEGURO = "supra_seguro";
	public static final String SUPRA_SEGURO_MSG_APPEARED = "supra_seguro_msg_appeared";

	public static final String ERROR_CAMBIO_CANTIDADES = "error_cambio_cantidades";
	public static final String MENSAJE_ERROR_CAMBIO_CANTIDADES = "mensaje_error_cambio_cantidades";

	public static final String ASEGURAR_UNICAMENTE_GARAJES = "asegurar_unicamente_garajes";
	public static final String SIN_MENSAJE_AVISO_GARAJES = "sin_mensaje_aviso_garajes";

	public static final String INGRESOS_INQUILINO_NUEVOS = "ingresos_inquilino_nuevos";

	public static final String NIVEL_ESTRUCTURA = "nivel_estructura";
	public static final String NOMBRE_COMERCIAL = "nombre_comercial";
	public static final String NOMBRE_COMERCIAL_PROSPECT = "nombre_comercial_prospect";
	public static final String EJECUTIVO_COMERCIAL = "ejecutivo_comercial";
	public static final String ACTIVIDAD_PRINCIPAL = "actividad_principal";
	public static final String IDIOMA = "idioma";
	public static final String DGS = "dgs";
	public static final String EMAIL_PRINCIPAL = "email_principal";
	public static final String TLF_PRINCIPAL = "tlf_principal";
	public static final String CONTACTO_RESPONSABLE = "contacto_responsable";
	public static final String CARGO_RESPONSABLE = "cargo_responsable";
	public static final String RENTA_MENSUAL_ALQUILER = "renta_mensual_alquiler";
	public static final String IMPAGO_ALQUILER = "impago_alquiler";
	public static final String FRANQUICIA_MAC = "franquiciaMac";
	public static final String FRANQUICIA_VOLUNTARIA = "franquicia_voluntaria";

	public static final String COBERTURA_MAQUINA_INCLUIDA = "cobertura_maquina_incluida";
	public static final String COBERTURA_MAQUINA_TIPO = "cob_opc_tipo_maquinaria";
	public static final String COBERTURA_MAQUINA_VALOR = "cob_opc_valor_maquinaria";
	public static final String COBERTURA_ACCIDENTES_EMPLEADOS_INCLUIDA = "cobertura_accidentes_empleados_incluida";
	public static final String COBERTURA_ENERGIA_SOLAR_INCLUIDA = "cobertura_energia_solar_incluida";
	public static final String COBERTURA_ENERGIA_SOLAR_TIPO = "cob_inst_energia_solar";
	public static final String COBERTURA_ENERGIA_SOLAR_VALOR = "cob_inst_energia_solar_valor";

	public static final String DESCUENTO = "descuento";
	public static final String DESCUENTO_HABILITADO = "descuento_habilitado";
	public static final String RECARGO = "recargo";

	public static final String CAPITALES_MODIFIED_ERROR = "capitales_modified_error";
	public static final String CAPITALES_MODIFIED_MESSAGE = "capitales_modified_message";

	public static final String TIPO_ALTA = "tipo_alta";
	public static final String DOMICILIACION_BANCARIA = "domiciliacion_bancaria";
	public static final String INCLUIR_TELEFONOS_TOMADOR = "incluir_telefonos_tomador";
	public static final String EXCLUIR_GARAJES = "excluir_garajes";
	public static final String EXCLUIR_LOCALES = "excluir_locales";
	public static final String CALIDAD_CONSTRUCCION = "calidad_construccion";

	public static final String INMUEBLE = "direccion_defecto";
	public static final String PROVINCIA_INMUEBLE = "provincia_inm";
	public static final String POBLACION_INMUEBLE = "poblacion_inm";
	public static final String NOMBRE_VIA_INMUEBLE = "via_inm";
	public static final String NUM_VIA_INMUEBLE = "numero_via_inm";

	public static final String FICHERO = "fichero";
	public static final String FICHERO_NUM_VIA = "fichero_numero_via";
	public static final String FICHERO_REFERENCIAS = "fichero_referencias";
	public static final String SUBIR_FICHERO = "subir_fichero";
	public static final String FECHA_ALQUILER = "fecha_contr_alq";
	
	public static final String FECHA_SINIESTRO = "fecha_siniestro";
	public static final String CAUSA_SINIESTRO = "causa_siniestro";	
	
	public static final String ROL_CONTACTO = "contacto_rol";	
	public static final String NOMBRE_CONTACTO = "contacto_nombre";	
	public static final String APELLIDO_CONTACTO = "contacto_apellido";	
	public static final String TELEFONO_CONTACTO = "contacto_telefono";

	public static final String PERSONA_FISICA = "Física";
	public static final String CAPITAL_16M = "16000000";
	public static final String DATOS_RIESGO = "Datos de riesgo";
	
	//Constantes para Siniestros			
	
	//Constantes Siniestros	:	Datos Alta Siniestro
	public static final String FECHA_OCURRENCIA = "fecha_ocurrencia";
	public static final String TIPO_DECLARANTE = "tipo_declarante";
	public static final String MEDIO_DECLARACION = "medio_declaracion";
	public static final String FECHA_REGISTRO = "fecha_registro";
	public static final String FECHA_DENUNCIA = "fecha_denuncia";
	public static final String DECLARACION_OBSERVACIONES = "dec_observaciones";
	public static final String DECLARACION_NOMBRE = "dec_nombre";
	public static final String DECLARACION_PRIM_APELLIDO = "dec_prim_apellido";
	public static final String DECLARACION_SEG_APELLIDO = "dec_seg_apellido";
	public static final String DECLARACION_PREFIJO = "dec_prefijo";
	public static final String DECLARACION_TELEFONO = "dec_telefono";
	public static final String DECLARACION_EMAIL = "dec_email";
	public static final String DECLARACION_EMAIL_NO_DISP = "dec_email_no_disp";
	
	public static final String ASISTENCIA = "asistencia"; 
	public static final String ASISTENCIA_URGENTE = "asis_urgente";
	public static final String ASISTENCIA_DANYOS_UBICADOS = "asis_danyos_ubicados";
	public static final String ASISTENCIA_ORIGEN_DANYOS_REPARADOS = "asis_origen_danyos_reparado";
	public static final String ASISTENCIA_DANYOS_A_CONSECUENCIA = "asis_danyos_a_consecuen";
	public static final String ASISTENCIA_REF_EXTERNA = "asis_ref_externa";
	
	
	public static final String CONTACTO_ROL = "cont_rol";
	public static final String CONTACTO_NOMBRE = "cont_nombre";
	public static final String CONTACTO_PRIM_APELLIDO = "cont_prim_apellido";
	public static final String CONTACTO_SEG_APELLIDO = "cont_seg_apellido";
	public static final String CONTACTO_TIPO_DOCUMENTO = "cont_tipo_doc";
	public static final String CONTACTO_N_DOCUMENTO = "cont_n_documento";
	public static final String CONTACTO_PREFIJO_TEL_UNO = "cont_pref_tel_1";
	public static final String CONTACTO_TELEFONO_UNO = "cont_telefono_1";
	public static final String CONTACTO_PREFIJO_TEL_DOS = "cont_pref_tel_2";
	public static final String CONTACTO_TELEFONO_DOS = "cont_telefono_2";
	public static final String CONTACTO_SEXO = "cont_sexo";
	public static final String CONTACTO_EMAIL = "cont_email";
	public static final String CONTACTO_EMAIL_NO_DISP = "cont_email_no_disp";
	public static final String CONTACTO_VIVE_EN_RIESGO = "cont_vive_en_riesgo";
	public static final String CONTACTO_DIR_TIPO_VIA = "cont_dir_tipo_via";
	public static final String CONTACTO_DIR_CALLE = "cont_dir_calle";
	public static final String CONTACTO_DIR_NUMERO = "cont_dir_numero";
	public static final String CONTACTO_DIR_PISO = "cont_dir_piso";
	public static final String CONTACTO_DIR_PUERTA = "cont_dir_puerta";
	public static final String CONTACTO_DIR_CP = "cont_dir_CP";
	public static final String CONTACTO_DIR_POBLACION = "cont_dir_poblacion";
	public static final String CONTACTO_DIR_PROVINCIA = "cont_dir_provincia";
	
	public static final String OCURRENCIA_LUGAR = "ocu_lugar";
	public static final String OCURRENCIA_DIR_TIPO_VIA = "ocu_dir_tipo_via";
	public static final String OCURRENCIA_DIR_CALLE = "ocu_dir_calle";
	public static final String OCURRENCIA_DIR_NUMERO = "ocu_dir_numero";
	public static final String OCURRENCIA_DIR_PORTAL = "ocu_dir_portal";
	public static final String OCURRENCIA_DIR_ESCALERA = "ocu_dir_escalera";
	public static final String OCURRENCIA_DIR_PISO = "ocu_dir_piso";
	public static final String OCURRENCIA_DIR_PUERTA = "ocu_dir_puerta";
	public static final String OCURRENCIA_DIR_CP = "ocu_dir_CP";
	public static final String OCURRENCIA_DIR_POBLACION = "ocu_dir_poblacion";
	public static final String OCURRENCIA_DIR_PROVINCIA = "ocu_dir_provincia";
	
	public static final String CAUSA = "causa";
	public static final String TIPO_CAUSA = "tipo_causa";
	public static final String MODIFICAR_RESERVA_INICIAL = "modif_reserva_inicial";	
	public static final String DESCRIPCION_SINIESTRO = "descripcion_siniestro"; 
	public static final String OTROS_IMPLICADOS = "otros_implicados";
	
	
	public static final String ASEGURADO = "asegurado";
	public static final String ASEGURADO_NOMBRE = "aseg_nombre";
	public static final String ASEGURADO_PRIM_APELLIDO = "aseg_prim_apellido";
	public static final String ASEGURADO_SEG_APELLIDO = "aseg_seg_apellido";
	public static final String ASEGURADO_TIPO_DOCUMENTO = "aseg_tipo_documento";
	public static final String ASEGURADO_N_DOCUMENTO = "aseg_n_documento";
	public static final String ASEGURADO_TELEFONO_UNO = "aseg_telefono_uno";
	public static final String ASEGURADO_TELEFONO_DOS = "aseg_telefono_dos";
	public static final String ASEGURADO_SEXO = "aseg_sexo";
	public static final String ASEGURADO_EMAIL = "aseg_email";
	public static final String ASEGURADO_DIR_TIPO_VIA = "aseg_tipo_via";
	public static final String ASEGURADO_DIR_CALLE = "aseg_dir_calle";
	public static final String ASEGURADO_DIR_NUMERO = "aseg_dir_numero";
	public static final String ASEGURADO_DIR_PISO = "aseg_dir_piso";
	public static final String ASEGURADO_DIR_PUERTA = "aseg_dir_puerta";
	public static final String ASEGURADO_DIR_CP = "aseg_dir_CP";
	public static final String ASEGURADO_DIR_POBLACION = "aseg_dir_poblacion";
	public static final String ASEGURADO_DIR_PROVINCIA = "aseg_sir_provincia";
	public static final String ASEGURADO_COD_IBAN = "aseg_cod_iban";
	public static final String ASEGURADO_COD_BANCO = "aseg_cod_banco";
	public static final String ASEGURADO_COD_SUCURSAL ="aseg_cod_sucursal";
	public static final String ASEGURADO_COD_DC ="aseg_cod_DC";
	public static final String ASEGURADO_COD_CUENTA ="aseg_cod_cuenta";
		
	public static final String OTRO_IMPLICADO = "otro_implicado";
	public static final String OTRO_ROL = "otro_rol";
	public static final String OTRO_NOMBRE = "otro_nombre";
	public static final String OTRO_PRIM_APELLIDO = "otro_prim_apellido";
	public static final String OTRO_SEG_APELLIDO = "otro_seg_apellido";
	public static final String OTRO_TIPO_DOCUMENTO = "otro_tipo_documento";
	public static final String OTRO_N_DOCUMENTO = "otro_n_documento";
	public static final String OTRO_TELEFONO_UNO = "otro_telefono_1";
	public static final String OTRO_TELEFONO_DOS = "otro_telefono_2";
	public static final String OTRO_SEXO = "otro_sexo";
	public static final String OTRO_EMAIL = "otro_email";
	public static final String OTRO_EMAIL_NO_DISP = "otro_email_no_disp";
	public static final String OTRO_DIR_TIPO_VIA = "otro_dir_tipo_via";
	public static final String OTRO_DIR_CALLE = "otro_dir_calle";
	public static final String OTRO_DIR_NUMERO = "otro_dir_numero";
	public static final String OTRO_DIR_PISO = "otro_dir_piso";
	public static final String OTRO_DIR_PUERTA = "otro_dir_puerta";
	public static final String OTRO_DIR_CP = "otro_dir_CP";
	public static final String OTRO_DIR_POBLACION = "otro_dir_poblacion";
	public static final String OTRO_DIR_PROVINCIA = "otro_dir_provincia";
	public static final String OTRO_COD_IBAN = "otro_cod_IBAN";
	public static final String OTRO_COD_BANCO = "otro_cod_banco";
	public static final String OTRO_COD_SUCURSAL = "otro_cod_sucursal";
	public static final String OTRO_COD_CUENTA = "otro_cod_cuenta";
	public static final String OTRO_IBAN_NO_DISP = "otro_IBAN_no_disp";
	public static final String OTRO_COMPANYIA_PRIVADA = "otro_companya_privada";
	public static final String OTRO_POLIZA = "otro_poliza";
	public static final String OTRO_REF_CONTRARIA = "otro_referencia_contraria";
	public static final String OTRO_COMP_PRIV_EMAIL = "otro_comp_priv_email";
	
	public static final String ENCARGO_COLABORADOR = "enc_colaborador";
	public static final String ENCARGO = "encargo";
	public static final String ENCARGO_SUBTIPO = "enc_subtipo";
	public static final String ENCARGO_FECHA = "enc_fecha";
	public static final String ENCARGO_DETALLES = "enc_detalles";
	public static final String ENCARGO_DOCUMENTOS = "enc_documentos";

	public static final String CIERRE_SINIESTRO = "cierre_siniestro";
	public static final String REAPERTURA_SINIESTRO = "reapertura_siniestro";
	public static final String REHUSO_SINIESTRO = "rehuso_siniestro";

}