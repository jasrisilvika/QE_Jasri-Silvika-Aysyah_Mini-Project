package starter.products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get {
    private static String base_url = "https://be-qa.alta.id/api";

    @Step("I set an endpoint for get all products")
    public String  iSetAnEndpointForGetAllProducts() {
        return base_url + "/products";
    }

    @Step("I request get all products")
    public void iRequestGetAllProducts() {
        SerenityRest.given().when()
                .get(iSetAnEndpointForGetAllProducts());
    }

    @Step("I set an endpoint for get product by {int}")
    public String iSetAnEndpointForGetProductById(int id) {
        return base_url + "/products/" + id;
    }

    @Step("I request get product by id")
    public void iRequestGetProductById(int id) {
        SerenityRest.given().when()
                .get(iSetAnEndpointForGetProductById(id));
    }

    @Step("I validate the {string} after get product by id")
    public void iValidateTheAfterGetProductById(String message, int id) {
        if (message.equals("success")){
            SerenityRest.then().body("data.ID", equalTo(id));
        }
        else{
            SerenityRest.then().body("error", equalTo("record not found"));
        }

    }
}
