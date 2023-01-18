package TiendaOnlineTests;

import Pages.HomePage;
import Pages.Modals.SignUpModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RemoveFromCartTests {


    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void should_remove_galaxy_from_cart(){
        HomePage page = new HomePage(driver);
        page.goToGalaxyS6Page();

        page.addGalaxyS6ToCart();

        var alertTextResult = page.cartResultAlert.getText();
        assertThat(alertTextResult).isEqualToIgnoringCase("Product added");

        page.cartResultAlert.accept();
        page.goToCart();

        page.deleteItem();
    }


//    @Test
//    public void should_sign_up(){
//        SignUpModal signUpModal = new SignUpModal(driver);
//        signUpModal.openPopUp();
//        signUpModal.signUp(UUID.randomUUID().toString(), "strongpasswd123");
//
//        var alertTextResult = signUpModal.signUpResultAlert.getText();
//        assertThat(alertTextResult).isEqualToIgnoringCase("Sign up successful.");
//    }
//
//    @Test
//    public void should_navigate_trough_options(){
//
//    }

    @After
    public void tearDown(){
        driver.quit();
    }
}