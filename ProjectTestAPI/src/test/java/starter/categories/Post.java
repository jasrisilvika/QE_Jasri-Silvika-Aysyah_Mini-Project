package starter.categories;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    private static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for POST create category")
    public String iSetAnEndpointForPOSTCreateCategory() {
        return base_url + "categories";
    }

    @Step("I request POST create category")
    public void iRequestPOSTCreateCategory(String category) {
        JSONObject reqData = new JSONObject();
        reqData.put("name", category);

        SerenityRest.given().header("Content-Type", "application/json")
                .body(reqData.toJSONString());
        SerenityRest.when()
                .post(iSetAnEndpointForPOSTCreateCategory());
    }


    @Step("I validate the data detail {string}")
    public void iValidateTheDataDetail(String categoryEqual) {
        if (categoryEqual.equals("gadget")) {
            SerenityRest.then().body("data.Name", equalTo(categoryEqual));
        }
        else {
            SerenityRest.then().body("error", equalTo(categoryEqual));
        }
    }

    @Step("I validate the status code {string}")
    public void iValidateTheStatusCode(String arg0) {
        SerenityRest.then().statusCode(Integer.parseInt(arg0));
    }


}
