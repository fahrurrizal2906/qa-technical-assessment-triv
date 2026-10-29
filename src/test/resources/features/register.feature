Feature: Register TRIV
  As a new user
  I want to access the registration screen
  So that I can verify registration validation

  @register @REG-001
  Scenario: REG-001 Open registration screen
    Given I am on the registration screen
    Then the registration screen should be displayed

  @register @REG-002
  Scenario: REG-002 Validate empty registration form
    Given I am on the registration screen
    When I submit the registration form without required fields
    Then registration validation should be displayed
    When I dismiss the registration validation popup
    Then the registration form should remain displayed

  @register @REG-003
  Scenario: REG-003 Register using valid dummy data
    Given I am on the registration screen
    When I fill in the registration form with valid data
    And I select occupation "Wiraswasta"
    And I accept the terms and conditions
    And I submit the registration form
    Then the email verification screen should be displayed
