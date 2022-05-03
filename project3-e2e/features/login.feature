Feature: Login Page

  Scenario: Entering valid credentials will redirect user to the main product page
    Given a user is on the login page
    When a user inputs valid credentials
    Then a user is redirected to the inventory page

  Scenario: Entering invalid credentials will display error message
    Given a user is on the login page
    When a user inputs invalid credentials
    Then an error message appears telling the user that their credentials are incorrect

  Scenario: User attempts to login with incorrect username
    Given a user is on the login page
    When User fills out incorrect username, but correct password and clicks login
    Then an error message appears telling the user that their credentials are incorrect

  Scenario: User attempts to login with incorrect password
    Given a user is on the login page
    When User fills out correct username, but incorrect password field and clicks the login button
    Then an error message appears telling the user that their credentials are incorrect

  Scenario: User attempts to login without entering username
    Given a user is on the login page
    When User neglects to enter a username, but enters a password and clicks login
    Then an error message appears telling the user that their credentials are incorrect

  Scenario: User attempts to login without entering password
    Given a user is on the login page
    When User enters a username, but neglects to enter a password and clicks login.
    Then an error message appears telling the user that their credentials are incorrect




  Scenario: Clicking on the register link will redirect user to register page
    Given a user is on the login page
    When a user clicks on the register link
    Then a user is redirected to the register page

  Scenario: An Admin logs in and sees the add new product button in the bottom right corner
    Given a user is on the login page
    When a user enters admin credentials
    Then the add new product button is visible