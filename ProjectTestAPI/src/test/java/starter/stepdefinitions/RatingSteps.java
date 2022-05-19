package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.rating.Get;
import starter.rating.Post;

public class RatingSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Given("I set an endpoint for get rating {int}")
    public void iSetAnEndpointForGetRating(int id){
        get.iSetAnEndpointForGetRating(id);
    }

    @When("I request get rating of product {int}")
    public void iRequestGetRatingOfProduct(int id) {
        get.iRequestGetRatingOfProduct(id);
    }

    @And("I validate the {string} after get rating")
    public void iValidateTheAfterGetRating(String result) {
        get.iValidateTheAfterGetRating(result);
    }


    @Given("I set an endpoint for add rating {int}")
    public void iSetAnEndpointForAddRatingId(int id) {
        post.iSetAnEndpointForAddRatingId(id);
    }

    @When("I request add rating {int} {int} {string}")
    public void iRequestAddRatingStarId(int star, int id, String tok) throws Exception{
        post.iRequestAddRatingStarId(star, id, tok);
    }

    @And("I validate the {string} after add rating {int}")
    public void iValidateTheAfterAddRating(String result, int star) {
        post.iValidateTheAfterAddRating(result, star);
    }
}
