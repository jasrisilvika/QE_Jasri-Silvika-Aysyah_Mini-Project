package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.OrderPage;

public class OrderSteps {
    @Steps
    LoginPage loginPage;
    OrderPage orderPage;
    @When("I click pay button")
    public void iClickPayButton(){
        orderPage.clickPayButton();
    }

    @Then("I go to login page")
    public void iGoToLoginPage() {
        loginPage.validateOnLoginPage();
    }


    @Then("I go to transaction page")
    public void iGoToTransactionPage() {
        orderPage.validateOnTransactionPage("Transactions");
    }
}
