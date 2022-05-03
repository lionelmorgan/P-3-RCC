Feature: Edit Product Page
  Background:
    Given a user is on the login page
    When a user enters admin credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page

    Scenario: User successfully changed the name of the product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The admin changes the name of the edit product
    Then The admin is redirected to the product page

    Scenario: User successfully changed the description of the product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The admin changes the description of the edit product
    Then The admin is redirected to the product page

    Scenario: User successfully changed the price of the product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The admin changes the price of the edit product
    Then The admin is redirected to the product page

    Scenario: User successfully changed the sale price of the product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The admin changes the sale price of the edit product
    Then The admin is redirected to the product page

    Scenario: User successfully changed the stock amount of the product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The admin changes the stock amount of the edit product
    Then The admin is redirected to the product page

    Scenario: User fails to change price when editing a product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The user tries to change the price lower than the sale price
    Then The user will stay on the edit product page

    Scenario: User fails to change sales price when editing a product
    When The admin clicks edit product
    Then The admin is redirected to edit product page
    Given The admin is on the edit product page
    When The user tries to change the sale price higher than the original price
    Then The user will stay on the edit product page