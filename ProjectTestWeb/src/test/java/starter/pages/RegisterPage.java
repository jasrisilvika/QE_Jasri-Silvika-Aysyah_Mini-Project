package starter.pages;

import Utils.General;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    General general = new General();

    private By fullnameField(){
        return By.xpath("//*[label[text()='Nama Lengkap']]/input");
    }

    private  By emailFIeld(){
        return By.xpath("//*[label[text()='Email']]/input");
    }

    private By passwordField(){
        return By.xpath("//*[label[text()='Password']]/input");
    }

    private By registerButton(){
        return By.xpath("//div[@class='text-center']//button");
    }

    private By errorMessage(){
        return By.xpath("//div[@class='v-alert__wrapper']//div[@class='v-alert__content']");
    }

    private By warningIcon(){
        return By.xpath("//div[@class='v-alert__wrapper']//i");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public boolean validateOnRegisterPage() {
        return $(registerButton()).isDisplayed();
    }

    @Step
    public void inputFullname(String fullname){
        $(fullnameField()).type(fullname);
    }

    @Step
    public void inputEmail(String email){
        if (email.equals("new")){
            $(emailFIeld()).type(general.randomEmail());
        }
        else {
            $(emailFIeld()).type(email);
        }

    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickRegisterButton(){
        $(registerButton()).click();
    }

    @Step
    public boolean warningIconAppears(){
        return $(warningIcon()).isDisplayed();
    }

    @Step
    public boolean errorMessageEqual(String text){
        return $(errorMessage()).getText().equals(text);
    }

}
