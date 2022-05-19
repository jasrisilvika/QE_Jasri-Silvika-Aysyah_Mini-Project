package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("I am on the homepage")
    public void iAmOnTheHomePage(){
        loginPage.validateOnHomePage();
    }

    @When("I click login icon")
    public void iClickLoginIcon() {
        homePage.clickLoginIcon();
    }

    @And("I validate on login page")
    public void iValidateOnLoginPage() {
        loginPage.validateOnLoginPage();
    }

    @And("I input {string} and {string}")
    public void iInputAnd(String email, String password) throws InterruptedException{
        loginPage.iInputAnd(email, password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I validate the {string}")
    public void iValidateThe(String result) throws InterruptedException {
        loginPage.iValidateThe(result);
    }


    @When("I click login button logout button")
    public void iClickLoginButtonLogoutButton() {
        loginPage.clickLogoutButton();
    }
    }

//    @And("I input email {string}")
//    public void iInputEmail(String email) throws InterruptedException{
//        loginPage.iInputEmail(email);
//    }
//
//    @And("I input password {string}")
//    public void iInputPassword(String password) throws InterruptedException {
//        loginPage.iInputPassword(password);
//    }
//}
