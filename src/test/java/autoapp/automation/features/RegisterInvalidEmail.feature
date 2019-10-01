Feature: Registering to automation practice with invalid email id

 
 @InvalidEmail    
 Scenario: Validate incorrect email address during user registration
    Given Automation practice site is opened
    When I click on SignIn
    And I create account with invalid emailid "abc123"
    Then I should see the error message as "Invalid email address."