package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class LoginPage extends BasePageObject {
    By loginText(){
        return By.xpath("//android.view.View[@content-desc=\"Login\"]");
    }

    By emailField(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }

    By passwordField(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }

    By loginButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    By productText(){
        return By.xpath("//android.view.View[@content-desc=\"Products\"]");
    }

    By errorMessage(String result){
        return By.xpath("//android.view.View[@content-desc=\""+result+"\"]");
    }

    By logoutButton(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }

    By cartIcon(){
        return By.xpath("//android.widget.Button[@content-desc=\"0\"]");
    }

    By beliButton(){
        return By.xpath("(//android.widget.Button[@content-desc=\"Beli\"])[1]");
    }

    By registerMenu(){
        return By.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }

    public void validateOnLoginPage(){
        Assertions.assertTrue(isDisplayed(loginButton()));
    }

    public void iInputAnd(String email, String password) throws InterruptedException{

        click(emailField());
        Thread.sleep(1000);
        sendKeys(emailField(),email);

        click(passwordField());
        Thread.sleep(1000);
        sendKeys(passwordField(),password);
    }

    public void clickLoginButton(){
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        click(loginButton());
    }

    public void iValidateThe(String result) throws InterruptedException{
        if (result.equals("success")){
            Assertions.assertTrue(isDisplayed(cartIcon()));
        } else if(result.equals("req")) {
            Assertions.assertTrue(isDisplayed(errorMessage("email can not empty")));
            Assertions.assertTrue(isDisplayed(errorMessage("password can not empty")));
        }else {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            Thread.sleep(1000);
            Assertions.assertTrue(isDisplayed(errorMessage(result)));
        }
    }
    public void validateOnHomePage(){
        Assertions.assertTrue(isDisplayed(cartIcon()));
    }

    public void clickLogoutButton(){
        click(logoutButton());
    }

    public void clickRegisterMenu(){
        click(registerMenu());
    }

//    public void iInputEmail(String email) throws InterruptedException{
//        Thread.sleep(1000);
//        click(emailField());
//        sendKeys(emailField(),email);
//    }
//
//    public void iInputPassword(String password) throws InterruptedException{
//        Thread.sleep(1000);
//        click(passwordField());
//        sendKeys(passwordField(),password);
//    }
}

