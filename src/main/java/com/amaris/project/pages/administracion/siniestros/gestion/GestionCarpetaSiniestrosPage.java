package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.steps.ActionSteps;

public class GestionCarpetaSiniestrosPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By carpetaBtn = By.cssSelector("#jt16");

	private By nuevaCarpetaBtn = By.cssSelector("li.js-action a");
	private By flechaAccionesBtn = By.cssSelector("div[id*=capaFlecha] a");
	private By tramitarBtn = By.cssSelector("div.cpdatos a");
	private By pesEncargo = By.cssSelector("#pes2");
	private By listEncargo = By.cssSelector("table.grid > tbody:nth-child(1) tr[valign='top'] td:nth-child(8) ");
	private By cerrarCarpetaBtn = By.cssSelector("ul.topnav > li:nth-child(6) > a:nth-child(1) span");
	private By tipoCarpetaTxt = By.cssSelector("table.grid > tbody:nth-child(1) tr[valign='top'] td:nth-child(4) ");

	// nueva carpeta
	private By tipoImplicaDrpDwn = By.cssSelector("#OTRIMPLI");
	private By rolImplicaDrpDwn = By.cssSelector("#implicado_rol");
	private By nombreInput = By.cssSelector("#nombre");
	private By apellidoInput = By.cssSelector("#apellido1");
	private By telefonoInput = By.cssSelector("#telefono1");
	private By telefono2Input = By.cssSelector("#telefono2");
	private By emailInput = By.cssSelector("#email");
	private By codIbanInput = By.cssSelector("div #codIban");
	private By bancoInput = By.cssSelector("div #codBan");
	private By sucursalInput = By.cssSelector("#codSuc");
	private By dcInput = By.cssSelector("#codDig");
	private By numeroCuentaInput = By.cssSelector("#codCue");
	private By compa = By.cssSelector("#companiaSOA");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By estadoCarpetaTxt = By.cssSelector("td:nth-child(7)");

	// cierre carpeta
	private By motivoCierreList = By.cssSelector("div.sis-col-50 #motivoCierre");
	private By cierreTareasBtn = By.cssSelector("#cierreTareas");
	private By grabarCierreBtn = By.cssSelector("#buttonRecord");

	private By noExistenCarpetas = By.cssSelector("body > form > div.sis-noresult");

	private By estadoSiniestroInfoTxt = By.cssSelector("form[name='formDatos'] table table > tbody > tr:nth-of-type(4) > td:nth-of-type(2)");

	public GestionCarpetaSiniestrosPage(UserStory userS) {
		super(userS);
	}

	public boolean comprobarTipoCarpeta() {
		boolean check = false;
		List<WebElement> listaTipoCarpeta = webDriver.getElements(tipoCarpetaTxt);

		for(int i = 0; i < listaTipoCarpeta.size() || check; i++) {
			if(webDriver.getText(listaTipoCarpeta.get(i)).equals("IMAS")){
				check = true;
				break;
			}
		}

		return check;
	}

	public boolean comprobarEncargos() {
		debugBegin();

		webDriver.clickInFrame(carpetaBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);
		
		boolean check = false;
		
		if(webDriver.isClickableInFrame(flechaAccionesBtn, cuerpoFrame)) {
			debugInfo("Hacer tramite");
			webDriver.clickInFrame(flechaAccionesBtn, cuerpoFrame);
			webDriver.waitWithDriver(1000);
			webDriver.clickInFrame(tramitarBtn, cuerpoFrame);
		}

		if(webDriver.isPresentInFrame(noExistenCarpetas, cuerpoFrame)) {
			return check;
		} else {
			webDriver.clickInFrame(pesEncargo, cuerpoFrame);

			if(webDriver.isClickableInFrame(listEncargo, cuerpoFrame)) {
				List<WebElement> listaPagos = webDriver.getElementsInFrame(listEncargo, cuerpoFrame);
				debugInfo("Contiene: " + listaPagos.size());

				for(int i = 0; i < listaPagos.size(); i++) {
					debugInfo("Estado: " + webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame));
					
					if(!webDriver.getTextInFrame(listaPagos.get(i), cuerpoFrame).equals("Cerrado")) {
						check = true;
						debugInfo("Encargos Pendiente: " + check);
						break;
					}
				}
			} else {
				debugInfo("No hay encargos");
			}
		}
		
		debugEnd();
		
		return check;
	}

	public GestionCarpetaSiniestrosPage nuevaCarpeta() {
		debugBegin();
		
		webDriver.clickInFrame(carpetaBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);
		webDriver.clickInFrame(nuevaCarpetaBtn, cuerpoFrame);
		
		debugInfo("Hecho click nueva carpeta");
		ActionSteps.waitForIt(webDriver);
		webDriver.clickElementChildByAttributeInFrame(tipoImplicaDrpDwn, cuerpoFrame, "value", "CAUS");
		webDriver.clickElementChildByAttributeInFrame(rolImplicaDrpDwn, cuerpoFrame, "value", "TOMA");
		webDriver.waitWithDriver(5000);
		
		webDriver.setTextInFrame(telefonoInput, cuerpoFrame, "911250100");
		webDriver.setTextInFrame(telefono2Input, cuerpoFrame, "961234567");
		webDriver.setTextInFrame(emailInput, cuerpoFrame, "prueba@esto.es");
		webDriver.waitWithDriver(8000);
		webDriver.setTextInFrame(codIbanInput, cuerpoFrame, "ES03");
		webDriver.setTextInFrame(bancoInput, cuerpoFrame, "2100");
		webDriver.setTextInFrame(sucursalInput, cuerpoFrame, "1234");
		webDriver.setTextInFrame(dcInput, cuerpoFrame, "56");
		webDriver.setTextInFrame(numeroCuentaInput, cuerpoFrame, "1234567890");
		webDriver.waitWithDriver(5000);
		
		webDriver.clickInFrame(grabarBtn, cuerpoFrame);
		
		debugInfo("Comprobamos el estado del siniestro (debería ser: Abierto)");
		debugInfo(webDriver.getTextInFrame(estadoSiniestroInfoTxt, cuerpoFrame));

		webDriver.waitWithDriver(9000);
		
		debugEnd();
		
		return this;
	}

	public GestionCarpetaSiniestrosPage cerrarCarpeta() {
		debugBegin();
		
		webDriver.clickInFrame(carpetaBtn, leftFrame);
		ActionSteps.waitForIt(webDriver);
		
		if(webDriver.isClickableInFrame(flechaAccionesBtn, cuerpoFrame)) {
			List<WebElement> estado = webDriver.getElementsInFrame(estadoCarpetaTxt, cuerpoFrame);
			debugInfo("contiene: " + estado.size());
			debugInfo("despues de la lista");
			
			for(int i = 0; i < estado.size(); i++) {
				debugInfo("Estado: " + estado.get(i).getText());
				
				if(webDriver.getTextInFrame(estado.get(i), cuerpoFrame).equals("Abierto")) {
					debugInfo("Carpeta abierta: Hacer tramite");
					webDriver.clickInFrame(By.cssSelector("tr[align*=center]:nth-child(" + (i + 2) + ") div[id*=capaFlecha] a"), cuerpoFrame);
					webDriver.waitWithDriver(1000);
					webDriver.clickInFrame(tramitarBtn, cuerpoFrame);
				}
			}
			
			ActionSteps.waitForIt(webDriver);
			webDriver.clickInFrame(cerrarCarpetaBtn, cuerpoFrame);
			
			
			debugInfo("Cierre");
			webDriver.waitWithDriver(5000);
			webDriver.switchToFrame(cuerpoFrame);
			webDriver.switchToFrame(capaIframe);

			webDriver.clickElementChildByAttribute(motivoCierreList, "value", "ERAD");
			
			debugInfo("Motivo");
			webDriver.click(grabarCierreBtn);
			webDriver.exitFrame();
		}

		debugEnd();

		return this;
	}

}