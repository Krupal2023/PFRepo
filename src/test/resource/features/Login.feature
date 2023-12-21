Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username								|password			| 
|krupalgov2014@gmail.com|Lakshya@2022	|
|krupalgov2014@gmail.com|Lakshya@2022	|
|krupalgov2014@gmail.com|Lakshya@2022	|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get proper warning massage about credentials missmatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "krupalgov2014@gmail.com" into email field
And  User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get proper warning massage about credentials missmatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "Lakshya@2022" into password field
And User clicks on login button
Then User should get proper warning massage about credentials missmatch

Scenario: Login without providing any credentials 
Given User navigates to login page
When User dont enter email address into email field
And user dont enter password into password field
And User clicks on login button
Then User should get proper warning massage about credentials missmatch

