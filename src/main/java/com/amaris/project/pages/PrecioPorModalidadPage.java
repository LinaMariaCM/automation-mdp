package com.amaris.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.Helpers.CoberturasAdicionalesHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;
import com.amaris.project.utils.CoberturasAdicionalesHelper;

public class PrecioPorModalidadPage extends PageObject {

	private String precioPlusAfter;
	private String precioPlusBefore;
	private String precioBasicAfter;
	private String precioBasicBefore;
	private String precioCompletoAfter;
	private String precioCompletoBefore;
	private String xPathFilterClausulaText = ".//td[3]";
	private String xPathFilterClausulaCheckbox = ".//td[input[@type='checkbox']]/input";
	private List<CoberturasAdicionalesHelper> coberturasAdicionales;

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By topFrame = By.cssSelector("#topFrame");
	private By hiddenFrame = By.cssSelector("#hideFrame");

	//private By btnContinuar = By.cssSelector("#botonContinuar");
	private By btnContinuar = By.cssSelector("button[ng-bind-html*='continuar']");
	private By btnGuardar = By.xpath(".//*[text()='Guardar']");
	private By btnCancelar = By.xpath(".//*[contains(text(),'Cancelar')]");
	private By btnAceptarInDialog = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");
	private By txtCodigoProjecto = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");
	private By btnWithCoberturaAdicional = By.xpath(".//tr[td[input[@type='checkbox']]]");

	private By rowWithCoberturaAdicional = By.xpath(".//*[input]/input");
	private By selectedCheckboxes = By.cssSelector("input:checked[type=checkbox]");

	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");
	private By btnAnadirMaquinaria = By.cssSelector("[ng-click*='#modalMaquinaria']");
	private By btnAnadirMaquinariaModalWindow = By.xpath(".//*[text() ='Añadir' and @ng-click='newMaquinaria()']");
	private By btnAnadirPlacaSolarModalWindow = By.cssSelector("#modalInstalaciones > div > div > div.modal-body > div > div:nth-child(3) > div > button");
	private By cmbTipoMaquinaria = By.xpath(".//*[@ng-model='item.data.descripcion.data.codigo']");

	private By txtValor = By.name("valor");
	private By btnGuardarMaquinariaModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveMaquinarias()']");
	private By btnAsegurarAccidentesPantallaPrincipal = By.xpath(".//*[contains(@ng-click,'#modalAsegurarAccidentes') and text()='Asegurar accidentes']");
	private By btnAsegurarAccidentesModalWindow = By.xpath(".//*[@ng-click='saveAsegurados()' and text()='Asegurar accidentes']");
	private By btnAnadirAsegurado = By.xpath(".//*[text() = 'Añadir asegurado']");

	private By cmbTipoDocumento = By.name("tipoDocumento");
	private By txtNumeroDocumento = By.cssSelector("#numeroDocumento_0");
	private By txtEmpleadoNombre = By.cssSelector("#nombre_0");
	private By txtEmpleadoApellido1 = By.cssSelector("#apellido1_0");
	private By txtEmpleadoApellido2 = By.cssSelector("#apellido2_0");
	private By txtEmpleadoFechaNacimiento = By.cssSelector("#fechaNacimiento_0");
	private By cmbEmpleadoProfesion = By.cssSelector("#profesion_0");
	private By txtEmpleadoProfesionDescripcion = By.cssSelector("#profesionRelacion_0");
	private By txtEmpleadoCapital = By.cssSelector("#capital_0");
	private By txtEmpleadoBeneficiario = By.cssSelector("#beneficiario_0");
	private By txtEmpleadoBeneficiarioDescripcion = By.cssSelector("#beneficiarioRelacion_0");

	private By btnAnadirPlacaSolar = By.xpath(".//*[text()='Añadir placa solar']");

	private By txtInstalacionFotovoltaicaDescripcion = By.name("descripcion");
	private By txtInstalcionFotovoltaicaValor = By.name("valor");

	private By btnGuardarInstalacionSolarModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveInstalaciones()']");
	private By btnModalidadBasic = By.xpath(".//*[text()='Basic']");
	private By btnModalidadPlus = By.xpath(".//*[text()='Plus']");
	private By drpDwnRespCivil = By.cssSelector("select[name='capital']");

