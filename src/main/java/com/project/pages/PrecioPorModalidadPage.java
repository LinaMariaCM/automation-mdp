package com.project.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.helpers.DniGeneratorHelper;
import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.Helpers.CoberturasAdicionalesHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;
import com.project.utils.CoberturasAdicionalesHelper;

public class PrecioPorModalidadPage {
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	// private String cssFilterSelectedCheckboxes =
	// "input:checked[type=checkbox]";
	private String xPathFilterClausulaText = ".//td[3]";
	private String xPathFilterClausulaCheckbox = ".//td[input[@type='checkbox']]/input";

	private List<CoberturasAdicionalesHelper> coberturasAdicionales;
	private String PrecioCompletoBefore;
	private String PrecioCompletoAfter;
	private String PrecioBasicBefore;
	private String PrecioBasicAfter;
	private String PrecioPlusBefore;
	private String PrecioPlusAfter;

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(id = "topFrame")
	private By topFrame = By.cssSelector("#topFrame");

	// @FindBy(id = "hideFrame")
	private By hiddenFrame = By.cssSelector("#hideFrame");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuar = By.xpath(".//*[text()='Continuar']");

	// //@FindBy(xpath = ".//*[text()='Guardar']")
	// @FindBy(css = "button[ng-click='save(formPrecioModalidad)']")
	private By btnGuardar = By.xpath(".//*[text()='Guardar']");

	// @FindBy(xpath = ".//*[contains(text(),'Cancelar')]")
	private By btnCancelar = By.xpath(".//*[contains(text(),'Cancelar')]");

	// @FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and
	// contains(text(),'se ha
	// guardado.')]/../../../../div[@class='modal-footer']/button")
	private By btnAceptarInDialog = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button");

	// @FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and
	// contains(text(),'se ha guardado.')]")
	private By txtCodigoProjecto = By.xpath(".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]");

	// @FindBy(xpath = ".//tr[td[input[@type='checkbox']]]")
	// //@FindBy(xpath = ".//*[input]/input")
	private By btnWithCoberturaAdicional = By.xpath(".//tr[td[input[@type='checkbox']]]");

	private List<WebElement> rowWithCoberturaAdicional;

	// @FindBy(css = "input:checked[type=checkbox]")
	private List<WebElement> selectedCheckboxes;

	// @FindBy(xpath = ".//*[@class='pagination' and
	// ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");

	/*
	 * //@FindBy(xpath = ".//*[text() ='Añadir maquinaria']") private By
	 * btnAnadirMaquinaria;
	 */

	// @FindBy(css = "[ng-click*='#modalMaquinaria']")
	private By btnAnadirMaquinaria = By.cssSelector("[ng-click*='#modalMaquinaria']");

	// @FindBy(xpath = ".//*[text() ='Añadir' and @ng-click='newMaquinaria()']")
	private By btnAnadirMaquinariaModalWindow = By.xpath(".//*[text() ='Añadir' and @ng-click='newMaquinaria()']");

	// //@FindBy(xpath = ".//*[text() ='Añadir' and
	// @ng-click='newInstalacion()']")
	// @FindBy(css = "#modalInstalaciones > div > div > div.modal-body > div >
	// div:nth-child(3) > div > button")
	private By btnAnadirPlacaSolarModalWindow = By.cssSelector("#modalInstalaciones > div > div > div.modal-body > div > div:nth-child(3) > div > button");

	// @FindBy(xpath = ".//*[@ng-model='item.data.descripcion.data.codigo']")
	private By cmbTipoMaquinaria = By.xpath(".//*[@ng-model='item.data.descripcion.data.codigo']");

	// @FindBy(name = "valor")
	private By txtValor = By.className("valor");

	// @FindBy(xpath = ".//*[text()='Guardar' and
	// @ng-click='saveMaquinarias()']")
	private By btnGuardarMaquinariaModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveMaquinarias()']");

	// @FindBy(xpath = ".//*[contains(@ng-click,'#modalAsegurarAccidentes') and
	// text()='Asegurar accidentes']")
	private By btnAsegurarAccidentesPantallaPrincipal = By.xpath(".//*[contains(@ng-click,'#modalAsegurarAccidentes') and text()='Asegurar accidentes']");

