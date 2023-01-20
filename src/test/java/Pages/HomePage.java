package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
    public WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    public WebElement homeLink;
    @FindBy(how = How.ID, using = "sb_form_q")
    WebElement searchBar;
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[2]")
    public WebElement phonesLink;
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[3]")
    public WebElement laptopsLink;
    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div/a[4]")
    public WebElement monitorsLink;

    public WebDriverWait wait;

//    public Alert cartResultAlert;
//    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a")
//    public WebElement galaxy_s6_link;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[2]/div[2]/div/a")
    public WebElement add_to_card_btn;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a")
    public WebElement delete_link;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void openPage(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void doASearch(String value) {
        searchBar.sendKeys(value + Keys.ENTER);
    }

//    public void addItemToCartByXpath(String locator){
//        wait.until(presenceOfElementLocated(By.xpath(locator)));
//    }
//
//    public void addGalaxyS6ToCart(){
//        wait.until(presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
//        add_to_card_btn.click();
//
//        new WebDriverWait(driver, Duration.ofSeconds(30000))
//                .ignoring(NoAlertPresentException.class)
//                .until(ExpectedConditions.alertIsPresent());
//
//        cartResultAlert = driver.switchTo().alert();
//    }

//    public void goToGalaxyS6Page(){
//        wait.until(presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a")));
//        galaxy_s6_link.click();
//    }

//    public void goToCart(){
//        cart_menu_link.click();
//    }

//    public void deleteItem(){
//        wait.until(presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a")));
//        delete_link.click();
//    }
}
