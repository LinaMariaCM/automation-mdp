package com.amaris.project.pages.administracion.siniestros.gestion;

import org.openqa.selenium.By;

import com.amaris.automation.model.testing.objects.PageObject;

public class DocumentacionSiniestroPage extends PageObject {

	private By cuerpoFrame = By.id("mainFrame");
	private By leftFrame = By.cssSelector("#leftFrame");
	private By capaIframe = By.cssSelector("#capaIframe");

	private By documentacion = By.cssSelector("#jt5");

	private By altaDocum = By.cssSelector("a.js-openModal");
	private By vitzualizacion = By.className("div.cpdatos a");
	private By acciones = By.cssSelector("tr.odd div.cajaFlechaAccion > a");
	private By filtro = By.cssSelector("#cabFiltrar");
	private By categoria = By.cssSelector("#categoria");
	private By btnFiltro = By.className("#botonFiltrar");

}