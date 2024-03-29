package step_definitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRemoveFromCartSteps {
    private WebDriver driver;
    ProductDetailsPage productDetailsPage;
    HomePage homePage;
    CartPage cartPage;
    String samsungGalaxyS6AddToCartBtnXpath, samsungGalaxyS6XPath, samsungGalaxyS6CartXpath;
    @Before("@userRemoveFromCartTest")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        samsungGalaxyS6XPath = "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";
        samsungGalaxyS6AddToCartBtnXpath = "/html/body/div[5]/div/div[2]/div[2]/div/a";
        samsungGalaxyS6CartXpath = "/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a";
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().window().maximize();
    }

    @Given("user navigates to home page")
    public void user_navigates_to_home_page(){
        productDetailsPage.openPage();
    }

    @When("opens a galaxy S6 item and adds it to cart")
    public void opens_a_galaxy_s6_item_and_adds_it_to_cart() {
        productDetailsPage.openPage();
        productDetailsPage.openItemByXPath(samsungGalaxyS6XPath);
        productDetailsPage.addItemToCartByXPath(samsungGalaxyS6AddToCartBtnXpath);
        var alertTextResult = productDetailsPage.addToCartAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added");
        productDetailsPage.addToCartAlert.accept();
        cartPage.goToCart();

    }
    @Then("user removes item from cart")
    public void user_removes_item_from_cart() {
        cartPage.goToCart();
        cartPage.deleteItemByXPath(samsungGalaxyS6CartXpath);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        WebElement TogetRows = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody"));
        List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));

        var totalRows = TotalRowsList.size();
        assertThat(totalRows).isEqualTo(0);
    }

    @After("@userRemoveFromCartTest")
    public void tearDown(){
        driver.quit();
    }
}
