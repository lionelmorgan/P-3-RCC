package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.RegisterPOM;

public class RegisterSDF {

    RegisterPOM registerPOM;

    @Given("a user is on the register page")
    public void a_user_is_on_the_register_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/register");
        this.registerPOM = new RegisterPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/register", this.registerPOM.getCurrentUrl());
    }

    @When("a user inputs unused credentials")
    public void a_user_inputs_unused_credentials(){
        this.registerPOM.enterUsername("seleniumUser");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }

    @Then("a user is redirected to the login page")
    public void a_user_is_redirected_to_the_login_page() {
        this.registerPOM.waitForSuccessfulRedirect();
        Assertions.assertEquals("http://localhost:4200/login", this.registerPOM.getCurrentUrl());
    }

    @When("a user inputs invalid username")
    public void a_user_inputs_invalid_username() {
        this.registerPOM.enterUsername("seleniumUser");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser1@revature.net");
        this.registerPOM.clickBtn();
    }
    @Then("a user is given an invalid username message")
    public void a_user_is_given_an_invalid_username_message() {
        String error = this.registerPOM.waitForErrorMessage();
        Assertions.assertEquals("Error! Username already in use", error );
    }

    @When("a user inputs invalid email")
    public void a_user_inputs_invalid_email() {
        this.registerPOM.enterUsername("seleniumUser1");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }
    @Then("a user is given an invalid email message")
    public void a_user_is_given_an_invalid_email_message() {
        String error = this.registerPOM.waitForErrorMessage();
        Assertions.assertEquals("Error! Email already in use", error );
    }

    @When("a user leaves firstname input empty")
    public void a_user_leaves_firstname_input_empty() {
        this.registerPOM.enterUsername("seleniumUser1");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }

    @When("a user leaves lastname input empty")
    public void a_user_leaves_lastname_input_empty() {
        this.registerPOM.enterUsername("seleniumUser1");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }

    @When("a user leaves password input empty")
    public void a_user_leaves_password_input_empty() {
        this.registerPOM.enterUsername("seleniumUser1");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }

    @When("a user leaves username input empty")
    public void a_user_leaves_username_input_empty() {

        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");
        this.registerPOM.enterEmail("SelUser@revature.net");
        this.registerPOM.clickBtn();
    }

    @When("a user leaves email input empty")
    public void a_user_leaves_email_input_empty() {
        this.registerPOM.enterUsername("seleniumUser1");
        this.registerPOM.enterPassword("password");
        this.registerPOM.enterFirstName("sel");
        this.registerPOM.enterLastName("user");

        this.registerPOM.clickBtn();
    }


    @Then("a user will not be able to register and stay on page")
    public void a_user_will_not_be_able_to_register_and_stay_on_page() {

        Assertions.assertEquals("http://localhost:4200/register", this.registerPOM.getCurrentUrl());

    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        this.registerPOM.clickLoginBtn();
    }
    @Then("the user is sent back to login page")
    public void the_user_is_sent_back_to_login_page() {
        this.registerPOM.waitForSuccessfulRedirect();
        Assertions.assertEquals("http://localhost:4200/login", this.registerPOM.getCurrentUrl());
    }
}
