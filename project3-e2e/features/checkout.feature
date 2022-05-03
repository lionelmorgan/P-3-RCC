Feature: Checkout Page
  Background:
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page
    When a user clicks on the add to cart button
    Then the user will be notified with a message and the cart quantity will increase
    When a user clicks the go to cart button
    Then the user will be redirected to the cart page
    Given a user is on the cart page
    When a user clicks on the checkout button
    Then the user is redirected to the checkout page

  Scenario: A user clicks on the use billing address as shipping address button
    Given a user is on the checkout page
    When a user clicks on the use billing address as shipping address button
    Then the billing address inputs are hidden
    When a user clicks the confirm button
    Then They are redirected to the receipt page

  Scenario: A user clicks on the billing address as shipping address button a second time
    Given a user is on the checkout page
    When a user clicks on the use billing address as shipping address button
    Then the billing address inputs are hidden
    When a user clicks on the use billing address as shipping address button again
    Then the billing address inputs are shown
    When a user clicks the confirm button
    Then They are redirected to the receipt page

  Scenario: The total above checkout is correct
    Given a user is on the checkout page
    When a user looks at their total
    Then The total is correct
    When a user clicks the confirm button
    Then They are redirected to the receipt page

  Scenario: A user clicks the confirm order button
    Given a user is on the checkout page
    When a user clicks the confirm button
    Then They are redirected to the receipt page