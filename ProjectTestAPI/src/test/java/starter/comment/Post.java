package starter.comment;

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

    @Step("I set an endpoint for add comment {int}")
    public String iSetAnEndpointForAddCommentId(int id) {
        return base_url +  "/products/" + id + "/comments";
    }

    @Step("I request add comment {string} {int} {string}")
    public void iRequestAddCommentId(String comment, int id,  String tok) throws  Exception{
        JSONObject reqData = new JSONObject();
        reqData.put("content",comment);

        if (tok.equals("yes")){
            token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .body(reqData.toJSONString())
                    .when()
                    .post(iSetAnEndpointForAddCommentId(id));
        } else {
            SerenityRest.given()
                    .when()
                    .post(iSetAnEndpointForAddCommentId(id));
        }
    }

    @Step("I validate the {string} after add comment {string}")
    public void iValidateTheAfterAddComment(String result, String comment) {
        if (result.equals("success")){
            SerenityRest.then()
                    .body("data.Content", equalTo(comment));
        } else {
            SerenityRest.then()
                    .body("error", equalTo(result));
        }


    }
}
