package com.amaris.project.pages.administracion.siniestros.apertura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import java.util.List;

public class AltaAperturaSiniestrosPage extends PageObject {

	// region webelements
	private By menuFrame = By.id("leftFrame");
	private By topFrame = By.id("topFrame");
	private By mainFrame = By.id("mainFrame");

	private By rdbtnNumPoliza = By.id("filtro1");
	private By rdbtnNombreTomador = By.id("filtro2");
	private By rdbtnNIF = By.id("filtro3");
	private By rdbtnDireccion = By.id("filtro4");
	private By rdbtnPolProcedencia = By.id("filtro5");
	private By rdbtnOtros = By.id("filtro6");

	private By btnContinuar = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(2) > td:nth-child(12) > a > span");
	private By btnBuscar = By.name("botonBuscar");
	private By comboProducto = By.id("producto_poliza");

	private By txtNumPoliza = By.id("polizsec");
	private By rdbtnEmpiezaPor = By.id("empiezapor");
	private By rdbtnContiene = By.id("contiene");
	private By txtNombre = By.id("nombpcom");
	private By txtNifDocumento = By.id("numedocu");
	private By txtProvincia = By.id("BUSC_EDIF_PROVINCIA");
	private By txtPoblacion = By.id("BUSC_EDIF_POBLACION");
	private By txtVia = By.id("BUSC_EDIF_VIA");
	private By txtNumVia = By.id("BUSC_EDIF_NUMVIA");
	private By txtRestoVia = By.id("BUSC_EDIF_RESTVIA");
	private By txtCodigoPostal = By.id("BUSC_EDIF_POSTCOD");
	private By txtPolProcedencia = By.id("poliproce");
	private By txtFechaDesde = By.id("desde");
	private By txtFechaHasta = By.id("hasta");

	private By comboEstado = By.id("estado");
	private By comboLineaNegocio = By.id("producto");
	private By txtCodMediador = By.id("codMediador");
	private By comboIntervalo = By.id("intervalo");
	private By comboPaginas = By.id("paginas");

	private By polizas50 = By.cssSelector(".lnkViewAllResults");

	private By selectPoliza = By.cssSelector(".si-button2.si-arrow-right");
	// private By selectPoliza = By.cssSelector("#capaAjax > table > tbody > tr:nth-child("+
	// Integer.toString((int)((Math.random()*51))) +") > td:nth-child(12) > a > span");

	// endregion

	public AltaAperturaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public AltaAperturaSiniestrosPage buscar50Polizas() {
		debugBegin();

		webDriver.clickInFrame(polizas50, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNumPoliza(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(rdbtnNumPoliza, mainFrame);
		webDriver.setTextInFrame(txtNumPoliza, mainFrame, numPoliza);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNumPoliza(String codigoProducto, String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(rdbtnNumPoliza, mainFrame);
		// webDriver.clickElementFromDropDownByAttribute(comboProducto, "value", codigoProducto);
		webDriver.clickElementFromDropDownByIndexInFrame(comboProducto, mainFrame, 0);
		webDriver.setTextInFrame(txtNumPoliza, mainFrame, numPoliza);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNombreTomador(String nombreTomador) {
		debugBegin();

		webDriver.clickInFrame(rdbtnNombreTomador, mainFrame);
		webDriver.clickInFrame(rdbtnEmpiezaPor, mainFrame);
		webDriver.setTextInFrame(txtNombre, mainFrame, nombreTomador);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarContieneNombreTomador(String nombreTomador) {
		debugBegin();

		webDriver.clickInFrame(rdbtnNombreTomador, mainFrame);
		webDriver.clickInFrame(rdbtnContiene, mainFrame);
		webDriver.setTextInFrame(txtNombre, mainFrame, nombreTomador);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPorNIF(String nif) {
		debugBegin();

		webDriver.clickInFrame(rdbtnNIF, mainFrame);
		webDriver.setTextInFrame(txtNifDocumento, mainFrame, nif);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarPolizaProcedencia(String numPoliza) {
		debugBegin();

		webDriver.clickInFrame(rdbtnPolProcedencia, mainFrame);
		webDriver.setTextInFrame(txtPolProcedencia, mainFrame, numPoliza);
		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage buscarOtros(String desde, String hasta, String estado, String lineaNegocio, String mediador) {
		debugBegin();

		webDriver.clickInFrame(rdbtnOtros, mainFrame);

		webDriver.setTextInFrame(txtFechaDesde, mainFrame, desde);
		webDriver.setTextInFrame(txtFechaHasta, mainFrame, hasta);

		// Estados: V = vigor, A =Anulada, F = Vencida
		webDriver.clickElementFromDropDownByAttributeInFrame(comboEstado, mainFrame, "value", estado);
		// Lineas Negocio 920, 510, 660, 640, 500
		webDriver.clickElementFromDropDownByAttributeInFrame(comboLineaNegocio, mainFrame, "value", lineaNegocio);
		webDriver.setTextInFrame(txtCodMediador, mainFrame, mediador);

		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	// Busqueda por Otros (solo fecha y ramo)
	public AltaAperturaSiniestrosPage buscarOtros(String desde, String hasta, String lineaNegocio) {
		debugBegin();

		webDriver.clickInFrame(rdbtnOtros, mainFrame);
		webDriver.setTextInFrame(txtFechaDesde, mainFrame, desde);
		webDriver.setTextInFrame(txtFechaHasta, mainFrame, hasta);
		// Ramos 920, 510, 660, 640, 500
		webDriver.clickElementFromDropDownByAttributeInFrame(comboLineaNegocio, mainFrame, "value", lineaNegocio);

		webDriver.clickInFrame(btnBuscar, mainFrame);

		debugEnd();

		return this;
	}

	// Continuar
	public AltaAperturaSiniestrosPage continuarPrimeraPoliza() {
		debugBegin();

		webDriver.clickInFrame(btnContinuar, mainFrame);

		debugEnd();

		return this;
	}

	public AltaAperturaSiniestrosPage continuarRandomPoliza() {
		debugBegin();

		List<WebElement> listaPolizas = webDriver.getElementsInFrame(selectPoliza, mainFrame);

		webDriver.waitWithDriver(3000);

		webDriver.clickInFrame(listaPolizas.get((int) (Math.random() * listaPolizas.size())), mainFrame);

		System.out.println(selectPoliza);

		// webDriver.clickInFrame(selectPoliza, mainFrame);

		debugEnd();

		return this;
	}

	// Busqueda por Direccion con la información obligatoriav TBD
	/*
	 * public SiniestrosAltaAperturaPage buscarDireccion(String provincia, String poblacion, String via, String numVia)
	 * { debugBegin();
	 * 
	 * webDriver.clickInFrame(rdbtnDireccion, mainFrame); webDriver.appendTextInFrame(txtProvincia, mainFrame,
	 * provincia); webDriver.appendTextInFrame(txtPoblacion, mainFrame, poblacion); webDriver.appendTextInFrame(txtVia,
	 * mainFrame, via); webDriver.appendTextInFrame(txtNumVia, mainFrame, numVia); webDriver.clickInFrame(btnBuscar,
	 * mainFrame);
	 * 
	 * debugEnd();
	 * 
	 * return this;}
	 */

	// endregion
}