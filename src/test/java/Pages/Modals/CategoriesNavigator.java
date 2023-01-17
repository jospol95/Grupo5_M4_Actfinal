package Pages.Modals;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoriesNavigator extends HomePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"itemc\"]")
    WebElement phonesLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"itemc\"]")
    WebElement laptopsLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"signInModal\"]/div/div")
    WebElement monitorsLink;

    public CategoriesNavigator(WebDriver driver) {
        super(driver);
    }
}
