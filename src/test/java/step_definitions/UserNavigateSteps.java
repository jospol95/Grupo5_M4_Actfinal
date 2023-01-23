package step_definitions;

import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserNavigateSteps {
    private HomePage homePage;
    private WebDriver driver;
    String firstPhoneName, firstComputerName, firstMonitorName;


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
        homePage.openPage();
        homePage.phonesLink.click();
        var firstElementLink ="/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";
        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));
        firstPhoneName = driver.findElement(By.xpath(firstElementLink)).getText();;

        homePage.laptopsLink.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));
        firstComputerName = driver.findElement(By.xpath(firstElementLink)).getText();;
        homePage.monitorsLink.click();

        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        firstMonitorName = driver.findElement(By.xpath(firstElementLink)).getText();
    }
    @Then("navigation should be successful")
    public void navigation_should_be_successful() {
        assertThat(firstPhoneName).isEqualToIgnoringCase("Samsung Galaxy S6");
        assertThat(firstComputerName).isEqualToIgnoringCase("Sony vaio i5");
        assertThat(firstMonitorName).isEqualToIgnoringCase("Apple monitor 24");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
