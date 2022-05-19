package starter.transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class Post {

    private static String base_url = "https://be-qa.alta.id/api";
    @Step("I set an endpoint fot post create transactions")
    public String iSetAnEndpointFotPostCreateTransactions() {
        return base_url + "/orders";
    }

    @Step("I request post create transaction with {int} and {int}")
    public List<JSONObject> bodyData(int product, int quantity) {
        List<JSONObject> reqData = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id",product);
        data.put("quantity",quantity);

        reqData.add(data);
        return reqData;
    }

    @Step("I request post create transaction with {int} and {int}")
    public void iRequestPostCreateTransactionWithProductAndQuantity(int product, int quantity) throws Exception {
        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//token.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .body(bodyData(product,quantity))
                .when()
                .post(iSetAnEndpointFotPostCreateTransactions());
    }

//    belom bener
    @Step("I validate the {string} with {int} and {int}")
    public void iValidateTheWithProductAndQuantity(String message, int product, int quantity) {
        if (message.equals("success")){
            SerenityRest.then().body("data[0].Product.ID",equalTo(product));
            SerenityRest.then().body("data[0].Quantity",equalTo(quantity));
        }
        else if (message.equals("pNull")){
            SerenityRest.then().body("data[0].Product",equalTo(null));
        }
        else if (message.equals("qNull")){
            SerenityRest.then().body("data[0].Quantity", equalTo(0));
        }
    }
}
