package starter.authentication;

import Utils.General;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Post {
    General general = new General();
    String email;

    private  static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for post create account")
    public String iSetAnEndpointForPostCreateAccount(){
        return base_url + "/auth/register";
    }

    @Step("I set an endpoint for post create account")
    public String getEmail(){
        return this.email;
    }

    @Step("I request post create account with {string} and {string} and {string}")
    public void iRequestPostCreateAccountWithAndAnd(String full_name, String email, String password) {
        JSONObject reqData = new JSONObject();
        if (email.equals("new")){
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")){
                file.write(this.email);
                file.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }else if (email.equals("same")){
            this.email="jasrivika@gmail.com";
        }

        reqData.put("fullname",full_name);
        reqData.put("email", this.email);
        reqData.put("password",password);

        SerenityRest.given()
                .body(reqData.toJSONString())
                .when()
                .post(iSetAnEndpointForPostCreateAccount());
    }

    @Step("I validate the {string} after create account {string}")
    public void iValidateTheAfterCreateAccount(String message, String full_name) {
        if (message.equals("success")){
            SerenityRest.then().body("data.Fullname", equalTo(full_name));
            SerenityRest.then().body("data.Email", equalTo(this.email));
        } else if(message.equals("required")){
            SerenityRest.then().body("error", equalTo("ERROR: duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)"));
        } else {
            SerenityRest.then().body("error", equalTo(message));
        }
    }


    @Step("I set an endpoint for login")
    public String iSetAnEndpointForLogin() {
        return base_url + "/auth/login";
    }

    @Step("I request login with {string} and {string}")
    public void iRequestLoginWithAnd(String email, String password) {
        JSONObject requestData = new JSONObject();
        requestData.put("email", email);
        requestData.put("password",password);

        SerenityRest.given()
                .body(requestData.toJSONString())
                .when()
                .post(iSetAnEndpointForLogin());
    }

    @Step("I validate the {string} after login")
    public void iValidateTheAfterLogin(String result) {
        if(result.equals("success")){
            SerenityRest.then().body(notNullValue());
        } else {
            SerenityRest.then().body("error",equalTo(result));
        }
    }

    @Step("I get the token if {string} for other request")
    public String iGetTheTokenIfForOtherRequest() {
        Response response = SerenityRest.lastResponse();
        String token = response.body().path("data");
        System.out.println(token);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//token.json")){
            file.write(token);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return token;
    }

}
