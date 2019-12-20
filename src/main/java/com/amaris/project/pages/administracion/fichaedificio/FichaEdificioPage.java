package com.amaris.project.pages.administracion.fichaedificio;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.project.Constants;

public class FichaEdificioPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");
	private By menuFrame = By.cssSelector("#leftFrame");

	private By fichaEdificioBtn = By.xpath(".//*[text()='Ficha Edificio']");

	private By direccionBtn = By.cssSelector("#filtro1");
	private By refCatastralBtn = By.cssSelector("#filtro2");
	private By proyectoBtn = By.cssSelector("#filtro3");
	private By polizaBtn = By.cssSelector("#filtro4");
	private By mediadorBtn = By.cssSelector("#filtro5");
	private By estadoBtn = By.cssSelector("#filtro6");

	private By refCatastralInput = By.cssSelector("#BUSC_EDIF_CATASTRO");
	private By proyectoInput = By.cssSelector("#BUSC_EDIF_PROYECTO");
	private By polizaInput = By.cssSelector("#BUSC_EDIF_POLIZA");
	private By mediadorInput = By.cssSelector("#BUSC_EDIF_MEDIADOR");
	private By estadoDrpDwn = By.cssSelector("#BUSC_EDIF_ESTADO");
	private By provinciaInput = By.cssSelector("#BUSC_EDIF_PROVINCIA");
	private By poblacionInput = By.cssSelector("#BUSC_EDIF_POBLACION");
	private By viaInput = By.cssSelector("#BUSC_EDIF_VIA");
	private By postCodInput = By.cssSelector("#BUSC_EDIF_POSTCOD");
	private By numViaInput = By.cssSelector("#BUSC_EDIF_NUMVIA");

	private By menuItem1Btn = By.xpath("/html/body/ul[1]/li/a");
	private By menuItem2Btn = By.xpath("/html/body/ul[2]/li/a");
	private By menuItem3Btn = By.xpath("/html/body/ul[3]/li/a");

	private By resultadoBusqueda = By.cssSelector("table.grid.anchuraCajas");
	private By barraResultados = By.cssSelector("td.headGrid");

	private By refCatResultadoTxt = By.xpath("//*[@id='tr1']/td[4]");

	private By buscarBtn = By.cssSelector("[name=''botonBuscar]");
	private By btnContinuar = By.xpath("//*[@id='tr1']/td[6]");

	private By direccionTxt = By.xpath(".//*[text()='Dirección: ']");
	private By mediadorTxt = By.xpath(".//*[text()='Mediador: ']");
	private By datosMediadorTxt = By.xpath(".//*[text()='Datos Mediador: ']");
	private By numViviendasTxt = By.xpath(".//*[text()='Nº Viviendas: '");
	private By antiguedadTxt = By.xpath(".//*[text()='Antigüedad del edificio: ']");
	private By superficieTxt = By.xpath(".//*[text()='Superficie construida(m2): ']");

	private By resumenTab = By.cssSelector("#pes0");
	private By polizasTab = By.cssSelector("#pes1");
	// endregion

	public FichaEdificioPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public FichaEdificioPage accederAlBuscadorEdificios() {
		debugBegin();

		webDriver.doubleClickInFrame(fichaEdificioBtn, menuFrame);
		webDriver.waitForAngular();

		debugEnd();

		return this;
	}

	public FichaEdificioPage printLogProcessPercentage(String message, int current, int total) {
		if((int) ((double) current / (double) total * 100) > (int) ((double) current - 1 / (double) total * 100)) {
			debugInfo(message + (int) ((double) current / (double) total * 100) + "%");
		}

		return this;
	}

	public FichaEdificioPage iterarEdificiosPorReferencias(String nombreFichero) {
		debugBegin();
		// Read file and fill HashMap
		Map<String, Map<String, String>> tablaHash = FileUtils.csvFileToMData(nombreFichero);

		// Iterate by number of lines
		for(int i = 0; i < tablaHash.size(); i++) {
			printLogProcessPercentage("Iterations - ", i, tablaHash.size());

			webDriver.appendTextInFrame(refCatastralInput, cuerpoFrame, tablaHash.get(i + "").get("ref_catastral"));

			webDriver.clickInFrame(buscarBtn, cuerpoFrame);

			webDriver.waitForAngular();
			webDriver.waitForElementToBeClickableInFrame(barraResultados, cuerpoFrame);

			if(webDriver.getTextInFrame(refCatResultadoTxt, cuerpoFrame)
				.equals(webDriver.getTextInFrame(refCatastralInput, cuerpoFrame))) {
				debugInfo("Referencia catastral encontrada");
			} else {
				debugInfo("Referencia catastral no encontrada");
			}
		}

		debugEnd();

		return this;
	}

	public FichaEdificioPage iterarEdificiosPorDirecciones(String nombreFichero) {
		debugBegin();

		// Reads file and fill HashMap
		Map<String, Map<String, String>> tablaHash;

		// Loads data in a HashMap by sections depending on "sectionSize"
		tablaHash = FileUtils.csvFileToMData(nombreFichero);
		// Iterate by number of lines
		for(int i = 0; i < tablaHash.size(); i++) {
			boolean dropDownPresent = true;

			String address = tablaHash.get(i + "").get("provincia") + " " + tablaHash.get(i + "").get("poblacion") + " "
				+ tablaHash.get(i + "").get("direccion") + " " + tablaHash.get(i + "").get("numero");

			// If text in field "provincia" is not equals to the provincia(i) value
			if(!webDriver.getTextInFrame(provinciaInput, cuerpoFrame).contains(tablaHash.get(i + "").get("provincia"))) {
				// Fill provincia
				webDriver.appendTextInFrame(provinciaInput, cuerpoFrame, tablaHash.get(i + "").get("provincia"));
				dropDownPresent = webDriver.isPresentInFrame(menuItem1Btn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de provincia no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1Btn, cuerpoFrame);
				}
			}

			// If text in field "poblacion" is not equals to the poblacion(i) value
			if(dropDownPresent && !webDriver.getTextInFrame(poblacionInput, cuerpoFrame)
				.contains(tablaHash.get(i + "").get("poblacion"))) {
				// Fill poblacion
				webDriver.appendTextInFrame(poblacionInput, cuerpoFrame, tablaHash.get(i + "").get("poblacion"));
				dropDownPresent = webDriver.isPresentInFrame(menuItem2Btn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de población no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1Btn, cuerpoFrame);
				}
			}

			if(dropDownPresent && !webDriver.getTextInFrame(viaInput, cuerpoFrame).contains(tablaHash.get(i + "").get("direccion"))) {
				webDriver.appendTextInFrame(viaInput, cuerpoFrame, tablaHash.get(i + "").get("direccion"));

				dropDownPresent = webDriver.isPresentInFrame(menuItem3Btn, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de vía no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1Btn, cuerpoFrame);
				}
			}

			if(webDriver.isPresentInFrame(numViaInput, cuerpoFrame)) {
				webDriver.appendTextInFrame(numViaInput, cuerpoFrame, tablaHash.get(i + "").get("numero"));
			}

			if(webDriver.isPresentInFrame(postCodInput, cuerpoFrame)) {
				String codigoPostal = tablaHash.get(i + "").get("codigo_postal");

				webDriver.appendTextInFrame(postCodInput, cuerpoFrame, codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
			}

			if(dropDownPresent) {
				try {
					webDriver.clickInFrame(buscarBtn, cuerpoFrame);

					debugInfo(webDriver.isPresentInFrame(resultadoBusqueda, cuerpoFrame) ? "Dirección normalizada"
						: "Direccion no encontrada\n" + address);
					webDriver.waitForElementToBeClickableInFrame(resultadoBusqueda, cuerpoFrame);

				} catch(UnhandledAlertException e) {
					webDriver.acceptAlert();
					debugInfo(address);
				}
			}
		}

		debugEnd();

		return this;
	}

	/**
	 * Selects the comboBox filter option as the searchFilter value
	 *
	 * @param searchFilter
	 */
	public FichaEdificioPage setFiltroBusqueda(String searchFilter) {
		setTestVar(Constants.FILTRO_BUSCADOR_EDIFICIO, searchFilter);
		setFiltroBusqueda();

		return this;
	}

	/**
	 * Selects the comboBox filter option set in the testData variable FiltroBuscadorEdificio
	 */
	public FichaEdificioPage setFiltroBusqueda() {
		debugBegin();

		switch(getTestVar(Constants.FILTRO_BUSCADOR_EDIFICIO)) {
			case Constants.FILTRO_BUSCADOR_DIRECCION:
				webDriver.clickInFrame(direccionBtn, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_CATASTRAL:
				webDriver.clickInFrame(refCatastralBtn, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_PROYECTO:
				webDriver.clickInFrame(proyectoBtn, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_POLIZA:
				webDriver.clickInFrame(polizaBtn, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_MEDIADOR:
				webDriver.clickInFrame(mediadorBtn, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_ESTADO:
				webDriver.clickInFrame(estadoBtn, cuerpoFrame);
				break;
			default:
		}

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarConFiltroBusqueda() {
		debugBegin();

		switch(getTestVar(Constants.FILTRO_BUSCADOR_EDIFICIO)) {
			case Constants.FILTRO_BUSCADOR_DIRECCION:
				buscarEdificioDireccion();
				break;
			case Constants.FILTRO_BUSCADOR_CATASTRAL:
				buscarEdificioRefCatastral();
				break;
			case Constants.FILTRO_BUSCADOR_PROYECTO:
				buscarEdificioProyecto();
				break;
			case Constants.FILTRO_BUSCADOR_POLIZA:
				buscarEdificioPoliza();
				break;
			case Constants.FILTRO_BUSCADOR_MEDIADOR:
				buscarEdificioMediador();
				break;
			case Constants.FILTRO_BUSCADOR_ESTADO:
				buscarEdificioEstado();
				break;
			default:
				buscarEdificioDireccion();
				break;
		}

		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioRefCatastral() {
		debugBegin();

		webDriver.clickInFrame(refCatastralBtn, cuerpoFrame);
		webDriver.setTextInFrame(refCatastralInput, cuerpoFrame, getTestVar(Constants.REFERENCIA_CATASTRAL));

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioProyecto() {
		debugBegin();

		webDriver.clickInFrame(proyectoBtn, cuerpoFrame);
		webDriver.setTextInFrame(proyectoInput, cuerpoFrame, getTestVar(Constants.PROYECTO));

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioPoliza() {
		debugBegin();

		webDriver.clickInFrame(polizaBtn, cuerpoFrame);
		webDriver.setTextInFrame(polizaInput, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioMediador() {
		debugBegin();

		webDriver.clickInFrame(mediadorBtn, cuerpoFrame);
		webDriver.setTextInFrame(mediadorInput, cuerpoFrame, getTestVar(Constants.MEDIADOR));

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioDireccion() {
		debugBegin();

		webDriver.clickInFrame(direccionBtn, cuerpoFrame);

		fillEdificioDireccion();

		debugEnd();

		return this;
	}

	public FichaEdificioPage fillEdificioDireccion() {
		fillEdificioDireccion(getTestVar(Constants.PROVINCIA), getTestVar(Constants.POBLACION), getTestVar(Constants.NOMBRE_VIA), getTestVar(Constants.NUM_VIA), null);

		return this;
	}

	public FichaEdificioPage fillEdificioDireccion(String provincia, String poblacion, String nombreVia, String numVia, String codigoPostal) {
		debugBegin();

		if(provincia != null) {
			webDriver.appendTextInFrame(provinciaInput, cuerpoFrame, provincia);
			webDriver.clickInFrame(menuItem1Btn, cuerpoFrame);
		}

		if(poblacion != null) {
			webDriver.appendTextInFrame(poblacionInput, cuerpoFrame, poblacion);
			webDriver.clickInFrame(menuItem2Btn, cuerpoFrame);
		}

		if(nombreVia != null) {
			webDriver.appendTextInFrame(viaInput, cuerpoFrame, nombreVia);
			webDriver.clickInFrame(menuItem3Btn, cuerpoFrame);
		}

		if(numVia != null) {
			webDriver.appendTextInFrame(numViaInput, cuerpoFrame, numVia);
		}

		if(codigoPostal != null) {
			webDriver.appendTextInFrame(postCodInput, cuerpoFrame, codigoPostal);
		}

		debugEnd();

		return this;
	}

	public FichaEdificioPage buscarEdificioEstado() {
		debugBegin();

		webDriver.clickInFrame(estadoBtn, cuerpoFrame);
		webDriver.clickElementFromDropDownByTextInFrame(estadoDrpDwn, cuerpoFrame, getTestVar(Constants.ESTADO_EDIFICIO));

		debugEnd();

		return this;
	}

	public boolean checkResultadoDireccion() {
		debugBegin();

		boolean result = checkResultadoDireccion(
			webDriver.getTextInFrame(poblacionInput, cuerpoFrame), 
			webDriver.getTextInFrame(viaInput, cuerpoFrame), 
			webDriver.getTextInFrame(numViaInput, cuerpoFrame), null, null);

		debugEnd();

		return result;
	}

	public boolean checkResultadoDireccion(String poblacion, String nombreVia, String numVia, String refCatastral, String estado) {
		debugBegin();

		boolean check = false;

		webDriver.waitForElementToBeClickableInFrame(resultadoBusqueda, cuerpoFrame);

		if(poblacion != null) {
			check = webDriver.isPresentInFrame(By.xpath(".//td[contains(text(), '" + poblacion + "')]"), cuerpoFrame);
		}

		if(nombreVia != null) {
			check = webDriver.isPresentInFrame(By.xpath(".//td[contains(text(), '" + nombreVia + "')]"), cuerpoFrame);
		}

		if(numVia != null) {
			check = webDriver.isPresentInFrame(By.xpath(".//td[contains(text(), '" + numVia + "')]"), cuerpoFrame);
		}

		if(refCatastral != null) {
			check = webDriver.isPresentInFrame(By.xpath(".//td[contains(text(), '" + refCatastral.toUpperCase() + "')]"), cuerpoFrame);
		}

		if(estado != null) {
			check = webDriver.isPresentInFrame(By.xpath(".//td[contains(text(), '" + estado + "')]"), cuerpoFrame);
		}

		debugEnd();

		return check;
	}

	public FichaEdificioPage openFichaEdificioDesdeGrid() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public boolean checkCabeceraFicha() {
		debugBegin();

		boolean check = webDriver.isPresentInFrame(direccionTxt, cuerpoFrame);

		check = check && webDriver.isPresentInFrame(mediadorTxt, cuerpoFrame);
		check = check && webDriver.isPresentInFrame(datosMediadorTxt, cuerpoFrame);
		check = check && webDriver.isPresentInFrame(numViviendasTxt, cuerpoFrame);
		check = check && webDriver.isPresentInFrame(antiguedadTxt, cuerpoFrame);
		check = check && webDriver.isPresentInFrame(superficieTxt, cuerpoFrame);

		debugEnd();

		return check;
	}

	public boolean checkPestanaResumenVisible() {
		debugBegin();

		boolean check = false;

		check = webDriver.isPresentInFrame(resumenTab, cuerpoFrame);

		debugEnd();

		return check;
	}

	public boolean checkPestanaPolizasVisible() {
		debugBegin();

		boolean check = false;

		check = webDriver.isPresentInFrame(polizasTab, cuerpoFrame);

		debugEnd();

		return check;
	}
	// endregion
}