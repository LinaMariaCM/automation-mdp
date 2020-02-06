package com.amaris.project.pages.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amaris.automation.model.helpers.DocumentGeneratorHelper;
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

	// region WebElements
	private By clausulaTxt = By.xpath(".//td[3]");
	private By clausulaCheckbox = By.xpath(".//td[input[@type='checkbox']]/input");

	private By cuerpoFrame = By.name("cuerpo");

	private By continuarBtn = By.cssSelector("button[ng-bind-html*='continuar']");
	private By guardarBtn = By.xpath(".//*[text()='Guardar']");
	private By cancelarBtn = By.xpath(".//*[contains(text(),'Cancelar')]");
	private By aceptarInDialogBtn = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");
	private By codigoProjectoTxt = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");

	private By rowWithCoberturaAdicional = By.xpath(".//*[input]/input");

	private By anyadirMaquinariaBtn = By.cssSelector("[ng-click*='#modalMaquinaria']");
	private By anyadirMaquinariaModalWindowBtn = By.xpath(".//*[text() ='Añadir' and @ng-click='newMaquinaria()']");
	private By anyadirPlacaSolarModalWindowBtn = By.cssSelector("#modalInstalaciones > div > div > div.modal-body > div > div:nth-child(3) > div > button");
	private By tipoMaquinariaDrpDwn = By.xpath(".//*[@ng-model='item.data.descripcion.data.codigo']");

	private By valorInput = By.name("valor");
	private By guardarMaquinariaModalWindowBtn = By.xpath(".//*[text()='Guardar' and @ng-click='saveMaquinarias()']");
	private By asegurarAccidentesPantallaPrincipalBtn = By.xpath(".//*[contains(@ng-click,'#modalAsegurarAccidentes') and text()='Asegurar accidentes']");
	private By asegurarAccidentesModalWindowBtn = By.xpath(".//*[@ng-click='saveAsegurados()' and text()='Asegurar accidentes']");
	private By anyadirAseguradoBtn = By.xpath(".//*[text() = 'Añadir asegurado']");

	private By tipoDocumentoDrpDwn = By.name("tipoDocumento");
	private By numeroDocumentoInput = By.cssSelector("#numeroDocumento_0");
	private By empleadoNombreInput = By.cssSelector("#nombre_0");
	private By empleadoApellido1Input = By.cssSelector("#apellido1_0");
	private By empleadoApellido2Input = By.cssSelector("#apellido2_0");
	private By empleadoFechaNacimientoInput = By.cssSelector("#fechaNacimiento_0");
	private By empleadoProfesionDrpDwn = By.cssSelector("#profesion_0");
	private By empleadoProfesionDescripcionInput = By.cssSelector("#profesionRelacion_0");
	private By empleadoCapitalInput = By.cssSelector("#capital_0");
	private By empleadoBeneficiarioDrpDwn = By.cssSelector("#beneficiario_0");
	private By empleadoBeneficiarioDescripcionInput = By.cssSelector("#beneficiarioRelacion_0");

	private By anyadirPlacaSolarBtn = By.xpath(".//*[text()='Añadir placa solar']");

	private By instalacionFotovoltaicaDescripcionInput = By.name("descripcion");
	private By instalcionFotovoltaicaValorInput = By.name("valor");

	private By guardarInstalacionSolarModalWindowBtn = By.xpath(".//*[text()='Guardar' and @ng-click='saveInstalaciones()']");
	private By modalidadBasicBtn = By.xpath(".//*[text()='Basic']");
	private By modalidadPlusBtn = By.xpath(".//*[text()='Plus']");
	private By respCivilDrpDwn = By.cssSelector("select[name='capital']");

	// TODO Revisar selectores, son todos el mismo
	private By precioBasicoTxt = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");
	private By precioCompletoTxt = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");
	private By precioPlusTxt = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");

	private By franquiciaVoluntariaDrpDwn = By.xpath(".//*[text()='Franquicia voluntaria']/../select");
	private By addTipoDescuentoBtn = By.xpath(".//*[text()='Añadir tipo de descuento']");
	private By porcentajeDescuentoInput = By.name("porcentaje");
	private By descuentoBtn = By.xpath(".//*[text()='Descuento']/../input");
	private By tipoDescuentoDrpDwn = By.cssSelector("#tipoDescuento");
	private By guadarDescuentoModalWindowBtn = By.xpath(".//*[text()='Guardar' and @ng-click='saveDescuento(formRecargoDescuento)']");
	private By mostrarDescuentoBtn = By.xpath(".//*[text()='Tipo de descuento']");
	private By porcentajeDescuentoPantallaPrincipalTxt = By.xpath(".//*[@ng-bind-html='descuento.data.getTextDescuentoRecargo() | encode' and contains(@class,'ng-binding')]");
	private By msgAutorizarDescuentoTxt = By.cssSelector("#modalErrores > div > div > div.modal-body > div > div > p");
	private By aceptarAutorizarDescuentoBtn = By.cssSelector("#modalErrores > div > div > div.modal-footer > button");
	private By recargoBtn = By.xpath(".//*[text()='Recargo']/../input");
	private By procesandoModal = By.cssSelector("#procesando");
	// endregion

	public PrecioPorModalidadPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public PrecioPorModalidadPage waitProcesando() {
		debugBegin();

		debugInfo("Se espera al mensaje \"procesando\"");
		webDriver.waitWithDriver(7000);

		while(this.webDriver.isPresent(procesandoModal)) {
			debugInfo("Se muestra mensaje \"procesando\"");
			webDriver.waitWithDriver(1500);
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage clickContinuar() {
		debugBegin();
		webDriver.clickInFrame(continuarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage clickCancelar() {
		debugBegin();
		webDriver.scrollToBottomInFrame(cuerpoFrame);
		webDriver.clickInFrame(cancelarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public List<CoberturasAdicionalesHelper> getCoberturasOpcionales() {
		debugBegin();

		List<CoberturasAdicionalesHelper> coberturasAdicionalesTemp = new ArrayList<>();
		webDriver.getElementsInFrame(rowWithCoberturaAdicional, cuerpoFrame).forEach(p -> {
			if(webDriver.isSelected(p.findElement(clausulaCheckbox))) {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(true,
					webDriver.getText(p.findElement(clausulaTxt)),
					p.findElement(clausulaCheckbox)));
			} else {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(false,
					webDriver.getText(p.findElement(clausulaTxt)),
					p.findElement(clausulaCheckbox)));
			}
		});

		debugEnd();

		return coberturasAdicionalesTemp;
	}

	public PrecioPorModalidadPage completarCoberturaPorMaquinaria() {
		debugBegin();

		debugInfo("Cobertura Maquina Incluida: " + getConfigVar(Constants.COBERTURA_MAQUINA_INCLUIDA));
		String completarCoberturaMaquinaria = getConfigVar(Constants.COBERTURA_MAQUINA_INCLUIDA);

		if(completarCoberturaMaquinaria.equals(Constants.CoberturaOpcionalncluida)) {
			getPreciosBefore();
			List<CoberturasAdicionalesHelper> coberturasAdicionales = getCoberturasOpcionales();
			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaRoturaMaquinariaDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(checkbox, cuerpoFrame);
				webDriver.clickInFrame(anyadirMaquinariaBtn, cuerpoFrame);
				webDriver.clickInFrame(anyadirMaquinariaModalWindowBtn, cuerpoFrame);
				webDriver.clickElementFromDropDownByTextInFrame(tipoMaquinariaDrpDwn, cuerpoFrame, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR));
				webDriver.appendTextInFrame(valorInput, cuerpoFrame, getScenarioVar(Constants.COBERTURA_MAQUINA_VALOR));
				webDriver.clickInFrame(guardarMaquinariaModalWindowBtn, cuerpoFrame);

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
			List<CoberturasAdicionalesHelper> coberturasAdicionales = getCoberturasOpcionales();

			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaAccidentesPersonalesEmpleados)).collect(Collectors.toList())
				.get(0).getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(asegurarAccidentesPantallaPrincipalBtn, cuerpoFrame);
				webDriver.clickInFrame(anyadirAseguradoBtn, cuerpoFrame);

				webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);
				webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, DocumentGeneratorHelper.generateNif());
				webDriver.appendTextInFrame(empleadoNombreInput, cuerpoFrame, getScenarioVar(Constants.NOMBRE_EMPLEADO));
				webDriver.appendTextInFrame(empleadoApellido1Input, cuerpoFrame, getScenarioVar(Constants.PRIMER_APELLIDO_EMPLEADO));
				webDriver.appendTextInFrame(empleadoApellido2Input, cuerpoFrame, getScenarioVar(Constants.SEGUNDO_APELLIDO_EMPLEADO));
				webDriver.clickElementFromDropDownByTextInFrame(empleadoProfesionDrpDwn, cuerpoFrame, getScenarioVar(Constants.PROFESION_EMPLEADO));
				webDriver.appendTextInFrame(empleadoProfesionDescripcionInput, cuerpoFrame, getScenarioVar(Constants.DESCRIPCION_PROFESION_EMPLEADO));

				webDriver.appendTextInFrame(empleadoCapitalInput, cuerpoFrame, getScenarioVar(Constants.CAPITAL_EMPLEADO));
				webDriver.appendTextInFrame(empleadoFechaNacimientoInput, cuerpoFrame, getScenarioVar(Constants.FECHA_NACIMIENTO_EMPLEADO));
				webDriver.clickElementFromDropDownByTextInFrame(empleadoBeneficiarioDrpDwn, cuerpoFrame, getScenarioVar(Constants.BENEFICIARIO_EMPLEADO));
				webDriver.appendTextInFrame(empleadoBeneficiarioDescripcionInput, cuerpoFrame, getScenarioVar(Constants.DESCRIPCION_BENEFICIARIO_EMPLEADO));
				webDriver.clickInFrame(asegurarAccidentesModalWindowBtn, cuerpoFrame);

				getPreciosAfter();

				compareValues(Constants.NotEqual, Constants.AfterEmpleados);
			}
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarCoberturasEnergiaSolar() {
		debugBegin();

		String coberturaSolar = getConfigVar(Constants.COBERTURA_ENERGIA_SOLAR_INCLUIDA);

		debugInfo("Cobertura Fotovoltaicas Incluida: " + coberturaSolar);
		if(coberturaSolar.equals(Constants.CoberturaOpcionalncluida)) {
			getPreciosBefore();

			List<CoberturasAdicionalesHelper> coberturasAdicionales = getCoberturasOpcionales();

			WebElement checkbox = coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(Constants.CoberturaEnergiaSolarDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();

			if(!checkbox.isSelected()) {
				webDriver.clickInFrame(anyadirPlacaSolarBtn, cuerpoFrame);
				webDriver.clickInFrame(anyadirPlacaSolarModalWindowBtn, cuerpoFrame);

				webDriver.appendTextInFrame(instalacionFotovoltaicaDescripcionInput, cuerpoFrame, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_TIPO));
				webDriver.appendTextInFrame(instalcionFotovoltaicaValorInput, cuerpoFrame, getScenarioVar(Constants.COBERTURA_ENERGIA_SOLAR_VALOR));
				webDriver.clickInFrame(guardarInstalacionSolarModalWindowBtn, cuerpoFrame);

				getPreciosAfter();

				compareValues(Constants.NotEqual, Constants.AfterEnergiaSolar);
			}
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage seleccionarModalidad() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);

		String modalidad = getScenarioVar(Constants.MODALIDAD);

		debugInfo("Modalidad: " + modalidad);
		switch(modalidad) {
			case Constants.ModalidadBasic:
				getPreciosBefore();
				webDriver.clickInFrame(modalidadBasicBtn, cuerpoFrame);
				getPreciosAfter();

				compareValues(Constants.NotEqual, Constants.AfterModalidadChangeToBasic);

				break;
			case Constants.ModalidadPlus:
				getPreciosBefore();
				webDriver.clickInFrame(modalidadPlusBtn, cuerpoFrame);
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
		ActionSteps.waitForIt(webDriver, porcentajeDescuentoPantallaPrincipalTxt);

		webDriver.clickInFrame(mostrarDescuentoBtn, cuerpoFrame);
		String descuentoValue = webDriver.getTextInFrame(porcentajeDescuentoPantallaPrincipalTxt, cuerpoFrame);

		if(Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))
			|| Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))
			|| !descuentoValue.equals(Constants.CantidadDescuentoNoEspecificado)) {
			getPreciosBefore();
			String errorMessage = null;

			webDriver.clickInFrame(addTipoDescuentoBtn, cuerpoFrame);

			if(Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))) {
				webDriver.appendTextInFrame(porcentajeDescuentoInput, cuerpoFrame, Constants.PorcentajeDescuentoRecargo);
				webDriver.clickInFrame(descuentoBtn, cuerpoFrame);
				webDriver.clickElementFromDropDownByTextInFrame(tipoDescuentoDrpDwn, cuerpoFrame, Constants.TipoDescuento);
				errorMessage = Constants.AfterAddingDiscount;
			} else if(Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))) {
				webDriver.clickInFrame(recargoBtn, cuerpoFrame);
				webDriver.appendTextInFrame(porcentajeDescuentoInput, cuerpoFrame, Constants.PorcentajeDescuentoRecargo);
				errorMessage = Constants.AfterAddingAdditionalCharge;
			} else if(!descuentoValue.equals(Constants.CantidadDescuentoNoEspecificado)
				&& !Boolean.parseBoolean(getScenarioVar(Constants.DESCUENTO_HABILITADO))
				&& !Boolean.parseBoolean(getScenarioVar(Constants.RECARGO))) {
				webDriver.appendTextInFrame(porcentajeDescuentoInput, cuerpoFrame, "");
				webDriver.tabulateElementInFrame(porcentajeDescuentoInput, cuerpoFrame);
			}

			webDriver.clickInFrame(guadarDescuentoModalWindowBtn, cuerpoFrame);

			getPreciosAfter();

			compareValues(Constants.NotEqual, errorMessage);
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage completarFranquiciaVoluntaria() {
		debugBegin();

		ActionSteps.waitForIt(webDriver);

		String franquiciaVoluntaria = getConfigVar("franquicia_voluntaria");
		debugInfo("Franquicia voluntaria: " + franquiciaVoluntaria);

		if(franquiciaVoluntaria != null) {
			getPreciosBefore();
			webDriver.clickElementFromDropDownByTextInFrame(franquiciaVoluntariaDrpDwn, cuerpoFrame, franquiciaVoluntaria);
			getPreciosAfter();

			compareValues(Constants.NotEqual, Constants.AfterAddingFranquiciaVoluntaria);
		}

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage getPreciosBefore() {
		debugBegin();

		String precioBasicBefore = webDriver.getTextInFrame(precioBasicoTxt, cuerpoFrame);
		String precioCompletoBefore = webDriver.getTextInFrame(precioCompletoTxt, cuerpoFrame);
		String precioPlusBefore = webDriver.getTextInFrame(precioPlusTxt, cuerpoFrame);

		debugInfo("Precio basic before: " + precioBasicBefore);
		debugInfo("Precio complet before: " + precioCompletoBefore);
		debugInfo("Precio plus before: " + precioPlusBefore);

		setTestVar(Constants.PRECIO_BASICO_BEFORE, precioBasicBefore);
		setTestVar(Constants.PRECIO_COMPLETO_BEFORE, precioCompletoBefore);
		setTestVar(Constants.PRECIO_PLUS_BEFORE, precioPlusBefore);

		debugEnd();

		return this;
	}

	public PrecioPorModalidadPage getPreciosAfter() {
		debugBegin();

		String precioBasicoAfter = webDriver.getTextInFrame(precioBasicoTxt, cuerpoFrame);
		String precioCompletoAfter = webDriver.getTextInFrame(precioCompletoTxt, cuerpoFrame);
		String precioPlusAfter = webDriver.getTextInFrame(precioPlusTxt, cuerpoFrame);

		debugInfo("Precio basic after: " + precioBasicoAfter);
		debugInfo("Precio complet after: " + precioCompletoAfter);
		debugInfo("Precio plus after: " + precioPlusAfter);

		setTestVar(Constants.PRECIO_BASICO_AFTER, precioBasicoAfter);
		setTestVar(Constants.PRECIO_COMPLETO_AFTER, precioCompletoAfter);
		setTestVar(Constants.PRECIO_PLUS_AFTER, precioPlusAfter);

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
						if(getTestVar(Constants.PRECIO_PLUS_BEFORE).equals(getTestVar(Constants.PRECIO_PLUS_AFTER))) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;
					case Constants.ModalidadBasic:
						if(getTestVar(Constants.PRECIO_BASICO_BEFORE).equals(getTestVar(Constants.PRECIO_BASICO_AFTER))) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;

					case Constants.ModalidadCompleta:
						if(getTestVar(Constants.PRECIO_COMPLETO_BEFORE).equals(getTestVar(Constants.PRECIO_COMPLETO_AFTER))) {
							setTestVar(Constants.CAPITALES_MODIFIED_ERROR, "true");
							setTestVar(Constants.CAPITALES_MODIFIED_MESSAGE, String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", modification));
						}
						break;
					default:
				}

				break;
			case Constants.Equal:
				if(!getTestVar(Constants.PRECIO_BASICO_BEFORE).equals(getTestVar(Constants.PRECIO_BASICO_AFTER)) ||
					!getTestVar(Constants.PRECIO_COMPLETO_BEFORE).equals(getTestVar(Constants.PRECIO_COMPLETO_AFTER))
					|| !getTestVar(Constants.PRECIO_PLUS_BEFORE).equals(getTestVar(Constants.PRECIO_PLUS_AFTER))) {
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
		webDriver.clickElementFromDropDownByTextInFrame(respCivilDrpDwn, cuerpoFrame, value);

		return this;
	}

	public PrecioPorModalidadPage agregarDescuento(String descuento) {
		debugBegin();

		webDriver.clickInFrame(addTipoDescuentoBtn, cuerpoFrame);

		webDriver.appendTextInFrame(porcentajeDescuentoInput, cuerpoFrame, descuento);
		webDriver.clickInFrame(descuentoBtn, cuerpoFrame);
		webDriver.clickElementFromDropDownByTextInFrame(tipoDescuentoDrpDwn, cuerpoFrame, Constants.TipoDescuento);

		webDriver.clickInFrame(guadarDescuentoModalWindowBtn, cuerpoFrame);

		if(webDriver.isPresentInFrame(msgAutorizarDescuentoTxt, cuerpoFrame)) {
			webDriver.clickInFrame(aceptarAutorizarDescuentoBtn, cuerpoFrame);
		}

		debugEnd();

		return this;
	}

	public String getPrecioTotal() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(precioCompletoTxt, cuerpoFrame)) {
			value = webDriver.getTextInFrame(precioCompletoTxt, cuerpoFrame);
		}

		debugEnd();
		return value;
	}

	public String getPrecioBasic() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(precioBasicoTxt, cuerpoFrame)) {
			value = webDriver.getTextInFrame(precioBasicoTxt, cuerpoFrame);
		}

		debugEnd();
		return value;
	}

	public String getPrecioPlus() {
		debugBegin();
		String value = "";

		if(webDriver.isPresentInFrame(precioPlusTxt, cuerpoFrame)) {
			value = webDriver.getTextInFrame(precioPlusTxt, cuerpoFrame);
		}

		debugEnd();

		return value;
	}

	public String getNumeroSimulacion() {
		debugBegin();

		String projectCode = webDriver.getTextInFrame(codigoProjectoTxt, cuerpoFrame);
		projectCode = StringUtils.substringBetween(projectCode, "El proyecto", "se ha guardado.").trim();

		webDriver.clickInFrame(aceptarInDialogBtn, cuerpoFrame);

		debugEnd();

		return projectCode;
	}

	public PrecioPorModalidadPage clickGuardar() {
		debugBegin();

		webDriver.scrollToBottomInFrame(cuerpoFrame);
		webDriver.clickInFrame(guardarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}
	// endregion

}