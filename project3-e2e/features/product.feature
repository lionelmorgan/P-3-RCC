Feature: Product Page
  Background:
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page


  Scenario: A user can increase the quantity to add to cart
    When a user increments the quantity of the product
    Then a user can see the quantity increases

  Scenario: A user puts an incorrect stock
    When a user inputs a number above the stock of the product
    Then the number in the input equals max stock

  Scenario: A user puts an negative number
    When a user inputs a negative number
    Then the number in the input is set to one

  Scenario: A user puts a non-number character
    When a user inputs a non-number character
    Then the number in the input stays the same

  Scenario: A registered user clicks on the add to cart button
    When a user clicks on the add to cart button
    Then the user will be notified with a message and the cart quantity will increase
    When a user clicks the go to cart button
    Then the user will be redirected to the cart page
    Given a user is on the cart page
    When a user deletes an item from cart
    Then the user can see that item was removed


  Scenario: A registered user clicks on the add to cart button
    When a user clicks on the add to cart button
    Then the user will be notified with a message and the cart quantity will increase


  Scenario: A user already has the product in their cart and the go to cart button is shown instead of the add to cart button and quantity selector
    Then The user will see the go to cart button
    Given a user is on the cart page
    When a user deletes an item from cart
    Then the user can see that item was removed

  Scenario: A registered user clicks on continue shopping button
    When a user clicks the continue shopping button
    Then the user will be redirected to the main page
