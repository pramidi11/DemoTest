Feature: Registering to automation practice

  Scenario: Validate user is able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto.com"
    Then I should be able to register with my below details
      | Gender | FirstName | LastName  | Password  | Address            | City      | State  | Zip   | Mobile     | AddressAlias |
      | Mr     | TestFName | TestLName | Password1 | 100 Spencer Street | Anchorage | Alaska | 30000 | 0406345454 | Home         |

  # The last example only works because I had previously created an account with the same email address, in the automationpractice.com site
  # @runthis
  Scenario Outline: Validate user is unable to register with "incorrect" email addresses
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "<badEmail>"
    Then I should see the registrationMessage "<errMsg>"

    Examples:
      | badEmail                  | errMsg                                                                                                               |
      | test                      | Invalid email address.                                                                                               |
      | test@testauto             | Invalid email address.                                                                                               |
      | @testauto.com             | Invalid email address.                                                                                               |
      | test99999@testauto.com    | An account using this email address has already been registered. Please enter a valid password or request a new one. |

