package com.amaris.project.pages.administracion.siniestros.gestion;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VistaSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By nPolizaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By responsableInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)");

	private By aseguradoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By fOcurrenciaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");

	private By riesgoInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");
	private By fAperturaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)");

	private By tipoCausaInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(1)");
	// private By estadoSiniestroInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) >
	// td:nth-of-type(2)");

	private By estadoSiniestroInfoTxt = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(2)");

	private By mediadorInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(1)");
	private By fechaCierreSiniestro = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(5) > td:nth-of-type(2)");

	private By tareasPendientesInfo = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(6) > td:nth-of-type(1)");

	private By costeActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)");
	private By importePagosInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	private By reservaActualInfo = By.cssSelector("form[name='formDatos'] table td:nth-of-type(2) table > tbody > tr:nth-of-type(3) > td:nth-of-type(1)");

	private By causaSin = By.cssSelector("body > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(1)");

	private By vistaSiniestroBtn = By.cssSelector("#jt3");

	private By cerrarSiniestroBtn = By.cssSelector("li:nth-child(1) span");
	private By modifiDatosBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(3) span");
	private By modificarAltaBtn = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(1) > a > span");
	private By altaAnotacion = By.cssSelector("#_sisnet_js_actionsdinamicbar_0 > li:nth-child(5) span");

	// Pestañas
	private By datoEco = By.cssSelector("#pes1");
	private By poliRecibo = By.cssSelector("#pes2");
	private By otrosSinies = By.cssSelector("#pes3");
	private By historicoBtn = By.cssSelector("#pes4");
	private By carpeta = By.cssSelector("#pes5");
	private By consultaSinies = By.cssSelector("#pes6");
	private By clasulas = By.cssSelector("#pes7");

	private By modiReferencia = By.cssSelector("#capaAjax .secondButton");
	private By def = By.cssSelector("#DEF");
	private By sac = By.cssSelector("#SAC");
	private By dgs = By.cssSelector("#DGS");
	private By reclamacion = By.cssSelector("#RECLAMACION");

	// Historico
	private By accederHistorico1Btn = By.cssSelector("#formPestania > table > tbody > tr.odd > td:nth-child(5) > a > span");
	private By historico1 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(3)");
	private By historico2 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(3) > td:nth-child(3)");
	private By historico3 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(4) > td:nth-child(3)");
	private By historico4 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(5) > td:nth-child(3)");
	private By historico5 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(6) > td:nth-child(3)");
	private By historico6 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(7) > td:nth-child(3)");
	private By historico7 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(8) > td:nth-child(3)");
	private By historico8 = By.cssSelector("#formDatos > table:nth-child(4) > tbody > tr:nth-child(9) > td:nth-child(3)");

	private By descripcionNuevaTxt = By.cssSelector("#formDatos > table:nth-child(7) > tbody > tr.odd > td:nth-child(3)");

	private By valoresNuevosList[] = { historico1, historico2, historico3, historico4, historico5, historico6, historico7, historico8};

	// Cierre
	private By motivoDrpDwn = By.cssSelector("#motivoCierre");
	private By motivoOption = By.cssSelector("#motivoCierre > option");

	private By grabarBtn = By.cssSelector("#botonGrabar");

	private By estadoSiniestro = By.cssSelector(("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)"));

	public VistaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public VistaSiniestrosPage cierreSiniestro(Boolean pagos, Boolean encargos, Boolean tareas) {
		debugBegin();

		// System.out.println("El estado del siniestro es: " + webDriver.getTextInFrame(estadoSiniestro, cuerpoFrame));
		// if(webDriver.getText(estadoSiniestro).compareTo("Cerrado") == 0) {
		// System.out.println("La carpeta del siniestro está cerrada, no se le puede añadir un pago.");

		// } else {

		if(!pagos && !encargos) {
			webDriver.clickInFrame(vistaSiniestroBtn, leftFrame);
			ActionSteps.waitForIt(webDriver);

			debugInfo("Vista");
			webDriver.clickInFrame(cerrarSiniestroBtn, cuerpoFrame);

			webDriver.waitWithDriver(8000);
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(capaIframe);

			webDriver.clickElementFromDropDownByAttribute(motivoDrpDwn, motivoOption, "value", "PRSC");

			webDriver.click(grabarBtn);

			webDriver.exitFrame();
		} else {
			debugInfo("Hay tareas pendientes.");
		}

		debugInfo("Comprobamos estado de Siniestro: ");
		webDriver.waitWithDriver(3000);
		debugInfo("Estado siniestro: " + webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame));

		debugEnd();

		return this;

	}

	public VistaSiniestrosPage modificarSiniestro() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(vistaSiniestroBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(modifiDatosBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public VistaSiniestrosPage modificarAltaSiniestro() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(vistaSiniestroBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(modificarAltaBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public VistaSiniestrosPage mapeoHistoricoModificarDatos(String nombre, String apellidoPri, String apellidoSeg, String telefono, String email, String descripcion) {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);

		int n = 0;
		String nuevosValores = "";

		while(webDriver.isPresent(valoresNuevosList[n])) {
			nuevosValores += " " + webDriver.getText(valoresNuevosList[n]);
			n++;
		}

		Assert.assertTrue((nuevosValores.contains(nombre) && nuevosValores.contains(apellidoPri) && nuevosValores.contains(apellidoSeg) && nuevosValores.contains(telefono)
			&& nuevosValores.contains(email)), "Los datos modificados se muestran correctamente en el historial");

		Assert.assertTrue(webDriver.getText(descripcionNuevaTxt).contains(descripcion), "Modificación siniestro completada con exito");

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public VistaSiniestrosPage mapeoHistoricoModificarCausa(String grupoCausa, String tipoCausa) {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);

		String nuevosValores = "";
		int n = 0;
		while(webDriver.isPresent(valoresNuevosList[n])) {
			nuevosValores = nuevosValores + " " + webDriver.getText(valoresNuevosList[n]);
			n++;
		}

		/*
		 * System.out.println(nuevosValores);
		 * 
		 * if(nuevosValores.contains(nombre))System.out.println("nombre OK"); else {
		 * System.out.println("Algo ha ido regular: "); System.out.println(nombre); }
		 */

		Assert.assertTrue((nuevosValores.contains(grupoCausa) && nuevosValores.contains(tipoCausa)), "Los datos modificados se muestran correctamente en el historial");

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public VistaSiniestrosPage irVistaSiniestroHistorico() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(vistaSiniestroBtn, leftFrame);

		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(historicoBtn, cuerpoFrame);
		
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(historicoBtn, cuerpoFrame);
		
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(accederHistorico1Btn, cuerpoFrame);

		debugEnd();
		return this;
	}

}// END