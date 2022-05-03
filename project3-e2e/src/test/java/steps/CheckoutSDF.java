package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.CartPOM;
import poms.CheckoutPOM;

public class CheckoutSDF {
    CheckoutPOM checkoutPOM;

    @Given("a user is on the checkout page")
    public void a_user_is_on_the_checkout_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/checkout");

        this.checkoutPOM = new CheckoutPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/checkout", this.checkoutPOM.getCurrentUrl());
    }
    @When("a user clicks on the use billing address as shipping address button")
    public void a_user_clicks_on_the_use_billing_address_as_shipping_address_button() {
        this.checkoutPOM.clickHideBtn();
    }
    @Then("the billing address inputs are hidden")
    public void the_billing_address_inputs_are_hidden() {
        Assertions.assertFalse(this.checkoutPOM.checkIfBillingIsVisible());
    }

    @When("a user looks at their total")
    public void a_user_looks_at_their_total() {
        Assertions.assertTrue(this.checkoutPOM.isTotalVisible());
    }
    @Then("The total is correct")
    public void the_total_is_correct() {
        Assertions.assertNotEquals("",this.checkoutPOM.getTotal());
    }


    @When("a user clicks the confirm button")
    public void a_user_clicks_the_confirm_button() throws InterruptedException {
        this.checkoutPOM.pageDown();
        this.checkoutPOM.clickCheckoutBtn();
    }
    @Then("They are redirected to the receipt page")
    public void they_are_redirected_to_the_receipt_page() {
        this.checkoutPOM.waitForSuccessfulRedirct();
        Assertions.assertTrue(this.checkoutPOM.getCurrentUrl().contains("http://localhost:4200/receipt/"));
    }

    @When("a user clicks on the use billing address as shipping address button again")
    public void a_user_clicks_on_the_use_billing_address_as_shipping_address_button_again() {
        this.checkoutPOM.clickHideBtn();
    }
    @Then("the billing address inputs are shown")
    public void the_billing_address_inputs_are_shown() {
        Assertions.assertTrue(this.checkoutPOM.isBillingVisible());
    }
}
