package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import net.thucydides.core.annotations.Steps;
import starter.products.Get;
import starter.products.Post;

import java.lang.reflect.Array;

public class ProductsSteps {
    @Steps
    Post post;
    @Steps
    Get get;
//    Post post = new Post();
    @Given("I set an endpoint for post create product")
    public void iSetAnEndpointForPostCreateProduct() {
        post.iSetAnEndpointForPostProduct();
    }


    @When("I request post create product with {string} and {int} and {int}")
    public void iRequestPostCreateProductWithAndPriceAndCategories(String name, int price, int categories) {
        post.iRequestPostCreateProductWithAndPriceAndCategories(name, price, categories);
    }

    @Then("I validate the status code {int}")
    public void iValidateTheStatusCodeStatus_code(int status_code) {
        post.iValidateTheStatusCodeStatus_code(status_code);
    }

    @And("I validate the {string}")
    public void iValidateThe(String message) {
        post.iValidateThe(message);
    }


    @Given("I set an endpoint for get all products")
    public void iSetAnEndpointForGetAllProducts() {
        get.iSetAnEndpointForGetAllProducts();
    }

    @When("I request get all products")
    public void iRequestGetAllProducts() {
        get.iRequestGetAllProducts();
    }


    @When("I request get product by {int}")
    public void iRequestGetProductById(int id) {
        get.iRequestGetProductById(id);
    }


    @Given("I set an endpoint for get product by {int}")
    public void iSetAnEndpointForGetProductById(int id) {
        get.iSetAnEndpointForGetProductById(id);
    }

    @And("I validate the {string} after get product by {int}")
    public void iValidateTheAfterGetProductById(String message, int id) {
        get.iValidateTheAfterGetProductById(message, id);
    }
}