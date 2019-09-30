Feature: Home page functionality

  Scenario: Validate MegaMenu (Dresses->Summer Dresses)
    Given Automation practice application is opened
    When I hover mouse over "DRESSES" on Home page
    Then I should see the sub-menu "SUMMER DRESSES"
    And I click on sub-menu "SUMMER DRESSES"
    Then I should be landing on [Summer Dresses] page
