package com.amaris.project.pages.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import com.amaris.automation.model.helpers.DniGeneratorHelper;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.utils.ClausulasHelper;
import com.amaris.project.Constants;

public class ClausulasPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");
	
	private By addClausulaHipotecariaBtn = By.xpath(".//*[text()='Añadir cláusula y/o hipotecaria']");
	private By tabClausulaHipotecariaBtn = By.xpath(".//*[text()='Cláusula hipotecaria']");

	private By tipoDocumentoDrpDwn = By.id("tipodocumento");
	private By numeroDocumentoInput = By.name("numerodocumento");

	private By nombreAseguradoInput = By.id("nombreasegurado");
	private By apellido1AseguradoInput = By.id("apellido1asegurado");
	private By apellido2AseguradoInput = By.id("apellido2asegurado");
	private By direccionRiesgoDrpDwn = By.id("direccionriesgo");
	private By entidadBancariaDrpDwn = By.id("entidadbancaria");
	private By coheficienteParticipacionInput = By.id("coefparticipacion");

	private By addClausulaBtn = By.xpath(".//*[text()='Añadir cláusula' and @ng-click='cp.insertarClausula()']");
	private By continuarInCreationBtn = By.xpath(".//*[text()='Continuar']");
	private By nextClausulasPageBtn = By.xpath(".//*[@ng-click='control.update(control.current + 1)']");

	private By clausulaCheckbox = By.xpath(".//td[2]/input");
	private By clausulaTxt = By.xpath(".//td[2]/input.//td[6]");
	private By clausulaNumber = By.xpath(".//td[2]/input.//td[4]");
	// endregion

	public ClausulasPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public ClausulasPage clickContinuar() {
		debugBegin();

		if(Boolean.parseBoolean(getTestVar(Constants.INFRA_SEGURO)) && !clausulaIsSelected(102)) {
			try {
				debugError("La clausula 102 no se ha seleccionado al crear un infraseguro");
			} catch(Exception e) {
				setTestVar("mensaje_error", "La clausula 102 no se ha seleccionado al crear un infraseguro");
				// webDriver.getScenario().write("La clausula 102 no se ha
				// seleccionado al crear un infraseguro");
			}
		}

		webDriver.scrollToBottomInFrame(cuerpoFrame);
		webDriver.waitWithDriver(4000);
		webDriver.clickInFrame(continuarInCreationBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ClausulasPage activarClausulas() {
		debugBegin();

		if(getConfigVar(Constants.MODIFICAR_CLAUSULAS) != null 
			&& getConfigVar(Constants.MODIFICAR_CLAUSULAS).equals(Constants.ModificarClausulas)) {
			for(int pageNumber = 1; pageNumber < 6; pageNumber++) {
				activarClausulasInPage(pageNumber);

				if(!existToBeActivatedClauses(pageNumber)) {
					break;
				} else {
					webDriver.scrollToBottomInFrame(cuerpoFrame);
					webDriver.clickInFrame(nextClausulasPageBtn, cuerpoFrame);
				}
			}
		}

		debugEnd();

		return this;
	}

	private List<ClausulasHelper> getClausulasInPage(int pageNumber) {
		debugBegin();

		List<ClausulasHelper> clausulasTemp = new ArrayList<>();
		List<ClausulasHelper> clausulasList = new ArrayList<>();
		clausulasList.addAll(getClausulasInPage(pageNumber));

		clausulasList.forEach(p -> {
			if(webDriver.isSelectedInFrame(clausulaCheckbox, cuerpoFrame)) {
				clausulasTemp.add(new ClausulasHelper(pageNumber, true,
					webDriver.getTextInFrame(clausulaTxt, cuerpoFrame),
					webDriver.getTextInFrame(clausulaNumber, cuerpoFrame),
					webDriver.getElementInFrame(clausulaCheckbox, cuerpoFrame)));
			} else {
				clausulasTemp.add(new ClausulasHelper(pageNumber, false,
					webDriver.getTextInFrame(clausulaTxt, cuerpoFrame),
					webDriver.getTextInFrame(clausulaNumber, cuerpoFrame),
					webDriver.getElementInFrame(clausulaCheckbox, cuerpoFrame)));
			}
		});

		debugEnd();

		return clausulasTemp;
	}

	private ClausulasPage activarClausulasInPage(int pageNumber) {
		debugBegin();

		List<ClausulasHelper> clausulasList = new ArrayList<>();
		clausulasList.addAll(getClausulasInPage(pageNumber));

		for(ClausulasHelper clausula : clausulasList) {
			if(!clausula.getSelected() && ClausulasHelper.getClausulas(userS).contains(clausula.getNumber())) {
				webDriver.clickInFrame(clausula.getCheckbox(), cuerpoFrame);
				clausula.setSelected(true);
			}
		}

		debugEnd();

		return this;
	}

	private boolean existToBeActivatedClauses(int pageNumber) {
		boolean check = false;
		
		List<ClausulasHelper> clausulasList = new ArrayList<>();
		clausulasList.addAll(getClausulasInPage(pageNumber));

		List<ClausulasHelper> clausulasTemp = clausulasList.stream()
			.filter(p -> ClausulasHelper.getClausulas(userS).contains(p.getNumber()) && p.getSelected())
			.collect(Collectors.toList());

		if(clausulasTemp.size() != ClausulasHelper.getClausulas(userS).size()) {
			check = true;
		}

		return check;
	}

	private String getClausulaStatusInPage(int clausulaNumber, int pageNumber) {
		debugBegin();

		List<ClausulasHelper> clausulasList = new ArrayList<>();
		clausulasList.addAll(getClausulasInPage(pageNumber));

		List<ClausulasHelper> clausulasfound = clausulasList.stream().filter(p -> p.getNumber().equals(Integer.toString(clausulaNumber)))
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

	public boolean clausulaIsSelected(int clausula) {
		debugBegin();

		boolean result = false;

		for(int pageNumber = 1; pageNumber <= 6; pageNumber++) {
			String clausulaSelected = getClausulaStatusInPage(clausula, pageNumber);

			if(clausulaSelected.equals(Constants.ClausulaEncontradaYSeleccionada) 
				|| clausulaSelected.equals(Constants.ClausulaEncontradaYNoSeleccionada)) {
				if(clausulaSelected.equals(Constants.ClausulaEncontradaYSeleccionada)) {
					result = true;					
				}
				
				break;
			}

			webDriver.clickInFrame(nextClausulasPageBtn, cuerpoFrame);
		}

		debugEnd();

		return result;
	}

	public ClausulasPage completarClausulaHipotecaria() {
		if(Boolean.parseBoolean(userS.getTestVar("clausula_hipotecaria"))) {
			webDriver.clickInFrame(addClausulaHipotecariaBtn, cuerpoFrame);
			webDriver.clickInFrame(tabClausulaHipotecariaBtn, cuerpoFrame);
			
			webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoDrpDwn, cuerpoFrame, Constants.NIF);
			
			webDriver.appendTextInFrame(numeroDocumentoInput, cuerpoFrame, DniGeneratorHelper.generateNif());
			webDriver.appendTextInFrame(nombreAseguradoInput, cuerpoFrame, Constants.ClausulaHipotecariaNombre);
			webDriver.appendTextInFrame(apellido1AseguradoInput, cuerpoFrame, Constants.ClausulaHipotecariaApellido1);
			webDriver.appendTextInFrame(apellido2AseguradoInput, cuerpoFrame, Constants.ClausulaHipotecariaApellido2);
			
			webDriver.clickElementFromDropDownByIndexInFrame(direccionRiesgoDrpDwn, cuerpoFrame, 0);
			webDriver.clickElementFromDropDownByTextInFrame(entidadBancariaDrpDwn, cuerpoFrame, Constants.ClausulaHipotecariaEntidadBancaria);
			
			webDriver.appendTextInFrame(coheficienteParticipacionInput, cuerpoFrame, Constants.ClausulaHipotecariaCoheficienteParticipacion);
			
			webDriver.tabulateElementInFrame(coheficienteParticipacionInput, cuerpoFrame);
			webDriver.clickInFrame(addClausulaBtn, cuerpoFrame);
		}

		return this;
	}
}