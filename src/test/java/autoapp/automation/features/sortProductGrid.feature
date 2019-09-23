Feature: Product grid sorting
		 The user is in a product category page and they should be able to sort the product grid
		 
Scenario: User sort the product grid in the Summer Dresses page by Price in ascending order
	Given The user navigates to the Automation Practise website
	And They navigate to the "Summer Dresses" page
	When They select sort by "Price: Lowest first" 
	Then The product grid is ordered in "Ascending" order by price
	
Scenario: User sort the product grid in the Summer Dresses page by Price in descending order
	Given The user navigates to the Automation Practise website
	And They navigate to the "Summer Dresses" page
	When They select sort by "Price: Highest first" 
	Then The product grid is ordered in "Descending" order by price