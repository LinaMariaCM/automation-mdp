package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.google.common.collect.TreeMultiset;
import com.project.ProjectConstants;
import com.project.steps.Steps;

import net.bytebuddy.asm.Advice.Enter;

//import com.mutuaPropietarios.WebdriverContext.BrowserContext;
//import com.mutuaPropietarios.WebdriverContext.Helpers.WebElementHelper;
//import com.mutuaPropietarios.testCasesData.context.ProjectConstants;
//import com.mutuaPropietarios.testCasesData.context.TestCaseData;

public class ClientePage extends PageObject {

	// region webelements
	
	@FindBy(name = "cuerpo")
	private By cuerpoFrame = By.name("cuerpo");

	@FindBy(id = "leftFrame")
	private By menuFrame = By.cssSelector("leftFrame");
	
	
	@FindBy(id = "leftFrame")
	private By cajaMenuCliente = By.cssSelector("#jt6son");
	
	private By topFrame = By.cssSelector("#leftFrame");
	
	//#topFrame
	@FindBy(id = "#jt13")
	private By administracion = By.cssSelector("#jt13");
	
	//@FindBy(id = "leftFrame")
	//private By menuFrameCliente = By.cssSelector("#layerInner > div > div");

  @FindBy(id= "#jt13")
	private By clientesLink = By.cssSelector("#jt13");
		//+ "#jt6son > #jt13");
	
	//@FindBy(id = "#jt13")                        
	//private By clientesLink = By.cssSelector("#jt13");
	
	@FindBy(id = "filtro1")
	private By rdbNombre = By.cssSelector("filtro1");

	@FindBy(id = "filtro2")
	private By rdbNIF = By.cssSelector("filtro2");

	@FindBy(id = "filtro3")
	private By rdbPoliza = By.cssSelector("filtro3");

	@FindBy(id = "filtro4")
	private By rdbCotizacion = By.cssSelector("filtro4");

	@FindBy(id = "filtro5")
	private By rdbColectivo = By.cssSelector("filtro5");

	@FindBy(id = "filtro6")
	private By rdbRecibo = By.cssSelector("filtro6");

	@FindBy(id = "filtro7")
	private By rdbContacto = By.cssSelector("filtro7");

	@FindBy(name = "botonBuscar")
	private By btnBuscar = By.name("botonBuscar");

	@FindBy(id = "numedocu")
	private By txtNIF = By.cssSelector("#numedocu");

	@FindBy(id = "nombpcom")
	private By txtNombre = By.cssSelector("#nombpcom");


	@FindBy(id = "datocont")
	private By txtContacto = By.cssSelector("#datocont");

	@FindBy(id = "recibsec")
	private By txtRecibo = By.cssSelector("#recibsec");                     

	@FindBy(id = "cotizsec")
	private By txtCotizacion = By.cssSelector("#cotizsec");                        

	@FindBy(id = "polizNum")
	private By txtColectivo = By.cssSelector("#polizNum");

	@FindBy(id = "polizsec")
	private By txtPoliza = By.cssSelector("#polizsec");                        

	@FindBy(xpath = "//*[@id='capaAjax']/table[2]/tbody/tr/td")//-------->esta variable no la encontre al parecer no se utilza
	private By barraResultadoBusqueda = By.xpath("//*[@id='capaAjax']/table[2]/tbody/tr/td");

	//@FindBy(xpath = ".//*[text()='Nuevo Tomador']")
	//private By btnNuevoTomador = By.xpath(".//*[text()='Nuevo Tomador']");

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a/span")
	private By btnNuevoTomador = By.xpath("/html/body/div[3]/div/ul/li[2]/a/span");
	
	//@FindBy(xpath = ".//*[text()='Nuevo Interveniente']")
	//private By btnNuevoInterveniente = By.xpath(".//*[text()='Nuevo Interveniente']");
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[4]/a/span")
	private By btnNuevoInterveniente = By.xpath("/html/body/div[3]/div/ul/li[4]/a/span");

	
	@FindBy(id = "#mainFrame")
	private By menuFrameTomador = By.cssSelector("#mainFrame");
	
