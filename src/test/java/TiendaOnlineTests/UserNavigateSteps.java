package TiendaOnlineTests;

import Pages.HomePage;
import Pages.Modals.SignUpModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class UserNavigateSteps {

    private WebDriver driver;
    private HomePage homePage;

    String firstPhoneName, firstComputerName, firstMonitorName;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();

    }

    @Test
    public void should_navigate(){
        homePage.openPage();

        homePage.phonesLink.click();
        var firstElementLink ="/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";
        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));
        firstPhoneName = driver.findElement(By.xpath(firstElementLink)).getText();;

        homePage.laptopsLink.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));

        firstComputerName = driver.findElement(By.xpath(firstElementLink)).getText();;
//        assertThat(firstLaptopLinkText).isEqualToIgnoringCase("Sony vaio i5");

        homePage.monitorsLink.click();
        homePage.wait.until(presenceOfElementLocated(By.xpath(firstElementLink)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        firstMonitorName = driver.findElement(By.xpath(firstElementLink)).getText();
//        assertThat(firstMonitorLink.getText()).isEqualToIgnoringCase("Apple monitor 24");
        assertThat(firstPhoneName).isEqualToIgnoringCase("Samsung Galaxy S6");
        assertThat(firstComputerName).isEqualToIgnoringCase("Sony vaio i5");
        assertThat(firstMonitorName).isEqualToIgnoringCase("Apple monitor 24");


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
