package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.CartPOM;
import poms.LoginPOM;

public class CartSDF {

    CartPOM cartPOM;

    Integer size;

    @Given("a user is on the cart page")
    public void a_user_is_on_the_cart_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/cart");

        this.cartPOM = new CartPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/cart", this.cartPOM.getCurrentUrl());

    }
    @When("a user deletes an item from cart")
    public void a_user_deletes_an_item_from_cart() {
        size = this.cartPOM.getCartSize();
        this.cartPOM.deleteItem();

    }
    @Then("the user can see that item was removed")
    public void the_user_can_see_that_item_was_removed() {
        Integer postSize = this.cartPOM.getCartSize();
        Assertions.assertEquals(0, postSize);
    }

    @When("a user clicks on the continue shopping button")
    public void a_user_clicks_on_the_continue_shopping_button() {
        this.cartPOM.clickContinueShopping();
    }
    @Then("the user is redirected to the main page")
    public void the_user_is_redirected_to_the_main_page() {
        Assertions.assertEquals("http://localhost:4200/", this.cartPOM.getCurrentUrl());
    }

    @When("a user clicks on the checkout button")
    public void a_user_clicks_on_the_checkout_button() {
        this.cartPOM.clickCheckoutBtn();
    }
    @Then("the user is redirected to the checkout page")
    public void the_user_is_redirected_to_the_checkout_page() {
        Assertions.assertEquals("http://localhost:4200/checkout", this.cartPOM.getCurrentUrl());
    }

    @When("a user increases the quantity of an item")
    public void a_user_increases_the_quantity_of_an_item() {
        this.cartPOM.incQuantity();
    }
    @Then("the user can see the respective quantity and price is the same as the total")
    public void the_user_can_see_the_respective_quantity_and_price_is_the_same_as_the_total() {

        Assertions.assertTrue(this.cartPOM.checkTotal());
    }


    @When("a user decreases the quantity of an item lower than one")
    public void a_user_decreases_the_quantity_of_an_item_lower_than() {
        this.cartPOM.decQuantity();
    }

    @When("a user inputs a non-number character in the quantity select")
    public void a_user_inputs_a_non_number_character_in_the_quantity_select() {
        this.cartPOM.insertLetterQuantity();
    }

    @Then("the user can see the quantity of an item stays at one")
    public void the_user_can_see_the_quantity_of_an_item_stays_at() {
        Assertions.assertEquals("1",this.cartPOM.getQuantity());

    }



}
