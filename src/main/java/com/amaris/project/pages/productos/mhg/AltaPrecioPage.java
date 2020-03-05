package com.amaris.project.pages.productos.mhg;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;

public class AltaPrecioPage extends PageObject {

	//---FRAMES----
	private By topFrame = By.cssSelector("#topFrame");
	private By modalFrame = By.cssSelector("#leftFrame");
	private By cuerpoFrame = By.cssSelector("#mainFrame");

	//--CAPITALES ASEGURADOS---
	private By capitalesAseguradosBtn = By.cssSelector("#capitales > div.row > div > div > button");
	private By contValorTotalInput = By.cssSelector("#CONTINENTE_VALOR_TOTAL");
	private By obrasReformaInput = By.cssSelector("#OBRAS_DE_REFORMA");
	private By contPrimerRiesgoInput = By.cssSelector("#CONTINENTE_PRIMER_RIESGO");
	private By mobiliarioInput = By.cssSelector("#MOBILIARIO");
	private By joyasCajaFuerteInput = By.cssSelector("#JOYAS_EN_CAJAFUERTE");
	private By ampliJoyaCajaFuerteInput = By.cssSelector("#AMPLIACION_JOYAS");
	private By mobiliarioEspecialInput = By.cssSelector("#MOBILIARIO_ESPECIAL");
	private By mobiliarioProfesionalInput = By.cssSelector("#MOBILIARIO_PROFESIONAL");

	private By algunaJoyaSuperiorBtn = By.cssSelector("#question-jewelry");
	private By capitContPrimerRiesgoBtn = By.cssSelector("#CAPICONTPRI");

	//--HOGAR GLOBAL-------
	private By euroBtn = By.cssSelector("#seccion_modalidades_pes > ul > li.mtp-tabs__item_mhoc.mtp-tabs__item_mhoc--right > button:nth-child(1)");
	private By imprimirBtn = By.cssSelector("#seccion_modalidades_pes > ul > li.mtp-tabs__item_mhoc.mtp-tabs__item_mhoc--right > button:nth-child(2)");

	//--GARANTIAS OBLIGATORIAS INCLUIDAS----
	private By garantiasObligIncluBtn = By.cssSelector("#seccion_modalidades > div:nth-child(2) > div > div > button");
	private By incendioAfinesBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(3) > div > div > button");
	private By danyosElectricosBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(4) > div > div > button");
	private By extensivosBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(5) > div > div > button");
	private By danyosPropiosBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(6) > div > div > button");
	private By gastosPerdidasBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(7) > div > div > button");
	private By roturasBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(8) > div > div > button");
	private By asistenciaInformaticaBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(9) > div > div > button");
	private By responsabilidadCivilBtn = By.cssSelector("#warranty-obligatory-complet > fieldset > div:nth-child(10) > div > div > button");
	private By responsabilidadCivilCombo = By.cssSelector("#SEL_GL144");
	private By responsabilidadCivilOption = By.cssSelector("#SEL_GL144 > option");
	private By numPerrosPeligrosInput = By.cssSelector("#NUM_PERROS_PELIGROSOS");

	//--GARANTIAS OPCIONALES----
	private By garantiasOpcionalesBtn = By.cssSelector("#seccion_modalidades > div:nth-child(3) > div > div > button");
	private By roturaComplementBtn = By.cssSelector("#ID_HRTCO");
	private By roboViviendaBtn = By.cssSelector("#ID_HROEX");
	private By roboComplementarioBtn = By.cssSelector("#ID_HROCO");
	private By restauraEsteticContBtn = By.cssSelector("#ID_GL153");
	private By alimentoRefrigeradoBtn = By.cssSelector("#ID_GL147");
	private By danyosGoterasBtn = By.cssSelector("#ID_GL1693");
	private By danyosHeladaBtn = By.cssSelector("#ID_GL170");
	private By roturaDesbordamientoBtn = By.cssSelector("#ID_GL171");
	private By vehiculosGrajeBtn = By.cssSelector("#ID_GL158");
	private By defensaJuridicaBtn = By.cssSelector("#ID_GL1621");
	private By asistenciaHogaroBtn = By.cssSelector("#ID_GL161");

	//---FRANQUICIA--
	private By franquiciaVoluntariaCombo = By.cssSelector("#FRANQUICIA");
	private By franquiciaVoluntariaOption = By.cssSelector("#FRANQUICIA > option");
	private By franquiciaManualBtn = By.cssSelector("#franquiciaManual");
	private By coberturaAfectFranqBtn = By.cssSelector("#tablaFranquicias > div > div > button");

	//---RECARGO/DESCUENTO----
	private By anyadirRecargoDescuentoBtn = By.cssSelector("#botonAddDescuento");
	private By ajusteTarifaGrantiaBtn = By.cssSelector("#botonAjusteTarifa");
	private By tipoDescuentoBtn = By.cssSelector("#divRecargoDescuento > div > div:nth-child(3) > div > div > button");


	//---RETRIBUCION AL MEDIADOR----
	private By tipoRetribucionCombo = By.cssSelector("#nombdato_TIPORETR_1");
	private By tipoRetribucionOption = By.cssSelector("#nombdato_TIPORETR_1 > option");

	//---PRECIO TOTAL----
	private By anualBtn = By.cssSelector("#payment-type-0");
	private By semestralBtn = By.cssSelector("#payment-type-1");
	private By trimestralBtn = By.cssSelector("#payment-type-2");

	//---CONTROLES DE PAGINA---
	private By cancelarBtn = By.cssSelector("#formDatos > div:nth-child(9) > div > div > a");
	private By guardarBtn = By.cssSelector("#formDatos > div:nth-child(9) > div > div > button.btn.btn-default");
	private By convertirProyectoBtn = By.cssSelector("#formDatos > div:nth-child(9) > div > div > button.btn.btn-primary.mtp-margin-right-15");

	public AltaPrecioPage(UserStory userS) {
		super(userS);
	}
}
