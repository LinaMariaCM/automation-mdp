package com.amaris.project.pages;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;

public class ClientePage extends PageObject {

	// region webelements
	private By cuerpoFrame = By.name("cuerpo");
	private By menuFrame = By.cssSelector("leftFrame");
	private By cajaMenuCliente = By.cssSelector("#jt6son");
	private By topFrame = By.cssSelector("#leftFrame");
	private By menuFrameTomador = By.cssSelector("#mainFrame");
	private By capaIframe = By.cssSelector("#capaIframe");
	private By frameDomiclilio = By.cssSelector("#dialog-modal >iframe");

	// #topFrame
	private By administracion = By.cssSelector("#jt13");
	private By clientesLink = By.cssSelector("#jt13"); 
	private By rdbNombre = By.cssSelector("filtro1");
	private By checkNif = By.cssSelector("#filtro2");
	private By btnContinuarResultadoBusqueda = By.cssSelector("#capaAjax > table > tbody > tr.odd > td:nth-child(5) > a");

	private By rdbPoliza = By.cssSelector("filtro3");
	private By rdbCotizacion = By.cssSelector("filtro4");
	private By rdbColectivo = By.cssSelector("filtro5");
	private By rdbRecibo = By.cssSelector("filtro6");
	private By rdbContacto = By.cssSelector("filtro7");
	private By btnBuscar = By.name("botonBuscar");

	private By txtNIF = By.cssSelector("#numedocu");
	private By txtNombre = By.cssSelector("#nombpcom");
	private By txtContacto = By.cssSelector("#datocont");
	private By txtRecibo = By.cssSelector("#recibsec");
	private By txtCotizacion = By.cssSelector("#cotizsec");
	private By txtColectivo = By.cssSelector("#polizNum");
	private By txtPoliza = By.cssSelector("#polizsec");
	private By barraResultadoBusqueda = By.xpath("//*[@id='capaAjax']/table[2]/tbody/tr/td");

	private By btnNuevoTomador = By.xpath("/html/body/div[3]/div/ul/li[2]/a/span");
	private By btnNuevoInterveniente = By.xpath("/html/body/div[3]/div/ul/li[4]/a/span");

	private By btnNuevoTomadorMant = By.cssSelector("div.menuNav.menuNavPosAbsolute li:nth-child(2) > a");

	private By drpdwnTipoDocumento = By.cssSelector("#ALTACLIE_TIPODOC");

	private By optionNie = By.cssSelector("#ALTACLIE_TIPODOC > option:nth-child(2)");

	// label localización domicilio
	private By labelProvincia = By.cssSelector("body > ul:nth-child(4) > li > a");
	private By labelPoblacion = By.cssSelector("#ui-active-menuitem");
	private By labelNombreVia = By.cssSelector("body > ul:nth-child(6) > li");
	private By labelCodigoPostal = By.cssSelector("#litePosta");

	private By txtNumeroDocumento = By.cssSelector("#ALTACLIE_NUMDOC");
	private By txtNombreCliente = By.cssSelector("#ALTACLIE_NOMBRE");
	private By txtApellido1Cliente = By.cssSelector("#ALTACLIE_APELLIDO1");
	private By txtApellido1Cliente2 = By.cssSelector("#ALTACLIE_APELLIDO2");

	private By drpdwnTipoCliente = By.cssSelector("#ALTACLIE_TIPOCLIE");
	private By drpdwnIdioma = By.cssSelector("#ALTACLIE_IDIOMA");
	private By drpdwnGestorPersonalizado = By.cssSelector("#ALTACLIE_GESTPER");

