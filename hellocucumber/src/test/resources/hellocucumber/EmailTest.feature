Feature: Email Test

  Scenario: Verify email creation and account creation page
    Given the user is on the authentication page
    When the user enters the email "testuser@example.com" for account creation
    Then the user sees the text "CREATE AN ACCOUNT"