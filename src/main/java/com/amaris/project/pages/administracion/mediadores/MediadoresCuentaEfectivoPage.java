package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresCuentaEfectivoPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//----Seleccionar año------------
	private By seleccionarAnyoBtn = By.cssSelector("#cabAnio");
	private By selecionarAnyoCombo = By.cssSelector("#mescuenta");
	private By quitarCriterioSeleccionBtn = By.cssSelector("#formBuscador > div > span > a");

	//------Filtrar ------------
	private By filtrarBtn = By.cssSelector("#cabFiltrar");
	private By aplicarFiltroBtn = By.cssSelector("#botonFiltrar");

	//------Exportar----------
	private By exportarBtn = By.cssSelector("#cabFiltrar");

	//---------------Alta de movimiento--------------
	private By altaMovimientoBtn = By.cssSelector("#cabAlta");
	private By volverBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li.rightList.js-action > a");
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
	private By versionImpresoraBtn = By.cssSelector("#cabGraficos");

	private By generarPagoAdeudoBtn = By.cssSelector("#cabPagAdeu");
	private By calcularImportesBtn = By.cssSelector("#cabCalcularu");
	private By grabarCalcImporteBtn = By.cssSelector("#buttonRecord");

	public MediadoresCuentaEfectivoPage(UserStory userS) {
		super(userS);
	}

}
