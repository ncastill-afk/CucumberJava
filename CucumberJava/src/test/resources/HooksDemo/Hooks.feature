Feature: Check login functionalityy

#Escenario
@smoke
Scenario: 1
Given user is o login page
When user enters valid username and password
And clicks on login button
Then user is navigated to the home page

Scenario: 2
Given user is on login page2
When user enters valid username and password
And clicks on login button
Then user is navigated to the home page2