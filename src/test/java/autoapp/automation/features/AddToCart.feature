Feature: Add selected Products to cart

  Scenario: Validate product is added to the cart successfully
    Given Automation practice application is opened
    And I select a product from the list
    And I change the quantity to "2", size to "M" and color to "Blue"
    And I add the item to the cart
    Then I validate that item is added to the cart correctly