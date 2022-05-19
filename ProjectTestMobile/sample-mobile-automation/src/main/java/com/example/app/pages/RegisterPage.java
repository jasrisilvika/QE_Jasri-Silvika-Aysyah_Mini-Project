package com.example.app.pages;


import com.example.app.Utils.General;
import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegisterPage extends BasePageObject {
    General general = new General();


    By registerButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }

    By fullnameField(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }

    By emailField(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }

    By passwordField(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    }

    By errorMessage(String result){
        return By.xpath("//android.view.View[@content-desc=\""+result+"\"]");
    }

    By loginButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    By beliButton(){
        return By.xpath("(//android.widget.Button[@content-desc=\"Beli\"])[1]");
    }

    public void validateOnRegisterPage(){
        Assertions.assertTrue(isDisplayed(registerButton()));
    }

    public void clickRegisterButton(){
        click(registerButton());
    }

//    public void iInputFullnameAndEmailAndPassword(String fullname, String email, String password) throws InterruptedException{
//        click(fullnameField());
//        Thread.sleep(1000);
//        sendKeys(fullnameField(),fullname);
//
//        click(emailField());
//        Thread.sleep(1000);
//        if (email.equals("new")){
//            sendKeys(emailField(),general.randomEmail());
//        } else {
//            sendKeys(emailField(),email);
//        }
//
//        click(emailField());
//        Thread.sleep(1000);
//        sendKeys(emailField(),email);
//
//        click(passwordField());
//        Thread.sleep(1000);
//        sendKeys(passwordField(),password);
//    }

    public void iInputFullname(String fullname) throws InterruptedException{
        Thread.sleep(2000);
        click(fullnameField());
        Thread.sleep(2000);
        sendKeys(fullnameField(),fullname);
    }

    public void iInputEmail(String email) throws InterruptedException{

        if (email.equals("new")){
            click(emailField());
            Thread.sleep(2000);
            sendKeys(emailField(),general.randomEmail());
        } else {
            click(emailField());
            Thread.sleep(2000);
            sendKeys(emailField(),email);
        }
    }

    public void iInputPassword(String password) throws InterruptedException{
        Thread.sleep(2000);
        click(passwordField());
        Thread.sleep(2000);
        sendKeys(passwordField(),password);
    }


    public void iValidateTheAfterRegister(String result) {
        if (result.equals("success")){
            Assertions.assertTrue(isDisplayed(beliButton()));
        } else if(result.equals("reqAll")){
            Assertions.assertTrue(isDisplayed(errorMessage("fullname can not empty")));
            Assertions.assertTrue(isDisplayed(errorMessage("email can not empty")));
            Assertions.assertTrue(isDisplayed(errorMessage("password can not empty")));
        }
        else {
            Assertions.assertTrue(isDisplayed(errorMessage(result)));
        }
    }
}
