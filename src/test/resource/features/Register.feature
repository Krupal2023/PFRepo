Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page 
When User enters details into below fileds

|firstName		|Krupal										|
|lastName			|Sonkusare								|

|telephone		|1234567890								|
|password			|12345										|

And User clicks on privacy policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page 
When User enters details into below fileds

|firstName		|Krupal										|
|lastName			|Sonkusare								|

|telephone		|1234567890								|
|password			|12345										|

And User selects Yes for newsletter
And User clicks on privacy policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account 
Given User navigates to Register Account page 
When User enters details into below fileds with duplicate email

|firstName		|Krupal										|
|lastName			|Sonkusare								|
|email				|krupalgov2014@gmail.com	|
|telephone		|1234567890								|
|password			|12345										|

And User clicks on privacy policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email

Scenario: user creates an account without filling any details 
Given User navigates to Register Account page 
When User dont enter any details into fields
And User clicks on Continue button
Then User should get proper warning massages for every mandatory fields