	@FindBy(id = "#capaIframe")
	private By capaIframe = By.cssSelector("#capaIframe");
	
	@FindBy(id = "#dialog-modal > .ifrmodal")
	private By frameDomiclilio = By.cssSelector("#dialog-modal >iframe");
	
	
	@FindBy(id = "body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(2) > a")
	private By btnNuevoTomadorMant = By.cssSelector("body > div.menuNav.menuNavPosAbsolute > div > ul > li:nth-child(2) > a");
	
	@FindBy(id = "ALTACLIE_TIPODOC")
	private By drpdwnTipoDocumento = By.cssSelector("#ALTACLIE_TIPODOC");   
	
	@FindBy(id = "#ALTACLIE_TIPODOC > option:nth-child(3)")
	private By optionNie = By.cssSelector("#ALTACLIE_TIPODOC > option:nth-child(2)");
	
	
	//@FindBy(id = "ALTACLIE_TIPODOC > option[value="NIE"]")
	//private By drpdwnTipoDocumento1 = By.cssSelector("#ALTACLIE_TIPODOC > option[value="NIE"]");   
	
	//label localización domicilio
	@FindBy(id = "body > ul:nth-child(4) > li > a")
	private By labelProvincia = By.cssSelector("body > ul:nth-child(4) > li > a");
	
	@FindBy(id = "#ui-active-menuitem")
	private By labelPoblacion = By.cssSelector("#ui-active-menuitem");
	
	
	
	@FindBy(id = "body > ul:nth-child(6) > li")
	private By labelNombreVia = By.cssSelector("body > ul:nth-child(6) > li");
	
	@FindBy(id = "#litePosta")
	private By labelCodigoPostal = By.cssSelector("#litePosta");
	
	//txt localización de domicilio
	@FindBy(id = "ALTACLIE_NUMDOC")
	private By txtNumeroDocumento = By.cssSelector("#ALTACLIE_NUMDOC");

	@FindBy(id = "ALTACLIE_TIPOCLIE")
	private By drpdwnTipoCliente = By.cssSelector("#ALTACLIE_TIPOCLIE");

	@FindBy(id = "ALTACLIE_NOMBRE")
	private By txtNombreCliente = By.cssSelector("#ALTACLIE_NOMBRE");

	@FindBy(id = "ALTACLIE_APELLIDO1")
	private By txtApellido1Cliente = By.cssSelector("#ALTACLIE_APELLIDO1");

	//@FindBy(id = "ALTACLIE_RAZSOC")
	//private By txtRazonSocial = By.cssSelector("ALTACLIE_RAZSOC");
	
	@FindBy(id = "#ALTACLIE_APELLIDO2")
	private By txtApellido1Cliente2 = By.cssSelector("#ALTACLIE_APELLIDO2");
	
	
	@FindBy(id = "ALTACLIE_IDIOMA")
	private By drpdwnIdioma = By.cssSelector("#ALTACLIE_IDIOMA");                        

	@FindBy(id = "ALTACLIE_GESTPER")
	private By drpdwnGestorPersonalizado = By.cssSelector("#ALTACLIE_GESTPER");

	@FindBy(id = "capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2) > span > div > span.selectAllCountries")
	private By cmbTelefonoFijo = By.cssSelector("#capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2) > span > div > span.selectAllCountriesALTACLIE_TELFF_2");
	
	@FindBy(id = "ALTACLIE_TELFF_2")
	private By txtTelefonoFijo = By.cssSelector("#ALTACLIE_TELFF_2");                        
	
	@FindBy(id = "capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2) > span > div > span.ui-combobox > input")
	private By cmbTelefonoMovil = By.cssSelector("#capaOtrosDatosTomador > div > div.marcofnd > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2) > span > div > span.ui-combobox > input");                        

	@FindBy(id = "ALTACLIE_TELFM_1")
	private By txtTelefonoMovil = By.cssSelector("#ALTACLIE_TELFM_1");                        
	
	@FindBy(id = "ALTACLIE_EMAIL_3")
	private By txtEmail = By.cssSelector("#ALTACLIE_EMAIL_3");                        
	
