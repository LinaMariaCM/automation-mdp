package com.project.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.automation.model.testing.TestDataManager;
import com.automation.model.webdriver.DriverHelper;
import com.project.ProjectConstants;

public class LoginPage {
	
	private String testId;
	private TestDataManager tCData;
	private DriverHelper webDriver;
	final static Logger logger = LoggerFactory.getLogger(PageObject.class);

	public LoginPage(DriverHelper driver, TestDataManager data) {
		this.tCData = data;
		this.webDriver = driver;
		this.testId = webDriver.getId() == null ? "" : webDriver.getId();
	}
	
	public LoginPage logIn(String environment, String accessType, String user) throws Exception {
		switch(environment) {
			case ProjectConstants.PreEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-Pre"));
				break;
			case ProjectConstants.UatEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-UAT"));
				break;
			case ProjectConstants.V7Environment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-V7"));
				break;
			case ProjectConstants.QAEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-QA"));
				break;
			case ProjectConstants.ATMIRAEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-ATMIRA"));
				break;
			case ProjectConstants.UpgradeEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-Upgrade"));
				break;
			case ProjectConstants.SiniestrosEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-Siniestros"));
				break;
			case ProjectConstants.MigracionEnvironment:				
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-Migracion"));
				break;
			case ProjectConstants.UatPjEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-UatPj"));
				break;
			case ProjectConstants.HogarMigEnvironment:
				this.webDriver.go(tCData.getConfigVar(accessType + "Home-HogarMig"));
				break;
			default:
				throw new Exception("Environment not available");
		}

		switch(accessType) {
			case ProjectConstants.LoginAccessInnova:
				new InnovaLoginPage(webDriver, tCData)
					.login(user, tCData.getGlobalVar(user + "_pass"));
				break;
			case ProjectConstants.LoginAccessGestionLine:
				new GestionOnlineLoginPage(webDriver, tCData)
					.login(user, tCData.getGlobalVar(user + "_pass"));

				new GestionOnlineHomePage(webDriver, tCData)
					.acceptCookies()
					.closeNovedadesDialog();
				break;
			default:
				throw new Exception("Not implemented login acess type selected");
		}
		
		return this;
	}

}
