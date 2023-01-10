Feature: Login functionality

Scenario Outline: Login with valid credentials
Given  User navigates to login page
When User enters valid email address <emailAddress> into the email address text field
And User enters valid password <password> into the password text field
And User clicks on login button
Then User should get successfully logged in
Examples:
|emailAddress						|password	|
|amotooricap1@gmail.com	|12345		|
|amotooricap2@gmail.com	|12345		|
|amotooricap3@gmail.com	|12345		|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into the email address text field
And User enters invalid password "123456789" into the password text field
And User clicks on login button
Then User should get a proper warning message about login credentials mismatch

Scenario: Login with invalid email address and valid password
Given User navigates to login page
When User enters invalid email address into the email address text field
And User enters valid password "12345" into the password text field
And User clicks on login button
Then User should get a proper warning message about login credentials mismatch

Scenario: Login with valid email address and invalid password
Given User navigates to login page
When User enters valid email address "amotooricap9@gmail.com" into the email address text field
And User enters invalid password "1234567822" into the password text field
And User clicks on login button
Then User should get a proper warning message about login credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User does not enter any email address into the email address text field
And User does not enter any password into the password text field
And User clicks on login button
Then User should get a proper warning message about login credentials mismatch