	// @FindBy(xpath = ".//*[@ng-click='saveAsegurados()' and text()='Asegurar
	// accidentes']")
	private By btnAsegurarAccidentesModalWindow = By.xpath(".//*[@ng-click='saveAsegurados()' and text()='Asegurar accidentes']");

	// @FindBy(xpath = ".//*[text() = 'Añadir asegurado']")
	private By btnAnadirAsegurado = By.xpath(".//*[text() = 'Añadir asegurado']");

	// @FindBy(name = "tipoDocumento")
	private By cmbTipoDocumento = By.name("tipoDocumento");

	// @FindBy(id = "numeroDocumento_0")
	private By txtNumeroDocumento = By.cssSelector("#numeroDocumento_0");

	// @FindBy(id = "nombre_0")
	private By txtEmpleadoNombre = By.cssSelector("#nombre_0");

	// @FindBy(id = "apellido1_0")
	private By txtEmpleadoApellido1 = By.cssSelector("#apellido1_0");

	// @FindBy(id = "apellido2_0")
	private By txtEmpleadoApellido2 = By.cssSelector("#apellido2_0");

	// @FindBy(id = "fechaNacimiento_0")
	private By txtEmpleadoFechaNacimiento = By.cssSelector("#fechaNacimiento_0");

	// @FindBy(id = "profesion_0")
	private By cmbEmpleadoProfesion = By.cssSelector("#profesion_0");

	// @FindBy(id = "profesionRelacion_0")
	private By txtEmpleadoProfesionDescripcion = By.cssSelector("profesionRelacion_0");

	// @FindBy(id = "capital_0")
	private By txtEmpleadoCapital = By.cssSelector("#capital_0");

	// @FindBy(id = "beneficiario_0")
	private By txtEmpleadoBeneficiario = By.cssSelector("#beneficiario_0");

	// @FindBy(id = "beneficiarioRelacion_0")
	private By txtEmpleadoBeneficiarioDescripcion = By.cssSelector("#beneficiarioRelacion_0");

	// @FindBy(xpath = ".//*[text()='Añadir placa solar']")
	private By btnAnadirPlacaSolar = By.xpath(".//*[text()='Añadir placa solar']");

	// @FindBy(name = "descripcion")
	private By txtInstalacionFotovoltaicaDescripcion = By.name("descripcion");

	// @FindBy(name = "valor")
	private By txtInstalcionFotovoltaicaValor = By.name("valor");

	// @FindBy(xpath = ".//*[text()='Guardar' and
	// @ng-click='saveInstalaciones()']")
	private By btnGuardarInstalacionSolarModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveInstalaciones()']");

	// @FindBy(xpath = ".//*[text()='Basic']")
	private By btnModalidadBasic = By.xpath(".//*[text()='Basic']");

	// @FindBy(xpath = ".//*[text()='Plus']")
	private By btnModalidadPlus = By.xpath(".//*[text()='Plus']");

	// @FindBy(css = "select[name='capital']")
	private By drpDwnRespCivil = By.cssSelector("select[name='capital']");

	// //@FindBy(xpath =
	// ".//*[text()='Basic']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	// @FindBy(css =
	// "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html']
	// tr[class='med-table-tr ng-scope']:nth-child(1)
	// span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")
	private By lblPrecioBasic = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");

	// //@FindBy(xpath =
	// ".//*[text()='Complet']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	// @FindBy(css =
	// "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html']
	// tr[class='med-table-tr ng-scope']:nth-child(1)
	// span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")

	private By lblPrecioComplet = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");

	// //@FindBy(xpath =
	// ".//*[text()='Plus']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	// @FindBy(css =
	// "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html']
	// tr[class='med-table-tr ng-scope']:nth-child(1)
	// span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")
	private By lblPrecioPlus = By
		.cssSelector("div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']");

	// @FindBy(xpath = ".//*[text()='Franquicia voluntaria']/../select")
	private By cmbFranquiciaVoluntaria = By.xpath(".//*[text()='Franquicia voluntaria']/../select");

	// @FindBy(xpath = ".//*[text()='Añadir tipo de descuento']")
	private By btnAddTipoDescuento = By.xpath(".//*[text()='Añadir tipo de descuento']");

	// @FindBy(name = "porcentaje")
	private By txtPorcentajeDescuento = By.name("porcentaje");

	// @FindBy(xpath = ".//*[text()='Descuento']/../input")
	private By rdnDescuento = By.xpath(".//*[text()='Descuento']/../input");

