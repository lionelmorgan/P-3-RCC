Feature: Add Product Page
  Background:
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible
    Given A user is on the main page

  Scenario: An Admin tries to make a new product without adding a name
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a name
    Then The form produces an error message on the name field

  Scenario: An Admin tries to make a new product without adding a description
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a description
    Then The form produces an error message on the description field

  Scenario: An Admin tries to make a new product without adding a regular price
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding a regular price
    Then The form produces an error message on the price field

  Scenario: An Admin tries to make a new product without adding an image
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When The Admin submits the form without adding image
    Then The form produces an stays the same and has place holder image

  Scenario: User successfully added a new product without a sale
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When A user inputs valid fields into everything but sale price and clicks create product
    Then A new product is created

  Scenario: User successfully added a new product with a sale
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When A user inputs valid fields into everything and clicks create product
    Then a new product with a sale is created

  Scenario: User fails to input correct price when creating an new product
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When  User fills out the name, description, price (lower then sale price), sales price, stock, and presses submit
    Then  User is prompted with an error message

  Scenario: User fails to input correct sales price when creating a new product
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When User fills out the name, description, price, sales price (higher then price), stock, and presses submit
    Then User is prompted with an error message

  Scenario: User fails to input correct sales price when creating a new product
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page
    Given An Admin is on the add product page
    When User fills out the name, description, price, sales price (higher then price), negative stock, and presses submit
    Then User is prompted with an error message