	@FindBy(id = "#ALTACLIE_MEDPREF")
	private By txtMedPref = By.cssSelector("#ALTACLIE_MEDPREF");                        
	
	@FindBy(id = "ALTACLIE_PNACIM")
	private By cmbPnacim = By.cssSelector("#ALTACLIE_PNACIM");    
	
	@FindBy(id = "#ALTACLIE_PNACIO > option:nth-child(64)")
	private By elementEspa = By.cssSelector("#ALTACLIE_PNACIO > option:nth-child(64)");
	
	
	@FindBy(id = "capaTomadorOtrosDatos > table > tbody > tr:nth-child(2) > td > img")
	private By btnIconFecha = By.cssSelector("#capaTomadorOtrosDatos > table > tbody > tr:nth-child(2) > td > img");                        
	
	@FindBy(id = "ALTACLIE_FECNAC")
	private By txtFenac = By.cssSelector("#ALTACLIE_FECNAC");                        
	
	@FindBy(id = "ALTACLIE_PNACIO")
	private By cmbPnacio = By.cssSelector("#ALTACLIE_PNACIO");                        
	
	@FindBy(id = "ALTACLIE_SEXO")
	private By cmbSexo = By.cssSelector("#ALTACLIE_SEXO");                        
	
	@FindBy(id = "ALTACLIE_NUMHIJ")
	private By cmbNumHijo = By.cssSelector("#ALTACLIE_NUMHIJ");                        
	
	@FindBy(id = "ALTACLIE_SITLAB")
	private By cmbSitLab = By.cssSelector("#ALTACLIE_SITLAB");                        
	
	@FindBy(id = "BOTON_DOMIMEDI")
	private By btnDomicilioFiscal = By.cssSelector("#BOTON_DOMIMEDI");

	
	//-----Popup Localización del domicilio----------------------
	/*@FindBy(id = "#capaIframe")
	private By domicilioFrame = By.cssSelector("#capaIframe");
	
	@FindBy(xpath = "//*[@id=\"ALTACLIE_PROVINCIA_ARVATO\"]")
	private By txtProvincia = By.xpath("//*[@id=\"ALTACLIE_PROVINCIA_ARVATO\"]");
	
	@FindBy(xpath = "//*[@id=\"ALTACLIE_POBLACION_ARVATO\"]")
	private By txtPoblacion = By.xpath("//*[@id=\"ALTACLIE_POBLACION_ARVATO\"]");*/
	
	@FindBy(id = "#ALTACLIE_PNACIO_ARVATO")
	private By txtPais = By.cssSelector("#ALTACLIE_PNACIO_ARVATO");
	
	@FindBy(id = "ALTACLIE_PROVINCIA_ARVATO")
	private By txtProvincia = By.cssSelector("#ALTACLIE_PROVINCIA_ARVATO");

	@FindBy(id = "ALTACLIE_POBLACION_ARVATO")
	private By txtPoblacion = By.cssSelector("#ALTACLIE_POBLACION_ARVATO");

	@FindBy(id = "ALTACLIE_NOMVIA_ARVATO")
	private By txtVia = By.cssSelector("#ALTACLIE_NOMVIA_ARVATO");                        
	
	@FindBy(id = "ALTACLIE_CODPOST_ARVATO")
	private By txtCodPost = By.cssSelector("#ALTACLIE_CODPOST_ARVATO");
	
	@FindBy(id = "#BOTON_NORMADOM")
	private By btnComprobarDireccion = By.cssSelector("#BOTON_NORMADOM");

	@FindBy(id = "#BOTON_ACEPTAR")
	private By btnAceptar = By.cssSelector("#BOTON_ACEPTAR");

	@FindBy(id = "botonGrabar")
	private By btnGrabar = By.cssSelector("#botonGrabar");
	// endregion
	
	// crear una nueva tarea
	@FindBy(id = "botonGrabar")
	private By agendaCliente = By.cssSelector("#jt3");
	