	// @FindBy(id = "tipoDescuento")
	private By cmbTipoDescuento = By.cssSelector("#tipoDescuento");

	// @FindBy(xpath = ".//*[text()='Guardar' and
	// @ng-click='saveDescuento(formRecargoDescuento)']")
	private By btnGuadarDescuentoModalWindow = By.xpath(".//*[text()='Guardar' and @ng-click='saveDescuento(formRecargoDescuento)']");

	// @FindBy(xpath = ".//*[text()='Tipo de descuento']")
	private By lnkMostrarDescuento = By.xpath(".//*[text()='Tipo de descuento']");

	// @FindBy(xpath =
	// ".//*[@ng-bind-html='descuento.data.getTextDescuentoRecargo() | encode'
	// and contains(@class,'ng-binding')]")
	private By lblPorcentajeDescuentoPantallaPrincipal = By.xpath(".//*[@ng-bind-html='descuento.data.getTextDescuentoRecargo() | encode' and contains(@class,'ng-binding')]");

	// @FindBy(css = "#modalErrores > div > div > div.modal-body > div > div >
	// p")
	private By msgAutorizarDescuento = By.cssSelector("#modalErrores > div > div > div.modal-body > div > div > p");

	// @FindBy(css = "#modalErrores > div > div > div.modal-footer > button")
	private By btnAceptarAutorizarDescuento = By.cssSelector("#modalErrores > div > div > div.modal-footer > button");

	// @FindBy(xpath = ".//*[text()='Recargo']/../input")
	private By rdnRecargo = By.xpath(".//*[text()='Recargo']/../input");

	// @FindBy(css = "tbody.ng-scope:nth-child(14)
	// [ng-if='pm.isEspecialGroup(item)']")
	private By roturaMquinariaChckBx = By.cssSelector("tbody.ng-scope:nth-child(14) [ng-if='pm.isEspecialGroup(item)']");

	// endregion

	// public PrecioPorModalidadPage(BrowserContext browserContext)
	// {
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// this.coberturasAdicionales = null;
	// }

	public PrecioPorModalidadPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	// region methods
	public PrecioPorModalidadPage executeActionsInPrecioPorModalidadPage() throws InterruptedException, IOException {
		this.seleccionarModalidad();
		this.completarCoberturaPorMaquinaria();
		this.completarCoberturasEmpleados();
		this.completarCoberturasEnergiaSolar();
		this.completarFranquiciaVoluntaria();
		this.completarOQuitarDescuentoRecargo();
		this.clickOnContinuar();
		
		return this;
	}

	public PrecioPorModalidadPage clickOnContinuar() throws InterruptedException {
		logger.debug("BEGIN - ClickOnContinuar");
		// this.cuerpoFrame.click();
		// this.webDriver.scrollToBottom();
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
		
		return this;
	}

	public PrecioPorModalidadPage clickOnCancelar() throws InterruptedException {
		logger.debug("BEGIN - ClickOnCancelar");
		this.webDriver.click(this.cuerpoFrame);
		this.webDriver.scrollToBottom();
		this.webDriver.clickInFrame(this.btnCancelar, this.cuerpoFrame);
		logger.debug("END - ClickOnCancelar");
		
		return this;
	}

