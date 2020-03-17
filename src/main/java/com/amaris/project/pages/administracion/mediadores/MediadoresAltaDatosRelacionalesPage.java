package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ChecksUtils;
import org.openqa.selenium.By;

public class MediadoresAltaDatosRelacionalesPage extends PageObject {

	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");

	private By especialistaRamoSIBtn = By.id("ALTAMEDI_ESPRAMOSI");
	private By especialistaRamoNOBtn = By.id("ALTAMEDI_ESPRAMONO");
	private By especialistaRamoCombo = By.cssSelector("#ALTAMEDI_RAMO");
	private By especialistaRamoOption = By.cssSelector("#ALTAMEDI_RAMO > option");

	private By adminFincasSIBtn = By.id("ALTAMEDI_FINCASSI");
	private By adminFincasNOBtn = By.id("ALTAMEDI_FINCASNO");
	private By adminFincasCuantasInput = By.id("ALTAMEDI_FINCAS");

	private By compPrincipInput = By.id("ALTAMEDI_COMPPRIN");
	private By compPrincipObligDisplay = By.cssSelector("#capaDatosMediador > div > div.marcofnd > table.wideBox > tbody > tr.flexibleField > th > label > span");

	private By medNuevoBancoBtn = By.linkText("Añadir nuevo banco");
	private By nombreBancoInput = By.cssSelector("#ALTAMEDI_NOMBANCO");
	private By observacionesBancoInput = By.cssSelector("#ALTAMEDI_OBSBANCO");

	private By grabarBtn = By.cssSelector("#buttonRecord");
	private By volverBtn = By.cssSelector("#botonVolver");

	private By avisoSistemaTxt = By.cssSelector("body > table > tbody > tr > td > p > strong");

	//-----------Controles de pagina---------------------------

	private By continuarBtn = By.id("botonContinuar1");

	public MediadoresAltaDatosRelacionalesPage(UserStory userS) {
		super(userS);
	}

	//---------------Añadir datos PRODUCTO--------------------------//

	public MediadoresAltaDatosRelacionalesPage anyadirDatosProductoConRamoConFinca() {

		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(especialistaRamoSIBtn);
		if(!getScenarioVar(Constants.RAMO).isEmpty()) {
			webDriver.clickElementFromDropDownByAttribute(especialistaRamoCombo, especialistaRamoOption, "value", getScenarioVar(Constants.RAMO));
		} else {
			webDriver.clickElementFromDropDownByAttribute(especialistaRamoCombo, especialistaRamoOption, "value", "10");
		}
		webDriver.click(adminFincasSIBtn);
		webDriver.setText(adminFincasCuantasInput, "30");
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	//------------------Añadir datos nuevo banco---------------------------
	public MediadoresAltaDatosRelacionalesPage anyadirNuevoBanco(String nombreBanco) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(medNuevoBancoBtn);
		webDriver.waitWithDriver(8000);
		webDriver.setTextInFrame(nombreBancoInput, nombreBanco, modalFrame);
		webDriver.switchToFrame(cuerpoFrame);
		webDriver.waitWithDriver(5000);
		webDriver.clickInFrame(grabarBtn, modalFrame);

		debugEnd();

		return this;
	}

	public MediadoresAltaDatosRelacionalesPage clickContinuarDatosRelacionales() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	//---------------------MÉTODOS COMPLEJOS----------------------------------

	public MediadoresAltaDatosRelacionalesPage altaDatosRelacionales() {
		debugBegin();

		anyadirDatosProductoConRamoConFinca();

		if(webDriver.isPresentInFrame(compPrincipObligDisplay, cuerpoFrame) && getScenarioVar(Constants.COMPANYIAS_PRINCIPALES) != null && !getScenarioVar(Constants.COMPANYIAS_PRINCIPALES)
			.isEmpty()) {
			webDriver.setTextInFrame(compPrincipInput, cuerpoFrame, getScenarioVar(Constants.COMPANYIAS_PRINCIPALES));
		} else {
			webDriver.setTextInFrame(compPrincipInput, "Compania principal abogado", cuerpoFrame);
		}

		anyadirNuevoBanco("Nombre del banco");

		debugEnd();

		return this;
	}

	//--------------RETENCIONES DE DATOS RELACIONALES DE ALTAS DE INTERMEDIARIOS, OFICINA Y COLABORADOR---------------------------------

	public boolean alertaSistemaRelacionales(String mensaje) {
		debugBegin();

		String alerta = webDriver.getTextInFrame(avisoSistemaTxt, cuerpoFrame).trim();
		boolean checkAlerta = alerta.equalsIgnoreCase(mensaje);

		debugInfo("Mensaje esperado: " + mensaje);
		debugInfo("Mensaje real: " + alerta);

		debugEnd();

		return checkAlerta;
	}

	public MediadoresAltaDatosRelacionalesPage altaRetencionesRelacionales() {
		debugBegin();

		webDriver.clickInFrame(especialistaRamoSIBtn, cuerpoFrame);

		clickContinuarDatosRelacionales();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_RAMO_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.clickElementFromDropDownByAttributeInFrame(especialistaRamoCombo, especialistaRamoOption, cuerpoFrame, "value", "1");

		webDriver.clickInFrame(adminFincasSIBtn, cuerpoFrame);

		clickContinuarDatosRelacionales();

		new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_CUANTAS_FINCAS_MEDIADORES);
		webDriver.acceptAlert();

		webDriver.setTextInFrame(adminFincasCuantasInput, cuerpoFrame, "10");

		clickContinuarDatosRelacionales();

		if(!getTestVar(Constants.NIVEL_ESTRUCTURA).isEmpty()
			&& getTestVar(Constants.NIVEL_ESTRUCTURA).equalsIgnoreCase("INTE")) {
			if(!getTestVar(Constants.TIPO_MEDIADOR).isEmpty()
				&& !getTestVar(Constants.TIPO_MEDIADOR).equalsIgnoreCase("AD")) {

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_COMPANYIAS_PRINCIPALES_TRABAJADO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.setTextInFrame(compPrincipInput, cuerpoFrame, "Principales");

				clickContinuarDatosRelacionales();

				alertaSistemaRelacionales(Constants.ALERTA_ENTIDAD_OBLIGATORIA_MEDIADORES);

				webDriver.switchToFrame(cuerpoFrame);

				webDriver.click(volverBtn);
				webDriver.click(medNuevoBancoBtn);
				webDriver.waitWithDriver(3000);
				webDriver.switchToFrame(modalFrame);
				webDriver.click(grabarBtn);

				new ChecksUtils(userS).comprobarAlerta(Constants.ALERTA_NOMBRE_BANCO_MEDIADORES);
				webDriver.acceptAlert();

				webDriver.switchToFrame(cuerpoFrame);
				webDriver.switchToFrame(modalFrame);
				webDriver.setText(nombreBancoInput, "Banco");
				webDriver.click(grabarBtn);

				webDriver.exitFrame();

				clickContinuarDatosRelacionales();
			}
		}
		debugEnd();

		return this;
	}

}
