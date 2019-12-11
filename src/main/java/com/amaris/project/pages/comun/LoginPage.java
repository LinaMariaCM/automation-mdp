package com.amaris.project.pages.comun;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.project.Constants;
import com.amaris.project.pages.comun.gestiononline.GestionOnlineLoginPage;
import com.amaris.project.pages.comun.innova.InnovaLoginPage;

public class LoginPage extends PageObject {

	public LoginPage(UserStory userS) {
		super(userS);
	}

	public LoginPage logIn(String environment, String accessType, String user) throws Exception {
		switch(environment) {
			case Constants.PreEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-Pre"));
				break;
			case Constants.UatEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-UAT"));
				break;
			case Constants.V7Environment:
				webDriver.go(getConfigVar(accessType + "Home-V7"));
				break;
			case Constants.QAEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-QA"));
				break;
			case Constants.ATMIRAEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-ATMIRA"));
				break;
			case Constants.UpgradeEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-Upgrade"));
				break;
			case Constants.SiniestrosEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-Siniestros"));
				break;
			case Constants.MigracionEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-Migracion"));
				break;
			case Constants.UatPjEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-UatPj"));
				break;
			case Constants.HogarMigEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-HogarMig"));
				break;
			case Constants.RecibosCheckEnvironment:
				webDriver.go(getConfigVar(accessType + "Home-RecibosCheck"));
				break;
			default:
				throw new Exception("Environment not available");
		}

		switch(accessType) {
			case Constants.LoginAccessInnova:
				new InnovaLoginPage(userS)
					.login(user, getGlobalVar("password"));
				break;
			case Constants.LoginAccessGestionLine:
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
