package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MediadoresDGSPage extends PageObject {

	// region WebElements
	private By menuFrame = By.id("mainFrame");
	private By modalFrame = By.id("leftFrame");

	private By notificarDGSBtn = By.id("BUSENVIO");
	private By descartarNotificarDGSBtn = By.id("BUSENVIO2");
	private By tipoMediadorAgenteExclusivoBtn = By.id("TIPOMEDI");
	private By tipoMediadorAuxiliarBtn = By.id("TIPOMEDI2");

	private By actualizarInformacionEnvioBtn = By.id("BUSRECEP");
	private By actualizarMediadoresEnvioBtn = By.id("BUSRECEP2");
	private By numeroEnvioInternoBtn = By.id("BUSC");
	private By numeroExpedienteBtn = By.id("BUSC2");
	private By numeroRegistroBtn = By.id("BUSC3");
	private By numeroTasasBtn = By.id("BUSC4");

	private By numeroBuscadoInput = By.id("NUMERO");
	private By numeroReferenciaInput = By.id("ALTAMEDI_NUMEXPED");
	private By fechaReferenciaInput = By.id("ALTAMEDI_FCREGSTR");
	private By numeroRegistroInput = By.id("ALTAMEDI_NUMRGSTR");
	private By numeroPagoTasasInput = By.id("ALTAMEDI_NUMTASA");
	private By fechaInscripcionInput = By.id("ALTAMEDI_FEINSDGS");
	private By respuestaDGSCombo = By.name("accion_0");
	private By codigoEntidadInput = By.id("entidad1");

	private By buscarBtn= By.cssSelector("input[name='botonBuscar']");
	private By enviarDGSBtn = By.id("BOTON_ENVIDGS");
	private By actualizarBtn= By.id("BOTON_ACTUALIZAR");

	private By xmlBtn = By.id("BUSCADGS_XML");
	private By excelBtn = By.id("BUSCADGS_XLS");
	private By volverBtn = By.id("BUSCADGS_BACK");
	// endregion

	public MediadoresDGSPage(UserStory userS) {
		super(userS);
	}

	public MediadoresDGSPage clickActualizar() {
		debugBegin();
		webDriver.clickInFrame(actualizarBtn, menuFrame);
		debugEnd();

		return this;
	}
	public MediadoresDGSPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, menuFrame);
		debugEnd();

		return this;
	}
	public MediadoresDGSPage clickEnviarDGS() {
		debugBegin();
		webDriver.clickInFrame(enviarDGSBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickXML() {
		debugBegin();
		webDriver.clickInFrame(xmlBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickExcel() {
		debugBegin();
		webDriver.clickInFrame(excelBtn, menuFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickVolver() {
		debugBegin();
		webDriver.clickInFrame(volverBtn, menuFrame);
		debugEnd();

		return this;
	}

	// Seleccionar casilla en la tabla
	//Leer texto en la tabla
/*
	public MediadoresDGSPage accederElementosTabla() {

		return this;
	}
 */

}
