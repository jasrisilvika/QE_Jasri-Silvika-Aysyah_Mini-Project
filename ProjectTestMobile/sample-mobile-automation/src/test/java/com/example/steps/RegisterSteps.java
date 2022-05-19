package com.example.steps;

import com.example.app.pages.LoginPage;
import com.example.app.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @And("I click register menu")
    public void iClickRegisterMenu(){
        loginPage.clickRegisterMenu();
        registerPage.validateOnRegisterPage();
    }

//    @When("I input fullname {string} and email {string} and password {string}")
//    public void iInputFullnameAndEmailAndPassword(String fullname, String email, String password) throws InterruptedException{
//        registerPage.iInputFullnameAndEmailAndPassword(fullname, email, password);
//    }

    @And("I click register button")
    public void iClickRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("I validate the {string} after register")
    public void iValidateTheAfterRegister(String result) {
        registerPage.iValidateTheAfterRegister(result);
    }

    @When("I input fullname {string}")
    public void iInputFullname(String fullname) throws InterruptedException{
        registerPage.iInputFullname(fullname);
    }

    @And("I input email {string}")
    public void iInputEmail(String email) throws InterruptedException{
        registerPage.iInputEmail(email);
    }

    @And("I input password {string}")
    public void iInputPassword(String password) throws InterruptedException{
        registerPage.iInputPassword(password);
    }
}
