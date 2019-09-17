Feature: Invalid user email validation at account creation
		 If the user enters an invalid email address to create an account, an error message should be displayed to indicate the user that the email address is invalid
		 
Scenario: User tries to create an account with an email address with no "@" sign
	Given User navigates to Automation Practise website
	When Clicks on the Sign-In button
	And Create an account with the invalid email address "testusertest.com"
	Then An error message is displayed indicating that they have entered an invalid email address
	
Scenario: User tries to create an account with an email address with no . sign
	Given User navigates to Automation Practise website
	When Clicks on the Sign-In button
	And Create an account with the invalid email address "testuser@testcom"
	Then An error message is displayed indicating that they have entered an invalid email address

Scenario: User tries to create an account without entering no email address
	Given User navigates to Automation Practise website
	When Clicks on the Sign-In button
	And Create an account with the invalid email address ""
	Then An error message is displayed indicating that they have entered an invalid email address