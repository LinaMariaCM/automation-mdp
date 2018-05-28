package com.project.pages;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.project.ProjectConstants;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasDetallesRiesgoPage extends PageObject {

	// region webelements
	@FindBy(name = "cuerpo")
	private By cuerpoFrame;

	@FindBy(name = "botonContinuar")
	private List<WebElement> btnContinuarList;
	// private By btnContinuarList;

	@FindBy(name = "botonContinuar")
	private By btnContinuar;

	@FindBy(id = "botonVolver")
	private By btnVolver;

	@FindBy(xpath = ".//*[text()='AVISO: Incurriendo en infraseguro, en caso de siniestro podrá aplicarse regla proporcional, ¿Está seguro?']")
	private List<WebElement> lblInfraseguroMsg;

	@FindBy(xpath = ".//*[text()='AVISO: Está asegurando el edificio por un valor muy superior al recomendado. ¿Está seguro? En caso de siniestro la indemnización se ajustará al valor del inmueble.']")
	private List<WebElement> lblSupraseguroMsg;

	@FindBy(xpath = ".//*[text()='Plantas de sótano > 10. Riesgo fuera de las normas de suscripción']")
	private List<WebElement> lblAvisoPeritajePlantasSotano;

	@FindBy(xpath = ".//*[text()='Peritaje: Debido a la antigüedad del edificio supera los 50 años, el riesgo debe ser peritado.']")
	// Peritaje: Debido a la antigüedad del edificio supera los 50 años, el
	// riesgo debe ser peritado.
	private By lblAvisoPeritajeYearGreaterThan50;

	@FindBy(xpath = ".//*[text()='Peritaje: Debido al capital de continente solicitado, el riesgo debe ser peritado. Una vez se finalice la peritación recibirá un mensaje informando de las acciones derivadas de ésta.']")
	private List<WebElement> lblAvisoPeritajeCapitalGreaterThan1500000;

	@FindBy(xpath = ".//*[text()='Plantas de sótano > 10. Riesgo fuera de las normas de suscripción']")
	private List<WebElement> lblAvisoPlantasSotano;

	@FindBy(xpath = ".//*[text()='Seleccionado un riesgo agravado. Riesgo fuera de las normas de suscripción ']")
	private List<WebElement> lblAvisoRiesgoAgravado;

	@FindBy(xpath = ".//*[text()='No se permite introducir comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año.']")
	private List<WebElement> lblAvisoComunidadesEnTramite;

	@FindBy(xpath = ".//*[text()='El capital de continente ha sido calculado en base a los datos publicados por la Oficina Virtual del Catastro; Mutua renuncia a la aplicación de la Regla Proporcional por infraseguro, siempre que los datos referentes a m2, calidad de la construcción y uso/destino de los departamentos del edificio sean correctos, y se aplique la revalorización automática anual de sumas aseguradas.']")
	private List<WebElement> lblAvisoLegalCatasatro;

	@FindBy(xpath = ".//*[text()='Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.']")
	private List<WebElement> lblAvisoNumeroPlantasAlto;

	@FindBy(xpath = ".//*[text()='Dado que el número de plantas en alto (plantas) > 20, el proyecto debe ser revisado por compañía.']")
	private By lblAvisoNumeroPlantasAlto1;

	@FindBy(xpath = ".//*[text()='Debido a que se ha modificado el año de construcción y no coincide con catastro, el proyecto debe ser revisado por compañía . Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante']")
	private List<WebElement> lblAvisoModificacionAnyoConstruccion;

	@FindBy(xpath = ".//*[text()='Debido a que se ha modificado el año de rehabilitación integral y el año de rehabilitación de conducciones comunitarias, el proyecto debe ser revisado por la compañía. Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante.']")
	// private List<WebElement> lblAvisoModificacionRehabilitacionIntegral;
	private By lblAvisoModificacionRehabilitacionIntegral = By
		.xpath(".//*[text()='Debido a que se ha modificado el año de rehabilitación integral y el año de rehabilitación de conducciones comunitarias, el proyecto debe ser revisado por la compañía. Hasta que no sea validado la impresión queda bloqueada y el precio no es vinculante.']");

	@FindBy(xpath = ".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']")
	private By lblAvisoRiesgoYaAsegurado = By.xpath(".//*[text()='AVISO: El mismo riesgo ya se encuentra asegurado en Mutua de propietarios.']");

	
	private By loaderModal = By.cssSelector("#modalLoader");
	private By procesandoWindow = By.cssSelector(".smallbox");
	
	// endregion

	// public ValidacionExcepcionesReglasDetallesRiesgoPage(BrowserContext
	// browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	//
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }

	public ValidacionExcepcionesReglasDetallesRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public boolean checkContinuarAvailability() throws IOException {
		debugBegin();
		
		boolean value = false;

		value = this.webDriver.isPresentInFrame(this.btnContinuar, this.cuerpoFrame);
		
		debugEnd();
		return value;
	}

	public void clickOnContinuar() throws IOException {
		debugBegin();
		// Added if statement as the riesgo ya asegurado messaage only appears
		// if we launch the same test twice or more in the same day.
		if(this.webDriver.isPresentInFrame(this.lblAvisoRiesgoYaAsegurado, this.cuerpoFrame)) {
			this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		}
		
		debugEnd();
	}

	public void ClickOnContinuarAndValidate() throws IOException {
		debugBegin();

		// this.browserContext.getTestCaseData().setInfraseguro(false);
		this.webDriver.waitWithDriver(1000);
		this.webDriver.waitForElementNotToBeClickable(this.loaderModal);
		this.webDriver.waitForElementNotToBeClickable(this.procesandoWindow);
		//this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(1000);
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);

		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "InfraSeguro"))
			&& !this.testDataM.getTestVar(testId, "deshabilitacion").equals("")
			&& !this.testDataM.getTestVar(testId, "edificioMadera").equals("")) {
			this.CheckInfraseguroMsg();
		}

		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "SupraSeguro"))
			&& !this.testDataM.getTestVar(testId, "deshabilitacion").equals("")
			&& !this.testDataM.getTestVar(testId, "edificioMadera").equals("")) {
			this.CheckSupraseguroMsg();
		}

		this.CheckAvisoConstructionYear();
		this.CheckAvisoRehabilitacionIntegralWithException();
		
		this.webDriver.waitForElementNotToBeClickable(this.loaderModal);
		this.webDriver.waitForElementNotToBeClickable(this.procesandoWindow);

		// this.CheckAvisoRehabilitacionIntegralYConstruccionesComunitarias();

