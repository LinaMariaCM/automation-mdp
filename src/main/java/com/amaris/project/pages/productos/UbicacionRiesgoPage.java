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

	private By anadirInmueblePantallaPrincipalBtn = By.xpath(".//*[text()='Añadir inmueble' and @ng-click='ur.addInmueble()' and @ng-disabled='ur.disableAddInmuebleButton']");
	private By cancelarBtn = By.xpath(".//*[@id='inmuebleModal']/div/div/div[3]/button[1]");
	private By criterioBusquedaReferenciaCatastralBtn = By.id("critCatastro");

	private By referenciaCatastralInput = By.name("refCatastral");
	private By buscarBtn = By.xpath(".//*[text()='Buscar']");
	private By anyadirInmuebleBtn = By.cssSelector(".modal-lg > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)");
	private By chkAsegurarUnicamenteGarajes = By.xpath(".//*[@ng-model='ur.inmueble.data.asegurarGarajes']");
	private By excluirGarajesBtn = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirGarajes']");
	private By excluirLocalesBtn = By.xpath(".//*[@ng-model='ur.inmueble.data.excluirLocales']");

	private By continuarBtn = By.xpath(".//*[text()='Continuar']");
	private By guardarBtn = By.xpath(".//*[@ng-click='ur.save(ubicacionRiesgoForm.$valid)']");

	private By provinciaInput = By.name("provincia");
	private By poblacionInput = By.name("poblacion");
	private By nombreViaInput = By.name("nombreVia");
	private By numeroViaInput = By.name("numVia");
	private By codigoPostalInput = By.name("codigoPostal");

	private By matchFoundElementBtn = By.xpath(".//*[@tabindex='-1' and contains(@ng-bind-html,'match.label')]");
	private By matchFoundElementViaBtn = By.xpath(".//*[contains(@ng-bind-html,'match.model.street') and contains(@ng-bind-html,'|')]");

	private By avisoSistemaTxt = By.xpath(".//*[text()='Al acceder en modo modificación las retenciones que su perfil lo permitan quedarán aceptadas de manera automática en cada paso.']");
	private By aceptarBtn = By.xpath(".//*[text()='Aceptar']");
	private By modificarReferenciaCatastralBtn = By.xpath(".//*[contains(@class,'glyphicon-pencil')]");
	private By modificarInmuebleBtn = By.xpath(".//*[text()='Modificar inmueble' and @ng-click='ur.modalBuscador.updateInmueble()']");

	private By currentReferenciaCatastralTxt = By.xpath(".//*[contains(@ng-bind-html,'inmuebleSeleccionado.data.refCatastral')]");
	private By calidadConstruccionDrpDwn = By.name("calidadConstruccion");
	private By lapizBtn = By.xpath(".//*[@ng-click='ur.editInmueble()']");

	private By resultadoBusquedaTxt = By.xpath(".//*[@id='inmuebleModal']/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]");

	private By mensajeModalErrorTxt = By.xpath("//*[@id='modalErrores']/div/div/div[2]/div/div/p");
	private By modalErrorBtn = By.xpath("//*[@id='modalErrores']/div/div/div[3]/button");
	private By mensajeErrorTxt = By.xpath("p[ng-bind-html='modalErrores.text | encode']");

	private By loaderModal = By.cssSelector("#modalLoader");
	private By procesandoModal = By.cssSelector("#procesando");
	// endregion

	public UbicacionRiesgoPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public UbicacionRiesgoPage waitProcesando() {
		debugBegin();

		debugInfo("Se espera al mensaje \"procesando\"");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesandoModal)) {
			debugInfo("Se muestra mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		debugEnd();

		return this;
	}

	public boolean fillInmuebleAndGetAvailability() {
		return addInmueble(getScenarioVar(Constants.INMUEBLE));
	}

	public UbicacionRiesgoPage fillInmuebleAndClickContinuar() {
		addInmueble(getScenarioVar(Constants.INMUEBLE));
		clickContinuar();

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

		webDriver.clickInFrame(anadirInmueblePantallaPrincipalBtn, cuerpoFrame);

		webDriver.appendTextInFrame(provinciaInput, cuerpoFrame, getTestVar(Constants.PROVINCIA));
		webDriver.clickInFrame(matchFoundElementBtn, cuerpoFrame);

		webDriver.appendTextInFrame(poblacionInput, cuerpoFrame, getTestVar(Constants.POBLACION));
		webDriver.clickInFrame(matchFoundElementBtn, cuerpoFrame);

		webDriver.appendTextInFrame(nombreViaInput, cuerpoFrame, getTestVar(Constants.NOMBRE_VIA));
		webDriver.clickInFrame(matchFoundElementViaBtn, cuerpoFrame);

		webDriver.appendTextInFrame(numeroViaInput, cuerpoFrame, getTestVar(Constants.NUM_VIA));
		webDriver.appendTextInFrame(codigoPostalInput, cuerpoFrame, getTestVar(Constants.CODIGO_POSTAL));

		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES)) && !webDriver.isSelectedInFrame(excluirGarajesBtn, cuerpoFrame)) {
			webDriver.clickInFrame(excluirGarajesBtn, cuerpoFrame);
		}

		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
			webDriver.clickInFrame(excluirLocalesBtn, cuerpoFrame);
		}

		editCalidadConstruccion();

		asegurarUnicamenteGarajes();

		boolean value = webDriver.isPresentAndClickInFrame(anyadirInmuebleBtn, cuerpoFrame);

		if(value) {
			webDriver.clickInFrame(anyadirInmuebleBtn, cuerpoFrame);
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

		webDriver.waitWithDriver(2000);
		webDriver.waitForElementNotToBeClickable(loaderModal);

		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(anadirInmueblePantallaPrincipalBtn, cuerpoFrame);

		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(criterioBusquedaReferenciaCatastralBtn, cuerpoFrame);
		webDriver.appendTextInFrame(referenciaCatastralInput, cuerpoFrame, referenciaCatastral);
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		webDriver.waitWithDriver(8000);
		webDriver.clickInFrame(anyadirInmuebleBtn, cuerpoFrame);

		debugEnd();

		return true;
	}

	public UbicacionRiesgoPage clickContinuar() {
		debugBegin();

		webDriver.waitWithDriver(4000);
		guardarRefCatastral(webDriver.getTextInFrame(currentReferenciaCatastralTxt, cuerpoFrame));
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage clickOnGuardar() {
		debugBegin();
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage closeAvisoSistemaPopup() {
		debugBegin();

		if(!webDriver.getElementsInFrame(avisoSistemaTxt, cuerpoFrame).isEmpty()) {
			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage modifyReferenciaCatastral() {
		debugBegin();

		String referenciaCatastral = webDriver.getTextInFrame(currentReferenciaCatastralTxt, cuerpoFrame);
		String expectedReferenciaCatastral = getScenarioVar(Constants.REFERENCIA_CATASTRAL);

		if(!referenciaCatastral.trim().equals(expectedReferenciaCatastral.substring(0, expectedReferenciaCatastral.length() - 6))) {
			webDriver.clickInFrame(modificarReferenciaCatastralBtn, cuerpoFrame);
			webDriver.clickInFrame(criterioBusquedaReferenciaCatastralBtn, cuerpoFrame);
			webDriver.appendTextInFrame(referenciaCatastralInput, cuerpoFrame, expectedReferenciaCatastral);
			webDriver.clickInFrame(buscarBtn, cuerpoFrame);
			webDriver.clickInFrame(modificarInmuebleBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage editInmuebleAndExcluirGarajesYLocales() {
		if(Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES))
			|| Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
			webDriver.clickInFrame(lapizBtn, cuerpoFrame);

			if(!webDriver.isSelectedInFrame(excluirGarajesBtn, cuerpoFrame) && Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_GARAJES))) {
				webDriver.clickInFrame(excluirGarajesBtn, cuerpoFrame);
			}

			if(!webDriver.isSelectedInFrame(excluirGarajesBtn, cuerpoFrame) && Boolean.parseBoolean(getTestVar(Constants.EXCLUIR_LOCALES))) {
				webDriver.clickInFrame(excluirLocalesBtn, cuerpoFrame);
			}

			webDriver.clickInFrame(modificarInmuebleBtn, cuerpoFrame);
		}

		return this;
	}

	public UbicacionRiesgoPage editCalidadConstruccion() {
		debugBegin();

		if(getTestVar(Constants.CALIDAD_CONSTRUCCION) != null) {
			webDriver.clickElementFromDropDownByAttributeInFrame(calidadConstruccionDrpDwn, cuerpoFrame, "value", getTestVar(Constants.CALIDAD_CONSTRUCCION));
			webDriver.tabulateElementInFrame(calidadConstruccionDrpDwn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage asegurarUnicamenteGarajes() {
		debugBegin();

		if(Boolean.parseBoolean(getScenarioVar(Constants.ASEGURAR_UNICAMENTE_GARAJES))) {
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

		webDriver.clickInFrame(anadirInmueblePantallaPrincipalBtn, cuerpoFrame);

		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		for(int i = 0; i < dataObject.size(); i++) {
			boolean dropDownPresent = true;

			String provincia = dataObject.getValue(i + "", Constants.PROVINCIA);
			String poblacion = dataObject.getValue(i + "", Constants.POBLACION);
			String direccion = dataObject.getValue(i + "", Constants.NOMBRE_VIA);
			String numero = dataObject.getValue(i + "", Constants.NUM_VIA);
			String direccionTotal = provincia + " " + poblacion + " " + direccion + " " + numero;

			printLogProcessPercentage("Iterations - ", i, dataObject.size());

			if(!webDriver.getTextInFrame(provinciaInput, cuerpoFrame).contains(provincia)) {
				webDriver.appendTextInFrame(provinciaInput, cuerpoFrame, provincia);

				dropDownPresent = webDriver.isPresentAndClickInFrame(matchFoundElementBtn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de provincia no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			if(dropDownPresent && !webDriver.getTextInFrame(poblacionInput, cuerpoFrame).contains(poblacion)) {
				webDriver.appendTextInFrame(poblacionInput, cuerpoFrame, poblacion);

				dropDownPresent = webDriver.isPresentAndClickInFrame(matchFoundElementBtn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de población no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			if(dropDownPresent && !webDriver.getTextInFrame(nombreViaInput, cuerpoFrame).contains(direccion)) {
				webDriver.appendTextInFrame(nombreViaInput, cuerpoFrame, direccion);

				dropDownPresent = webDriver.isPresentAndClickInFrame(matchFoundElementViaBtn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de via no encontrado en el dropdown\n" + direccionTotal);
				}
			}

			if(webDriver.isPresentInFrame(numeroViaInput, cuerpoFrame)) {
				webDriver.appendTextInFrame(numeroViaInput, cuerpoFrame, numero);
			}

			if(webDriver.isPresentInFrame(codigoPostalInput, cuerpoFrame)) {
				String codigoPostal = dataObject.getValue(i + "", Constants.CODIGO_POSTAL);

				webDriver.appendTextInFrame(codigoPostalInput, cuerpoFrame, codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
			}

			if(dropDownPresent) {
				try {
					webDriver.clickInFrame(buscarBtn, cuerpoFrame);

					debugInfo(webDriver.isPresentInFrame(resultadoBusquedaTxt, cuerpoFrame) ? "Dirección normalizada"
						: "Direccion no encontrada\n" + direccionTotal);
				} catch(UnhandledAlertException e) {
					debugError(webDriver.getAlertText());
					webDriver.acceptAlert();
				}
			}
		}

		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		webDriver.quit();

		debugEnd();

		return this;
	}

	public UbicacionRiesgoPage iterarEdificiosPorReferencias(String nombreFichero) {
		debugBegin();

		webDriver.isPresentAndClickInFrame(anadirInmueblePantallaPrincipalBtn, cuerpoFrame);
		webDriver.clickInFrame(criterioBusquedaReferenciaCatastralBtn, cuerpoFrame);

		DataObject dataObject = new DataObject(csvFileToMData(nombreFichero));

		for(int i = 0; i < dataObject.size(); i++) {
			String refCat = dataObject.getValue(i + "", Constants.REFERENCIA_CATASTRAL);

			printLogProcessPercentage("Iterations - ", i, dataObject.size());

			try {
				webDriver.appendTextInFrame(referenciaCatastralInput, cuerpoFrame, refCat);

				webDriver.clickInFrame(buscarBtn, cuerpoFrame);

				if(webDriver.isPresentInFrame(mensajeModalErrorTxt, cuerpoFrame)) {
					debugInfo("Referencia catastral no encontrada\n" + refCat);
					webDriver.clickInFrame(modalErrorBtn, cuerpoFrame);
				} else {
					webDriver.waitForElementToBePresentInFrame(resultadoBusquedaTxt, cuerpoFrame);
					debugInfo("Referencia catastral encontrada");
				}
			} catch(UnhandledAlertException e) {
				webDriver.acceptAlert();
				debugInfo("Error con referencia catastral\n" + refCat);
			} catch(Exception e) {
				webDriver.quit();

				new LoginPage(userS)
					.logIn(getConfigVar(Constants.ENTORNO), getTestVar(Constants.ACCESO), getTestVar(Constants.USUARIO));

				new InnovaHomePage(userS)
					.openMutuaEdificioConfort()
					.createNewProject();

				new AsignarMediadorPage(userS)
					.selectMediadorAndClickOnContinuar();

				webDriver.moveToElementInFrame(anadirInmueblePantallaPrincipalBtn, cuerpoFrame);
				webDriver.clickInFrame(criterioBusquedaReferenciaCatastralBtn, cuerpoFrame);
			}
		}

		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		webDriver.quit();

		debugEnd();

		return this;
	}

	public boolean checkNotification() {
		return webDriver.isPresentInFrame(mensajeErrorTxt, cuerpoFrame);
	}

	public boolean closeNotification() {
		debugBegin();

		boolean value = false;

		if(checkNotification()) {
			webDriver.clickInFrame(aceptarBtn, cuerpoFrame);
			value = true;
		}

		debugEnd();

		return value;
	}

	public UbicacionRiesgoPage guardarRefCatastral(String cadenaTexto) {
		debugBegin();

		try {
			String ruta = userS.getReportPath() + "/Polizas.txt";

			FileUtils.appendToFile(ruta, cadenaTexto + "_");
		} catch(Exception e) {
			debugError("Error intentado guardar el fichero Polizas.txt");
		}

		debugEnd();

		return this;
	}
	// endregion
}