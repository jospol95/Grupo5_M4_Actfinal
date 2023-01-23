package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CartPage extends HomePage{
    @FindBy(how = How.XPATH, using = "/html/body/nav/div/div/ul/li[4]/a")
    public WebElement cart_menu_link;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/button")
    public WebElement place_order_btn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    public WebElement purchase_btn;

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

    public void place_order(){
        place_order_btn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("USA");
        driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("1234 5433 1233");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("NY");
        driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("05");
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2023");
        purchase_btn.click();


    }
}
