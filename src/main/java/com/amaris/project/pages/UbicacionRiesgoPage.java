package com.amaris.project.pages;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.By;

import org.openqa.selenium.UnhandledAlertException;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class UbicacionRiesgoPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	// @FindBy(xpath = ".//*[text()='Añadir inmueble' and
	// @ng-click='ur.addInmueble()' and
	// @ng-disabled='ur.disableAddInmuebleButton']")
	private By btnAnadirInmueblePantallaPrincipal = By.xpath(".//*[text()='Añadir inmueble' and @ng-click='ur.addInmueble()' and @ng-disabled='ur.disableAddInmuebleButton']");

	// @FindBy(xpath = ".//*[@id='inmuebleModal']/div/div/div[3]/button[1]")
	private By btnCancelar = By.xpath(".//*[@id='inmuebleModal']/div/div/div[3]/button[1]");

	// @FindBy(id = "critCatastro")
	private By radioBtnCriterioBusquedaReferenciaCatastral = By.id("critCatastro");

	// @FindBy(name = "refCatastral")
	private By txtReferenciaCatastral = By.name("refCatastral");

	// @FindBy(xpath = ".//*[text()='Buscar']")
	private By btnBuscar = By.xpath(".//*[text()='Buscar']");

	// @FindBy(xpath = ".//*[@ng-click='ur.modalBuscador.updateInmueble()' and
	// text()='Añadir inmueble']")
	// private By btnAnadirInmuebleReferenciaCatastral =
	// By.xpath(".//*[@ng-click='ur.modalBuscador.updateInmueble()' and
	// text()='Añadir inmueble']");
	private By btnAnadirInmueble = By.cssSelector(".modal-lg > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)");

	// @FindBy(xpath = ".//*[@ng-model='ur.inmueble.data.asegurarGarajes']")
	private By chkAsegurarUnicamenteGarajes = By.xpath(".//*[@ng-model='ur.inmueble.data.asegurarGarajes']");

	// @FindBy(xpath = ".//*[@ng-model='ur.inmueble.data.excluirGarajes']")
	private By chkExcluirGarajes = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirGarajes']");

	// @FindBy(xpath = ".//*[@ng-model='ur.inmueble.data.excluirLocales']")
	private By chkExcluirLocales = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirLocales']");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	// @FindBy(xpath = ".//*[@ng-click='ur.save(ubicacionRiesgoForm.$valid)']")
	private By btnGuardar = By.xpath(".//*[@ng-click='ur.save(ubicacionRiesgoForm.$valid)']");

	// @FindBy(name = "provincia")
	private By txtProvincia = By.name("provincia");

	// @FindBy(name = "poblacion")
	private By txtPoblacion = By.name("poblacion");

	// @FindBy(name = "nombreVia")
	private By txtNombreVia = By.name("nombreVia");

	// @FindBy(name = "numVia")
	private By txtNumeroVia = By.name("numVia");

	// @FindBy(name = "codigoPostal")
	private By txtCodigoPostal = By.name("codigoPostal");

	// @FindBy(xpath = ".//*[@tabindex='-1' and
	// contains(@ng-bind-html,'match.label')]")
	private By lblMatchFoundElement = By.xpath(".//*[@tabindex='-1' and contains(@ng-bind-html,'match.label')]");

	// @FindBy(xpath = ".//*[contains(@ng-bind-html,'match.model.street') and
	// contains(@ng-bind-html,'|')]")
	private By lblMatchFoundElementVia = By.xpath(".//*[contains(@ng-bind-html,'match.model.street') and contains(@ng-bind-html,'|')]");

	// @FindBy(xpath = ".//*[text()='Al acceder en modo modificación las
	// retenciones que su perfil lo permitan quedarán aceptadas de manera
	// automática en cada paso.']")
	private By txtAvisoSistema = By.xpath(".//*[text()='Al acceder en modo modificación las retenciones que su perfil lo permitan quedarán aceptadas de manera automática en cada paso.']");

	// @FindBy(xpath = ".//*[text()='Aceptar']")
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");

	// @FindBy(xpath = ".//*[contains(@class,'glyphicon-pencil')]")
	private By btnModificarReferenciaCatastral = By.xpath(".//*[contains(@class,'glyphicon-pencil')]");

	// @FindBy(xpath = ".//*[text()='Modificar inmueble' and
	// @ng-click='ur.modalBuscador.updateInmueble()']")
	private By btnModificarInmueble = By.xpath(".//*[text()='Modificar inmueble' and @ng-click='ur.modalBuscador.updateInmueble()']");

	// @FindBy(xpath =
	// ".//*[contains(@ng-bind-html,'inmuebleSeleccionado.data.refCatastral')]")
	private By txtCurrentReferenciaCatastral = By.xpath(".//*[contains(@ng-bind-html,'inmuebleSeleccionado.data.refCatastral')]");

	// @FindBy(name = "calidadConstruccion")
	private By cbkCalidadConstruccion = By.name("calidadConstruccion");

	// @FindBy(xpath = ".//*[@ng-click='ur.editInmueble()']")
	private By btnLapiz = By.xpath(".//*[@ng-click='ur.editInmueble()']");

	// @FindBy(xpath =
	// ".//*[@id='inmuebleModal']/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]")
	private By resultadoBusqueda = By.xpath(".//*[@id='inmuebleModal']/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]");

	// @FindBy(xpath = "//*[@id='modalErrores']/div/div/div[2]/div/div/p")
	private By mensajeModalError = By.xpath("//*[@id='modalErrores']/div/div/div[2]/div/div/p");

	// @FindBy(xpath = "//*[@id='modalErrores']/div/div/div[3]/button")
	private By btnModalError = By.xpath("//*[@id='modalErrores']/div/div/div[3]/button");

	// @FindBy(css = "p[ng-bind-html='modalErrores.text | encode']")
	private By txtMensajeError = By.xpath("p[ng-bind-html='modalErrores.text | encode']");

	private By loaderModal = By.cssSelector("#modalLoader");

	// endregion
	/*
	 * public UbicacionRiesgoPage(BrowserContext browserContext) {
	 * this.browserContext = browserContext; this.wh =
	 * browserContext.webElementHelper; this.tData =
	 * browserContext.getTestCaseData();
	 * PageFactory.initElements(browserContext.getWebDriver(), this); }
	 */

	public UbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	public boolean fillInmuebleAndGetAvailability(String scenario) throws InterruptedException {

		// return
		// this.addInmueble(this.browserContext.getTestCaseData().getInmueble());
		return this.addInmueble(getScenarioVar("inmueble"));
	}

	public void fillInmuebleAndClickOnContinue(String scenario) throws InterruptedException {
		// this.addInmueble(this.browserContext.getTestCaseData().getInmueble());

		this.fillInmuebleAndGetAvailability(scenario);
		this.clickOnContinuar();
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	///// region methods
	/////////////////////////////////////////////////////////////////////////////////////////

	public boolean addInmueble(String inmueble) throws InterruptedException {
		debugBegin();

		boolean value = false;

		if(inmueble != null && !inmueble.isEmpty()) {
			value = this.addInmuebleByAddress();
		} else {// value =
				// this.addInmuebleByReferenciaCatastral(this.browserContext.getTestCaseData().getReferenciaCatastral());
			value = this.addInmuebleByReferenciaCatastral(getData("fichero_referencias").getValue(userS.getScenario(), "ref_catastral"));
		}
		/*
		 * switch (inmueble) { case
		 * MutuaPropietariosConstants.ReferenciaCatastralPorDefecto:
		 * System.out.println("Primer case"); value =
		 * this.addInmuebleByReferenciaCatastral(this.browserContext.
		 * getTestCaseData().getReferenciaCatastral()); break; case
		 * MutuaPropietariosConstants.DireccionPorDefecto:
		 * System.out.println("Segundo case"); value =
		 * this.addInmuebleByAddress(); break; }
		 */

		debugEnd();

		return value;
	}

	public boolean addInmuebleByAddress() throws InterruptedException {
		debugBegin();
		this.webDriver.waitForPageToLoad();
		// this.webDriver.moveToElementInFrameWithJavaScript(this.btnAnadirInmueblePantallaPrincipal,
		// this.cuerpoFrame);

		this.webDriver.clickInFrame(this.btnAnadirInmueblePantallaPrincipal, this.cuerpoFrame);

		/*
		 * this.webDriver.appendTextInFrame(this.txtProvincia, this.cuerpoFrame,
		 * String.valueOf(this.browserContext.getTestCaseData().
		 * getDireccionProvincia()));
		 */
		this.webDriver.appendTextInFrame(this.txtProvincia, this.cuerpoFrame, String.valueOf(getTestVar("direccion_provinvia")));

		this.webDriver.clickInFrame(this.lblMatchFoundElement, this.cuerpoFrame);

		/*
		 * this.webDriver.appendTextInFrame(this.txtPoblacion, this.cuerpoFrame,
		 * String.valueOf(this.browserContext.getTestCaseData().
		 * getDireccionPoblacion()));
		 */
		this.webDriver.appendTextInFrame(this.txtPoblacion, this.cuerpoFrame, String.valueOf(getTestVar("direccion_poblacion")));

		this.webDriver.clickInFrame(this.lblMatchFoundElement, this.cuerpoFrame);

		/*
		 * this.webDriver.appendTextInFrame(this.txtNombreVia, this.cuerpoFrame,
		 * String.valueOf(this.browserContext.getTestCaseData().
		 * getDireccionNombreVia()));
		 */
		this.webDriver.appendTextInFrame(this.txtNombreVia, this.cuerpoFrame, String.valueOf(getTestVar("direccion_nombre_via")));

		this.webDriver.clickInFrame(this.lblMatchFoundElementVia, this.cuerpoFrame);

		/*
		 * this.webDriver.appendTextInFrame(this.txtNumeroVia, this.cuerpoFrame,
		 * String.valueOf(this.browserContext.getTestCaseData().
		 * getDireccionNumeroVia()));
		 */
		this.webDriver.appendTextInFrame(this.txtNumeroVia, this.cuerpoFrame, String.valueOf(getTestVar("direccion_numero_via")));

		/*
		 * this.webDriver.appendTextInFrame(this.txtCodigoPostal,
		 * this.cuerpoFrame,
		 * String.valueOf(this.browserContext.getTestCaseData().
		 * getDireccionCodigoPostal()));
		 */
		this.webDriver.appendTextInFrame(this.txtCodigoPostal, this.cuerpoFrame, String.valueOf(getTestVar("direccion_codigo_postal")));

		this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);

		// if (isExcluirGarajes())
		if(Boolean.parseBoolean(getTestVar("ExcluirGarajes"))) {

			this.webDriver.switchToFrame(this.cuerpoFrame);
			if(!this.webDriver.isSelected(this.chkExcluirGarajes)) {
				this.webDriver.click(this.chkExcluirGarajes);
			}
			this.webDriver.exitFrame();
		}

		// if (isExcluirLocales())
		if(Boolean.parseBoolean(getTestVar("ExlcuirLocales"))) {
			this.webDriver.clickInFrame(this.chkExcluirLocales, this.cuerpoFrame);
		}

		this.editCalidadConstruccion();

		this.asegurarUnicamenteGarajes();
		// this.webDriver.waitForPageLoadWithAngular();
		this.webDriver.waitForLoadToComplete();

		// boolean value =
		// this.webDriver.isPresentInFrameAndClick(this.btnAnadirInmuebleReferenciaCatastral,
		// this.cuerpoFrame);
		boolean value = this.webDriver.isPresentAndClickInFrame(this.btnAnadirInmueble, this.cuerpoFrame);
		// this.webDriver.clickInFrame(this.btnAnadirInmuebleReferenciaCatastral,
		// this.cuerpoFrame);
		debugEnd();
		return value;
	}

	public void addInmuebleByDefaultAddress() throws InterruptedException {
		debugBegin();
		this.addInmuebleByAddress();
		debugEnd();
	}

	public boolean addInmuebleByReferenciaCatastral(String referenciaCatastral) {
		debugBegin();
		// this.webDriver.waitForPageLoadWithAngular();
		// this.webDriver.waitForAngular();
		this.webDriver.waitWithDriver(1000);
		this.webDriver.waitForElementNotToBeClickable(this.loaderModal);
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(1500);
		this.webDriver.moveToElement(this.btnAnadirInmueblePantallaPrincipal);
		this.webDriver.waitForElementToBeClickable(this.btnAnadirInmueblePantallaPrincipal);
		this.webDriver.click(this.btnAnadirInmueblePantallaPrincipal);
		// this.webDriver.waitForPageLoadWithAngular();
		// this.webDriver.waitForAngular();
		this.webDriver.waitWithDriver(1000);
		this.webDriver.click(this.radioBtnCriterioBusquedaReferenciaCatastral);

		this.webDriver.click(this.txtReferenciaCatastral);
		this.webDriver.waitForElementToBeClickable(this.radioBtnCriterioBusquedaReferenciaCatastral);
		// this.webDriver.appendText(this.txtReferenciaCatastral,
		// referenciaCatastral);
		// System.out.println("Valor referenciaCatastral: " +
		// referenciaCatastral);
		this.webDriver.appendText(txtReferenciaCatastral, referenciaCatastral);
		this.webDriver.click(this.btnBuscar);
		// this.webDriver.waitForAngular();

		/*
		 * Descomentar si se necesita marcar la opción: "asegurar únicamente
		 * garajes
		 */

		// this.asegurarUnicamenteGarajes();

		// this.browserContext.webElementHelper.clickInFrame(this.btnAnadirInmuebleReferenciaCatastral,
		// this.cuerpoFrame);

		// this.webDriver.waitForElementNotToBeClickable(this.loaderModal);
		this.webDriver.waitWithDriver(4000);
		// this.webDriver.waitForElementToBeClickable(this.btnAnadirInmuebleReferenciaCatastral);
		this.webDriver.click(this.btnAnadirInmueble);
		// this.webDriver.waitWithDriver(1500);
		this.webDriver.exitFrame();

		debugEnd();

		return true;
	}

	public void clickOnContinuar() {
		debugBegin();
		// this.webDriver.waitForPageLoadWithAngular();
		// this.webDriver.waitForAngular();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.GuardarRefCatastral(this.webDriver.getTextInFrame(this.txtCurrentReferenciaCatastral,
		// this.cuerpoFrame));
		this.GuardarRefCatastral(this.webDriver.getText(this.txtCurrentReferenciaCatastral));
		this.webDriver.waitForElementToBeClickableAndClick(this.btnContinuar);
		// this.webDriver.waitForAngular();
		// this.webDriver.click(this.btnContinuar);
		this.webDriver.exitFrame();
		debugEnd();
	}

	public void clickOnGuardar() {
		debugBegin();
		// this.webDriver.waitForPageLoadWithAngular();
		this.webDriver.clickInFrame(this.btnGuardar, this.cuerpoFrame);
		debugEnd();
	}

	public void closeAvisoSistemaPopup() throws IOException {
		debugBegin();
		// this.browserContextwebDriverConfiguration.SetWebDriverTimeouts(5);
		this.webDriver.switchToFrame(this.cuerpoFrame);

		if(this.webDriver.getElements(txtAvisoSistema).size() > 0) {
			this.webDriver.click(this.btnAceptar);
		}
		this.webDriver.exitFrame();
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		debugEnd();
	}

	public void modifyReferenciaCatastral() {
		debugBegin();

		String referenciaCatastral = this.webDriver.getTextInFrame(this.txtCurrentReferenciaCatastral, this.cuerpoFrame);
		// String expectedReferenciaCatastral =
		// this.browserContext.getTestCaseData().getReferenciaCatastral();
		String expectedReferenciaCatastral = getConfigVar("ReferenciaCatastral");

		if(!referenciaCatastral.trim().equals(expectedReferenciaCatastral.substring(0, expectedReferenciaCatastral.length() - 6))) {
			this.webDriver.clickInFrame(this.btnModificarReferenciaCatastral, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.radioBtnCriterioBusquedaReferenciaCatastral, this.cuerpoFrame);
			this.webDriver.appendTextInFrame(this.txtReferenciaCatastral, this.cuerpoFrame, expectedReferenciaCatastral);
			this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
			this.webDriver.clickInFrame(this.btnModificarInmueble, this.cuerpoFrame);
		}

		debugEnd();
	}

	public void editInmuebleAndExcluirGarajesYLocales() {
		// if (isExcluirGarajes() || isExcluirLocales())
		if(Boolean.parseBoolean(getTestVar("ExcluirGarajes")) || Boolean.parseBoolean(getTestVar("ExcluirLocales"))) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.click(this.btnLapiz);
			// if (!this.chkExcluirGarajes.isSelected() &&
			// isExcluirGarajes())

			if(!this.webDriver.isSelected(this.chkExcluirGarajes) && Boolean.parseBoolean(getTestVar("ExcluirGarajes"))) {
				this.webDriver.click(this.chkExcluirGarajes);
			}

			// if (!this.chkExcluirLocales.isSelected() &&
			// isExcluirLocales())
			if(!this.webDriver.isSelected(this.chkExcluirGarajes) && Boolean.parseBoolean(getTestVar("excluir_locales"))) {
				this.webDriver.click(this.chkExcluirLocales);
			}

			this.webDriver.click(this.btnModificarInmueble);
			this.webDriver.exitFrame();
		}
	}

	public void editCalidadConstruccion() {
		// if (getCalidadConstruccion() != null)
		if(getTestVar("calidad_construccion") != null) {
			this.webDriver.switchToFrame(this.cuerpoFrame);
			// this.webDriver.selectValueInDropDown(this.cbkCalidadConstruccion,
			// getCalidadConstruccion());
			this.webDriver.clickElementFromDropDownByAttribute(this.cbkCalidadConstruccion, "value", getTestVar("calidad_construccion"));
			this.webDriver.tabulateElement(this.cbkCalidadConstruccion);
			this.webDriver.exitFrame();
		}
	}

	// public void asegurarUnicamenteGarajes() {
	// // if (isAsegurarUnicamenteGarajes())
	// if(Boolean.parseBoolean(getTestVar(testId,
	// "asegurar_unicamente_garajes"))) {
	// this.webDriver.switchToFrame(this.cuerpoFrame);
	// this.webDriver.click(this.chkAsegurarUnicamenteGarajes);
	// this.webDriver.tabulateElement(this.chkAsegurarUnicamenteGarajes);
	// this.webDriver.exitFrame();
	// }
	// }

	public void asegurarUnicamenteGarajes() {
		// if (isAsegurarUnicamenteGarajes())
		// if(Boolean.parseBoolean(getScenarioVar(testId,
		// "asegurar_unicamente_garajes"))) {
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(2000);
		this.webDriver.click(this.chkAsegurarUnicamenteGarajes);

		this.webDriver.tabulateElement(this.chkAsegurarUnicamenteGarajes);
		// this.webDriver.click(this.chkAsegurarUnicamenteGarajes);
		// this.webDriver.exitFrame();
		// }
	}

	public void printLogProcessPercentage(String message, int current, int total) {
		if((int) ((double) current / (double) total * 100) > (int) ((double) current - 1 / (double) total * 100)) {
			debugInfo(message + (int) ((double) current / (double) total * 100) + "%");
		}
	}

	public void iterarEdificiosPorDirecciones(String nombreFichero) throws InterruptedException {
		debugBegin();

		// this.webDriver.moveToElementInFrameWithJavaScript(this.btnAnadirInmueblePantallaPrincipal,
		// this.cuerpoFrame);
		this.webDriver.clickInFrame(this.btnAnadirInmueblePantallaPrincipal, this.cuerpoFrame);

		// Read file and fill HashMap
		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		// Iterate by number of lines
		for(int i = 0; i < dataObject.size(); i++) {
			boolean dropDownPresent = true;
			String provincia = dataObject.getValue(i + "", "provincia");
			String poblacion = dataObject.getValue(i + "", "poblacion");
			String direccion = dataObject.getValue(i + "", "direccion");
			String numero = dataObject.getValue(i + "", "numero");
			String direccionTotal = provincia + " " + poblacion + " " + direccion + " " + numero;
			// Print iteration process percentage
			this.printLogProcessPercentage("Iterations - ", i, dataObject.size());

			// If text in field "provincia" is not equals to the
			// provincia(i) value
			if(!this.webDriver.getTextInFrame(this.txtProvincia, this.cuerpoFrame).contains(provincia)) {
				// Fill provincia
				// this.webDriver.waitForPageLoadToFinish();
				this.webDriver.appendTextInFrame(this.txtProvincia, this.cuerpoFrame, provincia);
				// this.webDriver.clickInFrame(this.lblMatchFoundElement,
				// this.cuerpoFrame);
				// this.webDriver.waitForPageLoadWithAngular();
				dropDownPresent = this.webDriver.isPresentAndClickInFrame(this.lblMatchFoundElement, this.cuerpoFrame);
				if(!dropDownPresent)
					System.out.println("Nombre de provincia no encontrado en el dropdown\n" + direccionTotal);
			}

			// If text in field "poblacion" is not equals to the
			// poblacion(i) value
			if(dropDownPresent && !this.webDriver.getTextInFrame(this.txtPoblacion, this.cuerpoFrame).contains(poblacion)) {
				// Fill poblacion
				// this.webDriver.waitForAngular();
				this.webDriver.appendTextInFrame(this.txtPoblacion, this.cuerpoFrame, poblacion);
				// this.webDriver.waitForPageLoadWithAngular();
				dropDownPresent = this.webDriver.isPresentAndClickInFrame(this.lblMatchFoundElement, this.cuerpoFrame);
				if(!dropDownPresent)
					System.out.println("Nombre de población no encontrado en el dropdown\n" + direccionTotal);
			}

			// If text in field "direccion" is not equals to the
			// direccion(i) value
			if(dropDownPresent && !this.webDriver.getTextInFrame(this.txtNombreVia, this.cuerpoFrame).contains(direccion)) {
				// Fill direccion
				// this.webDriver.waitForAngular();
				this.webDriver.appendTextInFrame(this.txtNombreVia, this.cuerpoFrame, direccion);
				// this.webDriver.waitForPageLoadWithAngular();
				dropDownPresent = this.webDriver.isPresentAndClickInFrame(this.lblMatchFoundElementVia, this.cuerpoFrame);
				if(!dropDownPresent)
					System.out.println("Nombre de via no encontrado en el dropdown\n" + direccionTotal);
			}

			// Fill numero
			if(this.webDriver.isPresentInFrame(this.txtNumeroVia, this.cuerpoFrame))
				this.webDriver.appendTextInFrame(this.txtNumeroVia, this.cuerpoFrame, numero);
			// Fill codigo postal
			if(this.webDriver.isPresentInFrame(this.txtCodigoPostal, this.cuerpoFrame)) {
				String codigoPostal = dataObject.getValue(i + "", "codigo_postal");
				this.webDriver.appendTextInFrame(this.txtCodigoPostal, this.cuerpoFrame, codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
			}

			if(dropDownPresent) {
				try {
					// Search
					this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);

					// Wait result
					System.out.println(this.webDriver.isPresentInFrame(this.resultadoBusqueda, this.cuerpoFrame) ? "Dirección normalizada"
						: "Direccion no encontrada\n" + direccionTotal);
					// this.webDriver.waitForWebElementInFrame(this.resultadoBusqueda,
					// this.cuerpoFrame);

				} catch(UnhandledAlertException e) {
					// WebElement Alert = null;

					// Manage alert Pop-up
					// this.webDriver.getAlertTextAndAccept(Alert);
					this.webDriver.acceptAlert();
					// System.out.println(this.webDriver.getAlertText());
					// this.webDriver.exitFrame();
				}
			}
		}

		this.webDriver.clickInFrame(this.btnCancelar, this.cuerpoFrame);
		this.webDriver.quit();
		debugEnd();
	}

	public void iterarEdificiosPorReferencias(String nombreFichero) throws Exception {
		debugBegin();

		// this.webDriver.moveToElementAndClickInFrame(this.btnAnadirInmueblePantallaPrincipal,
		// this.cuerpoFrame);
		this.webDriver.isPresentAndClickInFrame(this.btnAnadirInmueblePantallaPrincipal, this.cuerpoFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		this.webDriver.clickInFrame(this.radioBtnCriterioBusquedaReferenciaCatastral, this.cuerpoFrame);

		// Read file and fill HashMap
		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		// Iterate by number of lines
		for(int i = 0; i < dataObject.size(); i++) {
			System.out.println("***En en bucle iterar");
			String refCat = dataObject.getValue(i + "", "ref_catastral");
			// Print iteration process percentage
			this.printLogProcessPercentage("Iterations - ", i, dataObject.size());

			// Search
			try {
				// Fill referencia_catastral
				this.webDriver.appendTextInFrame(this.txtReferenciaCatastral, this.cuerpoFrame, refCat);

				this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);

				// Wait result
				if(this.webDriver.isPresentInFrame(this.mensajeModalError, this.cuerpoFrame)) {
					System.out.println("Referencia catastral no encontrada\n" + refCat);
					this.webDriver.clickInFrame(this.btnModalError, this.cuerpoFrame);
				} else {
					// this.webDriver.waitForWebElementInFrame(this.resultadoBusqueda,
					// this.cuerpoFrame);
					this.webDriver.waitForElementToBePresentInFrame(this.resultadoBusqueda, this.cuerpoFrame);
					System.out.println("Referencia catastral encontrada");
				}
			} catch(UnhandledAlertException e) {
				// WebElement Alert = null;

				// Manage alert Pop-up
				this.webDriver.acceptAlert();
				System.out.println("Error con referencia catastral\n" + refCat);
				// this.webDriver.exitFrame();
			} catch(Exception e) {
				this.webDriver.quit();

				new LoginPage(userS)
					.logIn(getConfigVar("environment"), getTestVar("acceso"), getTestVar("usuario"));

				// FichaEdificioPage
				InnovaHomePage innovaHomePage = new InnovaHomePage(userS);
				innovaHomePage.openMutuaEdificioConfort();
				innovaHomePage.openNewProjectMec();

				AsignarMediadorPage asignarMediadorPage = new AsignarMediadorPage(userS);
				//
				// REVISAR PARAMETROS DE ENTRADA DE: AsignarMediadorPage
				//
				// asignarMediadorPage.selectMediadorAndClickOnContinuar(getConfigVar("mediador"));
				asignarMediadorPage.selectMediadorAndClickOnContinuar();

				this.webDriver.moveToElementInFrame(this.btnAnadirInmueblePantallaPrincipal, this.cuerpoFrame);
				this.webDriver.clickInFrame(this.radioBtnCriterioBusquedaReferenciaCatastral, this.cuerpoFrame);
			}
		}
		this.webDriver.clickInFrame(this.btnCancelar, this.cuerpoFrame);
		this.webDriver.quit();
		debugEnd();
	}

	public boolean checkNotification() {
		return this.webDriver.isPresentInFrame(this.txtMensajeError, this.cuerpoFrame);
	}

	public boolean closeNotification() {
		debugBegin();
		boolean value = false;

		if(this.checkNotification()) {
			this.webDriver.clickInFrame(this.btnAceptar, this.cuerpoFrame);
			value = true;
		}

		debugEnd();
		return value;
	}

	public void GuardarRefCatastral(String cadenaTexto) {
		try {
			// String ruta = fileDownloadTempPath + "\\Polizas.txt";
			// String ruta =
			// this.browserContext.getTestCaseData().getFileDownloadTempPath() +
			// "\\Polizas.txt";
			String ruta = getConfigVar("fileDownloadTempPath") + "\\Polizas.txt";
			// File archivo = new File("C:\\MutuaPropietarios\\Polizas.txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta, true), StandardCharsets.UTF_8));
			bw.write(cadenaTexto + "_");
			bw.close();
		} catch(Exception e) {

		}
	}
	// endregion
}
