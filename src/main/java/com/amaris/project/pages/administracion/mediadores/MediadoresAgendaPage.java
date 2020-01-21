package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAgendaPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	//----------Nueva anotacion elementos-----------------------------------
	private By nuevaAnotacionBtn = By.cssSelector("#cabAnotacion");

	private By nuevaTareaBtn = By.cssSelector("#capaContenido > table > tbody > tr > td > div:nth-child(1) > a");
	private By tituloTareaInput = By.cssSelector("#titulo");
	private By descripcionTareaBtn = By.cssSelector("#anotacion");
	private By categoriaTareaCombo = By.cssSelector("#categoria");
	private By prioridadTareaCombo = By.cssSelector("#priority");
	private By fechaFinTareaInput = By.cssSelector("#fechaler");
	private By grabarAnotacionBtn = By.cssSelector("body > form > table > tbody > tr > td > input");

	private By plantillasBtn = By.cssSelector("#cabPlantillas");
	private By codigoPlantillaInput = By.cssSelector("#queryPlantilla");
	private By seleccionarPlantillaCombo = By.cssSelector("#plantilla");
	private By buscarPlantillaBtn = By.cssSelector("#botonPlantilla");

	private By documentosBtn = By.cssSelector("#cabDocumentos");

	//------------------Vistas-----------------------------------
	private By vistasBtn = By.cssSelector("#cabVistas");
	private By vistaMediadorBtn = By.cssSelector("#MEDIADOR");
	private By cerrarVistasElementBtn = By.cssSelector("#bloqueVistas > table > tbody > tr > td > div.sis-container-header > span > a > span");

	//-----------Filtrar------------------------
	private By filtrarBtn = By.cssSelector("#cabFiltrar");
	private By cerrarConfFiltrosBtn = By.cssSelector("#bloqueFiltrar > table > tbody > tr > td > div.sis-container-header > span > a > span");

	//-------------Leyenda------------------------------------
	private By leyendaBtn = By.cssSelector("#cabLeyenda");
	private By cerrarLeyendaBtn = By.cssSelector("#bloqueLeyenda > table > tbody > tr > td > div > span > a > span");

	//-----------Tareas futuras------------
	private By tareasFuturasBtn = By.cssSelector("#cabCalendario");
	private By calendSemanaBtn = By.cssSelector("#lnkPeriodo1");
	private By calendQuincenaBtn = By.cssSelector("#lnkPeriodo2");
	private By calendMesBtn = By.cssSelector("#lnkPeriodo3");
	private By calendTrimestreBtn = By.cssSelector("#lnkPeriodo4");
	private By calendSemestreBtn = By.cssSelector("#lnkPeriodo5");
	private By calendAnualBtn = By.cssSelector("#lnkPeriodo6");
	private By calendBianualBtn = By.cssSelector("#lnkPeriodo7");
	private By volverCalendarioBtn = By.cssSelector("div[id='funcionVolver'] > [id='cabAnotacion']");

	//-----------Anotaciones----------
	private By anotacionesBtn = By.cssSelector("#pesANOTACIONES");

	public MediadoresAgendaPage(UserStory userS) {
		super(userS);
	}

	public MediadoresAgendaPage clickVolverCalendario() {
		debugBegin();
		webDriver.clickInFrame(volverCalendarioBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickTareasFuturas() {
		debugBegin();
		webDriver.clickInFrame(tareasFuturasBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickCerrarLeyenda() {
		debugBegin();
		webDriver.clickInFrame(cerrarLeyendaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickCerrarConfiguracionFiltro() {
		debugBegin();
		webDriver.clickInFrame(cerrarConfFiltrosBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickCerrarVistasElementos() {
		debugBegin();
		webDriver.clickInFrame(cerrarVistasElementBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickBuscarPlantillas() {
		debugBegin();
		webDriver.clickInFrame(buscarPlantillaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickGrabarAnotacion() {
		debugBegin();
		webDriver.clickInFrame(grabarAnotacionBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickNuevaAnotacion() {
		debugBegin();
		webDriver.clickInFrame(nuevaAnotacionBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickNuevaTarea() {
		debugBegin();
		webDriver.clickInFrame(nuevaTareaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickPlantillas() {
		debugBegin();
		webDriver.clickInFrame(plantillasBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickVistas() {
		debugBegin();
		webDriver.clickInFrame(vistasBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickLeyenda() {
		debugBegin();
		webDriver.clickInFrame(leyendaBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickFiltrar() {
		debugBegin();
		webDriver.clickInFrame(filtrarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresAgendaPage clickAnotacion() {
		debugBegin();
		webDriver.clickInFrame(anotacionesBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
}