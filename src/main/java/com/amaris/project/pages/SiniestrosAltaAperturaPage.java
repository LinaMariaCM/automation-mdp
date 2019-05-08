package com.amaris.project.pages;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class SiniestrosAltaAperturaPage extends PageObject {

	public SiniestrosAltaAperturaPage(UserStory userS) {
		super(userS);
	}

	// region webelements
	//
	private By menuFrame = By.id("leftFrame");
	//
	private By topFrame = By.id("topFrame");
	//
	private By mainFrame = By.id("mainFrame");
	//
	private By rdbtnNumPoliza = By.id("filtro1");
	//
	private By rdbtnNombreTomador = By.id("filtro2");
	//
	private By rdbtnNIF = By.id("filtro3");
	//
	private By rdbtnDireccion = By.id("filtro4");
	//
	private By rdbtnPolProcedencia = By.id("filtro5");
	//
	private By rdbtnOtros = By.id("filtro6");
	//
	// private By btnContinuar =
	// By.xpath(".//*[@id='capaAjax']/table[4]/tbody/tr[2]/td[12]/a/span");
	private By btnContinuar = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(12) > a > span");
	//
	private By btnBuscar = By.name("botonBuscar");
	//
	private By comboProducto = By.id("producto_poliza");
	//
	private By txtNumPoliza = By.id("polizsec");
	//
	private By rdbtnEmpiezaPor = By.id("empiezapor");
	//
	private By rdbtnContiene = By.id("contiene");
	//
	private By txtNombre = By.id("nombpcom");
	//
	private By txtNifDocumento = By.id("numedocu");
	//
	private By txtProvincia = By.id("BUSC_EDIF_PROVINCIA");
	//
	private By txtPoblacion = By.id("BUSC_EDIF_POBLACION");
	//
	private By txtVia = By.id("BUSC_EDIF_VIA");
	//
	private By txtNumVia = By.id("BUSC_EDIF_NUMVIA");
	//
	private By txtRestoVia = By.id("BUSC_EDIF_RESTVIA");
	//
	private By txtCodigoPostal = By.id("BUSC_EDIF_POSTCOD");
	//
	private By txtPolProcedencia = By.id("poliproce");
	//
	private By txtFechaDesde = By.id("desde");
	//
	private By txtFechaHasta = By.id("hasta");
	//
	private By comboEstado = By.id("estado");
	//
	private By comboLineaNegocio = By.id("producto");
	//
	private By txtCodMediador = By.id("codMediador");
	//
	private By comboIntervalo = By.id("intervalo");
	//
	private By comboPaginas = By.id("paginas");
	//

	// endregion

	// Busqueda por numero de póliza
	public void buscarNumPoliza(String numPoliza) {
		this.debugBegin();

		this.webDriver.switchToFrame(this.mainFrame);
		this.webDriver.waitForElementToBeClickable(this.rdbtnNumPoliza);
		this.webDriver.click(this.rdbtnNumPoliza);
		this.webDriver.setText(this.txtNumPoliza, numPoliza);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por numero de póliza eligiendo ramo
	public void buscarNumPoliza(String codigoProducto, String numPoliza) {
		this.debugBegin();

		this.webDriver.switchToFrame(this.mainFrame);
		this.webDriver.waitForElementToBeClickable(this.rdbtnNumPoliza);
		this.webDriver.click(this.rdbtnNumPoliza);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboProducto, "value", codigoProducto);
		this.webDriver.setText(this.txtNumPoliza, numPoliza);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por nombre de tomador(empieza)
	public void buscarEmpiezaTomador(String nombreTomador) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnNombreTomador);
		this.webDriver.click(this.rdbtnEmpiezaPor);
		this.webDriver.setText(this.txtNombre, nombreTomador);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por nombre de tomador(contiene)
	public void buscarContieneTomador(String nombreTomador) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnNombreTomador);
		this.webDriver.click(this.rdbtnContiene);
		this.webDriver.setText(this.txtNombre, nombreTomador);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por NIF
	public void buscarNIF(String NIF) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnNIF);
		this.webDriver.setText(this.txtNifDocumento, NIF);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por Poliza de procendencia
	public void buscarPolizaProcedencia(String numPoliza) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnPolProcedencia);
		this.webDriver.setText(this.txtPolProcedencia, numPoliza);
		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por Otros
	public void buscarOtros(String desde, String hasta, String estado, String lineaNegocio, String mediador) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnOtros);

		this.webDriver.setText(this.txtFechaDesde, desde);
		this.webDriver.setText(this.txtFechaHasta, hasta);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboEstado, "value", estado); // estados
																								// V
																								// =
																								// vigor,
																								// A
																								// =
																								// Anulada,
																								// F
																								// =
																								// Vencida
		this.webDriver.clickElementFromDropDownByAttribute(this.comboLineaNegocio, "value", lineaNegocio);// Lineas
																											// Negocio
																											// 920,
																											// 510,
																											// 660,
																											// 640,
																											// 500
		this.webDriver.setText(this.txtCodMediador, mediador);

		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Busqueda por Otros (solo fecha y ramo)
	public void buscarOtros(String desde, String hasta, String lineaNegocio) {
		this.debugBegin();

		this.webDriver.click(this.rdbtnOtros);
		this.webDriver.setText(this.txtFechaDesde, desde);
		this.webDriver.setText(this.txtFechaHasta, hasta);
		this.webDriver.clickElementFromDropDownByAttribute(this.comboLineaNegocio, "value", lineaNegocio);// Ramos
																											// 920,
																											// 510,
																											// 660,
																											// 640,
																											// 500

		this.webDriver.click(this.btnBuscar);

		this.debugEnd();
	}

	// Continuar
	public void continuarPrimeraPoliza() {
		this.debugBegin();

		this.webDriver.click(this.btnContinuar);

		this.debugEnd();
	}

	// Busqueda por Direccion con la información obligatoriav TBD
	/*
	 * public void buscarDireccion(String provincia, String poblacion, String
	 * via, String numVia) { this.debugBegin();
	 * 
	 * this.webDriver.click(rdbtnDireccion);
	 * this.webDriver.appendText(txtProvincia, provincia);
	 * this.webDriver.appendText(txtPoblacion, poblacion);
	 * this.webDriver.appendText(txtVia, via);
	 * this.webDriver.appendText(txtNumVia, numVia);
	 * this.webDriver.click(btnBuscar);
	 * 
	 * this.debugEnd(); }
	 */

	// endregion
}