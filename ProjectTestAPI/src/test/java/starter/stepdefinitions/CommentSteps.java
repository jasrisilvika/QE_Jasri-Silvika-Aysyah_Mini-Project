package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.comment.Get;
import starter.comment.Post;

public class CommentSteps {
    @Steps
    Get get;

    @Steps
    Post post;

    @Given("I set an endpoint for get comment {int}")
    public void iSetAnEndpointForGetComment(int id){
        get.iSetAnEndpointForGetComment(id);
    }

    @When("I request get comment of product {int}")
    public void iRequestGetCommentOfProductId(int id) {
        get.iRequestGetCommentOfProductId(id);
    }


    @And("I validate the {string} after get comment")
    public void iValidateTheAfterGetComment(String result) {
        get.iValidateTheAfterGetComment(result);
    }


    @Given("I set an endpoint for add comment {int}")
    public void iSetAnEndpointForAddCommentId(int id) {
        post.iSetAnEndpointForAddCommentId(id);
    }

    @When("I request add comment {string} {int} {string}")
    public void iRequestAddCommentId(String comment, int id,  String tok) throws Exception{
        post.iRequestAddCommentId(comment, id, tok);
    }

    @And("I validate the {string} after add comment {string}")
    public void iValidateTheAfterAddComment(String result, String comment) {
        post.iValidateTheAfterAddComment(result, comment);
    }
}
