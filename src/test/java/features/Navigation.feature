#Author: p.baldwin@outlook.com
#Keywords Summary : code test

@assignment
Feature: Navigation from main page
  Scenarios that relate to site navigation

  Scenario: Able to navigate to Summer Dresses
    Given Automation practice application is opened
    When I navigate to "Dresses" > "Summer Dresses"
    Then I should see "Summer Dresses" page
