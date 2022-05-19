package com.example.steps;

import com.example.app.drivers.AndroidDriverInit;
import com.example.app.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.touch.TouchActions;

public class buySteps {

    HomePage homePage = new HomePage();

    @When("I click the buy button {int}")
    public void iClickTheBuyButton(int value){
        homePage.clickBuyButton(value);
    }

    @Then("I validate the cart {int}")
    public void iValidateTheCart(int value) {
        homePage.validateCart(value);
    }


}
