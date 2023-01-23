package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ProductDetailsPage extends HomePage{
    public Alert addToCartAlert;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void openItemByXPath(String XpathItem){
        wait.until(presenceOfElementLocated(By.xpath(XpathItem)));
        driver.findElement(By.xpath(XpathItem)).click();
    }
    public void addItemToCartByXPath(String XpathItem){
        wait.until(presenceOfElementLocated(By.xpath(XpathItem)));
        add_to_card_btn.click();

        new WebDriverWait(driver, Duration.ofSeconds(30000))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());


        addToCartAlert = driver.switchTo().alert();
    }


}
