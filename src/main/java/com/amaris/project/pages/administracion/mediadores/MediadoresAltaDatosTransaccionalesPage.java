package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

import javax.swing.undo.CannotUndoException;

public class MediadoresAltaDatosTransaccionalesPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//---------Datos de negocio--------------------------

	private By tipoRetribucionCombo = By.id("ALTAMEDI_TIPRETRI");
	private By tipoRetribucionOption = By.cssSelector("#ALTAMEDI_TIPRETRI > option");

	private By facturasBtn = By.id("ALTAMEDI_EMIFACT");
	private By polizasCrosselingBtn = By.id("ALTAMEDI_POLICROS");
	private By liquidarOficinasBtn = By.id("ALTAMEDI_LIQNIOFI");
	private By consolidarCuentaBtn = By.id("ALTAMEDI_LIQNIOFI");

	private By clasificarNegocioCombo = By.id("ALTAMEDI_CLAVONE");
	private By clasificarNegocioOption = By.cssSelector("#ALTAMEDI_CLAVONE > option");

	private By codigoIbanInput = By.id("COMODIN_CADENA");
	private By bancoInput = By.id("COMODIN_CADENA_1");
	private By sucursalInput = By.id("COMODIN_CADENA_2");
	private By dcInput = By.id("COMODIN_CADENA_3");
	private By cta1Input = By.id("COMODIN_CADENA_4");
	private By cta2Input = By.id("COMODIN_CADENA_5");

	private By codigoIbanLiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA");
	private By bancoLiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA_1");
	private By sucursalLiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA_2");
	private By dcLiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA_3");
	private By cta1LiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA_4");
	private By cta2LiqInput = By.cssSelector("#CCCOBRO_COMODIN_CADENA_5");

	//----------------Configuracion liquidacion---------------------

	private By retencionesBtn = By.id("ALTAMEDI_RETPARAPP");
	private By liquidacionParcialBtn = By.id("ALTAMEDI_PELIQPAR");
	private By pagoSinLiquidacionBtn = By.id("ALTAMEDI_PASINLIQ");
	private By limiteConcesionesInput = By.id("ALTAMEDI_LIMCOMIS");

	//-------------------------Configuración gestion de recibos-----------

	private By permisoImpresionRecibosBtn = By.id("ALTAMEDI_PERIMPREC");
	private By accionImpagoCombo = By.id("ALTAMEDI_ULTACIMP");
	private By accionImpagoOption = By.cssSelector("#ALTAMEDI_ULTACIMP > option");
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

	private By cancelarBtn = By.id("botonCancelar1");
	private By guardarBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	public MediadoresAltaDatosTransaccionalesPage(UserStory userS) {
		super(userS);
	}

	//-------------Añadir datos de negocio ---------------------

	public MediadoresAltaDatosTransaccionalesPage anyadirDatosBanco(String iban, String banco, String sucursal, String dc, String cta1, String cta2) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		webDriver.setText(codigoIbanInput, iban);
		webDriver.setText(bancoInput, banco);
		webDriver.setText(sucursalInput, sucursal);
		webDriver.setText(dcInput, dc);
		webDriver.setText(cta1Input, cta1);
		webDriver.setText(cta2Input, cta2);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosTransaccionalesPage anyadirDatosBancoLiquidaciones(String iban, String banco, String sucursal, String dc, String cta1, String cta2) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		webDriver.setText(codigoIbanLiqInput, iban);
		webDriver.setText(bancoLiqInput, banco);
		webDriver.setText(sucursalLiqInput, sucursal);
		webDriver.setText(dcLiqInput, dc);
		webDriver.setText(cta1LiqInput, cta1);
		webDriver.setText(cta2LiqInput, cta2);

		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//------------Configuración gestión de recibos-------------------
	public MediadoresAltaDatosTransaccionalesPage anyadirConfiguracionGestionrecibos(String ultAccionImpago) {
		debugBegin();
		if(ultAccionImpago.isEmpty()) ultAccionImpago = "NADA";
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.clickElementFromDropDownByAttribute(accionImpagoCombo, accionImpagoOption, "value", ultAccionImpago);
		webDriver.exitFrame();
		debugEnd();

		return this;
	}

	//-------------Clicks botones---------------------
	public MediadoresAltaDatosTransaccionalesPage clickContiuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosTransaccionalesPage clickGuardar() {
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAltaDatosTransaccionalesPage clickCancelar() {
		debugBegin();
		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	//-------------RETENCIONES DATOS TRANSACCIONALES PARA ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR-----------------------

	public MediadoresAltaDatosTransaccionalesPage retencionesAltaTransaccionales() {
		debugBegin();

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoRetribucionCombo, tipoRetribucionOption, cuerpoFrame, "title", "Elegir");

		clickGuardar();
		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_TIPO_RETRIBUCION_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(tipoRetribucionCombo, tipoRetribucionOption, cuerpoFrame, "value", "COMI");

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("COLA")
			&& getTestVar(Constants.TIPO_COLABORADOR).equalsIgnoreCase("AUXI")) {

			clickContiuar();
		}

		if(getTestVar(Constants.NIVEL_ESTRUCTURA) != null && !getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {

			clickContiuar();

			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CODIGO_IBAN);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(codigoIbanInput, "ES03", cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_BANCO);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(bancoInput, "2100", cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SUCURSAL);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(sucursalInput, "1234", cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DC_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(dcInput, "5612", cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CTA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(cta1Input, "3456", cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CTA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(cta2Input, "7890", cuerpoFrame);

			webDriver.clearTextInFrame(codigoIbanLiqInput, cuerpoFrame);
			webDriver.clearTextInFrame(bancoLiqInput, cuerpoFrame);
			webDriver.clearTextInFrame(sucursalLiqInput, cuerpoFrame);
			webDriver.clearTextInFrame(dcLiqInput, cuerpoFrame);
			webDriver.clearTextInFrame(cta1LiqInput, cuerpoFrame);
			webDriver.clearTextInFrame(cta2LiqInput, cuerpoFrame);

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CODIGO_IBAN);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(codigoIbanLiqInput, cuerpoFrame, "ES03");

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_BANCO);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(bancoLiqInput, cuerpoFrame, "2100");

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_SUCURSAL);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(sucursalLiqInput, cuerpoFrame, "1234");

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_DC_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(dcLiqInput, cuerpoFrame, "5612");

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CTA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(cta1LiqInput, cuerpoFrame, "3456");

			clickContiuar();
			new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CTA_MEDIADORES);
			webDriver.acceptAlert();

			webDriver.setTextInFrame(cta2LiqInput, cuerpoFrame, "7890");

			clickContiuar();
		}

		debugEnd();
		return this;
	}

}
