package com.amaris.project.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.project.Constants;

public class FichaEdificioPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By menuFrame = By.cssSelector("#leftFrame");

	private By fichaEdificioLink = By.xpath(".//*[text()='Ficha Edificio']");;

	private By rdbDireccion = By.cssSelector("#filtro1");
	private By rdbRefCatastral = By.cssSelector("#filtro2");
	private By rdbProyecto = By.cssSelector("#filtro3");
	private By rdbPoliza = By.cssSelector("#filtro4");
	private By rdbMediador = By.cssSelector("#filtro5");
	private By rdbEstado = By.cssSelector("#filtro6");

	private By txtRefCatastral = By.cssSelector("#BUSC_EDIF_CATASTRO");
	private By txtProyecto = By.cssSelector("#BUSC_EDIF_PROYECTO");
	private By txtPoliza = By.cssSelector("#BUSC_EDIF_POLIZA");
	private By txtMediador = By.cssSelector("#BUSC_EDIF_MEDIADOR");
	private By cmbEstado = By.cssSelector("#BUSC_EDIF_ESTADO");
	private By txtProvincia = By.cssSelector("#BUSC_EDIF_PROVINCIA");
	private By txtPoblacion = By.cssSelector("#BUSC_EDIF_POBLACION");
	private By txtVia = By.cssSelector("#BUSC_EDIF_VIA");
	private By txtPostCod = By.cssSelector("#BUSC_EDIF_POSTCOD");
	private By txtNumVia = By.cssSelector("#BUSC_EDIF_NUMVIA");
	private By compFormPag = By.cssSelector("#formularioPaginacion");

	private By menuDropdown = By.cssSelector("ul.ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all");

	private By menuItem1 = By.xpath("/html/body/ul[1]/li/a");
	private By menuItem2 = By.xpath("/html/body/ul[2]/li/a");
	private By menuItem3 = By.xpath("/html/body/ul[3]/li/a");

	private By resultadoBusqueda = By.cssSelector("table.grid.anchuraCajas");
	private By barraResultados = By.cssSelector("td.headGrid");

	private By refCatResultado = By.xpath("//*[@id='tr1']/td[4]");

	private By btnBuscar = By.cssSelector("[name=''botonBuscar]");
	private By btnContinuar = By.xpath("//*[@id='tr1']/td[6]");

	private By lblDireccion = By.xpath(".//*[text()='Dirección: ']");
	private By lblMediador = By.xpath(".//*[text()='Mediador: ']");
	private By lblDatosMediador = By.xpath(".//*[text()='Datos Mediador: ']");
	private By lblNumViviendas = By.xpath(".//*[text()='Nº Viviendas: '");
	private By lblAntiguedad = By.xpath(".//*[text()='Antigüedad del edificio: ']");
	private By lblSuperficie = By.xpath(".//*[text()='Superficie construida(m2): ']");

	private By tabResumen = By.cssSelector("#pes0");
	private By tabPolizas = By.cssSelector("#pes1");
	// endregion

	public FichaEdificioPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public FichaEdificioPage accederAlBuscadorEdificios() {
		debugBegin();

		webDriver.moveToElementInFrame(fichaEdificioLink, menuFrame);
		webDriver.doubleClickInFrame(fichaEdificioLink, menuFrame);
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
			// Print iteration process percentage
			printLogProcessPercentage("Iterations - ", i, tablaHash.size());

			// Fill referencia_catastral
			webDriver.appendTextInFrame(txtRefCatastral, cuerpoFrame, tablaHash.get(i + "").get("ref_catastral"));

			// Search
			webDriver.clickInFrame(btnBuscar, cuerpoFrame);
			// Wait result
			webDriver.waitForAngular();
			webDriver.waitForElementToBeClickableInFrame(barraResultados, cuerpoFrame);

			if(webDriver.getTextInFrame(refCatResultado, cuerpoFrame)
				.equals(webDriver.getTextInFrame(txtRefCatastral, cuerpoFrame))) {
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
			if(!webDriver.getTextInFrame(txtProvincia, cuerpoFrame).contains(tablaHash.get(i + "").get("provincia"))) {
				// Fill provincia
				webDriver.appendTextInFrame(txtProvincia, cuerpoFrame, tablaHash.get(i + "").get("provincia"));
				dropDownPresent = webDriver.isPresentInFrame(menuItem1, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de provincia no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1, cuerpoFrame);
				}
			}

			// If text in field "poblacion" is not equals to the poblacion(i) value
			if(dropDownPresent && !webDriver.getTextInFrame(txtPoblacion, cuerpoFrame)
				.contains(tablaHash.get(i + "").get("poblacion"))) {
				// Fill poblacion
				webDriver.appendTextInFrame(txtPoblacion, cuerpoFrame, tablaHash.get(i + "").get("poblacion"));
				dropDownPresent = webDriver.isPresentInFrame(menuItem2, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de población no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1, cuerpoFrame);
				}
			}

			// If text in field "direccion" is not equals to the direccion(i) value
			if(dropDownPresent
				&& !webDriver.getTextInFrame(txtVia, cuerpoFrame).contains(tablaHash.get(i + "").get("direccion"))) {
				// Fill direccion
				webDriver.appendTextInFrame(txtVia, cuerpoFrame, tablaHash.get(i + "").get("direccion"));

				dropDownPresent = webDriver.isPresentInFrame(menuItem3, cuerpoFrame);

				if(!dropDownPresent) {
					debugInfo("Nombre de vía no encontrado en el dropdown\n" + address);
				} else {
					webDriver.clickInFrame(menuItem1, cuerpoFrame);
				}
			}

			// Fill numero
			if(webDriver.isPresentInFrame(txtNumVia, cuerpoFrame)) {
				webDriver.appendTextInFrame(txtNumVia, cuerpoFrame, tablaHash.get(i + "").get("numero"));
			}

			// Fill codigo postal
			if(webDriver.isPresentInFrame(txtPostCod, cuerpoFrame)) {
				String codigoPostal = tablaHash.get(i + "").get("codigo_postal");
				webDriver.appendTextInFrame(txtPostCod, cuerpoFrame, codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
			}

			if(dropDownPresent) {
				try {
					// Search
					webDriver.clickInFrame(btnBuscar, cuerpoFrame);

					// Wait result
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
				webDriver.clickInFrame(rdbDireccion, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_CATASTRAL:
				webDriver.clickInFrame(rdbRefCatastral, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_PROYECTO:
				webDriver.clickInFrame(rdbProyecto, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_POLIZA:
				webDriver.clickInFrame(rdbPoliza, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_MEDIADOR:
				webDriver.clickInFrame(rdbMediador, cuerpoFrame);
				break;
			case Constants.FILTRO_BUSCADOR_ESTADO:
				webDriver.clickInFrame(rdbEstado, cuerpoFrame);
				break;
			default:
		}

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarConFiltroBusqueda() {
		debugBegin();

		switch(Constants.FILTRO_BUSCADOR_EDIFICIO) {
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

		webDriver.clickInFrame(btnBuscar, cuerpoFrame);

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioRefCatastral() {
		debugBegin();

		webDriver.clickInFrame(rdbRefCatastral, cuerpoFrame);
		webDriver.setTextInFrame(txtRefCatastral, cuerpoFrame, getTestVar(Constants.REFERENCIA_CATASTRAL));

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioProyecto() {
		debugBegin();

		webDriver.clickInFrame(rdbProyecto, cuerpoFrame);
		webDriver.setTextInFrame(txtProyecto, cuerpoFrame, getTestVar(Constants.PROYECTO));

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioPoliza() {
		debugBegin();

		webDriver.clickInFrame(rdbPoliza, cuerpoFrame);
		webDriver.setTextInFrame(txtPoliza, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioMediador() {
		debugBegin();

		webDriver.clickInFrame(rdbMediador, cuerpoFrame);
		webDriver.setTextInFrame(txtMediador, cuerpoFrame, getTestVar(Constants.MEDIADOR));

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioDireccion() {
		debugBegin();

		webDriver.clickInFrame(rdbDireccion, cuerpoFrame);

		fillEdificioDireccion();

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage fillEdificioDireccion() {
		fillEdificioDireccion(
			getTestVar(Constants.PROVINCIA), getTestVar(Constants.POBLACION), 
			getTestVar(Constants.NOMBRE_VIA), getTestVar(Constants.NUM_VIA), null);
		
		return this;
	}

	public FichaEdificioPage fillEdificioDireccion(String provincia, String poblacion, String nombreVia, String numVia, String codigoPostal) {
		debugBegin();

		if(provincia != null) {
			webDriver.appendTextInFrame(txtProvincia, cuerpoFrame, provincia);
			webDriver.clickInFrame(menuItem1, cuerpoFrame);
		}

		if(poblacion != null) {
			webDriver.appendTextInFrame(txtPoblacion, cuerpoFrame, poblacion);
			webDriver.clickInFrame(menuItem2, cuerpoFrame);
		}

		if(nombreVia != null) {
			webDriver.appendTextInFrame(txtVia, cuerpoFrame, nombreVia);
			webDriver.clickInFrame(menuItem3, cuerpoFrame);
		}

		if(numVia != null) {
			webDriver.appendTextInFrame(txtNumVia, cuerpoFrame, numVia);
		}

		if(codigoPostal != null) {
			webDriver.appendTextInFrame(txtPostCod, cuerpoFrame, codigoPostal);
		}

		debugEnd();
		
		return this;
	}

	public FichaEdificioPage buscarEdificioEstado() {
		debugBegin();

		webDriver.clickInFrame(rdbEstado, cuerpoFrame);
		webDriver.clickElementFromDropDownByTextInFrame(cmbEstado, cuerpoFrame, getTestVar(Constants.ESTADO_EDIFICIO));

		debugEnd();
		
		return this;
	}

	public boolean checkResultadoDireccion() {
		debugBegin();

		boolean result = checkResultadoDireccion(
			webDriver.getTextInFrame(txtPoblacion, cuerpoFrame), 
			webDriver.getTextInFrame(txtVia, cuerpoFrame), 
			webDriver.getTextInFrame(txtNumVia, cuerpoFrame), null, null);

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
		boolean check = false;

		// TODO Pero esto que es? Refactorizar
		check = webDriver.isPresentInFrame(lblDireccion, cuerpoFrame);
		check = webDriver.isPresentInFrame(lblMediador, cuerpoFrame);
		check = webDriver.isPresentInFrame(lblDatosMediador, cuerpoFrame);
		check = webDriver.isPresentInFrame(lblNumViviendas, cuerpoFrame);
		check = webDriver.isPresentInFrame(lblAntiguedad, cuerpoFrame);
		check = webDriver.isPresentInFrame(lblSuperficie, cuerpoFrame);

		debugEnd();

		return check;
	}

	public boolean checkPestanaResumenVisible() {
		debugBegin();
		boolean check = false;

		check = webDriver.isPresentInFrame(tabResumen, cuerpoFrame);

		debugEnd();

		return check;
	}

	public boolean checkPestanaPolizasVisible() {
		debugBegin();
		boolean check = false;

		check = webDriver.isPresentInFrame(tabPolizas, cuerpoFrame);

		debugEnd();

		return check;
	}
	// endregion
}