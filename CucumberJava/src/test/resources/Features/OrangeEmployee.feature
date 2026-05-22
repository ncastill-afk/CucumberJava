Feature: Test add employee funcionality 

	Scenario Outline:
	Check add employee is successful with valid credentials

		Given navegador esta abierto
		And user está en login page
		When user ingresa <username> and <password>
		And user se loguea
		And user choose add employee e ingresa datos basicos
		And user ingresa datos con detalle
		And user busca el empleado recien ingresado
		Then user do logout
		
		Examples:
		|username|password|
		|Admin|admin123|
