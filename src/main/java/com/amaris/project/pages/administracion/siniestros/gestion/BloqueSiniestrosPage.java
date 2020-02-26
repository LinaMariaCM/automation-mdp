package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;
import org.testng.Assert;

public class BloqueSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By bloqueBtn = By.cssSelector("#jt7");
	private By acciones = By.cssSelector("#capaFlecha12 a");
	//private By transicionarBtn = By.cssSelector("div.cpdatos a");
	private By transicionarBtn = By.linkText("Transicionar bloque");
	private By codBloque = By.cssSelector("#bloque1tr1 > td:nth-child(2)");
	private By listaBloque = By.cssSelector("table.grid.wideBox > tbody > tr[id*='bloque1tr']");

	// transicionar bloque
	private By bloqueDestinoDrpDwn = By.cssSelector("#nuevaCarpeta");
	private By bloqueDestinoOption = By.cssSelector("#nuevaCarpeta > option");
	private By reserva = By.cssSelector("#reservas");
	private By tarea_ori = By.cssSelector("#tareas_ori");
	private By tarea_desti = By.cssSelector("#tareas_des");
	private By datos = By.cssSelector("#datos");
	private By cierre = By.cssSelector("#cierre_ori");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By cancelar = By.cssSelector("#botonCancelar");
	private By errorTxt = By.cssSelector("td.sis-font-l");
	private By bloqueTransicionadoTxt = By.cssSelector("#bloque1tr2 > td:nth-child(2)");

	// Opciones
	private By opReservasBtn = By.cssSelector("#reservas");
	private By opOriginalBtn = By.cssSelector("#tareas_ori");
	private By opTareasBtn = By.cssSelector("#tareas_des");
	private By opDatosBtn = By.cssSelector("#datos");
	private By opCierreBtn = By.cssSelector("#cierre_ori");

	// pago a carpeta
	private By listaBloques = By.cssSelector("#bloque1tr1 > td:nth-child(1)");
	private By desplegarCarpetasBtn = By.cssSelector("a#cabeceraBloqueDesplegable1");
	private By listaCarpetas = By.cssSelector("#bloque1tr1b > td:nth-child(2)");
	private By menuAccionesCarpetaBloqueBtn = By.cssSelector(".innerTable [id*='capaFlecha']");
	private By pagoACarpetaBtn = By.cssSelector("[onclick*='TITULO=Pago a carpeta']");

	public BloqueSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// TODO Revisar para hacer rehusable con transicionarBloqueSinCerrarOrigen
	public BloqueSiniestrosPage transicionarBloqueCerrandoOrigen() {
		debugBegin();
		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(bloqueBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);

		debugInfo("Estoy en bloque");
		webDriver.waitWithDriver(3000);

		List<WebElement> listaBloques = webDriver.getElementsInFrame(listaBloque, cuerpoFrame);

		debugInfo("Contiene: " + listaBloques.size());
		for(int i = 0; i < listaBloques.size(); i++) {
			String codigo = webDriver.getTextInFrame(By.cssSelector("#bloque1tr" + (i + 1) + "> td:nth-child(2"), cuerpoFrame);
			debugInfo("El codigo es: " + codigo);

			debugInfo("Click acciones");
			webDriver.clickInFrame(By.cssSelector("#capaFlecha" + codigo + " a"), cuerpoFrame);

			if(webDriver.isClickableInFrame(transicionarBtn, cuerpoFrame)) {
				debugInfo("Contiene transiciona");
				webDriver.clickInFrame(transicionarBtn, cuerpoFrame);
				webDriver.waitWithDriver(3000);
				break;
			} else {
				debugInfo("No contiene transiciona");
				webDriver.clickInFrame(By.cssSelector("#cabeceraBloqueDesplegable" + (i + 1)), cuerpoFrame);
			}
		}

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);
		webDriver.click(bloqueDestinoDrpDwn);
		webDriver.clickElementFromDropDownByAttribute(bloqueDestinoDrpDwn, bloqueDestinoOption, "value", "11");

		debugInfo("Destino bloque");
		if(webDriver.isClickable(errorTxt)) {
			String mensjError = webDriver.getText(By.cssSelector("td.sis-font-l p strong"));
			debugInfo(mensjError);
		} else {
			debugInfo("Opcion reservas");
			webDriver.click(opReservasBtn);

			debugInfo("Opcion Tareas originales");
			webDriver.click(opOriginalBtn);

			debugInfo("Opcion Tareas destino");
			webDriver.click(opTareasBtn);

			debugInfo("Opcion Datos");
			webDriver.click(opDatosBtn);

			debugInfo("Opcion Cierre expediente de origen");
			webDriver.click(opCierreBtn);

			debugInfo("Se acaba de transicionar el bloque 13 al 11");
			webDriver.click(grabarBtn);
		}

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public BloqueSiniestrosPage transicionarBloqueSinCerrarOrigen() {
		debugBegin();

		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(bloqueBtn, leftFrame);

		ActionSteps.waitForIt(webDriver);

		debugInfo("Estoy en bloque");
		webDriver.waitWithDriver(3000);

		List<WebElement> listaBloques = webDriver.getElementsInFrame(listaBloque, cuerpoFrame);

		debugInfo("Contiene: " + listaBloques.size());
		for(int i = 0; i < listaBloques.size(); i++) {
			String codigo = webDriver.getTextInFrame(By.cssSelector("#bloque1tr" + (i + 1) + "> td:nth-child(2)"), cuerpoFrame);
			debugInfo("El codigo es: " + codigo);

			debugInfo("Click acciones");
			webDriver.clickInFrame(By.cssSelector("#capaFlecha" + codigo + " a"), cuerpoFrame);

		/*	if(webDriver.isClickableInFrame(transicionarBtn, cuerpoFrame)) {
				debugInfo("Contiene transiciona");*/
				webDriver.clickInFrame(transicionarBtn, cuerpoFrame);
				webDriver.waitWithDriver(3000);
		/*	} else {
				debugInfo("No contiene transiciona");
				webDriver.clickInFrame(By.cssSelector("#cabeceraBloqueDesplegable" + (i + 1)), cuerpoFrame);
			}*/
		}

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.switchToFrame(capaIframe);
		webDriver.click(bloqueDestinoDrpDwn);
		webDriver.clickElementFromDropDownByAttribute(bloqueDestinoDrpDwn, bloqueDestinoOption, "value", "31");

		debugInfo("Destino bloque");
		if(webDriver.isClickable(errorTxt)) {
			String mensjError = webDriver.getText(By.cssSelector("td.sis-font-l p strong"));
			debugInfo(mensjError);
		} else {
			debugInfo("Opcion reservas");
			webDriver.click(opReservasBtn);

			debugInfo("Opcion Datos");
			webDriver.click(opDatosBtn);

			debugInfo("Se acaba de transicionar el bloque 11 al 31");
			webDriver.click(grabarBtn);
		}

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	// Comprobar transiciones
	public BloqueSiniestrosPage iniciarPagoACarpeta() {
		debugBegin();

		webDriver.waitWithDriver(2000);
		webDriver.clickInFrame(bloqueBtn, leftFrame);

		ActionSteps.waitForIt(webDriver);

		debugInfo("Estoy en bloques");
		webDriver.switchToFrame(cuerpoFrame);

		debugInfo("Clic en desplegar lista de carpetas");
		webDriver.click(desplegarCarpetasBtn);

		debugInfo("Clic en desplegar lista de acciones de carpetas");
		webDriver.click(menuAccionesCarpetaBloqueBtn);

		debugInfo("Clic en el botón pago a carpeta");
		webDriver.click(pagoACarpetaBtn);

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	// TODO Revisar para hacer rehusable con verificarTransicionesSinCerrarOrigen
	public BloqueSiniestrosPage verificarTransicionesCerrandoOrigen() {
		debugBegin();

		webDriver.clickInFrame(bloqueBtn, leftFrame);
		webDriver.waitWithDriver(3000);

		String codigoTransicionado = webDriver.getTextInFrame(bloqueTransicionadoTxt, cuerpoFrame).trim();

		boolean checkTransicionado = codigoTransicionado.equals("11");
		Assert.assertTrue(checkTransicionado, "COMPARAR CAMPOS : El bloque de destino NO es 11, tal como se introdujo en la prueba");

		debugEnd();

		return this;
	}

	public BloqueSiniestrosPage verificarTransicionesSinCerrarOrigen() {
		debugBegin();

		webDriver.clickInFrame(bloqueBtn, leftFrame);
		String codigoTransicionado = webDriver.getTextInFrame(bloqueTransicionadoTxt, cuerpoFrame).trim();

		boolean checkTransicionado = codigoTransicionado.equals(getTestVar("31"));
		Assert.assertTrue(checkTransicionado, "COMPARAR CAMPOS : El bloque de destino NO es 31, tal como se introdujo en la prueba");

		debugEnd();
		return this;
	}

}