package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.CartPage;
import starter.pages.HomePage;

public class CartSteps {
    @Steps
    HomePage homePage;
    CartPage cartPage;

    @Given("I am on homepage")
    public void iAmOnHomepage(){
        cartPage.openUrl("https://qa.alta.id/");
        homePage.validateSearchBarAppears();
        homePage.validateHeaderHomepageEqual("AltaShop");
    }

    @When("I click buy button")
    public void iClickBuyButton() {
        cartPage.clickBuy();
    }

    @Then("I go to order page")
    public void iGoToOrderPage() {
        cartPage.iGoToOrderPage();
    }

    @And("I validate the detail")
    public void iValidateTheDetail() {
        cartPage.validateTotalQty("2");
    }

    @And("I validate on order page")
    public void iValidateOnOrderPage() {
        cartPage.validateOnOrderPage();
    }

    @And("I click plus button")
    public void iClickPlusButton() {
        cartPage.clickPlusButton();
    }

    @And("I click {string} button")
    public void iClickButton(String symbol) {
        if (symbol.equals("+")){
            cartPage.clickPlusButton();
        }else {
            cartPage.clickMinusButton();
        }
    }

    @And("I validate the {string} detail")
    public void iValidateTheDetail(String detail) {
        if(detail.equals("add")) {
            cartPage.validateTotalQty("2");
        } else {
            cartPage.validateEmptyCart("Order is empty!");
        }
    }
}
