package starter.comment;

import static org.hamcrest.CoreMatchers.equalTo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Get {
    private static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for get comment {int}")
    public String iSetAnEndpointForGetComment(int id){
        return base_url +  "/products/" + id + "/comments";
    }

    @Step("I request get comment of product {id}")
    public void iRequestGetCommentOfProductId(int id) {
        SerenityRest.given().when().get(iSetAnEndpointForGetComment(id));
    }

    @Step("I validate the {string} after get comment")
    public void iValidateTheAfterGetComment(String result) {
        if (result.equals("success")) {
            SerenityRest.then().body(notNullValue());
        }
    }
}

