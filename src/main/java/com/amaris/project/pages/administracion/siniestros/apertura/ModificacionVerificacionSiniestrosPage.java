package com.amaris.project.pages.administracion.siniestros.apertura;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class ModificacionVerificacionSiniestrosPage extends PageObject {

	// REGION Web Elements

	// TODO terminar de mapear webElements

	private By cuerpoFrame = By.cssSelector("#mainFrame");

	private By causaAnteriorTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(2) > td:nth-child(2)");
	private By causaNuevaTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(2) > td:nth-child(3)");

	private By rentaAnteriorTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(3) > td:nth-child(2)");
	private By rentaNuevaTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(3) > td:nth-child(3)");

	private By fechaDemandaDesTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(4) > td:nth-child(3)");
	private By fechaSolicitudAvanceRentaTxt = By.cssSelector("#formDatos > table.grid.narrowBox tr:nth-child(5) > td:nth-child(3)");

	private By grabarCambioBtn = By.cssSelector("#botonGrabar");
	// endregion

	// REGION Methods

	// Constructor
	public ModificacionVerificacionSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public ModificacionVerificacionSiniestrosPage mostrarCambios() {
		debugBegin();
		debugInfo("Se procede a mostrar los cambios producidos en el siniestro...");

		debugInfo("========================");
		debugInfo("Causa anterior: " + webDriver.getTextInFrame(causaAnteriorTxt, cuerpoFrame));
		debugInfo("Causa ACTUAL: " + webDriver.getTextInFrame(causaNuevaTxt, cuerpoFrame));
		debugInfo("------------------");
		debugInfo("Renta anterior: " + webDriver.getTextInFrame(rentaAnteriorTxt, cuerpoFrame));
		debugInfo("Renta ACTUAL: " + webDriver.getTextInFrame(rentaNuevaTxt, cuerpoFrame));
		debugInfo("------------------");
		debugInfo("Fecha interposición demanda desahucio: " + webDriver.getTextInFrame(fechaDemandaDesTxt, cuerpoFrame));
		debugInfo("Fecha solicitud avance renta: " + webDriver.getTextInFrame(fechaSolicitudAvanceRentaTxt, cuerpoFrame));
		debugInfo("------------------");

		debugEnd();
		return this;
	}

	public ModificacionVerificacionSiniestrosPage grabarCambios() {
		debugBegin();
		debugInfo("Grabando cambios...");
		webDriver.clickInFrame(grabarCambioBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}

	// End Region

	// END
}
