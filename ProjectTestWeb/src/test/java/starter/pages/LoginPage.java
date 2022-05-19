package starter.pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By emailField(){
        return By.xpath("//*[label[text()='Email']]/input");
    }

    private By passwordField(){
        return By.xpath("//*[label[text()='Password']]/input");
    }

    private By loginButton(){
        return By.xpath("//div[@class='text-center']//button");
    }

    private By errorMesage(){
        return By.className("v-alert__content");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public boolean validateOnLoginPage(){
        return $(loginButton()).isDisplayed();
    }

    @Step
    public void inputEmail(String email){
        $(emailField()).type(email);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

    @Step
    public boolean errorMessageAppears(){
        return $(errorMesage()).isDisplayed();
    }

    @Step
    public boolean errorMessageEqual(String text){
        return $(errorMesage()).getText().equals(text);
    }
}

