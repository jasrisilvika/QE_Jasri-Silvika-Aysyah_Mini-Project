package starter.rating;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class Post {
    private String token;
    private static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for add rating {int}")
    public String iSetAnEndpointForAddRatingId(int id) {
        return base_url + "/products/" + id + "/ratings";
    }

    @Step("I request add rating {int} {int} {string}")
    public void iRequestAddRatingStarId(int star, int id, String tok) throws Exception{
        JSONObject reqData = new JSONObject();
        reqData.put("count", star);

        if (tok.equals("yes")){
            token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .body(reqData.toJSONString())
                    .when()
                    .post(iSetAnEndpointForAddRatingId(id));
        } else {
            SerenityRest.given().when().post(iSetAnEndpointForAddRatingId(id));
        }
    }

    @Step("I validate the {string} after add rating")
    public void iValidateTheAfterAddRating(String result, int star) {
        if(result.equals("success")){
            SerenityRest.then().body("data.Ratings", equalTo(star));
        }
        else {
            SerenityRest.then().body("error", equalTo(result));
        }
    }
}

