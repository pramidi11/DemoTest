#Author: p.baldwin@outlook.com
#Keywords Summary : code test

@assignment
Feature: Registering to automation practice
  Scenarios that relate to user registration

  Scenario: Invalid email address is rejected
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid ".baldwin@belong.com.au"
    Then I should see error message "Invalid email address."
