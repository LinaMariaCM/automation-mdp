package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosTransaccionalesPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

//---------Datos de negocio--------------------------

	private By tipoRetribucionCombo = By.id("ALTAMEDI_TIPRETRI");

	private By facturasBtn = By.id("ALTAMEDI_EMIFACT");
	private By polizasCrosselingBtn = By.id("ALTAMEDI_POLICROS");
	private By liquidarOficinasBtn = By.id("ALTAMEDI_LIQNIOFI");
	private By consolidarCuentaBtn = By.id("ALTAMEDI_LIQNIOFI");

	private By clasificarNegocioCombo = By.id("ALTAMEDI_CLAVONE");

	private By codigoIbanInput = By.id("COMODIN_CADENA");
	private By bancoInput = By.id("COMODIN_CADENA_1");
	private By sucursalInput = By.id("COMODIN_CADENA_2");
	private By dcInput = By.id("COMODIN_CADENA_3");
	private By cta1Input = By.id("COMODIN_CADENA_4");
	private By cta2Input = By.id("COMODIN_CADENA_5");

//----------------Configuracion liquidacion---------------------

	private By retencionesBtn = By.id("ALTAMEDI_RETPARAPP");
	private By liquidacionParcialBtn = By.id("ALTAMEDI_PELIQPAR");
	private By pagoSinLiquidacionBtn = By.id("ALTAMEDI_PASINLIQ");
	private By limiteConcesionesInput = By.id("ALTAMEDI_LIMCOMIS");

//-------------------------Configuración gestion de recibos-----------

	private By permisoImpresionRecibosBtn = By.id("ALTAMEDI_PERIMPREC");
	private By accionImpagoCombo = By.id("ALTAMEDI_ULTACIMP");
	private By permitirDevueltosBancariosCombo = By.id("ALTAMEDI_PEGESDEVBAN");
	private By asignarDevueltosBancariosCombo = By.id("ALTAMEDI_ASAUTDEBAN");
	private By numeroDiasCobroDomiciliadosInput = By.id("ALTAMEDI_NDCOBDEF");
	private By numeroReenviosAutomaticosCombo = By.id("ALTAMEDI_NREENAUT");
	private By numDiasPasoImpagoInput = By.id("ALTAMEDI_NDPASIMP");

//------------------------Acceso operativas-------------

	private By accesoRecibosBtn = By.id("ALTAMEDI_ACCRECIB");
	private By pagoDomiciliacionBtn = By.id("ALTAMEDI_PAGDOMBAND");
	private By accesoCuentaMediadorBtn = By.id("ALTAMEDI_ACCCUMED");
	private By accesoFicherosDMBtn = By.id("ALTAMEDI_ACCFICCDM");
	private By accesoFicherosNODOMBtn = By.id("ALTAMEDI_ACCFICCNDM");

//----------------Envio documentacion------------------------------

	private By mandatoSEPABtn = By.id("ALTAMEDI_GENMSEPA");
	private By liquidacionesBtn = By.id("ALTAMEDI_LIQUIDAC");
	private By cartasRenovacionTomadorBtn = By.id("ALTAMEDI_CARRENTOM");
	private By listadoRecibosDomiciliadosBtn = By.id("ALTAMEDI_LISRECDOM");
	private By listadoCuentaEfectivoBtn = By.id("ALTAMEDI_LISCUENEFE");
	private By listadoPendientesBtn = By.id("ALTAMEDI_LISPENDI");

	//------------------------Valoracion financiera----------------

	private By clasificacionFinancieraCombo = By.id("ALTAMEDI_CLASCONT");
	private By nuevaFechaFiscalInput = By.id("ALTAMEDI_FECHALFI");
	private By nivelControlCombo = By.id("ALTAMEDI_NIVECONT");
	private By irpfCombo = By.id("GESMED_IRPF");
	private By causaIRPFreducidoCombo = By.id("ALTAMEDI_CAIRPFRED");
	private By irpfDocumentosCombo = By.id("ALTAMEDI_DOCUMENT");
	private By tipoPeriodoCombo = By.id("ALTAMEDI_TIPOPERI");
	private By periodoCombo = By.id("ALTAMEDI_PERIODO");
	private By evaluacionFinancieraEjercicioInput = By.id("ALTAMEDI_EJERCICIO");

	//-----------Controles de pagina---------------------------

	private By cancelarDescripcionBtn = By.id("botonCancelar1");
	private By guardarDescripcionBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	public MediadoresAltaDatosTransaccionalesPage(UserStory userS) {
		super(userS);
	}

}
