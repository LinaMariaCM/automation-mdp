package com.amaris.project.utils;

import java.awt.AWTException;
import java.io.IOException;

public interface IApplicationAccessHelper {

	void CreateProject();

	void CreateSimulation();

	void login(
		String userId, String password) throws Exception;

	void OpenMutuaEdificioConfort() throws AWTException, InterruptedException, IOException;

	void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException;

	void openGestionCotizaciones() throws AWTException, InterruptedException, IOException;

	void searchCotizacion(
		String cotizacion) throws AWTException, InterruptedException, IOException;

	void OpenGestionPolizas();

	void SearchPolizaByPolizaNumber(
		String poliza);

	void SearchPolizaByNifNie(
		String nifNie);

	void LoginAndCreateProjectMEC(
		String userId, String password) throws Exception;

	void LoginAndCreateProjectMAC(
		String userId, String password) throws Exception;

	void LoginAndCreateSimulation(
		String userId, String password) throws Exception;

	void loginAndSearchCotizacion(
		String userId, String password, String cotizacion) throws Exception;

	void LoginAndSearchAutorizacion(
		String userId, String password) throws Exception;

	void LoginAndSearchPolizaByPolizaNumber(
		String userId, String password, String poliza) throws Exception;

	void LoginAndSearchPolizaByNifNie(
		String userId, String password, String nifNie) throws Exception;

	// static IApplicationAccessHelper initialize(
	// String AccessType, BrowserContext br) throws Exception
	// {
	//
	// switch (AccessType)
	// {
	// case ProjectConstants.LoginAccessInnova:
	// return new InnovaApplicationAccessHelper(br);
	//
	// case ProjectConstants.LoginAccessGestionLine:
	// return new GestionOnlineAccessHelper(br);
	//
	// default:
	// throw new Exception("Not implemented login acess type selected");
	// }
	// }

}
