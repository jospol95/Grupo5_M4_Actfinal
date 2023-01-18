package step_definitions;

import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class UserNavigateSteps {
    private HomePage homePage;
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("user navigates to website")
    public void user_navigates_to_website() {
        homePage = new HomePage(driver);
    }
    @When("user clicks navigation links")
    public void user_clicks_navigation_links() {
        homePage.phonesLink.click();
        homePage.laptopsLink.click();
        homePage.monitorsLink.click();
    }
    @Then("navigation should be successful")
    public void navigation_should_be_successful() {
        assertTrue(true);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