//		if(this.btnContinuarList.size() == 1) {
//			this.webDriver.click(this.btnContinuarList.get(0));
//		}

		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		//this.webDriver.exitFrame();
		debugEnd();
	}

	public void CheckInfraseguroMsg() throws IOException {
		debugBegin();
		
		if(this.lblInfraseguroMsg.size() != 1) {
			// this.testDataM.setInfraseguroMessageAppeared(true);
			this.testDataM.setTestVar(testId, "InfraseguroMessageAppeared", "true");
			// throw new IOException("El aviso de que se está incurriendo en
			// infraseguro no ha aparecido");
		}
		
		debugEnd();
	}

	public void CheckSupraseguroMsg() throws IOException {
		debugBegin();
		
		if(this.lblSupraseguroMsg.size() != 1) {
			// this.testDataM.setSupraseguroMessageAppeared(true);
			this.testDataM.setTestVar(testId, "SupraseguroMessageAppeared", "true");
			// throw new IOException("El aviso de que se está incurriendo en
			// infraseguro no ha aparecido");
		}
		
		debugEnd();
	}

	public boolean CheckAvisoPeritajePlantasSotano() {
		debugBegin();
		
		boolean result = Integer.parseInt(this.testDataM.getTestVar(testId, "numeroPlantasSotano")) >= 6
			&& Integer.parseInt(this.testDataM.getTestVar(testId, "numeroPlantasSotano")) <= 10;

		debugEnd();
		return result;
	}

	public void CheckAviso(String aviso) {
		debugBegin();
		Assert.assertTrue("El aviso no aparece", this.webDriver.isPresentInFrame(By.xpath(".//*[contains(text(),'" + aviso + "')]"), this.cuerpoFrame));
		debugEnd();
	}

	public boolean CheckAvisoPeritajeConstructionYearGreaterThan50() {
		debugBegin();

		DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
		DateTime dateTime = DateTime.now(timeZone);
		int year = dateTime.year().get();

		debugEnd();
		return this.testDataM.getTestVar(testId, "construccion_edificio") != null
			&& year - Integer.valueOf(this.testDataM.getTestVar(testId, "construccion_edificio")) > 50;
	}

	public boolean CheckAvisoPeritajeCapitalContinenteGreaterThan15000000() {
		debugBegin();
		// if
		// (this.browserContext.getTestCaseData().getCapitalContinente().intValue()
		// > 15000000)
		// {
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		// Assert.assertTrue("EL mensaje de error que debía aparecer cuando el
		// capital continente es mayor de 15000000 no ha aparecido.",
		// this.lblAvisoPeritajeCapitalGreaterThan1500000.size() == 1);
		// }
		debugEnd();
		return Integer.parseInt(this.testDataM.getTestVar(testId, "capitalContinente")) > 15000000;
	}

	// public void CheckAvisoPlantasSotano()
	// {
	// logger.debug("BEGIN - CheckAvisoPlantasSotano");
	// if
	// (Integer.parseInt(this.browserContext.getTestCaseData().getNumeroPlantasSotano())
	// > 10)
	// {
	// this.webDriver.switchToFrame(this.cuerpoFrame);
	// Assert.assertTrue("EL mensaje de error que debía aparecer cuando hay más
	// de 10 plantas de sotano no ha aparecido.",
	// this.lblAvisoPlantasSotano.size() == 1);
	// }
	// logger.debug("END - CheckAvisoPlantasSotano");
	// }

	public boolean CheckAvisoPlantasSotanoMoreThan10() {
		debugBegin();
		
		boolean result = Integer.parseInt(this.testDataM.getTestVar(testId, "num_plantas_sotano")) > 10;
		
		debugEnd();
		return result;
	}

	// public void CheckAvisoRiesgoAgravado()
	// {
	// logger.debug("BEGIN - CheckAvisoRiesgoAgravado");
	// if (this.browserContext.getTestCaseData().isGasolineraMenos50M())
	// {
	// this.webDriver.switchToFrame(this.cuerpoFrame);
	// Assert.assertTrue("EL mensaje de error que debía aparecer cuando hay una
	// gasolinera a menos de 50 metros no ha aparecido.",
	// this.lblAvisoRiesgoAgravado.size() == 1);
	// }
	// logger.debug("END - CheckAvisoRiesgoAgravado");
	// }

	public boolean CheckAvisoRiesgoAgravado() {
		debugBegin();
		
		boolean result = Boolean.parseBoolean(this.testDataM.getTestVar(testId, "GasolineraMenos50M"));
		
		debugEnd();
		return result;
	}

	public void CheckAvisoComuniadesEnTramite() {
		debugBegin();
		if(this.testDataM.getTestVar(testId, "tomador").equals(ProjectConstants.AvisoComunidadesEnTramite)) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			Assert.assertTrue(
				"EL mensaje de error que debía aparecer cuando se introducen comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año no ha aparecido.", 
				this.lblAvisoComunidadesEnTramite.size() == 1);
		}
		debugEnd();
	}

	public void CheckAvisoPlantasAlto() {
		debugBegin();
		if(Integer.parseInt(this.testDataM.getTestVar(testId, "num_plantas_alto")) > 20) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			Assert.assertTrue("El mensaje de error que debía aparecer cuando se introduce un número de plantas en alto mayor de 20 no ha aparecido.", this.lblAvisoNumeroPlantasAlto.size() == 1);
		}
		debugEnd();
	}

	public void CheckAvisoPlantasAltoYContinuar() {
		debugBegin();
		if(this.webDriver.isPresentInFrame(this.lblAvisoNumeroPlantasAlto1, this.cuerpoFrame)) {
			System.out.println("El riesgo necesita ser revisado por el numero de plantas en alto");
			this.webDriver.clickInFrame(this.btnVolver, this.cuerpoFrame);
		}
		debugEnd();
	}

	/*
	 * public boolean
	 * CheckAvisoRehabilitacionIntegralYConstruccionesComunitarias() {
	 * logger.debug("BEGIN - CheckAvisoRehabilitacionIntegral"); if
	 * (!(this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias() != null)
	 * && this.testDataM.getNivelRehabilitacionConduccionesAguasComunitarias() !=
	 * null || this.testDataM.getAnyoRehabilitacionIntegral() != null) {
	 * System.out.println("***1"); if
	 * (this.lblAvisoModificacionRehabilitacionIntegral.size() == 1) {
	 * System.out.println("***2");
	 * this.testDataM.setAnyoRehabilitacionConstruccionesComunitariasMessage(true);
	 * return true; } } logger.debug("END - CheckAvisoRehabilitacionIntegral");
	 * return false; }
	 */

	// public boolean CheckAvisoRehabilitacionIntegralWithException()
	// {
	// logger.debug("BEGIN - CheckAvisoRehabilitacionIntegral");
	// if (!(this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias() !=
	// null)
	// && this.testDataM.getNivelRehabilitacionConduccionesAguasComunitarias() !=
	// null || this.testDataM.getAnyoRehabilitacionIntegral() != null)
	// {
	// System.out.println("***3");
	// Assert.assertTrue(MutuaPropietariosConstants.AvisoModificacionRehabilitacionIntegralNotPressent,
	// this.testDataM.isAnyoRehabilitacionConstruccionesComunitariasMessage());
	// return true;
	//
	// }
	//
	// logger.debug("END - CheckAvisoRehabilitacionIntegral");
	// return false;
	// }

	public boolean CheckAvisoRehabilitacionIntegralWithException() {
		debugBegin();
		if(this.testDataM.getTestVar(testId, "nivel_rehab_aguas_comun") != null) {
			if(!this.webDriver.isPresent(this.lblAvisoModificacionRehabilitacionIntegral)) {
				Assert.assertTrue(ProjectConstants.AvisoModificacionRehabilitacionIntegralNotPressent, Boolean
					.parseBoolean(this.testDataM.getTestVar(testId, "AnyoRehabilitacionConstruccionesComunitariasMessage")));
				return true;
			}
		}

		debugEnd();
		return false;
	}

	public boolean CheckAvisoConstructionYear() {
		debugBegin();
		// if (!this.testDataM.getAnyoConstruccion().equals("-1"))
		if(this.testDataM.getTestVar(testId, "construccion_edificio") != null) {
			if(this.lblAvisoModificacionAnyoConstruccion.size() == 1) {
				this.testDataM.setTestVar(testId, "construccion_edificio", "true");
				return true;
			}
		}

		debugEnd();
		return false;
	}

	public void CheckAvisoConstructionYearWithException() {
		debugBegin();
		if(!this.testDataM.getTestVar(testId, "construccion_edificio").equals("-1")) {
			if(this.lblAvisoModificacionAnyoConstruccion.size() == 1) {
				Assert.assertTrue(ProjectConstants.AvisoModificacionAnyoConstruccionNotPressent, this.lblAvisoModificacionAnyoConstruccion.get(0).isDisplayed());
			}
		}
		debugEnd();
	}

	// endregion

	// public boolean CheckAvisoAnyoRehabilitacionConduccionesComunitarias()
	// {
	// logger.debug("BEGIN -
	// CheckAvisoAnyoRehabilitacionConduccionesComunitarias");
	// if
	// (!this.testDataM.getAnyoRehabilitacionConstruccionesComunitarias().equals(null))
	// {
	// if (this.lblAvisoModificacionAnyoConstruccion.size() == 1)
	// {
	// this.testDataM.setAnyoRehabilitacionConstruccionesComunitariasMessage(true);
	// return true;
	// }
	// }
	// logger.debug("END -
	// CheckAvisoAnyoRehabilitacionConduccionesComunitarias");
	// return false;
	// }
}
