package com.project.pages;

import java.io.IOException;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.ProjectConstants;
import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ValidacionExcepcionesReglasDetallesRiesgoPage {
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

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

	public ValidacionExcepcionesReglasDetallesRiesgoPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public boolean checkContinuarAvailability() throws IOException {
		boolean value = false;

		logger.debug("BEGIN - checkContinuarAvailability");
		value = this.webDriver.isPresentInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - checkContinuarAvailability");
		return value;
	}

	public void clickOnContinuar() throws IOException {
		logger.debug("BEGIN - checkContinuarAvailability");
		// Added if statement as the riesgo ya asegurado messaage only appears
		// if we launch the same test twice or more in the same day.
		if(this.webDriver.isPresentInFrame(this.lblAvisoRiesgoYaAsegurado, this.cuerpoFrame)) {
			this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		}
		logger.debug("END - checkContinuarAvailability");
	}

	public void ClickOnContinuarAndValidate() throws IOException {
		logger.debug("BEGIN - ClickOnContinuarButton");

		// this.browserContext.getTestCaseData().setInfraseguro(false);
		this.webDriver.waitWithDriver(3000);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(3000);
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts(5);

		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "InfraSeguro"))
			&& !this.tCData.getTestVar(testId, "deshabilitacion").equals("")
			&& !this.tCData.getTestVar(testId, "edificioMadera").equals("")) {
			this.CheckInfraseguroMsg();
		}

		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "SupraSeguro"))
			&& !this.tCData.getTestVar(testId, "deshabilitacion").equals("")
			&& !this.tCData.getTestVar(testId, "edificioMadera").equals("")) {
			this.CheckSupraseguroMsg();
		}

		this.CheckAvisoConstructionYear();
		this.CheckAvisoRehabilitacionIntegralWithException();
		// this.CheckAvisoRehabilitacionIntegralYConstruccionesComunitarias();

		if(this.btnContinuarList.size() == 1) {
			this.webDriver.click(this.btnContinuarList.get(0));
		}

		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		this.webDriver.exitFrame();
		logger.debug("END - ClickOnContinuarButton");
	}

	public void CheckInfraseguroMsg() throws IOException {
		logger.debug("BEGIN - CheckInfraseguroMsg");
		if(this.lblInfraseguroMsg.size() != 1) {
			// this.tCData.setInfraseguroMessageAppeared(true);
			this.tCData.setTestVar(testId, "InfraseguroMessageAppeared", "true");
			// throw new IOException("El aviso de que se está incurriendo en
			// infraseguro no ha aparecido");
		}
		logger.debug("END - CheckInfraseguroMsg");
	}

	public void CheckSupraseguroMsg() throws IOException {
		logger.debug("BEGIN - CheckSupraseguroMsg");
		if(this.lblSupraseguroMsg.size() != 1) {
			// this.tCData.setSupraseguroMessageAppeared(true);
			this.tCData.setTestVar(testId, "SupraseguroMessageAppeared", "true");
			// throw new IOException("El aviso de que se está incurriendo en
			// infraseguro no ha aparecido");
		}
		logger.debug("END - CheckSupraseguroMsg");
	}

	public boolean CheckAvisoPeritajePlantasSotano() {
		logger.debug("BEGIN - CheckAvisoPeritajePlantasSotano");
		logger.debug("END - CheckAvisoPeritajePlantasSotano");
		return Integer.parseInt(this.tCData.getTestVar(testId, "numeroPlantasSotano")) >= 6
			&& Integer.parseInt(this.tCData.getTestVar(testId, "numeroPlantasSotano")) <= 10;
	}

	public void CheckAviso(
		String aviso) {
		logger.debug("BEGIN - CheckAviso");
		Assert.assertTrue("El aviso no aparece", this.webDriver.isPresentInFrame(By.xpath(".//*[contains(text(),'" + aviso + "')]"), this.cuerpoFrame));
		logger.debug("END - CheckAviso");
	}

	public boolean CheckAvisoPeritajeConstructionYearGreaterThan50() {
		logger.debug("BEGIN - CheckAvisoPeritajeConstructionYearGreaterThan50");

		DateTimeZone timeZone = DateTimeZone.forID("Europe/Madrid");
		DateTime dateTime = DateTime.now(timeZone);
		int year = dateTime.year().get();

		logger.debug("END - CheckAvisoPeritajeConstructionYearGreaterThan50");
		return this.tCData.getTestVar(testId, "construccion_edificio") != null
			&& year - Integer.valueOf(this.tCData.getTestVar(testId, "construccion_edificio")) > 50;
	}

	public boolean CheckAvisoPeritajeCapitalContinenteGreaterThan15000000() {
		logger.debug("BEGIN - CheckErrorCapitalContinenteGreaterThan15000000");
		// if
		// (this.browserContext.getTestCaseData().getCapitalContinente().intValue()
		// > 15000000)
		// {
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		// Assert.assertTrue("EL mensaje de error que debía aparecer cuando el
		// capital continente es mayor de 15000000 no ha aparecido.",
		// this.lblAvisoPeritajeCapitalGreaterThan1500000.size() == 1);
		// }
		logger.debug("END - lblErrorCapitalGreaterThan1500000");
		return Integer.parseInt(this.tCData.getTestVar(testId, "capitalContinente")) > 15000000;
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
		logger.debug("BEGIN - CheckAvisoPlantasSotanoMoreThan10");
		logger.debug("END - CheckAvisoPlantasSotanoMoreThan10");
		return Integer.parseInt(this.tCData.getTestVar(testId, "num_plantas_sotano")) > 10;
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
		logger.debug("BEGIN - CheckAvisoRiesgoAgravado");
		logger.debug("END - CheckAvisoRiesgoAgravado");
		return Boolean.parseBoolean(this.tCData.getTestVar(testId, "GasolineraMenos50M"));
	}

	public void CheckAvisoComuniadesEnTramite() {
		logger.debug("BEGIN - CheckAvisoComuniadesEnTramite");
		if(this.tCData.getTestVar(testId, "tomador").equals(ProjectConstants.AvisoComunidadesEnTramite)) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			Assert
				.assertTrue("EL mensaje de error que debía aparecer cuando se introducen comunidades en trámite cuando el edificio tiene antigüedad superior a 1 año no ha aparecido.", this.lblAvisoComunidadesEnTramite
					.size() == 1);
			logger.debug("END - CheckAvisoComuniadesEnTramite");
		}
	}

	public void CheckAvisoPlantasAlto() {
		logger.debug("BEGIN - CheckAvisoPlantasAlto");
		if(Integer.parseInt(this.tCData.getTestVar(testId, "num_plantas_alto")) > 20) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			Assert.assertTrue("El mensaje de error que debía aparecer cuando se introduce un número de plantas en alto mayor de 20 no ha aparecido.", this.lblAvisoNumeroPlantasAlto.size() == 1);
			logger.debug("END - CheckAvisoPlantasAlto");
		}
	}

	public void CheckAvisoPlantasAltoYContinuar() {
		logger.debug("BEGIN - CheckAvisoPlantasAltoYContinuar");
		if(this.webDriver.isPresentInFrame(this.lblAvisoNumeroPlantasAlto1, this.cuerpoFrame)) {
			System.out.println("El riesgo necesita ser revisado por el numero de plantas en alto");
			this.webDriver.clickInFrame(this.btnVolver, this.cuerpoFrame);
		}
		logger.debug("END - CheckAvisoPlantasAltoYContinuar");
	}

	/*
	 * public boolean
	 * CheckAvisoRehabilitacionIntegralYConstruccionesComunitarias() {
	 * logger.debug("BEGIN - CheckAvisoRehabilitacionIntegral"); if
	 * (!(this.tCData.getAnyoRehabilitacionConstruccionesComunitarias() != null)
	 * && this.tCData.getNivelRehabilitacionConduccionesAguasComunitarias() !=
	 * null || this.tCData.getAnyoRehabilitacionIntegral() != null) {
	 * System.out.println("***1"); if
	 * (this.lblAvisoModificacionRehabilitacionIntegral.size() == 1) {
	 * System.out.println("***2");
	 * this.tCData.setAnyoRehabilitacionConstruccionesComunitariasMessage(true);
	 * return true; } } logger.debug("END - CheckAvisoRehabilitacionIntegral");
	 * return false; }
	 */

	// public boolean CheckAvisoRehabilitacionIntegralWithException()
	// {
	// logger.debug("BEGIN - CheckAvisoRehabilitacionIntegral");
	// if (!(this.tCData.getAnyoRehabilitacionConstruccionesComunitarias() !=
	// null)
	// && this.tCData.getNivelRehabilitacionConduccionesAguasComunitarias() !=
	// null || this.tCData.getAnyoRehabilitacionIntegral() != null)
	// {
	// System.out.println("***3");
	// Assert.assertTrue(MutuaPropietariosConstants.AvisoModificacionRehabilitacionIntegralNotPressent,
	// this.tCData.isAnyoRehabilitacionConstruccionesComunitariasMessage());
	// return true;
	//
	// }
	//
	// logger.debug("END - CheckAvisoRehabilitacionIntegral");
	// return false;
	// }

	public boolean CheckAvisoRehabilitacionIntegralWithException() {
		logger.debug("BEGIN - CheckAvisoRehabilitacionIntegral");
		if(this.tCData.getTestVar(testId, "nivel_rehab_aguas_comun") != null) {
			if(!this.webDriver.isPresent(this.lblAvisoModificacionRehabilitacionIntegral)) {
				Assert.assertTrue(ProjectConstants.AvisoModificacionRehabilitacionIntegralNotPressent, Boolean
					.parseBoolean(this.tCData.getTestVar(testId, "AnyoRehabilitacionConstruccionesComunitariasMessage")));
				return true;
			}
		}

		logger.debug("END - CheckAvisoRehabilitacionIntegral");
		return false;
	}

	public boolean CheckAvisoConstructionYear() {
		logger.debug("BEGIN - CheckAvisoConstrucionYear");
		// if (!this.tCData.getAnyoConstruccion().equals("-1"))
		if(this.tCData.getTestVar(testId, "construccion_edificio") != null) {
			if(this.lblAvisoModificacionAnyoConstruccion.size() == 1) {
				this.tCData.setTestVar(testId, "construccion_edificio", "true");
				return true;
			}
		}

		logger.debug("END - CheckAvisoConstrucionYear");
		return false;
	}

	public void CheckAvisoConstructionYearWithException() {
		logger.debug("BEGIN - CheckAvisoConstructionYearWithException");
		if(!this.tCData.getTestVar(testId, "construccion_edificio").equals("-1")) {
			if(this.lblAvisoModificacionAnyoConstruccion.size() == 1) {
				Assert.assertTrue(ProjectConstants.AvisoModificacionAnyoConstruccionNotPressent, this.lblAvisoModificacionAnyoConstruccion.get(0).isDisplayed());
			}
		}
		logger.debug("END - CheckAvisoConstructionYearWithException");
	}

	// endregion

	// public boolean CheckAvisoAnyoRehabilitacionConduccionesComunitarias()
	// {
	// logger.debug("BEGIN -
	// CheckAvisoAnyoRehabilitacionConduccionesComunitarias");
	// if
	// (!this.tCData.getAnyoRehabilitacionConstruccionesComunitarias().equals(null))
	// {
	// if (this.lblAvisoModificacionAnyoConstruccion.size() == 1)
	// {
	// this.tCData.setAnyoRehabilitacionConstruccionesComunitariasMessage(true);
	// return true;
	// }
	// }
	// logger.debug("END -
	// CheckAvisoAnyoRehabilitacionConduccionesComunitarias");
	// return false;
	// }
}
