Feature: Validate Summer Dress Summary in Cart


Scenario: Validate user is able to add summer dress to shopping cart
    Given Automation practice site is opened
    #When I click on SignIn
    And click on the "Summer Dresses" menu from the main "Dresses" menu
   # When I sort by "Price: Lowest first"
   # Then the product grid is arranged accordingly
    
    When I click on "Add To Cart" button for one summer dress
    Then I am able to see and click the "Proceed To Checkout" button on the status dialog
    And validate the "Product Name", "Product Color" and "Product Qty" on the "Shopping cart summary" page
    