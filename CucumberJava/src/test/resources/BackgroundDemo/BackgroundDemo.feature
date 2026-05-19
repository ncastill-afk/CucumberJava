#Caracteristica: Validar la funcionalidad de pagina de inicio 
Feature: Check home page funcionality

#Fondo
Background: user in logged in
Given user is on login page
When user enters username and password
And click on login button
Then user is navigatedto the home page

#Escenario: Validar el link de desloguearse
Scenario: check logout link

When user clicks on logout link
Then logout text is displayed

#Escenario: Validar el text de cursos aparezca
Scenario: verify label courses text is present

When user clicks on courses link
Then courses text is displayed