package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.authentication.Post;

public class AuthenticationSteps {
    public String email, token;

    @Steps
    Post post;

    @Given("I set an endpoint for post create account")
    public void iSetAnEndpointForPostCreateAccount(){
        post.iSetAnEndpointForPostCreateAccount();
    }

    @When("I request post create account with {string} and {string} and {string}")
    public void iRequestPostCreateAccountWithAndAnd(String full_name, String email, String password) {
        post.iRequestPostCreateAccountWithAndAnd(full_name, email, password);
        this.email = post.getEmail();
    }


    @And("I validate the {string} after create account {string}")
    public void iValidateTheAfterCreateAccount(String message, String full_name) {
        post.iValidateTheAfterCreateAccount(message, full_name);
    }


    @Given("I set an endpoint for login")
    public void iSetAnEndpointForLogin() {
        post.iSetAnEndpointForLogin();
    }

    @When("I request login with {string} and {string}")
    public void iRequestLoginWithAnd(String email, String password) {
        post.iRequestLoginWithAnd(email, password);
    }


    @And("I validate the {string} after login")
    public void iValidateTheAfterLogin(String result) {
        post.iValidateTheAfterLogin(result);
    }

    @And("I get the token if {string} for other request")
    public void iGetTheTokenIfForOtherRequest(String result) {
        if(result.equals("success")){
            this.token = post.iGetTheTokenIfForOtherRequest();
        }
    }
}
