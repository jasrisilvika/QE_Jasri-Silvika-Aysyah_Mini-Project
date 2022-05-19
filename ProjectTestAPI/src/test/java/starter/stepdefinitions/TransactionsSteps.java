package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transactions.Get;
import starter.transactions.Post;

public class TransactionsSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Given("I set an endpoint for get all transactions")
    public void iSetAnEndpointForGetAllTransactions(){
        get.iSetAnEndpointForGetAllTransactions();
    }

    @When("I request get all transactions {string}")
    public void iRequestGetAllTransactions(String tok) throws Exception{
        get.iRequestGetAllTransactions(tok);
    }

    @And("I validate the {string} after get all transactions")
    public void iValidateTheAfterGetAllTransactions(String message) {
        get.iValidateTheAfterGetAllTransactions(message);
    }


    @Given("I set an endpoint fot post create transactions")
    public void iSetAnEndpointFotPostCreateTransactions() {
        post.iSetAnEndpointFotPostCreateTransactions();
    }

    @When("I request post create transaction with {int} and {int}")
    public void iRequestPostCreateTransactionWithProductAndQuantity(int product, int quantity) throws Exception{
        post.iRequestPostCreateTransactionWithProductAndQuantity(product, quantity);

    }

    @And("I validate the {string} with {int} and {int}")
    public void iValidateTheWithProductAndQuantity(String message, int product, int quantity) {
        post.iValidateTheWithProductAndQuantity(message, product, quantity);
    }
}
