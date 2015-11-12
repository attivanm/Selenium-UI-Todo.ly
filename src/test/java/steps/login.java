package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

import org.junit.After;
import org.junit.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;

/**
 * Created by ivanmorales on 11/9/2015.
 */
public class login {
    private PageTransporter transporter= PageTransporter.getInstance();
    private LoginPage loginPage;
    private MainPage mainPage;


    @Given("I navigate to login page$")
    public void navigateLoginPage() {
        loginPage = transporter.navigateToLoginPage();
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void login(String userName, String userPassword){
        mainPage = loginPage.loginSuccessful(userName, userPassword);
    }
    @Then("I should login successfully$")
    public void verifyMainPageIsDisplayed() {
        assertTrue(mainPage.isUserNameDisplayed(),"the main project is displayed");
        mainPage.logout();
    }

}
