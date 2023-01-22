package step_definitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.Modals.LoginModal;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps {
    private WebDriver driver;
    private LoginModal LoginModal;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("user navigates to the user login page")
    public void user_navigates_to_the_user_login_page() {
        LoginModal.openPopUp();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        LoginModal.login( "test", "test");
    }
    @Then("user login in the website")
    public void user_login_in_the_website() {
       // var alertTextResult = LoginModal.LoginResultAlert.getText();
        //assertThat(alertTextResult).isEqualToIgnoringCase("Sign up successful.");
        //wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
