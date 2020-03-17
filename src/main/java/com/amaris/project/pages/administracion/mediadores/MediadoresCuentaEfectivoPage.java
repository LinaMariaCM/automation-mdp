package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresCuentaEfectivoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//----Seleccionar anyo------------
	private By seleccionarAnyoBtn = By.cssSelector("#cabAnio");

	//------Filtrar ------------
	private By filtrarBtn = By.cssSelector("#cabFiltrar");

	//------Exportar----------
	private By exportarBtn = By.cssSelector("#cabFiltrar");

	//---------------Alta de movimiento--------------
	private By altaMovimientoBtn = By.cssSelector("#cabAlta");
	private By volverAltaMovBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li.rightList.js-action > a");
	private By fechaDatosInput = By.cssSelector("#fechmovi");
	private By conceptoInput = By.cssSelector("#aux533");
	private By descripcionInput = By.cssSelector("#descripcion");
	private By importeInput = By.cssSelector("#importe");
	private By observacionesInput = By.cssSelector("#observaciones");
	private By agregarMovimientoBtn = By.cssSelector("#botonAgregar");

	//--------Importar movimiento-----
	private By importarMovimientoBtn = By.cssSelector("#cabImportar");

	//---------Mas acciones-------------
	private By masAccionesBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li.js-actionsbar > a > span");

	private By generarPagoAdeudoBtn = By.cssSelector("#cabPagAdeu");
	private By calcularImportesBtn = By.cssSelector("#cabCalcularu");
	private By grabarCalcImporteBtn = By.cssSelector("#buttonRecord");

	public MediadoresCuentaEfectivoPage(UserStory userS) {
		super(userS);
	}

	public MediadoresCuentaEfectivoPage clickSeleccionarAnyo() {
		debugBegin();
		webDriver.clickInFrame(seleccionarAnyoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickFiltrar() {
		debugBegin();
		webDriver.clickInFrame(filtrarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickExportar() {
		debugBegin();
		webDriver.clickInFrame(exportarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickAltaMovimiento() {
		debugBegin();
		webDriver.clickInFrame(altaMovimientoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickVolverAltaMovimiento() {
		debugBegin();
		webDriver.clickInFrame(volverAltaMovBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickImportarMovimiento() {
		debugBegin();
		webDriver.clickInFrame(importarMovimientoBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickMasAcciones() {
		debugBegin();
		webDriver.clickInFrame(masAccionesBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickCalcularImportes() {
		debugBegin();
		webDriver.clickInFrame(calcularImportesBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresCuentaEfectivoPage clickGrabarCalcularImporte() {
		debugBegin();
		webDriver.clickInFrame(grabarCalcImporteBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

}
