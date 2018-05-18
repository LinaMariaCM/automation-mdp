package com.project.pages;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;
//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class GestionPolizasConsultarPage extends PageObject {

	DecimalFormat df = new DecimalFormat("#.00");
	Locale locale = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(this.locale);

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// @FindBy(xpath = "/html/body/h1/text()")
	// @FindBy(xpath = ".//*[contains(text(),'Póliza:')]")
	// ".//*[contains(text(),'La póliza') and contains(text(),'ha sido dada de
	// alta correctamente.')]"
	private By txtHeaderPolicyNumber = By.xpath(".//*[contains(text(),'Póliza:')]");

	// @FindBy(xpath = ".//*[@id='pesClausulas']/span")
	private By tabHeaderClausulas = By.xpath(".//*[@id='pesClausulas']/span");

	// @FindBy(xpath = ".//*[@id='pesImportes']/span")
	private By tabHeaderImportes;

	// @FindBy(xpath = ".//*[@id='pesCoberturas']/span")
	private By tabHeaderCoberturas = By.xpath(".//*[@id='pesCoberturas']/span");

	// @FindBy(xpath = ".//*[@id='pesDatosRiesgo']/span")
	// @FindBy(id = "pesDatosRiesgo")
	private By tabHeaderDatosRiesgos = By.cssSelector("pesDatosRiesgo");

	@FindBy(xpath = ".//tr[td/strong[text()='Tipo Descuento:']]/td[4]")
	private List<WebElement> lblTipoDescuento;

	@FindBy(xpath = ".//tr[td[text()='Rotura de maquinaria']]/td[3]")
	private List<WebElement> lblCoberturaMaquinariaCantidad;

	@FindBy(xpath = ".//tr[td/strong[text()='Descuento:']]/td[4]")
	private List<WebElement> lblCantidadDescuento;

	@FindBy(xpath = ".//*[@id='capaClausulas']//tr[td]")
	private List<WebElement> rowWithClausula;

	@FindBy(xpath = ".//tr[td[text()='Rotura de instalaciones de energía solar fotovoltaica']]/td[3]")
	private List<WebElement> lblCoberturaEnergiaSolarCantidad;

	@FindBy(xpath = ".//*[contains(text(),'Queda excluida la Responsabilidad Civil derivada de los alfeices de la cubierta por riesgo de desprendimientos')]")
	private List<WebElement> lblClausulasHipotecarias;

	@FindBy(xpath = ".//tr[td/strong[text()='Capital contenido:']]/td[2]")
	private List<WebElement> lblCapitalContenido;

	@FindBy(xpath = ".//tr[td/strong[text()='Capital continente:']]/td[2]")
	private List<WebElement> lblCapitalContinente;

	@FindBy(xpath = ".//tr[td/strong[text()='Año construcción:']]/td[2]")
	private List<WebElement> lblConstrucionYear;

	@FindBy(xpath = ".//*[contains(text(),'Locales excluidos')]")
	private List<WebElement> lblLocalesExluidos;

	@FindBy(xpath = ".//*[contains(text(),'Depósito de combustible superior a 3000 l')]")
	private List<WebElement> lblDepositoCombustible;

	@FindBy(xpath = ".//*[contains(text(),' Calefacción central y/o agua caliente)')]")
	private List<WebElement> lblCalefaccionCentral;

	@FindBy(xpath = ".//tr[td/strong[text()='M2 Construidos Totales:']]/td[2]")
	private List<WebElement> lblM2ContruidosTotales;

	@FindBy(xpath = ".//tr[td/strong[text()='Año rehabilitación conducciones de aguas comunitarias:']]/td[2]")
	private List<WebElement> lblAnyoRehabilitacionContruccionesComunitarias;

	@FindBy(xpath = ".//tr[td/strong[text()='Nivel de rehabilitación conducciones de aguas comunitarias:']]/td[4]")
	private List<WebElement> lblNivelRehabilitacionContruccionesComunitarias;

	@FindBy(xpath = ".//tr[td/strong[text()='Año rehabilitación integral:']]/td[2]")
	private List<WebElement> lblAnyoRehabilitacionIntegral;

	@FindBy(xpath = ".//tr[td/strong[text()='Calidad de la construcción:']]/td[4]")
	private List<WebElement> lblCalidadConstruccion;

	// @FindBy(xpath = ".//*[text()='Calefacción central y/o agua caliente']")
	// private List<WebElement> lblCalefaccionCentralYAguaCaliente;

	private String xPathFilterClausulaText = ".//td[3]";
	private String xPathFilterClausulaNumber = ".//td[2]";

	// endregion

	public GestionPolizasConsultarPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public void CheckPolizaNumber() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);

		// Get the text from the policy number shown in the header of the policy
		// file.
		String polizaNumber = this.webDriver.getText(this.txtHeaderPolicyNumber);

		// Trim the text to leave just the policy number itself.
		Integer firstCharacter = polizaNumber.indexOf(":") + 2;
		Integer lastCharacter = polizaNumber.indexOf(":") + 11;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPolizaConsulta = trimmedPolizaNumber;

		// Compare the trimmed policy number with the policy number obtained
		// when policy was created.
		org.junit.Assert.assertEquals(this.testDataM.getTestVar(testId, "NumPoliza"), numPolizaConsulta);
		this.webDriver.exitFrame();
		debugEnd();
	}

	public void CheckClausulas() {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.tabHeaderClausulas);
		List<Integer> tabPageClausulas = new ArrayList<>();
		// We need a method on testDataM to obtain a list of Strings for the
		// Clausulas variables
		// this.rowWithClausula.forEach(p ->
		// tabPageClausulas.add(Integer.valueOf(p.findElement(By.xpath(this.xPathFilterClausulaNumber)).getText())));
		// Integer numberOfMatchesFound =
		// this.testDataM.getClausulas().stream().filter(p ->
		// tabPageClausulas.contains(Integer.valueOf(p)))
		// .collect(Collectors.toList()).size();
		//
		// Assert.assertTrue(
		// "Las clausulas presentes en el tab de clausulas dentro del detalle de
		// la poliza no coinciden con las seleecionadas durante la inclusion del
		// suplemento",
		// numberOfMatchesFound == this.tData.getClausulas().size());
		// this.webDriver.exitFrame();
		debugEnd();
	}

	public void CheckValueInTab(String tab, String ValueToBeChecked, String ExpectedValue) throws Exception {
		debugBegin();
		this.OpenTab(tab);

		this.webDriver.switchToFrame(this.cuerpoFrame);
		List<WebElement> lblObjectCollection;
		String message = "";

		switch(ValueToBeChecked) {
			case ProjectConstants.PolizaDetailConstructionYear:
				lblObjectCollection = this.lblConstrucionYear;
				message = ProjectConstants.PolizaDetailConstructionYearErrorMessage;
				break;

			case ProjectConstants.PolizaDetailCapitalContinente:
				lblObjectCollection = this.lblCapitalContinente;
				message = ProjectConstants.PolizaDetailCapitalContinenteErrorMessage;
				break;

			case ProjectConstants.PolizaDetailCapitalContenido:
				lblObjectCollection = this.lblCapitalContenido;
				message = ProjectConstants.PolizaDetailCapitalContenidoErororMessage;
				break;

			case ProjectConstants.PolizaDetailNuevaClausulaHipotecaria:
				lblObjectCollection = this.lblClausulasHipotecarias;
				message = ProjectConstants.PolizaDetailNuevaClausulaHipotecariaErrorMessage;
				break;

			case ProjectConstants.PolizaDetailLocalesExcluidos:
				lblObjectCollection = this.lblLocalesExluidos;
				message = ProjectConstants.PolizaDetailLocalesExcluidosErrorMessage;
				break;

			case ProjectConstants.PolizaDetailCalefaccionCentral:
				lblObjectCollection = this.lblCalefaccionCentral;
				message = ProjectConstants.PolizaDetailCalefaccionCentralErrorMessage;
				break;

			case ProjectConstants.PolizaDetailPlacaSolar:
				lblObjectCollection = this.lblCoberturaEnergiaSolarCantidad;
				message = ProjectConstants.PolizaDetailPlacaSolarErrorMessage;
				break;

			case ProjectConstants.PolizaDetailMaquinaria:
				lblObjectCollection = this.lblCoberturaMaquinariaCantidad;
				message = ProjectConstants.PolizaDetailMaquinariaErrorMessage;
				break;

			case ProjectConstants.PolizaDetailDescuento:
			case ProjectConstants.PolizaDetailNoDescuento:

				lblObjectCollection = this.lblTipoDescuento;
				message = ProjectConstants.PolizaDetailDescuentoErrorMessage;
				break;

			case ProjectConstants.PolizaDetailDescuentoValue:
				lblObjectCollection = this.lblCantidadDescuento;
				message = ProjectConstants.PolizaDetailDescuentoValueErrorMessage;
				break;

			case ProjectConstants.PolizaDetailRecargo:
				lblObjectCollection = this.lblCantidadDescuento;
				message = ProjectConstants.PolizaDetailRecargoErrorMessage;
				break;

			case ProjectConstants.PolizaDetailM2ConstruidosTotales:
				lblObjectCollection = this.lblM2ContruidosTotales;
				message = ProjectConstants.PolizaDetailM2ConstruidosTotalesErrorMessage;
				break;

			case ProjectConstants.PolizaDetailYearRehabilitacionIntegral:
				lblObjectCollection = this.lblAnyoRehabilitacionIntegral;
				message = ProjectConstants.PolizaDetailYearRehabilitacionIntegralErrorMessage;
				break;

			case ProjectConstants.PolizaDetailCalidadConstruccion:
				lblObjectCollection = this.lblCalidadConstruccion;
				message = ProjectConstants.PolizaDetailCalidadConstruccionMessage;
				break;

			default:
				throw new Exception("El valor seleccionado para comprobar no está implementado");
		}

		// the value has to exist and to have an specific value
		if(!ExpectedValue.equals(null) && !ExpectedValue.equals(ProjectConstants.DescuentoRecargoNotSpecified)) {
			if(lblObjectCollection.size() == 0) { throw new Exception(message); }

			String value = this.webDriver.getText(lblObjectCollection.get(0));
			Assert.assertTrue(message, value.equals(ExpectedValue));
		}
		// The value doesn't have to exist
		else if(ExpectedValue.equals(null)) {
			if(lblObjectCollection.size() != 0) { throw new Exception(message); }
		}
		// The value has to exist only
		else if(ExpectedValue.equals(ProjectConstants.DescuentoRecargoNotSpecified)) {
			if(lblObjectCollection.size() != 0) { throw new Exception(message); }
		}

		this.webDriver.exitFrame();
		debugEnd();
	}

	public void OpenTab(String tabName) throws Exception {
		debugBegin();

		this.webDriver.switchToFrame(this.cuerpoFrame);

		switch(tabName) {
			case ProjectConstants.PolizaDetailTabDetallesRiesgo:
				this.webDriver.click(this.tabHeaderDatosRiesgos);
				break;

			case ProjectConstants.PolizaDetailTabClausulas:
				this.webDriver.click(this.tabHeaderClausulas);
				break;

			case ProjectConstants.PolizaDetailTabImportes:
				this.webDriver.click(this.tabHeaderImportes);
				break;

			case ProjectConstants.PolizaDetailTabCoberturas:
				this.webDriver.click(this.tabHeaderCoberturas);
				break;

			default:
				throw new Exception("El tab seleccionado no está implementado");
		}
		
		this.webDriver.exitFrame();
		debugEnd();
	}

	public void CheckAnyoAndNivelRehabilitacion() throws Exception {
		debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.click(this.tabHeaderDatosRiesgos);

		if(this.lblAnyoRehabilitacionContruccionesComunitarias.size() == 0 || this.lblNivelRehabilitacionContruccionesComunitarias
			.size() == 0) { throw new Exception("El año o el nivel de rehabilitación de las contrucciones comunitarias no ha aparecido correctamente"); }

		String AnyoRehabilitacion = this.webDriver.getText(this.lblAnyoRehabilitacionContruccionesComunitarias.get(0));
		String NivelRehabilitacion = this.webDriver.getText(this.lblNivelRehabilitacionContruccionesComunitarias.get(0));

		System.out.println("*** Año rehabilitacion en consulta poliza = " + AnyoRehabilitacion);
		System.out.println("*** Nivel rehabilitacion en consulta poliza = " + NivelRehabilitacion);
		System.out.println("*** Año rehabilitacion introducido en alta suplemento = "
			+ this.testDataM.getTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias"));

		Assert.assertTrue("El año de rehabilitación de construcciones comunitarias no ha aparecido correctamente", AnyoRehabilitacion
			.equals(this.testDataM.getTestVar(testId, "AnyoRehabilitacionConstruccionesComunitarias")));

		Assert.assertTrue("El nivel de rehabilitación de construcciones comunitarias no ha aparecido correctamente", NivelRehabilitacion
			.equals(this.testDataM.getTestVar(testId, "NivelRehabilitacionRehabilitacionConduccionesAguasComunitarias")));

		debugEnd();
	}

	// public void CheckCapitalContinente() throws Exception
	// {
	// logger.debug("BEGIN - CheckCapitalContinente");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderDatosRiesgos);
	//
	// if (this.lblCapitalContinente.size() == 0)
	// {
	// throw new Exception("El capital continente no ha aparecido
	// correctamente");
	// }
	//
	// Number capitalContiente =
	// this.nf.parse(this.wh.GetTextFromWebElement(this.lblCapitalContinente.get(0)));
	//
	// Assert.assertTrue("El capital contiente no ha aparecido correctamente",
	// this.nf.format(capitalContiente).toString().equals(this.nf.format(this.browserContext.getTestCaseData().getCapitalContinente()).toString()));
	//
	// logger.debug("END - CheckCapitalContinente");
	// }

	// public void CheckConstructionYear() throws Exception
	// {
	// logger.debug("BEGIN - CheckConstructionYear");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderDatosRiesgos);
	//
	// if (this.lblConstrucionYear.size() == 0)
	// {
	// throw new Exception("El año de construcción no ha aparecido
	// correctamente");
	// }
	//
	// String constructionYear =
	// this.wh.GetTextFromWebElement(this.lblConstrucionYear.get(0));
	//
	// Assert.assertTrue("El año de construcción no ha aparecido correctamente",
	// constructionYear.contains(this.browserContext.getTestCaseData().getAnyoConstruccion()));
	//
	// logger.debug("END - CheckConstructionYear");
	// }
	// endregion

	// public void CheckCapitalContenido() throws Exception
	// {
	// logger.debug("BEGIN - CheckCapitalContenido");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderDatosRiesgos);
	//
	// if (this.lblCapitalContenido.size() == 0)
	// {
	// throw new Exception("El capital contenido no ha aparecido
	// correctamente");
	// }
	//
	// Number capitalContenido =
	// this.nf.parse(this.wh.GetTextFromWebElement(this.lblCapitalContenido.get(0)));
	//
	// Assert.assertTrue("El capital contenido no ha aparecido correctamente",
	// this.nf.format(capitalContenido).toString().equals(this.nf.format(this.browserContext.getTestCaseData().getCapitalContenido()).toString()));
	//
	// logger.debug("END - CheckCapitalContenido");
	// }

	// public void CheckClausulasHipotecarias() throws Exception
	// {
	// logger.debug("BEGIN - CheckClausulasHipotecarias");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderClausulas);
	//
	// if (this.lblClausulasHipotecarias.size() == 0)
	// {
	// throw new Exception("La clausula hipotecaria no ha aparecido
	// correctamente");
	// }
	//
	// this.wh.ExitFromFrame();
	// logger.debug("END - CheckClausulasHipotecarias");
	// }

	// public void CheckTextAppearsInDatosRiesgo(String message) throws
	// Exception
	// {
	// logger.debug("BEGIN - CheckCalefaccionCentral");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderDatosRiesgos);
	//
	// List<WebElement> lblMessage =
	// this.browserContext.GetWebDriver().findElements(By.xpath(".//*[contains(text(),'"
	// + message + "')]"));
	//
	// if (lblMessage.size() == 0)
	// {
	// throw new Exception("El tipo de cobertura por calefaccióm cemtral no ha
	// aparecido correctamente");
	// }
	//
	// this.wh.ExitFromFrame();
	// logger.debug("END - CheckCalefaccionCentral");
	// }

	// public void CheckEnergiaSolar() throws Exception
	// {
	// logger.debug("BEGIN - CheckEnergiaSolar");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderCoberturas);
	//
	// if (this.lblCoberturaEnergiaSolarCantidad.size() == 0)
	// {
	// throw new Exception("El tipo de cobertura por energía solar no ha
	// aparecido correctamente");
	// }
	//
	// String energíaSolarCantidad =
	// this.wh.GetTextFromWebElement(this.lblCoberturaEnergiaSolarCantidad.get(0));
	//
	// Assert.assertTrue("El tipo cobertura energía solar no ha aparecido
	// correctamente",
	// energíaSolarCantidad.contains(String.valueOf(this.browserContext.getTestCaseData().getInstalacionesFotovoltaicasValor())));
	//
	// logger.debug("END - CheckEnergiaSolar");
	// }

	// public void CheckMaquinaria() throws Exception
	// {
	// logger.debug("BEGIN - CheckMaquinaria");
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderCoberturas);
	//
	// if (this.lblCoberturaMaquinariaCantidad.size() == 0)
	// {
	// throw new Exception("El tipo de cobertura por maquinaria no ha aparecido
	// correctamente");
	// }
	//
	// String maquinariaCantidad =
	// this.wh.GetTextFromWebElement(this.lblCoberturaMaquinariaCantidad.get(0));
	//
	// Assert.assertTrue("El tipo cobertura maquinaria no ha aparecido
	// correctamente",
	// maquinariaCantidad.contains(String.valueOf(this.browserContext.getTestCaseData().getModifieedCoberturaMaquinariaValor())));
	//
	// logger.debug("END - CheckMaquinaria");
	// }

	// public void CheckDescuento(boolean pressent) throws Exception
	// {
	// logger.debug("BEGIN - CheckDescuento");
	//
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderImportes);
	//
	// if (pressent)
	// {
	// if (this.lblTipoDescuento.size() == 0 || this.lblCantidadDescuento.size()
	// == 0)
	// {
	// throw new Exception("El tipo de descuento no ha aparecido
	// correctamente");
	// }
	//
	// String tipoDescuento =
	// this.wh.GetTextFromWebElement(this.lblTipoDescuento.get(0));
	// String cantidadDescuento =
	// this.wh.GetTextFromWebElement(this.lblCantidadDescuento.get(0));
	//
	// this.df.format(Long.valueOf(MutuaPropietariosConstants.PorcentajeDescuentoRecargo));
	//
	// Assert.assertTrue("El tipo de descuento no ha aparecido correctamente",
	// tipoDescuento.equals(MutuaPropietariosConstants.TipoDescuento));
	// Assert.assertTrue("La cantidad de descuento no ha aparecido
	// correctamente",
	// cantidadDescuento.equals(this.df.format(Long.valueOf(MutuaPropietariosConstants.PorcentajeDescuentoRecargo))));
	// }
	// else
	// {
	// if (this.lblTipoDescuento.size() != 0 || this.lblCantidadDescuento.size()
	// != 0)
	// {
	// throw new Exception("El tipo de descuento no ha aparecido
	// correctamente");
	// }
	//
	// Assert.assertTrue("El tipo de descuento no ha desaparecido
	// correctamente", this.lblTipoDescuento.size() != 0);
	// Assert.assertTrue("La cantidad de descuento no ha desaparecido
	// correctamente", this.lblCantidadDescuento.size() != 0);
	// }
	// logger.debug("END - CheckDescuento");
	// }

	// public void CheckRecargo(boolean pressent) throws Exception
	// {
	// logger.debug("BEGIN - CheckRecargo");
	//
	// this.wh.SwitchToFrame(this.cuerpoFrame);
	// this.wh.ClickOnWebElement(this.tabHeaderImportes);
	//
	// if (pressent)
	// {
	// if (this.lblTipoDescuento.size() == 0 || this.lblCantidadDescuento.size()
	// == 0)
	// {
	// throw new Exception("El tipo de recargo no ha aparecido correctamente");
	// }
	//
	// String tipoDescuento =
	// this.wh.GetTextFromWebElement(this.lblTipoDescuento.get(0));
	// String cantidadDescuento =
	// this.wh.GetTextFromWebElement(this.lblCantidadDescuento.get(0));
	//
	// this.df.format(Long.valueOf(MutuaPropietariosConstants.PorcentajeDescuentoRecargo));
	//
	// Assert.assertTrue("El tipo de recargo no ha aparecido correctamente",
	// tipoDescuento.equals(MutuaPropietariosConstants.TipoRecargo));
	// Assert.assertTrue("La cantidad de recargo no ha aparecido correctamente",
	// cantidadDescuento.equals(this.df.format(Long.valueOf(MutuaPropietariosConstants.PorcentajeDescuentoRecargo))));
	// }
	// else
	// {
	// Assert.assertTrue("El tipo de descuento no ha desaparecido
	// correctamente", this.lblTipoDescuento.get(0).getText().equals(""));
	// Assert.assertTrue("La cantidad de descuento no ha desaparecido
	// correctamente",
	// this.lblCantidadDescuento.get(0).getText().equals("0,00"));
	// }
	// logger.debug("END - CheckRecargo");
	// }
}