	private By cmbTelefonoFijo = By
		.cssSelector("#capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2) > span > div > span.selectAllCountriesALTACLIE_TELFF_2");
	private By txtTelefonoFijo = By.cssSelector("#ALTACLIE_TELFF_2");
	private By cmbTelefonoMovil = By
		.cssSelector("#capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2) > span > div > span.ui-combobox > input");
	private By txtTelefonoMovil = By.cssSelector("#ALTACLIE_TELFM_1");
	private By txtEmail = By.cssSelector("#ALTACLIE_EMAIL_3");
	private By txtMedPref = By.cssSelector("#ALTACLIE_MEDPREF");
	private By cmbPnacim = By.cssSelector("#ALTACLIE_PNACIM");
	private By elementEspa = By.cssSelector("#ALTACLIE_PNACIO > option:nth-child(64)");
	private By btnIconFecha = By.cssSelector("#capaTomadorOtrosDatos > table > tbody > tr:nth-child(2) > td > img");
	private By txtFenac = By.cssSelector("#ALTACLIE_FECNAC");
	private By cmbPnacio = By.cssSelector("#ALTACLIE_PNACIO");
	private By cmbSexo = By.cssSelector("#ALTACLIE_SEXO");
	private By cmbNumHijo = By.cssSelector("#ALTACLIE_NUMHIJ");
	private By cmbSitLab = By.cssSelector("#ALTACLIE_SITLAB");

	private By btnDomicilioFiscal = By.cssSelector("#BOTON_DOMIMEDI");

	// -----Popup Localización del domicilio----------------------

	private By txtPais = By.cssSelector("#ALTACLIE_PNACIO_ARVATO");
	private By txtProvincia = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");
	private By txtPoblacion = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");
	private By txtVia = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");
	private By txtCodPost = By.cssSelector("#ALTACLIE_CODPOST_ARVATO");

	private By btnComprobarDireccion = By.cssSelector("#BOTON_NORMADOM");
	private By btnAceptar = By.cssSelector("#BOTON_ACEPTAR");
	private By btnGrabar = By.cssSelector("#botonGrabar");
	private By popUpClientSelect = By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable");
	private By btnUpdateClient = By.cssSelector("#botonActualizar");

	// crear una nueva tarea
	private By agendaCliente = By.cssSelector("#jt3");

	private By panelNuevaTarea = By.cssSelector("#jt3#cabAnotacion > strong");

	private By nuevaTarea = By.cssSelector("#capaContenido > table > tbody > tr > td > div:nth-child(5) > a");

	private By txtTareaTitulo = By.cssSelector("#titulo");

	private By txtAnnotacion = By.cssSelector("#anotacion");

	private By cmbcategoria = By.cssSelector("#categoria");

	private By cmbPriority = By.cssSelector("#priority");

	private By txtFecha = By.cssSelector("#fechaler");

	private By linkFecha = By.cssSelector("#capaDatosAnotacion > div:nth-child(7) > div.box-field > img");

	private By txtHora = By.cssSelector("div >  input[name= 'horaaler']");

	private By btnGrabartarea = By.cssSelector("body > form > table > tbody > tr > td > input:nth-child(1)");

	private By menuDatosClientes = By.cssSelector("#jt4");

	private By menuMarcasRelaciones = By.cssSelector("#jt8");

	private By linkListaNegra = By.cssSelector("#cabListaNegra");

	// popup marca negativa
	private By indexTipoMarca = By.cssSelector("#motivo > option:nth-child(3)");
	// Valida para marca positiva(motivo)
	private By cmbtipoBlack = By.cssSelector("#motivo");
	private By cmbValorBlack = By.cssSelector("#valblack");
	private By indexValorMarca = By.cssSelector("#valblack > option:nth-child(2)");
	private By btnGrabarBlack = By.cssSelector("#botonGrabar");
	private By cmbAcciones = By.cssSelector("#capaFlecha45");
	// Se utiliza para marca positiva tambien
	private By btnOffBlack = By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");
	private By btnOnBlack = By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");

	// el boton modificar tiene la mismo valor de activar marca, cdo la marca
	// está activa el boton modificar toma su valor

	// marcca positiva
	private By btnMarcaPos = By.cssSelector("#pesMARCASPOSCLI");
	private By linkListBlanca = By.cssSelector("#cabListaBlanca");
	private By txtComent = By.cssSelector("#comentario");
	private By cmbAccionesPosi = By.cssSelector("#capaFlecha49");
	// Valido para las dos marcas
	private By btnBorrar = By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");

