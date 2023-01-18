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

public class LoginModal extends HomePage {

//    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logInModal\"]/div/div")
    WebElement loginModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"loginusername\"]")
    WebElement usernameInput;

   // @FindBy(how = How.XPATH, using ="//*[@id=\"signin2\"]")
    //WebElement loginLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginpassword\"]")
    WebElement passwdInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    WebElement loginBtn;

    @FindBy(how = How.ID, using = "sb_form_q")
    WebElement cancelBtn;

    //WebElement chromeAlert??
    public Alert loginResultAlert;

    public LoginModal(WebDriver driver){
        super(driver);
        loginLink.click();
    }

    private void setUsername (String username) {
        usernameInput.sendKeys(username);
    }

    private void setPassword (String passwd) {
        passwdInput.sendKeys(passwd);
    }

    public void cancellogin(){
        cancelBtn.click();
    }

    public void openPopUp(){
        Actions actions = new Actions(driver);
        actions.moveToElement(loginLink).click().build().perform();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")));
    }

    public void login(String username, String passwd){
        setUsername(username);
        setPassword(passwd);
        loginBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(30000))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

        loginResultAlert = driver.switchTo().alert();
//        al.accept();
    }
}