	private By lblPrecioBasic = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");
	private By lblPrecioComplet = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");
	private By lblPrecioPlus = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");

	private By cmbFranquiciaVoluntaria = By.xpath(".//*[text()='Franquicia voluntaria']/../select");
	private By btnAddTipoDescuento = By.xpath(".//*[text()='Añadir tipo de descuento']");
	private By txtPorcentajeDescuento = By.name("porcentaje");
	private By rdnDescuento = By.xpath(".//*[text()='Descuento']/../input");
	private By cmbTipoDescuento = By.cssSelector("#tipoDescuento");
	private By btnGuadarDescuentoModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveDescuento(formRecargoDescuento)']");
	private By lnkMostrarDescuento = By.xpath(".//*[text()='Tipo de descuento']");
	private By lblPorcentajeDescuentoPantallaPrincipal = By.xpath(".//*[@ng-bind-html='descuento.data.getTextDescuentoRecargo() | encode' and contains(@class,'ng-binding')]");
	private By msgAutorizarDescuento = By.cssSelector("#modalErrores > div > div > div.modal-body > div > div > p");
	private By btnAceptarAutorizarDescuento = By.cssSelector("#modalErrores > div > div > div.modal-footer > button");
	private By rdnRecargo = By.xpath(".//*[text()='Recargo']/../input");
	private By roturaMquinariaChckBx = By.cssSelector("tbody.ng-scope:nth-child(14) [ng-if='pm.isEspecialGroup(item)']");
	private By procesando = By.cssSelector("#procesando");
	// endregion

	public PrecioPorModalidadPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public PrecioPorModalidadPage waitProcesando() throws Exception {
		
		System.out.println("Espero a ver procesando...");
		webDriver.waitWithDriver(7000);
		
		while(this.webDriver.isPresent(procesando)) {
			System.out.println("Lo veo");
			webDriver.waitWithDriver(1500);
		}
		
		System.out.println("No veo procesando...");
		
		return this;
	}
	
