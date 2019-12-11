package com.amaris.project.pages.administracion.siniestros.gestion;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class RecobroSiniestrosPage extends PageObject {

	// BLOQUE RECOBRO: RECOBRO es #bloque1tr2 porque es el segundo bloque, coger lo elaborado por Moha para ajustarlo
	// aqui
	private By casillaBloque = By.cssSelector("#bloque1tr2 > td:nth-child(3)");
	private By abrirFormularioRecobro = By.cssSelector("#bloque1tr2 > td:nth-child(8) > a > span");

	// region ends

	public RecobroSiniestrosPage(UserStory userS) {
		super(userS);
	}

	// entrar a recobro desde el menú
	// localizar el texto BLOQUE RECOBRO: RECOBRO del elemento casillaBloque en la tabla
	// hacer clic en "Nuevo / Continuar" de la misma fila para abrir el formulario

}
