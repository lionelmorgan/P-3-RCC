package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.AddNewProductPOM;

public class AddNewProductSDF {

    AddNewProductPOM addNewProductPOM;




    @Given("An Admin is on the add product page")
    public void an_admin_is_on_the_add_product_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/admin-new-product");

        this.addNewProductPOM = new AddNewProductPOM(DriverSingleton.getInstance());

        Assertions.assertEquals("http://localhost:4200/admin-new-product", this.addNewProductPOM.getCurrentUrl());
    }

    @Given("An admin is on the main page")
    public void a_user_is_on_the_main_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/");

        this.addNewProductPOM = new AddNewProductPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.addNewProductPOM.getCurrentUrl());
    }

    @When("The Admin submits the form without adding a name")
    public void the_admin_submits_the_form_without_adding_a_name() {
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the name field")
    public void the_form_produces_an_error_message_on_the_name_field() {
        this.addNewProductPOM.waitHere();
        Assertions.assertTrue(this.addNewProductPOM.checkEmptyName());
    }

    @When("The Admin submits the form without adding a description")
    public void the_admin_submits_the_form_without_adding_a_description() {
        this.addNewProductPOM.enterProductName("How to get pictures of Uranus");
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the description field")
    public void the_form_produces_an_error_message_on_the_description_field() {
        this.addNewProductPOM.waitHere();
        Assertions.assertTrue(this.addNewProductPOM.checkEmptyDescription());
    }

    @When("The Admin submits the form without adding a regular price")
    public void the_admin_submits_the_form_without_adding_a_regular_price() {
        this.addNewProductPOM.enterProductName("How to get pictures of Uranus");
        this.addNewProductPOM.enterProductDescription("Lets take pictures of Uranus!");
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("The form produces an error message on the price field")
    public void the_form_produces_an_error_message_on_the_price_field() {
        this.addNewProductPOM.waitHere();
        Assertions.assertTrue(this.addNewProductPOM.checkEmptyRegularPrice());
    }

    @When("The Admin submits the form without adding image")
    public void the_admin_submits_the_form_without_adding_image() {
        this.addNewProductPOM.enterProductName("How to get pictures of Uranus");
        this.addNewProductPOM.enterProductDescription("Lets take pictures of Uranus!");
        this.addNewProductPOM.enterProductRegularPrice(1.99);
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("The form produces an stays the same and has place holder image")
    public void the_form_produces_an_stays_the_same_and_has_place_holder_image() {
        this.addNewProductPOM.waitHere();
        Assertions.assertTrue(this.addNewProductPOM.checkEmptyImage());
    }


    @When("A user inputs valid fields into everything but sale price and clicks create product")
    public void a_user_inputs_valid_fields_into_everything_but_sale_price_and_clicks_create_product() {
       this.addNewProductPOM.enterProductName("Selenium Testing Basics");
       this.addNewProductPOM.enterProductDescription("This product was made as a test from selenium");
       this.addNewProductPOM.enterProductRealPrice("100");
       this.addNewProductPOM.enterProductRealStock("50");
       this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("A new product is created")
    public void a_new_product_is_created() {
        this.addNewProductPOM.waitForSuccessfulRedirect();
        Assertions.assertTrue(this.addNewProductPOM.getCurrentUrl().contains("http://localhost:4200/product/"));

    }

    @When("A user inputs valid fields into everything and clicks create product")
    public void a_user_inputs_valid_fields_into_everything_and_clicks_create_product() {
        this.addNewProductPOM.enterProductName("Selenium Testing Basics 2.0");
        this.addNewProductPOM.enterProductDescription("This product was made as a second test from selenium");
        this.addNewProductPOM.enterProductRealPrice("100");
        this.addNewProductPOM.enterProductRealSalesPrice("50");
        this.addNewProductPOM.enterProductRealStock("50");
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("a new product with a sale is created")
    public void a_new_product_with_a_sale_is_created() {
        this.addNewProductPOM.waitForSuccessfulRedirect();
        Assertions.assertTrue(this.addNewProductPOM.saleRibbonIsVisible());
    }

    @When("User fills out the name, description, price \\(lower then sale price), sales price, stock, and presses submit")
    public void user_fills_out_the_name_description_price_lower_then_sale_price_sales_price_stock_and_presses_submit() {
        this.addNewProductPOM.enterProductName("Selenium Testing Basics 2.0");
        this.addNewProductPOM.enterProductDescription("This product was made as a second test from selenium");
        this.addNewProductPOM.enterProductRealSalesPrice("50");
        this.addNewProductPOM.enterProductRealPrice("10");
        this.addNewProductPOM.enterProductRealStock("50");
        this.addNewProductPOM.clickCreateProductBtn();
    }
    @Then("User is prompted with an error message")
    public void user_is_prompted_with_an_error_message() {
       Assertions.assertEquals("http://localhost:4200/admin-new-product", this.addNewProductPOM.getCurrentUrl());
    }

    @When("User fills out the name, description, price, sales price \\(higher then price), stock, and presses submit")
    public void user_fills_out_the_name_description_price_sales_price_higher_then_price_stock_and_presses_submit() {
        this.addNewProductPOM.enterProductName("Selenium Testing Basics 2.0");
        this.addNewProductPOM.enterProductDescription("This product was made as a second test from selenium");
        this.addNewProductPOM.enterProductRealPrice("10");
        this.addNewProductPOM.enterProductRealSalesPrice("50");
        this.addNewProductPOM.enterProductRealStock("50");
        this.addNewProductPOM.clickCreateProductBtn();
    }

    @When("User fills out the name, description, price, sales price \\(higher then price), negative stock, and presses submit")
    public void user_fills_out_the_name_description_price_sales_price_higher_then_price_negative_stock_and_presses_submit() {
        this.addNewProductPOM.enterProductName("Selenium Testing Basics 2.0");
        this.addNewProductPOM.enterProductDescription("This product was made as a second test from selenium");
        this.addNewProductPOM.enterProductRealPrice("10");
        this.addNewProductPOM.enterProductRealSalesPrice("50");
        this.addNewProductPOM.enterProductRealStock("-50");
        this.addNewProductPOM.clickCreateProductBtn();
    }



}
