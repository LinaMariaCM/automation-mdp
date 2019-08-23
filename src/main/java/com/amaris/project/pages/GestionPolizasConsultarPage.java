package com.amaris.project.pages;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ClausulasHelper;

public class GestionPolizasConsultarPage extends PageObject {

	DecimalFormat df = new DecimalFormat("#.00");
	Locale locale = new Locale("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(locale);

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By txtHeaderPolicyNumber = By.xpath(".//*[contains(text(),'Póliza:')]");
	private By tabHeaderClausulas = By.xpath(".//*[@id='pesClausulas']/span");
	private By tabHeaderImportes = By.xpath(".//*[@id='pesImportes']/span");
	private By tabHeaderCoberturas = By.xpath(".//*[@id='pesCoberturas']/span");
	private By tabHeaderDatosRiesgos = By.cssSelector("#pesDatosRiesgo > span");

	private By rowWithClausula = By.xpath(".//*[@id='capaClausulas']//tr[td]");

	private By lblTipoDescuento = By.xpath(".//tr[td/strong[text()='Tipo Descuento:']]/td[4]");
	private By lblCoberturaMaquinariaCantidad = By.xpath(".//tr[td[text()='Rotura de maquinaria']]/td[3]");
	private By lblCantidadDescuento = By.xpath(".//tr[td/strong[text()='Descuento:']]/td[4]");
	private By lblCoberturaEnergiaSolarCantidad = By.xpath(".//tr[td[text()='Rotura de instalaciones de energía solar fotovoltaica']]/td[3]");
	private By lblClausulasHipotecarias = By.xpath(".//*[contains(text(),'Queda excluida la Responsabilidad Civil derivada de los alfeices de la cubierta por riesgo de desprendimientos')]");
	private By lblCapitalContenido = By.xpath(".//tr[td/strong[text()='Capital contenido:']]/td[2]");
	private By lblCapitalContinente = By.xpath(".//tr[td/strong[text()='Capital continente:']]/td[2]");
	private By lblConstrucionYear = By.xpath(".//tr[td/strong[text()='Año construcción:']]/td[2]");
	private By lblLocalesExluidos = By.xpath(".//*[contains(text(),'Locales excluidos')]");
	private By lblDepositoCombustible = By.xpath(".//*[contains(text(),'Depósito de combustible superior a 3000 l')]");
	private By lblCalefaccionCentral = By.xpath(".//*[contains(text(),' Calefacción central y/o agua caliente)')]");
	private By lblM2ContruidosTotales = By.xpath(".//tr[td/strong[text()='M2 Construidos Totales:']]/td[2]");
	private By lblAnyoRehabConstructiones = By.xpath(".//tr[td/strong[text()='Año rehabilitación conducciones de aguas comunitarias:']]/td[2]");
	private By lblNivelRehabConstrucciones = By.xpath(".//tr[td/strong[text()='Nivel de rehabilitación conducciones de aguas comunitarias:']]/td[4]");
	private By lblAnyoRehabilitacionIntegral = By.xpath(".//tr[td/strong[text()='Año rehabilitación integral:']]/td[2]");
	private By lblCalidadConstruccion = By.xpath(".//tr[td/strong[text()='Calidad de la construcción:']]/td[4]");
	private By lblCalefaccionCentralYAguaCaliente = By.xpath(".//*[text()='Calefacción central y/o agua caliente']");

	private String xPathFilterClausulaText = ".//td[3]";
	private String xPathFilterClausulaNumber = ".//td[2]";

	// endregion

	public GestionPolizasConsultarPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionPolizasConsultarPage CheckPolizaNumber() {
		debugBegin();

		// Get the text from the policy number shown in the header of the policy file.
		String polizaNumber = webDriver.getTextInFrame(txtHeaderPolicyNumber, cuerpoFrame);

		// Trim the text to leave just the policy number itself.
		Integer firstCharacter = polizaNumber.indexOf(':') + 2;
		Integer lastCharacter = polizaNumber.indexOf(':') + 11;
		String trimmedPolizaNumber = polizaNumber.substring(firstCharacter, lastCharacter);
		String numPolizaConsulta = trimmedPolizaNumber;

		// Compare the trimmed policy number with the policy number obtained when policy was created.
		Assert.assertEquals(getTestVar("NumPoliza"), numPolizaConsulta);

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage CheckClausulas() {
		debugBegin();

		webDriver.clickInFrame(tabHeaderClausulas, cuerpoFrame);
		List<Integer> tabPageClausulas = new ArrayList<>();

		for(WebElement element : webDriver.getElements(rowWithClausula)) {
			String numeroClausula = webDriver.getTextInFrame(element.findElement(By.xpath(xPathFilterClausulaNumber)), cuerpoFrame);
			tabPageClausulas.add(Integer.parseInt(numeroClausula));
		}

		Integer numberOfMatchesFound = ClausulasHelper.getClausulas(userS).stream().filter(p -> tabPageClausulas.contains(Integer.valueOf(p)))
			.collect(Collectors.toList()).size();

		Assert.assertTrue(numberOfMatchesFound == ClausulasHelper.getClausulas(userS)
			.size(), "Las clausulas presentes en el tab de clausulas dentro del detalle de la poliza no coinciden con las seleecionadas durante la inclusion del suplemento");

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage CheckValueInTab(String tab, String valueToBeChecked, String expectedValue) throws Exception {
		debugBegin();

		OpenTab(tab);

		By lblObjectSelector;
		String message = "";

		switch(valueToBeChecked) {
			case Constants.PolizaDetailConstructionYear:
				lblObjectSelector = lblConstrucionYear;
				message = Constants.PolizaDetailConstructionYearErrorMessage;

				break;
			case Constants.PolizaDetailCapitalContinente:
				lblObjectSelector = lblCapitalContinente;
				message = Constants.PolizaDetailCapitalContinenteErrorMessage;

				break;
			case Constants.PolizaDetailCapitalContenido:
				lblObjectSelector = lblCapitalContenido;
				message = Constants.PolizaDetailCapitalContenidoErororMessage;

				break;
			case Constants.PolizaDetailNuevaClausulaHipotecaria:
				lblObjectSelector = lblClausulasHipotecarias;
				message = Constants.PolizaDetailNuevaClausulaHipotecariaErrorMessage;

				break;
			case Constants.PolizaDetailLocalesExcluidos:
				lblObjectSelector = lblLocalesExluidos;
				message = Constants.PolizaDetailLocalesExcluidosErrorMessage;

				break;
			case Constants.PolizaDetailCalefaccionCentral:
				lblObjectSelector = lblCalefaccionCentral;
				message = Constants.PolizaDetailCalefaccionCentralErrorMessage;

				break;
			case Constants.PolizaDetailPlacaSolar:
				lblObjectSelector = lblCoberturaEnergiaSolarCantidad;
				message = Constants.PolizaDetailPlacaSolarErrorMessage;

				break;
			case Constants.PolizaDetailMaquinaria:
				lblObjectSelector = lblCoberturaMaquinariaCantidad;
				message = Constants.PolizaDetailMaquinariaErrorMessage;

				break;
			case Constants.PolizaDetailDescuento:
			case Constants.PolizaDetailNoDescuento:
				lblObjectSelector = lblTipoDescuento;
				message = Constants.PolizaDetailDescuentoErrorMessage;

				break;
			case Constants.PolizaDetailDescuentoValue:
				lblObjectSelector = lblCantidadDescuento;
				message = Constants.PolizaDetailDescuentoValueErrorMessage;

				break;
			case Constants.PolizaDetailRecargo:
				lblObjectSelector = lblCantidadDescuento;
				message = Constants.PolizaDetailRecargoErrorMessage;

				break;
			case Constants.PolizaDetailM2ConstruidosTotales:
				lblObjectSelector = lblM2ContruidosTotales;
				message = Constants.PolizaDetailM2ConstruidosTotalesErrorMessage;

				break;
			case Constants.PolizaDetailYearRehabilitacionIntegral:
				lblObjectSelector = lblAnyoRehabilitacionIntegral;
				message = Constants.PolizaDetailYearRehabilitacionIntegralErrorMessage;

				break;
			case Constants.PolizaDetailCalidadConstruccion:
				lblObjectSelector = lblCalidadConstruccion;
				message = Constants.PolizaDetailCalidadConstruccionMessage;

				break;
			default:
				throw new Exception("El valor seleccionado para comprobar no está implementado");
		}

		List<WebElement> lblObjectCollection = webDriver.getElementsInFrame(lblObjectSelector, cuerpoFrame);

		// the value has to exist and to have an specific value
		if(expectedValue != null && !expectedValue.equals(Constants.DescuentoRecargoNotSpecified)) {
			if(lblObjectCollection.isEmpty()) { throw new Exception(message); }

			String value = webDriver.getText(lblObjectCollection.get(0));
			Assert.assertTrue(value.equals(expectedValue), message);
		} else if(expectedValue == null && !lblObjectCollection.isEmpty()) {
			// The value doesn't have to exist
			throw new Exception(message);
		} else if(expectedValue.equals(Constants.DescuentoRecargoNotSpecified) && !lblObjectCollection.isEmpty()) {
			// The value has to exist only
			throw new Exception(message);
		}

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage OpenTab(String tabName) throws Exception {
		debugBegin();

		switch(tabName) {
			case Constants.PolizaDetailTabDetallesRiesgo:
				webDriver.clickInFrame(tabHeaderDatosRiesgos, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabClausulas:
				webDriver.clickInFrame(tabHeaderClausulas, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabImportes:
				webDriver.clickInFrame(tabHeaderImportes, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabCoberturas:
				webDriver.clickInFrame(tabHeaderCoberturas, cuerpoFrame);

				break;
			default:
				throw new Exception("El tab seleccionado no está implementado");
		}

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage CheckAnyoAndNivelRehabilitacion() throws Exception {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		webDriver.click(tabHeaderDatosRiesgos);

		List<WebElement> anyoRehab = webDriver.getElementsInFrame(lblAnyoRehabConstructiones, cuerpoFrame);
		List<WebElement> nivelRehab = webDriver.getElementsInFrame(lblNivelRehabConstrucciones, cuerpoFrame);

		if(anyoRehab.isEmpty()
			|| nivelRehab.isEmpty()) { throw new Exception("El año o el nivel de rehabilitación de las contrucciones comunitarias no ha aparecido correctamente"); }

		String anyoRehabilitacion = webDriver.getText(anyoRehab.get(0));
		String nivelRehabilitacion = webDriver.getText(nivelRehab.get(0));

		debugInfo("*** Año rehabilitacion en consulta poliza = " + anyoRehabilitacion);
		debugInfo("*** Nivel rehabilitacion en consulta poliza = " + nivelRehabilitacion);
		debugInfo("*** Año rehabilitacion introducido en alta suplemento = "
			+ getTestVar("AnyoRehabilitacionConstruccionesComunitarias"));

		Assert.assertTrue(anyoRehabilitacion
			.equals(getTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES)), "El año de rehabilitación de construcciones comunitarias no ha aparecido correctamente");

		Assert.assertTrue(nivelRehabilitacion
			.equals(getTestVar(Constants.NIVEL_REHAB_AGUAS)), "El nivel de rehabilitación de construcciones comunitarias no ha aparecido correctamente");

		debugEnd();

		return this;
	}
	// endregion
}
