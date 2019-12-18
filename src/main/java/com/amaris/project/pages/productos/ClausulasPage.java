package com.amaris.project.pages.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.ClausulasHelper;
import com.amaris.project.Constants;

public class ClausulasPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");

	// Rows with a checkbox and a clausula
	private By rowWithClausula = By.xpath(".//tr[td[input]]");
	private List<WebElement> rowWithClausulaList;

	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");
	private By btnAddClausulaHipotecaria = By.xpath(".//*[text()='Añadir cláusula y/o hipotecaria']");
	private By btnTabClausulaHipotecaria = By.xpath(".//*[text()='Cláusula hipotecaria']");

	private By cmbTipoDocumento = By.id("tipodocumento");
	private By txtNumeroDocumento = By.name("numerodocumento");

	private By txtNombreAsegurado = By.id("nombreasegurado");
	private By txtApellido1Asegurado = By.id("apellido1asegurado");
	private By txtApellido2Asegurado = By.id("apellido2asegurado");
	private By cmbDireccionRiesgo = By.id("direccionriesgo");
	private By cmbEntidadBancaria = By.id("entidadbancaria");
	private By txtCoheficienteParticipacion = By.id("coefparticipacion");

	private By btnAddClausula = By.xpath(".//*[text()='Añadir cláusula' and @ng-click='cp.insertarClausula()']");
	private By btnContinuarInEdition = By.xpath(".//*[@title='Continuar']");
	private By btnContinuarInCreation = By.xpath(".//*[text()='Continuar']");
	private By btnNextClausulasPage = By.xpath(".//*[@ng-click='control.update(control.current + 1)']");

	private By rowCheckboxWithCoberturaOpcional = By.xpath(".//tr[td[input]]");
	private List<WebElement> rowCheckboxWithCoberturaOpcionalList;

	private String xPathFilterClausulaCheckbox = ".//td[2]/input";
	private String xPathFilterClausulaText = ".//td[6]";
	private String xPathFilterClausulaNumber = ".//td[4]";
	private List<ClausulasHelper> clausulas = new ArrayList<>();
	// endregion

	public ClausulasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ClausulasPage activateclausesAndClickOnContinue() {
		activateClauses();
		completarClausulaHipotecaria();
		clickOnContinuar();

		return this;
	}

	public ClausulasPage clickOnContinuar() {
		debugBegin();

		if(Boolean.parseBoolean(getTestVar(Constants.INFRA_SEGURO)) && !isClausulaSelected(102)) {
			try {
				debugError("La clausula 102 no se ha seleccionado al crear un infraseguro");
			} catch(Exception e) {
				setTestVar("mensaje_error", "La clausula 102 no se ha seleccionado al crear un infraseguro");
				// webDriver.getScenario().write("La clausula 102 no se ha
				// seleccionado al crear un infraseguro");
			}
		}
		webDriver.switchToFrame(cuerpoFrame);
		// webDriver.waitForPageLoadWithAngular();
		// cuerpoFrame.click();
		webDriver.scrollToBottom();
		webDriver.waitWithDriver(4000);
		webDriver.click(btnContinuarInCreation);
		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	public ClausulasPage activateClauses() {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);

		if(getConfigVar("ModificarClausulas").equals(Constants.ModificarClausulas)) {
			for(int pageNumber = 1; pageNumber < 6; pageNumber++) {
				activateClausesInPage(pageNumber);

				if(!existToBeActivatedClauses()) {
					break;
				} else {
					webDriver.scrollToBottom();
					webDriver.click(btnNextClausulasPage);
				}
			}
		}

		webDriver.exitFrame();

		debugEnd();

		return this;
	}

	private List<ClausulasHelper> getClausulasInPage(Integer pageNumber) {
		debugBegin();

		webDriver.switchToFrame(cuerpoFrame);
		// webDriver.waitForPageLoadWithAngular();

		List<ClausulasHelper> clausulasTemp = new ArrayList<>();

		rowWithClausulaList.forEach(p -> {
			// By element =
			// p.findElement(By.xpath(xPathFilterClausulaCheckbox));
			if(webDriver.isSelected(By.xpath(xPathFilterClausulaCheckbox))) {
				clausulasTemp.add(new ClausulasHelper(pageNumber, true,
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + xPathFilterClausulaText)),
					webDriver.getElement(By.xpath(xPathFilterClausulaCheckbox))));
				// clausulasTemp.add(new ClausulasHelper(pageNumber, true,
				// p.findElement(By.xpath(xPathFilterClausulaNumber)).getText(),
				// p.findElement(By.xpath(xPathFilterClausulaText)).getText(),
				// element));
			} else {
				clausulasTemp.add(new ClausulasHelper(pageNumber, false,
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + xPathFilterClausulaText)),
					webDriver.getElement(By.xpath(xPathFilterClausulaCheckbox))));
				// clausulasTemp.add(new ClausulasHelper(pageNumber, false,
				// p.findElement(By.xpath(xPathFilterClausulaNumber)).getText(),
				// p.findElement(By.xpath(xPathFilterClausulaText)).getText(),
				// element));
			}
		});

		webDriver.exitFrame();

		debugEnd();

		return clausulasTemp;
	}

	private ClausulasPage activateClausesInPage(Integer pageNumber) {
		debugBegin();

		clausulas.addAll(getClausulasInPage(pageNumber));

		for(ClausulasHelper clausula : clausulas) {
			if(!clausula.getSelected() && ClausulasHelper.getClausulas(userS).contains(clausula.getNumber())) {
				webDriver.clickInFrame(clausula.getCheckbox(), cuerpoFrame);
				clausula.setSelected(true);
			}
		}

		debugEnd();

		return this;
	}

	private boolean existToBeActivatedClauses() {
		boolean check = false;

		List<ClausulasHelper> clausulasTemp = clausulas.stream()
			.filter(p -> ClausulasHelper.getClausulas(userS).contains(p.getNumber()) && p.getSelected())
			.collect(Collectors.toList());

		if(clausulasTemp.size() != ClausulasHelper.getClausulas(userS).size()) {
			check = true;
		}

		return check;
	}

	private String getClausulaStatusInPage(int Clausula, int pageNumber) {
		debugBegin();

		clausulas.addAll(getClausulasInPage(pageNumber));

		List<ClausulasHelper> clausulasfound = clausulas.stream().filter(p -> p.getNumber().equals(Integer.toString(Clausula)))
			.collect(Collectors.toList());

		if(clausulasfound.size() == 1) {
			if(clausulasfound.get(0).getSelected()) {
				return Constants.ClausulaEncontradaYSeleccionada;
			} else {
				return Constants.ClausulaEncontradaYNoSeleccionada;
			}
		}

		debugEnd();

		return Constants.ClausulaNoEncontrada;
	}

	public boolean isClausulaSelected(Integer clausula) {
		debugBegin();

		boolean result = false;

		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {
			String clausulaSelected = getClausulaStatusInPage(clausula, pageNumber);

			if(clausulaSelected.equals(Constants.ClausulaEncontradaYSeleccionada)) {
				result = true;
				break;
			} else if(clausulaSelected.equals(Constants.ClausulaEncontradaYNoSeleccionada)) {
				break;
			}

			webDriver.clickInFrame(btnNextClausulasPage, cuerpoFrame);
		}

		debugEnd();

		return result;
	}

	public ClausulasPage completarClausulaHipotecaria() {

		if(Boolean.parseBoolean(userS.getTestVar("clausula_hipotecaria"))) {
			webDriver.switchToFrame(this.cuerpoFrame);
			webDriver.click(this.btnAddClausulaHipotecaria);
			webDriver.click(this.btnTabClausulaHipotecaria);
			webDriver.clickElementFromDropDownByText(this.cmbTipoDocumento, Constants.NIF);
			webDriver.appendText(this.txtNumeroDocumento, DniGeneratorHelper.generateNif());
			webDriver.appendText(this.txtNombreAsegurado, Constants.ClausulaHipotecariaNombre);
			webDriver.appendText(this.txtApellido1Asegurado, Constants.ClausulaHipotecariaApellido1);
			webDriver.appendText(this.txtApellido2Asegurado, Constants.ClausulaHipotecariaApellido2);
			webDriver.clickElementFromDropDownByIndex(this.cmbDireccionRiesgo, 0);
			webDriver.clickElementFromDropDownByText(this.cmbEntidadBancaria, Constants.ClausulaHipotecariaEntidadBancaria);
			webDriver.appendText(this.txtCoheficienteParticipacion, Constants.ClausulaHipotecariaCoheficienteParticipacion);
			webDriver.tabulateElement(this.txtCoheficienteParticipacion);
			webDriver.click(this.btnAddClausula);
			webDriver.exitFrame();
		}

		return this;
	}

}