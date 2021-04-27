Feature: Login to Hotel booking application

Scenario: Verify validation messages for mandatory fields in Login page
Given the user has navigated to login portal
When user clicks on login button without entering a valid user name
Then a validataion message is displayed mentioning user name is mandatory for login
When user enters user name without a password and clicks on login button
|UserName|
|admin|
Then a validataion message is displayed mentioning password is mandatory for login

Scenario: Verify login to hotel booking application
Given the user has navigated to login portal
When user enters a valid user name and password and clicks on login button
|UserName|Password|
|admin|admin|
Then the user is logged into hotel booking application


Scenario: Verify invalid login to hotel booking application
Given the user has navigated to login portal
When user enters a invalid user name and password and clicks on login button
|UserName|Password|
|test|test|
Then user validates error message for invalid login