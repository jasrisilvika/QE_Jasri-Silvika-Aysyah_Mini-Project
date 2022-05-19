package starter.transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import static org.hamcrest.CoreMatchers.notNullValue;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class Get {
    private String token;
    private static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for get all transactions")
    public String iSetAnEndpointForGetAllTransactions(){
        return base_url + "/orders";
    }

    @Step("I request get all transactions {string}")
    public void iRequestGetAllTransactions(String tok) throws Exception {
        if (tok.equals("yes")){
            token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);
            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .get(iSetAnEndpointForGetAllTransactions());
        } else {
            SerenityRest.given().when().get(iSetAnEndpointForGetAllTransactions());
        }

    }

    @Step("I validate the {string} after get all transactions")
    public void iValidateTheAfterGetAllTransactions(String message) {
        if (message.equals("success")){
            SerenityRest.then().body(notNullValue());
            SerenityRest.then().body("data[0].Product", equalTo("Durian Jatuh"));
            SerenityRest.then().body("data[1].Product", equalTo("Tensi Darah Elektrik"));
        } else {
            SerenityRest.then().body("error", equalTo("unauthorized"));
        }
    }

}
