Feature: Test Agencia de viaje 

	Scenario Outline:
	Se selecciona origen y destino del viaje

		Given navegador está abierto
		And se está en página de viaje
		When se selecciona el <origen> and <destino>
		And se hace click para encontrar el vuelo
		And se carga la pagina de vuelos
		And se carga la reserva <nombre> <dirección> <ciudad> <estado> <codigoZip> <tipoTarjeta> <numeroTarjCred> <mesTarjCred> <añoTarjCred> <nombreTarj>
		Then se carga la confirmación
		
		Examples:
		|origen|destino  | nombre | dirección | ciudad | estado | codigoZip | tipoTarjeta | numeroTarjCred | mesTarjCred | añoTarjCred | nombreTarj |
		|Boston| Rome | NMCL | aqui | Santiago | RM | 123123 | American_Express | 49753413457 | 08 | 2030 | GECL |
		#|student3|Password789|
		#|student|Password123|