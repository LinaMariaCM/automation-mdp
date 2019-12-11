package com.amaris.project.pages.productos;

import org.openqa.selenium.By;

import org.openqa.selenium.UnhandledAlertException;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.project.Constants;
import com.amaris.project.pages.administracion.mediadores.AsignarMediadorPage;
import com.amaris.project.pages.comun.LoginPage;
import com.amaris.project.pages.comun.innova.InnovaHomePage;

public class UbicacionRiesgoPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By btnAnadirInmueblePantallaPrincipal = By.xpath(".//*[text()='Añadir inmueble' and @ng-click='ur.addInmueble()' and @ng-disabled='ur.disableAddInmuebleButton']");
	private By btnCancelar = By.xpath(".//*[@id='inmuebleModal']/div/div/div[3]/button[1]");
	private By radioBtnCriterioBusquedaReferenciaCatastral = By.id("critCatastro");

	private By txtReferenciaCatastral = By.name("refCatastral");
	private By btnBuscar = By.xpath(".//*[text()='Buscar']");
	private By btnAnadirInmueble = By.cssSelector(".modal-lg > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)");
	private By chkAsegurarUnicamenteGarajes = By.xpath(".//*[@ng-model='ur.inmueble.data.asegurarGarajes']");
	private By chkExcluirGarajes = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirGarajes']");
	private By chkExcluirLocales = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirLocales']");

	private By btnContinuar = By.xpath(".//*[text()='Continuar']");
	private By btnGuardar = By.xpath(".//*[@ng-click='ur.save(ubicacionRiesgoForm.$valid)']");

	private By txtProvincia = By.name("provincia");
	private By txtPoblacion = By.name("poblacion");
	private By txtNombreVia = By.name("nombreVia");
	private By txtNumeroVia = By.name("numVia");
	private By txtCodigoPostal = By.name("codigoPostal");

	private By lblMatchFoundElement = By.xpath(".//*[@tabindex='-1' and contains(@ng-bind-html,'match.label')]");
	private By lblMatchFoundElementVia = By.xpath(".//*[contains(@ng-bind-html,'match.model.street') and contains(@ng-bind-html,'|')]");

	private By txtAvisoSistema = By.xpath(".//*[text()='Al acceder en modo modificación las retenciones que su perfil lo permitan quedarán aceptadas de manera automática en cada paso.']");
	private By btnAceptar = By.xpath(".//*[text()='Aceptar']");
	private By btnModificarReferenciaCatastral = By.xpath(".//*[contains(@class,'glyphicon-pencil')]");
	private By btnModificarInmueble = By.xpath(".//*[text()='Modificar inmueble' and @ng-click='ur.modalBuscador.updateInmueble()']");

	private By txtCurrentReferenciaCatastral = By.xpath(".//*[contains(@ng-bind-html,'inmuebleSeleccionado.data.refCatastral')]");
	private By cbkCalidadConstruccion = By.name("calidadConstruccion");
	private By btnLapiz = By.xpath(".//*[@ng-click='ur.editInmueble()']");

	private By resultadoBusqueda = By.xpath(".//*[@id='inmuebleModal']/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]");

	private By mensajeModalError = By.xpath("//*[@id='modalErrores']/div/div/div[2]/div/div/p");
	private By btnModalError = By.xpath("//*[@id='modalErrores']/div/div/div[3]/button");
	private By txtMensajeError = By.xpath("p[ng-bind-html='modalErrores.text | encode']");

	private By loaderModal = By.cssSelector("#modalLoader");
	private By procesando = By.cssSelector("#procesando");

	// endregion

	public UbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public UbicacionRiesgoPage waitProcesando() throws Exception {

		System.out.println("Espero a ver procesando...");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesando)) {
			System.out.println("Lo veo");
			webDriver.waitWithDriver(1500);
		}

		System.out.println("No veo procesando...");

		return this;
	}

	public boolean fillInmuebleAndGetAvailability() {
		return addInmueble(getScenarioVar(Constants.INMUEBLE));
	}

	public UbicacionRiesgoPage fillInmuebleAndClickOnContinue() {
		addInmueble(getScenarioVar(Constants.INMUEBLE));
		clickOnContinuar();

		return this;
	}

	public boolean addInmueble(String inmueble) {
		debugBegin();

		boolean value = false;

		if(inmueble != null && !inmueble.isEmpty()) {
			value = addInmuebleByAddress();
		} else {
			value = addInmuebleByReferenciaCatastral(getData(Constants.FICHERO_REFERENCIAS).getValue(userS.getScenario(), Constants.REFERENCIA_CATASTRAL));
		}

		debugEnd();

		return value;
	}

	public boolean addInmuebleByAddress() {
		debugBegin();

		webDriver.clickInFrame(btnAnadirInmueblePantallaPrincipal, cuerpoFrame);

		webDriver.appendTextInFrame(txtProvincia, cuerpoFrame, getTestVar(Constants.PROVINCIA));
		webDriver.clickInFrame(lblMatchFoundElement, cuerpoFrame);

		webDriver.appendTextInFrame(txtPoblacion, cuerpoFrame, getTestVar(Constants.POBLACION));
		webDriver.clickInFrame(lblMatchFoundElement, cuerpoFrame);

		webDriver.appendTextInFrame(txtNombreVia, cuerpoFrame, getTestVar(Constants.NOMBRE_VIA));
		webDriver.clickInFrame(lblMatchFoundElementVia, cuerpoFrame);

		webDriver.appendTextInFrame(txtNumeroVia, cuerpoFrame, getTestVar(Constants.NUM_VIA));
		webDriver.appendTextInFrame(txtCodigoPostal, cuerpoFrame, getTestVar(Constants.CODIGO_POSTAL));

		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES)) && !webDriver.isSelectedInFrame(chkExcluirGarajes, cuerpoFrame)) {
			webDriver.clickInFrame(chkExcluirGarajes, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
			webDriver.clickInFrame(chkExcluirLocales, cuerpoFrame);
		}

		editCalidadConstruccion();

		asegurarUnicamenteGarajes();
		// webDriver.waitForPageLoadWithAngular();

		boolean value = webDriver.isPresentAndClickInFrame(btnAnadirInmueble, cuerpoFrame);

		if(value) {
			webDriver.clickInFrame(btnAnadirInmueble, cuerpoFrame);
		}

		debugEnd();

		return value;
	}

	public boolean addInmuebleByDefaultAddress() {
		debugBegin();
		boolean result = addInmuebleByAddress();
		debugEnd();

		return result;
	}

	public boolean addInmuebleByReferenciaCatastral(String referenciaCatastral) {
		debugBegin();
		// webDriver.waitForAngular();
		webDriver.waitWithDriver(2000);
		webDriver.waitForElementNotToBeClickable(loaderModal);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(btnAnadirInmueblePantallaPrincipal, cuerpoFrame);
		// webDriver.waitForAngular();
		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(radioBtnCriterioBusquedaReferenciaCatastral, cuerpoFrame);
		webDriver.appendTextInFrame(txtReferenciaCatastral, cuerpoFrame, referenciaCatastral);
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);
		// webDriver.waitForAngular();

		// asegurarUnicamenteGarajes();

		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(btnAnadirInmueble, cuerpoFrame);

		debugEnd();

		return true;
	}

	public UbicacionRiesgoPage clickOnContinuar() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		GuardarRefCatastral(webDriver.getTextInFrame(txtCurrentReferenciaCatastral, cuerpoFrame));
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage clickOnGuardar() {
		debugBegin();
		webDriver.clickInFrame(btnGuardar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage closeAvisoSistemaPopup() {
		debugBegin();

		if(!webDriver.getElementsInFrame(txtAvisoSistema, cuerpoFrame).isEmpty()) {
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage modifyReferenciaCatastral() {
		debugBegin();

		String referenciaCatastral = webDriver.getTextInFrame(txtCurrentReferenciaCatastral, cuerpoFrame);
		String expectedReferenciaCatastral = getScenarioVar(Constants.REFERENCIA_CATASTRAL);

		if(!referenciaCatastral.trim().equals(expectedReferenciaCatastral.substring(0, expectedReferenciaCatastral.length() - 6))) {
			webDriver.clickInFrame(btnModificarReferenciaCatastral, cuerpoFrame);
			webDriver.clickInFrame(radioBtnCriterioBusquedaReferenciaCatastral, cuerpoFrame);
			webDriver.appendTextInFrame(txtReferenciaCatastral, cuerpoFrame, expectedReferenciaCatastral);
			webDriver.clickInFrame(btnBuscar, cuerpoFrame);
			webDriver.clickInFrame(btnModificarInmueble, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage editInmuebleAndExcluirGarajesYLocales() {
		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES))
			|| Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.click(btnLapiz);

			if(!webDriver.isSelected(chkExcluirGarajes) && Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES))) {
				webDriver.click(chkExcluirGarajes);
			}

			if(!webDriver.isSelected(chkExcluirGarajes) && Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
				webDriver.click(chkExcluirLocales);
			}

			webDriver.click(btnModificarInmueble);
			webDriver.exitFrame();
		}

		return this;
	}

	public UbicacionRiesgoPage editCalidadConstruccion() {
		debugBegin();

		if(getTestVar(Constants.CALIDAD_CONSTRUCCION) != null) {
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.clickElementFromDropDownByAttribute(cbkCalidadConstruccion, "value", getTestVar("calidad_construccion"));
			webDriver.tabulateElement(cbkCalidadConstruccion);
			webDriver.exitFrame();
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage asegurarUnicamenteGarajes() {
		debugBegin();

		if(getScenarioVar(Constants.ASEGURAR_UNICAMENTE_GARAJES).equals("true")) {
			webDriver.clickInFrame(chkAsegurarUnicamenteGarajes, cuerpoFrame);
			webDriver.tabulateElementInFrame(chkAsegurarUnicamenteGarajes, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage printLogProcessPercentage(String message, int current, int total) {
		if((int) ((double) current / (double) total * 100) > (int) ((double) current - 1 / (double) total * 100)) {
			debugInfo(message + (int) ((double) current / (double) total * 100) + "%");
		}

		return this;
	}

	public UbicacionRiesgoPage iterarEdificiosPorDirecciones(String nombreFichero) {
		debugBegin();

		webDriver.clickInFrame(btnAnadirInmueblePantallaPrincipal, cuerpoFrame);

		// Read file and fill HashMap
		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		// Iterate by number of lines
		for(int i = 0; i < dataObject.size(); i++) {
			boolean dropDownPresent = true;
			String provincia = dataObject.getValue(i + "", Constants.PROVINCIA);
			String poblacion = dataObject.getValue(i + "", Constants.POBLACION);
			String direccion = dataObject.getValue(i + "", Constants.NOMBRE_VIA);
			String numero = dataObject.getValue(i + "", Constants.NUM_VIA);
			String direccionTotal = provincia + " " + poblacion + " " + direccion + " " + numero;

			// Print iteration process percentage
			printLogProcessPercentage("Iterations - ", i, dataObject.size());

			// If text in field "provincia" is not equals to the provincia(i) value
			if(!webDriver.getTextInFrame(txtProvincia, cuerpoFrame).contains(provincia)) {
				// Fill provincia
				webDriver.appendTextInFrame(txtProvincia, cuerpoFrame, provincia);

				// webDriver.waitForAngular();
				dropDownPresent = webDriver.isPresentAndClickInFrame(lblMatchFoundElement, cuerpoFrame);
				if(!dropDownPresent) {
					debugInfo("Nombre de provincia no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			// If text in field "poblacion" is not equals to the poblacion(i) value
			if(dropDownPresent && !webDriver.getTextInFrame(txtPoblacion, cuerpoFrame).contains(poblacion)) {
				// Fill poblacion
				// webDriver.waitForAngular();
				webDriver.appendTextInFrame(txtPoblacion, cuerpoFrame, poblacion);
				// webDriver.waitForAngular();
				dropDownPresent = webDriver.isPresentAndClickInFrame(lblMatchFoundElement, cuerpoFrame);
				if(!dropDownPresent) {
					debugInfo("Nombre de población no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			// If text in field "direccion" is not equals to the direccion(i) value
			if(dropDownPresent && !webDriver.getTextInFrame(txtNombreVia, cuerpoFrame).contains(direccion)) {
				// Fill direccion
				// webDriver.waitForAngular();
				webDriver.appendTextInFrame(txtNombreVia, cuerpoFrame, direccion);
				// webDriver.waitForAngular();
				dropDownPresent = webDriver.isPresentAndClickInFrame(lblMatchFoundElementVia, cuerpoFrame);
				if(!dropDownPresent) {
					debugInfo("Nombre de via no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			// Fill numero
			if(webDriver.isPresentInFrame(txtNumeroVia, cuerpoFrame)) {
				webDriver.appendTextInFrame(txtNumeroVia, cuerpoFrame, numero);
			}

			// Fill codigo postal
			if(webDriver.isPresentInFrame(txtCodigoPostal, cuerpoFrame)) {
				String codigoPostal = dataObject.getValue(i + "", Constants.CODIGO_POSTAL);
				webDriver.appendTextInFrame(txtCodigoPostal, cuerpoFrame, codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
			}

			if(dropDownPresent) {
				try {
					// Search
					webDriver.clickInFrame(btnBuscar, cuerpoFrame);

					// Wait result
					debugInfo(webDriver.isPresentInFrame(resultadoBusqueda, cuerpoFrame) ? "Dirección normalizada"
						: "Direccion no encontrada\n" + direccionTotal);
				} catch(UnhandledAlertException e) {
					debugError(webDriver.getAlertText());
					webDriver.acceptAlert();
				}
			}
		}

		webDriver.clickInFrame(btnCancelar, cuerpoFrame);
		webDriver.quit();
		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage iterarEdificiosPorReferencias(String nombreFichero) throws Exception {
		debugBegin();

		webDriver.isPresentAndClickInFrame(btnAnadirInmueblePantallaPrincipal, cuerpoFrame);
		// webDriver.waitForAngular();
		webDriver.clickInFrame(radioBtnCriterioBusquedaReferenciaCatastral, cuerpoFrame);

		// Read file and fill HashMap
		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		// Iterate by number of lines
		for(int i = 0; i < dataObject.size(); i++) {
			debugInfo("***En en bucle iterar");
			String refCat = dataObject.getValue(i + "", Constants.REFERENCIA_CATASTRAL);

			// Print iteration process percentage
			printLogProcessPercentage("Iterations - ", i, dataObject.size());

			// Search
			try {
				// Fill referencia_catastral
				webDriver.appendTextInFrame(txtReferenciaCatastral, cuerpoFrame, refCat);

				webDriver.clickInFrame(btnBuscar, cuerpoFrame);

				// Wait result
				if(webDriver.isPresentInFrame(mensajeModalError, cuerpoFrame)) {
					debugInfo("Referencia catastral no encontrada\n" + refCat);
					webDriver.clickInFrame(btnModalError, cuerpoFrame);
				} else {
					webDriver.waitForElementToBePresentInFrame(resultadoBusqueda, cuerpoFrame);
					debugInfo("Referencia catastral encontrada");
				}
			} catch(UnhandledAlertException e) {
				// Manage alert Pop-up
				webDriver.acceptAlert();
				debugInfo("Error con referencia catastral\n" + refCat);
			} catch(Exception e) {
				webDriver.quit();

				new LoginPage(userS)
					.logIn(getConfigVar(Constants.ENTORNO), getTestVar(Constants.ACCESO), getTestVar(Constants.USUARIO));

				// FichaEdificioPage
				new InnovaHomePage(userS)
					.openMutuaEdificioConfort()
					.createNewProject();

				new AsignarMediadorPage(userS)
					.selectMediadorAndClickOnContinuar();

				webDriver.moveToElementInFrame(btnAnadirInmueblePantallaPrincipal, cuerpoFrame);
				webDriver.clickInFrame(radioBtnCriterioBusquedaReferenciaCatastral, cuerpoFrame);
			}
		}

		webDriver.clickInFrame(btnCancelar, cuerpoFrame);
		webDriver.quit();

		debugEnd();

		return this;
	}

	public boolean checkNotification() {
		return webDriver.isPresentInFrame(txtMensajeError, cuerpoFrame);
	}

	public boolean closeNotification() {
		debugBegin();

		boolean value = false;

		if(checkNotification()) {
			webDriver.clickInFrame(btnAceptar, cuerpoFrame);
			value = true;
		}

		debugEnd();

		return value;
	}

	public UbicacionRiesgoPage GuardarRefCatastral(String cadenaTexto) {
		debugBegin();

		try {
			String ruta = userS.getReportPath() + "/Polizas.txt";

			FileUtils.appendToFile(ruta, cadenaTexto + "_");
		} catch(Exception e) {}

		debugEnd();

		return this;
	}
	// endregion
}
