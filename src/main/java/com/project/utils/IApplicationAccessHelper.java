package com.project.utils;


import java.awt.AWTException;
import java.io.IOException;

import com.project.ProjectConstants;

public interface IApplicationAccessHelper
{

	public void CreateProject();

	public void CreateSimulation();

	public void login(
			String userId, String password) throws Exception;

	public void OpenMutuaEdificioConfort() throws AWTException, InterruptedException, IOException;
	
	public void OpenMutuaAlquilerConfort() throws AWTException, InterruptedException, IOException;

	public void openGestionCotizaciones() throws AWTException, InterruptedException, IOException;

	public void searchCotizacion(
			String cotizacion) throws AWTException, InterruptedException, IOException;

	public void OpenGestionPolizas();

	public void SearchPolizaByPolizaNumber(
			String poliza);

	public void SearchPolizaByNifNie(
			String nifNie);

	public void LoginAndCreateProjectMEC(
			String userId, String password) throws Exception;

	public void LoginAndCreateProjectMAC(
			String userId, String password) throws Exception;

	public void LoginAndCreateSimulation(
			String userId, String password) throws Exception;

	public void loginAndSearchCotizacion(
			String userId, String password, String cotizacion) throws Exception;

	public void LoginAndSearchAutorizacion(
			String userId, String password) throws Exception;

	public void LoginAndSearchPolizaByPolizaNumber(
			String userId, String password, String poliza) throws Exception;

	public void LoginAndSearchPolizaByNifNie(
			String userId, String password, String nifNie) throws Exception;

//	static IApplicationAccessHelper initialize(
//			String AccessType, BrowserContext br) throws Exception
//	{
//
//		switch (AccessType)
//		{
//			case ProjectConstants.LoginAccessInnova:
//				return new InnovaApplicationAccessHelper(br);
//
//			case ProjectConstants.LoginAccessGestionLine:
//				return new GestionOnlineAccessHelper(br);
//
//			default:
//				throw new Exception("Not implemented login acess type selected");
//		}
//	}
	
}
