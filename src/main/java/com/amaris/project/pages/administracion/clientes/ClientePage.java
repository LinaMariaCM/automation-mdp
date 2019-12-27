package com.amaris.project.pages.administracion.clientes;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class ClientePage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By topFrame = By.cssSelector("#leftFrame");
	private By tomadorMenuFrame = By.cssSelector("#mainFrame");
	private By capaIframe = By.cssSelector("#capaIframe");
	
	private By clientesBtn = By.cssSelector("#jt13");
	private By nombreBtn = By.cssSelector("#filtro1");
	private By nifBtn = By.cssSelector("#filtro2");
	private By continuarResultadoBusquedaBtn = By.cssSelector("#capaAjax > table > tbody > tr.odd > td:nth-child(5) > a");

	private By polizaBtn = By.cssSelector("#filtro3");
	private By cotizacionBtn = By.cssSelector("#filtro4");
	private By colectivoBtn = By.cssSelector("#filtro5");
	private By reciboBtn = By.cssSelector("#filtro6");
	private By contactoBtn = By.cssSelector("#filtro7");
	private By buscarBtn = By.name("botonBuscar");

	private By nifInput = By.cssSelector("#numedocu");
	private By nombreInput = By.cssSelector("#nombpcom");
	private By contactoInput = By.cssSelector("#datocont");
	private By reciboInput = By.cssSelector("#recibsec");
	private By cotizacionInput = By.cssSelector("#cotizsec");
	private By colectivoInput = By.cssSelector("#polizNum");
	private By polizaInput = By.cssSelector("#polizsec");
	private By resultadoBusquedaBar = By.xpath("//*[@id='capaAjax']/table[2]/tbody/tr/td");

	private By nuevoIntervenienteBtn = By.xpath("/html/body/div[3]/div/ul/li[4]/a/span");

	private By nuevoTomadorMantBtn = By.cssSelector("div.menuNav.menuNavPosAbsolute li:nth-child(2) > a");

	private By tipoDocumentoBtn = By.cssSelector("#ALTACLIE_TIPODOC");

	// label localización domicilio
	private By provinciaBtn = By.cssSelector("body > ul:nth-child(4) > li > a");
	private By poblacionBtn = By.cssSelector("#ui-active-menuitem");
	private By nombreViaBtn = By.cssSelector("body > ul:nth-child(6) > li");

	private By numeroDocumentoInput = By.cssSelector("#ALTACLIE_NUMDOC");
	private By nombreClienteInput = By.cssSelector("#ALTACLIE_NOMBRE");
	private By apellido1ClienteInput = By.cssSelector("#ALTACLIE_APELLIDO1");
	private By apellido2ClienteInput = By.cssSelector("#ALTACLIE_APELLIDO2");

	private By telefonoFijoInput = By.cssSelector("#ALTACLIE_TELFF_2");
	private By telefonoMovilInput = By.cssSelector("#ALTACLIE_TELFM_1");
	private By emailInput = By.cssSelector("#ALTACLIE_EMAIL_3");
	private By medPrefInput = By.cssSelector("#ALTACLIE_MEDPREF");
	private By fechaNacimientoInput = By.cssSelector("#ALTACLIE_FECNAC");
	private By paisNacionalidadBtn = By.cssSelector("#ALTACLIE_PNACIO");
	private By sexoBtn = By.cssSelector("#ALTACLIE_SEXO");

	private By domicilioFiscalBtn = By.cssSelector("#BOTON_DOMIMEDI");

	// -----Popup Localización del domicilio----------------------
	private By provinciaInput = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By poblacionInput = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By viaInput = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");
	private By codPostInput = By.cssSelector("#ALTACLIE_CODPOST_ARVATO");

	private By comprobarDireccionBtn = By.cssSelector("#BOTON_NORMADOM");
	private By aceptarBtn = By.cssSelector("#BOTON_ACEPTAR");
	private By grabarBtn = By.cssSelector("#botonGrabar");
	private By popUpClientSelect = By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable");
	private By updateClientBtn = By.cssSelector("#botonActualizar");

	private By marcasRelacionesBtn = By.cssSelector("#jt8");

	private By listaNegraBtn = By.cssSelector("#cabListaNegra");

	// marca positiva
	private By marcaPosBtn = By.cssSelector("#pesMARCASPOSCLI");
	private By listBlancaBtn = By.cssSelector("#cabListaBlanca");
	// endregion

	// la variable modificar es la misma que para marca negativa y positiva

	public ClientePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ClientePage accederAlBuscadorClientes() {
		debugBegin();

		webDriver.clickInFrame(clientesBtn, topFrame);
		webDriver.waitWithDriver(4000);

		debugEnd();

		return this;
	}

	public ClientePage clickNuevoTomadorSecond() {
		debugBegin();

		webDriver.clickInFrame(nuevoTomadorMantBtn, tomadorMenuFrame);
		webDriver.waitWithDriver(5000);

		debugEnd();

		return this;
	}

	public ClientePage datosTomador() {
		debugBegin();

		webDriver.clickInFrame(tipoDocumentoBtn, tomadorMenuFrame);

		webDriver.clickElementFromDropDownByTextInFrame(tipoDocumentoBtn, tomadorMenuFrame, getTestVar(Constants.TIPO_DOCUMENTO));
		webDriver.clickInFrame(numeroDocumentoInput, tomadorMenuFrame);

		debugInfo("DNI Tomador" + getScenarioVar(Constants.DNI_TOMADOR));

		webDriver.appendTextInFrame(numeroDocumentoInput, tomadorMenuFrame, getScenarioVar(Constants.DNI_TOMADOR));
		webDriver.appendTextInFrame(nombreClienteInput, tomadorMenuFrame, getConfigVar(Constants.NOMBRE_TOMADOR));
		webDriver.appendTextInFrame(apellido1ClienteInput, tomadorMenuFrame, getConfigVar(Constants.PRIMER_APELLIDO_TOMADOR));
		webDriver.appendTextInFrame(apellido2ClienteInput, tomadorMenuFrame, getConfigVar(Constants.SEGUNDO_APELLIDO_TOMADOR));
		webDriver.appendTextInFrame(telefonoFijoInput, tomadorMenuFrame, getConfigVar(Constants.TELEFONO_FIJO_TOMADOR));

		webDriver.waitWithDriver(6000);

		webDriver.appendTextInFrame(telefonoMovilInput, tomadorMenuFrame, getConfigVar(Constants.TELEFONO_MOVIL_TOMADOR));
		webDriver.appendTextInFrame(emailInput, tomadorMenuFrame, getConfigVar(Constants.EMAIL_TOMADOR));

		webDriver.waitWithDriver(6000);

		// Cmb medio preferido de comunicacion
		webDriver.clickElementFromDropDownByTextInFrame(medPrefInput, tomadorMenuFrame, "Email");
		// Nacionalidad
		webDriver.clickElementFromDropDownByTextInFrame(paisNacionalidadBtn, tomadorMenuFrame, "ANDORRA");
		System.out.println("Fin CMB nacionalidad");

		// Fecha de nacimiento
		webDriver.waitWithDriver(6000);
		webDriver.appendTextInFrame(fechaNacimientoInput, tomadorMenuFrame, getTestVar(Constants.FECHA_NACIMIENTO));

		// Sexo
		webDriver.clickElementFromDropDownByTextInFrame(sexoBtn, tomadorMenuFrame, getTestVar(Constants.SEXO));
		webDriver.clickInFrame(domicilioFiscalBtn, tomadorMenuFrame);

		debugEnd();

		return this;
	}

	public ClientePage localizacionDomicilioTomador() {
		debugBegin();
		webDriver.switchToFrame(tomadorMenuFrame);
		webDriver.switchToFrame(capaIframe);

		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(provinciaInput, getTestVar(Constants.PROVINCIA));
		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(provinciaBtn);

		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(poblacionInput, getTestVar(Constants.POBLACION));
		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(poblacionBtn);

		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(viaInput, getTestVar(Constants.NOMBRE_VIA));
		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(nombreViaBtn);

		// webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(codPostInput, getTestVar(Constants.CODIGO_POSTAL));
		webDriver.waitWithDriver(3000);
		// webDriver.switchToFrame(menuFrameTomador);

		webDriver.isPresentAndClick(comprobarDireccionBtn);
		webDriver.waitWithDriver(2000);
		webDriver.click(aceptarBtn);
		webDriver.waitWithDriver(5000);
		webDriver.exitFrame();
		webDriver.clickInFrame(grabarBtn, tomadorMenuFrame);
		webDriver.waitWithDriver(5000);

		if(webDriver.isPresentInFrame(popUpClientSelect, tomadorMenuFrame)) {
			webDriver.switchToFrame(tomadorMenuFrame);
			webDriver.waitWithDriver(2000);
			webDriver.clickInFrame(updateClientBtn, capaIframe);
		} else {
			debugInfo("Los datos del tomador se han actualizado correctamente");
		}

		// si cliente existe
		// click eb el boton conservar datos antiguos

		debugEnd();

		return this;
	}

	public ClientePage setFiltroBusqueda(String filtro) {
		setTestVar(Constants.FILTRO_BUSCADOR_CLIENTE, filtro);
		debugInfo("Filtro busqueda: " + filtro);

		return this;
	}

	public ClientePage buscarConFiltroBusqueda() {
		debugBegin();

		switch(getTestVar(Constants.FILTRO_BUSCADOR_CLIENTE)) {
			case Constants.FILTRO_BUSCADOR_NOMBRE:
				buscarClientePorNombre();
				break;
			case Constants.FILTRO_BUSCADOR_NIF:
				buscarClientePorNIF();
				break;
			case Constants.FILTRO_BUSCADOR_POLIZA:
				buscarClientePorPoliza();
				break;
			case Constants.FILTRO_BUSCADOR_COTIZACION:
				buscarClientePorCotizacion();
				break;
			case Constants.FILTRO_BUSCADOR_COLECTIVO:
				buscarClientePorColectivo();
				break;
			case Constants.FILTRO_BUSCADOR_RECIBO:
				buscarClientePorRecibo();
				break;
			case Constants.FILTRO_BUSCADOR_CONTACTO:
				buscarClientePorContacto();
				break;
		}

		webDriver.clickInFrame(buscarBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	public ClientePage clickNuevoInterveniente() {
		debugBegin();
		webDriver.clickInFrame(nuevoIntervenienteBtn, cuerpoFrame);
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorContacto() {
		debugBegin();

		webDriver.clickInFrame(contactoBtn, cuerpoFrame);
		webDriver.setTextInFrame(contactoInput, cuerpoFrame, getTestVar(Constants.CONTACTO_CLIENTE));

		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorRecibo() {
		debugBegin();

		webDriver.clickInFrame(reciboBtn, cuerpoFrame);
		webDriver.setTextInFrame(reciboInput, cuerpoFrame, getTestVar(Constants.RECIBO_CLIENTE));

		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorColectivo() {
		debugBegin();

		webDriver.clickInFrame(colectivoBtn, cuerpoFrame);
		webDriver.setTextInFrame(colectivoInput, cuerpoFrame, getTestVar(Constants.COLECTIVO_CLIENTE));

		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorCotizacion() {
		debugBegin();

		webDriver.clickInFrame(cotizacionBtn, cuerpoFrame);
		webDriver.setTextInFrame(cotizacionInput, cuerpoFrame, getTestVar(Constants.NUM_COTIZACION));

		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorPoliza() {
		debugBegin();

		webDriver.clickInFrame(polizaBtn, cuerpoFrame);
		webDriver.setTextInFrame(polizaInput, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));

		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorNombre() {
		debugBegin();

		webDriver.clickInFrame(nombreBtn, cuerpoFrame);
		webDriver.setTextInFrame(nombreInput, cuerpoFrame, getTestVar(Constants.NOMBRE_TOMADOR));

		debugEnd();

		return this;
	}

	public ClientePage buscarClientePorNIF() {
		debugBegin();

		webDriver.clickInFrame(nifBtn, cuerpoFrame);
		webDriver.setTextInFrame(nifInput, cuerpoFrame, getConfigVar(Constants.DNI_TOMADOR));

		webDriver.clickInFrame(buscarBtn, cuerpoFrame);

		debugEnd();

		return this;
	}

	public ClientePage clickContiuarResultadoBusqueda() {
		debugBegin();
		webDriver.clickInFrame(continuarResultadoBusquedaBtn, tomadorMenuFrame);
		debugEnd();

		return this;
	}

	public ClientePage marcaRelacion() {
		debugBegin();
		webDriver.clickInFrame(marcasRelacionesBtn, topFrame);
		debugEnd();

		return this;
	}

	public ClientePage anyadirMarcaNegativa() {
		debugBegin();

		webDriver.clickInFrame(listaNegraBtn, tomadorMenuFrame);
		webDriver.waitWithDriver(2000);

		// webDriver.clickElementFromDropDownByTextInFrame(cmbtipoBlack,capaIframe,
		// "CLIEXCLU");
		// webDriver.clickInFrame(cmbtipoBlack, capaIframe);
		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.clickInFrame(indexTipoMarca, fra);
		debugEnd();

		return this;
	}

	public ClientePage anyadirMarcaPositiva() {
		debugBegin();

		webDriver.clickInFrame(marcaPosBtn, tomadorMenuFrame);
		webDriver.clickInFrame(listBlancaBtn, tomadorMenuFrame);

		debugEnd();

		return this;
	}

	public boolean checkResultadoNIF() {
		debugBegin();

		boolean res = false;

		if(webDriver.isPresentInFrame(resultadoBusquedaBar, cuerpoFrame)) {
			res = webDriver.getTextInFrame(resultadoBusquedaBar, cuerpoFrame).contains("Resultado de la búsqueda (Nº clientes: 1)");
		}

		debugEnd();

		return res;
	}
	// endregion
}
