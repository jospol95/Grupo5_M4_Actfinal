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

public class SignUpModal extends HomePage {

//    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"signInModal\"]/div/div")
    WebElement signUpModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"sign-username\"]")
    WebElement usernameInput;

    @FindBy(how = How.XPATH, using ="//*[@id=\"signin2\"]")
    WebElement signUpLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"sign-password\"]")
    WebElement passwdInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    WebElement signUpBtn;

    public Alert signUpResultAlert;

    public SignUpModal(WebDriver driver){
        super(driver);
//        signUpLink.click();
    }

    private void setUsername (String username) {
        usernameInput.sendKeys(username);
    }

    private void setPassword (String passwd) {
        passwdInput.sendKeys(passwd);
    }


    public void openPopUp(){
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"signin2\"]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(signUpLink).click().build().perform();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"signInModal\"]/div/div")));
    }
    //*[@id="logInModal"]/div/div
    public void signUp(String username, String passwd){
        setUsername(username);
        setPassword(passwd);
        signUpBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(30000))
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

        signUpResultAlert = driver.switchTo().alert();
//        al.accept();
    }
}
