Feature: Test add employee funcionality 

	Scenario Outline:
	Check add employee is successful with valid credentials

		Given navegador está abierto
		And user está en login page
		When user ingresa <username> and <password>
		And user clicks en login
		And user choose add employee e ingresa datos basicos
		And user ingresa datos con detalle
		And user busca el empleado recien ingresado
		Then user do logout
		
		Examples:
		|username|password|primerNombre|medioNombre|apellido|switch|username|password1|password2|
		|Admin|admin123|Nadia|Melissa|Castillo|true|castlarainf|Ncastill123!|Ncastill123!|
