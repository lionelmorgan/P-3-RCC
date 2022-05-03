Feature: Header

  Scenario: A user can go to register page
  Given A user is on the main page
  When A user clicks on the register button
  Then The user will be redirected to register page

  Scenario: A user can go to login page
  Given A user is on the main page
  When A user clicks on the login button
  Then The user will be redirected to login page

  Scenario: A user can go to cart page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on the cart icon
    Then The user will be redirected to the cart page

  Scenario: A user can alternate between light and dark mode
    Given A user is on the main page
    When The user clicks on the dark mode button
    Then Then the color scheme will change

  Scenario: A user's name will be displayed on the main page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When The user name will be displayed in the header

  Scenario: A user can logout
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on the logout button
    Then The user will be redirected to login page

  Scenario: A user will see cart and logout buttons
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    Then A user sees the cart and logout buttons

  Scenario: A user will see register and login buttons
    Given A user is on the main page
    Then A user sees the register and login buttons

  Scenario: A user navigates back to main page by clicking title
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page
    Given A user is on the main page
    When A user clicks on a product
    Then The user will be redirected to the product page
    Given a user is on the product page
    When The user clicks on the Revature Courseware Cornucopia title
    Then The user is redirected to the main page