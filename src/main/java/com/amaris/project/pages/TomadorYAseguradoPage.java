package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class TomadorYAseguradoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.cssSelector("button[ng-click*='continuar(tomador']");
	private By btnAnadirDatosTomadorPantallaPrincipal = By.xpath(".//*[text()='Añadir datos tomador']");

	private By txtFechaNacimiento = By.name("fechaNacimiento");

	private By rdnUtilizarMismaDireccionAsegurado = By.xpath(".//*[text() = 'Utilizar la misma dirección del riesgo asegurado']/../input");
	private By btnAnadirDatosTomador = By.xpath(".//*[@class='modal-footer']/button[text()='Añadir datos tomador']");
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");
	
	private By txtPrefijoTelefonoFijo = By.cssSelector("#prefijoTlfFijo");
	private By lblPrefijo = By.xpath(".//*[contains(@ng-bind-html,'ypeaheadHighlight')]");
	private By txtTelefonoFijo = By.cssSelector("#tlfFijo");
	private By chbTelefonoFijoHorarioAtencionManana = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='1']");
	private By chbTelefonoFijoHorarioAtencionDeLunesAViernes = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='4']");
	private By chbTelefonoFijoHorarioAtencionTarde = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='2']");
	private By chbTelefonoFijoHorarioAtencionFinDeSemana = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='5']");
	private By chbTelefonoFijoHorarioAtencionNoche = By.xpath(".//*[@name = 'horarioAtenTlfFijo' and @value='3']");
	private By txtTelefonoMovilPrefijo = By.cssSelector("#prefijoTlfMovil");
	private By txtTelefonoMovil = By.cssSelector("#tlfMovil");
	private By chbTelefonoMovilHorarioAtencionManana = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='1']");
	private By chbTelefonoMovilHorarioAtencionDeLunesAViernes = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='4']");
	private By chbTelefonoMovilHorarioAtencionTarde = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='2']");
	private By chbTelefonoMovilHorarioAtencionFinDeSemana = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='5']");
	private By chbTelefonoMovilHorarioAtencionNoche = By.xpath(".//*[@name = 'horarioAtenTlfMovil' and @value='3']");

	private By cbkAseguradoDiferenteToamdor = By.cssSelector("#asegPpalEsTomadorNo");
	private By btnAddDataOfTheAseguradoPrincipal = By.xpath(".//*[text()='Añadir datos asegurado principal']");
	private By cbkAeguradoTipoDocumento = By.cssSelector("#tipoDocumento");
	private By txtAseguradoNumeroDocumento = By.cssSelector("#numeroDocumento");
	private By txtAseguradoNombre = By.cssSelector("#nombreAsegurado");
	private By txtAseguradoApellido1 = By.cssSelector("#apellido1Asegurado");
	private By txtAseguradoApellido2 = By.cssSelector("#apellido2Asegurado");

	private By chkAseguradoMismaDireccionDelRiesgo = By.xpath(".//*[@ng-model='mismaDireccionRiesgo']");
	private By btnAddAseguradoPrincipalModalWindow = By.xpath(".//div[@class='modal-footer']/button[text()='Añadir datos asegurado principal']");
	private By btnModificarDatosTomador = By.xpath(".//*[@name='tomadorAseguradoForm']//*[text()='Modificar datos tomador']");
	// endregion

	public TomadorYAseguradoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public TomadorYAseguradoPage AddDatosTomador() {
		debugBegin();

		if(getTestVar(Constants.TOMADOR).equals(Constants.NuevoTomadorYAseguradoPrincipal)) {
			webDriver.moveToElementInFrame(btnAnadirDatosTomadorPantallaPrincipal, cuerpoFrame);
			webDriver.clickInFrame(btnAnadirDatosTomadorPantallaPrincipal, cuerpoFrame);

			if(getTestVar(Constants.INCLUIR_TELEFONOS_TOMADOR).equals(Constants.TelefonosTomadorIncluidos)) {
				AddTelefonosYHorariosAtencionTomador();
			}

			webDriver.clickInFrame(txtFechaNacimiento, cuerpoFrame);
			webDriver.appendTextInFrame(txtFechaNacimiento, cuerpoFrame, getTestVar(Constants.FECHA_NACIMIENTO_TOMADOR));

			webDriver.clickInFrame(rdnUtilizarMismaDireccionAsegurado, cuerpoFrame);

			webDriver.clickInFrame(btnAnadirDatosTomador, cuerpoFrame);
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage addStaticDatosTomador() {
		debugBegin();

		webDriver.moveToElementInFrame(btnAnadirDatosTomadorPantallaPrincipal, cuerpoFrame);
		webDriver.clickInFrame(btnAnadirDatosTomadorPantallaPrincipal, cuerpoFrame);

		webDriver.clickInFrame(txtFechaNacimiento, cuerpoFrame);
		webDriver.appendTextInFrame(txtFechaNacimiento, cuerpoFrame, "08/01/1979");

		webDriver.clickInFrame(rdnUtilizarMismaDireccionAsegurado, cuerpoFrame);

		webDriver.clickInFrame(btnAnadirDatosTomador, cuerpoFrame);
		webDriver.clickInFrame(btnAceptar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage AddTelefonosYHorariosAtencionTomador() {
		webDriver.clickInFrame(txtTelefonoFijo, cuerpoFrame);
		webDriver.appendTextInFrame(txtTelefonoFijo, cuerpoFrame, getTestVar(Constants.TELEFONO_FIJO_TOMADOR));

		webDriver.appendTextInFrame(txtPrefijoTelefonoFijo, cuerpoFrame, getTestVar(Constants.PREFIJO_TELEFONO_FIJO_TOMADOR));
		webDriver.clickInFrame(lblPrefijo, cuerpoFrame);

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

		webDriver.appendTextInFrame(txtTelefonoMovil, cuerpoFrame, getTestVar(Constants.TELEFONO_MOVIL_TOMADOR));

		webDriver.appendTextInFrame(txtTelefonoMovilPrefijo, cuerpoFrame, getTestVar(Constants.PREFIJO_TELEFONO_MOVIL_TOMADOR));
		webDriver.clickInFrame(lblPrefijo, cuerpoFrame);
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

	public TomadorYAseguradoPage clickOnContinuar() {
		debugBegin();
		webDriver.scrollToBottom();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public TomadorYAseguradoPage AddDatosTomadorDiferenteAsegurado() {
		debugBegin();
		
		if(getTestVar(Constants.ASEGURADO_DIFERENTE_TOMADOR)
			.equals(Constants.AseguradoPrincipalDiferenteTomador)) {
			webDriver.clickInFrame(cbkAseguradoDiferenteToamdor, cuerpoFrame);
			webDriver.moveToElementInFrame(btnAddDataOfTheAseguradoPrincipal, cuerpoFrame);
			webDriver.clickInFrame(btnAddDataOfTheAseguradoPrincipal, cuerpoFrame);
			webDriver.clickElementFromDropDownByTextInFrame(cbkAeguradoTipoDocumento, cuerpoFrame, Constants.NIF);

			setTestVar(Constants.DOCUMENTO_ASEGURADO, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(txtAseguradoNumeroDocumento, cuerpoFrame, getTestVar(Constants.DOCUMENTO_ASEGURADO));
			webDriver.appendTextInFrame(txtAseguradoNombre, cuerpoFrame, getTestVar(Constants.NOMBRE_ASEGURADO));
			webDriver.appendTextInFrame(txtAseguradoApellido1, cuerpoFrame, getTestVar(Constants.PRIMER_APELLIDO_ASEGURADO));
			webDriver.appendTextInFrame(txtAseguradoApellido2, cuerpoFrame, getTestVar(Constants.SEGUNDO_APELLIDO_ASEGURADO));
			webDriver.clickInFrame(rdnUtilizarMismaDireccionAsegurado, cuerpoFrame);
			webDriver.clickInFrame(btnAddAseguradoPrincipalModalWindow, cuerpoFrame);
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}
	// endregion
}
