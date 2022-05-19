package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DetailPage extends PageObject {
    private String name, price;

    private By nameTag(int product){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6']["+ product +"]//div//div");
    }

    private By priceTag(int product){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6']["+ product +"]//div[3]//div[1]//b");
    }

    private By nameTagDetail(){
        return By.xpath("//div[@class='v-card__text']//p[1]");
    }

    private By priceTagDetail(){
        return By.xpath("//div[@class='v-card__text']//p[2]//b");
    }

    private By detailButton(int product){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][" + product + "]//span[text() = 'Detail']");
    }

    @Step
    public String getDetailNameInCard(int product){
        String name = $(nameTag(product)).getText();
        System.out.println(name);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//name.json")){
            file.write(name);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }

    @Step
    public String getDetailPriceInCard(int product){
        String price = $(priceTag(product)).getText();
        System.out.println(price);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//price.json")){
            file.write(price);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return price;
    }

    @Step
    public void clickDetailButton(int product){
        $(detailButton(product)).click();
    }

    @Step
    public boolean validateProductName(int product) throws Exception{
//        return $(nameTag(product)).getText().equals($(nameTagDetail()).getText());
        name = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//name.json"), StandardCharsets.UTF_8);
        return $(nameTagDetail()).getText().equals(name);
    }

    @Step
    public boolean validateProductPrice(int product) throws Exception{
//        return $(priceTag(product)).getText().equals($(priceTagDetail()).getText());
        price = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//price.json"), StandardCharsets.UTF_8);
        return $(priceTagDetail()).getText().equals(price);
    }
}
