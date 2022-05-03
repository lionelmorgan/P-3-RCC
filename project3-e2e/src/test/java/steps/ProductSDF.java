package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.ProductPOM;

public class ProductSDF {

    ProductPOM productPOM;


    @Given("a user is on the product page")
    public void a_user_is_on_the_product_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/product/14");
        this.productPOM = new ProductPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/product/14", this.productPOM.getCurrentUrl());
    }
    @When("a user increments the quantity of the product")
    public void a_user_increments_the_quantity_of_the_product() {
        this.productPOM.incQuantity();
    }
    @Then("a user can see the quantity increases")
    public void a_user_can_see_the_quantity_increases() {

        Assertions.assertEquals("2", this.productPOM.getQuantity());

    }

    @When("a user clicks on the add to cart button")
    public void a_user_clicks_on_the_add_to_cart_button() {
        this.productPOM.clickAddToCart();
    }


    @Then("a error message appears and the user is redirected to the login page")
    public void a_error_message_appears_a_user_is_redirected_to_the_login_page() {
        Assertions.assertEquals("Error! Unauthorized", this.productPOM.getErrorMessage());
        this.productPOM.waitForSuccessfulLoginRedirect();
        Assertions.assertEquals("http://localhost:4200/login", this.productPOM.getCurrentUrl());
    }

    @Then("the user will be notified with a message and the cart quantity will increase")
    public void the_user_will_be_notified_with_a_message_and_the_cart_quantity_will_increase() {
        Assertions.assertEquals("Added to Cart",this.productPOM.getMessage());
        Assertions.assertEquals("1", this.productPOM.getCartAmount());
    }

    @When("a user clicks the go to cart button")
    public void a_user_clicks_the_go_to_cart_button() {
        this.productPOM.clickGoToCart();
    }

    @Then("the user will be redirected to the cart page")
    public void the_user_will_be_redirected_to_the_cart_page() {
        this.productPOM.waitForSuccessfulCartRedirect();
        Assertions.assertEquals("http://localhost:4200/cart", this.productPOM.getCurrentUrl());
    }

    @Then("The user will see the go to cart button")
    public void the_user_will_see_the_go_to_cart_button() {
        Assertions.assertEquals("Go to Cart", this.productPOM.getBtnText());
    }

    @When("a user inputs a number above the stock of the product")
    public void a_user_inputs_a_number_above_the_stock_of_the_product() {
       productPOM.inputQuantity("10000000");
    }
    @Then("the number in the input equals max stock")
    public void the_number_in_the_input_equals_max_stock() {
        Assertions.assertEquals(this.productPOM.getMaxStock(), this.productPOM.getQuantity());
    }
    @When("a user inputs a negative number")
    public void a_user_inputs_a_negative_number() {
        productPOM.inputQuantity("-");

    }
    @Then("the number in the input is set to one")
    public void the_number_in_the_input_is_set_to_one() {
        Assertions.assertEquals("1", this.productPOM.getQuantity());
    }
    @When("a user inputs a non-number character")
    public void a_user_inputs_a_non_number_character() {
        productPOM.inputQuantity("z");
    }
    @Then("the number in the input stays the same")
    public void the_number_in_the_input_stays_the_same() {
        Assertions.assertEquals("1", this.productPOM.getQuantity());
    }

    @When("a user clicks the continue shopping button")
    public void a_user_clicks_the_continue_shopping_button() {
        this.productPOM.clickContinueShoppingBtn();
    }
    @Then("the user will be redirected to the main page")
    public void the_user_will_be_redirected_to_the_main_page() {
        this.productPOM.waitForSuccessfulRedirect();
        Assertions.assertEquals("http://localhost:4200/", this.productPOM.getCurrentUrl());
    }

    @When("The user clicks on the Revature Courseware Cornucopia title")
    public void the_user_clicks_on_the_revature_courseware_cornucopia_title(){
        this.productPOM.clickTitleLink();
    }

    @Then("The user is redirected to the main page")
    public void the_user_is_redirected_to_the_main_page(){
        this.productPOM.verifyMainRedirect();
        Assertions.assertEquals("http://localhost:4200/", this.productPOM.getCurrentUrl());
    }

    @When("The admin clicks edit product")
    public void the_admin_clicks_edit_product() {
        this.productPOM.clickEditBtn();
    }

    @Then("The admin is redirected to edit product page")
    public void the_admin_is_redirected_to_edit_product_page() {
        this.productPOM.verifyEditRedirect();
    }

}
