package com.amaris.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.ClausulasHelper;
import com.amaris.project.ProjectConstants;

public class ClausulasPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	// Rows with a checkbox and a clausula
	// @FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowWithClausula;

	// @FindBy(xpath = ".//*[@class='pagination' and
	// ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private By clausulaPageSelector = By.xpath(".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]");

	// @FindBy(xpath = ".//*[text()='Añadir cláusula y/o hipotecaria']")
	private By btnAddClausulaHipotecaria = By.xpath(".//*[text()='Añadir cláusula y/o hipotecaria']");

	// @FindBy(xpath = ".//*[text()='Cláusula hipotecaria']")
	private By btnTabClausulaHipotecaria = By.xpath(".//*[text()='Cláusula hipotecaria']");

	// @FindBy(id = "tipodocumento")
	private By cmbTipoDocumento = By.id("tipodocumento");

	// @FindBy(name = "numerodocumento")
	private By txtNumeroDocumento = By.name("numerodocumento");

	// @FindBy(id = "nombreasegurado")
	private By txtNombreAsegurado = By.id("nombreasegurado");

	// @FindBy(id = "apellido1asegurado")
	private By txtApellido1Asegurado = By.id("apellido1asegurado");

	// @FindBy(id = "apellido2asegurado")
	private By txtApellido2Asegurado = By.id("apellido2asegurado");

	// @FindBy(id = "direccionriesgo")
	private By cmbDireccionRiesgo = By.id("direccionriesgo");

	// @FindBy(id = "entidadbancaria")
	private By cmbEntidadBancaria = By.id("entidadbancaria");

	// @FindBy(id = "coefparticipacion")
	private By txtCoheficienteParticipacion = By.id("coefparticipacion");

	// @FindBy(xpath = ".//*[text()='Añadir cláusula' and
	// @ng-click='cp.insertarClausula()']")
	private By btnAddClausula = By.xpath(".//*[text()='Añadir cláusula' and @ng-click='cp.insertarClausula()']");

	// @FindBy(xpath = ".//*[@title='Continuar']")
	private By btnContinuarInEdition = By.xpath(".//*[@title='Continuar']");

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuarInCreation = By.xpath(".//*[text()='Continuar']");

	// @FindBy(xpath = ".//*[@ng-click='control.update(control.current + 1)']")
	private By btnNextClausulasPage = By.xpath(".//*[@ng-click='control.update(control.current + 1)']");

	// @FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowCheckboxWithCoberturaOpcional;

	private String xPathFilterClausulaCheckbox = ".//td[2]/input";
	// private String cssFilterSelectedCheckboxes =
	// "input:checked[type=checkbox]";
	private String xPathFilterClausulaText = ".//td[6]";
	private String xPathFilterClausulaNumber = ".//td[4]";
	private List<ClausulasHelper> clausulas = new ArrayList<>();
	// endregion

	public ClausulasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ClausulasPage activateclausesAndClickOnContinue() throws Exception {
		activateClauses();
		completarClausulaHipotecaria();
		clickOnContinuar();

		return this;
	}

	public ClausulasPage clickOnContinuar() throws Exception {
		debugBegin();

		if(Boolean.parseBoolean(getTestVar("infra_seguro"))) {
			if(!isClausulaSelected(102)) {
				try {
					throw new Exception("La clausula 102 no se ha seleccionado al crear un infraseguro");
				} catch(Exception e) {
					setTestVar("mensaje_error", "La clausula 102 no se ha seleccionado al crear un infraseguro");
					// webDriver.getScenario().write("La clausula 102 no se
					// ha seleccionado al crear un infraseguro");
				}
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
		if(getConfigVar("ModificarClausulas").equals(ProjectConstants.ModificarClausulas)) {
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

		rowWithClausula.forEach(p -> {
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

		/*
		 * clausulas.stream().filter(p ->
		 * browserContext.getTestCaseData().getClausulas().contains(p.
		 * getNumber())).forEach(x -> { if (x.getSelected().equals(false)) {
		 * webDriver.switchToFrame(cuerpoFrame);
		 * webDriver.click(x.getCheckbox()); x.setSelected(true);
		 * webDriver.exitFrame(); } });
		 */

		// userS.getTestVar(testId,
		// "modificar_clausulas").equals(ProjectConstants.ModificarClausulas)
		// clausulas.stream().filter(p ->
		// userS.getTestVar(testId,"get_clausulas").equals(ProjectConstants.lausulas)).forEach(x
		// ->
		// clausulas.stream().filter(p ->
		// browserContext.getTestCaseData().getClausulas().contains(p.getNumber())).forEach(x
		// ->
		// for(ClausulasHelper x : clausulas)
		for(int i = 0; i <= clausulas.size(); i++) {
			ClausulasHelper x = clausulas.get(i);
			if(x.getSelected().equals(false)) {
				webDriver.switchToFrame(cuerpoFrame);
				webDriver.click(x.getCheckbox());
				x.setSelected(true);
				webDriver.exitFrame();
			}
		} ;

		debugEnd();

		return this;
	}

	private boolean existToBeActivatedClauses() {
		System.out.println("COMPLETAR");
		List<ClausulasHelper> clausulasTemp = clausulas.stream()
			.filter(p -> getTestVar("clausula").contains(p.getNumber()) && p.getSelected().equals(true))
			.collect(Collectors.toList());

		/*
		 * if (clausulasTemp.size() ==
		 * browserContext.getTestCaseData().getClausulas().size()) { return
		 * false; } else { return true; }
		 */
		boolean check = false;

		for(ClausulasHelper clausula : clausulas) {
			if(!getTestVar("clausula").contains(clausula.getNumber()) || clausula.getSelected().equals(false)) {
				check = true;
			}
		}

		return check;
	}

	private String getClausulaStatusInPage(int Clausula, int pageNumber) {
		debugBegin();

		clausulas.addAll(getClausulasInPage(pageNumber));

		List<ClausulasHelper> clausulasfound = clausulas.stream().filter(p -> p.getNumber().equals(String.valueOf(Clausula)))
			.collect(Collectors.toList());

		if(clausulasfound.size() == 1) {
			if(clausulasfound.get(0).getSelected().equals(true)) {
				return ProjectConstants.ClausulaEncontradaYSeleccionada;
			} else {
				return ProjectConstants.ClausulaEncontradaYNoSeleccionada;
			}
		}

		debugEnd();

		return ProjectConstants.ClausulaNoEncontrada;
	}

	public boolean isClausulaSelected(Integer clausula) {
		debugBegin();

		boolean result = false;

		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {
			String clausulaSelected = getClausulaStatusInPage(clausula, pageNumber);

			if(clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYSeleccionada)) {
				result = true;
				break;
			} else if(clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYNoSeleccionada)) {
				result = false;
				break;
			}

			webDriver.switchToFrame(cuerpoFrame);
			webDriver.click(btnNextClausulasPage);
			webDriver.exitFrame();
		}

		debugEnd();

		return result;
	}

	/*
	 * public boolean isClausulaHipotecaria() { return ClausulaHipotecaria;
	 * }
	 * 
	 * public void setClausulaHipotecaria(boolean clausulaHipotecaria) {
	 * ClausulaHipotecaria = clausulaHipotecaria; }
	 * 
	 * 
	 */

	public ClausulasPage completarClausulaHipotecaria() {
		/*
		 * if (browsContext.isClausulaHipotecaria()) {
		 * webDriver.switchToFrame(cuerpoFrame);
		 * webDriver.click(btnAddClausulaHipotecaria);
		 * webDriver.click(btnTabClausulaHipotecaria);
		 * webDriver.selectValueInDropDown(cmbTipoDocumento,
		 * ProjectConstants.NIF); //webDriver.select(cmbTipoDocumento,
		 * ProjectConstants.NIF);
		 * webDriver.sendValueToWebElement(txtNumeroDocumento,
		 * DniGeneratorHelper.generaNif(null));
		 * webDriver.sendValueToWebElement(txtNombreAsegurado,
		 * ProjectConstants.ClausulaHipotecariaNombre);
		 * webDriver.sendValueToWebElement(txtApellido1Asegurado,
		 * ProjectConstants.ClausulaHipotecariaApellido1);
		 * webDriver.sendValueToWebElement(txtApellido2Asegurado,
		 * ProjectConstants.ClausulaHipotecariaApellido2);
		 * webDriver.selectFirstValueInDropDown(cmbDireccionRiesgo);
		 * webDriver.selectValueInDropDown(cmbEntidadBancaria,
		 * ProjectConstants.ClausulaHipotecariaEntidadBancaria);
		 * webDriver.sendValueToWebElement(
		 * txtCoheficienteParticipacion,
		 * ProjectConstants.ClausulaHipotecariaCoheficienteParticipacion);
		 * webDriver.changeFocusOfWebElement(
		 * txtCoheficienteParticipacion);
		 * webDriver.clickOnWebElement(btnAddClausula);
		 * webDriver.exitFromFrame(); }
		 */

		// if (userS.getTestVar(testId,
		// "clausula_hipotecaria").equals(ProjectConstants.ClausulaHipotecaria))
		if(Boolean.parseBoolean(userS.getTestVar("clausula_hipotecaria"))) {}

		return this;
	}

}