	// Add Relación
	private By btnRelaciones = By.cssSelector("#pesRELACIONES");
	private By linkAddRelacion = By.cssSelector("#cabRelacion");

	// pop up Añadir Relación
	private By txtbuqueda = By.cssSelector("#campoBusqueda");
	private By txtTipoRelacion = By.cssSelector("#tipoRelac");
	private By txtEstado = By.cssSelector("#estado");
	private By txtFechaEsta = By.cssSelector("#fechesta");
	private By btnFechaEsta = By.cssSelector("#capaResultado > div.wideBox > div.sis-frame-bg.sis-inner-box.sis-clearfix > div:nth-child(5) > div.box-field > img");
	private By txtComentario = By.cssSelector("#comentario");
	private By btnGrabarRelacion = By.cssSelector("#buttonRecord");
	private By cmbAccionRela = By.cssSelector("#capaFlecha75");
	// endregion

	// la variable modificar es la misma que para marca negativa y positiva

	// webDriver.acceptAlert---> falta el prompt de la alerta "decea eliminar el
	// registro de la relación"

	public ClientePage(UserStory userS) {
		super(userS);
	}

	// region methods
	public ClientePage accederAlBuscadorClientes() {
		debugBegin();
		
		webDriver.waitForElementToBeClickableInFrame(clientesLink, topFrame);
		webDriver.clickInFrame(clientesLink, topFrame);
		webDriver.waitWithDriver(4000);
		
		debugEnd();

		return this;
	}

	
		public ClientePage clickNuevoTomadorSecond() {
		debugBegin();
		
		webDriver.waitForElementToBeClickableInFrame(btnNuevoTomadorMant, menuFrameTomador);
		webDriver.clickInFrame(btnNuevoTomadorMant, menuFrameTomador);
		webDriver.waitWithDriver(5000);
		
		debugEnd();

		return this;
	}

	public ClientePage datosTomador() {
		debugBegin();
		
		webDriver.waitForElementToBeClickableInFrame(drpdwnTipoDocumento, menuFrameTomador);
		webDriver.clickInFrame(drpdwnTipoDocumento, menuFrameTomador);
		debugInfo("Test1");
		webDriver.clickElementFromDropDownByTextInFrame(drpdwnTipoDocumento, menuFrameTomador, getTestVar(Constants.TIPO_DOCUMENTO));
		webDriver.waitForElementToBeClickableInFrame(txtNumeroDocumento, menuFrameTomador);
		webDriver.clickInFrame(txtNumeroDocumento, menuFrameTomador);

		webDriver.appendTextInFrame(txtNumeroDocumento, menuFrameTomador, getTestVar(Constants.DNI_TOMADOR)); // NIE
		webDriver.appendTextInFrame(txtNombreCliente, menuFrameTomador, getConfigVar(Constants.NOMBRE_TOMADOR)); // Nombre
		webDriver.appendTextInFrame(txtApellido1Cliente, menuFrameTomador, getConfigVar(Constants.PRIMER_APELLIDO_TOMADOR)); // Apellido1
		webDriver.appendTextInFrame(txtApellido1Cliente2, menuFrameTomador, getConfigVar(Constants.SEGUNDO_APELLIDO_TOMADOR)); // Apellido2
		webDriver.appendTextInFrame(txtTelefonoFijo, menuFrameTomador, getConfigVar(Constants.TELEFONO_FIJO_TOMADOR)); // Fijo

		webDriver.waitWithDriver(6000);

		webDriver.appendTextInFrame(txtTelefonoMovil, menuFrameTomador, getConfigVar(Constants.TELEFONO_MOVIL_TOMADOR)); // Movil
		webDriver.appendTextInFrame(txtEmail, menuFrameTomador, getConfigVar(Constants.EMAIL_TOMADOR)); // Email
		
		webDriver.waitWithDriver(6000);
		
		// Cmb medio preferido de comunicacion
		webDriver.clickElementFromDropDownByTextInFrame(txtMedPref, menuFrameTomador, "Email");
		// Nacionalidad
		webDriver.clickElementFromDropDownByTextInFrame(cmbPnacio, menuFrameTomador, "ANDORRA");
		System.out.println("Fin CMB nacionalidad");
		
		// Fecha de nacimiento
		webDriver.waitWithDriver(6000);
		webDriver.appendTextInFrame(txtFenac, menuFrameTomador, getTestVar(Constants.FECHA_NACIMIENTO));

		// Sexo
		webDriver.clickElementFromDropDownByTextInFrame(cmbSexo, menuFrameTomador, getTestVar(Constants.SEXO));
		webDriver.clickInFrame(btnDomicilioFiscal, menuFrameTomador);
		
		debugEnd();

		return this;
	}

