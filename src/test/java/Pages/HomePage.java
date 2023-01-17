package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    @FindBy(how = How.ID, using = "sb_form_q")
    WebElement searchBar;

    protected WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
//        driver.get("https://www.bing.com");
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void doASearch(String value) {
        searchBar.sendKeys(value + Keys.ENTER);
    }
}
