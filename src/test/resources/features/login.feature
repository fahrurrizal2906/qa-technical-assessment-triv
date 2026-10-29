Feature: Login TRIV
  As a registered TRIV user
  I want to access the login screen and submit credentials
  So that I can verify login behavior

  @login @LOG-001
  Scenario: LOG-001 Open login screen
     When I navigate to the login screen
    Then the login screen should be displayed

  @login @LOG-002
  Scenario: LOG-002  login with valid credentials
    Given I navigate to the login screen
    When I login with valid email "khabibfahrurrizal@gmail.com" and password "P@ssw0rd2026"
    Then the OTP instruction should be displayed

   @login @LOG-003
   Scenario: LOG-003  login with invalid credentials
    Given I navigate to the login screen
    When I login with invalid email "khabibfahrurrizal123@gmail.com" and password "P@ssw0rd2026"
    Then the invalid credentials popup should be displayed
 