	public PrecioPorModalidadPage ExecuteActionsInPrecioPorModalidadPage() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		seleccionarModalidad();
		completarCoberturaPorMaquinaria();
		completarCoberturasEmpleados();
		completarCoberturasEnergiaSolar();
		completarFranquiciaVoluntaria();
		ActionSteps.waitForIt(webDriver);
		completarOQuitarDescuentoRecargo();
		clickOnContinuar();

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage clickOnContinuar() {
		debugBegin();
		webDriver.clickInFrame(btnContinuar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage clickOnCancelar() {
		debugBegin();
		webDriver.click(cuerpoFrame);
		webDriver.scrollToBottom();
		webDriver.clickInFrame(btnCancelar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public List<CoberturasAdicionalesHelper> getCoberturasOpcionales() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		// webDriver.waitForPageLoadWithAngular();

		List<CoberturasAdicionalesHelper> coberturasAdicionalesTemp = new ArrayList<>();
		webDriver.getElements(rowWithCoberturaAdicional).forEach(p -> {
			WebElement element = p.findElement(By.xpath(xPathFilterClausulaCheckbox));

			if(element.isSelected()) {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(true, p.findElement(By.xpath(xPathFilterClausulaText)).getText(),
					p.findElement(By.xpath(xPathFilterClausulaCheckbox))));
			} else {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(false, p.findElement(By.xpath(xPathFilterClausulaText)).getText(),
					p.findElement(By.xpath(xPathFilterClausulaCheckbox))));
			}
		});

		webDriver.exitFrame();

		debugEnd();

		return coberturasAdicionalesTemp;
	}

	public PrecioPorModalidadPage completarCoberturaPorMaquinaria() {
		debugBegin();

		debugInfo("Cobertura Maquina Incluida: " + getConfigVar(Constants.COBERTURA_MAQUINA_INCLUIDA));
		String completarCoberturaMaquinaria = getConfigVar(Constants.COBERTURA_MAQUINA_INCLUIDA);

		if(completarCoberturaMaquinaria.equals(Constants.CoberturaOpcionalncluida)) {
			getPreciosBefore();
			coberturasAdicionales = getCoberturasOpcionales();
			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaRoturaMaquinariaDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(checkbox, cuerpoFrame);
				webDriver.clickInFrame(btnAnadirMaquinaria, cuerpoFrame);
				webDriver.clickInFrame(btnAnadirMaquinariaModalWindow, cuerpoFrame);
				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoMaquinaria, cuerpoFrame, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR));
				webDriver.appendTextInFrame(txtValor, cuerpoFrame, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR));
				webDriver.clickInFrame(btnGuardarMaquinariaModalWindow, cuerpoFrame);
				getPreciosAfter();
				compareValues(Constants.NotEqual, Constants.AfterMaquinaria);
			}
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarCoberturasEmpleados() {
		debugBegin();

		String coberturaEmpleados = getConfigVar(Constants.COBERTURA_ACCIDENTES_EMPLEADOS_INCLUIDA);
		debugInfo("Cobertura Accidentes Personales Empleados Incluida: " + Constants.COBERTURA_ACCIDENTES_EMPLEADOS_INCLUIDA);

		if(coberturaEmpleados.equals(Constants.CoberturaOpcionalncluida)) {
			getPreciosBefore();
			coberturasAdicionales = getCoberturasOpcionales();

			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaAccidentesPersonalesEmpleados)).collect(Collectors.toList())
				.get(0).getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(btnAsegurarAccidentesPantallaPrincipal, cuerpoFrame);
				webDriver.clickInFrame(btnAnadirAsegurado, cuerpoFrame);

				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDocumento, cuerpoFrame, Constants.NIF);
				webDriver.appendTextInFrame(txtNumeroDocumento, cuerpoFrame, DniGeneratorHelper.generateNif());
				webDriver.appendTextInFrame(txtEmpleadoNombre, cuerpoFrame, getScenarioVar(Constants.NOMBRE_EMPLEADO));
				webDriver.appendTextInFrame(txtEmpleadoApellido1, cuerpoFrame, getScenarioVar(Constants.PRIMER_APELLIDO_EMPLEADO));
				webDriver.appendTextInFrame(txtEmpleadoApellido2, cuerpoFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_EMPLEADO));
				webDriver.clickElementFromDropDownByTextInFrame(cmbEmpleadoProfesion, cuerpoFrame, getScenarioVar(Constants.PROFESION_EMPLEADO));
				webDriver.appendTextInFrame(txtEmpleadoProfesionDescripcion, cuerpoFrame, getScenarioVar(Constants.DESCRIPCION_PROFESION_EMPLEADO));

				webDriver.appendTextInFrame(txtEmpleadoCapital, cuerpoFrame, getScenarioVar(Constants.CAPITAL_EMPLEADO));
				webDriver.appendTextInFrame(txtEmpleadoFechaNacimiento, cuerpoFrame, getScenarioVar(Constants.FECHA_NACIMIENTO_EMPLEADO));
				webDriver.clickElementFromDropDownByTextInFrame(txtEmpleadoBeneficiario, cuerpoFrame, getScenarioVar(Constants.BENEFICIARIO_EMPLEADO));
				webDriver.appendTextInFrame(txtEmpleadoBeneficiarioDescripcion, cuerpoFrame, getScenarioVar(Constants.DESCRIPCION_BENEFICIARIO_EMPLEADO));
				webDriver.clickInFrame(btnAsegurarAccidentesModalWindow, cuerpoFrame);
				getPreciosAfter();
				compareValues(Constants.NotEqual, Constants.AfterEmpleados);
			}
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarCoberturasEnergiaSolar() {
		debugBegin();
		String coberturasolar = getConfigVar(Constants.COBERTURA_ENERGIA_SOLAR_INCLUIDA);

		debugInfo("Cobertura Fotovoltaicas Incluida: " + coberturasolar);

		if(coberturasolar.equals(Constants.CoberturaOpcionalncluida)) {
			getPreciosBefore();
			coberturasAdicionales = getCoberturasOpcionales();

			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaEnergiaSolarDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(btnAnadirPlacaSolar, cuerpoFrame);
				webDriver.clickInFrame(btnAnadirPlacaSolarModalWindow, cuerpoFrame);

				webDriver.appendTextInFrame(txtInstalacionFotovoltaicaDescripcion, cuerpoFrame, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_TIPO));
				webDriver.appendTextInFrame(txtInstalcionFotovoltaicaValor, cuerpoFrame, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_VALOR));
				webDriver.clickInFrame(btnGuardarInstalacionSolarModalWindow, cuerpoFrame);

				getPreciosAfter();
				compareValues(Constants.NotEqual, Constants.AfterEnergiaSolar);
			}
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage seleccionarModalidad() {
		debugBegin();

		String modalidad = getScenarioVar(Constants.MODALIDAD);
		debugInfo("Modalidad: " + modalidad);

		switch(modalidad) {
			case Constants.ModalidadBasic:
				getPreciosBefore();
				webDriver.clickInFrame(btnModalidadBasic, cuerpoFrame);
				getPreciosAfter();
				compareValues(Constants.NotEqual, Constants.AfterModalidadChangeToBasic);
				break;
			case Constants.ModalidadPlus:
				getPreciosBefore();
				webDriver.clickInFrame(btnModalidadPlus, cuerpoFrame);
				getPreciosAfter();
				compareValues(Constants.NotEqual, Constants.AfterModalidadChangeToPlus);
				break;
			default:
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarOQuitarDescuentoRecargo() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);
		ActionSteps.waitForIt(webDriver, lblPorcentajeDescuentoPantallaPrincipal);

		webDriver.clickInFrame(lnkMostrarDescuento, cuerpoFrame);
		String descuentoValue = webDriver.getTextInFrame(lblPorcentajeDescuentoPantallaPrincipal, cuerpoFrame);

		if(Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))
			|| Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))
			|| !descuentoValue.equals(Constants.CantidadDescuentoNoEspecificado)) {
			getPreciosBefore();
			String errorMessage = null;

			webDriver.clickInFrame(btnAddTipoDescuento, cuerpoFrame);

			if(Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))) {
				webDriver.appendTextInFrame(txtPorcentajeDescuento, cuerpoFrame, Constants.PorcentajeDescuentoRecargo);
				webDriver.clickInFrame(rdnDescuento, cuerpoFrame);
				webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDescuento, cuerpoFrame, Constants.TipoDescuento);
				errorMessage = Constants.AfterAddingDiscount;
			} else if(Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))) {
				webDriver.clickInFrame(rdnRecargo, cuerpoFrame);
				webDriver.appendTextInFrame(txtPorcentajeDescuento, cuerpoFrame, Constants.PorcentajeDescuentoRecargo);
				errorMessage = Constants.AfterAddingAdditionalCharge;
			} else if(!descuentoValue.equals(Constants.CantidadDescuentoNoEspecificado)
				&& !Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))
				&& !Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))) {
				// webDriver.click(btnAddTipoDescuento);
				webDriver.appendTextInFrame(txtPorcentajeDescuento, cuerpoFrame, "");
				webDriver.tabulateElementInFrame(txtPorcentajeDescuento, cuerpoFrame);
			}

			webDriver.clickInFrame(btnGuadarDescuentoModalWindow, cuerpoFrame);
			getPreciosAfter();
			compareValues(Constants.NotEqual, errorMessage);
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarFranquiciaVoluntaria() {
		debugBegin();
		String franquiciaVoluntaria = getConfigVar("franquicia_voluntaria");
		debugInfo("Franquicia voluntaria: " + franquiciaVoluntaria);

		if(franquiciaVoluntaria != null) {
			getPreciosBefore();
			webDriver.clickElementFromDropDownByTextInFrame(cmbFranquiciaVoluntaria, cuerpoFrame, franquiciaVoluntaria);
			getPreciosAfter();
			compareValues(Constants.NotEqual, Constants.AfterAddingFranquiciaVoluntaria);
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage getPreciosBefore() {
		debugBegin();

		precioBasicBefore = webDriver.getTextInFrame(lblPrecioBasic, cuerpoFrame);
		precioCompletoBefore = webDriver.getTextInFrame(lblPrecioComplet, cuerpoFrame);
		precioPlusBefore = webDriver.getTextInFrame(lblPrecioPlus, cuerpoFrame);
		debugInfo("Precio basic before: " + precioBasicBefore);
		debugInfo("Precio complet before: " + precioCompletoBefore);
		debugInfo("Precio plus before: " + precioPlusBefore);

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage getPreciosAfter() {
		debugBegin();

		precioBasicAfter = webDriver.getTextInFrame(lblPrecioBasic, cuerpoFrame);
		precioCompletoAfter = webDriver.getTextInFrame(lblPrecioComplet, cuerpoFrame);
		precioPlusAfter = webDriver.getTextInFrame(lblPrecioPlus, cuerpoFrame);
		debugInfo("Precio basic after: " + precioBasicAfter);
		debugInfo("Precio complet after: " + precioCompletoAfter);
		debugInfo("Precio plus after: " + precioPlusAfter);

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage compareValues(String comparisonType, String modification) {
		debugBegin();
		debugInfo("ComparisonType: " + comparisonType + ", Modalidad: " + getScenarioVar(Constants.MODALIDAD));

		switch(comparisonType) {
			case Constants.NotEqual:
				switch(getScenarioVar(Constants.MODALIDAD)) {
					case Constants.ModalidadPlus:
						if(precioPlusBefore.equals(precioPlusAfter)) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;
					case Constants.ModalidadBasic:
						if(precioBasicBefore.equals(precioBasicAfter)) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;

					case Constants.ModalidadCompleta:
						if(precioCompletoBefore.equals(precioCompletoAfter)) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;
					default:
				}
				break;
			case Constants.Equal:
				if(!precioBasicBefore.equals(precioBasicAfter) ||
					!precioCompletoBefore.equals(precioBasicAfter)
					|| !precioPlusBefore.equals(precioPlusAfter)) {
					setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
					setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de los capitales ha variado en la pantalla de precio %s", modification));
				}

				break;
			default:
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage modificarRC(String value) {
		webDriver.clickElementFromDropDownByTextInFrame(drpDwnRespCivil, cuerpoFrame, value);

		return this;
	}

	public PrecioPorModalidadPage agregarDescuento(String descuento) {
		debugBegin();

		webDriver.clickInFrame(btnAddTipoDescuento, cuerpoFrame);

		webDriver.appendTextInFrame(txtPorcentajeDescuento, cuerpoFrame, descuento);
		webDriver.clickInFrame(rdnDescuento, cuerpoFrame);
		webDriver.clickElementFromDropDownByTextInFrame(cmbTipoDescuento, cuerpoFrame, Constants.TipoDescuento);

		webDriver.clickInFrame(btnGuadarDescuentoModalWindow, cuerpoFrame);

		// Pulsar Aceptar en el aviso sobre la autorizacion de descuento que sale para ciertos mediadores
		if(webDriver.isPresentInFrame(msgAutorizarDescuento, cuerpoFrame)) {
			webDriver.clickInFrame(btnAceptarAutorizarDescuento, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public String getPrecioTotal() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(lblPrecioComplet, cuerpoFrame)) {
			value = webDriver.getTextInFrame(lblPrecioComplet, cuerpoFrame);
		}

		debugEnd();
		return value;
	}

	public String getPrecioBasic() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(lblPrecioBasic, cuerpoFrame)) {
			value = webDriver.getTextInFrame(lblPrecioBasic, cuerpoFrame);
		}

		debugEnd();
		return value;
	}

	public String getPrecioPlus() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(lblPrecioPlus, cuerpoFrame)) {
			value = webDriver.getTextInFrame(lblPrecioPlus, cuerpoFrame);
		}

		debugEnd();

		return value;
	}

	public String getNumSimulacion() {
		debugBegin();

		String projectNumberText = webDriver.getTextInFrame(txtCodigoProjecto, cuerpoFrame);
		String projectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();

		webDriver.clickInFrame(btnAceptarInDialog, cuerpoFrame);

		debugEnd();

		return projectCode;
	}

	public PrecioPorModalidadPage clickOnGuardar() {
		debugBegin();

		webDriver.scrollToBottom();
		webDriver.clickInFrame(btnGuardar, cuerpoFrame);

		debugEnd();

		return this;
	}
	// endregion

}