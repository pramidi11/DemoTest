Feature: Registering to automation practice

  Scenario: Validate user is able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto.com"
    Then I should be able to register with my below details
      | Gender | FirstName | LastName  | Password  | Address            | City      | State  | Zip   | Mobile     |
      | Mr     | TestFName | TestLName | Password1 | 100 Spencer Street | Anchorage | Alaska | 30000 | 0406345454 |
    Then I should be on My Account page

  Scenario: Validate that user see an error message if email address is incorrect
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testWrong"
    Then I should see an error

  Scenario: Check whether Megamenu works(Dresses-> Summer Dresses)
    Given Automation practice application is opened
    When I hover on mega menu "Dresses"
    And I click on sub menu "Summer Dresses"
    Then I should be on "Summer Dresses - My Store" page
