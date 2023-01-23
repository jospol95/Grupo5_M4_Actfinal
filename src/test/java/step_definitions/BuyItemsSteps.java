package step_definitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.Modals.BuyItemsModal;
import Pages.ProductDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyItemsSteps {
    private WebDriver driver;
    private HomePage homePage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    @Before("@buyItemsTest")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Given("user navigates in the store")
    public void user_enter_in_the_store() {
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage.openPage();

    }
    @When("user is adding items in the store")
    public void user_add_items_in_the_store1() {
        var samsungGalaxyS6XPath = "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";
        var samsungGalaxyS6AddToCartBtnXpath = "/html/body/div[5]/div/div[2]/div[2]/div/a";

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
//        productDetailsPage.cartLink.click();
//        productDetailsPage.cartBtnOrder.click();
    }
    @Then("user buy items into the cart")
    public void user_buy_items_into_the_cart() {
        cartPage.goToCart();
        cartPage.place_order();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        var purchaseResultText = driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();;
        assertThat(purchaseResultText).isEqualToIgnoringCase("Thank you for your purchase!");
    }
    @After("@buyItemsTest")
    public void tearDown(){
        driver.quit();
    }
}
