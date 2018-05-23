package com.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.utils.ClausulasHelper;
import com.project.ProjectConstants;

/*import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.Helpers.ClausulasHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/

public class ClausulasPage extends PageObject {

	// region webelements
	// @FindBy(name = "cuerpo")
	private By cuerpoFrame;

	// Rows with a checkbox and a clausula
	// @FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowWithClausula;

	// @FindBy(xpath = ".//*[@class='pagination' and
	// ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private By clausulaPageSelector;

	// @FindBy(xpath = ".//*[text()='Añadir cláusula y/o hipotecaria']")
	private By btnAddClausulaHipotecaria;

	// @FindBy(xpath = ".//*[text()='Cláusula hipotecaria']")
	private By btnTabClausulaHipotecaria;

	// @FindBy(id = "tipodocumento")
	private By cmbTipoDocumento;

	// @FindBy(name = "numerodocumento")
	private By txtNumeroDocumento;

	// @FindBy(id = "nombreasegurado")
	private By txtNombreAsegurado;

	// @FindBy(id = "apellido1asegurado")
	private By txtApellido1Asegurado;

	// @FindBy(id = "apellido2asegurado")
	private By txtApellido2Asegurado;

	// @FindBy(id = "direccionriesgo")
	private By cmbDireccionRiesgo;

	// @FindBy(id = "entidadbancaria")
	private By cmbEntidadBancaria;

	// @FindBy(id = "coefparticipacion")
	private By txtCoheficienteParticipacion;

	// @FindBy(xpath = ".//*[text()='Añadir cláusula' and
	// @ng-click='cp.insertarClausula()']")
	private By btnAddClausula;

	// @FindBy(xpath = ".//*[@title='Continuar']")
	private By btnContinuarInEdition;

	// @FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuarInCreation;

	// @FindBy(xpath = ".//*[@ng-click='control.update(control.current + 1)']")
	private By btnNextClausulasPage;

	// @FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowCheckboxWithCoberturaOpcional;

	private String xPathFilterClausulaCheckbox = ".//td[2]/input";
	// private String cssFilterSelectedCheckboxes =
	// "input:checked[type=checkbox]";
	private String xPathFilterClausulaText = ".//td[6]";
	private String xPathFilterClausulaNumber = ".//td[4]";
	private List<ClausulasHelper> clausulas = new ArrayList<>();
	// endregion

	/*
	 * 
	 * public AsignarMediadorPage(DriverHelper driver, TestDataManager data) {
	 * this.testDataM = data; this.webDriver = driver; this.testId =
	 * webDriver.getId() == null ? "" : webDriver.getId(); }
	 * 
	 * 
	 * 
	 */

	public ClausulasPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ClausulasPage activateclausesAndClickOnContinue() throws Exception {
		this.ActivateClauses();
		this.CompletarClausulaHipotecaria();
		this.clickOnContinuar();
		
		return this;
	}

	public ClausulasPage clickOnContinuar() throws Exception {
		debugBegin();
		
		if(Boolean.parseBoolean(this.testDataM.getTestVar(testId, "infra_seguro"))) {
			if(!this.IsClausulaSelected(102)) {
				try {
					throw new Exception("La clausula 102 no se ha seleccionado al crear un infraseguro");
				} catch(Exception e) {
					testDataM.setTestVar(testId, "mensaje_error", "La clausula 102 no se ha seleccionado al crear un infraseguro");
					// this.webDriver.getScenario().write("La clausula 102 no se
					// ha seleccionado al crear un infraseguro");
				}
			}
		}
		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.waitForPageLoadWithAngular();
		// this.cuerpoFrame.click();
		this.webDriver.scrollToBottom();
		this.webDriver.click(this.btnContinuarInCreation);
		this.webDriver.exitFrame();
		
		debugEnd();
		
		return this;
	}

	public ClausulasPage ActivateClauses() {
		debugBegin();
		
		this.webDriver.switchToFrame(this.cuerpoFrame);
		if(this.testDataM.getTestVar(testId, "modificar_clausulas").equals(ProjectConstants.ModificarClausulas)) {
			for(int pageNumber = 1; pageNumber < 6; pageNumber++) {

				this.ActivateClausesInPage(pageNumber);

				if(!this.ExistToBeActivatedClauses()) {
					break;
				} else {
					this.webDriver.scrollToBottom();
					this.webDriver.click(this.btnNextClausulasPage);
				}
			}
		}
		
		this.webDriver.exitFrame();
		
		debugEnd();
		
		return this;
	}

	private List<ClausulasHelper> GetClausulasInPage(Integer pageNumber) {
		debugBegin();

		this.webDriver.switchToFrame(this.cuerpoFrame);
		// this.webDriver.waitForPageLoadWithAngular();

		List<ClausulasHelper> clausulasTemp = new ArrayList<>();

		this.rowWithClausula.forEach(p -> {
			// By element =
			// p.findElement(By.xpath(this.xPathFilterClausulaCheckbox));
			if(webDriver.isSelected(By.xpath(this.xPathFilterClausulaCheckbox))) {
				clausulasTemp.add(new ClausulasHelper(pageNumber, true,
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaText)),
					webDriver.getElement(By.xpath(this.xPathFilterClausulaCheckbox))));
				// clausulasTemp.add(new ClausulasHelper(pageNumber, true,
				// p.findElement(By.xpath(this.xPathFilterClausulaNumber)).getText(),
				// p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
				// element));
			} else {
				clausulasTemp.add(new ClausulasHelper(pageNumber, false,
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaText)),
					webDriver.getElement(By.xpath(this.xPathFilterClausulaCheckbox))));
				// clausulasTemp.add(new ClausulasHelper(pageNumber, false,
				// p.findElement(By.xpath(this.xPathFilterClausulaNumber)).getText(),
				// p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(),
				// element));
			}
		});
		
		this.webDriver.exitFrame();
		
		debugEnd();
		
		return clausulasTemp;
	}

	private ClausulasPage ActivateClausesInPage(Integer pageNumber) {
		debugBegin();
		
		this.clausulas.addAll(this.GetClausulasInPage(pageNumber));

		/*
		 * this.clausulas.stream().filter(p ->
		 * this.browserContext.getTestCaseData().getClausulas().contains(p.
		 * getNumber())).forEach(x -> { if (x.getSelected().equals(false)) {
		 * this.webDriver.switchToFrame(this.cuerpoFrame);
		 * this.webDriver.click(x.getCheckbox()); x.setSelected(true);
		 * this.webDriver.exitFrame(); } });
		 */

		// this.testDataM.getTestVar(testId,
		// "modificar_clausulas").equals(ProjectConstants.ModificarClausulas)
		// this.clausulas.stream().filter(p ->
		// this.testDataM.getTestVar(testId,"get_clausulas").equals(ProjectConstants.lausulas)).forEach(x
		// ->
		// this.clausulas.stream().filter(p ->
		// this.browserContext.getTestCaseData().getClausulas().contains(p.getNumber())).forEach(x
		// ->
		// for(ClausulasHelper x : clausulas)
		for(int i = 0; i <= clausulas.size(); i++) {
			ClausulasHelper x = clausulas.get(i);
			if(x.getSelected().equals(false)) {
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(x.getCheckbox());
				x.setSelected(true);
				this.webDriver.exitFrame();
			}
		} ;

		debugEnd();
		
		return this;
	}

	private boolean ExistToBeActivatedClauses() {
		System.out.println("COMPLETAR");
		List<ClausulasHelper> clausulasTemp = this.clausulas.stream()
			.filter(p -> this.testDataM.getTestVar(testId, "clausula").contains(p.getNumber()) && p.getSelected().equals(true))
			.collect(Collectors.toList());

		/*
		 * if (clausulasTemp.size() ==
		 * this.browserContext.getTestCaseData().getClausulas().size()) { return
		 * false; } else { return true; }
		 */
		boolean check = false;

		for(ClausulasHelper clausula : clausulas) {
			if(!this.testDataM.getTestVar(testId, "clausula").contains(clausula.getNumber()) || clausula.getSelected().equals(false)) {
				check = true;
			}
		}

		return check;
	}

	private String GetClausulaStatusInPage(int Clausula, int pageNumber) {
		debugBegin();
		
		this.clausulas.addAll(this.GetClausulasInPage(pageNumber));

		List<ClausulasHelper> clausulasfound = this.clausulas.stream().filter(p -> p.getNumber().equals(String.valueOf(Clausula)))
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

	public boolean IsClausulaSelected(Integer clausula) {
		debugBegin();
		
		boolean result = false;
		
		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {
			String clausulaSelected = this.GetClausulaStatusInPage(clausula, pageNumber);

			if(clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYSeleccionada)) {
				result = true;
				break;
			} else if(clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYNoSeleccionada)) { 
				result = false;
				break;
			}
			
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.click(this.btnNextClausulasPage);
			this.webDriver.exitFrame();
		}
		
		debugEnd();
		
		return result;
	}

	/*
	 * public boolean isClausulaHipotecaria() { return this.ClausulaHipotecaria;
	 * }
	 * 
	 * public void setClausulaHipotecaria(boolean clausulaHipotecaria) {
	 * this.ClausulaHipotecaria = clausulaHipotecaria; }
	 * 
	 * 
	 */

	public ClausulasPage CompletarClausulaHipotecaria() {
		/*
		 * if (this.browsContext.isClausulaHipotecaria()) {
		 * this.webDriver.switchToFrame(this.cuerpoFrame);
		 * this.webDriver.click(this.btnAddClausulaHipotecaria);
		 * this.webDriver.click(this.btnTabClausulaHipotecaria);
		 * this.webDriver.selectValueInDropDown(this.cmbTipoDocumento,
		 * ProjectConstants.NIF); //this.webDriver.select(this.cmbTipoDocumento,
		 * ProjectConstants.NIF);
		 * this.webDriver.sendValueToWebElement(this.txtNumeroDocumento,
		 * DniGeneratorHelper.generaNif(null));
		 * this.webDriver.sendValueToWebElement(this.txtNombreAsegurado,
		 * ProjectConstants.ClausulaHipotecariaNombre);
		 * this.webDriver.sendValueToWebElement(this.txtApellido1Asegurado,
		 * ProjectConstants.ClausulaHipotecariaApellido1);
		 * this.webDriver.sendValueToWebElement(this.txtApellido2Asegurado,
		 * ProjectConstants.ClausulaHipotecariaApellido2);
		 * this.webDriver.selectFirstValueInDropDown(this.cmbDireccionRiesgo);
		 * this.webDriver.selectValueInDropDown(this.cmbEntidadBancaria,
		 * ProjectConstants.ClausulaHipotecariaEntidadBancaria);
		 * this.webDriver.sendValueToWebElement(this.
		 * txtCoheficienteParticipacion,
		 * ProjectConstants.ClausulaHipotecariaCoheficienteParticipacion);
		 * this.webDriver.changeFocusOfWebElement(this.
		 * txtCoheficienteParticipacion);
		 * this.webDriver.clickOnWebElement(this.btnAddClausula);
		 * this.webDriver.exitFromFrame(); }
		 */

		// if (this.testDataM.getTestVar(testId,
		// "clausula_hipotecaria").equals(ProjectConstants.ClausulaHipotecaria))
		if(Boolean.parseBoolean(this.userS.getTestVar("clausula_hipotecaria"))) {}
		
		return this;
	}

}