Feature: Add items to cart

  # @runthis
  # The name of the colour is case-sensitive; the website uses camel case (eg, "Blue")
  Scenario: Select a Summer dress, change its colour, add the product to cart and verify cart contents
    Given Automation practice application is opened
    When I navigate to the "Summer dresses" page via the Megamenu
    And I select QuickView of "Printed Summer Dress (1)"
    And in QuickView I select the colour "Blue"
    And in QuickView I click "Add to cart"
    Then I should see the product added to the cart in a popup
    When I close the Product Added popup
    And I navigate to the "Cart Summary" page
    Then I should see the following products in my cart
      | Product Name         | Colour | Size | Quantity |
      | Printed Summer Dress | Blue   | S    | 1        |
