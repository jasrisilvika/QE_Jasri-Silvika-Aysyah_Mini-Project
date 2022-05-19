package starter.categories;

import static org.hamcrest.CoreMatchers.equalTo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Get {
    protected static String base_url = "https://be-qa.alta.id/api";

    @Step ("I set an endpoint for GET all categories")
    public String iSetAnEndpointForGETAllCategories(){
        return base_url + "/categories";
    }

    @Step ("I request GET all categories")
    public void iRequestGETAllCategories(){
        SerenityRest.given()
                .when()
                .get(iSetAnEndpointForGETAllCategories());
    }

    @Step("I validate the status code is {int}")
    public void iValidateTheStatusCode(int arg0){
        restAssuredThat(response -> response.statusCode(arg0));
    }

    @Step("I validate = the body is not null")
    public void iValidateTheBodyIsNotNull() {
        SerenityRest.then().body(notNullValue());
//        restAssuredThat(response -> response.body("data.Name",equalTo("kesehatan")));
    }
}
