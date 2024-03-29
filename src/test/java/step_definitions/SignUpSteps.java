package step_definitions;

import Pages.Modals.SignUpModal;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpSteps {
    private WebDriver driver;
    private SignUpModal signUpModal;
    @Before("@userSignUpTest")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        signUpModal = new SignUpModal(driver);
    }
    @Given("user navigates to the user sign up page")
    public void user_navigates_to_the_user_sign_up_page() {
        signUpModal.openPage();
        signUpModal.openPopUp();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    @When("user enters a new username and password")
    public void user_enters_a_correct_username_and_password() {
        signUpModal.signUp(UUID.randomUUID().toString(), "strongpasswd123");
    }
    @Then("user signs up in the website")
    public void user_signs_up_in_the_website() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        var alertTextResult = signUpModal.signUpResultAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Sign up successful.");
    }
    @After("@userSignUpTest")
    public void tearDown(){
        driver.quit();
    }
}
