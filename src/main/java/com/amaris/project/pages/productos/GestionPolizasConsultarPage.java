package com.amaris.project.pages.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.utils.ClausulasHelper;

public class GestionPolizasConsultarPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	private By headerPolicyNumberTxt = By.xpath(".//*[contains(text(),'Póliza:')]");
	private By headerClausulasBtn = By.xpath(".//*[@id='pesClausulas']/span");
	private By tabHeaderImportes = By.xpath(".//*[@id='pesImportes']/span");
	private By tabHeaderCoberturas = By.xpath(".//*[@id='pesCoberturas']/span");
	private By tabHeaderDatosRiesgos = By.cssSelector("#pesDatosRiesgo > span");

	private By clausulaRow = By.xpath(".//*[@id='capaClausulas']//tr[td]");

	private By tipoDescuentoTxt = By.xpath(".//tr[td/strong[text()='Tipo Descuento:']]/td[4]");
	private By coberturaMaquinariaCantidadTxt = By.xpath(".//tr[td[text()='Rotura de maquinaria']]/td[3]");
	private By cantidadDescuentoTxt = By.xpath(".//tr[td/strong[text()='Descuento:']]/td[4]");
	private By coberturaEnergiaSolarCantidadTxt = By.xpath(".//tr[td[text()='Rotura de instalaciones de energía solar fotovoltaica']]/td[3]");
	private By clausulasHipotecariasTxt = By.xpath(".//*[contains(text(),'Queda excluida la Responsabilidad Civil derivada de los alfeices de la cubierta por riesgo de desprendimientos')]");
	private By capitalContenidoTxt = By.xpath(".//tr[td/strong[text()='Capital contenido:']]/td[2]");
	private By capitalContinenteTxt = By.xpath(".//tr[td/strong[text()='Capital continente:']]/td[2]");
	private By construcionYearTxt = By.xpath(".//tr[td/strong[text()='Año construcción:']]/td[2]");
	private By localesExluidosTxt = By.xpath(".//*[contains(text(),'Locales excluidos')]");
	private By calefaccionCentralTxt = By.xpath(".//*[contains(text(),' Calefacción central y/o agua caliente)')]");
	private By m2ContruidosTotalesTxt = By.xpath(".//tr[td/strong[text()='M2 Construidos Totales:']]/td[2]");
	private By lblAnyoRehabConstructiones = By.xpath(".//tr[td/strong[text()='Año rehabilitación conducciones de aguas comunitarias:']]/td[2]");
	private By lblNivelRehabConstrucciones = By.xpath(".//tr[td/strong[text()='Nivel de rehabilitación conducciones de aguas comunitarias:']]/td[4]");
	private By anyoRehabilitacionIntegralTxt = By.xpath(".//tr[td/strong[text()='Año rehabilitación integral:']]/td[2]");
	private By calidadConstruccionTxt = By.xpath(".//tr[td/strong[text()='Calidad de la construcción:']]/td[4]");

	private By clausulaNumberTxt = By.xpath(".//td[2]");
	// endregion

	public GestionPolizasConsultarPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public GestionPolizasConsultarPage checkPolizaNumber() {
		debugBegin();

		String polizaNumber = webDriver.getTextInFrame(headerPolicyNumberTxt, cuerpoFrame);
		polizaNumber = polizaNumber.substring(polizaNumber.indexOf(':') + 2, polizaNumber.indexOf(':') + 11);

		Assert.assertEquals(getTestVar(Constants.NUM_POLIZA), polizaNumber);

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage checkClausulas() {
		debugBegin();

		webDriver.clickInFrame(headerClausulasBtn, cuerpoFrame);
		List<Integer> tabPageClausulas = new ArrayList<>();

		for(WebElement element : webDriver.getElements(clausulaRow)) {
			String numeroClausula = webDriver.getTextInFrame(element.findElement(clausulaNumberTxt), cuerpoFrame);

			tabPageClausulas.add(Integer.parseInt(numeroClausula));
		}

		Integer numberOfMatchesFound = ClausulasHelper.getClausulas(userS).stream().filter(p -> tabPageClausulas.contains(Integer.valueOf(p)))
			.collect(Collectors.toList()).size();

		Assert.assertTrue(numberOfMatchesFound == ClausulasHelper.getClausulas(userS)
			.size(), "Las clausulas presentes en el tab de clausulas dentro del detalle de la poliza no coinciden con las seleecionadas durante la inclusion del suplemento");

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage checkValueInTab(String tab, String valueToBeChecked, String expectedValue) throws Exception {
		debugBegin();

		openTab(tab);

		By objectSelectorTxt;
		String message = "";

		switch(valueToBeChecked) {
			case Constants.PolizaDetailConstructionYear:
				objectSelectorTxt = construcionYearTxt;
				message = Constants.PolizaDetailConstructionYearErrorMessage;

				break;
			case Constants.PolizaDetailCapitalContinente:
				objectSelectorTxt = capitalContinenteTxt;
				message = Constants.PolizaDetailCapitalContinenteErrorMessage;

				break;
			case Constants.PolizaDetailCapitalContenido:
				objectSelectorTxt = capitalContenidoTxt;
				message = Constants.PolizaDetailCapitalContenidoErororMessage;

				break;
			case Constants.PolizaDetailNuevaClausulaHipotecaria:
				objectSelectorTxt = clausulasHipotecariasTxt;
				message = Constants.PolizaDetailNuevaClausulaHipotecariaErrorMessage;

				break;
			case Constants.PolizaDetailLocalesExcluidos:
				objectSelectorTxt = localesExluidosTxt;
				message = Constants.PolizaDetailLocalesExcluidosErrorMessage;

				break;
			case Constants.PolizaDetailCalefaccionCentral:
				objectSelectorTxt = calefaccionCentralTxt;
				message = Constants.PolizaDetailCalefaccionCentralErrorMessage;

				break;
			case Constants.PolizaDetailPlacaSolar:
				objectSelectorTxt = coberturaEnergiaSolarCantidadTxt;
				message = Constants.PolizaDetailPlacaSolarErrorMessage;

				break;
			case Constants.PolizaDetailMaquinaria:
				objectSelectorTxt = coberturaMaquinariaCantidadTxt;
				message = Constants.PolizaDetailMaquinariaErrorMessage;

				break;
			case Constants.PolizaDetailDescuento:
			case Constants.PolizaDetailNoDescuento:
				objectSelectorTxt = tipoDescuentoTxt;
				message = Constants.PolizaDetailDescuentoErrorMessage;

				break;
			case Constants.PolizaDetailDescuentoValue:
				objectSelectorTxt = cantidadDescuentoTxt;
				message = Constants.PolizaDetailDescuentoValueErrorMessage;

				break;
			case Constants.PolizaDetailRecargo:
				objectSelectorTxt = cantidadDescuentoTxt;
				message = Constants.PolizaDetailRecargoErrorMessage;

				break;
			case Constants.PolizaDetailM2ConstruidosTotales:
				objectSelectorTxt = m2ContruidosTotalesTxt;
				message = Constants.PolizaDetailM2ConstruidosTotalesErrorMessage;

				break;
			case Constants.PolizaDetailYearRehabilitacionIntegral:
				objectSelectorTxt = anyoRehabilitacionIntegralTxt;
				message = Constants.PolizaDetailYearRehabilitacionIntegralErrorMessage;

				break;
			case Constants.PolizaDetailCalidadConstruccion:
				objectSelectorTxt = calidadConstruccionTxt;
				message = Constants.PolizaDetailCalidadConstruccionMessage;

				break;
			default:
				throw new Exception("El valor seleccionado para comprobar no está implementado");
		}

		List<WebElement> txtObjectCollection = webDriver.getElementsInFrame(objectSelectorTxt, cuerpoFrame);

		if(expectedValue != null && !expectedValue.equals(Constants.DescuentoRecargoNotSpecified)) {
			if(txtObjectCollection.isEmpty()) { throw new Exception(message); }

			String value = webDriver.getText(txtObjectCollection.get(0));
			Assert.assertTrue(value.equals(expectedValue), message);
		} else if(expectedValue == null && !txtObjectCollection.isEmpty()) {
			throw new Exception(message);
		} else if(expectedValue != null && expectedValue.equals(Constants.DescuentoRecargoNotSpecified) && !txtObjectCollection.isEmpty()) { throw new Exception(message); }

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage openTab(String tabName) {
		debugBegin();

		switch(tabName) {
			case Constants.PolizaDetailTabDetallesRiesgo:
				webDriver.clickInFrame(tabHeaderDatosRiesgos, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabClausulas:
				webDriver.clickInFrame(headerClausulasBtn, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabImportes:
				webDriver.clickInFrame(tabHeaderImportes, cuerpoFrame);

				break;
			case Constants.PolizaDetailTabCoberturas:
				webDriver.clickInFrame(tabHeaderCoberturas, cuerpoFrame);

				break;
			default:
		}

		debugEnd();

		return this;
	}

	public GestionPolizasConsultarPage checkAnyoAndNivelRehabilitacion() throws Exception {
		debugBegin();

		webDriver.clickInFrame(tabHeaderDatosRiesgos, cuerpoFrame);

		List<WebElement> anyoRehab = webDriver.getElementsInFrame(lblAnyoRehabConstructiones, cuerpoFrame);
		List<WebElement> nivelRehab = webDriver.getElementsInFrame(lblNivelRehabConstrucciones, cuerpoFrame);

		if(anyoRehab.isEmpty() || nivelRehab.isEmpty()) { throw new Exception("El año o el nivel de rehabilitación de las contrucciones comunitarias no ha aparecido correctamente"); }

		String anyoRehabilitacion = webDriver.getTextInFrame(anyoRehab.get(0), cuerpoFrame);
		String nivelRehabilitacion = webDriver.getTextInFrame(nivelRehab.get(0), cuerpoFrame);

		debugInfo("Año rehabilitacion en consulta poliza = " + anyoRehabilitacion);
		debugInfo("Nivel rehabilitacion en consulta poliza = " + nivelRehabilitacion);
		debugInfo("Año rehabilitacion introducido en alta suplemento = " + getTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES));

		Assert.assertTrue(anyoRehabilitacion
			.equals(getTestVar(Constants.ANYO_REHAB_CONSTRUCCIONES)), "El año de rehabilitación de construcciones comunitarias no ha aparecido correctamente");

		Assert.assertTrue(nivelRehabilitacion
			.equals(getTestVar(Constants.NIVEL_REHAB_AGUAS)), "El nivel de rehabilitación de construcciones comunitarias no ha aparecido correctamente");

		debugEnd();

		return this;
	}
	// endregion
}
