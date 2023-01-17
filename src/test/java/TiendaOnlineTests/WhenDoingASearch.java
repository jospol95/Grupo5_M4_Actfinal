package TiendaOnlineTests;

import Pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WhenDoingASearch {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void should_see_tittle(){
        HomePage homePage = new HomePage(driver);

        driver.get("https://www.bing.com");
        homePage.doASearch("CHEESECAKE");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
