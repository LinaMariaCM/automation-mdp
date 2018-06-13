package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;
import com.project.ProjectConstants;

public class LoginPage extends PageObject {

	public LoginPage(UserStory userS) {
		super(userS);
	}

	public LoginPage logIn(String environment, String accessType, String user) throws Exception {
		switch(environment) {
			case ProjectConstants.PreEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-Pre"));
				break;
			case ProjectConstants.UatEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-UAT"));
				break;
			case ProjectConstants.V7Environment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-V7"));
				break;
			case ProjectConstants.QAEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-QA"));
				break;
			case ProjectConstants.ATMIRAEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-ATMIRA"));
				break;
			case ProjectConstants.UpgradeEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-Upgrade"));
				break;
			case ProjectConstants.SiniestrosEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-Siniestros"));
				break;
			case ProjectConstants.MigracionEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-Migracion"));
				break;
			case ProjectConstants.UatPjEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-UatPj"));
				break;
			case ProjectConstants.HogarMigEnvironment:
				this.webDriver.go(testDataM.getConfigVar(accessType + "Home-HogarMig"));
				break;
			default:
				throw new Exception("Environment not available");
		}

		switch(accessType) {
			case ProjectConstants.LoginAccessInnova:
				new InnovaLoginPage(userS)
					.login(user, testDataM.getGlobalVar("password"));
				break;
			case ProjectConstants.LoginAccessGestionLine:
				new GestionOnlineLoginPage(userS)
					.login(user, testDataM.getGlobalVar("password"));

				new GestionOnlineHomePage(userS)
					.acceptCookies();
					//.closeNovedadesDialog();
				break;
			default:
				throw new Exception("Not implemented login access type selected");
		}

		return this;
	}

}