	@FindBy(id = "#jt3#cabAnotacion > strong")
	private By panelNuevaTarea = By.cssSelector("#jt3#cabAnotacion > strong");
	
	@FindBy(id = "#capaContenido > table > tbody > tr > td > div:nth-child(5) > a")
	private By nuevaTarea = By.cssSelector("#capaContenido > table > tbody > tr > td > div:nth-child(5) > a");
	
	@FindBy(id = "#titulo")
	private By txtTareaTitulo = By.cssSelector("#titulo");
	
	@FindBy(id = "#anotacion")
	private By txtAnnotacion = By.cssSelector("#anotacion");
	
	@FindBy(id = "#categoria")
	private By cmbcategoria = By.cssSelector("#categoria");
	
	@FindBy(id = "#priority")
	private By cmbPriority = By.cssSelector("#priority");
	
	@FindBy(id = "#fechaler")
	private By txtFecha = By.cssSelector("#fechaler");
	
	@FindBy(id = " #capaDatosAnotacion > div:nth-child(7) > div.box-field > img")
	private By linkFecha = By.cssSelector("#capaDatosAnotacion > div:nth-child(7) > div.box-field > img");
	
	@FindBy(id = "div >  input[name= 'horaaler']")
	private By txtHora = By.cssSelector("div >  input[name= 'horaaler']");
	
	@FindBy(id = "body > form > table > tbody > tr > td > input:nth-child(1)")
	private By btnGrabartarea = By.cssSelector("body > form > table > tbody > tr > td > input:nth-child(1)");
	
	@FindBy(id ="#jt4" )
	private By menuDatosClientes = By.cssSelector("#jt4");
	
	@FindBy(id ="#jt8" )
	private By menuMarcasRelaciones = By.cssSelector("#jt8");
	
	@FindBy(id ="#cabListaNegra" )
	private By linkListaNegra= By.cssSelector("#cabListaNegra");
	
	//popup marca negativa
	
	@FindBy(id =" #motivo" )
	private By cmbtipoBlack= By.cssSelector("#motivo");//valida para marca positiva(motivo)
	
	@FindBy(id ="#valblack" )
	private By cmbValorBlack= By.cssSelector("#valblack");
	
	@FindBy(id ="#botonGrabar" )
	private By btnGrabarBlack= By.cssSelector("#botonGrabar");
	
	@FindBy(id ="#capaFlecha45" )
	private By cmbAcciones= By.cssSelector("#capaFlecha45");
	
	@FindBy(id ="body > div.pdata > div > ul > li:nth-child(2) > a" )// borrar relacion tambien
	private By btnOffBlack= By.cssSelector("body > div.pdata > div > ul > li:nth-child(2) > a");//se utiliza para marca posiviva tambien
	
	@FindBy(id ="body > div.pdata > div > ul > li:nth-child(1) > a" )
	private By btnOnBlack= By.cssSelector("body > div.pdata > div > ul > li:nth-child(1) > a");
	
	// el boton modificar tiene la mismo valor de activar marca, cdo la marca está activa el boton modificar toma su valor
	
	
    // marcca positiva
	
	@FindBy(id = "#pesMARCASPOSCLI")
	private By btnMarcaPos= By.cssSelector("#pesMARCASPOSCLI");
	
	@FindBy(id = "#cabListaBlanca")
	private By linkListBlanca = By.cssSelector("#cabListaBlanca");
	
	@FindBy(id = "#comentario")
	private By txtComent = By.cssSelector("#comentario");
	
	@FindBy(id = "#capaFlecha49")
	private By cmbAccionesPosi= By.cssSelector("#capaFlecha49");
	
	@FindBy(id = "body > div.pdata > div > ul > li:nth-child(3) > a")
	private By btnBorrar= By.cssSelector("body > div.pdata > div > ul > li:nth-child(3) > a");//valido para las dos marcas
	
	//Add Relación 
	
	@FindBy(id = "#pesRELACIONES")
	private By btnRelaciones= By.cssSelector("#pesRELACIONES");
	
	@FindBy(id = "#cabRelacion")
	private By linkAddRelacion= By.cssSelector("#cabRelacion");
	
