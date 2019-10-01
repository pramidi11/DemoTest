# UITestsBelong

***Please branch out from DEMO and start assignment***
Write feature file , step definitions and if possible pages for any of the below two requirements 

Site URL: http://automationpractice.com/

1.	While registering, if the email address is incorrect. User should see an error message
2.	Check whether Megamenu works (Dresses -> Summer dresses)
3.	On the Summer dresses page, select a dress(Quick view) and change the color (Blue) and then add the item to cart, Validate	whether same product name, color and quantity are displayed in Cart Summary page.

Once you finish assignment,
raise pull request to merge your changes to DEMO. 

Notes added by Vinod Vijayan:

Task#1: While registering, if the email address is incorrect. User should see an error message
New Feature file added, RegisterInvalidEmail.feature
Reused functions to ‘Open the application’, ‘Click on sign’ in and ‘Create account’
Added a new function to check for an error message, once invalid email id is added.
The existing Step Definition file was updated to add ‘Then’ annotation - ‘I should not be able to register’ used in the new feature file and the respective glue code was added to RegisterPage.java file

Further possible enhancements:  
The existing feature file Register.feature can also be modified to accommodate this Task. If we choose to do it this way, then the email id must be accepted as a parameter in the ‘And’ annotation ‘I create account with emailid’ and the glue code must be modified to check for the appearance of the 'Account Failure Error' element before entering the details to create a user 

Task#2: Check whether Mega menu works (Dresses -> Summer dresses)
New Feature file added, CheckMegaMenu.feature
Reused function to ‘Open the application’
Added new functions to ‘Click main and sub menu’ and check if the ‘Selected Page has come up’
The existing Step Definition file was updated to link ‘When’ - ‘I click on Dresses and select Summer Dresses’ and ‘Then’ - ‘Summer Dresses page comes up’ actions from the new feature file and respective glue code added to the newly added HomePage.java file.

Further possible enhancements:  
Functions to click on Menu and sub menu can be parameterised so that the same function can be reused to click on  the other mega menu combinations. Additionally, the mega menu works on Hover and Click from the main menu, for proper functional coverage it is recommended to test both the options.

General notes:
To accommodate the newly added feature files the cucumber options in testRunRegister.java file was modified to specify the folder location instead of the feature file name.
Test results for the tasks completed have be captured in a flat file for the purpose of the assignment. Cucumber.json file has not been modified
