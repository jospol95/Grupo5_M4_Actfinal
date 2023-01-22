package Pages.Modals;

import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BuyItemsModal extends HomePage {

//    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"orderModal\"]/div/div")
    WebElement cartModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    WebElement cartBtnOrder;
    @FindBy(how = How.XPATH, using = "//*[@id=\"name\"]")
    WebElement nameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
    WebElement countryInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
    WebElement cityInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"card\"]")
    WebElement creditInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"month\"]")
    WebElement monthInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"year\"]")
    WebElement yearInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    WebElement purchaseBtn;


    //@FindBy(how = How.ID, using = "sb_form_q")
    //WebElement cancelBtn;

    //WebElement chromeAlert??

    public BuyItemsModal(WebDriver driver){
        super(driver);
        //loginLink.click();
    }


    private void setUsername (String username) {
        nameInput.sendKeys(username);
    }

    private void setCountry (String country) {
        countryInput.sendKeys(country);
    }
    private void setCity (String city) {
        cityInput.sendKeys(city);
    }
    private void setCredit (String credit) {
        creditInput.sendKeys(credit);
    }
    private void setMonth (String month) {
        monthInput.sendKeys(month);
    }

    private void setYear (String year) {
        yearInput.sendKeys(year);
    }
    public void openPopUp(){

        Actions actions = new Actions(driver);
        actions.moveToElement(cartLink).click().build().perform();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"orderModal\"]/div/div")));
    }

    public void buyItem(String username, String country, String city, String credit, String month, String year){
        setUsername(username);
        setCountry(country);
        setCity(city);
        setCredit(credit);
        setMonth(month);
        setYear(year);
        purchaseBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(30000))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

//        al.accept();
    }

}
