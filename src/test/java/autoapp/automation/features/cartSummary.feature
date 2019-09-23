Feature: The cart summary page details at checkout
		 To see the details that is displayed in the Cart Summary page that is visible to the user at checkout
		 
Scenario: Validate if the cart summary details such as product name, color and quantity at checkout is as same as what was selected 
	Given The user navigates to Automation Practise website
	And Hover over "DRESSES" in the Mega Menu
	And They click on "SUMMER DRESSES" option to navigate to the category page
	And They select a dress that has the color "Blue"
	And They add the quantity as "2"
	And Select the dress size "M"
	And They click the Add to cart button
	When They Proceed to checkout 
	Then In the "SHOPPING-CART SUMMARY" page The product name, color and quantity displayed as what was selected 