	//pop up Añadir Relación 
	
	@FindBy(id = "#campoBusqueda")
	private By txtbuqueda= By.cssSelector("#campoBusqueda");
	
	@FindBy(id = "#tipoRelac")
	private By txtTipoRelacion= By.cssSelector("#tipoRelac");
	
	@FindBy(id = "#estado")
	private By txtEstado= By.cssSelector("#estado");
	
	@FindBy(id = "#fechesta")
	private By txtFechaEsta= By.cssSelector("#fechesta");
	
	@FindBy(id = "#capaResultado > div.wideBox > div.sis-frame-bg.sis-inner-box.sis-clearfix > div:nth-child(5) > div.box-field > img")
	private By btnFechaEsta= By.cssSelector("#capaResultado > div.wideBox > div.sis-frame-bg.sis-inner-box.sis-clearfix > div:nth-child(5) > div.box-field > img");
	
	@FindBy(id = "#comentario")
	private By txtComentario= By.cssSelector("#comentario");
	
	@FindBy(id = "#buttonRecord")
	private By btnGrabarRelacion= By.cssSelector("#buttonRecord");
	
	@FindBy(id = "#capaFlecha75")
	private By cmbAccionRela= By.cssSelector("#capaFlecha75");
	
	// la variable modificar es la misma que para marca negativa y positiva
	

	//webDriver.acceptAlert---> falta el prompt de la alerta "decea eliminar el registro de la relación"
	
	

	public ClientePage(UserStory userS) {
		super(userS);
	}

	// region methods
	
	public void clickNuevoTomador() {//aporte jenney
		
		this.webDriver.waitForElementToBeClickableInFrame(this.clientesLink, this.topFrame);
		this.webDriver.clickInFrame(this.clientesLink, this.topFrame);
		this.webDriver.waitForElementToBeClickableInFrame(this.btnNuevoTomadorMant, this.menuFrameTomador);
		this.webDriver.clickInFrame(this.btnNuevoTomadorMant, this.menuFrameTomador);
	}
	
	public void datosTomador() {//aporte Jenney
		
		this.webDriver.waitForElementToBeClickableInFrame(this.drpdwnTipoDocumento, this.menuFrameTomador);
	    this.webDriver.clickInFrame(this.drpdwnTipoDocumento, this.menuFrameTomador);
	    debugInfo("Test1");
	    this.webDriver.clickElementFromDropDownByTextInFrame(this.drpdwnTipoDocumento,this.menuFrameTomador,this.getTestVar("tipo_documento"));
	    this.webDriver.waitForElementToBeClickableInFrame(this.txtNumeroDocumento, this.menuFrameTomador);
	    this.webDriver.clickInFrame(this.txtNumeroDocumento, this.menuFrameTomador);
	    //NIE
	    this.webDriver.appendTextInFrame(this.txtNumeroDocumento,this.menuFrameTomador,this.getTestVar("ci"));
	    //Nombre
	    this.webDriver.appendTextInFrame(this.txtNombreCliente,this.menuFrameTomador,this.getTestVar("nombre"));
	    //Apellido1
	    this.webDriver.appendTextInFrame(this.txtApellido1Cliente,this.menuFrameTomador,this.getTestVar("apellido1"));
	    //Apellido2
	    this.webDriver.appendTextInFrame(this.txtApellido1Cliente2,this.menuFrameTomador,this.getTestVar("apellido2"));
	    //txt telefono fijo
	    this.webDriver.appendTextInFrame(this.txtTelefonoFijo,this.menuFrameTomador,this.getTestVar("phone_fijo"));
	    
	    this.webDriver.waitWithDriver(6000);
	    //telefono movil
	    this.webDriver.appendTextInFrame(this.txtTelefonoMovil,this.menuFrameTomador,this.getTestVar("phone_movil"));
	    //email
	    this.webDriver.appendTextInFrame(this.txtEmail,this.menuFrameTomador,this.getTestVar("email"));
	    this.webDriver.waitWithDriver(6000);
	    //cmb medio preferido de comunicacion
	    this.webDriver.clickElementFromDropDownByTextInFrame(this.txtMedPref,this.menuFrameTomador,"Email");
	     //nacionalidad
	    this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbPnacio,this.menuFrameTomador,"ANDORRA");
	    System.out.println("Fin CMB nacionalidad");
	    //fecha de nacimiento
	    this.webDriver.waitWithDriver(6000);
	    this.webDriver.appendTextInFrame(this.txtFenac,this.menuFrameTomador,this.getTestVar("fecha_nacimiento"));//hasta aqui perfecto
	 
