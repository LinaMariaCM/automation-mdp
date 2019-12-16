package com.amaris.project.utils;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.pages.administracion.siniestros.apertura.AltaAperturaDeclaracionSiniestrosPage;
import org.testng.Assert;

public class ChecksUtils extends PageObject {

	public ChecksUtils(UserStory userS) {
		super(userS);
	}

	public void comprobarAlerta(String textoEsperado) {
		comprobarAlerta(textoEsperado, true);
	}

	public void comprobarAlerta(String textoEsperado, boolean comprobacionEsperada) {
		debugBegin();

		if(webDriver.alertIsPresent() && comprobacionEsperada) {
			String alertResult = webDriver.getAlertText();

			int indice = alertResult.indexOf('\n');
			alertResult = alertResult.substring(0, indice == -1 ? alertResult.length() : indice).trim();

			boolean checkAviso = alertResult.equalsIgnoreCase(textoEsperado);

			debugInfo("Mensaje esperado: " + textoEsperado);
			debugInfo("Mensaje real: " + alertResult);

			Assert.assertEquals(checkAviso, comprobacionEsperada, "COMPARAR CAMPOS : mensaje alerta NO es correcto");
		} else {
			Assert.assertFalse(comprobacionEsperada, "COMPARAR CAMPOS : alerta NO se muestra");
		}

		debugEnd();
	}
}
