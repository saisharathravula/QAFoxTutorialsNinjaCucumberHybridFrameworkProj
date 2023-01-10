Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters valid product "HP" into Search box text field
And User clicks on Search button
Then User should get valid product displaying in search results

Scenario: User searches for an invlaid product
Given User opens the application
When User enters invalid product "Honda" into Search box text field
And User clicks on Search button
Then User should get a message about No product matches

Scenario: User searches without any product
Given User opens the application
When User does not enter any product into Search box text field
And User clicks on Search button
Then User should get a message about No product matches