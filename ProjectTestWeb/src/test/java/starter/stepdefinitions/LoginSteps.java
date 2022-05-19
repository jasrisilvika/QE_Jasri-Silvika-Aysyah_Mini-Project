package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.HomePage;
import starter.pages.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;
    HomePage homePage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        loginPage.openUrl("https://qa.alta.id/auth/login");
        loginPage.validateOnLoginPage();
    }

    @When("I input {string} email")
    public void iInputEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("I input {string} password")
    public void iInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I get the {string}")
    public void iGetThe(String result) {
        if (result.equals("homepage")){
            homePage.validateSearchBarAppears();
            homePage.validateHeaderHomepageEqual("AltaShop");
        } else {
            loginPage.errorMessageAppears();
            loginPage.errorMessageEqual(result);
        }
    }


}
