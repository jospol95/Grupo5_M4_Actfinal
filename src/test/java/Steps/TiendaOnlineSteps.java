package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TiendaOnlineSteps {

    WebDriver driver;
    public TiendaOnlineSteps(){

    }

    @Given("^user navigates to the login page by opening Firefox$")
    public void should_navigate(){
    }

    @When("^user enters correct username and password values$")
    public void should_login(){
    }

    @Then("^user gets directed to homepage$")
    public void should_sign_up(){
    }

//Direct to the Homepage of the application as a result of correct username and password inputs in the WHEN step. This would define the THEN step of the feature

}