	public List<CoberturasAdicionalesHelper> getCoberturasOpcionales() {
		logger.debug("BEGIN - GetCoberturasOpcionales");
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.waitForPageLoadWithAngular();

		List<CoberturasAdicionalesHelper> coberturasAdicionalesTemp = new ArrayList<>();
		this.rowWithCoberturaAdicional.forEach(p -> {
			WebElement element = p.findElement(By.xpath(this.xPathFilterClausulaCheckbox));
			if(element.isSelected()) {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(true, p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
					p.findElement(By.xpath(this.xPathFilterClausulaCheckbox))));
			} else {
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(false, p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
					p.findElement(By.xpath(this.xPathFilterClausulaCheckbox))));
			}

		});

		this.webDriver.exitFrame();
		logger.debug("END - GetCoberturasOpcionales");
		return coberturasAdicionalesTemp;
	}

	public PrecioPorModalidadPage completarCoberturaPorMaquinaria() throws IOException, InterruptedException {
		logger.debug("BEGIN - CompletarCoberturaPorMaquinaria");
		String completarCoberturaMaquinaria = this.tCData.getTestVar(testId, "CoberturaOpcionalMaquinaHerramientaIncluida");
		if(completarCoberturaMaquinaria.equals(ProjectConstants.CoberturaOpcionalncluida)) {
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();
			WebElement checkbox = this.coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaRoturaMaquinariaDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();
			this.webDriver.switchToFrame(this.cuerpoFrame);
			if(!checkbox.isSelected()) {

				// this.webDriver.ScrollPageDown(2, this.cuerpoFrame);
				// this.webDriver.exitFrame();
				// Coordinates coordinate = ((Locatable)
				// checkbox).getCoordinates();
				//
				// coordinate.onPage();
				// coordinate.inViewPort();

				// this.webDriver.SwitchToFrame(this.cuerpoFrame);
				// coordinate.inViewPort();
				// this.webDriver.exitFrame();
				// int location = this.cuerpoFrame.getLocation().getY();

				// if (this.browserContext.getProperties().Browser.equals("IE"))
				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(checkbox,
					// this.cuerpoFrame, this.hiddenFrame, this.topFrame);

					this.webDriver.switchToFrame(this.cuerpoFrame);
					this.webDriver.waitForLoadToComplete();
				}

				checkbox.click();
				/*
				 * Thread.sleep(4000); this.webDriver.exitFrame(); //
				 * this.webDriver.click(checkbox);
				 * this.webDriver.moveToElementInFrameWithJavaScript(this.
				 * roturaMquinariaChckBx, this.cuerpoFrame); Thread.sleep(4000);
				 * // this.webDriver.click(this.roturaMquinariaChckBx);
				 * this.webDriver.clickInFrame(this.roturaMquinariaChckBx,
				 * this.cuerpoFrame); Thread.sleep(4000);
				 */
				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(this.btnAnadirMaquinaria,
					// this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.webDriver.switchToFrame(this.cuerpoFrame);
				}
				// this.webDriver.scrollToWebElementWithJavaScript(this.btnAnadirMaquinaria);
				// Thread.sleep(4000);
				// this.webDriver.moveToElementWithJavaScript(this.btnAnadirMaquinaria);
				// this.webDriver.moveToElementWithJavaScriptStepByStep(this.btnAnadirMaquinaria,
				// this.cuerpoFrame, this.hiddenFrame, this.topFrame);
				// Thread.sleep(4000);
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(this.btnAnadirMaquinaria);
				this.webDriver.click(this.btnAnadirMaquinariaModalWindow);
				this.webDriver.clickElementFromDropDownByText(this.cmbTipoMaquinaria, this.tCData.getTestVar(testId, "cob_opc_tipo_maquinaria"));
				this.webDriver.appendText(this.txtValor, String.valueOf(this.tCData.getTestVar(testId, "cob_opc_valor_maquinaria")));
				this.webDriver.click(this.btnGuardarMaquinariaModalWindow);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterMaquinaria);
			}
			
			this.webDriver.exitFrame();
		}
		
		logger.debug("END - CompletarCoberturaPorMaquinaria");
		
		return this;
	}

	public PrecioPorModalidadPage completarCoberturasEmpleados() throws IOException {
		logger.debug("BEGIN - CompletarCoberturasEmpleados");
		String coberturaEmpleados = this.tCData.getTestVar(testId, "CoberturaOpcionalAccidentesPersonalesEmpleadosIncluida");

		if(coberturaEmpleados.equals(ProjectConstants.CoberturaOpcionalncluida)) {
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();

			WebElement checkbox = this.coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaAccidentesPersonalesEmpleados)).collect(Collectors.toList())
				.get(0).getCheckbox();

			this.webDriver.switchToFrame(this.cuerpoFrame);

			if(!checkbox.isSelected()) {
				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(checkbox,
					// this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.webDriver.switchToFrame(this.cuerpoFrame);
				}

				// this.webDriver.moveToElementAndClick(checkbox);
				// this.webDriver.click(checkbox);

				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(this.btnAsegurarAccidentesPantallaPrincipal,
					// this.cuerpoFrame, this.hiddenFrame,
					// this.topFrame);
					this.webDriver.switchToFrame(this.cuerpoFrame);
				}
				this.webDriver.exitFrame();
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(this.btnAsegurarAccidentesPantallaPrincipal);
				this.webDriver.click(this.btnAnadirAsegurado);

				this.webDriver.clickElementFromDropDownByText(this.cmbTipoDocumento, ProjectConstants.NIF);
				this.webDriver.appendText(this.txtNumeroDocumento, DniGeneratorHelper.generaNif(null));
				this.webDriver.appendText(this.txtEmpleadoNombre, this.tCData.getTestVar(testId, "EmpleadoNombre"));
				this.webDriver.appendText(this.txtEmpleadoApellido1, this.tCData.getTestVar(testId, "EmpleadoPrimerApellido"));
				this.webDriver.appendText(this.txtEmpleadoApellido2, this.tCData.getTestVar(testId, "EmpleadoSegundoApellido"));
				this.webDriver.clickElementFromDropDownByText(this.cmbEmpleadoProfesion, this.tCData.getTestVar(testId, "EmpleadoProfesion"));
				this.webDriver.appendText(this.txtEmpleadoProfesionDescripcion, this.tCData.getTestVar(testId, "EmpleadoPofesionDescripcion"));

				this.webDriver.appendText(this.txtEmpleadoCapital, this.tCData.getTestVar(testId, "EmpleadoCapital"));
				this.webDriver.appendText(this.txtEmpleadoFechaNacimiento, this.tCData.getTestVar(testId, "EmpleadoFechaNacimiento"));
				this.webDriver.clickElementFromDropDownByText(this.txtEmpleadoBeneficiario, this.tCData.getTestVar(testId, "EmpleadoBeneficiario"));
				this.webDriver.appendText(this.txtEmpleadoBeneficiarioDescripcion, this.tCData.getTestVar(testId, "EmpleadoBeneficiarioDescripcion"));
				this.webDriver.click(this.btnAsegurarAccidentesModalWindow);
				this.webDriver.exitFrame();
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterEmpleados);
			}
			
			this.webDriver.exitFrame();
		}
		
		logger.debug("END - CompletarCoberturasEmpleados");
		
		return this;
	}

	public PrecioPorModalidadPage completarCoberturasEnergiaSolar() throws IOException {
		logger.debug("BEGIN - CompletarCoberturasEnergiaSolar");
		String coberturasolar = this.tCData.getTestVar(testId, "CoberturaOpcionalInstalacionesFotovoltaicasIncluida");

		if(coberturasolar.equals(ProjectConstants.CoberturaOpcionalncluida)) {
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();

			this.webDriver.switchToFrame(this.cuerpoFrame);
			WebElement checkbox = this.coberturasAdicionales.stream()
				.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaEnergiaSolarDescripcion)).collect(Collectors.toList()).get(0)
				.getCheckbox();

			if(!checkbox.isSelected()) {
				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(checkbox,
					// this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.webDriver.switchToFrame(this.cuerpoFrame);
				}

				// this.webDriver.moveToElementAndClick(checkbox);
				// this.webDriver.click(checkbox);

				if(this.tCData.getConfigVar("Browser").equals("IE")) {
					// this.webDriver.moveToElementWithJavaScriptStepByStep(this.btnAnadirPlacaSolar,
					// this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.webDriver.switchToFrame(this.cuerpoFrame);
				}

				this.webDriver.click(this.btnAnadirPlacaSolar);
				this.webDriver.click(this.btnAnadirPlacaSolarModalWindow);

				this.webDriver.appendText(this.txtInstalacionFotovoltaicaDescripcion, this.tCData.getTestVar(testId, "InstalacionesFotovoltaicasDescripcion"));
				this.webDriver.appendText(this.txtInstalcionFotovoltaicaValor, String.valueOf(this.tCData.getTestVar(testId, "InstalacionesFotovoltaicasValor")));
				this.webDriver.click(this.btnGuardarInstalacionSolarModalWindow);
				this.webDriver.exitFrame();
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterEnergiaSolar);
			}
			
			this.webDriver.exitFrame();
		}
		
		logger.debug("END - CompletarCoberturasEnergiaSolar");
		
		return this;
	}

	public PrecioPorModalidadPage seleccionarModalidad() {
		logger.debug("BEGIN - SeleccionarModalidad");

		String modalidad = this.tCData.getTestVar(testId, "modalidad");

		switch(modalidad) {
			case ProjectConstants.ModalidadBasic:
				this.getPreciosBefore();
				this.webDriver.switchToFrame(this.cuerpoFrame);
				// this.webDriver.moveToElementWithJavaScript(this.btnModalidadBasic);
				this.webDriver.click(this.btnModalidadBasic);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterModalidadChangeToBasic);
				break;
			case ProjectConstants.ModalidadPlus:
				this.getPreciosBefore();
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(this.btnModalidadPlus);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterModalidadChangeToPlus);
				break;
		}

		this.webDriver.exitFrame();
		logger.debug("END - SeleccionarModalidad");
		
		return this;
	}

	public PrecioPorModalidadPage completarOQuitarDescuentoRecargo() {
		logger.debug("BEGIN - CompletarOQuitarDescuentoRecargo");
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.click(this.lnkMostrarDescuento);
		// this.webDriver.moveToElementAndClick(this.lnkMostrarDescuento);
		String DescuentoValue = this.webDriver.getText(this.lblPorcentajeDescuentoPantallaPrincipal);
		this.webDriver.exitFrame();

		if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "descuentoEnabled")) || Boolean.parseBoolean(this.tCData.getTestVar(testId, "recargo"))
			|| !DescuentoValue.equals(ProjectConstants.CantidadDescuentoNoEspecificado)) {
			this.getPreciosBefore();
			this.webDriver.switchToFrame(this.cuerpoFrame);
			// this.webDriver.moveToElementAndClick(this.btnAddTipoDescuento);
			String ErrorMessage = null;

			if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "descuentoEnabled"))) {
				this.webDriver.appendText(this.txtPorcentajeDescuento, ProjectConstants.PorcentajeDescuentoRecargo);
				this.webDriver.click(this.rdnDescuento);
				this.webDriver.clickElementFromDropDownByText(this.cmbTipoDescuento, ProjectConstants.TipoDescuento);
				ErrorMessage = ProjectConstants.AfterAddingDiscount;
			} else if(Boolean.parseBoolean(this.tCData.getTestVar(testId, "recargo"))) {
				this.webDriver.click(this.rdnRecargo);
				this.webDriver.appendText(this.txtPorcentajeDescuento, ProjectConstants.PorcentajeDescuentoRecargo);
				ErrorMessage = ProjectConstants.AfterAddingAdditionalCharge;
			} else if(!DescuentoValue.equals(ProjectConstants.CantidadDescuentoNoEspecificado) && !Boolean.parseBoolean(this.tCData.getTestVar(testId, "descuentoEnabled"))
				&& !Boolean.parseBoolean(this.tCData.getTestVar(testId, "recargo"))) {
				// this.webDriver.click(this.btnAddTipoDescuento);
				this.webDriver.appendText(this.txtPorcentajeDescuento, "");
				this.webDriver.tabulateElement(this.txtPorcentajeDescuento);
			}

			this.webDriver.click(this.btnGuadarDescuentoModalWindow);
			this.getPreciosAfter();
			this.compareValues(ProjectConstants.NotEqual, ErrorMessage);
		}

		this.webDriver.exitFrame();
		logger.debug("END - CompletarOQuitarDescuentoRecargo");
		
		return this;
	}

	public PrecioPorModalidadPage completarFranquiciaVoluntaria() {
		logger.debug("BEGIN - CompletarFranquiciaVoluntaria");
		String franquiciaVoluntaria = this.tCData.getTestVar(testId, "franquicia_voluntaria");

		if(franquiciaVoluntaria != null) {
			this.getPreciosBefore();
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.clickElementFromDropDownByText(this.cmbFranquiciaVoluntaria, franquiciaVoluntaria);
			this.getPreciosAfter();
			this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterAddingFranquiciaVoluntaria);
		}
		logger.debug("END - CompletarFranquiciaVoluntaria");
		
		return this;
	}

	public PrecioPorModalidadPage getPreciosBefore() {
		logger.debug("BEGIN - GetPreciosBefore");
		this.webDriver.exitFrame();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.PrecioBasicBefore = this.webDriver.getText(this.lblPrecioBasic);
		this.PrecioCompletoBefore = this.webDriver.getText(this.lblPrecioComplet);
		this.PrecioPlusBefore = this.webDriver.getText(this.lblPrecioPlus);
		logger.debug("Precio basic before: " + this.webDriver.getText(this.lblPrecioBasic));
		logger.debug("Precio complet before: " + this.webDriver.getText(this.lblPrecioComplet));
		logger.debug("Precio plus before: " + this.webDriver.getText(this.lblPrecioPlus));
		this.webDriver.exitFrame();

		logger.debug("END - GetPreciosBefore");
		
		return this;
	}

	public PrecioPorModalidadPage getPreciosAfter() {
		logger.debug("BEGIN - GetPreciosAfter");
		this.webDriver.exitFrame();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.PrecioBasicAfter = this.webDriver.getText(this.lblPrecioBasic);
		this.PrecioCompletoAfter = this.webDriver.getText(this.lblPrecioComplet);
		this.PrecioPlusAfter = this.webDriver.getText(this.lblPrecioPlus);
		logger.debug("Precio basic after: " + this.webDriver.getText(this.lblPrecioBasic));
		logger.debug("Precio complet after: " + this.webDriver.getText(this.lblPrecioComplet));
		logger.debug("Precio plus after: " + this.webDriver.getText(this.lblPrecioPlus));
		this.webDriver.exitFrame();

		logger.debug("AFTER - GetPreciosAfter");
		
		return this;
	}

	public PrecioPorModalidadPage compareValues(String ComparisonType, String Modification) {
		logger.debug("BEGIN - CompareValues");
		logger.debug("ComparisonType: " + ComparisonType + ", Modalidad: " + this.tCData.getTestVar(testId, "modalidad"));
		switch(ComparisonType) {

			case ProjectConstants.NotEqual:
				switch(this.tCData.getTestVar(testId, "modalidad")) {
					case ProjectConstants.ModalidadPlus:
						if(this.PrecioPlusBefore.equals(this.PrecioPlusAfter)) {
							this.tCData.setTestVar(testId, "capitalesModifiedError", "true");
							// this.tCData.setTestVar(testId,
							// "capitalesModifiedErrorMessage", Modification);
							this.tCData.setTestVar(testId, "capitalesModifiedErrorMessage", "El valor de la prima total anual no ha variado en la pantalla de precio %s");
							// String.format("El valor de la prima total anual
							// no ha variado en la pantalla de precio %s",
							// Modification));
						}
						break;
					case ProjectConstants.ModalidadBasic:
						if(this.PrecioBasicBefore.equals(this.PrecioBasicAfter)) {
							// this.tCData.setCapitalesModifiedError(true);
							// this.tCData.setCapitalesModifiedErrorMessage(
							// String.format("El valor de la prima total anual
							// no ha variado en la pantalla de precio %s",
							// Modification));

							this.tCData.setTestVar(testId, "capitalesModifiedError", "true");
							// this.tCData.setTestVar(testId,
							// "capitalesModifiedErrorMessage", Modification);
							this.tCData.setTestVar(testId, "capitalesModifiedErrorMessage", "El valor de la prima total anual no ha variado en la pantalla de precio %s");
							// String.format("El valor de la prima total anual
							// no ha variado en la pantalla de precio %s",
							// Modification));

						}
						break;

					case ProjectConstants.ModalidadCompleta:
						if(this.PrecioCompletoBefore.equals(this.PrecioCompletoAfter)) {
							// this.tCData.setCapitalesModifiedError(true);
							// this.tCData.setCapitalesModifiedErrorMessage(
							// String.format("El valor de la prima total anual
							// no ha variado en la pantalla de precio %s",
							// Modification));

							this.tCData.setTestVar(testId, "capitalesModifiedError", "true");
							// this.tCData.setTestVar(testId,
							// "capitalesModifiedErrorMessage", Modification);
							this.tCData.setTestVar(testId, "capitalesModifiedErrorMessage", "El valor de la prima total anual no ha variado en la pantalla de precio %s");
							// String.format("El valor de la prima total anual
							// no ha variado en la pantalla de precio %s",
							// Modification));

						}
						break;
				}
				break;

			// Chris 06/09/2017 - Creo que este codigo no se usa. Lo comento.
			// case MutuaPropietariosConstants.Equal:
			// if (!this.PrecioBasicBefore.equals(this.PrecioBasicAfter) ||
			// !this.PrecioCompletoBefore.equals(this.PrecioBasicAfter)
			// || !this.PrecioPlusBefore.equals(this.PrecioPlusAfter))
			// {
			// this.tCData.setCapitalesModifiedError(true);
			// this.tCData.setCapitalesModifiedErrorMessage(
			// String.format("El valor de los capitales ha variado en la
			// pantalla de precio %s", Modification));
			// }

			// break;
		}
		logger.debug("END - CompareValues");
		
		return this;
	}

	public PrecioPorModalidadPage modificarRC(String value) {
		this.webDriver.clickElementFromDropDownByTextInFrame(this.drpDwnRespCivil, this.cuerpoFrame, value);
		
		return this;
	}

	public PrecioPorModalidadPage agregarDescuento(String descuento) {
		logger.debug("BEGIN - agregarDescuento");

		// this.GetPreciosBefore();
		// this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.moveToElementAndClickWithJavaScript(this.btnAddTipoDescuento);
		this.webDriver.clickInFrame(this.btnAddTipoDescuento, this.cuerpoFrame);
		String ErrorMessage = null;
		// this.webDriver.appendText(this.txtPorcentajeDescuento, descuento);
		// this.webDriver.click(this.rdnDescuento);
		// this.webDriver.clickElementFromDropDownByText(this.cmbTipoDescuento,
		// MutuaPropietariosConstants.TipoDescuento);
		this.webDriver.appendTextInFrame(this.txtPorcentajeDescuento, this.cuerpoFrame, descuento);
		this.webDriver.clickInFrame(this.rdnDescuento, this.cuerpoFrame);
		this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbTipoDescuento, this.cuerpoFrame, ProjectConstants.TipoDescuento);
		// ErrorMessage = MutuaPropietariosConstants.AfterAddingDiscount;

		// this.webDriver.click(this.btnGuadarDescuentoModalWindow);
		// this.GetPreciosAfter();
		// this.CompareValues(MutuaPropietariosConstants.NotEqual,
		// ErrorMessage);
		this.webDriver.clickInFrame(this.btnGuadarDescuentoModalWindow, this.cuerpoFrame);

		// Pulsar Aceptar en el aviso sobre la autorizacion de descuento que
		// sale para ciertos mediadores
		if(this.webDriver.isPresentInFrame(this.msgAutorizarDescuento, this.cuerpoFrame)) {
			this.webDriver.clickInFrame(this.btnAceptarAutorizarDescuento, this.cuerpoFrame);
		}

		// this.webDriver.exitFrame();
		logger.debug("END - agregarDescuento");
		
		return this;
	}

	public String getPrecioTotal() {
		logger.debug("BEGIN - getPrecioTotal");
		String value = "";
		if(this.webDriver.isPresentInFrame(this.lblPrecioComplet, this.cuerpoFrame))
			value = this.webDriver.getTextInFrame(this.lblPrecioComplet, this.cuerpoFrame);

		logger.debug("END - getPrecioTotal");
		return value;
	}

	public String getPrecioBasic() {
		logger.debug("BEGIN - getPrecioBasic");
		String value = "";
		if(this.webDriver.isPresentInFrame(this.lblPrecioBasic, this.cuerpoFrame))
			value = this.webDriver.getTextInFrame(this.lblPrecioBasic, this.cuerpoFrame);

		logger.debug("END - getPrecioBasic");
		return value;
	}

	public String getPrecioPlus() {
		logger.debug("BEGIN - getPrecioPlus");
		String value = "";
		
		if(this.webDriver.isPresentInFrame(this.lblPrecioPlus, this.cuerpoFrame))
			value = this.webDriver.getTextInFrame(this.lblPrecioPlus, this.cuerpoFrame);

		logger.debug("END - getPrecioPlus");
		
		return value;
	}

	public String getNumSimulacion() {
		logger.debug("BEGIN - getProjectNumber");
		String projectNumberText = this.webDriver.getTextInFrame(this.txtCodigoProjecto, this.cuerpoFrame);
		String ProjectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();
		this.webDriver.clickInFrame(this.btnAceptarInDialog, this.cuerpoFrame);
		logger.debug("END - getProjectNumber");
		
		return ProjectCode;
	}

	public PrecioPorModalidadPage clickOnGuardar() {
		logger.debug("BEGIN - clickOnGuardar");
		// this.cuerpoFrame.click();
		this.webDriver.scrollToBottom();
		this.webDriver.clickInFrame(this.btnGuardar, this.cuerpoFrame);
		logger.debug("END - clickOnGuardar");
		
		return this;
	}

	// endregion

}
