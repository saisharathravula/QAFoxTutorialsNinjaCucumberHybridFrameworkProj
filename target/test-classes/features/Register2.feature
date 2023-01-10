Feature: Register functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the below details into the fields
|firstName		|Arun												|
|lastName			|Motoori										|
|telephone		|1234567890									|
|password			|12345											|
And User selects Privacy Policy check box
And User clicks on Continue button
Then User account should create successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the below details into the fields
|firstName		|Arun												|
|lastName			|Motoori										|
|telephone		|1234567890									|
|password			|12345											|
And User selects Yes for Newsletter
And User selects Privacy Policy check box
And User clicks on Continue button
Then User account should create successfully

Scenario: User creates an account with already existing email address
Given User navigates to Register Account page
When User enters the below details into the fields with duplicate email
|firstName		|Arun												|
|lastName			|Motoori										|
|emailAddress	|amotooricap9@gmail.com	|
|telephone		|1234567890									|
|password			|12345											|
And User selects Yes for Newsletter
And User selects Privacy Policy check box
And User clicks on Continue button
Then User should get a proper warning message about duplicate email address

Scenario: User creates an account without providing any details
Given User navigates to Register Account page
When User does not enter any details into the fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field 