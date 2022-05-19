package starter.products;

import io.cucumber.java.en.And;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    private static String base_url = "https://be-qa.alta.id/api";


    @Step("I set an endpoint for post product")
    public String iSetAnEndpointForPostProduct(){
        return base_url + "/products";
    }

    @Step("I request post create product with {string} and {int} and {int}")
    public void iRequestPostCreateProductWithAndPriceAndCategories(String name, int price, int categories) {
        JSONObject reqData = new JSONObject();
        reqData.put("name",name);
        reqData.put("price",price);
        reqData.put("category",categories);

        SerenityRest.given().body(reqData.toJSONString())
                .when().post(iSetAnEndpointForPostProduct());
    }

    @Step("I validate the status code <status_code>")
    public void iValidateTheStatusCodeStatus_code(Integer status_code) {
        SerenityRest.then()
                .statusCode(status_code);
    }

    @Step("I validate the {string}")
    public void iValidateThe(String message) {
        if (message.equals("success")){
            SerenityRest.then().body("data.Name", equalTo("Flare Skirt"));
            SerenityRest.then().body("data.Price", equalTo(250000));
        }
        else {
            SerenityRest.then().body("error", equalTo(message));
        }

    }



}
