package com.e2eTests.automation.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.pageObjects.AuthentificationPage;
import com.e2eTests.automation.utils.CommonMethods;
import com.e2eTests.automation.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthentificationStepDef extends CommonMethods {

	public WebDriver driver;
	private AuthentificationPage authentificationPage = new AuthentificationPage();
	private CommonMethods commonMethods = new CommonMethods();
	
	//constructor to have one driver not 2
	public AuthentificationStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AuthentificationPage.class);
	}
	
	@Given("^je me connecte sur l'application OrangeHRM$")
	public void jeMeConnecteSurLApplicationOrangeHRM() throws Throwable {
		logger.info("je me connecte sur l'application OrangeHRM");
		commonMethods.openURLWithConfigFile("url1");
	   
	}

	@When("^je saisie username \"([^\"]*)\"$")
	public void jeSaisieUsername(String username) throws Throwable {
		logger.info("je saisie username");
		authentificationPage.fillUsername(username);
		
	}

	@When("^je saisie le mot de passe \\\"([^\\\"]*)\\\"$")
	public void jeSaisieLeMotDePasse(String pswd) throws Throwable {
		logger.info("je saisie le mot de passe");
		authentificationPage.fillPassword(pswd);
	
	}

	@When("^je clique sur le boutton login$")
	public void jeCliqueSurLeBouttonLogin() throws Throwable {
		
		authentificationPage.fillLoginButton();
	
	}


	@Then("^je me redirige vers la page home \\\"([^\\\"]*)\\\"$")
	public void jeMeRedirigeVersLaPageHome(String message) throws Throwable {
		logger.info("je me redirige vers la page home");
		String messageToWelcome = AuthentificationPage.welcome.getText();
		Assert.assertTrue(messageToWelcome.contains(message));
	}
       

	
	
}
