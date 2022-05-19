package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DetailPage;

public class DetailSteps {
    @Steps
    DetailPage detailPage;

    @And("I click detail button {int}")
    public void iClickDetailButton(int product){
        detailPage.clickDetailButton(product);
    }

    @Then("I validate the the detail product {int}")
    public void iValidateTheDetailProduct(int product) throws Exception{
        detailPage.validateProductName(product);
        detailPage.validateProductPrice(product);
    }

    @When("I get detail in card {int}")
    public void iGetDetailInCardProduct(int product) {
        detailPage.getDetailNameInCard(product);
        detailPage.getDetailPriceInCard(product);
    }
}