	    //sexo
	    this.webDriver.clickElementFromDropDownByTextInFrame(this.cmbSexo,this.menuFrameTomador,this.getTestVar("sexo"));
	    this.webDriver.clickInFrame(this.btnDomicilioFiscal, this.menuFrameTomador);
	}
	
	public void localizacionDomicilioTomador(){//aporte Jenney
		
	   debugInfo("Test1");
	    //dirección
	    //boton domiciliohttp://mant-innova.mutuadepropietarios.es/web/
	    //this.webDriver.appendText(this.txtProvincia,"Barcelona");
	    this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.appendTextInFrame(this.txtProvincia,this.capaIframe,this.getTestVar("provincia"));
	    this.webDriver.switchToFrame(this.menuFrameTomador);
        this.webDriver.clickInFrame(this.labelProvincia, this.capaIframe);
        
        this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.appendTextInFrame(this.txtPoblacion,this.capaIframe, this.getTestVar("poblacion"));	 
	    this.webDriver.switchToFrame(this.menuFrameTomador);
        this.webDriver.clickInFrame(this.labelPoblacion, this.capaIframe);
       
        this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.appendTextInFrame(this.txtVia,this.capaIframe,this.getTestVar("via"));
	    this.webDriver.switchToFrame(this.menuFrameTomador);
        this.webDriver.clickInFrame(this.labelNombreVia, this.capaIframe);
        
	    this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.appendTextInFrame(this.txtCodPost,this.capaIframe, this.getTestVar("codigo_postal"));
	    this.webDriver.waitWithDriver(3000);
	    
	    this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.waitWithDriver(3000);
	    this.webDriver.clickInFrame(this.btnComprobarDireccion,this.capaIframe);
	    
	    this.webDriver.switchToFrame(this.menuFrameTomador);
	    this.webDriver.waitWithDriver(2000);
	    this.webDriver.clickInFrame(this.btnAceptar,this.capaIframe);
	    
	    this.webDriver.waitWithDriver(5000);
	    
	    this.webDriver.clickInFrame(this.btnGrabar,this.menuFrameTomador);
	    }
	    
	    /*public void nuevoClienteSeleccionado() {---------> Ahora no aparece esto
	    	this.webDriver.switchToFrame(this.menuFrameTomador);
	    	this.webDriver.clickInFrame(this.btnGrabar,this.menuFrameTomador);
	    	//this.webDriver.clickInFrame(this.btnGrabar,this.menuFrameTomador);
	    	
	    }*/


		
	
	//#mainFrame  div   #dialog-modal > .ifrmodal 
	

	public void setFiltroBusqueda(String filtro) {
		// this.tData.setFiltroBuscadorCliente(filtro);
		this.userS.setTestVar("FiltroBuscadorCliente", filtro);
	}

	public void buscarConFiltroBusqueda() {
		debugBegin();

		switch(this.userS.getTestVar("FiltroBuscadorCliente")) {
			case ProjectConstants.FILTRO_BUSCADOR_NOMBRE:
				this.buscarClientePorNombre();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_NIF:
				this.buscarClientePorNIF();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_POLIZA:
				this.buscarClientePorPoliza();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_COTIZACION:
				this.buscarClientePorCotizacion();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_COLECTIVO:
				this.buscarClientePorColectivo();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_RECIBO:
				this.buscarClientePorRecibo();
				break;
			case ProjectConstants.FILTRO_BUSCADOR_CONTACTO:
				this.buscarClientePorContacto();
				break;
		}

		// Click btn buscar
		this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
		debugEnd();
	}

	/*public void clickNuevoTomador() {
		this.webDriver.clickInFrame(this.btnNuevoTomador, this.cuerpoFrame);
	}*/

	public void clickNuevoInterveniente() {
		this.webDriver.clickInFrame(this.btnNuevoInterveniente, this.cuerpoFrame);
	}

	private void buscarClientePorContacto() {
		// Click en el rdb Contacto
		this.webDriver.clickInFrame(this.rdbContacto, this.cuerpoFrame);

		// Set Contacto
		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtContacto,
		// this.cuerpoFrame, this.tData.getContactoCliente());
		this.webDriver.setTextInFrame(this.txtContacto, this.cuerpoFrame, this.userS.getTestVar("ContactoCliente"));
	}

	private void buscarClientePorRecibo() {
		// Click en el rdb Recibo
		this.webDriver.clickInFrame(this.rdbRecibo, this.cuerpoFrame);

		// Set Recibo
		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtRecibo,
		// this.cuerpoFrame, this.tData.getReciboCliente());
		this.webDriver.setTextInFrame(this.txtRecibo, this.cuerpoFrame, this.userS.getTestVar("ReciboCliente"));
	}

	private void buscarClientePorColectivo() {
		// Click en el rdb Cotizacion
		this.webDriver.clickInFrame(this.rdbColectivo, this.cuerpoFrame);

		// Set Cotizacion
		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtColectivo,
		// this.cuerpoFrame, this.tData.getColectivoCliente());
		this.webDriver.setTextInFrame(this.txtColectivo, this.cuerpoFrame, this.userS.getTestVar("ColectivoCliente"));
	}

	private void buscarClientePorCotizacion() {
		// Click en el rdb Cotizacion
		this.webDriver.clickInFrame(this.rdbCotizacion, this.cuerpoFrame);

		// Set Cotizacion
		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtCotizacion,
		// this.cuerpoFrame, this.tData.getNoCotizacion());
		this.webDriver.setTextInFrame(this.txtCotizacion, this.cuerpoFrame, this.userS.getTestVar("CotizacionNum"));
	}

	private void buscarClientePorPoliza() {
		// Click en el rdb Poliza
		this.webDriver.clickInFrame(this.rdbPoliza, this.cuerpoFrame);

		// Set Poliza

		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtPoliza,
		// this.cuerpoFrame, this.tData.getNumPoliza().toString());
		this.webDriver.setTextInFrame(this.txtPoliza, this.cuerpoFrame, this.userS.getTestVar("NumPoliza"));
	}

	private void buscarClientePorNombre() {
		// Click en el rdb Nombre
		this.webDriver.clickInFrame(this.rdbNombre, this.cuerpoFrame);

		// Set Nombre
		this.webDriver.clearText(txtNombre);
		this.webDriver.appendTextInFrame(this.txtNombre, this.cuerpoFrame, this.userS.getTestVar("TomadorNombre"));
	}

	public void buscarClientePorNIF() {
		this.buscarClientePorNIF(this.userS.getTestVar("DocumentoInquilino"));
	}

	public void buscarClientePorNIF(String numNIF) {
		// Click en el rdb NIF
		this.webDriver.clickInFrame(this.rdbNIF, this.cuerpoFrame);

		// Set NIF
		// this.webDriver.clearAndSetTextInWebElementInFrame(this.txtNIF,
		// this.cuerpoFrame, numNIF);
		this.webDriver.setTextInFrame(this.txtNIF, this.cuerpoFrame, numNIF);

		this.webDriver.clickInFrame(this.btnBuscar, this.cuerpoFrame);
	}

	public boolean checkResultadoNIF() {
		debugBegin();
		
		boolean res = false;
		if(this.webDriver.isPresentInFrame(this.barraResultadoBusqueda, this.cuerpoFrame)) {
			res = this.webDriver.getTextInFrame(this.barraResultadoBusqueda, this.cuerpoFrame).contains("Resultado de la búsqueda (Nº clientes: 1)");
		}

		debugEnd();
		
		return res;
	}
	// endregion
}
