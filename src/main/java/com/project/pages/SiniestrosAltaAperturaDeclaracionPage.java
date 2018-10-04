package com.project.pages;

import org.openqa.selenium.By;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.steps.Steps;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiniestrosAltaAperturaDeclaracionPage extends PageObject {
	
	public SiniestrosAltaAperturaDeclaracionPage(UserStory userS) {
		super(userS);
	}
	// final static Logger logger =
	// LoggerFactory.getLogger(SiniestrosAltaAperturaDeclaracionPage.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	//
	// // region webelements
	
	// #####	FRAMES	#####
	
	// @FindBy(id = "leftFrame")
	// private WebElement menuFrame;
	//
	// @FindBy(id = "topFrame")
	// private WebElement topFrame;
	//
	// @FindBy(id = "mainFrame")
	 private By cuerpoFrame = By.id("mainFrame");
	
	 
	 // #####	DATOS OCURRENCIA	#####
	 
	// @FindBy(id = "fechsini")
	 private By txtFechaOcurrencia = By.id("fechsini");
	
	 
	 //	#####	DATOS DECLARACION	####
	 
	// @FindBy(id = "tipodecl")
	// private WebElement drpdwnTipoDeclarante;
	 
	 private By tipoDeclaranteTomador = By.cssSelector("#tipodecl > option:nth-child(2)");
	
	 // @FindBy(id = "mododecl")
	// private WebElement drpdwnMedioDeclaracion;
	 
	 private By medioDeclaracionCorreoElec = By.cssSelector("#mododecl > option:nth-child(2)");
	 
	// @FindBy(id = "FECHDENU")
	// private WebElement txtFechaDenuncia;
	
	
	//	#####	ASISTENCIA	#####
	 
	// @FindBy(id = "asistenciaSi")
	 private By rdbtnAsistenciaSi = By.id("asistenciaSi");
	//
	// @FindBy(id = "asistenciaNo")
	 private By rdbtnAsistenciaNo = By.id("asistenciaNo");
	
	 
	// @FindBy(id = "botonContinuar")
	 
	// botón continuar para produtos 500 y 510 
	 private By btnContinuar = By.id("botonContinuar");
	 

	 
	// endregion
	
	 
	//############################################################################## 
	 
	 
	// region methods
	 
	// public void writeFechaOcurrencia(
	// String fechaOcurrencia)
	// {
	// logger.debug("BEGIN - writeFechaOcurrencia");
	// this.wh.sendValueToWebElementInFrame(this.txtFechaOcurrencia,
	// this.mainFrame, fechaOcurrencia);
	// logger.debug("END - writeFechaOcurrencia");
	// }
	//
	// public void selectTipoDeclarante(
	// String tipoDeclarante)
	// {
	// logger.debug("BEGIN - selectTipoDeclarante");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnTipoDeclarante,
	// this.mainFrame, tipoDeclarante);
	// logger.debug("END - selectTipoDeclarante");
	// }
	//
	// public void selectMedioDeclaracion(
	// String medioDeclaracion)
	// {
	// logger.debug("BEGIN - selectMedioDeclaracion");
	// this.wh.sendValueToWebElementInFrame(this.drpdwnMedioDeclaracion,
	// this.mainFrame, medioDeclaracion);
	// logger.debug("END - selectMedioDeclaracion");
	// }
	//
	// public void writeFechaDenuncia(
	// String fechaDenuncia)
	// {
	// logger.debug("BEGIN - writeFechaDenuncia");
	// this.wh.sendValueToWebElementInFrame(this.txtFechaDenuncia,
	// this.mainFrame, fechaDenuncia);
	// logger.debug("END - writeFechaDenuncia");
	// }
	//
	// public void selectAsistenciaSi()
	// {
	// logger.debug("BEGIN - selectAsistenciaSi");
	// this.wh.clickOnWebElementInFrame(this.rdbtnAsistenciaSi, this.mainFrame);
	// logger.debug("END - selectAsistenciaSi");
	// }
	//
	// public void selectAsistenciaNo()
	// {
	// logger.debug("BEGIN - selectAsistenciaNo");
	// this.wh.clickOnWebElementInFrame(this.rdbtnAsistenciaNo, this.mainFrame);
	// logger.debug("END - selectAsistenciaNo");
	// }
	
	 public void clickContinuar()
	 {
		this.debugBegin();
		
		this.webDriver.waitWithDriver(7000);
		this.webDriver.clickInFrame(this.btnContinuar, this.cuerpoFrame);
		
		//Steps.waitForIt(webDriver);
		System.out.println("pam");
	 	this.debugEnd();
	 }
	
	 DateFormat fOcurrencia = new SimpleDateFormat("dd/MM/yyyy");
	 
	 public void completarMinimos(String numPoliza) // método que completa el mínimo de campos para realizar una prueba
	 {

		 
		this.debugBegin();
		this.webDriver.switchToFrame(this.cuerpoFrame);
		this.webDriver.waitWithDriver(2500);

		this.webDriver.click(this.tipoDeclaranteTomador);
		
		this.webDriver.appendText(this.txtFechaOcurrencia, fOcurrencia.format(new Date()));
		
		this.webDriver.click(this.medioDeclaracionCorreoElec);
		
		this.webDriver.waitWithDriver(2500);
		System.out.println(numPoliza.substring(0, 3));
		System.out.println(numPoliza.substring(0, 3).equals("510"));
		System.out.println(numPoliza.substring(0, 3).compareTo("510"));
		//if(numPoliza.substring(0, 3).compareTo("510") == 0 || numPoliza.substring(0, 3).compareTo("500") == 0) this.webDriver.click(this.rdbtnAsistenciaNo);
		if(numPoliza.substring(0, 3).compareTo("900") == 0) {rdbtnAsistenciaNo = By.id("fisicoNo");}
		this.webDriver.waitWithDriver(2500);
		System.out.println("pim");
		this.webDriver.waitForElementToBeClickableAndClick(this.rdbtnAsistenciaNo);
	
		this.webDriver.click(this.btnContinuar);
		this.webDriver.waitWithDriver(2500);
		System.out.println("pam");
		this.webDriver.exitFrame();
		
		//this.clickContinuar();
		System.out.println("pum");
		//Steps.waitForIt(webDriver);
		
		this.debugEnd();
	 }
	 
	 
	// endregion
}