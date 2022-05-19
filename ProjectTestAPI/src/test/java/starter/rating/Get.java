package starter.rating;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Get {
    private static String base_url = "https://be-qa.alta.id/api";
    @Step("I set an endpoint for get rating")
    public String iSetAnEndpointForGetRating(int id){
        return base_url + "/products/" + id + "/ratings";
    }

    @Step("I request get rating of product {int}")
    public void iRequestGetRatingOfProduct(int id) {
        SerenityRest.given()
                .when()
                .get(iSetAnEndpointForGetRating(id));
    }

    @Step("I validate the {string} after get rating")
    public void iValidateTheAfterGetRating(String result) {
        if (result.equals("success")) {
            SerenityRest.then().body(notNullValue());
        } else {
            SerenityRest.then().body("data", equalTo(0));
        }
    }
}
