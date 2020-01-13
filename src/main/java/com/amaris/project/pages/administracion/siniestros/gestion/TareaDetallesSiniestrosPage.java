package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;

public class TareaDetallesSiniestrosPage extends PageObject{

	// region WebElements
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
	
	// Detalles
	private By idTareaTxt = By.cssSelector("body > div.contentBoxTab.widthTabs > div > div.bgTabsInt > div.sis-bgpositive.sis-inner-box > div:nth-child(1) > div.box-field");
	private By fVencimientoTxt = By.cssSelector("body > div.contentBoxTab.widthTabs > div > div.bgTabsInt > div.sis-bgpositive.sis-inner-box > div:nth-child(2) > div.box-field");
	
	private By cerrarTareaBtn = By.cssSelector("#botonCerrar");
	private By modificarTareaBtn = By.cssSelector("#formModificacion > div > input.mainButton.js-openModal");
	
	// Datos de tarea
	private By datosTareaPestanyaBtn = By.cssSelector("#pesTarea > span");
	
	private By historialTareaTxt = By.cssSelector("#capaTarea > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td");
	private By tituloTarea = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(1) > div.box-result");
	private By id = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(2) > div.box-result");
	private By fAltaTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(4) > div.box-result");
	private By estadoTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(5) > div.box-result");
	private By usuarioAltaTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(6) > div.box-result");
	private By usuarioCierreTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(8) > div.box-result");
	private By fTramitacionTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(9) > div.box-result");
	private By fCierreTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(10) > div.box-result");	
	private By leidoTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(12) > div.box-result");
	private By usuarioLeidoTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(13) > div.box-result");
	private By fLeidoTxt = By.cssSelector("#capaTarea > div.sis-inner-box.sis-clearfix > div:nth-child(14) > div.box-result");
	
	//Situaciones de la tarea
	private By situacionesTareaPestanyaBtn = By.cssSelector("#pesSituaciones > span");
	
	private By situacionesTarea = By.cssSelector("#capaSituaciones > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td");
	//TODO : tener en cuenta generar un lista de elementos para el caso en el cual hayan más de una situación de tarea
	private By elementoSituacionesTarea = By.cssSelector("#capaSituaciones > table > tbody > tr > td > table > tbody > tr > td");
	
	//Tareas relacionadas
	private By tareasRelacionadasPestanyaBtn = By.cssSelector("pesTareasRelacionadas");	
	//TODO : tener en cuenta generar un lista de elementos para capturar las distintas tareas relacionadas
	private By elementoTareasRelacionadas = By.cssSelector("div[id=capaRelacionadas] table tbody tr[valign=top]");
	
	//METHODS REGION
	public TareaDetallesSiniestrosPage(UserStory userS) {
		super(userS);
	}
	
	public TareaDetallesSiniestrosPage consultarUsuariosDeAlta() {
		debugBegin();
		
		debugInfo("Procedemos a consultar el usuario de alta");
		debugInfo("-----------------------------------");
		debugInfo("-Usuario Alta : " + webDriver.getTextInFrame(usuarioAltaTxt, cuerpoFrame));
		debugInfo("-Fecha Alta: 	" + webDriver.getTextInFrame(fAltaTxt, cuerpoFrame));
		debugInfo("-Estado: 		" + webDriver.getTextInFrame(estadoTxt, cuerpoFrame));
		
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage consultarUsuariosDeCierre() {
		debugBegin();
		
		debugInfo("Procedemos a consultar el usuario de cierre");
		debugInfo("-----------------------------------");
		debugInfo("- Usuario Cierre: " + webDriver.getTextInFrame(usuarioCierreTxt, cuerpoFrame));
		debugInfo("- Fecha Cierre:   " + webDriver.getTextInFrame(fCierreTxt, cuerpoFrame));
		debugInfo("- Fecha Tramitación" + webDriver.getTextInFrame(fTramitacionTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage consultarDatosTarea() {
		debugBegin();
		
		debugInfo("Procedemos a consultar los datos de la tarea");
		debugInfo("-----------------------------------");
		debugInfo("- Id - Tarea: 		 	 " + webDriver.getTextInFrame(idTareaTxt, cuerpoFrame));
		debugInfo("- Fecha Vencimiento: 	 " + webDriver.getTextInFrame(fVencimientoTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		debugInfo("- Historial de la tarea: " + webDriver.getTextInFrame(historialTareaTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		debugInfo("-Usuario Alta : " + webDriver.getTextInFrame(usuarioAltaTxt, cuerpoFrame));
		debugInfo("-Fecha Alta: 	" + webDriver.getTextInFrame(fAltaTxt, cuerpoFrame));
		debugInfo("-Estado: 		" + webDriver.getTextInFrame(estadoTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		debugInfo("- Usuario Cierre: " + webDriver.getTextInFrame(usuarioCierreTxt, cuerpoFrame));
		debugInfo("- Fecha Cierre:   " + webDriver.getTextInFrame(fCierreTxt, cuerpoFrame));
		debugInfo("- Fecha Tramitación" + webDriver.getTextInFrame(fTramitacionTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		debugInfo("- Leído: 			" + webDriver.getTextInFrame(leidoTxt, cuerpoFrame));
		debugInfo("- Usuario Leído:   	" + webDriver.getTextInFrame(usuarioLeidoTxt, cuerpoFrame));
		debugInfo("- Fecha Leído		" + webDriver.getTextInFrame(fLeidoTxt, cuerpoFrame));
		debugInfo("-----------------------------------");
		
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage cerrarTarea() {
		debugBegin();
		debugInfo("procedemos a cerrar la tarea");
		webDriver.clickInFrame(cerrarTareaBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage modificarTarea() {
		debugBegin();
		debugInfo("procedemos a modificar la tarea");
		webDriver.clickInFrame(modificarTareaBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage datosTareaPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Datos Tarea'");
		webDriver.clickInFrame(datosTareaPestanyaBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage tareasRelacionadasPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Tareas Relacionadas'");
		webDriver.clickInFrame(tareasRelacionadasPestanyaBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}
	
	public TareaDetallesSiniestrosPage situacionesTareaPestanya() {
		debugBegin();
		debugInfo("seleccionamos la pestaña 'Tareas Relacionadas'");
		webDriver.clickInFrame(situacionesTareaPestanyaBtn, cuerpoFrame);
		debugEnd();
		
		return this;
	}
}//END
