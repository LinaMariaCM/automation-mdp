package com.amaris.project.pages.productos.mac;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import com.amaris.project.Constants;

public class TomadorYAseguradoPage_MAC extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	// DATOS TOMADOR
	private By btnTomador = By.xpath(".//*[text()='Tomador']");

	private By drpDwnAlta = By.cssSelector("#TOMADOR_TIPOTOMASEG_CONF");
	private By drpDwnTipoPersona = By.cssSelector("#TOMADOR_TIPOPERSONA_CONF");
	private By drpDwnDocumento = By.cssSelector("#TOMADOR_TIPODOCFIS_CONF");
	private By drpDwnMedioPago = By.cssSelector("#TOMADOR_MEDIOPAGO_CONF");

	private By btnAsegurado = By.xpath(".//*[text()='Asegurado']");
	private By btnFisica = By.xpath(".//*[text()='Fisica']");
	private By btnNIF = By.xpath(".//*[text()='NIF']");
	private By btnMedioPagoMediador = By.xpath(".//*[text()='Mediador']");
	private By txtDocumento = By.xpath(".//*[text()='Documento']");

	private By anadirDatosTomadorBtn = By.cssSelector("#botonGrabar");
	private By btnAnadirDatosTomadorPantallaPrincipal = By.id("addTomaAsegurados");
	private By anadirDireccionBtn = By.cssSelector("#botonInmuebleVisual");

	private By tomadorDniTxt = By.cssSelector("#TOMADOR_DOCUMENTOFIS_CONF");
	private By tomadorNombreTxt = By.cssSelector("#TOMADOR_NOMBREFIS_CONF");
	private By tomadorPrimerApellidoTxt = By.cssSelector("#TOMADOR_APELL1FIS_CONF");
	private By tomadorSegundoApellidoTxt = By.cssSelector("#TOMADOR_APELL2FIS_CONF");
	private By fechaNacimientoTxt = By.cssSelector("#fechaNacimiento");

	private By rellenarDireccionBtn = By.cssSelector("#botoncapaUbicacionIntervinientes");
	private By provinciaTxt = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO_TOM");
	private By provinciaItem = By.xpath("/html/body/ul[2]/li/a");
	private By poblacionTxt = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO_TOM");
	private By poblacionItem = By.xpath("/html/body/ul[3]/li/a");
	private By nomViaTxt = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO_TOM");
	private By nomViaItem = By.xpath("/html/body/ul[4]/li/a");
	private By numViaTxt = By.cssSelector("#ALTACLIE_BS_NUMVIA_TOM");
	private By drpDwnTipoVia = By.cssSelector("#ALTACLIE_BS_TIPOVIA_ARVATO_TOM");
	private By txtCodigoPostal = By.cssSelector("#ALTACLIE_BS_CODPOST_ARVATO_TOM");

	private By txtIBAN = By.cssSelector("#bloque2Tomador");
	// endregion

	public TomadorYAseguradoPage_MAC(UserStory userS) {
		super(userS);
	}

	// region Methods
	public void executeActionsInTomadorYAseguradoPage() {
		AddDatosTomadorAsegurado();
	}

	public void AddDatosTomadorAsegurado() {
		debugBegin();

		if(!getScenarioVar(Constants.TIPO_ALTA).equals(Constants.NuevoTomadorYAseguradoPrincipal)) {
			webDriver.clickInFrame(btnAnadirDatosTomadorPantallaPrincipal, mainFrame);

			seleccionarTomador("Tomador");
			seleccionarTipoPersona(Constants.PERSONA_FISICA);
			seleccionarTipoDocumento(Constants.NIF);

			setTestVar(Constants.DNI_TOMADOR, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(tomadorDniTxt, mainFrame, getTestVar(Constants.DNI_TOMADOR));
			webDriver.appendTextInFrame(tomadorNombreTxt, mainFrame, getScenarioVar(Constants.NOMBRE_TOMADOR));
			webDriver.appendTextInFrame(tomadorPrimerApellidoTxt, mainFrame, getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
			webDriver.appendTextInFrame(tomadorSegundoApellidoTxt, mainFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));

			webDriver.clickInFrame(rellenarDireccionBtn, mainFrame);
			webDriver.appendTextInFrame(provinciaTxt, mainFrame, getScenarioVar(Constants.PROVINCIA));
			webDriver.clickInFrame(provinciaItem, mainFrame);
			webDriver.appendTextInFrame(poblacionTxt, mainFrame, getScenarioVar(Constants.POBLACION));
			webDriver.clickInFrame(poblacionItem, mainFrame);
			webDriver.appendTextInFrame(nomViaTxt, mainFrame, getScenarioVar(Constants.NOMBRE_VIA));
			webDriver.clickInFrame(nomViaItem, mainFrame);
			webDriver.appendTextInFrame(numViaTxt, mainFrame, getData("fichero_numero_via").getValue(userS.getScenario(), Constants.NUM_VIA_INMUEBLE));
			webDriver.clickInFrame(anadirDireccionBtn, mainFrame);
			webDriver.appendTextInFrame(fechaNacimientoTxt, mainFrame, getScenarioVar(Constants.FECHA_NACIMIENTO));
			seleccionarMedioPago();

			webDriver.clickInFrame(anadirDatosTomadorBtn, mainFrame);
		}

		debugEnd();
	}

	public void seleccionarTomador(String tomador) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpDwnAlta, mainFrame, tomador);
		debugEnd();
	}

	public void seleccionarTipoDocumento(String tipoDocumento) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpDwnDocumento, mainFrame, tipoDocumento);
		debugEnd();
	}

	public void seleccionarTipoPersona(String tipoPersona) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(drpDwnTipoPersona, mainFrame, tipoPersona);
		debugEnd();
	}

	public void seleccionarMedioPago() {
		debugBegin();
		if(getScenarioVar(Constants.MEDIO_PAGO).equals(Constants.MEDIADOR)) {
			webDriver.clickElementFromDropDownByTextInFrame(drpDwnMedioPago, mainFrame, "Mediador");
			debugEnd();
		}

		if(getScenarioVar(Constants.MEDIO_PAGO).equals(Constants.DOMICILIACION_BANCARIA)) {
			webDriver.clickElementFromDropDownByTextInFrame(drpDwnMedioPago, mainFrame, "Domiciliación bancaria");
			webDriver.appendTextInFrame(txtIBAN, mainFrame, getScenarioVar(Constants.NUM_CUENTA).substring(2));

		}

		debugEnd();
	}
}
