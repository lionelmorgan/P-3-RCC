Feature: Register Page
  Scenario: Entering valid credentials will redirect user to the login page
    Given a user is on the register page
    When a user inputs unused credentials
    Then a user is redirected to the login page

  Scenario: Entering an invalid username will give user an error
    Given a user is on the register page
    When a user inputs invalid username
    Then a user is given an invalid username message

  Scenario: Entering an invalid email will give user an error
    Given a user is on the register page
    When a user inputs invalid email
    Then a user is given an invalid email message

  Scenario: Entering an empty firstname input will give user an error
    Given a user is on the register page
    When a user leaves firstname input empty
    Then a user will not be able to register and stay on page

  Scenario: Entering an empty lastname input will give user an error
    Given a user is on the register page
    When a user leaves lastname input empty
    Then a user will not be able to register and stay on page

  Scenario: Entering an empty password input will give user an error
    Given a user is on the register page
    When a user leaves password input empty
    Then a user will not be able to register and stay on page

  Scenario: Entering an empty username input will give user an error
    Given a user is on the register page
    When a user leaves username input empty
    Then a user will not be able to register and stay on page

  Scenario: Entering an empty email input will give user an error
    Given a user is on the register page
    When a user leaves email input empty
    Then a user will not be able to register and stay on page

  Scenario: Clicking Login button will send user back to login page
    Given a user is on the register page
    When the user clicks the login button
    Then the user is sent back to login page
