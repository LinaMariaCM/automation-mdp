package com.amaris.project.pages.productos.mac;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import com.amaris.project.Constants;

public class TomadorYAseguradoPageMac extends PageObject {

	// region WebElements
	private By mainFrame = By.cssSelector("#mainFrame");

	private By altaDrpDwn = By.cssSelector("#TOMADOR_TIPOTOMASEG_CONF");
	private By tipoPersonaDrpDwn = By.cssSelector("#TOMADOR_TIPOPERSONA_CONF");
	private By documentoDrpDwn = By.cssSelector("#TOMADOR_TIPODOCFIS_CONF");
	private By medioPagoDrpDwn = By.cssSelector("#TOMADOR_MEDIOPAGO_CONF");

	private By anadirDatosTomadorBtn = By.cssSelector("#botonGrabar");
	private By anadirDatosTomadorPantallaPrincipalBtn = By.id("addTomaAsegurados");
	private By anadirDireccionBtn = By.cssSelector("#botonInmuebleVisual");

	private By tomadorDniInput = By.cssSelector("#TOMADOR_DOCUMENTOFIS_CONF");
	private By tomadorNombreInput = By.cssSelector("#TOMADOR_NOMBREFIS_CONF");
	private By tomadorPrimerApellidoInput = By.cssSelector("#TOMADOR_APELL1FIS_CONF");
	private By tomadorSegundoApellidoInput = By.cssSelector("#TOMADOR_APELL2FIS_CONF");
	private By fechaNacimientoInput = By.cssSelector("#fechaNacimiento");

	private By rellenarDireccionBtn = By.cssSelector("#botoncapaUbicacionIntervinientes");
	private By provinciaInput = By.cssSelector("#ALTACLIE_BS_PROVINCIA_ARVATO_TOM");
	private By provinciaBtn = By.xpath("/html/body/ul[2]/li/a");
	private By poblacionInput = By.cssSelector("#ALTACLIE_BS_POBLACION_ARVATO_TOM");
	private By poblacionBtn = By.xpath("/html/body/ul[3]/li/a");
	private By nomViaInput = By.cssSelector("#ALTACLIE_BS_NOMVIA_ARVATO_TOM");
	private By nomViaBtn = By.xpath("/html/body/ul[4]/li/a");
	private By numViaInput = By.cssSelector("#ALTACLIE_BS_NUMVIA_TOM");
	private By ibanInput = By.cssSelector("#bloque2Tomador");
	// endregion

	public TomadorYAseguradoPageMac(UserStory userS) {
		super(userS);
	}

	// region Methods
	public TomadorYAseguradoPageMac addDatosTomadorAsegurado() {
		debugBegin();

		if(getScenarioVar(Constants.TIPO_ALTA) != null && !getScenarioVar(Constants.TIPO_ALTA).equals(Constants.NuevoTomadorYAseguradoPrincipal)) {
			webDriver.clickInFrame(anadirDatosTomadorPantallaPrincipalBtn, mainFrame);

			seleccionarTomador("Tomador");
			seleccionarTipoPersona(Constants.PERSONA_FISICA);
			seleccionarTipoDocumento(Constants.NIF);

			setTestVar(Constants.DNI_TOMADOR, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(tomadorDniInput, mainFrame, getTestVar(Constants.DNI_TOMADOR));
			webDriver.appendTextInFrame(tomadorNombreInput, mainFrame, getScenarioVar(Constants.NOMBRE_TOMADOR));
			webDriver.appendTextInFrame(tomadorPrimerApellidoInput, mainFrame, getScenarioVar(Constants.PRIMER_APELLIDO_TOMADOR));
			webDriver.appendTextInFrame(tomadorSegundoApellidoInput, mainFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_TOMADOR));

			webDriver.clickInFrame(rellenarDireccionBtn, mainFrame);
			webDriver.appendTextInFrame(provinciaInput, mainFrame, getScenarioVar(Constants.PROVINCIA));

			webDriver.clickInFrame(provinciaBtn, mainFrame);
			webDriver.appendTextInFrame(poblacionInput, mainFrame, getScenarioVar(Constants.POBLACION));

			webDriver.clickInFrame(poblacionBtn, mainFrame);
			webDriver.appendTextInFrame(nomViaInput, mainFrame, getScenarioVar(Constants.NOMBRE_VIA));

			webDriver.clickInFrame(nomViaBtn, mainFrame);
			webDriver.appendTextInFrame(numViaInput, mainFrame, getData("fichero_numero_via").getValue(userS.getScenario(), Constants.NUM_VIA_INMUEBLE));

			webDriver.clickInFrame(anadirDireccionBtn, mainFrame);
			webDriver.appendTextInFrame(fechaNacimientoInput, mainFrame, getScenarioVar(Constants.FECHA_NACIMIENTO));

			seleccionarMedioPago();

			webDriver.clickInFrame(anadirDatosTomadorBtn, mainFrame);
		}

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPageMac seleccionarTomador(String tomador) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(altaDrpDwn, mainFrame, tomador);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPageMac seleccionarTipoDocumento(String tipoDocumento) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(documentoDrpDwn, mainFrame, tipoDocumento);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPageMac seleccionarTipoPersona(String tipoPersona) {
		debugBegin();
		webDriver.clickElementFromDropDownByTextInFrame(tipoPersonaDrpDwn, mainFrame, tipoPersona);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPageMac seleccionarMedioPago() {
		debugBegin();

		if(getScenarioVar(Constants.MEDIO_PAGO).equals(Constants.MEDIADOR)) {
			webDriver.clickElementFromDropDownByTextInFrame(medioPagoDrpDwn, mainFrame, "Mediador");
			debugEnd();
		}

		if(getScenarioVar(Constants.MEDIO_PAGO).equals(Constants.DOMICILIACION_BANCARIA)) {
			webDriver.clickElementFromDropDownByTextInFrame(medioPagoDrpDwn, mainFrame, "Domiciliación bancaria");
			webDriver.appendTextInFrame(ibanInput, mainFrame, getScenarioVar(Constants.NUM_CUENTA).substring(2));

		}

		debugEnd();

		return this;
	}
}
