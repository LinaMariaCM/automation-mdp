package com.amaris.project.pages.administracion.mediadores;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class MediadoresAltaDatosRelacionalesPage extends PageObject {

	private By mainFrame = By.cssSelector("#mainFrame");
	private By modalFrame = By.cssSelector("#capaIframe");
	private By menuFrame = By.cssSelector("#leftFrame");
	private By topFrame = By.cssSelector("#topFrame");

	private By especialistaRamoSIBtn = By.id("ALTAMEDI_ESPRAMOSI");
	private By especialistaRamoNOBtn = By.id("ALTAMEDI_ESPRAMONO");
	private By especialistaRamoCombo = By.id("ALTAMEDI_RAMO");

	private By adminFincasSIBtn = By.id("ALTAMEDI_FINCASSI");
	private By adminFincasNOBtn = By.id("ALTAMEDI_FINCASNO");
	private By adminFincasCuantasInput = By.id("ALTAMEDI_FINCAS");

	private By medNuevoProductoBtn = By.linkText("Añadir nuevo producto");
	private By nuevoProductoCombo = By.id("ALTAMEDI_PRODUCT");
	private By nuevoProdCompPrincipalCombo = By.id("ALTAMEDI_COMPRIN");
	private By nuevoProdCompSecundariaCombo = By.id("ALTAMEDI_COMSECU");

	private By potencialNPCombo = By.id("ALTAMEDI_POTNP");
	private By autonomoProyectosSIBtn = By.id("ALTAMEDI_AUTOSI");
	private By autonomoProyectosNOBtn = By.id("ALTAMEDI_AUTONO");
	private By compPrincipInput = By.id("ALTAMEDI_COMPPRIN");

	private By medNuevoBancoBtn = By.linkText("Añadir nuevo banco");
	private By nombreBancoInput = By.id("ALTAMEDI_NOMBANCO");
	private By observacionesBancoInput = By.id("ALTAMEDI_OBSBANCO");

	private By valorarDelegadoCombo = By.id("ALTAMEDI_VALDEL");

	private By grabarBtn = By.id("buttonRecord");
	private By cancelarBtn = By.id("buttonCancel");

	//-----------Controles de pagina---------------------------

	private By cancelarDescripcionBtn = By.id("botonCancelar1");
	private By guardarDescripcionBtn = By.id("botonGrabar1");
	private By continuarBtn = By.id("botonContinuar1");

	public MediadoresAltaDatosRelacionalesPage(UserStory userS) {
		super(userS);
	}
}
