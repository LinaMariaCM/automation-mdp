package com.project.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.Helpers.CoberturasAdicionalesHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class PrecioPorModalidadPage
{
	final static Logger logger = LoggerFactory.getLogger(PrecioPorModalidadPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	// private String cssFilterSelectedCheckboxes = "input:checked[type=checkbox]";
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
	@FindBy(name = "cuerpo")
	private WebElement cuerpoFrame;

	@FindBy(id = "topFrame")
	private WebElement topFrame;

	@FindBy(id = "hideFrame")
	private WebElement hiddenFrame;
	
	@FindBy(xpath = ".//*[text()='Continuar']")
	private WebElement btnContinuar;
	
	// @FindBy(xpath = ".//*[text()='Guardar']")
	@FindBy(css = "button[ng-click='save(formPrecioModalidad)']")
	private WebElement btnGuardar;
	
	@FindBy(xpath = ".//*[contains(text(),'Cancelar')]")
	private WebElement btnCancelar;

	@FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]/../../../../div[@class='modal-footer']/button")
	private WebElement btnAceptarInDialog;
	
	@FindBy(xpath = ".//*[starts-with(text(),'El proyecto') and contains(text(),'se ha guardado.')]")
	private WebElement txtCodigoProjecto;
	
	@FindBy(xpath = ".//tr[td[input[@type='checkbox']]]")
	// @FindBy(xpath = ".//*[input]/input")
	private List<WebElement> rowWithCoberturaAdicional;
	
	@FindBy(css = "input:checked[type=checkbox]")
	private List<WebElement> selectedCheckboxes;
	
	@FindBy(xpath = ".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private WebElement clausulaPageSelector;
	
	/*
	 * @FindBy(xpath = ".//*[text() ='Añadir maquinaria']") private WebElement btnAnadirMaquinaria;
	 */
	
	@FindBy(css = "[ng-click*='#modalMaquinaria']")
	private WebElement btnAnadirMaquinaria;
	
	@FindBy(xpath = ".//*[text() ='Añadir' and @ng-click='newMaquinaria()']")
	private WebElement btnAnadirMaquinariaModalWindow;
	
	// @FindBy(xpath = ".//*[text() ='Añadir' and @ng-click='newInstalacion()']")
	@FindBy(css = "#modalInstalaciones > div > div > div.modal-body > div > div:nth-child(3) > div > button")
	private WebElement btnAnadirPlacaSolarModalWindow;
	
	@FindBy(xpath = ".//*[@ng-model='item.data.descripcion.data.codigo']")
	private WebElement cmbTipoMaquinaria;
	
	@FindBy(name = "valor")
	private WebElement txtValor;
	
	@FindBy(xpath = ".//*[text()='Guardar' and @ng-click='saveMaquinarias()']")
	private WebElement btnGuardarMaquinariaModalWindow;
	
	@FindBy(xpath = ".//*[contains(@ng-click,'#modalAsegurarAccidentes') and text()='Asegurar accidentes']")
	private WebElement btnAsegurarAccidentesPantallaPrincipal;
	
	@FindBy(xpath = ".//*[@ng-click='saveAsegurados()' and text()='Asegurar accidentes']")
	private WebElement btnAsegurarAccidentesModalWindow;
	
	@FindBy(xpath = ".//*[text() = 'Añadir asegurado']")
	private WebElement btnAnadirAsegurado;
	
	@FindBy(name = "tipoDocumento")
	private WebElement cmbTipoDocumento;
	
	@FindBy(id = "numeroDocumento_0")
	private WebElement txtNumeroDocumento;
	
	@FindBy(id = "nombre_0")
	private WebElement txtEmpleadoNombre;
	
	@FindBy(id = "apellido1_0")
	private WebElement txtEmpleadoApellido1;
	
	@FindBy(id = "apellido2_0")
	private WebElement txtEmpleadoApellido2;
	
	@FindBy(id = "fechaNacimiento_0")
	private WebElement txtEmpleadoFechaNacimiento;
	
	@FindBy(id = "profesion_0")
	private WebElement cmbEmpleadoProfesion;
	
	@FindBy(id = "profesionRelacion_0")
	private WebElement txtEmpleadoProfesionDescripcion;
	
	@FindBy(id = "capital_0")
	private WebElement txtEmpleadoCapital;
	
	@FindBy(id = "beneficiario_0")
	private WebElement txtEmpleadoBeneficiario;
	
	@FindBy(id = "beneficiarioRelacion_0")
	private WebElement txtEmpleadoBeneficiarioDescripcion;
	
	@FindBy(xpath = ".//*[text()='Añadir placa solar']")
	private WebElement btnAnadirPlacaSolar;
	
	@FindBy(name = "descripcion")
	private WebElement txtInstalacionFotovoltaicaDescripcion;
	
	@FindBy(name = "valor")
	private WebElement txtInstalcionFotovoltaicaValor;
	
	@FindBy(xpath = ".//*[text()='Guardar' and @ng-click='saveInstalaciones()']")
	private WebElement btnGuardarInstalacionSolarModalWindow;
	
	@FindBy(xpath = ".//*[text()='Basic']")
	private WebElement btnModalidadBasic;
	
	@FindBy(xpath = ".//*[text()='Plus']")
	private WebElement btnModalidadPlus;
	
	@FindBy(css = "select[name='capital']")
	private WebElement drpDwnRespCivil;
	
	// @FindBy(xpath = ".//*[text()='Basic']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	@FindBy(css = "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")
	private WebElement lblPrecioBasic;
	
	// @FindBy(xpath = ".//*[text()='Complet']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	@FindBy(css = "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")

	private WebElement lblPrecioComplet;
	
	// @FindBy(xpath = ".//*[text()='Plus']/..//div[contains(@ng-bind-html,'pm.getImporteModalidad(item))')]")
	@FindBy(css = "div[ng-include*='views/comunidades/precioModalidad/precioTotal.html'] tr[class='med-table-tr ng-scope']:nth-child(1) span[ng-bind-html='numberToView(item.data.reciboTotal) | encode']")
	private WebElement lblPrecioPlus;
	
	@FindBy(xpath = ".//*[text()='Franquicia voluntaria']/../select")
	private WebElement cmbFranquiciaVoluntaria;
	
	@FindBy(xpath = ".//*[text()='Añadir tipo de descuento']")
	private WebElement btnAddTipoDescuento;
	
	@FindBy(name = "porcentaje")
	private WebElement txtPorcentajeDescuento;
	
	@FindBy(xpath = ".//*[text()='Descuento']/../input")
	private WebElement rdnDescuento;
	
	@FindBy(id = "tipoDescuento")
	private WebElement cmbTipoDescuento;
	
	@FindBy(xpath = ".//*[text()='Guardar' and @ng-click='saveDescuento(formRecargoDescuento)']")
	private WebElement btnGuadarDescuentoModalWindow;
	
	@FindBy(xpath = ".//*[text()='Tipo de descuento']")
	private WebElement lnkMostrarDescuento;
	
	@FindBy(xpath = ".//*[@ng-bind-html='descuento.data.getTextDescuentoRecargo() | encode' and contains(@class,'ng-binding')]")
	private WebElement lblPorcentajeDescuentoPantallaPrincipal;
	
	@FindBy(css = "#modalErrores > div > div > div.modal-body > div > div > p")
	private WebElement msgAutorizarDescuento;
	
	@FindBy(css = "#modalErrores > div > div > div.modal-footer > button")
	private WebElement btnAceptarAutorizarDescuento;
	
	@FindBy(xpath = ".//*[text()='Recargo']/../input")
	private WebElement rdnRecargo;
	
	@FindBy(css = "tbody.ng-scope:nth-child(14) [ng-if='pm.isEspecialGroup(item)']")
	private WebElement roturaMquinariaChckBx;

	// endregion
	
	public PrecioPorModalidadPage(BrowserContext browserContext)
	{
		this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
		this.coberturasAdicionales = null;
	}
	
	// region methods
	public void ExecuteActionsInPrecioPorModalidadPage() throws InterruptedException, IOException
	{
		this.seleccionarModalidad();
		this.completarCoberturaPorMaquinaria();
		this.completarCoberturasEmpleados();
		this.completarCoberturasEnergiaSolar();
		this.completarFranquiciaVoluntaria();
		this.completarOQuitarDescuentoRecargo();
		this.clickOnContinuar();
	}

	public void clickOnContinuar() throws InterruptedException
	{
		logger.debug("BEGIN - ClickOnContinuar");
		// this.cuerpoFrame.click();
		// this.wh.scrollToEndOfPage();
		this.wh.clickOnWebElementInFrame(this.btnContinuar, this.cuerpoFrame);
		logger.debug("END - ClickOnContinuar");
	}

	public void clickOnCancelar() throws InterruptedException
	{
		logger.debug("BEGIN - ClickOnCancelar");
		this.cuerpoFrame.click();
		this.wh.scrollToEndOfPage();
		this.wh.clickOnWebElementInFrame(this.btnCancelar, this.cuerpoFrame);
		logger.debug("END - ClickOnCancelar");
	}
	
	public List<CoberturasAdicionalesHelper> getCoberturasOpcionales()
	{
		logger.debug("BEGIN - GetCoberturasOpcionales");
		this.wh.switchToFrame(this.cuerpoFrame);
		this.wh.waitForPageLoadWithAngular();
		
		List<CoberturasAdicionalesHelper> coberturasAdicionalesTemp = new ArrayList<>();
		this.rowWithCoberturaAdicional.forEach(p ->
		{
			WebElement element = p.findElement(By.xpath(this.xPathFilterClausulaCheckbox));
			if (element.isSelected())
			{
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(true, p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
						p.findElement(By.xpath(this.xPathFilterClausulaCheckbox))));
			}
			else
			{
				coberturasAdicionalesTemp.add(new CoberturasAdicionalesHelper(false, p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
						p.findElement(By.xpath(this.xPathFilterClausulaCheckbox))));
			}
		});
		
		this.wh.exitFromFrame();
		logger.debug("END - GetCoberturasOpcionales");
		return coberturasAdicionalesTemp;
	}
	
	public void completarCoberturaPorMaquinaria() throws IOException, InterruptedException
	{
		logger.debug("BEGIN - CompletarCoberturaPorMaquinaria");
		String completarCoberturaMaquinaria = this.browserContext.getTestCaseData().getCoberturaOpcionalMaquinaHerramientaIncluida();
		if (completarCoberturaMaquinaria.equals(ProjectConstants.CoberturaOpcionalncluida))
		{
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();
			WebElement checkbox = this.coberturasAdicionales.stream()
					.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaRoturaMaquinariaDescripcion)).collect(Collectors.toList()).get(0)
					.getCheckbox();
			this.wh.switchToFrame(this.cuerpoFrame);
			if (!checkbox.isSelected())
			{

				// this.wh.ScrollPageDown(2, this.cuerpoFrame);
				// this.wh.ExitFromFrame();
				// Coordinates coordinate = ((Locatable) checkbox).getCoordinates();
				//
				// coordinate.onPage();
				// coordinate.inViewPort();

				// this.wh.SwitchToFrame(this.cuerpoFrame);
				// coordinate.inViewPort();
				// this.wh.ExitFromFrame();
				// int location = this.cuerpoFrame.getLocation().getY();
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(checkbox, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
					this.wh.waitForPageLoadToFinish();
				}
				
				checkbox.click();
				/*
				 * Thread.sleep(4000); this.wh.exitFromFrame(); // this.wh.clickOnWebElement(checkbox);
				 * this.wh.moveToElementInFrameWithJavaScript(this.roturaMquinariaChckBx, this.cuerpoFrame); Thread.sleep(4000); //
				 * this.wh.clickOnWebElement(this.roturaMquinariaChckBx); this.wh.clickOnWebElementInFrame(this.roturaMquinariaChckBx, this.cuerpoFrame);
				 * Thread.sleep(4000);
				 */
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(this.btnAnadirMaquinaria, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
				}
				// this.wh.scrollToWebElementWithJavaScript(this.btnAnadirMaquinaria);
				// Thread.sleep(4000);
				// this.wh.moveToElementWithJavaScript(this.btnAnadirMaquinaria);
				this.wh.moveToElementWithJavaScriptStepByStep(this.btnAnadirMaquinaria, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
				// Thread.sleep(4000);
				this.wh.switchToFrame(this.cuerpoFrame);
				this.wh.clickOnWebElement(this.btnAnadirMaquinaria);
				this.wh.clickOnWebElement(this.btnAnadirMaquinariaModalWindow);
				this.wh.selectValueInDropDown(this.cmbTipoMaquinaria, this.browserContext.getTestCaseData().getCoberturaOpcionalMaquinariaTipo());
				this.wh.sendValueToWebElement(this.txtValor, String.valueOf(this.browserContext.getTestCaseData().getCoberturaOpcionalMaquinariaValor()));
				this.wh.clickOnWebElement(this.btnGuardarMaquinariaModalWindow);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterMaquinaria);
			}
			this.wh.exitFromFrame();
		}
		logger.debug("END - CompletarCoberturaPorMaquinaria");
	}
	
	public void completarCoberturasEmpleados() throws IOException
	{
		logger.debug("BEGIN - CompletarCoberturasEmpleados");
		String coberturaEmpleados = this.browserContext.getTestCaseData().getCoberturaOpcionalAccidentesPersonalesEmpleadosIncluida();
		
		if (coberturaEmpleados.equals(ProjectConstants.CoberturaOpcionalncluida))
		{
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();
			
			WebElement checkbox = this.coberturasAdicionales.stream()
					.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaAccidentesPersonalesEmpleados)).collect(Collectors.toList())
					.get(0).getCheckbox();
			
			this.wh.switchToFrame(this.cuerpoFrame);
			
			if (!checkbox.isSelected())
			{
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(checkbox, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
				}

				this.wh.moveToElementAndClickWithJavaScript(checkbox);
				// this.wh.clickOnWebElement(checkbox);
				
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(this.btnAsegurarAccidentesPantallaPrincipal, this.cuerpoFrame, this.hiddenFrame,
							this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
				}
				this.wh.exitFromFrame();
				this.wh.switchToFrame(this.cuerpoFrame);
				this.wh.clickOnWebElement(this.btnAsegurarAccidentesPantallaPrincipal);
				this.wh.clickOnWebElement(this.btnAnadirAsegurado);
				
				this.wh.selectValueInDropDown(this.cmbTipoDocumento, ProjectConstants.NIF);
				this.wh.sendValueToWebElement(this.txtNumeroDocumento, DniGeneratorHelper.generaNif(null));
				this.wh.sendValueToWebElement(this.txtEmpleadoNombre, this.browserContext.getTestCaseData().getEmpleadoNombre());
				this.wh.sendValueToWebElement(this.txtEmpleadoApellido1, this.browserContext.getTestCaseData().getEmpleadoPrimerApellido());
				this.wh.sendValueToWebElement(this.txtEmpleadoApellido2, this.browserContext.getTestCaseData().getEmpleadoSegundoApellido());
				this.wh.selectValueInDropDown(this.cmbEmpleadoProfesion, this.browserContext.getTestCaseData().getEmpleadoProfesion());
				this.wh.sendValueToWebElement(this.txtEmpleadoProfesionDescripcion, this.browserContext.getTestCaseData().getEmpleadoPofesionDescripcion());
				
				this.wh.sendValueToWebElement(this.txtEmpleadoCapital, this.browserContext.getTestCaseData().getEmpleadoCapital());
				this.wh.sendValueToWebElement(this.txtEmpleadoFechaNacimiento, this.browserContext.getTestCaseData().getEmpleadoFechaNacimiento());
				this.wh.selectValueInDropDown(this.txtEmpleadoBeneficiario, this.browserContext.getTestCaseData().getEmpleadoBeneficiario());
				this.wh.sendValueToWebElement(this.txtEmpleadoBeneficiarioDescripcion,
						this.browserContext.getTestCaseData().getEmpleadoBeneficiarioDescripcion());
				this.wh.clickOnWebElement(this.btnAsegurarAccidentesModalWindow);
				this.wh.exitFromFrame();
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterEmpleados);
			}
			this.wh.exitFromFrame();
		}
		logger.debug("END - CompletarCoberturasEmpleados");
	}
	
	public void completarCoberturasEnergiaSolar() throws IOException
	{
		logger.debug("BEGIN - CompletarCoberturasEnergiaSolar");
		String coberturasolar = this.browserContext.getTestCaseData().getCoberturaOpcionalInstalacionesFotovoltaicasIncluida();
		
		if (coberturasolar.equals(ProjectConstants.CoberturaOpcionalncluida))
		{
			this.getPreciosBefore();
			this.coberturasAdicionales = this.getCoberturasOpcionales();
			
			this.wh.switchToFrame(this.cuerpoFrame);
			WebElement checkbox = this.coberturasAdicionales.stream()
					.filter(p -> p.getDescription().equals(ProjectConstants.CoberturaEnergiaSolarDescripcion)).collect(Collectors.toList()).get(0)
					.getCheckbox();
			
			if (!checkbox.isSelected())
			{
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(checkbox, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
				}
				
				this.wh.moveToElementAndClickWithJavaScript(checkbox);
				// this.wh.clickOnWebElement(checkbox);
				
				if (this.browserContext.getProperties().Browser.equals("IE"))
				{
					this.wh.moveToElementWithJavaScriptStepByStep(this.btnAnadirPlacaSolar, this.cuerpoFrame, this.hiddenFrame, this.topFrame);
					this.wh.switchToFrame(this.cuerpoFrame);
				}

				this.wh.clickOnWebElement(this.btnAnadirPlacaSolar);
				this.wh.clickOnWebElement(this.btnAnadirPlacaSolarModalWindow);
				
				this.wh.sendValueToWebElement(this.txtInstalacionFotovoltaicaDescripcion,
						this.browserContext.getTestCaseData().getInstalacionesFotovoltaicasDescripcion());
				this.wh.sendValueToWebElement(this.txtInstalcionFotovoltaicaValor,
						String.valueOf(this.browserContext.getTestCaseData().getInstalacionesFotovoltaicasValor()));
				this.wh.clickOnWebElement(this.btnGuardarInstalacionSolarModalWindow);
				this.wh.exitFromFrame();
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterEnergiaSolar);
			}
			this.wh.exitFromFrame();
		}
		logger.debug("END - CompletarCoberturasEnergiaSolar");
	}
	
	public void seleccionarModalidad()
	{
		logger.debug("BEGIN - SeleccionarModalidad");
		
		String modalidad = this.browserContext.getTestCaseData().getModalidad();
		
		switch (modalidad)
		{
			case ProjectConstants.ModalidadBasic:
				this.getPreciosBefore();
				this.wh.switchToFrame(this.cuerpoFrame);
				// this.wh.moveToElementWithJavaScript(this.btnModalidadBasic);
				this.wh.clickOnWebElement(this.btnModalidadBasic);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterModalidadChangeToBasic);
				break;
			case ProjectConstants.ModalidadPlus:
				this.getPreciosBefore();
				this.wh.switchToFrame(this.cuerpoFrame);
				this.wh.clickOnWebElement(this.btnModalidadPlus);
				this.getPreciosAfter();
				this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterModalidadChangeToPlus);
				break;
		}
		
		this.wh.exitFromFrame();
		logger.debug("END - SeleccionarModalidad");
	}
	
	public void completarOQuitarDescuentoRecargo()
	{
		logger.debug("BEGIN - CompletarOQuitarDescuentoRecargo");
		this.wh.switchToFrame(this.cuerpoFrame);
		// this.wh.ClickOnWebElement(this.lnkMostrarDescuento);
		this.wh.moveToElementAndClickWithJavaScript(this.lnkMostrarDescuento);
		String DescuentoValue = this.wh.getTextFromWebElement(this.lblPorcentajeDescuentoPantallaPrincipal);
		this.wh.exitFromFrame();
		
		if (this.tData.isDescuentoEnabled() || this.tData.isRecargo()
				|| !DescuentoValue.equals(ProjectConstants.CantidadDescuentoNoEspecificado))
		{
			this.getPreciosBefore();
			this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.moveToElementAndClickWithJavaScript(this.btnAddTipoDescuento);
			String ErrorMessage = null;
			
			if (this.tData.isDescuentoEnabled())
			{
				this.wh.sendValueToWebElement(this.txtPorcentajeDescuento, ProjectConstants.PorcentajeDescuentoRecargo);
				this.wh.clickOnWebElement(this.rdnDescuento);
				this.wh.selectValueInDropDown(this.cmbTipoDescuento, ProjectConstants.TipoDescuento);
				ErrorMessage = ProjectConstants.AfterAddingDiscount;
			}
			else if (this.tData.isRecargo())
			{
				this.wh.clickOnWebElement(this.rdnRecargo);
				this.wh.sendValueToWebElement(this.txtPorcentajeDescuento, ProjectConstants.PorcentajeDescuentoRecargo);
				ErrorMessage = ProjectConstants.AfterAddingAdditionalCharge;
			}
			else if (!DescuentoValue.equals(ProjectConstants.CantidadDescuentoNoEspecificado) && !this.tData.isDescuentoEnabled()
					&& !this.tData.isRecargo())
			{
				// this.wh.ClickOnWebElement(this.btnAddTipoDescuento);
				this.wh.sendValueToWebElement(this.txtPorcentajeDescuento, "");
				this.wh.changeFocusOfWebElement(this.txtPorcentajeDescuento);
			}
			
			this.wh.clickOnWebElement(this.btnGuadarDescuentoModalWindow);
			this.getPreciosAfter();
			this.compareValues(ProjectConstants.NotEqual, ErrorMessage);
		}
		
		this.wh.exitFromFrame();
		logger.debug("END - CompletarOQuitarDescuentoRecargo");
	}
	
	public void completarFranquiciaVoluntaria()
	{
		logger.debug("BEGIN - CompletarFranquiciaVoluntaria");
		String franquiciaVoluntaria = this.browserContext.getTestCaseData().getFranquiciaVoluntaria();
		
		if (franquiciaVoluntaria != null)
		{
			this.getPreciosBefore();
			this.wh.switchToFrame(this.cuerpoFrame);
			this.wh.selectValueInDropDown(this.cmbFranquiciaVoluntaria, franquiciaVoluntaria);
			this.getPreciosAfter();
			this.compareValues(ProjectConstants.NotEqual, ProjectConstants.AfterAddingFranquiciaVoluntaria);
		}
		logger.debug("END - CompletarFranquiciaVoluntaria");
	}
	
	public void getPreciosBefore()
	{
		logger.debug("BEGIN - GetPreciosBefore");
		this.wh.exitFromFrame();
		this.wh.switchToFrame(this.cuerpoFrame);
		this.PrecioBasicBefore = this.wh.getTextFromWebElement(this.lblPrecioBasic);
		this.PrecioCompletoBefore = this.wh.getTextFromWebElement(this.lblPrecioComplet);
		this.PrecioPlusBefore = this.wh.getTextFromWebElement(this.lblPrecioPlus);
		logger.debug("Precio basic before: " + this.wh.getTextFromWebElement(this.lblPrecioBasic));
		logger.debug("Precio complet before: " + this.wh.getTextFromWebElement(this.lblPrecioComplet));
		logger.debug("Precio plus before: " + this.wh.getTextFromWebElement(this.lblPrecioPlus));
		this.wh.exitFromFrame();
		
		logger.debug("END - GetPreciosBefore");
	}
	
	public void getPreciosAfter()
	{
		logger.debug("BEGIN - GetPreciosAfter");
		this.wh.exitFromFrame();
		this.wh.switchToFrame(this.cuerpoFrame);
		this.PrecioBasicAfter = this.wh.getTextFromWebElement(this.lblPrecioBasic);
		this.PrecioCompletoAfter = this.wh.getTextFromWebElement(this.lblPrecioComplet);
		this.PrecioPlusAfter = this.wh.getTextFromWebElement(this.lblPrecioPlus);
		logger.debug("Precio basic after: " + this.wh.getTextFromWebElement(this.lblPrecioBasic));
		logger.debug("Precio complet after: " + this.wh.getTextFromWebElement(this.lblPrecioComplet));
		logger.debug("Precio plus after: " + this.wh.getTextFromWebElement(this.lblPrecioPlus));
		this.wh.exitFromFrame();
		
		logger.debug("AFTER - GetPreciosAfter");
	}
	
	public void compareValues(
			String ComparisonType, String Modification)
	{
		logger.debug("BEGIN - CompareValues");
		logger.debug("ComparisonType: " + ComparisonType + ", Modalidad: " + this.tData.getModalidad());
		switch (ComparisonType)
		{
			
			case ProjectConstants.NotEqual:
				switch (this.tData.getModalidad())
				{
					case ProjectConstants.ModalidadPlus:
						if (this.PrecioPlusBefore.equals(this.PrecioPlusAfter))
						{
							this.tData.setCapitalesModifiedError(true);
							this.tData.setCapitalesModifiedErrorMessage(
									String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", Modification));
						}
						break;
					case ProjectConstants.ModalidadBasic:
						if (this.PrecioBasicBefore.equals(this.PrecioBasicAfter))
						{
							this.tData.setCapitalesModifiedError(true);
							this.tData.setCapitalesModifiedErrorMessage(
									String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", Modification));
						}
						break;
					
					case ProjectConstants.ModalidadCompleta:
						if (this.PrecioCompletoBefore.equals(this.PrecioCompletoAfter))
						{
							this.tData.setCapitalesModifiedError(true);
							this.tData.setCapitalesModifiedErrorMessage(
									String.format("El valor de la prima total anual no ha variado en la pantalla de precio %s", Modification));
						}
						break;
				}
				break;

			// Chris 06/09/2017 - Creo que este codigo no se usa. Lo comento.
			// case MutuaPropietariosConstants.Equal:
			// if (!this.PrecioBasicBefore.equals(this.PrecioBasicAfter) || !this.PrecioCompletoBefore.equals(this.PrecioBasicAfter)
			// || !this.PrecioPlusBefore.equals(this.PrecioPlusAfter))
			// {
			// this.tData.setCapitalesModifiedError(true);
			// this.tData.setCapitalesModifiedErrorMessage(
			// String.format("El valor de los capitales ha variado en la pantalla de precio %s", Modification));
			// }

			// break;
		}
		logger.debug("END - CompareValues");
	}

	public void modificarRC(
			String value)
	{
		this.wh.selectValueInDropDownInFrame(this.drpDwnRespCivil, this.cuerpoFrame, value);
	}
	
	public void agregarDescuento(
			String descuento)
	{
		logger.debug("BEGIN - agregarDescuento");
		
		// this.GetPreciosBefore();
		// this.wh.switchToFrame(this.cuerpoFrame);
		// this.wh.moveToElementAndClickWithJavaScript(this.btnAddTipoDescuento);
		this.wh.clickOnWebElementInFrame(this.btnAddTipoDescuento, this.cuerpoFrame);
		String ErrorMessage = null;
		// this.wh.sendValueToWebElement(this.txtPorcentajeDescuento, descuento);
		// this.wh.clickOnWebElement(this.rdnDescuento);
		// this.wh.selectValueInDropDown(this.cmbTipoDescuento, MutuaPropietariosConstants.TipoDescuento);
		this.wh.sendValueToWebElementInFrame(this.txtPorcentajeDescuento, this.cuerpoFrame, descuento);
		this.wh.clickOnWebElementInFrame(this.rdnDescuento, this.cuerpoFrame);
		this.wh.selectValueInDropDownInFrame(this.cmbTipoDescuento, this.cuerpoFrame, ProjectConstants.TipoDescuento);
		// ErrorMessage = MutuaPropietariosConstants.AfterAddingDiscount;
		
		// this.wh.clickOnWebElement(this.btnGuadarDescuentoModalWindow);
		// this.GetPreciosAfter();
		// this.CompareValues(MutuaPropietariosConstants.NotEqual, ErrorMessage);
		this.wh.clickOnWebElementInFrame(this.btnGuadarDescuentoModalWindow, this.cuerpoFrame);

		// Pulsar Aceptar en el aviso sobre la autorizacion de descuento que sale para ciertos mediadores
		if (this.wh.webElementInFrameIsPresent(this.msgAutorizarDescuento, this.cuerpoFrame))
		{
			this.wh.clickOnWebElementInFrame(this.btnAceptarAutorizarDescuento, this.cuerpoFrame);
		}

		// this.wh.exitFromFrame();
		logger.debug("END - agregarDescuento");
	}

	public String getPrecioTotal()
	{
		logger.debug("BEGIN - getPrecioTotal");
		String value = "";
		if (this.wh.webElementInFrameIsPresent(this.lblPrecioComplet, this.cuerpoFrame))
			value = this.wh.getTextFromWebElementInFrame(this.lblPrecioComplet, this.cuerpoFrame);

		logger.debug("END - getPrecioTotal");
		return value;
	}

	public String getPrecioBasic()
	{
		logger.debug("BEGIN - getPrecioBasic");
		String value = "";
		if (this.wh.webElementInFrameIsPresent(this.lblPrecioBasic, this.cuerpoFrame))
			value = this.wh.getTextFromWebElementInFrame(this.lblPrecioBasic, this.cuerpoFrame);

		logger.debug("END - getPrecioBasic");
		return value;
	}

	public String getPrecioPlus()
	{
		logger.debug("BEGIN - getPrecioPlus");
		String value = "";
		if (this.wh.webElementInFrameIsPresent(this.lblPrecioPlus, this.cuerpoFrame))
			value = this.wh.getTextFromWebElementInFrame(this.lblPrecioPlus, this.cuerpoFrame);

		logger.debug("END - getPrecioPlus");
		return value;
	}
	
	public String getNumSimulacion()
	{
		logger.debug("BEGIN - getProjectNumber");
		String projectNumberText = this.wh.getTextFromWebElementInFrame(this.txtCodigoProjecto, this.cuerpoFrame);
		String ProjectCode = StringUtils.substringBetween(projectNumberText, "El proyecto", "se ha guardado.").trim();
		this.wh.clickOnWebElementInFrame(this.btnAceptarInDialog, this.cuerpoFrame);
		logger.debug("END - getProjectNumber");
		return ProjectCode;
	}
	
	public void clickOnGuardar()
	{
		logger.debug("BEGIN - clickOnGuardar");
		// this.cuerpoFrame.click();
		this.wh.scrollToEndOfPage();
		this.wh.clickOnWebElementInFrame(this.btnGuardar, this.cuerpoFrame);
		logger.debug("END - clickOnGuardar");
	}
	
	// endregion
	
}
