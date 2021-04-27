Feature: To perform a Hotel booking

Background: User login into Hotel booking application
Given the user has navigated to login portal
When user enters a valid user name and password and clicks on login button
|UserName|Password|
|admin|admin|
Then the user is logged into hotel booking application

Scenario: User verifies validations for fields in Hotel booking page
Given the user is in Hotel booking page
Then user verifies validations for first name field
|FirstName|
||
When user enters a valid first name
|FirstName|
|FName1|
Then user verifies validation for last name field
|LastName|
||
When user enters a valid last name
|LastName|
|LName1|
Then user verifies validation for email field
|Validation|EmailId|
|Empty||
|Invalid|email|
When user enters a valid email id
|EmailId|
|test@test.com|
Then user verifies validation for mobile number field
|Validation|MobileNo|
|Empty||
|Invalid|98574575|
|Invalid|4541247821|
When user enters a valid mobile number
|MobileNo|
|8745621478|
When user enters a valid address
|Address|
|Test address|
Then user verifies validation for city dropdown
|City|
||
When user selects a valid city
|City|
|Chennai|
Then user verifies validation for State dropdown
|State|
||
When user selects a valid state
|State|
|Tamilnadu|
When user selects number of persons
|Persons|
|5|
Then user verifies the number of rooms allocated by application
Then user verifies validation for card holder name
|CardHolderName|
||
When user enters a valid card holder name field
|CardHolderName|
|Test|
Then user verifies validation of card number field
|CardNumber|
||
When user verifies a valid card number
|CardNumber|
|8475956352147536|
Then user verifies validation of cvv field
|CVV|
||
When user enters a valid cvv
|CVV|
|129|
Then user validates expiry month field
|ExpiryMonth|
||
When user enters a valid expiry month
|ExpiryMonth|
|05|
Then user validates expiry year field
|ExpiryYear|
||

Scenario: User validates input fields and creates a hotel booking
Given the user is in Hotel booking page
Then user verifies validations for first name field
|FirstName|
||
When user enters a valid first name
|FirstName|
|FName1|
Then user verifies validation for last name field
|LastName|
||
When user enters a valid last name
|LastName|
|LName1|
Then user verifies validation for email field
|Validation|EmailId|
|Empty||
|Invalid|email|
When user enters a valid email id
|EmailId|
|test@test.com|
Then user verifies validation for mobile number field
|Validation|MobileNo|
|Empty||
|Invalid|98574575|
|Invalid|4541247821|
When user enters a valid mobile number
|MobileNo|
|8745621478|
When user enters a valid address
|Address|
|Test address|
Then user verifies validation for city dropdown
|City|
||
When user selects a valid city
|City|
|Chennai|
Then user verifies validation for State dropdown
|State|
||
When user selects a valid state
|State|
|Tamilnadu|
When user selects number of persons
|Persons|
|5|
Then user verifies the number of rooms allocated by application
Then user verifies validation for card holder name
|CardHolderName|
||
When user enters a valid card holder name field
|CardHolderName|
|Test|
Then user verifies validation of card number field
|CardNumber|
||
When user verifies a valid card number
|CardNumber|
|8475956352147536|
Then user verifies validation of cvv field
|CVV|
||
When user enters a valid cvv
|CVV|
|129|
Then user validates expiry month field
|ExpiryMonth|
||
When user enters a valid expiry month
|ExpiryMonth|
|05|
Then user validates expiry year field
|ExpiryYear|
||
When user enters a valid expiry year
|ExpiryYear|
|2025|
When user clicks on confirm booking button
Then user validates success of hotel booking
