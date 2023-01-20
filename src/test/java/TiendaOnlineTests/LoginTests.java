package TiendaOnlineTests;

import Pages.Modals.LoginModal;
import Pages.Modals.SignUpModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

import static org.junit.Assert.assertThat;

public class LoginTests {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //No necesario para login, no hay popUp
    public void should_login(){
        LoginModal loginModal = new LoginModal(driver);
        loginModal.openPage();
        loginModal.openPopUp();
        loginModal.login( "test", "test");

        //var alertTextResult = signUpModal.signUpResultAlert.getText();
        //assertThat(alertTextResult).isEqualToIgnoringCase("Sign up successful.");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
