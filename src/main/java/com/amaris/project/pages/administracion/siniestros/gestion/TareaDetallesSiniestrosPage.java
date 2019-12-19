package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class TareaDetallesSiniestrosPage extends PageObject{

	//WEB ELEMENTS REGION
	
	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");
	
	private By cambiarOperador = By.cssSelector("#cabCambiarOperador > span");
	private By etiquetas = By.cssSelector("#cabEtiquetas > span");
	
	private By siniestro = By.cssSelector("#capaCabecera > div > div:nth-child(2) > a");
	private By operador = By.cssSelector("#capaCabecera > div > div:nth-child(2) > strong:nth-child(4)");
	private By origen = By.cssSelector("#capaOrigenTarea");
	private By modulo = By.cssSelector("#capaCabecera > div > div:nth-child(5)");
	private By prioridad = By.cssSelector("#capaCabecera > div > div:nth-child(3) > div");
	private By categoria = By.cssSelector("#capaCabecera > div > div:nth-child(6)");
	private By tipoTarea = By.cssSelector("#capaCabecera > div > div.sis-frame-bg2.sinsalto.alignCenter > img");
	
	//Detalles
	
	private By idTarea = By.cssSelector("body > div.contentBoxTab.widthTabs > div > div.bgTabsInt > div.sis-bgpositive.sis-inner-box > div:nth-child(1) > div.box-field");
	private By fVencimiento = By.cssSelector("body > div.contentBoxTab.widthTabs > div > div.bgTabsInt > div.sis-bgpositive.sis-inner-box > div:nth-child(2) > div.box-field");
	
	private By cerrarTarea = By.cssSelector("#botonCerrar");
	private By modificarTarea = By.cssSelector("#formModificacion > div > input.mainButton.js-openModal");
	
	//Datos de tarea
	private By datosTareaPestanya = By.cssSelector("#pesTarea > span");
	
	private By historialTarea = By.cssSelector("#capaTarea > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td");
	private By tituloTarea = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(1) > div.box-result");
	private By id = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(2) > div.box-result");
	private By fAlta = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(4) > div.box-result");
	private By estado = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(5) > div.box-result");
	private By usuarioAlta = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(6) > div.box-result");
	private By usuarioCierre = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(8) > div.box-result");
	private By fTramitacion = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(9) > div.box-result");
	private By fCierre = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(10) > div.box-result");	
	private By leido = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(12) > div.box-result");
	private By usuarioLeido = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(13) > div.box-result");
	private By fLeido = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(14) > div.box-result");
	
	
	//Situaciones de la tarea
	private By situacionesTareaPestanya = By.cssSelector("#pesSituaciones > span");
	
	private By situacionesTarea = By.cssSelector("#capaSituaciones > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td");
	//TODO : tener en cuenta generar un lista de elementos para el caso en el cual hayan más de una situación de tarea
	private By ElementoSituacionesTarea = By.cssSelector("#capaSituaciones > table > tbody > tr > td > table > tbody > tr > td");
	
	//Tareas relacionadas
	private By tareasRelacionadasPestanya = By.cssSelector("pesTareasRelacionadas");	
	//TODO : tener en cuenta generar un lista de elementos para capturar las distintas tareas relacionadas
	private By ElementoTareasRelacionadas = By.cssSelector("div[id=capaRelacionadas] table tbody tr[valign=top]");
	
	//METHODS REGION
	public TareaDetallesSiniestrosPage(UserStory userS) {
		super(userS);
	}
	
	public TareaDetallesSiniestrosPage consultarUsuariosDeAlta() {
		debugBegin();		
		debugInfo("Procedemos a consultar el usuario de alta");
		System.out.println("-----------------------------------");
		System.out.println("-Usuario Alta : " + webDriver.getTextInFrame(usuarioAlta, cuerpoFrame));
		System.out.println("-Fecha Alta: 	" + webDriver.getTextInFrame(fAlta, cuerpoFrame));
		System.out.println("-Estado: 		" + webDriver.getTextInFrame(estado, cuerpoFrame));
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage consultarUsuariosDeCierre() {
		debugBegin();
		debugInfo("procedemos a consultar el usuario de cierre");
		System.out.println("-----------------------------------");
		System.out.println("- Usuario Cierre: " + webDriver.getTextInFrame(usuarioCierre, cuerpoFrame));
		System.out.println("- Fecha Cierre:   " + webDriver.getTextInFrame(fCierre, cuerpoFrame));
		System.out.println("- Fecha Tramitación" + webDriver.getTextInFrame(fTramitacion, cuerpoFrame));
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage consultarDatosTarea() {
		debugBegin();
		debugInfo("procedemos a consultar los datos de la tarea");
		System.out.println("-----------------------------------");
		System.out.println("- Id - Tarea: 		 	 " + webDriver.getTextInFrame(idTarea, cuerpoFrame));
		System.out.println("- Fecha Vencimiento: 	 " + webDriver.getTextInFrame(fVencimiento, cuerpoFrame));
		System.out.println("-----------------------------------");
		System.out.println("- Historial de la tarea: " + webDriver.getTextInFrame(historialTarea, cuerpoFrame));
		System.out.println("-----------------------------------");
		System.out.println("-Usuario Alta : " + webDriver.getTextInFrame(usuarioAlta, cuerpoFrame));
		System.out.println("-Fecha Alta: 	" + webDriver.getTextInFrame(fAlta, cuerpoFrame));
		System.out.println("-Estado: 		" + webDriver.getTextInFrame(estado, cuerpoFrame));
		System.out.println("-----------------------------------");
		System.out.println("- Usuario Cierre: " + webDriver.getTextInFrame(usuarioCierre, cuerpoFrame));
		System.out.println("- Fecha Cierre:   " + webDriver.getTextInFrame(fCierre, cuerpoFrame));
		System.out.println("- Fecha Tramitación" + webDriver.getTextInFrame(fTramitacion, cuerpoFrame));
		System.out.println("-----------------------------------");
		System.out.println("- Leído: 			" + webDriver.getTextInFrame(leido, cuerpoFrame));
		System.out.println("- Usuario Leído:   	" + webDriver.getTextInFrame(usuarioLeido, cuerpoFrame));
		System.out.println("- Fecha Leído		" + webDriver.getTextInFrame(fLeido, cuerpoFrame));
		
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage cerrarTarea() {
		debugBegin();
		debugInfo("procedemos a cerrar la tarea");
		webDriver.clickInFrame(cerrarTarea, cuerpoFrame);
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage modificarTarea() {
		debugBegin();
		debugInfo("procedemos a modificar la tarea");
		webDriver.clickInFrame(modificarTarea, cuerpoFrame);
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage datosTareaPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Datos Tarea'");
		webDriver.clickInFrame(datosTareaPestanya, cuerpoFrame);
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage tareasRelacionadasPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Tareas Relacionadas'");
		webDriver.clickInFrame(tareasRelacionadasPestanya, cuerpoFrame);
		debugEnd();
		return this;
	}
	
	public TareaDetallesSiniestrosPage situacionesTareaPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Tareas Relacionadas'");
		webDriver.clickInFrame(situacionesTareaPestanya, cuerpoFrame);
		debugEnd();
		return this;
	}
	
	
}//END
