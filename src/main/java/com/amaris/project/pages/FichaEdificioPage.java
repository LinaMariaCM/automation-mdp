package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;


public class FichaEdificioPage extends PageObject {
	
	FichaEdificioPage(UserStory userS) {
		super(userS);
	}
	
	// // region webelements
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(id = "leftFrame")
	// private WebElement menuFrame;
	//
	// @FindBy(xpath = ".//*[text()='Ficha Edificio']")
	// private WebElement fichaEdificioLink;
	//
	// @FindBy(id = "filtro1")
	// private WebElement rdbDireccion;
	//
	// @FindBy(id = "filtro2")
	// private WebElement rdbRefCatastral;
	//
	// @FindBy(id = "filtro3")
	// private WebElement rdbProyecto;
	//
	// @FindBy(id = "filtro4")
	// private WebElement rdbPoliza;
	//
	// @FindBy(id = "filtro5")
	// private WebElement rdbMediador;
	//
	// @FindBy(id = "filtro6")
	// private WebElement rdbEstado;
	//
	// @FindBy(id = "BUSC_EDIF_CATASTRO")
	// private WebElement txtRefCatastral;
	//
	// @FindBy(id = "BUSC_EDIF_PROYECTO")
	// private WebElement txtProyecto;
	//
	// @FindBy(id = "BUSC_EDIF_POLIZA")
	// private WebElement txtPoliza;
	//
	// @FindBy(id = "BUSC_EDIF_MEDIADOR")
	// private WebElement txtMediador;
	//
	// @FindBy(id = "BUSC_EDIF_ESTADO")
	// private WebElement cmbEstado;
	//
	// @FindBy(id = "BUSC_EDIF_PROVINCIA")
	// private WebElement txtProvincia;
	//
	// @FindBy(id = "BUSC_EDIF_POBLACION")
	// private WebElement txtPoblacion;
	//
	// @FindBy(id = "BUSC_EDIF_VIA")
	// private WebElement txtVia;
	//
	// @FindBy(id = "BUSC_EDIF_POSTCOD")
	// private WebElement txtPostCod;
	//
	// @FindBy(id = "BUSC_EDIF_NUMVIA")
	// private WebElement txtNumVia;
	//
	// @FindBy(id = "formularioPaginacion")
	// private WebElement compFormPag;
	//
	// @FindBy(css =
	// "ul.ui-autocomplete.ui-menu.ui-widget.ui-widget-content.ui-corner-all")
	// private WebElement menuDropdown;
	//
	// @FindBy(xpath = "/html/body/ul[1]/li/a")
	// private WebElement menuItem1;
	//
	// @FindBy(xpath = "/html/body/ul[2]/li/a")
	// private WebElement menuItem2;
	//
	// @FindBy(xpath = "/html/body/ul[3]/li/a")
	// private WebElement menuItem3;
	//
	// @FindBy(css = "table.grid.anchuraCajas")
	// private WebElement resultadoBusqueda;
	//
	// @FindBy(css = "td.headGrid")
	// private WebElement barraResultados;
	//
	// @FindBy(xpath = "//*[@id='tr1']/td[4]")
	// private WebElement refCatResultado;
	//
	// @FindBy(name = "botonBuscar")
	// private WebElement btnBuscar;
	//
	// @FindBy(xpath = "//*[@id='tr1']/td[6]")
	// private WebElement btnContinuar;
	//
	// @FindBy(xpath = ".//*[text()='Dirección: ']")
	// private WebElement lblDireccion;
	//
	// @FindBy(xpath = ".//*[text()='Mediador: ']")
	// private WebElement lblMediador;
	//
	// @FindBy(xpath = ".//*[text()='Datos Mediador: ']")
	// private WebElement lblDatosMediador;
	//
	// @FindBy(xpath = ".//*[text()='Nº Viviendas: ']")
	// private WebElement lblNumViviendas;
	//
	// @FindBy(xpath = ".//*[text()='Antigüedad del edificio: ']")
	// private WebElement lblAntiguedad;
	//
	// @FindBy(xpath = ".//*[text()='Superficie construida(m2): ']")
	// private WebElement lblSuperficie;
	//
	// @FindBy(id = "pes0")
	// private WebElement tabResumen;
	//
	// @FindBy(id = "pes1")
	// private WebElement tabPolizas;
	// // endregion
	//
	// public FichaEdificioPage(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void accederAlBuscadorEdificios() throws InterruptedException
	// {
	// // Click en link Ficha Edificio
	// this.wh.moveToElementInFrameWithJavaScript(this.fichaEdificioLink,
	// this.menuFrame);
	// this.wh.doubleClickOnWebElementInFrame(this.fichaEdificioLink,
	// this.menuFrame);
	// this.wh.waitForPageLoadWithAngular();
	// }
	//
	// public void printLogProcessPercentage(
	// String message, int current, int total)
	// {
	// if ((int) ((double) current / (double) total * 100) > (int) ((double)
	// current - 1 / (double) total * 100))
	// {
	// logger.debug(message + (int) ((double) current / (double) total * 100) +
	// "%");
	// }
	// }
	//
	// public void iterarEdificiosPorReferencias(
	// String nombreFichero) throws InterruptedException
	// {
	// logger.debug("BEGIN - IterarEdificiosPorReferencias");
	// // Read file and fill HashMap
	// HashMap<String, HashMap<String, String>> tablaHash =
	// loadDataFileToHashMap(nombreFichero, false);
	//
	// // Iterate by number of lines
	// for (int i = 0; i < tablaHash.size(); i++)
	// {
	// // Print iteration process percentage
	// this.printLogProcessPercentage("Iterations - ", i, tablaHash.size());
	//
	// // Fill referencia_catastral
	// this.wh.sendValueToWebElementInFrame(this.txtRefCatastral,
	// this.cuerpoFrame, getValuesDataSetByIndex(tablaHash, "ref_catastral",
	// i));
	//
	// // Search
	// this.wh.clickOnWebElementInFrame(this.btnBuscar, this.cuerpoFrame);
	// // Wait result
	// this.wh.waitForPageLoadWithAngular();
	// this.wh.waitForWebElementInFrame(this.barraResultados, this.cuerpoFrame);
	//
	// if (this.wh.getTextFromWebElementInFrame(this.refCatResultado,
	// this.cuerpoFrame)
	// .equals(this.wh.getTextFromWebElementInFrame(this.txtRefCatastral,
	// this.cuerpoFrame)))
	// {
	// System.out.println("Referencia catastral encontrada");
	// }
	// else
	// System.out.println("Referencia catastral no encontrada");
	// }
	// logger.debug("END - IterarEdificiosPorReferencias");
	// }
	//
	// public void iterarEdificiosPorDirecciones(
	// String nombreFichero) throws InterruptedException
	// {
	// logger.debug("BEGIN - IterarEdificiosPorDirecciones");
	// int sectionSize = 50, linesInFile = countLinesInFile(nombreFichero);
	// // Reads file and fill HashMap
	// HashMap<String, HashMap<String, String>> tablaHash;
	//
	// // Loads data in a HashMap by sections depending on "sectionSize"
	// for (int j = 0; j < linesInFile; j += sectionSize)
	// {
	// tablaHash =
	// loadDataFileSectionToHashMapByInitialLineAndSize(nombreFichero, j,
	// sectionSize, false);
	// // Iterate by number of lines
	// for (int i = 0; i < tablaHash.size(); i++)
	// {
	// boolean dropDownPresent = true;
	// String address = getValuesDataSetByIndex(tablaHash, "provincia", i) + " "
	// + getValuesDataSetByIndex(tablaHash, "poblacion", i) + " "
	// + getValuesDataSetByIndex(tablaHash, "direccion", i) + " " +
	// getValuesDataSetByIndex(tablaHash, "numero", i);
	// // Print iteration process percentage
	// this.printLogProcessPercentage("Iterations - ", j + i, linesInFile);
	//
	// // If text in field "provincia" is not equals to the provincia(i) value
	// if (!this.wh.getTextFromWebElementInFrame(this.txtProvincia,
	// this.cuerpoFrame).contains(getValuesDataSetByIndex(tablaHash,
	// "provincia", i)))
	// {
	// // Fill provincia
	// this.wh.sendValueToWebElementInFrame(this.txtProvincia, this.cuerpoFrame,
	// getValuesDataSetByIndex(tablaHash, "provincia", i));
	// dropDownPresent =
	// this.wh.webElementInFrameIsPresentAndClick(this.menuItem1,
	// this.cuerpoFrame);
	// if (!dropDownPresent)
	// System.out.println("Nombre de provincia no encontrado en el dropdown\n" +
	// address);
	// // this.wh.ClickOnWebElementInFrame(this.menuItem1, this.cuerpoFrame);
	// }
	//
	// // If text in field "poblacion" is not equals to the poblacion(i) value
	// if (dropDownPresent &&
	// !this.wh.getTextFromWebElementInFrame(this.txtPoblacion,
	// this.cuerpoFrame)
	// .contains(getValuesDataSetByIndex(tablaHash, "poblacion", i)))
	// {
	// // Fill poblacion
	// this.wh.sendValueToWebElementInFrame(this.txtPoblacion, this.cuerpoFrame,
	// getValuesDataSetByIndex(tablaHash, "poblacion", i));
	// dropDownPresent =
	// this.wh.webElementInFrameIsPresentAndClick(this.menuItem2,
	// this.cuerpoFrame);
	// if (!dropDownPresent)
	// System.out.println("Nombre de población no encontrado en el dropdown\n" +
	// address);
	// }
	//
	// // If text in field "direccion" is not equals to the direccion(i) value
	// if (dropDownPresent
	// && !this.wh.getTextFromWebElementInFrame(this.txtVia,
	// this.cuerpoFrame).contains(getValuesDataSetByIndex(tablaHash,
	// "direccion", i)))
	// {
	// // Fill direccion
	// this.wh.sendValueToWebElementInFrame(this.txtVia, this.cuerpoFrame,
	// getValuesDataSetByIndex(tablaHash, "direccion", i));
	// dropDownPresent =
	// this.wh.webElementInFrameIsPresentAndClick(this.menuItem3,
	// this.cuerpoFrame);
	// if (!dropDownPresent)
	// System.out.println("Nombre de vía no encontrado en el dropdown\n" +
	// address);
	// }
	//
	// // Fill numero
	// if (this.wh.webElementInFrameIsPresent(this.txtNumVia, this.cuerpoFrame))
	// this.wh.sendValueToWebElementInFrame(this.txtNumVia, this.cuerpoFrame,
	// getValuesDataSetByIndex(tablaHash, "numero", i));
	// // Fill codigo postal
	// if (this.wh.webElementInFrameIsPresent(this.txtPostCod,
	// this.cuerpoFrame))
	// {
	// String codigoPostal = getValuesDataSetByIndex(tablaHash, "codigo_postal",
	// i);
	// this.wh.sendValueToWebElementInFrame(this.txtPostCod, this.cuerpoFrame,
	// codigoPostal.length() == 5 ? codigoPostal : "0" + codigoPostal);
	// }
	//
	// if (dropDownPresent)
	// {
	// try
	// {
	// // Search
	// this.wh.clickOnWebElementInFrame(this.btnBuscar, this.cuerpoFrame);
	//
	// // Wait result
	// System.out.println(this.wh.webElementInFrameIsPresent(this.resultadoBusqueda,
	// this.cuerpoFrame) ? "Dirección normalizada"
	// : "Direccion no encontrada\n" + address);
	// this.wh.waitForWebElementInFrame(this.resultadoBusqueda,
	// this.cuerpoFrame);
	//
	// }
	// catch (UnhandledAlertException e)
	// {
	// WebElement Alert = null;
	//
	// // Manage alert Pop-up
	// this.wh.getAlertTextAndAccept(Alert);
	// System.out.println(address);
	// this.wh.exitFromFrame();
	// }
	// }
	// }
	// }
	// logger.debug("END - IterarEdificiosPorDirecciones");
	// }
	//
	// /**
	// * Selects the comboBox filter option as the searchFilter value
	// *
	// * @param searchFilter
	// */
	// public void setFiltroBusqueda(
	// String searchFilter)
	// {
	// this.tData.setFiltroBuscadorEdificio(searchFilter);
	// this.setFiltroBusqueda();
	// }
	//
	// /**
	// * Selects the comboBox filter option set in the testData variable
	// FiltroBuscadorEdificio
	// */
	// public void setFiltroBusqueda()
	// {
	// logger.debug("BEGIN - setFiltroBusqueda");
	//
	// switch (this.tData.getFiltroBuscadorEdificio())
	// {
	// case ProjectConstants.FILTRO_BUSCADOR_DIRECCION:
	// this.wh.clickOnWebElementInFrame(this.rdbDireccion, this.cuerpoFrame);
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_CATASTRAL:
	// this.wh.clickOnWebElementInFrame(this.rdbRefCatastral, this.cuerpoFrame);
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_PROYECTO:
	// this.wh.clickOnWebElementInFrame(this.rdbProyecto, this.cuerpoFrame);
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_POLIZA:
	// this.wh.clickOnWebElementInFrame(this.rdbPoliza, this.cuerpoFrame);
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_MEDIADOR:
	// this.wh.clickOnWebElementInFrame(this.rdbMediador, this.cuerpoFrame);
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_ESTADO:
	// this.wh.clickOnWebElementInFrame(this.rdbEstado, this.cuerpoFrame);
	// break;
	// }
	// logger.debug("END - setFiltroBusqueda");
	// }
	//
	// public void buscarConFiltroBusqueda()
	// {
	// logger.debug("BEGIN - FiltroBusqueda");
	//
	// switch (this.tData.getFiltroBuscadorEdificio())
	// {
	// case ProjectConstants.FILTRO_BUSCADOR_DIRECCION:
	// this.buscarEdificioDireccion();
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_CATASTRAL:
	// this.buscarEdificioRefCatastral();
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_PROYECTO:
	// this.buscarEdificioProyecto();
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_POLIZA:
	// this.buscarEdificioPoliza();
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_MEDIADOR:
	// this.buscarEdificioMediador();
	// break;
	// case ProjectConstants.FILTRO_BUSCADOR_ESTADO:
	// this.buscarEdificioEstado();
	// break;
	// default:
	// this.buscarEdificioDireccion();
	// break;
	// }
	//
	// // Click btn buscar
	// this.wh.clickOnWebElementInFrame(this.btnBuscar, this.cuerpoFrame);
	// logger.debug("END - FiltroBusqueda");
	// }
	//
	// public void buscarEdificioRefCatastral()
	// {
	// // Click en el rdb Ref Cadastral
	// this.wh.clickOnWebElementInFrame(this.rdbRefCatastral, this.cuerpoFrame);
	// // Set Ref Catastral
	// this.wh.clearAndSetTextInWebElementInFrame(this.txtRefCatastral,
	// this.cuerpoFrame, this.tData.getReferenciaCatastral());
	// }
	//
	// public void buscarEdificioProyecto()
	// {
	// // Click en el rdb Proyecto
	// this.wh.clickOnWebElementInFrame(this.rdbProyecto, this.cuerpoFrame);
	// // Set Proyecto
	// this.wh.clearAndSetTextInWebElementInFrame(this.txtProyecto,
	// this.cuerpoFrame, this.tData.getProyecto());
	// }
	//
	// public void buscarEdificioPoliza()
	// {
	// // Click en el rdb Poliza
	// this.wh.clickOnWebElementInFrame(this.rdbPoliza, this.cuerpoFrame);
	// // Set Poliza
	// this.wh.clearAndSetTextInWebElementInFrame(this.txtPoliza,
	// this.cuerpoFrame, this.tData.getNumPoliza().toString());
	// }
	//
	// public void buscarEdificioMediador()
	// {
	// // Click en el rdb Mediador
	// this.wh.clickOnWebElementInFrame(this.rdbMediador, this.cuerpoFrame);
	// // Set Mediador
	// this.wh.clearAndSetTextInWebElementInFrame(this.txtMediador,
	// this.cuerpoFrame, this.tData.getMediador().toString());
	// }
	//
	// public void buscarEdificioDireccion()
	// {
	// logger.debug("BEGIN - BuscarEdificioDireccion");
	// this.wh.clickOnWebElementInFrame(this.rdbDireccion, this.cuerpoFrame);
	//
	// this.fillEdificioDireccion();
	// /*
	// * // Set Provincia
	// this.wh.SendValueToWebElementInFrameWithJavaScript(this.txtProvincia,
	// this.cuerpoFrame, this.tData.getProvincia()); // Set
	// * Poblacion
	// this.wh.SendValueToWebElementInFrameWithJavaScript(this.txtPoblacion,
	// this.cuerpoFrame, this.tData.getPoblacion()); // Set Via
	// * this.wh.SendValueToWebElementInFrameWithJavaScript(this.txtVia,
	// this.cuerpoFrame, this.tData.getNombreVia()); // Set Num Via
	// * this.wh.SendValueToWebElementInFrameWithJavaScript(this.txtNumVia,
	// this.cuerpoFrame, this.tData.getNumVia());
	// */
	//
	// logger.debug("END - BuscarEdificioDireccion");
	// }
	//
	// public void fillEdificioDireccion()
	// {
	// this.fillEdificioDireccion(this.tData.getProvincia(),
	// this.tData.getPoblacion(), this.tData.getNombreVia(),
	// this.tData.getNumVia(), null);
	// }
	//
	// public void fillEdificioDireccion(
	// String provincia, String poblacion, String nombreVia, String numVia,
	// String codigoPostal)
	// {
	// logger.debug("BEGIN - FillEdificioDireccion");
	// // this.wh.SwitchToFrame(this.cuerpoFrame);
	//
	// if (provincia != null)
	// {
	// // Fill provincia
	// this.wh.sendValueToWebElementInFrame(this.txtProvincia, this.cuerpoFrame,
	// provincia);
	// this.wh.clickOnWebElementInFrame(this.menuItem1, this.cuerpoFrame);
	// }
	//
	// // If text in field "poblacion" is not equals to the poblacion(i) value
	// if (poblacion != null)
	// {
	// // Fill poblacion
	// this.wh.sendValueToWebElementInFrame(this.txtPoblacion, this.cuerpoFrame,
	// poblacion);
	// this.wh.clickOnWebElementInFrame(this.menuItem2, this.cuerpoFrame);
	// }
	//
	// // If text in field "direccion" is not equals to the direccion(i) value
	// if (nombreVia != null)
	// {
	// // Fill direccion
	// this.wh.sendValueToWebElementInFrame(this.txtVia, this.cuerpoFrame,
	// nombreVia);
	// this.wh.clickOnWebElementInFrame(this.menuItem3, this.cuerpoFrame);
	// }
	//
	// if (numVia != null)
	// {
	// // Fill numero
	// this.wh.sendValueToWebElementInFrame(this.txtNumVia, this.cuerpoFrame,
	// numVia);
	// }
	//
	// if (codigoPostal != null)
	// {
	// // Fill codigo postal
	// this.wh.sendValueToWebElementInFrame(this.txtPostCod, this.cuerpoFrame,
	// codigoPostal);
	// }
	//
	// logger.debug("END - FillEdificioDireccion");
	// }
	//
	// public void buscarEdificioEstado()
	// {
	// // Click en el rdb Estado
	// this.wh.clickOnWebElementInFrame(this.rdbEstado, this.cuerpoFrame);
	// // Set Estado
	// this.wh.selectValueInDropDownInFrame(this.cmbEstado, this.cuerpoFrame,
	// this.tData.getEstadoEdificio());
	//
	// }
	//
	// public boolean checkResultadoDireccion()
	// {
	// return
	// this.checkResultadoDireccion(this.wh.getTextFromWebElementInFrame(this.txtPoblacion,
	// this.cuerpoFrame),
	// this.wh.getTextFromWebElementInFrame(this.txtVia, this.cuerpoFrame),
	// this.wh.getTextFromWebElementInFrame(this.txtNumVia, this.cuerpoFrame),
	// null, null);
	// }
	//
	// public boolean checkResultadoDireccion(
	// String poblacion, String nombreVia, String numVia, String refCatastral,
	// String estado)
	// {
	// logger.debug("BEGIN - checkResultado");
	// boolean check = false;
	// this.wh.waitForWebElementInFrame(this.resultadoBusqueda,
	// this.cuerpoFrame);
	//
	// if (poblacion != null)
	// {
	// check =
	// this.wh.webElementInFrameIsPresent(By.xpath(".//td[contains(text(), '" +
	// poblacion + "')]"), this.cuerpoFrame);
	// }
	//
	// if (nombreVia != null)
	// {
	// check =
	// this.wh.webElementInFrameIsPresent(By.xpath(".//td[contains(text(), '" +
	// nombreVia + "')]"), this.cuerpoFrame);
	// }
	//
	// if (numVia != null)
	// {
	// check =
	// this.wh.webElementInFrameIsPresent(By.xpath(".//td[contains(text(), '" +
	// numVia + "')]"), this.cuerpoFrame);
	// }
	//
	// if (refCatastral != null)
	// {
	// check =
	// this.wh.webElementInFrameIsPresent(By.xpath(".//td[contains(text(), '" +
	// refCatastral.toUpperCase() + "')]"), this.cuerpoFrame);
	// }
	//
	// if (estado != null)
	// {
	// check =
	// this.wh.webElementInFrameIsPresent(By.xpath(".//td[contains(text(), '" +
	// estado + "')]"), this.cuerpoFrame);
	// }
	//
	// logger.debug("END - checkResultado");
	// return check;
	// }
	//
	// public void openFichaEdificioDesdeGrid()
	// {
	// logger.debug("START - openFichaEdificioDesdeGrid");
	// this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
	// logger.debug("END - openFichaEdificioDesdeGrid");
	// }
	//
	// public boolean checkCabeceraFicha()
	// {
	// logger.debug("BEGIN - checkCabeceraFicha");
	// boolean check = false;
	//
	// check = this.wh.webElementInFrameIsPresent(this.lblDireccion,
	// this.cuerpoFrame);
	// check = this.wh.webElementInFrameIsPresent(this.lblMediador,
	// this.cuerpoFrame);
	// check = this.wh.webElementInFrameIsPresent(this.lblDatosMediador,
	// this.cuerpoFrame);
	// check = this.wh.webElementInFrameIsPresent(this.lblNumViviendas,
	// this.cuerpoFrame);
	// check = this.wh.webElementInFrameIsPresent(this.lblAntiguedad,
	// this.cuerpoFrame);
	// check = this.wh.webElementInFrameIsPresent(this.lblSuperficie,
	// this.cuerpoFrame);
	//
	// logger.debug("END - checkResultado");
	// return check;
	// }
	//
	// public boolean checkPestanaResumenVisible()
	// {
	// logger.debug("BEGIN - checkPestañaResumenVisible");
	// boolean check = false;
	//
	// check = this.wh.webElementInFrameIsPresent(this.tabResumen,
	// this.cuerpoFrame);
	//
	// logger.debug("END - checkPestañaResumenVisible");
	// return check;
	// }
	//
	// public boolean checkPestanaPolizasVisible()
	// {
	// logger.debug("BEGIN - checkPestañaPólizasVisible");
	// boolean check = false;
	//
	// check = this.wh.webElementInFrameIsPresent(this.tabPolizas,
	// this.cuerpoFrame);
	//
	// logger.debug("END - checkPestañaPólizasVisible");
	// return check;
	// }
	// // endregion
}
