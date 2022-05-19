package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {
    By loginIcon(){
        return By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }

    By beliButton(int index){
        return By.xpath("(//android.widget.Button[@content-desc=\"Beli\"])["+index+"]");
    }

    By cartIcon(int value){
        return By.xpath("//android.widget.Button[@content-desc=\""+value+"\"]");
    }

    public void clickBuyButton(int value){
        if (value == 0){
            click(beliButton(value));
        } else {
            for (int i=1; i <= value; i++){
                click(beliButton(i));
            }
        }
    }


    public void clickLoginIcon(){
        click(loginIcon());
    }

    public void validateCart(int value){
        Assertions.assertTrue(isDisplayed(cartIcon(value)));
    }
}
