package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.HomePage;

public class LogoutSteps {
    @Steps
    HomePage homePage;
    @When("I click profile icon")
    public void iClickProfileIcon(){
        homePage.clickProfileIcon();
    }
    @And("I click logout button")
    public void iClickLogoutButton(){
        homePage.clickLogoutButton();
    }
}
