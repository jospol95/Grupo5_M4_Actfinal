package step_definitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.Modals.LoginModal;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps {
    private WebDriver driver;
    private LoginModal LoginModal;
    @Before("@loginTest")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        LoginModal = new LoginModal(driver);
    }
    @Given("user navigates to the user login page")
    public void user_navigates_to_the_user_login_page() {
        LoginModal.openPage();
        LoginModal.openPopUp();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        LoginModal.login( "test", "test");
    }
    @Then("user login in the website")
    public void user_login_in_the_website() {
        var welcomeUserLinkXpath = "/html/body/nav/div[1]/ul/li[7]/a";
        LoginModal.wait.until(presenceOfElementLocated(By.xpath(welcomeUserLinkXpath)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        assertThat(LoginModal.welcomeUserLink.getText()).isEqualToIgnoringCase("Welcome Test");
    }
    @After("@loginTest")
    public void tearDown(){
        driver.quit();
    }
}
