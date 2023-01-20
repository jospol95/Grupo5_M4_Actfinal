package TiendaOnlineTests;

import Pages.Modals.AddToCartModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AddToCartTests {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void should_sign_up(){
        AddToCartModal addToCartModal = new AddToCartModal(driver);
        addToCartModal.openProducts();
        addToCartModal.addToCart(UUID.randomUUID().toString(), "strongpasswd123");

        var alertTextResult = addToCartModal.addToCartResultAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added.");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
