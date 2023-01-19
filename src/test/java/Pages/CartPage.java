package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CartPage extends HomePage{
    @FindBy(how = How.XPATH, using = "/html/body/nav/div/div/ul/li[4]/a")
    public WebElement cart_menu_link;


    public CartPage(WebDriver driver) {
        super(driver);
//        cart_menu_link.click();
    }

    public void goToCart(){
        cart_menu_link.click();
    }

    public void deleteItemByXPath(String xPath){
        wait.until(presenceOfElementLocated(By.xpath(xPath)));
        delete_link.click();
    }
}
