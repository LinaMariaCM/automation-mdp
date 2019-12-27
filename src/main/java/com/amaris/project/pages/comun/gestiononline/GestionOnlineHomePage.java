package com.amaris.project.pages.comun.gestiononline;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class GestionOnlineHomePage extends PageObject {

	// region webelements
	private By topFrame = By.cssSelector("#topFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By mainFrame = By.cssSelector("#mainFrame");
	private By contentFrame = By.cssSelector("#blockrandom");

	private By idiomaCastellanoBtn = By.cssSelector("body > header > div.wrap.t3-footer > div > div > div > ul > li:nth-child(1) > a");
	private By btnNovedadesDialogClose = By.cssSelector(".//*[contains(@class,'modal-header')]/button");
	private By contratacionSelectorBtn = By.cssSelector("div.nav-collapse:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)");
	private By siniestrosSelectorBtn = By.cssSelector("#t3-mainnav > div > div > div > div > ul > li:nth-child(5) > a");
	private By altaSiniestroBtn = By.cssSelector("#t3-mainnav > div > div > div > div > ul > li:nth-child(5) > div > div > div > div > div > ul > li:nth-child(2) > a");

	private By btnContratarOnlineOption = By.cssSelector(".//*[@class='navbar-inner']//*[text()='Contratar online ']");
	private By contratacionBtn = By.cssSelector(".contratacion");

	private By misProyectosWebOptionBtn = By.cssSelector(".mis-proyectos-web");
	private By contratarMecBtn = By.cssSelector("#dropdown-comunidad > div:nth-child(1) > a:nth-child(1)");
	private By comunidadesDrpDwn = By.cssSelector(".span14 > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");
	private By drpdownImpagoAlquileres = By.cssSelector("div.border1px:nth-child(3) > a:nth-child(1)");

	private By btnContratarMutuaAlquilerConfort = By.cssSelector("#dropdown-alquiler > div:nth-child(1) > a:nth-child(1) > p:nth-child(1) > span:nth-child(1) > strong:nth-child(2)");
	private By mutuaEdificioConfortBtn = By.cssSelector(".//*[contains(@title,'MUTUA EDIFICIO CONFORT.')]");
	private By btnNuevoProjecto = By.cssSelector(".//*[normalize-space(text())='Nuevo proyecto']");
	private By nuevaSimulacionBtn = By.cssSelector(".//*[normalize-space(text())='Nueva Simulación']");

	private By aceptarCookiesBtn = By.cssSelector("#ca_banner > div.accept");
	private By mapaWebBtn = By.cssSelector("#Mod222 > div > div > div > p > a");
	private By gestionCotizacionesBtn = By.cssSelector(".//*[text()='Gestión de cotizaciones']");
	private By gestionPolizasBtn = By.cssSelector(".//*[@title='Gestión de pólizas']");

	private By codigoProyectoInput = By.cssSelector("#pr_id");
	private By tipoProyectoDropdown = By.cssSelector("#tprpoyecto");
	private By productoDropdown = By.cssSelector("#producto");
	private By buscarBtn = By.cssSelector("#search");

	private By modificarProyectoBtn = By.cssSelector(".dropdown-menu-right > li:nth-child(3) > a:nth-child(1)");
	private By modificarProyectoUatPj = By.cssSelector("td[id*='eliminar_'] > div > ul > li:nth-child(3) > a");
	private By consultarProyecto = By.cssSelector("table[id*='DataTables_Table'] a[onclick*='javascript: verEjemplar']");

	private By accionesDrpDwn = By.cssSelector(("a.dropdown-toggle > img:nth-child(1)"));
	private By estadoPolizaTxt = By.cssSelector("#DataTables_Table_0 > tbody > tr > td:nth-child(13)");
	private By errorBuscarPanel = By.cssSelector(".mis-proyectos-web div[id *= modalWindow");
	private By cerrarErrorBuscarBtn = By.cssSelector("#modalWindow > div.modal-footer > button");

	private By desplegarAlquileresBtn = By.cssSelector("a[data-target*='dropdown-alquiler'] p");
	private By contratarAlquileresBtn = By.cssSelector("div[id='dropdown-alquiler'] a p");

	// endregion

	public GestionOnlineHomePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionOnlineHomePage acceptCookies() {
		debugBegin();
		webDriver.waitWithDriver(2500);
		webDriver.click(aceptarCookiesBtn);
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
		webDriver.doubleClickInFrame(mutuaEdificioConfortBtn, leftFrame);
		webDriver.doubleClickInFrame(nuevaSimulacionBtn, leftFrame);

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

		webDriver.click(contratacionBtn);
		webDriver.clickInFrame(comunidadesDrpDwn, contentFrame);
		webDriver.clickInFrame(contratarMecBtn, contentFrame);
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
		webDriver.click(contratacionBtn);
		// webDriver.clickInFrame(btnContratarMutuaAlquilerConfort, contentFrame);
		webDriver.clickInFrame(desplegarAlquileresBtn, contentFrame);
		webDriver.waitWithDriver(1000);
		webDriver.clickInFrame(contratarAlquileresBtn, contentFrame);
		webDriver.waitWithDriver(3000);
		
		webDriver.switchToWindow(1);
		
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openMisProyectosWeb() {
		debugBegin();

		webDriver.click(contratacionBtn);
		webDriver.click(misProyectosWebOptionBtn);

		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openSiniestros() {
		debugBegin();

		// webDriver.click(aceptarBtn);
		webDriver.click(siniestrosSelectorBtn);
		webDriver.click(altaSiniestroBtn);

		// webDriver.click(aceptarBtn);
		webDriver.click(contratacionSelectorBtn);
		webDriver.click(misProyectosWebOptionBtn);

		debugEnd();

		return this;
	}

	public void altaSiniestros() {
		debugBegin();

		// webDriver.click(aceptarBtn);
		webDriver.moveToElement(siniestrosSelectorBtn);
		// webDriver.click(siniestrosSelectorBtn);
		webDriver.click(altaSiniestroBtn);

		debugEnd();

	}

	public GestionOnlineHomePage buscarProyectoWeb(String noCotizacion) {
		debugBegin();

		webDriver.waitWithDriver(4000);

		webDriver.clickInFrame(codigoProyectoInput, contentFrame);
		debugInfo("Cotizacion: " + noCotizacion);
		webDriver.waitWithDriver(3000);
		webDriver.appendTextInFrame(codigoProyectoInput, contentFrame, noCotizacion);
		webDriver.clickInFrame(buscarBtn, contentFrame);

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

		while(!webDriver.isPresentInFrame(accionesDrpDwn, contentFrame)) {
			if(webDriver.isPresent(errorBuscarPanel)) {
				webDriver.click(cerrarErrorBuscarBtn);
				webDriver.clickInFrame(buscarBtn, contentFrame);
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
		this.webDriver.waitWithDriver(3000);
		this.webDriver.clickInFrame(accionesDrpDwn, contentFrame);
		this.webDriver.waitWithDriver(3000);
		this.webDriver.clickInFrame(modificarProyectoBtn, contentFrame);
		this.webDriver.switchToWindow(1);
		this.webDriver.waitWithDriver(3000);

		debugEnd();

		return this;
	}

	public String recuperarEstadoPoliza() {
		debugBegin();
		String result = webDriver.getTextInFrame(estadoPolizaTxt, contentFrame);
		debugEnd();

		return result;
	}

	public GestionOnlineHomePage openGestionCotizaciones() {
		debugBegin();
		webDriver.click(mapaWebBtn);
		webDriver.doubleClickInFrame(gestionCotizacionesBtn, mainFrame);
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage seleccionaIdiomaCast() {
		debugBegin();
		webDriver.click(idiomaCastellanoBtn);
		debugEnd();

		return this;
	}

	public GestionOnlineHomePage openGestionPolizas() {
		debugBegin();
		webDriver.doubleClickInFrame(mapaWebBtn, topFrame);
		webDriver.doubleClickInFrame(gestionPolizasBtn, mainFrame);
		debugEnd();

		return this;
	}
	// endregion
}
