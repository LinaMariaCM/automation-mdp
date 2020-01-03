package com.amaris.project.pages.productos;

import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class TomadorYAseguradoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By continuarBtn = By.cssSelector("button[ng-click*='continuar(tomador']");
	private By anyadirDatosTomadorPantallaPrincipalBtn = By.xpath(".//*[text()='Añadir datos tomador']");

	private By fechaNacimientoInput = By.name("fechaNacimiento");

	private By utilizarMismaDireccionAseguradoBtn = By.xpath(".//*[text() = 'Utilizar la misma dirección del riesgo asegurado']/../input");
	private By anyadirDatosTomadorBtn = By.xpath(".//*[@class='modal-footer']/button[text()='Añadir datos tomador']");
	private By aceptarBtn = By.xpath(".//*[text()='Aceptar']");

	private By prefijoTelefonoFijoInput = By.cssSelector("#prefijoTlfFijo");
	private By prefijoBtn = By.xpath(".//*[contains(@ng-bind-html,'ypeaheadHighlight')]");
	private By telefonoFijoInput = By.cssSelector("#tlfFijo");
	private By telefonoMovilPrefijoInput = By.cssSelector("#prefijoTlfMovil");
	private By telefonoMovilInput = By.cssSelector("#tlfMovil");

	private By aseguradoDiferenteToamdorBtn = By.cssSelector("#asegPpalEsTomadorNo");
	private By addDataOfTheAseguradoPrincipalBtn = By.xpath(".//*[text()='Añadir datos asegurado principal']");
	private By aseguradoTipoDocumentoDrpDwn = By.cssSelector("#tipoDocumento");
	private By aseguradoNumeroDocumentoInput = By.cssSelector("#numeroDocumento");
	private By aseguradoNombreInput = By.cssSelector("#nombreAsegurado");
	private By aseguradoApellido1Input = By.cssSelector("#apellido1Asegurado");
	private By aseguradoApellido2Input = By.cssSelector("#apellido2Asegurado");

	private By addAseguradoPrincipalModalWindowBtn = By.xpath(".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']");
	// endregion

	public TomadorYAseguradoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public TomadorYAseguradoPage addDatosTomador() {
		debugBegin();

		if(getTestVar(Constants.TOMADOR).equals(Constants.NuevoTomadorYAseguradoPrincipal)) {
			webDriver.clickInFrame(anyadirDatosTomadorPantallaPrincipalBtn, cuerpoFrame);

			if(getTestVar(Constants.INCLUIR_TELEFONOS_TOMADOR) != null && getTestVar(Constants.INCLUIR_TELEFONOS_TOMADOR).equals(Constants.TelefonosTomadorIncluidos)) {
				addTelefonosYHorariosAtencionTomador();
			}

			webDriver.clickInFrame(fechaNacimientoInput, cuerpoFrame);
			webDriver.appendTextInFrame(fechaNacimientoInput, cuerpoFrame, getTestVar(Constants.FECHA_NACIMIENTO_TOMADOR));

			webDriver.clickInFrame(utilizarMismaDireccionAseguradoBtn, cuerpoFrame);

			webDriver.clickInFrame(anyadirDatosTomadorBtn, cuerpoFrame);
			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addStaticDatosTomador() {
		debugBegin();

		webDriver.moveToElementInFrame(anyadirDatosTomadorPantallaPrincipalBtn, cuerpoFrame);
		webDriver.clickInFrame(anyadirDatosTomadorPantallaPrincipalBtn, cuerpoFrame);

		webDriver.clickInFrame(fechaNacimientoInput, cuerpoFrame);
		webDriver.appendTextInFrame(fechaNacimientoInput, cuerpoFrame, "08/01/1979");

		webDriver.clickInFrame(utilizarMismaDireccionAseguradoBtn, cuerpoFrame);

		webDriver.clickInFrame(anyadirDatosTomadorBtn, cuerpoFrame);
		webDriver.clickInFrame(aceptarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addTelefonosYHorariosAtencionTomador() {
		webDriver.clickInFrame(telefonoFijoInput, cuerpoFrame);
		webDriver.appendTextInFrame(telefonoFijoInput, cuerpoFrame, getTestVar(Constants.TELEFONO_FIJO_TOMADOR));

		webDriver.appendTextInFrame(prefijoTelefonoFijoInput, cuerpoFrame, getTestVar(Constants.PREFIJO_TELEFONO_FIJO_TOMADOR));
		webDriver.clickInFrame(prefijoBtn, cuerpoFrame);

		// List<String> TelefonoFijoHorarioAtencion =
		// testDataM.getTestListVar(testId, "TelefonoFijoHorarioAtencion");
		//
		// TelefonoFijoHorarioAtencion.forEach(option ->
		// {
		// switch (option)
		// {
		// case ProjectConstants.Manana:
		// webDriver.clickInFrame(chbTelefonoFijoHorarioAtencionManana,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Tarde:
		// webDriver.clickInFrame(chbTelefonoFijoHorarioAtencionTarde,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Noche:
		// webDriver.clickInFrame(chbTelefonoFijoHorarioAtencionNoche,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.FinDeSemana:
		// webDriver.clickInFrame(chbTelefonoFijoHorarioAtencionFinDeSemana,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.DeLunesAViernes:
		// webDriver.clickInFrame(chbTelefonoFijoHorarioAtencionDeLunesAViernes,
		// cuerpoFrame);
		// break;
		// }
		// });

		webDriver.appendTextInFrame(telefonoMovilInput, cuerpoFrame, getTestVar(Constants.TELEFONO_MOVIL_TOMADOR));

		webDriver.appendTextInFrame(telefonoMovilPrefijoInput, cuerpoFrame, getTestVar(Constants.PREFIJO_TELEFONO_MOVIL_TOMADOR));
		webDriver.clickInFrame(prefijoBtn, cuerpoFrame);
		//
		// List<String> TelefonoMovilHorarioAtencion =
		// testDataM.getTestListVar(testId,
		// "TelefonoMovilHorarioAtencion");
		//
		// TelefonoMovilHorarioAtencion.forEach(option ->
		// {
		// switch (option)
		// {
		// case ProjectConstants.Manana:
		// webDriver.clickInFrame(chbTelefonoMovilHorarioAtencionManana,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Tarde:
		// webDriver.clickInFrame(chbTelefonoMovilHorarioAtencionTarde,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.Noche:
		// webDriver.clickInFrame(chbTelefonoMovilHorarioAtencionNoche,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.FinDeSemana:
		// webDriver.clickInFrame(chbTelefonoMovilHorarioAtencionFinDeSemana,
		// cuerpoFrame);
		// break;
		//
		// case ProjectConstants.DeLunesAViernes:
		// webDriver.clickInFrame(chbTelefonoMovilHorarioAtencionDeLunesAViernes,
		// cuerpoFrame);
		// break;
		// }
		// });

		return this;
	}

	public TomadorYAseguradoPage clickContinuar() {
		debugBegin();
		webDriver.scrollToBottomInFrame(cuerpoFrame);
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addDatosTomadorDiferenteAsegurado() {
		debugBegin();

		if(getTestVar(Constants.ASEGURADO_DIFERENTE_TOMADOR)
			.equals(Constants.AseguradoPrincipalDiferenteTomador)) {
			webDriver.clickInFrame(aseguradoDiferenteToamdorBtn, cuerpoFrame);
			webDriver.clickInFrame(addDataOfTheAseguradoPrincipalBtn, cuerpoFrame);
			webDriver.clickElementFromDropDownByTextInFrame(aseguradoTipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);

			setTestVar(Constants.DOCUMENTO_ASEGURADO, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(aseguradoNumeroDocumentoInput, cuerpoFrame, getTestVar(Constants.DOCUMENTO_ASEGURADO));
			webDriver.appendTextInFrame(aseguradoNombreInput, cuerpoFrame, getTestVar(Constants.NOMBRE_ASEGURADO));
			webDriver.appendTextInFrame(aseguradoApellido1Input, cuerpoFrame, getTestVar(Constants.PRIMER_APELLIDO_ASEGURADO));
			webDriver.appendTextInFrame(aseguradoApellido2Input, cuerpoFrame, getTestVar(Constants.SEGUNDO_APELLIDO_ASEGURADO));
			webDriver.clickInFrame(utilizarMismaDireccionAseguradoBtn, cuerpoFrame);
			webDriver.clickInFrame(addAseguradoPrincipalModalWindowBtn, cuerpoFrame);
			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}
	// endregion
}
