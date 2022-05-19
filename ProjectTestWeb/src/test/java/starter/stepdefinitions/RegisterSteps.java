package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class RegisterSteps {
    @Steps
    RegisterPage registerPage;
    LoginPage loginPage;

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage(){
        registerPage.openUrl("https://qa.alta.id/auth/register");
        registerPage.validateOnRegisterPage();
    }

    @When("I input {string} fullname")
    public void iInputFullname(String fullname) {
        registerPage.inputFullname(fullname);
    }

    @And("I click register button")
    public void iClickRegisterButton() {
        registerPage.clickRegisterButton();
    }


    @Then("I get {string}")
    public void iGet(String result) {
        if(result.equals("login")){
            loginPage.validateOnLoginPage();
        }
        else{
            registerPage.warningIconAppears();
            registerPage.errorMessageEqual(result);
        }
    }

    @And("input {string} email")
    public void inputEmail(String email) {
        registerPage.inputEmail(email);
    }

    @And("input {string} password")
    public void inputPassword(String password) {
        registerPage.inputPassword(password);
    }
}
