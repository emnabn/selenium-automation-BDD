package com.e2eTests.automation.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.e2eTests.automation.pageObjects.AuthentificationPage;
import com.e2eTests.automation.utils.Setup;

import cucumber.api.java.en.When;

public class AuthenticationMultiUser {
	
	public WebDriver driver;
	private AuthentificationPage authentificationPage = new AuthentificationPage();
	public AuthenticationMultiUser() {
		driver=Setup.driver;
	}

	@When("^je saisie le nom de l'utilisateur \"([^\"]*)\"$")
	public void jeSaisieLeNomDeLUtilisateur(String name) throws Throwable {
		authentificationPage.fillUsername(name);
	}

	@When("^je saisie le mot de passe de l'utilisateur \"([^\"]*)\"$")
	public void jeSaisieLeMotDePasseDeLUtilisateur(String pswd) throws Throwable {
		authentificationPage.fillPassword(pswd);
	}

}
