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
	private By topFrame = By.cssSelector("#topFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By contentFrame = By.cssSelector("#blockrandom");

	private By idiomaCastellano = By.cssSelector("body > header > div.wrap.t3-footer > div > div > div > ul > li:nth-child(1) > a");
	private By btnNovedadesDialogClose = By.cssSelector(".//*[contains(@class,'modal-header')]/button");
	private By btnContratacionSelector = By.cssSelector("div.nav-collapse:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)");
	private By btnSiniestrosSelector = By.cssSelector("#t3-mainnav > div > div > div > div > ul > li:nth-child(5) > a");
	private By btnAltaSiniestro = By.cssSelector("#t3-mainnav > div > div > div > div > ul > li:nth-child(5) > div > div > div > div > div > ul > li:nth-child(2) > a");

	private By btnContratarOnlineOption = By.cssSelector(".//*[@class='navbar-inner']//*[text()='Contratar online ']");
	private By btnContratacion = By.cssSelector(".contratacion");

	private By btnMisProyectosWebOption = By.cssSelector(".mis-proyectos-web");
	private By btnContratarMutuaEdificioConfort = By.cssSelector("#dropdown-comunidad > div:nth-child(1) > a:nth-child(1)");
	private By drpdownComunidades = By.cssSelector(".span14 > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");
	private By drpdownImpagoAlquileres = By.cssSelector("div.border1px:nth-child(3) > a:nth-child(1)");

	private By btnContratarMutuaAlquilerConfort = By.cssSelector("#dropdown-alquiler > div:nth-child(1) > a:nth-child(1) > p:nth-child(1) > span:nth-child(1) > strong:nth-child(2)");
	private By btnMutuaEdificioConfort = By.cssSelector(".//*[contains(@title,'MUTUA EDIFICIO CONFORT.')]");
	private By btnNuevoProjecto = By.cssSelector(".//*[normalize-space(text())='Nuevo proyecto']");
	private By btnNuevaSimulaion = By.cssSelector(".//*[normalize-space(text())='Nueva Simulación']");

	private By btnAceptarCookies = By.cssSelector("#ca_banner > div.accept");
	private By btnMapaWeb = By.cssSelector("#Mod222 > div > div > div > p > a");
	private By btnGestionCotizaciones = By.cssSelector(".//*[text()='Gestión de cotizaciones']");
	private By btnGestionPolizas = By.cssSelector(".//*[@title='Gestión de pólizas']");

	private By txtCodigoProyecto = By.cssSelector("#pr_id");
	private By tipoProyectoDropdown = By.cssSelector("#tprpoyecto");
	private By productoDropdown = By.cssSelector("#producto");
	private By btnBuscar = By.cssSelector("#search");

	private By modificarProyecto = By.cssSelector(".dropdown-menu-right > li:nth-child(3) > a:nth-child(1)");
	private By modificarProyectoUatPj = By.cssSelector("td[id*='eliminar_'] > div > ul > li:nth-child(3) > a");
	private By consultarProyecto = By.cssSelector("table[id*='DataTables_Table'] a[onclick*='javascript: verEjemplar']");

	private By drpdwnAcciones = By.cssSelector(("a.dropdown-toggle > img:nth-child(1)"));
	private By estadoPoliza = By.cssSelector("#DataTables_Table_0 > tbody > tr > td:nth-child(13)");
	private By errorBuscar = By.cssSelector(".mis-proyectos-web div[id *= modalWindow");
	private By cerrarErrorBuscar = By.cssSelector("#modalWindow > div.modal-footer > button");
	// endregion

	public GestionOnlineHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineHomePage acceptCookies() {
		debugBegin();
		webDriver.waitWithDriver(2500);
		webDriver.click(btnAceptarCookies);;
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage createNewProject() {
		debugBegin();

		// TODO Por que esta vacio!!???

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage createNewSimulation() {
		debugBegin();

		// TODO En el framework antiguo estaba con InFrame, aqui no, comprobar cual debe ser
		webDriver.doubleClickInFrame(btnMutuaEdificioConfort, leftFrame);
		webDriver.doubleClickInFrame(btnNuevaSimulaion, leftFrame);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openContratarMutuaEdificioConfort() {
		debugBegin();
		// In GO UatPj environment, only need to hover over option.
		// if(getConfigVar("environment").equals("UatPj")) {
		// webDriver.moveToElement(btnContratacionSelector);
		// } else {
		// webDriver.click(btnContratacionSelector);
		// }
		// webDriver.moveToElement(btnContratacionSelector);

		webDriver.click(btnContratacion);
		webDriver.clickInFrame(drpdownComunidades, contentFrame);
		webDriver.clickInFrame(btnContratarMutuaEdificioConfort, contentFrame);
		webDriver.switchToWindow(1);
		webDriver.maximizeWindow();

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openContratarMutuaAlquilerConfort() {
		debugBegin();

		// // In GO UatPj environment, only need to hover over option.
		// if(getConfigVar("environmnent").equals("UatPj")) {
		// webDriver.moveToElement(btnContratacionSelector);
		// } else {
		// webDriver.click(btnContratacionSelector);
		// }
		// webDriver.moveToElement(btnContratacionSelector);

		webDriver.click(btnContratacion);
		webDriver.clickInFrame(btnContratarMutuaAlquilerConfort, contentFrame);
		webDriver.waitWithDriver(3000);
		webDriver.switchToWindow(1);
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openMisProyectosWeb() {
		debugBegin();

		webDriver.click(btnContratacion);
		webDriver.click(btnMisProyectosWebOption);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openSiniestros() {
		debugBegin();

		// webDriver.click(btnAceptar);
		webDriver.click(btnSiniestrosSelector);
		webDriver.click(btnAltaSiniestro);

		// webDriver.click(btnAceptar);
		webDriver.click(btnContratacionSelector);
		webDriver.click(btnMisProyectosWebOption);

		debugEnd();

		return this;
	}

	public void altaSiniestros() {
		debugBegin();

		// webDriver.click(btnAceptar);
		webDriver.moveToElement(btnSiniestrosSelector);
		// webDriver.click(btnSiniestrosSelector);
		webDriver.click(btnAltaSiniestro);

		debugEnd();

	}

	public GestionOnlineHomePage buscarProyectoWeb(String noCotizacion) {
		debugBegin();

		webDriver.clickInFrame(txtCodigoProyecto, contentFrame);
		webDriver.appendTextInFrame(txtCodigoProyecto, contentFrame, noCotizacion);
		webDriver.clickInFrame(btnBuscar, contentFrame);

		// if(getConfigVar("environmnent").equals("UatPj")) {
		// while(!webDriver.isPresentInFrame(drpdwnAcciones,
		// contentFrame)) {
		// // Si aparece el error de busqueda, cierralo y buscar de nuevo.
		// if(webDriver.isPresent(errorBuscar)) {
		// webDriver.click(cerrarErrorBuscar);
		// webDriver.clickInFrame(btnBuscar, contentFrame);
		// }
		// }
		// } else {
		// while(!webDriver.isPresentInFrame(consultarProyecto,
		// contentFrame)) {
		// // Si aparece el error de busqueda, cierralo y buscar de nuevo.
		// if(webDriver.isPresent(errorBuscar)) {
		// webDriver.click(cerrarErrorBuscar);
		// webDriver.clickInFrame(btnBuscar, contentFrame);
		// }
		// }
		// }

		while(!webDriver.isPresentInFrame(drpdwnAcciones, contentFrame)) {
			// Si aparece el error de busqueda, cierralo y buscar de nuevo.
			if(webDriver.isPresent(errorBuscar)) {
				webDriver.click(cerrarErrorBuscar);
				webDriver.clickInFrame(btnBuscar, contentFrame);
			}
		}

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage modificarProyecto() {
		debugBegin();

		// if(getConfigVar("environmnent").equals("UatPj")) {
		// System.out.println("In modificarProyecto UatPJ if");
		// // webDriver.clickInFrame(drpdwnAcciones,
		// // buscadorFrame);
		// // webDriver.clickInFrame(modificarProyectoUatPj,
		// // buscadorFrame);
		// webDriver.click(drpdwnAcciones);
		// webDriver.click(modificarProyectoUatPj);
		// } else {
		// System.out.println("In modificarProyecto UatPJ if else");
		// try {
		// webDriver.click(modificarProyecto);
		// } catch(Exception e) {
		// webDriver.click(modificarProyecto);
		// }
		// }
		webDriver.clickInFrame(drpdwnAcciones, contentFrame);
		webDriver.waitWithDriver(3000);
		webDriver.clickInFrame(modificarProyecto, contentFrame);
		webDriver.switchToWindow(1);
		webDriver.waitWithDriver(3000);
		
		debugEnd();

		return this;
	}

	public String recuperarEstadoPoliza() {
		debugBegin();
		String result = webDriver.getTextInFrame(estadoPoliza, contentFrame);
		debugEnd();

		return result;
	}

	public GestionOnlineHomePage openGestionCotizaciones() {
		debugBegin();
		webDriver.click(btnMapaWeb);
		webDriver.doubleClickInFrame(btnGestionCotizaciones, mainFrame);
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage seleccionaIdiomaCast() {
		debugBegin();
		webDriver.click(idiomaCastellano);
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openGestionPolizas() {
		debugBegin();
		webDriver.doubleClickInFrame(btnMapaWeb, topFrame);
		webDriver.doubleClickInFrame(btnGestionPolizas, mainFrame);
		debugEnd();

		return this;
	}
	// endregion
}
