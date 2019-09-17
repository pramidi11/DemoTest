Feature: Functionality of the Mega Menu in the homepage
		 Accessing different category pages through the links given in the Mega Menu
		 
Scenario: User the accesses Women in the Mega Menu
	Given User navigates to the Automation Practise website
	When They click "WOMEN" in the Mega Menu
	Then The user is navigated to the "WOMEN" page 
	
Scenario: User the accesses Dresses in the Mega Menu
	Given User navigates to the Automation Practise website
	When They click "DRESSES" in the Mega Menu
	Then The user is navigated to the "DRESSES" page

Scenario: User the accesses T-Shirts in the Mega Menu
	Given User navigates to the Automation Practise website
	When They click "T-SHIRTS" in the Mega Menu
	Then The user is navigated to the "T-SHIRTS" page
	
Scenario: User the accesses T-shirt page through Women link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "WOMEN" in the Mega Menu
	And Click the "T-Shirts" link
	Then The user is navigated to the "T-SHIRTS" page
	
Scenario: User the accesses Blouses page through Women link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "WOMEN" in the Mega Menu
	And Click the "Blouses" link
	Then The user is navigated to the "BLOUSES" page

Scenario: User the accesses Casual Dresses page through Women link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "WOMEN" in the Mega Menu
	And Click the "Casual Dresses" link
	Then The user is navigated to the "CASUAL DRESSES" page
	
Scenario: User the accesses Evening Dresses page through Women link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "WOMEN" in the Mega Menu
	And Click the "Evening Dresses" link
	Then The user is navigated to the "EVENING DRESSES" page

Scenario: User the accesses Summer Dresses page through Women link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "WOMEN" in the Mega Menu
	And Click the "Summer Dresses" link
	Then The user is navigated to the "SUMMER DRESSES" page
	
Scenario: User the accesses Casual Dresses page through Dresses link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "DRESSES" in the Mega Menu
	And Click the "CASUAL DRESSES" link
	Then The user is navigated to the "CASUAL DRESSES" page
	
Scenario: User the accesses Evening Dresses page through Dresses link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "DRESSES" in the Mega Menu
	And Click the "EVENING DRESSES" link
	Then The user is navigated to the "EVENING DRESSES" page

Scenario: User the accesses Summer Dresses page through Dresses link in the Mega Menu
	Given User navigates to the Automation Practise website
	When They hover over "DRESSES" in the Mega Menu
	And Click the "SUMMER DRESSES" link
	Then The user is navigated to the "SUMMER DRESSES" page 
	