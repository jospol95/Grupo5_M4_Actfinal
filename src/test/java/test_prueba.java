import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class test_prueba {

    private WebDriver browser;
    private WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        browser = new ChromeDriver();
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
//        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))
    }
    @Test
//    public void should_do_something(){
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
//        WebDriver browser = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
//
//        browser.get("https://www.demoblaze.com/index.html");
//    }

    public void mi_primer_test(){
    browser.get("https://www.bing.com");
    browser.findElement(By.cssSelector("#sb_form_q")).sendKeys("CHEESECAKE" + Keys.ENTER);

    wait.until(presenceOfElementLocated(By.cssSelector(".b_poleContent")));
    String title = browser.findElement(By.cssSelector(".b_antiSideBleed")).getText();

    assertThat(title).isEqualToIgnoringCase("Recipes");
    }

    @After
    public void tearDown(){
        browser.quit();
    }
}
