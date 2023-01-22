package step_definitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddToCartSteps {
    private WebDriver driver;
    private HomePage homePage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("user enter in the store")
    public void user_enter_in_the_store() {
        homePage = new HomePage(driver);
    }
    @When("user add items in the store")
    public void user_add_items_in_the_store() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);
        var samsungGalaxyS6XPath = "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";
        var samsungGalaxyS6AddToCartBtnXpath = "/html/body/div[5]/div/div[2]/div[2]/div/a";

        productDetailsPage.openPage();
        productDetailsPage.openItemByXPath(samsungGalaxyS6XPath);
        productDetailsPage.addItemToCartByXPath(samsungGalaxyS6AddToCartBtnXpath);
        var alertTextResult = productDetailsPage.addToCartAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added");
        productDetailsPage.addToCartAlert.accept();
        productDetailsPage.homeLink.click();

        var samsungGalaxyS7XPath = "/html/body/div[5]/div/div[2]/div/div[4]/div/div/h4/a";
        var samsungGalaxyS7AddToCartBtnXpath = "/html/body/div[5]/div/div[2]/div[2]/div/a";

        productDetailsPage.openPage();
        productDetailsPage.openItemByXPath(samsungGalaxyS7XPath);
        productDetailsPage.addItemToCartByXPath(samsungGalaxyS7AddToCartBtnXpath);
        productDetailsPage.addToCartAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added");
        productDetailsPage.addToCartAlert.accept();
        productDetailsPage.homeLink.click();

        var sonyVaioi7XPath = "/html/body/div[5]/div/div[2]/div/div[9]/div/div/h4/a";
        var sonyVaioi7AddToCartBtnXpath = "/html/body/div[5]/div/div[2]/div[2]/div/a";

        productDetailsPage.openPage();
        productDetailsPage.openItemByXPath(sonyVaioi7XPath);
        productDetailsPage.addItemToCartByXPath(sonyVaioi7AddToCartBtnXpath);
        productDetailsPage.addToCartAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added");
        productDetailsPage.addToCartAlert.accept();
        productDetailsPage.homeLink.click();
    }
    @Then("user check the cart")
    public void user_check_the_cart() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.cartLink.click();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
