package com.amaris.project.pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.ProjectConstants;

public class LoginPage extends PageObject {

	public LoginPage(UserStory userS) {
		super(userS);
	}

	public LoginPage logIn(String environment, String accessType, String user) throws Exception {
		switch(environment) {
			case ProjectConstants.PreEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-Pre"));
				break;
			case ProjectConstants.UatEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-UAT"));
				break;
			case ProjectConstants.V7Environment:
				this.webDriver.go(getConfigVar(accessType + "Home-V7"));
				break;
			case ProjectConstants.QAEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-QA"));
				break;
			case ProjectConstants.ATMIRAEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-ATMIRA"));
				break;
			case ProjectConstants.UpgradeEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-Upgrade"));
				break;
			case ProjectConstants.SiniestrosEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-Siniestros"));
				break;
			case ProjectConstants.MigracionEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-Migracion"));
				break;
			case ProjectConstants.UatPjEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-UatPj"));
				break;
			case ProjectConstants.HogarMigEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-HogarMig"));
				break;
			case ProjectConstants.RecibosCheckEnvironment:
				this.webDriver.go(getConfigVar(accessType + "Home-RecibosCheck"));
				break;
			default:
				throw new Exception("Environment not available");
		}

		switch(accessType) {
			case ProjectConstants.LoginAccessInnova:
				new InnovaLoginPage(userS)
					.login(user, getGlobalVar("password"));
				break;
			case ProjectConstants.LoginAccessGestionLine:
				new GestionOnlineLoginPage(userS)
					.login(user, getGlobalVar("password"));
				webDriver.waitWithDriver(2000);
				// new GestionOnlineHomePage(userS)
				// .acceptCookies();
				// .closeNovedadesDialog();
				break;
			default:
				throw new Exception("Not implemented login access type selected");
		}
		
		// webDriver.setWaitForAngular(true);

		return this;
	}

}
