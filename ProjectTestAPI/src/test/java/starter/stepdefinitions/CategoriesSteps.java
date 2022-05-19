package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.categories.Get;
import starter.categories.Post;

public class CategoriesSteps {
    @Steps
    Get get;
    Post post = new Post();

    @Given("I set an endpoint for GET all categories")
    public void iSetAnEndpointForGETAllCategories() {
        get.iSetAnEndpointForGETAllCategories();
    }

    @When("I request GET all categories")
    public void iRequestGETAllCategories() {
        get.iRequestGETAllCategories();
    }

    @Then("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int arg0) {
        get.iValidateTheStatusCode(200);
    }

    @And("I validate the body is not null")
    public void iValidateTheBodyIsNotNUll() {
        get.iValidateTheBodyIsNotNull();
    }



    @And("I validate the data detail {string}")
    public void iValidateTheDataDetail(String categoryEqual) {
        post.iValidateTheDataDetail(categoryEqual);
    }



    @Given("I set an endpoint for POST category")
    public void iSetAnEndpointForPOSTCategory() {
        post.iSetAnEndpointForPOSTCreateCategory();
    }

    @When("I request POST create {string}")
    public void iRequestPOSTCreate(String category) {
        post.iRequestPOSTCreateCategory(category);
    }

    @Then("I validate the status code {string}")
    public void iValidateTheStatusCode(String arg0) {
        post.iValidateTheStatusCode(arg0);
    }
}