	public ClientePage localizacionDomicilioTomador() {
		debugBegin();
		webDriver.switchToFrame(menuFrameTomador);
        webDriver.switchToFrame(capaIframe);
		
		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(txtProvincia, getTestVar(Constants.PROVINCIA));
		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(labelProvincia);

		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(txtPoblacion, getTestVar(Constants.POBLACION));
		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(labelPoblacion);

		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(txtVia, getTestVar(Constants.NOMBRE_VIA));
		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.click(labelNombreVia);

		//webDriver.switchToFrame(menuFrameTomador);
		webDriver.appendText(txtCodPost, getTestVar(Constants.CODIGO_POSTAL));
		webDriver.waitWithDriver(3000);
		//webDriver.switchToFrame(menuFrameTomador);
		
		webDriver.isPresentAndClick(btnComprobarDireccion);
		webDriver.waitWithDriver(2000);
		webDriver.click(btnAceptar);
		webDriver.waitWithDriver(5000);
		webDriver.exitFrame();
		webDriver.clickInFrame(btnGrabar, menuFrameTomador);
		webDriver.waitWithDriver(5000);
		
		if(webDriver.isPresentInFrame(popUpClientSelect, menuFrameTomador)) {
			webDriver.switchToFrame(menuFrameTomador);
			webDriver.waitWithDriver(2000);
			webDriver.clickInFrame(btnUpdateClient, capaIframe);
		} else {
			System.out.print("Los datos del tomador se han actualizado correctamente");
		}

		// si cliente existe
		// click eb el boton conservar datos antiguos
		
		debugEnd();

		return this;
	}

	// if(webDriver.switchToFrame();

	// webDriver.clickInFrame(btnComprobarDireccion,capaIframe

	// ) }else {

	/*
	 * public ClientePage nuevoClienteSeleccionado() {---------> Ahora no aparece esto
	 * webDriver.switchToFrame(menuFrameTomador);
	 * webDriver.clickInFrame(btnGrabar,menuFrameTomador);
	 * //webDriver.clickInFrame(btnGrabar,menuFrameTomador);
	 * 
	 * }
	 */

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

