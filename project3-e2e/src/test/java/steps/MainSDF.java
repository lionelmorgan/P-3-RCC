package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import poms.MainPOM;

import java.awt.*;

public class MainSDF {

    MainPOM mainPOM;

    String id;

    Integer size;

    @Given("A user is on the main page")
    public void a_user_is_on_the_main_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/");

        this.mainPOM = new MainPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.mainPOM.getCurrentUrl());
    }
    @When("A user clicks on the register button")
    public void a_user_clicks_on_the_register_button() {
        this.mainPOM.clickRegisterBtn();
    }

    @Then("The user will be redirected to register page")
    public void the_user_will_be_redirected_to_register_page() {
        this.mainPOM.verifyRegisterRedirect();

        Assertions.assertEquals("http://localhost:4200/register",this.mainPOM.getCurrentUrl());

    }

    @When("A user clicks on the login button")
    public void a_user_clicks_on_the_login_button() {
        this.mainPOM.clickLoginBtn();
    }

    @Then("The user will be redirected to login page")
    public void the_user_will_be_redirected_to_login_page() {
        this.mainPOM.verifyLoginRedirect();
        Assertions.assertEquals("http://localhost:4200/login",this.mainPOM.getCurrentUrl());
    }

    @When("A user clicks on a product")
    public void a_user_clicks_on_a_product() {
        this.id = this.mainPOM.getId();
        this.mainPOM.clickProduct();
    }
    @Then("The user will be redirected to the product page")
    public void the_user_will_be_redirected_to_the_product_page() {
        this.mainPOM.verifyProductRedirect(this.id);
        Assertions.assertEquals("http://localhost:4200/product/"+this.id,this.mainPOM.getCurrentUrl());
    }

    @When("A user inputs a search in the search bar")
    public void a_user_inputs_a_search_in_the_search_bar() {
        this.mainPOM.search("java");
    }

    @Then("The user will be able to see searched items")
    public void the_user_will_be_able_to_see_searched_items() {
        String title = this.mainPOM.checkProductTitle();
        String description = this.mainPOM.checkProductDescription();
        Assertions.assertTrue(this.mainPOM.checkSearch("java",title, description));

    }

    @When("A user clicks on the cart icon")
    public void a_user_clicks_on_the_cart_icon() {
        this.mainPOM.clickCartBtn();
    }

    @Then("The user will be redirected to the cart page")
    public void the_user_will_be_redirected_to_the_cart_page() {
        this.mainPOM.verifyCartRedirect();
        Assertions.assertEquals("http://localhost:4200/cart",this.mainPOM.getCurrentUrl());
    }

    @When("The user clicks on the dark mode button")
    public void the_user_clicks_on_the_dark_mode_button() {
        this.mainPOM.clickDarkModeBtn();
    }
    @Then("Then the color scheme will change")
    public void then_the_color_scheme_will_change() {
        Assertions.assertNotEquals("light", this.mainPOM.checkThemeColor());
    }

    @Then("The user can see sale tags and sale prices")
    public void the_user_can_see_sale_tags_and_sale_prices() {
        this.mainPOM.waitForSales();
        Assertions.assertTrue(this.mainPOM.checkSales());
    }

    @When("An admin clicks on the add new product button")
    public void an_admin_clicks_on_the_add_new_product_button() {
        this.mainPOM.clickNewProductButton();
    }
    @Then("The admin is redirected to the add new product page")
    public void the_admin_is_redirected_to_the_add_new_product_page() {
        this.mainPOM.verifyAdminRedirect();
        Assertions.assertEquals("http://localhost:4200/admin-new-product", this.mainPOM.getCurrentUrl());
    }

    @When("A user scrolls to the bottom of the page")
    public void a_user_scrolls_to_the_bottom_of_the_page(){
        this.mainPOM.waitForLoad();
        this.size = this.mainPOM.getProductsSize();
        this.mainPOM.scrollToBottom();
    }
    @Then("More items will load onto the page")
    public void more_items_will_load_onto_the_page() {
        Assertions.assertTrue(this.mainPOM.checkIncreasedProducts(this.size));
    }

    @Then("The user can see items that are out of stock")
    public void the_user_can_see_items_that_are_out_of_stock() {
        Assertions.assertTrue(this.mainPOM.checkOutOfStock());
    }

    @Then("The user name will be displayed in the header")
    public void the_user_name_will_be_displayed_in_the_header(){
        Assertions.assertTrue(this.mainPOM.checkName());
    }

    @When("A user clicks on the logout button")
    public void a_user_clicks_on_the_logout_button() {
        this.mainPOM.clickLogoutBtn();
    }

    @Then("A user sees the cart and logout buttons")
    public void the_user_will_see_cart_and_logout_buttons(){
        Assertions.assertTrue(this.mainPOM.checkCartAndLogoutBtn());
    }

   /* @Then("The user will not see the login and register buttons")
    public void the_user_will_not_see_the_login_and_register_buttons(){
        Assertions.assertFalse(this.mainPOM.checkLoginAndRegisterBtn());
    }*/

    @Given("A user is not logged in")
    public void a_user_is_not_logged_in() {
        Assertions.assertFalse(this.mainPOM.checkName());
    }

    @Then("A user sees the register and login buttons")
    public void a_user_sees_the_register_and_login_buttons(){
        Assertions.assertTrue(this.mainPOM.checkRegisterAndLoginBtn());
    }

    /*@Then("The user will not see the cart and logout buttons")
    public void the_user_will_not_see_the_cart_and_logout_buttons(){
        Assertions.assertFalse(this.mainPOM.checkCartAndLogoutBtn());
    }*/

}
