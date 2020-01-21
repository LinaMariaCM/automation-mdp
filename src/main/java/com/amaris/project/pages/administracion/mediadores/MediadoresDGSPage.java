package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresDGSPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By notificarDGSBtn = By.cssSelector("#BUSENVIO");
	private By descartarNotificarDGSBtn = By.cssSelector("#BUSENVIO2");
	private By tipoMediadorAgenteExclusivoBtn = By.cssSelector("#TIPOMEDI");
	private By tipoMediadorAuxiliarBtn = By.cssSelector("#TIPOMEDI2");

	private By actualizarInformacionEnvioBtn = By.cssSelector("#BUSRECEP");
	private By actualizarMediadoresEnvioBtn = By.cssSelector("#BUSRECEP2");
	private By numeroEnvioInternoBtn = By.cssSelector("#BUSC");
	private By numeroExpedienteBtn = By.cssSelector("#BUSC2");
	private By numeroRegistroBtn = By.cssSelector("#BUSC3");
	private By numeroTasasBtn = By.cssSelector("#BUSC4");

	private By numeroBuscadoInput = By.cssSelector("#NUMERO");
	private By numeroReferenciaInput = By.cssSelector("#ALTAMEDI_NUMEXPED");
	private By fechaReferenciaInput = By.cssSelector("#ALTAMEDI_FCREGSTR");
	private By numeroRegistroInput = By.cssSelector("#ALTAMEDI_NUMRGSTR");
	private By numeroPagoTasasInput = By.cssSelector("#ALTAMEDI_NUMTASA");
	private By fechaInscripcionInput = By.cssSelector("#ALTAMEDI_FEINSDGS");
	private By respuestaDGSCombo = By.cssSelector("#tr1 > td:nth-child(2) > select");
	private By codigoEntidadInput = By.cssSelector("#entidad1");

	private By buscarBtn= By.cssSelector("#cajabuscador > tbody > tr > td.marcofnd > input");
	private By enviarDGSBtn = By.cssSelector("#BOTON_ENVIDGS");
	private By actualizarBtn= By.cssSelector("#BOTON_ACTUALIZAR");
	private By descartarDGSBtn= By.cssSelector("#BOTON_DESCDGS");

	private By xmlBtn = By.cssSelector("#BUSCADGS_XML");
	private By excelBtn = By.cssSelector("#BUSCADGS_XLS");
	private By volverBtn = By.cssSelector("#BUSCADGS_BACK");
	// endregion

	public MediadoresDGSPage(UserStory userS) {
		super(userS);
	}

	public MediadoresDGSPage clickActualizar() {
		debugBegin();
		webDriver.clickInFrame(actualizarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	public MediadoresDGSPage clickBuscar() {
		debugBegin();
		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}
	public MediadoresDGSPage clickEnviarDGS() {
		debugBegin();
		webDriver.clickInFrame(enviarDGSBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickXML() {
		debugBegin();
		webDriver.clickInFrame(xmlBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickExcel() {
		debugBegin();
		webDriver.clickInFrame(excelBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickVolver() {
		debugBegin();
		webDriver.clickInFrame(volverBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public MediadoresDGSPage clickDescartarDGS() {
		debugBegin();
		webDriver.clickInFrame(descartarDGSBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

}
