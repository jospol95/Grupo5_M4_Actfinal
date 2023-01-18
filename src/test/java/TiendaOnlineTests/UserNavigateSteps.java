package TiendaOnlineTests;

import Pages.HomePage;
import Pages.Modals.SignUpModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class UserNavigateSteps {

    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void should_navigate(){
        homePage.phonesLink.click();
        homePage.laptopsLink.click();
        homePage.monitorsLink.click();
        assertTrue(true);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
