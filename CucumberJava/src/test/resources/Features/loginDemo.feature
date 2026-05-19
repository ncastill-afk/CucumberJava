Feature: Test login funcionality 

	Scenario Outline:
	Chek login is successful with valid credentials

		Given browser is open
		And user is o login page
		When user enters <username> and <password>
		And user clicks on login
		Then user is navigated to the home page
		
		Examples:
		|username|password  |
		|student2|Password3456|
		|student3|Password789|
		|student|Password123|