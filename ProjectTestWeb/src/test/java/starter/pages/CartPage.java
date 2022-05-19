package starter.pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    private By buyButton(){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][5]//span[text() = 'Beli']");
    }

    private By plusButton(){
        return By.xpath("//div[@class='v-list-item__icon']//button//span[text()='+']");
    }

    private By totalQty(){
        return By.id("label-total-quantity");
    }

    private By totalBayar(){
        return By.id("label-total-bayar");
    }

    private By cartIcon(){
        return By.xpath("//div[@class='v-toolbar__content']//button[1]");
    }

    private By minusbutton(){
        return By.xpath("//div[@class='v-list-item__icon']//button//span[text()='-']");
    }

    private By emptyWarning(){
        return By.xpath("//div[@class='v-alert__content']");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public void clickBuy(){
        $(buyButton()).click();
    }

    @Step
    public void iGoToOrderPage(){
        $(cartIcon()).click();
    }

    @Step
    public boolean validateOnOrderPage(){
      return  $(plusButton()).isDisplayed();
    }

    @Step
    public void clickPlusButton(){
        $(plusButton()).click();
    }

    @Step
    public boolean validateTotalQty(String num){
        return $(totalQty()).getText().equals(num);
    }

    @Step
    public void clickMinusButton(){
        $(minusbutton()).click();
    }

    @Step
    public void validateEmptyCart(String text){
        $(emptyWarning()).getText().equals(text);
    }
}