		// Click btn buscar
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);
		debugEnd();

		return this;
	}

	public ClientePage clickNuevoInterveniente() {
		debugBegin();
		webDriver.clickInFrame(btnNuevoInterveniente, cuerpoFrame);
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorContacto() {
		debugBegin();
		
		webDriver.clickInFrame(rdbContacto, cuerpoFrame);

		// Set Contacto
		// webDriver.clearAndSetTextInWebElementInFrame(txtContacto,
		// cuerpoFrame, tData.getContactoCliente());
		webDriver.setTextInFrame(txtContacto, cuerpoFrame, getTestVar(Constants.CONTACTO_CLIENTE));
		
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorRecibo() {
		debugBegin();
		
		webDriver.clickInFrame(rdbRecibo, cuerpoFrame);

		// Set Recibo
		// webDriver.clearAndSetTextInWebElementInFrame(txtRecibo,
		// cuerpoFrame, tData.getReciboCliente());
		webDriver.setTextInFrame(txtRecibo, cuerpoFrame, getTestVar(Constants.RECIBO_CLIENTE));
		
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorColectivo() {
		debugBegin();
		webDriver.clickInFrame(rdbColectivo, cuerpoFrame);

		// Set Cotizacion
		// webDriver.clearAndSetTextInWebElementInFrame(txtColectivo,
		// cuerpoFrame, tData.getColectivoCliente());
		webDriver.setTextInFrame(txtColectivo, cuerpoFrame, getTestVar(Constants.COLECTIVO_CLIENTE));
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorCotizacion() {
		debugBegin();
		
		webDriver.clickInFrame(rdbCotizacion, cuerpoFrame);

		// Set Cotizacion
		// webDriver.clearAndSetTextInWebElementInFrame(txtCotizacion,
		// cuerpoFrame, tData.getNoCotizacion());
		webDriver.setTextInFrame(txtCotizacion, cuerpoFrame, getTestVar(Constants.NUM_COTIZACION));
		
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorPoliza() {
		debugBegin();
		
		webDriver.clickInFrame(rdbPoliza, cuerpoFrame);

		// Set Poliza

		// webDriver.clearAndSetTextInWebElementInFrame(txtPoliza,
		// cuerpoFrame, tData.getNumPoliza().toString());
		webDriver.setTextInFrame(txtPoliza, cuerpoFrame, getTestVar(Constants.NUM_POLIZA));
		
		debugEnd();

		return this;
	}

	private ClientePage buscarClientePorNombre() {
		debugBegin();
		
		webDriver.clickInFrame(rdbNombre, cuerpoFrame);

		// Set Nombre
		webDriver.clearText(txtNombre);
		webDriver.appendTextInFrame(txtNombre, cuerpoFrame, getTestVar(Constants.NOMBRE_TOMADOR));
		
		debugEnd();

		return this;
	}

	/*
	 * public ClientePage buscarClientePorNIF() {//aporte jenney
	 * 
	 * 
	 * buscarClientePorNIF(userS.getTestVar("ci")); }
	 */

	public ClientePage buscarClientePorNIF() {
		debugBegin();
		
		webDriver.clickInFrame(checkNif, cuerpoFrame);
		webDriver.setTextInFrame(txtNIF, cuerpoFrame, getScenarioVar(Constants.DOCUMENTO_INQUILINO));
		webDriver.clickInFrame(btnBuscar, cuerpoFrame);
		
		debugEnd();

		return this;
	}

	public ClientePage clickContiuarResultadoBusqueda() {
		debugBegin();
		webDriver.clickInFrame(btnContinuarResultadoBusqueda, menuFrameTomador);
		debugEnd();

		return this;
	}

	public ClientePage marcaRelacion() {
		debugBegin();
		webDriver.clickInFrame(menuMarcasRelaciones, topFrame);
		debugEnd();

		return this;
	}

	public ClientePage anadirMarcaNegativa() {
		debugBegin();
		
		webDriver.clickInFrame(linkListaNegra, menuFrameTomador);
		webDriver.switchToFrame(menuFrameTomador);
		webDriver.waitWithDriver(2000);

		// webDriver.clickElementFromDropDownByTextInFrame(cmbtipoBlack,capaIframe,
		// "CLIEXCLU");
		// webDriver.clickInFrame(cmbtipoBlack, capaIframe);
		// webDriver.switchToFrame(cuerpoFrame);
		// webDriver.clickInFrame(indexTipoMarca, fra);
		debugEnd();

		return this;
	}

	public ClientePage anadirMarcaPositiva() {
		debugBegin();

		webDriver.clickInFrame(btnMarcaPos, menuFrameTomador);
		webDriver.clickInFrame(linkListBlanca, menuFrameTomador);

		debugEnd();

		return this;
	}

	public boolean checkResultadoNIF() {
		debugBegin();

		boolean res = false;
		if(webDriver.isPresentInFrame(barraResultadoBusqueda, cuerpoFrame)) {
			res = webDriver.getTextInFrame(barraResultadoBusqueda, cuerpoFrame).contains("Resultado de la búsqueda (Nº clientes: 1)");
		}

		debugEnd();

		return res;
	}
	// endregion
}
