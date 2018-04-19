package com.project.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.utils.ClausulasHelper;
import com.project.ProjectConstants;


/*import com.mutuaPropietarios.WebdriverContext.BrowserContext;
import com.mutuaPropietarios.WebdriverContext.Helpers.DniGeneratorHelper;
import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
import com.mutuaPropietarios.testCasesData.Helpers.ClausulasHelper;
import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
import com.mutuaPropietarios.testCasesData.context.TestCaseData;
*/

public class ClausulasPage
{
	/*final static Logger logger = LoggerFactory.getLogger(ClausulasPage.class);
	BrowserContext browserContext;
	private WebElementHelper wh;
	TestCaseData tData;
	*/
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);
	
	
	// region webelements
	@FindBy(name = "cuerpo")
	private By cuerpoFrame;
	
	// Rows with a checkbox and a clausula
	@FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowWithClausula;
	
	@FindBy(xpath = ".//*[@class='pagination' and ancestor::*[contains(@ng-if,'control.totalPages')]]")
	private By clausulaPageSelector;
	
	@FindBy(xpath = ".//*[text()='Añadir cláusula y/o hipotecaria']")
	private By btnAddClausulaHipotecaria;
	
	@FindBy(xpath = ".//*[text()='Cláusula hipotecaria']")
	private By btnTabClausulaHipotecaria;
	
	@FindBy(id = "tipodocumento")
	private By cmbTipoDocumento;
	
	@FindBy(name = "numerodocumento")
	private By txtNumeroDocumento;
	
	@FindBy(id = "nombreasegurado")
	private By txtNombreAsegurado;
	
	@FindBy(id = "apellido1asegurado")
	private By txtApellido1Asegurado;
	
	@FindBy(id = "apellido2asegurado")
	private By txtApellido2Asegurado;
	
	@FindBy(id = "direccionriesgo")
	private By cmbDireccionRiesgo;
	
	@FindBy(id = "entidadbancaria")
	private By cmbEntidadBancaria;
	
	@FindBy(id = "coefparticipacion")
	private By txtCoheficienteParticipacion;
	
	@FindBy(xpath = ".//*[text()='Añadir cláusula' and @ng-click='cp.insertarClausula()']")
	private By btnAddClausula;
	
	@FindBy(xpath = ".//*[@title='Continuar']")
	private By btnContinuarInEdition;
	
	@FindBy(xpath = ".//*[text()='Continuar']")
	private By btnContinuarInCreation;
	
	@FindBy(xpath = ".//*[@ng-click='control.update(control.current + 1)']")
	private By btnNextClausulasPage;
	
	@FindBy(xpath = ".//tr[td[input]]")
	private List<By> rowCheckboxWithCoberturaOpcional;
	
	private String xPathFilterClausulaCheckbox = ".//td[2]/input";
	// private String cssFilterSelectedCheckboxes = "input:checked[type=checkbox]";
	private String xPathFilterClausulaText = ".//td[6]";
	private String xPathFilterClausulaNumber = ".//td[4]";
	private List<ClausulasHelper> clausulas = new ArrayList<>();
	// endregion
	
	
	/*
	 * 
	 * 	public AsignarMediadorPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}

	
	 * 
	 * */
	
	
	public ClausulasPage(DriverHelper driver, TestDataManager data)
	{
	/*	this.browserContext = browserContext;
		this.wh = browserContext.webElementHelper;
		this.tData = browserContext.getTestCaseData();
		PageFactory.initElements(browserContext.getWebDriver(), this);
	*/
		
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();	
	}
	
	
	
	// region methods
	public void ActivateclausesAndClickOnContinue() throws Exception
	{
		this.ActivateClauses();
		this.CompletarClausulaHipotecaria();
		this.clickOnContinuar();
	}
	
	public void clickOnContinuar() throws Exception
	{
		logger.debug("BEGIN - ClickOnContinuarInCreation");
		if (Boolean.parseBoolean(this.tCData.getTestVar(testId, "infra_seguro")))
		{
			if (!this.IsClausulaSelected(102))
			{
				try
				{
					throw new Exception("La clausula 102 no se ha seleccionado al crear un infraseguro");
				}
				catch (Exception e)
				{
					tCData.setTestVar(testId, "mensaje_error", "La clausula 102 no se ha seleccionado al crear un infraseguro");
					//this.webDriver.getScenario().write("La clausula 102 no se ha seleccionado al crear un infraseguro");
				}
			}
		}
		this.webDriver.switchToFrame( this.cuerpoFrame);
		//this.webDriver.waitForPageLoadWithAngular();
		//this.cuerpoFrame.click();
		this.webDriver.scrollToBottom();
		this.webDriver.click(this.btnContinuarInCreation);
		this.webDriver.exitFrame();
		logger.debug("END - ClickOnContinuarInCreation");
	}
	
	public void ActivateClauses()
	{
		this.webDriver.switchToFrame( this.cuerpoFrame);
		if (this.tCData.getTestVar(testId, "modificar_clausulas").equals(ProjectConstants.ModificarClausulas))
		{
			for (int pageNumber = 1; pageNumber < 6; pageNumber++)
			{
				
				this.ActivateClausesInPage(pageNumber);
				
				if (!this.ExistToBeActivatedClauses())
				{
					break;
				}
				else
				{
					this.webDriver.scrollToBottom();
					this.webDriver.click(this.btnNextClausulasPage);
				}
			}			
		}
		this.webDriver.exitFrame();
	}
	
	private List<ClausulasHelper> GetClausulasInPage(
			Integer pageNumber)
	{
		logger.debug("BEGIN - GetCoberturasOpcionales");
		
		this.webDriver.switchToFrame(this.cuerpoFrame);
		//this.webDriver.waitForPageLoadWithAngular();
		
		List<ClausulasHelper> clausulasTemp = new ArrayList<>();
		
		this.rowWithClausula.forEach(p ->
		{
			//By element = p.findElement(By.xpath(this.xPathFilterClausulaCheckbox));
			if (webDriver.isSelected(By.xpath(this.xPathFilterClausulaCheckbox)))
			{
				clausulasTemp.add(new ClausulasHelper(pageNumber, true, 
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaText)), 
					webDriver.getElement(By.xpath(this.xPathFilterClausulaCheckbox))));
//				clausulasTemp.add(new ClausulasHelper(pageNumber, true, p.findElement(By.xpath(this.xPathFilterClausulaNumber)).getText(),
//					p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(), element));
			}
			else
			{
				clausulasTemp.add(new ClausulasHelper(pageNumber, false, 
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaNumber)),
					webDriver.getText(By.xpath(xPathFilterClausulaCheckbox + this.xPathFilterClausulaText)), 
					webDriver.getElement(By.xpath(this.xPathFilterClausulaCheckbox))));
