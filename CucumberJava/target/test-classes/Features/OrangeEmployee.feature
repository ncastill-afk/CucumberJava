#language: es

Característica: Funcionalidad de agregar empleado

	Esquema del escenario: Verificar que se pueda agregar un empleado con credenciales válidas
		Dado que el navegador está abierto
		Y el usuario está en la página de login
		Cuando el usuario ingresa <username> y <password>
		Y el usuario inicia sesión
		Y el usuario selecciona agregar empleado e ingresa los datos básicos
		Y el usuario ingresa los datos detallados
		Y el usuario busca el empleado recién ingresado
		Entonces el usuario cierra sesión
		
		Ejemplos:
		  | username | password  |
		  | Admin    | admin123  |


	Escenario: Verificar que no se pueda iniciar sesión con una contraseña incorrecta
		Dado que el navegador está abierto
		Y el usuario está en la página de login
		Cuando el usuario ingresa <username> y <password>
		Y el usuario intenta iniciar sesión
		Entonces debería mostrarse un mensaje de credenciales inválidas
		Ejemplos:
		  | username | password  |
		  | Admin    | hola  |


