package TiendaOnlineTests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.Modals.BuyItemsModal;
import TiendaOnlineTests.BuyItemsTests;
import Pages.ProductDetailsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyItemsTests {

    private WebDriver driver;

    public Alert cartResultAlert;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void adding_products(){
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
        productDetailsPage.cartLink.click();
        productDetailsPage.cartBtnOrder.click();
    }
public void buying_products(){

    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

    var cartModal = "/html/body/div[3]/div/div";
    BuyItemsModal buyItemsModal = new BuyItemsModal(driver);
    buyItemsModal.openPage();
    buyItemsModal.openPopUp();

    buyItemsModal.buyItem("test", "Spain", "Palma de Mallorca", "2344543534231", "08", "2023");
    //var alertTextResult = buyItemsModal.cartResultAlert.getText();
    //assertThat(alertTextResult).isEqualToIgnoringCase("Thank you for your purchase!");


}

    //@After
    //public void tearDown(){
       // driver.quit();
    //}
}
