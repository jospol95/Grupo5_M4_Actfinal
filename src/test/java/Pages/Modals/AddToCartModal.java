package Pages.Modals;

import Pages.HomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddToCartModal extends HomePage {

//    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[4]/div/div/h4/a")
    WebElement s7LinkModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    WebElement s7AddModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    WebElement s6LinkModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    WebElement s6AddModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[9]/div/div/h4/a")
    WebElement vi7LinkModal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    WebElement vi7AddModal;


    public Alert addToCartResultAlert;


    //@FindBy(how = How.ID, using = "sb_form_q")
    //WebElement cancelBtn;

    //WebElement chromeAlert??

    public AddToCartModal(WebDriver driver){
        super(driver);
        //loginLink.click();
    }

    public void openProducts(){
        //Adding Sony Galaxy 7
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        Actions actions = new Actions(driver);
        actions.moveToElement(s7LinkModal).click().build().perform();

        //Adding Sony Galaxy 6
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        Actions actions = new Actions(driver);
        actions.moveToElement(s6LinkModal).click().build().perform();

        //Adding Vaio 7
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        Actions actions = new Actions(driver);
        actions.moveToElement(vi7LinkModal).click().build().perform();

    }

    public void addToCart(){



        //loginResultAlert = driver.switchTo().alert();
//        al.accept();
    }
}
