package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class OrderPage extends PageObject {
    private By payButton(){
        return By.xpath("//div[@class='text-right mt-3']//span");
    }

    private By transactionPage(){
        return By.xpath("//div[@class='container']//h1");
    }

    @Step
    public void clickPayButton(){
        $(payButton()).click();
    }

    @Step
    public boolean validateOnTransactionPage(String text){
        return $(transactionPage()).getText().equals(text);
    }
}
