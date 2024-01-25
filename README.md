# Taller-Spring-Boot
Contiene una dos distintas API con implementación de librería, autenticación básica, por Jwt Token y conexión a base de datos MySQL

# 🛅 Tecnología 
***

Spring Tool Suit 4 - IDE utilizado para la ejecución de esta API

Xampp - Simulador de Base de datos MySQL

# 📋 Pre-requisitos  
***

En el IDE en donde usted realizara las modificaciones que contiene su requerimiento o en el sistema operativo de su equipo. 
Deberá agregar las siguientes variables de entorno para poder ejecutar el microservicio de forma local: 

Configuracion de variables
```
| DATASOURCE_URL 	| jdbc:mysql://localhost:3306/spring?autoReconnect=true&useSSL=false				   	
| DATASOURCE_USER 	| root   														
| DATASOURCE_PWD 	|  															
	
```

# 🚀 Comenzando 
***

Laboratorio-01: API con comunicación a la base de datos MySQL, utiliza la librería de entidad, además de implementar Swagger y autenticación básica en esta.

Laboratorio-3: API centrada en ejemplificar la autenticación por Jwt Token, generando y consumiendo así el token para realizar la autenticación.

Libreria-Entidades: Librería que posee una homologación de la tabla y columnas de la base de datos para ser usada por la API Laboratorio-01.

apachecamel: API ejemplo utilizando Método Get / Post / Put con PathParam, QueryParam y Body respectivamente. 