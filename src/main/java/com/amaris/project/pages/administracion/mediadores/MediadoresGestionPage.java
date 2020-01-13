package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresGestionPage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By tituloPaginaTxt = By.cssSelector("h1.titulopagina");

	//-------------menu botones--------------------------------

	private By visionGlobalBtn = By.cssSelector("#pes0");
	private By infoDescriptivaBtn = By.cssSelector("#pes1");
	private By infoContactoBtn = By.cssSelector("#pes2");
	private By infoRelacionalBtn = By.cssSelector("#pes3");
	private By condicionesNegocioBtn = By.cssSelector("#pes5");
	private By infoHistoricaBtn = By.cssSelector("#pes6");
	private By infoCCMBtn = By.cssSelector("#pes7");
	private By contactosBtn = By.cssSelector("#pes8");
	private By situacionesBtn = By.cssSelector("#pes9");
	private By cambiosBtn = By.cssSelector("#pes10");
	private By anotacionesBtn = By.cssSelector("#pes11");

	private By masAccionesBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > a > span");
	private By convertirAffinityBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(1) > a");
	private By iniciarAltamediadorBtn = By.cssSelector("#capaCab > table > tbody > tr > td:nth-child(3) > table > tbody > tr > td > div > ul > li > ul > li:nth-child(2) > a");

	// Info descriptiva
	private By consultarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By importarDocuBtn = By.cssSelector("#cabNuevoDoc");
	private By subirLogoMedBtn = By.cssSelector("#cabNuevoDoc");

	//Info contactos
	private By modificarMedContactoBtn = By.cssSelector("#capaAjax > table:nth-child(1) > tbody > tr:nth-child(1) > td > a");

	//Info relacional
	private By modificarMedRelacioBtn = By.cssSelector("#capaAjax > table > tbody > tr:nth-child(1) > td > a");

	//Condiciones de negocio
	private By modificarMedCondiciNegBtn = By.cssSelector("#capaAjax > table > tbody > tr > td > a");

	private By cuadroComisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(1) > div.titulo > a");
	private By buscarArbolComiInput = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(2) > th:nth-child(2)");
	private By grabarArbolComiBtn = By.cssSelector("#buttonRecord");
	private By cancelarArbolComiBtn = By.cssSelector("#buttonCancel");

	private By cuadroSubcomisionesCondiciBtn = By.cssSelector("#capaAjax > div:nth-child(3) > table > tbody > tr > td:nth-child(3) > div.titulo > a");
	private By fechaIniAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHINI");
	private By fechaVenciAsignaSubcomiBtn = By.cssSelector("#SOBCOMFECHFIN");

	private By arbolInput = By.cssSelector("#criterio");
	private By buscarArbolSubcomiBtn = By.cssSelector("body > form > div.contentBox.wideBox > div.marcofnd > table > tbody > tr:nth-child(9) > td:nth-child(3) > input");

	//Contactos
	private By anyadirNuevoContacBtn = By.cssSelector("#cabMedioContacto");
	private By fechaDescendenteBtn = By.cssSelector("#descendenteContactos");
	private By fechaAscendenteBtn = By.cssSelector("#ascendenteContactos");

	//Cambio
	private By situacionCambiosCombo = By.cssSelector("#situacion");

	// endregion

	public MediadoresGestionPage(UserStory userS) {
		super(userS);
	}

	// region methods
	public String getContenidoTituloPagina() {
		debugBegin();
		String contenido = webDriver.getTextInFrame(tituloPaginaTxt, cuerpoFrame);
		debugEnd();

		return contenido;
	}
	// endregion
}
