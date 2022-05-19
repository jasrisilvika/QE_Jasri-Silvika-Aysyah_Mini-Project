package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    private By headerHomepage(){
        return By.xpath("//header//div[@class='v-toolbar__title']//h3");
    }

    private By searchBar(){
        return By.xpath("//div[@class='v-select__slot']//label");
    }

    private By profileIcon(){
        return By.xpath("//div[@class='v-toolbar__content']//button[2]");
    }

    private By logoutButton(){
        return By.xpath("//*[@class=\"v-list v-sheet theme--light\"]/div[2]");
    }


    @Step
    public boolean validateHeaderHomepageEqual(String text){
        return $(headerHomepage()).getText().equals(text);
    }

    @Step
    public boolean validateSearchBarAppears(){
        return $(searchBar()).isDisplayed();
    }

    @Step
    public boolean validateSearchBarEqual(String text){
        return $(searchBar()).getText().equals(text);
    }

    @Step
    public void clickProfileIcon(){
        $(profileIcon()).click();
    }

    @Step
    public void clickLogoutButton(){
        $(logoutButton()).click();
    }
}
