##@Vinod Vijayan
##(Comments): This feature ensures that an invalid email id format is not accepted during registration

Feature: Registering to automation practice with invalid email 

  Scenario: Validate user is not able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto"
    Then I should not be able to register
    
