package com.amaris.project.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.openqa.selenium.By;
import com.amaris.project.Constants;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ValidacionExcepcionesReglasDetallesRiesgoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");

	private By btnContinuar = By.name("botonContinuar");
	private By btnVolver = By.id("botonVolver");

	private By lblInfraseguroMsg = By.xpath(".//*[text()='AVISO: Incurriendo en infraseguro, en caso de siniestro podrá aplicarse regla proporcional, ¿Está seguro?']");
	private By lblSupraseguroMsg = By
		.xpath(".//*[text()='AVISO: Está asegurando el edificio por un valor muy superior al recomendado. ¿Está seguro? En caso de siniestro la indemnización se ajustará al valor del inmueble.']");
	private By lblAvisoPeritajePlantasSotano = By.xpath(".//*[text()='Plantas de sótano > 10. Riesgo fuera de las normas de suscripción']");
	private By lblAvisoPeritajeYearGreaterThan50 = By.xpath(".//*[text()='Peritaje: Debido a la antigüedad del edificio supera los 50 años, el riesgo debe ser peritado.']");
	private By lblAvisoPeritajeCapitalGreaterThan1500000 = By
		.xpath(".//*[text()='Peritaje: Debido al capital de continente solicitado, el riesgo debe ser peritado. Una vez se finalice la peritación recibirá un mensaje informando de las acciones derivadas de ésta.']");
	private By lblAvisoPlantasSotano = By.xpath(".//*[text()='Plantas de sótano > 10. Riesgo fuera de las normas de suscripción']");
	private By lblAvisoRiesgoAgravado = By.xpath(".//*[text()='Seleccionado un riesgo agravado. Riesgo fuera de las normas de suscripción ']");
	private By lblAvisoComunidadesEnTramite = By.xpath(".//*[text()='No se permite introducir comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año.']");
	private By lblAvisoLegalCatasatro = By
		.xpath(".//*[text()='El capital de continente ha sido calculado en base a los datos publicados por la Oficina Virtual del Catastro; Mutua renuncia a la aplicación de la Regla Proporcional por infraseguro, siempre que los datos referentes a m2, calidad de la construcción y uso/destino de los departamentos del edificio sean correctos, y se aplique la revalorización automática anual de sumas aseguradas.']");
	private By lblAvisoNumeroPlantasAlto = By.xpath(".//*[text()='Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.']");
	private By lblAvisoNumeroPlantasAlto1 = By.xpath(".//*[text()='Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.']");
	private By lblAvisoModificacionAnyoConstruccion = By
		.xpath(".//*[text()='Debido a que se ha modificado el año de construcción y no coincide con catastro, el proyecto debe ser revisado por compañía . Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante']");
	private By lblAvisoModificacionRehabilitacionIntegral = By
		.xpath(".//*[text()='Debido a que se ha modificado el año de rehabilitación integral y el año de rehabilitación de conducciones comunitarias, el proyecto debe ser revisado por la compañía. Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante.']");
	private By lblAvisoRiesgoYaAsegurado = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");
	private By lblAvisoDireccionNoNormalizada = By.xpath(".//*[text()='La dirección del riesgo no está normalizada']");

	private By loaderModal = By.cssSelector("#modalLoader");
	private By procesandoWindow = By.cssSelector(".smallbox");
	private By btnConvertirAProyecto = By.cssSelector("button[ng-click*='convertToProject']");
	private By procesando = By.cssSelector("#procesando");
	// endregion

	public ValidacionExcepcionesReglasDetallesRiesgoPage(UserStory userS) {
		super(userS);
	}
	
	
	public ValidacionExcepcionesReglasDetallesRiesgoPage waitProcesando() throws Exception {
		
		System.out.println("Espero a ver procesando...");
		webDriver.waitWithDriver(7000);
		
		while(this.webDriver.isPresent(procesando)) {
			System.out.println("Lo veo");
			webDriver.waitWithDriver(1500);
		}
		
		System.out.println("No veo procesando...");
		
		return this;
	}
	
	public boolean checkContinuarAvailability() {
		debugBegin();

		boolean value = false;

		value = webDriver.isPresentInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return value;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage clickOnContinuar() {
		debugBegin();
		// Added if statement as the riesgo ya asegurado messaage only appears
		// if we launch the same test twice or more in the same day.
		if(webDriver.isPresentInFrame(lblAvisoRiesgoYaAsegurado, cuerpoFrame)) {
			webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage ClickOnContinuarAndValidate() {
		debugBegin();

		setTestVar(Constants.INFRA_SEGURO, "false");
		webDriver.waitWithDriver(1000);
		webDriver.waitForElementNotToBeClickable(loaderModal);
		webDriver.waitForElementNotToBeClickable(procesandoWindow);
		webDriver.waitWithDriver(1000);
		
		if(!getScenarioVar(Constants.DESHABITACION).isEmpty() && !getScenarioVar(Constants.CONSTRUIDO_MADERA).isEmpty()) {
			if(Boolean.parseBoolean(getTestVar(Constants.INFRA_SEGURO))) {
				CheckInfraseguroMsg();
			}

			if(Boolean.parseBoolean(getTestVar(Constants.SUPRA_SEGURO))) {
				CheckSupraseguroMsg();
			}
		}

		
		CheckAvisoConstructionYear();
		CheckAvisoRehabilitacionIntegralWithException();
		
		webDriver.waitForElementNotToBeClickable(loaderModal);
		webDriver.waitForElementNotToBeClickable(procesandoWindow);
		
		/*if(webDriver.getElementsInFrame(btnContinuar, cuerpoFrame).size() == 1) {
			webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		}*/
		
		if(webDriver.getElementsInFrame(btnConvertirAProyecto, cuerpoFrame).size() == 1) {
			webDriver.clickInFrame(btnConvertirAProyecto, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckInfraseguroMsg() {
		debugBegin();

		if(webDriver.getElementsInFrame(lblInfraseguroMsg, cuerpoFrame).size() != 1) {
			// TODO revisar si aqui deberia de aparecer o no
			setTestVar(Constants.INFRA_SEGURO_MSG_APPEARED, "true");
			debugInfo("El aviso de que se está incurriendo en infraseguro ha aparecido");
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckSupraseguroMsg() {
		debugBegin();

		if(webDriver.getElementsInFrame(lblSupraseguroMsg, cuerpoFrame).size() != 1) {
			// TODO revisar si aqui deberia de aparecer o no
			setTestVar(Constants.SUPRA_SEGURO_MSG_APPEARED, "true");
			debugInfo("El aviso de que se está incurriendo en supraseguro ha aparecido");
		}

		debugEnd();

		return this;
	}

	public boolean CheckAvisoPeritajePlantasSotano() {
		debugBegin();

		boolean result = Integer.parseInt(getTestVar(Constants.NUM_PLANTAS_SOTANO)) >= 6
			&& Integer.parseInt(getTestVar(Constants.NUM_PLANTAS_SOTANO)) <= 10;

		debugEnd();

		return result;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAviso(String aviso) {
		debugBegin();
		Assert.assertTrue(webDriver.isPresentInFrame(By.xpath(".//*[contains(text(),'" + aviso + "')]"), cuerpoFrame), "El aviso no aparece");
		debugEnd();

		return this;
	}

	public boolean CheckAvisoPeritajeConstructionYearGreaterThan50() {
		debugBegin();

		int year = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(LocalDate.now()));

		debugEnd();

		return getTestVar(Constants.ANYO_CONSTRUIDO) != null
			&& year - Integer.valueOf(getTestVar(Constants.ANYO_CONSTRUIDO)) > 50;
	}

	public boolean CheckAvisoPeritajeCapitalContinenteGreaterThan15000000() {
		debugBegin();
		// if
		// (browserContext.getTestCaseData().getCapitalContinente().intValue()
		// > 15000000)
		// {
		// webDriver.switchToFrame(cuerpoFrame);
		// Assert.assertTrue("EL mensaje de error que debía aparecer cuando el
		// capital continente es mayor de 15000000 no ha aparecido.",
		// lblAvisoPeritajeCapitalGreaterThan1500000.size() == 1);
		// }
		debugEnd();

		return Integer.parseInt(getTestVar(Constants.CAPITAL_CONTINENTE)) > 15000000;
	}

	public boolean CheckAvisoPlantasSotanoMoreThan10() {
		debugBegin();

		boolean result = Integer.parseInt(getTestVar(Constants.NUM_PLANTAS_SOTANO)) > 10;

		debugEnd();

		return result;
	}

	public boolean CheckAvisoRiesgoAgravado() {
		debugBegin();

		boolean result = Boolean.parseBoolean(getTestVar(Constants.GASOLINERA_MENOS_50M));

		debugEnd();

		return result;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAvisoComuniadesEnTramite() {
		debugBegin();

		if(getTestVar(Constants.TOMADOR).equals(Constants.AvisoComunidadesEnTramite)) {
			webDriver.switchToFrame(cuerpoFrame);
			Assert.assertTrue(webDriver.getElementsInFrame(lblAvisoComunidadesEnTramite, cuerpoFrame)
				.size() == 1, "El mensaje de error que debía aparecer cuando se introducen comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año no ha aparecido.");
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAvisoPlantasAlto() {
		debugBegin();

		if(Integer.parseInt(getTestVar(Constants.NUM_PLANTAS_ALTO)) > 20) {
			webDriver.switchToFrame(cuerpoFrame);
			Assert.assertTrue(webDriver.getElementsInFrame(lblAvisoNumeroPlantasAlto, cuerpoFrame)
				.size() == 1, "El mensaje de error que debía aparecer cuando se introduce un número de plantas en alto mayor de 20 no ha aparecido.");
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAvisoPlantasAltoYContinuar() {
		debugBegin();

		if(webDriver.isPresentInFrame(lblAvisoNumeroPlantasAlto1, cuerpoFrame)) {
			debugInfo("El riesgo necesita ser revisado por el numero de plantas en alto");
			webDriver.clickInFrame(btnVolver, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public boolean CheckAvisoRehabilitacionIntegralWithException() {
		debugBegin();

		boolean result = false;

		if(getTestVar(Constants.NIVEL_REHAB_AGUAS) != null && !webDriver.isPresent(lblAvisoModificacionRehabilitacionIntegral)) {
			Assert.assertTrue(Boolean
				.parseBoolean(getTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES_MSG)), Constants.AvisoModificacionRehabilitacionIntegralNotPressent);
			result = true;
		}

		debugEnd();

		return result;
	}

	public boolean CheckAvisoConstructionYear() {
		debugBegin();

		boolean result = false;

		if(getTestVar(Constants.ANYO_CONSTRUIDO) != null
			&& webDriver.getElementsInFrame(lblAvisoModificacionAnyoConstruccion, cuerpoFrame).size() == 1) {
			setTestVar(Constants.ANYO_CONSTRUIDO_MSG, "true");
			result = true;
		}

		debugEnd();

		return result;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAvisoConstructionYearWithException() {
		debugBegin();

		if(Constants.ANYO_CONSTRUIDO != null && !getTestVar(Constants.ANYO_CONSTRUIDO).equals("-1")
			&& webDriver.getElementsInFrame(lblAvisoModificacionAnyoConstruccion, cuerpoFrame).size() == 1) {
			Assert.assertTrue(webDriver.getElementsInFrame(lblAvisoModificacionAnyoConstruccion, cuerpoFrame)
				.get(0).isDisplayed(), Constants.AvisoModificacionAnyoConstruccionNotPressent);
		}

		debugEnd();

		return this;
	}

	public ValidacionExcepcionesReglasDetallesRiesgoPage CheckAvisoDireccionNoNormalizada() {
		debugBegin();

		if(getTestVar(Constants.INMUEBLE).equals(Constants.DireccionNoNormalizada)) {
			debugInfo("Direccion no normalizada");
			Assert.assertTrue(webDriver.isPresentInFrame(lblAvisoDireccionNoNormalizada, cuerpoFrame),
				"El aviso que la dirección no está normalizada no ha aparecido.");
		}

		debugEnd();

		return this;
	}
	// endregion
}