//				clausulasTemp.add(new ClausulasHelper(pageNumber, false, p.findElement(By.xpath(this.xPathFilterClausulaNumber)).getText(),
//					p.findElement(By.xpath(this.xPathFilterClausulaText)).getText(), element));
			}
		});
		this.webDriver.exitFrame();
		logger.debug("END - GetCoberturasOpcionales");
		return clausulasTemp;
		
	}
	
	private void ActivateClausesInPage(
			Integer pageNumber)
	{
		this.clausulas.addAll(this.GetClausulasInPage(pageNumber));
		
	/*	this.clausulas.stream().filter(p -> this.browserContext.getTestCaseData().getClausulas().contains(p.getNumber())).forEach(x ->
		{
			if (x.getSelected().equals(false))
			{	this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(x.getCheckbox());
				x.setSelected(true);
				this.webDriver.exitFrame();
			}
		});
		*/
		
		//this.tCData.getTestVar(testId, "modificar_clausulas").equals(ProjectConstants.ModificarClausulas)
		//this.clausulas.stream().filter(p -> this.tCData.getTestVar(testId,"get_clausulas").equals(ProjectConstants.lausulas)).forEach(x ->
		//this.clausulas.stream().filter(p -> this.browserContext.getTestCaseData().getClausulas().contains(p.getNumber())).forEach(x ->
		//for(ClausulasHelper x : clausulas)
		for(int i=0; i<=clausulas.size();i++)
		{	
			ClausulasHelper x = clausulas.get(i);		
			if (x.getSelected().equals(false))
			{	
				this.webDriver.switchToFrame(this.cuerpoFrame);
				this.webDriver.click(x.getCheckbox());
				x.setSelected(true);
				this.webDriver.exitFrame();
			}
		};
		
	}
	
	private boolean ExistToBeActivatedClauses()
	{
		System.out.println("COMPLETAR");
		List<ClausulasHelper> clausulasTemp = this.clausulas.stream()
				.filter(p -> this.tCData.getTestVar(testId, "clausula").contains(p.getNumber()) && p.getSelected().equals(true))
				.collect(Collectors.toList());
		
		/*if (clausulasTemp.size() == this.browserContext.getTestCaseData().getClausulas().size())
		{
			return false;
		}
		else
		{
			return true;
		}*/
		boolean check = false;
		
		for(ClausulasHelper clausula : clausulas) {
			if(!this.tCData.getTestVar(testId, "clausula").contains(clausula.getNumber()) || clausula.getSelected().equals(false)) {
				check = true;
			}
		}
		
		return check;
	}
	
	private String GetClausulaStatusInPage(
			int Clausula, int pageNumber)
	{
		this.clausulas.addAll(this.GetClausulasInPage(pageNumber));
		
		List<ClausulasHelper> clausulasfound = this.clausulas.stream().filter(p -> p.getNumber().equals(String.valueOf(Clausula)))
				.collect(Collectors.toList());
		
		if (clausulasfound.size() == 1)
		{
			if (clausulasfound.get(0).getSelected().equals(true))
			{
				return ProjectConstants.ClausulaEncontradaYSeleccionada;
			}
			else
			{
				return ProjectConstants.ClausulaEncontradaYNoSeleccionada;
			}
		}
		
		return ProjectConstants.ClausulaNoEncontrada;
	}
	
	public boolean IsClausulaSelected(
			Integer clausula)
	{
		for (int pageNumber = 1; pageNumber <= 6; pageNumber++)
		{
			
			String clausulaSelected = this.GetClausulaStatusInPage(clausula, pageNumber);
			
			if (clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYSeleccionada))
			{
				return true;
			}
			else if (clausulaSelected.equals(ProjectConstants.ClausulaEncontradaYNoSeleccionada))
			{
				return false;
			}
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.click(this.btnNextClausulasPage);
			this.webDriver.exitFrame();
		}
		return false;
	}
	
	
	/*
	 * 	public boolean isClausulaHipotecaria()
	{
		return this.ClausulaHipotecaria;
	}

	public void setClausulaHipotecaria(boolean clausulaHipotecaria)
	{
		this.ClausulaHipotecaria = clausulaHipotecaria;
	}

	 * 
	 * */
	
	public void CompletarClausulaHipotecaria()
	{
		/*if (this.browsContext.isClausulaHipotecaria())
		{
			this.webDriver.switchToFrame(this.cuerpoFrame);
			this.webDriver.click(this.btnAddClausulaHipotecaria);
			this.webDriver.click(this.btnTabClausulaHipotecaria);
			this.webDriver.selectValueInDropDown(this.cmbTipoDocumento, ProjectConstants.NIF);
			//this.webDriver.select(this.cmbTipoDocumento, ProjectConstants.NIF);
			this.webDriver.sendValueToWebElement(this.txtNumeroDocumento, DniGeneratorHelper.generaNif(null));
			this.webDriver.sendValueToWebElement(this.txtNombreAsegurado, ProjectConstants.ClausulaHipotecariaNombre);
			this.webDriver.sendValueToWebElement(this.txtApellido1Asegurado, ProjectConstants.ClausulaHipotecariaApellido1);
			this.webDriver.sendValueToWebElement(this.txtApellido2Asegurado, ProjectConstants.ClausulaHipotecariaApellido2);
			this.webDriver.selectFirstValueInDropDown(this.cmbDireccionRiesgo);
			this.webDriver.selectValueInDropDown(this.cmbEntidadBancaria, ProjectConstants.ClausulaHipotecariaEntidadBancaria);
			this.webDriver.sendValueToWebElement(this.txtCoheficienteParticipacion, ProjectConstants.ClausulaHipotecariaCoheficienteParticipacion);
			this.webDriver.changeFocusOfWebElement(this.txtCoheficienteParticipacion);
			this.webDriver.clickOnWebElement(this.btnAddClausula);
			this.webDriver.exitFromFrame();
		}*/
		
	//	if (this.tCData.getTestVar(testId, "clausula_hipotecaria").equals(ProjectConstants.ClausulaHipotecaria))
		if (Boolean.parseBoolean(this.tCData.getTestVar(testId, "clausula_hipotecaria"))){}
	}
		
		
		
		
}