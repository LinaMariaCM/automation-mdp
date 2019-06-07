package com.amaris.project.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineHomePage extends PageObject {

	// region webelements
	// @FindBy(id = "blockrandom")
	// private By frameAppMainWindow;
	// private By frameAppMainWindow = By.cssSelector("#blockrandom");

	private By topFrame = By.cssSelector("#topFrame");

	private By leftFrame = By.cssSelector("#leftFrame");

	private By mainFrame = By.cssSelector("#mainFrame");

	private By contentFrame = By.cssSelector("#blockrandom");

	private By btnNovedadesDialogClose = By.cssSelector(".//*[contains(@class,'modal-header')]/button");

	private By btnContratacionSelector = By.cssSelector("div.nav-collapse:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)");
	// "#t3-mainnav > div > div > div > div > ul > li:nth-child(6) > a");

	@FindBy(linkText = "Siniestros")
	private By btnSiniestrosSelector;

	private By btnContratarOnlineOption = By.cssSelector(".//*[@class='navbar-inner']//*[text()='Contratar online ']");

	// @FindBy(xpath = ".//*[contains(text(),'Contratar Online Proyectos')]")

	private By btnContratacion = By.cssSelector(".contratacion");

	// @FindBy(xpath = ".//*[contains(text(),'Mis proyectos web')]")

	private By btnMisProyectosWebOption = By.cssSelector(".mis-proyectos-web");
	// private By btnMisProyectosWebOption =
	// By.cssSelector("div.nav-collapse:nth-child(2) > div:nth-child(1) >
	// ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > div:nth-child(1) >
	// div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1)
	// > li:nth-child(2) > a:nth-child(1)");

	// @FindBy(xpath = ".//*[contains(text(),'Mutua Edificio
	// Confort')]/../..//*[contains(text(),'Contratar')]")

	// private By btnContratarMutuaEdificioSeleccionPlus =
	// By.cssSelector("#dropdown-comunidad > div >
	// a.span2.contratar_btn.popup.prod-mdp > p > span");
	// private By btnContratarMutuaEdificioConfort =
	// By.cssSelector("#dropdown-comunidad > div:nth-child(#dropdown-comunidad >
	// div:nth-child(1) > a:nth-child(1) > p:nth-child(1) > span:nth-child(1) >
	// strong:nth-child(2)");
	private By btnContratarMutuaEdificioConfort = By.cssSelector("#dropdown-comunidad > div:nth-child(1) > a:nth-child(1)");
	// @FindBy(xpath = ".//*[contains(text(),'Mutua Alquiler
	// Confort')]/../..//*[contains(text(),'Contratar')]")

	private By drpdownComunidades = By.cssSelector(".span14 > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");
	private By drpdownImpagoAlquileres = By.cssSelector("div.border1px:nth-child(3) > a:nth-child(1)");

	private By btnContratarMutuaAlquilerConfort = By.cssSelector("#dropdown-alquiler > div:nth-child(1) > a:nth-child(1) > p:nth-child(1) > span:nth-child(1) > strong:nth-child(2)");

	private By btnMutuaEdificioConfort = By.cssSelector(".//*[contains(@title,'MUTUA EDIFICIO CONFORT.')]");

	private By btnNuevoProjecto = By.cssSelector(".//*[normalize-space(text())='Nuevo proyecto']");

	private By btnNuevaSimulaion = By.cssSelector(".//*[normalize-space(text())='Nueva Simulación']");

	// @FindBy(xpath = ".//*[text()='Acepto']")
	// @FindBy(css = ".accept")
	// private By btnAcepto = By.cssSelector(".//*[text()='Acepto']");
	private By btnAceptarCookies = By.cssSelector("#ca_banner > div.accept");

	// @FindBy(linkText = "Aceptar")
	// private By btnAceptar;

	// @FindBy(xpath = ".//*[text()=' Mapa del sitio']")
	// @FindBy(css = "#Mod222 > div > div > div > p > a")
	private By btnMapaWeb = By.cssSelector("#Mod222 > div > div > div > p > a");

	// @FindBy(xpath = ".//*[text()='Gestión de cotizaciones']")
	private By btnGestionCotizaciones = By.cssSelector(".//*[text()='Gestión de cotizaciones']");

	// @FindBy(xpath = ".//*[@title='Gestión de pólizas']")
	private By btnGestionPolizas = By.cssSelector(".//*[@title='Gestión de pólizas']");

	// @FindBy(xpath = ".//*[@id='pr_id']")
	private By txtCodigoProyecto = By.cssSelector("#pr_id");

	private By tipoProyectoDropdown = By.cssSelector("#tprpoyecto");

	private By productoDropdown = By.cssSelector("#producto");

	private By btnBuscar = By.cssSelector("#search");

	// @FindBy(css = "table[id*='DataTables_Table'] a[onclick*='javascript:
	// editarProyecto']")

	// private By modificarProyecto = By.xpath("table[id*='DataTables_Table']
	// a[onclick*='javascript: editarProyecto']");
	private By modificarProyecto = By.cssSelector(".dropdown-menu-right > li:nth-child(3) > a:nth-child(1)");

	// private By modificarProyecto =
	// By.cssSelector("table[id*='DataTables_Table'] a[onclick*='javascript:
	// editarProyecto']");

	// @FindBy(css = "[id^='eliminar_'] > div > ul > li:nth-child(3) > a")
	private By modificarProyectoUatPj = By.cssSelector("td[id*='eliminar_'] > div > ul > li:nth-child(3) > a");

	// @FindBy(css = "table[id*='DataTables_Table'] a[onclick*='javascript:
	// verEjemplar']")
	private By consultarProyecto = By.cssSelector("table[id*='DataTables_Table'] a[onclick*='javascript: verEjemplar']");

	// @FindBy(css = "[id^='eliminar_'] > div > a")
	// private By drpdwnAcciones = By.cssSelector("[id^='eliminar_'] > div >
	// a");
	private By drpdwnAcciones = By.cssSelector(("a.dropdown-toggle > img:nth-child(1)"));

	// @FindBy(css = "tr.odd:nth-child(1) > td:nth-child(13)")
	// @FindBy(css = "#DataTables_Table_0 > tbody > tr > td:nth-child(13)") //
	// By from UatPj
	private By estadoPoliza = By.cssSelector("#DataTables_Table_0 > tbody > tr > td:nth-child(13)");

	// @FindBy(css = ".mis-proyectos-web div[id *= modalWindow")
	// @FindBy(css = "#modalWindow")
	private By errorBuscar = By.cssSelector(".mis-proyectos-web div[id *= modalWindow");

	// @FindBy(css = "#modalWindow .modal-footer .btn-primary")
	// @FindBy(css = "#modalWindow > div.modal-footer > button") // This is the
	// By from UatPj
	private By cerrarErrorBuscar = By.cssSelector("#modalWindow > div.modal-footer > button");

	// endregion

	public GestionOnlineHomePage(UserStory userS) {
		super(userS);
	}

	// public void deleteCookies()
	// {
	// logger.debug("BEGIN - deleteCookies");
	// this.browserContext.getWebDriver().manage().deleteAllCookies();
	// logger.debug("END - deleteCookies");
	// }

	// region methods

	public GestionOnlineHomePage acceptCookies() {
		debugBegin();
		this.webDriver.waitWithDriver(2500);
		// this.webDriver.click(this.btnAceptarCookies);
		this.webDriver.click(this.btnAceptarCookies);;
		debugEnd();

		return this;
	}

	// This doesn't appear anymore
	// public GestionOnlineHomePage closeNovedadesDialog() {
	// debugBegin();
	// if(!this.getConfigVar("environmnent").equals("UatPj")) {
	// this.webDriver.click(this.btnAceptar);
	// }
	// debugEnd();
	//
	// return this;
	// }

	public GestionOnlineHomePage createNewProject() {
		debugBegin();

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage createNewSimulation() {
		debugBegin();
		// this.webDriver.doubleClick(this.btnMutuaEdificioConfort,
		// this.frameLeftFrame);
		// this.webDriver.doubleclickInFrame(this.btnNuevaSimulaion,
		// this.frameLeftFrame);
		this.webDriver.doubleClick(this.btnMutuaEdificioConfort);
		this.webDriver.doubleClick(this.btnNuevaSimulaion);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openContratarMutuaEdificioConfort() throws AWTException, InterruptedException, IOException {
		debugBegin();
		// In GO UatPj environment, only need to hover over option.
		// if(this.getConfigVar("environment").equals("UatPj")) {
		// this.webDriver.moveToElement(this.btnContratacionSelector);
		// } else {
		// this.webDriver.click(this.btnContratacionSelector);
		// }
		// this.webDriver.moveToElement(this.btnContratacionSelector);

		this.webDriver.click(this.btnContratacion);
		this.webDriver.clickInFrame(this.drpdownComunidades, this.contentFrame);
		this.webDriver.clickInFrame(this.btnContratarMutuaEdificioConfort, this.contentFrame);
		this.webDriver.switchToWindow(1);
		this.webDriver.maximizeWindow();
		// this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openContratarMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException {
		debugBegin();

		// // In GO UatPj environment, only need to hover over option.
		// if(this.getConfigVar("environmnent").equals("UatPj")) {
		// this.webDriver.moveToElement(this.btnContratacionSelector);
		// } else {
		// this.webDriver.click(this.btnContratacionSelector);
		// }
		// this.webDriver.moveToElement(this.btnContratacionSelector);

		this.webDriver.click(this.btnContratacion);
		this.webDriver.clickInFrame(this.btnContratarMutuaAlquilerConfort, this.contentFrame);
		this.webDriver.waitWithDriver(3000);
		this.webDriver.switchToWindow(1);
		// this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openMisProyectosWeb() throws AWTException, InterruptedException, IOException {
		debugBegin();

		// if(this.getConfigVar("environmnent").equals("UatPj")) {
		//// this.webDriver.moveToElement(this.btnContratacionSelector);
		//// } else {
		//// this.webDriver.click(this.btnContratacionSelector);
		//// }
		this.webDriver.click(this.btnContratacion);
		this.webDriver.click(this.btnMisProyectosWebOption);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openSiniestros() throws AWTException, InterruptedException, IOException {
		debugBegin();

		// this.webDriver.click(this.btnAceptar);
		this.webDriver.click(this.btnContratacionSelector);
		this.webDriver.click(this.btnMisProyectosWebOption);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage buscarProyectoWeb(String noCotizacion) throws AWTException, InterruptedException, IOException {
		debugBegin();

		this.webDriver.clickInFrame(this.txtCodigoProyecto, this.contentFrame);
		this.webDriver.appendTextInFrame(this.txtCodigoProyecto, this.contentFrame, noCotizacion);
		this.webDriver.clickInFrame(this.btnBuscar, this.contentFrame);

		// if(this.getConfigVar("environmnent").equals("UatPj")) {
		// while(!this.webDriver.isPresentInFrame(this.drpdwnAcciones,
		// this.contentFrame)) {
		// // Si aparece el error de busqueda, cierralo y buscar de nuevo.
		// if(this.webDriver.isPresent(this.errorBuscar)) {
		// this.webDriver.click(this.cerrarErrorBuscar);
		// this.webDriver.clickInFrame(this.btnBuscar, this.contentFrame);
		// }
		// }
		// } else {
		// while(!this.webDriver.isPresentInFrame(this.consultarProyecto,
		// this.contentFrame)) {
		// // Si aparece el error de busqueda, cierralo y buscar de nuevo.
		// if(this.webDriver.isPresent(this.errorBuscar)) {
		// this.webDriver.click(this.cerrarErrorBuscar);
		// this.webDriver.clickInFrame(this.btnBuscar, this.contentFrame);
		// }
		// }
		// }

		while(!this.webDriver.isPresentInFrame(this.drpdwnAcciones, this.contentFrame)) {
			// Si aparece el error de busqueda, cierralo y buscar de nuevo.
			if(this.webDriver.isPresent(this.errorBuscar)) {
				this.webDriver.click(this.cerrarErrorBuscar);
				this.webDriver.clickInFrame(this.btnBuscar, this.contentFrame);
			}
		}

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage modificarProyecto() throws AWTException, InterruptedException, IOException {
		debugBegin();

		this.webDriver.switchToFrame(this.contentFrame);

		// if(this.getConfigVar("environmnent").equals("UatPj")) {
		// System.out.println("In modificarProyecto UatPJ if");
		// // this.webDriver.clickInFrame(this.drpdwnAcciones,
		// // this.buscadorFrame);
		// // this.webDriver.clickInFrame(this.modificarProyectoUatPj,
		// // this.buscadorFrame);
		// this.webDriver.click(this.drpdwnAcciones);
		// this.webDriver.click(this.modificarProyectoUatPj);
		// } else {
		// System.out.println("In modificarProyecto UatPJ if else");
		// try {
		// this.webDriver.click(this.modificarProyecto);
		// } catch(Exception e) {
		// this.webDriver.click(this.modificarProyecto);
		// }
		// }
		this.webDriver.click(this.drpdwnAcciones);
		this.webDriver.waitWithDriver(3000);
		this.webDriver.click(this.modificarProyecto);
		this.webDriver.switchToWindow(1);
		this.webDriver.waitWithDriver(3000);
		// this.webDriver.moveToSecondWindow(this.browserContext.getTestCaseData().getMainWindowHandle());
		// this.browserContext.webDriverConfiguration.SetWebDriverTimeouts();
		debugEnd();

		return this;
	}

	public String recuperarEstadoPoliza() {
		debugBegin();
		this.webDriver.getTextInFrame(this.estadoPoliza, this.contentFrame);
		debugEnd();
		return this.webDriver.getTextInFrame(this.estadoPoliza, this.contentFrame);
	}

	public void openGestionCotizaciones() {
		debugBegin();
		this.webDriver.click(this.btnMapaWeb);
		this.webDriver.doubleClickInFrame(this.btnGestionCotizaciones, this.mainFrame);
		debugEnd();
	}

	public GestionOnlineHomePage openGestionPolizas() {
		debugBegin();
		this.webDriver.doubleClickInFrame(this.btnMapaWeb, this.topFrame);
		this.webDriver.doubleClickInFrame(this.btnGestionPolizas, this.mainFrame);
		debugEnd();

		return this;
	}
	// endregion
}
