Feature: Main Page

  Scenario: A user can go to a product page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page

  Scenario: A user can search for a product
    Given A user is on the main page
    When A user inputs a search in the search bar
    Then The user will be able to see searched items

  Scenario: A user will see a sale tag and a sale price
    Given A user is on the main page
    Then The user can see sale tags and sale prices

  Scenario: An Admin is logged in and wants to add a new product
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible
    Given A user is on the main page
    When An admin clicks on the add new product button
    Then The admin is redirected to the add new product page

  Scenario: A user can scroll down to the bottom of the page and more products are loaded
    Given A user is on the main page
    When A user scrolls to the bottom of the page
    Then More items will load onto the page

  Scenario: A user can see certain items are out of stock
    Given A user is on the main page
    Then The user can see items that are out of stock

  Scenario: An Admin is logged in and can see the add new product button
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible






